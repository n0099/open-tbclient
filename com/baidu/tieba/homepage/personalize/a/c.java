package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, a> implements com.baidu.tieba.a.f {
    private String aeX;
    private NEGFeedBackView.a eJz;
    public BdUniqueId epM;
    com.baidu.tieba.card.aa<com.baidu.tieba.card.data.j> gSU;
    private com.baidu.tieba.card.k idk;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eJz = null;
        this.gSU = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (c.this.idk.eTB != view) {
                    if (view == c.this.idk.fGo.getCommentContainer()) {
                        c.this.b(jVar);
                        i = 5;
                    } else if (view == c.this.idk.gBE.getCommentContainer()) {
                        c.this.b(jVar);
                    } else if (c.this.idk.bKV() != null && view.getId() == c.this.idk.bKV().getId()) {
                        i = 2;
                    } else if (c.this.idk.bKW() != null && view.getId() == c.this.idk.bKW().getId()) {
                        i = 2;
                    }
                } else {
                    String str = "";
                    long j = 0;
                    if (jVar != null && jVar.aOi() != null) {
                        i = jVar.aOi().aQS().live_type;
                        str = jVar.aOi().getTid();
                        j = jVar.aOi().aQS().live_id;
                    }
                    an anVar = new an("c11824");
                    anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.dh("ab_tag", jVar.bLA());
                    anVar.s(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
                    anVar.ag("obj_type", i);
                    anVar.dh("tid", str);
                    anVar.dh("obj_param1", jVar.getExtra());
                    anVar.dh("obj_source", jVar.getSource());
                    anVar.ag("obj_floor", jVar.bLz());
                    TiebaStatic.log(anVar);
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.c.a.a(jVar.dEA, c.this.epM, jVar.bLz(), i);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bx */
    public a b(ViewGroup viewGroup) {
        this.idk = new com.baidu.tieba.card.k(this.mPageContext, this.epM);
        this.idk.si(2);
        if (this.epM != null) {
            this.idk.o(this.epM);
        }
        return new a(this.idk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        jVar.sr(jVar.position + 1);
        if (aVar.idn instanceof com.baidu.tieba.a.e) {
            aVar.idn.setPage(this.aeX);
        }
        aVar.idn.sn(i + 1);
        aVar.idn.a(jVar);
        aVar.idn.c(this.gSU);
        aVar.idn.b(this.eJz);
        String str = "";
        if (jVar != null && jVar.aOi() != null) {
            int i2 = jVar.aOi().aQS().live_type;
            String tid = jVar.aOi().getTid();
            if (!StringUtils.isNull(jVar.aOi().aQS().appId)) {
                str = jVar.aOi().aQS().appId;
            }
            long j = jVar.aOi().aQS().live_id;
            an anVar = new an("c11823");
            anVar.ag("obj_type", i2);
            anVar.dh(TiebaInitialize.Params.OBJ_PARAM3, str);
            anVar.dh("tid", tid);
            anVar.dh("ab_tag", jVar.bLA());
            anVar.s(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
            anVar.s("fid", jVar.aOi().getFid());
            anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.dh("obj_param1", jVar.getExtra());
            anVar.dh("obj_source", jVar.getSource());
            anVar.ag("obj_floor", jVar.bLz());
            TiebaStatic.log(anVar);
        }
        com.baidu.tieba.homepage.personalize.c.a.a(jVar.dEA, this.epM, jVar.bLz());
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.j jVar) {
        String str = "";
        String str2 = "";
        if (jVar != null && jVar.aOi() != null) {
            str = jVar.aOi().getTid();
            str2 = jVar.aOi().getNid();
        }
        an anVar = new an("c12942");
        anVar.ag("obj_locate", 1);
        anVar.ag("obj_type", 5);
        anVar.dh("tid", str);
        anVar.dh("obj_source", jVar.getSource());
        anVar.dh("nid", str2);
        TiebaStatic.log(anVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.eJz = aVar;
    }

    /* loaded from: classes9.dex */
    public static class a extends aa.a {
        public com.baidu.tieba.card.k idn;

        public a(com.baidu.tieba.card.k kVar) {
            super(kVar.getView());
            this.idn = kVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void zL(String str) {
        this.aeX = str;
    }
}
