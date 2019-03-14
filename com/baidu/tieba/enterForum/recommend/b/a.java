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
    private LinkedHashMap<String, List<b>> eEA;
    private HashMap<Long, Integer> eEB;
    private HashMap<String, List<b>> eEC;
    private List<f> eEy;
    private HashMap<String, Integer> eEz;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.T(dataRes.test_info)) {
                this.eEy = new ArrayList();
                this.eEB = new HashMap<>();
                this.eEC = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.eEy.add(fVar);
                        if (testInfo.recomm_forum != null && !v.T(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.eEI = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.eEB.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.eEC.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!v.T(dataRes.recomm_forum)) {
                this.eEz = new HashMap<>();
                this.eEA = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !v.T(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.eEI = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.eEz.put(recommForum.title, recommForum.page_size);
                        this.eEA.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> ub(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.eEA != null && this.eEA.size() > 0) {
            arrayList.addAll(this.eEA.get(str));
        }
        return arrayList;
    }

    private List<b> uc(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.eEC != null && this.eEC.size() > 0) {
            arrayList.addAll(this.eEC.get(str));
        }
        return arrayList;
    }

    public List<m> aXc() {
        ArrayList arrayList = new ArrayList();
        if (this.eEz != null && this.eEz.size() > 0) {
            for (String str : this.eEz.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.eEz.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.pj(intValue);
                    dVar.bz(ub(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.aXg());
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
        if (this.eEC != null && this.eEC.size() > 0) {
            Iterator<String> it = this.eEC.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.eEB.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.pj(intValue);
                        dVar.bz(uc(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.aXg());
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> cx(long j) {
        int i;
        if (v.T(this.eEy)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.eEy.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.eEy.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.eEy.get(size - 1));
            arrayList.addAll(this.eEy.subList(0, size - 1));
        } else {
            arrayList.addAll(this.eEy.subList(i - 1, size));
            arrayList.addAll(this.eEy.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> aXd() {
        return this.eEy;
    }

    public List<m> cy(long j) {
        ArrayList arrayList = new ArrayList();
        if (j > 0) {
            List<m> cw = cw(j);
            if (cw != null && !v.T(cw)) {
                arrayList.addAll(cw);
            }
            List<m> aXc = aXc();
            if (aXc != null && !v.T(aXc)) {
                arrayList.addAll(aXc);
            }
        } else {
            List<m> aXc2 = aXc();
            if (aXc2 != null && !v.T(aXc2)) {
                arrayList.addAll(aXc2);
            }
        }
        e eVar = new e();
        eVar.eER = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
