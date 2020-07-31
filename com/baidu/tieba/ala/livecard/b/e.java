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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.y;
import com.baidu.tieba.pb.ThreadSkinView;
import tbclient.AppPosInfo;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.a<bv> implements com.baidu.tieba.a.e, y {
    private CardUserInfoLayout adW;
    private String afx;
    private final View.OnClickListener ahD;
    public TbImageView eRr;
    private TextView eRx;
    private RelativeLayout fWZ;
    protected ThreadSourceShareAndPraiseLayout fXN;
    private com.baidu.tieba.ala.livecard.vc.a fXU;
    public ThreadSkinView fXY;
    private TbImageView fXZ;
    private View fXc;
    public RelativeLayout fYa;
    private TBLottieAnimationView fYb;
    private TextView fYc;
    private LinearLayout fYd;
    private View fYe;
    private boolean fYf;
    private boolean fYg;
    public LinearLayout fiQ;
    private String mForumName;
    private int mLastScreenWidth;
    private View mMaskView;
    private TextView mTextTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.fYf = false;
        this.mLastScreenWidth = 0;
        this.ahD = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.bRn() != null) {
                    e.this.bRn().a(view, e.this.adQ);
                }
            }
        };
        setTag(bdUniqueId);
        this.dVN = tbPageContext;
        View view = getView();
        this.fWZ = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fiQ = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.fWZ.setOnClickListener(this);
        this.fXZ = (TbImageView) view.findViewById(R.id.video_card_stage_view);
        this.fXZ.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.fXZ.setDefaultBgResource(R.color.transparent);
        this.adW = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.adW.setUserAfterClickListener(this.ahD);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fYa = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.eRr = (TbImageView) view.findViewById(R.id.image_video);
        this.eRr.setDrawCorner(true);
        this.eRr.setPlaceHolder(3);
        this.eRr.setDefaultResource(0);
        this.eRr.setDefaultErrorResource(0);
        this.eRr.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        TbImageView tbImageView = this.eRr;
        TbImageView tbImageView2 = this.eRr;
        tbImageView.setConrers(15);
        this.eRr.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eRr.setBorderColor(ao.getColor(R.color.cp_border_a));
        this.eRr.setBorderSurroundContent(true);
        this.eRr.setDrawBorder(true);
        this.fYd = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
        this.fYb = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.fYb.loop(true);
        ao.a(this.fYb, R.raw.ala_live2);
        this.fYb.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.e.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                e.this.fYb.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                e.this.fYb.cancelAnimation();
            }
        });
        this.eRx = (TextView) view.findViewById(R.id.play_count);
        this.fYc = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.fYe = view.findViewById(R.id.play_count_line);
        this.fXb = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        b(this.fXb);
        this.fXb.setSelectVisible(false);
        this.fXb.setIsBarViewVisible(false);
        this.fXb.setCommentNumEnable(true);
        this.fXb.setLiveShareEnable(false);
        this.fXb.setFrom(2);
        this.fXb.getCommentContainer().setOnClickListener(this);
        this.fXb.hideDisagree();
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dNB = 2;
        cVar.dNH = 2;
        this.fXb.setAgreeStatisticData(cVar);
        this.gUl = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.gUl);
        this.gUl.setFrom(2);
        this.gUl.setShareReportFrom(1);
        this.fXN = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.fXN.ekZ.setOnClickListener(this);
        this.fXN.ekZ.getCommentContainer().setOnClickListener(this);
        this.fXN.setFrom(2);
        this.fXN.setShareReportFrom(1);
        this.fXN.setSourceFromForPb(3);
        this.fXN.setStType("frs_page");
        this.fXN.setHideBarName(true);
        this.fXc = view.findViewById(R.id.divider_below_reply_number_layout);
        this.fXY = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.fXU = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.adW.getSuffixContainer());
        this.fXU.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.b
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            d(tbPageContext, i);
            ao.setBackgroundResource(this.fWZ, R.drawable.addresslist_item_bg);
            ao.setBackgroundResource(this.fYa, R.drawable.bg_ala_shape);
            int dimens = l.getDimens(getContext(), R.dimen.tbds10);
            ao.a(this.fYd, R.color.cp_other_d, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, 0.0f, 0.0f, dimens, dimens, 0.0f, 0.0f});
            ao.setBackgroundColor(this.fYe, R.color.cp_cont_a);
            ao.setViewTextColor(this.eRx, R.color.cp_cont_a);
            ao.setViewTextColor(this.fYc, R.color.cp_cont_a);
            this.adW.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.eRr.setPlaceHolder(3);
            this.fXb.onChangeSkinType();
            this.mSkinType = i;
            if (this.fXN != null && this.fXN.getVisibility() == 0) {
                this.fXN.onChangeSkinType();
            }
        }
        if (this.adQ != 0 && m.EA(((bv) this.adQ).getId())) {
            ao.setViewTextColor(this.mTextTitle, R.color.cp_cont_d);
        } else {
            ao.setViewTextColor(this.mTextTitle, R.color.cp_cont_b);
        }
        ao.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.fXU.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_video_layout_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bv bvVar) {
        this.adQ = bvVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void rn(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.b.caw().caq() && !com.baidu.tieba.frs.a.cap().caq()) {
            if (view == this.fWZ || view == this.fXb.getCommentContainer() || view == this.fiQ || view == this.fXN.ekZ.getCommentContainer() || view == this.gUl.getCommentContainer()) {
                if (this.adQ != 0) {
                    m.Ez(((bv) this.adQ).getId());
                }
                if (bRn() != null) {
                    bRn().a(this.fWZ, this.adQ);
                }
                b(getContext(), (bv) this.adQ);
                if (this.adQ != 0) {
                    if (view == this.fXb.getCommentContainer() || view == this.fXN.ekZ.getCommentContainer()) {
                        ap apVar = new ap("c12942");
                        apVar.ah("obj_locate", 2);
                        apVar.ah("obj_type", 5);
                        apVar.dn("tid", ((bv) this.adQ).getTid());
                        apVar.dn("nid", ((bv) this.adQ).getNid());
                        TiebaStatic.log(apVar);
                    }
                }
            } else if (view.getId() == R.id.video_container) {
                if (bRn() != null) {
                    bRn().a(view, this.adQ);
                }
                b(getContext(), (bv) this.adQ);
            }
        }
    }

    private void refreshView() {
        SparseArray<String> sparseArray;
        if (this.adQ == 0 || ((bv) this.adQ).aWl() == null) {
            this.fWZ.setVisibility(8);
            return;
        }
        this.fWZ.setVisibility(0);
        int equipmentWidth = l.getEquipmentWidth(this.dVN.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fYa.getLayoutParams();
            layoutParams.width = equipmentWidth - l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.fYa.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (((bv) this.adQ).aWF() != null && ((bv) this.adQ).aWF().user_info != null && ((bv) this.adQ).aWF().user_info.is_official == 2) {
            this.fYg = true;
            SparseArray<String> sparseArray2 = ((bv) this.adQ).aWF().dislikeInfo;
            this.fXZ.setVisibility(0);
            int[] screenDimensions = l.getScreenDimensions(getContext());
            ViewGroup.LayoutParams layoutParams2 = this.fXZ.getLayoutParams();
            layoutParams2.width = screenDimensions[0];
            layoutParams2.height = (screenDimensions[0] * 156) / 1080;
            this.fXZ.setLayoutParams(layoutParams2);
            if (!TextUtils.isEmpty(((bv) this.adQ).aWF().liveStagePicUrl)) {
                this.fXZ.startLoad(((bv) this.adQ).aWF().liveStagePicUrl, 10, false);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.adW.getLayoutParams();
            marginLayoutParams.topMargin = this.dVN.getResources().getDimensionPixelSize(R.dimen.tbds24);
            this.adW.setLayoutParams(marginLayoutParams);
            sparseArray = sparseArray2;
        } else {
            this.fYg = false;
            this.fXZ.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.adW.getLayoutParams();
            marginLayoutParams2.topMargin = this.dVN.getResources().getDimensionPixelSize(R.dimen.tbds44);
            this.adW.setLayoutParams(marginLayoutParams2);
            sparseArray = null;
        }
        if (this.fYg && sparseArray != null && sparseArray.size() > 0) {
            this.fXU.l((bv) this.adQ, "ala_frs_demo_hell_live_feed_back_type");
        } else if (this.fXU.bCv() != null) {
            this.fXU.bCv().setVisibility(8);
        }
        ((bv) this.adQ).w(false, true);
        this.adW.setData((bv) this.adQ);
        SpannableStringBuilder aWV = ((bv) this.adQ).aWV();
        if (aWV != null && !StringUtils.isNull(aWV.toString())) {
            this.mTextTitle.setText(((bv) this.adQ).aWV());
            this.mTextTitle.setVisibility(0);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (((bv) this.adQ).aWF().audience_count > 0) {
            this.fYe.setVisibility(0);
            this.eRx.setVisibility(0);
            this.eRx.setText(String.format(this.dVN.getResources().getString(R.string.ala_audience_count_prefix), as.numFormatOverWan(((bv) this.adQ).aWF().audience_count)));
        } else {
            this.fYe.setVisibility(8);
            this.eRx.setVisibility(8);
        }
        this.fYc.setVisibility(8);
        if (((bv) this.adQ).aWF().openRecomReason == 1) {
            String str = ((bv) this.adQ).aWF().recomReason;
            if (!StringUtils.isNull(str)) {
                this.fYc.setVisibility(0);
                this.fYc.setText(str);
            } else {
                String aWA = ((bv) this.adQ).aWA();
                String aWB = ((bv) this.adQ).aWB();
                if (UtilHelper.isDecimal(aWA) && UtilHelper.isDecimal(aWB) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo dcR = com.baidu.tieba.recapp.d.a.dcN().dcR();
                    String str2 = dcR.latitude;
                    String str3 = dcR.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(aWA), Double.parseDouble(aWB)) <= 50.0d) {
                        this.fYc.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.fYc.setVisibility(0);
                    }
                }
            }
        }
        rp(pM(1));
        V((bv) this.adQ);
        this.mMaskView.setVisibility((com.baidu.tieba.frs.b.caw().caq() || com.baidu.tieba.frs.a.cap().caq()) ? 0 : 8);
        onChangeSkinType(this.dVN, TbadkCoreApplication.getInst().getSkinType());
        bCz();
        this.fYb.playAnimation();
        aO(this.fWZ);
    }

    public void bCz() {
        if (k.aTv().isShowImages() && this.adQ != 0 && ((bv) this.adQ).aTN() != null && ((bv) this.adQ).aTN().aWF() != null) {
            this.eRr.setPlaceHolder(3);
            this.eRr.startLoad(((bv) this.adQ).aTN().aWF().cover, 10, false);
            this.fYa.setVisibility(0);
            return;
        }
        this.fYa.setVisibility(8);
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.fXb != null) {
            if (this.adW != null) {
                this.adW.setPageUniqueId(bdUniqueId);
            }
            setTag(bdUniqueId);
            r(bdUniqueId);
        }
    }

    public void kY(boolean z) {
        this.fYf = z;
    }

    private void V(bv bvVar) {
        if (bvVar != null) {
            TiebaStatic.log(new ap("c12125").dn("tid", bvVar.getId()).ah("obj_locate", this.fYf ? 2 : 1).t("obj_id", bvVar.aWF().live_id).ah("obj_type", 2));
            if (bvVar.aWF() != null && bvVar.aWF().user_info != null && bvVar.aWF().user_info.is_official == 2) {
                TiebaStatic.log(new ap("c12800").dn("tid", bvVar.getId()));
            }
        }
    }

    private void m(bv bvVar, String str) {
        TiebaStatic.log(new ap("c12126").dn("tid", bvVar.getId()).ah("obj_locate", this.fYf ? 2 : 1).t("obj_id", bvVar.aWF().live_id).ah("obj_type", 2));
        if (bvVar.aWF() != null && bvVar.aWF().user_info != null && bvVar.aWF().user_info.is_official == 2) {
            TiebaStatic.log(new ap("c12801").dn("tid", bvVar.getId()));
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (str.equals("frs_live_play")) {
            if (bvVar.aWp().equals(this.mForumName)) {
                TiebaStatic.log(new ap("c11843").dn("uid", currentAccount).t("fid", bvVar.getFid()));
            } else {
                TiebaStatic.log(new ap("c11845").dn("uid", currentAccount).t("fid", bvVar.getFid()));
            }
        }
    }

    public void b(Context context, bv bvVar) {
        String str;
        if (context != null && bvVar != null && bvVar.aWF() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(context, R.string.no_network_guide);
                return;
            }
            String str2 = this.fYg ? "frs_live_stage_live" : "frs_play";
            if (bvVar.aVX() != null) {
                str2 = bvVar.aVX();
            }
            int frsCurTabType = TbSingleton.getInstance().getFrsCurTabType();
            if (frsCurTabType == 14) {
                str = AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_NEW + bvVar.getFid();
            } else {
                str = frsCurTabType == 13 ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_HOT + bvVar.getFid() : str2;
            }
            m(bvVar, str);
            AlaInfoData aWF = bvVar.aWF();
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && bvVar.aWl() != null) {
                z = TextUtils.equals(bvVar.aWl().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(aWF);
            if (aWF.user_info != null) {
                alaLiveInfoCoreData.userName = aWF.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, str, "", z, this.mForumName)));
        }
    }

    public void rp(int i) {
        if (this.adQ != 0) {
            if (i == 1) {
                this.fXb.setVisibility(8);
                this.fXN.setData((bv) this.adQ);
                return;
            }
            this.fXc.setVisibility(this.fXb.setData((bv) this.adQ) ? 8 : 0);
            this.fXN.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.afx = str;
    }

    public int pM(int i) {
        return com.baidu.tieba.a.d.brD().ar(this.afx, i);
    }
}
