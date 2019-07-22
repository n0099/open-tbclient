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
/* loaded from: classes4.dex */
public class a {
    private List<f> eZg;
    private HashMap<String, Integer> eZh;
    private LinkedHashMap<String, List<b>> eZi;
    private HashMap<Long, Integer> eZj;
    private HashMap<String, List<b>> eZk;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.aa(dataRes.test_info)) {
                this.eZg = new ArrayList();
                this.eZj = new HashMap<>();
                this.eZk = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.eZg.add(fVar);
                        if (testInfo.recomm_forum != null && !v.aa(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.eZq = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.eZj.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.eZk.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!v.aa(dataRes.recomm_forum)) {
                this.eZh = new HashMap<>();
                this.eZi = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !v.aa(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.eZq = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.eZh.put(recommForum.title, recommForum.page_size);
                        this.eZi.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> vY(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.eZi != null && this.eZi.size() > 0) {
            arrayList.addAll(this.eZi.get(str));
        }
        return arrayList;
    }

    private List<b> vZ(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.eZk != null && this.eZk.size() > 0) {
            arrayList.addAll(this.eZk.get(str));
        }
        return arrayList;
    }

    public List<m> bgu() {
        ArrayList arrayList = new ArrayList();
        if (this.eZh != null && this.eZh.size() > 0) {
            for (String str : this.eZh.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.eZh.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.qC(intValue);
                    dVar.bH(vY(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.bgy());
                }
            }
        }
        return arrayList;
    }

    private List<m> da(long j) {
        if (j <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.eZk != null && this.eZk.size() > 0) {
            Iterator<String> it = this.eZk.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.eZj.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.qC(intValue);
                        dVar.bH(vZ(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.bgy());
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> db(long j) {
        int i;
        if (v.aa(this.eZg)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.eZg.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.eZg.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.eZg.get(size - 1));
            arrayList.addAll(this.eZg.subList(0, size - 1));
        } else {
            arrayList.addAll(this.eZg.subList(i - 1, size));
            arrayList.addAll(this.eZg.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> bgv() {
        return this.eZg;
    }

    public List<m> dc(long j) {
        ArrayList arrayList = new ArrayList();
        if (j > 0) {
            List<m> da = da(j);
            if (da != null && !v.aa(da)) {
                arrayList.addAll(da);
            }
            List<m> bgu = bgu();
            if (bgu != null && !v.aa(bgu)) {
                arrayList.addAll(bgu);
            }
        } else {
            List<m> bgu2 = bgu();
            if (bgu2 != null && !v.aa(bgu2)) {
                arrayList.addAll(bgu2);
            }
        }
        e eVar = new e();
        eVar.eZz = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
