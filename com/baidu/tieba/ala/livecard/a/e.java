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
import android.widget.ImageView;
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
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.z;
import com.baidu.tieba.pb.ThreadSkinView;
import tbclient.AppPosInfo;
/* loaded from: classes10.dex */
public class e extends com.baidu.tieba.card.a<cb> implements com.baidu.tieba.a.e, z {
    private CardUserInfoLayout agp;
    private String aif;
    private final View.OnClickListener aki;
    public TbImageView fTW;
    private TextView fUc;
    public LinearLayout gnT;
    protected ThreadSourceShareAndPraiseLayout hnS;
    private com.baidu.tieba.ala.livecard.vc.a hnZ;
    private RelativeLayout hne;
    private View hnh;
    public ThreadSkinView hod;
    private TbImageView hoe;
    public RelativeLayout hof;
    private TBLottieAnimationView hog;
    private TextView hoh;
    private LinearLayout hoi;
    private View hoj;
    private FrameLayout hok;
    private LinearLayout hol;
    private TextView hom;
    private ImageView hon;
    private boolean hoo;
    private boolean hop;
    private String mForumName;
    private int mLastScreenWidth;
    private View mMaskView;
    private TextView mTextTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.hoo = false;
        this.mLastScreenWidth = 0;
        this.aki = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.crV() != null) {
                    e.this.crV().a(view, e.this.agj);
                }
            }
        };
        setTag(bdUniqueId);
        this.eUY = tbPageContext;
        View view = getView();
        this.hne = (RelativeLayout) view.findViewById(R.id.layout_root);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hne.getLayoutParams();
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        layoutParams.bottomMargin = 0;
        this.gnT = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.hne.setOnClickListener(this);
        this.hoe = (TbImageView) view.findViewById(R.id.video_card_stage_view);
        this.hoe.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.hoe.setDefaultBgResource(R.color.transparent);
        this.agp = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.agp.setUserAfterClickListener(this.aki);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.hof = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.fTW = (TbImageView) view.findViewById(R.id.image_video);
        this.fTW.setDrawCorner(true);
        this.fTW.setPlaceHolder(3);
        this.fTW.setDefaultResource(0);
        this.fTW.setRadiusById(R.string.J_X05);
        TbImageView tbImageView = this.fTW;
        TbImageView tbImageView2 = this.fTW;
        tbImageView.setConrers(15);
        this.fTW.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fTW.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.fTW.setBorderSurroundContent(true);
        this.fTW.setDrawBorder(true);
        this.hoi = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
        this.hog = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.hog.loop(true);
        ap.a(this.hog, R.raw.ala_live2);
        this.hog.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ala.livecard.a.e.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                e.this.hog.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                e.this.hog.cancelAnimation();
            }
        });
        this.fUc = (TextView) view.findViewById(R.id.play_count);
        this.hoh = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.hoj = view.findViewById(R.id.play_count_line);
        this.hng = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        b(this.hng);
        this.hng.setSelectVisible(false);
        this.hng.setIsBarViewVisible(false);
        this.hng.setCommentNumEnable(true);
        this.hng.setLiveShareEnable(false);
        this.hng.setFrom(2);
        this.hng.getCommentContainer().setOnClickListener(this);
        this.hng.hideDisagree();
        com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
        eVar.eMa = 2;
        eVar.eMg = 2;
        this.hng.setAgreeStatisticData(eVar);
        this.iup = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.iup);
        this.iup.setFrom(2);
        this.iup.setShareReportFrom(1);
        this.hnS = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.hnS.fls.setOnClickListener(this);
        this.hnS.fls.getCommentContainer().setOnClickListener(this);
        this.hnS.setFrom(2);
        this.hnS.setShareReportFrom(1);
        this.hnS.setSourceFromForPb(3);
        this.hnS.setStType("frs_page");
        this.hnS.setHideBarName(true);
        this.hnh = view.findViewById(R.id.divider_below_reply_number_layout);
        this.hod = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.hnZ = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.agp.getSuffixContainer());
        this.hnZ.setUniqueId(getTag());
        this.hok = (FrameLayout) view.findViewById(R.id.text_bottom_layout);
        this.hol = (LinearLayout) view.findViewById(R.id.forum_friends_now_looking);
        this.hom = (TextView) view.findViewById(R.id.tv_forum_friends_now_looking);
        this.hon = (ImageView) view.findViewById(R.id.image_forum_friends_now_looking);
    }

    @Override // com.baidu.tieba.card.b
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            g(tbPageContext, i);
            com.baidu.tbadk.core.elementsMaven.c.br(this.hne).og(R.string.J_X06).aJ(R.color.CAM_X0205, R.color.CAM_X0206);
            com.baidu.tbadk.core.elementsMaven.c.br(this.hof).ok(R.dimen.L_X01).oj(R.color.CAM_X0401).og(R.string.J_X05).setBackGroundColor(R.color.CAM_X0611);
            int dimens = l.getDimens(getContext(), R.dimen.tbds31);
            ap.a(this.hoi, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, dimens, dimens, dimens, dimens, dimens, dimens});
            ap.setBackgroundColor(this.hoj, R.color.CAM_X0101);
            ap.setViewTextColor(this.fUc, R.color.CAM_X0101);
            ap.setViewTextColor(this.hoh, R.color.CAM_X0101);
            com.baidu.tbadk.core.util.f.a.btv().oO(0).oX(1).af(l.getDimens(getContext(), R.dimen.tbds31)).oU(R.color.CAM_X0304).oW(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds2)).bv(this.hol);
            ap.setViewTextColor(this.hom, R.color.CAM_X0304);
            WebPManager.a(this.hon, R.drawable.icon_ala_watching, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.agp.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fTW.setPlaceHolder(3);
            this.hng.onChangeSkinType();
            this.mSkinType = i;
            if (this.hnS != null && this.hnS.getVisibility() == 0) {
                this.hnS.onChangeSkinType();
            }
        }
        if (this.agj != 0 && m.IN(((cb) this.agj).getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0109);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0105);
        }
        ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
        this.hnZ.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_video_layout_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(cb cbVar) {
        this.agj = cbVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void uX(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.b.cBr().cBl() && !com.baidu.tieba.frs.a.cBk().cBl()) {
            if (view == this.hne || view == this.hng.getCommentContainer() || view == this.gnT || view == this.hnS.fls.getCommentContainer() || view == this.iup.getCommentContainer() || view == this.hol) {
                if (this.agj != 0) {
                    m.IM(((cb) this.agj).getId());
                }
                if (crV() != null) {
                    crV().a(this.hne, this.agj);
                }
                b(getContext(), (cb) this.agj);
                if (this.agj != 0) {
                    if (view == this.hng.getCommentContainer() || view == this.hnS.fls.getCommentContainer()) {
                        ar arVar = new ar("c12942");
                        arVar.ap("obj_locate", 2);
                        arVar.ap("obj_type", 5);
                        arVar.dR("tid", ((cb) this.agj).getTid());
                        arVar.dR(IntentConfig.NID, ((cb) this.agj).bmo());
                        com.baidu.tbadk.pageExtra.c bR = com.baidu.tbadk.pageExtra.d.bR(view);
                        if (bR != null) {
                            arVar.dR("obj_cur_page", bR.getCurrentPageKey());
                        }
                        if (com.baidu.tbadk.pageExtra.d.bDM() != null) {
                            arVar.dR("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDM());
                        }
                        TiebaStatic.log(arVar);
                    }
                }
            } else if (view.getId() == R.id.video_container) {
                if (crV() != null) {
                    crV().a(view, this.agj);
                }
                b(getContext(), (cb) this.agj);
            }
        }
    }

    private void refreshView() {
        SparseArray<String> sparseArray;
        if (this.agj == 0 || ((cb) this.agj).bnQ() == null) {
            this.hne.setVisibility(8);
            return;
        }
        this.hne.setVisibility(0);
        int equipmentWidth = l.getEquipmentWidth(this.eUY.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hof.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext()) - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.hof.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (((cb) this.agj).boj() != null && ((cb) this.agj).boj().user_info != null && ((cb) this.agj).boj().user_info.is_official == 2) {
            this.hop = true;
            SparseArray<String> sparseArray2 = ((cb) this.agj).boj().dislikeInfo;
            this.hoe.setVisibility(0);
            int[] screenDimensions = l.getScreenDimensions(getContext());
            ViewGroup.LayoutParams layoutParams2 = this.hoe.getLayoutParams();
            layoutParams2.width = screenDimensions[0];
            layoutParams2.height = (screenDimensions[0] * 156) / 1080;
            this.hoe.setLayoutParams(layoutParams2);
            if (!TextUtils.isEmpty(((cb) this.agj).boj().liveStagePicUrl)) {
                this.hoe.startLoad(((cb) this.agj).boj().liveStagePicUrl, 10, false);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.agp.getLayoutParams();
            marginLayoutParams.topMargin = this.eUY.getResources().getDimensionPixelSize(R.dimen.tbds24);
            this.agp.setLayoutParams(marginLayoutParams);
            sparseArray = sparseArray2;
        } else {
            this.hop = false;
            this.hoe.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.agp.getLayoutParams();
            marginLayoutParams2.topMargin = this.eUY.getResources().getDimensionPixelSize(R.dimen.tbds44);
            this.agp.setLayoutParams(marginLayoutParams2);
            sparseArray = null;
        }
        if (this.hop && sparseArray != null && sparseArray.size() > 0) {
            this.hnZ.l((cb) this.agj, "ala_frs_demo_hell_live_feed_back_type");
        } else if (this.hnZ.bYO() != null) {
            this.hnZ.bYO().setVisibility(8);
        }
        ((cb) this.agj).y(false, true);
        this.agp.setData((cb) this.agj);
        SpannableStringBuilder boz = ((cb) this.agj).boz();
        if (boz != null && !StringUtils.isNull(boz.toString())) {
            this.mTextTitle.setText(((cb) this.agj).boz());
            this.mTextTitle.setVisibility(0);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (((cb) this.agj).boj().audience_count > 0) {
            this.hoj.setVisibility(0);
            this.fUc.setVisibility(0);
            this.fUc.setText(String.format(this.eUY.getResources().getString(R.string.ala_audience_count_prefix), au.numFormatOverWan(((cb) this.agj).boj().audience_count)));
        } else {
            this.hoj.setVisibility(8);
            this.fUc.setVisibility(8);
        }
        this.hoh.setVisibility(8);
        if (((cb) this.agj).boj().openRecomReason == 1) {
            String str = ((cb) this.agj).boj().recomReason;
            if (!StringUtils.isNull(str)) {
                this.hoh.setVisibility(0);
                this.hoh.setText(str);
            } else {
                String latitude = ((cb) this.agj).getLatitude();
                String bof = ((cb) this.agj).bof();
                if (UtilHelper.isDecimal(latitude) && UtilHelper.isDecimal(bof) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo dEj = com.baidu.tieba.recapp.c.a.dEe().dEj();
                    String str2 = dEj.latitude;
                    String str3 = dEj.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(latitude), Double.parseDouble(bof)) <= 50.0d) {
                        this.hoh.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.hoh.setVisibility(0);
                    }
                }
            }
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hok.getLayoutParams();
        if (((cb) this.agj).boj() != null && !StringUtils.isNull(((cb) this.agj).boj().forumUserLiveMsg)) {
            this.hol.setVisibility(0);
            this.hom.setText(au.cutChineseAndEnglishWithSuffix(((cb) this.agj).boj().forumUserLiveMsg, 10, StringHelper.STRING_MORE) + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_forum_live_suffix));
            layoutParams3.addRule(3, R.id.forum_friends_now_looking);
        } else {
            this.hol.setVisibility(8);
            layoutParams3.addRule(3, R.id.video_card_content_layout);
        }
        this.hok.setLayoutParams(layoutParams3);
        uZ(sW(1));
        Z((cb) this.agj);
        this.mMaskView.setVisibility((com.baidu.tieba.frs.b.cBr().cBl() || com.baidu.tieba.frs.a.cBk().cBl()) ? 0 : 8);
        onChangeSkinType(this.eUY, TbadkCoreApplication.getInst().getSkinType());
        bYS();
        this.hog.playAnimation();
        ba(this.hne);
    }

    public void bYS() {
        if (k.bkT().isShowImages() && this.agj != 0 && ((cb) this.agj).bln() != null && ((cb) this.agj).bln().boj() != null) {
            this.fTW.setPlaceHolder(3);
            this.fTW.startLoad(((cb) this.agj).bln().boj().cover, 10, false);
            this.hof.setVisibility(0);
            return;
        }
        this.hof.setVisibility(8);
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hng != null) {
            if (this.agp != null) {
                this.agp.setPageUniqueId(bdUniqueId);
            }
            setTag(bdUniqueId);
            q(bdUniqueId);
        }
    }

    public void nH(boolean z) {
        this.hoo = z;
    }

    private void Z(cb cbVar) {
        if (cbVar != null) {
            TiebaStatic.log(new ar("c12125").dR("tid", cbVar.getId()).ap("obj_locate", this.hoo ? 2 : 1).v("obj_id", cbVar.boj().live_id).ap("obj_type", 2));
            if (cbVar.boj() != null && cbVar.boj().user_info != null && cbVar.boj().user_info.is_official == 2) {
                TiebaStatic.log(new ar("c12800").dR("tid", cbVar.getId()));
            }
        }
    }

    private void m(cb cbVar, String str) {
        TiebaStatic.log(new ar("c12126").dR("tid", cbVar.getId()).ap("obj_locate", this.hoo ? 2 : 1).v("obj_id", cbVar.boj().live_id).ap("obj_type", 2));
        if (cbVar.boj() != null && cbVar.boj().user_info != null && cbVar.boj().user_info.is_official == 2) {
            TiebaStatic.log(new ar("c12801").dR("tid", cbVar.getId()));
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (str.equals("frs_live_play")) {
            if (cbVar.bnU().equals(this.mForumName)) {
                TiebaStatic.log(new ar("c11843").dR("uid", currentAccount).v("fid", cbVar.getFid()));
            } else {
                TiebaStatic.log(new ar("c11845").dR("uid", currentAccount).v("fid", cbVar.getFid()));
            }
        }
    }

    public void b(Context context, cb cbVar) {
        String str;
        if (context != null && cbVar != null && cbVar.boj() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(context, R.string.no_network_guide);
                return;
            }
            String str2 = this.hop ? "frs_live_stage_live" : "frs_play";
            if (cbVar.bnC() != null) {
                str2 = cbVar.bnC();
            }
            int frsCurTabType = TbSingleton.getInstance().getFrsCurTabType();
            if (frsCurTabType == 14) {
                str = AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_NEW + cbVar.getFid();
            } else {
                str = frsCurTabType == 13 ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_HOT + cbVar.getFid() : str2;
            }
            m(cbVar, str);
            AlaInfoData boj = cbVar.boj();
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && cbVar.bnQ() != null) {
                z = TextUtils.equals(cbVar.bnQ().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(boj);
            if (boj.user_info != null) {
                alaLiveInfoCoreData.userName = boj.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, str, "", z, this.mForumName)));
        }
    }

    public void uZ(int i) {
        if (this.agj != 0) {
            if (i == 1) {
                this.hng.setVisibility(8);
                this.hnS.setData((cb) this.agj);
                return;
            }
            this.hnh.setVisibility(this.hng.setData((cb) this.agj) ? 8 : 0);
            this.hnS.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aif = str;
    }

    public int sW(int i) {
        return com.baidu.tieba.a.d.bKP().aB(this.aif, i);
    }
}
