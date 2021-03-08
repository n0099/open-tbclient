package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
/* loaded from: classes2.dex */
public class HomePageAlaLiveThreadAdapter extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, HomePageAlaLiveThreadViewHolder> implements com.baidu.tieba.a.f {
    private String ajx;
    public BdUniqueId fIy;
    private NEGFeedBackView.a gfx;
    com.baidu.tieba.card.ab<com.baidu.tieba.card.data.j> iNL;
    private com.baidu.tieba.card.k klR;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public HomePageAlaLiveThreadAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gfx = null;
        this.iNL = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.adapter.HomePageAlaLiveThreadAdapter.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (HomePageAlaLiveThreadAdapter.this.klR.gpQ != view) {
                    if (view == HomePageAlaLiveThreadAdapter.this.klR.hpe.getCommentContainer()) {
                        HomePageAlaLiveThreadAdapter.this.a(jVar, view);
                        i = 5;
                    } else if (view == HomePageAlaLiveThreadAdapter.this.klR.iwm.getCommentContainer()) {
                        HomePageAlaLiveThreadAdapter.this.a(jVar, view);
                    } else if (HomePageAlaLiveThreadAdapter.this.klR.csl() != null && view.getId() == HomePageAlaLiveThreadAdapter.this.klR.csl().getId()) {
                        i = 2;
                    } else if (HomePageAlaLiveThreadAdapter.this.klR.csm() != null && view.getId() == HomePageAlaLiveThreadAdapter.this.klR.csm().getId()) {
                        i = 2;
                    }
                } else {
                    String str = "";
                    long j = 0;
                    if (jVar != null && jVar.blp() != null) {
                        i = jVar.blp().bol().live_type;
                        str = jVar.blp().getTid();
                        j = jVar.blp().bol().live_id;
                    }
                    ar arVar = new ar("c11824");
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar.dR("ab_tag", jVar.csV());
                    arVar.v(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
                    arVar.aq("obj_type", i);
                    arVar.dR("tid", str);
                    arVar.dR("obj_param1", jVar.getExtra());
                    arVar.dR("obj_source", jVar.getSource());
                    arVar.aq("obj_floor", jVar.csU());
                    TiebaStatic.log(arVar);
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.a.a.a(jVar.eLr, HomePageAlaLiveThreadAdapter.this.fIy, jVar.csU(), i);
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
        this.klR = new com.baidu.tieba.card.k(this.mPageContext, this.fIy);
        this.klR.wW(2);
        if (this.fIy != null) {
            this.klR.o(this.fIy);
        }
        return new HomePageAlaLiveThreadViewHolder(this.klR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, HomePageAlaLiveThreadViewHolder homePageAlaLiveThreadViewHolder) {
        jVar.xe(jVar.position + 1);
        if (homePageAlaLiveThreadViewHolder.klT instanceof com.baidu.tieba.a.e) {
            homePageAlaLiveThreadViewHolder.klT.setPage(this.ajx);
        }
        homePageAlaLiveThreadViewHolder.klT.xb(i + 1);
        homePageAlaLiveThreadViewHolder.klT.a(jVar);
        homePageAlaLiveThreadViewHolder.klT.c(this.iNL);
        homePageAlaLiveThreadViewHolder.klT.b(this.gfx);
        String str = "";
        if (jVar != null && jVar.blp() != null) {
            int i2 = jVar.blp().bol().live_type;
            String tid = jVar.blp().getTid();
            if (!StringUtils.isNull(jVar.blp().bol().appId)) {
                str = jVar.blp().bol().appId;
            }
            long j = jVar.blp().bol().live_id;
            ar arVar = new ar("c11823");
            arVar.aq("obj_type", i2);
            arVar.dR(TiebaInitialize.Params.OBJ_PARAM3, str);
            arVar.dR("tid", tid);
            arVar.dR("ab_tag", jVar.csV());
            arVar.v(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
            arVar.v("fid", jVar.blp().getFid());
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dR("obj_param1", jVar.getExtra());
            arVar.dR("obj_source", jVar.getSource());
            arVar.aq("obj_floor", jVar.csU());
            TiebaStatic.log(arVar);
        }
        com.baidu.tieba.homepage.personalize.a.a.a(jVar.eLr, this.fIy, jVar.csU());
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
        public com.baidu.tieba.card.k klT;

        public HomePageAlaLiveThreadViewHolder(com.baidu.tieba.card.k kVar) {
            super(kVar.getView());
            this.klT = kVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void ED(String str) {
        this.ajx = str;
    }
}
