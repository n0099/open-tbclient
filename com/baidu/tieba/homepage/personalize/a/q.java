package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ag;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.card.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class q extends com.baidu.tieba.homepage.a<com.baidu.tieba.card.data.l, am<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l> afn;
    private String ahc;
    private boolean ajR;
    public BdUniqueId eSq;
    private NEGFeedBackView.a foG;
    private com.baidu.tieba.homepage.personalize.model.e iWS;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> igv;
    private com.baidu.adp.lib.d.b<TbImageView> igw;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.foG = null;
        this.ajR = true;
        this.igv = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: crP */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(q.this.mPageContext.getPageActivity());
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
        this.igw = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.q.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: blW */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(q.this.mPageContext.getPageActivity());
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
        this.afn = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.q.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.s.cfn().kO(true);
                com.baidu.tieba.a.d.bBN().dA("page_recommend", "show_");
                if (view != null && q.this.iWS != null && lVar != null && lVar.bcY() != null && !StringUtils.isNull(lVar.bcY().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.fd(com.baidu.adp.lib.f.b.toLong(lVar.bcY().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.fc(com.baidu.adp.lib.f.b.toLong(lVar.bcY().getTid(), 0L));
                        q.this.iWS.a(com.baidu.adp.lib.f.b.toLong(lVar.bcY().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.cfz(), lVar.cfA(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.bcY().getBaijiahaoData());
                    }
                    q.this.b(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        czJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        int i = 1;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root) {
            TiebaStatic.log(lVar.cfM());
            com.baidu.tieba.a.d.bBN().a("page_recommend", "clk_", lVar.cfM());
        } else if (id == R.id.thread_info_commont_container) {
            TiebaStatic.log(lVar.cfM());
            com.baidu.tieba.a.d.bBN().a("page_recommend", "clk_", lVar.cfM());
            i = 5;
        } else if (id == R.id.thread_card_voice) {
            TiebaStatic.log(lVar.cfQ());
            com.baidu.tieba.a.d.bBN().a("page_recommend", "clk_", lVar.cfQ());
            i = 0;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(lVar.cfO());
            com.baidu.tieba.a.d.bBN().a("page_recommend", "clk_", lVar.cfO());
            i = 2;
        } else if (id == R.id.user_name) {
            TiebaStatic.log(lVar.cfO());
            com.baidu.tieba.a.d.bBN().a("page_recommend", "clk_", lVar.cfO());
            i = 2;
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(lVar.cfN());
            com.baidu.tieba.a.d.bBN().a("page_recommend", "clk_", lVar.cfN());
            i = 0;
        } else if (id == R.id.god_reply_voice_btn) {
            aq aqVar = new aq("c10760");
            aqVar.ai("obj_locate", 4);
            TiebaStatic.log(aqVar);
            i = 0;
        } else if (id == R.id.god_reply_content) {
            aq aqVar2 = new aq("c10760");
            aqVar2.ai("obj_locate", 2);
            TiebaStatic.log(aqVar2);
            i = 0;
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            aq aqVar3 = new aq("c10760");
            aqVar3.ai("obj_locate", 1);
            TiebaStatic.log(aqVar3);
            i = 0;
        } else if (!(view instanceof TbImageView)) {
            i = 0;
        } else {
            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                aq aqVar4 = new aq("c10760");
                aqVar4.ai("obj_locate", 3);
                TiebaStatic.log(aqVar4);
            }
            TiebaStatic.log(lVar.cfP());
            com.baidu.tieba.a.d.bBN().a("page_recommend", "clk_", lVar.cfP());
            i = 3;
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.c.a.a(lVar.dXg, this.eSq, lVar.cfz(), i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.eSq);
        eVar.bp(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.q.4
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
        final com.baidu.card.w wVar = new com.baidu.card.w(this.mPageContext.getPageActivity());
        wVar.setFrom("index");
        wVar.setConstrainLayoutPool(this.igv);
        wVar.setConstrainImagePool(this.igw);
        wVar.setFromCDN(this.ajR);
        aVar.c(wVar);
        aVar.a((com.baidu.card.i) new com.baidu.card.s(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.i) new ag(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.i) new com.baidu.card.aa(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.i) new com.baidu.card.k(this.mPageContext.getPageActivity()));
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.ajR);
        nVar.setForm("index");
        aVar.a((com.baidu.card.i) nVar);
        if (!aI(1) || !aI(2)) {
            wVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.homepage.personalize.a.q.5
                @Override // com.baidu.adp.widget.a.b
                public void i(int i, int i2, int i3) {
                    q.this.h(i, i2, i3);
                    if (q.this.aI(1) && q.this.aI(2)) {
                        wVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dYY = 1;
        cVar.dZe = 1;
        anVar.setAgreeStatisticData(cVar);
        anVar.setFrom(1);
        anVar.setShareReportFrom(3);
        anVar.setFromForPb(2);
        aVar.b(anVar);
        ak tV = aVar.tV();
        tV.setSourceForPb(2);
        am amVar = new am(tV);
        amVar.setPageId(this.eSq);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.q.6
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                    lVar.objType = 1;
                    if (q.this.afn != null) {
                        q.this.afn.a(amVar2.getView(), lVar);
                    }
                    ay.a((AbsThreadDataSupport) lVar, view.getContext(), 2, false);
                    amVar2.tW().b(new a.C0096a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, am<com.baidu.tieba.card.data.l> amVar) {
        if (lVar == null || amVar == null || amVar.getView() == null || lVar.dXg == null) {
            return null;
        }
        lVar.vX(lVar.position + 1);
        amVar.tW().setPage(this.ahc);
        amVar.aL(true).a(this.foG);
        amVar.a(lVar.bdj(), this.iNp);
        amVar.b((am<com.baidu.tieba.card.data.l>) lVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afn);
        com.baidu.tieba.card.s.cfn().e(lVar.cfL());
        com.baidu.tieba.a.d.bBN().a("page_recommend", "show_", lVar.cfL());
        com.baidu.tieba.homepage.personalize.c.a.a(lVar.dXg, this.eSq, lVar.cfz());
        return amVar.getView();
    }

    private void czJ() {
        com.baidu.tieba.card.data.l.htQ = "c10705";
        com.baidu.tieba.card.data.l.htR = "c10730";
        com.baidu.tieba.card.data.l.htS = "c10731";
        com.baidu.tieba.card.data.l.htT = "c10704";
        com.baidu.tieba.card.data.l.htU = "c10755";
        com.baidu.tieba.card.data.l.htV = "c10710";
        com.baidu.tieba.card.data.l.htW = "c10736";
        com.baidu.tieba.card.data.l.htX = "c10737";
        com.baidu.tieba.card.data.l.htY = "c10711";
        com.baidu.tieba.card.data.l.htZ = "c10758";
        com.baidu.tieba.card.data.l.hua = "c10757";
    }

    public void setFromCDN(boolean z) {
        this.ajR = z;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.iWS = eVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.foG = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void DH(String str) {
        this.ahc = str;
    }
}
