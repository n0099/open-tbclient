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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.y;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.b<bk> implements com.baidu.tieba.a.e, y {
    private CardUserInfoLayout adC;
    private String aeX;
    private bk aee;
    private final View.OnClickListener agI;
    private LinearLayout fGW;
    private TextView fGX;
    private TextView fGY;
    private RelativeLayout fGZ;
    private RelativeLayout fGm;
    private ThreadCommentAndPraiseInfoLayout fGo;
    private View fGp;
    public AlaVideoContainer fGq;
    private ThreadSourceShareAndPraiseLayout fHa;
    private HeadImageView feV;
    private LinearLayout fjx;
    private View mDivider;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.agI = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bKS() != null) {
                    c.this.bKS().a(view, c.this.aee);
                }
            }
        };
        setTag(bdUniqueId);
        View view = getView();
        this.fGm = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fGm.setOnClickListener(this);
        this.fGW = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.fGW.setOnClickListener(this);
        this.fGZ = (RelativeLayout) view.findViewById(R.id.ala_share_container);
        this.fjx = (LinearLayout) this.fGZ.findViewById(R.id.challenge_root);
        this.adC = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.adC.setShowFlag(6141);
        this.feV = (HeadImageView) view.findViewById(R.id.ala_share_live_user_pendant_header);
        this.feV.setIsRound(true);
        this.feV.setDrawBorder(false);
        this.feV.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.feV.setAutoChangeStyle(false);
        this.fGY = (TextView) view.findViewById(R.id.ala_share_live_username_text);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fGX = (TextView) view.findViewById(R.id.ala_live_room_title);
        this.fGq = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.fGq.setOnVideoClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.fGo = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.fGo.setOnClickListener(this);
        this.fGo.setReplyTimeVisible(false);
        this.fGo.setShowPraiseNum(true);
        this.fGo.setNeedAddReplyIcon(true);
        this.fGo.setNeedAddPraiseIcon(true);
        this.fGo.setFrom(2);
        this.fGo.getCommentContainer().setOnClickListener(this);
        this.fGo.setShareVisible(true);
        this.fGo.setShareReportFrom(1);
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dAZ = 2;
        cVar.dBf = 2;
        this.fGo.setAgreeStatisticData(cVar);
        this.fHa = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.fHa.dXt.setOnClickListener(this);
        this.fHa.dXt.getCommentContainer().setOnClickListener(this);
        this.fHa.setFrom(2);
        this.fHa.setShareReportFrom(1);
        this.fHa.setSourceFromForPb(3);
        this.fHa.setStType("frs_page");
        this.fHa.setHideBarName(true);
        this.fGp = view.findViewById(R.id.divider_below_reply_number_layout);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.fGq.setLigvingLogLayoutVisible(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fGm, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_b);
            am.setBackgroundColor(this.fGZ, R.color.cp_bg_line_c);
            if (this.fGq != null) {
                this.fGq.onChangeSkinType(i);
            }
            this.adC.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fGo.onChangeSkinType();
            this.mSkinType = i;
            if (this.feV != null) {
                this.feV.setPlaceHolder(1);
            }
            if (this.fHa != null && this.fHa.getVisibility() == 0) {
                this.fHa.onChangeSkinType();
            }
        }
        if (this.aee != null && m.Do(this.aee.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.fGX, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.fGY, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.fGX, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.fGY, (int) R.color.cp_cont_b);
        }
        am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_share_live_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bk bkVar) {
        this.aee = bkVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void qw(int i) {
    }

    private void refreshView() {
        if (this.aee == null || this.aee.aQx() == null) {
            this.fGm.setVisibility(8);
            return;
        }
        this.fGm.setVisibility(0);
        this.adC.setData(this.aee);
        this.adC.setUserAfterClickListener(this.agI);
        this.fGq.getController().a(this.aee, this.mForumName, "", false);
        this.fGq.getController().startPlayAnimation();
        if (this.aee.aQS() != null && this.aee.aQS().share_info != null && !StringUtils.isNull(this.aee.aQS().share_info.content)) {
            this.mTextTitle.setVisibility(0);
            this.mTextTitle.setText(this.aee.aQS().share_info.content);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (this.aee.aQS() != null && this.aee.aQS().user_info != null) {
            String str = this.aee.aQS().user_info.user_name;
            if (ae.getTextLengthWithEmoji(str) > 14) {
                str = ae.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.fGY.setText(str + ":");
            if (TextUtils.isEmpty(this.aee.aQS().user_info.portrait)) {
                this.feV.setPlaceHolder(1);
            } else {
                this.feV.startLoad(this.aee.aQS().user_info.portrait, 10, false, false);
            }
        }
        String title = this.aee.getTitle();
        if (!StringUtils.isNull(title)) {
            this.fGX.setText(title);
            this.fGX.setVisibility(0);
        } else {
            this.fGX.setVisibility(8);
        }
        qy(oY(1));
        if (this.aee.aQS().mChallengeInfoData != null && this.aee.aQS().mChallengeInfoData.challenge_id > 0) {
            this.fjx.setVisibility(0);
        } else {
            this.fjx.setVisibility(8);
        }
        this.mMaskView.setVisibility(com.baidu.tieba.frs.a.bTX().bTY() ? 0 : 8);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        rP();
    }

    private void rP() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fGZ.getLayoutParams();
        if (this.mTextTitle.getVisibility() == 0) {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        } else {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
        }
        this.fGZ.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.a.bTX().bTY()) {
            if (view == this.fGm || view == this.fGo.getCommentContainer() || this.fGW == view || view == this.fHa.dXt.getCommentContainer()) {
                if (this.aee != null) {
                    m.Dn(this.aee.getId());
                }
                if (bKS() != null) {
                    bKS().a(this.fGm, this.aee);
                }
                TiebaStatic.log(new an("c12323"));
                int i = 5;
                if (this.aee.aQS().live_status == 1) {
                    o(this.mTbPageContext);
                } else {
                    n(this.mTbPageContext);
                    i = 1;
                }
                if (view == this.fGo.getCommentContainer() || view == this.fHa.dXt.getCommentContainer()) {
                    an anVar = new an("c12942");
                    anVar.ag("obj_locate", 2);
                    anVar.dh("tid", this.aee.getTid());
                    anVar.ag("obj_type", i);
                    anVar.dh("nid", this.aee.getNid());
                    TiebaStatic.log(anVar);
                }
            } else if (view.getId() == R.id.video_container) {
                if (bKS() != null) {
                    bKS().a(view, this.aee);
                }
                TiebaStatic.log(new an("c12323"));
                if (this.aee.aQS().live_status == 1) {
                    o(this.mTbPageContext);
                } else {
                    n(this.mTbPageContext);
                }
            }
        }
    }

    private void n(TbPageContext<?> tbPageContext) {
        if (this.aee != null && this.aee.aQS() != null && this.aee.aQS().share_info != null) {
            if (this.aee.aQS().share_info.record_tid <= 0) {
                o(this.mTbPageContext);
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(this.aee.aQS().share_info.record_tid), null, "frs_page");
            createNormalCfg.setVideo_source(this.aee.aRH() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs");
            createNormalCfg.setFromSmartFrs(this.aee.aRN());
            createNormalCfg.setSmartFrsPosition(this.aee.aRT());
            createNormalCfg.setStartFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }

    public void o(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.aee != null && this.aee.aQS() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(tbPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.aee.aQS());
            if (this.aee.aQS().user_info != null) {
                alaLiveInfoCoreData.userName = this.aee.aQS().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, "frs_share_live", "", false, this.mForumName)));
        }
    }

    public void qy(int i) {
        if (this.aee != null) {
            if (i == 1) {
                this.fGo.setVisibility(8);
                this.fHa.setData(this.aee);
                return;
            }
            this.fGo.setData(this.aee);
            this.fHa.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aeX = str;
    }

    public int oY(int i) {
        return com.baidu.tieba.a.d.blZ().as(this.aeX, i);
    }

    public ThreadCommentAndPraiseInfoLayout bwl() {
        return this.fGo;
    }

    public ThreadCommentAndPraiseInfoLayout bwm() {
        if (this.fHa != null) {
            return this.fHa.dXt;
        }
        return null;
    }
}
