package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.b;
import com.baidu.card.e;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes16.dex */
public class i extends com.baidu.tieba.frs.j<bu, com.baidu.card.ak<bv>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String afx;
    private boolean aib;
    private boolean ekj;
    private com.baidu.tieba.card.aa<bv> fWK;
    private NEGFeedBackView.a fXo;
    private HashSet<String> hOC;
    private int hOD;
    private com.baidu.tieba.frs.d.b hOE;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.ekj = false;
        this.aib = true;
        this.hOD = 3;
        this.hOE = new com.baidu.tieba.frs.d.b();
        this.fWK = new com.baidu.tieba.card.aa<bv>() { // from class: com.baidu.tieba.frs.entelechy.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bv bvVar) {
                if (view != null && bvVar != null) {
                    if ("c13010".equals(i.this.mFrom)) {
                        TiebaStatic.log(new ap("c13010").ah("obj_type", 3).t("fid", bvVar.getFid()).dn("tid", bvVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 2, i.this.mPageId, i.this.hOE, i.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 15, i.this.mPageId, i.this.hOE, i.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 5, i.this.mPageId, i.this.hOE, i.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 14, i.this.mPageId, i.this.hOE, i.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 12, i.this.mPageId, i.this.hOE, i.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 13, i.this.mPageId, i.this.hOE, i.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bvVar, 1, i.this.mPageId, i.this.hOE, i.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.chQ().a(i.this.hOE, bvVar, 2);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.d.c.chQ().a(i.this.hOE, bvVar, 1);
                    } else {
                        TiebaStatic.log(new ap(CommonStatisticKey.USER_ICON_VISIT).ah("obj_type", 3));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        ap apVar = new ap(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        apVar.dn("obj_type", "1");
                        apVar.dn("tid", bvVar.getTid());
                        TiebaStatic.log(apVar);
                    } else if (view instanceof OriginalThreadCardView) {
                        ap apVar2 = new ap(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        apVar2.dn("obj_type", "3");
                        apVar2.dn("tid", bvVar.getTid());
                        TiebaStatic.log(apVar2);
                    }
                }
            }
        };
        this.fXo = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.i.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aq aqVar) {
                TiebaStatic.log(new ap("c11973").dn("fid", aqVar.getFid()).dn("tid", aqVar.getTid()).dn("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(aq aqVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, aq aqVar) {
                if (arrayList != null && aqVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new ap("c11974").dn("obj_locate", sb.toString()).dn("fid", aqVar.getFid()).dn("tid", aqVar.getTid()).dn("nid", aqVar.getNid()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("source", aqVar.source).dn("weight", aqVar.weight).dn("ab_tag", aqVar.abTag).dn("extra", aqVar.extra).ah(IntentConfig.CARD_TYPE, aqVar.cardType).ah("obj_floor", aqVar.dPI));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.card.ak<bv> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.bf(4280);
        eVar.setPageUniqueId(this.mPageId);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.i.3
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
        com.baidu.card.ad adVar = new com.baidu.card.ad(this.mPageContext);
        adVar.b((Boolean) false);
        adVar.e(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20));
        adVar.setFrom("frs");
        if (this.hOD == 502) {
            adVar.setNeedFrsTabName(false);
        } else {
            adVar.setNeedFrsTabName(true);
        }
        aVar.se().bm(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds38));
        aVar.c(adVar);
        com.baidu.card.ad adVar2 = new com.baidu.card.ad(this.mPageContext);
        adVar2.b((Boolean) true);
        adVar2.setFrom("frs");
        if (this.hOD == 502) {
            adVar2.setNeedFrsTabName(false);
        } else {
            adVar2.setNeedFrsTabName(true);
        }
        adVar2.e(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds39), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds31));
        aVar.a((com.baidu.card.h) adVar2);
        adVar2.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.i.4
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.aTN() != null && absThreadDataSupport.aTN().dUi != null) {
                    ax.a(absThreadDataSupport.aTN().dUi, i.this.mContext, 3);
                }
            }
        });
        com.baidu.card.aq aqVar = new com.baidu.card.aq(this.mPageContext.getPageActivity());
        aqVar.b((Boolean) true);
        aqVar.setFrom("frs");
        aqVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.i.5
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.aTN() != null && absThreadDataSupport.aTN().dUi != null) {
                    ax.a(absThreadDataSupport.aTN().dUi, i.this.mContext, 3);
                }
            }
        });
        aqVar.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.tieba.frs.entelechy.a.i.6
            @Override // com.baidu.card.view.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                boolean z = true;
                if (absThreadDataSupport != null && absThreadDataSupport.aTN() != null && absThreadDataSupport.aTN().dUi != null) {
                    if (absThreadDataSupport.aTN().dUi.videoInfo == null) {
                        z = false;
                    } else if (absThreadDataSupport.aTN().dUi.videoInfo.is_vertical.intValue() != 1) {
                        z = false;
                    }
                    if (z) {
                        i.this.f(absThreadDataSupport.aTN().dUi);
                    } else {
                        i.this.ao(absThreadDataSupport.aTN());
                    }
                }
            }
        });
        aVar.a((com.baidu.card.h) aqVar);
        com.baidu.card.l lVar = new com.baidu.card.l(this.mPageContext.getPageActivity());
        lVar.setFromCDN(this.aib);
        lVar.setForm("frs");
        aVar.a((com.baidu.card.h) lVar);
        com.baidu.card.al alVar = new com.baidu.card.al(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dNB = 2;
        cVar.dNH = 2;
        alVar.setAgreeStatisticData(cVar);
        alVar.setFrom(2);
        alVar.setShareReportFrom(3);
        alVar.setFromForPb(2);
        alVar.bf(16);
        aVar.b(alVar);
        aVar.se().setBackgroundResource(R.drawable.addresslist_item_bg);
        com.baidu.card.ai a = aVar.a(true, viewGroup, this.hlu);
        a.setSourceForPb(2);
        com.baidu.card.ak<bv> akVar = new com.baidu.card.ak<>(a);
        akVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.frs.entelechy.a.i.7
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bu) && (view.getTag() instanceof com.baidu.card.ak)) {
                    com.baidu.card.ak akVar2 = (com.baidu.card.ak) view.getTag();
                    bv bvVar = ((bu) qVar).dLK;
                    bvVar.objType = 1;
                    if (i.this.fWK != null) {
                        i.this.fWK.a(akVar2.getView(), bvVar);
                    }
                    ax.a((AbsThreadDataSupport) bvVar, view.getContext(), i.this.hOD, false);
                    akVar2.sg().b(new a.C0096a(1));
                }
            }
        });
        akVar.sh();
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bu buVar, com.baidu.card.ak<bv> akVar) {
        if (buVar == null || akVar == null || akVar.getView() == null) {
            return null;
        }
        if (akVar.sg() instanceof com.baidu.tieba.a.e) {
            akVar.sg().setPage(this.afx);
        }
        akVar.sg().setPosition(i);
        super.a(i, view, viewGroup, (ViewGroup) buVar, (bu) akVar);
        com.baidu.tieba.frs.i.a(akVar.sg().sa(), this.hEX);
        if (this.hEX != null && this.hEX.getForum() != null && !StringUtils.isNull(this.hEX.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.hEX.getForum().getTopic_special_icon_right())) {
            buVar.dLK.de(this.hEX.getForum().getTopic_special_icon(), this.hEX.getForum().getTopic_special_icon_right());
        }
        boolean z = (buVar.dLK.aWl() == null || buVar.dLK.aWl().getUserId() == null || !buVar.dLK.aWl().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (buVar.dLK.aXA() && buVar.dLK.getFeedBackReasonMap() != null && !z) {
            akVar.aK(true).a(this.fXo);
        }
        akVar.si();
        if (buVar.dLK.aXA() && akVar.sg().sa() != null) {
            akVar.sg().sa().bf(32);
        }
        akVar.b((com.baidu.card.ak<bv>) buVar.dLK);
        akVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.sg().a(this.fWK);
        if (this.hOE != null) {
            buVar.dLK.dPI = (buVar.position + 1) - (this.hEX != null ? this.hEX.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.chQ().a(this.hOE, buVar.dLK);
        an(buVar.dLK);
        buVar.dLK.aXx();
        com.baidu.tieba.frs.d.a.a(buVar.dLK, this.mPageId, this.hOE, getTbPageTag());
        if (buVar.dLK != null) {
            buVar.dLK.aXx();
        }
        return akVar.getView();
    }

    private void an(bv bvVar) {
        if (this.hOC == null) {
            this.hOC = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.chQ().a(bvVar, this.hOC);
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void rn(int i) {
        this.hOD = i;
    }

    @Override // com.baidu.tieba.a.f
    public void AP(String str) {
        this.afx = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.ekj = z;
    }

    @Override // com.baidu.tieba.frs.j
    public void setFromCDN(boolean z) {
        this.aib = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hOE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(bv bvVar) {
        if (bvVar != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromTransmitThreadData(bvVar);
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, "frs", videoSerializeVideoThreadInfo.threadId, com.baidu.tieba.card.m.aVX(), bvVar.aTQ(), videoSerializeVideoThreadInfo);
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
