package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.y;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class e extends com.baidu.tieba.frs.h<bb, com.baidu.tieba.card.a.a<y>> implements com.baidu.tieba.a.f, ab, com.baidu.tieba.frs.e.d {
    private String cbk;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dQa;
    private com.baidu.adp.lib.e.b<TbImageView> dQb;
    private com.baidu.tieba.frs.e.b dTF;
    private ad dTH;
    private String mForumName;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dTF = new com.baidu.tieba.frs.e.b();
        this.dTH = new ad() { // from class: com.baidu.tieba.frs.entelechy.a.e.1
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.b bVar, Object obj) {
                if (bVar instanceof bb) {
                    if (e.this.dLj != null) {
                        e.this.dLj.a(view, bVar, bb.atR);
                    }
                    bb bbVar = (bb) bVar;
                    com.baidu.tieba.frs.e.c.aHW().a(e.this.dTF, bbVar, 1);
                    com.baidu.tieba.frs.e.a.a(bbVar, 1, e.this.mPageId, e.this.dTF);
                }
            }
        };
        this.dQa = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aDZ */
            public ConstrainImageLayout jz() {
                return new ConstrainImageLayout(e.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void u(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout v(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout w(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.dQb = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: FH */
            public TbImageView jz() {
                TbImageView tbImageView = new TbImageView(e.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(e.d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void u(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView v(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView w(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void iK(int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<y> onCreateViewHolder(ViewGroup viewGroup) {
        y yVar = new y(this.mPageContext, viewGroup);
        com.baidu.tieba.card.a.a<y> aVar = new com.baidu.tieba.card.a.a<>(yVar);
        yVar.setConstrainImagePool(this.dQb);
        yVar.setConstrainLayoutPool(this.dQa);
        yVar.b(this.dTH);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<y> aVar) {
        if (aVar == null || aVar.arr() == null) {
            return null;
        }
        if (aVar.arr() instanceof com.baidu.tieba.a.e) {
            aVar.arr().setPage(this.cbk);
        }
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        if (this.dTF != null) {
            int i2 = 0;
            if (this.dLc != null) {
                i2 = this.dLc.aHA();
            }
            bbVar.awj = (i + 1) - i2;
        }
        com.baidu.tieba.frs.e.c.aHW().a(this.dTF, bbVar);
        com.baidu.tieba.frs.e.a.a(bbVar, this.mPageId, this.dTF);
        aVar.arr().b(this.dTH);
        aVar.arr().a(bbVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void kb(String str) {
        this.cbk = str;
    }

    @Override // com.baidu.tieba.frs.e.d
    public com.baidu.tieba.frs.e.b aFf() {
        return this.dTF;
    }
}
