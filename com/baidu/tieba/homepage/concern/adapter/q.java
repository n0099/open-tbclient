package com.baidu.tieba.homepage.concern.adapter;

import android.graphics.Rect;
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
import com.baidu.card.ao;
import com.baidu.card.d;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class q extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ThreadCardViewHolder<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> agg;
    private String aif;
    private com.baidu.adp.widget.ListView.s amk;
    public BdUniqueId fGZ;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ThreadCardViewHolder<com.baidu.tieba.card.data.k> threadCardViewHolder) {
        return a2(i, view, viewGroup, kVar, (ThreadCardViewHolder) threadCardViewHolder);
    }

    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.agg = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.adapter.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && kVar != null && kVar.bln() != null && !StringUtils.isNull(kVar.bln().getTid())) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        com.baidu.tieba.homepage.concern.c.a(view, kVar, 2);
                    } else if (id == R.id.thread_card_voice) {
                        com.baidu.tieba.homepage.concern.c.a(view, kVar, 6);
                    } else if (id == R.id.user_avatar || id == R.id.user_name) {
                        com.baidu.tieba.homepage.concern.c.a(view, kVar, 1);
                    } else if (id == R.id.god_reply_voice_btn) {
                        ar arVar = new ar("c13423");
                        arVar.ap("obj_locate", 4);
                        if (kVar != null) {
                            arVar.dR("tid", kVar.tid);
                            if (kVar.eJQ != null && kVar.eJQ.bpv() != null) {
                                arVar.dR("pid", kVar.eJQ.bpv().getId());
                            }
                        }
                        TiebaStatic.log(arVar);
                    } else if (id == R.id.god_reply_content) {
                        ar arVar2 = new ar("c13423");
                        arVar2.ap("obj_locate", 2);
                        if (kVar != null) {
                            arVar2.dR("tid", kVar.tid);
                            if (kVar.eJQ != null && kVar.eJQ.bpv() != null) {
                                arVar2.dR("pid", kVar.eJQ.bpv().getId());
                            }
                        }
                        TiebaStatic.log(arVar2);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        ar arVar3 = new ar("c13423");
                        arVar3.ap("obj_locate", 1);
                        if (kVar != null) {
                            arVar3.dR("tid", kVar.tid);
                            if (kVar.eJQ != null && kVar.eJQ.bpv() != null) {
                                arVar3.dR("pid", kVar.eJQ.bpv().getId());
                            }
                        }
                        TiebaStatic.log(arVar3);
                    } else if (id == R.id.god_reply_agree_view) {
                        ar arVar4 = new ar("c13423");
                        arVar4.ap("obj_locate", 5);
                        if (kVar != null) {
                            arVar4.dR("tid", kVar.tid);
                            if (kVar.eJQ != null && kVar.eJQ.bpv() != null) {
                                arVar4.dR("pid", kVar.eJQ.bpv().getId());
                            }
                        }
                        TiebaStatic.log(arVar4);
                    } else if (view.getId() == R.id.forum_name_text) {
                        com.baidu.tieba.homepage.concern.c.a(view, kVar, 7);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            ar arVar5 = new ar("c13423");
                            arVar5.ap("obj_locate", 3);
                            if (kVar != null) {
                                arVar5.dR("tid", kVar.tid);
                                if (kVar.eJQ != null && kVar.eJQ.bpv() != null) {
                                    arVar5.dR("pid", kVar.eJQ.bpv().getId());
                                }
                            }
                            TiebaStatic.log(arVar5);
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
    public ThreadCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.fGZ);
        dVar.bq(128);
        dVar.br(1024);
        dVar.a(new d.a() { // from class: com.baidu.tieba.homepage.concern.adapter.q.2
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
        aVar.ti().bx(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        aVar.c(afVar);
        final af afVar2 = new af(this.mPageContext);
        afVar2.c(true);
        afVar2.setFrom(ImageViewerConfig.FROM_CONCERN);
        afVar2.e(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        afVar2.a(new a.InterfaceC0088a() { // from class: com.baidu.tieba.homepage.concern.adapter.q.3
            @Override // com.baidu.card.a.InterfaceC0088a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.bln() != null && aVar2.bln().eTc != null) {
                    com.baidu.tbadk.util.s.a(1, q.this.mContext, aVar2.bln(), 0, (Rect) null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", (String) null, "concern_tab", "");
                    com.baidu.tieba.homepage.concern.c.a(afVar2.getView(), aVar2, 6);
                }
            }
        });
        aVar.a((com.baidu.card.h) afVar2);
        final com.baidu.card.ar arVar = new com.baidu.card.ar(this.mPageContext.getPageActivity());
        arVar.c(true);
        arVar.setFrom(ImageViewerConfig.FROM_CONCERN);
        arVar.a(new a.InterfaceC0088a() { // from class: com.baidu.tieba.homepage.concern.adapter.q.4
            @Override // com.baidu.card.a.InterfaceC0088a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.bln() != null && aVar2.bln().eTc != null) {
                    com.baidu.tbadk.util.s.a(1, q.this.mContext, aVar2.bln(), 0, (Rect) null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", (String) null, "concern_tab", "");
                    com.baidu.tieba.homepage.concern.c.a(arVar.getView(), aVar2, 6);
                }
            }
        });
        arVar.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.tieba.homepage.concern.adapter.q.5
            @Override // com.baidu.card.view.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                boolean z;
                if (aVar2 != null && aVar2.bln() != null && aVar2.bln().eTc != null) {
                    if (aVar2.bln().eTc.videoInfo != null) {
                        z = aVar2.bln().eTc.videoInfo.is_vertical.intValue() == 1;
                    } else {
                        z = false;
                    }
                    com.baidu.tbadk.util.s.a(1, z, q.this.mContext, aVar2.bln(), 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", null, "concern_tab", "");
                    com.baidu.tieba.homepage.concern.c.a(arVar.getView(), aVar2, 6);
                }
            }
        });
        aVar.a((com.baidu.card.h) arVar);
        aVar.a((com.baidu.card.h) new ao(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.k(this.mPageContext.getPageActivity()));
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
        eVar.eMa = 9;
        eVar.eMg = 9;
        amVar.setAgreeStatisticData(eVar);
        amVar.setFrom(9);
        amVar.setShareReportFrom(4);
        amVar.setFromForPb(1);
        amVar.bq(32);
        aVar.b(amVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.FULL, viewGroup, this.amk);
        a2.setSourceForPb(1);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(a2);
        threadCardViewHolder.setPageId(this.fGZ);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.concern.adapter.q.6
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) nVar;
                    kVar.objType = 1;
                    if (q.this.agg != null) {
                        q.this.agg.a(threadCardViewHolder2.getView(), kVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 1, false, com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup2, view, i));
                    threadCardViewHolder2.tj().b(new a.C0089a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(final int i, final View view, final ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ThreadCardViewHolder threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.eJQ == null) {
            return null;
        }
        kVar.xd(kVar.position + 1);
        threadCardViewHolder.tj().setPosition(i);
        if (threadCardViewHolder.tj().td() instanceof am) {
            ((am) threadCardViewHolder.tj().td()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.homepage.concern.adapter.q.7
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup, view, i));
                    }
                }
            });
        }
        com.baidu.tieba.card.t.csB().e(kVar.IT("c12351"));
        threadCardViewHolder.tj().setPage(this.aif);
        threadCardViewHolder.a(true, Align.ALIGN_RIGHT_TOP);
        threadCardViewHolder.tm();
        threadCardViewHolder.b((ThreadCardViewHolder) kVar);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tj().a(this.agg);
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Ew(String str) {
        this.aif = str;
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.amk = sVar;
    }
}
