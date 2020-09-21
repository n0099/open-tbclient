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
    private CardUserInfoLayout afw;
    private String ahc;
    private final View.OnClickListener ajn;
    public TbImageView feU;
    private TextView ffa;
    public LinearLayout fxB;
    protected ThreadSourceShareAndPraiseLayout gmX;
    private RelativeLayout gmj;
    private View gmm;
    private com.baidu.tieba.ala.livecard.vc.a gne;
    public ThreadSkinView gni;
    private TbImageView gnj;
    public RelativeLayout gnk;
    private TBLottieAnimationView gnl;
    private TextView gnm;
    private LinearLayout gnn;
    private View gno;
    private boolean gnp;
    private boolean gnq;
    private String mForumName;
    private int mLastScreenWidth;
    private View mMaskView;
    private TextView mTextTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.gnp = false;
        this.mLastScreenWidth = 0;
        this.ajn = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.ceP() != null) {
                    e.this.ceP().a(view, e.this.afq);
                }
            }
        };
        setTag(bdUniqueId);
        this.ehG = tbPageContext;
        View view = getView();
        this.gmj = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fxB = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.gmj.setOnClickListener(this);
        this.gnj = (TbImageView) view.findViewById(R.id.video_card_stage_view);
        this.gnj.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.gnj.setDefaultBgResource(R.color.transparent);
        this.afw = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.afw.setUserAfterClickListener(this.ajn);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gnk = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.feU = (TbImageView) view.findViewById(R.id.image_video);
        this.feU.setDrawCorner(true);
        this.feU.setPlaceHolder(3);
        this.feU.setDefaultResource(0);
        this.feU.setDefaultErrorResource(0);
        this.feU.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        TbImageView tbImageView = this.feU;
        TbImageView tbImageView2 = this.feU;
        tbImageView.setConrers(15);
        this.feU.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.feU.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.feU.setBorderSurroundContent(true);
        this.feU.setDrawBorder(true);
        this.gnn = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
        this.gnl = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.gnl.loop(true);
        ap.a(this.gnl, R.raw.ala_live2);
        this.gnl.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.e.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                e.this.gnl.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                e.this.gnl.cancelAnimation();
            }
        });
        this.ffa = (TextView) view.findViewById(R.id.play_count);
        this.gnm = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.gno = view.findViewById(R.id.play_count_line);
        this.gml = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        b(this.gml);
        this.gml.setSelectVisible(false);
        this.gml.setIsBarViewVisible(false);
        this.gml.setCommentNumEnable(true);
        this.gml.setLiveShareEnable(false);
        this.gml.setFrom(2);
        this.gml.getCommentContainer().setOnClickListener(this);
        this.gml.hideDisagree();
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dYY = 2;
        cVar.dZe = 2;
        this.gml.setAgreeStatisticData(cVar);
        this.hol = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.hol);
        this.hol.setFrom(2);
        this.hol.setShareReportFrom(1);
        this.gmX = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.gmX.exc.setOnClickListener(this);
        this.gmX.exc.getCommentContainer().setOnClickListener(this);
        this.gmX.setFrom(2);
        this.gmX.setShareReportFrom(1);
        this.gmX.setSourceFromForPb(3);
        this.gmX.setStType("frs_page");
        this.gmX.setHideBarName(true);
        this.gmm = view.findViewById(R.id.divider_below_reply_number_layout);
        this.gni = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.gne = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.afw.getSuffixContainer());
        this.gne.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.b
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            g(tbPageContext, i);
            ap.setBackgroundResource(this.gmj, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.gnk, R.drawable.bg_ala_shape);
            int dimens = l.getDimens(getContext(), R.dimen.tbds10);
            ap.a(this.gnn, R.color.cp_other_d, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, 0.0f, 0.0f, dimens, dimens, 0.0f, 0.0f});
            ap.setBackgroundColor(this.gno, R.color.cp_cont_a);
            ap.setViewTextColor(this.ffa, R.color.cp_cont_a);
            ap.setViewTextColor(this.gnm, R.color.cp_cont_a);
            this.afw.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.feU.setPlaceHolder(3);
            this.gml.onChangeSkinType();
            this.mSkinType = i;
            if (this.gmX != null && this.gmX.getVisibility() == 0) {
                this.gmX.onChangeSkinType();
            }
        }
        if (this.afq != 0 && m.Hx(((bw) this.afq).getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b);
        }
        ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.gne.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_video_layout_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bw bwVar) {
        this.afq = bwVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void tS(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.b.cog().coa() && !com.baidu.tieba.frs.a.cnZ().coa()) {
            if (view == this.gmj || view == this.gml.getCommentContainer() || view == this.fxB || view == this.gmX.exc.getCommentContainer() || view == this.hol.getCommentContainer()) {
                if (this.afq != 0) {
                    m.Hw(((bw) this.afq).getId());
                }
                if (ceP() != null) {
                    ceP().a(this.gmj, this.afq);
                }
                b(getContext(), (bw) this.afq);
                if (this.afq != 0) {
                    if (view == this.gml.getCommentContainer() || view == this.gmX.exc.getCommentContainer()) {
                        aq aqVar = new aq("c12942");
                        aqVar.ai("obj_locate", 2);
                        aqVar.ai("obj_type", 5);
                        aqVar.dF("tid", ((bw) this.afq).getTid());
                        aqVar.dF("nid", ((bw) this.afq).getNid());
                        TiebaStatic.log(aqVar);
                    }
                }
            } else if (view.getId() == R.id.video_container) {
                if (ceP() != null) {
                    ceP().a(view, this.afq);
                }
                b(getContext(), (bw) this.afq);
            }
        }
    }

    private void refreshView() {
        SparseArray<String> sparseArray;
        if (this.afq == 0 || ((bw) this.afq).bfy() == null) {
            this.gmj.setVisibility(8);
            return;
        }
        this.gmj.setVisibility(0);
        int equipmentWidth = l.getEquipmentWidth(this.ehG.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gnk.getLayoutParams();
            layoutParams.width = equipmentWidth - l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.gnk.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (((bw) this.afq).bfS() != null && ((bw) this.afq).bfS().user_info != null && ((bw) this.afq).bfS().user_info.is_official == 2) {
            this.gnq = true;
            SparseArray<String> sparseArray2 = ((bw) this.afq).bfS().dislikeInfo;
            this.gnj.setVisibility(0);
            int[] screenDimensions = l.getScreenDimensions(getContext());
            ViewGroup.LayoutParams layoutParams2 = this.gnj.getLayoutParams();
            layoutParams2.width = screenDimensions[0];
            layoutParams2.height = (screenDimensions[0] * 156) / 1080;
            this.gnj.setLayoutParams(layoutParams2);
            if (!TextUtils.isEmpty(((bw) this.afq).bfS().liveStagePicUrl)) {
                this.gnj.startLoad(((bw) this.afq).bfS().liveStagePicUrl, 10, false);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.afw.getLayoutParams();
            marginLayoutParams.topMargin = this.ehG.getResources().getDimensionPixelSize(R.dimen.tbds24);
            this.afw.setLayoutParams(marginLayoutParams);
            sparseArray = sparseArray2;
        } else {
            this.gnq = false;
            this.gnj.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.afw.getLayoutParams();
            marginLayoutParams2.topMargin = this.ehG.getResources().getDimensionPixelSize(R.dimen.tbds44);
            this.afw.setLayoutParams(marginLayoutParams2);
            sparseArray = null;
        }
        if (this.gnq && sparseArray != null && sparseArray.size() > 0) {
            this.gne.l((bw) this.afq, "ala_frs_demo_hell_live_feed_back_type");
        } else if (this.gne.bNa() != null) {
            this.gne.bNa().setVisibility(8);
        }
        ((bw) this.afq).z(false, true);
        this.afw.setData((bw) this.afq);
        SpannableStringBuilder bgi = ((bw) this.afq).bgi();
        if (bgi != null && !StringUtils.isNull(bgi.toString())) {
            this.mTextTitle.setText(((bw) this.afq).bgi());
            this.mTextTitle.setVisibility(0);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (((bw) this.afq).bfS().audience_count > 0) {
            this.gno.setVisibility(0);
            this.ffa.setVisibility(0);
            this.ffa.setText(String.format(this.ehG.getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(((bw) this.afq).bfS().audience_count)));
        } else {
            this.gno.setVisibility(8);
            this.ffa.setVisibility(8);
        }
        this.gnm.setVisibility(8);
        if (((bw) this.afq).bfS().openRecomReason == 1) {
            String str = ((bw) this.afq).bfS().recomReason;
            if (!StringUtils.isNull(str)) {
                this.gnm.setVisibility(0);
                this.gnm.setText(str);
            } else {
                String bfN = ((bw) this.afq).bfN();
                String bfO = ((bw) this.afq).bfO();
                if (UtilHelper.isDecimal(bfN) && UtilHelper.isDecimal(bfO) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo drN = com.baidu.tieba.recapp.d.a.drI().drN();
                    String str2 = drN.latitude;
                    String str3 = drN.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(bfN), Double.parseDouble(bfO)) <= 50.0d) {
                        this.gnm.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.gnm.setVisibility(0);
                    }
                }
            }
        }
        tU(sq(1));
        W((bw) this.afq);
        this.mMaskView.setVisibility((com.baidu.tieba.frs.b.cog().coa() || com.baidu.tieba.frs.a.cnZ().coa()) ? 0 : 8);
        onChangeSkinType(this.ehG, TbadkCoreApplication.getInst().getSkinType());
        bNe();
        this.gnl.playAnimation();
        aO(this.gmj);
    }

    public void bNe() {
        if (k.bcG().isShowImages() && this.afq != 0 && ((bw) this.afq).bcY() != null && ((bw) this.afq).bcY().bfS() != null) {
            this.feU.setPlaceHolder(3);
            this.feU.startLoad(((bw) this.afq).bcY().bfS().cover, 10, false);
            this.gnk.setVisibility(0);
            return;
        }
        this.gnk.setVisibility(8);
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gml != null) {
            if (this.afw != null) {
                this.afw.setPageUniqueId(bdUniqueId);
            }
            setTag(bdUniqueId);
            q(bdUniqueId);
        }
    }

    public void lC(boolean z) {
        this.gnp = z;
    }

    private void W(bw bwVar) {
        if (bwVar != null) {
            TiebaStatic.log(new aq("c12125").dF("tid", bwVar.getId()).ai("obj_locate", this.gnp ? 2 : 1).u("obj_id", bwVar.bfS().live_id).ai("obj_type", 2));
            if (bwVar.bfS() != null && bwVar.bfS().user_info != null && bwVar.bfS().user_info.is_official == 2) {
                TiebaStatic.log(new aq("c12800").dF("tid", bwVar.getId()));
            }
        }
    }

    private void m(bw bwVar, String str) {
        TiebaStatic.log(new aq("c12126").dF("tid", bwVar.getId()).ai("obj_locate", this.gnp ? 2 : 1).u("obj_id", bwVar.bfS().live_id).ai("obj_type", 2));
        if (bwVar.bfS() != null && bwVar.bfS().user_info != null && bwVar.bfS().user_info.is_official == 2) {
            TiebaStatic.log(new aq("c12801").dF("tid", bwVar.getId()));
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (str.equals("frs_live_play")) {
            if (bwVar.bfC().equals(this.mForumName)) {
                TiebaStatic.log(new aq("c11843").dF("uid", currentAccount).u("fid", bwVar.getFid()));
            } else {
                TiebaStatic.log(new aq("c11845").dF("uid", currentAccount).u("fid", bwVar.getFid()));
            }
        }
    }

    public void b(Context context, bw bwVar) {
        String str;
        if (context != null && bwVar != null && bwVar.bfS() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(context, R.string.no_network_guide);
                return;
            }
            String str2 = this.gnq ? "frs_live_stage_live" : "frs_play";
            if (bwVar.bfk() != null) {
                str2 = bwVar.bfk();
            }
            int frsCurTabType = TbSingleton.getInstance().getFrsCurTabType();
            if (frsCurTabType == 14) {
                str = AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_NEW + bwVar.getFid();
            } else {
                str = frsCurTabType == 13 ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_HOT + bwVar.getFid() : str2;
            }
            m(bwVar, str);
            AlaInfoData bfS = bwVar.bfS();
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && bwVar.bfy() != null) {
                z = TextUtils.equals(bwVar.bfy().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bfS);
            if (bfS.user_info != null) {
                alaLiveInfoCoreData.userName = bfS.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, str, "", z, this.mForumName)));
        }
    }

    public void tU(int i) {
        if (this.afq != 0) {
            if (i == 1) {
                this.gml.setVisibility(8);
                this.gmX.setData((bw) this.afq);
                return;
            }
            this.gmm.setVisibility(this.gml.setData((bw) this.afq) ? 8 : 0);
            this.gmX.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahc = str;
    }

    public int sq(int i) {
        return com.baidu.tieba.a.d.bBN().au(this.ahc, i);
    }
}
