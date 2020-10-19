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
    private CardUserInfoLayout afN;
    private bw agw;
    private String aht;
    private final View.OnClickListener ajF;
    private HeadImageView fWA;
    private RelativeLayout gAC;
    private ThreadCommentAndPraiseInfoLayout gAE;
    private View gAF;
    public AlaVideoContainer gAG;
    private LinearLayout gBm;
    private TextView gBn;
    private TextView gBo;
    private RelativeLayout gBp;
    private ThreadSourceShareAndPraiseLayout gBq;
    private LinearLayout gbe;
    private View mDivider;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ajF = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cil() != null) {
                    c.this.cil().a(view, c.this.agw);
                }
            }
        };
        setTag(bdUniqueId);
        View view = getView();
        this.gAC = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.gAC.setOnClickListener(this);
        this.gBm = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.gBm.setOnClickListener(this);
        this.gBp = (RelativeLayout) view.findViewById(R.id.ala_share_container);
        this.gbe = (LinearLayout) this.gBp.findViewById(R.id.challenge_root);
        this.afN = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.afN.setShowFlag(6141);
        this.fWA = (HeadImageView) view.findViewById(R.id.ala_share_live_user_pendant_header);
        this.fWA.setIsRound(true);
        this.fWA.setDrawBorder(false);
        this.fWA.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fWA.setAutoChangeStyle(false);
        this.gBo = (TextView) view.findViewById(R.id.ala_share_live_username_text);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gBn = (TextView) view.findViewById(R.id.ala_live_room_title);
        this.gAG = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.gAG.setOnVideoClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.gAE = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.gAE.setOnClickListener(this);
        this.gAE.setReplyTimeVisible(false);
        this.gAE.setShowPraiseNum(true);
        this.gAE.setNeedAddReplyIcon(true);
        this.gAE.setNeedAddPraiseIcon(true);
        this.gAE.setFrom(2);
        this.gAE.getCommentContainer().setOnClickListener(this);
        this.gAE.setShareVisible(true);
        this.gAE.setShareReportFrom(1);
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.ela = 2;
        cVar.elg = 2;
        this.gAE.setAgreeStatisticData(cVar);
        this.gBq = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.gBq.eJm.setOnClickListener(this);
        this.gBq.eJm.getCommentContainer().setOnClickListener(this);
        this.gBq.setFrom(2);
        this.gBq.setShareReportFrom(1);
        this.gBq.setSourceFromForPb(3);
        this.gBq.setStType("frs_page");
        this.gBq.setHideBarName(true);
        this.gAF = view.findViewById(R.id.divider_below_reply_number_layout);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.gAG.setLigvingLogLayoutVisible(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gAC, R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_b);
            ap.setBackgroundColor(this.gBp, R.color.cp_bg_line_c);
            if (this.gAG != null) {
                this.gAG.onChangeSkinType(i);
            }
            this.afN.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.gAE.onChangeSkinType();
            this.mSkinType = i;
            if (this.fWA != null) {
                this.fWA.setPlaceHolder(1);
            }
            if (this.gBq != null && this.gBq.getVisibility() == 0) {
                this.gBq.onChangeSkinType();
            }
        }
        if (this.agw != null && m.Ik(this.agw.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d);
            ap.setViewTextColor(this.gBn, R.color.cp_cont_d);
            ap.setViewTextColor(this.gBo, R.color.cp_cont_d);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b);
            ap.setViewTextColor(this.gBn, R.color.cp_cont_f);
            ap.setViewTextColor(this.gBo, R.color.cp_cont_b);
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
        this.agw = bwVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void ux(int i) {
    }

    private void refreshView() {
        if (this.agw == null || this.agw.bih() == null) {
            this.gAC.setVisibility(8);
            return;
        }
        this.gAC.setVisibility(0);
        this.afN.setData(this.agw);
        this.afN.setUserAfterClickListener(this.ajF);
        this.gAG.getController().a(this.agw, this.mForumName, "", false);
        this.gAG.getController().startPlayAnimation();
        if (this.agw.biB() != null && this.agw.biB().share_info != null && !StringUtils.isNull(this.agw.biB().share_info.content)) {
            this.mTextTitle.setVisibility(0);
            this.mTextTitle.setText(this.agw.biB().share_info.content);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (this.agw.biB() != null && this.agw.biB().user_info != null) {
            String str = this.agw.biB().user_info.user_name;
            if (af.getTextLengthWithEmoji(str) > 14) {
                str = af.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.gBo.setText(str + ":");
            if (TextUtils.isEmpty(this.agw.biB().user_info.portrait)) {
                this.fWA.setPlaceHolder(1);
            } else {
                this.fWA.startLoad(this.agw.biB().user_info.portrait, 10, false, false);
            }
        }
        String title = this.agw.getTitle();
        if (!StringUtils.isNull(title)) {
            this.gBn.setText(title);
            this.gBn.setVisibility(0);
        } else {
            this.gBn.setVisibility(8);
        }
        uz(sO(1));
        if (this.agw.biB().mChallengeInfoData != null && this.agw.biB().mChallengeInfoData.challenge_id > 0) {
            this.gbe.setVisibility(0);
        } else {
            this.gbe.setVisibility(8);
        }
        this.mMaskView.setVisibility((com.baidu.tieba.frs.b.crE().cry() || com.baidu.tieba.frs.a.crx().cry()) ? 0 : 8);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        ua();
    }

    private void ua() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gBp.getLayoutParams();
        if (this.mTextTitle.getVisibility() == 0) {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        } else {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
        }
        this.gBp.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.b.crE().cry() && !com.baidu.tieba.frs.a.crx().cry()) {
            if (view == this.gAC || view == this.gAE.getCommentContainer() || this.gBm == view || view == this.gBq.eJm.getCommentContainer()) {
                if (this.agw != null) {
                    m.Ij(this.agw.getId());
                }
                if (cil() != null) {
                    cil().a(this.gAC, this.agw);
                }
                TiebaStatic.log(new aq("c12323"));
                int i = 5;
                if (this.agw.biB().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                    i = 1;
                }
                if (view == this.gAE.getCommentContainer() || view == this.gBq.eJm.getCommentContainer()) {
                    aq aqVar = new aq("c12942");
                    aqVar.aj("obj_locate", 2);
                    aqVar.dK("tid", this.agw.getTid());
                    aqVar.aj("obj_type", i);
                    aqVar.dK("nid", this.agw.getNid());
                    TiebaStatic.log(aqVar);
                }
            } else if (view.getId() == R.id.video_container) {
                if (cil() != null) {
                    cil().a(view, this.agw);
                }
                TiebaStatic.log(new aq("c12323"));
                if (this.agw.biB().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                }
            }
        }
    }

    private void p(TbPageContext<?> tbPageContext) {
        if (this.agw != null && this.agw.biB() != null && this.agw.biB().share_info != null) {
            if (this.agw.biB().share_info.record_tid <= 0) {
                q(this.mTbPageContext);
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(this.agw.biB().share_info.record_tid), null, "frs_page");
            createNormalCfg.setVideo_source(this.agw.bjq() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs");
            createNormalCfg.setFromSmartFrs(this.agw.bjw());
            createNormalCfg.setSmartFrsPosition(this.agw.bjC());
            createNormalCfg.setStartFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }

    public void q(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.agw != null && this.agw.biB() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(tbPageContext.getPageActivity(), R.string.no_network_guide);
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.agw.biB());
            if (this.agw.biB().user_info != null) {
                alaLiveInfoCoreData.userName = this.agw.biB().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, "frs_share_live", "", false, this.mForumName)));
        }
    }

    public void uz(int i) {
        if (this.agw != null) {
            if (i == 1) {
                this.gAE.setVisibility(8);
                this.gBq.setData(this.agw);
                return;
            }
            this.gAE.setData(this.agw);
            this.gBq.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aht = str;
    }

    public int sO(int i) {
        return com.baidu.tieba.a.d.bEz().av(this.aht, i);
    }

    public ThreadCommentAndPraiseInfoLayout bQt() {
        return this.gAE;
    }

    public ThreadCommentAndPraiseInfoLayout bQu() {
        if (this.gBq != null) {
            return this.gBq.eJm;
        }
        return null;
    }
}
