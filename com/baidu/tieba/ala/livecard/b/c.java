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
    private final View.OnClickListener Nx;
    private RelativeLayout eNV;
    private ThreadCommentAndPraiseInfoLayout eNX;
    private View eNY;
    public AlaVideoContainer eNZ;
    private LinearLayout eOF;
    private TextView eOG;
    private TextView eOH;
    private RelativeLayout eOI;
    private ThreadSourceShareAndPraiseLayout eOJ;
    private HeadImageView eoL;
    private LinearLayout etn;
    private View mDivider;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.Nx = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.buM() != null) {
                    c.this.buM().a(view, c.this.KJ);
                }
            }
        };
        setTag(bdUniqueId);
        View view = getView();
        this.eNV = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.eNV.setOnClickListener(this);
        this.eOF = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.eOF.setOnClickListener(this);
        this.eOI = (RelativeLayout) view.findViewById(R.id.ala_share_container);
        this.etn = (LinearLayout) this.eOI.findViewById(R.id.challenge_root);
        this.Kj = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.Kj.setShowFlag(6141);
        this.eoL = (HeadImageView) view.findViewById(R.id.ala_share_live_user_pendant_header);
        this.eoL.setIsRound(true);
        this.eoL.setDrawBorder(false);
        this.eoL.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eoL.setAutoChangeStyle(false);
        this.eOH = (TextView) view.findViewById(R.id.ala_share_live_username_text);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.eOG = (TextView) view.findViewById(R.id.ala_live_room_title);
        this.eNZ = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.eNZ.setOnVideoClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.eNX = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.eNX.setOnClickListener(this);
        this.eNX.setReplyTimeVisible(false);
        this.eNX.setShowPraiseNum(true);
        this.eNX.setNeedAddReplyIcon(true);
        this.eNX.setNeedAddPraiseIcon(true);
        this.eNX.setFrom(2);
        this.eNX.getCommentContainer().setOnClickListener(this);
        this.eNX.setShareVisible(true);
        this.eNX.setShareReportFrom(1);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNP = 2;
        dVar.cNV = 2;
        this.eNX.setAgreeStatisticData(dVar);
        this.eOJ = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.eOJ.djh.setOnClickListener(this);
        this.eOJ.djh.getCommentContainer().setOnClickListener(this);
        this.eOJ.setFrom(2);
        this.eOJ.setShareReportFrom(1);
        this.eOJ.setSourceFromForPb(3);
        this.eOJ.setStType("frs_page");
        this.eOJ.setHideBarName(true);
        this.eNY = view.findViewById(R.id.divider_below_reply_number_layout);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.eNZ.setLigvingLogLayoutVisible(8);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eNV, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.eOI, R.color.cp_bg_line_c);
            if (this.eNZ != null) {
                this.eNZ.onChangeSkinType(i);
            }
            this.Kj.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.eNX.onChangeSkinType();
            this.mSkinType = i;
            if (this.eoL != null) {
                this.eoL.setPlaceHolder(1);
            }
            if (this.eOJ != null && this.eOJ.getVisibility() == 0) {
                this.eOJ.onChangeSkinType();
            }
        }
        if (this.KJ != null && l.zW(this.KJ.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eOG, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eOH, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eOG, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.eOH, (int) R.color.cp_cont_b);
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
    public void pB(int i) {
    }

    private void refreshView() {
        if (this.KJ == null || this.KJ.aCr() == null) {
            this.eNV.setVisibility(8);
            return;
        }
        this.eNV.setVisibility(0);
        this.Kj.setData(this.KJ);
        this.Kj.setUserAfterClickListener(this.Nx);
        this.eNZ.getController().a(this.KJ, this.mForumName, "", false);
        this.eNZ.getController().startPlayAnimation();
        if (this.KJ.aCK() != null && this.KJ.aCK().share_info != null && !StringUtils.isNull(this.KJ.aCK().share_info.content)) {
            this.mTextTitle.setVisibility(0);
            this.mTextTitle.setText(this.KJ.aCK().share_info.content);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (this.KJ.aCK() != null && this.KJ.aCK().user_info != null) {
            String str = this.KJ.aCK().user_info.user_name;
            if (ad.getTextLengthWithEmoji(str) > 14) {
                str = ad.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.eOH.setText(str + ":");
            if (TextUtils.isEmpty(this.KJ.aCK().user_info.portrait)) {
                this.eoL.setPlaceHolder(1);
            } else {
                this.eoL.startLoad(this.KJ.aCK().user_info.portrait, 10, false, false);
            }
        }
        String title = this.KJ.getTitle();
        if (!StringUtils.isNull(title)) {
            this.eOG.setText(title);
            this.eOG.setVisibility(0);
        } else {
            this.eOG.setVisibility(8);
        }
        pD(oe(1));
        if (this.KJ.aCK().mChallengeInfoData != null && this.KJ.aCK().mChallengeInfoData.challenge_id > 0) {
            this.etn.setVisibility(0);
        } else {
            this.etn.setVisibility(8);
        }
        this.mMaskView.setVisibility(com.baidu.tieba.frs.a.bDd().bDe() ? 0 : 8);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        nn();
    }

    private void nn() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eOI.getLayoutParams();
        if (this.mTextTitle.getVisibility() == 0) {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        } else {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
        }
        this.eOI.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.a.bDd().bDe()) {
            if (view == this.eNV || view == this.eNX.getCommentContainer() || this.eOF == view || view == this.eOJ.djh.getCommentContainer()) {
                if (this.KJ != null) {
                    l.zV(this.KJ.getId());
                }
                if (buM() != null) {
                    buM().a(this.eNV, this.KJ);
                }
                TiebaStatic.log(new an("c12323"));
                int i = 5;
                if (this.KJ.aCK().live_status == 1) {
                    n(this.mTbPageContext);
                } else {
                    m(this.mTbPageContext);
                    i = 1;
                }
                if (view == this.eNX.getCommentContainer() || view == this.eOJ.djh.getCommentContainer()) {
                    an anVar = new an("c12942");
                    anVar.X("obj_locate", 2);
                    anVar.cx("tid", this.KJ.getTid());
                    anVar.X("obj_type", i);
                    TiebaStatic.log(anVar);
                }
            } else if (view.getId() == R.id.video_container) {
                if (buM() != null) {
                    buM().a(view, this.KJ);
                }
                TiebaStatic.log(new an("c12323"));
                if (this.KJ.aCK().live_status == 1) {
                    n(this.mTbPageContext);
                } else {
                    m(this.mTbPageContext);
                }
            }
        }
    }

    private void m(TbPageContext<?> tbPageContext) {
        if (this.KJ != null && this.KJ.aCK() != null && this.KJ.aCK().share_info != null) {
            if (this.KJ.aCK().share_info.record_tid <= 0) {
                n(this.mTbPageContext);
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(this.KJ.aCK().share_info.record_tid), null, "frs_page");
            createNormalCfg.setVideo_source(this.KJ.aDx() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs");
            createNormalCfg.setFromSmartFrs(this.KJ.aDD());
            createNormalCfg.setSmartFrsPosition(this.KJ.aDI());
            createNormalCfg.setStartFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }

    public void n(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.KJ != null && this.KJ.aCK() != null) {
            if (!j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.KJ.aCK());
            if (this.KJ.aCK().user_info != null) {
                alaLiveInfoCoreData.userName = this.KJ.aCK().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, "frs_share_live", "", false, this.mForumName)));
        }
    }

    public void pD(int i) {
        if (this.KJ != null) {
            if (i == 1) {
                this.eNX.setVisibility(8);
                this.eOJ.setData(this.KJ);
                return;
            }
            this.eNX.setData(this.KJ);
            this.eOJ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oe(int i) {
        return com.baidu.tieba.a.d.aXK().ai(this.LC, i);
    }

    public ThreadCommentAndPraiseInfoLayout bhf() {
        return this.eNX;
    }

    public ThreadCommentAndPraiseInfoLayout bhg() {
        if (this.eOJ != null) {
            return this.eOJ.djh;
        }
        return null;
    }
}
