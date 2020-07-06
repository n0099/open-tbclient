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
import com.baidu.card.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes9.dex */
public class u extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ak<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.k> adX;
    private String afG;
    private boolean aik;
    public BdUniqueId eyE;
    private TbPageContext<?> mPageContext;

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aik = true;
        this.adX = new aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.a.u.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && kVar != null && kVar.aPS() != null && !StringUtils.isNull(kVar.aPS().getTid())) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        com.baidu.tieba.homepage.concern.b.a(view, kVar, 2);
                    } else if (id == R.id.thread_card_voice) {
                        com.baidu.tieba.homepage.concern.b.a(view, kVar, 6);
                    } else if (id == R.id.user_avatar || id == R.id.user_name) {
                        com.baidu.tieba.homepage.concern.b.a(view, kVar, 1);
                    } else if (id == R.id.god_reply_voice_btn) {
                        ao aoVar = new ao("c13423");
                        aoVar.ag("obj_locate", 4);
                        if (kVar != null) {
                            aoVar.dk("tid", kVar.tid);
                            if (kVar.dLi != null && kVar.dLi.aTS() != null) {
                                aoVar.dk("pid", kVar.dLi.aTS().getId());
                            }
                        }
                        TiebaStatic.log(aoVar);
                    } else if (id == R.id.god_reply_content) {
                        ao aoVar2 = new ao("c13423");
                        aoVar2.ag("obj_locate", 2);
                        if (kVar != null) {
                            aoVar2.dk("tid", kVar.tid);
                            if (kVar.dLi != null && kVar.dLi.aTS() != null) {
                                aoVar2.dk("pid", kVar.dLi.aTS().getId());
                            }
                        }
                        TiebaStatic.log(aoVar2);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        ao aoVar3 = new ao("c13423");
                        aoVar3.ag("obj_locate", 1);
                        if (kVar != null) {
                            aoVar3.dk("tid", kVar.tid);
                            if (kVar.dLi != null && kVar.dLi.aTS() != null) {
                                aoVar3.dk("pid", kVar.dLi.aTS().getId());
                            }
                        }
                        TiebaStatic.log(aoVar3);
                    } else if (id == R.id.god_reply_agree_view) {
                        ao aoVar4 = new ao("c13423");
                        aoVar4.ag("obj_locate", 5);
                        if (kVar != null) {
                            aoVar4.dk("tid", kVar.tid);
                            if (kVar.dLi != null && kVar.dLi.aTS() != null) {
                                aoVar4.dk("pid", kVar.dLi.aTS().getId());
                            }
                        }
                        TiebaStatic.log(aoVar4);
                    } else if (view.getId() == R.id.forum_name_text) {
                        com.baidu.tieba.homepage.concern.b.a(view, kVar, 7);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            ao aoVar5 = new ao("c13423");
                            aoVar5.ag("obj_locate", 3);
                            if (kVar != null) {
                                aoVar5.dk("tid", kVar.tid);
                                if (kVar.dLi != null && kVar.dLi.aTS() != null) {
                                    aoVar5.dk("pid", kVar.dLi.aTS().getId());
                                }
                            }
                            TiebaStatic.log(aoVar5);
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
    /* renamed from: aQ */
    public ak<com.baidu.tieba.card.data.k> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.eyE);
        eVar.bd(128);
        eVar.be(1024);
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
        com.baidu.card.ao aoVar = new com.baidu.card.ao(this.mPageContext.getPageActivity());
        aVar.c(aoVar);
        aoVar.bs(2);
        aVar.a((com.baidu.card.h) new an(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.j(this.mPageContext.getPageActivity()));
        com.baidu.card.l lVar = new com.baidu.card.l(this.mPageContext.getPageActivity());
        lVar.setFromCDN(this.aik);
        lVar.setForm(ImageViewerConfig.FROM_CONCERN);
        aVar.a((com.baidu.card.h) lVar);
        al alVar = new al(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dHq = 9;
        cVar.dHw = 9;
        alVar.setAgreeStatisticData(cVar);
        alVar.setFrom(9);
        alVar.setShareReportFrom(4);
        alVar.setFromForPb(1);
        aVar.b(alVar);
        ai sd = aVar.sd();
        sd.setSourceForPb(1);
        ak<com.baidu.tieba.card.data.k> akVar = new ak<>(sd);
        akVar.setPageId(this.eyE);
        a(new z() { // from class: com.baidu.tieba.homepage.concern.a.u.3
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ak)) {
                    ak akVar2 = (ak) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                    kVar.objType = 1;
                    if (u.this.adX != null) {
                        u.this.adX.a(akVar2.getView(), kVar);
                    }
                    aw.a((AbsThreadDataSupport) kVar, view.getContext(), 1, false);
                    akVar2.se().b(new a.C0098a(1));
                }
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ak<com.baidu.tieba.card.data.k> akVar) {
        if (kVar == null || akVar == null || akVar.getView() == null || kVar.dLi == null) {
            return null;
        }
        kVar.sR(kVar.position + 1);
        com.baidu.tieba.card.s.bOB().e(kVar.DU("c12351"));
        akVar.se().setPage(this.afG);
        akVar.a(true, kVar.aPZ() ? Align.ALIGN_RIGHT_TOP : Align.ALIGN_RIGHT_BOTTOM);
        akVar.b((ak<com.baidu.tieba.card.data.k>) kVar);
        akVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.se().a(this.adX);
        return akVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Ae(String str) {
        this.afG = str;
    }
}
