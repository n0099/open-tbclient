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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.z;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.a<cb> implements com.baidu.tieba.a.e, z {
    private CardUserInfoLayout ahH;
    private String ajx;
    private final View.OnClickListener alB;
    private HeadImageView gFk;
    private LinearLayout gJR;
    private LinearLayout hpM;
    private TextView hpN;
    private TextView hpO;
    private RelativeLayout hpP;
    private ThreadSourceShareAndPraiseLayout hpQ;
    private RelativeLayout hpc;
    private View hpf;
    public AlaVideoContainer hpg;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.alB = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.csi() != null) {
                    c.this.csi().a(view, c.this.ahB);
                }
            }
        };
        setTag(bdUniqueId);
        this.eWx = tbPageContext;
        View view = getView();
        this.hpc = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.hpc.setOnClickListener(this);
        this.hpM = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.hpM.setOnClickListener(this);
        this.hpP = (RelativeLayout) view.findViewById(R.id.ala_share_container);
        this.gJR = (LinearLayout) this.hpP.findViewById(R.id.challenge_root);
        this.ahH = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.ahH.setShowFlag(6141);
        this.gFk = (HeadImageView) view.findViewById(R.id.ala_share_live_user_pendant_header);
        this.gFk.setIsRound(true);
        this.gFk.setDrawBorder(false);
        this.gFk.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gFk.setAutoChangeStyle(false);
        this.hpO = (TextView) view.findViewById(R.id.ala_share_live_username_text);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.hpN = (TextView) view.findViewById(R.id.ala_live_room_title);
        this.hpg = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.hpg.setOnVideoClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.hpe = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        b(this.hpe);
        this.hpe.setSelectVisible(false);
        this.hpe.setIsBarViewVisible(false);
        this.hpe.setCommentNumEnable(true);
        this.hpe.setLiveShareEnable(false);
        this.hpe.setFrom(2);
        this.hpe.getCommentContainer().setOnClickListener(this);
        this.hpe.hideDisagree();
        this.hpe.setShareReportFrom(1);
        com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
        eVar.eNB = 2;
        eVar.eNH = 2;
        this.hpe.setAgreeStatisticData(eVar);
        this.iwm = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.iwm);
        this.iwm.setFrom(2);
        this.iwm.setShareReportFrom(1);
        this.hpQ = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.hpQ.fmS.setOnClickListener(this);
        this.hpQ.fmS.getCommentContainer().setOnClickListener(this);
        this.hpQ.setFrom(2);
        this.hpQ.setShareReportFrom(1);
        this.hpQ.setSourceFromForPb(3);
        this.hpQ.setStType("frs_page");
        this.hpQ.setHideBarName(true);
        this.hpf = view.findViewById(R.id.divider_below_reply_number_layout);
        this.hpg.setLigvingLogLayoutVisible(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            g(tbPageContext, i);
            com.baidu.tbadk.core.elementsMaven.c.br(this.hpc).oh(R.string.J_X06).aJ(R.color.CAM_X0205, R.color.CAM_X0206);
            ap.setBackgroundColor(this.hpP, R.color.CAM_X0204);
            if (this.hpg != null) {
                this.hpg.onChangeSkinType(i);
            }
            this.ahH.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.hpe.onChangeSkinType();
            this.mSkinType = i;
            if (this.gFk != null) {
                this.gFk.setPlaceHolder(1);
            }
            if (this.hpQ != null && this.hpQ.getVisibility() == 0) {
                this.hpQ.onChangeSkinType();
            }
        }
        if (this.ahB != 0 && m.IX(((cb) this.ahB).getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0109);
            ap.setViewTextColor(this.hpN, R.color.CAM_X0109);
            ap.setViewTextColor(this.hpO, R.color.CAM_X0109);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0105);
            ap.setViewTextColor(this.hpN, R.color.CAM_X0106);
            ap.setViewTextColor(this.hpO, R.color.CAM_X0105);
        }
        ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_share_live_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(cb cbVar) {
        this.ahB = cbVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void uZ(int i) {
    }

    private void refreshView() {
        if (this.ahB == 0 || ((cb) this.ahB).bnS() == null) {
            this.hpc.setVisibility(8);
            return;
        }
        this.hpc.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hpc.getLayoutParams();
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        layoutParams.bottomMargin = 0;
        this.ahH.setData((cb) this.ahB);
        this.ahH.setUserAfterClickListener(this.alB);
        this.hpg.getController().a((cb) this.ahB, this.mForumName, "", false);
        this.hpg.getController().startPlayAnimation();
        if (((cb) this.ahB).bol() != null && ((cb) this.ahB).bol().share_info != null && !StringUtils.isNull(((cb) this.ahB).bol().share_info.content)) {
            this.mTextTitle.setVisibility(0);
            this.mTextTitle.setText(((cb) this.ahB).bol().share_info.content);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (((cb) this.ahB).bol() != null && ((cb) this.ahB).bol().user_info != null) {
            String str = ((cb) this.ahB).bol().user_info.user_name;
            if (ag.getTextLengthWithEmoji(str) > 14) {
                str = ag.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.hpO.setText(str + ":");
            if (TextUtils.isEmpty(((cb) this.ahB).bol().user_info.portrait)) {
                this.gFk.setPlaceHolder(1);
            } else {
                this.gFk.startLoad(((cb) this.ahB).bol().user_info.portrait, 10, false, false);
            }
        }
        String title = ((cb) this.ahB).getTitle();
        if (!StringUtils.isNull(title)) {
            this.hpN.setText(title);
            this.hpN.setVisibility(0);
        } else {
            this.hpN.setVisibility(8);
        }
        vb(sY(1));
        if (((cb) this.ahB).bol().mChallengeInfoData != null && ((cb) this.ahB).bol().mChallengeInfoData.challenge_id > 0) {
            this.gJR.setVisibility(0);
        } else {
            this.gJR.setVisibility(8);
        }
        this.mMaskView.setVisibility((com.baidu.tieba.frs.b.cBE().cBy() || com.baidu.tieba.frs.a.cBx().cBy()) ? 0 : 8);
        ba(this.hpc);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        tn();
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hpe != null) {
            if (this.ahH != null) {
                this.ahH.setPageUniqueId(bdUniqueId);
            }
            setTag(bdUniqueId);
            q(bdUniqueId);
        }
    }

    private void tn() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hpP.getLayoutParams();
        if (this.mTextTitle.getVisibility() == 0) {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        } else {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
        }
        this.hpP.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.b.cBE().cBy() && !com.baidu.tieba.frs.a.cBx().cBy()) {
            if (view == this.hpc || view == this.hpe.getCommentContainer() || this.hpM == view || view == this.hpQ.fmS.getCommentContainer() || view == this.iwm.getCommentContainer()) {
                if (this.ahB != 0) {
                    m.IW(((cb) this.ahB).getId());
                }
                if (csi() != null) {
                    csi().a(this.hpc, this.ahB);
                }
                TiebaStatic.log(new ar("c12323"));
                int i = 5;
                if (((cb) this.ahB).bol().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                    i = 1;
                }
                if (view == this.hpe.getCommentContainer() || view == this.hpQ.fmS.getCommentContainer()) {
                    ar arVar = new ar("c12942");
                    arVar.aq("obj_locate", 2);
                    arVar.dR("tid", ((cb) this.ahB).getTid());
                    arVar.aq("obj_type", i);
                    arVar.dR(IntentConfig.NID, ((cb) this.ahB).bmq());
                    com.baidu.tbadk.pageExtra.c bR = com.baidu.tbadk.pageExtra.d.bR(view);
                    if (bR != null) {
                        arVar.dR("obj_cur_page", bR.getCurrentPageKey());
                    }
                    if (com.baidu.tbadk.pageExtra.d.bDP() != null) {
                        arVar.dR("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDP());
                    }
                    TiebaStatic.log(arVar);
                }
            } else if (view.getId() == R.id.video_container) {
                if (csi() != null) {
                    csi().a(view, this.ahB);
                }
                TiebaStatic.log(new ar("c12323"));
                if (((cb) this.ahB).bol().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                }
            }
        }
    }

    private void p(TbPageContext<?> tbPageContext) {
        if (this.ahB != 0 && ((cb) this.ahB).bol() != null && ((cb) this.ahB).bol().share_info != null) {
            if (((cb) this.ahB).bol().share_info.record_tid <= 0) {
                q(this.mTbPageContext);
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(((cb) this.ahB).bol().share_info.record_tid), null, "frs_page");
            createNormalCfg.setVideo_source(((cb) this.ahB).bpc() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs");
            createNormalCfg.setFromSmartFrs(((cb) this.ahB).bpj());
            createNormalCfg.setSmartFrsPosition(((cb) this.ahB).bpp());
            createNormalCfg.setStartFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }

    public void q(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.ahB != 0 && ((cb) this.ahB).bol() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(tbPageContext.getPageActivity(), R.string.no_network_guide);
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(((cb) this.ahB).bol());
            if (((cb) this.ahB).bol().user_info != null) {
                alaLiveInfoCoreData.userName = ((cb) this.ahB).bol().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, "frs_share_live", "", false, this.mForumName)));
        }
    }

    public void vb(int i) {
        if (this.ahB != 0) {
            if (i == 1) {
                this.hpe.setVisibility(8);
                this.hpQ.setData((cb) this.ahB);
                return;
            }
            this.hpe.setData((cb) this.ahB);
            this.hpQ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ajx = str;
    }

    public int sY(int i) {
        return com.baidu.tieba.a.d.bKY().aB(this.ajx, i);
    }

    public ThreadCommentAndPraiseInfoLayout bZd() {
        return this.hpe;
    }

    public ThreadCommentAndPraiseInfoLayout bZe() {
        if (this.hpQ != null) {
            return this.hpQ.fmS;
        }
        return null;
    }
}
