package com.baidu.tieba.ala.livecard.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
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
/* loaded from: classes10.dex */
public class e extends com.baidu.tieba.card.a<bz> implements com.baidu.tieba.a.e, y {
    private CardUserInfoLayout aho;
    private String aji;
    private final View.OnClickListener alk;
    public TbImageView fWo;
    private TextView fWu;
    public LinearLayout gpU;
    private View hnA;
    private RelativeLayout hnx;
    private TBLottieAnimationView hoA;
    private TextView hoB;
    private LinearLayout hoC;
    private View hoD;
    private boolean hoE;
    private boolean hoF;
    protected ThreadSourceShareAndPraiseLayout hol;
    private com.baidu.tieba.ala.livecard.vc.a hos;
    public ThreadSkinView hox;
    private TbImageView hoy;
    public RelativeLayout hoz;
    private String mForumName;
    private int mLastScreenWidth;
    private View mMaskView;
    private TextView mTextTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.hoE = false;
        this.mLastScreenWidth = 0;
        this.alk = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.cuD() != null) {
                    e.this.cuD().a(view, e.this.ahi);
                }
            }
        };
        setTag(bdUniqueId);
        this.eXu = tbPageContext;
        View view = getView();
        this.hnx = (RelativeLayout) view.findViewById(R.id.layout_root);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hnx.getLayoutParams();
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        layoutParams.bottomMargin = 0;
        this.gpU = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.hnx.setOnClickListener(this);
        this.hoy = (TbImageView) view.findViewById(R.id.video_card_stage_view);
        this.hoy.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.hoy.setDefaultBgResource(R.color.transparent);
        this.aho = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.aho.setUserAfterClickListener(this.alk);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.hoz = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.fWo = (TbImageView) view.findViewById(R.id.image_video);
        this.fWo.setDrawCorner(true);
        this.fWo.setPlaceHolder(3);
        this.fWo.setDefaultResource(0);
        this.fWo.setRadiusById(R.string.J_X05);
        TbImageView tbImageView = this.fWo;
        TbImageView tbImageView2 = this.fWo;
        tbImageView.setConrers(15);
        this.fWo.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fWo.setBorderColor(ao.getColor(R.color.CAM_X0401));
        this.fWo.setBorderSurroundContent(true);
        this.fWo.setDrawBorder(true);
        this.hoC = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
        this.hoA = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.hoA.loop(true);
        ao.a(this.hoA, R.raw.ala_live2);
        this.hoA.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ala.livecard.a.e.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                e.this.hoA.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                e.this.hoA.cancelAnimation();
            }
        });
        this.fWu = (TextView) view.findViewById(R.id.play_count);
        this.hoB = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.hoD = view.findViewById(R.id.play_count_line);
        this.hnz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        b(this.hnz);
        this.hnz.setSelectVisible(false);
        this.hnz.setIsBarViewVisible(false);
        this.hnz.setCommentNumEnable(true);
        this.hnz.setLiveShareEnable(false);
        this.hnz.setFrom(2);
        this.hnz.getCommentContainer().setOnClickListener(this);
        this.hnz.hideDisagree();
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eOz = 2;
        dVar.eOF = 2;
        this.hnz.setAgreeStatisticData(dVar);
        this.its = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.its);
        this.its.setFrom(2);
        this.its.setShareReportFrom(1);
        this.hol = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.hol.fnK.setOnClickListener(this);
        this.hol.fnK.getCommentContainer().setOnClickListener(this);
        this.hol.setFrom(2);
        this.hol.setShareReportFrom(1);
        this.hol.setSourceFromForPb(3);
        this.hol.setStType("frs_page");
        this.hol.setHideBarName(true);
        this.hnA = view.findViewById(R.id.divider_below_reply_number_layout);
        this.hox = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.hos = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.aho.getSuffixContainer());
        this.hos.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.b
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            g(tbPageContext, i);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.hnx).pK(R.string.J_X06).aM(R.color.CAM_X0205, R.color.CAM_X0206);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.hoz).pN(R.dimen.L_X01).pM(R.color.CAM_X0401).pK(R.string.J_X05).setBackGroundColor(R.color.CAM_X0611);
            int dimens = l.getDimens(getContext(), R.dimen.tbds31);
            ao.a(this.hoC, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, dimens, dimens, dimens, dimens, dimens, dimens});
            ao.setBackgroundColor(this.hoD, R.color.CAM_X0101);
            ao.setViewTextColor(this.fWu, R.color.CAM_X0101);
            ao.setViewTextColor(this.hoB, R.color.CAM_X0101);
            this.aho.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fWo.setPlaceHolder(3);
            this.hnz.onChangeSkinType();
            this.mSkinType = i;
            if (this.hol != null && this.hol.getVisibility() == 0) {
                this.hol.onChangeSkinType();
            }
        }
        if (this.ahi != 0 && m.Jo(((bz) this.ahi).getId())) {
            ao.setViewTextColor(this.mTextTitle, R.color.CAM_X0109);
        } else {
            ao.setViewTextColor(this.mTextTitle, R.color.CAM_X0105);
        }
        ao.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
        this.hos.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_video_layout_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bz bzVar) {
        this.ahi = bzVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void wt(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.b.cDY().cDS() && !com.baidu.tieba.frs.a.cDR().cDS()) {
            if (view == this.hnx || view == this.hnz.getCommentContainer() || view == this.gpU || view == this.hol.fnK.getCommentContainer() || view == this.its.getCommentContainer()) {
                if (this.ahi != 0) {
                    m.Jn(((bz) this.ahi).getId());
                }
                if (cuD() != null) {
                    cuD().a(this.hnx, this.ahi);
                }
                b(getContext(), (bz) this.ahi);
                if (this.ahi != 0) {
                    if (view == this.hnz.getCommentContainer() || view == this.hol.fnK.getCommentContainer()) {
                        aq aqVar = new aq("c12942");
                        aqVar.an("obj_locate", 2);
                        aqVar.an("obj_type", 5);
                        aqVar.dX("tid", ((bz) this.ahi).getTid());
                        aqVar.dX(IntentConfig.NID, ((bz) this.ahi).bpP());
                        com.baidu.tbadk.pageExtra.c bV = com.baidu.tbadk.pageExtra.d.bV(view);
                        if (bV != null) {
                            aqVar.dX("obj_cur_page", bV.getCurrentPageKey());
                        }
                        if (com.baidu.tbadk.pageExtra.d.bHn() != null) {
                            aqVar.dX("obj_pre_page", com.baidu.tbadk.pageExtra.d.bHn());
                        }
                        TiebaStatic.log(aqVar);
                    }
                }
            } else if (view.getId() == R.id.video_container) {
                if (cuD() != null) {
                    cuD().a(view, this.ahi);
                }
                b(getContext(), (bz) this.ahi);
            }
        }
    }

    private void refreshView() {
        SparseArray<String> sparseArray;
        if (this.ahi == 0 || ((bz) this.ahi).brr() == null) {
            this.hnx.setVisibility(8);
            return;
        }
        this.hnx.setVisibility(0);
        int equipmentWidth = l.getEquipmentWidth(this.eXu.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hoz.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext()) - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.hoz.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (((bz) this.ahi).brK() != null && ((bz) this.ahi).brK().user_info != null && ((bz) this.ahi).brK().user_info.is_official == 2) {
            this.hoF = true;
            SparseArray<String> sparseArray2 = ((bz) this.ahi).brK().dislikeInfo;
            this.hoy.setVisibility(0);
            int[] screenDimensions = l.getScreenDimensions(getContext());
            ViewGroup.LayoutParams layoutParams2 = this.hoy.getLayoutParams();
            layoutParams2.width = screenDimensions[0];
            layoutParams2.height = (screenDimensions[0] * 156) / 1080;
            this.hoy.setLayoutParams(layoutParams2);
            if (!TextUtils.isEmpty(((bz) this.ahi).brK().liveStagePicUrl)) {
                this.hoy.startLoad(((bz) this.ahi).brK().liveStagePicUrl, 10, false);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.aho.getLayoutParams();
            marginLayoutParams.topMargin = this.eXu.getResources().getDimensionPixelSize(R.dimen.tbds24);
            this.aho.setLayoutParams(marginLayoutParams);
            sparseArray = sparseArray2;
        } else {
            this.hoF = false;
            this.hoy.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.aho.getLayoutParams();
            marginLayoutParams2.topMargin = this.eXu.getResources().getDimensionPixelSize(R.dimen.tbds44);
            this.aho.setLayoutParams(marginLayoutParams2);
            sparseArray = null;
        }
        if (this.hoF && sparseArray != null && sparseArray.size() > 0) {
            this.hos.l((bz) this.ahi, "ala_frs_demo_hell_live_feed_back_type");
        } else if (this.hos.cbI() != null) {
            this.hos.cbI().setVisibility(8);
        }
        ((bz) this.ahi).z(false, true);
        this.aho.setData((bz) this.ahi);
        SpannableStringBuilder bsa = ((bz) this.ahi).bsa();
        if (bsa != null && !StringUtils.isNull(bsa.toString())) {
            this.mTextTitle.setText(((bz) this.ahi).bsa());
            this.mTextTitle.setVisibility(0);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (((bz) this.ahi).brK().audience_count > 0) {
            this.hoD.setVisibility(0);
            this.fWu.setVisibility(0);
            this.fWu.setText(String.format(this.eXu.getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(((bz) this.ahi).brK().audience_count)));
        } else {
            this.hoD.setVisibility(8);
            this.fWu.setVisibility(8);
        }
        this.hoB.setVisibility(8);
        if (((bz) this.ahi).brK().openRecomReason == 1) {
            String str = ((bz) this.ahi).brK().recomReason;
            if (!StringUtils.isNull(str)) {
                this.hoB.setVisibility(0);
                this.hoB.setText(str);
            } else {
                String latitude = ((bz) this.ahi).getLatitude();
                String brG = ((bz) this.ahi).brG();
                if (UtilHelper.isDecimal(latitude) && UtilHelper.isDecimal(brG) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo dFT = com.baidu.tieba.recapp.c.a.dFO().dFT();
                    String str2 = dFT.latitude;
                    String str3 = dFT.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(latitude), Double.parseDouble(brG)) <= 50.0d) {
                        this.hoB.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.hoB.setVisibility(0);
                    }
                }
            }
        }
        wv(ux(1));
        Y((bz) this.ahi);
        this.mMaskView.setVisibility((com.baidu.tieba.frs.b.cDY().cDS() || com.baidu.tieba.frs.a.cDR().cDS()) ? 0 : 8);
        onChangeSkinType(this.eXu, TbadkCoreApplication.getInst().getSkinType());
        cbM();
        this.hoA.playAnimation();
        ba(this.hnx);
    }

    public void cbM() {
        if (k.bov().isShowImages() && this.ahi != 0 && ((bz) this.ahi).boP() != null && ((bz) this.ahi).boP().brK() != null) {
            this.fWo.setPlaceHolder(3);
            this.fWo.startLoad(((bz) this.ahi).boP().brK().cover, 10, false);
            this.hoz.setVisibility(0);
            return;
        }
        this.hoz.setVisibility(8);
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hnz != null) {
            if (this.aho != null) {
                this.aho.setPageUniqueId(bdUniqueId);
            }
            setTag(bdUniqueId);
            q(bdUniqueId);
        }
    }

    public void nA(boolean z) {
        this.hoE = z;
    }

    private void Y(bz bzVar) {
        if (bzVar != null) {
            TiebaStatic.log(new aq("c12125").dX("tid", bzVar.getId()).an("obj_locate", this.hoE ? 2 : 1).w("obj_id", bzVar.brK().live_id).an("obj_type", 2));
            if (bzVar.brK() != null && bzVar.brK().user_info != null && bzVar.brK().user_info.is_official == 2) {
                TiebaStatic.log(new aq("c12800").dX("tid", bzVar.getId()));
            }
        }
    }

    private void m(bz bzVar, String str) {
        TiebaStatic.log(new aq("c12126").dX("tid", bzVar.getId()).an("obj_locate", this.hoE ? 2 : 1).w("obj_id", bzVar.brK().live_id).an("obj_type", 2));
        if (bzVar.brK() != null && bzVar.brK().user_info != null && bzVar.brK().user_info.is_official == 2) {
            TiebaStatic.log(new aq("c12801").dX("tid", bzVar.getId()));
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (str.equals("frs_live_play")) {
            if (bzVar.brv().equals(this.mForumName)) {
                TiebaStatic.log(new aq("c11843").dX("uid", currentAccount).w("fid", bzVar.getFid()));
            } else {
                TiebaStatic.log(new aq("c11845").dX("uid", currentAccount).w("fid", bzVar.getFid()));
            }
        }
    }

    public void b(Context context, bz bzVar) {
        String str;
        if (context != null && bzVar != null && bzVar.brK() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(context, R.string.no_network_guide);
                return;
            }
            String str2 = this.hoF ? "frs_live_stage_live" : "frs_play";
            if (bzVar.brd() != null) {
                str2 = bzVar.brd();
            }
            int frsCurTabType = TbSingleton.getInstance().getFrsCurTabType();
            if (frsCurTabType == 14) {
                str = AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_NEW + bzVar.getFid();
            } else {
                str = frsCurTabType == 13 ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_HOT + bzVar.getFid() : str2;
            }
            m(bzVar, str);
            AlaInfoData brK = bzVar.brK();
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && bzVar.brr() != null) {
                z = TextUtils.equals(bzVar.brr().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(brK);
            if (brK.user_info != null) {
                alaLiveInfoCoreData.userName = brK.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, str, "", z, this.mForumName)));
        }
    }

    public void wv(int i) {
        if (this.ahi != 0) {
            if (i == 1) {
                this.hnz.setVisibility(8);
                this.hol.setData((bz) this.ahi);
                return;
            }
            this.hnA.setVisibility(this.hnz.setData((bz) this.ahi) ? 8 : 0);
            this.hol.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aji = str;
    }

    public int ux(int i) {
        return com.baidu.tieba.a.d.bOn().az(this.aji, i);
    }
}
