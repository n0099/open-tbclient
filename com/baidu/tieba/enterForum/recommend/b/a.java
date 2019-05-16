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
    private List<f> eUe;
    private HashMap<String, Integer> eUf;
    private LinkedHashMap<String, List<b>> eUg;
    private HashMap<Long, Integer> eUh;
    private HashMap<String, List<b>> eUi;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.aa(dataRes.test_info)) {
                this.eUe = new ArrayList();
                this.eUh = new HashMap<>();
                this.eUi = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.eUe.add(fVar);
                        if (testInfo.recomm_forum != null && !v.aa(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.eUo = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.eUh.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.eUi.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!v.aa(dataRes.recomm_forum)) {
                this.eUf = new HashMap<>();
                this.eUg = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !v.aa(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.eUo = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.eUf.put(recommForum.title, recommForum.page_size);
                        this.eUg.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> vu(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.eUg != null && this.eUg.size() > 0) {
            arrayList.addAll(this.eUg.get(str));
        }
        return arrayList;
    }

    private List<b> vv(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.eUi != null && this.eUi.size() > 0) {
            arrayList.addAll(this.eUi.get(str));
        }
        return arrayList;
    }

    public List<m> beo() {
        ArrayList arrayList = new ArrayList();
        if (this.eUf != null && this.eUf.size() > 0) {
            for (String str : this.eUf.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.eUf.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.qk(intValue);
                    dVar.bF(vu(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.bes());
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
        if (this.eUi != null && this.eUi.size() > 0) {
            Iterator<String> it = this.eUi.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.eUh.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.qk(intValue);
                        dVar.bF(vv(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.bes());
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> cU(long j) {
        int i;
        if (v.aa(this.eUe)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.eUe.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.eUe.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.eUe.get(size - 1));
            arrayList.addAll(this.eUe.subList(0, size - 1));
        } else {
            arrayList.addAll(this.eUe.subList(i - 1, size));
            arrayList.addAll(this.eUe.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> bep() {
        return this.eUe;
    }

    public List<m> cV(long j) {
        ArrayList arrayList = new ArrayList();
        if (j > 0) {
            List<m> cT = cT(j);
            if (cT != null && !v.aa(cT)) {
                arrayList.addAll(cT);
            }
            List<m> beo = beo();
            if (beo != null && !v.aa(beo)) {
                arrayList.addAll(beo);
            }
        } else {
            List<m> beo2 = beo();
            if (beo2 != null && !v.aa(beo2)) {
                arrayList.addAll(beo2);
            }
        }
        e eVar = new e();
        eVar.eUx = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
