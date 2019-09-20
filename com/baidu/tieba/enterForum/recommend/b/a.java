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
    private List<f> fba;
    private HashMap<String, Integer> fbb;
    private LinkedHashMap<String, List<b>> fbc;
    private HashMap<Long, Integer> fbd;
    private HashMap<String, List<b>> fbe;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!v.aa(dataRes.test_info)) {
                this.fba = new ArrayList();
                this.fbd = new HashMap<>();
                this.fbe = new HashMap<>();
                for (TestInfo testInfo : dataRes.test_info) {
                    if (testInfo != null) {
                        f fVar = new f();
                        fVar.a(testInfo);
                        this.fba.add(fVar);
                        if (testInfo.recomm_forum != null && !v.aa(testInfo.recomm_forum.forums)) {
                            ArrayList arrayList = new ArrayList();
                            for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                                if (recommendForumInfo != null) {
                                    b bVar = new b();
                                    bVar.b(recommendForumInfo);
                                    bVar.fbk = 1;
                                    arrayList.add(bVar);
                                }
                            }
                            this.fbd.put(Long.valueOf(fVar.testId), testInfo.recomm_forum.page_size);
                            this.fbe.put(String.valueOf(fVar.testId) + "|" + testInfo.recomm_forum.title, arrayList);
                        }
                    }
                }
            }
            if (!v.aa(dataRes.recomm_forum)) {
                this.fbb = new HashMap<>();
                this.fbc = new LinkedHashMap<>();
                for (RecommForum recommForum : dataRes.recomm_forum) {
                    if (recommForum != null && !v.aa(recommForum.forums)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo2 : recommForum.forums) {
                            if (recommendForumInfo2 != null) {
                                b bVar2 = new b();
                                bVar2.b(recommendForumInfo2);
                                bVar2.fbk = 2;
                                arrayList2.add(bVar2);
                            }
                        }
                        this.fbb.put(recommForum.title, recommForum.page_size);
                        this.fbc.put(recommForum.title, arrayList2);
                    }
                }
            }
        }
    }

    private List<b> wy(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.fbc != null && this.fbc.size() > 0) {
            arrayList.addAll(this.fbc.get(str));
        }
        return arrayList;
    }

    private List<b> wz(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.fbe != null && this.fbe.size() > 0) {
            arrayList.addAll(this.fbe.get(str));
        }
        return arrayList;
    }

    public List<m> bhd() {
        ArrayList arrayList = new ArrayList();
        if (this.fbb != null && this.fbb.size() > 0) {
            for (String str : this.fbb.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.fbb.get(str).intValue();
                    d dVar = new d();
                    dVar.setTitle(str);
                    dVar.qH(intValue);
                    dVar.bH(wy(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.bhh());
                }
            }
        }
        return arrayList;
    }

    private List<m> dd(long j) {
        if (j <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.fbe != null && this.fbe.size() > 0) {
            Iterator<String> it = this.fbe.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.fbd.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.setTitle(str);
                        dVar.qH(intValue);
                        dVar.bH(wz(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.bhh());
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> de(long j) {
        int i;
        if (v.aa(this.fba)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.fba.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else if (this.fba.get(i2).testId == j) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            arrayList.add(this.fba.get(size - 1));
            arrayList.addAll(this.fba.subList(0, size - 1));
        } else {
            arrayList.addAll(this.fba.subList(i - 1, size));
            arrayList.addAll(this.fba.subList(0, i - 1));
        }
        return arrayList;
    }

    public List<f> bhe() {
        return this.fba;
    }

    public List<m> df(long j) {
        ArrayList arrayList = new ArrayList();
        if (j > 0) {
            List<m> dd = dd(j);
            if (dd != null && !v.aa(dd)) {
                arrayList.addAll(dd);
            }
            List<m> bhd = bhd();
            if (bhd != null && !v.aa(bhd)) {
                arrayList.addAll(bhd);
            }
        } else {
            List<m> bhd2 = bhd();
            if (bhd2 != null && !v.aa(bhd2)) {
                arrayList.addAll(bhd2);
            }
        }
        e eVar = new e();
        eVar.fbt = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }
}
