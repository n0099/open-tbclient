package com.baidu.tieba.ala.livecard.b;

import android.text.TextUtils;
import android.view.View;
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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.y;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.b<bv> implements com.baidu.tieba.a.e, y {
    private CardUserInfoLayout adW;
    private bv aeA;
    private String afx;
    private final View.OnClickListener ahD;
    private LinearLayout fAc;
    private RelativeLayout fWZ;
    private LinearLayout fXJ;
    private TextView fXK;
    private TextView fXL;
    private RelativeLayout fXM;
    private ThreadSourceShareAndPraiseLayout fXN;
    private ThreadCommentAndPraiseInfoLayout fXb;
    private View fXc;
    public AlaVideoContainer fXd;
    private HeadImageView fvB;
    private View mDivider;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ahD = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bRn() != null) {
                    c.this.bRn().a(view, c.this.aeA);
                }
            }
        };
        setTag(bdUniqueId);
        View view = getView();
        this.fWZ = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fWZ.setOnClickListener(this);
        this.fXJ = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.fXJ.setOnClickListener(this);
        this.fXM = (RelativeLayout) view.findViewById(R.id.ala_share_container);
        this.fAc = (LinearLayout) this.fXM.findViewById(R.id.challenge_root);
        this.adW = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.adW.setShowFlag(6141);
        this.fvB = (HeadImageView) view.findViewById(R.id.ala_share_live_user_pendant_header);
        this.fvB.setIsRound(true);
        this.fvB.setDrawBorder(false);
        this.fvB.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fvB.setAutoChangeStyle(false);
        this.fXL = (TextView) view.findViewById(R.id.ala_share_live_username_text);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fXK = (TextView) view.findViewById(R.id.ala_live_room_title);
        this.fXd = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.fXd.setOnVideoClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.fXb = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.fXb.setOnClickListener(this);
        this.fXb.setReplyTimeVisible(false);
        this.fXb.setShowPraiseNum(true);
        this.fXb.setNeedAddReplyIcon(true);
        this.fXb.setNeedAddPraiseIcon(true);
        this.fXb.setFrom(2);
        this.fXb.getCommentContainer().setOnClickListener(this);
        this.fXb.setShareVisible(true);
        this.fXb.setShareReportFrom(1);
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dNB = 2;
        cVar.dNH = 2;
        this.fXb.setAgreeStatisticData(cVar);
        this.fXN = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.fXN.ekZ.setOnClickListener(this);
        this.fXN.ekZ.getCommentContainer().setOnClickListener(this);
        this.fXN.setFrom(2);
        this.fXN.setShareReportFrom(1);
        this.fXN.setSourceFromForPb(3);
        this.fXN.setStType("frs_page");
        this.fXN.setHideBarName(true);
        this.fXc = view.findViewById(R.id.divider_below_reply_number_layout);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.fXd.setLigvingLogLayoutVisible(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.fWZ, R.drawable.addresslist_item_bg);
            ao.setBackgroundColor(this.mDivider, R.color.cp_bg_line_b);
            ao.setBackgroundColor(this.fXM, R.color.cp_bg_line_c);
            if (this.fXd != null) {
                this.fXd.onChangeSkinType(i);
            }
            this.adW.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fXb.onChangeSkinType();
            this.mSkinType = i;
            if (this.fvB != null) {
                this.fvB.setPlaceHolder(1);
            }
            if (this.fXN != null && this.fXN.getVisibility() == 0) {
                this.fXN.onChangeSkinType();
            }
        }
        if (this.aeA != null && m.EA(this.aeA.getId())) {
            ao.setViewTextColor(this.mTextTitle, R.color.cp_cont_d);
            ao.setViewTextColor(this.fXK, R.color.cp_cont_d);
            ao.setViewTextColor(this.fXL, R.color.cp_cont_d);
        } else {
            ao.setViewTextColor(this.mTextTitle, R.color.cp_cont_b);
            ao.setViewTextColor(this.fXK, R.color.cp_cont_f);
            ao.setViewTextColor(this.fXL, R.color.cp_cont_b);
        }
        ao.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_share_live_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bv bvVar) {
        this.aeA = bvVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void rn(int i) {
    }

    private void refreshView() {
        if (this.aeA == null || this.aeA.aWl() == null) {
            this.fWZ.setVisibility(8);
            return;
        }
        this.fWZ.setVisibility(0);
        this.adW.setData(this.aeA);
        this.adW.setUserAfterClickListener(this.ahD);
        this.fXd.getController().a(this.aeA, this.mForumName, "", false);
        this.fXd.getController().startPlayAnimation();
        if (this.aeA.aWF() != null && this.aeA.aWF().share_info != null && !StringUtils.isNull(this.aeA.aWF().share_info.content)) {
            this.mTextTitle.setVisibility(0);
            this.mTextTitle.setText(this.aeA.aWF().share_info.content);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (this.aeA.aWF() != null && this.aeA.aWF().user_info != null) {
            String str = this.aeA.aWF().user_info.user_name;
            if (ae.getTextLengthWithEmoji(str) > 14) {
                str = ae.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.fXL.setText(str + ":");
            if (TextUtils.isEmpty(this.aeA.aWF().user_info.portrait)) {
                this.fvB.setPlaceHolder(1);
            } else {
                this.fvB.startLoad(this.aeA.aWF().user_info.portrait, 10, false, false);
            }
        }
        String title = this.aeA.getTitle();
        if (!StringUtils.isNull(title)) {
            this.fXK.setText(title);
            this.fXK.setVisibility(0);
        } else {
            this.fXK.setVisibility(8);
        }
        rp(pM(1));
        if (this.aeA.aWF().mChallengeInfoData != null && this.aeA.aWF().mChallengeInfoData.challenge_id > 0) {
            this.fAc.setVisibility(0);
        } else {
            this.fAc.setVisibility(8);
        }
        this.mMaskView.setVisibility((com.baidu.tieba.frs.b.caw().caq() || com.baidu.tieba.frs.a.cap().caq()) ? 0 : 8);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        sj();
    }

    private void sj() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fXM.getLayoutParams();
        if (this.mTextTitle.getVisibility() == 0) {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        } else {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
        }
        this.fXM.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.b.caw().caq() && !com.baidu.tieba.frs.a.cap().caq()) {
            if (view == this.fWZ || view == this.fXb.getCommentContainer() || this.fXJ == view || view == this.fXN.ekZ.getCommentContainer()) {
                if (this.aeA != null) {
                    m.Ez(this.aeA.getId());
                }
                if (bRn() != null) {
                    bRn().a(this.fWZ, this.aeA);
                }
                TiebaStatic.log(new ap("c12323"));
                int i = 5;
                if (this.aeA.aWF().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                    i = 1;
                }
                if (view == this.fXb.getCommentContainer() || view == this.fXN.ekZ.getCommentContainer()) {
                    ap apVar = new ap("c12942");
                    apVar.ah("obj_locate", 2);
                    apVar.dn("tid", this.aeA.getTid());
                    apVar.ah("obj_type", i);
                    apVar.dn("nid", this.aeA.getNid());
                    TiebaStatic.log(apVar);
                }
            } else if (view.getId() == R.id.video_container) {
                if (bRn() != null) {
                    bRn().a(view, this.aeA);
                }
                TiebaStatic.log(new ap("c12323"));
                if (this.aeA.aWF().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                }
            }
        }
    }

    private void p(TbPageContext<?> tbPageContext) {
        if (this.aeA != null && this.aeA.aWF() != null && this.aeA.aWF().share_info != null) {
            if (this.aeA.aWF().share_info.record_tid <= 0) {
                q(this.mTbPageContext);
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(this.aeA.aWF().share_info.record_tid), null, "frs_page");
            createNormalCfg.setVideo_source(this.aeA.aXu() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs");
            createNormalCfg.setFromSmartFrs(this.aeA.aXA());
            createNormalCfg.setSmartFrsPosition(this.aeA.aXG());
            createNormalCfg.setStartFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }

    public void q(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.aeA != null && this.aeA.aWF() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(tbPageContext.getPageActivity(), R.string.no_network_guide);
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.aeA.aWF());
            if (this.aeA.aWF().user_info != null) {
                alaLiveInfoCoreData.userName = this.aeA.aWF().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, "frs_share_live", "", false, this.mForumName)));
        }
    }

    public void rp(int i) {
        if (this.aeA != null) {
            if (i == 1) {
                this.fXb.setVisibility(8);
                this.fXN.setData(this.aeA);
                return;
            }
            this.fXb.setData(this.aeA);
            this.fXN.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.afx = str;
    }

    public int pM(int i) {
        return com.baidu.tieba.a.d.brD().ar(this.afx, i);
    }

    public ThreadCommentAndPraiseInfoLayout bCx() {
        return this.fXb;
    }

    public ThreadCommentAndPraiseInfoLayout bCy() {
        if (this.fXN != null) {
            return this.fXN.ekZ;
        }
        return null;
    }
}
