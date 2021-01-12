package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
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
/* loaded from: classes2.dex */
public class a {
    private List<f> iGi;
    private HashMap<String, Integer> iGj;
    private LinkedHashMap<String, List<b>> iGk;
    private HashMap<Long, Integer> iGl;
    private HashMap<String, List<b>> iGm;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!x.isEmpty(dataRes.test_info)) {
                this.iGi = new ArrayList();
                this.iGl = new HashMap<>();
                this.iGm = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.iGi.add(fVar);
                        if (testInfo.recomm_forum != null && !x.isEmpty(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.iGs = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.iGl.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.iGm.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!x.isEmpty(dataRes.recomm_forum)) {
                this.iGj = new HashMap<>();
                this.iGk = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !x.isEmpty(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.iGs = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.iGj.put(recommForum.title, recommForum.page_size);
                        this.iGk.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> IC(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.iGk != null && this.iGk.size() > 0) {
            arrayList.addAll(this.iGk.get(str));
        }
        return arrayList;
    }

    private List<b> ID(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.iGm != null && this.iGm.size() > 0) {
            arrayList.addAll(this.iGm.get(str));
        }
        return arrayList;
    }

    public List<n> pM(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (this.iGj != null && this.iGj.size() > 0) {
            for (String str : this.iGj.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.iGj.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.needTopMargin = !z;
                    dVar.xA(intValue);
                    dVar.cX(IC(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.cvB());
                }
            }
        }
        return arrayList;
    }

    private List<n> k(long j, boolean z) {
        if (j <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.iGm != null && this.iGm.size() > 0) {
            Iterator<String> it = this.iGm.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.iGl.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.needTopMargin = !z;
                        dVar.xA(intValue);
                        dVar.cX(ID(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.cvB());
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> gf(long j) {
        int i;
        if (x.isEmpty(this.iGi)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.iGi.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.iGi.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.iGi.get(size - 1));
            arrayList.addAll(this.iGi.subList(0, size - 1));
        } else {
            arrayList.addAll(this.iGi.subList(i - 1, size));
            arrayList.addAll(this.iGi.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> cvy() {
        return this.iGi;
    }

    public List<n> l(long j, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (j > 0) {
            List<n> k = k(j, z);
            if (k != null && !x.isEmpty(k)) {
                arrayList.addAll(k);
            }
            List<n> pM = pM(z);
            if (pM != null && !x.isEmpty(pM)) {
                arrayList.addAll(pM);
            }
        } else {
            List<n> pM2 = pM(z);
            if (pM2 != null && !x.isEmpty(pM2)) {
                arrayList.addAll(pM2);
            }
        }
        e eVar = new e();
        eVar.iGB = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
