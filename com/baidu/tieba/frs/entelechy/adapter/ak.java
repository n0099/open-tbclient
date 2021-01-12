package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.ao;
import com.baidu.card.ar;
import com.baidu.card.d;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class ak extends com.baidu.tieba.frs.k<bz, ThreadCardViewHolder<bz>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.frs.b.d {
    private String air;
    private boolean akY;
    private boolean fik;
    private com.baidu.tieba.card.aa<bz> hiC;
    private NEGFeedBackView.a hjg;
    private HashSet<String> jkH;
    private int jkI;
    private com.baidu.tieba.frs.b.b jkJ;
    private boolean jlb;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public ak(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.fik = false;
        this.akY = true;
        this.jkI = 3;
        this.jkJ = new com.baidu.tieba.frs.b.b();
        this.hiC = new com.baidu.tieba.card.aa<bz>() { // from class: com.baidu.tieba.frs.entelechy.adapter.ak.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bz bzVar) {
                if (view != null && bzVar != null) {
                    if ("c13010".equals(ak.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").an("obj_type", 3).w("fid", bzVar.getFid()).dW("tid", bzVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 2, ak.this.mPageId, ak.this.jkJ, ak.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 15, ak.this.mPageId, ak.this.jkJ, ak.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 5, ak.this.mPageId, ak.this.jkJ, ak.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 14, ak.this.mPageId, ak.this.jkJ, ak.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 12, ak.this.mPageId, ak.this.jkJ, ak.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 13, ak.this.mPageId, ak.this.jkJ, ak.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.b.a.a(bzVar, 1, ak.this.mPageId, ak.this.jkJ, ak.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.c.cIR().a(ak.this.jkJ, bzVar, 2);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.b.c.cIR().a(ak.this.jkJ, bzVar, 1);
                    } else {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).an("obj_type", 3));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        aq aqVar = new aq(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        aqVar.dW("obj_type", "1");
                        aqVar.dW("tid", bzVar.getTid());
                        TiebaStatic.log(aqVar);
                    } else if (view instanceof OriginalThreadCardView) {
                        aq aqVar2 = new aq(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        aqVar2.dW("obj_type", "3");
                        aqVar2.dW("tid", bzVar.getTid());
                        TiebaStatic.log(aqVar2);
                    }
                }
            }
        };
        this.hjg = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.adapter.ak.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(at atVar) {
                TiebaStatic.log(new aq("c11973").dW("fid", atVar.getFid()).dW("tid", atVar.getTid()).dW("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(at atVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, at atVar) {
                if (arrayList != null && atVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + ",");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new aq("c11974").dW("obj_locate", sb.toString()).dW("fid", atVar.getFid()).dW("tid", atVar.getTid()).dW(IntentConfig.NID, atVar.blV()).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("source", atVar.source).dW("weight", atVar.weight).dW("ab_tag", atVar.abTag).dW("extra", atVar.extra).an(IntentConfig.CARD_TYPE, atVar.cardType).an("obj_floor", atVar.eMg));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder<bz> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.bq(4280);
        dVar.setPageUniqueId(this.mPageId);
        dVar.a(new d.a() { // from class: com.baidu.tieba.frs.entelechy.adapter.ak.3
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
        com.baidu.card.af afVar = new com.baidu.card.af(this.mPageContext);
        afVar.c(false);
        afVar.setFrom("frs");
        if (this.jkI == 502) {
            afVar.setNeedFrsTabName(false);
        } else {
            afVar.setNeedFrsTabName(true);
        }
        aVar.tl().bx(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds38));
        aVar.c(afVar);
        com.baidu.card.af afVar2 = new com.baidu.card.af(this.mPageContext);
        afVar2.c(true);
        afVar2.setFrom("frs");
        if (this.jkI == 502) {
            afVar2.setNeedFrsTabName(false);
        } else {
            afVar2.setNeedFrsTabName(true);
        }
        afVar2.e(com.baidu.tbadk.a.b.b.bjq(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), com.baidu.tbadk.a.b.b.bjq(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
        aVar.a((com.baidu.card.h) afVar2);
        afVar2.a(new a.InterfaceC0088a() { // from class: com.baidu.tieba.frs.entelechy.adapter.ak.4
            @Override // com.baidu.card.a.InterfaceC0088a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.bkV() != null && aVar2.bkV().eQQ != null) {
                    ay.a(aVar2.bkV().eQQ, ak.this.mContext, 3);
                }
            }
        });
        ar arVar = new ar(this.mPageContext.getPageActivity());
        arVar.c(true);
        arVar.setFrom("frs");
        arVar.a(new a.InterfaceC0088a() { // from class: com.baidu.tieba.frs.entelechy.adapter.ak.5
            @Override // com.baidu.card.a.InterfaceC0088a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.bkV() != null && aVar2.bkV().eQQ != null) {
                    ay.a(aVar2.bkV().eQQ, ak.this.mContext, 3);
                }
            }
        });
        arVar.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.tieba.frs.entelechy.adapter.ak.6
            @Override // com.baidu.card.view.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                boolean z = true;
                if (aVar2 != null && aVar2.bkV() != null && aVar2.bkV().eQQ != null) {
                    if (aVar2.bkV().eQQ.videoInfo == null) {
                        z = false;
                    } else if (aVar2.bkV().eQQ.videoInfo.is_vertical.intValue() != 1) {
                        z = false;
                    }
                    if (z) {
                        ak.this.f(aVar2.bkV().eQQ);
                    } else {
                        ak.this.ar(aVar2.bkV());
                    }
                }
            }
        });
        aVar.a((com.baidu.card.h) arVar);
        aVar.a((com.baidu.card.h) new ao(this.mPageContext.getPageActivity()));
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.akY);
        nVar.setForm("frs");
        aVar.a((com.baidu.card.h) nVar);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.eJO = 2;
        dVar2.eJU = 2;
        amVar.setAgreeStatisticData(dVar2);
        amVar.setFrom(2);
        amVar.setShareReportFrom(3);
        amVar.setFromForPb(2);
        amVar.bq(48);
        aVar.b(amVar);
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.FULL, viewGroup, this.iGb);
        a2.setSourceForPb(2);
        ThreadCardViewHolder<bz> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.ak.7
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar2 instanceof bz) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    bz bzVar = (bz) nVar2;
                    bzVar.objType = 1;
                    if (ak.this.hiC != null) {
                        ak.this.hiC.a(threadCardViewHolder2.getView(), bzVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) bzVar, view.getContext(), ak.this.jkI, false);
                    threadCardViewHolder2.tm().b(new a.C0089a(1));
                }
            }
        });
        threadCardViewHolder.tn();
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bz bzVar, ThreadCardViewHolder<bz> threadCardViewHolder) {
        if (bzVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
            return null;
        }
        if (threadCardViewHolder.tm() instanceof com.baidu.tieba.a.e) {
            threadCardViewHolder.tm().setPage(this.air);
        }
        threadCardViewHolder.tm().setPosition(i);
        super.a(i, view, viewGroup, (ViewGroup) bzVar, (bz) threadCardViewHolder);
        com.baidu.tieba.frs.j.a(threadCardViewHolder.tm().tg(), this.jaa);
        if (this.jaa != null && this.jaa.getForum() != null && !StringUtils.isNull(this.jaa.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.jaa.getForum().getTopic_special_icon_right())) {
            bzVar.dJ(this.jaa.getForum().getTopic_special_icon(), this.jaa.getForum().getTopic_special_icon_right());
        }
        boolean z = (bzVar.bnx() == null || bzVar.bnx().getUserId() == null || !bzVar.bnx().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bzVar.boP() && bzVar.getFeedBackReasonMap() != null && !z) {
            threadCardViewHolder.aK(true).a(this.hjg);
        }
        threadCardViewHolder.tp();
        if (threadCardViewHolder.tm().tg() != null) {
            threadCardViewHolder.tm().tg().bq(32);
        }
        threadCardViewHolder.b((ThreadCardViewHolder<bz>) bzVar);
        threadCardViewHolder.tm().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tm().a(this.hiC);
        if (this.jkJ != null) {
            bzVar.eMg = (bzVar.position + 1) - (this.jaa != null ? this.jaa.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.b.c.cIR().a(this.jkJ, bzVar);
        aq(bzVar);
        bzVar.boL();
        com.baidu.tieba.frs.b.a.a(bzVar, this.mPageId, this.jkJ, getTbPageTag());
        if (bzVar != null) {
            bzVar.boL();
        }
        return threadCardViewHolder.getView();
    }

    private void aq(bz bzVar) {
        if (this.jkH == null) {
            this.jkH = new HashSet<>();
        }
        com.baidu.tieba.frs.b.c.cIR().a(bzVar, this.jkH);
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void uN(int i) {
        this.jkI = i;
    }

    @Override // com.baidu.tieba.a.f
    public void Ea(String str) {
        this.air = str;
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.akY = z;
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jkJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(bz bzVar) {
        if (bzVar != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromTransmitThreadData(bzVar);
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, "frs", videoSerializeVideoThreadInfo.threadId, com.baidu.tieba.card.m.bnj(), bzVar.bkY(), videoSerializeVideoThreadInfo);
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

    public void qU(boolean z) {
        this.jlb = z;
    }
}
