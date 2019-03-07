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
    private List<f> eEC;
    private HashMap<String, Integer> eED;
    private LinkedHashMap<String, List<b>> eEE;
    private HashMap<Long, Integer> eEF;
    private HashMap<String, List<b>> eEG;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.T(dataRes.test_info)) {
                this.eEC = new ArrayList();
                this.eEF = new HashMap<>();
                this.eEG = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.eEC.add(fVar);
                        if (testInfo.recomm_forum != null && !v.T(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.eEM = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.eEF.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.eEG.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!v.T(dataRes.recomm_forum)) {
                this.eED = new HashMap<>();
                this.eEE = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !v.T(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.eEM = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.eED.put(recommForum.title, recommForum.page_size);
                        this.eEE.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> uc(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.eEE != null && this.eEE.size() > 0) {
            arrayList.addAll(this.eEE.get(str));
        }
        return arrayList;
    }

    private List<b> ud(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.eEG != null && this.eEG.size() > 0) {
            arrayList.addAll(this.eEG.get(str));
        }
        return arrayList;
    }

    public List<m> aXc() {
        ArrayList arrayList = new ArrayList();
        if (this.eED != null && this.eED.size() > 0) {
            for (String str : this.eED.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.eED.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.pj(intValue);
                    dVar.bz(uc(str));
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
        if (this.eEG != null && this.eEG.size() > 0) {
            Iterator<String> it = this.eEG.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.eEF.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.pj(intValue);
                        dVar.bz(ud(next));
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
        if (v.T(this.eEC)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.eEC.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.eEC.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.eEC.get(size - 1));
            arrayList.addAll(this.eEC.subList(0, size - 1));
        } else {
            arrayList.addAll(this.eEC.subList(i - 1, size));
            arrayList.addAll(this.eEC.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> aXd() {
        return this.eEC;
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
        eVar.eEV = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
