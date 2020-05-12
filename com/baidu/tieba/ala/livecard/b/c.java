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
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.card.l;
import com.baidu.tieba.card.x;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.a<bj> implements com.baidu.tieba.a.e, x {
    private bj adJ;
    private CardUserInfoLayout adk;
    private String aeB;
    private final View.OnClickListener agl;
    private HeadImageView eSn;
    private LinearLayout eWN;
    private RelativeLayout fsu;
    private ThreadCommentAndPraiseInfoLayout fsw;
    private View fsx;
    public AlaVideoContainer fsy;
    private LinearLayout fte;
    private TextView ftf;
    private TextView ftg;
    private RelativeLayout fth;
    private ThreadSourceShareAndPraiseLayout fti;
    private View mDivider;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.agl = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bEx() != null) {
                    c.this.bEx().a(view, c.this.adJ);
                }
            }
        };
        setTag(bdUniqueId);
        View view = getView();
        this.fsu = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fsu.setOnClickListener(this);
        this.fte = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.fte.setOnClickListener(this);
        this.fth = (RelativeLayout) view.findViewById(R.id.ala_share_container);
        this.eWN = (LinearLayout) this.fth.findViewById(R.id.challenge_root);
        this.adk = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.adk.setShowFlag(6141);
        this.eSn = (HeadImageView) view.findViewById(R.id.ala_share_live_user_pendant_header);
        this.eSn.setIsRound(true);
        this.eSn.setDrawBorder(false);
        this.eSn.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eSn.setAutoChangeStyle(false);
        this.ftg = (TextView) view.findViewById(R.id.ala_share_live_username_text);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.ftf = (TextView) view.findViewById(R.id.ala_live_room_title);
        this.fsy = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.fsy.setOnVideoClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.fsw = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.fsw.setOnClickListener(this);
        this.fsw.setReplyTimeVisible(false);
        this.fsw.setShowPraiseNum(true);
        this.fsw.setNeedAddReplyIcon(true);
        this.fsw.setNeedAddPraiseIcon(true);
        this.fsw.setFrom(2);
        this.fsw.getCommentContainer().setOnClickListener(this);
        this.fsw.setShareVisible(true);
        this.fsw.setShareReportFrom(1);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.dmX = 2;
        dVar.dnd = 2;
        this.fsw.setAgreeStatisticData(dVar);
        this.fti = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.fti.dJe.setOnClickListener(this);
        this.fti.dJe.getCommentContainer().setOnClickListener(this);
        this.fti.setFrom(2);
        this.fti.setShareReportFrom(1);
        this.fti.setSourceFromForPb(3);
        this.fti.setStType("frs_page");
        this.fti.setHideBarName(true);
        this.fsx = view.findViewById(R.id.divider_below_reply_number_layout);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.fsy.setLigvingLogLayoutVisible(8);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fsu, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_b);
            am.setBackgroundColor(this.fth, R.color.cp_bg_line_c);
            if (this.fsy != null) {
                this.fsy.onChangeSkinType(i);
            }
            this.adk.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fsw.onChangeSkinType();
            this.mSkinType = i;
            if (this.eSn != null) {
                this.eSn.setPlaceHolder(1);
            }
            if (this.fti != null && this.fti.getVisibility() == 0) {
                this.fti.onChangeSkinType();
            }
        }
        if (this.adJ != null && l.BF(this.adJ.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.ftf, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.ftg, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.ftf, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.ftg, (int) R.color.cp_cont_b);
        }
        am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_ala_share_live_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bj bjVar) {
        this.adJ = bjVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pV(int i) {
    }

    private void refreshView() {
        if (this.adJ == null || this.adJ.aKC() == null) {
            this.fsu.setVisibility(8);
            return;
        }
        this.fsu.setVisibility(0);
        this.adk.setData(this.adJ);
        this.adk.setUserAfterClickListener(this.agl);
        this.fsy.getController().a(this.adJ, this.mForumName, "", false);
        this.fsy.getController().startPlayAnimation();
        if (this.adJ.aKV() != null && this.adJ.aKV().share_info != null && !StringUtils.isNull(this.adJ.aKV().share_info.content)) {
            this.mTextTitle.setVisibility(0);
            this.mTextTitle.setText(this.adJ.aKV().share_info.content);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (this.adJ.aKV() != null && this.adJ.aKV().user_info != null) {
            String str = this.adJ.aKV().user_info.user_name;
            if (ad.getTextLengthWithEmoji(str) > 14) {
                str = ad.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.ftg.setText(str + ":");
            if (TextUtils.isEmpty(this.adJ.aKV().user_info.portrait)) {
                this.eSn.setPlaceHolder(1);
            } else {
                this.eSn.startLoad(this.adJ.aKV().user_info.portrait, 10, false, false);
            }
        }
        String title = this.adJ.getTitle();
        if (!StringUtils.isNull(title)) {
            this.ftf.setText(title);
            this.ftf.setVisibility(0);
        } else {
            this.ftf.setVisibility(8);
        }
        pX(or(1));
        if (this.adJ.aKV().mChallengeInfoData != null && this.adJ.aKV().mChallengeInfoData.challenge_id > 0) {
            this.eWN.setVisibility(0);
        } else {
            this.eWN.setVisibility(8);
        }
        this.mMaskView.setVisibility(com.baidu.tieba.frs.a.bNC().bND() ? 0 : 8);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        rG();
    }

    private void rG() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fth.getLayoutParams();
        if (this.mTextTitle.getVisibility() == 0) {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        } else {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
        }
        this.fth.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.a.bNC().bND()) {
            if (view == this.fsu || view == this.fsw.getCommentContainer() || this.fte == view || view == this.fti.dJe.getCommentContainer()) {
                if (this.adJ != null) {
                    l.BE(this.adJ.getId());
                }
                if (bEx() != null) {
                    bEx().a(this.fsu, this.adJ);
                }
                TiebaStatic.log(new an("c12323"));
                int i = 5;
                if (this.adJ.aKV().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                    i = 1;
                }
                if (view == this.fsw.getCommentContainer() || view == this.fti.dJe.getCommentContainer()) {
                    an anVar = new an("c12942");
                    anVar.af("obj_locate", 2);
                    anVar.cI("tid", this.adJ.getTid());
                    anVar.af("obj_type", i);
                    TiebaStatic.log(anVar);
                }
            } else if (view.getId() == R.id.video_container) {
                if (bEx() != null) {
                    bEx().a(view, this.adJ);
                }
                TiebaStatic.log(new an("c12323"));
                if (this.adJ.aKV().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                }
            }
        }
    }

    private void p(TbPageContext<?> tbPageContext) {
        if (this.adJ != null && this.adJ.aKV() != null && this.adJ.aKV().share_info != null) {
            if (this.adJ.aKV().share_info.record_tid <= 0) {
                q(this.mTbPageContext);
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(this.adJ.aKV().share_info.record_tid), null, "frs_page");
            createNormalCfg.setVideo_source(this.adJ.aLI() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs");
            createNormalCfg.setFromSmartFrs(this.adJ.aLO());
            createNormalCfg.setSmartFrsPosition(this.adJ.aLU());
            createNormalCfg.setStartFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }

    public void q(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.adJ != null && this.adJ.aKV() != null) {
            if (!j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.adJ.aKV());
            if (this.adJ.aKV().user_info != null) {
                alaLiveInfoCoreData.userName = this.adJ.aKV().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, "frs_share_live", "", false, this.mForumName)));
        }
    }

    public void pX(int i) {
        if (this.adJ != null) {
            if (i == 1) {
                this.fsw.setVisibility(8);
                this.fti.setData(this.adJ);
                return;
            }
            this.fsw.setData(this.adJ);
            this.fti.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aeB = str;
    }

    public int or(int i) {
        return com.baidu.tieba.a.d.bfN().ar(this.aeB, i);
    }

    public ThreadCommentAndPraiseInfoLayout bqu() {
        return this.fsw;
    }

    public ThreadCommentAndPraiseInfoLayout bqv() {
        if (this.fti != null) {
            return this.fti.dJe;
        }
        return null;
    }
}
