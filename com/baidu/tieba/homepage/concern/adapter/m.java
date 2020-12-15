package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes22.dex */
public class m extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, am<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k> agG;
    private String aiw;
    private boolean alo;
    private com.baidu.adp.widget.ListView.v amH;
    public BdUniqueId fzO;
    private TbPageContext<?> mPageContext;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.alo = true;
        this.agG = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.adapter.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && kVar != null && kVar.bmn() != null && !StringUtils.isNull(kVar.bmn().getTid())) {
                    m.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.amH = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root) {
            com.baidu.tieba.homepage.concern.c.a(view, kVar, 2);
        } else if (id == R.id.god_reply_voice_btn) {
            ar arVar = new ar("c13423");
            arVar.al("obj_locate", 4);
            if (kVar != null) {
                arVar.dY("tid", kVar.tid);
                if (kVar.eCR != null && kVar.eCR.bqu() != null) {
                    arVar.dY("pid", kVar.eCR.bqu().getId());
                }
            }
            TiebaStatic.log(arVar);
        } else if (id == R.id.god_reply_content) {
            ar arVar2 = new ar("c13423");
            arVar2.al("obj_locate", 2);
            if (kVar != null) {
                arVar2.dY("tid", kVar.tid);
                if (kVar.eCR != null && kVar.eCR.bqu() != null) {
                    arVar2.dY("pid", kVar.eCR.bqu().getId());
                }
            }
            TiebaStatic.log(arVar2);
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            ar arVar3 = new ar("c13423");
            arVar3.al("obj_locate", 1);
            if (kVar != null) {
                arVar3.dY("tid", kVar.tid);
                if (kVar.eCR != null && kVar.eCR.bqu() != null) {
                    arVar3.dY("pid", kVar.eCR.bqu().getId());
                }
            }
            TiebaStatic.log(arVar3);
        } else if (id == R.id.god_reply_agree_view) {
            ar arVar4 = new ar("c13423");
            arVar4.al("obj_locate", 5);
            if (kVar != null) {
                arVar4.dY("tid", kVar.tid);
                if (kVar.eCR != null && kVar.eCR.bqu() != null) {
                    arVar4.dY("pid", kVar.eCR.bqu().getId());
                }
            }
            TiebaStatic.log(arVar4);
        } else if ((view instanceof TbImageView) && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            ar arVar5 = new ar("c13423");
            arVar5.al("obj_locate", 3);
            if (kVar != null) {
                arVar5.dY("tid", kVar.tid);
                if (kVar.eCR != null && kVar.eCR.bqu() != null) {
                    arVar5.dY("pid", kVar.eCR.bqu().getId());
                }
            }
            TiebaStatic.log(arVar5);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.alo);
        nVar.setForm(ImageViewerConfig.FROM_CONCERN);
        aVar.a((com.baidu.card.i) nVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.EXTEND, viewGroup, this.amH);
        a2.setSourceForPb(1);
        am amVar = new am(a2);
        amVar.setPageId(this.fzO);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.concern.adapter.m.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                    kVar.objType = 1;
                    if (m.this.agG != null) {
                        m.this.agG.a(amVar2.getView(), kVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 1, false);
                    amVar2.tZ().b(new a.C0097a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, am<com.baidu.tieba.card.data.k> amVar) {
        if (kVar == null || amVar == null || amVar.getView() == null || kVar.eCR == null) {
            return null;
        }
        kVar.ym(kVar.position + 1);
        com.baidu.tieba.card.t.csh().e(new ar("c13424"));
        amVar.tZ().setPosition(i);
        if (amVar.tZ() instanceof com.baidu.tieba.a.e) {
            amVar.tZ().setPage(this.aiw);
        }
        amVar.b((am<com.baidu.tieba.card.data.k>) kVar);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tZ().a(this.agG);
        return amVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }
}
