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
    private List<f> fcU;
    private HashMap<String, Integer> fcV;
    private LinkedHashMap<String, List<b>> fcW;
    private HashMap<Long, Integer> fcX;
    private HashMap<String, List<b>> fcY;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.isEmpty(dataRes.test_info)) {
                this.fcU = new ArrayList();
                this.fcX = new HashMap<>();
                this.fcY = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.fcU.add(fVar);
                        if (testInfo.recomm_forum != null && !v.isEmpty(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.fde = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.fcX.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.fcY.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!v.isEmpty(dataRes.recomm_forum)) {
                this.fcV = new HashMap<>();
                this.fcW = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !v.isEmpty(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.fde = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.fcV.put(recommForum.title, recommForum.page_size);
                        this.fcW.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> uW(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.fcW != null && this.fcW.size() > 0) {
            arrayList.addAll(this.fcW.get(str));
        }
        return arrayList;
    }

    private List<b> uX(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.fcY != null && this.fcY.size() > 0) {
            arrayList.addAll(this.fcY.get(str));
        }
        return arrayList;
    }

    public List<m> beV() {
        ArrayList arrayList = new ArrayList();
        if (this.fcV != null && this.fcV.size() > 0) {
            for (String str : this.fcV.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.fcV.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.pC(intValue);
                    dVar.bU(uW(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.beZ());
                }
            }
        }
        return arrayList;
    }

    private List<m> cC(long j) {
        if (j <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.fcY != null && this.fcY.size() > 0) {
            Iterator<String> it = this.fcY.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.fcX.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.pC(intValue);
                        dVar.bU(uX(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.beZ());
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> cD(long j) {
        int i;
        if (v.isEmpty(this.fcU)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.fcU.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.fcU.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.fcU.get(size - 1));
            arrayList.addAll(this.fcU.subList(0, size - 1));
        } else {
            arrayList.addAll(this.fcU.subList(i - 1, size));
            arrayList.addAll(this.fcU.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> beW() {
        return this.fcU;
    }

    public List<m> cE(long j) {
        ArrayList arrayList = new ArrayList();
        if (j > 0) {
            List<m> cC = cC(j);
            if (cC != null && !v.isEmpty(cC)) {
                arrayList.addAll(cC);
            }
            List<m> beV = beV();
            if (beV != null && !v.isEmpty(beV)) {
                arrayList.addAll(beV);
            }
        } else {
            List<m> beV2 = beV();
            if (beV2 != null && !v.isEmpty(beV2)) {
                arrayList.addAll(beV2);
            }
        }
        e eVar = new e();
        eVar.fdn = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
