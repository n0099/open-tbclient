package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.af;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
/* loaded from: classes21.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, a> implements com.baidu.tieba.a.f {
    private String ahc;
    public BdUniqueId eSq;
    private NEGFeedBackView.a foG;
    com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k> hFx;
    private com.baidu.tieba.card.k iWO;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.foG = null;
        this.hFx = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                int i = 0;
                if (c.this.iWO.fxB != view) {
                    if (view == c.this.iWO.gml.getCommentContainer()) {
                        c.this.b(kVar);
                        i = 5;
                    } else if (view == c.this.iWO.hol.getCommentContainer()) {
                        c.this.b(kVar);
                    } else if (c.this.iWO.ceS() != null && view.getId() == c.this.iWO.ceS().getId()) {
                        i = 2;
                    } else if (c.this.iWO.ceT() != null && view.getId() == c.this.iWO.ceT().getId()) {
                        i = 2;
                    }
                } else {
                    String str = "";
                    long j = 0;
                    if (kVar != null && kVar.bcY() != null) {
                        i = kVar.bcY().bfS().live_type;
                        str = kVar.bcY().getTid();
                        j = kVar.bcY().bfS().live_id;
                    }
                    aq aqVar = new aq("c11824");
                    aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.dF("ab_tag", kVar.cfA());
                    aqVar.u(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
                    aqVar.ai("obj_type", i);
                    aqVar.dF("tid", str);
                    aqVar.dF("obj_param1", kVar.getExtra());
                    aqVar.dF("obj_source", kVar.getSource());
                    aqVar.ai("obj_floor", kVar.cfz());
                    TiebaStatic.log(aqVar);
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.c.a.a(kVar.dXg, c.this.eSq, kVar.cfz(), i);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bE */
    public a c(ViewGroup viewGroup) {
        this.iWO = new com.baidu.tieba.card.k(this.mPageContext, this.eSq);
        this.iWO.vO(2);
        if (this.eSq != null) {
            this.iWO.o(this.eSq);
        }
        return new a(this.iWO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, a aVar) {
        kVar.vX(kVar.position + 1);
        if (aVar.iWQ instanceof com.baidu.tieba.a.e) {
            aVar.iWQ.setPage(this.ahc);
        }
        aVar.iWQ.vT(i + 1);
        aVar.iWQ.a(kVar);
        aVar.iWQ.c(this.hFx);
        aVar.iWQ.b(this.foG);
        String str = "";
        if (kVar != null && kVar.bcY() != null) {
            int i2 = kVar.bcY().bfS().live_type;
            String tid = kVar.bcY().getTid();
            if (!StringUtils.isNull(kVar.bcY().bfS().appId)) {
                str = kVar.bcY().bfS().appId;
            }
            long j = kVar.bcY().bfS().live_id;
            aq aqVar = new aq("c11823");
            aqVar.ai("obj_type", i2);
            aqVar.dF(TiebaInitialize.Params.OBJ_PARAM3, str);
            aqVar.dF("tid", tid);
            aqVar.dF("ab_tag", kVar.cfA());
            aqVar.u(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
            aqVar.u("fid", kVar.bcY().getFid());
            aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dF("obj_param1", kVar.getExtra());
            aqVar.dF("obj_source", kVar.getSource());
            aqVar.ai("obj_floor", kVar.cfz());
            TiebaStatic.log(aqVar);
        }
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.dXg, this.eSq, kVar.cfz());
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.k kVar) {
        String str = "";
        String str2 = "";
        if (kVar != null && kVar.bcY() != null) {
            str = kVar.bcY().getTid();
            str2 = kVar.bcY().getNid();
        }
        aq aqVar = new aq("c12942");
        aqVar.ai("obj_locate", 1);
        aqVar.ai("obj_type", 5);
        aqVar.dF("tid", str);
        aqVar.dF("obj_source", kVar.getSource());
        aqVar.dF("nid", str2);
        TiebaStatic.log(aqVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.foG = aVar;
    }

    /* loaded from: classes21.dex */
    public static class a extends af.a {
        public com.baidu.tieba.card.k iWQ;

        public a(com.baidu.tieba.card.k kVar) {
            super(kVar.getView());
            this.iWQ = kVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void DH(String str) {
        this.ahc = str;
    }
}
