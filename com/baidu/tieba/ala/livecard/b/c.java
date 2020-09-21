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
import com.baidu.tbadk.util.af;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.y;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.b<bw> implements com.baidu.tieba.a.e, y {
    private CardUserInfoLayout afw;
    private bw agf;
    private String ahc;
    private final View.OnClickListener ajn;
    private HeadImageView fKj;
    private LinearLayout fOM;
    private LinearLayout gmT;
    private TextView gmU;
    private TextView gmV;
    private RelativeLayout gmW;
    private ThreadSourceShareAndPraiseLayout gmX;
    private RelativeLayout gmj;
    private ThreadCommentAndPraiseInfoLayout gml;
    private View gmm;
    public AlaVideoContainer gmn;
    private View mDivider;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ajn = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ceP() != null) {
                    c.this.ceP().a(view, c.this.agf);
                }
            }
        };
        setTag(bdUniqueId);
        View view = getView();
        this.gmj = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.gmj.setOnClickListener(this);
        this.gmT = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.gmT.setOnClickListener(this);
        this.gmW = (RelativeLayout) view.findViewById(R.id.ala_share_container);
        this.fOM = (LinearLayout) this.gmW.findViewById(R.id.challenge_root);
        this.afw = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.afw.setShowFlag(6141);
        this.fKj = (HeadImageView) view.findViewById(R.id.ala_share_live_user_pendant_header);
        this.fKj.setIsRound(true);
        this.fKj.setDrawBorder(false);
        this.fKj.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fKj.setAutoChangeStyle(false);
        this.gmV = (TextView) view.findViewById(R.id.ala_share_live_username_text);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gmU = (TextView) view.findViewById(R.id.ala_live_room_title);
        this.gmn = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.gmn.setOnVideoClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.gml = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.gml.setOnClickListener(this);
        this.gml.setReplyTimeVisible(false);
        this.gml.setShowPraiseNum(true);
        this.gml.setNeedAddReplyIcon(true);
        this.gml.setNeedAddPraiseIcon(true);
        this.gml.setFrom(2);
        this.gml.getCommentContainer().setOnClickListener(this);
        this.gml.setShareVisible(true);
        this.gml.setShareReportFrom(1);
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dYY = 2;
        cVar.dZe = 2;
        this.gml.setAgreeStatisticData(cVar);
        this.gmX = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.gmX.exc.setOnClickListener(this);
        this.gmX.exc.getCommentContainer().setOnClickListener(this);
        this.gmX.setFrom(2);
        this.gmX.setShareReportFrom(1);
        this.gmX.setSourceFromForPb(3);
        this.gmX.setStType("frs_page");
        this.gmX.setHideBarName(true);
        this.gmm = view.findViewById(R.id.divider_below_reply_number_layout);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.gmn.setLigvingLogLayoutVisible(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gmj, R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_b);
            ap.setBackgroundColor(this.gmW, R.color.cp_bg_line_c);
            if (this.gmn != null) {
                this.gmn.onChangeSkinType(i);
            }
            this.afw.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.gml.onChangeSkinType();
            this.mSkinType = i;
            if (this.fKj != null) {
                this.fKj.setPlaceHolder(1);
            }
            if (this.gmX != null && this.gmX.getVisibility() == 0) {
                this.gmX.onChangeSkinType();
            }
        }
        if (this.agf != null && m.Hx(this.agf.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d);
            ap.setViewTextColor(this.gmU, R.color.cp_cont_d);
            ap.setViewTextColor(this.gmV, R.color.cp_cont_d);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b);
            ap.setViewTextColor(this.gmU, R.color.cp_cont_f);
            ap.setViewTextColor(this.gmV, R.color.cp_cont_b);
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
        this.agf = bwVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void tS(int i) {
    }

    private void refreshView() {
        if (this.agf == null || this.agf.bfy() == null) {
            this.gmj.setVisibility(8);
            return;
        }
        this.gmj.setVisibility(0);
        this.afw.setData(this.agf);
        this.afw.setUserAfterClickListener(this.ajn);
        this.gmn.getController().a(this.agf, this.mForumName, "", false);
        this.gmn.getController().startPlayAnimation();
        if (this.agf.bfS() != null && this.agf.bfS().share_info != null && !StringUtils.isNull(this.agf.bfS().share_info.content)) {
            this.mTextTitle.setVisibility(0);
            this.mTextTitle.setText(this.agf.bfS().share_info.content);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (this.agf.bfS() != null && this.agf.bfS().user_info != null) {
            String str = this.agf.bfS().user_info.user_name;
            if (af.getTextLengthWithEmoji(str) > 14) {
                str = af.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.gmV.setText(str + ":");
            if (TextUtils.isEmpty(this.agf.bfS().user_info.portrait)) {
                this.fKj.setPlaceHolder(1);
            } else {
                this.fKj.startLoad(this.agf.bfS().user_info.portrait, 10, false, false);
            }
        }
        String title = this.agf.getTitle();
        if (!StringUtils.isNull(title)) {
            this.gmU.setText(title);
            this.gmU.setVisibility(0);
        } else {
            this.gmU.setVisibility(8);
        }
        tU(sq(1));
        if (this.agf.bfS().mChallengeInfoData != null && this.agf.bfS().mChallengeInfoData.challenge_id > 0) {
            this.fOM.setVisibility(0);
        } else {
            this.fOM.setVisibility(8);
        }
        this.mMaskView.setVisibility((com.baidu.tieba.frs.b.cog().coa() || com.baidu.tieba.frs.a.cnZ().coa()) ? 0 : 8);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        ua();
    }

    private void ua() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gmW.getLayoutParams();
        if (this.mTextTitle.getVisibility() == 0) {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        } else {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
        }
        this.gmW.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.b.cog().coa() && !com.baidu.tieba.frs.a.cnZ().coa()) {
            if (view == this.gmj || view == this.gml.getCommentContainer() || this.gmT == view || view == this.gmX.exc.getCommentContainer()) {
                if (this.agf != null) {
                    m.Hw(this.agf.getId());
                }
                if (ceP() != null) {
                    ceP().a(this.gmj, this.agf);
                }
                TiebaStatic.log(new aq("c12323"));
                int i = 5;
                if (this.agf.bfS().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                    i = 1;
                }
                if (view == this.gml.getCommentContainer() || view == this.gmX.exc.getCommentContainer()) {
                    aq aqVar = new aq("c12942");
                    aqVar.ai("obj_locate", 2);
                    aqVar.dF("tid", this.agf.getTid());
                    aqVar.ai("obj_type", i);
                    aqVar.dF("nid", this.agf.getNid());
                    TiebaStatic.log(aqVar);
                }
            } else if (view.getId() == R.id.video_container) {
                if (ceP() != null) {
                    ceP().a(view, this.agf);
                }
                TiebaStatic.log(new aq("c12323"));
                if (this.agf.bfS().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                }
            }
        }
    }

    private void p(TbPageContext<?> tbPageContext) {
        if (this.agf != null && this.agf.bfS() != null && this.agf.bfS().share_info != null) {
            if (this.agf.bfS().share_info.record_tid <= 0) {
                q(this.mTbPageContext);
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(this.agf.bfS().share_info.record_tid), null, "frs_page");
            createNormalCfg.setVideo_source(this.agf.bgH() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs");
            createNormalCfg.setFromSmartFrs(this.agf.bgN());
            createNormalCfg.setSmartFrsPosition(this.agf.bgT());
            createNormalCfg.setStartFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }

    public void q(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.agf != null && this.agf.bfS() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(tbPageContext.getPageActivity(), R.string.no_network_guide);
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.agf.bfS());
            if (this.agf.bfS().user_info != null) {
                alaLiveInfoCoreData.userName = this.agf.bfS().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, "frs_share_live", "", false, this.mForumName)));
        }
    }

    public void tU(int i) {
        if (this.agf != null) {
            if (i == 1) {
                this.gml.setVisibility(8);
                this.gmX.setData(this.agf);
                return;
            }
            this.gml.setData(this.agf);
            this.gmX.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahc = str;
    }

    public int sq(int i) {
        return com.baidu.tieba.a.d.bBN().au(this.ahc, i);
    }

    public ThreadCommentAndPraiseInfoLayout bNc() {
        return this.gml;
    }

    public ThreadCommentAndPraiseInfoLayout bNd() {
        if (this.gmX != null) {
            return this.gmX.exc;
        }
        return null;
    }
}
