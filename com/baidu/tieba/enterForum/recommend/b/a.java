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
    private List<f> gEp;
    private HashMap<String, Integer> gEq;
    private LinkedHashMap<String, List<b>> gEr;
    private HashMap<Long, Integer> gEs;
    private HashMap<String, List<b>> gEt;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.isEmpty(dataRes.test_info)) {
                this.gEp = new ArrayList();
                this.gEs = new HashMap<>();
                this.gEt = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.gEp.add(fVar);
                        if (testInfo.recomm_forum != null && !v.isEmpty(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.gEz = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.gEs.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.gEt.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!v.isEmpty(dataRes.recomm_forum)) {
                this.gEq = new HashMap<>();
                this.gEr = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !v.isEmpty(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.gEz = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.gEq.put(recommForum.title, recommForum.page_size);
                        this.gEr.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> Ce(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.gEr != null && this.gEr.size() > 0) {
            arrayList.addAll(this.gEr.get(str));
        }
        return arrayList;
    }

    private List<b> Cf(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.gEt != null && this.gEt.size() > 0) {
            arrayList.addAll(this.gEt.get(str));
        }
        return arrayList;
    }

    public List<m> lR(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (this.gEq != null && this.gEq.size() > 0) {
            for (String str : this.gEq.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.gEq.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.needTopMargin = !z;
                    dVar.sq(intValue);
                    dVar.bZ(Ce(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.bJg());
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
        if (this.gEt != null && this.gEt.size() > 0) {
            Iterator<String> it = this.gEt.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.gEs.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.needTopMargin = !z;
                        dVar.sq(intValue);
                        dVar.bZ(Cf(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.bJg());
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> dY(long j) {
        int i;
        if (v.isEmpty(this.gEp)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.gEp.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.gEp.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.gEp.get(size - 1));
            arrayList.addAll(this.gEp.subList(0, size - 1));
        } else {
            arrayList.addAll(this.gEp.subList(i - 1, size));
            arrayList.addAll(this.gEp.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> bJd() {
        return this.gEp;
    }

    public List<m> g(long j, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (j > 0) {
            List<m> f = f(j, z);
            if (f != null && !v.isEmpty(f)) {
                arrayList.addAll(f);
            }
            List<m> lR = lR(z);
            if (lR != null && !v.isEmpty(lR)) {
                arrayList.addAll(lR);
            }
        } else {
            List<m> lR2 = lR(z);
            if (lR2 != null && !v.isEmpty(lR2)) {
                arrayList.addAll(lR2);
            }
        }
        e eVar = new e();
        eVar.gEI = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
