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
    private List<f> eZu;
    private HashMap<String, Integer> eZv;
    private LinkedHashMap<String, List<b>> eZw;
    private HashMap<Long, Integer> eZx;
    private HashMap<String, List<b>> eZy;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.aa(dataRes.test_info)) {
                this.eZu = new ArrayList();
                this.eZx = new HashMap<>();
                this.eZy = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.eZu.add(fVar);
                        if (testInfo.recomm_forum != null && !v.aa(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.eZE = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.eZx.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.eZy.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!v.aa(dataRes.recomm_forum)) {
                this.eZv = new HashMap<>();
                this.eZw = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !v.aa(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.eZE = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.eZv.put(recommForum.title, recommForum.page_size);
                        this.eZw.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> vZ(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.eZw != null && this.eZw.size() > 0) {
            arrayList.addAll(this.eZw.get(str));
        }
        return arrayList;
    }

    private List<b> wa(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.eZy != null && this.eZy.size() > 0) {
            arrayList.addAll(this.eZy.get(str));
        }
        return arrayList;
    }

    public List<m> bgx() {
        ArrayList arrayList = new ArrayList();
        if (this.eZv != null && this.eZv.size() > 0) {
            for (String str : this.eZv.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.eZv.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.qE(intValue);
                    dVar.bH(vZ(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.bgB());
                }
            }
        }
        return arrayList;
    }

    private List<m> da(long j) {
        if (j <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.eZy != null && this.eZy.size() > 0) {
            Iterator<String> it = this.eZy.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.eZx.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.qE(intValue);
                        dVar.bH(wa(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.bgB());
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> db(long j) {
        int i;
        if (v.aa(this.eZu)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.eZu.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.eZu.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.eZu.get(size - 1));
            arrayList.addAll(this.eZu.subList(0, size - 1));
        } else {
            arrayList.addAll(this.eZu.subList(i - 1, size));
            arrayList.addAll(this.eZu.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> bgy() {
        return this.eZu;
    }

    public List<m> dc(long j) {
        ArrayList arrayList = new ArrayList();
        if (j > 0) {
            List<m> da = da(j);
            if (da != null && !v.aa(da)) {
                arrayList.addAll(da);
            }
            List<m> bgx = bgx();
            if (bgx != null && !v.aa(bgx)) {
                arrayList.addAll(bgx);
            }
        } else {
            List<m> bgx2 = bgx();
            if (bgx2 != null && !v.aa(bgx2)) {
                arrayList.addAll(bgx2);
            }
        }
        e eVar = new e();
        eVar.eZN = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
