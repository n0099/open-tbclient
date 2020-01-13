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
    private CardUserInfoLayout JN;
    private bj Kn;
    private String Lg;
    private final View.OnClickListener MX;
    private RelativeLayout eJp;
    private ThreadCommentAndPraiseInfoLayout eJr;
    private View eJs;
    public AlaVideoContainer eJt;
    private LinearLayout eKa;
    private TextView eKb;
    private TextView eKc;
    private RelativeLayout eKd;
    private ThreadSourceShareAndPraiseLayout eKe;
    private HeadImageView ejV;
    private LinearLayout eos;
    private View mDivider;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.MX = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bta() != null) {
                    c.this.bta().a(view, c.this.Kn);
                }
            }
        };
        setTag(bdUniqueId);
        View view = getView();
        this.eJp = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.eJp.setOnClickListener(this);
        this.eKa = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.eKa.setOnClickListener(this);
        this.eKd = (RelativeLayout) view.findViewById(R.id.ala_share_container);
        this.eos = (LinearLayout) this.eKd.findViewById(R.id.challenge_root);
        this.JN = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.JN.setShowFlag(6141);
        this.ejV = (HeadImageView) view.findViewById(R.id.ala_share_live_user_pendant_header);
        this.ejV.setIsRound(true);
        this.ejV.setDrawBorder(false);
        this.ejV.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ejV.setAutoChangeStyle(false);
        this.eKc = (TextView) view.findViewById(R.id.ala_share_live_username_text);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.eKb = (TextView) view.findViewById(R.id.ala_live_room_title);
        this.eJt = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.eJt.setOnVideoClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.eJr = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.eJr.setOnClickListener(this);
        this.eJr.setReplyTimeVisible(false);
        this.eJr.setShowPraiseNum(true);
        this.eJr.setNeedAddReplyIcon(true);
        this.eJr.setNeedAddPraiseIcon(true);
        this.eJr.setFrom(2);
        this.eJr.getCommentContainer().setOnClickListener(this);
        this.eJr.setShareVisible(true);
        this.eJr.setShareReportFrom(1);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cJx = 2;
        dVar.cJD = 2;
        this.eJr.setAgreeStatisticData(dVar);
        this.eKe = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.eKe.deA.setOnClickListener(this);
        this.eKe.deA.getCommentContainer().setOnClickListener(this);
        this.eKe.setFrom(2);
        this.eKe.setShareReportFrom(1);
        this.eKe.setSourceFromForPb(3);
        this.eKe.setStType("frs_page");
        this.eKe.setHideBarName(true);
        this.eJs = view.findViewById(R.id.divider_below_reply_number_layout);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.eJt.setLigvingLogLayoutVisible(8);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eJp, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.eKd, R.color.cp_bg_line_c);
            if (this.eJt != null) {
                this.eJt.onChangeSkinType(i);
            }
            this.JN.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.eJr.onChangeSkinType();
            this.mSkinType = i;
            if (this.ejV != null) {
                this.ejV.setPlaceHolder(1);
            }
            if (this.eKe != null && this.eKe.getVisibility() == 0) {
                this.eKe.onChangeSkinType();
            }
        }
        if (this.Kn != null && l.zD(this.Kn.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eKb, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eKc, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eKb, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.eKc, (int) R.color.cp_cont_b);
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
        this.Kn = bjVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void po(int i) {
    }

    private void refreshView() {
        if (this.Kn == null || this.Kn.azX() == null) {
            this.eJp.setVisibility(8);
            return;
        }
        this.eJp.setVisibility(0);
        this.JN.setData(this.Kn);
        this.JN.setUserAfterClickListener(this.MX);
        this.eJt.getController().a(this.Kn, this.mForumName, "", false);
        this.eJt.getController().startPlayAnimation();
        if (this.Kn.aAq() != null && this.Kn.aAq().share_info != null && !StringUtils.isNull(this.Kn.aAq().share_info.content)) {
            this.mTextTitle.setVisibility(0);
            this.mTextTitle.setText(this.Kn.aAq().share_info.content);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (this.Kn.aAq() != null && this.Kn.aAq().user_info != null) {
            String str = this.Kn.aAq().user_info.user_name;
            if (ad.getTextLengthWithEmoji(str) > 14) {
                str = ad.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.eKc.setText(str + ":");
            if (TextUtils.isEmpty(this.Kn.aAq().user_info.portrait)) {
                this.ejV.setPlaceHolder(1);
            } else {
                this.ejV.startLoad(this.Kn.aAq().user_info.portrait, 10, false, false);
            }
        }
        String title = this.Kn.getTitle();
        if (!StringUtils.isNull(title)) {
            this.eKb.setText(title);
            this.eKb.setVisibility(0);
        } else {
            this.eKb.setVisibility(8);
        }
        pq(nL(1));
        if (this.Kn.aAq().mChallengeInfoData != null && this.Kn.aAq().mChallengeInfoData.challenge_id > 0) {
            this.eos.setVisibility(0);
        } else {
            this.eos.setVisibility(8);
        }
        this.mMaskView.setVisibility(com.baidu.tieba.frs.a.bBr().bBs() ? 0 : 8);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        mX();
    }

    private void mX() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eKd.getLayoutParams();
        if (this.mTextTitle.getVisibility() == 0) {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        } else {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
        }
        this.eKd.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.a.bBr().bBs()) {
            if (view == this.eJp || view == this.eJr.getCommentContainer() || this.eKa == view || view == this.eKe.deA.getCommentContainer()) {
                if (this.Kn != null) {
                    l.zC(this.Kn.getId());
                }
                if (bta() != null) {
                    bta().a(this.eJp, this.Kn);
                }
                TiebaStatic.log(new an("c12323"));
                int i = 5;
                if (this.Kn.aAq().live_status == 1) {
                    m(this.mTbPageContext);
                } else {
                    l(this.mTbPageContext);
                    i = 1;
                }
                if (view == this.eJr.getCommentContainer() || view == this.eKe.deA.getCommentContainer()) {
                    an anVar = new an("c12942");
                    anVar.Z("obj_locate", 2);
                    anVar.cp("tid", this.Kn.getTid());
                    anVar.Z("obj_type", i);
                    TiebaStatic.log(anVar);
                }
            } else if (view.getId() == R.id.video_container) {
                if (bta() != null) {
                    bta().a(view, this.Kn);
                }
                TiebaStatic.log(new an("c12323"));
                if (this.Kn.aAq().live_status == 1) {
                    m(this.mTbPageContext);
                } else {
                    l(this.mTbPageContext);
                }
            }
        }
    }

    private void l(TbPageContext<?> tbPageContext) {
        if (this.Kn != null && this.Kn.aAq() != null && this.Kn.aAq().share_info != null) {
            if (this.Kn.aAq().share_info.record_tid <= 0) {
                m(this.mTbPageContext);
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(this.Kn.aAq().share_info.record_tid), null, "frs_page");
            createNormalCfg.setVideo_source(this.Kn.aBe() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs");
            createNormalCfg.setFromSmartFrs(this.Kn.aBk());
            createNormalCfg.setSmartFrsPosition(this.Kn.aBp());
            createNormalCfg.setStartFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }

    public void m(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.Kn != null && this.Kn.aAq() != null) {
            if (!j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.Kn.aAq());
            if (this.Kn.aAq().user_info != null) {
                alaLiveInfoCoreData.userName = this.Kn.aAq().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, "frs_share_live", "", false, this.mForumName)));
        }
    }

    public void pq(int i) {
        if (this.Kn != null) {
            if (i == 1) {
                this.eJr.setVisibility(8);
                this.eKe.setData(this.Kn);
                return;
            }
            this.eJr.setData(this.Kn);
            this.eKe.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Lg = str;
    }

    public int nL(int i) {
        return com.baidu.tieba.a.d.aVo().ak(this.Lg, i);
    }

    public ThreadCommentAndPraiseInfoLayout beN() {
        return this.eJr;
    }

    public ThreadCommentAndPraiseInfoLayout beO() {
        if (this.eKe != null) {
            return this.eKe.deA;
        }
        return null;
    }
}
