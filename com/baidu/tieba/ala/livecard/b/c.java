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
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.a<bj> implements com.baidu.tieba.a.e, x {
    private CardUserInfoLayout JH;
    private bj Ki;
    private String La;
    private final View.OnClickListener MT;
    private LinearLayout eIQ;
    private TextView eIR;
    private TextView eIS;
    private RelativeLayout eIT;
    private ThreadSourceShareAndPraiseLayout eIU;
    private RelativeLayout eIf;
    private ThreadCommentAndPraiseInfoLayout eIh;
    private View eIi;
    public AlaVideoContainer eIj;
    private HeadImageView ejh;
    private LinearLayout enf;
    private View mDivider;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.MT = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.brY() != null) {
                    c.this.brY().a(view, c.this.Ki);
                }
            }
        };
        setTag(bdUniqueId);
        View view = getView();
        this.eIf = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.eIf.setOnClickListener(this);
        this.eIQ = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.eIQ.setOnClickListener(this);
        this.eIT = (RelativeLayout) view.findViewById(R.id.ala_share_container);
        this.enf = (LinearLayout) this.eIT.findViewById(R.id.challenge_root);
        this.JH = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.JH.setShowFlag(6141);
        this.ejh = (HeadImageView) view.findViewById(R.id.ala_share_live_user_pendant_header);
        this.ejh.setIsRound(true);
        this.ejh.setDrawBorder(false);
        this.ejh.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ejh.setAutoChangeStyle(false);
        this.eIS = (TextView) view.findViewById(R.id.ala_share_live_username_text);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.eIR = (TextView) view.findViewById(R.id.ala_live_room_title);
        this.eIj = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.eIj.setOnVideoClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.eIh = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.eIh.setOnClickListener(this);
        this.eIh.setReplyTimeVisible(false);
        this.eIh.setShowPraiseNum(true);
        this.eIh.setNeedAddReplyIcon(true);
        this.eIh.setNeedAddPraiseIcon(true);
        this.eIh.setFrom(2);
        this.eIh.getCommentContainer().setOnClickListener(this);
        this.eIh.setShareVisible(true);
        this.eIh.setShareReportFrom(1);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cJm = 2;
        dVar.cJs = 2;
        this.eIh.setAgreeStatisticData(dVar);
        this.eIU = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.eIU.dep.setOnClickListener(this);
        this.eIU.dep.getCommentContainer().setOnClickListener(this);
        this.eIU.setFrom(2);
        this.eIU.setShareReportFrom(1);
        this.eIU.setSourceFromForPb(3);
        this.eIU.setStType("frs_page");
        this.eIU.setHideBarName(true);
        this.eIi = view.findViewById(R.id.divider_below_reply_number_layout);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.eIj.setLigvingLogLayoutVisible(8);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eIf, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.eIT, R.color.cp_bg_line_c);
            if (this.eIj != null) {
                this.eIj.onChangeSkinType(i);
            }
            this.JH.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.eIh.onChangeSkinType();
            this.mSkinType = i;
            if (this.ejh != null) {
                this.ejh.setPlaceHolder(1);
            }
            if (this.eIU != null && this.eIU.getVisibility() == 0) {
                this.eIU.onChangeSkinType();
            }
        }
        if (this.Ki != null && l.zt(this.Ki.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eIR, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eIS, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eIR, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.eIS, (int) R.color.cp_cont_b);
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
        this.Ki = bjVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pm(int i) {
    }

    private void refreshView() {
        if (this.Ki == null || this.Ki.azE() == null) {
            this.eIf.setVisibility(8);
            return;
        }
        this.eIf.setVisibility(0);
        this.JH.setData(this.Ki);
        this.JH.setUserAfterClickListener(this.MT);
        this.eIj.getController().a(this.Ki, this.mForumName, "", false);
        this.eIj.getController().startPlayAnimation();
        if (this.Ki.azX() != null && this.Ki.azX().share_info != null && !StringUtils.isNull(this.Ki.azX().share_info.content)) {
            this.mTextTitle.setVisibility(0);
            this.mTextTitle.setText(this.Ki.azX().share_info.content);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (this.Ki.azX() != null && this.Ki.azX().user_info != null) {
            String str = this.Ki.azX().user_info.user_name;
            if (ad.getTextLengthWithEmoji(str) > 14) {
                str = ad.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.eIS.setText(str + ":");
            if (TextUtils.isEmpty(this.Ki.azX().user_info.portrait)) {
                this.ejh.setPlaceHolder(1);
            } else {
                this.ejh.startLoad(this.Ki.azX().user_info.portrait, 10, false, false);
            }
        }
        String title = this.Ki.getTitle();
        if (!StringUtils.isNull(title)) {
            this.eIR.setText(title);
            this.eIR.setVisibility(0);
        } else {
            this.eIR.setVisibility(8);
        }
        pp(nL(1));
        if (this.Ki.azX().mChallengeInfoData != null && this.Ki.azX().mChallengeInfoData.challenge_id > 0) {
            this.enf.setVisibility(0);
        } else {
            this.enf.setVisibility(8);
        }
        this.mMaskView.setVisibility(com.baidu.tieba.frs.a.bAp().bAq() ? 0 : 8);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        mW();
    }

    private void mW() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eIT.getLayoutParams();
        if (this.mTextTitle.getVisibility() == 0) {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        } else {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
        }
        this.eIT.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.a.bAp().bAq()) {
            if (view == this.eIf || view == this.eIh.getCommentContainer() || this.eIQ == view || view == this.eIU.dep.getCommentContainer()) {
                if (this.Ki != null) {
                    l.zs(this.Ki.getId());
                }
                if (brY() != null) {
                    brY().a(this.eIf, this.Ki);
                }
                TiebaStatic.log(new an("c12323"));
                int i = 5;
                if (this.Ki.azX().live_status == 1) {
                    m(this.mTbPageContext);
                } else {
                    l(this.mTbPageContext);
                    i = 1;
                }
                if (view == this.eIh.getCommentContainer() || view == this.eIU.dep.getCommentContainer()) {
                    an anVar = new an("c12942");
                    anVar.Z("obj_locate", 2);
                    anVar.cp("tid", this.Ki.getTid());
                    anVar.Z("obj_type", i);
                    TiebaStatic.log(anVar);
                }
            } else if (view.getId() == R.id.video_container) {
                if (brY() != null) {
                    brY().a(view, this.Ki);
                }
                TiebaStatic.log(new an("c12323"));
                if (this.Ki.azX().live_status == 1) {
                    m(this.mTbPageContext);
                } else {
                    l(this.mTbPageContext);
                }
            }
        }
    }

    private void l(TbPageContext<?> tbPageContext) {
        if (this.Ki != null && this.Ki.azX() != null && this.Ki.azX().share_info != null) {
            if (this.Ki.azX().share_info.record_tid <= 0) {
                m(this.mTbPageContext);
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(this.Ki.azX().share_info.record_tid), null, "frs_page");
            createNormalCfg.setVideo_source(this.Ki.aAL() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs");
            createNormalCfg.setFromSmartFrs(this.Ki.aAR());
            createNormalCfg.setSmartFrsPosition(this.Ki.aAW());
            createNormalCfg.setStartFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }

    public void m(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.Ki != null && this.Ki.azX() != null) {
            if (!j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.Ki.azX());
            if (this.Ki.azX().user_info != null) {
                alaLiveInfoCoreData.userName = this.Ki.azX().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, "frs_share_live", "", false, this.mForumName)));
        }
    }

    public void pp(int i) {
        if (this.Ki != null) {
            if (i == 1) {
                this.eIh.setVisibility(8);
                this.eIU.setData(this.Ki);
                return;
            }
            this.eIh.setData(this.Ki);
            this.eIU.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.La = str;
    }

    public int nL(int i) {
        return com.baidu.tieba.a.d.aUV().aj(this.La, i);
    }

    public ThreadCommentAndPraiseInfoLayout bes() {
        return this.eIh;
    }

    public ThreadCommentAndPraiseInfoLayout bet() {
        if (this.eIU != null) {
            return this.eIU.dep;
        }
        return null;
    }
}
