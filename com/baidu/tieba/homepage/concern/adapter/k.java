package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes21.dex */
public class k extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, am<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.l> afn;
    private String ahc;
    private boolean ajR;
    private com.baidu.adp.widget.ListView.v alj;
    public BdUniqueId eSq;
    private TbPageContext<?> mPageContext;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajR = true;
        this.afn = new aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.concern.adapter.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                if (view != null && lVar != null && lVar.bcY() != null && !StringUtils.isNull(lVar.bcY().getTid())) {
                    k.this.b(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.alj = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root) {
            com.baidu.tieba.homepage.concern.c.a(view, lVar, 2);
        } else if (id == R.id.god_reply_voice_btn) {
            aq aqVar = new aq("c13423");
            aqVar.ai("obj_locate", 4);
            if (lVar != null) {
                aqVar.dF("tid", lVar.tid);
                if (lVar.dXg != null && lVar.dXg.bhb() != null) {
                    aqVar.dF("pid", lVar.dXg.bhb().getId());
                }
            }
            TiebaStatic.log(aqVar);
        } else if (id == R.id.god_reply_content) {
            aq aqVar2 = new aq("c13423");
            aqVar2.ai("obj_locate", 2);
            if (lVar != null) {
                aqVar2.dF("tid", lVar.tid);
                if (lVar.dXg != null && lVar.dXg.bhb() != null) {
                    aqVar2.dF("pid", lVar.dXg.bhb().getId());
                }
            }
            TiebaStatic.log(aqVar2);
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            aq aqVar3 = new aq("c13423");
            aqVar3.ai("obj_locate", 1);
            if (lVar != null) {
                aqVar3.dF("tid", lVar.tid);
                if (lVar.dXg != null && lVar.dXg.bhb() != null) {
                    aqVar3.dF("pid", lVar.dXg.bhb().getId());
                }
            }
            TiebaStatic.log(aqVar3);
        } else if (id == R.id.god_reply_agree_view) {
            aq aqVar4 = new aq("c13423");
            aqVar4.ai("obj_locate", 5);
            if (lVar != null) {
                aqVar4.dF("tid", lVar.tid);
                if (lVar.dXg != null && lVar.dXg.bhb() != null) {
                    aqVar4.dF("pid", lVar.dXg.bhb().getId());
                }
            }
            TiebaStatic.log(aqVar4);
        } else if ((view instanceof TbImageView) && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            aq aqVar5 = new aq("c13423");
            aqVar5.ai("obj_locate", 3);
            if (lVar != null) {
                aqVar5.dF("tid", lVar.tid);
                if (lVar.dXg != null && lVar.dXg.bhb() != null) {
                    aqVar5.dF("pid", lVar.dXg.bhb().getId());
                }
            }
            TiebaStatic.log(aqVar5);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.ajR);
        nVar.setForm(ImageViewerConfig.FROM_CONCERN);
        aVar.a((com.baidu.card.i) nVar);
        ak a = aVar.a(false, viewGroup, this.alj);
        a.setSourceForPb(1);
        am amVar = new am(a);
        amVar.setPageId(this.eSq);
        a(new ab() { // from class: com.baidu.tieba.homepage.concern.adapter.k.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                    lVar.objType = 1;
                    if (k.this.afn != null) {
                        k.this.afn.a(amVar2.getView(), lVar);
                    }
                    ay.a((AbsThreadDataSupport) lVar, view.getContext(), 1, false);
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
        com.baidu.tieba.card.s.cfn().e(new aq("c13424"));
        amVar.tW().setPosition(i);
        if (amVar.tW() instanceof com.baidu.tieba.a.e) {
            amVar.tW().setPage(this.ahc);
        }
        amVar.b((am<com.baidu.tieba.card.data.l>) lVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afn);
        return amVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void DH(String str) {
        this.ahc = str;
    }
}
