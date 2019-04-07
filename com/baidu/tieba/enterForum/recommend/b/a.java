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
    private List<f> eEj;
    private HashMap<String, Integer> eEk;
    private LinkedHashMap<String, List<b>> eEl;
    private HashMap<Long, Integer> eEm;
    private HashMap<String, List<b>> eEn;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.T(dataRes.test_info)) {
                this.eEj = new ArrayList();
                this.eEm = new HashMap<>();
                this.eEn = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.eEj.add(fVar);
                        if (testInfo.recomm_forum != null && !v.T(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.eEt = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.eEm.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.eEn.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!v.T(dataRes.recomm_forum)) {
                this.eEk = new HashMap<>();
                this.eEl = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !v.T(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.eEt = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.eEk.put(recommForum.title, recommForum.page_size);
                        this.eEl.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> ua(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.eEl != null && this.eEl.size() > 0) {
            arrayList.addAll(this.eEl.get(str));
        }
        return arrayList;
    }

    private List<b> ub(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.eEn != null && this.eEn.size() > 0) {
            arrayList.addAll(this.eEn.get(str));
        }
        return arrayList;
    }

    public List<m> aXa() {
        ArrayList arrayList = new ArrayList();
        if (this.eEk != null && this.eEk.size() > 0) {
            for (String str : this.eEk.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.eEk.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.pf(intValue);
                    dVar.bx(ua(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.aXe());
                }
            }
        }
        return arrayList;
    }

    private List<m> cw(long j) {
        if (j <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.eEn != null && this.eEn.size() > 0) {
            Iterator<String> it = this.eEn.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.eEm.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.pf(intValue);
                        dVar.bx(ub(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.aXe());
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> cx(long j) {
        int i;
        if (v.T(this.eEj)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.eEj.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.eEj.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.eEj.get(size - 1));
            arrayList.addAll(this.eEj.subList(0, size - 1));
        } else {
            arrayList.addAll(this.eEj.subList(i - 1, size));
            arrayList.addAll(this.eEj.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> aXb() {
        return this.eEj;
    }

    public List<m> cy(long j) {
        ArrayList arrayList = new ArrayList();
        if (j > 0) {
            List<m> cw = cw(j);
            if (cw != null && !v.T(cw)) {
                arrayList.addAll(cw);
            }
            List<m> aXa = aXa();
            if (aXa != null && !v.T(aXa)) {
                arrayList.addAll(aXa);
            }
        } else {
            List<m> aXa2 = aXa();
            if (aXa2 != null && !v.T(aXa2)) {
                arrayList.addAll(aXa2);
            }
        }
        e eVar = new e();
        eVar.eEC = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
