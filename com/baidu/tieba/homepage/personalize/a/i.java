package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.w;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<w>> {
    private ab Xr;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> fdJ;
    private com.baidu.adp.lib.e.b<TbImageView> fdK;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Xr = new ab() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.b bVar, Object obj) {
                if ((bVar instanceof bg) && (obj instanceof com.baidu.tieba.card.u)) {
                    TiebaStatic.log(i.this.a("c13024", (bg) bVar, (com.baidu.tieba.card.u) obj));
                }
            }
        };
        this.fdJ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: beG */
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
        this.fdK = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aeY */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(i.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(d.C0277d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1));
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
    /* renamed from: ao */
    public com.baidu.tieba.card.a.a<w> onCreateViewHolder(ViewGroup viewGroup) {
        w wVar = new w(this.mPageContext, viewGroup);
        com.baidu.tieba.card.a.a<w> aVar = new com.baidu.tieba.card.a.a<>(wVar);
        wVar.setConstrainImagePool(this.fdK);
        wVar.setConstrainLayoutPool(this.fdJ);
        wVar.d(this.Xr);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<w> aVar) {
        if (aVar == null || aVar.aRg() == null) {
            return null;
        }
        if (kVar != null && kVar.WO() != null) {
            com.baidu.tieba.card.u uVar = new com.baidu.tieba.card.u();
            uVar.locate = kVar.position + 1;
            uVar.source = kVar.getSource();
            uVar.weight = kVar.getWeight();
            uVar.ejF = kVar.aQO();
            com.baidu.tieba.card.t.aQD().b(a("c13023", kVar.WO(), uVar));
            aVar.aRg().a(uVar);
            aVar.aRg().d(this.Xr);
            aVar.aRg().a(kVar.WO());
        }
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public am a(String str, bg bgVar, com.baidu.tieba.card.u uVar) {
        if (StringUtils.isNull(str) || bgVar == null || uVar == null) {
            return null;
        }
        am bJ = new am(str).bJ(ImageViewerConfig.FORUM_ID, String.valueOf(bgVar.getFid())).bJ("tid", String.valueOf(bgVar.getTid())).T("obj_locate", uVar.locate).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, uVar.source).bJ("obj_param1", uVar.weight).bJ("ab_tag", uVar.ejF).bJ("obj_param3", com.baidu.tieba.card.n.aQv());
        if (bgVar.YO() != null) {
            bJ.bJ("obj_name", bgVar.YO().getName_show());
            return bJ;
        }
        return bJ;
    }
}
