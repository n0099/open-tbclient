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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.y;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.b<bw> implements com.baidu.tieba.a.e, y {
    private bw afJ;
    private CardUserInfoLayout afc;
    private String agH;
    private final View.OnClickListener aiR;
    private HeadImageView fGT;
    private LinearLayout fLu;
    private RelativeLayout giY;
    private LinearLayout gjI;
    private TextView gjJ;
    private TextView gjK;
    private RelativeLayout gjL;
    private ThreadSourceShareAndPraiseLayout gjM;
    private ThreadCommentAndPraiseInfoLayout gja;
    private View gjb;
    public AlaVideoContainer gjc;
    private View mDivider;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aiR = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cbz() != null) {
                    c.this.cbz().a(view, c.this.afJ);
                }
            }
        };
        setTag(bdUniqueId);
        View view = getView();
        this.giY = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.giY.setOnClickListener(this);
        this.gjI = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.gjI.setOnClickListener(this);
        this.gjL = (RelativeLayout) view.findViewById(R.id.ala_share_container);
        this.fLu = (LinearLayout) this.gjL.findViewById(R.id.challenge_root);
        this.afc = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.afc.setShowFlag(6141);
        this.fGT = (HeadImageView) view.findViewById(R.id.ala_share_live_user_pendant_header);
        this.fGT.setIsRound(true);
        this.fGT.setDrawBorder(false);
        this.fGT.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fGT.setAutoChangeStyle(false);
        this.gjK = (TextView) view.findViewById(R.id.ala_share_live_username_text);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gjJ = (TextView) view.findViewById(R.id.ala_live_room_title);
        this.gjc = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.gjc.setOnVideoClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.gja = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.gja.setOnClickListener(this);
        this.gja.setReplyTimeVisible(false);
        this.gja.setShowPraiseNum(true);
        this.gja.setNeedAddReplyIcon(true);
        this.gja.setNeedAddPraiseIcon(true);
        this.gja.setFrom(2);
        this.gja.getCommentContainer().setOnClickListener(this);
        this.gja.setShareVisible(true);
        this.gja.setShareReportFrom(1);
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dWK = 2;
        cVar.dWQ = 2;
        this.gja.setAgreeStatisticData(cVar);
        this.gjM = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.gjM.euU.setOnClickListener(this);
        this.gjM.euU.getCommentContainer().setOnClickListener(this);
        this.gjM.setFrom(2);
        this.gjM.setShareReportFrom(1);
        this.gjM.setSourceFromForPb(3);
        this.gjM.setStType("frs_page");
        this.gjM.setHideBarName(true);
        this.gjb = view.findViewById(R.id.divider_below_reply_number_layout);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.gjc.setLigvingLogLayoutVisible(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.giY, R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_b);
            ap.setBackgroundColor(this.gjL, R.color.cp_bg_line_c);
            if (this.gjc != null) {
                this.gjc.onChangeSkinType(i);
            }
            this.afc.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.gja.onChangeSkinType();
            this.mSkinType = i;
            if (this.fGT != null) {
                this.fGT.setPlaceHolder(1);
            }
            if (this.gjM != null && this.gjM.getVisibility() == 0) {
                this.gjM.onChangeSkinType();
            }
        }
        if (this.afJ != null && m.GZ(this.afJ.getId())) {
            ap.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
            ap.setViewTextColor(this.gjJ, (int) R.color.cp_cont_d);
            ap.setViewTextColor(this.gjK, (int) R.color.cp_cont_d);
        } else {
            ap.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
            ap.setViewTextColor(this.gjJ, (int) R.color.cp_cont_f);
            ap.setViewTextColor(this.gjK, (int) R.color.cp_cont_b);
        }
        ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_share_live_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bw bwVar) {
        this.afJ = bwVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void tz(int i) {
    }

    private void refreshView() {
        if (this.afJ == null || this.afJ.beE() == null) {
            this.giY.setVisibility(8);
            return;
        }
        this.giY.setVisibility(0);
        this.afc.setData(this.afJ);
        this.afc.setUserAfterClickListener(this.aiR);
        this.gjc.getController().a(this.afJ, this.mForumName, "", false);
        this.gjc.getController().startPlayAnimation();
        if (this.afJ.beY() != null && this.afJ.beY().share_info != null && !StringUtils.isNull(this.afJ.beY().share_info.content)) {
            this.mTextTitle.setVisibility(0);
            this.mTextTitle.setText(this.afJ.beY().share_info.content);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (this.afJ.beY() != null && this.afJ.beY().user_info != null) {
            String str = this.afJ.beY().user_info.user_name;
            if (ae.getTextLengthWithEmoji(str) > 14) {
                str = ae.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.gjK.setText(str + ":");
            if (TextUtils.isEmpty(this.afJ.beY().user_info.portrait)) {
                this.fGT.setPlaceHolder(1);
            } else {
                this.fGT.startLoad(this.afJ.beY().user_info.portrait, 10, false, false);
            }
        }
        String title = this.afJ.getTitle();
        if (!StringUtils.isNull(title)) {
            this.gjJ.setText(title);
            this.gjJ.setVisibility(0);
        } else {
            this.gjJ.setVisibility(8);
        }
        tB(rY(1));
        if (this.afJ.beY().mChallengeInfoData != null && this.afJ.beY().mChallengeInfoData.challenge_id > 0) {
            this.fLu.setVisibility(0);
        } else {
            this.fLu.setVisibility(8);
        }
        this.mMaskView.setVisibility((com.baidu.tieba.frs.b.ckS().ckM() || com.baidu.tieba.frs.a.ckL().ckM()) ? 0 : 8);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        tU();
    }

    private void tU() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gjL.getLayoutParams();
        if (this.mTextTitle.getVisibility() == 0) {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        } else {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
        }
        this.gjL.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.b.ckS().ckM() && !com.baidu.tieba.frs.a.ckL().ckM()) {
            if (view == this.giY || view == this.gja.getCommentContainer() || this.gjI == view || view == this.gjM.euU.getCommentContainer()) {
                if (this.afJ != null) {
                    m.GY(this.afJ.getId());
                }
                if (cbz() != null) {
                    cbz().a(this.giY, this.afJ);
                }
                TiebaStatic.log(new aq("c12323"));
                int i = 5;
                if (this.afJ.beY().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                    i = 1;
                }
                if (view == this.gja.getCommentContainer() || view == this.gjM.euU.getCommentContainer()) {
                    aq aqVar = new aq("c12942");
                    aqVar.ai("obj_locate", 2);
                    aqVar.dD("tid", this.afJ.getTid());
                    aqVar.ai("obj_type", i);
                    aqVar.dD("nid", this.afJ.getNid());
                    TiebaStatic.log(aqVar);
                }
            } else if (view.getId() == R.id.video_container) {
                if (cbz() != null) {
                    cbz().a(view, this.afJ);
                }
                TiebaStatic.log(new aq("c12323"));
                if (this.afJ.beY().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                }
            }
        }
    }

    private void p(TbPageContext<?> tbPageContext) {
        if (this.afJ != null && this.afJ.beY() != null && this.afJ.beY().share_info != null) {
            if (this.afJ.beY().share_info.record_tid <= 0) {
                q(this.mTbPageContext);
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(this.afJ.beY().share_info.record_tid), null, "frs_page");
            createNormalCfg.setVideo_source(this.afJ.bfN() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs");
            createNormalCfg.setFromSmartFrs(this.afJ.bfT());
            createNormalCfg.setSmartFrsPosition(this.afJ.bfZ());
            createNormalCfg.setStartFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }

    public void q(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.afJ != null && this.afJ.beY() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(tbPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.afJ.beY());
            if (this.afJ.beY().user_info != null) {
                alaLiveInfoCoreData.userName = this.afJ.beY().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, "frs_share_live", "", false, this.mForumName)));
        }
    }

    public void tB(int i) {
        if (this.afJ != null) {
            if (i == 1) {
                this.gja.setVisibility(8);
                this.gjM.setData(this.afJ);
                return;
            }
            this.gja.setData(this.afJ);
            this.gjM.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.agH = str;
    }

    public int rY(int i) {
        return com.baidu.tieba.a.d.bAA().au(this.agH, i);
    }

    public ThreadCommentAndPraiseInfoLayout bLR() {
        return this.gja;
    }

    public ThreadCommentAndPraiseInfoLayout bLS() {
        if (this.gjM != null) {
            return this.gjM.euU;
        }
        return null;
    }
}
