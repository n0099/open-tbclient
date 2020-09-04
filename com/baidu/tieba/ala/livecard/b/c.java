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
    private bw afL;
    private CardUserInfoLayout afe;
    private String agJ;
    private final View.OnClickListener aiT;
    private HeadImageView fGX;
    private LinearLayout fLy;
    private LinearLayout gjM;
    private TextView gjN;
    private TextView gjO;
    private RelativeLayout gjP;
    private ThreadSourceShareAndPraiseLayout gjQ;
    private RelativeLayout gjc;
    private ThreadCommentAndPraiseInfoLayout gje;
    private View gjf;
    public AlaVideoContainer gjg;
    private View mDivider;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aiT = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cbA() != null) {
                    c.this.cbA().a(view, c.this.afL);
                }
            }
        };
        setTag(bdUniqueId);
        View view = getView();
        this.gjc = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.gjc.setOnClickListener(this);
        this.gjM = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.gjM.setOnClickListener(this);
        this.gjP = (RelativeLayout) view.findViewById(R.id.ala_share_container);
        this.fLy = (LinearLayout) this.gjP.findViewById(R.id.challenge_root);
        this.afe = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.afe.setShowFlag(6141);
        this.fGX = (HeadImageView) view.findViewById(R.id.ala_share_live_user_pendant_header);
        this.fGX.setIsRound(true);
        this.fGX.setDrawBorder(false);
        this.fGX.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fGX.setAutoChangeStyle(false);
        this.gjO = (TextView) view.findViewById(R.id.ala_share_live_username_text);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gjN = (TextView) view.findViewById(R.id.ala_live_room_title);
        this.gjg = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.gjg.setOnVideoClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.gje = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.gje.setOnClickListener(this);
        this.gje.setReplyTimeVisible(false);
        this.gje.setShowPraiseNum(true);
        this.gje.setNeedAddReplyIcon(true);
        this.gje.setNeedAddPraiseIcon(true);
        this.gje.setFrom(2);
        this.gje.getCommentContainer().setOnClickListener(this);
        this.gje.setShareVisible(true);
        this.gje.setShareReportFrom(1);
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dWO = 2;
        cVar.dWU = 2;
        this.gje.setAgreeStatisticData(cVar);
        this.gjQ = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.gjQ.euY.setOnClickListener(this);
        this.gjQ.euY.getCommentContainer().setOnClickListener(this);
        this.gjQ.setFrom(2);
        this.gjQ.setShareReportFrom(1);
        this.gjQ.setSourceFromForPb(3);
        this.gjQ.setStType("frs_page");
        this.gjQ.setHideBarName(true);
        this.gjf = view.findViewById(R.id.divider_below_reply_number_layout);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.gjg.setLigvingLogLayoutVisible(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gjc, R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_b);
            ap.setBackgroundColor(this.gjP, R.color.cp_bg_line_c);
            if (this.gjg != null) {
                this.gjg.onChangeSkinType(i);
            }
            this.afe.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.gje.onChangeSkinType();
            this.mSkinType = i;
            if (this.fGX != null) {
                this.fGX.setPlaceHolder(1);
            }
            if (this.gjQ != null && this.gjQ.getVisibility() == 0) {
                this.gjQ.onChangeSkinType();
            }
        }
        if (this.afL != null && m.Ha(this.afL.getId())) {
            ap.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
            ap.setViewTextColor(this.gjN, (int) R.color.cp_cont_d);
            ap.setViewTextColor(this.gjO, (int) R.color.cp_cont_d);
        } else {
            ap.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
            ap.setViewTextColor(this.gjN, (int) R.color.cp_cont_f);
            ap.setViewTextColor(this.gjO, (int) R.color.cp_cont_b);
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
        this.afL = bwVar;
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
        if (this.afL == null || this.afL.beE() == null) {
            this.gjc.setVisibility(8);
            return;
        }
        this.gjc.setVisibility(0);
        this.afe.setData(this.afL);
        this.afe.setUserAfterClickListener(this.aiT);
        this.gjg.getController().a(this.afL, this.mForumName, "", false);
        this.gjg.getController().startPlayAnimation();
        if (this.afL.beY() != null && this.afL.beY().share_info != null && !StringUtils.isNull(this.afL.beY().share_info.content)) {
            this.mTextTitle.setVisibility(0);
            this.mTextTitle.setText(this.afL.beY().share_info.content);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (this.afL.beY() != null && this.afL.beY().user_info != null) {
            String str = this.afL.beY().user_info.user_name;
            if (ae.getTextLengthWithEmoji(str) > 14) {
                str = ae.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.gjO.setText(str + ":");
            if (TextUtils.isEmpty(this.afL.beY().user_info.portrait)) {
                this.fGX.setPlaceHolder(1);
            } else {
                this.fGX.startLoad(this.afL.beY().user_info.portrait, 10, false, false);
            }
        }
        String title = this.afL.getTitle();
        if (!StringUtils.isNull(title)) {
            this.gjN.setText(title);
            this.gjN.setVisibility(0);
        } else {
            this.gjN.setVisibility(8);
        }
        tB(rY(1));
        if (this.afL.beY().mChallengeInfoData != null && this.afL.beY().mChallengeInfoData.challenge_id > 0) {
            this.fLy.setVisibility(0);
        } else {
            this.fLy.setVisibility(8);
        }
        this.mMaskView.setVisibility((com.baidu.tieba.frs.b.ckT().ckN() || com.baidu.tieba.frs.a.ckM().ckN()) ? 0 : 8);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        tU();
    }

    private void tU() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gjP.getLayoutParams();
        if (this.mTextTitle.getVisibility() == 0) {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        } else {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
        }
        this.gjP.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.b.ckT().ckN() && !com.baidu.tieba.frs.a.ckM().ckN()) {
            if (view == this.gjc || view == this.gje.getCommentContainer() || this.gjM == view || view == this.gjQ.euY.getCommentContainer()) {
                if (this.afL != null) {
                    m.GZ(this.afL.getId());
                }
                if (cbA() != null) {
                    cbA().a(this.gjc, this.afL);
                }
                TiebaStatic.log(new aq("c12323"));
                int i = 5;
                if (this.afL.beY().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                    i = 1;
                }
                if (view == this.gje.getCommentContainer() || view == this.gjQ.euY.getCommentContainer()) {
                    aq aqVar = new aq("c12942");
                    aqVar.ai("obj_locate", 2);
                    aqVar.dD("tid", this.afL.getTid());
                    aqVar.ai("obj_type", i);
                    aqVar.dD("nid", this.afL.getNid());
                    TiebaStatic.log(aqVar);
                }
            } else if (view.getId() == R.id.video_container) {
                if (cbA() != null) {
                    cbA().a(view, this.afL);
                }
                TiebaStatic.log(new aq("c12323"));
                if (this.afL.beY().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                }
            }
        }
    }

    private void p(TbPageContext<?> tbPageContext) {
        if (this.afL != null && this.afL.beY() != null && this.afL.beY().share_info != null) {
            if (this.afL.beY().share_info.record_tid <= 0) {
                q(this.mTbPageContext);
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(this.afL.beY().share_info.record_tid), null, "frs_page");
            createNormalCfg.setVideo_source(this.afL.bfN() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs");
            createNormalCfg.setFromSmartFrs(this.afL.bfT());
            createNormalCfg.setSmartFrsPosition(this.afL.bfZ());
            createNormalCfg.setStartFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }

    public void q(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.afL != null && this.afL.beY() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(tbPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.afL.beY());
            if (this.afL.beY().user_info != null) {
                alaLiveInfoCoreData.userName = this.afL.beY().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, "frs_share_live", "", false, this.mForumName)));
        }
    }

    public void tB(int i) {
        if (this.afL != null) {
            if (i == 1) {
                this.gje.setVisibility(8);
                this.gjQ.setData(this.afL);
                return;
            }
            this.gje.setData(this.afL);
            this.gjQ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.agJ = str;
    }

    public int rY(int i) {
        return com.baidu.tieba.a.d.bAB().au(this.agJ, i);
    }

    public ThreadCommentAndPraiseInfoLayout bLS() {
        return this.gje;
    }

    public ThreadCommentAndPraiseInfoLayout bLT() {
        if (this.gjQ != null) {
            return this.gjQ.euY;
        }
        return null;
    }
}
