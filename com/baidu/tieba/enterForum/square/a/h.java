package com.baidu.tieba.enterForum.square.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.a.e;
import com.baidu.tieba.card.a.l;
import com.baidu.tieba.card.a.m;
import com.baidu.tieba.card.a.o;
import com.baidu.tieba.card.a.p;
import com.baidu.tieba.card.a.s;
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
    private b bcH;
    private c bcI;
    private e bcJ;
    private f bcK;
    private d bcL;
    private g bcM;
    private BdTypeListView bcd;
    private final List<com.baidu.adp.widget.ListView.a> bcG = new ArrayList();
    private final ArrayList<u> Xq = new ArrayList<>();

    public h(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, BdUniqueId bdUniqueId) {
        a(tbPageContext, bdTypeListView, bdUniqueId);
    }

    private void a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, BdUniqueId bdUniqueId) {
        this.bcH = new b(tbPageContext);
        this.bcI = new c(tbPageContext);
        this.bcJ = new e(tbPageContext);
        this.bcK = new f(tbPageContext);
        this.bcL = new d(tbPageContext);
        this.bcM = new g(tbPageContext);
        this.bcH.setTag(bdUniqueId);
        this.bcI.setTag(bdUniqueId);
        this.bcJ.setTag(bdUniqueId);
        this.bcK.setTag(bdUniqueId);
        this.bcL.setTag(bdUniqueId);
        this.bcM.setTag(bdUniqueId);
        this.bcG.add(this.bcH);
        this.bcG.add(this.bcI);
        this.bcG.add(this.bcJ);
        this.bcG.add(this.bcK);
        this.bcG.add(this.bcL);
        this.bcG.add(this.bcM);
        this.bcd = bdTypeListView;
        this.bcd.g(this.bcG);
    }

    public void b(DataRes dataRes) {
        if (dataRes != null) {
            this.Xq.clear();
            a(dataRes.banner_info);
            S(dataRes.dir_info);
            T(dataRes.weekly_info);
            V(dataRes.recommend_forums);
            U(dataRes.recommend_classes);
            W(dataRes.new_top_info);
            if (this.bcd != null) {
                Os();
                this.bcd.setData(this.Xq);
            }
        }
    }

    private void a(ForumSquareBanner forumSquareBanner) {
        if (forumSquareBanner != null && y.p(forumSquareBanner.infos) > 0) {
            com.baidu.tieba.card.a.e eVar = new com.baidu.tieba.card.a.e();
            eVar.au(forumSquareBanner.forum_counts.longValue());
            for (BannerBaseInfo bannerBaseInfo : forumSquareBanner.infos) {
                if (bannerBaseInfo != null) {
                    e.a aVar = new e.a();
                    aVar.title = bannerBaseInfo.title;
                    aVar.link = bannerBaseInfo.link;
                    aVar.tag = bannerBaseInfo.tag;
                    aVar.type = bannerBaseInfo.type.intValue();
                    aVar.url = bannerBaseInfo.image_url;
                    eVar.FZ().add(aVar);
                }
            }
            if (y.p(eVar.FZ()) > 0) {
                this.Xq.add(eVar);
            }
        }
    }

    private void S(List<ForumSquareDirs> list) {
        if (y.p(list) > 0) {
            l lVar = new l();
            lVar.aVn = TbadkCoreApplication.m411getInst().getString(t.j.group_fourm_category_title);
            int i = 0;
            for (ForumSquareDirs forumSquareDirs : list) {
                if (forumSquareDirs != null) {
                    l.a aVar = new l.a();
                    aVar.id = forumSquareDirs.id.longValue();
                    aVar.url = forumSquareDirs.pic;
                    aVar.title = forumSquareDirs.title;
                    aVar.type = forumSquareDirs.type.intValue();
                    aVar.link = forumSquareDirs.link;
                    aVar.aVN = forumSquareDirs.torder.intValue();
                    aVar.position = i;
                    lVar.FZ().add(aVar);
                    i++;
                }
            }
            if (y.p(lVar.FZ()) > 0) {
                this.Xq.add(lVar);
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x006c: IGET  (r7v1 java.lang.Long A[REMOVE]) = (r0v8 tbclient.GetForumClassList.WeeklyInfo) tbclient.GetForumClassList.WeeklyInfo.forum_id java.lang.Long)] */
    private void T(List<WeeklyInfo> list) {
        if (y.p(list) > 0) {
            o oVar = new o();
            oVar.aVn = TbadkCoreApplication.m411getInst().getString(t.j.group_fourm_hot_title);
            int i = 1;
            for (WeeklyInfo weeklyInfo : list) {
                if (weeklyInfo != null && !TextUtils.isEmpty(weeklyInfo.forum_name) && weeklyInfo.forum_id.longValue() > 0 && !TextUtils.isEmpty(weeklyInfo.avatar)) {
                    com.baidu.tbadk.widget.a.g gVar = new com.baidu.tbadk.widget.a.g();
                    gVar.rank = i;
                    gVar.forumAvatar = weeklyInfo.avatar;
                    gVar.forumName = weeklyInfo.forum_name;
                    gVar.forumId = com.baidu.adp.lib.h.b.g(new StringBuilder().append(weeklyInfo.forum_id).toString(), -1);
                    gVar.isLiked = weeklyInfo.is_like.intValue() == 1;
                    oVar.a(gVar);
                    i++;
                }
            }
            if (y.p(oVar.FZ()) > 0) {
                this.Xq.add(oVar);
            }
        }
    }

    private void U(List<RecommendForumClass> list) {
        if (y.p(list) > 0) {
            m mVar = new m();
            mVar.aVn = TbadkCoreApplication.m411getInst().getString(t.j.group_fourm_good_title);
            int i = 0;
            for (RecommendForumClass recommendForumClass : list) {
                if (recommendForumClass != null && !TextUtils.isEmpty(recommendForumClass.recommend_title) && !TextUtils.isEmpty(recommendForumClass.recommend_image_url) && !TextUtils.isEmpty(recommendForumClass.link_url)) {
                    m.a aVar = new m.a();
                    aVar.id = recommendForumClass.forum_class_id.longValue();
                    aVar.title = recommendForumClass.recommend_title;
                    aVar.url = recommendForumClass.recommend_image_url;
                    aVar.link = recommendForumClass.link_url;
                    aVar.position = i;
                    mVar.a(aVar);
                    i++;
                }
            }
            if (y.p(mVar.FZ()) > 0) {
                this.Xq.add(mVar);
            }
        }
    }

    private void V(List<ForumSquareRecommendForumInfo> list) {
        if (y.p(list) > 0) {
            p pVar = new p();
            pVar.aVn = TbadkCoreApplication.m411getInst().getString(t.j.group_fourm_recommend_title);
            for (ForumSquareRecommendForumInfo forumSquareRecommendForumInfo : list) {
                if (forumSquareRecommendForumInfo != null && forumSquareRecommendForumInfo.forum_id.longValue() > 0 && !TextUtils.isEmpty(forumSquareRecommendForumInfo.forum_name) && !TextUtils.isEmpty(forumSquareRecommendForumInfo.avatar) && forumSquareRecommendForumInfo.member_count.longValue() >= 0 && forumSquareRecommendForumInfo.thread_count.longValue() >= 0) {
                    com.baidu.tieba.card.a.g gVar = new com.baidu.tieba.card.a.g();
                    gVar.aVB = forumSquareRecommendForumInfo.avatar;
                    gVar.mForumId = forumSquareRecommendForumInfo.forum_id.longValue();
                    gVar.mForumName = forumSquareRecommendForumInfo.forum_name;
                    gVar.aVF = forumSquareRecommendForumInfo._abstract;
                    gVar.aVC = forumSquareRecommendForumInfo.is_like.intValue();
                    gVar.aVD = forumSquareRecommendForumInfo.member_count.longValue();
                    gVar.aVE = forumSquareRecommendForumInfo.thread_count.longValue();
                    gVar.aVG = String.valueOf(TbadkCoreApplication.m411getInst().getString(t.j.attention_n)) + ay.z(forumSquareRecommendForumInfo.member_count.longValue());
                    gVar.aVH = String.valueOf(TbadkCoreApplication.m411getInst().getString(t.j.text_post)) + ay.z(forumSquareRecommendForumInfo.thread_count.longValue());
                    gVar.aVI = forumSquareRecommendForumInfo.recommend_reason;
                    pVar.FZ().add(gVar);
                }
            }
            if (y.p(pVar.FZ()) > 0) {
                this.Xq.add(pVar);
            }
        }
    }

    private void W(List<ForumInfo> list) {
        if (y.p(list) > 0) {
            s sVar = new s();
            sVar.aVn = TbadkCoreApplication.m411getInst().getString(t.j.group_fourm_new_top_title);
            for (ForumInfo forumInfo : list) {
                if (forumInfo != null && forumInfo.forum_id.longValue() > 0 && !TextUtils.isEmpty(forumInfo.forum_name) && !TextUtils.isEmpty(forumInfo.avatar)) {
                    com.baidu.tieba.card.a.h hVar = new com.baidu.tieba.card.a.h();
                    hVar.aVB = forumInfo.avatar;
                    hVar.mId = forumInfo.forum_id.longValue();
                    hVar.mName = forumInfo.forum_name;
                    hVar.aVF = forumInfo._abstract;
                    hVar.aVC = forumInfo.is_like.intValue();
                    sVar.FZ().add(hVar);
                }
            }
            if (y.p(sVar.FZ()) > 0) {
                this.Xq.add(sVar);
            }
        }
    }

    public void de(int i) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bcG) {
            if (aVar instanceof a) {
                ((a) aVar).de(i);
            }
        }
    }

    public void Os() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bcG) {
            if (aVar instanceof a) {
                ((a) aVar).bcn = true;
            }
        }
    }

    public void onDestroy() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bcG) {
            if (aVar instanceof a) {
                ((a) aVar).onDestroy();
            }
        }
    }

    public void onPause() {
        if (this.bcH != null) {
            this.bcH.onPause();
        }
    }

    public void onResume() {
        if (this.bcH != null) {
            this.bcH.onStart();
        }
    }

    public List<u> getData() {
        return this.Xq;
    }
}
