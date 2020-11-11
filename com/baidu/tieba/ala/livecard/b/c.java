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
    private RelativeLayout gSP;
    private ThreadCommentAndPraiseInfoLayout gSR;
    private View gSS;
    public AlaVideoContainer gST;
    private TextView gTA;
    private TextView gTB;
    private RelativeLayout gTC;
    private ThreadSourceShareAndPraiseLayout gTD;
    private LinearLayout gTz;
    private HeadImageView gms;
    private LinearLayout gqV;
    private View mDivider;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ajG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cnT() != null) {
                    c.this.cnT().a(view, c.this.agx);
                }
            }
        };
        setTag(bdUniqueId);
        View view = getView();
        this.gSP = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.gSP.setOnClickListener(this);
        this.gTz = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.gTz.setOnClickListener(this);
        this.gTC = (RelativeLayout) view.findViewById(R.id.ala_share_container);
        this.gqV = (LinearLayout) this.gTC.findViewById(R.id.challenge_root);
        this.afO = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.afO.setShowFlag(6141);
        this.gms = (HeadImageView) view.findViewById(R.id.ala_share_live_user_pendant_header);
        this.gms.setIsRound(true);
        this.gms.setDrawBorder(false);
        this.gms.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gms.setAutoChangeStyle(false);
        this.gTB = (TextView) view.findViewById(R.id.ala_share_live_username_text);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gTA = (TextView) view.findViewById(R.id.ala_live_room_title);
        this.gST = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.gST.setOnVideoClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.gSR = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.gSR.setOnClickListener(this);
        this.gSR.setReplyTimeVisible(false);
        this.gSR.setShowPraiseNum(true);
        this.gSR.setNeedAddReplyIcon(true);
        this.gSR.setNeedAddPraiseIcon(true);
        this.gSR.setFrom(2);
        this.gSR.getCommentContainer().setOnClickListener(this);
        this.gSR.setShareVisible(true);
        this.gSR.setShareReportFrom(1);
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.ezt = 2;
        cVar.ezz = 2;
        this.gSR.setAgreeStatisticData(cVar);
        this.gTD = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.gTD.eXx.setOnClickListener(this);
        this.gTD.eXx.getCommentContainer().setOnClickListener(this);
        this.gTD.setFrom(2);
        this.gTD.setShareReportFrom(1);
        this.gTD.setSourceFromForPb(3);
        this.gTD.setStType("frs_page");
        this.gTD.setHideBarName(true);
        this.gSS = view.findViewById(R.id.divider_below_reply_number_layout);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.gST.setLigvingLogLayoutVisible(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gSP, R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_b);
            ap.setBackgroundColor(this.gTC, R.color.cp_bg_line_c);
            if (this.gST != null) {
                this.gST.onChangeSkinType(i);
            }
            this.afO.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.gSR.onChangeSkinType();
            this.mSkinType = i;
            if (this.gms != null) {
                this.gms.setPlaceHolder(1);
            }
            if (this.gTD != null && this.gTD.getVisibility() == 0) {
                this.gTD.onChangeSkinType();
            }
        }
        if (this.agx != null && n.Ja(this.agx.getId())) {
            ap.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
            ap.setViewTextColor(this.gTA, (int) R.color.cp_cont_d);
            ap.setViewTextColor(this.gTB, (int) R.color.cp_cont_d);
        } else {
            ap.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
            ap.setViewTextColor(this.gTA, (int) R.color.cp_cont_f);
            ap.setViewTextColor(this.gTB, (int) R.color.cp_cont_b);
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
    public void vd(int i) {
    }

    private void refreshView() {
        if (this.agx == null || this.agx.bmA() == null) {
            this.gSP.setVisibility(8);
            return;
        }
        this.gSP.setVisibility(0);
        this.afO.setData(this.agx);
        this.afO.setUserAfterClickListener(this.ajG);
        this.gST.getController().a(this.agx, this.mForumName, "", false);
        this.gST.getController().startPlayAnimation();
        if (this.agx.bmU() != null && this.agx.bmU().share_info != null && !StringUtils.isNull(this.agx.bmU().share_info.content)) {
            this.mTextTitle.setVisibility(0);
            this.mTextTitle.setText(this.agx.bmU().share_info.content);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (this.agx.bmU() != null && this.agx.bmU().user_info != null) {
            String str = this.agx.bmU().user_info.user_name;
            if (af.getTextLengthWithEmoji(str) > 14) {
                str = af.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.gTB.setText(str + ":");
            if (TextUtils.isEmpty(this.agx.bmU().user_info.portrait)) {
                this.gms.setPlaceHolder(1);
            } else {
                this.gms.startLoad(this.agx.bmU().user_info.portrait, 10, false, false);
            }
        }
        String title = this.agx.getTitle();
        if (!StringUtils.isNull(title)) {
            this.gTA.setText(title);
            this.gTA.setVisibility(0);
        } else {
            this.gTA.setVisibility(8);
        }
        vf(tj(1));
        if (this.agx.bmU().mChallengeInfoData != null && this.agx.bmU().mChallengeInfoData.challenge_id > 0) {
            this.gqV.setVisibility(0);
        } else {
            this.gqV.setVisibility(8);
        }
        this.mMaskView.setVisibility((com.baidu.tieba.frs.b.cxm().cxg() || com.baidu.tieba.frs.a.cxf().cxg()) ? 0 : 8);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        ua();
    }

    private void ua() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gTC.getLayoutParams();
        if (this.mTextTitle.getVisibility() == 0) {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        } else {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
        }
        this.gTC.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.b.cxm().cxg() && !com.baidu.tieba.frs.a.cxf().cxg()) {
            if (view == this.gSP || view == this.gSR.getCommentContainer() || this.gTz == view || view == this.gTD.eXx.getCommentContainer()) {
                if (this.agx != null) {
                    n.IZ(this.agx.getId());
                }
                if (cnT() != null) {
                    cnT().a(this.gSP, this.agx);
                }
                TiebaStatic.log(new aq("c12323"));
                int i = 5;
                if (this.agx.bmU().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                    i = 1;
                }
                if (view == this.gSR.getCommentContainer() || view == this.gTD.eXx.getCommentContainer()) {
                    aq aqVar = new aq("c12942");
                    aqVar.al("obj_locate", 2);
                    aqVar.dR("tid", this.agx.getTid());
                    aqVar.al("obj_type", i);
                    aqVar.dR("nid", this.agx.getNid());
                    TiebaStatic.log(aqVar);
                }
            } else if (view.getId() == R.id.video_container) {
                if (cnT() != null) {
                    cnT().a(view, this.agx);
                }
                TiebaStatic.log(new aq("c12323"));
                if (this.agx.bmU().live_status == 1) {
                    q(this.mTbPageContext);
                } else {
                    p(this.mTbPageContext);
                }
            }
        }
    }

    private void p(TbPageContext<?> tbPageContext) {
        if (this.agx != null && this.agx.bmU() != null && this.agx.bmU().share_info != null) {
            if (this.agx.bmU().share_info.record_tid <= 0) {
                q(this.mTbPageContext);
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(this.agx.bmU().share_info.record_tid), null, "frs_page");
            createNormalCfg.setVideo_source(this.agx.bnJ() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs");
            createNormalCfg.setFromSmartFrs(this.agx.bnP());
            createNormalCfg.setSmartFrsPosition(this.agx.bnV());
            createNormalCfg.setStartFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }

    public void q(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.agx != null && this.agx.bmU() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(tbPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.agx.bmU());
            if (this.agx.bmU().user_info != null) {
                alaLiveInfoCoreData.userName = this.agx.bmU().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, "frs_share_live", "", false, this.mForumName)));
        }
    }

    public void vf(int i) {
        if (this.agx != null) {
            if (i == 1) {
                this.gSR.setVisibility(8);
                this.gTD.setData(this.agx);
                return;
            }
            this.gSR.setData(this.agx);
            this.gTD.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahu = str;
    }

    public int tj(int i) {
        return com.baidu.tieba.a.d.bIR().ax(this.ahu, i);
    }

    public ThreadCommentAndPraiseInfoLayout bVY() {
        return this.gSR;
    }

    public ThreadCommentAndPraiseInfoLayout bVZ() {
        if (this.gTD != null) {
            return this.gTD.eXx;
        }
        return null;
    }
}
