package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.card.e;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class s extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ak<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k> adX;
    private boolean aik;
    private NEGFeedBackView.a eTW;
    public BdUniqueId eyE;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hFi;
    private com.baidu.adp.lib.d.b<TbImageView> hFj;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aik = true;
        this.eTW = null;
        this.hFi = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.s.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cay */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(s.this.mPageContext.getPageActivity());
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
        this.hFj = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.s.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aYG */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(s.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(an.getColor(R.color.common_color_10264));
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
        this.adX = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.s.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public boolean a(View view, com.baidu.tieba.card.data.k kVar, String str) {
                if (kVar != null && kVar.dLi != null && kVar.dLi.aTe() != null) {
                    s.this.a(kVar.dLi, view);
                    TiebaStatic.log(kVar.bOY());
                    TiebaStatic.log(kVar.bOZ());
                    s.this.e(kVar.dLi, kVar.bOL());
                    return true;
                }
                return false;
            }
        };
        this.mPageContext = tbPageContext;
        cjP();
    }

    private void cjP() {
        com.baidu.tieba.card.data.k.gUx = "c13388";
        com.baidu.tieba.card.data.k.gUy = "c13389";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public ak<com.baidu.tieba.card.data.k> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.eyE);
        eVar.aD(false);
        eVar.aE(false);
        eVar.be(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.s.3
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
        com.baidu.card.u uVar = new com.baidu.card.u(this.mPageContext.getPageActivity());
        uVar.setFrom("index");
        uVar.setConstrainLayoutPool(this.hFi);
        uVar.setConstrainImagePool(this.hFj);
        uVar.setFromCDN(this.aik);
        aVar.c(uVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.af(this.mPageContext.getPageActivity()));
        aVar.sc().bn(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds62));
        aVar.sc().bk(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds27));
        aVar.sc().bm(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds23));
        ak<com.baidu.tieba.card.data.k> akVar = new ak<>(aVar.sd());
        akVar.setPageId(this.eyE);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.homepage.personalize.a.s.4
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                if (kVar != null && kVar.dLi != null && kVar.dLi.aTe() != null) {
                    s.this.a(kVar.dLi, view);
                    TiebaStatic.log(kVar.bOY());
                    TiebaStatic.log(kVar.bOZ());
                    s.this.e(kVar.dLi, kVar.bOL());
                }
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ak<com.baidu.tieba.card.data.k> akVar) {
        if (kVar == null || akVar == null || akVar.getView() == null || kVar.dLi == null) {
            return null;
        }
        kVar.sR(kVar.position + 1);
        akVar.aI(false).a(this.eTW);
        akVar.b((ak<com.baidu.tieba.card.data.k>) kVar);
        akVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.se().a(this.adX);
        com.baidu.tieba.card.s.bOA().e(kVar.bOX());
        com.baidu.tieba.a.d.boA().a("page_recommend", "show_", kVar.bOX());
        f(kVar.dLi, kVar.bOL());
        return akVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.eTW = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Ae(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bu buVar, View view) {
        if (buVar != null && buVar.aTe() != null) {
            String str = buVar.aTe().id;
            String str2 = buVar.aTe().link;
            String str3 = buVar.aTe().h5_url;
            Long l = buVar.aTe().swan_app_id;
            long parseLong = Long.parseLong(buVar.getTid());
            String str4 = buVar.aTe().name;
            long fid = buVar.getFid();
            com.baidu.tbadk.core.sharedPref.b.aVP().putLong("smart_app_tid", parseLong);
            com.baidu.tbadk.core.sharedPref.b.aVP().putString("smart_app_name", str4);
            com.baidu.tbadk.core.sharedPref.b.aVP().putString("smart_app_id", str);
            if (!StringUtils.isNull(str)) {
                if (!com.baidu.tieba.aiapps.a.b(str, str2, "1191008600000000", buVar.aTe().is_game)) {
                    if (!StringUtils.isNull(str3)) {
                        com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), str3);
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.card.m.DO(buVar.getTid());
                TiebaStatic.log(new ao("c13274").s("fid", fid).s("tid", parseLong).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("obj_name", str4).s("obj_id", l.longValue()).dk("obj_source", "index_card").ag("obj_param1", buVar.aTe().is_game.intValue()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(bu buVar, int i) {
        if (buVar != null && buVar.aTe() != null) {
            com.baidu.tieba.s.c.dgX().b(this.eyE, com.baidu.tieba.s.a.a(buVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 1, i, buVar.aTe().id));
        }
    }

    private void f(bu buVar, int i) {
        if (buVar != null && buVar.aTe() != null) {
            String str = buVar.aTe().id;
            com.baidu.tieba.s.c.dgX().a(this.eyE, com.baidu.tieba.s.a.a(buVar.getTid(), "", str, (BaijiahaoData) null), com.baidu.tieba.s.a.a(buVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", i, str));
        }
    }
}
