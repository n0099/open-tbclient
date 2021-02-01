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
    private String aif;
    public BdUniqueId fGZ;
    private NEGFeedBackView.a gdO;
    com.baidu.tieba.card.ab<com.baidu.tieba.card.data.j> iLO;
    private com.baidu.tieba.card.k kjB;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public HomePageAlaLiveThreadAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gdO = null;
        this.iLO = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.adapter.HomePageAlaLiveThreadAdapter.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (HomePageAlaLiveThreadAdapter.this.kjB.gnT != view) {
                    if (view == HomePageAlaLiveThreadAdapter.this.kjB.hng.getCommentContainer()) {
                        HomePageAlaLiveThreadAdapter.this.a(jVar, view);
                        i = 5;
                    } else if (view == HomePageAlaLiveThreadAdapter.this.kjB.iup.getCommentContainer()) {
                        HomePageAlaLiveThreadAdapter.this.a(jVar, view);
                    } else if (HomePageAlaLiveThreadAdapter.this.kjB.crY() != null && view.getId() == HomePageAlaLiveThreadAdapter.this.kjB.crY().getId()) {
                        i = 2;
                    } else if (HomePageAlaLiveThreadAdapter.this.kjB.crZ() != null && view.getId() == HomePageAlaLiveThreadAdapter.this.kjB.crZ().getId()) {
                        i = 2;
                    }
                } else {
                    String str = "";
                    long j = 0;
                    if (jVar != null && jVar.bln() != null) {
                        i = jVar.bln().boj().live_type;
                        str = jVar.bln().getTid();
                        j = jVar.bln().boj().live_id;
                    }
                    ar arVar = new ar("c11824");
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar.dR("ab_tag", jVar.csI());
                    arVar.v(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
                    arVar.ap("obj_type", i);
                    arVar.dR("tid", str);
                    arVar.dR("obj_param1", jVar.getExtra());
                    arVar.dR("obj_source", jVar.getSource());
                    arVar.ap("obj_floor", jVar.csH());
                    TiebaStatic.log(arVar);
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.a.a.a(jVar.eJQ, HomePageAlaLiveThreadAdapter.this.fGZ, jVar.csH(), i);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bW */
    public HomePageAlaLiveThreadViewHolder e(ViewGroup viewGroup) {
        this.kjB = new com.baidu.tieba.card.k(this.mPageContext, this.fGZ);
        this.kjB.wV(2);
        if (this.fGZ != null) {
            this.kjB.o(this.fGZ);
        }
        return new HomePageAlaLiveThreadViewHolder(this.kjB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, HomePageAlaLiveThreadViewHolder homePageAlaLiveThreadViewHolder) {
        jVar.xd(jVar.position + 1);
        if (homePageAlaLiveThreadViewHolder.kjD instanceof com.baidu.tieba.a.e) {
            homePageAlaLiveThreadViewHolder.kjD.setPage(this.aif);
        }
        homePageAlaLiveThreadViewHolder.kjD.xa(i + 1);
        homePageAlaLiveThreadViewHolder.kjD.a(jVar);
        homePageAlaLiveThreadViewHolder.kjD.c(this.iLO);
        homePageAlaLiveThreadViewHolder.kjD.b(this.gdO);
        String str = "";
        if (jVar != null && jVar.bln() != null) {
            int i2 = jVar.bln().boj().live_type;
            String tid = jVar.bln().getTid();
            if (!StringUtils.isNull(jVar.bln().boj().appId)) {
                str = jVar.bln().boj().appId;
            }
            long j = jVar.bln().boj().live_id;
            ar arVar = new ar("c11823");
            arVar.ap("obj_type", i2);
            arVar.dR(TiebaInitialize.Params.OBJ_PARAM3, str);
            arVar.dR("tid", tid);
            arVar.dR("ab_tag", jVar.csI());
            arVar.v(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
            arVar.v("fid", jVar.bln().getFid());
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dR("obj_param1", jVar.getExtra());
            arVar.dR("obj_source", jVar.getSource());
            arVar.ap("obj_floor", jVar.csH());
            TiebaStatic.log(arVar);
        }
        com.baidu.tieba.homepage.personalize.a.a.a(jVar.eJQ, this.fGZ, jVar.csH());
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
        public com.baidu.tieba.card.k kjD;

        public HomePageAlaLiveThreadViewHolder(com.baidu.tieba.card.k kVar) {
            super(kVar.getView());
            this.kjD = kVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void Ey(String str) {
        this.aif = str;
    }
}
