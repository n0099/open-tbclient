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
    private List<f> iNO;
    private HashMap<String, Integer> iNP;
    private LinkedHashMap<String, List<b>> iNQ;
    private HashMap<Long, Integer> iNR;
    private HashMap<String, List<b>> iNS;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!y.isEmpty(dataRes.test_info)) {
                this.iNO = new ArrayList();
                this.iNR = new HashMap<>();
                this.iNS = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.iNO.add(fVar);
                        if (testInfo.recomm_forum != null && !y.isEmpty(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.iNY = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.iNR.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.iNS.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!y.isEmpty(dataRes.recomm_forum)) {
                this.iNP = new HashMap<>();
                this.iNQ = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !y.isEmpty(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.iNY = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.iNP.put(recommForum.title, recommForum.page_size);
                        this.iNQ.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> Jx(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.iNQ != null && this.iNQ.size() > 0) {
            arrayList.addAll(this.iNQ.get(str));
        }
        return arrayList;
    }

    private List<b> Jy(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.iNS != null && this.iNS.size() > 0) {
            arrayList.addAll(this.iNS.get(str));
        }
        return arrayList;
    }

    public List<n> pW(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (this.iNP != null && this.iNP.size() > 0) {
            for (String str : this.iNP.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.iNP.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.needTopMargin = !z;
                    dVar.xL(intValue);
                    dVar.cS(Jx(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.cxa());
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
        if (this.iNS != null && this.iNS.size() > 0) {
            Iterator<String> it = this.iNS.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.iNR.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.needTopMargin = !z;
                        dVar.xL(intValue);
                        dVar.cS(Jy(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.cxa());
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> gk(long j) {
        int i;
        if (y.isEmpty(this.iNO)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.iNO.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.iNO.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.iNO.get(size - 1));
            arrayList.addAll(this.iNO.subList(0, size - 1));
        } else {
            arrayList.addAll(this.iNO.subList(i - 1, size));
            arrayList.addAll(this.iNO.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> cwX() {
        return this.iNO;
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
        eVar.iOh = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
