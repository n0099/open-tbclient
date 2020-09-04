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
/* loaded from: classes16.dex */
public class a {
    private LinkedHashMap<String, List<b>> hyA;
    private HashMap<Long, Integer> hyB;
    private HashMap<String, List<b>> hyC;
    private List<f> hyy;
    private HashMap<String, Integer> hyz;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!y.isEmpty(dataRes.test_info)) {
                this.hyy = new ArrayList();
                this.hyB = new HashMap<>();
                this.hyC = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.hyy.add(fVar);
                        if (testInfo.recomm_forum != null && !y.isEmpty(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.hyI = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.hyB.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.hyC.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!y.isEmpty(dataRes.recomm_forum)) {
                this.hyz = new HashMap<>();
                this.hyA = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !y.isEmpty(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.hyI = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.hyz.put(recommForum.title, recommForum.page_size);
                        this.hyA.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> Hz(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.hyA != null && this.hyA.size() > 0) {
            arrayList.addAll(this.hyA.get(str));
        }
        return arrayList;
    }

    private List<b> HA(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.hyC != null && this.hyC.size() > 0) {
            arrayList.addAll(this.hyC.get(str));
        }
        return arrayList;
    }

    public List<q> nI(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (this.hyz != null && this.hyz.size() > 0) {
            for (String str : this.hyz.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.hyz.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.needTopMargin = !z;
                    dVar.wf(intValue);
                    dVar.cm(Hz(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.cgl());
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
        if (this.hyC != null && this.hyC.size() > 0) {
            Iterator<String> it = this.hyC.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.hyB.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.needTopMargin = !z;
                        dVar.wf(intValue);
                        dVar.cm(HA(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.cgl());
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> eA(long j) {
        int i;
        if (y.isEmpty(this.hyy)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.hyy.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.hyy.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.hyy.get(size - 1));
            arrayList.addAll(this.hyy.subList(0, size - 1));
        } else {
            arrayList.addAll(this.hyy.subList(i - 1, size));
            arrayList.addAll(this.hyy.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> cgi() {
        return this.hyy;
    }

    public List<q> h(long j, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (j > 0) {
            List<q> g = g(j, z);
            if (g != null && !y.isEmpty(g)) {
                arrayList.addAll(g);
            }
            List<q> nI = nI(z);
            if (nI != null && !y.isEmpty(nI)) {
                arrayList.addAll(nI);
            }
        } else {
            List<q> nI2 = nI(z);
            if (nI2 != null && !y.isEmpty(nI2)) {
                arrayList.addAll(nI2);
            }
        }
        e eVar = new e();
        eVar.hyR = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
