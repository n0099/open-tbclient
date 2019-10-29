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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.z;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.a<bh> implements com.baidu.tieba.a.e, z {
    private bh FT;
    private CardUserInfoLayout Fv;
    private String GC;
    private final View.OnClickListener HO;
    private View bhm;
    private LinearLayout dCX;
    private RelativeLayout dTp;
    private View dTs;
    public AlaVideoContainer dTt;
    private LinearLayout dUa;
    private TextView dUb;
    private TextView dUc;
    private RelativeLayout dUd;
    private NewThreadCommentAndPraiseInfoLayout dUe;
    private ThreadSourceShareAndPraiseLayout dUf;
    private HeadImageView dyW;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.HO = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aZX() != null) {
                    c.this.aZX().a(view, c.this.FT);
                }
            }
        };
        setTag(bdUniqueId);
        View view = getView();
        this.dTp = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.dTp.setOnClickListener(this);
        this.dUa = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.dUa.setOnClickListener(this);
        this.dUd = (RelativeLayout) view.findViewById(R.id.ala_share_container);
        this.dCX = (LinearLayout) this.dUd.findViewById(R.id.challenge_root);
        this.Fv = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.Fv.setShowFlag(6141);
        this.dyW = (HeadImageView) view.findViewById(R.id.ala_share_live_user_pendant_header);
        this.dyW.setIsRound(true);
        this.dyW.setDrawBorder(false);
        this.dyW.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dyW.setAutoChangeStyle(false);
        this.dUc = (TextView) view.findViewById(R.id.ala_share_live_username_text);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.dUb = (TextView) view.findViewById(R.id.ala_live_room_title);
        this.dTt = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.dTt.setOnVideoClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.dUe = (NewThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.dUe.setOnClickListener(this);
        this.dUe.setReplyTimeVisible(false);
        this.dUe.setShowPraiseNum(true);
        this.dUe.setNeedAddReplyIcon(true);
        this.dUe.setNeedAddPraiseIcon(true);
        this.dUe.setFrom(2);
        this.dUe.getCommentContainer().setOnClickListener(this);
        this.dUe.setShareVisible(true);
        this.dUe.setShareReportFrom(1);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bXQ = 2;
        dVar.bXV = 2;
        this.dUe.setAgreeStatisticData(dVar);
        this.dUf = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.dUf.crO.setOnClickListener(this);
        this.dUf.crO.getCommentContainer().setOnClickListener(this);
        this.dUf.setFrom(2);
        this.dUf.setShareReportFrom(1);
        this.dUf.setSourceFromForPb(3);
        this.dUf.setStType("frs_page");
        this.dUf.setHideBarName(true);
        this.dTs = view.findViewById(R.id.divider_below_reply_number_layout);
        this.bhm = view.findViewById(R.id.divider_line);
        this.dTt.setLigvingLogLayoutVisible(8);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.dTp, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.bhm, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.dUd, R.color.cp_bg_line_c);
            if (this.dTt != null) {
                this.dTt.onChangeSkinType(i);
            }
            this.Fv.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.dUe.onChangeSkinType();
            this.mSkinType = i;
            if (this.dyW != null) {
                this.dyW.setDefaultBgResource(com.baidu.tbadk.util.e.Vl());
            }
            if (this.dUf != null && this.dUf.getVisibility() == 0) {
                this.dUf.onChangeSkinType();
            }
        }
        if (this.FT != null && n.uA(this.FT.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.dUb, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.dUc, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.dUb, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.dUc, (int) R.color.cp_cont_b);
        }
        am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_ala_share_live_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bh bhVar) {
        this.FT = bhVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void mX(int i) {
    }

    private void refreshView() {
        if (this.FT == null || this.FT.aiG() == null) {
            this.dTp.setVisibility(8);
            return;
        }
        this.dTp.setVisibility(0);
        this.Fv.setData(this.FT);
        this.Fv.setUserAfterClickListener(this.HO);
        this.dTt.getController().a(this.FT, this.mForumName, "", false);
        this.dTt.getController().startPlayAnimation();
        if (this.FT.aiZ() != null && this.FT.aiZ().share_info != null && !StringUtils.isNull(this.FT.aiZ().share_info.content)) {
            this.mTextTitle.setVisibility(0);
            this.mTextTitle.setText(this.FT.aiZ().share_info.content);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (this.FT.aiZ() != null && this.FT.aiZ().user_info != null) {
            String str = this.FT.aiZ().user_info.user_name;
            if (aa.getTextLengthWithEmoji(str) > 14) {
                str = aa.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.dUc.setText(str + ":");
            if (TextUtils.isEmpty(this.FT.aiZ().user_info.portrait)) {
                this.dyW.setDefaultResource(com.baidu.tbadk.util.e.Vl());
            } else {
                this.dyW.startLoad(this.FT.aiZ().user_info.portrait, 10, false, false);
            }
        }
        String title = this.FT.getTitle();
        if (!StringUtils.isNull(title)) {
            this.dUb.setText(title);
            this.dUb.setVisibility(0);
        } else {
            this.dUb.setVisibility(8);
        }
        mZ(ly(1));
        if (this.FT.aiZ().mChallengeInfoData != null && this.FT.aiZ().mChallengeInfoData.challenge_id > 0) {
            this.dCX.setVisibility(0);
        } else {
            this.dCX.setVisibility(8);
        }
        this.mMaskView.setVisibility(com.baidu.tieba.frs.a.biW().biX() ? 0 : 8);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        lZ();
    }

    private void lZ() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dUd.getLayoutParams();
        if (this.mTextTitle.getVisibility() == 0) {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        } else {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
        }
        this.dUd.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.a.biW().biX()) {
            if (view == this.dTp || view == this.dUe.getCommentContainer() || this.dUa == view || view == this.dUf.crO.getCommentContainer()) {
                if (this.FT != null) {
                    n.uz(this.FT.getId());
                }
                if (aZX() != null) {
                    aZX().a(this.dTp, this.FT);
                }
                TiebaStatic.log(new an("c12323"));
                int i = 5;
                if (this.FT.aiZ().live_status == 1) {
                    k(this.mTbPageContext);
                } else {
                    j(this.mTbPageContext);
                    i = 1;
                }
                if (view == this.dUe.getCommentContainer() || view == this.dUf.crO.getCommentContainer()) {
                    an anVar = new an("c12942");
                    anVar.O("obj_locate", 2);
                    anVar.bS("tid", this.FT.getTid());
                    anVar.O("obj_type", i);
                    TiebaStatic.log(anVar);
                }
            } else if (view.getId() == R.id.video_container) {
                if (aZX() != null) {
                    aZX().a(view, this.FT);
                }
                TiebaStatic.log(new an("c12323"));
                if (this.FT.aiZ().live_status == 1) {
                    k(this.mTbPageContext);
                } else {
                    j(this.mTbPageContext);
                }
            }
        }
    }

    private void j(TbPageContext<?> tbPageContext) {
        if (this.FT != null && this.FT.aiZ() != null && this.FT.aiZ().share_info != null) {
            if (this.FT.aiZ().share_info.record_tid <= 0) {
                k(this.mTbPageContext);
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(this.FT.aiZ().share_info.record_tid), null, "frs_page");
            createNormalCfg.setVideo_source(this.FT.ajH() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs");
            createNormalCfg.setFromSmartFrs(this.FT.ajO());
            createNormalCfg.setSmartFrsPosition(this.FT.ajV());
            createNormalCfg.setStartFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }

    public void k(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.FT != null && this.FT.aiZ() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(tbPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.FT.aiZ());
            if (this.FT.aiZ().user_info != null) {
                alaLiveInfoCoreData.userName = this.FT.aiZ().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, "frs_share_live", "", false, this.mForumName)));
        }
    }

    public void mZ(int i) {
        if (this.FT != null) {
            if (i == 1) {
                this.dUe.setVisibility(8);
                this.dUf.setData(this.FT);
                return;
            }
            this.dUe.setData(this.FT);
            this.dUf.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.GC = str;
    }

    public int ly(int i) {
        return com.baidu.tieba.a.d.aDe().X(this.GC, i);
    }

    public ThreadCommentAndPraiseInfoLayout aMP() {
        return this.dUe;
    }

    public ThreadCommentAndPraiseInfoLayout aMQ() {
        if (this.dUf != null) {
            return this.dUf.crO;
        }
        return null;
    }
}
