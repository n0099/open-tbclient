package com.baidu.tieba.homepage.personalize.model;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.m;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.card.data.o;
import com.baidu.tieba.card.data.p;
import com.baidu.tieba.card.data.t;
import com.baidu.tieba.tbadkCore.ae;
import java.util.LinkedList;
import java.util.List;
import tbclient.App;
import tbclient.BannerList;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.CardGod;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class e {
    public static void d(DataRes.Builder builder) {
        if (builder != null) {
            x.o(builder.resource_list);
            x.o(builder.card_forum);
            x.o(builder.card_topic);
            if (builder.banner_list != null) {
                BannerList.Builder builder2 = new BannerList.Builder(builder.banner_list);
                x.o(builder2.app);
                builder.banner_list = builder2.build(false);
            }
            x.o(builder.card_god);
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
                    com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("has_requested_new_user_guide", true);
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

    public static List<t> e(DataRes.Builder builder) {
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
                if (cardForum != null && com.baidu.tieba.homepage.personalize.data.b.ka(cardForum.card_type.intValue()) && dVar == null) {
                    dVar = new com.baidu.tieba.homepage.personalize.data.d();
                    dVar.a(cardForum);
                    if (dVar.pO()) {
                        linkedList.add(dVar);
                    }
                }
            }
        }
        if (builder.banner_list != null && builder.banner_list.app != null) {
            for (App app : builder.banner_list.app) {
                com.baidu.tieba.homepage.personalize.data.a aVar = new com.baidu.tieba.homepage.personalize.data.a();
                aVar.b(app);
                if (aVar.getPosition() <= 0) {
                    a(aVar.Uk(), 1, 100);
                } else {
                    AdvertAppInfo Uk = aVar.Uk();
                    if (Uk == null) {
                        a(aVar.Uk(), 1, 100);
                    } else {
                        if (Uk.pP()) {
                            try {
                                if (TextUtils.isEmpty(Uk.TY) || ae.isInstalledPackage(TbadkCoreApplication.m9getInst().getContext(), Uk.TY)) {
                                    if (TextUtils.isEmpty(Uk.TY)) {
                                        a(aVar.Uk(), 1, 100);
                                    } else {
                                        a(aVar.Uk(), 1, 3);
                                    }
                                }
                            } catch (Exception e) {
                                a(aVar.Uk(), 1, 100);
                            }
                        }
                        if (Uk.pO()) {
                            linkedList.add(aVar);
                        } else {
                            a(aVar.Uk(), 1, 100);
                        }
                    }
                }
            }
        }
        if (x.p(builder.card_god) != 0) {
            for (CardGod cardGod : builder.card_god) {
                com.baidu.tieba.homepage.personalize.data.e eVar = new com.baidu.tieba.homepage.personalize.data.e();
                eVar.a(cardGod);
                if (eVar.pO()) {
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

    public static com.baidu.tieba.card.data.c B(bi biVar) {
        if (m.n(biVar)) {
            return new m(biVar);
        }
        if (o.n(biVar)) {
            return new o(biVar);
        }
        if (p.n(biVar)) {
            return new p(biVar);
        }
        if (n.n(biVar)) {
            n nVar = new n();
            if (biVar.sr()) {
                nVar.bxy = true;
            } else {
                nVar.bxy = false;
            }
            nVar.threadData = biVar;
            return nVar;
        }
        return null;
    }

    public static void g(DataRes.Builder builder) {
        if (builder != null && builder.card_forum != null && builder.card_topic != null && builder.resource_list != null && x.p(builder.thread_list) != 0) {
            int p = x.p(builder.thread_list);
            for (int size = builder.card_forum.size() - 1; size >= 0; size--) {
                if (builder.card_forum.get(size).position.longValue() > p) {
                    builder.card_forum.remove(size);
                }
            }
            for (int size2 = builder.card_topic.size() - 1; size2 >= 0; size2--) {
                if (builder.card_topic.get(size2).position.intValue() > p) {
                    builder.card_topic.remove(size2);
                }
            }
            for (int size3 = builder.resource_list.size() - 1; size3 >= 0; size3--) {
                if (builder.resource_list.get(size3).position.longValue() > p) {
                    builder.resource_list.remove(size3);
                }
            }
            for (int size4 = builder.card_god.size() - 1; size4 >= 0; size4--) {
                if (builder.card_god.get(size4).position.intValue() > p) {
                    builder.card_god.remove(size4);
                }
            }
            if (builder.banner_list != null && builder.banner_list.app != null) {
                BannerList.Builder builder2 = new BannerList.Builder(builder.banner_list);
                if (builder2.app != null) {
                    for (int size5 = builder2.app.size() - 1; size5 >= 0; size5--) {
                        App app = builder2.app.get(size5);
                        int g = app != null ? com.baidu.adp.lib.g.b.g(app.pos_name, -1) : -1;
                        if (g < 0 || g > p) {
                            com.baidu.tieba.homepage.personalize.data.a aVar = new com.baidu.tieba.homepage.personalize.data.a();
                            aVar.b(app);
                            a(aVar.Uk(), 1, 2);
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
        com.baidu.tieba.recapp.report.b.bbA().a(com.baidu.tieba.recapp.report.e.a(advertAppInfo, 5, i, i2));
    }
}
