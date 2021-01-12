package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
/* loaded from: classes2.dex */
public class HomePageAlaFriendRoomAdapter extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, HomePageAlaLiveThreadViewHolder> implements com.baidu.tieba.a.f {
    private String air;
    public BdUniqueId fEN;
    private NEGFeedBackView.a gbz;
    com.baidu.tieba.card.aa<com.baidu.tieba.card.data.j> iGf;
    private com.baidu.tieba.card.j kbo;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public HomePageAlaFriendRoomAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gbz = null;
        this.iGf = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.adapter.HomePageAlaFriendRoomAdapter.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (HomePageAlaFriendRoomAdapter.this.kbo.gln != view) {
                    if (view == HomePageAlaFriendRoomAdapter.this.kbo.hiT.getCommentContainer()) {
                        HomePageAlaFriendRoomAdapter.this.a(jVar, view);
                        i = 5;
                    } else if (view == HomePageAlaFriendRoomAdapter.this.kbo.ioL.getCommentContainer()) {
                        HomePageAlaFriendRoomAdapter.this.a(jVar, view);
                    } else if (HomePageAlaFriendRoomAdapter.this.kbo.cqO() != null && view.getId() == HomePageAlaFriendRoomAdapter.this.kbo.cqO().getId()) {
                        i = 2;
                    } else if (HomePageAlaFriendRoomAdapter.this.kbo.cqP() != null && view.getId() == HomePageAlaFriendRoomAdapter.this.kbo.cqP().getId()) {
                        i = 2;
                    }
                } else {
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.a.a.a(jVar.eHK, HomePageAlaFriendRoomAdapter.this.fEN, jVar.crv(), i);
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
        this.kbo = new com.baidu.tieba.card.j(this.mPageContext, this.fEN);
        this.kbo.wL(2);
        if (this.fEN != null) {
            this.kbo.o(this.fEN);
        }
        return new HomePageAlaLiveThreadViewHolder(this.kbo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, HomePageAlaLiveThreadViewHolder homePageAlaLiveThreadViewHolder) {
        jVar.wT(jVar.position + 1);
        if (homePageAlaLiveThreadViewHolder.kbq instanceof com.baidu.tieba.a.e) {
            homePageAlaLiveThreadViewHolder.kbq.setPage(this.air);
        }
        homePageAlaLiveThreadViewHolder.kbq.wQ(i + 1);
        homePageAlaLiveThreadViewHolder.kbq.a(jVar);
        homePageAlaLiveThreadViewHolder.kbq.c(this.iGf);
        homePageAlaLiveThreadViewHolder.kbq.b(this.gbz);
        com.baidu.tieba.homepage.personalize.a.a.a(jVar.eHK, this.fEN, jVar.crv());
        if (jVar.bkV() != null && jVar.bkV().bnQ() != null) {
            aq aqVar = new aq("c14007");
            aqVar.an("obj_locate", 1);
            aqVar.w("obj_param1", jVar.bkV().bnQ().live_id);
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(aqVar);
        }
        return homePageAlaLiveThreadViewHolder.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.card.data.j jVar, View view) {
        String str = "";
        String str2 = "";
        if (jVar != null && jVar.bkV() != null) {
            str = jVar.bkV().getTid();
            str2 = jVar.bkV().blV();
        }
        aq aqVar = new aq("c12942");
        aqVar.an("obj_locate", 1);
        aqVar.an("obj_type", 5);
        aqVar.dW("tid", str);
        aqVar.dW("obj_source", jVar.getSource());
        aqVar.dW(IntentConfig.NID, str2);
        com.baidu.tbadk.pageExtra.c bV = com.baidu.tbadk.pageExtra.d.bV(view);
        if (bV != null) {
            aqVar.dW("obj_cur_page", bV.getCurrentPageKey());
        }
        if (com.baidu.tbadk.pageExtra.d.bDu() != null) {
            aqVar.dW("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDu());
        }
        TiebaStatic.log(aqVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.gbz = aVar;
    }

    /* loaded from: classes2.dex */
    public static class HomePageAlaLiveThreadViewHolder extends TypeAdapter.ViewHolder {
        public com.baidu.tieba.card.j kbq;

        public HomePageAlaLiveThreadViewHolder(com.baidu.tieba.card.j jVar) {
            super(jVar.getView());
            this.kbq = jVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void Ea(String str) {
        this.air = str;
    }
}
