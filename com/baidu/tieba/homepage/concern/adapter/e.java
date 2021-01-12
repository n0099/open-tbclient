package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a;
import com.baidu.card.a.a;
import com.baidu.card.af;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.card.d;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ThreadCardViewHolder<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.k> ago;
    private String air;
    private com.baidu.adp.widget.ListView.s amu;
    public BdUniqueId fEN;
    private TbPageContext<?> mPageContext;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ago = new aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.adapter.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && kVar != null && kVar.bkV() != null && !StringUtils.isNull(kVar.bkV().getTid())) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        com.baidu.tieba.homepage.concern.c.a(view, kVar, 2);
                    } else if (id == R.id.user_avatar || id == R.id.user_name) {
                        com.baidu.tieba.homepage.concern.c.a(view, kVar, 1);
                    } else if (id == R.id.god_reply_voice_btn) {
                        aq aqVar = new aq("c13423");
                        aqVar.an("obj_locate", 4);
                        if (kVar != null) {
                            aqVar.dW("tid", kVar.tid);
                            if (kVar.eHK != null && kVar.eHK.bpd() != null) {
                                aqVar.dW("pid", kVar.eHK.bpd().getId());
                            }
                        }
                        TiebaStatic.log(aqVar);
                    } else if (id == R.id.god_reply_content) {
                        aq aqVar2 = new aq("c13423");
                        aqVar2.an("obj_locate", 2);
                        if (kVar != null) {
                            aqVar2.dW("tid", kVar.tid);
                            if (kVar.eHK != null && kVar.eHK.bpd() != null) {
                                aqVar2.dW("pid", kVar.eHK.bpd().getId());
                            }
                        }
                        TiebaStatic.log(aqVar2);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        aq aqVar3 = new aq("c13423");
                        aqVar3.an("obj_locate", 1);
                        if (kVar != null) {
                            aqVar3.dW("tid", kVar.tid);
                            if (kVar.eHK != null && kVar.eHK.bpd() != null) {
                                aqVar3.dW("pid", kVar.eHK.bpd().getId());
                            }
                        }
                        TiebaStatic.log(aqVar3);
                    } else if (id == R.id.god_reply_agree_view) {
                        aq aqVar4 = new aq("c13423");
                        aqVar4.an("obj_locate", 5);
                        if (kVar != null) {
                            aqVar4.dW("tid", kVar.tid);
                            if (kVar.eHK != null && kVar.eHK.bpd() != null) {
                                aqVar4.dW("pid", kVar.eHK.bpd().getId());
                            }
                        }
                        TiebaStatic.log(aqVar4);
                    } else if (id == R.id.forum_name_text) {
                        com.baidu.tieba.homepage.concern.c.a(view, kVar, 7);
                    } else if (id == R.id.thread_card_title || id == R.id.thread_card_abstract) {
                        com.baidu.tieba.homepage.concern.c.a(view, kVar, 2);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            aq aqVar5 = new aq("c13423");
                            aqVar5.an("obj_locate", 3);
                            if (kVar != null) {
                                aqVar5.dW("tid", kVar.tid);
                                if (kVar.eHK != null && kVar.eHK.bpd() != null) {
                                    aqVar5.dW("pid", kVar.eHK.bpd().getId());
                                }
                            }
                            TiebaStatic.log(aqVar5);
                            return;
                        }
                        com.baidu.tieba.homepage.concern.c.a(view, kVar, 6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder<com.baidu.tieba.card.data.k> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.fEN);
        dVar.bq(128);
        dVar.br(1024);
        dVar.a(new d.a() { // from class: com.baidu.tieba.homepage.concern.adapter.e.2
            @Override // com.baidu.card.d.a
            public void a(com.baidu.tbadk.core.data.a aVar2, View view) {
                if (aVar2 != null) {
                    if (view.getId() == R.id.user_name) {
                        aVar2.objType = 3;
                    } else if (view.getId() == R.id.user_avatar) {
                        aVar2.objType = 4;
                    } else {
                        aVar2.objType = 1;
                    }
                }
            }
        });
        aVar.a(dVar);
        af afVar = new af(this.mPageContext);
        afVar.c(false);
        afVar.setFrom(ImageViewerConfig.FROM_CONCERN);
        aVar.tl().bx(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        aVar.c(afVar);
        final af afVar2 = new af(this.mPageContext);
        afVar2.c(true);
        afVar2.setFrom(ImageViewerConfig.FROM_CONCERN);
        afVar2.e(com.baidu.tbadk.a.b.b.bjq(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), com.baidu.tbadk.a.b.b.bjq(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
        afVar2.a(new a.InterfaceC0088a() { // from class: com.baidu.tieba.homepage.concern.adapter.e.3
            @Override // com.baidu.card.a.InterfaceC0088a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.bkV() != null && aVar2.bkV().eQQ != null) {
                    ay.a(aVar2.bkV().eQQ, e.this.mContext, 1);
                    com.baidu.tieba.homepage.concern.c.a(afVar2.getView(), aVar2, 6);
                }
            }
        });
        aVar.a((com.baidu.card.h) afVar2);
        final an anVar = new an(this.mPageContext.getPageActivity());
        anVar.c(true);
        anVar.a(new a.InterfaceC0088a() { // from class: com.baidu.tieba.homepage.concern.adapter.e.4
            @Override // com.baidu.card.a.InterfaceC0088a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.bkV() != null && aVar2.bkV().eQQ != null) {
                    ay.a(aVar2.bkV().eQQ, e.this.mContext, 1);
                    com.baidu.tieba.homepage.concern.c.a(anVar.getView(), aVar2, 6);
                }
            }
        });
        aVar.a((com.baidu.card.h) anVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.k(this.mPageContext.getPageActivity()));
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.eJO = 9;
        dVar2.eJU = 9;
        amVar.setAgreeStatisticData(dVar2);
        amVar.setFrom(9);
        amVar.setShareReportFrom(4);
        amVar.setFromForPb(1);
        amVar.bq(32);
        aVar.b(amVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.FULL, viewGroup, this.amu);
        a2.setSourceForPb(1);
        ThreadCardViewHolder<com.baidu.tieba.card.data.k> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.fEN);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.concern.adapter.e.5
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) nVar;
                    kVar.objType = 1;
                    if (e.this.ago != null) {
                        e.this.ago.a(threadCardViewHolder2.getView(), kVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 1, false);
                    threadCardViewHolder2.tm().b(new a.C0089a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ThreadCardViewHolder<com.baidu.tieba.card.data.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.eHK == null) {
            return null;
        }
        kVar.wT(kVar.position + 1);
        threadCardViewHolder.tm().setPosition(i);
        com.baidu.tieba.card.s.crj().e(kVar.Ih("c12351"));
        threadCardViewHolder.tm().setPage(this.air);
        threadCardViewHolder.a(true, Align.ALIGN_RIGHT_TOP);
        threadCardViewHolder.tq();
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.card.data.k>) kVar);
        threadCardViewHolder.tm().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tm().a(this.ago);
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Ea(String str) {
        this.air = str;
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.amu = sVar;
    }
}
