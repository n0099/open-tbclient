package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import tbclient.RecommendForumInfo;
import tbclient.Recommforum.DataRes;
import tbclient.Recommforum.RecommForum;
import tbclient.Recommforum.TestInfo;
/* loaded from: classes22.dex */
public class a {
    private List<f> imT;
    private HashMap<String, Integer> imU;
    private LinkedHashMap<String, List<b>> imV;
    private HashMap<Long, Integer> imW;
    private HashMap<String, List<b>> imX;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!y.isEmpty(dataRes.test_info)) {
                this.imT = new ArrayList();
                this.imW = new HashMap<>();
                this.imX = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.imT.add(fVar);
                        if (testInfo.recomm_forum != null && !y.isEmpty(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.ind = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.imW.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.imX.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!y.isEmpty(dataRes.recomm_forum)) {
                this.imU = new HashMap<>();
                this.imV = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !y.isEmpty(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.ind = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.imU.put(recommForum.title, recommForum.page_size);
                        this.imV.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> Jz(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.imV != null && this.imV.size() > 0) {
            arrayList.addAll(this.imV.get(str));
        }
        return arrayList;
    }

    private List<b> JA(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.imX != null && this.imX.size() > 0) {
            arrayList.addAll(this.imX.get(str));
        }
        return arrayList;
    }

    public List<q> oU(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (this.imU != null && this.imU.size() > 0) {
            for (String str : this.imU.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.imU.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.needTopMargin = !z;
                    dVar.xQ(intValue);
                    dVar.cM(Jz(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.csG());
                }
            }
        }
        return arrayList;
    }

    private List<q> i(long j, boolean z) {
        if (j <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.imX != null && this.imX.size() > 0) {
            Iterator<String> it = this.imX.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.imW.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.needTopMargin = !z;
                        dVar.xQ(intValue);
                        dVar.cM(JA(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.csG());
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> fy(long j) {
        int i;
        if (y.isEmpty(this.imT)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.imT.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.imT.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.imT.get(size - 1));
            arrayList.addAll(this.imT.subList(0, size - 1));
        } else {
            arrayList.addAll(this.imT.subList(i - 1, size));
            arrayList.addAll(this.imT.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> csD() {
        return this.imT;
    }

    public List<q> j(long j, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (j > 0) {
            List<q> i = i(j, z);
            if (i != null && !y.isEmpty(i)) {
                arrayList.addAll(i);
            }
            List<q> oU = oU(z);
            if (oU != null && !y.isEmpty(oU)) {
                arrayList.addAll(oU);
            }
        } else {
            List<q> oU2 = oU(z);
            if (oU2 != null && !y.isEmpty(oU2)) {
                arrayList.addAll(oU2);
            }
        }
        e eVar = new e();
        eVar.inm = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
