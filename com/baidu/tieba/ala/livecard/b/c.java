package com.baidu.tieba.ala.livecard.b;

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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.z;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.a<bx> implements com.baidu.tieba.a.e, z {
    private CardUserInfoLayout afT;
    private String ahw;
    private final View.OnClickListener ajJ;
    public AlaVideoContainer gSA;
    private RelativeLayout gSw;
    private View gSz;
    private LinearLayout gTg;
    private TextView gTh;
    private TextView gTi;
    private RelativeLayout gTj;
    private ThreadSourceShareAndPraiseLayout gTk;
    private HeadImageView glZ;
    private LinearLayout gqC;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ajJ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cnv() != null) {
                    c.this.cnv().a(view, c.this.afN);
                }
            }
        };
        setTag(bdUniqueId);
        this.eGu = tbPageContext;
        View view = getView();
        this.gSw = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.gSw.setOnClickListener(this);
        this.gTg = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.gTg.setOnClickListener(this);
        this.gTj = (RelativeLayout) view.findViewById(R.id.ala_share_container);
        this.gqC = (LinearLayout) this.gTj.findViewById(R.id.challenge_root);
        this.afT = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.afT.setShowFlag(6141);
        this.glZ = (HeadImageView) view.findViewById(R.id.ala_share_live_user_pendant_header);
        this.glZ.setIsRound(true);
        this.glZ.setDrawBorder(false);
        this.glZ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.glZ.setAutoChangeStyle(false);
        this.gTi = (TextView) view.findViewById(R.id.ala_share_live_username_text);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gTh = (TextView) view.findViewById(R.id.ala_live_room_title);
        this.gSA = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.gSA.setOnVideoClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.gSy = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        b(this.gSy);
        this.gSy.setSelectVisible(false);
        this.gSy.setIsBarViewVisible(false);
        this.gSy.setCommentNumEnable(true);
        this.gSy.setLiveShareEnable(false);
        this.gSy.setFrom(2);
        this.gSy.getCommentContainer().setOnClickListener(this);
        this.gSy.hideDisagree();
        this.gSy.setShareReportFrom(1);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.exI = 2;
        dVar.exO = 2;
        this.gSy.setAgreeStatisticData(dVar);
        this.hVY = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.hVY);
        this.hVY.setFrom(2);
        this.hVY.setShareReportFrom(1);
        this.gTk = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.gTk.eWE.setOnClickListener(this);
        this.gTk.eWE.getCommentContainer().setOnClickListener(this);
        this.gTk.setFrom(2);
        this.gTk.setShareReportFrom(1);
        this.gTk.setSourceFromForPb(3);
        this.gTk.setStType("frs_page");
        this.gTk.setHideBarName(true);
        this.gSz = view.findViewById(R.id.divider_below_reply_number_layout);
        this.gSA.setLigvingLogLayoutVisible(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            g(tbPageContext, i);
            com.baidu.tbadk.core.elementsMaven.c.bj(this.gSw).pb(com.baidu.tbadk.a.d.bhw() ? R.string.J_X02 : R.string.J_X06).aN(R.color.CAM_X0205, R.color.CAM_X0206);
            ap.setBackgroundColor(this.gTj, R.color.CAM_X0204);
            if (this.gSA != null) {
                this.gSA.onChangeSkinType(i);
            }
            this.afT.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.gSy.onChangeSkinType();
            this.mSkinType = i;
            if (this.glZ != null) {
                this.glZ.setPlaceHolder(1);
            }
            if (this.gTk != null && this.gTk.getVisibility() == 0) {
                this.gTk.onChangeSkinType();
            }
        }
        if (this.afN != 0 && n.IB(((bx) this.afN).getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0109);
            ap.setViewTextColor(this.gTh, R.color.CAM_X0109);
            ap.setViewTextColor(this.gTi, R.color.CAM_X0109);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0105);
            ap.setViewTextColor(this.gTh, R.color.CAM_X0106);
            ap.setViewTextColor(this.gTi, R.color.CAM_X0105);
        }
        ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_share_live_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bx bxVar) {
        this.afN = bxVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void vB(int i) {
    }

    private void refreshView() {
        if (this.afN == 0 || ((bx) this.afN).blC() == null) {
            this.gSw.setVisibility(8);
            return;
        }
        this.gSw.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gSw.getLayoutParams();
        if (com.baidu.tbadk.a.d.bhw()) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
        } else {
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
            layoutParams.bottomMargin = 0;
        }
        this.afT.setData((bx) this.afN);
        this.afT.setUserAfterClickListener(this.ajJ);
        this.gSA.getController().a((bx) this.afN, this.mForumName, "", false);
        this.gSA.getController().startPlayAnimation();
        if (((bx) this.afN).blW() != null && ((bx) this.afN).blW().share_info != null && !StringUtils.isNull(((bx) this.afN).blW().share_info.content)) {
            this.mTextTitle.setVisibility(0);
            this.mTextTitle.setText(((bx) this.afN).blW().share_info.content);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (((bx) this.afN).blW() != null && ((bx) this.afN).blW().user_info != null) {
            String str = ((bx) this.afN).blW().user_info.user_name;
            if (ae.getTextLengthWithEmoji(str) > 14) {
                str = ae.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.gTi.setText(str + ":");
            if (TextUtils.isEmpty(((bx) this.afN).blW().user_info.portrait)) {
                this.glZ.setPlaceHolder(1);
            } else {
                this.glZ.startLoad(((bx) this.afN).blW().user_info.portrait, 10, false, false);
            }
        }
        String title = ((bx) this.afN).getTitle();
        if (!StringUtils.isNull(title)) {
            this.gTh.setText(title);
            this.gTh.setVisibility(0);
        } else {
            this.gTh.setVisibility(8);
        }
        vD(tH(1));
        if (((bx) this.afN).blW().mChallengeInfoData != null && ((bx) this.afN).blW().mChallengeInfoData.challenge_id > 0) {
            this.gqC.setVisibility(0);
        } else {
            this.gqC.setVisibility(8);
        }
        this.mMaskView.setVisibility((com.baidu.tieba.frs.b.cwO().cwI() || com.baidu.tieba.frs.a.cwH().cwI()) ? 0 : 8);
        aO(this.gSw);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        ua();
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gSy != null) {
            if (this.afT != null) {
                this.afT.setPageUniqueId(bdUniqueId);
            }
            setTag(bdUniqueId);
            q(bdUniqueId);
        }
    }

    private void ua() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gTj.getLayoutParams();
        if (this.mTextTitle.getVisibility() == 0) {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        } else {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
        }
        this.gTj.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.b.cwO().cwI() && !com.baidu.tieba.frs.a.cwH().cwI()) {
            if (view == this.gSw || view == this.gSy.getCommentContainer() || this.gTg == view || view == this.gTk.eWE.getCommentContainer() || view == this.hVY.getCommentContainer()) {
                if (this.afN != 0) {
                    n.IA(((bx) this.afN).getId());
                }
                if (cnv() != null) {
                    cnv().a(this.gSw, this.afN);
                }
                TiebaStatic.log(new ar("c12323"));
                int i = 5;
                if (((bx) this.afN).blW().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                    i = 1;
                }
                if (view == this.gSy.getCommentContainer() || view == this.gTk.eWE.getCommentContainer()) {
                    ar arVar = new ar("c12942");
                    arVar.ak("obj_locate", 2);
                    arVar.dR("tid", ((bx) this.afN).getTid());
                    arVar.ak("obj_type", i);
                    arVar.dR("nid", ((bx) this.afN).getNid());
                    TiebaStatic.log(arVar);
                }
            } else if (view.getId() == R.id.video_container) {
                if (cnv() != null) {
                    cnv().a(view, this.afN);
                }
                TiebaStatic.log(new ar("c12323"));
                if (((bx) this.afN).blW().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                }
            }
        }
    }

    private void p(TbPageContext<?> tbPageContext) {
        if (this.afN != 0 && ((bx) this.afN).blW() != null && ((bx) this.afN).blW().share_info != null) {
            if (((bx) this.afN).blW().share_info.record_tid <= 0) {
                q(this.mTbPageContext);
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(((bx) this.afN).blW().share_info.record_tid), null, "frs_page");
            createNormalCfg.setVideo_source(((bx) this.afN).bmN() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs");
            createNormalCfg.setFromSmartFrs(((bx) this.afN).bmT());
            createNormalCfg.setSmartFrsPosition(((bx) this.afN).bmZ());
            createNormalCfg.setStartFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }

    public void q(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.afN != 0 && ((bx) this.afN).blW() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(tbPageContext.getPageActivity(), R.string.no_network_guide);
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(((bx) this.afN).blW());
            if (((bx) this.afN).blW().user_info != null) {
                alaLiveInfoCoreData.userName = ((bx) this.afN).blW().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, "frs_share_live", "", false, this.mForumName)));
        }
    }

    public void vD(int i) {
        if (this.afN != 0) {
            if (i == 1) {
                this.gSy.setVisibility(8);
                this.gTk.setData((bx) this.afN);
                return;
            }
            this.gSy.setData((bx) this.afN);
            this.gTk.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahw = str;
    }

    public int tH(int i) {
        return com.baidu.tieba.a.d.bIl().aw(this.ahw, i);
    }

    public ThreadCommentAndPraiseInfoLayout bVr() {
        return this.gSy;
    }

    public ThreadCommentAndPraiseInfoLayout bVs() {
        if (this.gTk != null) {
            return this.gTk.eWE;
        }
        return null;
    }
}
