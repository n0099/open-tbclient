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
    private String aji;
    public BdUniqueId fJu;
    private NEGFeedBackView.a ggi;
    com.baidu.tieba.card.aa<com.baidu.tieba.card.data.j> iKM;
    private com.baidu.tieba.card.k kfX;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public HomePageAlaLiveThreadAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ggi = null;
        this.iKM = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.adapter.HomePageAlaLiveThreadAdapter.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (HomePageAlaLiveThreadAdapter.this.kfX.gpU != view) {
                    if (view == HomePageAlaLiveThreadAdapter.this.kfX.hnz.getCommentContainer()) {
                        HomePageAlaLiveThreadAdapter.this.a(jVar, view);
                        i = 5;
                    } else if (view == HomePageAlaLiveThreadAdapter.this.kfX.its.getCommentContainer()) {
                        HomePageAlaLiveThreadAdapter.this.a(jVar, view);
                    } else if (HomePageAlaLiveThreadAdapter.this.kfX.cuF() != null && view.getId() == HomePageAlaLiveThreadAdapter.this.kfX.cuF().getId()) {
                        i = 2;
                    } else if (HomePageAlaLiveThreadAdapter.this.kfX.cuG() != null && view.getId() == HomePageAlaLiveThreadAdapter.this.kfX.cuG().getId()) {
                        i = 2;
                    }
                } else {
                    String str = "";
                    long j = 0;
                    if (jVar != null && jVar.boO() != null) {
                        i = jVar.boO().brJ().live_type;
                        str = jVar.boO().getTid();
                        j = jVar.boO().brJ().live_id;
                    }
                    aq aqVar = new aq("c11824");
                    aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.dX("ab_tag", jVar.cvn());
                    aqVar.w(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
                    aqVar.an("obj_type", i);
                    aqVar.dX("tid", str);
                    aqVar.dX("obj_param1", jVar.getExtra());
                    aqVar.dX("obj_source", jVar.getSource());
                    aqVar.an("obj_floor", jVar.cvm());
                    TiebaStatic.log(aqVar);
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.a.a.a(jVar.eMv, HomePageAlaLiveThreadAdapter.this.fJu, jVar.cvm(), i);
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
        this.kfX = new com.baidu.tieba.card.k(this.mPageContext, this.fJu);
        this.kfX.ys(2);
        if (this.fJu != null) {
            this.kfX.o(this.fJu);
        }
        return new HomePageAlaLiveThreadViewHolder(this.kfX);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, HomePageAlaLiveThreadViewHolder homePageAlaLiveThreadViewHolder) {
        jVar.yA(jVar.position + 1);
        if (homePageAlaLiveThreadViewHolder.kfZ instanceof com.baidu.tieba.a.e) {
            homePageAlaLiveThreadViewHolder.kfZ.setPage(this.aji);
        }
        homePageAlaLiveThreadViewHolder.kfZ.yx(i + 1);
        homePageAlaLiveThreadViewHolder.kfZ.a(jVar);
        homePageAlaLiveThreadViewHolder.kfZ.c(this.iKM);
        homePageAlaLiveThreadViewHolder.kfZ.b(this.ggi);
        String str = "";
        if (jVar != null && jVar.boO() != null) {
            int i2 = jVar.boO().brJ().live_type;
            String tid = jVar.boO().getTid();
            if (!StringUtils.isNull(jVar.boO().brJ().appId)) {
                str = jVar.boO().brJ().appId;
            }
            long j = jVar.boO().brJ().live_id;
            aq aqVar = new aq("c11823");
            aqVar.an("obj_type", i2);
            aqVar.dX(TiebaInitialize.Params.OBJ_PARAM3, str);
            aqVar.dX("tid", tid);
            aqVar.dX("ab_tag", jVar.cvn());
            aqVar.w(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
            aqVar.w("fid", jVar.boO().getFid());
            aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dX("obj_param1", jVar.getExtra());
            aqVar.dX("obj_source", jVar.getSource());
            aqVar.an("obj_floor", jVar.cvm());
            TiebaStatic.log(aqVar);
        }
        com.baidu.tieba.homepage.personalize.a.a.a(jVar.eMv, this.fJu, jVar.cvm());
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
        public com.baidu.tieba.card.k kfZ;

        public HomePageAlaLiveThreadViewHolder(com.baidu.tieba.card.k kVar) {
            super(kVar.getView());
            this.kfZ = kVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void Fm(String str) {
        this.aji = str;
    }
}
