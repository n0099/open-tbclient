package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.d;
import com.baidu.card.x;
import com.baidu.card.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bg;
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
    private ab<com.baidu.tieba.card.data.k> VC;
    private boolean Yd;
    private NEGFeedBackView.a cSD;
    public BdUniqueId cxx;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> fyU;
    private com.baidu.adp.lib.e.b<TbImageView> fyV;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Yd = true;
        this.cSD = null;
        this.fyU = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: boc */
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
        this.fyV = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.m.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: alc */
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
        this.VC = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.m.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public boolean a(View view, com.baidu.tieba.card.data.k kVar, String str) {
                if (kVar != null && kVar.threadData != null && kVar.threadData.afj() != null) {
                    m.this.a(kVar.threadData, view);
                    TiebaStatic.log(kVar.bak());
                    TiebaStatic.log(kVar.bal());
                    m.this.d(kVar.threadData, kVar.aZX());
                    return true;
                }
                return false;
            }
        };
        this.mPageContext = tbPageContext;
        bwS();
    }

    private void bwS() {
        com.baidu.tieba.card.data.k.eFN = "c13388";
        com.baidu.tieba.card.data.k.eFO = "c13389";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public z<com.baidu.tieba.card.data.k> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.cxx);
        dVar.ay(false);
        dVar.az(false);
        dVar.aA(false);
        dVar.bn(1024);
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
        oVar.setConstrainLayoutPool(this.fyU);
        oVar.setConstrainImagePool(this.fyV);
        oVar.setFromCDN(this.Yd);
        aVar.b(oVar);
        aVar.a((com.baidu.card.f) new com.baidu.card.u(this.mPageContext.getPageActivity()));
        z<com.baidu.tieba.card.data.k> zVar = new z<>(aVar.qO());
        aVar.qN().setBackgroundResource(R.drawable.addresslist_item_bg);
        zVar.setPageId(this.cxx);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.m.4
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                if (kVar != null && kVar.threadData != null && kVar.threadData.afj() != null) {
                    m.this.a(kVar.threadData, view);
                    TiebaStatic.log(kVar.bak());
                    TiebaStatic.log(kVar.bal());
                    m.this.d(kVar.threadData, kVar.aZX());
                }
            }
        });
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, z<com.baidu.tieba.card.data.k> zVar) {
        if (kVar == null || zVar == null || zVar.getView() == null || kVar.threadData == null) {
            return null;
        }
        kVar.pI(kVar.position + 1);
        zVar.qQ().a(this.cSD);
        zVar.a(kVar);
        zVar.qP().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qP().a(this.VC);
        com.baidu.tieba.card.t.aZN().c(kVar.baj());
        com.baidu.tieba.a.d.aCF().a("page_recommend", "show_", kVar.baj());
        e(kVar.threadData, kVar.aZX());
        return zVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.cSD = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void sm(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bg bgVar, View view) {
        if (bgVar != null && bgVar.afj() != null) {
            String str = bgVar.afj().id;
            String str2 = bgVar.afj().link;
            String str3 = bgVar.afj().h5_url;
            Long l = bgVar.afj().swan_app_id;
            long parseLong = Long.parseLong(bgVar.getTid());
            String str4 = bgVar.afj().name;
            long fid = bgVar.getFid();
            com.baidu.tbadk.core.sharedPref.b.ahO().putLong("smart_app_tid", parseLong);
            com.baidu.tbadk.core.sharedPref.b.ahO().putString("smart_app_name", str4);
            com.baidu.tbadk.core.sharedPref.b.ahO().putString("smart_app_id", str);
            if (!StringUtils.isNull(str)) {
                if (!com.baidu.tieba.aiapps.a.b(str, str2, "1191008600000000", bgVar.afj().is_game)) {
                    if (!StringUtils.isNull(str3)) {
                        com.baidu.tbadk.browser.a.ae(view.getContext(), str3);
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.card.n.vw(bgVar.getTid());
                TiebaStatic.log(new an("c13274").l("fid", fid).l("tid", parseLong).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", str4).l(VideoPlayActivityConfig.OBJ_ID, l.longValue()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "index_card").P("obj_param1", bgVar.afj().is_game.intValue()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(bg bgVar, int i) {
        if (bgVar != null && bgVar.afj() != null) {
            com.baidu.tieba.q.c.coo().b(this.cxx, com.baidu.tieba.q.a.a(bgVar, "a002", "common_click", 1, i, bgVar.afj().id));
        }
    }

    private void e(bg bgVar, int i) {
        if (bgVar != null && bgVar.afj() != null) {
            String str = bgVar.afj().id;
            com.baidu.tieba.q.c.coo().a(this.cxx, str, com.baidu.tieba.q.a.a(bgVar, "a002", "common_exp", i, str));
        }
    }
}
