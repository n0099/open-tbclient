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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
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
public class e extends com.baidu.tieba.card.a<bw> implements com.baidu.tieba.a.e, y {
    private CardUserInfoLayout afc;
    private String agH;
    private final View.OnClickListener aiR;
    public TbImageView fbX;
    private TextView fcd;
    public LinearLayout fum;
    private RelativeLayout giY;
    protected ThreadSourceShareAndPraiseLayout gjM;
    private com.baidu.tieba.ala.livecard.vc.a gjT;
    public ThreadSkinView gjX;
    private TbImageView gjY;
    public RelativeLayout gjZ;
    private View gjb;
    private TBLottieAnimationView gka;
    private TextView gkb;
    private LinearLayout gkc;
    private View gkd;
    private boolean gke;
    private boolean gkf;
    private String mForumName;
    private int mLastScreenWidth;
    private View mMaskView;
    private TextView mTextTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.gke = false;
        this.mLastScreenWidth = 0;
        this.aiR = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.cbz() != null) {
                    e.this.cbz().a(view, e.this.aeW);
                }
            }
        };
        setTag(bdUniqueId);
        this.efn = tbPageContext;
        View view = getView();
        this.giY = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fum = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.giY.setOnClickListener(this);
        this.gjY = (TbImageView) view.findViewById(R.id.video_card_stage_view);
        this.gjY.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.gjY.setDefaultBgResource(R.color.transparent);
        this.afc = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.afc.setUserAfterClickListener(this.aiR);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gjZ = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.fbX = (TbImageView) view.findViewById(R.id.image_video);
        this.fbX.setDrawCorner(true);
        this.fbX.setPlaceHolder(3);
        this.fbX.setDefaultResource(0);
        this.fbX.setDefaultErrorResource(0);
        this.fbX.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        TbImageView tbImageView = this.fbX;
        TbImageView tbImageView2 = this.fbX;
        tbImageView.setConrers(15);
        this.fbX.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fbX.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.fbX.setBorderSurroundContent(true);
        this.fbX.setDrawBorder(true);
        this.gkc = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
        this.gka = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.gka.loop(true);
        ap.a(this.gka, (int) R.raw.ala_live2);
        this.gka.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.e.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                e.this.gka.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                e.this.gka.cancelAnimation();
            }
        });
        this.fcd = (TextView) view.findViewById(R.id.play_count);
        this.gkb = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.gkd = view.findViewById(R.id.play_count_line);
        this.gja = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        b(this.gja);
        this.gja.setSelectVisible(false);
        this.gja.setIsBarViewVisible(false);
        this.gja.setCommentNumEnable(true);
        this.gja.setLiveShareEnable(false);
        this.gja.setFrom(2);
        this.gja.getCommentContainer().setOnClickListener(this);
        this.gja.hideDisagree();
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dWK = 2;
        cVar.dWQ = 2;
        this.gja.setAgreeStatisticData(cVar);
        this.hhd = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.hhd);
        this.hhd.setFrom(2);
        this.hhd.setShareReportFrom(1);
        this.gjM = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.gjM.euU.setOnClickListener(this);
        this.gjM.euU.getCommentContainer().setOnClickListener(this);
        this.gjM.setFrom(2);
        this.gjM.setShareReportFrom(1);
        this.gjM.setSourceFromForPb(3);
        this.gjM.setStType("frs_page");
        this.gjM.setHideBarName(true);
        this.gjb = view.findViewById(R.id.divider_below_reply_number_layout);
        this.gjX = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.gjT = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.afc.getSuffixContainer());
        this.gjT.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.b
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            g(tbPageContext, i);
            ap.setBackgroundResource(this.giY, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.gjZ, R.drawable.bg_ala_shape);
            int dimens = l.getDimens(getContext(), R.dimen.tbds10);
            ap.a(this.gkc, (int) R.color.cp_other_d, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, 0.0f, 0.0f, dimens, dimens, 0.0f, 0.0f});
            ap.setBackgroundColor(this.gkd, R.color.cp_cont_a);
            ap.setViewTextColor(this.fcd, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.gkb, (int) R.color.cp_cont_a);
            this.afc.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fbX.setPlaceHolder(3);
            this.gja.onChangeSkinType();
            this.mSkinType = i;
            if (this.gjM != null && this.gjM.getVisibility() == 0) {
                this.gjM.onChangeSkinType();
            }
        }
        if (this.aeW != 0 && m.GZ(((bw) this.aeW).getId())) {
            ap.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            ap.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
        ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.gjT.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_video_layout_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bw bwVar) {
        this.aeW = bwVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void tz(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.b.ckS().ckM() && !com.baidu.tieba.frs.a.ckL().ckM()) {
            if (view == this.giY || view == this.gja.getCommentContainer() || view == this.fum || view == this.gjM.euU.getCommentContainer() || view == this.hhd.getCommentContainer()) {
                if (this.aeW != 0) {
                    m.GY(((bw) this.aeW).getId());
                }
                if (cbz() != null) {
                    cbz().a(this.giY, this.aeW);
                }
                b(getContext(), (bw) this.aeW);
                if (this.aeW != 0) {
                    if (view == this.gja.getCommentContainer() || view == this.gjM.euU.getCommentContainer()) {
                        aq aqVar = new aq("c12942");
                        aqVar.ai("obj_locate", 2);
                        aqVar.ai("obj_type", 5);
                        aqVar.dD("tid", ((bw) this.aeW).getTid());
                        aqVar.dD("nid", ((bw) this.aeW).getNid());
                        TiebaStatic.log(aqVar);
                    }
                }
            } else if (view.getId() == R.id.video_container) {
                if (cbz() != null) {
                    cbz().a(view, this.aeW);
                }
                b(getContext(), (bw) this.aeW);
            }
        }
    }

    private void refreshView() {
        SparseArray<String> sparseArray;
        if (this.aeW == 0 || ((bw) this.aeW).beE() == null) {
            this.giY.setVisibility(8);
            return;
        }
        this.giY.setVisibility(0);
        int equipmentWidth = l.getEquipmentWidth(this.efn.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gjZ.getLayoutParams();
            layoutParams.width = equipmentWidth - l.getDimens(this.efn.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.gjZ.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (((bw) this.aeW).beY() != null && ((bw) this.aeW).beY().user_info != null && ((bw) this.aeW).beY().user_info.is_official == 2) {
            this.gkf = true;
            SparseArray<String> sparseArray2 = ((bw) this.aeW).beY().dislikeInfo;
            this.gjY.setVisibility(0);
            int[] screenDimensions = l.getScreenDimensions(getContext());
            ViewGroup.LayoutParams layoutParams2 = this.gjY.getLayoutParams();
            layoutParams2.width = screenDimensions[0];
            layoutParams2.height = (screenDimensions[0] * 156) / 1080;
            this.gjY.setLayoutParams(layoutParams2);
            if (!TextUtils.isEmpty(((bw) this.aeW).beY().liveStagePicUrl)) {
                this.gjY.startLoad(((bw) this.aeW).beY().liveStagePicUrl, 10, false);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.afc.getLayoutParams();
            marginLayoutParams.topMargin = this.efn.getResources().getDimensionPixelSize(R.dimen.tbds24);
            this.afc.setLayoutParams(marginLayoutParams);
            sparseArray = sparseArray2;
        } else {
            this.gkf = false;
            this.gjY.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.afc.getLayoutParams();
            marginLayoutParams2.topMargin = this.efn.getResources().getDimensionPixelSize(R.dimen.tbds44);
            this.afc.setLayoutParams(marginLayoutParams2);
            sparseArray = null;
        }
        if (this.gkf && sparseArray != null && sparseArray.size() > 0) {
            this.gjT.l((bw) this.aeW, "ala_frs_demo_hell_live_feed_back_type");
        } else if (this.gjT.bLP() != null) {
            this.gjT.bLP().setVisibility(8);
        }
        ((bw) this.aeW).z(false, true);
        this.afc.setData((bw) this.aeW);
        SpannableStringBuilder bfo = ((bw) this.aeW).bfo();
        if (bfo != null && !StringUtils.isNull(bfo.toString())) {
            this.mTextTitle.setText(((bw) this.aeW).bfo());
            this.mTextTitle.setVisibility(0);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (((bw) this.aeW).beY().audience_count > 0) {
            this.gkd.setVisibility(0);
            this.fcd.setVisibility(0);
            this.fcd.setText(String.format(this.efn.getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(((bw) this.aeW).beY().audience_count)));
        } else {
            this.gkd.setVisibility(8);
            this.fcd.setVisibility(8);
        }
        this.gkb.setVisibility(8);
        if (((bw) this.aeW).beY().openRecomReason == 1) {
            String str = ((bw) this.aeW).beY().recomReason;
            if (!StringUtils.isNull(str)) {
                this.gkb.setVisibility(0);
                this.gkb.setText(str);
            } else {
                String beT = ((bw) this.aeW).beT();
                String beU = ((bw) this.aeW).beU();
                if (UtilHelper.isDecimal(beT) && UtilHelper.isDecimal(beU) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo dob = com.baidu.tieba.recapp.d.a.dnW().dob();
                    String str2 = dob.latitude;
                    String str3 = dob.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(beT), Double.parseDouble(beU)) <= 50.0d) {
                        this.gkb.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.gkb.setVisibility(0);
                    }
                }
            }
        }
        tB(rY(1));
        V((bw) this.aeW);
        this.mMaskView.setVisibility((com.baidu.tieba.frs.b.ckS().ckM() || com.baidu.tieba.frs.a.ckL().ckM()) ? 0 : 8);
        onChangeSkinType(this.efn, TbadkCoreApplication.getInst().getSkinType());
        bLT();
        this.gka.playAnimation();
        aN(this.giY);
    }

    public void bLT() {
        if (k.bbM().isShowImages() && this.aeW != 0 && ((bw) this.aeW).bce() != null && ((bw) this.aeW).bce().beY() != null) {
            this.fbX.setPlaceHolder(3);
            this.fbX.startLoad(((bw) this.aeW).bce().beY().cover, 10, false);
            this.gjZ.setVisibility(0);
            return;
        }
        this.gjZ.setVisibility(8);
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gja != null) {
            if (this.afc != null) {
                this.afc.setPageUniqueId(bdUniqueId);
            }
            setTag(bdUniqueId);
            r(bdUniqueId);
        }
    }

    public void ly(boolean z) {
        this.gke = z;
    }

    private void V(bw bwVar) {
        if (bwVar != null) {
            TiebaStatic.log(new aq("c12125").dD("tid", bwVar.getId()).ai("obj_locate", this.gke ? 2 : 1).u("obj_id", bwVar.beY().live_id).ai("obj_type", 2));
            if (bwVar.beY() != null && bwVar.beY().user_info != null && bwVar.beY().user_info.is_official == 2) {
                TiebaStatic.log(new aq("c12800").dD("tid", bwVar.getId()));
            }
        }
    }

    private void m(bw bwVar, String str) {
        TiebaStatic.log(new aq("c12126").dD("tid", bwVar.getId()).ai("obj_locate", this.gke ? 2 : 1).u("obj_id", bwVar.beY().live_id).ai("obj_type", 2));
        if (bwVar.beY() != null && bwVar.beY().user_info != null && bwVar.beY().user_info.is_official == 2) {
            TiebaStatic.log(new aq("c12801").dD("tid", bwVar.getId()));
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (str.equals("frs_live_play")) {
            if (bwVar.beI().equals(this.mForumName)) {
                TiebaStatic.log(new aq("c11843").dD("uid", currentAccount).u("fid", bwVar.getFid()));
            } else {
                TiebaStatic.log(new aq("c11845").dD("uid", currentAccount).u("fid", bwVar.getFid()));
            }
        }
    }

    public void b(Context context, bw bwVar) {
        String str;
        if (context != null && bwVar != null && bwVar.beY() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(context, (int) R.string.no_network_guide);
                return;
            }
            String str2 = this.gkf ? "frs_live_stage_live" : "frs_play";
            if (bwVar.beq() != null) {
                str2 = bwVar.beq();
            }
            int frsCurTabType = TbSingleton.getInstance().getFrsCurTabType();
            if (frsCurTabType == 14) {
                str = AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_NEW + bwVar.getFid();
            } else {
                str = frsCurTabType == 13 ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_HOT + bwVar.getFid() : str2;
            }
            m(bwVar, str);
            AlaInfoData beY = bwVar.beY();
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && bwVar.beE() != null) {
                z = TextUtils.equals(bwVar.beE().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(beY);
            if (beY.user_info != null) {
                alaLiveInfoCoreData.userName = beY.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, str, "", z, this.mForumName)));
        }
    }

    public void tB(int i) {
        if (this.aeW != 0) {
            if (i == 1) {
                this.gja.setVisibility(8);
                this.gjM.setData((bw) this.aeW);
                return;
            }
            this.gjb.setVisibility(this.gja.setData((bw) this.aeW) ? 8 : 0);
            this.gjM.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.agH = str;
    }

    public int rY(int i) {
        return com.baidu.tieba.a.d.bAA().au(this.agH, i);
    }
}
