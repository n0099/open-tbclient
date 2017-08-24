package com.baidu.tieba.homepage.personalize.model;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.data.m;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.card.data.r;
import com.baidu.tieba.tbadkCore.s;
import java.util.LinkedList;
import java.util.List;
import tbclient.App;
import tbclient.BannerList;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.CardGod;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class d {
    public static void d(DataRes.Builder builder) {
        if (builder != null) {
            u.t(builder.resource_list);
            u.t(builder.card_forum);
            u.t(builder.card_topic);
            if (builder.banner_list != null) {
                BannerList.Builder builder2 = new BannerList.Builder(builder.banner_list);
                u.t(builder2.app);
                builder.banner_list = builder2.build(false);
            }
            u.t(builder.card_god);
        }
    }

    public static void a(DataRes.Builder builder, DataRes.Builder builder2) {
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
            if (builder2.banner_list != null) {
                BannerList.Builder builder3 = new BannerList.Builder(builder.banner_list);
                if (builder3.app == null) {
                    builder3.app = new LinkedList();
                }
                if (builder2.banner_list.app != null) {
                    builder3.app.addAll(builder2.banner_list.app);
                }
                builder.banner_list = builder3.build(false);
            }
            if (builder.age_sex == null) {
                builder.age_sex = builder2.age_sex;
                if (builder2.age_sex != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_requested_new_user_guide", true);
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

    public static List<r> e(DataRes.Builder builder) {
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
                if (cardForum != null && com.baidu.tieba.homepage.personalize.data.b.kT(cardForum.card_type.intValue()) && dVar == null) {
                    dVar = new com.baidu.tieba.homepage.personalize.data.d();
                    dVar.a(cardForum);
                    if (dVar.LO()) {
                        linkedList.add(dVar);
                    }
                }
                dVar = dVar;
            }
        }
        if (builder.banner_list != null && builder.banner_list.app != null) {
            for (App app : builder.banner_list.app) {
                com.baidu.tieba.homepage.personalize.data.a aVar = new com.baidu.tieba.homepage.personalize.data.a();
                aVar.b(app);
                AdvertAppInfo Xe = aVar.Xe();
                if (Xe == null) {
                    a(aVar.Xe(), 1, 100);
                } else {
                    int py = Xe.py();
                    if (py != 0) {
                        a(aVar.Xe(), 1, py);
                        if (py != 28 && py != 31) {
                            if (Xe.UW != null) {
                                Xe.UW.Vi = TbErrInfo.ERR_IMG_GET_REMOTE;
                            }
                        }
                    }
                    if (aVar.getPosition() <= 0) {
                        a(aVar.Xe(), 1, 23);
                        if (Xe.UW != null) {
                            Xe.UW.Vi = TbErrInfo.ERR_IMG_GET_REMOTE;
                        }
                    }
                    if (Xe.pz()) {
                        try {
                            if (TextUtils.isEmpty(Xe.UQ) || s.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), Xe.UQ)) {
                                if (TextUtils.isEmpty(Xe.UQ)) {
                                    a(aVar.Xe(), 1, 26);
                                } else {
                                    a(aVar.Xe(), 1, 3);
                                }
                            }
                        } catch (Exception e) {
                            a(aVar.Xe(), 1, 100);
                        }
                    }
                    linkedList.add(aVar);
                }
            }
        }
        if (u.u(builder.card_god) != 0) {
            for (CardGod cardGod : builder.card_god) {
                com.baidu.tieba.homepage.personalize.data.e eVar = new com.baidu.tieba.homepage.personalize.data.e();
                eVar.a(cardGod);
                if (eVar.LO()) {
                    linkedList.add(eVar);
                }
            }
        }
        return linkedList;
    }

    public static void f(DataRes.Builder builder) {
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

    public static com.baidu.tieba.card.data.c S(bl blVar) {
        if (k.B(blVar)) {
            return new k(blVar);
        }
        if (m.B(blVar)) {
            return new m(blVar);
        }
        if (n.B(blVar)) {
            return new n(blVar);
        }
        if (l.B(blVar)) {
            l lVar = new l();
            if (blVar.isLinkThread()) {
                lVar.isLinkThread = true;
            } else {
                lVar.isLinkThread = false;
                if (blVar.rJ()) {
                    lVar.bKr = true;
                } else {
                    lVar.bKr = false;
                }
            }
            lVar.threadData = blVar;
            return lVar;
        }
        return null;
    }

    public static void g(DataRes.Builder builder) {
        if (builder != null && builder.card_forum != null && builder.card_topic != null && builder.resource_list != null && u.u(builder.thread_list) != 0) {
            int u = u.u(builder.thread_list);
            for (int size = builder.card_forum.size() - 1; size >= 0; size--) {
                if (builder.card_forum.get(size).position.longValue() > u) {
                    builder.card_forum.remove(size);
                }
            }
            for (int size2 = builder.card_topic.size() - 1; size2 >= 0; size2--) {
                if (builder.card_topic.get(size2).position.intValue() > u) {
                    builder.card_topic.remove(size2);
                }
            }
            for (int size3 = builder.resource_list.size() - 1; size3 >= 0; size3--) {
                if (builder.resource_list.get(size3).position.longValue() > u) {
                    builder.resource_list.remove(size3);
                }
            }
            for (int size4 = builder.card_god.size() - 1; size4 >= 0; size4--) {
                if (builder.card_god.get(size4).position.intValue() > u) {
                    builder.card_god.remove(size4);
                }
            }
            if (builder.banner_list != null && builder.banner_list.app != null) {
                BannerList.Builder builder2 = new BannerList.Builder(builder.banner_list);
                if (builder2.app != null) {
                    for (int size5 = builder2.app.size() - 1; size5 >= 0; size5--) {
                        App app = builder2.app.get(size5);
                        int g = app != null ? com.baidu.adp.lib.g.b.g(app.pos_name, -1) : -1;
                        if (g < 0 || g > u) {
                            com.baidu.tieba.homepage.personalize.data.a aVar = new com.baidu.tieba.homepage.personalize.data.a();
                            aVar.b(app);
                            a(aVar.Xe(), 1, 2);
                            builder2.app.remove(size5);
                        }
                    }
                    if (builder2.app.size() != builder.banner_list.app.size()) {
                        builder.banner_list = builder2.build(false);
                    }
                }
            }
        }
    }

    private static void a(AdvertAppInfo advertAppInfo, int i, int i2) {
        com.baidu.tieba.recapp.report.b.biO().a(com.baidu.tieba.recapp.report.d.a(advertAppInfo, 5, i, i2));
    }
}
