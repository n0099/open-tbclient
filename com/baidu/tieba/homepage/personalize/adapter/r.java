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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class r extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ThreadCardViewHolder<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k> ago;
    private String air;
    private com.baidu.adp.widget.ListView.s amu;
    public BdUniqueId fEN;
    private NEGFeedBackView.a gbz;
    private com.baidu.tieba.homepage.personalize.model.e kbv;
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
        this.ago = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.adapter.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.s.crj().mC(true);
                com.baidu.tieba.a.d.bKv().dQ("page_recommend", "show_");
                if (view != null && r.this.kbv != null && kVar != null && kVar.bkV() != null && !StringUtils.isNull(kVar.bkV().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.gA(com.baidu.adp.lib.f.b.toLong(kVar.bkV().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.gz(com.baidu.adp.lib.f.b.toLong(kVar.bkV().getTid(), 0L));
                        r.this.kbv.a(com.baidu.adp.lib.f.b.toLong(kVar.bkV().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.crv(), kVar.crw(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", kVar.bkV().getBaijiahaoData());
                    }
                    r.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cNf();
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.amu = sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        aq crC;
        int i = 2;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            if (com.baidu.tieba.card.data.l.ad(kVar.eHK)) {
                crC = kVar.crD();
                TiebaStatic.log(crC);
            } else {
                crC = kVar.crC();
                TiebaStatic.log(crC);
            }
            com.baidu.tieba.a.d.bKv().a("page_recommend", "clk_", crC);
            i = 1;
        } else if (id == R.id.thread_card_voice) {
            TiebaStatic.log(kVar.crM());
            com.baidu.tieba.a.d.bKv().a("page_recommend", "clk_", kVar.crM());
            i = 1;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.crK());
            com.baidu.tieba.a.d.bKv().a("page_recommend", "clk_", kVar.crK());
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.crK());
            com.baidu.tieba.a.d.bKv().a("page_recommend", "clk_", kVar.crK());
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.crB());
            com.baidu.tieba.a.d.bKv().a("page_recommend", "clk_", kVar.crB());
            i = 9;
        } else if (id == R.id.god_reply_voice_btn) {
            aq aqVar = new aq("c10760");
            aqVar.an("obj_locate", 4);
            TiebaStatic.log(aqVar);
            i = 5;
        } else if (id == R.id.god_reply_content) {
            aq aqVar2 = new aq("c10760");
            aqVar2.an("obj_locate", 2);
            TiebaStatic.log(aqVar2);
            i = 5;
        } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
            i = 0;
        } else {
            aq aqVar3 = new aq("c10760");
            aqVar3.an("obj_locate", 1);
            TiebaStatic.log(aqVar3);
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.a.a.a(kVar.eHK, this.fEN, kVar.crv(), i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eJO = 1;
        dVar.eJU = 1;
        amVar.setAgreeStatisticData(dVar);
        amVar.setFrom(1);
        amVar.setStType("personalize_page");
        amVar.setShareReportFrom(3);
        amVar.setFromForPb(2);
        amVar.bq(32);
        aVar.b(amVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.amu);
        a2.setSourceForPb(2);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(a2);
        threadCardViewHolder.setPageId(this.fEN);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.personalize.adapter.r.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) nVar;
                    kVar.objType = 1;
                    if (r.this.ago != null) {
                        r.this.ago.a(threadCardViewHolder2.getView(), kVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false, com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup2, view, i));
                    threadCardViewHolder2.tm().b(new a.C0089a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(final int i, final View view, final ViewGroup viewGroup, final com.baidu.tieba.card.data.k kVar, ThreadCardViewHolder threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.eHK == null) {
            return null;
        }
        kVar.wT(kVar.position + 1);
        threadCardViewHolder.tm().setPosition(i);
        threadCardViewHolder.tm().setPage(this.air);
        if (threadCardViewHolder.tm().tg() instanceof am) {
            ((am) threadCardViewHolder.tm().tg()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.homepage.personalize.adapter.r.3
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup, view, i));
                        if (kVar.bkV() != null && kVar.bkV().bom() != null) {
                            aq Ig = kVar.Ig(com.baidu.tieba.card.data.k.iuW);
                            Ig.dW("obj_type", kVar.bkV().bom().id);
                            Ig.dW("obj_name", kVar.bkV().bom().name);
                            TiebaStatic.log(Ig);
                        }
                    }
                }
            });
        }
        threadCardViewHolder.a(false, Align.ALIGN_RIGHT_BOTTOM, this.gbz);
        threadCardViewHolder.b((ThreadCardViewHolder) kVar);
        threadCardViewHolder.tm().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tm().a(this.ago);
        com.baidu.tieba.card.s.crj().e(kVar.crE());
        com.baidu.tieba.a.d.bKv().e(kVar.crE());
        com.baidu.tieba.homepage.personalize.a.a.a(kVar.eHK, this.fEN, kVar.crv());
        return threadCardViewHolder.getView();
    }

    private void cNf() {
        com.baidu.tieba.card.data.k.iuL = "c10730";
        com.baidu.tieba.card.data.k.iuM = "c10731";
        com.baidu.tieba.card.data.k.iuN = "c10704";
        com.baidu.tieba.card.data.k.iuO = "c10755";
        com.baidu.tieba.card.data.k.iuP = "c10710";
        com.baidu.tieba.card.data.k.iuQ = "c10736";
        com.baidu.tieba.card.data.k.iuR = "c10737";
        com.baidu.tieba.card.data.k.iuS = "c10711";
        com.baidu.tieba.card.data.k.iuT = "c10758";
        com.baidu.tieba.card.data.k.iuU = "c10757";
        com.baidu.tieba.card.data.k.iuX = "c10734";
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.kbv = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Ea(String str) {
        this.air = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.gbz = aVar;
    }
}
