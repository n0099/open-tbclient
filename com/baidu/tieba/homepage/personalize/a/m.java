package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.card.al;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class m extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, al<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l> aeT;
    private String agH;
    private boolean ajr;
    private com.baidu.adp.widget.ListView.v akI;
    public BdUniqueId ePv;
    private com.baidu.tieba.homepage.personalize.model.e iOg;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajr = true;
        this.aeT = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.s.cbX().kK(true);
                com.baidu.tieba.a.d.bAA().dA("page_recommend", "show_");
                if (view != null && m.this.iOg != null && lVar != null && lVar.bce() != null && !StringUtils.isNull(lVar.bce().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.eP(com.baidu.adp.lib.f.b.toLong(lVar.bce().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.eO(com.baidu.adp.lib.f.b.toLong(lVar.bce().getTid(), 0L));
                        m.this.iOg.a(com.baidu.adp.lib.f.b.toLong(lVar.bce().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.ccj(), lVar.cck(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.bce().getBaijiahaoData());
                    }
                    m.this.b(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cyk();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.akI = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        int i = 1;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            TiebaStatic.log(lVar.ccw());
            com.baidu.tieba.a.d.bAA().a("page_recommend", "clk_", lVar.ccw());
        } else if (id == R.id.god_reply_voice_btn) {
            aq aqVar = new aq("c10760");
            aqVar.ai("obj_locate", 4);
            TiebaStatic.log(aqVar);
        } else if (id == R.id.god_reply_content) {
            aq aqVar2 = new aq("c10760");
            aqVar2.ai("obj_locate", 2);
            TiebaStatic.log(aqVar2);
            i = 5;
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
            TiebaStatic.log(lVar.ccz());
            com.baidu.tieba.a.d.bAA().a("page_recommend", "clk_", lVar.ccz());
            i = 3;
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.c.a.a(lVar.dUS, this.ePv, lVar.ccj(), i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public al b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.m mVar = new com.baidu.card.m(this.mPageContext.getPageActivity());
        mVar.setFromCDN(this.ajr);
        mVar.setForm("index");
        aVar.a((com.baidu.card.h) mVar);
        aj a = aVar.a(false, viewGroup, this.akI);
        a.setSourceForPb(2);
        al alVar = new al(a);
        alVar.setPageId(this.ePv);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.m.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof al)) {
                    al alVar2 = (al) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                    lVar.objType = 1;
                    if (m.this.aeT != null) {
                        m.this.aeT.a(alVar2.getView(), lVar);
                    }
                    ay.a((AbsThreadDataSupport) lVar, view.getContext(), 2, false);
                    alVar2.tR().b(new a.C0095a(1));
                }
            }
        });
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, al<com.baidu.tieba.card.data.l> alVar) {
        if (lVar == null || alVar == null || alVar.getView() == null || lVar.dUS == null) {
            return null;
        }
        lVar.vy(lVar.position + 1);
        alVar.tR().setPosition(i);
        alVar.tR().setPage(this.agH);
        alVar.b((al<com.baidu.tieba.card.data.l>) lVar);
        alVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        alVar.tR().a(this.aeT);
        com.baidu.tieba.card.s.cbX().e(lVar.ccv());
        com.baidu.tieba.a.d.bAA().e(lVar.ccv());
        com.baidu.tieba.homepage.personalize.c.a.a(lVar.dUS, this.ePv, lVar.ccj());
        return alVar.getView();
    }

    private void cyk() {
        com.baidu.tieba.card.data.l.hmJ = "c10705";
        com.baidu.tieba.card.data.l.hmK = "c10730";
        com.baidu.tieba.card.data.l.hmL = "c10731";
        com.baidu.tieba.card.data.l.hmM = "c10704";
        com.baidu.tieba.card.data.l.hmN = "c10755";
        com.baidu.tieba.card.data.l.hmO = "c10710";
        com.baidu.tieba.card.data.l.hmP = "c10736";
        com.baidu.tieba.card.data.l.hmQ = "c10737";
        com.baidu.tieba.card.data.l.hmR = "c10711";
        com.baidu.tieba.card.data.l.hmS = "c10758";
        com.baidu.tieba.card.data.l.hmT = "c10757";
    }

    public void setFromCDN(boolean z) {
        this.ajr = z;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.iOg = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Dj(String str) {
        this.agH = str;
    }
}
