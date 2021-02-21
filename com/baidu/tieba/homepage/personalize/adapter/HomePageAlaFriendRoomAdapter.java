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
    private NEGFeedBackView.a gdT;
    com.baidu.tieba.card.ab<com.baidu.tieba.card.data.j> iMc;
    private com.baidu.tieba.card.j kjM;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public HomePageAlaFriendRoomAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gdT = null;
        this.iMc = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.adapter.HomePageAlaFriendRoomAdapter.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (HomePageAlaFriendRoomAdapter.this.kjM.goh != view) {
                    if (view == HomePageAlaFriendRoomAdapter.this.kjM.hnu.getCommentContainer()) {
                        HomePageAlaFriendRoomAdapter.this.a(jVar, view);
                        i = 5;
                    } else if (view == HomePageAlaFriendRoomAdapter.this.kjM.iuD.getCommentContainer()) {
                        HomePageAlaFriendRoomAdapter.this.a(jVar, view);
                    } else if (HomePageAlaFriendRoomAdapter.this.kjM.csf() != null && view.getId() == HomePageAlaFriendRoomAdapter.this.kjM.csf().getId()) {
                        i = 2;
                    } else if (HomePageAlaFriendRoomAdapter.this.kjM.csg() != null && view.getId() == HomePageAlaFriendRoomAdapter.this.kjM.csg().getId()) {
                        i = 2;
                    }
                } else {
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.a.a.a(jVar.eJQ, HomePageAlaFriendRoomAdapter.this.fGZ, jVar.csO(), i);
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
        this.kjM = new com.baidu.tieba.card.j(this.mPageContext, this.fGZ);
        this.kjM.wV(2);
        if (this.fGZ != null) {
            this.kjM.o(this.fGZ);
        }
        return new HomePageAlaLiveThreadViewHolder(this.kjM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, HomePageAlaLiveThreadViewHolder homePageAlaLiveThreadViewHolder) {
        jVar.xd(jVar.position + 1);
        if (homePageAlaLiveThreadViewHolder.kjO instanceof com.baidu.tieba.a.e) {
            homePageAlaLiveThreadViewHolder.kjO.setPage(this.aif);
        }
        homePageAlaLiveThreadViewHolder.kjO.xa(i + 1);
        homePageAlaLiveThreadViewHolder.kjO.a(jVar);
        homePageAlaLiveThreadViewHolder.kjO.c(this.iMc);
        homePageAlaLiveThreadViewHolder.kjO.b(this.gdT);
        com.baidu.tieba.homepage.personalize.a.a.a(jVar.eJQ, this.fGZ, jVar.csO());
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
        this.gdT = aVar;
    }

    /* loaded from: classes2.dex */
    public static class HomePageAlaLiveThreadViewHolder extends TypeAdapter.ViewHolder {
        public com.baidu.tieba.card.j kjO;

        public HomePageAlaLiveThreadViewHolder(com.baidu.tieba.card.j jVar) {
            super(jVar.getView());
            this.kjO = jVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void Ew(String str) {
        this.aif = str;
    }
}
