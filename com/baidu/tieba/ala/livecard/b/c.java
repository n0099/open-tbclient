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
    private CardUserInfoLayout EV;
    private bh Fs;
    private String Gc;
    private final View.OnClickListener Ho;
    private View bgU;
    private LinearLayout dCg;
    private View dSB;
    public AlaVideoContainer dSC;
    private RelativeLayout dSy;
    private LinearLayout dTj;
    private TextView dTk;
    private TextView dTl;
    private RelativeLayout dTm;
    private NewThreadCommentAndPraiseInfoLayout dTn;
    private ThreadSourceShareAndPraiseLayout dTo;
    private HeadImageView dyf;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.Ho = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aZV() != null) {
                    c.this.aZV().a(view, c.this.Fs);
                }
            }
        };
        setTag(bdUniqueId);
        View view = getView();
        this.dSy = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.dSy.setOnClickListener(this);
        this.dTj = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.dTj.setOnClickListener(this);
        this.dTm = (RelativeLayout) view.findViewById(R.id.ala_share_container);
        this.dCg = (LinearLayout) this.dTm.findViewById(R.id.challenge_root);
        this.EV = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.EV.setShowFlag(6141);
        this.dyf = (HeadImageView) view.findViewById(R.id.ala_share_live_user_pendant_header);
        this.dyf.setIsRound(true);
        this.dyf.setDrawBorder(false);
        this.dyf.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dyf.setAutoChangeStyle(false);
        this.dTl = (TextView) view.findViewById(R.id.ala_share_live_username_text);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.dTk = (TextView) view.findViewById(R.id.ala_live_room_title);
        this.dSC = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.dSC.setOnVideoClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.dTn = (NewThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.dTn.setOnClickListener(this);
        this.dTn.setReplyTimeVisible(false);
        this.dTn.setShowPraiseNum(true);
        this.dTn.setNeedAddReplyIcon(true);
        this.dTn.setNeedAddPraiseIcon(true);
        this.dTn.setFrom(2);
        this.dTn.getCommentContainer().setOnClickListener(this);
        this.dTn.setShareVisible(true);
        this.dTn.setShareReportFrom(1);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bWZ = 2;
        dVar.bXe = 2;
        this.dTn.setAgreeStatisticData(dVar);
        this.dTo = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.dTo.cqW.setOnClickListener(this);
        this.dTo.cqW.getCommentContainer().setOnClickListener(this);
        this.dTo.setFrom(2);
        this.dTo.setShareReportFrom(1);
        this.dTo.setSourceFromForPb(3);
        this.dTo.setStType("frs_page");
        this.dTo.setHideBarName(true);
        this.dSB = view.findViewById(R.id.divider_below_reply_number_layout);
        this.bgU = view.findViewById(R.id.divider_line);
        this.dSC.setLigvingLogLayoutVisible(8);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.dSy, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.bgU, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.dTm, R.color.cp_bg_line_c);
            if (this.dSC != null) {
                this.dSC.onChangeSkinType(i);
            }
            this.EV.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.dTn.onChangeSkinType();
            this.mSkinType = i;
            if (this.dyf != null) {
                this.dyf.setDefaultBgResource(com.baidu.tbadk.util.e.Vj());
            }
            if (this.dTo != null && this.dTo.getVisibility() == 0) {
                this.dTo.onChangeSkinType();
            }
        }
        if (this.Fs != null && n.uA(this.Fs.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.dTk, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.dTl, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.dTk, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.dTl, (int) R.color.cp_cont_b);
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
        this.Fs = bhVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void mW(int i) {
    }

    private void refreshView() {
        if (this.Fs == null || this.Fs.aiE() == null) {
            this.dSy.setVisibility(8);
            return;
        }
        this.dSy.setVisibility(0);
        this.EV.setData(this.Fs);
        this.EV.setUserAfterClickListener(this.Ho);
        this.dSC.getController().a(this.Fs, this.mForumName, "", false);
        this.dSC.getController().startPlayAnimation();
        if (this.Fs.aiX() != null && this.Fs.aiX().share_info != null && !StringUtils.isNull(this.Fs.aiX().share_info.content)) {
            this.mTextTitle.setVisibility(0);
            this.mTextTitle.setText(this.Fs.aiX().share_info.content);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (this.Fs.aiX() != null && this.Fs.aiX().user_info != null) {
            String str = this.Fs.aiX().user_info.user_name;
            if (aa.getTextLengthWithEmoji(str) > 14) {
                str = aa.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.dTl.setText(str + ":");
            if (TextUtils.isEmpty(this.Fs.aiX().user_info.portrait)) {
                this.dyf.setDefaultResource(com.baidu.tbadk.util.e.Vj());
            } else {
                this.dyf.startLoad(this.Fs.aiX().user_info.portrait, 10, false, false);
            }
        }
        String title = this.Fs.getTitle();
        if (!StringUtils.isNull(title)) {
            this.dTk.setText(title);
            this.dTk.setVisibility(0);
        } else {
            this.dTk.setVisibility(8);
        }
        mY(lx(1));
        if (this.Fs.aiX().mChallengeInfoData != null && this.Fs.aiX().mChallengeInfoData.challenge_id > 0) {
            this.dCg.setVisibility(0);
        } else {
            this.dCg.setVisibility(8);
        }
        this.mMaskView.setVisibility(com.baidu.tieba.frs.a.biU().biV() ? 0 : 8);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        lZ();
    }

    private void lZ() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dTm.getLayoutParams();
        if (this.mTextTitle.getVisibility() == 0) {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        } else {
            layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
        }
        this.dTm.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.a.biU().biV()) {
            if (view == this.dSy || view == this.dTn.getCommentContainer() || this.dTj == view || view == this.dTo.cqW.getCommentContainer()) {
                if (this.Fs != null) {
                    n.uz(this.Fs.getId());
                }
                if (aZV() != null) {
                    aZV().a(this.dSy, this.Fs);
                }
                TiebaStatic.log(new an("c12323"));
                int i = 5;
                if (this.Fs.aiX().live_status == 1) {
                    k(this.mTbPageContext);
                } else {
                    j(this.mTbPageContext);
                    i = 1;
                }
                if (view == this.dTn.getCommentContainer() || view == this.dTo.cqW.getCommentContainer()) {
                    an anVar = new an("c12942");
                    anVar.O("obj_locate", 2);
                    anVar.bS("tid", this.Fs.getTid());
                    anVar.O("obj_type", i);
                    TiebaStatic.log(anVar);
                }
            } else if (view.getId() == R.id.video_container) {
                if (aZV() != null) {
                    aZV().a(view, this.Fs);
                }
                TiebaStatic.log(new an("c12323"));
                if (this.Fs.aiX().live_status == 1) {
                    k(this.mTbPageContext);
                } else {
                    j(this.mTbPageContext);
                }
            }
        }
    }

    private void j(TbPageContext<?> tbPageContext) {
        if (this.Fs != null && this.Fs.aiX() != null && this.Fs.aiX().share_info != null) {
            if (this.Fs.aiX().share_info.record_tid <= 0) {
                k(this.mTbPageContext);
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(this.Fs.aiX().share_info.record_tid), null, "frs_page");
            createNormalCfg.setVideo_source(this.Fs.ajF() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs");
            createNormalCfg.setFromSmartFrs(this.Fs.ajM());
            createNormalCfg.setSmartFrsPosition(this.Fs.ajT());
            createNormalCfg.setStartFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }

    public void k(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.Fs != null && this.Fs.aiX() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(tbPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.Fs.aiX());
            if (this.Fs.aiX().user_info != null) {
                alaLiveInfoCoreData.userName = this.Fs.aiX().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, "frs_share_live", "", false, this.mForumName)));
        }
    }

    public void mY(int i) {
        if (this.Fs != null) {
            if (i == 1) {
                this.dTn.setVisibility(8);
                this.dTo.setData(this.Fs);
                return;
            }
            this.dTn.setData(this.Fs);
            this.dTo.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Gc = str;
    }

    public int lx(int i) {
        return com.baidu.tieba.a.d.aDc().X(this.Gc, i);
    }

    public ThreadCommentAndPraiseInfoLayout aMN() {
        return this.dTn;
    }

    public ThreadCommentAndPraiseInfoLayout aMO() {
        if (this.dTo != null) {
            return this.dTo.cqW;
        }
        return null;
    }
}
