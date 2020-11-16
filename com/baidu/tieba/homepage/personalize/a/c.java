package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
/* loaded from: classes21.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, a> implements com.baidu.tieba.a.f {
    private String ahw;
    private NEGFeedBackView.a fOM;
    public BdUniqueId fsa;
    com.baidu.tieba.card.ab<com.baidu.tieba.card.data.j> inF;
    private com.baidu.tieba.card.k jFe;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fOM = null;
        this.inF = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (c.this.jFe.fXC != view) {
                    if (view == c.this.jFe.gSy.getCommentContainer()) {
                        c.this.b(jVar);
                        i = 5;
                    } else if (view == c.this.jFe.hVY.getCommentContainer()) {
                        c.this.b(jVar);
                    } else if (c.this.jFe.cny() != null && view.getId() == c.this.jFe.cny().getId()) {
                        i = 2;
                    } else if (c.this.jFe.cnz() != null && view.getId() == c.this.jFe.cnz().getId()) {
                        i = 2;
                    }
                } else {
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.c.a.a(jVar.evQ, c.this.fsa, jVar.cof(), i);
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
        this.jFe = new com.baidu.tieba.card.k(this.mPageContext, this.fsa);
        this.jFe.xy(2);
        if (this.fsa != null) {
            this.jFe.o(this.fsa);
        }
        return new a(this.jFe);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        jVar.xH(jVar.position + 1);
        if (aVar.jFg instanceof com.baidu.tieba.a.e) {
            aVar.jFg.setPage(this.ahw);
        }
        aVar.jFg.xD(i + 1);
        aVar.jFg.a(jVar);
        aVar.jFg.c(this.inF);
        aVar.jFg.b(this.fOM);
        com.baidu.tieba.homepage.personalize.c.a.a(jVar.evQ, this.fsa, jVar.cof());
        if (jVar.bjd() != null && jVar.bjd().blW() != null) {
            ar arVar = new ar("c14007");
            arVar.ak("obj_locate", 1);
            arVar.w("obj_param1", jVar.bjd().blW().live_id);
            arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(arVar);
        }
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.j jVar) {
        String str = "";
        String str2 = "";
        if (jVar != null && jVar.bjd() != null) {
            str = jVar.bjd().getTid();
            str2 = jVar.bjd().getNid();
        }
        ar arVar = new ar("c12942");
        arVar.ak("obj_locate", 1);
        arVar.ak("obj_type", 5);
        arVar.dR("tid", str);
        arVar.dR("obj_source", jVar.getSource());
        arVar.dR("nid", str2);
        TiebaStatic.log(arVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.fOM = aVar;
    }

    /* loaded from: classes21.dex */
    public static class a extends af.a {
        public com.baidu.tieba.card.k jFg;

        public a(com.baidu.tieba.card.k kVar) {
            super(kVar.getView());
            this.jFg = kVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void EA(String str) {
        this.ahw = str;
    }
}
