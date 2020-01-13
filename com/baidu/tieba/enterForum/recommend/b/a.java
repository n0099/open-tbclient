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
/* loaded from: classes7.dex */
public class a {
    private List<f> fUH;
    private HashMap<String, Integer> fUI;
    private LinkedHashMap<String, List<b>> fUJ;
    private HashMap<Long, Integer> fUK;
    private HashMap<String, List<b>> fUL;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.isEmpty(dataRes.test_info)) {
                this.fUH = new ArrayList();
                this.fUK = new HashMap<>();
                this.fUL = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.fUH.add(fVar);
                        if (testInfo.recomm_forum != null && !v.isEmpty(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.fUR = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.fUK.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.fUL.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!v.isEmpty(dataRes.recomm_forum)) {
                this.fUI = new HashMap<>();
                this.fUJ = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !v.isEmpty(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.fUR = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.fUI.put(recommForum.title, recommForum.page_size);
                        this.fUJ.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> zY(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.fUJ != null && this.fUJ.size() > 0) {
            arrayList.addAll(this.fUJ.get(str));
        }
        return arrayList;
    }

    private List<b> zZ(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.fUL != null && this.fUL.size() > 0) {
            arrayList.addAll(this.fUL.get(str));
        }
        return arrayList;
    }

    public List<m> bxr() {
        ArrayList arrayList = new ArrayList();
        if (this.fUI != null && this.fUI.size() > 0) {
            for (String str : this.fUI.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.fUI.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.rN(intValue);
                    dVar.bQ(zY(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.bxv());
                }
            }
        }
        return arrayList;
    }

    private List<m> dn(long j) {
        if (j <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.fUL != null && this.fUL.size() > 0) {
            Iterator<String> it = this.fUL.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.fUK.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.rN(intValue);
                        dVar.bQ(zZ(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.bxv());
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: do  reason: not valid java name */
    public List<f> m28do(long j) {
        int i;
        if (v.isEmpty(this.fUH)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.fUH.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.fUH.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.fUH.get(size - 1));
            arrayList.addAll(this.fUH.subList(0, size - 1));
        } else {
            arrayList.addAll(this.fUH.subList(i - 1, size));
            arrayList.addAll(this.fUH.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> bxs() {
        return this.fUH;
    }

    public List<m> dp(long j) {
        ArrayList arrayList = new ArrayList();
        if (j > 0) {
            List<m> dn = dn(j);
            if (dn != null && !v.isEmpty(dn)) {
                arrayList.addAll(dn);
            }
            List<m> bxr = bxr();
            if (bxr != null && !v.isEmpty(bxr)) {
                arrayList.addAll(bxr);
            }
        } else {
            List<m> bxr2 = bxr();
            if (bxr2 != null && !v.isEmpty(bxr2)) {
                arrayList.addAll(bxr2);
            }
        }
        e eVar = new e();
        eVar.fVa = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
