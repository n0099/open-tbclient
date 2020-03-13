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
    private View eNA;
    public AlaVideoContainer eNB;
    private RelativeLayout eNx;
    private ThreadCommentAndPraiseInfoLayout eNz;
    private LinearLayout eOh;
    private TextView eOi;
    private TextView eOj;
    private RelativeLayout eOk;
    private ThreadSourceShareAndPraiseLayout eOl;
    private HeadImageView eou;
    private LinearLayout esQ;
    private View mDivider;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.Nw = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.buH() != null) {
                    c.this.buH().a(view, c.this.KJ);
                }
            }
        };
        setTag(bdUniqueId);
        View view = getView();
        this.eNx = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.eNx.setOnClickListener(this);
        this.eOh = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.eOh.setOnClickListener(this);
        this.eOk = (RelativeLayout) view.findViewById(R.id.ala_share_container);
        this.esQ = (LinearLayout) this.eOk.findViewById(R.id.challenge_root);
        this.Kj = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.Kj.setShowFlag(6141);
        this.eou = (HeadImageView) view.findViewById(R.id.ala_share_live_user_pendant_header);
        this.eou.setIsRound(true);
        this.eou.setDrawBorder(false);
        this.eou.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eou.setAutoChangeStyle(false);
        this.eOj = (TextView) view.findViewById(R.id.ala_share_live_username_text);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.eOi = (TextView) view.findViewById(R.id.ala_live_room_title);
        this.eNB = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.eNB.setOnVideoClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.eNz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.eNz.setOnClickListener(this);
        this.eNz.setReplyTimeVisible(false);
        this.eNz.setShowPraiseNum(true);
        this.eNz.setNeedAddReplyIcon(true);
        this.eNz.setNeedAddPraiseIcon(true);
        this.eNz.setFrom(2);
        this.eNz.getCommentContainer().setOnClickListener(this);
        this.eNz.setShareVisible(true);
        this.eNz.setShareReportFrom(1);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNC = 2;
        dVar.cNI = 2;
        this.eNz.setAgreeStatisticData(dVar);
        this.eOl = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.eOl.diU.setOnClickListener(this);
        this.eOl.diU.getCommentContainer().setOnClickListener(this);
        this.eOl.setFrom(2);
        this.eOl.setShareReportFrom(1);
        this.eOl.setSourceFromForPb(3);
        this.eOl.setStType("frs_page");
        this.eOl.setHideBarName(true);
        this.eNA = view.findViewById(R.id.divider_below_reply_number_layout);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.eNB.setLigvingLogLayoutVisible(8);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eNx, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.eOk, R.color.cp_bg_line_c);
            if (this.eNB != null) {
                this.eNB.onChangeSkinType(i);
            }
            this.Kj.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.eNz.onChangeSkinType();
            this.mSkinType = i;
            if (this.eou != null) {
                this.eou.setPlaceHolder(1);
            }
            if (this.eOl != null && this.eOl.getVisibility() == 0) {
                this.eOl.onChangeSkinType();
            }
        }
        if (this.KJ != null && l.zU(this.KJ.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eOi, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eOj, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eOi, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.eOj, (int) R.color.cp_cont_b);
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
            this.eNx.setVisibility(8);
            return;
        }
        this.eNx.setVisibility(0);
        this.Kj.setData(this.KJ);
        this.Kj.setUserAfterClickListener(this.Nw);
        this.eNB.getController().a(this.KJ, this.mForumName, "", false);
        this.eNB.getController().startPlayAnimation();
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
            this.eOj.setText(str + ":");
            if (TextUtils.isEmpty(this.KJ.aCH().user_info.portrait)) {
                this.eou.setPlaceHolder(1);
            } else {
                this.eou.startLoad(this.KJ.aCH().user_info.portrait, 10, false, false);
            }
        }
        String title = this.KJ.getTitle();
        if (!StringUtils.isNull(title)) {
            this.eOi.setText(title);
            this.eOi.setVisibility(0);
        } else {
            this.eOi.setVisibility(8);
        }
        pB(oc(1));
        if (this.KJ.aCH().mChallengeInfoData != null && this.KJ.aCH().mChallengeInfoData.challenge_id > 0) {
            this.esQ.setVisibility(0);
        } else {
            this.esQ.setVisibility(8);
        }
        this.mMaskView.setVisibility(com.baidu.tieba.frs.a.bCW().bCX() ? 0 : 8);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        nn();
    }

    private void nn() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eOk.getLayoutParams();
        if (this.mTextTitle.getVisibility() == 0) {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        } else {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
        }
        this.eOk.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.a.bCW().bCX()) {
            if (view == this.eNx || view == this.eNz.getCommentContainer() || this.eOh == view || view == this.eOl.diU.getCommentContainer()) {
                if (this.KJ != null) {
                    l.zT(this.KJ.getId());
                }
                if (buH() != null) {
                    buH().a(this.eNx, this.KJ);
                }
                TiebaStatic.log(new an("c12323"));
                int i = 5;
                if (this.KJ.aCH().live_status == 1) {
                    m(this.mTbPageContext);
                } else {
                    l(this.mTbPageContext);
                    i = 1;
                }
                if (view == this.eNz.getCommentContainer() || view == this.eOl.diU.getCommentContainer()) {
                    an anVar = new an("c12942");
                    anVar.X("obj_locate", 2);
                    anVar.cy("tid", this.KJ.getTid());
                    anVar.X("obj_type", i);
                    TiebaStatic.log(anVar);
                }
            } else if (view.getId() == R.id.video_container) {
                if (buH() != null) {
                    buH().a(view, this.KJ);
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
                this.eNz.setVisibility(8);
                this.eOl.setData(this.KJ);
                return;
            }
            this.eNz.setData(this.KJ);
            this.eOl.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oc(int i) {
        return com.baidu.tieba.a.d.aXG().ai(this.LC, i);
    }

    public ThreadCommentAndPraiseInfoLayout bha() {
        return this.eNz;
    }

    public ThreadCommentAndPraiseInfoLayout bhb() {
        if (this.eOl != null) {
            return this.eOl.diU;
        }
        return null;
    }
}
