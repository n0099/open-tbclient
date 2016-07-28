package com.baidu.tieba.homepage.personalize.b;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.a.m;
import com.baidu.tieba.card.a.n;
import com.baidu.tieba.card.a.o;
import com.baidu.tieba.card.a.s;
import com.baidu.tieba.tbadkCore.al;
import java.util.LinkedList;
import java.util.List;
import tbclient.App;
import tbclient.BannerList;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.CardGod;
import tbclient.Personalized.CardTopic;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class e {
    public static void c(DataRes.Builder builder) {
        if (builder != null) {
            y.r(builder.resource_list);
            y.r(builder.card_forum);
            y.r(builder.card_topic);
            if (builder.banner_list != null) {
                BannerList.Builder builder2 = new BannerList.Builder(builder.banner_list);
                y.r(builder2.app);
                builder.banner_list = builder2.build(false);
            }
            y.r(builder.card_god);
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
                    com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("has_requested_new_user_guide", true);
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

    public static List<s> d(DataRes.Builder builder) {
        com.baidu.tbadk.core.data.b Lr;
        com.baidu.tieba.homepage.personalize.data.c bVar;
        if (builder == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        if (builder.card_topic != null) {
            for (CardTopic cardTopic : builder.card_topic) {
                com.baidu.tieba.homepage.personalize.data.d dVar = new com.baidu.tieba.homepage.personalize.data.d();
                dVar.a(cardTopic);
                if (y.s(dVar.aWI) > 3) {
                    linkedList.add(dVar);
                }
            }
        }
        if (builder.resource_list != null) {
            for (Resource resource : builder.resource_list) {
                com.baidu.tieba.homepage.personalize.data.e eVar = new com.baidu.tieba.homepage.personalize.data.e();
                eVar.a(resource);
                linkedList.add(eVar);
            }
        }
        if (builder.card_forum != null) {
            for (CardForum cardForum : builder.card_forum) {
                if (cardForum != null) {
                    if (com.baidu.tieba.homepage.personalize.data.c.jB(cardForum.card_type.intValue())) {
                        bVar = new com.baidu.tieba.homepage.personalize.data.f();
                    } else {
                        bVar = com.baidu.tieba.homepage.personalize.data.c.jC(cardForum.card_type.intValue()) ? new com.baidu.tieba.homepage.personalize.data.b() : null;
                    }
                    if (bVar != null) {
                        bVar.a(cardForum);
                        if (bVar.ok()) {
                            linkedList.add(bVar);
                        }
                    }
                }
            }
        }
        if (builder.banner_list != null && builder.banner_list.app != null) {
            for (App app : builder.banner_list.app) {
                com.baidu.tieba.homepage.personalize.data.a aVar = new com.baidu.tieba.homepage.personalize.data.a();
                aVar.b(app);
                if (aVar.getPosition() > 0 && (Lr = aVar.Lr()) != null) {
                    if (Lr.ol()) {
                        try {
                            if (!TextUtils.isEmpty(Lr.MK) && !al.isInstalledPackage(TbadkCoreApplication.m10getInst().getContext(), Lr.MK)) {
                            }
                        } catch (Exception e) {
                        }
                    }
                    if (Lr.ok()) {
                        linkedList.add(aVar);
                    }
                }
            }
        }
        if (y.s(builder.card_god) != 0) {
            for (CardGod cardGod : builder.card_god) {
                com.baidu.tieba.homepage.personalize.data.g gVar = new com.baidu.tieba.homepage.personalize.data.g();
                gVar.a(cardGod);
                if (gVar.ok()) {
                    linkedList.add(gVar);
                }
            }
        }
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

    public static com.baidu.tieba.card.a.c q(be beVar) {
        if (n.c(beVar)) {
            return new n(beVar);
        }
        if (o.c(beVar)) {
            return new o(beVar);
        }
        if (m.c(beVar)) {
            m mVar = new m();
            if (beVar.qy()) {
                mVar.aWr = true;
            } else {
                mVar.aWr = false;
            }
            mVar.threadData = beVar;
            return mVar;
        }
        return null;
    }

    public static void f(DataRes.Builder builder) {
        if (builder != null && builder.card_forum != null && builder.card_topic != null && builder.resource_list != null && y.s(builder.thread_list) != 0) {
            int s = y.s(builder.thread_list);
            for (int size = builder.card_forum.size() - 1; size >= 0; size--) {
                if (builder.card_forum.get(size).position.longValue() > s) {
                    builder.card_forum.remove(size);
                }
            }
            for (int size2 = builder.card_topic.size() - 1; size2 >= 0; size2--) {
                if (builder.card_topic.get(size2).position.intValue() > s) {
                    builder.card_topic.remove(size2);
                }
            }
            for (int size3 = builder.resource_list.size() - 1; size3 >= 0; size3--) {
                if (builder.resource_list.get(size3).position.longValue() > s) {
                    builder.resource_list.remove(size3);
                }
            }
            for (int size4 = builder.card_god.size() - 1; size4 >= 0; size4--) {
                if (builder.card_god.get(size4).position.intValue() > s) {
                    builder.card_god.remove(size4);
                }
            }
            if (builder.banner_list != null && builder.banner_list.app != null) {
                BannerList.Builder builder2 = new BannerList.Builder(builder.banner_list);
                if (builder2.app != null) {
                    for (int size5 = builder2.app.size() - 1; size5 >= 0; size5--) {
                        App app = builder2.app.get(size5);
                        int g = app != null ? com.baidu.adp.lib.h.b.g(app.pos_name, -1) : -1;
                        if (g < 0 || g > s) {
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
}
