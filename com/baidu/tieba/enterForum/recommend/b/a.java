package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import tbclient.RecommendForumInfo;
import tbclient.Recommforum.DataRes;
import tbclient.Recommforum.RecommForum;
import tbclient.Recommforum.TestInfo;
/* loaded from: classes9.dex */
public class a {
    private List<f> hfR;
    private HashMap<String, Integer> hfS;
    private LinkedHashMap<String, List<b>> hfT;
    private HashMap<Long, Integer> hfU;
    private HashMap<String, List<b>> hfV;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!w.isEmpty(dataRes.test_info)) {
                this.hfR = new ArrayList();
                this.hfU = new HashMap<>();
                this.hfV = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.hfR.add(fVar);
                        if (testInfo.recomm_forum != null && !w.isEmpty(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.hgb = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.hfU.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.hfV.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!w.isEmpty(dataRes.recomm_forum)) {
                this.hfS = new HashMap<>();
                this.hfT = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !w.isEmpty(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.hgb = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.hfS.put(recommForum.title, recommForum.page_size);
                        this.hfT.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> Eo(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.hfT != null && this.hfT.size() > 0) {
            arrayList.addAll(this.hfT.get(str));
        }
        return arrayList;
    }

    private List<b> Ep(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.hfV != null && this.hfV.size() > 0) {
            arrayList.addAll(this.hfV.get(str));
        }
        return arrayList;
    }

    public List<q> mx(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (this.hfS != null && this.hfS.size() > 0) {
            for (String str : this.hfS.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.hfS.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.needTopMargin = !z;
                    dVar.ty(intValue);
                    dVar.cf(Eo(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.bSF());
                }
            }
        }
        return arrayList;
    }

    private List<q> g(long j, boolean z) {
        if (j <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.hfV != null && this.hfV.size() > 0) {
            Iterator<String> it = this.hfV.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.hfU.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.needTopMargin = !z;
                        dVar.ty(intValue);
                        dVar.cf(Ep(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.bSF());
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> ec(long j) {
        int i;
        if (w.isEmpty(this.hfR)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.hfR.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.hfR.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.hfR.get(size - 1));
            arrayList.addAll(this.hfR.subList(0, size - 1));
        } else {
            arrayList.addAll(this.hfR.subList(i - 1, size));
            arrayList.addAll(this.hfR.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> bSC() {
        return this.hfR;
    }

    public List<q> h(long j, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (j > 0) {
            List<q> g = g(j, z);
            if (g != null && !w.isEmpty(g)) {
                arrayList.addAll(g);
            }
            List<q> mx = mx(z);
            if (mx != null && !w.isEmpty(mx)) {
                arrayList.addAll(mx);
            }
        } else {
            List<q> mx2 = mx(z);
            if (mx2 != null && !w.isEmpty(mx2)) {
                arrayList.addAll(mx2);
            }
        }
        e eVar = new e();
        eVar.hgk = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
