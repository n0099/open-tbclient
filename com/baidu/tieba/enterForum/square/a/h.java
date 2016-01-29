package com.baidu.tieba.enterForum.square.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.a.e;
import com.baidu.tieba.card.a.k;
import com.baidu.tieba.card.a.l;
import com.baidu.tieba.card.a.n;
import com.baidu.tieba.card.a.o;
import com.baidu.tieba.card.a.p;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetForumClassList.BannerBaseInfo;
import tbclient.GetForumClassList.DataRes;
import tbclient.GetForumClassList.ForumInfo;
import tbclient.GetForumClassList.ForumSquareBanner;
import tbclient.GetForumClassList.ForumSquareDirs;
import tbclient.GetForumClassList.ForumSquareRecommendForumInfo;
import tbclient.GetForumClassList.RecommendForumClass;
import tbclient.GetForumClassList.WeeklyInfo;
/* loaded from: classes.dex */
public class h {
    private b aXY;
    private c aXZ;
    private BdTypeListView aXu;
    private e aYa;
    private f aYb;
    private d aYc;
    private g aYd;
    private final List<com.baidu.adp.widget.ListView.a> aXX = new ArrayList();
    private final ArrayList<u> YX = new ArrayList<>();

    public h(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, BdUniqueId bdUniqueId) {
        a(tbPageContext, bdTypeListView, bdUniqueId);
    }

    private void a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, BdUniqueId bdUniqueId) {
        this.aXY = new b(tbPageContext);
        this.aXZ = new c(tbPageContext);
        this.aYa = new e(tbPageContext);
        this.aYb = new f(tbPageContext);
        this.aYc = new d(tbPageContext);
        this.aYd = new g(tbPageContext);
        this.aXY.setTag(bdUniqueId);
        this.aXZ.setTag(bdUniqueId);
        this.aYa.setTag(bdUniqueId);
        this.aYb.setTag(bdUniqueId);
        this.aYc.setTag(bdUniqueId);
        this.aYd.setTag(bdUniqueId);
        this.aXX.add(this.aXY);
        this.aXX.add(this.aXZ);
        this.aXX.add(this.aYa);
        this.aXX.add(this.aYb);
        this.aXX.add(this.aYc);
        this.aXX.add(this.aYd);
        this.aXu = bdTypeListView;
        this.aXu.g(this.aXX);
    }

    public void b(DataRes dataRes) {
        if (dataRes != null) {
            this.YX.clear();
            a(dataRes.banner_info);
            O(dataRes.dir_info);
            P(dataRes.weekly_info);
            R(dataRes.recommend_forums);
            Q(dataRes.recommend_classes);
            S(dataRes.new_top_info);
            if (this.aXu != null) {
                ME();
                this.aXu.setData(this.YX);
            }
        }
    }

    private void a(ForumSquareBanner forumSquareBanner) {
        if (forumSquareBanner != null && x.o(forumSquareBanner.infos) > 0) {
            com.baidu.tieba.card.a.e eVar = new com.baidu.tieba.card.a.e();
            eVar.aq(forumSquareBanner.forum_counts.longValue());
            for (BannerBaseInfo bannerBaseInfo : forumSquareBanner.infos) {
                if (bannerBaseInfo != null) {
                    e.a aVar = new e.a();
                    aVar.title = bannerBaseInfo.title;
                    aVar.link = bannerBaseInfo.link;
                    aVar.tag = bannerBaseInfo.tag;
                    aVar.type = bannerBaseInfo.type.intValue();
                    aVar.url = bannerBaseInfo.image_url;
                    eVar.Fm().add(aVar);
                }
            }
            if (x.o(eVar.Fm()) > 0) {
                this.YX.add(eVar);
            }
        }
    }

    private void O(List<ForumSquareDirs> list) {
        if (x.o(list) > 0) {
            k kVar = new k();
            kVar.aRF = TbadkCoreApplication.m411getInst().getString(t.j.group_fourm_category_title);
            int i = 0;
            for (ForumSquareDirs forumSquareDirs : list) {
                if (forumSquareDirs != null) {
                    k.a aVar = new k.a();
                    aVar.id = forumSquareDirs.id.longValue();
                    aVar.url = forumSquareDirs.pic;
                    aVar.title = forumSquareDirs.title;
                    aVar.type = forumSquareDirs.type.intValue();
                    aVar.link = forumSquareDirs.link;
                    aVar.aSe = forumSquareDirs.torder.intValue();
                    aVar.position = i;
                    kVar.Fm().add(aVar);
                    i++;
                }
            }
            if (x.o(kVar.Fm()) > 0) {
                this.YX.add(kVar);
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x006c: IGET  (r7v1 java.lang.Long A[REMOVE]) = (r0v8 tbclient.GetForumClassList.WeeklyInfo) tbclient.GetForumClassList.WeeklyInfo.forum_id java.lang.Long)] */
    private void P(List<WeeklyInfo> list) {
        if (x.o(list) > 0) {
            n nVar = new n();
            nVar.aRF = TbadkCoreApplication.m411getInst().getString(t.j.group_fourm_hot_title);
            int i = 1;
            for (WeeklyInfo weeklyInfo : list) {
                if (weeklyInfo != null && !TextUtils.isEmpty(weeklyInfo.forum_name) && weeklyInfo.forum_id.longValue() > 0 && !TextUtils.isEmpty(weeklyInfo.avatar)) {
                    com.baidu.tbadk.widget.a.g gVar = new com.baidu.tbadk.widget.a.g();
                    gVar.rank = i;
                    gVar.forumAvatar = weeklyInfo.avatar;
                    gVar.forumName = weeklyInfo.forum_name;
                    gVar.forumId = com.baidu.adp.lib.h.b.g(new StringBuilder().append(weeklyInfo.forum_id).toString(), -1);
                    gVar.isLiked = weeklyInfo.is_like.intValue() == 1;
                    nVar.a(gVar);
                    i++;
                }
            }
            if (x.o(nVar.Fm()) > 0) {
                this.YX.add(nVar);
            }
        }
    }

    private void Q(List<RecommendForumClass> list) {
        if (x.o(list) > 0) {
            l lVar = new l();
            lVar.aRF = TbadkCoreApplication.m411getInst().getString(t.j.group_fourm_good_title);
            int i = 0;
            for (RecommendForumClass recommendForumClass : list) {
                if (recommendForumClass != null && !TextUtils.isEmpty(recommendForumClass.recommend_title) && !TextUtils.isEmpty(recommendForumClass.recommend_image_url) && !TextUtils.isEmpty(recommendForumClass.link_url)) {
                    l.a aVar = new l.a();
                    aVar.id = recommendForumClass.forum_class_id.longValue();
                    aVar.title = recommendForumClass.recommend_title;
                    aVar.url = recommendForumClass.recommend_image_url;
                    aVar.link = recommendForumClass.link_url;
                    aVar.position = i;
                    lVar.a(aVar);
                    i++;
                }
            }
            if (x.o(lVar.Fm()) > 0) {
                this.YX.add(lVar);
            }
        }
    }

    private void R(List<ForumSquareRecommendForumInfo> list) {
        if (x.o(list) > 0) {
            o oVar = new o();
            oVar.aRF = TbadkCoreApplication.m411getInst().getString(t.j.group_fourm_recommend_title);
            for (ForumSquareRecommendForumInfo forumSquareRecommendForumInfo : list) {
                if (forumSquareRecommendForumInfo != null && forumSquareRecommendForumInfo.forum_id.longValue() > 0 && !TextUtils.isEmpty(forumSquareRecommendForumInfo.forum_name) && !TextUtils.isEmpty(forumSquareRecommendForumInfo.avatar) && forumSquareRecommendForumInfo.member_count.longValue() >= 0 && forumSquareRecommendForumInfo.thread_count.longValue() >= 0) {
                    com.baidu.tieba.card.a.g gVar = new com.baidu.tieba.card.a.g();
                    gVar.aRU = forumSquareRecommendForumInfo.avatar;
                    gVar.mForumId = forumSquareRecommendForumInfo.forum_id.longValue();
                    gVar.mForumName = forumSquareRecommendForumInfo.forum_name;
                    gVar.aRY = forumSquareRecommendForumInfo._abstract;
                    gVar.aRV = forumSquareRecommendForumInfo.is_like.intValue();
                    gVar.aRW = forumSquareRecommendForumInfo.member_count.longValue();
                    gVar.aRX = forumSquareRecommendForumInfo.thread_count.longValue();
                    gVar.aRZ = String.valueOf(TbadkCoreApplication.m411getInst().getString(t.j.attention_n)) + aw.x(forumSquareRecommendForumInfo.member_count.longValue());
                    gVar.aSa = String.valueOf(TbadkCoreApplication.m411getInst().getString(t.j.text_post)) + aw.x(forumSquareRecommendForumInfo.thread_count.longValue());
                    gVar.aSb = forumSquareRecommendForumInfo.recommend_reason;
                    oVar.Fm().add(gVar);
                }
            }
            if (x.o(oVar.Fm()) > 0) {
                this.YX.add(oVar);
            }
        }
    }

    private void S(List<ForumInfo> list) {
        if (x.o(list) > 0) {
            p pVar = new p();
            pVar.aRF = TbadkCoreApplication.m411getInst().getString(t.j.group_fourm_new_top_title);
            for (ForumInfo forumInfo : list) {
                if (forumInfo != null && forumInfo.forum_id.longValue() > 0 && !TextUtils.isEmpty(forumInfo.forum_name) && !TextUtils.isEmpty(forumInfo.avatar)) {
                    com.baidu.tieba.card.a.h hVar = new com.baidu.tieba.card.a.h();
                    hVar.aRU = forumInfo.avatar;
                    hVar.mId = forumInfo.forum_id.longValue();
                    hVar.mName = forumInfo.forum_name;
                    hVar.aRY = forumInfo._abstract;
                    hVar.aRV = forumInfo.is_like.intValue();
                    pVar.Fm().add(hVar);
                }
            }
            if (x.o(pVar.Fm()) > 0) {
                this.YX.add(pVar);
            }
        }
    }

    public void db(int i) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aXX) {
            if (aVar instanceof a) {
                ((a) aVar).db(i);
            }
        }
    }

    public void ME() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aXX) {
            if (aVar instanceof a) {
                ((a) aVar).aXE = true;
            }
        }
    }

    public void onDestroy() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aXX) {
            if (aVar instanceof a) {
                ((a) aVar).onDestroy();
            }
        }
    }

    public void onPause() {
        if (this.aXY != null) {
            this.aXY.onPause();
        }
    }

    public void onResume() {
        if (this.aXY != null) {
            this.aXY.onStart();
        }
    }

    public List<u> getData() {
        return this.YX;
    }
}
