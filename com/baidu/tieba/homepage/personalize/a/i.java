package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<com.baidu.tieba.card.w>> {
    private ab VB;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> fBg;
    private com.baidu.adp.lib.e.b<TbImageView> fBh;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.VB = new ab() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.b bVar, Object obj) {
                if ((bVar instanceof bh) && (obj instanceof com.baidu.tieba.card.u)) {
                    TiebaStatic.log(i.this.a("c13024", (bh) bVar, (com.baidu.tieba.card.u) obj));
                }
            }
        };
        this.fBg = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: boX */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(i.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void destroyObject(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout activateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout passivateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.fBh = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: alq */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(i.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(am.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void destroyObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView activateObject(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
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
    /* renamed from: aq */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.w> onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.card.w wVar = new com.baidu.tieba.card.w(this.mPageContext, viewGroup);
        com.baidu.tieba.card.a.a<com.baidu.tieba.card.w> aVar = new com.baidu.tieba.card.a.a<>(wVar);
        wVar.setConstrainImagePool(this.fBh);
        wVar.setConstrainLayoutPool(this.fBg);
        wVar.d(this.VB);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.w> aVar) {
        if (aVar == null || aVar.baX() == null) {
            return null;
        }
        if (kVar != null && kVar.acC() != null) {
            com.baidu.tieba.card.u uVar = new com.baidu.tieba.card.u();
            uVar.locate = kVar.position + 1;
            uVar.source = kVar.getSource();
            uVar.weight = kVar.getWeight();
            uVar.cAq = kVar.baE();
            com.baidu.tieba.card.t.bat().c(a("c13023", kVar.acC(), uVar));
            aVar.baX().a(uVar);
            aVar.baX().d(this.VB);
            aVar.baX().a(kVar.acC());
        }
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public an a(String str, bh bhVar, com.baidu.tieba.card.u uVar) {
        if (StringUtils.isNull(str) || bhVar == null || uVar == null) {
            return null;
        }
        an bT = new an(str).bT("fid", String.valueOf(bhVar.getFid())).bT("tid", String.valueOf(bhVar.getTid())).P("obj_locate", uVar.locate).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, uVar.source).bT("obj_param1", uVar.weight).bT("ab_tag", uVar.cAq).bT("obj_param3", com.baidu.tieba.card.n.bak());
        if (bhVar.aeC() != null) {
            bT.bT("obj_name", bhVar.aeC().getName_show());
            return bT;
        }
        return bT;
    }
}
