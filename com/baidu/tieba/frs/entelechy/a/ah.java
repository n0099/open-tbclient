package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.card.al;
import com.baidu.card.b;
import com.baidu.card.e;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes9.dex */
public class ah extends com.baidu.tieba.frs.h<bk, com.baidu.card.ag<bk>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String aeX;
    private boolean aha;
    private boolean dWD;
    private com.baidu.tieba.card.aa<bk> fFX;
    private NEGFeedBackView.a fGB;
    private com.baidu.tieba.frs.d.b hvA;
    private HashSet<String> hvy;
    private int hvz;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public ah(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.dWD = false;
        this.aha = true;
        this.hvz = 3;
        this.hvA = new com.baidu.tieba.frs.d.b();
        this.fFX = new com.baidu.tieba.card.aa<bk>() { // from class: com.baidu.tieba.frs.entelechy.a.ah.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bk bkVar) {
                if (view != null && bkVar != null) {
                    if ("c13010".equals(ah.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").ag("obj_type", 3).s("fid", bkVar.getFid()).dh("tid", bkVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 2, ah.this.mPageId, ah.this.hvA, ah.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 15, ah.this.mPageId, ah.this.hvA, ah.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 5, ah.this.mPageId, ah.this.hvA, ah.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 14, ah.this.mPageId, ah.this.hvA, ah.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 12, ah.this.mPageId, ah.this.hvA, ah.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 13, ah.this.mPageId, ah.this.hvA, ah.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bkVar, 1, ah.this.mPageId, ah.this.hvA, ah.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.caQ().a(ah.this.hvA, bkVar, 2);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.d.c.caQ().a(ah.this.hvA, bkVar, 1);
                    } else {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).ag("obj_type", 3));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        an anVar = new an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        anVar.dh("obj_type", "1");
                        anVar.dh("tid", bkVar.getTid());
                        TiebaStatic.log(anVar);
                    } else if (view instanceof OriginalThreadCardView) {
                        an anVar2 = new an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        anVar2.dh("obj_type", "3");
                        anVar2.dh("tid", bkVar.getTid());
                        TiebaStatic.log(anVar2);
                    }
                }
            }
        };
        this.fGB = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.ah.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(ak akVar) {
                TiebaStatic.log(new an("c11973").dh("fid", akVar.getFid()).dh("tid", akVar.getTid()).dh("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ak akVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, ak akVar) {
                if (arrayList != null && akVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new an("c11974").dh("obj_locate", sb.toString()).dh("fid", akVar.getFid()).dh("tid", akVar.getTid()).dh("nid", akVar.getNid()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("source", akVar.source).dh("weight", akVar.weight).dh("ab_tag", akVar.abTag).dh("extra", akVar.extra).ag(IntentConfig.CARD_TYPE, akVar.cardType).ag("obj_floor", akVar.dDb));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public com.baidu.card.ag<bk> b(ViewGroup viewGroup) {
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.aX(4280);
        eVar.setPageUniqueId(this.mPageId);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.ah.3
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
        aaVar.e(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20));
        aaVar.setFrom("frs");
        if (this.hvz == 502) {
            aaVar.setNeedFrsTabName(false);
        } else {
            aaVar.setNeedFrsTabName(true);
        }
        aVar.rK().be(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds38));
        aVar.c(aaVar);
        com.baidu.card.aa aaVar2 = new com.baidu.card.aa(this.mPageContext);
        aaVar2.b((Boolean) true);
        aaVar2.setFrom("frs");
        if (this.hvz == 502) {
            aaVar2.setNeedFrsTabName(false);
        } else {
            aaVar2.setNeedFrsTabName(true);
        }
        aaVar2.e(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds39), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds39));
        aVar.a((com.baidu.card.h) aaVar2);
        aaVar2.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.ah.4
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.aOi() != null && absThreadDataSupport.aOi().dHm != null) {
                    au.a(absThreadDataSupport.aOi().dHm, ah.this.mContext, 3);
                }
            }
        });
        al alVar = new al(this.mPageContext.getPageActivity());
        alVar.b((Boolean) true);
        alVar.setFrom("frs");
        alVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.ah.5
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.aOi() != null && absThreadDataSupport.aOi().dHm != null) {
                    au.a(absThreadDataSupport.aOi().dHm, ah.this.mContext, 3);
                }
            }
        });
        alVar.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.tieba.frs.entelechy.a.ah.6
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
                        ah.this.f(absThreadDataSupport.aOi().dHm);
                    } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                        ah.this.ar(absThreadDataSupport.aOi());
                    } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_PB) {
                        ah.this.g(absThreadDataSupport);
                    } else {
                        ah.this.ar(absThreadDataSupport.aOi());
                    }
                }
            }
        });
        aVar.a((com.baidu.card.h) alVar);
        com.baidu.card.l lVar = new com.baidu.card.l(this.mPageContext.getPageActivity());
        lVar.setFromCDN(this.aha);
        lVar.setForm("frs");
        aVar.a((com.baidu.card.h) lVar);
        com.baidu.card.ah ahVar = new com.baidu.card.ah(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dAZ = 2;
        cVar.dBf = 2;
        ahVar.setAgreeStatisticData(cVar);
        ahVar.setFrom(2);
        ahVar.setShareReportFrom(3);
        ahVar.bm(2);
        ahVar.aX(16);
        aVar.b(ahVar);
        aVar.rK().setBackgroundResource(R.drawable.addresslist_item_bg);
        com.baidu.card.ae a = aVar.a(true, viewGroup, this.gSQ);
        a.setSourceForPb(2);
        com.baidu.card.ag<bk> agVar = new com.baidu.card.ag<>(a);
        agVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.x() { // from class: com.baidu.tieba.frs.entelechy.a.ah.7
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, com.baidu.adp.widget.ListView.o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((oVar instanceof bk) && (view.getTag() instanceof com.baidu.card.ag)) {
                    com.baidu.card.ag agVar2 = (com.baidu.card.ag) view.getTag();
                    bk bkVar = (bk) oVar;
                    bkVar.objType = 1;
                    if (ah.this.fFX != null) {
                        ah.this.fFX.a(agVar2.getView(), bkVar);
                    }
                    au.a((AbsThreadDataSupport) bkVar, view.getContext(), ah.this.hvz, false);
                    agVar2.rM().b(new a.C0097a(1));
                }
            }
        });
        agVar.rN();
        return agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bk bkVar, com.baidu.card.ag<bk> agVar) {
        if (bkVar == null || agVar == null || agVar.getView() == null) {
            return null;
        }
        if (agVar.rM() instanceof com.baidu.tieba.a.e) {
            agVar.rM().setPage(this.aeX);
        }
        agVar.rM().setPosition(i);
        super.a(i, view, viewGroup, (ViewGroup) bkVar, (bk) agVar);
        com.baidu.tieba.frs.g.a(agVar.rM().rG(), this.hmG);
        if (this.hmG != null && this.hmG.getForum() != null && !StringUtils.isNull(this.hmG.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.hmG.getForum().getTopic_special_icon_right())) {
            bkVar.cY(this.hmG.getForum().getTopic_special_icon(), this.hmG.getForum().getTopic_special_icon_right());
        }
        boolean z = (bkVar.aQx() == null || bkVar.aQx().getUserId() == null || !bkVar.aQx().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bkVar.aRN() && bkVar.getFeedBackReasonMap() != null && !z) {
            agVar.aH(true).a(this.fGB);
        }
        agVar.rO();
        if (bkVar.aRN() && agVar.rM().rG() != null) {
            agVar.rM().rG().aX(32);
        }
        agVar.b((com.baidu.card.ag<bk>) bkVar);
        agVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        agVar.rM().a(this.fFX);
        if (this.hvA != null) {
            bkVar.dDb = (bkVar.position + 1) - (this.hmG != null ? this.hmG.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.caQ().a(this.hvA, bkVar);
        aq(bkVar);
        bkVar.aRK();
        com.baidu.tieba.frs.d.a.a(bkVar, this.mPageId, this.hvA, getTbPageTag());
        if (bkVar != null) {
            bkVar.aRK();
        }
        return agVar.getView();
    }

    private void aq(bk bkVar) {
        if (this.hvy == null) {
            this.hvy = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.caQ().a(bkVar, this.hvy);
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void qw(int i) {
        this.hvz = i;
    }

    @Override // com.baidu.tieba.a.f
    public void zL(String str) {
        this.aeX = str;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.aha = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hvA;
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
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, "frs", videoSerializeVideoThreadInfo.threadId, com.baidu.tieba.card.m.aQj(), bkVar.aOl(), videoSerializeVideoThreadInfo);
            if (videoSerializeVideoThreadInfo.mBaijiahaoData != null) {
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
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, "frs");
            if (originalThreadInfo.oriUgcInfo != null) {
                videoPlayActivityConfig.setNid(originalThreadInfo.oriUgcInfo.oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }
}
