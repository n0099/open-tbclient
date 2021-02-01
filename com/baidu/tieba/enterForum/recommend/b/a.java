package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
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
/* loaded from: classes2.dex */
public class a {
    private List<f> iLR;
    private HashMap<String, Integer> iLS;
    private LinkedHashMap<String, List<b>> iLT;
    private HashMap<Long, Integer> iLU;
    private HashMap<String, List<b>> iLV;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!y.isEmpty(dataRes.test_info)) {
                this.iLR = new ArrayList();
                this.iLU = new HashMap<>();
                this.iLV = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.iLR.add(fVar);
                        if (testInfo.recomm_forum != null && !y.isEmpty(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.iMb = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.iLU.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.iLV.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!y.isEmpty(dataRes.recomm_forum)) {
                this.iLS = new HashMap<>();
                this.iLT = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !y.isEmpty(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.iMb = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.iLS.put(recommForum.title, recommForum.page_size);
                        this.iLT.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> Jn(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.iLT != null && this.iLT.size() > 0) {
            arrayList.addAll(this.iLT.get(str));
        }
        return arrayList;
    }

    private List<b> Jo(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.iLV != null && this.iLV.size() > 0) {
            arrayList.addAll(this.iLV.get(str));
        }
        return arrayList;
    }

    public List<n> pW(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (this.iLS != null && this.iLS.size() > 0) {
            for (String str : this.iLS.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.iLS.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.needTopMargin = !z;
                    dVar.xK(intValue);
                    dVar.cS(Jn(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.cwN());
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
        if (this.iLV != null && this.iLV.size() > 0) {
            Iterator<String> it = this.iLV.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.iLU.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.needTopMargin = !z;
                        dVar.xK(intValue);
                        dVar.cS(Jo(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.cwN());
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> gk(long j) {
        int i;
        if (y.isEmpty(this.iLR)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.iLR.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.iLR.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.iLR.get(size - 1));
            arrayList.addAll(this.iLR.subList(0, size - 1));
        } else {
            arrayList.addAll(this.iLR.subList(i - 1, size));
            arrayList.addAll(this.iLR.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> cwK() {
        return this.iLR;
    }

    public List<n> l(long j, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (j > 0) {
            List<n> k = k(j, z);
            if (k != null && !y.isEmpty(k)) {
                arrayList.addAll(k);
            }
            List<n> pW = pW(z);
            if (pW != null && !y.isEmpty(pW)) {
                arrayList.addAll(pW);
            }
        } else {
            List<n> pW2 = pW(z);
            if (pW2 != null && !y.isEmpty(pW2)) {
                arrayList.addAll(pW2);
            }
        }
        e eVar = new e();
        eVar.iMk = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
