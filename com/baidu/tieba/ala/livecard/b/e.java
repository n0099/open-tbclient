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
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.z;
import com.baidu.tieba.pb.ThreadSkinView;
import tbclient.AppPosInfo;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.a<bw> implements com.baidu.tieba.a.e, z {
    private CardUserInfoLayout afO;
    private String ahu;
    private final View.OnClickListener ajG;
    private TextView fFC;
    public TbImageView fFw;
    public LinearLayout fXV;
    private RelativeLayout gSP;
    private View gSS;
    protected ThreadSourceShareAndPraiseLayout gTD;
    private com.baidu.tieba.ala.livecard.vc.a gTK;
    public ThreadSkinView gTO;
    private TbImageView gTP;
    public RelativeLayout gTQ;
    private TBLottieAnimationView gTR;
    private TextView gTS;
    private LinearLayout gTT;
    private View gTU;
    private boolean gTV;
    private boolean gTW;
    private String mForumName;
    private int mLastScreenWidth;
    private View mMaskView;
    private TextView mTextTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.gTV = false;
        this.mLastScreenWidth = 0;
        this.ajG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.cnT() != null) {
                    e.this.cnT().a(view, e.this.afI);
                }
            }
        };
        setTag(bdUniqueId);
        this.eIc = tbPageContext;
        View view = getView();
        this.gSP = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fXV = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.gSP.setOnClickListener(this);
        this.gTP = (TbImageView) view.findViewById(R.id.video_card_stage_view);
        this.gTP.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.gTP.setDefaultBgResource(R.color.transparent);
        this.afO = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.afO.setUserAfterClickListener(this.ajG);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gTQ = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.fFw = (TbImageView) view.findViewById(R.id.image_video);
        this.fFw.setDrawCorner(true);
        this.fFw.setPlaceHolder(3);
        this.fFw.setDefaultResource(0);
        this.fFw.setDefaultErrorResource(0);
        this.fFw.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        TbImageView tbImageView = this.fFw;
        TbImageView tbImageView2 = this.fFw;
        tbImageView.setConrers(15);
        this.fFw.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fFw.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.fFw.setBorderSurroundContent(true);
        this.fFw.setDrawBorder(true);
        this.gTT = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
        this.gTR = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.gTR.loop(true);
        ap.a(this.gTR, (int) R.raw.ala_live2);
        this.gTR.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.e.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                e.this.gTR.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                e.this.gTR.cancelAnimation();
            }
        });
        this.fFC = (TextView) view.findViewById(R.id.play_count);
        this.gTS = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.gTU = view.findViewById(R.id.play_count_line);
        this.gSR = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        b(this.gSR);
        this.gSR.setSelectVisible(false);
        this.gSR.setIsBarViewVisible(false);
        this.gSR.setCommentNumEnable(true);
        this.gSR.setLiveShareEnable(false);
        this.gSR.setFrom(2);
        this.gSR.getCommentContainer().setOnClickListener(this);
        this.gSR.hideDisagree();
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.ezt = 2;
        cVar.ezz = 2;
        this.gSR.setAgreeStatisticData(cVar);
        this.hVy = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.hVy);
        this.hVy.setFrom(2);
        this.hVy.setShareReportFrom(1);
        this.gTD = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.gTD.eXx.setOnClickListener(this);
        this.gTD.eXx.getCommentContainer().setOnClickListener(this);
        this.gTD.setFrom(2);
        this.gTD.setShareReportFrom(1);
        this.gTD.setSourceFromForPb(3);
        this.gTD.setStType("frs_page");
        this.gTD.setHideBarName(true);
        this.gSS = view.findViewById(R.id.divider_below_reply_number_layout);
        this.gTO = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.gTK = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.afO.getSuffixContainer());
        this.gTK.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.b
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            g(tbPageContext, i);
            ap.setBackgroundResource(this.gSP, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.gTQ, R.drawable.bg_ala_shape);
            int dimens = l.getDimens(getContext(), R.dimen.tbds10);
            ap.a(this.gTT, (int) R.color.cp_other_d, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, 0.0f, 0.0f, dimens, dimens, 0.0f, 0.0f});
            ap.setBackgroundColor(this.gTU, R.color.cp_cont_a);
            ap.setViewTextColor(this.fFC, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.gTS, (int) R.color.cp_cont_a);
            this.afO.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fFw.setPlaceHolder(3);
            this.gSR.onChangeSkinType();
            this.mSkinType = i;
            if (this.gTD != null && this.gTD.getVisibility() == 0) {
                this.gTD.onChangeSkinType();
            }
        }
        if (this.afI != 0 && n.Ja(((bw) this.afI).getId())) {
            ap.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            ap.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
        ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.gTK.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_video_layout_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bw bwVar) {
        this.afI = bwVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void vd(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.b.cxm().cxg() && !com.baidu.tieba.frs.a.cxf().cxg()) {
            if (view == this.gSP || view == this.gSR.getCommentContainer() || view == this.fXV || view == this.gTD.eXx.getCommentContainer() || view == this.hVy.getCommentContainer()) {
                if (this.afI != 0) {
                    n.IZ(((bw) this.afI).getId());
                }
                if (cnT() != null) {
                    cnT().a(this.gSP, this.afI);
                }
                b(getContext(), (bw) this.afI);
                if (this.afI != 0) {
                    if (view == this.gSR.getCommentContainer() || view == this.gTD.eXx.getCommentContainer()) {
                        aq aqVar = new aq("c12942");
                        aqVar.al("obj_locate", 2);
                        aqVar.al("obj_type", 5);
                        aqVar.dR("tid", ((bw) this.afI).getTid());
                        aqVar.dR("nid", ((bw) this.afI).getNid());
                        TiebaStatic.log(aqVar);
                    }
                }
            } else if (view.getId() == R.id.video_container) {
                if (cnT() != null) {
                    cnT().a(view, this.afI);
                }
                b(getContext(), (bw) this.afI);
            }
        }
    }

    private void refreshView() {
        SparseArray<String> sparseArray;
        if (this.afI == 0 || ((bw) this.afI).bmA() == null) {
            this.gSP.setVisibility(8);
            return;
        }
        this.gSP.setVisibility(0);
        int equipmentWidth = l.getEquipmentWidth(this.eIc.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gTQ.getLayoutParams();
            layoutParams.width = equipmentWidth - l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.gTQ.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (((bw) this.afI).bmU() != null && ((bw) this.afI).bmU().user_info != null && ((bw) this.afI).bmU().user_info.is_official == 2) {
            this.gTW = true;
            SparseArray<String> sparseArray2 = ((bw) this.afI).bmU().dislikeInfo;
            this.gTP.setVisibility(0);
            int[] screenDimensions = l.getScreenDimensions(getContext());
            ViewGroup.LayoutParams layoutParams2 = this.gTP.getLayoutParams();
            layoutParams2.width = screenDimensions[0];
            layoutParams2.height = (screenDimensions[0] * 156) / 1080;
            this.gTP.setLayoutParams(layoutParams2);
            if (!TextUtils.isEmpty(((bw) this.afI).bmU().liveStagePicUrl)) {
                this.gTP.startLoad(((bw) this.afI).bmU().liveStagePicUrl, 10, false);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.afO.getLayoutParams();
            marginLayoutParams.topMargin = this.eIc.getResources().getDimensionPixelSize(R.dimen.tbds24);
            this.afO.setLayoutParams(marginLayoutParams);
            sparseArray = sparseArray2;
        } else {
            this.gTW = false;
            this.gTP.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.afO.getLayoutParams();
            marginLayoutParams2.topMargin = this.eIc.getResources().getDimensionPixelSize(R.dimen.tbds44);
            this.afO.setLayoutParams(marginLayoutParams2);
            sparseArray = null;
        }
        if (this.gTW && sparseArray != null && sparseArray.size() > 0) {
            this.gTK.l((bw) this.afI, "ala_frs_demo_hell_live_feed_back_type");
        } else if (this.gTK.bVW() != null) {
            this.gTK.bVW().setVisibility(8);
        }
        ((bw) this.afI).z(false, true);
        this.afO.setData((bw) this.afI);
        SpannableStringBuilder bnk = ((bw) this.afI).bnk();
        if (bnk != null && !StringUtils.isNull(bnk.toString())) {
            this.mTextTitle.setText(((bw) this.afI).bnk());
            this.mTextTitle.setVisibility(0);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (((bw) this.afI).bmU().audience_count > 0) {
            this.gTU.setVisibility(0);
            this.fFC.setVisibility(0);
            this.fFC.setText(String.format(this.eIc.getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(((bw) this.afI).bmU().audience_count)));
        } else {
            this.gTU.setVisibility(8);
            this.fFC.setVisibility(8);
        }
        this.gTS.setVisibility(8);
        if (((bw) this.afI).bmU().openRecomReason == 1) {
            String str = ((bw) this.afI).bmU().recomReason;
            if (!StringUtils.isNull(str)) {
                this.gTS.setVisibility(0);
                this.gTS.setText(str);
            } else {
                String bmP = ((bw) this.afI).bmP();
                String bmQ = ((bw) this.afI).bmQ();
                if (UtilHelper.isDecimal(bmP) && UtilHelper.isDecimal(bmQ) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo dBh = com.baidu.tieba.recapp.d.a.dBc().dBh();
                    String str2 = dBh.latitude;
                    String str3 = dBh.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(bmP), Double.parseDouble(bmQ)) <= 50.0d) {
                        this.gTS.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.gTS.setVisibility(0);
                    }
                }
            }
        }
        vf(tj(1));
        W((bw) this.afI);
        this.mMaskView.setVisibility((com.baidu.tieba.frs.b.cxm().cxg() || com.baidu.tieba.frs.a.cxf().cxg()) ? 0 : 8);
        onChangeSkinType(this.eIc, TbadkCoreApplication.getInst().getSkinType());
        bWa();
        this.gTR.playAnimation();
        aS(this.gSP);
    }

    public void bWa() {
        if (k.bjH().isShowImages() && this.afI != 0 && ((bw) this.afI).bjZ() != null && ((bw) this.afI).bjZ().bmU() != null) {
            this.fFw.setPlaceHolder(3);
            this.fFw.startLoad(((bw) this.afI).bjZ().bmU().cover, 10, false);
            this.gTQ.setVisibility(0);
            return;
        }
        this.gTQ.setVisibility(8);
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gSR != null) {
            if (this.afO != null) {
                this.afO.setPageUniqueId(bdUniqueId);
            }
            setTag(bdUniqueId);
            q(bdUniqueId);
        }
    }

    public void mF(boolean z) {
        this.gTV = z;
    }

    private void W(bw bwVar) {
        if (bwVar != null) {
            TiebaStatic.log(new aq("c12125").dR("tid", bwVar.getId()).al("obj_locate", this.gTV ? 2 : 1).w("obj_id", bwVar.bmU().live_id).al("obj_type", 2));
            if (bwVar.bmU() != null && bwVar.bmU().user_info != null && bwVar.bmU().user_info.is_official == 2) {
                TiebaStatic.log(new aq("c12800").dR("tid", bwVar.getId()));
            }
        }
    }

    private void m(bw bwVar, String str) {
        TiebaStatic.log(new aq("c12126").dR("tid", bwVar.getId()).al("obj_locate", this.gTV ? 2 : 1).w("obj_id", bwVar.bmU().live_id).al("obj_type", 2));
        if (bwVar.bmU() != null && bwVar.bmU().user_info != null && bwVar.bmU().user_info.is_official == 2) {
            TiebaStatic.log(new aq("c12801").dR("tid", bwVar.getId()));
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (str.equals("frs_live_play")) {
            if (bwVar.bmE().equals(this.mForumName)) {
                TiebaStatic.log(new aq("c11843").dR("uid", currentAccount).w("fid", bwVar.getFid()));
            } else {
                TiebaStatic.log(new aq("c11845").dR("uid", currentAccount).w("fid", bwVar.getFid()));
            }
        }
    }

    public void b(Context context, bw bwVar) {
        String str;
        if (context != null && bwVar != null && bwVar.bmU() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(context, (int) R.string.no_network_guide);
                return;
            }
            String str2 = this.gTW ? "frs_live_stage_live" : "frs_play";
            if (bwVar.bmm() != null) {
                str2 = bwVar.bmm();
            }
            int frsCurTabType = TbSingleton.getInstance().getFrsCurTabType();
            if (frsCurTabType == 14) {
                str = AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_NEW + bwVar.getFid();
            } else {
                str = frsCurTabType == 13 ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_HOT + bwVar.getFid() : str2;
            }
            m(bwVar, str);
            AlaInfoData bmU = bwVar.bmU();
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && bwVar.bmA() != null) {
                z = TextUtils.equals(bwVar.bmA().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bmU);
            if (bmU.user_info != null) {
                alaLiveInfoCoreData.userName = bmU.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, str, "", z, this.mForumName)));
        }
    }

    public void vf(int i) {
        if (this.afI != 0) {
            if (i == 1) {
                this.gSR.setVisibility(8);
                this.gTD.setData((bw) this.afI);
                return;
            }
            this.gSS.setVisibility(this.gSR.setData((bw) this.afI) ? 8 : 0);
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
}
