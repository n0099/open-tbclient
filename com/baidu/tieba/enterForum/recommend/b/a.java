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
/* loaded from: classes6.dex */
public class a {
    private HashMap<Long, Integer> fRA;
    private HashMap<String, List<b>> fRB;
    private List<f> fRx;
    private HashMap<String, Integer> fRy;
    private LinkedHashMap<String, List<b>> fRz;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.isEmpty(dataRes.test_info)) {
                this.fRx = new ArrayList();
                this.fRA = new HashMap<>();
                this.fRB = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.fRx.add(fVar);
                        if (testInfo.recomm_forum != null && !v.isEmpty(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.fRH = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.fRA.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.fRB.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!v.isEmpty(dataRes.recomm_forum)) {
                this.fRy = new HashMap<>();
                this.fRz = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !v.isEmpty(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.fRH = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.fRy.put(recommForum.title, recommForum.page_size);
                        this.fRz.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> zO(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.fRz != null && this.fRz.size() > 0) {
            arrayList.addAll(this.fRz.get(str));
        }
        return arrayList;
    }

    private List<b> zP(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.fRB != null && this.fRB.size() > 0) {
            arrayList.addAll(this.fRB.get(str));
        }
        return arrayList;
    }

    public List<m> bwp() {
        ArrayList arrayList = new ArrayList();
        if (this.fRy != null && this.fRy.size() > 0) {
            for (String str : this.fRy.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.fRy.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.rI(intValue);
                    dVar.bQ(zO(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.bwt());
                }
            }
        }
        return arrayList;
    }

    private List<m> di(long j) {
        if (j <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.fRB != null && this.fRB.size() > 0) {
            Iterator<String> it = this.fRB.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.fRA.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.rI(intValue);
                        dVar.bQ(zP(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.bwt());
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> dj(long j) {
        int i;
        if (v.isEmpty(this.fRx)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.fRx.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.fRx.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.fRx.get(size - 1));
            arrayList.addAll(this.fRx.subList(0, size - 1));
        } else {
            arrayList.addAll(this.fRx.subList(i - 1, size));
            arrayList.addAll(this.fRx.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> bwq() {
        return this.fRx;
    }

    public List<m> dk(long j) {
        ArrayList arrayList = new ArrayList();
        if (j > 0) {
            List<m> di = di(j);
            if (di != null && !v.isEmpty(di)) {
                arrayList.addAll(di);
            }
            List<m> bwp = bwp();
            if (bwp != null && !v.isEmpty(bwp)) {
                arrayList.addAll(bwp);
            }
        } else {
            List<m> bwp2 = bwp();
            if (bwp2 != null && !v.isEmpty(bwp2)) {
                arrayList.addAll(bwp2);
            }
        }
        e eVar = new e();
        eVar.fRQ = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
