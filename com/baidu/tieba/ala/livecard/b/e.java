package com.baidu.tieba.ala.livecard.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.y;
import com.baidu.tieba.pb.ThreadSkinView;
import tbclient.AppPosInfo;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.a<bk> implements com.baidu.tieba.a.e, y {
    private CardUserInfoLayout adC;
    private String aeX;
    private final View.OnClickListener agI;
    public TbImageView eBm;
    private TextView eBs;
    public LinearLayout eTM;
    private View fGA;
    private RelativeLayout fGx;
    private TextView fHA;
    private LinearLayout fHB;
    private View fHC;
    private boolean fHD;
    private boolean fHE;
    protected ThreadSourceShareAndPraiseLayout fHl;
    private com.baidu.tieba.ala.livecard.vc.a fHs;
    public ThreadSkinView fHw;
    private TbImageView fHx;
    public RelativeLayout fHy;
    private TBLottieAnimationView fHz;
    private View mDivider;
    private String mForumName;
    private int mLastScreenWidth;
    private View mMaskView;
    private TextView mTextTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.fHD = false;
        this.mLastScreenWidth = 0;
        this.agI = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.bKU() != null) {
                    e.this.bKU().a(view, e.this.adw);
                }
            }
        };
        setTag(bdUniqueId);
        this.dIF = tbPageContext;
        View view = getView();
        this.fGx = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.eTM = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.fGx.setOnClickListener(this);
        this.fHx = (TbImageView) view.findViewById(R.id.video_card_stage_view);
        this.fHx.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.fHx.setDefaultBgResource(R.color.transparent);
        this.adC = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.adC.setUserAfterClickListener(this.agI);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fHy = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.eBm = (TbImageView) view.findViewById(R.id.image_video);
        this.eBm.setDrawCorner(true);
        this.eBm.setPlaceHolder(3);
        this.eBm.setDefaultResource(0);
        this.eBm.setDefaultErrorResource(0);
        this.eBm.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        TbImageView tbImageView = this.eBm;
        TbImageView tbImageView2 = this.eBm;
        tbImageView.setConrers(15);
        this.eBm.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eBm.setBorderColor(am.getColor(R.color.cp_border_a));
        this.eBm.setBorderSurroundContent(true);
        this.eBm.setDrawBorder(true);
        this.fHB = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
        this.fHz = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.fHz.loop(true);
        am.a(this.fHz, (int) R.raw.ala_live2);
        this.fHz.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.e.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                e.this.fHz.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                e.this.fHz.cancelAnimation();
            }
        });
        this.eBs = (TextView) view.findViewById(R.id.play_count);
        this.fHA = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.fHC = view.findViewById(R.id.play_count_line);
        this.fGz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        b(this.fGz);
        this.fGz.setSelectVisible(false);
        this.fGz.setIsBarViewVisible(false);
        this.fGz.setCommentNumEnable(true);
        this.fGz.setLiveShareEnable(false);
        this.fGz.setFrom(2);
        this.fGz.getCommentContainer().setOnClickListener(this);
        this.fGz.hideDisagree();
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dAZ = 2;
        cVar.dBf = 2;
        this.fGz.setAgreeStatisticData(cVar);
        this.gBP = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.gBP);
        this.gBP.setFrom(2);
        this.gBP.setShareReportFrom(1);
        this.fHl = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.fHl.dXt.setOnClickListener(this);
        this.fHl.dXt.getCommentContainer().setOnClickListener(this);
        this.fHl.setFrom(2);
        this.fHl.setShareReportFrom(1);
        this.fHl.setSourceFromForPb(3);
        this.fHl.setStType("frs_page");
        this.fHl.setHideBarName(true);
        this.fGA = view.findViewById(R.id.divider_below_reply_number_layout);
        this.fHw = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.fHs = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.adC.getSuffixContainer());
        this.fHs.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.b
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            d(tbPageContext, i);
            am.setBackgroundResource(this.fGx, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fHy, R.drawable.bg_ala_shape);
            int dimens = l.getDimens(getContext(), R.dimen.tbds10);
            am.a(this.fHB, (int) R.color.cp_other_d, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, 0.0f, 0.0f, dimens, dimens, 0.0f, 0.0f});
            am.setBackgroundColor(this.fHC, R.color.cp_cont_a);
            am.setViewTextColor(this.eBs, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.fHA, (int) R.color.cp_cont_a);
            this.adC.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.eBm.setPlaceHolder(3);
            this.fGz.onChangeSkinType();
            this.mSkinType = i;
            if (this.fHl != null && this.fHl.getVisibility() == 0) {
                this.fHl.onChangeSkinType();
            }
        }
        if (this.adw != 0 && m.Do(((bk) this.adw).getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
        am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.fHs.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_video_layout_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bk bkVar) {
        this.adw = bkVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void qy(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.a.bTZ().bUa()) {
            if (view == this.fGx || view == this.fGz.getCommentContainer() || view == this.eTM || view == this.fHl.dXt.getCommentContainer() || view == this.gBP.getCommentContainer()) {
                if (this.adw != 0) {
                    m.Dn(((bk) this.adw).getId());
                }
                if (bKU() != null) {
                    bKU().a(this.fGx, this.adw);
                }
                b(getContext(), (bk) this.adw);
                if (this.adw != 0) {
                    if (view == this.fGz.getCommentContainer() || view == this.fHl.dXt.getCommentContainer()) {
                        an anVar = new an("c12942");
                        anVar.ag("obj_locate", 2);
                        anVar.ag("obj_type", 5);
                        anVar.dh("tid", ((bk) this.adw).getTid());
                        anVar.dh("nid", ((bk) this.adw).getNid());
                        TiebaStatic.log(anVar);
                    }
                }
            } else if (view.getId() == R.id.video_container) {
                if (bKU() != null) {
                    bKU().a(view, this.adw);
                }
                b(getContext(), (bk) this.adw);
            }
        }
    }

    private void refreshView() {
        SparseArray<String> sparseArray;
        if (this.adw == 0 || ((bk) this.adw).aQx() == null) {
            this.fGx.setVisibility(8);
            return;
        }
        this.fGx.setVisibility(0);
        int equipmentWidth = l.getEquipmentWidth(this.dIF.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fHy.getLayoutParams();
            layoutParams.width = equipmentWidth - l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.fHy.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (((bk) this.adw).aQS() != null && ((bk) this.adw).aQS().user_info != null && ((bk) this.adw).aQS().user_info.is_official == 2) {
            this.fHE = true;
            SparseArray<String> sparseArray2 = ((bk) this.adw).aQS().dislikeInfo;
            this.fHx.setVisibility(0);
            int[] screenDimensions = l.getScreenDimensions(getContext());
            ViewGroup.LayoutParams layoutParams2 = this.fHx.getLayoutParams();
            layoutParams2.width = screenDimensions[0];
            layoutParams2.height = (screenDimensions[0] * 156) / 1080;
            this.fHx.setLayoutParams(layoutParams2);
            if (!TextUtils.isEmpty(((bk) this.adw).aQS().liveStagePicUrl)) {
                this.fHx.startLoad(((bk) this.adw).aQS().liveStagePicUrl, 10, false);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.adC.getLayoutParams();
            marginLayoutParams.topMargin = this.dIF.getResources().getDimensionPixelSize(R.dimen.tbds24);
            this.adC.setLayoutParams(marginLayoutParams);
            sparseArray = sparseArray2;
        } else {
            this.fHE = false;
            this.fHx.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.adC.getLayoutParams();
            marginLayoutParams2.topMargin = this.dIF.getResources().getDimensionPixelSize(R.dimen.tbds44);
            this.adC.setLayoutParams(marginLayoutParams2);
            sparseArray = null;
        }
        if (this.fHE && sparseArray != null && sparseArray.size() > 0) {
            this.fHs.e((bk) this.adw, "ala_frs_demo_hell_live_feed_back_type");
        } else if (this.fHs.bwl() != null) {
            this.fHs.bwl().setVisibility(8);
        }
        ((bk) this.adw).v(false, true);
        this.adC.setData((bk) this.adw);
        SpannableStringBuilder aRi = ((bk) this.adw).aRi();
        if (aRi != null && !StringUtils.isNull(aRi.toString())) {
            this.mTextTitle.setText(((bk) this.adw).aRi());
            this.mTextTitle.setVisibility(0);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (((bk) this.adw).aQS().audience_count > 0) {
            this.fHC.setVisibility(0);
            this.eBs.setVisibility(0);
            this.eBs.setText(String.format(this.dIF.getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(((bk) this.adw).aQS().audience_count)));
        } else {
            this.fHC.setVisibility(8);
            this.eBs.setVisibility(8);
        }
        this.fHA.setVisibility(8);
        if (((bk) this.adw).aQS().openRecomReason == 1) {
            String str = ((bk) this.adw).aQS().recomReason;
            if (!StringUtils.isNull(str)) {
                this.fHA.setVisibility(0);
                this.fHA.setText(str);
            } else {
                String aQN = ((bk) this.adw).aQN();
                String aQO = ((bk) this.adw).aQO();
                if (UtilHelper.isDecimal(aQN) && UtilHelper.isDecimal(aQO) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo cVt = com.baidu.tieba.recapp.d.a.cVp().cVt();
                    String str2 = cVt.latitude;
                    String str3 = cVt.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(aQN), Double.parseDouble(aQO)) <= 50.0d) {
                        this.fHA.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.fHA.setVisibility(0);
                    }
                }
            }
        }
        qA(pa(1));
        X((bk) this.adw);
        this.mMaskView.setVisibility(com.baidu.tieba.frs.a.bTZ().bUa() ? 0 : 8);
        onChangeSkinType(this.dIF, TbadkCoreApplication.getInst().getSkinType());
        bwp();
        this.fHz.playAnimation();
        aJ(this.fGx);
    }

    public void bwp() {
        if (k.aNQ().isShowImages() && this.adw != 0 && ((bk) this.adw).aOi() != null && ((bk) this.adw).aOi().aQS() != null) {
            this.eBm.setPlaceHolder(3);
            this.eBm.startLoad(((bk) this.adw).aOi().aQS().cover, 10, false);
            this.fHy.setVisibility(0);
            return;
        }
        this.fHy.setVisibility(8);
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.fGz != null) {
            if (this.adC != null) {
                this.adC.setPageUniqueId(bdUniqueId);
            }
            setTag(bdUniqueId);
            q(bdUniqueId);
        }
    }

    public void kg(boolean z) {
        this.fHD = z;
    }

    private void X(bk bkVar) {
        if (bkVar != null) {
            TiebaStatic.log(new an("c12125").dh("tid", bkVar.getId()).ag("obj_locate", this.fHD ? 2 : 1).s("obj_id", bkVar.aQS().live_id).ag("obj_type", 2));
            if (bkVar.aQS() != null && bkVar.aQS().user_info != null && bkVar.aQS().user_info.is_official == 2) {
                TiebaStatic.log(new an("c12800").dh("tid", bkVar.getId()));
            }
        }
    }

    private void f(bk bkVar, String str) {
        TiebaStatic.log(new an("c12126").dh("tid", bkVar.getId()).ag("obj_locate", this.fHD ? 2 : 1).s("obj_id", bkVar.aQS().live_id).ag("obj_type", 2));
        if (bkVar.aQS() != null && bkVar.aQS().user_info != null && bkVar.aQS().user_info.is_official == 2) {
            TiebaStatic.log(new an("c12801").dh("tid", bkVar.getId()));
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (str.equals("frs_live_play")) {
            if (bkVar.aQC().equals(this.mForumName)) {
                TiebaStatic.log(new an("c11843").dh("uid", currentAccount).s("fid", bkVar.getFid()));
            } else {
                TiebaStatic.log(new an("c11845").dh("uid", currentAccount).s("fid", bkVar.getFid()));
            }
        }
    }

    public void b(Context context, bk bkVar) {
        String str;
        if (context != null && bkVar != null && bkVar.aQS() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(context, (int) R.string.no_network_guide);
                return;
            }
            String str2 = this.fHE ? "frs_live_stage_live" : "frs_play";
            if (bkVar.aQj() != null) {
                str2 = bkVar.aQj();
            }
            int frsCurTabType = TbSingleton.getInstance().getFrsCurTabType();
            if (frsCurTabType == 14) {
                str = AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_NEW + bkVar.getFid();
            } else {
                str = frsCurTabType == 13 ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_HOT + bkVar.getFid() : str2;
            }
            f(bkVar, str);
            AlaInfoData aQS = bkVar.aQS();
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && bkVar.aQx() != null) {
                z = TextUtils.equals(bkVar.aQx().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(aQS);
            if (aQS.user_info != null) {
                alaLiveInfoCoreData.userName = aQS.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, str, "", z, this.mForumName)));
        }
    }

    public void qA(int i) {
        if (this.adw != 0) {
            if (i == 1) {
                this.fGz.setVisibility(8);
                this.fHl.setData((bk) this.adw);
                return;
            }
            this.fGA.setVisibility(this.fGz.setData((bk) this.adw) ? 8 : 0);
            this.fHl.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aeX = str;
    }

    public int pa(int i) {
        return com.baidu.tieba.a.d.bmb().as(this.aeX, i);
    }
}
