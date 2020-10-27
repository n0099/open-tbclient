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
    private NEGFeedBackView.a fJp;
    public BdUniqueId fmX;
    com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k> igS;
    private com.baidu.tieba.card.k jyj;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fJp = null;
        this.igS = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                int i = 0;
                if (c.this.jyj.fSf != view) {
                    if (view == c.this.jyj.gMs.getCommentContainer()) {
                        c.this.b(kVar);
                        i = 5;
                    } else if (view == c.this.jyj.hPB.getCommentContainer()) {
                        c.this.b(kVar);
                    } else if (c.this.jyj.clv() != null && view.getId() == c.this.jyj.clv().getId()) {
                        i = 2;
                    } else if (c.this.jyj.clw() != null && view.getId() == c.this.jyj.clw().getId()) {
                        i = 2;
                    }
                } else {
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.c.a.a(kVar.erH, c.this.fmX, kVar.cmc(), i);
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
        this.jyj = new com.baidu.tieba.card.k(this.mPageContext, this.fmX);
        this.jyj.wN(2);
        if (this.fmX != null) {
            this.jyj.o(this.fmX);
        }
        return new a(this.jyj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, a aVar) {
        kVar.wW(kVar.position + 1);
        if (aVar.jyl instanceof com.baidu.tieba.a.e) {
            aVar.jyl.setPage(this.ahu);
        }
        aVar.jyl.wS(i + 1);
        aVar.jyl.a(kVar);
        aVar.jyl.c(this.igS);
        aVar.jyl.b(this.fJp);
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.erH, this.fmX, kVar.cmc());
        if (kVar.bhz() != null && kVar.bhz().bku() != null) {
            aq aqVar = new aq("c14007");
            aqVar.aj("obj_locate", 1);
            aqVar.w("obj_param1", kVar.bhz().bku().live_id);
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(aqVar);
        }
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
        public com.baidu.tieba.card.k jyl;

        public a(com.baidu.tieba.card.k kVar) {
            super(kVar.getView());
            this.jyl = kVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void EL(String str) {
        this.ahu = str;
    }
}
