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
    private List<f> iMf;
    private HashMap<String, Integer> iMg;
    private LinkedHashMap<String, List<b>> iMh;
    private HashMap<Long, Integer> iMi;
    private HashMap<String, List<b>> iMj;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!y.isEmpty(dataRes.test_info)) {
                this.iMf = new ArrayList();
                this.iMi = new HashMap<>();
                this.iMj = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.iMf.add(fVar);
                        if (testInfo.recomm_forum != null && !y.isEmpty(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.iMp = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.iMi.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.iMj.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!y.isEmpty(dataRes.recomm_forum)) {
                this.iMg = new HashMap<>();
                this.iMh = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !y.isEmpty(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.iMp = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.iMg.put(recommForum.title, recommForum.page_size);
                        this.iMh.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> Jo(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.iMh != null && this.iMh.size() > 0) {
            arrayList.addAll(this.iMh.get(str));
        }
        return arrayList;
    }

    private List<b> Jp(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.iMj != null && this.iMj.size() > 0) {
            arrayList.addAll(this.iMj.get(str));
        }
        return arrayList;
    }

    public List<n> pW(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (this.iMg != null && this.iMg.size() > 0) {
            for (String str : this.iMg.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.iMg.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.needTopMargin = !z;
                    dVar.xK(intValue);
                    dVar.cS(Jo(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.cwU());
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
        if (this.iMj != null && this.iMj.size() > 0) {
            Iterator<String> it = this.iMj.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.iMi.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.needTopMargin = !z;
                        dVar.xK(intValue);
                        dVar.cS(Jp(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.cwU());
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> gk(long j) {
        int i;
        if (y.isEmpty(this.iMf)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.iMf.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.iMf.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.iMf.get(size - 1));
            arrayList.addAll(this.iMf.subList(0, size - 1));
        } else {
            arrayList.addAll(this.iMf.subList(i - 1, size));
            arrayList.addAll(this.iMf.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> cwR() {
        return this.iMf;
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
        eVar.iMy = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
