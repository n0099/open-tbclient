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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
/* loaded from: classes2.dex */
public class HomePageAlaLiveThreadAdapter extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, HomePageAlaLiveThreadViewHolder> implements com.baidu.tieba.a.f {
    private String air;
    public BdUniqueId fEN;
    private NEGFeedBackView.a gbz;
    com.baidu.tieba.card.aa<com.baidu.tieba.card.data.j> iGf;
    private com.baidu.tieba.card.k kbr;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public HomePageAlaLiveThreadAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gbz = null;
        this.iGf = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.adapter.HomePageAlaLiveThreadAdapter.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (HomePageAlaLiveThreadAdapter.this.kbr.gln != view) {
                    if (view == HomePageAlaLiveThreadAdapter.this.kbr.hiT.getCommentContainer()) {
                        HomePageAlaLiveThreadAdapter.this.a(jVar, view);
                        i = 5;
                    } else if (view == HomePageAlaLiveThreadAdapter.this.kbr.ioL.getCommentContainer()) {
                        HomePageAlaLiveThreadAdapter.this.a(jVar, view);
                    } else if (HomePageAlaLiveThreadAdapter.this.kbr.cqO() != null && view.getId() == HomePageAlaLiveThreadAdapter.this.kbr.cqO().getId()) {
                        i = 2;
                    } else if (HomePageAlaLiveThreadAdapter.this.kbr.cqP() != null && view.getId() == HomePageAlaLiveThreadAdapter.this.kbr.cqP().getId()) {
                        i = 2;
                    }
                } else {
                    String str = "";
                    long j = 0;
                    if (jVar != null && jVar.bkV() != null) {
                        i = jVar.bkV().bnQ().live_type;
                        str = jVar.bkV().getTid();
                        j = jVar.bkV().bnQ().live_id;
                    }
                    aq aqVar = new aq("c11824");
                    aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.dW("ab_tag", jVar.crw());
                    aqVar.w(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
                    aqVar.an("obj_type", i);
                    aqVar.dW("tid", str);
                    aqVar.dW("obj_param1", jVar.getExtra());
                    aqVar.dW("obj_source", jVar.getSource());
                    aqVar.an("obj_floor", jVar.crv());
                    TiebaStatic.log(aqVar);
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.a.a.a(jVar.eHK, HomePageAlaLiveThreadAdapter.this.fEN, jVar.crv(), i);
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
        this.kbr = new com.baidu.tieba.card.k(this.mPageContext, this.fEN);
        this.kbr.wL(2);
        if (this.fEN != null) {
            this.kbr.o(this.fEN);
        }
        return new HomePageAlaLiveThreadViewHolder(this.kbr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, HomePageAlaLiveThreadViewHolder homePageAlaLiveThreadViewHolder) {
        jVar.wT(jVar.position + 1);
        if (homePageAlaLiveThreadViewHolder.kbt instanceof com.baidu.tieba.a.e) {
            homePageAlaLiveThreadViewHolder.kbt.setPage(this.air);
        }
        homePageAlaLiveThreadViewHolder.kbt.wQ(i + 1);
        homePageAlaLiveThreadViewHolder.kbt.a(jVar);
        homePageAlaLiveThreadViewHolder.kbt.c(this.iGf);
        homePageAlaLiveThreadViewHolder.kbt.b(this.gbz);
        String str = "";
        if (jVar != null && jVar.bkV() != null) {
            int i2 = jVar.bkV().bnQ().live_type;
            String tid = jVar.bkV().getTid();
            if (!StringUtils.isNull(jVar.bkV().bnQ().appId)) {
                str = jVar.bkV().bnQ().appId;
            }
            long j = jVar.bkV().bnQ().live_id;
            aq aqVar = new aq("c11823");
            aqVar.an("obj_type", i2);
            aqVar.dW(TiebaInitialize.Params.OBJ_PARAM3, str);
            aqVar.dW("tid", tid);
            aqVar.dW("ab_tag", jVar.crw());
            aqVar.w(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
            aqVar.w("fid", jVar.bkV().getFid());
            aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dW("obj_param1", jVar.getExtra());
            aqVar.dW("obj_source", jVar.getSource());
            aqVar.an("obj_floor", jVar.crv());
            TiebaStatic.log(aqVar);
        }
        com.baidu.tieba.homepage.personalize.a.a.a(jVar.eHK, this.fEN, jVar.crv());
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
        public com.baidu.tieba.card.k kbt;

        public HomePageAlaLiveThreadViewHolder(com.baidu.tieba.card.k kVar) {
            super(kVar.getView());
            this.kbt = kVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void Ea(String str) {
        this.air = str;
    }
}
