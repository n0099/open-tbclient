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
    private bj KJ;
    private CardUserInfoLayout Kj;
    private String LC;
    private final View.OnClickListener Nw;
    private LinearLayout eNT;
    private TextView eNU;
    private TextView eNV;
    private RelativeLayout eNW;
    private ThreadSourceShareAndPraiseLayout eNX;
    private RelativeLayout eNj;
    private ThreadCommentAndPraiseInfoLayout eNl;
    private View eNm;
    public AlaVideoContainer eNn;
    private HeadImageView eog;
    private LinearLayout esC;
    private View mDivider;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.Nw = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.buE() != null) {
                    c.this.buE().a(view, c.this.KJ);
                }
            }
        };
        setTag(bdUniqueId);
        View view = getView();
        this.eNj = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.eNj.setOnClickListener(this);
        this.eNT = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.eNT.setOnClickListener(this);
        this.eNW = (RelativeLayout) view.findViewById(R.id.ala_share_container);
        this.esC = (LinearLayout) this.eNW.findViewById(R.id.challenge_root);
        this.Kj = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.Kj.setShowFlag(6141);
        this.eog = (HeadImageView) view.findViewById(R.id.ala_share_live_user_pendant_header);
        this.eog.setIsRound(true);
        this.eog.setDrawBorder(false);
        this.eog.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eog.setAutoChangeStyle(false);
        this.eNV = (TextView) view.findViewById(R.id.ala_share_live_username_text);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.eNU = (TextView) view.findViewById(R.id.ala_live_room_title);
        this.eNn = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.eNn.setOnVideoClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.eNl = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.eNl.setOnClickListener(this);
        this.eNl.setReplyTimeVisible(false);
        this.eNl.setShowPraiseNum(true);
        this.eNl.setNeedAddReplyIcon(true);
        this.eNl.setNeedAddPraiseIcon(true);
        this.eNl.setFrom(2);
        this.eNl.getCommentContainer().setOnClickListener(this);
        this.eNl.setShareVisible(true);
        this.eNl.setShareReportFrom(1);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNA = 2;
        dVar.cNG = 2;
        this.eNl.setAgreeStatisticData(dVar);
        this.eNX = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.eNX.diG.setOnClickListener(this);
        this.eNX.diG.getCommentContainer().setOnClickListener(this);
        this.eNX.setFrom(2);
        this.eNX.setShareReportFrom(1);
        this.eNX.setSourceFromForPb(3);
        this.eNX.setStType("frs_page");
        this.eNX.setHideBarName(true);
        this.eNm = view.findViewById(R.id.divider_below_reply_number_layout);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.eNn.setLigvingLogLayoutVisible(8);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eNj, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.eNW, R.color.cp_bg_line_c);
            if (this.eNn != null) {
                this.eNn.onChangeSkinType(i);
            }
            this.Kj.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.eNl.onChangeSkinType();
            this.mSkinType = i;
            if (this.eog != null) {
                this.eog.setPlaceHolder(1);
            }
            if (this.eNX != null && this.eNX.getVisibility() == 0) {
                this.eNX.onChangeSkinType();
            }
        }
        if (this.KJ != null && l.zT(this.KJ.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eNU, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eNV, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eNU, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.eNV, (int) R.color.cp_cont_b);
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
        this.KJ = bjVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pz(int i) {
    }

    private void refreshView() {
        if (this.KJ == null || this.KJ.aCm() == null) {
            this.eNj.setVisibility(8);
            return;
        }
        this.eNj.setVisibility(0);
        this.Kj.setData(this.KJ);
        this.Kj.setUserAfterClickListener(this.Nw);
        this.eNn.getController().a(this.KJ, this.mForumName, "", false);
        this.eNn.getController().startPlayAnimation();
        if (this.KJ.aCF() != null && this.KJ.aCF().share_info != null && !StringUtils.isNull(this.KJ.aCF().share_info.content)) {
            this.mTextTitle.setVisibility(0);
            this.mTextTitle.setText(this.KJ.aCF().share_info.content);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (this.KJ.aCF() != null && this.KJ.aCF().user_info != null) {
            String str = this.KJ.aCF().user_info.user_name;
            if (ad.getTextLengthWithEmoji(str) > 14) {
                str = ad.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.eNV.setText(str + ":");
            if (TextUtils.isEmpty(this.KJ.aCF().user_info.portrait)) {
                this.eog.setPlaceHolder(1);
            } else {
                this.eog.startLoad(this.KJ.aCF().user_info.portrait, 10, false, false);
            }
        }
        String title = this.KJ.getTitle();
        if (!StringUtils.isNull(title)) {
            this.eNU.setText(title);
            this.eNU.setVisibility(0);
        } else {
            this.eNU.setVisibility(8);
        }
        pB(oc(1));
        if (this.KJ.aCF().mChallengeInfoData != null && this.KJ.aCF().mChallengeInfoData.challenge_id > 0) {
            this.esC.setVisibility(0);
        } else {
            this.esC.setVisibility(8);
        }
        this.mMaskView.setVisibility(com.baidu.tieba.frs.a.bCT().bCU() ? 0 : 8);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        nn();
    }

    private void nn() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNW.getLayoutParams();
        if (this.mTextTitle.getVisibility() == 0) {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        } else {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
        }
        this.eNW.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.a.bCT().bCU()) {
            if (view == this.eNj || view == this.eNl.getCommentContainer() || this.eNT == view || view == this.eNX.diG.getCommentContainer()) {
                if (this.KJ != null) {
                    l.zS(this.KJ.getId());
                }
                if (buE() != null) {
                    buE().a(this.eNj, this.KJ);
                }
                TiebaStatic.log(new an("c12323"));
                int i = 5;
                if (this.KJ.aCF().live_status == 1) {
                    m(this.mTbPageContext);
                } else {
                    l(this.mTbPageContext);
                    i = 1;
                }
                if (view == this.eNl.getCommentContainer() || view == this.eNX.diG.getCommentContainer()) {
                    an anVar = new an("c12942");
                    anVar.X("obj_locate", 2);
                    anVar.cy("tid", this.KJ.getTid());
                    anVar.X("obj_type", i);
                    TiebaStatic.log(anVar);
                }
            } else if (view.getId() == R.id.video_container) {
                if (buE() != null) {
                    buE().a(view, this.KJ);
                }
                TiebaStatic.log(new an("c12323"));
                if (this.KJ.aCF().live_status == 1) {
                    m(this.mTbPageContext);
                } else {
                    l(this.mTbPageContext);
                }
            }
        }
    }

    private void l(TbPageContext<?> tbPageContext) {
        if (this.KJ != null && this.KJ.aCF() != null && this.KJ.aCF().share_info != null) {
            if (this.KJ.aCF().share_info.record_tid <= 0) {
                m(this.mTbPageContext);
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(this.KJ.aCF().share_info.record_tid), null, "frs_page");
            createNormalCfg.setVideo_source(this.KJ.aDr() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs");
            createNormalCfg.setFromSmartFrs(this.KJ.aDx());
            createNormalCfg.setSmartFrsPosition(this.KJ.aDC());
            createNormalCfg.setStartFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }

    public void m(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.KJ != null && this.KJ.aCF() != null) {
            if (!j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.KJ.aCF());
            if (this.KJ.aCF().user_info != null) {
                alaLiveInfoCoreData.userName = this.KJ.aCF().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, "frs_share_live", "", false, this.mForumName)));
        }
    }

    public void pB(int i) {
        if (this.KJ != null) {
            if (i == 1) {
                this.eNl.setVisibility(8);
                this.eNX.setData(this.KJ);
                return;
            }
            this.eNl.setData(this.KJ);
            this.eNX.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oc(int i) {
        return com.baidu.tieba.a.d.aXD().ai(this.LC, i);
    }

    public ThreadCommentAndPraiseInfoLayout bgX() {
        return this.eNl;
    }

    public ThreadCommentAndPraiseInfoLayout bgY() {
        if (this.eNX != null) {
            return this.eNX.diG;
        }
        return null;
    }
}
