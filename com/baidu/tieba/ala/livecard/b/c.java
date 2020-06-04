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
    private View fGA;
    public AlaVideoContainer fGB;
    private RelativeLayout fGx;
    private ThreadCommentAndPraiseInfoLayout fGz;
    private LinearLayout fHh;
    private TextView fHi;
    private TextView fHj;
    private RelativeLayout fHk;
    private ThreadSourceShareAndPraiseLayout fHl;
    private HeadImageView ffg;
    private LinearLayout fjI;
    private View mDivider;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.agI = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bKU() != null) {
                    c.this.bKU().a(view, c.this.aee);
                }
            }
        };
        setTag(bdUniqueId);
        View view = getView();
        this.fGx = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fGx.setOnClickListener(this);
        this.fHh = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.fHh.setOnClickListener(this);
        this.fHk = (RelativeLayout) view.findViewById(R.id.ala_share_container);
        this.fjI = (LinearLayout) this.fHk.findViewById(R.id.challenge_root);
        this.adC = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.adC.setShowFlag(6141);
        this.ffg = (HeadImageView) view.findViewById(R.id.ala_share_live_user_pendant_header);
        this.ffg.setIsRound(true);
        this.ffg.setDrawBorder(false);
        this.ffg.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ffg.setAutoChangeStyle(false);
        this.fHj = (TextView) view.findViewById(R.id.ala_share_live_username_text);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fHi = (TextView) view.findViewById(R.id.ala_live_room_title);
        this.fGB = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.fGB.setOnVideoClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.fGz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.fGz.setOnClickListener(this);
        this.fGz.setReplyTimeVisible(false);
        this.fGz.setShowPraiseNum(true);
        this.fGz.setNeedAddReplyIcon(true);
        this.fGz.setNeedAddPraiseIcon(true);
        this.fGz.setFrom(2);
        this.fGz.getCommentContainer().setOnClickListener(this);
        this.fGz.setShareVisible(true);
        this.fGz.setShareReportFrom(1);
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dAZ = 2;
        cVar.dBf = 2;
        this.fGz.setAgreeStatisticData(cVar);
        this.fHl = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.fHl.dXt.setOnClickListener(this);
        this.fHl.dXt.getCommentContainer().setOnClickListener(this);
        this.fHl.setFrom(2);
        this.fHl.setShareReportFrom(1);
        this.fHl.setSourceFromForPb(3);
        this.fHl.setStType("frs_page");
        this.fHl.setHideBarName(true);
        this.fGA = view.findViewById(R.id.divider_below_reply_number_layout);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.fGB.setLigvingLogLayoutVisible(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fGx, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_b);
            am.setBackgroundColor(this.fHk, R.color.cp_bg_line_c);
            if (this.fGB != null) {
                this.fGB.onChangeSkinType(i);
            }
            this.adC.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fGz.onChangeSkinType();
            this.mSkinType = i;
            if (this.ffg != null) {
                this.ffg.setPlaceHolder(1);
            }
            if (this.fHl != null && this.fHl.getVisibility() == 0) {
                this.fHl.onChangeSkinType();
            }
        }
        if (this.aee != null && m.Do(this.aee.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.fHi, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.fHj, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.fHi, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.fHj, (int) R.color.cp_cont_b);
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
    public void qy(int i) {
    }

    private void refreshView() {
        if (this.aee == null || this.aee.aQx() == null) {
            this.fGx.setVisibility(8);
            return;
        }
        this.fGx.setVisibility(0);
        this.adC.setData(this.aee);
        this.adC.setUserAfterClickListener(this.agI);
        this.fGB.getController().a(this.aee, this.mForumName, "", false);
        this.fGB.getController().startPlayAnimation();
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
            this.fHj.setText(str + ":");
            if (TextUtils.isEmpty(this.aee.aQS().user_info.portrait)) {
                this.ffg.setPlaceHolder(1);
            } else {
                this.ffg.startLoad(this.aee.aQS().user_info.portrait, 10, false, false);
            }
        }
        String title = this.aee.getTitle();
        if (!StringUtils.isNull(title)) {
            this.fHi.setText(title);
            this.fHi.setVisibility(0);
        } else {
            this.fHi.setVisibility(8);
        }
        qA(pa(1));
        if (this.aee.aQS().mChallengeInfoData != null && this.aee.aQS().mChallengeInfoData.challenge_id > 0) {
            this.fjI.setVisibility(0);
        } else {
            this.fjI.setVisibility(8);
        }
        this.mMaskView.setVisibility(com.baidu.tieba.frs.a.bTZ().bUa() ? 0 : 8);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        rP();
    }

    private void rP() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fHk.getLayoutParams();
        if (this.mTextTitle.getVisibility() == 0) {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        } else {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
        }
        this.fHk.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.a.bTZ().bUa()) {
            if (view == this.fGx || view == this.fGz.getCommentContainer() || this.fHh == view || view == this.fHl.dXt.getCommentContainer()) {
                if (this.aee != null) {
                    m.Dn(this.aee.getId());
                }
                if (bKU() != null) {
                    bKU().a(this.fGx, this.aee);
                }
                TiebaStatic.log(new an("c12323"));
                int i = 5;
                if (this.aee.aQS().live_status == 1) {
                    o(this.mTbPageContext);
                } else {
                    n(this.mTbPageContext);
                    i = 1;
                }
                if (view == this.fGz.getCommentContainer() || view == this.fHl.dXt.getCommentContainer()) {
                    an anVar = new an("c12942");
                    anVar.ag("obj_locate", 2);
                    anVar.dh("tid", this.aee.getTid());
                    anVar.ag("obj_type", i);
                    anVar.dh("nid", this.aee.getNid());
                    TiebaStatic.log(anVar);
                }
            } else if (view.getId() == R.id.video_container) {
                if (bKU() != null) {
                    bKU().a(view, this.aee);
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

    public void qA(int i) {
        if (this.aee != null) {
            if (i == 1) {
                this.fGz.setVisibility(8);
                this.fHl.setData(this.aee);
                return;
            }
            this.fGz.setData(this.aee);
            this.fHl.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aeX = str;
    }

    public int pa(int i) {
        return com.baidu.tieba.a.d.bmb().as(this.aeX, i);
    }

    public ThreadCommentAndPraiseInfoLayout bwn() {
        return this.fGz;
    }

    public ThreadCommentAndPraiseInfoLayout bwo() {
        if (this.fHl != null) {
            return this.fHl.dXt;
        }
        return null;
    }
}
