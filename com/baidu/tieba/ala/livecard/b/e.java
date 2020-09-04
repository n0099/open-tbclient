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
    private CardUserInfoLayout afe;
    private String agJ;
    private final View.OnClickListener aiT;
    public TbImageView fcb;
    private TextView fch;
    public LinearLayout fuq;
    protected ThreadSourceShareAndPraiseLayout gjQ;
    private com.baidu.tieba.ala.livecard.vc.a gjX;
    private RelativeLayout gjc;
    private View gjf;
    public ThreadSkinView gkb;
    private TbImageView gkc;
    public RelativeLayout gkd;
    private TBLottieAnimationView gke;
    private TextView gkf;
    private LinearLayout gkg;
    private View gkh;
    private boolean gki;
    private boolean gkj;
    private String mForumName;
    private int mLastScreenWidth;
    private View mMaskView;
    private TextView mTextTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.gki = false;
        this.mLastScreenWidth = 0;
        this.aiT = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.cbA() != null) {
                    e.this.cbA().a(view, e.this.aeY);
                }
            }
        };
        setTag(bdUniqueId);
        this.efr = tbPageContext;
        View view = getView();
        this.gjc = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fuq = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.gjc.setOnClickListener(this);
        this.gkc = (TbImageView) view.findViewById(R.id.video_card_stage_view);
        this.gkc.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.gkc.setDefaultBgResource(R.color.transparent);
        this.afe = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.afe.setUserAfterClickListener(this.aiT);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gkd = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.fcb = (TbImageView) view.findViewById(R.id.image_video);
        this.fcb.setDrawCorner(true);
        this.fcb.setPlaceHolder(3);
        this.fcb.setDefaultResource(0);
        this.fcb.setDefaultErrorResource(0);
        this.fcb.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        TbImageView tbImageView = this.fcb;
        TbImageView tbImageView2 = this.fcb;
        tbImageView.setConrers(15);
        this.fcb.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fcb.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.fcb.setBorderSurroundContent(true);
        this.fcb.setDrawBorder(true);
        this.gkg = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
        this.gke = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.gke.loop(true);
        ap.a(this.gke, (int) R.raw.ala_live2);
        this.gke.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.e.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                e.this.gke.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                e.this.gke.cancelAnimation();
            }
        });
        this.fch = (TextView) view.findViewById(R.id.play_count);
        this.gkf = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.gkh = view.findViewById(R.id.play_count_line);
        this.gje = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        b(this.gje);
        this.gje.setSelectVisible(false);
        this.gje.setIsBarViewVisible(false);
        this.gje.setCommentNumEnable(true);
        this.gje.setLiveShareEnable(false);
        this.gje.setFrom(2);
        this.gje.getCommentContainer().setOnClickListener(this);
        this.gje.hideDisagree();
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dWO = 2;
        cVar.dWU = 2;
        this.gje.setAgreeStatisticData(cVar);
        this.hhh = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.hhh);
        this.hhh.setFrom(2);
        this.hhh.setShareReportFrom(1);
        this.gjQ = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.gjQ.euY.setOnClickListener(this);
        this.gjQ.euY.getCommentContainer().setOnClickListener(this);
        this.gjQ.setFrom(2);
        this.gjQ.setShareReportFrom(1);
        this.gjQ.setSourceFromForPb(3);
        this.gjQ.setStType("frs_page");
        this.gjQ.setHideBarName(true);
        this.gjf = view.findViewById(R.id.divider_below_reply_number_layout);
        this.gkb = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.gjX = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.afe.getSuffixContainer());
        this.gjX.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.b
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            g(tbPageContext, i);
            ap.setBackgroundResource(this.gjc, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.gkd, R.drawable.bg_ala_shape);
            int dimens = l.getDimens(getContext(), R.dimen.tbds10);
            ap.a(this.gkg, (int) R.color.cp_other_d, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, 0.0f, 0.0f, dimens, dimens, 0.0f, 0.0f});
            ap.setBackgroundColor(this.gkh, R.color.cp_cont_a);
            ap.setViewTextColor(this.fch, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.gkf, (int) R.color.cp_cont_a);
            this.afe.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fcb.setPlaceHolder(3);
            this.gje.onChangeSkinType();
            this.mSkinType = i;
            if (this.gjQ != null && this.gjQ.getVisibility() == 0) {
                this.gjQ.onChangeSkinType();
            }
        }
        if (this.aeY != 0 && m.Ha(((bw) this.aeY).getId())) {
            ap.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            ap.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
        ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.gjX.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_video_layout_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bw bwVar) {
        this.aeY = bwVar;
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
        if (!com.baidu.tieba.frs.b.ckT().ckN() && !com.baidu.tieba.frs.a.ckM().ckN()) {
            if (view == this.gjc || view == this.gje.getCommentContainer() || view == this.fuq || view == this.gjQ.euY.getCommentContainer() || view == this.hhh.getCommentContainer()) {
                if (this.aeY != 0) {
                    m.GZ(((bw) this.aeY).getId());
                }
                if (cbA() != null) {
                    cbA().a(this.gjc, this.aeY);
                }
                b(getContext(), (bw) this.aeY);
                if (this.aeY != 0) {
                    if (view == this.gje.getCommentContainer() || view == this.gjQ.euY.getCommentContainer()) {
                        aq aqVar = new aq("c12942");
                        aqVar.ai("obj_locate", 2);
                        aqVar.ai("obj_type", 5);
                        aqVar.dD("tid", ((bw) this.aeY).getTid());
                        aqVar.dD("nid", ((bw) this.aeY).getNid());
                        TiebaStatic.log(aqVar);
                    }
                }
            } else if (view.getId() == R.id.video_container) {
                if (cbA() != null) {
                    cbA().a(view, this.aeY);
                }
                b(getContext(), (bw) this.aeY);
            }
        }
    }

    private void refreshView() {
        SparseArray<String> sparseArray;
        if (this.aeY == 0 || ((bw) this.aeY).beE() == null) {
            this.gjc.setVisibility(8);
            return;
        }
        this.gjc.setVisibility(0);
        int equipmentWidth = l.getEquipmentWidth(this.efr.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gkd.getLayoutParams();
            layoutParams.width = equipmentWidth - l.getDimens(this.efr.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.gkd.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (((bw) this.aeY).beY() != null && ((bw) this.aeY).beY().user_info != null && ((bw) this.aeY).beY().user_info.is_official == 2) {
            this.gkj = true;
            SparseArray<String> sparseArray2 = ((bw) this.aeY).beY().dislikeInfo;
            this.gkc.setVisibility(0);
            int[] screenDimensions = l.getScreenDimensions(getContext());
            ViewGroup.LayoutParams layoutParams2 = this.gkc.getLayoutParams();
            layoutParams2.width = screenDimensions[0];
            layoutParams2.height = (screenDimensions[0] * 156) / 1080;
            this.gkc.setLayoutParams(layoutParams2);
            if (!TextUtils.isEmpty(((bw) this.aeY).beY().liveStagePicUrl)) {
                this.gkc.startLoad(((bw) this.aeY).beY().liveStagePicUrl, 10, false);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.afe.getLayoutParams();
            marginLayoutParams.topMargin = this.efr.getResources().getDimensionPixelSize(R.dimen.tbds24);
            this.afe.setLayoutParams(marginLayoutParams);
            sparseArray = sparseArray2;
        } else {
            this.gkj = false;
            this.gkc.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.afe.getLayoutParams();
            marginLayoutParams2.topMargin = this.efr.getResources().getDimensionPixelSize(R.dimen.tbds44);
            this.afe.setLayoutParams(marginLayoutParams2);
            sparseArray = null;
        }
        if (this.gkj && sparseArray != null && sparseArray.size() > 0) {
            this.gjX.l((bw) this.aeY, "ala_frs_demo_hell_live_feed_back_type");
        } else if (this.gjX.bLQ() != null) {
            this.gjX.bLQ().setVisibility(8);
        }
        ((bw) this.aeY).z(false, true);
        this.afe.setData((bw) this.aeY);
        SpannableStringBuilder bfo = ((bw) this.aeY).bfo();
        if (bfo != null && !StringUtils.isNull(bfo.toString())) {
            this.mTextTitle.setText(((bw) this.aeY).bfo());
            this.mTextTitle.setVisibility(0);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (((bw) this.aeY).beY().audience_count > 0) {
            this.gkh.setVisibility(0);
            this.fch.setVisibility(0);
            this.fch.setText(String.format(this.efr.getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(((bw) this.aeY).beY().audience_count)));
        } else {
            this.gkh.setVisibility(8);
            this.fch.setVisibility(8);
        }
        this.gkf.setVisibility(8);
        if (((bw) this.aeY).beY().openRecomReason == 1) {
            String str = ((bw) this.aeY).beY().recomReason;
            if (!StringUtils.isNull(str)) {
                this.gkf.setVisibility(0);
                this.gkf.setText(str);
            } else {
                String beT = ((bw) this.aeY).beT();
                String beU = ((bw) this.aeY).beU();
                if (UtilHelper.isDecimal(beT) && UtilHelper.isDecimal(beU) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo doe = com.baidu.tieba.recapp.d.a.dnZ().doe();
                    String str2 = doe.latitude;
                    String str3 = doe.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(beT), Double.parseDouble(beU)) <= 50.0d) {
                        this.gkf.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.gkf.setVisibility(0);
                    }
                }
            }
        }
        tB(rY(1));
        V((bw) this.aeY);
        this.mMaskView.setVisibility((com.baidu.tieba.frs.b.ckT().ckN() || com.baidu.tieba.frs.a.ckM().ckN()) ? 0 : 8);
        onChangeSkinType(this.efr, TbadkCoreApplication.getInst().getSkinType());
        bLU();
        this.gke.playAnimation();
        aN(this.gjc);
    }

    public void bLU() {
        if (k.bbM().isShowImages() && this.aeY != 0 && ((bw) this.aeY).bce() != null && ((bw) this.aeY).bce().beY() != null) {
            this.fcb.setPlaceHolder(3);
            this.fcb.startLoad(((bw) this.aeY).bce().beY().cover, 10, false);
            this.gkd.setVisibility(0);
            return;
        }
        this.gkd.setVisibility(8);
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gje != null) {
            if (this.afe != null) {
                this.afe.setPageUniqueId(bdUniqueId);
            }
            setTag(bdUniqueId);
            r(bdUniqueId);
        }
    }

    public void lA(boolean z) {
        this.gki = z;
    }

    private void V(bw bwVar) {
        if (bwVar != null) {
            TiebaStatic.log(new aq("c12125").dD("tid", bwVar.getId()).ai("obj_locate", this.gki ? 2 : 1).u("obj_id", bwVar.beY().live_id).ai("obj_type", 2));
            if (bwVar.beY() != null && bwVar.beY().user_info != null && bwVar.beY().user_info.is_official == 2) {
                TiebaStatic.log(new aq("c12800").dD("tid", bwVar.getId()));
            }
        }
    }

    private void m(bw bwVar, String str) {
        TiebaStatic.log(new aq("c12126").dD("tid", bwVar.getId()).ai("obj_locate", this.gki ? 2 : 1).u("obj_id", bwVar.beY().live_id).ai("obj_type", 2));
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
            String str2 = this.gkj ? "frs_live_stage_live" : "frs_play";
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
        if (this.aeY != 0) {
            if (i == 1) {
                this.gje.setVisibility(8);
                this.gjQ.setData((bw) this.aeY);
                return;
            }
            this.gjf.setVisibility(this.gje.setData((bw) this.aeY) ? 8 : 0);
            this.gjQ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.agJ = str;
    }

    public int rY(int i) {
        return com.baidu.tieba.a.d.bAB().au(this.agJ, i);
    }
}
