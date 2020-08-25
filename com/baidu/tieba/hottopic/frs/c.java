package com.baidu.tieba.hottopic.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
import com.baidu.tieba.frs.k;
/* loaded from: classes15.dex */
public class c extends k<bw, com.baidu.tieba.card.a.a<v>> implements x {
    private aa<bw> fFR;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hZl;
    private com.baidu.adp.lib.d.b<TbImageView> hZm;
    private String mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.fFR = new aa<bw>() { // from class: com.baidu.tieba.hottopic.frs.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, bw bwVar, Object obj) {
                if (view != null && bwVar != null && bwVar.beE() != null) {
                    if ("c13010".equals(c.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").ai("obj_type", 4).u("fid", bwVar.getFid()).dD("tid", bwVar.getTid()));
                    }
                    if (view.getId() == R.id.card_root_layout) {
                        TiebaStatic.log(new aq("c13020").u("fid", bwVar.getFid()).dD("obj_name", bwVar.beE().getName_show()).dD("tid", bwVar.getTid()));
                    }
                }
            }
        };
        this.hZl = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.hottopic.frs.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: coB */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(c.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public void destroyObject(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public ConstrainImageLayout activateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: e */
            public ConstrainImageLayout passivateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.hZm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.hottopic.frs.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: blb */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(c.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(ap.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: a */
            public void destroyObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: b */
            public TbImageView activateObject(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public TbImageView passivateObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.tieba.frs.k
    public void a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext.getPageActivity();
            this.mPageContext = tbPageContext;
            this.mPageId = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.card.x
    public String Va() {
        return "FrsHottopicDelegateAdapter";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a<v> b(ViewGroup viewGroup) {
        v vVar = new v(this.mPageContext, viewGroup);
        vVar.setConstrainImagePool(this.hZm);
        vVar.setConstrainLayoutPool(this.hZl);
        return new com.baidu.tieba.card.a.a<>(vVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bw bwVar, com.baidu.tieba.card.a.a<v> aVar) {
        if (aVar == null || aVar.ccE() == null) {
            return null;
        }
        aVar.ccE().c(this.fFR);
        aVar.ccE().a(bwVar);
        if (bwVar != null && bwVar.beE() != null) {
            aq aqVar = new aq("c13019");
            aqVar.dD("tid", bwVar.getTid()).u("fid", bwVar.getFid()).dD("obj_name", bwVar.beE().getName_show());
            s.cbX().e(aqVar);
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.x
    public void setFrom(String str) {
        this.mFrom = str;
    }
}
