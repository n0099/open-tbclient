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
    private List<f> iyA;
    private HashMap<String, Integer> iyB;
    private LinkedHashMap<String, List<b>> iyC;
    private HashMap<Long, Integer> iyD;
    private HashMap<String, List<b>> iyE;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!y.isEmpty(dataRes.test_info)) {
                this.iyA = new ArrayList();
                this.iyD = new HashMap<>();
                this.iyE = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.iyA.add(fVar);
                        if (testInfo.recomm_forum != null && !y.isEmpty(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.iyK = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.iyD.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.iyE.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!y.isEmpty(dataRes.recomm_forum)) {
                this.iyB = new HashMap<>();
                this.iyC = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !y.isEmpty(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.iyK = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.iyB.put(recommForum.title, recommForum.page_size);
                        this.iyC.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> JQ(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.iyC != null && this.iyC.size() > 0) {
            arrayList.addAll(this.iyC.get(str));
        }
        return arrayList;
    }

    private List<b> JR(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.iyE != null && this.iyE.size() > 0) {
            arrayList.addAll(this.iyE.get(str));
        }
        return arrayList;
    }

    public List<q> pt(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (this.iyB != null && this.iyB.size() > 0) {
            for (String str : this.iyB.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.iyB.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.needTopMargin = !z;
                    dVar.yT(intValue);
                    dVar.cQ(JQ(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.cwy());
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
        if (this.iyE != null && this.iyE.size() > 0) {
            Iterator<String> it = this.iyE.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.iyD.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.needTopMargin = !z;
                        dVar.yT(intValue);
                        dVar.cQ(JR(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.cwy());
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> gf(long j) {
        int i;
        if (y.isEmpty(this.iyA)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.iyA.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.iyA.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.iyA.get(size - 1));
            arrayList.addAll(this.iyA.subList(0, size - 1));
        } else {
            arrayList.addAll(this.iyA.subList(i - 1, size));
            arrayList.addAll(this.iyA.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> cwv() {
        return this.iyA;
    }

    public List<q> j(long j, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (j > 0) {
            List<q> i = i(j, z);
            if (i != null && !y.isEmpty(i)) {
                arrayList.addAll(i);
            }
            List<q> pt = pt(z);
            if (pt != null && !y.isEmpty(pt)) {
                arrayList.addAll(pt);
            }
        } else {
            List<q> pt2 = pt(z);
            if (pt2 != null && !y.isEmpty(pt2)) {
                arrayList.addAll(pt2);
            }
        }
        e eVar = new e();
        eVar.iyT = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
