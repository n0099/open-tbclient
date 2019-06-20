package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import tbclient.RecommendForumInfo;
import tbclient.Recommforum.DataRes;
import tbclient.Recommforum.RecommForum;
import tbclient.Recommforum.TestInfo;
/* loaded from: classes4.dex */
public class a {
    private List<f> eUf;
    private HashMap<String, Integer> eUg;
    private LinkedHashMap<String, List<b>> eUh;
    private HashMap<Long, Integer> eUi;
    private HashMap<String, List<b>> eUj;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.aa(dataRes.test_info)) {
                this.eUf = new ArrayList();
                this.eUi = new HashMap<>();
                this.eUj = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.eUf.add(fVar);
                        if (testInfo.recomm_forum != null && !v.aa(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.eUp = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.eUi.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.eUj.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!v.aa(dataRes.recomm_forum)) {
                this.eUg = new HashMap<>();
                this.eUh = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !v.aa(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.eUp = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.eUg.put(recommForum.title, recommForum.page_size);
                        this.eUh.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> vt(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.eUh != null && this.eUh.size() > 0) {
            arrayList.addAll(this.eUh.get(str));
        }
        return arrayList;
    }

    private List<b> vu(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.eUj != null && this.eUj.size() > 0) {
            arrayList.addAll(this.eUj.get(str));
        }
        return arrayList;
    }

    public List<m> ber() {
        ArrayList arrayList = new ArrayList();
        if (this.eUg != null && this.eUg.size() > 0) {
            for (String str : this.eUg.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.eUg.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.qk(intValue);
                    dVar.bF(vt(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.bev());
                }
            }
        }
        return arrayList;
    }

    private List<m> cT(long j) {
        if (j <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.eUj != null && this.eUj.size() > 0) {
            Iterator<String> it = this.eUj.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.eUi.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.qk(intValue);
                        dVar.bF(vu(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.bev());
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> cU(long j) {
        int i;
        if (v.aa(this.eUf)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.eUf.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.eUf.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.eUf.get(size - 1));
            arrayList.addAll(this.eUf.subList(0, size - 1));
        } else {
            arrayList.addAll(this.eUf.subList(i - 1, size));
            arrayList.addAll(this.eUf.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> bes() {
        return this.eUf;
    }

    public List<m> cV(long j) {
        ArrayList arrayList = new ArrayList();
        if (j > 0) {
            List<m> cT = cT(j);
            if (cT != null && !v.aa(cT)) {
                arrayList.addAll(cT);
            }
            List<m> ber = ber();
            if (ber != null && !v.aa(ber)) {
                arrayList.addAll(ber);
            }
        } else {
            List<m> ber2 = ber();
            if (ber2 != null && !v.aa(ber2)) {
                arrayList.addAll(ber2);
            }
        }
        e eVar = new e();
        eVar.eUy = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
