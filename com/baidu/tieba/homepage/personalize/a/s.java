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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class s extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ak<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k> adN;
    private boolean aib;
    public BdUniqueId eEU;
    private NEGFeedBackView.a far;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hLg;
    private com.baidu.adp.lib.d.b<TbImageView> hLh;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aib = true;
        this.far = null;
        this.hLg = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.s.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cdX */
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
        this.hLh = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.s.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bcD */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(s.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(ao.getColor(R.color.common_color_10264));
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
        this.adN = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.s.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public boolean a(View view, com.baidu.tieba.card.data.k kVar, String str) {
                if (kVar != null && kVar.dLK != null && kVar.dLK.aXa() != null) {
                    s.this.a(kVar.dLK, view);
                    TiebaStatic.log(kVar.bSk());
                    TiebaStatic.log(kVar.bSl());
                    s.this.e(kVar.dLK, kVar.bRX());
                    return true;
                }
                return false;
            }
        };
        this.mPageContext = tbPageContext;
        cnr();
    }

    private void cnr() {
        com.baidu.tieba.card.data.k.hab = "c13388";
        com.baidu.tieba.card.data.k.hac = "c13389";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public ak<com.baidu.tieba.card.data.k> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.eEU);
        eVar.aD(false);
        eVar.aE(false);
        eVar.bg(1024);
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
        uVar.setConstrainLayoutPool(this.hLg);
        uVar.setConstrainImagePool(this.hLh);
        uVar.setFromCDN(this.aib);
        aVar.c(uVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.af(this.mPageContext.getPageActivity()));
        aVar.se().bp(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds62));
        aVar.se().bm(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds27));
        aVar.se().bo(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds23));
        ak<com.baidu.tieba.card.data.k> akVar = new ak<>(aVar.sf());
        akVar.setPageId(this.eEU);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.homepage.personalize.a.s.4
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                if (kVar != null && kVar.dLK != null && kVar.dLK.aXa() != null) {
                    s.this.a(kVar.dLK, view);
                    TiebaStatic.log(kVar.bSk());
                    TiebaStatic.log(kVar.bSl());
                    s.this.e(kVar.dLK, kVar.bRX());
                }
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ak<com.baidu.tieba.card.data.k> akVar) {
        if (kVar == null || akVar == null || akVar.getView() == null || kVar.dLK == null) {
            return null;
        }
        kVar.tj(kVar.position + 1);
        akVar.aK(false).a(this.far);
        akVar.b((ak<com.baidu.tieba.card.data.k>) kVar);
        akVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.sg().a(this.adN);
        com.baidu.tieba.card.s.bRL().e(kVar.bSj());
        com.baidu.tieba.a.d.brD().a("page_recommend", "show_", kVar.bSj());
        f(kVar.dLK, kVar.bRX());
        return akVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.far = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void AP(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bv bvVar, View view) {
        if (bvVar != null && bvVar.aXa() != null) {
            String str = bvVar.aXa().id;
            String str2 = bvVar.aXa().link;
            String str3 = bvVar.aXa().h5_url;
            Long l = bvVar.aXa().swan_app_id;
            long parseLong = Long.parseLong(bvVar.getTid());
            String str4 = bvVar.aXa().name;
            long fid = bvVar.getFid();
            com.baidu.tbadk.core.sharedPref.b.aZP().putLong("smart_app_tid", parseLong);
            com.baidu.tbadk.core.sharedPref.b.aZP().putString("smart_app_name", str4);
            com.baidu.tbadk.core.sharedPref.b.aZP().putString("smart_app_id", str);
            if (!StringUtils.isNull(str)) {
                if (!com.baidu.tieba.aiapps.a.b(str, str2, "1191008600000000", bvVar.aXa().is_game)) {
                    if (!StringUtils.isNull(str3)) {
                        com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), str3);
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.card.m.Ez(bvVar.getTid());
                TiebaStatic.log(new ap("c13274").t("fid", fid).t("tid", parseLong).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("obj_name", str4).t("obj_id", l.longValue()).dn("obj_source", "index_card").ah("obj_param1", bvVar.aXa().is_game.intValue()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(bv bvVar, int i) {
        if (bvVar != null && bvVar.aXa() != null) {
            com.baidu.tieba.s.c.dkh().b(this.eEU, com.baidu.tieba.s.a.a(bvVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 1, i, bvVar.aXa().id));
        }
    }

    private void f(bv bvVar, int i) {
        if (bvVar != null && bvVar.aXa() != null) {
            String str = bvVar.aXa().id;
            com.baidu.tieba.s.c.dkh().a(this.eEU, com.baidu.tieba.s.a.a(bvVar.getTid(), "", str, (BaijiahaoData) null), com.baidu.tieba.s.a.a(bvVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", i, str));
        }
    }
}
