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
    public TbImageView eBb;
    private TextView eBh;
    public LinearLayout eTB;
    private RelativeLayout fGm;
    private View fGp;
    protected ThreadSourceShareAndPraiseLayout fHa;
    private com.baidu.tieba.ala.livecard.vc.a fHh;
    public ThreadSkinView fHl;
    private TbImageView fHm;
    public RelativeLayout fHn;
    private TBLottieAnimationView fHo;
    private TextView fHp;
    private LinearLayout fHq;
    private View fHr;
    private boolean fHs;
    private boolean fHt;
    private View mDivider;
    private String mForumName;
    private int mLastScreenWidth;
    private View mMaskView;
    private TextView mTextTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.fHs = false;
        this.mLastScreenWidth = 0;
        this.agI = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.bKS() != null) {
                    e.this.bKS().a(view, e.this.adw);
                }
            }
        };
        setTag(bdUniqueId);
        this.dIF = tbPageContext;
        View view = getView();
        this.fGm = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.eTB = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.fGm.setOnClickListener(this);
        this.fHm = (TbImageView) view.findViewById(R.id.video_card_stage_view);
        this.fHm.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.fHm.setDefaultBgResource(R.color.transparent);
        this.adC = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.adC.setUserAfterClickListener(this.agI);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fHn = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.eBb = (TbImageView) view.findViewById(R.id.image_video);
        this.eBb.setDrawCorner(true);
        this.eBb.setPlaceHolder(3);
        this.eBb.setDefaultResource(0);
        this.eBb.setDefaultErrorResource(0);
        this.eBb.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        TbImageView tbImageView = this.eBb;
        TbImageView tbImageView2 = this.eBb;
        tbImageView.setConrers(15);
        this.eBb.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eBb.setBorderColor(am.getColor(R.color.cp_border_a));
        this.eBb.setBorderSurroundContent(true);
        this.eBb.setDrawBorder(true);
        this.fHq = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
        this.fHo = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.fHo.loop(true);
        am.a(this.fHo, (int) R.raw.ala_live2);
        this.fHo.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.e.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                e.this.fHo.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                e.this.fHo.cancelAnimation();
            }
        });
        this.eBh = (TextView) view.findViewById(R.id.play_count);
        this.fHp = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.fHr = view.findViewById(R.id.play_count_line);
        this.fGo = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        b(this.fGo);
        this.fGo.setSelectVisible(false);
        this.fGo.setIsBarViewVisible(false);
        this.fGo.setCommentNumEnable(true);
        this.fGo.setLiveShareEnable(false);
        this.fGo.setFrom(2);
        this.fGo.getCommentContainer().setOnClickListener(this);
        this.fGo.hideDisagree();
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dAZ = 2;
        cVar.dBf = 2;
        this.fGo.setAgreeStatisticData(cVar);
        this.gBE = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.gBE);
        this.gBE.setFrom(2);
        this.gBE.setShareReportFrom(1);
        this.fHa = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.fHa.dXt.setOnClickListener(this);
        this.fHa.dXt.getCommentContainer().setOnClickListener(this);
        this.fHa.setFrom(2);
        this.fHa.setShareReportFrom(1);
        this.fHa.setSourceFromForPb(3);
        this.fHa.setStType("frs_page");
        this.fHa.setHideBarName(true);
        this.fGp = view.findViewById(R.id.divider_below_reply_number_layout);
        this.fHl = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.fHh = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.adC.getSuffixContainer());
        this.fHh.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.b
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            d(tbPageContext, i);
            am.setBackgroundResource(this.fGm, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fHn, R.drawable.bg_ala_shape);
            int dimens = l.getDimens(getContext(), R.dimen.tbds10);
            am.a(this.fHq, (int) R.color.cp_other_d, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, 0.0f, 0.0f, dimens, dimens, 0.0f, 0.0f});
            am.setBackgroundColor(this.fHr, R.color.cp_cont_a);
            am.setViewTextColor(this.eBh, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.fHp, (int) R.color.cp_cont_a);
            this.adC.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.eBb.setPlaceHolder(3);
            this.fGo.onChangeSkinType();
            this.mSkinType = i;
            if (this.fHa != null && this.fHa.getVisibility() == 0) {
                this.fHa.onChangeSkinType();
            }
        }
        if (this.adw != 0 && m.Do(((bk) this.adw).getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
        am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.fHh.onChangeSkinType();
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
    public void qw(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.a.bTX().bTY()) {
            if (view == this.fGm || view == this.fGo.getCommentContainer() || view == this.eTB || view == this.fHa.dXt.getCommentContainer() || view == this.gBE.getCommentContainer()) {
                if (this.adw != 0) {
                    m.Dn(((bk) this.adw).getId());
                }
                if (bKS() != null) {
                    bKS().a(this.fGm, this.adw);
                }
                b(getContext(), (bk) this.adw);
                if (this.adw != 0) {
                    if (view == this.fGo.getCommentContainer() || view == this.fHa.dXt.getCommentContainer()) {
                        an anVar = new an("c12942");
                        anVar.ag("obj_locate", 2);
                        anVar.ag("obj_type", 5);
                        anVar.dh("tid", ((bk) this.adw).getTid());
                        anVar.dh("nid", ((bk) this.adw).getNid());
                        TiebaStatic.log(anVar);
                    }
                }
            } else if (view.getId() == R.id.video_container) {
                if (bKS() != null) {
                    bKS().a(view, this.adw);
                }
                b(getContext(), (bk) this.adw);
            }
        }
    }

    private void refreshView() {
        SparseArray<String> sparseArray;
        if (this.adw == 0 || ((bk) this.adw).aQx() == null) {
            this.fGm.setVisibility(8);
            return;
        }
        this.fGm.setVisibility(0);
        int equipmentWidth = l.getEquipmentWidth(this.dIF.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fHn.getLayoutParams();
            layoutParams.width = equipmentWidth - l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.fHn.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (((bk) this.adw).aQS() != null && ((bk) this.adw).aQS().user_info != null && ((bk) this.adw).aQS().user_info.is_official == 2) {
            this.fHt = true;
            SparseArray<String> sparseArray2 = ((bk) this.adw).aQS().dislikeInfo;
            this.fHm.setVisibility(0);
            int[] screenDimensions = l.getScreenDimensions(getContext());
            ViewGroup.LayoutParams layoutParams2 = this.fHm.getLayoutParams();
            layoutParams2.width = screenDimensions[0];
            layoutParams2.height = (screenDimensions[0] * 156) / 1080;
            this.fHm.setLayoutParams(layoutParams2);
            if (!TextUtils.isEmpty(((bk) this.adw).aQS().liveStagePicUrl)) {
                this.fHm.startLoad(((bk) this.adw).aQS().liveStagePicUrl, 10, false);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.adC.getLayoutParams();
            marginLayoutParams.topMargin = this.dIF.getResources().getDimensionPixelSize(R.dimen.tbds24);
            this.adC.setLayoutParams(marginLayoutParams);
            sparseArray = sparseArray2;
        } else {
            this.fHt = false;
            this.fHm.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.adC.getLayoutParams();
            marginLayoutParams2.topMargin = this.dIF.getResources().getDimensionPixelSize(R.dimen.tbds44);
            this.adC.setLayoutParams(marginLayoutParams2);
            sparseArray = null;
        }
        if (this.fHt && sparseArray != null && sparseArray.size() > 0) {
            this.fHh.e((bk) this.adw, "ala_frs_demo_hell_live_feed_back_type");
        } else if (this.fHh.bwj() != null) {
            this.fHh.bwj().setVisibility(8);
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
            this.fHr.setVisibility(0);
            this.eBh.setVisibility(0);
            this.eBh.setText(String.format(this.dIF.getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(((bk) this.adw).aQS().audience_count)));
        } else {
            this.fHr.setVisibility(8);
            this.eBh.setVisibility(8);
        }
        this.fHp.setVisibility(8);
        if (((bk) this.adw).aQS().openRecomReason == 1) {
            String str = ((bk) this.adw).aQS().recomReason;
            if (!StringUtils.isNull(str)) {
                this.fHp.setVisibility(0);
                this.fHp.setText(str);
            } else {
                String aQN = ((bk) this.adw).aQN();
                String aQO = ((bk) this.adw).aQO();
                if (UtilHelper.isDecimal(aQN) && UtilHelper.isDecimal(aQO) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo cVd = com.baidu.tieba.recapp.d.a.cUZ().cVd();
                    String str2 = cVd.latitude;
                    String str3 = cVd.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(aQN), Double.parseDouble(aQO)) <= 50.0d) {
                        this.fHp.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.fHp.setVisibility(0);
                    }
                }
            }
        }
        qy(oY(1));
        X((bk) this.adw);
        this.mMaskView.setVisibility(com.baidu.tieba.frs.a.bTX().bTY() ? 0 : 8);
        onChangeSkinType(this.dIF, TbadkCoreApplication.getInst().getSkinType());
        bwn();
        this.fHo.playAnimation();
        aJ(this.fGm);
    }

    public void bwn() {
        if (k.aNQ().isShowImages() && this.adw != 0 && ((bk) this.adw).aOi() != null && ((bk) this.adw).aOi().aQS() != null) {
            this.eBb.setPlaceHolder(3);
            this.eBb.startLoad(((bk) this.adw).aOi().aQS().cover, 10, false);
            this.fHn.setVisibility(0);
            return;
        }
        this.fHn.setVisibility(8);
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.fGo != null) {
            if (this.adC != null) {
                this.adC.setPageUniqueId(bdUniqueId);
            }
            setTag(bdUniqueId);
            q(bdUniqueId);
        }
    }

    public void kg(boolean z) {
        this.fHs = z;
    }

    private void X(bk bkVar) {
        if (bkVar != null) {
            TiebaStatic.log(new an("c12125").dh("tid", bkVar.getId()).ag("obj_locate", this.fHs ? 2 : 1).s("obj_id", bkVar.aQS().live_id).ag("obj_type", 2));
            if (bkVar.aQS() != null && bkVar.aQS().user_info != null && bkVar.aQS().user_info.is_official == 2) {
                TiebaStatic.log(new an("c12800").dh("tid", bkVar.getId()));
            }
        }
    }

    private void f(bk bkVar, String str) {
        TiebaStatic.log(new an("c12126").dh("tid", bkVar.getId()).ag("obj_locate", this.fHs ? 2 : 1).s("obj_id", bkVar.aQS().live_id).ag("obj_type", 2));
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
            String str2 = this.fHt ? "frs_live_stage_live" : "frs_play";
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

    public void qy(int i) {
        if (this.adw != 0) {
            if (i == 1) {
                this.fGo.setVisibility(8);
                this.fHa.setData((bk) this.adw);
                return;
            }
            this.fGp.setVisibility(this.fGo.setData((bk) this.adw) ? 8 : 0);
            this.fHa.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aeX = str;
    }

    public int oY(int i) {
        return com.baidu.tieba.a.d.blZ().as(this.aeX, i);
    }
}
