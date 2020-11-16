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
/* loaded from: classes21.dex */
public class a {
    private List<f> inI;
    private HashMap<String, Integer> inJ;
    private LinkedHashMap<String, List<b>> inK;
    private HashMap<Long, Integer> inL;
    private HashMap<String, List<b>> inM;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!y.isEmpty(dataRes.test_info)) {
                this.inI = new ArrayList();
                this.inL = new HashMap<>();
                this.inM = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.inI.add(fVar);
                        if (testInfo.recomm_forum != null && !y.isEmpty(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.inS = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.inL.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.inM.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!y.isEmpty(dataRes.recomm_forum)) {
                this.inJ = new HashMap<>();
                this.inK = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !y.isEmpty(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.inS = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.inJ.put(recommForum.title, recommForum.page_size);
                        this.inK.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> Ja(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.inK != null && this.inK.size() > 0) {
            arrayList.addAll(this.inK.get(str));
        }
        return arrayList;
    }

    private List<b> Jb(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.inM != null && this.inM.size() > 0) {
            arrayList.addAll(this.inM.get(str));
        }
        return arrayList;
    }

    public List<q> oX(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (this.inJ != null && this.inJ.size() > 0) {
            for (String str : this.inJ.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.inJ.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.needTopMargin = !z;
                    dVar.yo(intValue);
                    dVar.cM(Ja(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.csj());
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
        if (this.inM != null && this.inM.size() > 0) {
            Iterator<String> it = this.inM.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.inL.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.needTopMargin = !z;
                        dVar.yo(intValue);
                        dVar.cM(Jb(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.csj());
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> fB(long j) {
        int i;
        if (y.isEmpty(this.inI)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.inI.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.inI.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.inI.get(size - 1));
            arrayList.addAll(this.inI.subList(0, size - 1));
        } else {
            arrayList.addAll(this.inI.subList(i - 1, size));
            arrayList.addAll(this.inI.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> csg() {
        return this.inI;
    }

    public List<q> j(long j, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (j > 0) {
            List<q> i = i(j, z);
            if (i != null && !y.isEmpty(i)) {
                arrayList.addAll(i);
            }
            List<q> oX = oX(z);
            if (oX != null && !y.isEmpty(oX)) {
                arrayList.addAll(oX);
            }
        } else {
            List<q> oX2 = oX(z);
            if (oX2 != null && !y.isEmpty(oX2)) {
                arrayList.addAll(oX2);
            }
        }
        e eVar = new e();
        eVar.iob = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
