package com.baidu.tieba.homepage.concern.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.x;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.card.ag;
import com.baidu.card.ah;
import com.baidu.card.al;
import com.baidu.card.b;
import com.baidu.card.e;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class l extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ag<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.k> adt;
    private String aeX;
    private com.baidu.adp.widget.ListView.t aib;
    public BdUniqueId epM;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.aa$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ag<com.baidu.tieba.card.data.k> agVar) {
        return a2(i, view, viewGroup, kVar, (ag) agVar);
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.adt = new aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && kVar != null && kVar.aOi() != null && !StringUtils.isNull(kVar.aOi().getTid())) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        com.baidu.tieba.homepage.concern.b.a(view, kVar, 2);
                    } else if (id == R.id.thread_card_voice) {
                        com.baidu.tieba.homepage.concern.b.a(view, kVar, 6);
                    } else if (id == R.id.user_avatar || id == R.id.user_name) {
                        com.baidu.tieba.homepage.concern.b.a(view, kVar, 1);
                    } else if (id == R.id.god_reply_voice_btn) {
                        an anVar = new an("c13423");
                        anVar.ag("obj_locate", 4);
                        if (kVar != null) {
                            anVar.dh("tid", kVar.tid);
                            if (kVar.dEA != null && kVar.dEA.aSb() != null) {
                                anVar.dh("pid", kVar.dEA.aSb().getId());
                            }
                        }
                        TiebaStatic.log(anVar);
                    } else if (id == R.id.god_reply_content) {
                        an anVar2 = new an("c13423");
                        anVar2.ag("obj_locate", 2);
                        if (kVar != null) {
                            anVar2.dh("tid", kVar.tid);
                            if (kVar.dEA != null && kVar.dEA.aSb() != null) {
                                anVar2.dh("pid", kVar.dEA.aSb().getId());
                            }
                        }
                        TiebaStatic.log(anVar2);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        an anVar3 = new an("c13423");
                        anVar3.ag("obj_locate", 1);
                        if (kVar != null) {
                            anVar3.dh("tid", kVar.tid);
                            if (kVar.dEA != null && kVar.dEA.aSb() != null) {
                                anVar3.dh("pid", kVar.dEA.aSb().getId());
                            }
                        }
                        TiebaStatic.log(anVar3);
                    } else if (id == R.id.god_reply_agree_view) {
                        an anVar4 = new an("c13423");
                        anVar4.ag("obj_locate", 5);
                        if (kVar != null) {
                            anVar4.dh("tid", kVar.tid);
                            if (kVar.dEA != null && kVar.dEA.aSb() != null) {
                                anVar4.dh("pid", kVar.dEA.aSb().getId());
                            }
                        }
                        TiebaStatic.log(anVar4);
                    } else if (view.getId() == R.id.forum_name_text) {
                        com.baidu.tieba.homepage.concern.b.a(view, kVar, 7);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            an anVar5 = new an("c13423");
                            anVar5.ag("obj_locate", 3);
                            if (kVar != null) {
                                anVar5.dh("tid", kVar.tid);
                                if (kVar.dEA != null && kVar.dEA.aSb() != null) {
                                    anVar5.dh("pid", kVar.dEA.aSb().getId());
                                }
                            }
                            TiebaStatic.log(anVar5);
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
    /* renamed from: aM */
    public ag b(ViewGroup viewGroup) {
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.epM);
        eVar.aX(128);
        eVar.aY(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.concern.a.l.2
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
        com.baidu.card.aa aaVar = new com.baidu.card.aa(this.mPageContext);
        aaVar.b((Boolean) false);
        aaVar.e(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds27));
        aaVar.setFrom(ImageViewerConfig.FROM_CONCERN);
        aVar.rK().be(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        aVar.c(aaVar);
        final com.baidu.card.aa aaVar2 = new com.baidu.card.aa(this.mPageContext);
        aaVar2.b((Boolean) true);
        aaVar2.setFrom(ImageViewerConfig.FROM_CONCERN);
        aaVar2.e(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds29), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds37));
        aaVar2.a(new b.a() { // from class: com.baidu.tieba.homepage.concern.a.l.3
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.aOi() != null && absThreadDataSupport.aOi().dHm != null) {
                    au.a(absThreadDataSupport.aOi().dHm, l.this.mContext, 1);
                    com.baidu.tieba.homepage.concern.b.a(aaVar2.getView(), absThreadDataSupport, 6);
                }
            }
        });
        aVar.a((com.baidu.card.h) aaVar2);
        final al alVar = new al(this.mPageContext.getPageActivity());
        alVar.b((Boolean) true);
        alVar.setFrom(ImageViewerConfig.FROM_CONCERN);
        alVar.a(new b.a() { // from class: com.baidu.tieba.homepage.concern.a.l.4
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.aOi() != null && absThreadDataSupport.aOi().dHm != null) {
                    au.a(absThreadDataSupport.aOi().dHm, l.this.mContext, 3);
                    com.baidu.tieba.homepage.concern.b.a(alVar.getView(), absThreadDataSupport, 6);
                }
            }
        });
        alVar.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.tieba.homepage.concern.a.l.5
            @Override // com.baidu.card.view.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                boolean z = true;
                if (absThreadDataSupport != null && absThreadDataSupport.aOi() != null && absThreadDataSupport.aOi().dHm != null) {
                    if (absThreadDataSupport.aOi().dHm.videoInfo == null) {
                        z = false;
                    } else if (absThreadDataSupport.aOi().dHm.videoInfo.is_vertical.intValue() != 1) {
                        z = false;
                    }
                    if (z) {
                        l.this.f(absThreadDataSupport.aOi().dHm);
                    } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                        l.this.ar(absThreadDataSupport.aOi());
                    } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_PB) {
                        l.this.g(absThreadDataSupport);
                    } else {
                        l.this.ar(absThreadDataSupport.aOi());
                    }
                    com.baidu.tieba.homepage.concern.b.a(alVar.getView(), absThreadDataSupport, 6);
                }
            }
        });
        aVar.a((com.baidu.card.h) alVar);
        com.baidu.card.j jVar = new com.baidu.card.j(this.mPageContext.getPageActivity());
        jVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds24));
        aVar.a((com.baidu.card.h) jVar);
        ah ahVar = new ah(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dAZ = 9;
        cVar.dBf = 9;
        ahVar.setAgreeStatisticData(cVar);
        ahVar.setFrom(9);
        ahVar.setShareReportFrom(4);
        ahVar.bm(1);
        ahVar.aX(32);
        aVar.b(ahVar);
        aVar.rK().setBackgroundResource(R.drawable.addresslist_item_bg);
        ae a = aVar.a(true, viewGroup, this.aib);
        a.setSourceForPb(1);
        ag agVar = new ag(a);
        agVar.setPageId(this.epM);
        a(new x() { // from class: com.baidu.tieba.homepage.concern.a.l.6
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, com.baidu.adp.widget.ListView.o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((oVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ag)) {
                    ag agVar2 = (ag) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) oVar;
                    kVar.objType = 1;
                    if (l.this.adt != null) {
                        l.this.adt.a(agVar2.getView(), kVar);
                    }
                    au.a((AbsThreadDataSupport) kVar, view.getContext(), 1, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.t) viewGroup2, view, i));
                    agVar2.rM().b(new a.C0097a(1));
                }
            }
        });
        return agVar;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(final int i, final View view, final ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ag agVar) {
        if (kVar == null || agVar == null || agVar.getView() == null || kVar.dEA == null) {
            return null;
        }
        kVar.sr(kVar.position + 1);
        agVar.rM().setPosition(i);
        if (agVar.rM().rG() instanceof ah) {
            ((ah) agVar.rM().rG()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.homepage.concern.a.l.7
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((com.baidu.adp.widget.ListView.t) viewGroup, view, i));
                    }
                }
            });
        }
        com.baidu.tieba.card.s.bLq().e(kVar.Dt("c12351"));
        agVar.rM().setPage(this.aeX);
        agVar.a(true, kVar.aOp() ? Align.ALIGN_RIGHT_TOP : Align.ALIGN_RIGHT_BOTTOM);
        agVar.b((ag) kVar);
        agVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        agVar.rM().a(this.adt);
        return agVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void zL(String str) {
        this.aeX = str;
    }

    public void a(com.baidu.adp.widget.ListView.t tVar) {
        this.aib = tVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(AbsThreadDataSupport absThreadDataSupport) {
        au.a(absThreadDataSupport.aOi().dHm, this.mContext, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(bk bkVar) {
        if (bkVar != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromTransmitThreadData(bkVar);
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, "concern_tab", videoSerializeVideoThreadInfo.threadId, com.baidu.tieba.card.m.aQj(), bkVar.aOl(), videoSerializeVideoThreadInfo);
            if (videoSerializeVideoThreadInfo.mBaijiahaoData != null && !TextUtils.isEmpty(videoSerializeVideoThreadInfo.mBaijiahaoData.oriUgcNid)) {
                videoMiddlePageActivityConfig.setNid(videoSerializeVideoThreadInfo.mBaijiahaoData.oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithOriginThreadData(originalThreadInfo);
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", null, "concern_tab");
            if (originalThreadInfo.oriUgcInfo != null) {
                videoPlayActivityConfig.setNid(originalThreadInfo.oriUgcInfo.oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }
}
