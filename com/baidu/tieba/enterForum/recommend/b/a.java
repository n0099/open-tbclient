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
    private List<f> fXF;
    private HashMap<String, Integer> fXG;
    private LinkedHashMap<String, List<b>> fXH;
    private HashMap<Long, Integer> fXI;
    private HashMap<String, List<b>> fXJ;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.isEmpty(dataRes.test_info)) {
                this.fXF = new ArrayList();
                this.fXI = new HashMap<>();
                this.fXJ = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.fXF.add(fVar);
                        if (testInfo.recomm_forum != null && !v.isEmpty(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.fXP = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.fXI.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.fXJ.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!v.isEmpty(dataRes.recomm_forum)) {
                this.fXG = new HashMap<>();
                this.fXH = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !v.isEmpty(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.fXP = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.fXG.put(recommForum.title, recommForum.page_size);
                        this.fXH.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> Aq(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.fXH != null && this.fXH.size() > 0) {
            arrayList.addAll(this.fXH.get(str));
        }
        return arrayList;
    }

    private List<b> Ar(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.fXJ != null && this.fXJ.size() > 0) {
            arrayList.addAll(this.fXJ.get(str));
        }
        return arrayList;
    }

    public List<m> kO(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (this.fXG != null && this.fXG.size() > 0) {
            for (String str : this.fXG.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.fXG.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.needTopMargin = !z;
                    dVar.rV(intValue);
                    dVar.bN(Aq(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.bzg());
                }
            }
        }
        return arrayList;
    }

    private List<m> f(long j, boolean z) {
        if (j <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.fXJ != null && this.fXJ.size() > 0) {
            Iterator<String> it = this.fXJ.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.fXI.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.needTopMargin = !z;
                        dVar.rV(intValue);
                        dVar.bN(Ar(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.bzg());
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> dp(long j) {
        int i;
        if (v.isEmpty(this.fXF)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.fXF.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.fXF.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.fXF.get(size - 1));
            arrayList.addAll(this.fXF.subList(0, size - 1));
        } else {
            arrayList.addAll(this.fXF.subList(i - 1, size));
            arrayList.addAll(this.fXF.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> bzd() {
        return this.fXF;
    }

    public List<m> g(long j, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (j > 0) {
            List<m> f = f(j, z);
            if (f != null && !v.isEmpty(f)) {
                arrayList.addAll(f);
            }
            List<m> kO = kO(z);
            if (kO != null && !v.isEmpty(kO)) {
                arrayList.addAll(kO);
            }
        } else {
            List<m> kO2 = kO(z);
            if (kO2 != null && !v.isEmpty(kO2)) {
                arrayList.addAll(kO2);
            }
        }
        e eVar = new e();
        eVar.fXY = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
