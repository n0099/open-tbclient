package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ah;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.e;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class t extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, am<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.l> afF;
    private boolean akk;
    private NEGFeedBackView.a fPf;
    public BdUniqueId fsQ;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> iNL;
    private com.baidu.adp.lib.d.b<TbImageView> iNM;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akk = true;
        this.fPf = null;
        this.iNL = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cAV */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(t.this.mPageContext.getPageActivity());
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
        this.iNM = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.t.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bsZ */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(t.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(ap.getColor(R.color.common_color_10264));
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
        this.afF = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.t.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public boolean a(View view, com.baidu.tieba.card.data.l lVar, String str) {
                if (lVar != null && lVar.exA != null && lVar.exA.bnp() != null) {
                    t.this.a(lVar.exA, view);
                    TiebaStatic.log(lVar.coQ());
                    TiebaStatic.log(lVar.coR());
                    t.this.e(lVar.exA, lVar.coD());
                    return true;
                }
                return false;
            }
        };
        this.mPageContext = tbPageContext;
        cIV();
    }

    private void cIV() {
        com.baidu.tieba.card.data.l.ibq = "c13388";
        com.baidu.tieba.card.data.l.ibr = "c13389";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aV */
    public am<com.baidu.tieba.card.data.l> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.fsQ);
        eVar.aE(false);
        eVar.aF(false);
        eVar.bp(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.t.3
            @Override // com.baidu.card.e.a
            public void a(AbsThreadDataSupport absThreadDataSupport, View view) {
                if (absThreadDataSupport != null) {
                    if (view.getId() == R.id.user_name) {
                        absThreadDataSupport.objType = 3;
                    } else if (view.getId() == R.id.user_avatar) {
                        absThreadDataSupport.objType = 4;
                    } else {
                        absThreadDataSupport.objType = 1;
                    }
                }
            }
        });
        aVar.a(eVar);
        com.baidu.card.w wVar = new com.baidu.card.w(this.mPageContext.getPageActivity());
        wVar.setFrom("index");
        wVar.setConstrainLayoutPool(this.iNL);
        wVar.setConstrainImagePool(this.iNM);
        wVar.setFromCDN(this.akk);
        aVar.c(wVar);
        aVar.a((com.baidu.card.i) new ah(this.mPageContext.getPageActivity()));
        aVar.tU().by(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds62));
        aVar.tU().bv(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds27));
        aVar.tU().bx(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds23));
        am<com.baidu.tieba.card.data.l> amVar = new am<>(aVar.tV());
        amVar.setPageId(this.fsQ);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.t.4
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                if (lVar != null && lVar.exA != null && lVar.exA.bnp() != null) {
                    t.this.a(lVar.exA, view);
                    TiebaStatic.log(lVar.coQ());
                    TiebaStatic.log(lVar.coR());
                    t.this.e(lVar.exA, lVar.coD());
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, am<com.baidu.tieba.card.data.l> amVar) {
        if (lVar == null || amVar == null || amVar.getView() == null || lVar.exA == null) {
            return null;
        }
        lVar.xj(lVar.position + 1);
        amVar.aL(false).a(this.fPf);
        amVar.b((am<com.baidu.tieba.card.data.l>) lVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afF);
        com.baidu.tieba.card.t.cor().e(lVar.coP());
        com.baidu.tieba.a.d.bIR().a("page_recommend", "show_", lVar.coP());
        f(lVar.exA, lVar.coD());
        return amVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.fPf = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void EZ(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bw bwVar, View view) {
        if (bwVar != null && bwVar.bnp() != null) {
            String str = bwVar.bnp().id;
            String str2 = bwVar.bnp().link;
            String str3 = bwVar.bnp().h5_url;
            Long l = bwVar.bnp().swan_app_id;
            long parseLong = Long.parseLong(bwVar.getTid());
            String str4 = bwVar.bnp().name;
            long fid = bwVar.getFid();
            com.baidu.tbadk.core.sharedPref.b.bqh().putLong("smart_app_tid", parseLong);
            com.baidu.tbadk.core.sharedPref.b.bqh().putString("smart_app_name", str4);
            com.baidu.tbadk.core.sharedPref.b.bqh().putString("smart_app_id", str);
            if (!StringUtils.isNull(str)) {
                if (!com.baidu.tieba.aiapps.a.b(str, str2, "1191008600000000", bwVar.bnp().is_game)) {
                    if (!StringUtils.isNull(str3)) {
                        com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), str3);
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.card.n.IZ(bwVar.getTid());
                TiebaStatic.log(new aq("c13274").w("fid", fid).w("tid", parseLong).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("obj_name", str4).w("obj_id", l.longValue()).dR("obj_source", "index_card").al("obj_param1", bwVar.bnp().is_game.intValue()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(bw bwVar, int i) {
        if (bwVar != null && bwVar.bnp() != null) {
            com.baidu.tieba.s.c.dIX().b(this.fsQ, com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 1, i, bwVar.bnp().id));
        }
    }

    private void f(bw bwVar, int i) {
        if (bwVar != null && bwVar.bnp() != null) {
            String str = bwVar.bnp().id;
            com.baidu.tieba.s.c.dIX().a(this.fsQ, com.baidu.tieba.s.a.a(bwVar.getTid(), "", str, (BaijiahaoData) null), com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", i, str));
        }
    }
}
