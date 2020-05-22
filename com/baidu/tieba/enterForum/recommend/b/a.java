package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.o;
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
    private List<f> gSX;
    private HashMap<String, Integer> gSY;
    private LinkedHashMap<String, List<b>> gSZ;
    private HashMap<Long, Integer> gTa;
    private HashMap<String, List<b>> gTb;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.isEmpty(dataRes.test_info)) {
                this.gSX = new ArrayList();
                this.gTa = new HashMap<>();
                this.gTb = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.gSX.add(fVar);
                        if (testInfo.recomm_forum != null && !v.isEmpty(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.gTh = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.gTa.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.gTb.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!v.isEmpty(dataRes.recomm_forum)) {
                this.gSY = new HashMap<>();
                this.gSZ = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !v.isEmpty(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.gTh = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.gSY.put(recommForum.title, recommForum.page_size);
                        this.gSZ.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> DN(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.gSZ != null && this.gSZ.size() > 0) {
            arrayList.addAll(this.gSZ.get(str));
        }
        return arrayList;
    }

    private List<b> DO(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.gTb != null && this.gTb.size() > 0) {
            arrayList.addAll(this.gTb.get(str));
        }
        return arrayList;
    }

    public List<o> mm(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (this.gSY != null && this.gSY.size() > 0) {
            for (String str : this.gSY.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.gSY.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.needTopMargin = !z;
                    dVar.sV(intValue);
                    dVar.bW(DN(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.bPA());
                }
            }
        }
        return arrayList;
    }

    private List<o> g(long j, boolean z) {
        if (j <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.gTb != null && this.gTb.size() > 0) {
            Iterator<String> it = this.gTb.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.gTa.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.needTopMargin = !z;
                        dVar.sV(intValue);
                        dVar.bW(DO(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.bPA());
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> dZ(long j) {
        int i;
        if (v.isEmpty(this.gSX)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.gSX.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.gSX.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.gSX.get(size - 1));
            arrayList.addAll(this.gSX.subList(0, size - 1));
        } else {
            arrayList.addAll(this.gSX.subList(i - 1, size));
            arrayList.addAll(this.gSX.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> bPx() {
        return this.gSX;
    }

    public List<o> h(long j, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (j > 0) {
            List<o> g = g(j, z);
            if (g != null && !v.isEmpty(g)) {
                arrayList.addAll(g);
            }
            List<o> mm = mm(z);
            if (mm != null && !v.isEmpty(mm)) {
                arrayList.addAll(mm);
            }
        } else {
            List<o> mm2 = mm(z);
            if (mm2 != null && !v.isEmpty(mm2)) {
                arrayList.addAll(mm2);
            }
        }
        e eVar = new e();
        eVar.gTq = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
