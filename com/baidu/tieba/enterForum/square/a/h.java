package com.baidu.tieba.enterForum.square.a;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.a.a.c;
import com.baidu.tieba.a.a.f;
import com.baidu.tieba.a.a.g;
import com.baidu.tieba.a.a.i;
import com.baidu.tieba.a.a.j;
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
    private b aRJ;
    private c aRK;
    private e aRL;
    private f aRM;
    private d aRN;
    private g aRO;
    private BdTypeListView aRs;
    private final List<com.baidu.adp.widget.ListView.a> aRI = new ArrayList();
    private final ArrayList<u> XX = new ArrayList<>();

    public h(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        a(tbPageContext, bdTypeListView);
    }

    private void a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.aRJ = new b(tbPageContext);
        this.aRK = new c(tbPageContext);
        this.aRL = new e(tbPageContext);
        this.aRM = new f(tbPageContext);
        this.aRN = new d(tbPageContext);
        this.aRO = new g(tbPageContext);
        this.aRI.add(this.aRJ);
        this.aRI.add(this.aRK);
        this.aRI.add(this.aRL);
        this.aRI.add(this.aRM);
        this.aRI.add(this.aRN);
        this.aRI.add(this.aRO);
        this.aRs = bdTypeListView;
        this.aRs.g(this.aRI);
    }

    public void b(DataRes dataRes) {
        if (dataRes != null) {
            this.XX.clear();
            a(dataRes.banner_info);
            Q(dataRes.dir_info);
            R(dataRes.weekly_info);
            T(dataRes.recommend_forums);
            S(dataRes.recommend_classes);
            U(dataRes.new_top_info);
            if (this.aRs != null) {
                Ku();
                this.aRs.setData(this.XX);
            }
        }
    }

    private void a(ForumSquareBanner forumSquareBanner) {
        if (forumSquareBanner != null && y.k(forumSquareBanner.infos) > 0) {
            com.baidu.tieba.a.a.c cVar = new com.baidu.tieba.a.a.c();
            cVar.am(forumSquareBanner.forum_counts.longValue());
            for (BannerBaseInfo bannerBaseInfo : forumSquareBanner.infos) {
                if (bannerBaseInfo != null) {
                    c.a aVar = new c.a();
                    aVar.title = bannerBaseInfo.title;
                    aVar.link = bannerBaseInfo.link;
                    aVar.tag = bannerBaseInfo.tag;
                    aVar.type = bannerBaseInfo.type.intValue();
                    aVar.url = bannerBaseInfo.image_url;
                    cVar.Ed().add(aVar);
                }
            }
            if (y.k(cVar.Ed()) > 0) {
                this.XX.add(cVar);
            }
        }
    }

    private void Q(List<ForumSquareDirs> list) {
        if (y.k(list) > 0) {
            com.baidu.tieba.a.a.f fVar = new com.baidu.tieba.a.a.f();
            fVar.aMH = TbadkCoreApplication.m411getInst().getString(n.i.group_fourm_category_title);
            int i = 0;
            for (ForumSquareDirs forumSquareDirs : list) {
                if (forumSquareDirs != null) {
                    f.a aVar = new f.a();
                    aVar.id = forumSquareDirs.id.longValue();
                    aVar.url = forumSquareDirs.pic;
                    aVar.title = forumSquareDirs.title;
                    aVar.type = forumSquareDirs.type.intValue();
                    aVar.link = forumSquareDirs.link;
                    aVar.aMV = forumSquareDirs.torder.intValue();
                    aVar.position = i;
                    fVar.Ed().add(aVar);
                    i++;
                }
            }
            if (y.k(fVar.Ed()) > 0) {
                this.XX.add(fVar);
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x006c: IGET  (r7v1 java.lang.Long A[REMOVE]) = (r0v8 tbclient.GetForumClassList.WeeklyInfo) tbclient.GetForumClassList.WeeklyInfo.forum_id java.lang.Long)] */
    private void R(List<WeeklyInfo> list) {
        if (y.k(list) > 0) {
            com.baidu.tieba.a.a.h hVar = new com.baidu.tieba.a.a.h();
            hVar.aMH = TbadkCoreApplication.m411getInst().getString(n.i.group_fourm_hot_title);
            int i = 1;
            for (WeeklyInfo weeklyInfo : list) {
                if (weeklyInfo != null && !TextUtils.isEmpty(weeklyInfo.forum_name) && weeklyInfo.forum_id.longValue() > 0 && !TextUtils.isEmpty(weeklyInfo.avatar)) {
                    com.baidu.tbadk.widget.horizonalScrollListView.f fVar = new com.baidu.tbadk.widget.horizonalScrollListView.f();
                    fVar.rank = i;
                    fVar.forumAvatar = weeklyInfo.avatar;
                    fVar.forumName = weeklyInfo.forum_name;
                    fVar.forumId = com.baidu.adp.lib.h.b.g(new StringBuilder().append(weeklyInfo.forum_id).toString(), -1);
                    fVar.isLiked = weeklyInfo.is_like.intValue() == 1;
                    hVar.a(fVar);
                    i++;
                }
            }
            if (y.k(hVar.Ed()) > 0) {
                this.XX.add(hVar);
            }
        }
    }

    private void S(List<RecommendForumClass> list) {
        if (y.k(list) > 0) {
            com.baidu.tieba.a.a.g gVar = new com.baidu.tieba.a.a.g();
            gVar.aMH = TbadkCoreApplication.m411getInst().getString(n.i.group_fourm_good_title);
            int i = 0;
            for (RecommendForumClass recommendForumClass : list) {
                if (recommendForumClass != null && !TextUtils.isEmpty(recommendForumClass.recommend_title) && !TextUtils.isEmpty(recommendForumClass.recommend_image_url) && !TextUtils.isEmpty(recommendForumClass.link_url)) {
                    g.a aVar = new g.a();
                    aVar.id = recommendForumClass.forum_class_id.longValue();
                    aVar.title = recommendForumClass.recommend_title;
                    aVar.url = recommendForumClass.recommend_image_url;
                    aVar.link = recommendForumClass.link_url;
                    aVar.position = i;
                    gVar.a(aVar);
                    i++;
                }
            }
            if (y.k(gVar.Ed()) > 0) {
                this.XX.add(gVar);
            }
        }
    }

    private void T(List<ForumSquareRecommendForumInfo> list) {
        if (y.k(list) > 0) {
            i iVar = new i();
            iVar.aMH = TbadkCoreApplication.m411getInst().getString(n.i.group_fourm_recommend_title);
            for (ForumSquareRecommendForumInfo forumSquareRecommendForumInfo : list) {
                if (forumSquareRecommendForumInfo != null && forumSquareRecommendForumInfo.forum_id.longValue() > 0 && !TextUtils.isEmpty(forumSquareRecommendForumInfo.forum_name) && !TextUtils.isEmpty(forumSquareRecommendForumInfo.avatar) && forumSquareRecommendForumInfo.member_count.longValue() >= 0 && forumSquareRecommendForumInfo.thread_count.longValue() >= 0) {
                    com.baidu.tieba.a.a.d dVar = new com.baidu.tieba.a.a.d();
                    dVar.aMN = forumSquareRecommendForumInfo.avatar;
                    dVar.mForumId = forumSquareRecommendForumInfo.forum_id.longValue();
                    dVar.mForumName = forumSquareRecommendForumInfo.forum_name;
                    dVar.aMR = forumSquareRecommendForumInfo._abstract;
                    dVar.aMO = forumSquareRecommendForumInfo.is_like.intValue();
                    dVar.aMP = forumSquareRecommendForumInfo.member_count.longValue();
                    dVar.aMQ = forumSquareRecommendForumInfo.thread_count.longValue();
                    dVar.aMS = String.valueOf(TbadkCoreApplication.m411getInst().getString(n.i.attention_n)) + ax.v(forumSquareRecommendForumInfo.member_count.longValue());
                    dVar.aMT = String.valueOf(TbadkCoreApplication.m411getInst().getString(n.i.text_post)) + ax.v(forumSquareRecommendForumInfo.thread_count.longValue());
                    dVar.aMU = forumSquareRecommendForumInfo.recommend_reason;
                    iVar.Ed().add(dVar);
                }
            }
            if (y.k(iVar.Ed()) > 0) {
                this.XX.add(iVar);
            }
        }
    }

    private void U(List<ForumInfo> list) {
        if (y.k(list) > 0) {
            j jVar = new j();
            jVar.aMH = TbadkCoreApplication.m411getInst().getString(n.i.group_fourm_new_top_title);
            for (ForumInfo forumInfo : list) {
                if (forumInfo != null && forumInfo.forum_id.longValue() > 0 && !TextUtils.isEmpty(forumInfo.forum_name) && !TextUtils.isEmpty(forumInfo.avatar)) {
                    com.baidu.tieba.a.a.e eVar = new com.baidu.tieba.a.a.e();
                    eVar.aMN = forumInfo.avatar;
                    eVar.mId = forumInfo.forum_id.longValue();
                    eVar.mName = forumInfo.forum_name;
                    eVar.aMR = forumInfo._abstract;
                    eVar.aMO = forumInfo.is_like.intValue();
                    jVar.Ed().add(eVar);
                }
            }
            if (y.k(jVar.Ed()) > 0) {
                this.XX.add(jVar);
            }
        }
    }

    public void cZ(int i) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aRI) {
            if (aVar instanceof a) {
                ((a) aVar).cZ(i);
            }
        }
    }

    public void Ku() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aRI) {
            if (aVar instanceof a) {
                ((a) aVar).aRB = true;
            }
        }
    }

    public void onDestroy() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aRI) {
            if (aVar instanceof a) {
                ((a) aVar).onDestroy();
            }
        }
    }

    public void onPause() {
        if (this.aRJ != null) {
            this.aRJ.onPause();
        }
    }

    public void onResume() {
        if (this.aRJ != null) {
            this.aRJ.onStart();
        }
    }

    public List<u> getData() {
        return this.XX;
    }
}
