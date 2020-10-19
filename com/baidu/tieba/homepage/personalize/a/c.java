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
/* loaded from: classes22.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, a> implements com.baidu.tieba.a.f {
    private String aht;
    private NEGFeedBackView.a fAU;
    public BdUniqueId fey;
    com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k> hUs;
    private com.baidu.tieba.card.k jlM;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fAU = null;
        this.hUs = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                int i = 0;
                if (c.this.jlM.fJK != view) {
                    if (view == c.this.jlM.gAE.getCommentContainer()) {
                        c.this.b(kVar);
                        i = 5;
                    } else if (view == c.this.jlM.hDf.getCommentContainer()) {
                        c.this.b(kVar);
                    } else if (c.this.jlM.cio() != null && view.getId() == c.this.jlM.cio().getId()) {
                        i = 2;
                    } else if (c.this.jlM.cip() != null && view.getId() == c.this.jlM.cip().getId()) {
                        i = 2;
                    }
                } else {
                    String str = "";
                    long j = 0;
                    if (kVar != null && kVar.bfG() != null) {
                        i = kVar.bfG().biB().live_type;
                        str = kVar.bfG().getTid();
                        j = kVar.bfG().biB().live_id;
                    }
                    aq aqVar = new aq("c11824");
                    aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.dK("ab_tag", kVar.ciW());
                    aqVar.u(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
                    aqVar.aj("obj_type", i);
                    aqVar.dK("tid", str);
                    aqVar.dK("obj_param1", kVar.getExtra());
                    aqVar.dK("obj_source", kVar.getSource());
                    aqVar.aj("obj_floor", kVar.ciV());
                    TiebaStatic.log(aqVar);
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.c.a.a(kVar.eji, c.this.fey, kVar.ciV(), i);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bG */
    public a c(ViewGroup viewGroup) {
        this.jlM = new com.baidu.tieba.card.k(this.mPageContext, this.fey);
        this.jlM.wu(2);
        if (this.fey != null) {
            this.jlM.o(this.fey);
        }
        return new a(this.jlM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, a aVar) {
        kVar.wD(kVar.position + 1);
        if (aVar.jlO instanceof com.baidu.tieba.a.e) {
            aVar.jlO.setPage(this.aht);
        }
        aVar.jlO.wz(i + 1);
        aVar.jlO.a(kVar);
        aVar.jlO.c(this.hUs);
        aVar.jlO.b(this.fAU);
        String str = "";
        if (kVar != null && kVar.bfG() != null) {
            int i2 = kVar.bfG().biB().live_type;
            String tid = kVar.bfG().getTid();
            if (!StringUtils.isNull(kVar.bfG().biB().appId)) {
                str = kVar.bfG().biB().appId;
            }
            long j = kVar.bfG().biB().live_id;
            aq aqVar = new aq("c11823");
            aqVar.aj("obj_type", i2);
            aqVar.dK(TiebaInitialize.Params.OBJ_PARAM3, str);
            aqVar.dK("tid", tid);
            aqVar.dK("ab_tag", kVar.ciW());
            aqVar.u(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
            aqVar.u("fid", kVar.bfG().getFid());
            aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dK("obj_param1", kVar.getExtra());
            aqVar.dK("obj_source", kVar.getSource());
            aqVar.aj("obj_floor", kVar.ciV());
            TiebaStatic.log(aqVar);
        }
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.eji, this.fey, kVar.ciV());
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.k kVar) {
        String str = "";
        String str2 = "";
        if (kVar != null && kVar.bfG() != null) {
            str = kVar.bfG().getTid();
            str2 = kVar.bfG().getNid();
        }
        aq aqVar = new aq("c12942");
        aqVar.aj("obj_locate", 1);
        aqVar.aj("obj_type", 5);
        aqVar.dK("tid", str);
        aqVar.dK("obj_source", kVar.getSource());
        aqVar.dK("nid", str2);
        TiebaStatic.log(aqVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.fAU = aVar;
    }

    /* loaded from: classes22.dex */
    public static class a extends af.a {
        public com.baidu.tieba.card.k jlO;

        public a(com.baidu.tieba.card.k kVar) {
            super(kVar.getView());
            this.jlO = kVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void Es(String str) {
        this.aht = str;
    }
}
