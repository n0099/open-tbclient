package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.z;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes16.dex */
public class j extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ak<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.k> adN;
    private String afx;
    private boolean aib;
    private com.baidu.adp.widget.ListView.v ajt;
    public BdUniqueId eEU;
    private TbPageContext<?> mPageContext;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aib = true;
        this.adN = new aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && kVar != null && kVar.aTN() != null && !StringUtils.isNull(kVar.aTN().getTid())) {
                    j.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.ajt = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root) {
            com.baidu.tieba.homepage.concern.b.a(view, kVar, 2);
        } else if (id == R.id.god_reply_voice_btn) {
            ap apVar = new ap("c13423");
            apVar.ah("obj_locate", 4);
            if (kVar != null) {
                apVar.dn("tid", kVar.tid);
                if (kVar.dLK != null && kVar.dLK.aXO() != null) {
                    apVar.dn("pid", kVar.dLK.aXO().getId());
                }
            }
            TiebaStatic.log(apVar);
        } else if (id == R.id.god_reply_content) {
            ap apVar2 = new ap("c13423");
            apVar2.ah("obj_locate", 2);
            if (kVar != null) {
                apVar2.dn("tid", kVar.tid);
                if (kVar.dLK != null && kVar.dLK.aXO() != null) {
                    apVar2.dn("pid", kVar.dLK.aXO().getId());
                }
            }
            TiebaStatic.log(apVar2);
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            ap apVar3 = new ap("c13423");
            apVar3.ah("obj_locate", 1);
            if (kVar != null) {
                apVar3.dn("tid", kVar.tid);
                if (kVar.dLK != null && kVar.dLK.aXO() != null) {
                    apVar3.dn("pid", kVar.dLK.aXO().getId());
                }
            }
            TiebaStatic.log(apVar3);
        } else if (id == R.id.god_reply_agree_view) {
            ap apVar4 = new ap("c13423");
            apVar4.ah("obj_locate", 5);
            if (kVar != null) {
                apVar4.dn("tid", kVar.tid);
                if (kVar.dLK != null && kVar.dLK.aXO() != null) {
                    apVar4.dn("pid", kVar.dLK.aXO().getId());
                }
            }
            TiebaStatic.log(apVar4);
        } else if ((view instanceof TbImageView) && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            ap apVar5 = new ap("c13423");
            apVar5.ah("obj_locate", 3);
            if (kVar != null) {
                apVar5.dn("tid", kVar.tid);
                if (kVar.dLK != null && kVar.dLK.aXO() != null) {
                    apVar5.dn("pid", kVar.dLK.aXO().getId());
                }
            }
            TiebaStatic.log(apVar5);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public ak b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.l lVar = new com.baidu.card.l(this.mPageContext.getPageActivity());
        lVar.setFromCDN(this.aib);
        lVar.setForm(ImageViewerConfig.FROM_CONCERN);
        aVar.a((com.baidu.card.h) lVar);
        ai a = aVar.a(false, viewGroup, this.ajt);
        a.setSourceForPb(1);
        ak akVar = new ak(a);
        akVar.setPageId(this.eEU);
        a(new z() { // from class: com.baidu.tieba.homepage.concern.a.j.2
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ak)) {
                    ak akVar2 = (ak) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                    kVar.objType = 1;
                    if (j.this.adN != null) {
                        j.this.adN.a(akVar2.getView(), kVar);
                    }
                    ax.a((AbsThreadDataSupport) kVar, view.getContext(), 1, false);
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
        com.baidu.tieba.card.s.bRL().e(new ap("c13424"));
        akVar.sg().setPosition(i);
        if (akVar.sg() instanceof com.baidu.tieba.a.e) {
            akVar.sg().setPage(this.afx);
        }
        akVar.b((ak<com.baidu.tieba.card.data.k>) kVar);
        akVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.sg().a(this.adN);
        return akVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void AP(String str) {
        this.afx = str;
    }
}
