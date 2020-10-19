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
public class k extends a<com.baidu.tieba.card.data.k> implements com.baidu.tieba.a.e {
    private CardUserInfoLayout afN;
    private String aht;
    private View.OnClickListener ajF;
    private View.OnClickListener eIr;
    public boolean eJz;
    public LinearLayout fJK;
    public TbImageView fri;
    private TextView fro;
    public RelativeLayout gBD;
    private TBLottieAnimationView gBE;
    private TextView gBF;
    private LinearLayout gBG;
    private View gBH;
    private FrameLayout hFg;
    private View.OnClickListener hFh;
    private CustomMessageListener hFi;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.eJz = false;
        this.mLastScreenWidth = 0;
        this.hFh = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        };
        this.ajF = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.cil() != null) {
                    k.this.cil().a(view, k.this.afH);
                }
            }
        };
        this.eIr = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.cil() != null) {
                    k.this.cil().a(view, k.this.afH);
                }
            }
        };
        this.hFi = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.k.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && k.this.afH != 0 && ((com.baidu.tieba.card.data.k) k.this.afH).eji != null && ((com.baidu.tieba.card.data.k) k.this.afH).eji.getTid() != null && k.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(((com.baidu.tieba.card.data.k) k.this.afH).eji.getTid())) {
                    m.a(k.this.mTextTitle, ((com.baidu.tieba.card.data.k) k.this.afH).eji.getId(), R.color.cp_cont_d, R.color.cp_cont_d);
                }
            }
        };
        this.etO = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init(getView());
    }

    private void init(View view) {
        this.hFg = (FrameLayout) view.findViewById(R.id.layout_root);
        this.mDivider = view.findViewById(R.id.divider_line);
        com.baidu.tbadk.a.b.a.d(this.mDivider, R.dimen.tbds20, R.dimen.tbds0);
        this.fJK = (LinearLayout) view.findViewById(R.id.content_layout);
        this.afN = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.afN.setPageContext(this.etO);
        this.afN.setPageUniqueId(this.mBdUniqueId);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gBD = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.fri = (TbImageView) view.findViewById(R.id.image_video);
        this.fri.setDrawCorner(true);
        this.fri.setPlaceHolder(3);
        this.fri.setDefaultResource(0);
        this.fri.setDefaultErrorResource(0);
        this.fri.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
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
        this.gBE.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                k.this.gBE.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                k.this.gBE.cancelAnimation();
            }
        });
        this.fro = (TextView) view.findViewById(R.id.play_count);
        this.gBF = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.gBH = view.findViewById(R.id.play_count_line);
        this.hDh = (ForumEnterLayout) view.findViewById(R.id.card_forum_enter_button);
        this.gAE = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_layout);
        this.hDf = (ThreadCardBottomOpSegmentWeightLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.gAE);
        b(this.hDf);
        this.fJK.setOnClickListener(this);
        com.baidu.tbadk.a.b.a.h(view.findViewById(R.id.imageMask), R.color.transparent);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mDivider, R.color.cp_bg_line_b);
            g(tbPageContext, i);
            ap.setBackgroundResource(this.hFg, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.fJK, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.gBD, R.drawable.bg_ala_shape);
            int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
            ap.a(this.gBG, R.color.cp_other_d, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, 0.0f, 0.0f, dimens, dimens, 0.0f, 0.0f});
            ap.setBackgroundColor(this.gBH, R.color.cp_cont_a);
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b);
            ap.setViewTextColor(this.fro, R.color.cp_cont_a);
            ap.setViewTextColor(this.gBF, R.color.cp_cont_a);
            this.afN.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fri.setPlaceHolder(3);
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
        this.afH = kVar;
        refreshView();
    }

    private void refreshView() {
        if (this.afH == 0 || ((com.baidu.tieba.card.data.k) this.afH).bfG() == null) {
            this.hFg.setVisibility(8);
            return;
        }
        this.hFg.setVisibility(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.etO.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gBD.getLayoutParams();
            layoutParams.width = equipmentWidth - com.baidu.adp.lib.util.l.getDimens(this.etO.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.gBD.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (((com.baidu.tieba.card.data.k) this.afH).bfG().biB() != null && ((com.baidu.tieba.card.data.k) this.afH).bfG().biB().isChushou) {
            this.gAE.setShowFlag(10);
            this.gAE.hideShareContainer();
        } else {
            this.gAE.setShowFlag(11);
            this.gAE.resetShareContainer();
        }
        this.afN.setVisibility(0);
        this.afN.setData(((com.baidu.tieba.card.data.k) this.afH).bfG());
        this.afN.setUserAfterClickListener(this.ajF);
        ((com.baidu.tieba.card.data.k) this.afH).bfG().bjf();
        this.mTextTitle.setText(new SpannableStringBuilder(((com.baidu.tieba.card.data.k) this.afH).bfG().biR()));
        if (((com.baidu.tieba.card.data.k) this.afH).eji.biB().audience_count > 0) {
            this.gBH.setVisibility(0);
            this.fro.setVisibility(0);
            this.fro.setText(String.format(this.etO.getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(((com.baidu.tieba.card.data.k) this.afH).eji.biB().audience_count)));
        } else {
            this.gBH.setVisibility(8);
            this.fro.setVisibility(8);
        }
        this.gBF.setVisibility(8);
        if (((com.baidu.tieba.card.data.k) this.afH).eji.biB().openRecomReason == 1) {
            String str = ((com.baidu.tieba.card.data.k) this.afH).eji.biB().recomReason;
            if (!StringUtils.isNull(str)) {
                this.gBF.setVisibility(0);
                this.gBF.setText(str);
            } else {
                String biw = ((com.baidu.tieba.card.data.k) this.afH).eji.biw();
                String bix = ((com.baidu.tieba.card.data.k) this.afH).eji.bix();
                if (UtilHelper.isDecimal(biw) && UtilHelper.isDecimal(bix) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo dvy = com.baidu.tieba.recapp.d.a.dvt().dvy();
                    String str2 = dvy.latitude;
                    String str3 = dvy.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && com.baidu.adp.lib.util.l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(biw), Double.parseDouble(bix)) <= 50.0d) {
                        this.gBF.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.gBF.setVisibility(0);
                    }
                }
            }
        }
        aQ(this.hFg);
        onChangeSkinType(this.etO, TbadkCoreApplication.getInst().getSkinType());
        if (m.Ik(((com.baidu.tieba.card.data.k) this.afH).eji.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        bQv();
        this.gBE.playAnimation();
    }

    public void bQv() {
        if (com.baidu.tbadk.core.k.bfo().isShowImages() && this.afH != 0 && ((com.baidu.tieba.card.data.k) this.afH).bfG() != null && ((com.baidu.tieba.card.data.k) this.afH).bfG().biB() != null) {
            this.fri.setPlaceHolder(3);
            this.fri.startLoad(((com.baidu.tieba.card.data.k) this.afH).bfG().biB().cover, 10, false);
            this.gBD.setVisibility(0);
            return;
        }
        this.gBD.setVisibility(8);
    }

    public View cio() {
        if (this.afN != null) {
            return this.afN.getAvatar();
        }
        return null;
    }

    public View cip() {
        if (this.eJz) {
            if (this.afN != null) {
                return this.afN.getUserName();
            }
            return null;
        }
        return this.mTextTitle;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fJK || view == this.gAE.getCommentContainer() || view == this.hDf.getCommentContainer()) {
            if (((com.baidu.tieba.card.data.k) this.afH).bfG().biB() != null && ((com.baidu.tieba.card.data.k) this.afH).bfG().biB().isChushou) {
                ex(((com.baidu.tieba.card.data.k) this.afH).bfG().biB().thirdRoomId, ((com.baidu.tieba.card.data.k) this.afH).bfG().biB().thirdLiveType);
            } else {
                ch(view);
            }
        }
    }

    private void ex(String str, String str2) {
        be.bmY().b(this.mTbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void ch(View view) {
        if (cil() != null) {
            cil().a(view, this.afH);
        }
        if (this.afH != 0 && ((com.baidu.tieba.card.data.k) this.afH).bfG() != null && ((com.baidu.tieba.card.data.k) this.afH).bfG().biB() != null) {
            m.Ij(((com.baidu.tieba.card.data.k) this.afH).eji.getId());
            m.a(this.mTextTitle, ((com.baidu.tieba.card.data.k) this.afH).eji.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(((com.baidu.tieba.card.data.k) this.afH).bfG().biB());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.etO.getPageActivity(), alaLiveInfoCoreData, "home_rec_play", "", false, "")));
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gAE != null && this.hFi != null) {
            setTag(bdUniqueId);
            q(bdUniqueId);
            if (this.afN != null) {
                this.afN.setPageUniqueId(bdUniqueId);
            }
            this.hFi.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hFi);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aht = str;
    }

    public void wz(int i) {
        if (this.gAE != null) {
            this.gAE.eIp = String.valueOf(i);
        }
    }

    public void ix(boolean z) {
        this.eJz = z;
    }
}
