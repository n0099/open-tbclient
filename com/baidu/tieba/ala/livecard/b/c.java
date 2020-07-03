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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.y;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.b<bu> implements com.baidu.tieba.a.e, y {
    private bu aeK;
    private CardUserInfoLayout aeg;
    private String afG;
    private final View.OnClickListener ahM;
    private RelativeLayout fRG;
    private ThreadCommentAndPraiseInfoLayout fRI;
    private View fRJ;
    public AlaVideoContainer fRK;
    private LinearLayout fSq;
    private TextView fSr;
    private TextView fSs;
    private RelativeLayout fSt;
    private ThreadSourceShareAndPraiseLayout fSu;
    private HeadImageView fqr;
    private LinearLayout fuV;
    private View mDivider;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ahM = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bOc() != null) {
                    c.this.bOc().a(view, c.this.aeK);
                }
            }
        };
        setTag(bdUniqueId);
        View view = getView();
        this.fRG = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fRG.setOnClickListener(this);
        this.fSq = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.fSq.setOnClickListener(this);
        this.fSt = (RelativeLayout) view.findViewById(R.id.ala_share_container);
        this.fuV = (LinearLayout) this.fSt.findViewById(R.id.challenge_root);
        this.aeg = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.aeg.setShowFlag(6141);
        this.fqr = (HeadImageView) view.findViewById(R.id.ala_share_live_user_pendant_header);
        this.fqr.setIsRound(true);
        this.fqr.setDrawBorder(false);
        this.fqr.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fqr.setAutoChangeStyle(false);
        this.fSs = (TextView) view.findViewById(R.id.ala_share_live_username_text);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fSr = (TextView) view.findViewById(R.id.ala_live_room_title);
        this.fRK = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.fRK.setOnVideoClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.fRI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.fRI.setOnClickListener(this);
        this.fRI.setReplyTimeVisible(false);
        this.fRI.setShowPraiseNum(true);
        this.fRI.setNeedAddReplyIcon(true);
        this.fRI.setNeedAddPraiseIcon(true);
        this.fRI.setFrom(2);
        this.fRI.getCommentContainer().setOnClickListener(this);
        this.fRI.setShareVisible(true);
        this.fRI.setShareReportFrom(1);
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dHq = 2;
        cVar.dHw = 2;
        this.fRI.setAgreeStatisticData(cVar);
        this.fSu = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.fSu.eeP.setOnClickListener(this);
        this.fSu.eeP.getCommentContainer().setOnClickListener(this);
        this.fSu.setFrom(2);
        this.fSu.setShareReportFrom(1);
        this.fSu.setSourceFromForPb(3);
        this.fSu.setStType("frs_page");
        this.fSu.setHideBarName(true);
        this.fRJ = view.findViewById(R.id.divider_below_reply_number_layout);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.fRK.setLigvingLogLayoutVisible(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setBackgroundResource(this.fRG, R.drawable.addresslist_item_bg);
            an.setBackgroundColor(this.mDivider, R.color.cp_bg_line_b);
            an.setBackgroundColor(this.fSt, R.color.cp_bg_line_c);
            if (this.fRK != null) {
                this.fRK.onChangeSkinType(i);
            }
            this.aeg.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fRI.onChangeSkinType();
            this.mSkinType = i;
            if (this.fqr != null) {
                this.fqr.setPlaceHolder(1);
            }
            if (this.fSu != null && this.fSu.getVisibility() == 0) {
                this.fSu.onChangeSkinType();
            }
        }
        if (this.aeK != null && m.DP(this.aeK.getId())) {
            an.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.fSr, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.fSs, (int) R.color.cp_cont_d);
        } else {
            an.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.fSr, (int) R.color.cp_cont_f);
            an.setViewTextColor(this.fSs, (int) R.color.cp_cont_b);
        }
        an.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_share_live_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bu buVar) {
        this.aeK = buVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void qX(int i) {
    }

    private void refreshView() {
        if (this.aeK == null || this.aeK.aSp() == null) {
            this.fRG.setVisibility(8);
            return;
        }
        this.fRG.setVisibility(0);
        this.aeg.setData(this.aeK);
        this.aeg.setUserAfterClickListener(this.ahM);
        this.fRK.getController().a(this.aeK, this.mForumName, "", false);
        this.fRK.getController().startPlayAnimation();
        if (this.aeK.aSJ() != null && this.aeK.aSJ().share_info != null && !StringUtils.isNull(this.aeK.aSJ().share_info.content)) {
            this.mTextTitle.setVisibility(0);
            this.mTextTitle.setText(this.aeK.aSJ().share_info.content);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (this.aeK.aSJ() != null && this.aeK.aSJ().user_info != null) {
            String str = this.aeK.aSJ().user_info.user_name;
            if (ae.getTextLengthWithEmoji(str) > 14) {
                str = ae.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.fSs.setText(str + ":");
            if (TextUtils.isEmpty(this.aeK.aSJ().user_info.portrait)) {
                this.fqr.setPlaceHolder(1);
            } else {
                this.fqr.startLoad(this.aeK.aSJ().user_info.portrait, 10, false, false);
            }
        }
        String title = this.aeK.getTitle();
        if (!StringUtils.isNull(title)) {
            this.fSr.setText(title);
            this.fSr.setVisibility(0);
        } else {
            this.fSr.setVisibility(8);
        }
        qZ(pz(1));
        if (this.aeK.aSJ().mChallengeInfoData != null && this.aeK.aSJ().mChallengeInfoData.challenge_id > 0) {
            this.fuV.setVisibility(0);
        } else {
            this.fuV.setVisibility(8);
        }
        this.mMaskView.setVisibility((com.baidu.tieba.frs.b.bXc().bWW() || com.baidu.tieba.frs.a.bWV().bWW()) ? 0 : 8);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        sh();
    }

    private void sh() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fSt.getLayoutParams();
        if (this.mTextTitle.getVisibility() == 0) {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        } else {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
        }
        this.fSt.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.b.bXc().bWW() && !com.baidu.tieba.frs.a.bWV().bWW()) {
            if (view == this.fRG || view == this.fRI.getCommentContainer() || this.fSq == view || view == this.fSu.eeP.getCommentContainer()) {
                if (this.aeK != null) {
                    m.DO(this.aeK.getId());
                }
                if (bOc() != null) {
                    bOc().a(this.fRG, this.aeK);
                }
                TiebaStatic.log(new ao("c12323"));
                int i = 5;
                if (this.aeK.aSJ().live_status == 1) {
                    r(this.mTbPageContext);
                } else {
                    q(this.mTbPageContext);
                    i = 1;
                }
                if (view == this.fRI.getCommentContainer() || view == this.fSu.eeP.getCommentContainer()) {
                    ao aoVar = new ao("c12942");
                    aoVar.ag("obj_locate", 2);
                    aoVar.dk("tid", this.aeK.getTid());
                    aoVar.ag("obj_type", i);
                    aoVar.dk("nid", this.aeK.getNid());
                    TiebaStatic.log(aoVar);
                }
            } else if (view.getId() == R.id.video_container) {
                if (bOc() != null) {
                    bOc().a(view, this.aeK);
                }
                TiebaStatic.log(new ao("c12323"));
                if (this.aeK.aSJ().live_status == 1) {
                    r(this.mTbPageContext);
                } else {
                    q(this.mTbPageContext);
                }
            }
        }
    }

    private void q(TbPageContext<?> tbPageContext) {
        if (this.aeK != null && this.aeK.aSJ() != null && this.aeK.aSJ().share_info != null) {
            if (this.aeK.aSJ().share_info.record_tid <= 0) {
                r(this.mTbPageContext);
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(this.aeK.aSJ().share_info.record_tid), null, "frs_page");
            createNormalCfg.setVideo_source(this.aeK.aTy() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs");
            createNormalCfg.setFromSmartFrs(this.aeK.aTE());
            createNormalCfg.setSmartFrsPosition(this.aeK.aTK());
            createNormalCfg.setStartFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }

    public void r(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.aeK != null && this.aeK.aSJ() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(tbPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.aeK.aSJ());
            if (this.aeK.aSJ().user_info != null) {
                alaLiveInfoCoreData.userName = this.aeK.aSJ().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, "frs_share_live", "", false, this.mForumName)));
        }
    }

    public void qZ(int i) {
        if (this.aeK != null) {
            if (i == 1) {
                this.fRI.setVisibility(8);
                this.fSu.setData(this.aeK);
                return;
            }
            this.fRI.setData(this.aeK);
            this.fSu.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.afG = str;
    }

    public int pz(int i) {
        return com.baidu.tieba.a.d.boA().as(this.afG, i);
    }

    public ThreadCommentAndPraiseInfoLayout bzi() {
        return this.fRI;
    }

    public ThreadCommentAndPraiseInfoLayout bzj() {
        if (this.fSu != null) {
            return this.fSu.eeP;
        }
        return null;
    }
}
