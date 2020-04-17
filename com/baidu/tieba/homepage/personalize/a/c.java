package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, a> implements com.baidu.tieba.a.f {
    private String aey;
    public BdUniqueId ebv;
    private NEGFeedBackView.a euS;
    com.baidu.tieba.card.z<com.baidu.tieba.card.data.j> gEg;
    private com.baidu.tieba.card.j hOx;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.euS = null;
        this.gEg = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (c.this.hOx.eGZ != view) {
                    if (view == c.this.hOx.fsr.getCommentContainer()) {
                        c.this.b(jVar);
                        i = 5;
                    } else if (view == c.this.hOx.ftd.dJa.getCommentContainer()) {
                        c.this.b(jVar);
                    } else if (c.this.hOx.bEC() != null && view.getId() == c.this.hOx.bEC().getId()) {
                        i = 2;
                    } else if (c.this.hOx.bED() != null && view.getId() == c.this.hOx.bED().getId()) {
                        i = 2;
                    }
                } else {
                    String str = "";
                    long j = 0;
                    if (jVar != null && jVar.aIw() != null) {
                        i = jVar.aIw().aKX().live_type;
                        str = jVar.aIw().getTid();
                        j = jVar.aIw().aKX().live_id;
                    }
                    an anVar = new an("c11824");
                    anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.cI(TiebaInitialize.Params.AB_TAG, jVar.bFi());
                    anVar.t(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
                    anVar.af("obj_type", i);
                    anVar.cI("tid", str);
                    anVar.cI("obj_param1", jVar.getExtra());
                    anVar.cI("obj_source", jVar.getSource());
                    anVar.af("obj_floor", jVar.bFh());
                    TiebaStatic.log(anVar);
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.c.a.a(jVar.dqA, c.this.ebv, jVar.bFh(), i);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bn */
    public a b(ViewGroup viewGroup) {
        this.hOx = new com.baidu.tieba.card.j(this.mPageContext, this.ebv);
        this.hOx.currentPageType = 2;
        if (this.hOx.fsr != null) {
            this.hOx.fsr.dIc = 2;
        }
        if (this.hOx.ftd != null && this.hOx.ftd.dJa != null) {
            this.hOx.ftd.dJa.dIc = 2;
        }
        if (this.ebv != null) {
            this.hOx.m(this.ebv);
        }
        return new a(this.hOx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        jVar.rN(jVar.position + 1);
        if (aVar.hOz instanceof com.baidu.tieba.a.e) {
            aVar.hOz.setPage(this.aey);
        }
        aVar.hOz.rJ(i + 1);
        aVar.hOz.a(jVar);
        aVar.hOz.c(this.gEg);
        aVar.hOz.b(this.euS);
        String str = "";
        if (jVar != null && jVar.aIw() != null) {
            int i2 = jVar.aIw().aKX().live_type;
            String tid = jVar.aIw().getTid();
            if (!StringUtils.isNull(jVar.aIw().aKX().appId)) {
                str = jVar.aIw().aKX().appId;
            }
            long j = jVar.aIw().aKX().live_id;
            an anVar = new an("c11823");
            anVar.af("obj_type", i2);
            anVar.cI(TiebaInitialize.Params.OBJ_PARAM3, str);
            anVar.cI("tid", tid);
            anVar.cI(TiebaInitialize.Params.AB_TAG, jVar.bFi());
            anVar.t(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
            anVar.t("fid", jVar.aIw().getFid());
            anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cI("obj_param1", jVar.getExtra());
            anVar.cI("obj_source", jVar.getSource());
            anVar.af("obj_floor", jVar.bFh());
            TiebaStatic.log(anVar);
        }
        com.baidu.tieba.homepage.personalize.c.a.a(jVar.dqA, this.ebv, jVar.bFh());
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.j jVar) {
        String str = "";
        if (jVar != null && jVar.aIw() != null) {
            str = jVar.aIw().getTid();
        }
        an anVar = new an("c12942");
        anVar.af("obj_locate", 1);
        anVar.af("obj_type", 5);
        anVar.cI("tid", str);
        anVar.cI("obj_source", jVar.getSource());
        TiebaStatic.log(anVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.euS = aVar;
    }

    /* loaded from: classes9.dex */
    public static class a extends y.a {
        public com.baidu.tieba.card.j hOz;

        public a(com.baidu.tieba.card.j jVar) {
            super(jVar.getView());
            this.hOz = jVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void yc(String str) {
        this.aey = str;
    }
}
