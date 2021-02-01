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
    private String aif;
    public BdUniqueId fGZ;
    private NEGFeedBackView.a gdO;
    com.baidu.tieba.card.ab<com.baidu.tieba.card.data.j> iLO;
    private com.baidu.tieba.card.j kjy;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public HomePageAlaFriendRoomAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gdO = null;
        this.iLO = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.adapter.HomePageAlaFriendRoomAdapter.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (HomePageAlaFriendRoomAdapter.this.kjy.gnT != view) {
                    if (view == HomePageAlaFriendRoomAdapter.this.kjy.hng.getCommentContainer()) {
                        HomePageAlaFriendRoomAdapter.this.a(jVar, view);
                        i = 5;
                    } else if (view == HomePageAlaFriendRoomAdapter.this.kjy.iup.getCommentContainer()) {
                        HomePageAlaFriendRoomAdapter.this.a(jVar, view);
                    } else if (HomePageAlaFriendRoomAdapter.this.kjy.crY() != null && view.getId() == HomePageAlaFriendRoomAdapter.this.kjy.crY().getId()) {
                        i = 2;
                    } else if (HomePageAlaFriendRoomAdapter.this.kjy.crZ() != null && view.getId() == HomePageAlaFriendRoomAdapter.this.kjy.crZ().getId()) {
                        i = 2;
                    }
                } else {
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.a.a.a(jVar.eJQ, HomePageAlaFriendRoomAdapter.this.fGZ, jVar.csH(), i);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bV */
    public HomePageAlaLiveThreadViewHolder e(ViewGroup viewGroup) {
        this.kjy = new com.baidu.tieba.card.j(this.mPageContext, this.fGZ);
        this.kjy.wV(2);
        if (this.fGZ != null) {
            this.kjy.o(this.fGZ);
        }
        return new HomePageAlaLiveThreadViewHolder(this.kjy);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, HomePageAlaLiveThreadViewHolder homePageAlaLiveThreadViewHolder) {
        jVar.xd(jVar.position + 1);
        if (homePageAlaLiveThreadViewHolder.kjA instanceof com.baidu.tieba.a.e) {
            homePageAlaLiveThreadViewHolder.kjA.setPage(this.aif);
        }
        homePageAlaLiveThreadViewHolder.kjA.xa(i + 1);
        homePageAlaLiveThreadViewHolder.kjA.a(jVar);
        homePageAlaLiveThreadViewHolder.kjA.c(this.iLO);
        homePageAlaLiveThreadViewHolder.kjA.b(this.gdO);
        com.baidu.tieba.homepage.personalize.a.a.a(jVar.eJQ, this.fGZ, jVar.csH());
        if (jVar.bln() != null && jVar.bln().boj() != null) {
            ar arVar = new ar("c14007");
            arVar.ap("obj_locate", 1);
            arVar.v("obj_param1", jVar.bln().boj().live_id);
            arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(arVar);
        }
        return homePageAlaLiveThreadViewHolder.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.card.data.j jVar, View view) {
        String str = "";
        String str2 = "";
        if (jVar != null && jVar.bln() != null) {
            str = jVar.bln().getTid();
            str2 = jVar.bln().bmo();
        }
        ar arVar = new ar("c12942");
        arVar.ap("obj_locate", 1);
        arVar.ap("obj_type", 5);
        arVar.dR("tid", str);
        arVar.dR("obj_source", jVar.getSource());
        arVar.dR(IntentConfig.NID, str2);
        com.baidu.tbadk.pageExtra.c bR = com.baidu.tbadk.pageExtra.d.bR(view);
        if (bR != null) {
            arVar.dR("obj_cur_page", bR.getCurrentPageKey());
        }
        if (com.baidu.tbadk.pageExtra.d.bDM() != null) {
            arVar.dR("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDM());
        }
        TiebaStatic.log(arVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.gdO = aVar;
    }

    /* loaded from: classes2.dex */
    public static class HomePageAlaLiveThreadViewHolder extends TypeAdapter.ViewHolder {
        public com.baidu.tieba.card.j kjA;

        public HomePageAlaLiveThreadViewHolder(com.baidu.tieba.card.j jVar) {
            super(jVar.getView());
            this.kjA = jVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void Ey(String str) {
        this.aif = str;
    }
}
