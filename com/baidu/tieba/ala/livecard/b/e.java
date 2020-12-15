package com.baidu.tieba.ala.livecard.b;

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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.z;
import com.baidu.tieba.pb.ThreadSkinView;
import tbclient.AppPosInfo;
/* loaded from: classes6.dex */
public class e extends com.baidu.tieba.card.a<by> implements com.baidu.tieba.a.e, z {
    private CardUserInfoLayout agP;
    private String aiw;
    private final View.OnClickListener akI;
    public TbImageView fMK;
    private TextView fMQ;
    public LinearLayout gfP;
    private RelativeLayout hbL;
    private View hbO;
    private com.baidu.tieba.ala.livecard.vc.a hcG;
    public ThreadSkinView hcK;
    private TbImageView hcL;
    public RelativeLayout hcM;
    private TBLottieAnimationView hcN;
    private TextView hcO;
    private LinearLayout hcP;
    private View hcQ;
    private boolean hcR;
    private boolean hcS;
    protected ThreadSourceShareAndPraiseLayout hcz;
    private String mForumName;
    private int mLastScreenWidth;
    private View mMaskView;
    private TextView mTextTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.hcR = false;
        this.mLastScreenWidth = 0;
        this.akI = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.crJ() != null) {
                    e.this.crJ().a(view, e.this.agJ);
                }
            }
        };
        setTag(bdUniqueId);
        this.eNx = tbPageContext;
        View view = getView();
        this.hbL = (RelativeLayout) view.findViewById(R.id.layout_root);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hbL.getLayoutParams();
        if (com.baidu.tbadk.a.d.bkA()) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
        } else {
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
            layoutParams.bottomMargin = 0;
        }
        this.gfP = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.hbL.setOnClickListener(this);
        this.hcL = (TbImageView) view.findViewById(R.id.video_card_stage_view);
        this.hcL.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.hcL.setDefaultBgResource(R.color.transparent);
        this.agP = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.agP.setUserAfterClickListener(this.akI);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.hcM = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.fMK = (TbImageView) view.findViewById(R.id.image_video);
        this.fMK.setDrawCorner(true);
        this.fMK.setPlaceHolder(3);
        this.fMK.setDefaultResource(0);
        this.fMK.setDefaultErrorResource(0);
        this.fMK.setRadiusById(R.string.J_X05);
        TbImageView tbImageView = this.fMK;
        TbImageView tbImageView2 = this.fMK;
        tbImageView.setConrers(15);
        this.fMK.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fMK.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.fMK.setBorderSurroundContent(true);
        this.fMK.setDrawBorder(true);
        this.hcP = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
        this.hcN = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.hcN.loop(true);
        ap.a(this.hcN, (int) R.raw.ala_live2);
        this.hcN.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.e.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                e.this.hcN.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                e.this.hcN.cancelAnimation();
            }
        });
        this.fMQ = (TextView) view.findViewById(R.id.play_count);
        this.hcO = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.hcQ = view.findViewById(R.id.play_count_line);
        this.hbN = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        b(this.hbN);
        this.hbN.setSelectVisible(false);
        this.hbN.setIsBarViewVisible(false);
        this.hbN.setCommentNumEnable(true);
        this.hbN.setLiveShareEnable(false);
        this.hbN.setFrom(2);
        this.hbN.getCommentContainer().setOnClickListener(this);
        this.hbN.hideDisagree();
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eEJ = 2;
        dVar.eEP = 2;
        this.hbN.setAgreeStatisticData(dVar);
        this.igX = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.igX);
        this.igX.setFrom(2);
        this.igX.setShareReportFrom(1);
        this.hcz = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.hcz.feb.setOnClickListener(this);
        this.hcz.feb.getCommentContainer().setOnClickListener(this);
        this.hcz.setFrom(2);
        this.hcz.setShareReportFrom(1);
        this.hcz.setSourceFromForPb(3);
        this.hcz.setStType("frs_page");
        this.hcz.setHideBarName(true);
        this.hbO = view.findViewById(R.id.divider_below_reply_number_layout);
        this.hcK = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.hcG = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.agP.getSuffixContainer());
        this.hcG.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.b
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            g(tbPageContext, i);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.hbL).pA(com.baidu.tbadk.a.d.bkA() ? R.string.J_X02 : R.string.J_X06).aP(R.color.CAM_X0205, R.color.CAM_X0206);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.hcM).pD(R.dimen.L_X01).pC(R.color.CAM_X0401).pA(R.string.J_X05).setBackGroundColor(R.color.CAM_X0611);
            int dimens = l.getDimens(getContext(), R.dimen.tbds31);
            ap.a(this.hcP, (int) R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, dimens, dimens, dimens, dimens, dimens, dimens});
            ap.setBackgroundColor(this.hcQ, R.color.CAM_X0101);
            ap.setViewTextColor(this.fMQ, (int) R.color.CAM_X0101);
            ap.setViewTextColor(this.hcO, (int) R.color.CAM_X0101);
            this.agP.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fMK.setPlaceHolder(3);
            this.hbN.onChangeSkinType();
            this.mSkinType = i;
            if (this.hcz != null && this.hcz.getVisibility() == 0) {
                this.hcz.onChangeSkinType();
            }
        }
        if (this.agJ != 0 && n.Jr(((by) this.agJ).getId())) {
            ap.setViewTextColor(this.mTextTitle, (int) R.color.CAM_X0109);
        } else {
            ap.setViewTextColor(this.mTextTitle, (int) R.color.CAM_X0105);
        }
        ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
        this.hcG.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_video_layout_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(by byVar) {
        this.agJ = byVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void wi(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.b.cBe().cAY() && !com.baidu.tieba.frs.a.cAX().cAY()) {
            if (view == this.hbL || view == this.hbN.getCommentContainer() || view == this.gfP || view == this.hcz.feb.getCommentContainer() || view == this.igX.getCommentContainer()) {
                if (this.agJ != 0) {
                    n.Jq(((by) this.agJ).getId());
                }
                if (crJ() != null) {
                    crJ().a(this.hbL, this.agJ);
                }
                b(getContext(), (by) this.agJ);
                if (this.agJ != 0) {
                    if (view == this.hbN.getCommentContainer() || view == this.hcz.feb.getCommentContainer()) {
                        ar arVar = new ar("c12942");
                        arVar.al("obj_locate", 2);
                        arVar.al("obj_type", 5);
                        arVar.dY("tid", ((by) this.agJ).getTid());
                        arVar.dY("nid", ((by) this.agJ).getNid());
                        com.baidu.tbadk.pageExtra.c bM = com.baidu.tbadk.pageExtra.d.bM(view);
                        if (bM != null) {
                            arVar.dY("obj_cur_page", bM.getCurrentPageKey());
                        }
                        if (com.baidu.tbadk.pageExtra.d.bET() != null) {
                            arVar.dY("obj_pre_page", com.baidu.tbadk.pageExtra.d.bET());
                        }
                        TiebaStatic.log(arVar);
                    }
                }
            } else if (view.getId() == R.id.video_container) {
                if (crJ() != null) {
                    crJ().a(view, this.agJ);
                }
                b(getContext(), (by) this.agJ);
            }
        }
    }

    private void refreshView() {
        SparseArray<String> sparseArray;
        if (this.agJ == 0 || ((by) this.agJ).boP() == null) {
            this.hbL.setVisibility(8);
            return;
        }
        this.hbL.setVisibility(0);
        int equipmentWidth = l.getEquipmentWidth(this.eNx.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hcM.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext()) - (com.baidu.tbadk.a.d.bkA() ? UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2 : (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.hcM.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (((by) this.agJ).bpj() != null && ((by) this.agJ).bpj().user_info != null && ((by) this.agJ).bpj().user_info.is_official == 2) {
            this.hcS = true;
            SparseArray<String> sparseArray2 = ((by) this.agJ).bpj().dislikeInfo;
            this.hcL.setVisibility(0);
            int[] screenDimensions = l.getScreenDimensions(getContext());
            ViewGroup.LayoutParams layoutParams2 = this.hcL.getLayoutParams();
            layoutParams2.width = screenDimensions[0];
            layoutParams2.height = (screenDimensions[0] * 156) / 1080;
            this.hcL.setLayoutParams(layoutParams2);
            if (!TextUtils.isEmpty(((by) this.agJ).bpj().liveStagePicUrl)) {
                this.hcL.startLoad(((by) this.agJ).bpj().liveStagePicUrl, 10, false);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.agP.getLayoutParams();
            marginLayoutParams.topMargin = this.eNx.getResources().getDimensionPixelSize(R.dimen.tbds24);
            this.agP.setLayoutParams(marginLayoutParams);
            sparseArray = sparseArray2;
        } else {
            this.hcS = false;
            this.hcL.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.agP.getLayoutParams();
            marginLayoutParams2.topMargin = this.eNx.getResources().getDimensionPixelSize(R.dimen.tbds44);
            this.agP.setLayoutParams(marginLayoutParams2);
            sparseArray = null;
        }
        if (this.hcS && sparseArray != null && sparseArray.size() > 0) {
            this.hcG.l((by) this.agJ, "ala_frs_demo_hell_live_feed_back_type");
        } else if (this.hcG.bZa() != null) {
            this.hcG.bZa().setVisibility(8);
        }
        ((by) this.agJ).z(false, true);
        this.agP.setData((by) this.agJ);
        SpannableStringBuilder bpz = ((by) this.agJ).bpz();
        if (bpz != null && !StringUtils.isNull(bpz.toString())) {
            this.mTextTitle.setText(((by) this.agJ).bpz());
            this.mTextTitle.setVisibility(0);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (((by) this.agJ).bpj().audience_count > 0) {
            this.hcQ.setVisibility(0);
            this.fMQ.setVisibility(0);
            this.fMQ.setText(String.format(this.eNx.getResources().getString(R.string.ala_audience_count_prefix), au.numFormatOverWan(((by) this.agJ).bpj().audience_count)));
        } else {
            this.hcQ.setVisibility(8);
            this.fMQ.setVisibility(8);
        }
        this.hcO.setVisibility(8);
        if (((by) this.agJ).bpj().openRecomReason == 1) {
            String str = ((by) this.agJ).bpj().recomReason;
            if (!StringUtils.isNull(str)) {
                this.hcO.setVisibility(0);
                this.hcO.setText(str);
            } else {
                String bpe = ((by) this.agJ).bpe();
                String bpf = ((by) this.agJ).bpf();
                if (UtilHelper.isDecimal(bpe) && UtilHelper.isDecimal(bpf) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo dGd = com.baidu.tieba.recapp.d.a.dFY().dGd();
                    String str2 = dGd.latitude;
                    String str3 = dGd.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(bpe), Double.parseDouble(bpf)) <= 50.0d) {
                        this.hcO.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.hcO.setVisibility(0);
                    }
                }
            }
        }
        wk(ul(1));
        Y((by) this.agJ);
        this.mMaskView.setVisibility((com.baidu.tieba.frs.b.cBe().cAY() || com.baidu.tieba.frs.a.cAX().cAY()) ? 0 : 8);
        onChangeSkinType(this.eNx, TbadkCoreApplication.getInst().getSkinType());
        bZe();
        this.hcN.playAnimation();
        aO(this.hbL);
    }

    public void bZe() {
        if (k.blV().isShowImages() && this.agJ != 0 && ((by) this.agJ).bmn() != null && ((by) this.agJ).bmn().bpj() != null) {
            this.fMK.setPlaceHolder(3);
            this.fMK.startLoad(((by) this.agJ).bmn().bpj().cover, 10, false);
            this.hcM.setVisibility(0);
            return;
        }
        this.hcM.setVisibility(8);
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hbN != null) {
            if (this.agP != null) {
                this.agP.setPageUniqueId(bdUniqueId);
            }
            setTag(bdUniqueId);
            q(bdUniqueId);
        }
    }

    public void nb(boolean z) {
        this.hcR = z;
    }

    private void Y(by byVar) {
        if (byVar != null) {
            TiebaStatic.log(new ar("c12125").dY("tid", byVar.getId()).al("obj_locate", this.hcR ? 2 : 1).w("obj_id", byVar.bpj().live_id).al("obj_type", 2));
            if (byVar.bpj() != null && byVar.bpj().user_info != null && byVar.bpj().user_info.is_official == 2) {
                TiebaStatic.log(new ar("c12800").dY("tid", byVar.getId()));
            }
        }
    }

    private void m(by byVar, String str) {
        TiebaStatic.log(new ar("c12126").dY("tid", byVar.getId()).al("obj_locate", this.hcR ? 2 : 1).w("obj_id", byVar.bpj().live_id).al("obj_type", 2));
        if (byVar.bpj() != null && byVar.bpj().user_info != null && byVar.bpj().user_info.is_official == 2) {
            TiebaStatic.log(new ar("c12801").dY("tid", byVar.getId()));
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (str.equals("frs_live_play")) {
            if (byVar.boT().equals(this.mForumName)) {
                TiebaStatic.log(new ar("c11843").dY("uid", currentAccount).w("fid", byVar.getFid()));
            } else {
                TiebaStatic.log(new ar("c11845").dY("uid", currentAccount).w("fid", byVar.getFid()));
            }
        }
    }

    public void b(Context context, by byVar) {
        String str;
        if (context != null && byVar != null && byVar.bpj() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(context, (int) R.string.no_network_guide);
                return;
            }
            String str2 = this.hcS ? "frs_live_stage_live" : "frs_play";
            if (byVar.boB() != null) {
                str2 = byVar.boB();
            }
            int frsCurTabType = TbSingleton.getInstance().getFrsCurTabType();
            if (frsCurTabType == 14) {
                str = AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_NEW + byVar.getFid();
            } else {
                str = frsCurTabType == 13 ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_HOT + byVar.getFid() : str2;
            }
            m(byVar, str);
            AlaInfoData bpj = byVar.bpj();
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && byVar.boP() != null) {
                z = TextUtils.equals(byVar.boP().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bpj);
            if (bpj.user_info != null) {
                alaLiveInfoCoreData.userName = bpj.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, str, "", z, this.mForumName)));
        }
    }

    public void wk(int i) {
        if (this.agJ != 0) {
            if (i == 1) {
                this.hbN.setVisibility(8);
                this.hcz.setData((by) this.agJ);
                return;
            }
            this.hbO.setVisibility(this.hbN.setData((by) this.agJ) ? 8 : 0);
            this.hcz.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aiw = str;
    }

    public int ul(int i) {
        return com.baidu.tieba.a.d.bLU().ax(this.aiw, i);
    }
}
