package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
/* loaded from: classes22.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, a> implements com.baidu.tieba.a.f {
    private String ahu;
    private NEGFeedBackView.a fPf;
    public BdUniqueId fsQ;
    com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k> imQ;
    private com.baidu.tieba.card.k jEg;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fPf = null;
        this.imQ = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                int i = 0;
                if (c.this.jEg.fXV != view) {
                    if (view == c.this.jEg.gSR.getCommentContainer()) {
                        c.this.b(kVar);
                        i = 5;
                    } else if (view == c.this.jEg.hVy.getCommentContainer()) {
                        c.this.b(kVar);
                    } else if (c.this.jEg.cnW() != null && view.getId() == c.this.jEg.cnW().getId()) {
                        i = 2;
                    } else if (c.this.jEg.cnX() != null && view.getId() == c.this.jEg.cnX().getId()) {
                        i = 2;
                    }
                } else {
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.c.a.a(kVar.exA, c.this.fsQ, kVar.coD(), i);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bI */
    public a c(ViewGroup viewGroup) {
        this.jEg = new com.baidu.tieba.card.k(this.mPageContext, this.fsQ);
        this.jEg.xa(2);
        if (this.fsQ != null) {
            this.jEg.o(this.fsQ);
        }
        return new a(this.jEg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, a aVar) {
        kVar.xj(kVar.position + 1);
        if (aVar.jEi instanceof com.baidu.tieba.a.e) {
            aVar.jEi.setPage(this.ahu);
        }
        aVar.jEi.xf(i + 1);
        aVar.jEi.a(kVar);
        aVar.jEi.c(this.imQ);
        aVar.jEi.b(this.fPf);
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.exA, this.fsQ, kVar.coD());
        if (kVar.bjZ() != null && kVar.bjZ().bmU() != null) {
            aq aqVar = new aq("c14007");
            aqVar.al("obj_locate", 1);
            aqVar.w("obj_param1", kVar.bjZ().bmU().live_id);
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(aqVar);
        }
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
        public com.baidu.tieba.card.k jEi;

        public a(com.baidu.tieba.card.k kVar) {
            super(kVar.getView());
            this.jEi = kVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void EZ(String str) {
        this.ahu = str;
    }
}
