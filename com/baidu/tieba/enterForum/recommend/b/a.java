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
/* loaded from: classes22.dex */
public class a {
    private List<f> igV;
    private HashMap<String, Integer> igW;
    private LinkedHashMap<String, List<b>> igX;
    private HashMap<Long, Integer> igY;
    private HashMap<String, List<b>> igZ;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!y.isEmpty(dataRes.test_info)) {
                this.igV = new ArrayList();
                this.igY = new HashMap<>();
                this.igZ = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.igV.add(fVar);
                        if (testInfo.recomm_forum != null && !y.isEmpty(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.ihf = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.igY.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.igZ.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!y.isEmpty(dataRes.recomm_forum)) {
                this.igW = new HashMap<>();
                this.igX = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !y.isEmpty(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.ihf = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.igW.put(recommForum.title, recommForum.page_size);
                        this.igX.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> Ji(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.igX != null && this.igX.size() > 0) {
            arrayList.addAll(this.igX.get(str));
        }
        return arrayList;
    }

    private List<b> Jj(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.igZ != null && this.igZ.size() > 0) {
            arrayList.addAll(this.igZ.get(str));
        }
        return arrayList;
    }

    public List<q> oL(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (this.igW != null && this.igW.size() > 0) {
            for (String str : this.igW.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.igW.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.needTopMargin = !z;
                    dVar.xD(intValue);
                    dVar.cE(Ji(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.cqf());
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
        if (this.igZ != null && this.igZ.size() > 0) {
            Iterator<String> it = this.igZ.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.igY.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.needTopMargin = !z;
                        dVar.xD(intValue);
                        dVar.cE(Jj(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.cqf());
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> fc(long j) {
        int i;
        if (y.isEmpty(this.igV)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.igV.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.igV.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.igV.get(size - 1));
            arrayList.addAll(this.igV.subList(0, size - 1));
        } else {
            arrayList.addAll(this.igV.subList(i - 1, size));
            arrayList.addAll(this.igV.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> cqc() {
        return this.igV;
    }

    public List<q> j(long j, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (j > 0) {
            List<q> i = i(j, z);
            if (i != null && !y.isEmpty(i)) {
                arrayList.addAll(i);
            }
            List<q> oL = oL(z);
            if (oL != null && !y.isEmpty(oL)) {
                arrayList.addAll(oL);
            }
        } else {
            List<q> oL2 = oL(z);
            if (oL2 != null && !y.isEmpty(oL2)) {
                arrayList.addAll(oL2);
            }
        }
        e eVar = new e();
        eVar.iho = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
