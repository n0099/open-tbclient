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
/* loaded from: classes9.dex */
public class e extends com.baidu.tieba.card.a<cb> implements com.baidu.tieba.a.e, z {
    private CardUserInfoLayout ahH;
    private String ajx;
    private final View.OnClickListener alB;
    private TextView fVC;
    public TbImageView fVw;
    public LinearLayout gpQ;
    protected ThreadSourceShareAndPraiseLayout hpQ;
    private com.baidu.tieba.ala.livecard.vc.a hpX;
    private RelativeLayout hpc;
    private View hpf;
    public ThreadSkinView hqb;
    private TbImageView hqc;
    public RelativeLayout hqd;
    private TBLottieAnimationView hqe;
    private TextView hqf;
    private LinearLayout hqg;
    private View hqh;
    private FrameLayout hqi;
    private LinearLayout hqj;
    private TextView hqk;
    private ImageView hql;
    private boolean hqm;
    private boolean hqn;
    private String mForumName;
    private int mLastScreenWidth;
    private View mMaskView;
    private TextView mTextTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.hqm = false;
        this.mLastScreenWidth = 0;
        this.alB = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.csi() != null) {
                    e.this.csi().a(view, e.this.ahB);
                }
            }
        };
        setTag(bdUniqueId);
        this.eWx = tbPageContext;
        View view = getView();
        this.hpc = (RelativeLayout) view.findViewById(R.id.layout_root);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hpc.getLayoutParams();
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        layoutParams.bottomMargin = 0;
        this.gpQ = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.hpc.setOnClickListener(this);
        this.hqc = (TbImageView) view.findViewById(R.id.video_card_stage_view);
        this.hqc.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.hqc.setDefaultBgResource(R.color.transparent);
        this.ahH = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.ahH.setUserAfterClickListener(this.alB);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.hqd = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.fVw = (TbImageView) view.findViewById(R.id.image_video);
        this.fVw.setDrawCorner(true);
        this.fVw.setPlaceHolder(3);
        this.fVw.setDefaultResource(0);
        this.fVw.setRadiusById(R.string.J_X05);
        TbImageView tbImageView = this.fVw;
        TbImageView tbImageView2 = this.fVw;
        tbImageView.setConrers(15);
        this.fVw.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fVw.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.fVw.setBorderSurroundContent(true);
        this.fVw.setDrawBorder(true);
        this.hqg = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
        this.hqe = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.hqe.loop(true);
        ap.a(this.hqe, R.raw.ala_live2);
        this.hqe.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ala.livecard.a.e.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                e.this.hqe.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                e.this.hqe.cancelAnimation();
            }
        });
        this.fVC = (TextView) view.findViewById(R.id.play_count);
        this.hqf = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.hqh = view.findViewById(R.id.play_count_line);
        this.hpe = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        b(this.hpe);
        this.hpe.setSelectVisible(false);
        this.hpe.setIsBarViewVisible(false);
        this.hpe.setCommentNumEnable(true);
        this.hpe.setLiveShareEnable(false);
        this.hpe.setFrom(2);
        this.hpe.getCommentContainer().setOnClickListener(this);
        this.hpe.hideDisagree();
        com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
        eVar.eNB = 2;
        eVar.eNH = 2;
        this.hpe.setAgreeStatisticData(eVar);
        this.iwm = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.iwm);
        this.iwm.setFrom(2);
        this.iwm.setShareReportFrom(1);
        this.hpQ = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.hpQ.fmS.setOnClickListener(this);
        this.hpQ.fmS.getCommentContainer().setOnClickListener(this);
        this.hpQ.setFrom(2);
        this.hpQ.setShareReportFrom(1);
        this.hpQ.setSourceFromForPb(3);
        this.hpQ.setStType("frs_page");
        this.hpQ.setHideBarName(true);
        this.hpf = view.findViewById(R.id.divider_below_reply_number_layout);
        this.hqb = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.hpX = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.ahH.getSuffixContainer());
        this.hpX.setUniqueId(getTag());
        this.hqi = (FrameLayout) view.findViewById(R.id.text_bottom_layout);
        this.hqj = (LinearLayout) view.findViewById(R.id.forum_friends_now_looking);
        this.hqk = (TextView) view.findViewById(R.id.tv_forum_friends_now_looking);
        this.hql = (ImageView) view.findViewById(R.id.image_forum_friends_now_looking);
    }

    @Override // com.baidu.tieba.card.b
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            g(tbPageContext, i);
            com.baidu.tbadk.core.elementsMaven.c.br(this.hpc).oh(R.string.J_X06).aJ(R.color.CAM_X0205, R.color.CAM_X0206);
            com.baidu.tbadk.core.elementsMaven.c.br(this.hqd).ol(R.dimen.L_X01).ok(R.color.CAM_X0401).oh(R.string.J_X05).setBackGroundColor(R.color.CAM_X0611);
            int dimens = l.getDimens(getContext(), R.dimen.tbds31);
            ap.a(this.hqg, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, dimens, dimens, dimens, dimens, dimens, dimens});
            ap.setBackgroundColor(this.hqh, R.color.CAM_X0101);
            ap.setViewTextColor(this.fVC, R.color.CAM_X0101);
            ap.setViewTextColor(this.hqf, R.color.CAM_X0101);
            com.baidu.tbadk.core.util.f.a.bty().oP(0).oY(1).aj(l.getDimens(getContext(), R.dimen.tbds31)).oV(R.color.CAM_X0304).oX(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds2)).bv(this.hqj);
            ap.setViewTextColor(this.hqk, R.color.CAM_X0304);
            WebPManager.a(this.hql, R.drawable.icon_ala_watching, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.ahH.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fVw.setPlaceHolder(3);
            this.hpe.onChangeSkinType();
            this.mSkinType = i;
            if (this.hpQ != null && this.hpQ.getVisibility() == 0) {
                this.hpQ.onChangeSkinType();
            }
        }
        if (this.ahB != 0 && m.IX(((cb) this.ahB).getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0109);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0105);
        }
        ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
        this.hpX.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_video_layout_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(cb cbVar) {
        this.ahB = cbVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void uZ(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.b.cBE().cBy() && !com.baidu.tieba.frs.a.cBx().cBy()) {
            if (view == this.hpc || view == this.hpe.getCommentContainer() || view == this.gpQ || view == this.hpQ.fmS.getCommentContainer() || view == this.iwm.getCommentContainer() || view == this.hqj) {
                if (this.ahB != 0) {
                    m.IW(((cb) this.ahB).getId());
                }
                if (csi() != null) {
                    csi().a(this.hpc, this.ahB);
                }
                b(getContext(), (cb) this.ahB);
                if (this.ahB != 0) {
                    if (view == this.hpe.getCommentContainer() || view == this.hpQ.fmS.getCommentContainer()) {
                        ar arVar = new ar("c12942");
                        arVar.aq("obj_locate", 2);
                        arVar.aq("obj_type", 5);
                        arVar.dR("tid", ((cb) this.ahB).getTid());
                        arVar.dR(IntentConfig.NID, ((cb) this.ahB).bmq());
                        com.baidu.tbadk.pageExtra.c bR = com.baidu.tbadk.pageExtra.d.bR(view);
                        if (bR != null) {
                            arVar.dR("obj_cur_page", bR.getCurrentPageKey());
                        }
                        if (com.baidu.tbadk.pageExtra.d.bDP() != null) {
                            arVar.dR("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDP());
                        }
                        TiebaStatic.log(arVar);
                    }
                }
            } else if (view.getId() == R.id.video_container) {
                if (csi() != null) {
                    csi().a(view, this.ahB);
                }
                b(getContext(), (cb) this.ahB);
            }
        }
    }

    private void refreshView() {
        SparseArray<String> sparseArray;
        if (this.ahB == 0 || ((cb) this.ahB).bnS() == null) {
            this.hpc.setVisibility(8);
            return;
        }
        this.hpc.setVisibility(0);
        int equipmentWidth = l.getEquipmentWidth(this.eWx.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hqd.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext()) - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.hqd.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (((cb) this.ahB).bol() != null && ((cb) this.ahB).bol().user_info != null && ((cb) this.ahB).bol().user_info.is_official == 2) {
            this.hqn = true;
            SparseArray<String> sparseArray2 = ((cb) this.ahB).bol().dislikeInfo;
            this.hqc.setVisibility(0);
            int[] screenDimensions = l.getScreenDimensions(getContext());
            ViewGroup.LayoutParams layoutParams2 = this.hqc.getLayoutParams();
            layoutParams2.width = screenDimensions[0];
            layoutParams2.height = (screenDimensions[0] * 156) / 1080;
            this.hqc.setLayoutParams(layoutParams2);
            if (!TextUtils.isEmpty(((cb) this.ahB).bol().liveStagePicUrl)) {
                this.hqc.startLoad(((cb) this.ahB).bol().liveStagePicUrl, 10, false);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ahH.getLayoutParams();
            marginLayoutParams.topMargin = this.eWx.getResources().getDimensionPixelSize(R.dimen.tbds24);
            this.ahH.setLayoutParams(marginLayoutParams);
            sparseArray = sparseArray2;
        } else {
            this.hqn = false;
            this.hqc.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.ahH.getLayoutParams();
            marginLayoutParams2.topMargin = this.eWx.getResources().getDimensionPixelSize(R.dimen.tbds44);
            this.ahH.setLayoutParams(marginLayoutParams2);
            sparseArray = null;
        }
        if (this.hqn && sparseArray != null && sparseArray.size() > 0) {
            this.hpX.l((cb) this.ahB, "ala_frs_demo_hell_live_feed_back_type");
        } else if (this.hpX.bZb() != null) {
            this.hpX.bZb().setVisibility(8);
        }
        ((cb) this.ahB).y(false, true);
        this.ahH.setData((cb) this.ahB);
        SpannableStringBuilder boB = ((cb) this.ahB).boB();
        if (boB != null && !StringUtils.isNull(boB.toString())) {
            this.mTextTitle.setText(((cb) this.ahB).boB());
            this.mTextTitle.setVisibility(0);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (((cb) this.ahB).bol().audience_count > 0) {
            this.hqh.setVisibility(0);
            this.fVC.setVisibility(0);
            this.fVC.setText(String.format(this.eWx.getResources().getString(R.string.ala_audience_count_prefix), au.numFormatOverWan(((cb) this.ahB).bol().audience_count)));
        } else {
            this.hqh.setVisibility(8);
            this.fVC.setVisibility(8);
        }
        this.hqf.setVisibility(8);
        if (((cb) this.ahB).bol().openRecomReason == 1) {
            String str = ((cb) this.ahB).bol().recomReason;
            if (!StringUtils.isNull(str)) {
                this.hqf.setVisibility(0);
                this.hqf.setText(str);
            } else {
                String latitude = ((cb) this.ahB).getLatitude();
                String boh = ((cb) this.ahB).boh();
                if (UtilHelper.isDecimal(latitude) && UtilHelper.isDecimal(boh) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo dEz = com.baidu.tieba.recapp.c.a.dEu().dEz();
                    String str2 = dEz.latitude;
                    String str3 = dEz.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(latitude), Double.parseDouble(boh)) <= 50.0d) {
                        this.hqf.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.hqf.setVisibility(0);
                    }
                }
            }
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hqi.getLayoutParams();
        if (((cb) this.ahB).bol() != null && !StringUtils.isNull(((cb) this.ahB).bol().forumUserLiveMsg)) {
            this.hqj.setVisibility(0);
            this.hqk.setText(au.cutChineseAndEnglishWithSuffix(((cb) this.ahB).bol().forumUserLiveMsg, 10, StringHelper.STRING_MORE) + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_forum_live_suffix));
            layoutParams3.addRule(3, R.id.forum_friends_now_looking);
        } else {
            this.hqj.setVisibility(8);
            layoutParams3.addRule(3, R.id.video_card_content_layout);
        }
        this.hqi.setLayoutParams(layoutParams3);
        vb(sY(1));
        Z((cb) this.ahB);
        this.mMaskView.setVisibility((com.baidu.tieba.frs.b.cBE().cBy() || com.baidu.tieba.frs.a.cBx().cBy()) ? 0 : 8);
        onChangeSkinType(this.eWx, TbadkCoreApplication.getInst().getSkinType());
        bZf();
        this.hqe.playAnimation();
        ba(this.hpc);
    }

    public void bZf() {
        if (k.bkV().isShowImages() && this.ahB != 0 && ((cb) this.ahB).blp() != null && ((cb) this.ahB).blp().bol() != null) {
            this.fVw.setPlaceHolder(3);
            this.fVw.startLoad(((cb) this.ahB).blp().bol().cover, 10, false);
            this.hqd.setVisibility(0);
            return;
        }
        this.hqd.setVisibility(8);
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hpe != null) {
            if (this.ahH != null) {
                this.ahH.setPageUniqueId(bdUniqueId);
            }
            setTag(bdUniqueId);
            q(bdUniqueId);
        }
    }

    public void nH(boolean z) {
        this.hqm = z;
    }

    private void Z(cb cbVar) {
        if (cbVar != null) {
            TiebaStatic.log(new ar("c12125").dR("tid", cbVar.getId()).aq("obj_locate", this.hqm ? 2 : 1).v("obj_id", cbVar.bol().live_id).aq("obj_type", 2));
            if (cbVar.bol() != null && cbVar.bol().user_info != null && cbVar.bol().user_info.is_official == 2) {
                TiebaStatic.log(new ar("c12800").dR("tid", cbVar.getId()));
            }
        }
    }

    private void m(cb cbVar, String str) {
        TiebaStatic.log(new ar("c12126").dR("tid", cbVar.getId()).aq("obj_locate", this.hqm ? 2 : 1).v("obj_id", cbVar.bol().live_id).aq("obj_type", 2));
        if (cbVar.bol() != null && cbVar.bol().user_info != null && cbVar.bol().user_info.is_official == 2) {
            TiebaStatic.log(new ar("c12801").dR("tid", cbVar.getId()));
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (str.equals("frs_live_play")) {
            if (cbVar.bnW().equals(this.mForumName)) {
                TiebaStatic.log(new ar("c11843").dR("uid", currentAccount).v("fid", cbVar.getFid()));
            } else {
                TiebaStatic.log(new ar("c11845").dR("uid", currentAccount).v("fid", cbVar.getFid()));
            }
        }
    }

    public void b(Context context, cb cbVar) {
        String str;
        if (context != null && cbVar != null && cbVar.bol() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(context, R.string.no_network_guide);
                return;
            }
            String str2 = this.hqn ? "frs_live_stage_live" : "frs_play";
            if (cbVar.bnE() != null) {
                str2 = cbVar.bnE();
            }
            int frsCurTabType = TbSingleton.getInstance().getFrsCurTabType();
            if (frsCurTabType == 14) {
                str = AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_NEW + cbVar.getFid();
            } else {
                str = frsCurTabType == 13 ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_HOT + cbVar.getFid() : str2;
            }
            m(cbVar, str);
            AlaInfoData bol = cbVar.bol();
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && cbVar.bnS() != null) {
                z = TextUtils.equals(cbVar.bnS().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bol);
            if (bol.user_info != null) {
                alaLiveInfoCoreData.userName = bol.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, str, "", z, this.mForumName)));
        }
    }

    public void vb(int i) {
        if (this.ahB != 0) {
            if (i == 1) {
                this.hpe.setVisibility(8);
                this.hpQ.setData((cb) this.ahB);
                return;
            }
            this.hpf.setVisibility(this.hpe.setData((cb) this.ahB) ? 8 : 0);
            this.hpQ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ajx = str;
    }

    public int sY(int i) {
        return com.baidu.tieba.a.d.bKY().aB(this.ajx, i);
    }
}
