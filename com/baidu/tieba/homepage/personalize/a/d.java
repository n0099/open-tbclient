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
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, a> implements com.baidu.tieba.a.f {
    private String ahu;
    private NEGFeedBackView.a fJp;
    public BdUniqueId fmX;
    com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k> igS;
    private com.baidu.tieba.card.l jym;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fJp = null;
        this.igS = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                int i = 0;
                if (d.this.jym.fSf != view) {
                    if (view == d.this.jym.gMs.getCommentContainer()) {
                        d.this.b(kVar);
                        i = 5;
                    } else if (view == d.this.jym.hPB.getCommentContainer()) {
                        d.this.b(kVar);
                    } else if (d.this.jym.clv() != null && view.getId() == d.this.jym.clv().getId()) {
                        i = 2;
                    } else if (d.this.jym.clw() != null && view.getId() == d.this.jym.clw().getId()) {
                        i = 2;
                    }
                } else {
                    String str = "";
                    long j = 0;
                    if (kVar != null && kVar.bhz() != null) {
                        i = kVar.bhz().bku().live_type;
                        str = kVar.bhz().getTid();
                        j = kVar.bhz().bku().live_id;
                    }
                    aq aqVar = new aq("c11824");
                    aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.dR("ab_tag", kVar.cmd());
                    aqVar.w(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
                    aqVar.aj("obj_type", i);
                    aqVar.dR("tid", str);
                    aqVar.dR("obj_param1", kVar.getExtra());
                    aqVar.dR("obj_source", kVar.getSource());
                    aqVar.aj("obj_floor", kVar.cmc());
                    TiebaStatic.log(aqVar);
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.c.a.a(kVar.erH, d.this.fmX, kVar.cmc(), i);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bH */
    public a c(ViewGroup viewGroup) {
        this.jym = new com.baidu.tieba.card.l(this.mPageContext, this.fmX);
        this.jym.wN(2);
        if (this.fmX != null) {
            this.jym.o(this.fmX);
        }
        return new a(this.jym);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, a aVar) {
        kVar.wW(kVar.position + 1);
        if (aVar.jyo instanceof com.baidu.tieba.a.e) {
            aVar.jyo.setPage(this.ahu);
        }
        aVar.jyo.wS(i + 1);
        aVar.jyo.a(kVar);
        aVar.jyo.c(this.igS);
        aVar.jyo.b(this.fJp);
        String str = "";
        if (kVar != null && kVar.bhz() != null) {
            int i2 = kVar.bhz().bku().live_type;
            String tid = kVar.bhz().getTid();
            if (!StringUtils.isNull(kVar.bhz().bku().appId)) {
                str = kVar.bhz().bku().appId;
            }
            long j = kVar.bhz().bku().live_id;
            aq aqVar = new aq("c11823");
            aqVar.aj("obj_type", i2);
            aqVar.dR(TiebaInitialize.Params.OBJ_PARAM3, str);
            aqVar.dR("tid", tid);
            aqVar.dR("ab_tag", kVar.cmd());
            aqVar.w(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
            aqVar.w("fid", kVar.bhz().getFid());
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dR("obj_param1", kVar.getExtra());
            aqVar.dR("obj_source", kVar.getSource());
            aqVar.aj("obj_floor", kVar.cmc());
            TiebaStatic.log(aqVar);
        }
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.erH, this.fmX, kVar.cmc());
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.k kVar) {
        String str = "";
        String str2 = "";
        if (kVar != null && kVar.bhz() != null) {
            str = kVar.bhz().getTid();
            str2 = kVar.bhz().getNid();
        }
        aq aqVar = new aq("c12942");
        aqVar.aj("obj_locate", 1);
        aqVar.aj("obj_type", 5);
        aqVar.dR("tid", str);
        aqVar.dR("obj_source", kVar.getSource());
        aqVar.dR("nid", str2);
        TiebaStatic.log(aqVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.fJp = aVar;
    }

    /* loaded from: classes22.dex */
    public static class a extends af.a {
        public com.baidu.tieba.card.l jyo;

        public a(com.baidu.tieba.card.l lVar) {
            super(lVar.getView());
            this.jyo = lVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void EL(String str) {
        this.ahu = str;
    }
}
