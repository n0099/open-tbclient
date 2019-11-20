package com.baidu.tieba.ala.livecard.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.z;
import com.baidu.tieba.pb.ThreadSkinView;
/* loaded from: classes6.dex */
public class e extends com.baidu.tieba.card.a<bh> implements com.baidu.tieba.a.e, z {
    private CardUserInfoLayout EV;
    private bh Fs;
    private String Gc;
    private final View.OnClickListener Ho;
    private View bgU;
    private TbPageContext<?> ceu;
    private View dSB;
    public AlaVideoContainer dSC;
    private RelativeLayout dSy;
    public ThreadSkinView dTA;
    private TbImageView dTB;
    private boolean dTC;
    private boolean dTD;
    public NewThreadCommentAndPraiseInfoLayout dTn;
    protected ThreadSourceShareAndPraiseLayout dTo;
    private com.baidu.tieba.ala.livecard.vc.a dTv;
    public LinearLayout dTz;
    private String mForumName;
    private View mMaskView;
    private TextView mTextTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.dTC = false;
        this.Ho = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aZV() != null) {
                    e.this.aZV().a(view, e.this.Fs);
                }
            }
        };
        setTag(bdUniqueId);
        this.ceu = tbPageContext;
        View view = getView();
        this.dSy = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.dTz = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.dSy.setOnClickListener(this);
        this.dTB = (TbImageView) view.findViewById(R.id.video_card_stage_view);
        this.dTB.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.dTB.setDefaultBgResource(R.color.transparent);
        this.EV = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.EV.setUserAfterClickListener(this.Ho);
        this.EV.setShowFlag(6141);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.dTn = (NewThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.dTn.setOnClickListener(this);
        this.dTn.setReplyTimeVisible(false);
        this.dTn.setSelectVisible(false);
        this.dTn.setNeedAddReplyIcon(true);
        this.dTn.setIsBarViewVisible(false);
        this.dTn.setCommentNumEnable(false);
        this.dTn.setLiveShareEnable(false);
        this.dTn.setShowPraiseNum(true);
        this.dTn.setNeedAddPraiseIcon(true);
        this.dTn.setShareVisible(true);
        this.dTn.setFrom(2);
        this.dTn.getCommentContainer().setOnClickListener(this);
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
        this.dTA = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.dSC = (AlaVideoContainer) view.findViewById(R.id.ala_video_container);
        this.dSC.setOnVideoClickListener(this);
        this.dSC.setLigvingLogLayoutVisible(8);
        this.bgU = view.findViewById(R.id.divider_line);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.dTv = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.EV.getSuffixContainer());
        this.dTv.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.dSy, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.bgU, R.color.cp_bg_line_c);
            if (this.dSC != null) {
                this.dSC.onChangeSkinType(i);
            }
            this.EV.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.dTn.onChangeSkinType();
            this.mSkinType = i;
            if (this.dTo != null && this.dTo.getVisibility() == 0) {
                this.dTo.onChangeSkinType();
            }
        }
        if (this.Fs != null && n.uA(this.Fs.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
        am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.dTv.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_ala_video_layout_new;
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.a.biU().biV()) {
            if (view == this.dSy || view == this.dTn.getCommentContainer() || view == this.dTz || view == this.dTo.cqW.getCommentContainer()) {
                if (this.Fs != null) {
                    n.uz(this.Fs.getId());
                }
                if (aZV() != null) {
                    aZV().a(this.dSy, this.Fs);
                }
                c(getContext(), this.Fs);
                if (this.Fs != null) {
                    if (view == this.dTn.getCommentContainer() || view == this.dTo.cqW.getCommentContainer()) {
                        an anVar = new an("c12942");
                        anVar.O("obj_locate", 2);
                        anVar.O("obj_type", 5);
                        anVar.bS("tid", this.Fs.getTid());
                        TiebaStatic.log(anVar);
                    }
                }
            } else if (view.getId() == R.id.video_container) {
                if (aZV() != null) {
                    aZV().a(view, this.Fs);
                }
                c(getContext(), this.Fs);
            }
        }
    }

    private void refreshView() {
        SparseArray<String> sparseArray;
        if (this.Fs == null || this.Fs.aiE() == null || this.dSC == null || this.dSC.getController() == null) {
            this.dSy.setVisibility(8);
            return;
        }
        this.dSC.getController().a(this.Fs, this.mForumName, "", false);
        this.dSC.getController().startPlayAnimation();
        this.dSy.setVisibility(0);
        if (this.Fs.aiX() != null && this.Fs.aiX().user_info != null && this.Fs.aiX().user_info.is_official == 2) {
            this.dTD = true;
            SparseArray<String> sparseArray2 = this.Fs.aiX().dislikeInfo;
            this.dTB.setVisibility(0);
            int[] screenDimensions = l.getScreenDimensions(getContext());
            ViewGroup.LayoutParams layoutParams = this.dTB.getLayoutParams();
            layoutParams.width = screenDimensions[0];
            layoutParams.height = (screenDimensions[0] * 156) / 1080;
            this.dTB.setLayoutParams(layoutParams);
            if (!TextUtils.isEmpty(this.Fs.aiX().liveStagePicUrl)) {
                this.dTB.startLoad(this.Fs.aiX().liveStagePicUrl, 10, false);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.EV.getLayoutParams();
            marginLayoutParams.topMargin = this.ceu.getResources().getDimensionPixelSize(R.dimen.tbds24);
            this.EV.setLayoutParams(marginLayoutParams);
            sparseArray = sparseArray2;
        } else {
            this.dTD = false;
            this.dTB.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.EV.getLayoutParams();
            marginLayoutParams2.topMargin = this.ceu.getResources().getDimensionPixelSize(R.dimen.tbds44);
            this.EV.setLayoutParams(marginLayoutParams2);
            sparseArray = null;
        }
        if (this.dTD && sparseArray != null && sparseArray.size() > 0) {
            this.dTv.c(this.Fs, "ala_frs_demo_hell_live_feed_back_type");
        } else if (this.dTv.aML() != null) {
            this.dTv.aML().setVisibility(8);
        }
        this.Fs.q(false, true);
        this.EV.setData(this.Fs);
        SpannableStringBuilder ajk = this.Fs.ajk();
        if (ajk != null && !StringUtils.isNull(ajk.toString())) {
            this.mTextTitle.setText(this.Fs.ajk());
            this.mTextTitle.setVisibility(0);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        mY(lx(1));
        P(this.Fs);
        this.mMaskView.setVisibility(com.baidu.tieba.frs.a.biU().biV() ? 0 : 8);
        onChangeSkinType(this.ceu, TbadkCoreApplication.getInst().getSkinType());
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dTn != null && this.EV != null) {
            this.EV.setPageUniqueId(bdUniqueId);
        }
    }

    public void hj(boolean z) {
        this.dTC = z;
    }

    private void P(bh bhVar) {
        if (bhVar != null) {
            TiebaStatic.log(new an("c12125").bS("tid", bhVar.getId()).O("obj_locate", this.dTC ? 2 : 1).p("obj_id", bhVar.aiX().live_id).O("obj_type", 2));
            if (bhVar.aiX() != null && bhVar.aiX().user_info != null && bhVar.aiX().user_info.is_official == 2) {
                TiebaStatic.log(new an("c12800").bS("tid", bhVar.getId()));
            }
        }
    }

    private void d(bh bhVar, String str) {
        TiebaStatic.log(new an("c12126").bS("tid", bhVar.getId()).O("obj_locate", this.dTC ? 2 : 1).p("obj_id", bhVar.aiX().live_id).O("obj_type", 2));
        if (bhVar.aiX() != null && bhVar.aiX().user_info != null && bhVar.aiX().user_info.is_official == 2) {
            TiebaStatic.log(new an("c12801").bS("tid", bhVar.getId()));
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (str.equals("frs_live_play")) {
            if (bhVar.aiJ().equals(this.mForumName)) {
                TiebaStatic.log(new an("c11843").bS("uid", currentAccount).p("fid", bhVar.getFid()));
            } else {
                TiebaStatic.log(new an("c11845").bS("uid", currentAccount).p("fid", bhVar.getFid()));
            }
        }
    }

    public void c(Context context, bh bhVar) {
        if (context != null && bhVar != null && bhVar.aiX() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(context, (int) R.string.no_network_guide);
                return;
            }
            String air = bhVar.air() != null ? bhVar.air() : this.dTD ? "frs_live_stage_live" : "frs_play";
            d(bhVar, air);
            AlaInfoData aiX = bhVar.aiX();
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && bhVar.aiE() != null) {
                z = TextUtils.equals(bhVar.aiE().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(aiX);
            if (aiX.user_info != null) {
                alaLiveInfoCoreData.userName = aiX.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, air, "", z, this.mForumName)));
        }
    }

    public void mY(int i) {
        if (this.Fs != null) {
            if (i == 1) {
                this.dTn.setVisibility(8);
                this.dTo.setData(this.Fs);
                return;
            }
            this.dSB.setVisibility(this.dTn.setData(this.Fs) ? 8 : 0);
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
}
