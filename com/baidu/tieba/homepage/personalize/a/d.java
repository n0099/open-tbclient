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
    private NEGFeedBackView.a fPf;
    public BdUniqueId fsQ;
    com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k> imQ;
    private com.baidu.tieba.card.l jEj;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fPf = null;
        this.imQ = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                int i = 0;
                if (d.this.jEj.fXV != view) {
                    if (view == d.this.jEj.gSR.getCommentContainer()) {
                        d.this.b(kVar);
                        i = 5;
                    } else if (view == d.this.jEj.hVy.getCommentContainer()) {
                        d.this.b(kVar);
                    } else if (d.this.jEj.cnW() != null && view.getId() == d.this.jEj.cnW().getId()) {
                        i = 2;
                    } else if (d.this.jEj.cnX() != null && view.getId() == d.this.jEj.cnX().getId()) {
                        i = 2;
                    }
                } else {
                    String str = "";
                    long j = 0;
                    if (kVar != null && kVar.bjZ() != null) {
                        i = kVar.bjZ().bmU().live_type;
                        str = kVar.bjZ().getTid();
                        j = kVar.bjZ().bmU().live_id;
                    }
                    aq aqVar = new aq("c11824");
                    aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.dR("ab_tag", kVar.coE());
                    aqVar.w(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
                    aqVar.al("obj_type", i);
                    aqVar.dR("tid", str);
                    aqVar.dR("obj_param1", kVar.getExtra());
                    aqVar.dR("obj_source", kVar.getSource());
                    aqVar.al("obj_floor", kVar.coD());
                    TiebaStatic.log(aqVar);
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.c.a.a(kVar.exA, d.this.fsQ, kVar.coD(), i);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bJ */
    public a c(ViewGroup viewGroup) {
        this.jEj = new com.baidu.tieba.card.l(this.mPageContext, this.fsQ);
        this.jEj.xa(2);
        if (this.fsQ != null) {
            this.jEj.o(this.fsQ);
        }
        return new a(this.jEj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, a aVar) {
        kVar.xj(kVar.position + 1);
        if (aVar.jEl instanceof com.baidu.tieba.a.e) {
            aVar.jEl.setPage(this.ahu);
        }
        aVar.jEl.xf(i + 1);
        aVar.jEl.a(kVar);
        aVar.jEl.c(this.imQ);
        aVar.jEl.b(this.fPf);
        String str = "";
        if (kVar != null && kVar.bjZ() != null) {
            int i2 = kVar.bjZ().bmU().live_type;
            String tid = kVar.bjZ().getTid();
            if (!StringUtils.isNull(kVar.bjZ().bmU().appId)) {
                str = kVar.bjZ().bmU().appId;
            }
            long j = kVar.bjZ().bmU().live_id;
            aq aqVar = new aq("c11823");
            aqVar.al("obj_type", i2);
            aqVar.dR(TiebaInitialize.Params.OBJ_PARAM3, str);
            aqVar.dR("tid", tid);
            aqVar.dR("ab_tag", kVar.coE());
            aqVar.w(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
            aqVar.w("fid", kVar.bjZ().getFid());
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dR("obj_param1", kVar.getExtra());
            aqVar.dR("obj_source", kVar.getSource());
            aqVar.al("obj_floor", kVar.coD());
            TiebaStatic.log(aqVar);
        }
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.exA, this.fsQ, kVar.coD());
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.k kVar) {
        String str = "";
        String str2 = "";
        if (kVar != null && kVar.bjZ() != null) {
            str = kVar.bjZ().getTid();
            str2 = kVar.bjZ().getNid();
        }
        aq aqVar = new aq("c12942");
        aqVar.al("obj_locate", 1);
        aqVar.al("obj_type", 5);
        aqVar.dR("tid", str);
        aqVar.dR("obj_source", kVar.getSource());
        aqVar.dR("nid", str2);
        TiebaStatic.log(aqVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.fPf = aVar;
    }

    /* loaded from: classes22.dex */
    public static class a extends af.a {
        public com.baidu.tieba.card.l jEl;

        public a(com.baidu.tieba.card.l lVar) {
            super(lVar.getView());
            this.jEl = lVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void EZ(String str) {
        this.ahu = str;
    }
}
