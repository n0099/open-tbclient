package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.y;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class e extends com.baidu.tieba.frs.f<bd, com.baidu.tieba.card.a.a<y>> implements com.baidu.tieba.a.f, aa, com.baidu.tieba.frs.e.c {
    private String bER;
    private ab dob;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dod;
    private com.baidu.adp.lib.e.b<TbImageView> doe;
    private String mForumName;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dob = new ab() { // from class: com.baidu.tieba.frs.entelechy.a.e.1
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.b bVar, Object obj) {
                if (bVar instanceof bd) {
                    if (e.this.dhm != null) {
                        e.this.dhm.a(view, bVar, bd.ahS);
                    }
                    com.baidu.tieba.frs.e.b.ayQ().a(com.baidu.tieba.frs.e.c.dyP, (bd) bVar, 1);
                }
            }
        };
        this.dod = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: avY */
            public ConstrainImageLayout mo9if() {
                return new ConstrainImageLayout(e.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void q(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout r(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout s(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.doe = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: AI */
            public TbImageView mo9if() {
                TbImageView tbImageView = new TbImageView(e.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(d.C0141d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void q(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView r(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView s(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.tieba.card.aa
    public void setForumName(String str) {
        this.mForumName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<y> onCreateViewHolder(ViewGroup viewGroup) {
        y yVar = new y(this.mPageContext, viewGroup);
        com.baidu.tieba.card.a.a<y> aVar = new com.baidu.tieba.card.a.a<>(yVar);
        yVar.setConstrainImagePool(this.doe);
        yVar.setConstrainLayoutPool(this.dod);
        yVar.b(this.dob);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, com.baidu.tieba.card.a.a<y> aVar) {
        if (aVar == null || aVar.ajG() == null) {
            return null;
        }
        if (aVar.ajG() instanceof com.baidu.tieba.a.e) {
            aVar.ajG().setPage(this.bER);
        }
        super.onFillViewHolder(i, view, viewGroup, bdVar, aVar);
        com.baidu.tieba.frs.e.b.ayQ().a(dyP, bdVar);
        aVar.ajG().b(this.dob);
        aVar.ajG().a(bdVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void iy(String str) {
        this.bER = str;
    }
}
