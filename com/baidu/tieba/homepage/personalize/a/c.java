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
/* loaded from: classes22.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, a> implements com.baidu.tieba.a.f {
    private String aiw;
    private NEGFeedBackView.a fWC;
    public BdUniqueId fzO;
    com.baidu.tieba.card.ab<com.baidu.tieba.card.data.j> iyz;
    private com.baidu.tieba.card.k jSJ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fWC = null;
        this.iyz = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (c.this.jSJ.gfP != view) {
                    if (view == c.this.jSJ.hbN.getCommentContainer()) {
                        c.this.a(jVar, view);
                        i = 5;
                    } else if (view == c.this.jSJ.igX.getCommentContainer()) {
                        c.this.a(jVar, view);
                    } else if (c.this.jSJ.crM() != null && view.getId() == c.this.jSJ.crM().getId()) {
                        i = 2;
                    } else if (c.this.jSJ.crN() != null && view.getId() == c.this.jSJ.crN().getId()) {
                        i = 2;
                    }
                } else {
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.c.a.a(jVar.eCR, c.this.fzO, jVar.cst(), i);
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
        this.jSJ = new com.baidu.tieba.card.k(this.mPageContext, this.fzO);
        this.jSJ.ye(2);
        if (this.fzO != null) {
            this.jSJ.o(this.fzO);
        }
        return new a(this.jSJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        jVar.ym(jVar.position + 1);
        if (aVar.jSL instanceof com.baidu.tieba.a.e) {
            aVar.jSL.setPage(this.aiw);
        }
        aVar.jSL.yj(i + 1);
        aVar.jSL.a(jVar);
        aVar.jSL.c(this.iyz);
        aVar.jSL.b(this.fWC);
        com.baidu.tieba.homepage.personalize.c.a.a(jVar.eCR, this.fzO, jVar.cst());
        if (jVar.bmn() != null && jVar.bmn().bpj() != null) {
            ar arVar = new ar("c14007");
            arVar.al("obj_locate", 1);
            arVar.w("obj_param1", jVar.bmn().bpj().live_id);
            arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(arVar);
        }
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.card.data.j jVar, View view) {
        String str = "";
        String str2 = "";
        if (jVar != null && jVar.bmn() != null) {
            str = jVar.bmn().getTid();
            str2 = jVar.bmn().getNid();
        }
        ar arVar = new ar("c12942");
        arVar.al("obj_locate", 1);
        arVar.al("obj_type", 5);
        arVar.dY("tid", str);
        arVar.dY("obj_source", jVar.getSource());
        arVar.dY("nid", str2);
        com.baidu.tbadk.pageExtra.c bM = com.baidu.tbadk.pageExtra.d.bM(view);
        if (bM != null) {
            arVar.dY("obj_cur_page", bM.getCurrentPageKey());
        }
        if (com.baidu.tbadk.pageExtra.d.bET() != null) {
            arVar.dY("obj_pre_page", com.baidu.tbadk.pageExtra.d.bET());
        }
        TiebaStatic.log(arVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.fWC = aVar;
    }

    /* loaded from: classes22.dex */
    public static class a extends af.a {
        public com.baidu.tieba.card.k jSL;

        public a(com.baidu.tieba.card.k kVar) {
            super(kVar.getView());
            this.jSL = kVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }
}
