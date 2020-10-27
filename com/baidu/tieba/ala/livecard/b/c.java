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
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.z;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.b<bw> implements com.baidu.tieba.a.e, z {
    private CardUserInfoLayout afO;
    private bw agx;
    private String ahu;
    private final View.OnClickListener ajG;
    private RelativeLayout gMq;
    private ThreadCommentAndPraiseInfoLayout gMs;
    private View gMt;
    public AlaVideoContainer gMu;
    private LinearLayout gNa;
    private TextView gNb;
    private TextView gNc;
    private RelativeLayout gNd;
    private ThreadSourceShareAndPraiseLayout gNe;
    private HeadImageView ggE;
    private LinearLayout gli;
    private View mDivider;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ajG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cls() != null) {
                    c.this.cls().a(view, c.this.agx);
                }
            }
        };
        setTag(bdUniqueId);
        View view = getView();
        this.gMq = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.gMq.setOnClickListener(this);
        this.gNa = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.gNa.setOnClickListener(this);
        this.gNd = (RelativeLayout) view.findViewById(R.id.ala_share_container);
        this.gli = (LinearLayout) this.gNd.findViewById(R.id.challenge_root);
        this.afO = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.afO.setShowFlag(6141);
        this.ggE = (HeadImageView) view.findViewById(R.id.ala_share_live_user_pendant_header);
        this.ggE.setIsRound(true);
        this.ggE.setDrawBorder(false);
        this.ggE.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ggE.setAutoChangeStyle(false);
        this.gNc = (TextView) view.findViewById(R.id.ala_share_live_username_text);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gNb = (TextView) view.findViewById(R.id.ala_live_room_title);
        this.gMu = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.gMu.setOnVideoClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.gMs = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.gMs.setOnClickListener(this);
        this.gMs.setReplyTimeVisible(false);
        this.gMs.setShowPraiseNum(true);
        this.gMs.setNeedAddReplyIcon(true);
        this.gMs.setNeedAddPraiseIcon(true);
        this.gMs.setFrom(2);
        this.gMs.getCommentContainer().setOnClickListener(this);
        this.gMs.setShareVisible(true);
        this.gMs.setShareReportFrom(1);
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.etA = 2;
        cVar.etG = 2;
        this.gMs.setAgreeStatisticData(cVar);
        this.gNe = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.gNe.eRI.setOnClickListener(this);
        this.gNe.eRI.getCommentContainer().setOnClickListener(this);
        this.gNe.setFrom(2);
        this.gNe.setShareReportFrom(1);
        this.gNe.setSourceFromForPb(3);
        this.gNe.setStType("frs_page");
        this.gNe.setHideBarName(true);
        this.gMt = view.findViewById(R.id.divider_below_reply_number_layout);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.gMu.setLigvingLogLayoutVisible(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gMq, R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_b);
            ap.setBackgroundColor(this.gNd, R.color.cp_bg_line_c);
            if (this.gMu != null) {
                this.gMu.onChangeSkinType(i);
            }
            this.afO.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.gMs.onChangeSkinType();
            this.mSkinType = i;
            if (this.ggE != null) {
                this.ggE.setPlaceHolder(1);
            }
            if (this.gNe != null && this.gNe.getVisibility() == 0) {
                this.gNe.onChangeSkinType();
            }
        }
        if (this.agx != null && n.IJ(this.agx.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d);
            ap.setViewTextColor(this.gNb, R.color.cp_cont_d);
            ap.setViewTextColor(this.gNc, R.color.cp_cont_d);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b);
            ap.setViewTextColor(this.gNb, R.color.cp_cont_f);
            ap.setViewTextColor(this.gNc, R.color.cp_cont_b);
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
        this.agx = bwVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void uQ(int i) {
    }

    private void refreshView() {
        if (this.agx == null || this.agx.bka() == null) {
            this.gMq.setVisibility(8);
            return;
        }
        this.gMq.setVisibility(0);
        this.afO.setData(this.agx);
        this.afO.setUserAfterClickListener(this.ajG);
        this.gMu.getController().a(this.agx, this.mForumName, "", false);
        this.gMu.getController().startPlayAnimation();
        if (this.agx.bku() != null && this.agx.bku().share_info != null && !StringUtils.isNull(this.agx.bku().share_info.content)) {
            this.mTextTitle.setVisibility(0);
            this.mTextTitle.setText(this.agx.bku().share_info.content);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (this.agx.bku() != null && this.agx.bku().user_info != null) {
            String str = this.agx.bku().user_info.user_name;
            if (af.getTextLengthWithEmoji(str) > 14) {
                str = af.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.gNc.setText(str + ":");
            if (TextUtils.isEmpty(this.agx.bku().user_info.portrait)) {
                this.ggE.setPlaceHolder(1);
            } else {
                this.ggE.startLoad(this.agx.bku().user_info.portrait, 10, false, false);
            }
        }
        String title = this.agx.getTitle();
        if (!StringUtils.isNull(title)) {
            this.gNb.setText(title);
            this.gNb.setVisibility(0);
        } else {
            this.gNb.setVisibility(8);
        }
        uS(sZ(1));
        if (this.agx.bku().mChallengeInfoData != null && this.agx.bku().mChallengeInfoData.challenge_id > 0) {
            this.gli.setVisibility(0);
        } else {
            this.gli.setVisibility(8);
        }
        this.mMaskView.setVisibility((com.baidu.tieba.frs.b.cuL().cuF() || com.baidu.tieba.frs.a.cuE().cuF()) ? 0 : 8);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        ua();
    }

    private void ua() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gNd.getLayoutParams();
        if (this.mTextTitle.getVisibility() == 0) {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        } else {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
        }
        this.gNd.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.b.cuL().cuF() && !com.baidu.tieba.frs.a.cuE().cuF()) {
            if (view == this.gMq || view == this.gMs.getCommentContainer() || this.gNa == view || view == this.gNe.eRI.getCommentContainer()) {
                if (this.agx != null) {
                    n.II(this.agx.getId());
                }
                if (cls() != null) {
                    cls().a(this.gMq, this.agx);
                }
                TiebaStatic.log(new aq("c12323"));
                int i = 5;
                if (this.agx.bku().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                    i = 1;
                }
                if (view == this.gMs.getCommentContainer() || view == this.gNe.eRI.getCommentContainer()) {
                    aq aqVar = new aq("c12942");
                    aqVar.aj("obj_locate", 2);
                    aqVar.dR("tid", this.agx.getTid());
                    aqVar.aj("obj_type", i);
                    aqVar.dR("nid", this.agx.getNid());
                    TiebaStatic.log(aqVar);
                }
            } else if (view.getId() == R.id.video_container) {
                if (cls() != null) {
                    cls().a(view, this.agx);
                }
                TiebaStatic.log(new aq("c12323"));
                if (this.agx.bku().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                }
            }
        }
    }

    private void p(TbPageContext<?> tbPageContext) {
        if (this.agx != null && this.agx.bku() != null && this.agx.bku().share_info != null) {
            if (this.agx.bku().share_info.record_tid <= 0) {
                q(this.mTbPageContext);
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(this.agx.bku().share_info.record_tid), null, "frs_page");
            createNormalCfg.setVideo_source(this.agx.blj() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs");
            createNormalCfg.setFromSmartFrs(this.agx.blp());
            createNormalCfg.setSmartFrsPosition(this.agx.blv());
            createNormalCfg.setStartFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }

    public void q(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.agx != null && this.agx.bku() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(tbPageContext.getPageActivity(), R.string.no_network_guide);
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.agx.bku());
            if (this.agx.bku().user_info != null) {
                alaLiveInfoCoreData.userName = this.agx.bku().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, "frs_share_live", "", false, this.mForumName)));
        }
    }

    public void uS(int i) {
        if (this.agx != null) {
            if (i == 1) {
                this.gMs.setVisibility(8);
                this.gNe.setData(this.agx);
                return;
            }
            this.gMs.setData(this.agx);
            this.gNe.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahu = str;
    }

    public int sZ(int i) {
        return com.baidu.tieba.a.d.bGs().av(this.ahu, i);
    }

    public ThreadCommentAndPraiseInfoLayout bTq() {
        return this.gMs;
    }

    public ThreadCommentAndPraiseInfoLayout bTr() {
        if (this.gNe != null) {
            return this.gNe.eRI;
        }
        return null;
    }
}
