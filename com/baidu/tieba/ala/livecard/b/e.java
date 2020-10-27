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
    public LinearLayout fSf;
    public TbImageView fzG;
    private TextView fzM;
    private RelativeLayout gMq;
    private View gMt;
    protected ThreadSourceShareAndPraiseLayout gNe;
    private com.baidu.tieba.ala.livecard.vc.a gNl;
    public ThreadSkinView gNp;
    private TbImageView gNq;
    public RelativeLayout gNr;
    private TBLottieAnimationView gNs;
    private TextView gNt;
    private LinearLayout gNu;
    private View gNv;
    private boolean gNw;
    private boolean gNx;
    private String mForumName;
    private int mLastScreenWidth;
    private View mMaskView;
    private TextView mTextTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.gNw = false;
        this.mLastScreenWidth = 0;
        this.ajG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.cls() != null) {
                    e.this.cls().a(view, e.this.afI);
                }
            }
        };
        setTag(bdUniqueId);
        this.eCn = tbPageContext;
        View view = getView();
        this.gMq = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fSf = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.gMq.setOnClickListener(this);
        this.gNq = (TbImageView) view.findViewById(R.id.video_card_stage_view);
        this.gNq.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.gNq.setDefaultBgResource(R.color.transparent);
        this.afO = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.afO.setUserAfterClickListener(this.ajG);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gNr = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.fzG = (TbImageView) view.findViewById(R.id.image_video);
        this.fzG.setDrawCorner(true);
        this.fzG.setPlaceHolder(3);
        this.fzG.setDefaultResource(0);
        this.fzG.setDefaultErrorResource(0);
        this.fzG.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        TbImageView tbImageView = this.fzG;
        TbImageView tbImageView2 = this.fzG;
        tbImageView.setConrers(15);
        this.fzG.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fzG.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.fzG.setBorderSurroundContent(true);
        this.fzG.setDrawBorder(true);
        this.gNu = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
        this.gNs = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.gNs.loop(true);
        ap.a(this.gNs, R.raw.ala_live2);
        this.gNs.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.e.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                e.this.gNs.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                e.this.gNs.cancelAnimation();
            }
        });
        this.fzM = (TextView) view.findViewById(R.id.play_count);
        this.gNt = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.gNv = view.findViewById(R.id.play_count_line);
        this.gMs = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        b(this.gMs);
        this.gMs.setSelectVisible(false);
        this.gMs.setIsBarViewVisible(false);
        this.gMs.setCommentNumEnable(true);
        this.gMs.setLiveShareEnable(false);
        this.gMs.setFrom(2);
        this.gMs.getCommentContainer().setOnClickListener(this);
        this.gMs.hideDisagree();
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.etA = 2;
        cVar.etG = 2;
        this.gMs.setAgreeStatisticData(cVar);
        this.hPB = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.hPB);
        this.hPB.setFrom(2);
        this.hPB.setShareReportFrom(1);
        this.gNe = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.gNe.eRI.setOnClickListener(this);
        this.gNe.eRI.getCommentContainer().setOnClickListener(this);
        this.gNe.setFrom(2);
        this.gNe.setShareReportFrom(1);
        this.gNe.setSourceFromForPb(3);
        this.gNe.setStType("frs_page");
        this.gNe.setHideBarName(true);
        this.gMt = view.findViewById(R.id.divider_below_reply_number_layout);
        this.gNp = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.gNl = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.afO.getSuffixContainer());
        this.gNl.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.b
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            g(tbPageContext, i);
            ap.setBackgroundResource(this.gMq, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.gNr, R.drawable.bg_ala_shape);
            int dimens = l.getDimens(getContext(), R.dimen.tbds10);
            ap.a(this.gNu, R.color.cp_other_d, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, 0.0f, 0.0f, dimens, dimens, 0.0f, 0.0f});
            ap.setBackgroundColor(this.gNv, R.color.cp_cont_a);
            ap.setViewTextColor(this.fzM, R.color.cp_cont_a);
            ap.setViewTextColor(this.gNt, R.color.cp_cont_a);
            this.afO.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fzG.setPlaceHolder(3);
            this.gMs.onChangeSkinType();
            this.mSkinType = i;
            if (this.gNe != null && this.gNe.getVisibility() == 0) {
                this.gNe.onChangeSkinType();
            }
        }
        if (this.afI != 0 && n.IJ(((bw) this.afI).getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b);
        }
        ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.gNl.onChangeSkinType();
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
    public void uQ(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.b.cuL().cuF() && !com.baidu.tieba.frs.a.cuE().cuF()) {
            if (view == this.gMq || view == this.gMs.getCommentContainer() || view == this.fSf || view == this.gNe.eRI.getCommentContainer() || view == this.hPB.getCommentContainer()) {
                if (this.afI != 0) {
                    n.II(((bw) this.afI).getId());
                }
                if (cls() != null) {
                    cls().a(this.gMq, this.afI);
                }
                b(getContext(), (bw) this.afI);
                if (this.afI != 0) {
                    if (view == this.gMs.getCommentContainer() || view == this.gNe.eRI.getCommentContainer()) {
                        aq aqVar = new aq("c12942");
                        aqVar.aj("obj_locate", 2);
                        aqVar.aj("obj_type", 5);
                        aqVar.dR("tid", ((bw) this.afI).getTid());
                        aqVar.dR("nid", ((bw) this.afI).getNid());
                        TiebaStatic.log(aqVar);
                    }
                }
            } else if (view.getId() == R.id.video_container) {
                if (cls() != null) {
                    cls().a(view, this.afI);
                }
                b(getContext(), (bw) this.afI);
            }
        }
    }

    private void refreshView() {
        SparseArray<String> sparseArray;
        if (this.afI == 0 || ((bw) this.afI).bka() == null) {
            this.gMq.setVisibility(8);
            return;
        }
        this.gMq.setVisibility(0);
        int equipmentWidth = l.getEquipmentWidth(this.eCn.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gNr.getLayoutParams();
            layoutParams.width = equipmentWidth - l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.gNr.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (((bw) this.afI).bku() != null && ((bw) this.afI).bku().user_info != null && ((bw) this.afI).bku().user_info.is_official == 2) {
            this.gNx = true;
            SparseArray<String> sparseArray2 = ((bw) this.afI).bku().dislikeInfo;
            this.gNq.setVisibility(0);
            int[] screenDimensions = l.getScreenDimensions(getContext());
            ViewGroup.LayoutParams layoutParams2 = this.gNq.getLayoutParams();
            layoutParams2.width = screenDimensions[0];
            layoutParams2.height = (screenDimensions[0] * 156) / 1080;
            this.gNq.setLayoutParams(layoutParams2);
            if (!TextUtils.isEmpty(((bw) this.afI).bku().liveStagePicUrl)) {
                this.gNq.startLoad(((bw) this.afI).bku().liveStagePicUrl, 10, false);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.afO.getLayoutParams();
            marginLayoutParams.topMargin = this.eCn.getResources().getDimensionPixelSize(R.dimen.tbds24);
            this.afO.setLayoutParams(marginLayoutParams);
            sparseArray = sparseArray2;
        } else {
            this.gNx = false;
            this.gNq.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.afO.getLayoutParams();
            marginLayoutParams2.topMargin = this.eCn.getResources().getDimensionPixelSize(R.dimen.tbds44);
            this.afO.setLayoutParams(marginLayoutParams2);
            sparseArray = null;
        }
        if (this.gNx && sparseArray != null && sparseArray.size() > 0) {
            this.gNl.l((bw) this.afI, "ala_frs_demo_hell_live_feed_back_type");
        } else if (this.gNl.bTo() != null) {
            this.gNl.bTo().setVisibility(8);
        }
        ((bw) this.afI).z(false, true);
        this.afO.setData((bw) this.afI);
        SpannableStringBuilder bkK = ((bw) this.afI).bkK();
        if (bkK != null && !StringUtils.isNull(bkK.toString())) {
            this.mTextTitle.setText(((bw) this.afI).bkK());
            this.mTextTitle.setVisibility(0);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (((bw) this.afI).bku().audience_count > 0) {
            this.gNv.setVisibility(0);
            this.fzM.setVisibility(0);
            this.fzM.setText(String.format(this.eCn.getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(((bw) this.afI).bku().audience_count)));
        } else {
            this.gNv.setVisibility(8);
            this.fzM.setVisibility(8);
        }
        this.gNt.setVisibility(8);
        if (((bw) this.afI).bku().openRecomReason == 1) {
            String str = ((bw) this.afI).bku().recomReason;
            if (!StringUtils.isNull(str)) {
                this.gNt.setVisibility(0);
                this.gNt.setText(str);
            } else {
                String bkp = ((bw) this.afI).bkp();
                String bkq = ((bw) this.afI).bkq();
                if (UtilHelper.isDecimal(bkp) && UtilHelper.isDecimal(bkq) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo dyF = com.baidu.tieba.recapp.d.a.dyA().dyF();
                    String str2 = dyF.latitude;
                    String str3 = dyF.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(bkp), Double.parseDouble(bkq)) <= 50.0d) {
                        this.gNt.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.gNt.setVisibility(0);
                    }
                }
            }
        }
        uS(sZ(1));
        W((bw) this.afI);
        this.mMaskView.setVisibility((com.baidu.tieba.frs.b.cuL().cuF() || com.baidu.tieba.frs.a.cuE().cuF()) ? 0 : 8);
        onChangeSkinType(this.eCn, TbadkCoreApplication.getInst().getSkinType());
        bTs();
        this.gNs.playAnimation();
        aQ(this.gMq);
    }

    public void bTs() {
        if (k.bhh().isShowImages() && this.afI != 0 && ((bw) this.afI).bhz() != null && ((bw) this.afI).bhz().bku() != null) {
            this.fzG.setPlaceHolder(3);
            this.fzG.startLoad(((bw) this.afI).bhz().bku().cover, 10, false);
            this.gNr.setVisibility(0);
            return;
        }
        this.gNr.setVisibility(8);
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gMs != null) {
            if (this.afO != null) {
                this.afO.setPageUniqueId(bdUniqueId);
            }
            setTag(bdUniqueId);
            q(bdUniqueId);
        }
    }

    public void mv(boolean z) {
        this.gNw = z;
    }

    private void W(bw bwVar) {
        if (bwVar != null) {
            TiebaStatic.log(new aq("c12125").dR("tid", bwVar.getId()).aj("obj_locate", this.gNw ? 2 : 1).w("obj_id", bwVar.bku().live_id).aj("obj_type", 2));
            if (bwVar.bku() != null && bwVar.bku().user_info != null && bwVar.bku().user_info.is_official == 2) {
                TiebaStatic.log(new aq("c12800").dR("tid", bwVar.getId()));
            }
        }
    }

    private void m(bw bwVar, String str) {
        TiebaStatic.log(new aq("c12126").dR("tid", bwVar.getId()).aj("obj_locate", this.gNw ? 2 : 1).w("obj_id", bwVar.bku().live_id).aj("obj_type", 2));
        if (bwVar.bku() != null && bwVar.bku().user_info != null && bwVar.bku().user_info.is_official == 2) {
            TiebaStatic.log(new aq("c12801").dR("tid", bwVar.getId()));
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (str.equals("frs_live_play")) {
            if (bwVar.bke().equals(this.mForumName)) {
                TiebaStatic.log(new aq("c11843").dR("uid", currentAccount).w("fid", bwVar.getFid()));
            } else {
                TiebaStatic.log(new aq("c11845").dR("uid", currentAccount).w("fid", bwVar.getFid()));
            }
        }
    }

    public void b(Context context, bw bwVar) {
        String str;
        if (context != null && bwVar != null && bwVar.bku() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(context, R.string.no_network_guide);
                return;
            }
            String str2 = this.gNx ? "frs_live_stage_live" : "frs_play";
            if (bwVar.bjM() != null) {
                str2 = bwVar.bjM();
            }
            int frsCurTabType = TbSingleton.getInstance().getFrsCurTabType();
            if (frsCurTabType == 14) {
                str = AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_NEW + bwVar.getFid();
            } else {
                str = frsCurTabType == 13 ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_HOT + bwVar.getFid() : str2;
            }
            m(bwVar, str);
            AlaInfoData bku = bwVar.bku();
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && bwVar.bka() != null) {
                z = TextUtils.equals(bwVar.bka().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bku);
            if (bku.user_info != null) {
                alaLiveInfoCoreData.userName = bku.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, str, "", z, this.mForumName)));
        }
    }

    public void uS(int i) {
        if (this.afI != 0) {
            if (i == 1) {
                this.gMs.setVisibility(8);
                this.gNe.setData((bw) this.afI);
                return;
            }
            this.gMt.setVisibility(this.gMs.setData((bw) this.afI) ? 8 : 0);
            this.gNe.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahu = str;
    }

    public int sZ(int i) {
        return com.baidu.tieba.a.d.bGs().av(this.ahu, i);
    }
}
