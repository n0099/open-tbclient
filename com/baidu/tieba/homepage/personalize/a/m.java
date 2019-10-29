package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.d;
import com.baidu.card.x;
import com.baidu.card.z;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class m extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, z<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> Fq;
    private boolean HY;
    public BdUniqueId cKf;
    private NEGFeedBackView.a dcY;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> fAu;
    private com.baidu.adp.lib.e.b<TbImageView> fAv;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.HY = true;
        this.dcY = null;
        this.fAu = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bmb */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(m.this.mPageContext.getPageActivity());
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
        this.fAv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.m.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aoe */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(m.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(am.getColor(R.color.common_color_10264));
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
        this.Fq = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.m.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public boolean a(View view, com.baidu.tieba.card.data.k kVar, String str) {
                if (kVar != null && kVar.cbq != null && kVar.cbq.ajs() != null) {
                    m.this.a(kVar.cbq, view);
                    TiebaStatic.log(kVar.baS());
                    TiebaStatic.log(kVar.baT());
                    m.this.d(kVar.cbq, kVar.baG());
                    return true;
                }
                return false;
            }
        };
        this.mPageContext = tbPageContext;
        buY();
    }

    private void buY() {
        com.baidu.tieba.card.data.k.eQi = "c13388";
        com.baidu.tieba.card.data.k.eQj = "c13389";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public z<com.baidu.tieba.card.data.k> b(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.cKf);
        dVar.T(false);
        dVar.U(false);
        dVar.V(false);
        dVar.aC(1024);
        dVar.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.a.m.3
            @Override // com.baidu.card.d.a
            public void a(com.baidu.tbadk.core.data.a aVar2, View view) {
                if (aVar2 != null) {
                    if (view.getId() == R.id.user_name) {
                        aVar2.objType = 3;
                    } else if (view.getId() == R.id.user_avatar) {
                        aVar2.objType = 4;
                    } else {
                        aVar2.objType = 1;
                    }
                }
            }
        });
        aVar.c(dVar);
        com.baidu.card.o oVar = new com.baidu.card.o(this.mPageContext.getPageActivity());
        oVar.setFrom("index");
        oVar.setConstrainLayoutPool(this.fAu);
        oVar.setConstrainImagePool(this.fAv);
        oVar.setFromCDN(this.HY);
        aVar.b(oVar);
        aVar.a((com.baidu.card.f) new com.baidu.card.u(this.mPageContext.getPageActivity()));
        z<com.baidu.tieba.card.data.k> zVar = new z<>(aVar.lU());
        zVar.setPageId(this.cKf);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.m.4
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                if (kVar != null && kVar.cbq != null && kVar.cbq.ajs() != null) {
                    m.this.a(kVar.cbq, view);
                    TiebaStatic.log(kVar.baS());
                    TiebaStatic.log(kVar.baT());
                    m.this.d(kVar.cbq, kVar.baG());
                }
            }
        });
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, z<com.baidu.tieba.card.data.k> zVar) {
        if (kVar == null || zVar == null || zVar.getView() == null || kVar.cbq == null) {
            return null;
        }
        kVar.oP(kVar.position + 1);
        zVar.lW().a(this.dcY);
        zVar.a(kVar);
        zVar.lV().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.lV().b(this.Fq);
        com.baidu.tieba.card.t.baw().c(kVar.baR());
        com.baidu.tieba.a.d.aDe().a("page_recommend", "show_", kVar.baR());
        e(kVar.cbq, kVar.baG());
        return zVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dcY = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void rh(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bh bhVar, View view) {
        if (bhVar != null && bhVar.ajs() != null) {
            String str = bhVar.ajs().id;
            String str2 = bhVar.ajs().link;
            String str3 = bhVar.ajs().h5_url;
            Long l = bhVar.ajs().swan_app_id;
            long parseLong = Long.parseLong(bhVar.getTid());
            String str4 = bhVar.ajs().name;
            long fid = bhVar.getFid();
            com.baidu.tbadk.core.sharedPref.b.alR().putLong("smart_app_tid", parseLong);
            com.baidu.tbadk.core.sharedPref.b.alR().putString("smart_app_name", str4);
            com.baidu.tbadk.core.sharedPref.b.alR().putString("smart_app_id", str);
            if (!StringUtils.isNull(str)) {
                if (!com.baidu.tieba.aiapps.a.b(str, str2, "1191008600000000", bhVar.ajs().is_game)) {
                    if (!StringUtils.isNull(str3)) {
                        com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), str3);
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.card.n.uz(bhVar.getTid());
                TiebaStatic.log(new an("c13274").p("fid", fid).p("tid", parseLong).bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("obj_name", str4).p("obj_id", l.longValue()).bS("obj_source", "index_card").O("obj_param1", bhVar.ajs().is_game.intValue()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(bh bhVar, int i) {
        if (bhVar != null && bhVar.ajs() != null) {
            com.baidu.tieba.q.c.cnk().b(this.cKf, com.baidu.tieba.q.a.a(bhVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 1, i, bhVar.ajs().id));
        }
    }

    private void e(bh bhVar, int i) {
        if (bhVar != null && bhVar.ajs() != null) {
            String str = bhVar.ajs().id;
            com.baidu.tieba.q.c.cnk().a(this.cKf, str, com.baidu.tieba.q.a.a(bhVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", i, str));
        }
    }
}
