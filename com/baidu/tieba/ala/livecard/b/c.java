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
    private LinearLayout eNU;
    private TextView eNV;
    private TextView eNW;
    private RelativeLayout eNX;
    private ThreadSourceShareAndPraiseLayout eNY;
    private RelativeLayout eNk;
    private ThreadCommentAndPraiseInfoLayout eNm;
    private View eNn;
    public AlaVideoContainer eNo;
    private HeadImageView eoh;
    private LinearLayout esD;
    private View mDivider;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.Nw = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.buG() != null) {
                    c.this.buG().a(view, c.this.KJ);
                }
            }
        };
        setTag(bdUniqueId);
        View view = getView();
        this.eNk = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.eNk.setOnClickListener(this);
        this.eNU = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.eNU.setOnClickListener(this);
        this.eNX = (RelativeLayout) view.findViewById(R.id.ala_share_container);
        this.esD = (LinearLayout) this.eNX.findViewById(R.id.challenge_root);
        this.Kj = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.Kj.setShowFlag(6141);
        this.eoh = (HeadImageView) view.findViewById(R.id.ala_share_live_user_pendant_header);
        this.eoh.setIsRound(true);
        this.eoh.setDrawBorder(false);
        this.eoh.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eoh.setAutoChangeStyle(false);
        this.eNW = (TextView) view.findViewById(R.id.ala_share_live_username_text);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.eNV = (TextView) view.findViewById(R.id.ala_live_room_title);
        this.eNo = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.eNo.setOnVideoClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.eNm = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.eNm.setOnClickListener(this);
        this.eNm.setReplyTimeVisible(false);
        this.eNm.setShowPraiseNum(true);
        this.eNm.setNeedAddReplyIcon(true);
        this.eNm.setNeedAddPraiseIcon(true);
        this.eNm.setFrom(2);
        this.eNm.getCommentContainer().setOnClickListener(this);
        this.eNm.setShareVisible(true);
        this.eNm.setShareReportFrom(1);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNB = 2;
        dVar.cNH = 2;
        this.eNm.setAgreeStatisticData(dVar);
        this.eNY = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.eNY.diH.setOnClickListener(this);
        this.eNY.diH.getCommentContainer().setOnClickListener(this);
        this.eNY.setFrom(2);
        this.eNY.setShareReportFrom(1);
        this.eNY.setSourceFromForPb(3);
        this.eNY.setStType("frs_page");
        this.eNY.setHideBarName(true);
        this.eNn = view.findViewById(R.id.divider_below_reply_number_layout);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.eNo.setLigvingLogLayoutVisible(8);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eNk, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.eNX, R.color.cp_bg_line_c);
            if (this.eNo != null) {
                this.eNo.onChangeSkinType(i);
            }
            this.Kj.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.eNm.onChangeSkinType();
            this.mSkinType = i;
            if (this.eoh != null) {
                this.eoh.setPlaceHolder(1);
            }
            if (this.eNY != null && this.eNY.getVisibility() == 0) {
                this.eNY.onChangeSkinType();
            }
        }
        if (this.KJ != null && l.zT(this.KJ.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eNV, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eNW, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eNV, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.eNW, (int) R.color.cp_cont_b);
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
        if (this.KJ == null || this.KJ.aCo() == null) {
            this.eNk.setVisibility(8);
            return;
        }
        this.eNk.setVisibility(0);
        this.Kj.setData(this.KJ);
        this.Kj.setUserAfterClickListener(this.Nw);
        this.eNo.getController().a(this.KJ, this.mForumName, "", false);
        this.eNo.getController().startPlayAnimation();
        if (this.KJ.aCH() != null && this.KJ.aCH().share_info != null && !StringUtils.isNull(this.KJ.aCH().share_info.content)) {
            this.mTextTitle.setVisibility(0);
            this.mTextTitle.setText(this.KJ.aCH().share_info.content);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (this.KJ.aCH() != null && this.KJ.aCH().user_info != null) {
            String str = this.KJ.aCH().user_info.user_name;
            if (ad.getTextLengthWithEmoji(str) > 14) {
                str = ad.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.eNW.setText(str + ":");
            if (TextUtils.isEmpty(this.KJ.aCH().user_info.portrait)) {
                this.eoh.setPlaceHolder(1);
            } else {
                this.eoh.startLoad(this.KJ.aCH().user_info.portrait, 10, false, false);
            }
        }
        String title = this.KJ.getTitle();
        if (!StringUtils.isNull(title)) {
            this.eNV.setText(title);
            this.eNV.setVisibility(0);
        } else {
            this.eNV.setVisibility(8);
        }
        pB(oc(1));
        if (this.KJ.aCH().mChallengeInfoData != null && this.KJ.aCH().mChallengeInfoData.challenge_id > 0) {
            this.esD.setVisibility(0);
        } else {
            this.esD.setVisibility(8);
        }
        this.mMaskView.setVisibility(com.baidu.tieba.frs.a.bCV().bCW() ? 0 : 8);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        nn();
    }

    private void nn() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNX.getLayoutParams();
        if (this.mTextTitle.getVisibility() == 0) {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        } else {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
        }
        this.eNX.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.a.bCV().bCW()) {
            if (view == this.eNk || view == this.eNm.getCommentContainer() || this.eNU == view || view == this.eNY.diH.getCommentContainer()) {
                if (this.KJ != null) {
                    l.zS(this.KJ.getId());
                }
                if (buG() != null) {
                    buG().a(this.eNk, this.KJ);
                }
                TiebaStatic.log(new an("c12323"));
                int i = 5;
                if (this.KJ.aCH().live_status == 1) {
                    m(this.mTbPageContext);
                } else {
                    l(this.mTbPageContext);
                    i = 1;
                }
                if (view == this.eNm.getCommentContainer() || view == this.eNY.diH.getCommentContainer()) {
                    an anVar = new an("c12942");
                    anVar.X("obj_locate", 2);
                    anVar.cy("tid", this.KJ.getTid());
                    anVar.X("obj_type", i);
                    TiebaStatic.log(anVar);
                }
            } else if (view.getId() == R.id.video_container) {
                if (buG() != null) {
                    buG().a(view, this.KJ);
                }
                TiebaStatic.log(new an("c12323"));
                if (this.KJ.aCH().live_status == 1) {
                    m(this.mTbPageContext);
                } else {
                    l(this.mTbPageContext);
                }
            }
        }
    }

    private void l(TbPageContext<?> tbPageContext) {
        if (this.KJ != null && this.KJ.aCH() != null && this.KJ.aCH().share_info != null) {
            if (this.KJ.aCH().share_info.record_tid <= 0) {
                m(this.mTbPageContext);
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(this.KJ.aCH().share_info.record_tid), null, "frs_page");
            createNormalCfg.setVideo_source(this.KJ.aDt() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs");
            createNormalCfg.setFromSmartFrs(this.KJ.aDz());
            createNormalCfg.setSmartFrsPosition(this.KJ.aDE());
            createNormalCfg.setStartFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }

    public void m(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.KJ != null && this.KJ.aCH() != null) {
            if (!j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.KJ.aCH());
            if (this.KJ.aCH().user_info != null) {
                alaLiveInfoCoreData.userName = this.KJ.aCH().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, "frs_share_live", "", false, this.mForumName)));
        }
    }

    public void pB(int i) {
        if (this.KJ != null) {
            if (i == 1) {
                this.eNm.setVisibility(8);
                this.eNY.setData(this.KJ);
                return;
            }
            this.eNm.setData(this.KJ);
            this.eNY.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oc(int i) {
        return com.baidu.tieba.a.d.aXF().ai(this.LC, i);
    }

    public ThreadCommentAndPraiseInfoLayout bgZ() {
        return this.eNm;
    }

    public ThreadCommentAndPraiseInfoLayout bha() {
        if (this.eNY != null) {
            return this.eNY.diH;
        }
        return null;
    }
}
