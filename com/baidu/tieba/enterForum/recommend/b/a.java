package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import tbclient.RecommendForumInfo;
import tbclient.Recommforum.DataRes;
import tbclient.Recommforum.RecommForum;
import tbclient.Recommforum.TestInfo;
/* loaded from: classes16.dex */
public class a {
    private List<f> hlB;
    private HashMap<String, Integer> hlC;
    private LinkedHashMap<String, List<b>> hlD;
    private HashMap<Long, Integer> hlE;
    private HashMap<String, List<b>> hlF;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!x.isEmpty(dataRes.test_info)) {
                this.hlB = new ArrayList();
                this.hlE = new HashMap<>();
                this.hlF = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.hlB.add(fVar);
                        if (testInfo.recomm_forum != null && !x.isEmpty(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.hlL = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.hlE.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.hlF.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!x.isEmpty(dataRes.recomm_forum)) {
                this.hlC = new HashMap<>();
                this.hlD = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !x.isEmpty(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.hlL = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.hlC.put(recommForum.title, recommForum.page_size);
                        this.hlD.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> EZ(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.hlD != null && this.hlD.size() > 0) {
            arrayList.addAll(this.hlD.get(str));
        }
        return arrayList;
    }

    private List<b> Fa(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.hlF != null && this.hlF.size() > 0) {
            arrayList.addAll(this.hlF.get(str));
        }
        return arrayList;
    }

    public List<q> nc(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (this.hlC != null && this.hlC.size() > 0) {
            for (String str : this.hlC.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.hlC.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.needTopMargin = !z;
                    dVar.tQ(intValue);
                    dVar.ck(EZ(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.bVX());
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
        if (this.hlF != null && this.hlF.size() > 0) {
            Iterator<String> it = this.hlF.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.hlE.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.needTopMargin = !z;
                        dVar.tQ(intValue);
                        dVar.ck(Fa(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.bVX());
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> ep(long j) {
        int i;
        if (x.isEmpty(this.hlB)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.hlB.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.hlB.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.hlB.get(size - 1));
            arrayList.addAll(this.hlB.subList(0, size - 1));
        } else {
            arrayList.addAll(this.hlB.subList(i - 1, size));
            arrayList.addAll(this.hlB.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> bVU() {
        return this.hlB;
    }

    public List<q> h(long j, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (j > 0) {
            List<q> g = g(j, z);
            if (g != null && !x.isEmpty(g)) {
                arrayList.addAll(g);
            }
            List<q> nc = nc(z);
            if (nc != null && !x.isEmpty(nc)) {
                arrayList.addAll(nc);
            }
        } else {
            List<q> nc2 = nc(z);
            if (nc2 != null && !x.isEmpty(nc2)) {
                arrayList.addAll(nc2);
            }
        }
        e eVar = new e();
        eVar.hlU = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
