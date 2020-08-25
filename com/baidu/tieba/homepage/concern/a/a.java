package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.aa;
/* loaded from: classes16.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k>> implements com.baidu.tieba.a.f {
    private String agH;
    public BdUniqueId ePv;
    private aa hyp;
    private com.baidu.tieba.card.k iGT;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.hyp = new aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && a.this.iGT != null && a.this.iGT.getView() != null && kVar != null && kVar.bce() != null && !StringUtils.isNull(kVar.bce().getTid())) {
                    com.baidu.tieba.homepage.concern.b.a(view, kVar, view == a.this.iGT.cbC() ? 1 : 2);
                    if (view == a.this.iGT.gja.getCommentContainer() || view == a.this.iGT.hhd.getCommentContainer()) {
                        aq aqVar = new aq("c12942");
                        aqVar.ai("obj_locate", 7);
                        aqVar.ai("obj_type", 5);
                        aqVar.dD("tid", kVar.bce().getTid());
                        aqVar.dD("nid", kVar.bce().getNid());
                        TiebaStatic.log(aqVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> b(ViewGroup viewGroup) {
        this.iGT = new com.baidu.tieba.card.k(this.mPageContext, this.ePv);
        this.iGT.id(true);
        if (this.ePv != null) {
            this.iGT.p(this.ePv);
        }
        return new com.baidu.tieba.card.a.a<>(this.iGT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> aVar) {
        if (kVar == null || aVar == null || aVar.ccE() == null) {
            return null;
        }
        kVar.vy(i + 1);
        com.baidu.tieba.card.s.cbX().e(kVar.Hd("c12351"));
        if (aVar.ccE() instanceof com.baidu.tieba.a.e) {
            aVar.ccE().setPage(this.agH);
        }
        aVar.ccE().a(kVar);
        aVar.ccE().c(this.hyp);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Dj(String str) {
        this.agH = str;
    }
}
