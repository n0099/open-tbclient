package com.baidu.tieba.ala.livecard.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.y;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.a<bz> implements com.baidu.tieba.a.e, y {
    private CardUserInfoLayout agx;
    private String air;
    private final View.OnClickListener akt;
    private HeadImageView gAD;
    private LinearLayout gFk;
    private RelativeLayout hiR;
    private View hiU;
    public AlaVideoContainer hiV;
    private LinearLayout hjB;
    private TextView hjC;
    private TextView hjD;
    private RelativeLayout hjE;
    private ThreadSourceShareAndPraiseLayout hjF;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.akt = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cqL() != null) {
                    c.this.cqL().a(view, c.this.agr);
                }
            }
        };
        setTag(bdUniqueId);
        this.eSJ = tbPageContext;
        View view = getView();
        this.hiR = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.hiR.setOnClickListener(this);
        this.hjB = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.hjB.setOnClickListener(this);
        this.hjE = (RelativeLayout) view.findViewById(R.id.ala_share_container);
        this.gFk = (LinearLayout) this.hjE.findViewById(R.id.challenge_root);
        this.agx = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.agx.setShowFlag(6141);
        this.gAD = (HeadImageView) view.findViewById(R.id.ala_share_live_user_pendant_header);
        this.gAD.setIsRound(true);
        this.gAD.setDrawBorder(false);
        this.gAD.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gAD.setAutoChangeStyle(false);
        this.hjD = (TextView) view.findViewById(R.id.ala_share_live_username_text);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.hjC = (TextView) view.findViewById(R.id.ala_live_room_title);
        this.hiV = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.hiV.setOnVideoClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.hiT = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        b(this.hiT);
        this.hiT.setSelectVisible(false);
        this.hiT.setIsBarViewVisible(false);
        this.hiT.setCommentNumEnable(true);
        this.hiT.setLiveShareEnable(false);
        this.hiT.setFrom(2);
        this.hiT.getCommentContainer().setOnClickListener(this);
        this.hiT.hideDisagree();
        this.hiT.setShareReportFrom(1);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eJO = 2;
        dVar.eJU = 2;
        this.hiT.setAgreeStatisticData(dVar);
        this.ioL = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.ioL);
        this.ioL.setFrom(2);
        this.ioL.setShareReportFrom(1);
        this.hjF = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.hjF.fjb.setOnClickListener(this);
        this.hjF.fjb.getCommentContainer().setOnClickListener(this);
        this.hjF.setFrom(2);
        this.hjF.setShareReportFrom(1);
        this.hjF.setSourceFromForPb(3);
        this.hjF.setStType("frs_page");
        this.hjF.setHideBarName(true);
        this.hiU = view.findViewById(R.id.divider_below_reply_number_layout);
        this.hiV.setLigvingLogLayoutVisible(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            g(tbPageContext, i);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.hiR).od(R.string.J_X06).aM(R.color.CAM_X0205, R.color.CAM_X0206);
            ao.setBackgroundColor(this.hjE, R.color.CAM_X0204);
            if (this.hiV != null) {
                this.hiV.onChangeSkinType(i);
            }
            this.agx.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.hiT.onChangeSkinType();
            this.mSkinType = i;
            if (this.gAD != null) {
                this.gAD.setPlaceHolder(1);
            }
            if (this.hjF != null && this.hjF.getVisibility() == 0) {
                this.hjF.onChangeSkinType();
            }
        }
        if (this.agr != 0 && m.Id(((bz) this.agr).getId())) {
            ao.setViewTextColor(this.mTextTitle, R.color.CAM_X0109);
            ao.setViewTextColor(this.hjC, R.color.CAM_X0109);
            ao.setViewTextColor(this.hjD, R.color.CAM_X0109);
        } else {
            ao.setViewTextColor(this.mTextTitle, R.color.CAM_X0105);
            ao.setViewTextColor(this.hjC, R.color.CAM_X0106);
            ao.setViewTextColor(this.hjD, R.color.CAM_X0105);
        }
        ao.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_share_live_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bz bzVar) {
        this.agr = bzVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void uN(int i) {
    }

    private void refreshView() {
        if (this.agr == 0 || ((bz) this.agr).bnx() == null) {
            this.hiR.setVisibility(8);
            return;
        }
        this.hiR.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hiR.getLayoutParams();
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        layoutParams.bottomMargin = 0;
        this.agx.setData((bz) this.agr);
        this.agx.setUserAfterClickListener(this.akt);
        this.hiV.getController().a((bz) this.agr, this.mForumName, "", false);
        this.hiV.getController().startPlayAnimation();
        if (((bz) this.agr).bnQ() != null && ((bz) this.agr).bnQ().share_info != null && !StringUtils.isNull(((bz) this.agr).bnQ().share_info.content)) {
            this.mTextTitle.setVisibility(0);
            this.mTextTitle.setText(((bz) this.agr).bnQ().share_info.content);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (((bz) this.agr).bnQ() != null && ((bz) this.agr).bnQ().user_info != null) {
            String str = ((bz) this.agr).bnQ().user_info.user_name;
            if (ad.getTextLengthWithEmoji(str) > 14) {
                str = ad.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.hjD.setText(str + ":");
            if (TextUtils.isEmpty(((bz) this.agr).bnQ().user_info.portrait)) {
                this.gAD.setPlaceHolder(1);
            } else {
                this.gAD.startLoad(((bz) this.agr).bnQ().user_info.portrait, 10, false, false);
            }
        }
        String title = ((bz) this.agr).getTitle();
        if (!StringUtils.isNull(title)) {
            this.hjC.setText(title);
            this.hjC.setVisibility(0);
        } else {
            this.hjC.setVisibility(8);
        }
        uP(sR(1));
        if (((bz) this.agr).bnQ().mChallengeInfoData != null && ((bz) this.agr).bnQ().mChallengeInfoData.challenge_id > 0) {
            this.gFk.setVisibility(0);
        } else {
            this.gFk.setVisibility(8);
        }
        this.mMaskView.setVisibility((com.baidu.tieba.frs.b.cAg().cAa() || com.baidu.tieba.frs.a.czZ().cAa()) ? 0 : 8);
        ba(this.hiR);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        tr();
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hiT != null) {
            if (this.agx != null) {
                this.agx.setPageUniqueId(bdUniqueId);
            }
            setTag(bdUniqueId);
            q(bdUniqueId);
        }
    }

    private void tr() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hjE.getLayoutParams();
        if (this.mTextTitle.getVisibility() == 0) {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        } else {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
        }
        this.hjE.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.b.cAg().cAa() && !com.baidu.tieba.frs.a.czZ().cAa()) {
            if (view == this.hiR || view == this.hiT.getCommentContainer() || this.hjB == view || view == this.hjF.fjb.getCommentContainer() || view == this.ioL.getCommentContainer()) {
                if (this.agr != 0) {
                    m.Ic(((bz) this.agr).getId());
                }
                if (cqL() != null) {
                    cqL().a(this.hiR, this.agr);
                }
                TiebaStatic.log(new aq("c12323"));
                int i = 5;
                if (((bz) this.agr).bnQ().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                    i = 1;
                }
                if (view == this.hiT.getCommentContainer() || view == this.hjF.fjb.getCommentContainer()) {
                    aq aqVar = new aq("c12942");
                    aqVar.an("obj_locate", 2);
                    aqVar.dW("tid", ((bz) this.agr).getTid());
                    aqVar.an("obj_type", i);
                    aqVar.dW(IntentConfig.NID, ((bz) this.agr).blV());
                    com.baidu.tbadk.pageExtra.c bV = com.baidu.tbadk.pageExtra.d.bV(view);
                    if (bV != null) {
                        aqVar.dW("obj_cur_page", bV.getCurrentPageKey());
                    }
                    if (com.baidu.tbadk.pageExtra.d.bDu() != null) {
                        aqVar.dW("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDu());
                    }
                    TiebaStatic.log(aqVar);
                }
            } else if (view.getId() == R.id.video_container) {
                if (cqL() != null) {
                    cqL().a(view, this.agr);
                }
                TiebaStatic.log(new aq("c12323"));
                if (((bz) this.agr).bnQ().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                }
            }
        }
    }

    private void p(TbPageContext<?> tbPageContext) {
        if (this.agr != 0 && ((bz) this.agr).bnQ() != null && ((bz) this.agr).bnQ().share_info != null) {
            if (((bz) this.agr).bnQ().share_info.record_tid <= 0) {
                q(this.mTbPageContext);
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(((bz) this.agr).bnQ().share_info.record_tid), null, "frs_page");
            createNormalCfg.setVideo_source(((bz) this.agr).boI() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs");
            createNormalCfg.setFromSmartFrs(((bz) this.agr).boP());
            createNormalCfg.setSmartFrsPosition(((bz) this.agr).boV());
            createNormalCfg.setStartFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }

    public void q(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.agr != 0 && ((bz) this.agr).bnQ() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(tbPageContext.getPageActivity(), R.string.no_network_guide);
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(((bz) this.agr).bnQ());
            if (((bz) this.agr).bnQ().user_info != null) {
                alaLiveInfoCoreData.userName = ((bz) this.agr).bnQ().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, "frs_share_live", "", false, this.mForumName)));
        }
    }

    public void uP(int i) {
        if (this.agr != 0) {
            if (i == 1) {
                this.hiT.setVisibility(8);
                this.hjF.setData((bz) this.agr);
                return;
            }
            this.hiT.setData((bz) this.agr);
            this.hjF.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.air = str;
    }

    public int sR(int i) {
        return com.baidu.tieba.a.d.bKv().az(this.air, i);
    }

    public ThreadCommentAndPraiseInfoLayout bXS() {
        return this.hiT;
    }

    public ThreadCommentAndPraiseInfoLayout bXT() {
        if (this.hjF != null) {
            return this.hjF.fjb;
        }
        return null;
    }
}
