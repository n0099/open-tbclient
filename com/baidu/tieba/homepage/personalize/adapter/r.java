package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class r extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ThreadCardViewHolder<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k> ahy;
    private String ajx;
    private com.baidu.adp.widget.ListView.s anC;
    public BdUniqueId fIy;
    private NEGFeedBackView.a gfx;
    private com.baidu.tieba.homepage.personalize.model.e klV;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ThreadCardViewHolder<com.baidu.tieba.card.data.k> threadCardViewHolder) {
        return a2(i, view, viewGroup, kVar, (ThreadCardViewHolder) threadCardViewHolder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ahy = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.adapter.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.csH().mG(true);
                com.baidu.tieba.a.d.bKY().dK("page_recommend", "show_");
                if (view != null && r.this.klV != null && kVar != null && kVar.blp() != null && !StringUtils.isNull(kVar.blp().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.gF(com.baidu.adp.lib.f.b.toLong(kVar.blp().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.gE(com.baidu.adp.lib.f.b.toLong(kVar.blp().getTid(), 0L));
                        r.this.klV.a(com.baidu.adp.lib.f.b.toLong(kVar.blp().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.csU(), kVar.csV(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", kVar.blp().getBaijiahaoData());
                    }
                    r.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cPp();
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.anC = sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        ar ctb;
        int i = 2;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            if (com.baidu.tieba.card.data.l.ae(kVar.eLr)) {
                ctb = kVar.ctc();
                TiebaStatic.log(ctb);
            } else {
                ctb = kVar.ctb();
                TiebaStatic.log(ctb);
            }
            com.baidu.tieba.a.d.bKY().a("page_recommend", "clk_", ctb);
            i = 1;
        } else if (id == R.id.thread_card_voice) {
            TiebaStatic.log(kVar.ctl());
            com.baidu.tieba.a.d.bKY().a("page_recommend", "clk_", kVar.ctl());
            i = 1;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.ctj());
            com.baidu.tieba.a.d.bKY().a("page_recommend", "clk_", kVar.ctj());
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.ctj());
            com.baidu.tieba.a.d.bKY().a("page_recommend", "clk_", kVar.ctj());
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.cta());
            com.baidu.tieba.a.d.bKY().a("page_recommend", "clk_", kVar.cta());
            i = 9;
        } else if (id == R.id.god_reply_voice_btn) {
            ar arVar = new ar("c10760");
            arVar.aq("obj_locate", 4);
            TiebaStatic.log(arVar);
            i = 5;
        } else if (id == R.id.god_reply_content) {
            ar arVar2 = new ar("c10760");
            arVar2.aq("obj_locate", 2);
            TiebaStatic.log(arVar2);
            i = 5;
        } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
            i = 0;
        } else {
            ar arVar3 = new ar("c10760");
            arVar3.aq("obj_locate", 1);
            TiebaStatic.log(arVar3);
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.a.a.a(kVar.eLr, this.fIy, kVar.csU(), i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
        eVar.eNB = 1;
        eVar.eNH = 1;
        amVar.setAgreeStatisticData(eVar);
        amVar.setFrom(1);
        amVar.setStType("personalize_page");
        amVar.setShareReportFrom(3);
        amVar.setFromForPb(2);
        amVar.br(32);
        aVar.b(amVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.anC);
        a2.setSourceForPb(2);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(a2);
        threadCardViewHolder.setPageId(this.fIy);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.personalize.adapter.r.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) nVar;
                    kVar.objType = 1;
                    if (r.this.ahy != null) {
                        r.this.ahy.a(threadCardViewHolder2.getView(), kVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false, com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup2, view, i));
                    threadCardViewHolder2.tj().b(new a.C0095a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(final int i, final View view, final ViewGroup viewGroup, final com.baidu.tieba.card.data.k kVar, ThreadCardViewHolder threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.eLr == null) {
            return null;
        }
        kVar.xe(kVar.position + 1);
        threadCardViewHolder.tj().setPosition(i);
        threadCardViewHolder.tj().setPage(this.ajx);
        if (threadCardViewHolder.tj().td() instanceof am) {
            ((am) threadCardViewHolder.tj().td()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.homepage.personalize.adapter.r.3
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup, view, i));
                        if (kVar.blp() != null && kVar.blp().boG() != null) {
                            ar Jb = kVar.Jb(com.baidu.tieba.card.data.k.iCD);
                            Jb.dR("obj_type", kVar.blp().boG().id);
                            Jb.dR("obj_name", kVar.blp().boG().name);
                            TiebaStatic.log(Jb);
                        }
                    }
                }
            });
        }
        threadCardViewHolder.a(false, Align.ALIGN_RIGHT_BOTTOM, this.gfx);
        threadCardViewHolder.b((ThreadCardViewHolder) kVar);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tj().a(this.ahy);
        com.baidu.tieba.card.t.csH().e(kVar.ctd());
        com.baidu.tieba.a.d.bKY().e(kVar.ctd());
        com.baidu.tieba.homepage.personalize.a.a.a(kVar.eLr, this.fIy, kVar.csU());
        return threadCardViewHolder.getView();
    }

    private void cPp() {
        com.baidu.tieba.card.data.k.iCs = "c10730";
        com.baidu.tieba.card.data.k.iCt = "c10731";
        com.baidu.tieba.card.data.k.iCu = "c10704";
        com.baidu.tieba.card.data.k.iCv = "c10755";
        com.baidu.tieba.card.data.k.iCw = "c10710";
        com.baidu.tieba.card.data.k.iCx = "c10736";
        com.baidu.tieba.card.data.k.iCy = "c10737";
        com.baidu.tieba.card.data.k.iCz = "c10711";
        com.baidu.tieba.card.data.k.iCA = "c10758";
        com.baidu.tieba.card.data.k.iCB = "c10757";
        com.baidu.tieba.card.data.k.iCE = "c10734";
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.klV = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void ED(String str) {
        this.ajx = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.gfx = aVar;
    }
}
