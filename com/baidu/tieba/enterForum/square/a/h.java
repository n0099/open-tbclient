package com.baidu.tieba.enterForum.square.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.a.d;
import com.baidu.tieba.card.a.h;
import com.baidu.tieba.card.a.i;
import com.baidu.tieba.card.a.k;
import com.baidu.tieba.card.a.l;
import com.baidu.tieba.card.a.m;
import com.baidu.tieba.n;
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
    private b aVL;
    private c aVM;
    private e aVN;
    private f aVO;
    private d aVP;
    private g aVQ;
    private BdTypeListView aVi;
    private final List<com.baidu.adp.widget.ListView.a> aVK = new ArrayList();
    private final ArrayList<u> YA = new ArrayList<>();

    public h(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, BdUniqueId bdUniqueId) {
        a(tbPageContext, bdTypeListView, bdUniqueId);
    }

    private void a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, BdUniqueId bdUniqueId) {
        this.aVL = new b(tbPageContext);
        this.aVM = new c(tbPageContext);
        this.aVN = new e(tbPageContext);
        this.aVO = new f(tbPageContext);
        this.aVP = new d(tbPageContext);
        this.aVQ = new g(tbPageContext);
        this.aVL.setTag(bdUniqueId);
        this.aVM.setTag(bdUniqueId);
        this.aVN.setTag(bdUniqueId);
        this.aVO.setTag(bdUniqueId);
        this.aVP.setTag(bdUniqueId);
        this.aVQ.setTag(bdUniqueId);
        this.aVK.add(this.aVL);
        this.aVK.add(this.aVM);
        this.aVK.add(this.aVN);
        this.aVK.add(this.aVO);
        this.aVK.add(this.aVP);
        this.aVK.add(this.aVQ);
        this.aVi = bdTypeListView;
        this.aVi.g(this.aVK);
    }

    public void b(DataRes dataRes) {
        if (dataRes != null) {
            this.YA.clear();
            a(dataRes.banner_info);
            R(dataRes.dir_info);
            S(dataRes.weekly_info);
            U(dataRes.recommend_forums);
            T(dataRes.recommend_classes);
            V(dataRes.new_top_info);
            if (this.aVi != null) {
                KN();
                this.aVi.setData(this.YA);
            }
        }
    }

    private void a(ForumSquareBanner forumSquareBanner) {
        if (forumSquareBanner != null && y.l(forumSquareBanner.infos) > 0) {
            com.baidu.tieba.card.a.d dVar = new com.baidu.tieba.card.a.d();
            dVar.an(forumSquareBanner.forum_counts.longValue());
            for (BannerBaseInfo bannerBaseInfo : forumSquareBanner.infos) {
                if (bannerBaseInfo != null) {
                    d.a aVar = new d.a();
                    aVar.title = bannerBaseInfo.title;
                    aVar.link = bannerBaseInfo.link;
                    aVar.tag = bannerBaseInfo.tag;
                    aVar.type = bannerBaseInfo.type.intValue();
                    aVar.url = bannerBaseInfo.image_url;
                    dVar.DS().add(aVar);
                }
            }
            if (y.l(dVar.DS()) > 0) {
                this.YA.add(dVar);
            }
        }
    }

    private void R(List<ForumSquareDirs> list) {
        if (y.l(list) > 0) {
            com.baidu.tieba.card.a.h hVar = new com.baidu.tieba.card.a.h();
            hVar.aPH = TbadkCoreApplication.m411getInst().getString(n.j.group_fourm_category_title);
            int i = 0;
            for (ForumSquareDirs forumSquareDirs : list) {
                if (forumSquareDirs != null) {
                    h.a aVar = new h.a();
                    aVar.id = forumSquareDirs.id.longValue();
                    aVar.url = forumSquareDirs.pic;
                    aVar.title = forumSquareDirs.title;
                    aVar.type = forumSquareDirs.type.intValue();
                    aVar.link = forumSquareDirs.link;
                    aVar.aPZ = forumSquareDirs.torder.intValue();
                    aVar.position = i;
                    hVar.DS().add(aVar);
                    i++;
                }
            }
            if (y.l(hVar.DS()) > 0) {
                this.YA.add(hVar);
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x006c: IGET  (r7v1 java.lang.Long A[REMOVE]) = (r0v8 tbclient.GetForumClassList.WeeklyInfo) tbclient.GetForumClassList.WeeklyInfo.forum_id java.lang.Long)] */
    private void S(List<WeeklyInfo> list) {
        if (y.l(list) > 0) {
            k kVar = new k();
            kVar.aPH = TbadkCoreApplication.m411getInst().getString(n.j.group_fourm_hot_title);
            int i = 1;
            for (WeeklyInfo weeklyInfo : list) {
                if (weeklyInfo != null && !TextUtils.isEmpty(weeklyInfo.forum_name) && weeklyInfo.forum_id.longValue() > 0 && !TextUtils.isEmpty(weeklyInfo.avatar)) {
                    com.baidu.tbadk.widget.a.g gVar = new com.baidu.tbadk.widget.a.g();
                    gVar.rank = i;
                    gVar.forumAvatar = weeklyInfo.avatar;
                    gVar.forumName = weeklyInfo.forum_name;
                    gVar.forumId = com.baidu.adp.lib.h.b.g(new StringBuilder().append(weeklyInfo.forum_id).toString(), -1);
                    gVar.isLiked = weeklyInfo.is_like.intValue() == 1;
                    kVar.a(gVar);
                    i++;
                }
            }
            if (y.l(kVar.DS()) > 0) {
                this.YA.add(kVar);
            }
        }
    }

    private void T(List<RecommendForumClass> list) {
        if (y.l(list) > 0) {
            i iVar = new i();
            iVar.aPH = TbadkCoreApplication.m411getInst().getString(n.j.group_fourm_good_title);
            int i = 0;
            for (RecommendForumClass recommendForumClass : list) {
                if (recommendForumClass != null && !TextUtils.isEmpty(recommendForumClass.recommend_title) && !TextUtils.isEmpty(recommendForumClass.recommend_image_url) && !TextUtils.isEmpty(recommendForumClass.link_url)) {
                    i.a aVar = new i.a();
                    aVar.id = recommendForumClass.forum_class_id.longValue();
                    aVar.title = recommendForumClass.recommend_title;
                    aVar.url = recommendForumClass.recommend_image_url;
                    aVar.link = recommendForumClass.link_url;
                    aVar.position = i;
                    iVar.a(aVar);
                    i++;
                }
            }
            if (y.l(iVar.DS()) > 0) {
                this.YA.add(iVar);
            }
        }
    }

    private void U(List<ForumSquareRecommendForumInfo> list) {
        if (y.l(list) > 0) {
            l lVar = new l();
            lVar.aPH = TbadkCoreApplication.m411getInst().getString(n.j.group_fourm_recommend_title);
            for (ForumSquareRecommendForumInfo forumSquareRecommendForumInfo : list) {
                if (forumSquareRecommendForumInfo != null && forumSquareRecommendForumInfo.forum_id.longValue() > 0 && !TextUtils.isEmpty(forumSquareRecommendForumInfo.forum_name) && !TextUtils.isEmpty(forumSquareRecommendForumInfo.avatar) && forumSquareRecommendForumInfo.member_count.longValue() >= 0 && forumSquareRecommendForumInfo.thread_count.longValue() >= 0) {
                    com.baidu.tieba.card.a.f fVar = new com.baidu.tieba.card.a.f();
                    fVar.aPR = forumSquareRecommendForumInfo.avatar;
                    fVar.mForumId = forumSquareRecommendForumInfo.forum_id.longValue();
                    fVar.mForumName = forumSquareRecommendForumInfo.forum_name;
                    fVar.aPV = forumSquareRecommendForumInfo._abstract;
                    fVar.aPS = forumSquareRecommendForumInfo.is_like.intValue();
                    fVar.aPT = forumSquareRecommendForumInfo.member_count.longValue();
                    fVar.aPU = forumSquareRecommendForumInfo.thread_count.longValue();
                    fVar.aPW = String.valueOf(TbadkCoreApplication.m411getInst().getString(n.j.attention_n)) + ax.w(forumSquareRecommendForumInfo.member_count.longValue());
                    fVar.aPX = String.valueOf(TbadkCoreApplication.m411getInst().getString(n.j.text_post)) + ax.w(forumSquareRecommendForumInfo.thread_count.longValue());
                    fVar.aPY = forumSquareRecommendForumInfo.recommend_reason;
                    lVar.DS().add(fVar);
                }
            }
            if (y.l(lVar.DS()) > 0) {
                this.YA.add(lVar);
            }
        }
    }

    private void V(List<ForumInfo> list) {
        if (y.l(list) > 0) {
            m mVar = new m();
            mVar.aPH = TbadkCoreApplication.m411getInst().getString(n.j.group_fourm_new_top_title);
            for (ForumInfo forumInfo : list) {
                if (forumInfo != null && forumInfo.forum_id.longValue() > 0 && !TextUtils.isEmpty(forumInfo.forum_name) && !TextUtils.isEmpty(forumInfo.avatar)) {
                    com.baidu.tieba.card.a.g gVar = new com.baidu.tieba.card.a.g();
                    gVar.aPR = forumInfo.avatar;
                    gVar.mId = forumInfo.forum_id.longValue();
                    gVar.mName = forumInfo.forum_name;
                    gVar.aPV = forumInfo._abstract;
                    gVar.aPS = forumInfo.is_like.intValue();
                    mVar.DS().add(gVar);
                }
            }
            if (y.l(mVar.DS()) > 0) {
                this.YA.add(mVar);
            }
        }
    }

    public void cK(int i) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
            if (aVar instanceof a) {
                ((a) aVar).cK(i);
            }
        }
    }

    public void KN() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
            if (aVar instanceof a) {
                ((a) aVar).aVr = true;
            }
        }
    }

    public void onDestroy() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
            if (aVar instanceof a) {
                ((a) aVar).onDestroy();
            }
        }
    }

    public void onPause() {
        if (this.aVL != null) {
            this.aVL.onPause();
        }
    }

    public void onResume() {
        if (this.aVL != null) {
            this.aVL.onStart();
        }
    }

    public List<u> getData() {
        return this.YA;
    }
}
