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
/* loaded from: classes9.dex */
public class a {
    private List<f> fWK;
    private HashMap<String, Integer> fWL;
    private LinkedHashMap<String, List<b>> fWM;
    private HashMap<Long, Integer> fWN;
    private HashMap<String, List<b>> fWO;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.isEmpty(dataRes.test_info)) {
                this.fWK = new ArrayList();
                this.fWN = new HashMap<>();
                this.fWO = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.fWK.add(fVar);
                        if (testInfo.recomm_forum != null && !v.isEmpty(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.fWU = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.fWN.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.fWO.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!v.isEmpty(dataRes.recomm_forum)) {
                this.fWL = new HashMap<>();
                this.fWM = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !v.isEmpty(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.fWU = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.fWL.put(recommForum.title, recommForum.page_size);
                        this.fWM.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> Ao(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.fWM != null && this.fWM.size() > 0) {
            arrayList.addAll(this.fWM.get(str));
        }
        return arrayList;
    }

    private List<b> Ap(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.fWO != null && this.fWO.size() > 0) {
            arrayList.addAll(this.fWO.get(str));
        }
        return arrayList;
    }

    public List<m> kJ(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (this.fWL != null && this.fWL.size() > 0) {
            for (String str : this.fWL.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.fWL.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.needTopMargin = !z;
                    dVar.rT(intValue);
                    dVar.bN(Ao(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.byZ());
                }
            }
        }
        return arrayList;
    }

    private List<m> e(long j, boolean z) {
        if (j <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.fWO != null && this.fWO.size() > 0) {
            Iterator<String> it = this.fWO.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.fWN.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.needTopMargin = !z;
                        dVar.rT(intValue);
                        dVar.bN(Ap(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.byZ());
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> dp(long j) {
        int i;
        if (v.isEmpty(this.fWK)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.fWK.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.fWK.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.fWK.get(size - 1));
            arrayList.addAll(this.fWK.subList(0, size - 1));
        } else {
            arrayList.addAll(this.fWK.subList(i - 1, size));
            arrayList.addAll(this.fWK.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> byW() {
        return this.fWK;
    }

    public List<m> f(long j, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (j > 0) {
            List<m> e = e(j, z);
            if (e != null && !v.isEmpty(e)) {
                arrayList.addAll(e);
            }
            List<m> kJ = kJ(z);
            if (kJ != null && !v.isEmpty(kJ)) {
                arrayList.addAll(kJ);
            }
        } else {
            List<m> kJ2 = kJ(z);
            if (kJ2 != null && !v.isEmpty(kJ2)) {
                arrayList.addAll(kJ2);
            }
        }
        e eVar = new e();
        eVar.fXd = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
