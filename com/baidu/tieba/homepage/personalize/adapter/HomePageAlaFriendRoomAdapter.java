package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
/* loaded from: classes2.dex */
public class HomePageAlaFriendRoomAdapter extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, HomePageAlaLiveThreadViewHolder> implements com.baidu.tieba.a.f {
    private String ajx;
    public BdUniqueId fIy;
    private NEGFeedBackView.a gfx;
    com.baidu.tieba.card.ab<com.baidu.tieba.card.data.j> iNL;
    private com.baidu.tieba.card.j klO;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public HomePageAlaFriendRoomAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gfx = null;
        this.iNL = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.adapter.HomePageAlaFriendRoomAdapter.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (HomePageAlaFriendRoomAdapter.this.klO.gpQ != view) {
                    if (view == HomePageAlaFriendRoomAdapter.this.klO.hpe.getCommentContainer()) {
                        HomePageAlaFriendRoomAdapter.this.a(jVar, view);
                        i = 5;
                    } else if (view == HomePageAlaFriendRoomAdapter.this.klO.iwm.getCommentContainer()) {
                        HomePageAlaFriendRoomAdapter.this.a(jVar, view);
                    } else if (HomePageAlaFriendRoomAdapter.this.klO.csl() != null && view.getId() == HomePageAlaFriendRoomAdapter.this.klO.csl().getId()) {
                        i = 2;
                    } else if (HomePageAlaFriendRoomAdapter.this.klO.csm() != null && view.getId() == HomePageAlaFriendRoomAdapter.this.klO.csm().getId()) {
                        i = 2;
                    }
                } else {
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.a.a.a(jVar.eLr, HomePageAlaFriendRoomAdapter.this.fIy, jVar.csU(), i);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bU */
    public HomePageAlaLiveThreadViewHolder e(ViewGroup viewGroup) {
        this.klO = new com.baidu.tieba.card.j(this.mPageContext, this.fIy);
        this.klO.wW(2);
        if (this.fIy != null) {
            this.klO.o(this.fIy);
        }
        return new HomePageAlaLiveThreadViewHolder(this.klO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, HomePageAlaLiveThreadViewHolder homePageAlaLiveThreadViewHolder) {
        jVar.xe(jVar.position + 1);
        if (homePageAlaLiveThreadViewHolder.klQ instanceof com.baidu.tieba.a.e) {
            homePageAlaLiveThreadViewHolder.klQ.setPage(this.ajx);
        }
        homePageAlaLiveThreadViewHolder.klQ.xb(i + 1);
        homePageAlaLiveThreadViewHolder.klQ.a(jVar);
        homePageAlaLiveThreadViewHolder.klQ.c(this.iNL);
        homePageAlaLiveThreadViewHolder.klQ.b(this.gfx);
        com.baidu.tieba.homepage.personalize.a.a.a(jVar.eLr, this.fIy, jVar.csU());
        if (jVar.blp() != null && jVar.blp().bol() != null) {
            ar arVar = new ar("c14007");
            arVar.aq("obj_locate", 1);
            arVar.v("obj_param1", jVar.blp().bol().live_id);
            arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(arVar);
        }
        return homePageAlaLiveThreadViewHolder.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.card.data.j jVar, View view) {
        String str = "";
        String str2 = "";
        if (jVar != null && jVar.blp() != null) {
            str = jVar.blp().getTid();
            str2 = jVar.blp().bmq();
        }
        ar arVar = new ar("c12942");
        arVar.aq("obj_locate", 1);
        arVar.aq("obj_type", 5);
        arVar.dR("tid", str);
        arVar.dR("obj_source", jVar.getSource());
        arVar.dR(IntentConfig.NID, str2);
        com.baidu.tbadk.pageExtra.c bR = com.baidu.tbadk.pageExtra.d.bR(view);
        if (bR != null) {
            arVar.dR("obj_cur_page", bR.getCurrentPageKey());
        }
        if (com.baidu.tbadk.pageExtra.d.bDP() != null) {
            arVar.dR("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDP());
        }
        TiebaStatic.log(arVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.gfx = aVar;
    }

    /* loaded from: classes2.dex */
    public static class HomePageAlaLiveThreadViewHolder extends TypeAdapter.ViewHolder {
        public com.baidu.tieba.card.j klQ;

        public HomePageAlaLiveThreadViewHolder(com.baidu.tieba.card.j jVar) {
            super(jVar.getView());
            this.klQ = jVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void ED(String str) {
        this.ajx = str;
    }
}
