package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.z;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.card.al;
import com.baidu.card.an;
import com.baidu.card.ao;
import com.baidu.card.e;
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
public class u extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ak<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.k> adN;
    private String afx;
    private boolean aib;
    public BdUniqueId eEU;
    private TbPageContext<?> mPageContext;

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aib = true;
        this.adN = new aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.a.u.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && kVar != null && kVar.aTN() != null && !StringUtils.isNull(kVar.aTN().getTid())) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        com.baidu.tieba.homepage.concern.b.a(view, kVar, 2);
                    } else if (id == R.id.thread_card_voice) {
                        com.baidu.tieba.homepage.concern.b.a(view, kVar, 6);
                    } else if (id == R.id.user_avatar || id == R.id.user_name) {
                        com.baidu.tieba.homepage.concern.b.a(view, kVar, 1);
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
                    } else if (view.getId() == R.id.forum_name_text) {
                        com.baidu.tieba.homepage.concern.b.a(view, kVar, 7);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            ap apVar5 = new ap("c13423");
                            apVar5.ah("obj_locate", 3);
                            if (kVar != null) {
                                apVar5.dn("tid", kVar.tid);
                                if (kVar.dLK != null && kVar.dLK.aXO() != null) {
                                    apVar5.dn("pid", kVar.dLK.aXO().getId());
                                }
                            }
                            TiebaStatic.log(apVar5);
                            return;
                        }
                        com.baidu.tieba.homepage.concern.b.a(view, kVar, 6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public ak<com.baidu.tieba.card.data.k> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.eEU);
        eVar.bf(128);
        eVar.bg(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.concern.a.u.2
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
        ao aoVar = new ao(this.mPageContext.getPageActivity());
        aVar.c(aoVar);
        aoVar.bu(2);
        aVar.a((com.baidu.card.h) new an(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.j(this.mPageContext.getPageActivity()));
        com.baidu.card.l lVar = new com.baidu.card.l(this.mPageContext.getPageActivity());
        lVar.setFromCDN(this.aib);
        lVar.setForm(ImageViewerConfig.FROM_CONCERN);
        aVar.a((com.baidu.card.h) lVar);
        al alVar = new al(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dNB = 9;
        cVar.dNH = 9;
        alVar.setAgreeStatisticData(cVar);
        alVar.setFrom(9);
        alVar.setShareReportFrom(4);
        alVar.setFromForPb(1);
        aVar.b(alVar);
        ai sf = aVar.sf();
        sf.setSourceForPb(1);
        ak<com.baidu.tieba.card.data.k> akVar = new ak<>(sf);
        akVar.setPageId(this.eEU);
        a(new z() { // from class: com.baidu.tieba.homepage.concern.a.u.3
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ak)) {
                    ak akVar2 = (ak) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                    kVar.objType = 1;
                    if (u.this.adN != null) {
                        u.this.adN.a(akVar2.getView(), kVar);
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
        com.baidu.tieba.card.s.bRL().e(kVar.EF("c12351"));
        akVar.sg().setPage(this.afx);
        akVar.a(true, Align.ALIGN_RIGHT_TOP);
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
