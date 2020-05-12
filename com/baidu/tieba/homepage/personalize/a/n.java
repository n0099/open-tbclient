package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class n extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<com.baidu.tieba.card.u>> {
    private com.baidu.tieba.card.z ada;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hdt;
    private com.baidu.adp.lib.d.b<TbImageView> hdu;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ada = new com.baidu.tieba.card.z() { // from class: com.baidu.tieba.homepage.personalize.a.n.1
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.b bVar, Object obj) {
                if ((bVar instanceof bj) && (obj instanceof com.baidu.tieba.card.s)) {
                    TiebaStatic.log(n.this.a("c13024", (bj) bVar, (com.baidu.tieba.card.s) obj));
                }
            }
        };
        this.hdt = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.n.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bQP */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(n.this.mPageContext.getPageActivity());
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
        this.hdu = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.n.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aQE */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(n.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(am.getColor(R.color.common_color_10043));
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ax */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.u> b(ViewGroup viewGroup) {
        com.baidu.tieba.card.u uVar = new com.baidu.tieba.card.u(this.mPageContext, viewGroup);
        com.baidu.tieba.card.a.a<com.baidu.tieba.card.u> aVar = new com.baidu.tieba.card.a.a<>(uVar);
        uVar.setConstrainImagePool(this.hdu);
        uVar.setConstrainLayoutPool(this.hdt);
        uVar.c(this.ada);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.u> aVar) {
        if (aVar == null || aVar.bFA() == null) {
            return null;
        }
        if (kVar != null && kVar.aIu() != null) {
            com.baidu.tieba.card.s sVar = new com.baidu.tieba.card.s();
            sVar.locate = kVar.position + 1;
            sVar.source = kVar.getSource();
            sVar.weight = kVar.getWeight();
            sVar.dpc = kVar.bFh();
            com.baidu.tieba.card.r.bEX().e(a("c13023", kVar.aIu(), sVar));
            aVar.bFA().a(sVar);
            aVar.bFA().c(this.ada);
            aVar.bFA().a(kVar.aIu());
        }
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public an a(String str, bj bjVar, com.baidu.tieba.card.s sVar) {
        if (StringUtils.isNull(str) || bjVar == null || sVar == null) {
            return null;
        }
        an cI = new an(str).cI("fid", String.valueOf(bjVar.getFid())).cI("tid", String.valueOf(bjVar.getTid())).af("obj_locate", sVar.locate).cI("obj_source", sVar.source).cI("obj_param1", sVar.weight).cI(TiebaInitialize.Params.AB_TAG, sVar.dpc).cI(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.l.bEO());
        if (bjVar.aKC() != null) {
            cI.cI("obj_name", bjVar.aKC().getName_show());
            return cI;
        }
        return cI;
    }
}
