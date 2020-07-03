package com.baidu.tieba.homepage.personalize.model;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.data.p;
import com.baidu.tieba.recapp.q;
import com.baidu.tieba.recapp.report.g;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.App;
import tbclient.BannerList;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.Resource;
/* loaded from: classes9.dex */
public class d {
    public static void a(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i, int i2, int i3, int i4) {
        if (builder2 != null && builder != null) {
            if (builder2.card_forum != null && builder.card_forum != null) {
                builder.card_forum.addAll(builder2.card_forum);
            }
            if (builder2.card_topic != null && builder.card_topic != null) {
                builder.card_topic.addAll(builder2.card_topic);
            }
            if (builder2.resource_list != null && builder.resource_list != null) {
                builder.resource_list.addAll(builder2.resource_list);
            }
            if (i == 0) {
                builder.banner_list = a(z, builder.banner_list, builder2.banner_list, i2);
            } else {
                builder.banner_list = a(z, builder.banner_list, builder2.banner_list, builder.thread_list != null ? builder.thread_list.size() : 0, i3, i4, i2);
            }
            if (builder.age_sex == null) {
                builder.age_sex = builder2.age_sex;
                if (builder2.age_sex != null) {
                    com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.HAS_REQUESTED_NEW_USER_GUIDE, true);
                }
            }
            if (builder2.interestion != null && builder != null && builder.interestion != null && builder.interestion.size() == 0) {
                builder.interestion.addAll(builder2.interestion);
            }
            if (builder2.card_god != null) {
                builder.card_god.addAll(builder2.card_god);
            }
        }
    }

    private static BannerList a(boolean z, BannerList bannerList, BannerList bannerList2, int i) {
        int i2;
        if (i > 0) {
            BannerList.Builder builder = new BannerList.Builder(bannerList);
            if (builder.app == null) {
                builder.app = new LinkedList();
            }
            BannerList.Builder builder2 = new BannerList.Builder(bannerList2);
            if (z) {
                a(builder2);
            }
            if (builder2.app != null) {
                Iterator<App> it = builder2.app.iterator();
                i2 = 0;
                while (it.hasNext()) {
                    App next = it.next();
                    if (next != null) {
                        int i3 = com.baidu.adp.lib.f.b.toInt(next.pos_name, -1);
                        if (i3 <= 0) {
                            it.remove();
                            a(next, 1, 23);
                        } else if (i3 <= i + i2 + 1) {
                            i2++;
                        } else {
                            it.remove();
                            a(next, 1, 2);
                        }
                    } else {
                        it.remove();
                    }
                    i2 = i2;
                }
            } else {
                i2 = 0;
            }
            int i4 = i2 + i;
            if (i4 <= 0) {
                return builder.build(false);
            }
            a(builder, i4);
            if (builder2.app != null) {
                builder.app.addAll(0, builder2.app);
            }
            return builder.build(false);
        }
        return bannerList;
    }

    private static BannerList a(boolean z, BannerList bannerList, BannerList bannerList2, int i, int i2, int i3, int i4) {
        if (i4 > 0) {
            BannerList.Builder builder = new BannerList.Builder(bannerList);
            if (bannerList2 == null || bannerList2.app == null) {
                return builder.build(false);
            }
            if (builder.app == null) {
                builder.app = new LinkedList();
            }
            o(i, builder.app);
            int i5 = i2 + i3;
            BannerList.Builder builder2 = new BannerList.Builder(bannerList2);
            if (builder2.app == null) {
                builder2.app = new LinkedList();
            }
            if (z) {
                a(builder2);
            }
            if (builder2.app != null) {
                int i6 = 0;
                Iterator<App> it = builder2.app.iterator();
                while (true) {
                    int i7 = i6;
                    if (!it.hasNext()) {
                        break;
                    }
                    App next = it.next();
                    if (next != null) {
                        int i8 = com.baidu.adp.lib.f.b.toInt(next.pos_name, -1);
                        if (i8 <= 0) {
                            it.remove();
                            a(next, 1, 23);
                        } else if (i8 <= i4 + i7 + 1) {
                            i7++;
                        } else {
                            it.remove();
                            a(next, 1, 2);
                        }
                    } else {
                        it.remove();
                    }
                    i6 = i7;
                }
            }
            a(builder2, i5);
            if (builder2.app != null) {
                builder.app.addAll(builder2.app);
            }
            return builder.build(false);
        }
        return bannerList;
    }

    private static void o(int i, List<App> list) {
        if (list != null) {
            int i2 = 0;
            Iterator<App> it = list.iterator();
            while (true) {
                int i3 = i2;
                if (it.hasNext()) {
                    App next = it.next();
                    if (next != null) {
                        int i4 = com.baidu.adp.lib.f.b.toInt(next.pos_name, -1);
                        if (i4 <= 0) {
                            it.remove();
                            a(next, 1, 23);
                        } else if (i4 <= i + i3 + 1) {
                            i3++;
                        } else {
                            it.remove();
                            a(next, 1, 2);
                        }
                    } else {
                        it.remove();
                    }
                    i2 = i3;
                } else {
                    return;
                }
            }
        }
    }

    private static void a(BannerList.Builder builder) {
        if (builder != null && !w.isEmpty(builder.app)) {
            for (int i = 0; i < builder.app.size(); i++) {
                App app = builder.app.get(i);
                if (app != null) {
                    App.Builder builder2 = new App.Builder(app);
                    builder2.pos = Integer.valueOf(com.baidu.adp.lib.f.b.toInt(app.pos_name, 0));
                    App build = builder2.build(false);
                    builder.app.remove(i);
                    builder.app.add(i, build);
                }
            }
        }
    }

    private static void a(BannerList.Builder builder, int i) {
        if (builder != null && builder.app != null) {
            for (int i2 = 0; i2 < builder.app.size(); i2++) {
                App app = builder.app.get(i2);
                if (app != null) {
                    App.Builder builder2 = new App.Builder(app);
                    builder2.pos_name = String.valueOf(com.baidu.adp.lib.f.b.toInt(app.pos_name, 0) + i);
                    App build = builder2.build(false);
                    builder.app.remove(i2);
                    builder.app.add(i2, build);
                }
            }
        }
    }

    public static List<p> d(DataRes.Builder builder) {
        com.baidu.tieba.homepage.personalize.data.d dVar = null;
        if (builder == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        if (builder.resource_list != null) {
            for (Resource resource : builder.resource_list) {
                com.baidu.tieba.homepage.personalize.data.c cVar = new com.baidu.tieba.homepage.personalize.data.c();
                cVar.a(resource);
                linkedList.add(cVar);
            }
        }
        if (builder.card_forum != null) {
            for (CardForum cardForum : builder.card_forum) {
                if (cardForum != null && com.baidu.tieba.homepage.personalize.data.b.xm(cardForum.card_type.intValue()) && dVar == null) {
                    dVar = new com.baidu.tieba.homepage.personalize.data.d();
                    dVar.a(cardForum);
                    if (dVar.isValidate()) {
                        linkedList.add(dVar);
                    }
                }
                dVar = dVar;
            }
        }
        List<AppData> cYQ = q.cYS().cYQ();
        if (cYQ != null) {
            cYQ.clear();
        }
        if (builder.banner_list != null && builder.banner_list.app != null) {
            for (App app : builder.banner_list.app) {
                com.baidu.tieba.homepage.personalize.data.a aVar = new com.baidu.tieba.homepage.personalize.data.a();
                aVar.b(app);
                if (cYQ != null && aVar.gUg != null) {
                    aVar.gUg.dOy = true;
                    cYQ.add(aVar.gUg.dHb);
                }
                AdvertAppInfo bOT = aVar.bOT();
                if (bOT == null) {
                    a(aVar.bOT(), 1, 100);
                } else {
                    int aQi = bOT.aQi();
                    if (aQi != 0) {
                        a(aVar.bOT(), 1, aQi);
                        if (aQi != 28 && aQi != 31) {
                            if (bOT.dGU != null) {
                                bOT.dGU.dHh = -1001;
                            }
                        }
                    }
                    if (aVar.getPosition() <= 0) {
                        a(aVar.bOT(), 1, 23);
                        if (bOT.dGU != null) {
                            bOT.dGU.dHh = -1001;
                        }
                    }
                    if (bOT.aQj()) {
                        try {
                            if (TextUtils.isEmpty(bOT.dGO) || x.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), bOT.dGO)) {
                                if (TextUtils.isEmpty(bOT.dGO)) {
                                    a(aVar.bOT(), 1, 26);
                                } else {
                                    a(aVar.bOT(), 1, 3);
                                }
                            }
                        } catch (Exception e) {
                            a(aVar.bOT(), 1, 100);
                        }
                    }
                    linkedList.add(aVar);
                }
            }
        }
        q.cYS().cYR();
        return linkedList;
    }

    public static void e(DataRes.Builder builder) {
        if (builder != null) {
            if (builder.thread_list == null) {
                builder.thread_list = new LinkedList();
            }
            if (builder.card_forum == null) {
                builder.card_forum = new LinkedList();
            }
            if (builder.card_topic == null) {
                builder.card_topic = new LinkedList();
            }
            if (builder.resource_list == null) {
                builder.resource_list = new LinkedList();
            }
            if (builder.thread_personalized == null) {
                builder.thread_personalized = new LinkedList();
            }
            if (builder.interestion == null) {
                builder.interestion = new LinkedList();
            }
            if (builder.card_god == null) {
                builder.card_god = new LinkedList();
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:8:0x0011 */
    public static com.baidu.tieba.card.data.c aB(bu buVar) {
        k kVar = null;
        kVar = null;
        if (buVar != null) {
            if (buVar.isShareThread) {
                k kVar2 = new k();
                kVar2.dLi = buVar;
                kVar = kVar2;
            } else if (j.ad(buVar)) {
                kVar = new j(buVar);
            } else if (k.ad(buVar) || k.af(buVar)) {
                k kVar3 = new k();
                if (buVar.isLinkThread()) {
                    kVar3.isLinkThread = true;
                } else if (buVar.aTs()) {
                    kVar3.dLc = true;
                } else {
                    kVar3.isLinkThread = false;
                    if (buVar.aSs()) {
                        kVar3.gUO = true;
                    } else {
                        kVar3.gUO = false;
                    }
                }
                kVar3.dLi = buVar;
                kVar3.gUP = true;
                kVar = kVar3;
            } else if (l.ad(buVar)) {
                kVar = new l(buVar);
            }
            if (kVar != null) {
                kVar.bOR();
            }
        }
        return kVar;
    }

    public static k aC(bu buVar) {
        k kVar;
        if (buVar.isShareThread) {
            kVar = new k();
            kVar.dLi = buVar;
        } else {
            kVar = new k();
            if (buVar.isLinkThread()) {
                kVar.isLinkThread = true;
            } else {
                kVar.isLinkThread = false;
                if (buVar.aSs()) {
                    kVar.gUO = true;
                } else {
                    kVar.gUO = false;
                }
            }
            kVar.dLi = buVar;
            kVar.gUP = true;
        }
        if (kVar != null) {
            kVar.bOR();
        }
        return kVar;
    }

    public static void a(com.baidu.tieba.card.data.c cVar) {
        if (cVar instanceof k) {
            ((k) cVar).dKS = true;
        } else if (cVar instanceof l) {
            ((l) cVar).dKS = true;
        } else if (cVar instanceof j) {
            ((j) cVar).dKS = true;
        }
        cVar.a(AbsThreadDataSupport.SupportType.TOP);
    }

    public static void b(com.baidu.tieba.card.data.c cVar) {
        ((k) cVar).gUR = true;
        cVar.a(AbsThreadDataSupport.SupportType.CONTENT);
    }

    public static void c(com.baidu.tieba.card.data.c cVar) {
        ((k) cVar).dKW = true;
        cVar.a(AbsThreadDataSupport.SupportType.CONTENT);
    }

    public static void d(com.baidu.tieba.card.data.c cVar) {
        ((k) cVar).dKX = true;
        cVar.a(AbsThreadDataSupport.SupportType.CONTENT);
    }

    public static void e(com.baidu.tieba.card.data.c cVar) {
        ((k) cVar).dKT = true;
        cVar.a(AbsThreadDataSupport.SupportType.CONTENT);
    }

    public static void f(com.baidu.tieba.card.data.c cVar) {
        ((l) cVar).gUZ = true;
        cVar.a(AbsThreadDataSupport.SupportType.CONTENT);
    }

    public static void g(com.baidu.tieba.card.data.c cVar) {
        if (cVar instanceof k) {
            ((k) cVar).gUS = true;
        } else if (cVar instanceof l) {
            ((l) cVar).gUS = true;
        } else if (cVar instanceof j) {
            ((j) cVar).gUS = true;
        }
        cVar.a(AbsThreadDataSupport.SupportType.EXTEND);
    }

    public static void h(com.baidu.tieba.card.data.c cVar) {
        if (cVar instanceof k) {
            ((k) cVar).gUQ = true;
        } else if (cVar instanceof l) {
            ((l) cVar).gUQ = true;
        }
        cVar.a(AbsThreadDataSupport.SupportType.TOP);
    }

    public static void i(com.baidu.tieba.card.data.c cVar) {
        if (cVar instanceof k) {
            ((k) cVar).dKZ = true;
        } else if (cVar instanceof l) {
            ((l) cVar).dKZ = true;
        } else if (cVar instanceof j) {
            ((j) cVar).dKZ = true;
        }
        cVar.a(AbsThreadDataSupport.SupportType.EXTEND);
    }

    public static void j(com.baidu.tieba.card.data.c cVar) {
        if (cVar instanceof k) {
            ((k) cVar).dKY = true;
        } else if (cVar instanceof l) {
            ((l) cVar).dKY = true;
        } else if (cVar instanceof j) {
            ((j) cVar).dKY = true;
        }
        cVar.a(AbsThreadDataSupport.SupportType.BOTTOM);
    }

    public static void k(com.baidu.tieba.card.data.c cVar) {
        if (cVar instanceof k) {
            ((k) cVar).dLe = true;
        } else if (cVar instanceof l) {
            ((l) cVar).dLe = true;
        }
        cVar.a(AbsThreadDataSupport.SupportType.EXTEND);
    }

    public static void l(com.baidu.tieba.card.data.c cVar) {
        if (cVar instanceof k) {
            ((k) cVar).dLg = true;
        } else if (cVar instanceof l) {
            ((l) cVar).dLg = true;
        } else if (cVar instanceof j) {
            ((j) cVar).dLg = true;
        }
        cVar.a(AbsThreadDataSupport.SupportType.EXTEND);
    }

    public static void m(com.baidu.tieba.card.data.c cVar) {
        if (cVar instanceof k) {
            ((k) cVar).dLh = true;
        } else if (cVar instanceof l) {
            ((l) cVar).dLh = true;
        } else if (cVar instanceof j) {
            ((j) cVar).dLh = true;
        }
        cVar.a(AbsThreadDataSupport.SupportType.EXTEND);
    }

    public static void f(DataRes.Builder builder) {
        if (builder != null) {
            int count = w.getCount(builder.thread_list);
            if (builder.banner_list != null && builder.banner_list.app != null) {
                BannerList.Builder builder2 = new BannerList.Builder(builder.banner_list);
                if (builder2.app != null) {
                    db(builder2.app);
                    for (int size = builder2.app.size() - 1; size >= 0; size--) {
                        App app = builder2.app.get(size);
                        com.baidu.tieba.homepage.personalize.data.a aVar = new com.baidu.tieba.homepage.personalize.data.a();
                        aVar.b(app);
                        int i = app != null ? com.baidu.adp.lib.f.b.toInt(app.pos_name, -1) : -1;
                        if (i < 0 || i > count + size) {
                            a(aVar.bOT(), 1, 2);
                            builder2.app.remove(size);
                        } else {
                            AdvertAppInfo bOT = aVar.bOT();
                            if (bOT == null) {
                                a(aVar.bOT(), 1, 100);
                                builder2.app.remove(size);
                            } else {
                                int aQi = bOT.aQi();
                                if (aQi != 0) {
                                    a(aVar.bOT(), 1, aQi);
                                    builder2.app.remove(size);
                                }
                            }
                        }
                    }
                    if (builder2.app.size() != builder.banner_list.app.size()) {
                        builder.banner_list = builder2.build(false);
                    }
                }
            }
        }
    }

    private static void db(List<App> list) {
        if (list != null && list.size() > 1) {
            int size = list.size() - 1;
            int i = size;
            int i2 = size - 1;
            while (i2 > 0) {
                int c = c(list.get(i));
                int c2 = c(list.get(i2));
                if (c <= 0 || c - c2 < 3) {
                    w.remove(list, i);
                }
                int i3 = i - 1;
                i = i3;
                i2 = i3 - 1;
            }
        }
    }

    private static int c(App app) {
        if (app == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(app.pos_name, -1);
    }

    public static void g(DataRes.Builder builder) {
        f(builder);
        if (builder != null && builder.card_forum != null && builder.card_topic != null && builder.resource_list != null && w.getCount(builder.thread_list) != 0) {
            int count = w.getCount(builder.thread_list);
            for (int size = builder.card_forum.size() - 1; size >= 0; size--) {
                if (builder.card_forum.get(size).position.longValue() > count) {
                    builder.card_forum.remove(size);
                }
            }
            for (int size2 = builder.card_topic.size() - 1; size2 >= 0; size2--) {
                if (builder.card_topic.get(size2).position.intValue() > count) {
                    builder.card_topic.remove(size2);
                }
            }
            for (int size3 = builder.resource_list.size() - 1; size3 >= 0; size3--) {
                if (builder.resource_list.get(size3).position.longValue() > count) {
                    builder.resource_list.remove(size3);
                }
            }
            for (int size4 = builder.card_god.size() - 1; size4 >= 0; size4--) {
                if (builder.card_god.get(size4).position.intValue() > count) {
                    builder.card_god.remove(size4);
                }
            }
        }
    }

    private static void a(AdvertAppInfo advertAppInfo, int i, int i2) {
        com.baidu.tieba.recapp.report.d.cZQ().a(g.b(advertAppInfo, 5, i, i2));
        if (advertAppInfo != null && advertAppInfo.dHb != null) {
            advertAppInfo.dHb.mDiscardReason = i2;
        }
    }

    private static void a(App app, int i, int i2) {
        com.baidu.tieba.homepage.personalize.data.a aVar = new com.baidu.tieba.homepage.personalize.data.a();
        aVar.b(app);
        a(aVar.bOT(), i, i2);
    }
}
