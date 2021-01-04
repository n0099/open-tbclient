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
    private String aji;
    public BdUniqueId fJu;
    private NEGFeedBackView.a ggi;
    com.baidu.tieba.card.aa<com.baidu.tieba.card.data.j> iKM;
    private com.baidu.tieba.card.j kfU;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public HomePageAlaFriendRoomAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ggi = null;
        this.iKM = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.adapter.HomePageAlaFriendRoomAdapter.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (HomePageAlaFriendRoomAdapter.this.kfU.gpU != view) {
                    if (view == HomePageAlaFriendRoomAdapter.this.kfU.hnz.getCommentContainer()) {
                        HomePageAlaFriendRoomAdapter.this.a(jVar, view);
                        i = 5;
                    } else if (view == HomePageAlaFriendRoomAdapter.this.kfU.its.getCommentContainer()) {
                        HomePageAlaFriendRoomAdapter.this.a(jVar, view);
                    } else if (HomePageAlaFriendRoomAdapter.this.kfU.cuF() != null && view.getId() == HomePageAlaFriendRoomAdapter.this.kfU.cuF().getId()) {
                        i = 2;
                    } else if (HomePageAlaFriendRoomAdapter.this.kfU.cuG() != null && view.getId() == HomePageAlaFriendRoomAdapter.this.kfU.cuG().getId()) {
                        i = 2;
                    }
                } else {
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.a.a.a(jVar.eMv, HomePageAlaFriendRoomAdapter.this.fJu, jVar.cvm(), i);
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
        this.kfU = new com.baidu.tieba.card.j(this.mPageContext, this.fJu);
        this.kfU.ys(2);
        if (this.fJu != null) {
            this.kfU.o(this.fJu);
        }
        return new HomePageAlaLiveThreadViewHolder(this.kfU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, HomePageAlaLiveThreadViewHolder homePageAlaLiveThreadViewHolder) {
        jVar.yA(jVar.position + 1);
        if (homePageAlaLiveThreadViewHolder.kfW instanceof com.baidu.tieba.a.e) {
            homePageAlaLiveThreadViewHolder.kfW.setPage(this.aji);
        }
        homePageAlaLiveThreadViewHolder.kfW.yx(i + 1);
        homePageAlaLiveThreadViewHolder.kfW.a(jVar);
        homePageAlaLiveThreadViewHolder.kfW.c(this.iKM);
        homePageAlaLiveThreadViewHolder.kfW.b(this.ggi);
        com.baidu.tieba.homepage.personalize.a.a.a(jVar.eMv, this.fJu, jVar.cvm());
        if (jVar.boO() != null && jVar.boO().brJ() != null) {
            aq aqVar = new aq("c14007");
            aqVar.an("obj_locate", 1);
            aqVar.w("obj_param1", jVar.boO().brJ().live_id);
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(aqVar);
        }
        return homePageAlaLiveThreadViewHolder.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.card.data.j jVar, View view) {
        String str = "";
        String str2 = "";
        if (jVar != null && jVar.boO() != null) {
            str = jVar.boO().getTid();
            str2 = jVar.boO().bpO();
        }
        aq aqVar = new aq("c12942");
        aqVar.an("obj_locate", 1);
        aqVar.an("obj_type", 5);
        aqVar.dX("tid", str);
        aqVar.dX("obj_source", jVar.getSource());
        aqVar.dX(IntentConfig.NID, str2);
        com.baidu.tbadk.pageExtra.c bV = com.baidu.tbadk.pageExtra.d.bV(view);
        if (bV != null) {
            aqVar.dX("obj_cur_page", bV.getCurrentPageKey());
        }
        if (com.baidu.tbadk.pageExtra.d.bHm() != null) {
            aqVar.dX("obj_pre_page", com.baidu.tbadk.pageExtra.d.bHm());
        }
        TiebaStatic.log(aqVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.ggi = aVar;
    }

    /* loaded from: classes2.dex */
    public static class HomePageAlaLiveThreadViewHolder extends TypeAdapter.ViewHolder {
        public com.baidu.tieba.card.j kfW;

        public HomePageAlaLiveThreadViewHolder(com.baidu.tieba.card.j jVar) {
            super(jVar.getView());
            this.kfW = jVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void Fm(String str) {
        this.aji = str;
    }
}
