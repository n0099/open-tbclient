package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.ak;
import com.baidu.card.b;
import com.baidu.card.e;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
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
public class ah extends com.baidu.tieba.frs.h<bj, com.baidu.card.af<bj>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.x, com.baidu.tieba.frs.d.d {
    private String aey;
    private boolean agt;
    private boolean dIk;
    private NEGFeedBackView.a fsE;
    private com.baidu.tieba.card.z<bj> fsa;
    private HashSet<String> hgE;
    private int hgF;
    private com.baidu.tieba.frs.d.b hgG;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public ah(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.dIk = false;
        this.agt = true;
        this.hgF = 3;
        this.hgG = new com.baidu.tieba.frs.d.b();
        this.fsa = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.ah.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if ("c13010".equals(ah.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").af("obj_type", 3).t("fid", bjVar.getFid()).cI("tid", bjVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, ah.this.mPageId, ah.this.hgG, ah.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, ah.this.mPageId, ah.this.hgG, ah.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, ah.this.mPageId, ah.this.hgG, ah.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 14, ah.this.mPageId, ah.this.hgG, ah.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 12, ah.this.mPageId, ah.this.hgG, ah.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 13, ah.this.mPageId, ah.this.hgG, ah.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, ah.this.mPageId, ah.this.hgG, ah.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bUu().a(ah.this.hgG, bjVar, 2);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.d.c.bUu().a(ah.this.hgG, bjVar, 1);
                    } else {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).af("obj_type", 3));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        an anVar = new an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        anVar.cI("obj_type", "1");
                        anVar.cI("tid", bjVar.getTid());
                        TiebaStatic.log(anVar);
                    } else if (view instanceof OriginalThreadCardView) {
                        an anVar2 = new an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        anVar2.cI("obj_type", "3");
                        anVar2.cI("tid", bjVar.getTid());
                        TiebaStatic.log(anVar2);
                    }
                }
            }
        };
        this.fsE = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.ah.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                TiebaStatic.log(new an("c11973").cI("fid", alVar.getFid()).cI("tid", alVar.getTid()).cI("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(al alVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, al alVar) {
                if (arrayList != null && alVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new an("c11974").cI("obj_locate", sb.toString()).cI("fid", alVar.getFid()).cI("tid", alVar.getTid()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("source", alVar.source).cI(TableDefine.SessionColumns.COLUMN_WEIGHT, alVar.weight).cI(TiebaInitialize.Params.AB_TAG, alVar.doY).cI("extra", alVar.extra).af("card_type", alVar.cardType).af("obj_floor", alVar.doZ));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aA */
    public com.baidu.card.af<bj> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.aW(4280);
        eVar.setPageUniqueId(this.mPageId);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.ah.3
            @Override // com.baidu.card.e.a
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
        aVar.a(eVar);
        com.baidu.card.z zVar = new com.baidu.card.z(this.mPageContext);
        zVar.b((Boolean) false);
        zVar.e(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20));
        zVar.setFrom("frs");
        if (this.hgF == 502) {
            zVar.setNeedFrsTabName(false);
        } else {
            zVar.setNeedFrsTabName(true);
        }
        aVar.rB().bd(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds38));
        aVar.c(zVar);
        com.baidu.card.z zVar2 = new com.baidu.card.z(this.mPageContext);
        zVar2.b((Boolean) true);
        zVar2.setFrom("frs");
        if (this.hgF == 502) {
            zVar2.setNeedFrsTabName(false);
        } else {
            zVar2.setNeedFrsTabName(true);
        }
        zVar2.e(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds39), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds39));
        aVar.a((com.baidu.card.h) zVar2);
        zVar2.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.ah.4
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.aIw() != null && aVar2.aIw().dto != null) {
                    au.a(aVar2.aIw().dto, ah.this.mContext, 3);
                }
            }
        });
        ak akVar = new ak(this.mPageContext.getPageActivity());
        akVar.b((Boolean) true);
        akVar.setFrom("frs");
        akVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.ah.5
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.aIw() != null && aVar2.aIw().dto != null) {
                    au.a(aVar2.aIw().dto, ah.this.mContext, 3);
                }
            }
        });
        akVar.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.tieba.frs.entelechy.a.ah.6
            @Override // com.baidu.card.view.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                boolean z = true;
                if (aVar2 != null && aVar2.aIw() != null && aVar2.aIw().dto != null) {
                    if (aVar2.aIw().dto.videoInfo == null) {
                        z = false;
                    } else if (aVar2.aIw().dto.videoInfo.is_vertical.intValue() != 1) {
                        z = false;
                    }
                    if (z) {
                        ah.this.f(aVar2.aIw().dto);
                    } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                        ah.this.aq(aVar2.aIw());
                    } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_PB) {
                        ah.this.d(aVar2);
                    } else {
                        ah.this.aq(aVar2.aIw());
                    }
                }
            }
        });
        aVar.a((com.baidu.card.h) akVar);
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setFromCDN(this.agt);
        kVar.setForm("frs");
        aVar.a((com.baidu.card.h) kVar);
        com.baidu.card.ag agVar = new com.baidu.card.ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.dmT = 2;
        dVar.dmZ = 2;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(2);
        agVar.setShareReportFrom(3);
        agVar.bl(2);
        agVar.aW(16);
        aVar.b(agVar);
        aVar.rB().setBackgroundResource(R.drawable.addresslist_item_bg);
        com.baidu.card.ad a = aVar.a(true, viewGroup, this.gEc);
        a.bc(2);
        com.baidu.card.af<bj> afVar = new com.baidu.card.af<>(a);
        afVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.v() { // from class: com.baidu.tieba.frs.entelechy.a.ah.7
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bj) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar2 = (com.baidu.card.af) view.getTag();
                    bj bjVar = (bj) mVar;
                    bjVar.objType = 1;
                    if (ah.this.fsa != null) {
                        ah.this.fsa.a(afVar2.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), ah.this.hgF, false);
                    afVar2.rD().b(new a.C0074a(1));
                }
            }
        });
        afVar.rE();
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bj bjVar, com.baidu.card.af<bj> afVar) {
        if (bjVar == null || afVar == null || afVar.getView() == null) {
            return null;
        }
        if (afVar.rD() instanceof com.baidu.tieba.a.e) {
            afVar.rD().setPage(this.aey);
        }
        afVar.rD().setPosition(i);
        super.a(i, view, viewGroup, (ViewGroup) bjVar, (bj) afVar);
        com.baidu.tieba.frs.g.a(afVar.rD().rx(), this.gXO);
        if (this.gXO != null && this.gXO.getForum() != null && !StringUtils.isNull(this.gXO.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.gXO.getForum().getTopic_special_icon_right())) {
            bjVar.cz(this.gXO.getForum().getTopic_special_icon(), this.gXO.getForum().getTopic_special_icon_right());
        }
        boolean z = (bjVar.aKE() == null || bjVar.aKE().getUserId() == null || !bjVar.aKE().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bjVar.aLQ() && bjVar.getFeedBackReasonMap() != null && !z) {
            afVar.aF(true).a(this.fsE);
        }
        afVar.rF();
        if (bjVar.aLQ() && afVar.rD().rx() != null) {
            afVar.rD().rx().aW(32);
        }
        afVar.b((com.baidu.card.af<bj>) bjVar);
        afVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.rD().a(this.fsa);
        if (this.hgG != null) {
            bjVar.doZ = (bjVar.position + 1) - (this.gXO != null ? this.gXO.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bUu().a(this.hgG, bjVar);
        ap(bjVar);
        bjVar.aLN();
        com.baidu.tieba.frs.d.a.a(bjVar, this.mPageId, this.hgG, getTbPageTag());
        if (bjVar != null) {
            bjVar.aLN();
        }
        return afVar.getView();
    }

    private void ap(bj bjVar) {
        if (this.hgE == null) {
            this.hgE = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.bUu().a(bjVar, this.hgE);
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pV(int i) {
        this.hgF = i;
    }

    @Override // com.baidu.tieba.a.f
    public void yc(String str) {
        this.aey = str;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.agt = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hgG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.core.data.a aVar) {
        au.a(aVar.aIw().dto, this.mContext, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(bj bjVar) {
        if (bjVar != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromTransmitThreadData(bjVar);
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, "frs", videoSerializeVideoThreadInfo.threadId, com.baidu.tieba.card.l.aKq(), bjVar.aIz(), videoSerializeVideoThreadInfo);
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
