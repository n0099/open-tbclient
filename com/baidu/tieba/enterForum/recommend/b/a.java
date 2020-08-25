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
/* loaded from: classes16.dex */
public class a {
    private List<f> hys;
    private HashMap<String, Integer> hyt;
    private LinkedHashMap<String, List<b>> hyu;
    private HashMap<Long, Integer> hyv;
    private HashMap<String, List<b>> hyw;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!y.isEmpty(dataRes.test_info)) {
                this.hys = new ArrayList();
                this.hyv = new HashMap<>();
                this.hyw = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.hys.add(fVar);
                        if (testInfo.recomm_forum != null && !y.isEmpty(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.hyC = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.hyv.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.hyw.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!y.isEmpty(dataRes.recomm_forum)) {
                this.hyt = new HashMap<>();
                this.hyu = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !y.isEmpty(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.hyC = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.hyt.put(recommForum.title, recommForum.page_size);
                        this.hyu.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> Hy(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.hyu != null && this.hyu.size() > 0) {
            arrayList.addAll(this.hyu.get(str));
        }
        return arrayList;
    }

    private List<b> Hz(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.hyw != null && this.hyw.size() > 0) {
            arrayList.addAll(this.hyw.get(str));
        }
        return arrayList;
    }

    public List<q> nG(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (this.hyt != null && this.hyt.size() > 0) {
            for (String str : this.hyt.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.hyt.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.needTopMargin = !z;
                    dVar.wf(intValue);
                    dVar.cm(Hy(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.cgk());
                }
            }
        }
        return arrayList;
    }

    private List<q> g(long j, boolean z) {
        if (j <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.hyw != null && this.hyw.size() > 0) {
            Iterator<String> it = this.hyw.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.hyv.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.needTopMargin = !z;
                        dVar.wf(intValue);
                        dVar.cm(Hz(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.cgk());
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> eA(long j) {
        int i;
        if (y.isEmpty(this.hys)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.hys.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.hys.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.hys.get(size - 1));
            arrayList.addAll(this.hys.subList(0, size - 1));
        } else {
            arrayList.addAll(this.hys.subList(i - 1, size));
            arrayList.addAll(this.hys.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> cgh() {
        return this.hys;
    }

    public List<q> h(long j, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (j > 0) {
            List<q> g = g(j, z);
            if (g != null && !y.isEmpty(g)) {
                arrayList.addAll(g);
            }
            List<q> nG = nG(z);
            if (nG != null && !y.isEmpty(nG)) {
                arrayList.addAll(nG);
            }
        } else {
            List<q> nG2 = nG(z);
            if (nG2 != null && !y.isEmpty(nG2)) {
                arrayList.addAll(nG2);
            }
        }
        e eVar = new e();
        eVar.hyL = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
