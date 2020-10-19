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
    private List<f> hUv;
    private HashMap<String, Integer> hUw;
    private LinkedHashMap<String, List<b>> hUx;
    private HashMap<Long, Integer> hUy;
    private HashMap<String, List<b>> hUz;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!y.isEmpty(dataRes.test_info)) {
                this.hUv = new ArrayList();
                this.hUy = new HashMap<>();
                this.hUz = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.hUv.add(fVar);
                        if (testInfo.recomm_forum != null && !y.isEmpty(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.hUF = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.hUy.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.hUz.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!y.isEmpty(dataRes.recomm_forum)) {
                this.hUw = new HashMap<>();
                this.hUx = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !y.isEmpty(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.hUF = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.hUw.put(recommForum.title, recommForum.page_size);
                        this.hUx.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> IJ(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.hUx != null && this.hUx.size() > 0) {
            arrayList.addAll(this.hUx.get(str));
        }
        return arrayList;
    }

    private List<b> IK(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.hUz != null && this.hUz.size() > 0) {
            arrayList.addAll(this.hUz.get(str));
        }
        return arrayList;
    }

    public List<q> ot(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (this.hUw != null && this.hUw.size() > 0) {
            for (String str : this.hUw.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.hUw.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.needTopMargin = !z;
                    dVar.xk(intValue);
                    dVar.cv(IJ(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.cmY());
                }
            }
        }
        return arrayList;
    }

    private List<q> h(long j, boolean z) {
        if (j <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.hUz != null && this.hUz.size() > 0) {
            Iterator<String> it = this.hUz.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.hUy.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.needTopMargin = !z;
                        dVar.xk(intValue);
                        dVar.cv(IK(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.cmY());
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> fb(long j) {
        int i;
        if (y.isEmpty(this.hUv)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.hUv.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.hUv.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.hUv.get(size - 1));
            arrayList.addAll(this.hUv.subList(0, size - 1));
        } else {
            arrayList.addAll(this.hUv.subList(i - 1, size));
            arrayList.addAll(this.hUv.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> cmV() {
        return this.hUv;
    }

    public List<q> i(long j, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (j > 0) {
            List<q> h = h(j, z);
            if (h != null && !y.isEmpty(h)) {
                arrayList.addAll(h);
            }
            List<q> ot = ot(z);
            if (ot != null && !y.isEmpty(ot)) {
                arrayList.addAll(ot);
            }
        } else {
            List<q> ot2 = ot(z);
            if (ot2 != null && !y.isEmpty(ot2)) {
                arrayList.addAll(ot2);
            }
        }
        e eVar = new e();
        eVar.hUO = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
