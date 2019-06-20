package com.baidu.tieba.homepage.personalize.model;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.data.p;
import com.baidu.tieba.homepage.personalize.data.f;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.App;
import tbclient.BannerList;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.CardGod;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.Resource;
/* loaded from: classes4.dex */
public class d {
    public static void a(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i, int i2) {
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
                builder.banner_list = a(z, builder.banner_list, builder2.banner_list, (builder.thread_list != null ? builder.thread_list.size() : 0) - i2, i2);
            }
            if (builder.age_sex == null) {
                builder.age_sex = builder2.age_sex;
                if (builder2.age_sex != null) {
                    com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("has_requested_new_user_guide", true);
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
                        int f = com.baidu.adp.lib.g.b.f(next.pos_name, -1);
                        if (f <= 0) {
                            it.remove();
                            a(next, 1, 23);
                        } else if (f <= i + i2 + 1) {
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
            int i3 = i2 + i;
            if (i3 <= 0) {
                return builder.build(false);
            }
            a(builder, i3);
            if (builder2.app != null) {
                builder.app.addAll(0, builder2.app);
            }
            return builder.build(false);
        }
        return bannerList;
    }

    private static BannerList a(boolean z, BannerList bannerList, BannerList bannerList2, int i, int i2) {
        if (i2 > 0) {
            BannerList.Builder builder = new BannerList.Builder(bannerList);
            if (bannerList2 == null || bannerList2.app == null) {
                return builder.build(false);
            }
            if (builder.app == null) {
                builder.app = new LinkedList();
            }
            h(i, builder.app);
            int size = i + builder.app.size();
            BannerList.Builder builder2 = new BannerList.Builder(bannerList2);
            if (builder2.app == null) {
                builder2.app = new LinkedList();
            }
            if (z) {
                a(builder2);
            }
            if (builder2.app != null) {
                Iterator<App> it = builder2.app.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    App next = it.next();
                    if (next != null) {
                        int f = com.baidu.adp.lib.g.b.f(next.pos_name, -1);
                        if (f <= 0) {
                            it.remove();
                            a(next, 1, 23);
                        } else if (f <= i2 + i3 + 1) {
                            i3++;
                        } else {
                            it.remove();
                            a(next, 1, 2);
                        }
                    } else {
                        it.remove();
                    }
                    i3 = i3;
                }
            }
            a(builder2, size);
            if (builder2.app != null) {
                builder.app.addAll(builder2.app);
            }
            return builder.build(false);
        }
        return bannerList;
    }

    private static void h(int i, List<App> list) {
        if (list != null) {
            int i2 = 0;
            Iterator<App> it = list.iterator();
            while (true) {
                int i3 = i2;
                if (it.hasNext()) {
                    App next = it.next();
                    if (next != null) {
                        int f = com.baidu.adp.lib.g.b.f(next.pos_name, -1);
                        if (f <= 0) {
                            it.remove();
                            a(next, 1, 23);
                        } else if (f <= i + i3 + 1) {
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
        if (builder != null && !v.aa(builder.app)) {
            for (int i = 0; i < builder.app.size(); i++) {
                App app = builder.app.get(i);
                if (app != null) {
                    App.Builder builder2 = new App.Builder(app);
                    builder2.pos = Integer.valueOf(com.baidu.adp.lib.g.b.f(app.pos_name, 0));
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
                    builder2.pos_name = String.valueOf(com.baidu.adp.lib.g.b.f(app.pos_name, 0) + i);
                    App build = builder2.build(false);
                    builder.app.remove(i2);
                    builder.app.add(i2, build);
                }
            }
        }
    }

    public static List<p> b(DataRes.Builder builder) {
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
                if (cardForum != null && com.baidu.tieba.homepage.personalize.data.b.tI(cardForum.card_type.intValue()) && dVar == null) {
                    dVar = new com.baidu.tieba.homepage.personalize.data.d();
                    dVar.a(cardForum);
                    if (dVar.aCA()) {
                        linkedList.add(dVar);
                    }
                }
                dVar = dVar;
            }
        }
        List<AppData> ceK = r.ceM().ceK();
        if (ceK != null) {
            ceK.clear();
        }
        if (builder.banner_list != null && builder.banner_list.app != null) {
            for (App app : builder.banner_list.app) {
                com.baidu.tieba.homepage.personalize.data.a aVar = new com.baidu.tieba.homepage.personalize.data.a();
                aVar.b(app);
                if (ceK != null && aVar.eAB != null) {
                    ceK.add(aVar.eAB.bEk);
                }
                AdvertAppInfo aYg = aVar.aYg();
                if (aYg == null) {
                    a(aVar.aYg(), 1, 100);
                } else {
                    int abE = aYg.abE();
                    if (abE != 0) {
                        a(aVar.aYg(), 1, abE);
                        if (abE != 28 && abE != 31) {
                            if (aYg.bEd != null) {
                                aYg.bEd.bEq = -1001;
                            }
                        }
                    }
                    if (aVar.getPosition() <= 0) {
                        a(aVar.aYg(), 1, 23);
                        if (aYg.bEd != null) {
                            aYg.bEd.bEq = -1001;
                        }
                    }
                    if (aYg.abF()) {
                        try {
                            if (TextUtils.isEmpty(aYg.bDX) || u.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), aYg.bDX)) {
                                if (TextUtils.isEmpty(aYg.bDX)) {
                                    a(aVar.aYg(), 1, 26);
                                } else {
                                    a(aVar.aYg(), 1, 3);
                                }
                            }
                        } catch (Exception e) {
                            a(aVar.aYg(), 1, 100);
                        }
                    }
                    linkedList.add(aVar);
                }
            }
        }
        r.ceM().ceL();
        if (v.Z(builder.card_god) != 0) {
            for (CardGod cardGod : builder.card_god) {
                f fVar = new f();
                fVar.a(cardGod);
                if (fVar.aCA()) {
                    linkedList.add(fVar);
                }
            }
        }
        return linkedList;
    }

    public static void c(DataRes.Builder builder) {
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

    public static com.baidu.tieba.card.data.c ao(bg bgVar) {
        if (bgVar == null) {
            return null;
        }
        if (bgVar.isShareThread) {
            k kVar = new k();
            kVar.threadData = bgVar;
            return kVar;
        } else if (j.V(bgVar)) {
            return new j(bgVar);
        } else {
            if (k.V(bgVar) || k.W(bgVar)) {
                k kVar2 = new k();
                if (bgVar.isLinkThread()) {
                    kVar2.isLinkThread = true;
                } else if (bgVar.aeq()) {
                    kVar2.bIf = true;
                } else {
                    kVar2.isLinkThread = false;
                    if (bgVar.ady()) {
                        kVar2.eBg = true;
                    } else {
                        kVar2.eBg = false;
                    }
                }
                kVar2.threadData = bgVar;
                kVar2.eBh = true;
                return kVar2;
            } else if (l.V(bgVar)) {
                return new l(bgVar);
            } else {
                return null;
            }
        }
    }

    public static k ap(bg bgVar) {
        if (bgVar.isShareThread) {
            k kVar = new k();
            kVar.threadData = bgVar;
            return kVar;
        }
        k kVar2 = new k();
        if (bgVar.isLinkThread()) {
            kVar2.isLinkThread = true;
        } else {
            kVar2.isLinkThread = false;
            if (bgVar.ady()) {
                kVar2.eBg = true;
            } else {
                kVar2.eBg = false;
            }
        }
        kVar2.threadData = bgVar;
        kVar2.eBh = true;
        return kVar2;
    }

    public static void a(com.baidu.tieba.card.data.c cVar) {
        if (cVar instanceof k) {
            ((k) cVar).bHW = true;
        } else if (cVar instanceof l) {
            ((l) cVar).bHW = true;
        } else if (cVar instanceof j) {
            ((j) cVar).bHW = true;
        }
    }

    public static void b(com.baidu.tieba.card.data.c cVar) {
        ((k) cVar).eBi = true;
    }

    public static void c(com.baidu.tieba.card.data.c cVar) {
        ((k) cVar).bIa = true;
    }

    public static void d(com.baidu.tieba.card.data.c cVar) {
        ((k) cVar).bHX = true;
    }

    public static void e(com.baidu.tieba.card.data.c cVar) {
        ((l) cVar).eBs = true;
    }

    public static void f(com.baidu.tieba.card.data.c cVar) {
        if (cVar instanceof k) {
            ((k) cVar).eBj = true;
        } else if (cVar instanceof l) {
            ((l) cVar).eBj = true;
        } else if (cVar instanceof j) {
            ((j) cVar).eBj = true;
        }
    }

    public static void g(com.baidu.tieba.card.data.c cVar) {
        if (cVar instanceof k) {
            ((k) cVar).bIc = true;
        } else if (cVar instanceof l) {
            ((l) cVar).bIc = true;
        } else if (cVar instanceof j) {
            ((j) cVar).bIc = true;
        }
    }

    public static void h(com.baidu.tieba.card.data.c cVar) {
        if (cVar instanceof k) {
            ((k) cVar).bIb = true;
        } else if (cVar instanceof l) {
            ((l) cVar).bIb = true;
        } else if (cVar instanceof j) {
            ((j) cVar).bIb = true;
        }
    }

    public static void d(DataRes.Builder builder) {
        if (builder != null) {
            int Z = v.Z(builder.thread_list);
            if (builder.banner_list != null && builder.banner_list.app != null) {
                BannerList.Builder builder2 = new BannerList.Builder(builder.banner_list);
                if (builder2.app != null) {
                    cH(builder2.app);
                    for (int size = builder2.app.size() - 1; size >= 0; size--) {
                        App app = builder2.app.get(size);
                        com.baidu.tieba.homepage.personalize.data.a aVar = new com.baidu.tieba.homepage.personalize.data.a();
                        aVar.b(app);
                        int f = app != null ? com.baidu.adp.lib.g.b.f(app.pos_name, -1) : -1;
                        if (f < 0 || f > Z + size) {
                            a(aVar.aYg(), 1, 2);
                            builder2.app.remove(size);
                        } else {
                            AdvertAppInfo aYg = aVar.aYg();
                            if (aYg == null) {
                                a(aVar.aYg(), 1, 100);
                                builder2.app.remove(size);
                            } else {
                                int abE = aYg.abE();
                                if (abE != 0) {
                                    a(aVar.aYg(), 1, abE);
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

    private static void cH(List<App> list) {
        if (list != null && list.size() > 1) {
            int size = list.size() - 1;
            int i = size;
            int i2 = size - 1;
            while (i2 > 0) {
                int c = c(list.get(i));
                int c2 = c(list.get(i2));
                if (c <= 0 || c - c2 < 3) {
                    v.d(list, i);
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
        return com.baidu.adp.lib.g.b.f(app.pos_name, -1);
    }

    public static void e(DataRes.Builder builder) {
        d(builder);
        if (builder != null && builder.card_forum != null && builder.card_topic != null && builder.resource_list != null && v.Z(builder.thread_list) != 0) {
            int Z = v.Z(builder.thread_list);
            for (int size = builder.card_forum.size() - 1; size >= 0; size--) {
                if (builder.card_forum.get(size).position.longValue() > Z) {
                    builder.card_forum.remove(size);
                }
            }
            for (int size2 = builder.card_topic.size() - 1; size2 >= 0; size2--) {
                if (builder.card_topic.get(size2).position.intValue() > Z) {
                    builder.card_topic.remove(size2);
                }
            }
            for (int size3 = builder.resource_list.size() - 1; size3 >= 0; size3--) {
                if (builder.resource_list.get(size3).position.longValue() > Z) {
                    builder.resource_list.remove(size3);
                }
            }
            for (int size4 = builder.card_god.size() - 1; size4 >= 0; size4--) {
                if (builder.card_god.get(size4).position.intValue() > Z) {
                    builder.card_god.remove(size4);
                }
            }
        }
    }

    private static void a(AdvertAppInfo advertAppInfo, int i, int i2) {
        com.baidu.tieba.recapp.report.c.cfH().a(com.baidu.tieba.recapp.report.f.b(advertAppInfo, 5, i, i2));
        if (advertAppInfo != null && advertAppInfo.bEk != null) {
            advertAppInfo.bEk.mDiscardReason = i2;
        }
    }

    private static void a(App app, int i, int i2) {
        com.baidu.tieba.homepage.personalize.data.a aVar = new com.baidu.tieba.homepage.personalize.data.a();
        aVar.b(app);
        a(aVar.aYg(), i, i2);
    }
}
