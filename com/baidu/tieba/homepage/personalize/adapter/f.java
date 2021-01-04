package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ThreadCardViewHolder<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k> ahf;
    private String aji;
    private boolean alQ;
    private com.baidu.adp.widget.ListView.s anl;
    public BdUniqueId fJu;
    private com.baidu.tieba.homepage.personalize.model.e kgb;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.alQ = true;
        this.ahf = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.adapter.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.s.cva().mG(true);
                com.baidu.tieba.a.d.bOm().dR("page_recommend", "show_");
                if (view != null && f.this.kgb != null && kVar != null && kVar.boO() != null && !StringUtils.isNull(kVar.boO().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.gA(com.baidu.adp.lib.f.b.toLong(kVar.boO().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.gz(com.baidu.adp.lib.f.b.toLong(kVar.boO().getTid(), 0L));
                        f.this.kgb.a(com.baidu.adp.lib.f.b.toLong(kVar.boO().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.cvm(), kVar.cvn(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", kVar.boO().getBaijiahaoData());
                    }
                    f.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cQW();
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.anl = sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        int i = 2;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            TiebaStatic.log(kVar.cvt());
            com.baidu.tieba.a.d.bOm().a("page_recommend", "clk_", kVar.cvt());
            i = 1;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.cvB());
            com.baidu.tieba.a.d.bOm().a("page_recommend", "clk_", kVar.cvB());
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.cvB());
            com.baidu.tieba.a.d.bOm().a("page_recommend", "clk_", kVar.cvB());
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.cvs());
            com.baidu.tieba.a.d.bOm().a("page_recommend", "clk_", kVar.cvs());
            i = 9;
        } else if (id == R.id.god_reply_content) {
            aq aqVar = new aq("c10760");
            aqVar.an("obj_locate", 2);
            TiebaStatic.log(aqVar);
            i = 5;
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            aq aqVar2 = new aq("c10760");
            aqVar2.an("obj_locate", 1);
            TiebaStatic.log(aqVar2);
            i = 5;
        } else if (!(view instanceof TbImageView)) {
            i = 0;
        } else {
            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                aq aqVar3 = new aq("c10760");
                aqVar3.an("obj_locate", 3);
                TiebaStatic.log(aqVar3);
            }
            TiebaStatic.log(kVar.cvC());
            com.baidu.tieba.a.d.bOm().a("page_recommend", "clk_", kVar.cvC());
            i = 3;
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.a.a.a(kVar.eMv, this.fJu, kVar.cvm(), i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.y yVar = new com.baidu.card.y(this.mPageContext.getPageActivity());
        yVar.setFrom("index");
        yVar.setFromCDN(this.alQ);
        aVar.c(yVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.anl);
        a2.setSourceForPb(2);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(a2);
        threadCardViewHolder.setPageId(this.fJu);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.personalize.adapter.f.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) nVar;
                    kVar.objType = 1;
                    if (f.this.ahf != null) {
                        f.this.ahf.a(threadCardViewHolder2.getView(), kVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    threadCardViewHolder2.ty().b(new a.C0090a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ThreadCardViewHolder<com.baidu.tieba.card.data.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.eMv == null) {
            return null;
        }
        kVar.yA(kVar.position + 1);
        threadCardViewHolder.ty().setPosition(i);
        threadCardViewHolder.ty().setPage(this.aji);
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.card.data.k>) kVar);
        threadCardViewHolder.ty().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.ty().a(this.ahf);
        com.baidu.tieba.card.s.cva().e(kVar.cvv());
        com.baidu.tieba.a.d.bOm().e(kVar.cvv());
        com.baidu.card.y yVar = (com.baidu.card.y) threadCardViewHolder.ty().tr();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) yVar.aiw.amp.getLayoutParams();
        layoutParams.width = kVar.eSI;
        layoutParams.height = kVar.eSJ;
        if (yVar.aiw.amp.getVisibility() != 8) {
            yVar.aiw.amp.setLayoutParams(layoutParams);
        }
        com.baidu.tieba.homepage.personalize.a.a.a(kVar.eMv, this.fJu, kVar.cvm());
        return threadCardViewHolder.getView();
    }

    private void cQW() {
        com.baidu.tieba.card.data.k.izr = "c10705";
        com.baidu.tieba.card.data.k.izs = "c10730";
        com.baidu.tieba.card.data.k.izt = "c10731";
        com.baidu.tieba.card.data.k.izu = "c10704";
        com.baidu.tieba.card.data.k.izv = "c10755";
        com.baidu.tieba.card.data.k.izw = "c10710";
        com.baidu.tieba.card.data.k.izx = "c10736";
        com.baidu.tieba.card.data.k.izy = "c10737";
        com.baidu.tieba.card.data.k.izz = "c10711";
        com.baidu.tieba.card.data.k.izA = "c10758";
        com.baidu.tieba.card.data.k.izB = "c10757";
    }

    @Override // com.baidu.tieba.a.f
    public void Fm(String str) {
        this.aji = str;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.kgb = eVar;
    }
}
