package com.baidu.tieba.card;

import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.card.view.ForumEnterLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import tbclient.AppPosInfo;
/* loaded from: classes21.dex */
public class l extends a<com.baidu.tieba.card.data.k> implements com.baidu.tieba.a.e {
    private CardUserInfoLayout afO;
    private String ahu;
    private View.OnClickListener ajG;
    private View.OnClickListener eWC;
    public boolean eXK;
    private TextView fFC;
    public TbImageView fFw;
    public LinearLayout fXV;
    public RelativeLayout gTQ;
    private TBLottieAnimationView gTR;
    private TextView gTS;
    private LinearLayout gTT;
    private View gTU;
    private CustomMessageListener hXA;
    private View.OnClickListener hXC;
    private FrameLayout hXz;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.eXK = false;
        this.mLastScreenWidth = 0;
        this.hXC = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        };
        this.ajG = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.cnT() != null) {
                    l.this.cnT().a(view, l.this.afI);
                }
            }
        };
        this.eWC = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.cnT() != null) {
                    l.this.cnT().a(view, l.this.afI);
                }
            }
        };
        this.hXA = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.l.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && l.this.afI != 0 && ((com.baidu.tieba.card.data.k) l.this.afI).exA != null && ((com.baidu.tieba.card.data.k) l.this.afI).exA.getTid() != null && l.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(((com.baidu.tieba.card.data.k) l.this.afI).exA.getTid())) {
                    n.a(l.this.mTextTitle, ((com.baidu.tieba.card.data.k) l.this.afI).exA.getId(), R.color.cp_cont_d, R.color.cp_cont_d);
                }
            }
        };
        this.eIc = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init(getView());
    }

    private void init(View view) {
        this.hXz = (FrameLayout) view.findViewById(R.id.layout_root);
        this.mDivider = view.findViewById(R.id.divider_line);
        com.baidu.tbadk.a.b.a.d(this.mDivider, R.dimen.tbds20, R.dimen.tbds0);
        this.fXV = (LinearLayout) view.findViewById(R.id.content_layout);
        this.afO = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.afO.setPageContext(this.eIc);
        this.afO.setPageUniqueId(this.mBdUniqueId);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gTQ = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.fFw = (TbImageView) view.findViewById(R.id.image_video);
        this.fFw.setDrawCorner(true);
        this.fFw.setPlaceHolder(3);
        this.fFw.setDefaultResource(0);
        this.fFw.setDefaultErrorResource(0);
        this.fFw.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
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
        ap.a(this.gTR, R.raw.ala_live2);
        this.gTR.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.l.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                l.this.gTR.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                l.this.gTR.cancelAnimation();
            }
        });
        this.fFC = (TextView) view.findViewById(R.id.play_count);
        this.gTS = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.gTU = view.findViewById(R.id.play_count_line);
        this.hVA = (ForumEnterLayout) view.findViewById(R.id.card_forum_enter_button);
        this.gSR = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_layout);
        this.hVy = (ThreadCardBottomOpSegmentWeightLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.gSR);
        b(this.hVy);
        this.fXV.setOnClickListener(this);
        com.baidu.tbadk.a.b.a.h(view.findViewById(R.id.imageMask), R.color.transparent);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mDivider, R.color.cp_bg_line_b);
            g(tbPageContext, i);
            ap.setBackgroundResource(this.hXz, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.fXV, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.gTQ, R.drawable.bg_ala_shape);
            int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
            ap.a(this.gTT, R.color.cp_other_d, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, 0.0f, 0.0f, dimens, dimens, 0.0f, 0.0f});
            ap.setBackgroundColor(this.gTU, R.color.cp_cont_a);
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b);
            ap.setViewTextColor(this.fFC, R.color.cp_cont_a);
            ap.setViewTextColor(this.gTS, R.color.cp_cont_a);
            this.afO.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fFw.setPlaceHolder(3);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_ala_live_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.k kVar) {
        this.afI = kVar;
        refreshView();
    }

    private void refreshView() {
        if (this.afI == 0 || ((com.baidu.tieba.card.data.k) this.afI).bjZ() == null) {
            this.hXz.setVisibility(8);
            return;
        }
        this.hXz.setVisibility(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eIc.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gTQ.getLayoutParams();
            layoutParams.width = equipmentWidth - com.baidu.adp.lib.util.l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.gTQ.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (((com.baidu.tieba.card.data.k) this.afI).bjZ().bmU() != null && ((com.baidu.tieba.card.data.k) this.afI).bjZ().bmU().isChushou) {
            this.gSR.setShowFlag(10);
            this.gSR.hideShareContainer();
        } else {
            this.gSR.setShowFlag(11);
            this.gSR.resetShareContainer();
        }
        this.afO.setVisibility(0);
        this.afO.setData(((com.baidu.tieba.card.data.k) this.afI).bjZ());
        this.afO.setUserAfterClickListener(this.ajG);
        ((com.baidu.tieba.card.data.k) this.afI).bjZ().bny();
        this.mTextTitle.setText(new SpannableStringBuilder(((com.baidu.tieba.card.data.k) this.afI).bjZ().bnk()));
        if (((com.baidu.tieba.card.data.k) this.afI).exA.bmU().audience_count > 0) {
            this.gTU.setVisibility(0);
            this.fFC.setVisibility(0);
            this.fFC.setText(String.format(this.eIc.getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(((com.baidu.tieba.card.data.k) this.afI).exA.bmU().audience_count)));
        } else {
            this.gTU.setVisibility(8);
            this.fFC.setVisibility(8);
        }
        this.gTS.setVisibility(8);
        if (((com.baidu.tieba.card.data.k) this.afI).exA.bmU().openRecomReason == 1) {
            String str = ((com.baidu.tieba.card.data.k) this.afI).exA.bmU().recomReason;
            if (!StringUtils.isNull(str)) {
                this.gTS.setVisibility(0);
                this.gTS.setText(str);
            } else {
                String bmP = ((com.baidu.tieba.card.data.k) this.afI).exA.bmP();
                String bmQ = ((com.baidu.tieba.card.data.k) this.afI).exA.bmQ();
                if (UtilHelper.isDecimal(bmP) && UtilHelper.isDecimal(bmQ) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo dBh = com.baidu.tieba.recapp.d.a.dBc().dBh();
                    String str2 = dBh.latitude;
                    String str3 = dBh.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && com.baidu.adp.lib.util.l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(bmP), Double.parseDouble(bmQ)) <= 50.0d) {
                        this.gTS.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.gTS.setVisibility(0);
                    }
                }
            }
        }
        aS(this.hXz);
        onChangeSkinType(this.eIc, TbadkCoreApplication.getInst().getSkinType());
        if (n.Ja(((com.baidu.tieba.card.data.k) this.afI).exA.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        bWa();
        this.gTR.playAnimation();
    }

    public void bWa() {
        if (com.baidu.tbadk.core.k.bjH().isShowImages() && this.afI != 0 && ((com.baidu.tieba.card.data.k) this.afI).bjZ() != null && ((com.baidu.tieba.card.data.k) this.afI).bjZ().bmU() != null) {
            this.fFw.setPlaceHolder(3);
            this.fFw.startLoad(((com.baidu.tieba.card.data.k) this.afI).bjZ().bmU().cover, 10, false);
            this.gTQ.setVisibility(0);
            return;
        }
        this.gTQ.setVisibility(8);
    }

    public View cnW() {
        if (this.afO != null) {
            return this.afO.getAvatar();
        }
        return null;
    }

    public View cnX() {
        if (this.eXK) {
            if (this.afO != null) {
                return this.afO.getUserName();
            }
            return null;
        }
        return this.mTextTitle;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fXV || view == this.gSR.getCommentContainer() || view == this.hVy.getCommentContainer()) {
            if (((com.baidu.tieba.card.data.k) this.afI).bjZ().bmU() != null && ((com.baidu.tieba.card.data.k) this.afI).bjZ().bmU().isChushou) {
                eC(((com.baidu.tieba.card.data.k) this.afI).bjZ().bmU().thirdRoomId, ((com.baidu.tieba.card.data.k) this.afI).bjZ().bmU().thirdLiveType);
            } else {
                cq(view);
            }
        }
    }

    private void eC(String str, String str2) {
        be.brr().b(this.mTbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void cq(View view) {
        if (cnT() != null) {
            cnT().a(view, this.afI);
        }
        if (this.afI != 0 && ((com.baidu.tieba.card.data.k) this.afI).bjZ() != null && ((com.baidu.tieba.card.data.k) this.afI).bjZ().bmU() != null) {
            n.IZ(((com.baidu.tieba.card.data.k) this.afI).exA.getId());
            n.a(this.mTextTitle, ((com.baidu.tieba.card.data.k) this.afI).exA.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(((com.baidu.tieba.card.data.k) this.afI).bjZ().bmU());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.eIc.getPageActivity(), alaLiveInfoCoreData, "home_rec_play", "", false, "")));
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gSR != null && this.hXA != null) {
            setTag(bdUniqueId);
            q(bdUniqueId);
            if (this.afO != null) {
                this.afO.setPageUniqueId(bdUniqueId);
            }
            this.hXA.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hXA);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahu = str;
    }

    public void xf(int i) {
        if (this.gSR != null) {
            this.gSR.eWA = String.valueOf(i);
        }
    }

    public void iT(boolean z) {
        this.eXK = z;
    }
}
