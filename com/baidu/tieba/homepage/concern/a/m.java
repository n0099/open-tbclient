package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
/* loaded from: classes9.dex */
public class m extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a>> implements com.baidu.tieba.a.f {
    private String aey;
    public BdUniqueId ebv;
    private z gEg;
    private com.baidu.tieba.homepage.concern.view.a hIP;
    private z<com.baidu.tieba.card.data.k> hIQ;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hdn;
    private com.baidu.adp.lib.d.b<TbImageView> hdo;
    private TbPageContext<?> mPageContext;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.hdn = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.concern.a.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bQQ */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(m.this.mPageContext.getPageActivity());
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
        this.hdo = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.homepage.concern.a.m.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aQH */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(m.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(am.getColor(R.color.common_color_10264));
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
        this.gEg = new z<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.a.m.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && m.this.hIP != null && m.this.hIP.getView() != null && kVar != null && kVar.aIw() != null && !StringUtils.isNull(kVar.aIw().getTid())) {
                    int id = view.getId();
                    if (id == R.id.user_avatar || id == R.id.user_name) {
                        com.baidu.tieba.homepage.concern.b.a(view, kVar, 1);
                    } else if (id == R.id.thread_card_title || id == R.id.thread_card_abstract) {
                        com.baidu.tieba.homepage.concern.b.a(view, kVar, 2);
                    } else if (id == R.id.thread_card_root) {
                        com.baidu.tieba.homepage.concern.b.a(view, kVar, 2);
                    } else if (view instanceof TbImageView) {
                        com.baidu.tieba.homepage.concern.b.a(view, kVar, 3);
                    }
                }
            }
        };
        this.hIQ = new z<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.a.m.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (kVar != null && kVar.aIw() != null) {
                    com.baidu.tieba.card.l.BB(kVar.aIw().getTid());
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ax */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> b(ViewGroup viewGroup) {
        final com.baidu.tieba.homepage.concern.view.a aVar = new com.baidu.tieba.homepage.concern.view.a(this.mPageContext);
        aVar.setSingleImageRatio(0.75d);
        aVar.setConstrainLayoutPool(this.hdn);
        aVar.setConstrainImagePool(this.hdo);
        aVar.c(this.hIQ);
        if (this.ebv != null) {
            aVar.m(this.ebv);
        }
        if (!at(1) || !at(2)) {
            aVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.homepage.concern.a.m.4
                @Override // com.baidu.adp.widget.a.b
                public void i(int i, int i2, int i3) {
                    m.this.h(i, i2, i3);
                    if (m.this.at(1) && m.this.at(2)) {
                        aVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        this.hIP = aVar;
        return new com.baidu.tieba.card.a.a<>(this.hIP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> aVar) {
        if (kVar == null || aVar == null || aVar.bFB() == null) {
            return null;
        }
        kVar.rN(i + 1);
        com.baidu.tieba.card.r.bEY().e(kVar.BH("c12351"));
        if (aVar.bFB() instanceof com.baidu.tieba.a.e) {
            aVar.bFB().setPage(this.aey);
        }
        aVar.bFB().a(kVar);
        aVar.bFB().c(this.gEg);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void yc(String str) {
        this.aey = str;
    }
}
