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
    private String aeB;
    public BdUniqueId ebA;
    private NEGFeedBackView.a euX;
    com.baidu.tieba.card.z<com.baidu.tieba.card.data.j> gEm;
    private com.baidu.tieba.card.j hOD;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.euX = null;
        this.gEm = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (c.this.hOD.eHe != view) {
                    if (view == c.this.hOD.fsw.getCommentContainer()) {
                        c.this.b(jVar);
                        i = 5;
                    } else if (view == c.this.hOD.fti.dJe.getCommentContainer()) {
                        c.this.b(jVar);
                    } else if (c.this.hOD.bEA() != null && view.getId() == c.this.hOD.bEA().getId()) {
                        i = 2;
                    } else if (c.this.hOD.bEB() != null && view.getId() == c.this.hOD.bEB().getId()) {
                        i = 2;
                    }
                } else {
                    String str = "";
                    long j = 0;
                    if (jVar != null && jVar.aIu() != null) {
                        i = jVar.aIu().aKV().live_type;
                        str = jVar.aIu().getTid();
                        j = jVar.aIu().aKV().live_id;
                    }
                    an anVar = new an("c11824");
                    anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.cI(TiebaInitialize.Params.AB_TAG, jVar.bFg());
                    anVar.t(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
                    anVar.af("obj_type", i);
                    anVar.cI("tid", str);
                    anVar.cI("obj_param1", jVar.getExtra());
                    anVar.cI("obj_source", jVar.getSource());
                    anVar.af("obj_floor", jVar.bFf());
                    TiebaStatic.log(anVar);
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.c.a.a(jVar.dqE, c.this.ebA, jVar.bFf(), i);
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
        this.hOD = new com.baidu.tieba.card.j(this.mPageContext, this.ebA);
        this.hOD.currentPageType = 2;
        if (this.hOD.fsw != null) {
            this.hOD.fsw.dIg = 2;
        }
        if (this.hOD.fti != null && this.hOD.fti.dJe != null) {
            this.hOD.fti.dJe.dIg = 2;
        }
        if (this.ebA != null) {
            this.hOD.m(this.ebA);
        }
        return new a(this.hOD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        jVar.rN(jVar.position + 1);
        if (aVar.hOF instanceof com.baidu.tieba.a.e) {
            aVar.hOF.setPage(this.aeB);
        }
        aVar.hOF.rJ(i + 1);
        aVar.hOF.a(jVar);
        aVar.hOF.c(this.gEm);
        aVar.hOF.b(this.euX);
        String str = "";
        if (jVar != null && jVar.aIu() != null) {
            int i2 = jVar.aIu().aKV().live_type;
            String tid = jVar.aIu().getTid();
            if (!StringUtils.isNull(jVar.aIu().aKV().appId)) {
                str = jVar.aIu().aKV().appId;
            }
            long j = jVar.aIu().aKV().live_id;
            an anVar = new an("c11823");
            anVar.af("obj_type", i2);
            anVar.cI(TiebaInitialize.Params.OBJ_PARAM3, str);
            anVar.cI("tid", tid);
            anVar.cI(TiebaInitialize.Params.AB_TAG, jVar.bFg());
            anVar.t(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
            anVar.t("fid", jVar.aIu().getFid());
            anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cI("obj_param1", jVar.getExtra());
            anVar.cI("obj_source", jVar.getSource());
            anVar.af("obj_floor", jVar.bFf());
            TiebaStatic.log(anVar);
        }
        com.baidu.tieba.homepage.personalize.c.a.a(jVar.dqE, this.ebA, jVar.bFf());
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.j jVar) {
        String str = "";
        if (jVar != null && jVar.aIu() != null) {
            str = jVar.aIu().getTid();
        }
        an anVar = new an("c12942");
        anVar.af("obj_locate", 1);
        anVar.af("obj_type", 5);
        anVar.cI("tid", str);
        anVar.cI("obj_source", jVar.getSource());
        TiebaStatic.log(anVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.euX = aVar;
    }

    /* loaded from: classes9.dex */
    public static class a extends y.a {
        public com.baidu.tieba.card.j hOF;

        public a(com.baidu.tieba.card.j jVar) {
            super(jVar.getView());
            this.hOF = jVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void yf(String str) {
        this.aeB = str;
    }
}
