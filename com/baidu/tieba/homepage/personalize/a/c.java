package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, a> implements com.baidu.tieba.a.f {
    private String afG;
    private NEGFeedBackView.a eTW;
    public BdUniqueId eyE;
    com.baidu.tieba.card.aa<com.baidu.tieba.card.data.j> hfO;
    private com.baidu.tieba.card.k ite;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eTW = null;
        this.hfO = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (c.this.ite.fdX != view) {
                    if (view == c.this.ite.fRI.getCommentContainer()) {
                        c.this.b(jVar);
                        i = 5;
                    } else if (view == c.this.ite.gOF.getCommentContainer()) {
                        c.this.b(jVar);
                    } else if (c.this.ite.bOf() != null && view.getId() == c.this.ite.bOf().getId()) {
                        i = 2;
                    } else if (c.this.ite.bOg() != null && view.getId() == c.this.ite.bOg().getId()) {
                        i = 2;
                    }
                } else {
                    String str = "";
                    long j = 0;
                    if (jVar != null && jVar.aPS() != null) {
                        i = jVar.aPS().aSJ().live_type;
                        str = jVar.aPS().getTid();
                        j = jVar.aPS().aSJ().live_id;
                    }
                    ao aoVar = new ao("c11824");
                    aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
                    aoVar.dk("ab_tag", jVar.bOM());
                    aoVar.s(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
                    aoVar.ag("obj_type", i);
                    aoVar.dk("tid", str);
                    aoVar.dk("obj_param1", jVar.getExtra());
                    aoVar.dk("obj_source", jVar.getSource());
                    aoVar.ag("obj_floor", jVar.bOL());
                    TiebaStatic.log(aoVar);
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.c.a.a(jVar.dLi, c.this.eyE, jVar.bOL(), i);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bF */
    public a b(ViewGroup viewGroup) {
        this.ite = new com.baidu.tieba.card.k(this.mPageContext, this.eyE);
        this.ite.sI(2);
        if (this.eyE != null) {
            this.ite.o(this.eyE);
        }
        return new a(this.ite);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        jVar.sR(jVar.position + 1);
        if (aVar.itg instanceof com.baidu.tieba.a.e) {
            aVar.itg.setPage(this.afG);
        }
        aVar.itg.sN(i + 1);
        aVar.itg.a(jVar);
        aVar.itg.c(this.hfO);
        aVar.itg.b(this.eTW);
        String str = "";
        if (jVar != null && jVar.aPS() != null) {
            int i2 = jVar.aPS().aSJ().live_type;
            String tid = jVar.aPS().getTid();
            if (!StringUtils.isNull(jVar.aPS().aSJ().appId)) {
                str = jVar.aPS().aSJ().appId;
            }
            long j = jVar.aPS().aSJ().live_id;
            ao aoVar = new ao("c11823");
            aoVar.ag("obj_type", i2);
            aoVar.dk(TiebaInitialize.Params.OBJ_PARAM3, str);
            aoVar.dk("tid", tid);
            aoVar.dk("ab_tag", jVar.bOM());
            aoVar.s(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
            aoVar.s("fid", jVar.aPS().getFid());
            aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
            aoVar.dk("obj_param1", jVar.getExtra());
            aoVar.dk("obj_source", jVar.getSource());
            aoVar.ag("obj_floor", jVar.bOL());
            TiebaStatic.log(aoVar);
        }
        com.baidu.tieba.homepage.personalize.c.a.a(jVar.dLi, this.eyE, jVar.bOL());
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.j jVar) {
        String str = "";
        String str2 = "";
        if (jVar != null && jVar.aPS() != null) {
            str = jVar.aPS().getTid();
            str2 = jVar.aPS().getNid();
        }
        ao aoVar = new ao("c12942");
        aoVar.ag("obj_locate", 1);
        aoVar.ag("obj_type", 5);
        aoVar.dk("tid", str);
        aoVar.dk("obj_source", jVar.getSource());
        aoVar.dk("nid", str2);
        TiebaStatic.log(aoVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.eTW = aVar;
    }

    /* loaded from: classes9.dex */
    public static class a extends ad.a {
        public com.baidu.tieba.card.k itg;

        public a(com.baidu.tieba.card.k kVar) {
            super(kVar.getView());
            this.itg = kVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void Ae(String str) {
        this.afG = str;
    }
}
