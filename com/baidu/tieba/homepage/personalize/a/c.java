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
    private NEGFeedBackView.a eJK;
    public BdUniqueId epM;
    com.baidu.tieba.card.aa<com.baidu.tieba.card.data.j> gTf;
    private com.baidu.tieba.card.k ieb;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eJK = null;
        this.gTf = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (c.this.ieb.eTM != view) {
                    if (view == c.this.ieb.fGz.getCommentContainer()) {
                        c.this.b(jVar);
                        i = 5;
                    } else if (view == c.this.ieb.gBP.getCommentContainer()) {
                        c.this.b(jVar);
                    } else if (c.this.ieb.bKX() != null && view.getId() == c.this.ieb.bKX().getId()) {
                        i = 2;
                    } else if (c.this.ieb.bKY() != null && view.getId() == c.this.ieb.bKY().getId()) {
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
                    anVar.dh("ab_tag", jVar.bLC());
                    anVar.s(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
                    anVar.ag("obj_type", i);
                    anVar.dh("tid", str);
                    anVar.dh("obj_param1", jVar.getExtra());
                    anVar.dh("obj_source", jVar.getSource());
                    anVar.ag("obj_floor", jVar.bLB());
                    TiebaStatic.log(anVar);
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.c.a.a(jVar.dEA, c.this.epM, jVar.bLB(), i);
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
        this.ieb = new com.baidu.tieba.card.k(this.mPageContext, this.epM);
        this.ieb.sk(2);
        if (this.epM != null) {
            this.ieb.o(this.epM);
        }
        return new a(this.ieb);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        jVar.st(jVar.position + 1);
        if (aVar.ied instanceof com.baidu.tieba.a.e) {
            aVar.ied.setPage(this.aeX);
        }
        aVar.ied.sp(i + 1);
        aVar.ied.a(jVar);
        aVar.ied.c(this.gTf);
        aVar.ied.b(this.eJK);
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
            anVar.dh("ab_tag", jVar.bLC());
            anVar.s(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
            anVar.s("fid", jVar.aOi().getFid());
            anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.dh("obj_param1", jVar.getExtra());
            anVar.dh("obj_source", jVar.getSource());
            anVar.ag("obj_floor", jVar.bLB());
            TiebaStatic.log(anVar);
        }
        com.baidu.tieba.homepage.personalize.c.a.a(jVar.dEA, this.epM, jVar.bLB());
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
        this.eJK = aVar;
    }

    /* loaded from: classes9.dex */
    public static class a extends aa.a {
        public com.baidu.tieba.card.k ied;

        public a(com.baidu.tieba.card.k kVar) {
            super(kVar.getView());
            this.ied = kVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void zL(String str) {
        this.aeX = str;
    }
}
