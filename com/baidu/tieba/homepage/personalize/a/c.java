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
/* loaded from: classes16.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, a> implements com.baidu.tieba.a.f {
    private String agJ;
    public BdUniqueId ePz;
    private NEGFeedBackView.a flN;
    com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k> hyv;
    private com.baidu.tieba.card.k iOi;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.flN = null;
        this.hyv = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                int i = 0;
                if (c.this.iOi.fuq != view) {
                    if (view == c.this.iOi.gje.getCommentContainer()) {
                        c.this.b(kVar);
                        i = 5;
                    } else if (view == c.this.iOi.hhh.getCommentContainer()) {
                        c.this.b(kVar);
                    } else if (c.this.iOi.cbD() != null && view.getId() == c.this.iOi.cbD().getId()) {
                        i = 2;
                    } else if (c.this.iOi.cbE() != null && view.getId() == c.this.iOi.cbE().getId()) {
                        i = 2;
                    }
                } else {
                    String str = "";
                    long j = 0;
                    if (kVar != null && kVar.bce() != null) {
                        i = kVar.bce().beY().live_type;
                        str = kVar.bce().getTid();
                        j = kVar.bce().beY().live_id;
                    }
                    aq aqVar = new aq("c11824");
                    aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.dD("ab_tag", kVar.ccl());
                    aqVar.u(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
                    aqVar.ai("obj_type", i);
                    aqVar.dD("tid", str);
                    aqVar.dD("obj_param1", kVar.getExtra());
                    aqVar.dD("obj_source", kVar.getSource());
                    aqVar.ai("obj_floor", kVar.cck());
                    TiebaStatic.log(aqVar);
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.c.a.a(kVar.dUW, c.this.ePz, kVar.cck(), i);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bD */
    public a b(ViewGroup viewGroup) {
        this.iOi = new com.baidu.tieba.card.k(this.mPageContext, this.ePz);
        this.iOi.vp(2);
        if (this.ePz != null) {
            this.iOi.p(this.ePz);
        }
        return new a(this.iOi);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, a aVar) {
        kVar.vy(kVar.position + 1);
        if (aVar.iOk instanceof com.baidu.tieba.a.e) {
            aVar.iOk.setPage(this.agJ);
        }
        aVar.iOk.vu(i + 1);
        aVar.iOk.a(kVar);
        aVar.iOk.c(this.hyv);
        aVar.iOk.b(this.flN);
        String str = "";
        if (kVar != null && kVar.bce() != null) {
            int i2 = kVar.bce().beY().live_type;
            String tid = kVar.bce().getTid();
            if (!StringUtils.isNull(kVar.bce().beY().appId)) {
                str = kVar.bce().beY().appId;
            }
            long j = kVar.bce().beY().live_id;
            aq aqVar = new aq("c11823");
            aqVar.ai("obj_type", i2);
            aqVar.dD(TiebaInitialize.Params.OBJ_PARAM3, str);
            aqVar.dD("tid", tid);
            aqVar.dD("ab_tag", kVar.ccl());
            aqVar.u(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
            aqVar.u("fid", kVar.bce().getFid());
            aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dD("obj_param1", kVar.getExtra());
            aqVar.dD("obj_source", kVar.getSource());
            aqVar.ai("obj_floor", kVar.cck());
            TiebaStatic.log(aqVar);
        }
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.dUW, this.ePz, kVar.cck());
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.k kVar) {
        String str = "";
        String str2 = "";
        if (kVar != null && kVar.bce() != null) {
            str = kVar.bce().getTid();
            str2 = kVar.bce().getNid();
        }
        aq aqVar = new aq("c12942");
        aqVar.ai("obj_locate", 1);
        aqVar.ai("obj_type", 5);
        aqVar.dD("tid", str);
        aqVar.dD("obj_source", kVar.getSource());
        aqVar.dD("nid", str2);
        TiebaStatic.log(aqVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.flN = aVar;
    }

    /* loaded from: classes16.dex */
    public static class a extends af.a {
        public com.baidu.tieba.card.k iOk;

        public a(com.baidu.tieba.card.k kVar) {
            super(kVar.getView());
            this.iOk = kVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void Dk(String str) {
        this.agJ = str;
    }
}
