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
/* loaded from: classes21.dex */
public class a {
    private List<f> hFA;
    private HashMap<String, Integer> hFB;
    private LinkedHashMap<String, List<b>> hFC;
    private HashMap<Long, Integer> hFD;
    private HashMap<String, List<b>> hFE;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!y.isEmpty(dataRes.test_info)) {
                this.hFA = new ArrayList();
                this.hFD = new HashMap<>();
                this.hFE = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.hFA.add(fVar);
                        if (testInfo.recomm_forum != null && !y.isEmpty(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.hFK = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.hFD.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.hFE.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!y.isEmpty(dataRes.recomm_forum)) {
                this.hFB = new HashMap<>();
                this.hFC = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !y.isEmpty(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.hFK = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.hFB.put(recommForum.title, recommForum.page_size);
                        this.hFC.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> HW(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.hFC != null && this.hFC.size() > 0) {
            arrayList.addAll(this.hFC.get(str));
        }
        return arrayList;
    }

    private List<b> HX(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.hFE != null && this.hFE.size() > 0) {
            arrayList.addAll(this.hFE.get(str));
        }
        return arrayList;
    }

    public List<q> nO(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (this.hFB != null && this.hFB.size() > 0) {
            for (String str : this.hFB.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.hFB.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.needTopMargin = !z;
                    dVar.wE(intValue);
                    dVar.cs(HW(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.cjC());
                }
            }
        }
        return arrayList;
    }

    private List<q> h(long j, boolean z) {
        if (j <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.hFE != null && this.hFE.size() > 0) {
            Iterator<String> it = this.hFE.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.hFD.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.needTopMargin = !z;
                        dVar.wE(intValue);
                        dVar.cs(HX(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.cjC());
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> eK(long j) {
        int i;
        if (y.isEmpty(this.hFA)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.hFA.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.hFA.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.hFA.get(size - 1));
            arrayList.addAll(this.hFA.subList(0, size - 1));
        } else {
            arrayList.addAll(this.hFA.subList(i - 1, size));
            arrayList.addAll(this.hFA.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> cjz() {
        return this.hFA;
    }

    public List<q> i(long j, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (j > 0) {
            List<q> h = h(j, z);
            if (h != null && !y.isEmpty(h)) {
                arrayList.addAll(h);
            }
            List<q> nO = nO(z);
            if (nO != null && !y.isEmpty(nO)) {
                arrayList.addAll(nO);
            }
        } else {
            List<q> nO2 = nO(z);
            if (nO2 != null && !y.isEmpty(nO2)) {
                arrayList.addAll(nO2);
            }
        }
        e eVar = new e();
        eVar.hFT = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
