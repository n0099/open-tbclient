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
/* loaded from: classes10.dex */
public class c extends com.baidu.tieba.card.a<cb> implements com.baidu.tieba.a.e, z {
    private CardUserInfoLayout agp;
    private String aif;
    private final View.OnClickListener aki;
    private HeadImageView gDn;
    private LinearLayout gHU;
    private LinearLayout hnO;
    private TextView hnP;
    private TextView hnQ;
    private RelativeLayout hnR;
    private ThreadSourceShareAndPraiseLayout hnS;
    private RelativeLayout hne;
    private View hnh;
    public AlaVideoContainer hni;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aki = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.crV() != null) {
                    c.this.crV().a(view, c.this.agj);
                }
            }
        };
        setTag(bdUniqueId);
        this.eUY = tbPageContext;
        View view = getView();
        this.hne = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.hne.setOnClickListener(this);
        this.hnO = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.hnO.setOnClickListener(this);
        this.hnR = (RelativeLayout) view.findViewById(R.id.ala_share_container);
        this.gHU = (LinearLayout) this.hnR.findViewById(R.id.challenge_root);
        this.agp = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.agp.setShowFlag(6141);
        this.gDn = (HeadImageView) view.findViewById(R.id.ala_share_live_user_pendant_header);
        this.gDn.setIsRound(true);
        this.gDn.setDrawBorder(false);
        this.gDn.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gDn.setAutoChangeStyle(false);
        this.hnQ = (TextView) view.findViewById(R.id.ala_share_live_username_text);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.hnP = (TextView) view.findViewById(R.id.ala_live_room_title);
        this.hni = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.hni.setOnVideoClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.hng = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        b(this.hng);
        this.hng.setSelectVisible(false);
        this.hng.setIsBarViewVisible(false);
        this.hng.setCommentNumEnable(true);
        this.hng.setLiveShareEnable(false);
        this.hng.setFrom(2);
        this.hng.getCommentContainer().setOnClickListener(this);
        this.hng.hideDisagree();
        this.hng.setShareReportFrom(1);
        com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
        eVar.eMa = 2;
        eVar.eMg = 2;
        this.hng.setAgreeStatisticData(eVar);
        this.iup = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.iup);
        this.iup.setFrom(2);
        this.iup.setShareReportFrom(1);
        this.hnS = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.hnS.fls.setOnClickListener(this);
        this.hnS.fls.getCommentContainer().setOnClickListener(this);
        this.hnS.setFrom(2);
        this.hnS.setShareReportFrom(1);
        this.hnS.setSourceFromForPb(3);
        this.hnS.setStType("frs_page");
        this.hnS.setHideBarName(true);
        this.hnh = view.findViewById(R.id.divider_below_reply_number_layout);
        this.hni.setLigvingLogLayoutVisible(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            g(tbPageContext, i);
            com.baidu.tbadk.core.elementsMaven.c.br(this.hne).og(R.string.J_X06).aJ(R.color.CAM_X0205, R.color.CAM_X0206);
            ap.setBackgroundColor(this.hnR, R.color.CAM_X0204);
            if (this.hni != null) {
                this.hni.onChangeSkinType(i);
            }
            this.agp.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.hng.onChangeSkinType();
            this.mSkinType = i;
            if (this.gDn != null) {
                this.gDn.setPlaceHolder(1);
            }
            if (this.hnS != null && this.hnS.getVisibility() == 0) {
                this.hnS.onChangeSkinType();
            }
        }
        if (this.agj != 0 && m.IN(((cb) this.agj).getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0109);
            ap.setViewTextColor(this.hnP, R.color.CAM_X0109);
            ap.setViewTextColor(this.hnQ, R.color.CAM_X0109);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0105);
            ap.setViewTextColor(this.hnP, R.color.CAM_X0106);
            ap.setViewTextColor(this.hnQ, R.color.CAM_X0105);
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
        this.agj = cbVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void uX(int i) {
    }

    private void refreshView() {
        if (this.agj == 0 || ((cb) this.agj).bnQ() == null) {
            this.hne.setVisibility(8);
            return;
        }
        this.hne.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hne.getLayoutParams();
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        layoutParams.bottomMargin = 0;
        this.agp.setData((cb) this.agj);
        this.agp.setUserAfterClickListener(this.aki);
        this.hni.getController().a((cb) this.agj, this.mForumName, "", false);
        this.hni.getController().startPlayAnimation();
        if (((cb) this.agj).boj() != null && ((cb) this.agj).boj().share_info != null && !StringUtils.isNull(((cb) this.agj).boj().share_info.content)) {
            this.mTextTitle.setVisibility(0);
            this.mTextTitle.setText(((cb) this.agj).boj().share_info.content);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (((cb) this.agj).boj() != null && ((cb) this.agj).boj().user_info != null) {
            String str = ((cb) this.agj).boj().user_info.user_name;
            if (ag.getTextLengthWithEmoji(str) > 14) {
                str = ag.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.hnQ.setText(str + ":");
            if (TextUtils.isEmpty(((cb) this.agj).boj().user_info.portrait)) {
                this.gDn.setPlaceHolder(1);
            } else {
                this.gDn.startLoad(((cb) this.agj).boj().user_info.portrait, 10, false, false);
            }
        }
        String title = ((cb) this.agj).getTitle();
        if (!StringUtils.isNull(title)) {
            this.hnP.setText(title);
            this.hnP.setVisibility(0);
        } else {
            this.hnP.setVisibility(8);
        }
        uZ(sW(1));
        if (((cb) this.agj).boj().mChallengeInfoData != null && ((cb) this.agj).boj().mChallengeInfoData.challenge_id > 0) {
            this.gHU.setVisibility(0);
        } else {
            this.gHU.setVisibility(8);
        }
        this.mMaskView.setVisibility((com.baidu.tieba.frs.b.cBr().cBl() || com.baidu.tieba.frs.a.cBk().cBl()) ? 0 : 8);
        ba(this.hne);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        tn();
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hng != null) {
            if (this.agp != null) {
                this.agp.setPageUniqueId(bdUniqueId);
            }
            setTag(bdUniqueId);
            q(bdUniqueId);
        }
    }

    private void tn() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hnR.getLayoutParams();
        if (this.mTextTitle.getVisibility() == 0) {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        } else {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
        }
        this.hnR.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.b.cBr().cBl() && !com.baidu.tieba.frs.a.cBk().cBl()) {
            if (view == this.hne || view == this.hng.getCommentContainer() || this.hnO == view || view == this.hnS.fls.getCommentContainer() || view == this.iup.getCommentContainer()) {
                if (this.agj != 0) {
                    m.IM(((cb) this.agj).getId());
                }
                if (crV() != null) {
                    crV().a(this.hne, this.agj);
                }
                TiebaStatic.log(new ar("c12323"));
                int i = 5;
                if (((cb) this.agj).boj().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                    i = 1;
                }
                if (view == this.hng.getCommentContainer() || view == this.hnS.fls.getCommentContainer()) {
                    ar arVar = new ar("c12942");
                    arVar.ap("obj_locate", 2);
                    arVar.dR("tid", ((cb) this.agj).getTid());
                    arVar.ap("obj_type", i);
                    arVar.dR(IntentConfig.NID, ((cb) this.agj).bmo());
                    com.baidu.tbadk.pageExtra.c bR = com.baidu.tbadk.pageExtra.d.bR(view);
                    if (bR != null) {
                        arVar.dR("obj_cur_page", bR.getCurrentPageKey());
                    }
                    if (com.baidu.tbadk.pageExtra.d.bDM() != null) {
                        arVar.dR("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDM());
                    }
                    TiebaStatic.log(arVar);
                }
            } else if (view.getId() == R.id.video_container) {
                if (crV() != null) {
                    crV().a(view, this.agj);
                }
                TiebaStatic.log(new ar("c12323"));
                if (((cb) this.agj).boj().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                }
            }
        }
    }

    private void p(TbPageContext<?> tbPageContext) {
        if (this.agj != 0 && ((cb) this.agj).boj() != null && ((cb) this.agj).boj().share_info != null) {
            if (((cb) this.agj).boj().share_info.record_tid <= 0) {
                q(this.mTbPageContext);
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(((cb) this.agj).boj().share_info.record_tid), null, "frs_page");
            createNormalCfg.setVideo_source(((cb) this.agj).bpa() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs");
            createNormalCfg.setFromSmartFrs(((cb) this.agj).bph());
            createNormalCfg.setSmartFrsPosition(((cb) this.agj).bpn());
            createNormalCfg.setStartFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }

    public void q(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.agj != 0 && ((cb) this.agj).boj() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(tbPageContext.getPageActivity(), R.string.no_network_guide);
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(((cb) this.agj).boj());
            if (((cb) this.agj).boj().user_info != null) {
                alaLiveInfoCoreData.userName = ((cb) this.agj).boj().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, "frs_share_live", "", false, this.mForumName)));
        }
    }

    public void uZ(int i) {
        if (this.agj != 0) {
            if (i == 1) {
                this.hng.setVisibility(8);
                this.hnS.setData((cb) this.agj);
                return;
            }
            this.hng.setData((cb) this.agj);
            this.hnS.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aif = str;
    }

    public int sW(int i) {
        return com.baidu.tieba.a.d.bKP().aB(this.aif, i);
    }

    public ThreadCommentAndPraiseInfoLayout bYQ() {
        return this.hng;
    }

    public ThreadCommentAndPraiseInfoLayout bYR() {
        if (this.hnS != null) {
            return this.hnS.fls;
        }
        return null;
    }
}
