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
    private List<f> iKP;
    private HashMap<String, Integer> iKQ;
    private LinkedHashMap<String, List<b>> iKR;
    private HashMap<Long, Integer> iKS;
    private HashMap<String, List<b>> iKT;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!x.isEmpty(dataRes.test_info)) {
                this.iKP = new ArrayList();
                this.iKS = new HashMap<>();
                this.iKT = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.iKP.add(fVar);
                        if (testInfo.recomm_forum != null && !x.isEmpty(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.iKZ = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.iKS.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.iKT.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!x.isEmpty(dataRes.recomm_forum)) {
                this.iKQ = new HashMap<>();
                this.iKR = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !x.isEmpty(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.iKZ = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.iKQ.put(recommForum.title, recommForum.page_size);
                        this.iKR.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> JN(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.iKR != null && this.iKR.size() > 0) {
            arrayList.addAll(this.iKR.get(str));
        }
        return arrayList;
    }

    private List<b> JO(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.iKT != null && this.iKT.size() > 0) {
            arrayList.addAll(this.iKT.get(str));
        }
        return arrayList;
    }

    public List<n> pQ(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (this.iKQ != null && this.iKQ.size() > 0) {
            for (String str : this.iKQ.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.iKQ.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.needTopMargin = !z;
                    dVar.zg(intValue);
                    dVar.cX(JN(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.czt());
                }
            }
        }
        return arrayList;
    }

    private List<n> j(long j, boolean z) {
        if (j <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.iKT != null && this.iKT.size() > 0) {
            Iterator<String> it = this.iKT.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.iKS.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.needTopMargin = !z;
                        dVar.zg(intValue);
                        dVar.cX(JO(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.czt());
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> gf(long j) {
        int i;
        if (x.isEmpty(this.iKP)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.iKP.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.iKP.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.iKP.get(size - 1));
            arrayList.addAll(this.iKP.subList(0, size - 1));
        } else {
            arrayList.addAll(this.iKP.subList(i - 1, size));
            arrayList.addAll(this.iKP.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> czq() {
        return this.iKP;
    }

    public List<n> k(long j, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (j > 0) {
            List<n> j2 = j(j, z);
            if (j2 != null && !x.isEmpty(j2)) {
                arrayList.addAll(j2);
            }
            List<n> pQ = pQ(z);
            if (pQ != null && !x.isEmpty(pQ)) {
                arrayList.addAll(pQ);
            }
        } else {
            List<n> pQ2 = pQ(z);
            if (pQ2 != null && !x.isEmpty(pQ2)) {
                arrayList.addAll(pQ2);
            }
        }
        e eVar = new e();
        eVar.iLi = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
