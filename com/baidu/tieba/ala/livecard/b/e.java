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
    private CardUserInfoLayout afN;
    private String aht;
    private final View.OnClickListener ajF;
    public LinearLayout fJK;
    public TbImageView fri;
    private TextView fro;
    private RelativeLayout gAC;
    private View gAF;
    public ThreadSkinView gBB;
    private TbImageView gBC;
    public RelativeLayout gBD;
    private TBLottieAnimationView gBE;
    private TextView gBF;
    private LinearLayout gBG;
    private View gBH;
    private boolean gBI;
    private boolean gBJ;
    protected ThreadSourceShareAndPraiseLayout gBq;
    private com.baidu.tieba.ala.livecard.vc.a gBx;
    private String mForumName;
    private int mLastScreenWidth;
    private View mMaskView;
    private TextView mTextTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.gBI = false;
        this.mLastScreenWidth = 0;
        this.ajF = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.cil() != null) {
                    e.this.cil().a(view, e.this.afH);
                }
            }
        };
        setTag(bdUniqueId);
        this.etO = tbPageContext;
        View view = getView();
        this.gAC = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fJK = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.gAC.setOnClickListener(this);
        this.gBC = (TbImageView) view.findViewById(R.id.video_card_stage_view);
        this.gBC.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.gBC.setDefaultBgResource(R.color.transparent);
        this.afN = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.afN.setUserAfterClickListener(this.ajF);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gBD = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.fri = (TbImageView) view.findViewById(R.id.image_video);
        this.fri.setDrawCorner(true);
        this.fri.setPlaceHolder(3);
        this.fri.setDefaultResource(0);
        this.fri.setDefaultErrorResource(0);
        this.fri.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        TbImageView tbImageView = this.fri;
        TbImageView tbImageView2 = this.fri;
        tbImageView.setConrers(15);
        this.fri.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fri.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.fri.setBorderSurroundContent(true);
        this.fri.setDrawBorder(true);
        this.gBG = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
        this.gBE = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.gBE.loop(true);
        ap.a(this.gBE, R.raw.ala_live2);
        this.gBE.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.e.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                e.this.gBE.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                e.this.gBE.cancelAnimation();
            }
        });
        this.fro = (TextView) view.findViewById(R.id.play_count);
        this.gBF = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.gBH = view.findViewById(R.id.play_count_line);
        this.gAE = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        b(this.gAE);
        this.gAE.setSelectVisible(false);
        this.gAE.setIsBarViewVisible(false);
        this.gAE.setCommentNumEnable(true);
        this.gAE.setLiveShareEnable(false);
        this.gAE.setFrom(2);
        this.gAE.getCommentContainer().setOnClickListener(this);
        this.gAE.hideDisagree();
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.ela = 2;
        cVar.elg = 2;
        this.gAE.setAgreeStatisticData(cVar);
        this.hDf = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.hDf);
        this.hDf.setFrom(2);
        this.hDf.setShareReportFrom(1);
        this.gBq = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.gBq.eJm.setOnClickListener(this);
        this.gBq.eJm.getCommentContainer().setOnClickListener(this);
        this.gBq.setFrom(2);
        this.gBq.setShareReportFrom(1);
        this.gBq.setSourceFromForPb(3);
        this.gBq.setStType("frs_page");
        this.gBq.setHideBarName(true);
        this.gAF = view.findViewById(R.id.divider_below_reply_number_layout);
        this.gBB = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.gBx = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.afN.getSuffixContainer());
        this.gBx.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.b
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            g(tbPageContext, i);
            ap.setBackgroundResource(this.gAC, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.gBD, R.drawable.bg_ala_shape);
            int dimens = l.getDimens(getContext(), R.dimen.tbds10);
            ap.a(this.gBG, R.color.cp_other_d, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, 0.0f, 0.0f, dimens, dimens, 0.0f, 0.0f});
            ap.setBackgroundColor(this.gBH, R.color.cp_cont_a);
            ap.setViewTextColor(this.fro, R.color.cp_cont_a);
            ap.setViewTextColor(this.gBF, R.color.cp_cont_a);
            this.afN.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fri.setPlaceHolder(3);
            this.gAE.onChangeSkinType();
            this.mSkinType = i;
            if (this.gBq != null && this.gBq.getVisibility() == 0) {
                this.gBq.onChangeSkinType();
            }
        }
        if (this.afH != 0 && m.Ik(((bw) this.afH).getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b);
        }
        ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.gBx.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_video_layout_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bw bwVar) {
        this.afH = bwVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void ux(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.b.crE().cry() && !com.baidu.tieba.frs.a.crx().cry()) {
            if (view == this.gAC || view == this.gAE.getCommentContainer() || view == this.fJK || view == this.gBq.eJm.getCommentContainer() || view == this.hDf.getCommentContainer()) {
                if (this.afH != 0) {
                    m.Ij(((bw) this.afH).getId());
                }
                if (cil() != null) {
                    cil().a(this.gAC, this.afH);
                }
                b(getContext(), (bw) this.afH);
                if (this.afH != 0) {
                    if (view == this.gAE.getCommentContainer() || view == this.gBq.eJm.getCommentContainer()) {
                        aq aqVar = new aq("c12942");
                        aqVar.aj("obj_locate", 2);
                        aqVar.aj("obj_type", 5);
                        aqVar.dK("tid", ((bw) this.afH).getTid());
                        aqVar.dK("nid", ((bw) this.afH).getNid());
                        TiebaStatic.log(aqVar);
                    }
                }
            } else if (view.getId() == R.id.video_container) {
                if (cil() != null) {
                    cil().a(view, this.afH);
                }
                b(getContext(), (bw) this.afH);
            }
        }
    }

    private void refreshView() {
        SparseArray<String> sparseArray;
        if (this.afH == 0 || ((bw) this.afH).bih() == null) {
            this.gAC.setVisibility(8);
            return;
        }
        this.gAC.setVisibility(0);
        int equipmentWidth = l.getEquipmentWidth(this.etO.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gBD.getLayoutParams();
            layoutParams.width = equipmentWidth - l.getDimens(this.etO.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.gBD.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (((bw) this.afH).biB() != null && ((bw) this.afH).biB().user_info != null && ((bw) this.afH).biB().user_info.is_official == 2) {
            this.gBJ = true;
            SparseArray<String> sparseArray2 = ((bw) this.afH).biB().dislikeInfo;
            this.gBC.setVisibility(0);
            int[] screenDimensions = l.getScreenDimensions(getContext());
            ViewGroup.LayoutParams layoutParams2 = this.gBC.getLayoutParams();
            layoutParams2.width = screenDimensions[0];
            layoutParams2.height = (screenDimensions[0] * 156) / 1080;
            this.gBC.setLayoutParams(layoutParams2);
            if (!TextUtils.isEmpty(((bw) this.afH).biB().liveStagePicUrl)) {
                this.gBC.startLoad(((bw) this.afH).biB().liveStagePicUrl, 10, false);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.afN.getLayoutParams();
            marginLayoutParams.topMargin = this.etO.getResources().getDimensionPixelSize(R.dimen.tbds24);
            this.afN.setLayoutParams(marginLayoutParams);
            sparseArray = sparseArray2;
        } else {
            this.gBJ = false;
            this.gBC.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.afN.getLayoutParams();
            marginLayoutParams2.topMargin = this.etO.getResources().getDimensionPixelSize(R.dimen.tbds44);
            this.afN.setLayoutParams(marginLayoutParams2);
            sparseArray = null;
        }
        if (this.gBJ && sparseArray != null && sparseArray.size() > 0) {
            this.gBx.l((bw) this.afH, "ala_frs_demo_hell_live_feed_back_type");
        } else if (this.gBx.bQr() != null) {
            this.gBx.bQr().setVisibility(8);
        }
        ((bw) this.afH).z(false, true);
        this.afN.setData((bw) this.afH);
        SpannableStringBuilder biR = ((bw) this.afH).biR();
        if (biR != null && !StringUtils.isNull(biR.toString())) {
            this.mTextTitle.setText(((bw) this.afH).biR());
            this.mTextTitle.setVisibility(0);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (((bw) this.afH).biB().audience_count > 0) {
            this.gBH.setVisibility(0);
            this.fro.setVisibility(0);
            this.fro.setText(String.format(this.etO.getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(((bw) this.afH).biB().audience_count)));
        } else {
            this.gBH.setVisibility(8);
            this.fro.setVisibility(8);
        }
        this.gBF.setVisibility(8);
        if (((bw) this.afH).biB().openRecomReason == 1) {
            String str = ((bw) this.afH).biB().recomReason;
            if (!StringUtils.isNull(str)) {
                this.gBF.setVisibility(0);
                this.gBF.setText(str);
            } else {
                String biw = ((bw) this.afH).biw();
                String bix = ((bw) this.afH).bix();
                if (UtilHelper.isDecimal(biw) && UtilHelper.isDecimal(bix) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo dvy = com.baidu.tieba.recapp.d.a.dvt().dvy();
                    String str2 = dvy.latitude;
                    String str3 = dvy.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(biw), Double.parseDouble(bix)) <= 50.0d) {
                        this.gBF.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.gBF.setVisibility(0);
                    }
                }
            }
        }
        uz(sO(1));
        W((bw) this.afH);
        this.mMaskView.setVisibility((com.baidu.tieba.frs.b.crE().cry() || com.baidu.tieba.frs.a.crx().cry()) ? 0 : 8);
        onChangeSkinType(this.etO, TbadkCoreApplication.getInst().getSkinType());
        bQv();
        this.gBE.playAnimation();
        aQ(this.gAC);
    }

    public void bQv() {
        if (k.bfo().isShowImages() && this.afH != 0 && ((bw) this.afH).bfG() != null && ((bw) this.afH).bfG().biB() != null) {
            this.fri.setPlaceHolder(3);
            this.fri.startLoad(((bw) this.afH).bfG().biB().cover, 10, false);
            this.gBD.setVisibility(0);
            return;
        }
        this.gBD.setVisibility(8);
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gAE != null) {
            if (this.afN != null) {
                this.afN.setPageUniqueId(bdUniqueId);
            }
            setTag(bdUniqueId);
            q(bdUniqueId);
        }
    }

    public void me(boolean z) {
        this.gBI = z;
    }

    private void W(bw bwVar) {
        if (bwVar != null) {
            TiebaStatic.log(new aq("c12125").dK("tid", bwVar.getId()).aj("obj_locate", this.gBI ? 2 : 1).u("obj_id", bwVar.biB().live_id).aj("obj_type", 2));
            if (bwVar.biB() != null && bwVar.biB().user_info != null && bwVar.biB().user_info.is_official == 2) {
                TiebaStatic.log(new aq("c12800").dK("tid", bwVar.getId()));
            }
        }
    }

    private void m(bw bwVar, String str) {
        TiebaStatic.log(new aq("c12126").dK("tid", bwVar.getId()).aj("obj_locate", this.gBI ? 2 : 1).u("obj_id", bwVar.biB().live_id).aj("obj_type", 2));
        if (bwVar.biB() != null && bwVar.biB().user_info != null && bwVar.biB().user_info.is_official == 2) {
            TiebaStatic.log(new aq("c12801").dK("tid", bwVar.getId()));
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (str.equals("frs_live_play")) {
            if (bwVar.bil().equals(this.mForumName)) {
                TiebaStatic.log(new aq("c11843").dK("uid", currentAccount).u("fid", bwVar.getFid()));
            } else {
                TiebaStatic.log(new aq("c11845").dK("uid", currentAccount).u("fid", bwVar.getFid()));
            }
        }
    }

    public void b(Context context, bw bwVar) {
        String str;
        if (context != null && bwVar != null && bwVar.biB() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(context, R.string.no_network_guide);
                return;
            }
            String str2 = this.gBJ ? "frs_live_stage_live" : "frs_play";
            if (bwVar.bhT() != null) {
                str2 = bwVar.bhT();
            }
            int frsCurTabType = TbSingleton.getInstance().getFrsCurTabType();
            if (frsCurTabType == 14) {
                str = AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_NEW + bwVar.getFid();
            } else {
                str = frsCurTabType == 13 ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_HOT + bwVar.getFid() : str2;
            }
            m(bwVar, str);
            AlaInfoData biB = bwVar.biB();
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && bwVar.bih() != null) {
                z = TextUtils.equals(bwVar.bih().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(biB);
            if (biB.user_info != null) {
                alaLiveInfoCoreData.userName = biB.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, str, "", z, this.mForumName)));
        }
    }

    public void uz(int i) {
        if (this.afH != 0) {
            if (i == 1) {
                this.gAE.setVisibility(8);
                this.gBq.setData((bw) this.afH);
                return;
            }
            this.gAF.setVisibility(this.gAE.setData((bw) this.afH) ? 8 : 0);
            this.gBq.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aht = str;
    }

    public int sO(int i) {
        return com.baidu.tieba.a.d.bEz().av(this.aht, i);
    }
}
