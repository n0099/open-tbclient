package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.card.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class aa extends com.baidu.tieba.homepage.a<com.baidu.tieba.card.data.k, ak<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k> adN;
    private String afx;
    private com.baidu.adp.widget.ListView.v ajt;
    public BdUniqueId eEU;
    private NEGFeedBackView.a far;
    private com.baidu.tieba.homepage.personalize.model.e izo;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public aa(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.adN = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.aa.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.s.bRL().km(true);
                com.baidu.tieba.a.d.brD().dk("page_recommend", "show_");
                if (view != null && aa.this.izo != null && kVar != null && kVar.aTN() != null && !StringUtils.isNull(kVar.aTN().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.eD(com.baidu.adp.lib.f.b.toLong(kVar.aTN().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.eC(com.baidu.adp.lib.f.b.toLong(kVar.aTN().getTid(), 0L));
                        aa.this.izo.a(com.baidu.adp.lib.f.b.toLong(kVar.aTN().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.bRX(), kVar.bRY(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", kVar.aTN().getBaijiahaoData());
                    }
                    aa.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cnr();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.ajt = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        int i = 2;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            if (com.baidu.tieba.card.data.l.aa(kVar.dLK)) {
                TiebaStatic.log(kVar.bSp());
            } else {
                TiebaStatic.log(kVar.bSk());
            }
            com.baidu.tieba.a.d.brD().a("page_recommend", "clk_", kVar.bSk());
            i = 1;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.bSm());
            com.baidu.tieba.a.d.brD().a("page_recommend", "clk_", kVar.bSm());
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.bSm());
            com.baidu.tieba.a.d.brD().a("page_recommend", "clk_", kVar.bSm());
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.bSl());
            com.baidu.tieba.a.d.brD().a("page_recommend", "clk_", kVar.bSl());
            i = 9;
        } else if (id == R.id.god_reply_content) {
            ap apVar = new ap("c10760");
            apVar.ah("obj_locate", 2);
            TiebaStatic.log(apVar);
            i = 5;
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            ap apVar2 = new ap("c10760");
            apVar2.ah("obj_locate", 1);
            TiebaStatic.log(apVar2);
            i = 5;
        } else if (!(view instanceof TbImageView)) {
            i = 0;
        } else {
            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                ap apVar3 = new ap("c10760");
                apVar3.ah("obj_locate", 3);
                TiebaStatic.log(apVar3);
            }
            TiebaStatic.log(kVar.bSn());
            com.baidu.tieba.a.d.brD().a("page_recommend", "clk_", kVar.bSn());
            i = 3;
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.c.a.a(kVar.dLK, this.eEU, kVar.bRX(), i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public ak b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.eEU);
        eVar.bg(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.aa.2
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
        eVar.b(this.mPageContext);
        aVar.a(eVar);
        ai a = aVar.a(false, viewGroup, this.ajt);
        a.setSourceForPb(2);
        ak akVar = new ak(a);
        akVar.setPageId(this.eEU);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.homepage.personalize.a.aa.3
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ak)) {
                    ak akVar2 = (ak) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                    kVar.objType = 1;
                    if (aa.this.adN != null) {
                        aa.this.adN.a(akVar2.getView(), kVar);
                    }
                    ax.a((AbsThreadDataSupport) kVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    akVar2.sg().b(new a.C0096a(1));
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
        akVar.sg().setPosition(i);
        akVar.sg().setPage(this.afx);
        akVar.a(true, Align.ALIGN_RIGHT_TOP, this.far);
        akVar.a(kVar.aTY(), this.irz);
        akVar.b((ak<com.baidu.tieba.card.data.k>) kVar);
        akVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.sg().a(this.adN);
        com.baidu.tieba.card.s.bRL().e(kVar.bSj());
        com.baidu.tieba.a.d.brD().e(kVar.bSj());
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.dLK, this.eEU, kVar.bRX());
        return akVar.getView();
    }

    private void cnr() {
        com.baidu.tieba.card.data.k.gZR = "c10730";
        com.baidu.tieba.card.data.k.gZS = "c10731";
        com.baidu.tieba.card.data.k.gZT = "c10704";
        com.baidu.tieba.card.data.k.gZU = "c10755";
        com.baidu.tieba.card.data.k.gZV = "c10710";
        com.baidu.tieba.card.data.k.gZW = "c10736";
        com.baidu.tieba.card.data.k.gZX = "c10737";
        com.baidu.tieba.card.data.k.gZY = "c10711";
        com.baidu.tieba.card.data.k.gZZ = "c10758";
        com.baidu.tieba.card.data.k.haa = "c10757";
        com.baidu.tieba.card.data.k.had = "c10734";
        com.baidu.tieba.card.data.k.hae = "c10708";
        com.baidu.tieba.card.data.k.haf = "c10735";
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.izo = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void AP(String str) {
        this.afx = str;
    }
}
