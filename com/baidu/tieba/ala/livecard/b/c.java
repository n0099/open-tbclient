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
    private bj adG;
    private CardUserInfoLayout adh;
    private String aey;
    private final View.OnClickListener agi;
    private HeadImageView eSi;
    private LinearLayout eWI;
    private LinearLayout fsZ;
    private RelativeLayout fsp;
    private ThreadCommentAndPraiseInfoLayout fsr;
    private View fss;
    public AlaVideoContainer fst;
    private TextView fta;
    private TextView ftb;
    private RelativeLayout ftc;
    private ThreadSourceShareAndPraiseLayout ftd;
    private View mDivider;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.agi = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bEy() != null) {
                    c.this.bEy().a(view, c.this.adG);
                }
            }
        };
        setTag(bdUniqueId);
        View view = getView();
        this.fsp = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fsp.setOnClickListener(this);
        this.fsZ = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.fsZ.setOnClickListener(this);
        this.ftc = (RelativeLayout) view.findViewById(R.id.ala_share_container);
        this.eWI = (LinearLayout) this.ftc.findViewById(R.id.challenge_root);
        this.adh = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.adh.setShowFlag(6141);
        this.eSi = (HeadImageView) view.findViewById(R.id.ala_share_live_user_pendant_header);
        this.eSi.setIsRound(true);
        this.eSi.setDrawBorder(false);
        this.eSi.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eSi.setAutoChangeStyle(false);
        this.ftb = (TextView) view.findViewById(R.id.ala_share_live_username_text);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fta = (TextView) view.findViewById(R.id.ala_live_room_title);
        this.fst = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.fst.setOnVideoClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.fsr = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.fsr.setOnClickListener(this);
        this.fsr.setReplyTimeVisible(false);
        this.fsr.setShowPraiseNum(true);
        this.fsr.setNeedAddReplyIcon(true);
        this.fsr.setNeedAddPraiseIcon(true);
        this.fsr.setFrom(2);
        this.fsr.getCommentContainer().setOnClickListener(this);
        this.fsr.setShareVisible(true);
        this.fsr.setShareReportFrom(1);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.dmT = 2;
        dVar.dmZ = 2;
        this.fsr.setAgreeStatisticData(dVar);
        this.ftd = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.ftd.dJa.setOnClickListener(this);
        this.ftd.dJa.getCommentContainer().setOnClickListener(this);
        this.ftd.setFrom(2);
        this.ftd.setShareReportFrom(1);
        this.ftd.setSourceFromForPb(3);
        this.ftd.setStType("frs_page");
        this.ftd.setHideBarName(true);
        this.fss = view.findViewById(R.id.divider_below_reply_number_layout);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.fst.setLigvingLogLayoutVisible(8);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fsp, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_b);
            am.setBackgroundColor(this.ftc, R.color.cp_bg_line_c);
            if (this.fst != null) {
                this.fst.onChangeSkinType(i);
            }
            this.adh.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fsr.onChangeSkinType();
            this.mSkinType = i;
            if (this.eSi != null) {
                this.eSi.setPlaceHolder(1);
            }
            if (this.ftd != null && this.ftd.getVisibility() == 0) {
                this.ftd.onChangeSkinType();
            }
        }
        if (this.adG != null && l.BC(this.adG.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.fta, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.ftb, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.fta, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.ftb, (int) R.color.cp_cont_b);
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
        this.adG = bjVar;
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
        if (this.adG == null || this.adG.aKE() == null) {
            this.fsp.setVisibility(8);
            return;
        }
        this.fsp.setVisibility(0);
        this.adh.setData(this.adG);
        this.adh.setUserAfterClickListener(this.agi);
        this.fst.getController().a(this.adG, this.mForumName, "", false);
        this.fst.getController().startPlayAnimation();
        if (this.adG.aKX() != null && this.adG.aKX().share_info != null && !StringUtils.isNull(this.adG.aKX().share_info.content)) {
            this.mTextTitle.setVisibility(0);
            this.mTextTitle.setText(this.adG.aKX().share_info.content);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (this.adG.aKX() != null && this.adG.aKX().user_info != null) {
            String str = this.adG.aKX().user_info.user_name;
            if (ad.getTextLengthWithEmoji(str) > 14) {
                str = ad.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.ftb.setText(str + ":");
            if (TextUtils.isEmpty(this.adG.aKX().user_info.portrait)) {
                this.eSi.setPlaceHolder(1);
            } else {
                this.eSi.startLoad(this.adG.aKX().user_info.portrait, 10, false, false);
            }
        }
        String title = this.adG.getTitle();
        if (!StringUtils.isNull(title)) {
            this.fta.setText(title);
            this.fta.setVisibility(0);
        } else {
            this.fta.setVisibility(8);
        }
        pX(or(1));
        if (this.adG.aKX().mChallengeInfoData != null && this.adG.aKX().mChallengeInfoData.challenge_id > 0) {
            this.eWI.setVisibility(0);
        } else {
            this.eWI.setVisibility(8);
        }
        this.mMaskView.setVisibility(com.baidu.tieba.frs.a.bND().bNE() ? 0 : 8);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        rG();
    }

    private void rG() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ftc.getLayoutParams();
        if (this.mTextTitle.getVisibility() == 0) {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        } else {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
        }
        this.ftc.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.a.bND().bNE()) {
            if (view == this.fsp || view == this.fsr.getCommentContainer() || this.fsZ == view || view == this.ftd.dJa.getCommentContainer()) {
                if (this.adG != null) {
                    l.BB(this.adG.getId());
                }
                if (bEy() != null) {
                    bEy().a(this.fsp, this.adG);
                }
                TiebaStatic.log(new an("c12323"));
                int i = 5;
                if (this.adG.aKX().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                    i = 1;
                }
                if (view == this.fsr.getCommentContainer() || view == this.ftd.dJa.getCommentContainer()) {
                    an anVar = new an("c12942");
                    anVar.af("obj_locate", 2);
                    anVar.cI("tid", this.adG.getTid());
                    anVar.af("obj_type", i);
                    TiebaStatic.log(anVar);
                }
            } else if (view.getId() == R.id.video_container) {
                if (bEy() != null) {
                    bEy().a(view, this.adG);
                }
                TiebaStatic.log(new an("c12323"));
                if (this.adG.aKX().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                }
            }
        }
    }

    private void p(TbPageContext<?> tbPageContext) {
        if (this.adG != null && this.adG.aKX() != null && this.adG.aKX().share_info != null) {
            if (this.adG.aKX().share_info.record_tid <= 0) {
                q(this.mTbPageContext);
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(this.adG.aKX().share_info.record_tid), null, "frs_page");
            createNormalCfg.setVideo_source(this.adG.aLK() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs");
            createNormalCfg.setFromSmartFrs(this.adG.aLQ());
            createNormalCfg.setSmartFrsPosition(this.adG.aLW());
            createNormalCfg.setStartFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }

    public void q(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.adG != null && this.adG.aKX() != null) {
            if (!j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.adG.aKX());
            if (this.adG.aKX().user_info != null) {
                alaLiveInfoCoreData.userName = this.adG.aKX().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, "frs_share_live", "", false, this.mForumName)));
        }
    }

    public void pX(int i) {
        if (this.adG != null) {
            if (i == 1) {
                this.fsr.setVisibility(8);
                this.ftd.setData(this.adG);
                return;
            }
            this.fsr.setData(this.adG);
            this.ftd.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aey = str;
    }

    public int or(int i) {
        return com.baidu.tieba.a.d.bfP().ar(this.aey, i);
    }

    public ThreadCommentAndPraiseInfoLayout bqw() {
        return this.fsr;
    }

    public ThreadCommentAndPraiseInfoLayout bqx() {
        if (this.ftd != null) {
            return this.ftd.dJa;
        }
        return null;
    }
}
