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
    private List<f> gEj;
    private HashMap<String, Integer> gEk;
    private LinkedHashMap<String, List<b>> gEl;
    private HashMap<Long, Integer> gEm;
    private HashMap<String, List<b>> gEn;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.isEmpty(dataRes.test_info)) {
                this.gEj = new ArrayList();
                this.gEm = new HashMap<>();
                this.gEn = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.gEj.add(fVar);
                        if (testInfo.recomm_forum != null && !v.isEmpty(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.gEt = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.gEm.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.gEn.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!v.isEmpty(dataRes.recomm_forum)) {
                this.gEk = new HashMap<>();
                this.gEl = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !v.isEmpty(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.gEt = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.gEk.put(recommForum.title, recommForum.page_size);
                        this.gEl.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> Cb(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.gEl != null && this.gEl.size() > 0) {
            arrayList.addAll(this.gEl.get(str));
        }
        return arrayList;
    }

    private List<b> Cc(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.gEn != null && this.gEn.size() > 0) {
            arrayList.addAll(this.gEn.get(str));
        }
        return arrayList;
    }

    public List<m> lR(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (this.gEk != null && this.gEk.size() > 0) {
            for (String str : this.gEk.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.gEk.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.needTopMargin = !z;
                    dVar.sq(intValue);
                    dVar.bZ(Cb(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.bJi());
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
        if (this.gEn != null && this.gEn.size() > 0) {
            Iterator<String> it = this.gEn.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.gEm.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.needTopMargin = !z;
                        dVar.sq(intValue);
                        dVar.bZ(Cc(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.bJi());
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> dY(long j) {
        int i;
        if (v.isEmpty(this.gEj)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.gEj.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.gEj.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.gEj.get(size - 1));
            arrayList.addAll(this.gEj.subList(0, size - 1));
        } else {
            arrayList.addAll(this.gEj.subList(i - 1, size));
            arrayList.addAll(this.gEj.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> bJf() {
        return this.gEj;
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
        eVar.gEC = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
