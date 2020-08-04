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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
/* loaded from: classes16.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, a> implements com.baidu.tieba.a.f {
    private String afx;
    public BdUniqueId eEU;
    private NEGFeedBackView.a far;
    com.baidu.tieba.card.aa<com.baidu.tieba.card.data.j> hly;
    private com.baidu.tieba.card.k izk;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.far = null;
        this.hly = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (c.this.izk.fiQ != view) {
                    if (view == c.this.izk.fXb.getCommentContainer()) {
                        c.this.b(jVar);
                        i = 5;
                    } else if (view == c.this.izk.gUl.getCommentContainer()) {
                        c.this.b(jVar);
                    } else if (c.this.izk.bRq() != null && view.getId() == c.this.izk.bRq().getId()) {
                        i = 2;
                    } else if (c.this.izk.bRr() != null && view.getId() == c.this.izk.bRr().getId()) {
                        i = 2;
                    }
                } else {
                    String str = "";
                    long j = 0;
                    if (jVar != null && jVar.aTN() != null) {
                        i = jVar.aTN().aWF().live_type;
                        str = jVar.aTN().getTid();
                        j = jVar.aTN().aWF().live_id;
                    }
                    ap apVar = new ap("c11824");
                    apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
                    apVar.dn("ab_tag", jVar.bRY());
                    apVar.t(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
                    apVar.ah("obj_type", i);
                    apVar.dn("tid", str);
                    apVar.dn("obj_param1", jVar.getExtra());
                    apVar.dn("obj_source", jVar.getSource());
                    apVar.ah("obj_floor", jVar.bRX());
                    TiebaStatic.log(apVar);
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.c.a.a(jVar.dLK, c.this.eEU, jVar.bRX(), i);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bG */
    public a b(ViewGroup viewGroup) {
        this.izk = new com.baidu.tieba.card.k(this.mPageContext, this.eEU);
        this.izk.ta(2);
        if (this.eEU != null) {
            this.izk.p(this.eEU);
        }
        return new a(this.izk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        jVar.tj(jVar.position + 1);
        if (aVar.izm instanceof com.baidu.tieba.a.e) {
            aVar.izm.setPage(this.afx);
        }
        aVar.izm.tf(i + 1);
        aVar.izm.a(jVar);
        aVar.izm.c(this.hly);
        aVar.izm.b(this.far);
        String str = "";
        if (jVar != null && jVar.aTN() != null) {
            int i2 = jVar.aTN().aWF().live_type;
            String tid = jVar.aTN().getTid();
            if (!StringUtils.isNull(jVar.aTN().aWF().appId)) {
                str = jVar.aTN().aWF().appId;
            }
            long j = jVar.aTN().aWF().live_id;
            ap apVar = new ap("c11823");
            apVar.ah("obj_type", i2);
            apVar.dn(TiebaInitialize.Params.OBJ_PARAM3, str);
            apVar.dn("tid", tid);
            apVar.dn("ab_tag", jVar.bRY());
            apVar.t(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
            apVar.t("fid", jVar.aTN().getFid());
            apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
            apVar.dn("obj_param1", jVar.getExtra());
            apVar.dn("obj_source", jVar.getSource());
            apVar.ah("obj_floor", jVar.bRX());
            TiebaStatic.log(apVar);
        }
        com.baidu.tieba.homepage.personalize.c.a.a(jVar.dLK, this.eEU, jVar.bRX());
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.j jVar) {
        String str = "";
        String str2 = "";
        if (jVar != null && jVar.aTN() != null) {
            str = jVar.aTN().getTid();
            str2 = jVar.aTN().getNid();
        }
        ap apVar = new ap("c12942");
        apVar.ah("obj_locate", 1);
        apVar.ah("obj_type", 5);
        apVar.dn("tid", str);
        apVar.dn("obj_source", jVar.getSource());
        apVar.dn("nid", str2);
        TiebaStatic.log(apVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.far = aVar;
    }

    /* loaded from: classes16.dex */
    public static class a extends ad.a {
        public com.baidu.tieba.card.k izm;

        public a(com.baidu.tieba.card.k kVar) {
            super(kVar.getView());
            this.izm = kVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void AP(String str) {
        this.afx = str;
    }
}
