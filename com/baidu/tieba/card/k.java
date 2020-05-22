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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import tbclient.AppPosInfo;
/* loaded from: classes8.dex */
public class k extends a<com.baidu.tieba.card.data.j> implements com.baidu.tieba.a.e {
    private CardUserInfoLayout adC;
    private String aeX;
    private View.OnClickListener agI;
    private View.OnClickListener dWy;
    public boolean dXG;
    public TbImageView eBb;
    private TextView eBh;
    public LinearLayout eTB;
    public RelativeLayout fHn;
    private TBLottieAnimationView fHo;
    private TextView fHp;
    private LinearLayout fHq;
    private View fHr;
    private FrameLayout gDF;
    private View.OnClickListener gDG;
    private CustomMessageListener gDH;
    public View mDivider;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.dXG = false;
        this.mLastScreenWidth = 0;
        this.gDG = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        };
        this.agI = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.bKS() != null) {
                    k.this.bKS().a(view, k.this.adw);
                }
            }
        };
        this.dWy = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.bKS() != null) {
                    k.this.bKS().a(view, k.this.adw);
                }
            }
        };
        this.gDH = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.k.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && k.this.adw != 0 && ((com.baidu.tieba.card.data.j) k.this.adw).dEA != null && ((com.baidu.tieba.card.data.j) k.this.adw).dEA.getTid() != null && k.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(((com.baidu.tieba.card.data.j) k.this.adw).dEA.getTid())) {
                    m.a(k.this.mTextTitle, ((com.baidu.tieba.card.data.j) k.this.adw).dEA.getId(), (int) R.color.cp_cont_d, (int) R.color.cp_cont_d);
                }
            }
        };
        this.dIF = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init(getView());
    }

    private void init(View view) {
        this.gDF = (FrameLayout) view.findViewById(R.id.layout_root);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.eTB = (LinearLayout) view.findViewById(R.id.content_layout);
        this.adC = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.adC.setPageContext(this.dIF);
        this.adC.setPageUniqueId(this.mBdUniqueId);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fHn = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.eBb = (TbImageView) view.findViewById(R.id.image_video);
        this.eBb.setDrawCorner(true);
        this.eBb.setPlaceHolder(3);
        this.eBb.setDefaultResource(0);
        this.eBb.setDefaultErrorResource(0);
        this.eBb.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
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
        this.fHo.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                k.this.fHo.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                k.this.fHo.cancelAnimation();
            }
        });
        this.eBh = (TextView) view.findViewById(R.id.play_count);
        this.fHp = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.fHr = view.findViewById(R.id.play_count_line);
        this.gBG = (ForumEnterLayout) view.findViewById(R.id.card_forum_enter_button);
        this.fGo = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_layout);
        this.gBE = (ThreadCardBottomOpSegmentWeightLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.fGo);
        b(this.gBE);
        this.eTB.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            d(tbPageContext, i);
            am.setBackgroundResource(this.gDF, R.drawable.addresslist_item_bg);
            am.setBackgroundResource(this.eTB, R.drawable.addresslist_item_bg);
            am.setBackgroundResource(this.fHn, R.drawable.bg_ala_shape);
            int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
            am.a(this.fHq, (int) R.color.cp_other_d, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, 0.0f, 0.0f, dimens, dimens, 0.0f, 0.0f});
            am.setBackgroundColor(this.fHr, R.color.cp_cont_a);
            am.setBackgroundResource(this.mDivider, R.color.cp_bg_line_b);
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eBh, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.fHp, (int) R.color.cp_cont_a);
            this.adC.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.eBb.setPlaceHolder(3);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_ala_live_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.j jVar) {
        this.adw = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.adw == 0 || ((com.baidu.tieba.card.data.j) this.adw).aOi() == null) {
            this.gDF.setVisibility(8);
            return;
        }
        this.gDF.setVisibility(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.dIF.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fHn.getLayoutParams();
            layoutParams.width = equipmentWidth - com.baidu.adp.lib.util.l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.fHn.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (((com.baidu.tieba.card.data.j) this.adw).aOi().aQS() != null && ((com.baidu.tieba.card.data.j) this.adw).aOi().aQS().isChushou) {
            this.fGo.setShowFlag(10);
            this.fGo.hideShareContainer();
        } else {
            this.fGo.setShowFlag(11);
            this.fGo.resetShareContainer();
        }
        this.adC.setVisibility(0);
        this.adC.setData(((com.baidu.tieba.card.data.j) this.adw).aOi());
        this.adC.setUserAfterClickListener(this.agI);
        ((com.baidu.tieba.card.data.j) this.adw).aOi().aRw();
        this.mTextTitle.setText(new SpannableStringBuilder(((com.baidu.tieba.card.data.j) this.adw).aOi().aRi()));
        if (((com.baidu.tieba.card.data.j) this.adw).dEA.aQS().audience_count > 0) {
            this.fHr.setVisibility(0);
            this.eBh.setVisibility(0);
            this.eBh.setText(String.format(this.dIF.getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(((com.baidu.tieba.card.data.j) this.adw).dEA.aQS().audience_count)));
        } else {
            this.fHr.setVisibility(8);
            this.eBh.setVisibility(8);
        }
        this.fHp.setVisibility(8);
        if (((com.baidu.tieba.card.data.j) this.adw).dEA.aQS().openRecomReason == 1) {
            String str = ((com.baidu.tieba.card.data.j) this.adw).dEA.aQS().recomReason;
            if (!StringUtils.isNull(str)) {
                this.fHp.setVisibility(0);
                this.fHp.setText(str);
            } else {
                String aQN = ((com.baidu.tieba.card.data.j) this.adw).dEA.aQN();
                String aQO = ((com.baidu.tieba.card.data.j) this.adw).dEA.aQO();
                if (UtilHelper.isDecimal(aQN) && UtilHelper.isDecimal(aQO) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo cVd = com.baidu.tieba.recapp.d.a.cUZ().cVd();
                    String str2 = cVd.latitude;
                    String str3 = cVd.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && com.baidu.adp.lib.util.l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(aQN), Double.parseDouble(aQO)) <= 50.0d) {
                        this.fHp.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.fHp.setVisibility(0);
                    }
                }
            }
        }
        aJ(this.gDF);
        onChangeSkinType(this.dIF, TbadkCoreApplication.getInst().getSkinType());
        if (m.Do(((com.baidu.tieba.card.data.j) this.adw).dEA.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        bwn();
        this.fHo.playAnimation();
    }

    public void bwn() {
        if (com.baidu.tbadk.core.k.aNQ().isShowImages() && this.adw != 0 && ((com.baidu.tieba.card.data.j) this.adw).aOi() != null && ((com.baidu.tieba.card.data.j) this.adw).aOi().aQS() != null) {
            this.eBb.setPlaceHolder(3);
            this.eBb.startLoad(((com.baidu.tieba.card.data.j) this.adw).aOi().aQS().cover, 10, false);
            this.fHn.setVisibility(0);
            return;
        }
        this.fHn.setVisibility(8);
    }

    public View bKV() {
        if (this.adC != null) {
            return this.adC.getAvatar();
        }
        return null;
    }

    public View bKW() {
        if (this.dXG) {
            if (this.adC != null) {
                return this.adC.getUserName();
            }
            return null;
        }
        return this.mTextTitle;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eTB || view == this.fGo.getCommentContainer() || view == this.gBE.getCommentContainer()) {
            if (((com.baidu.tieba.card.data.j) this.adw).aOi().aQS() != null && ((com.baidu.tieba.card.data.j) this.adw).aOi().aQS().isChushou) {
                dN(((com.baidu.tieba.card.data.j) this.adw).aOi().aQS().thirdRoomId, ((com.baidu.tieba.card.data.j) this.adw).aOi().aQS().thirdLiveType);
            } else {
                bI(view);
            }
        }
    }

    private void dN(String str, String str2) {
        ba.aUZ().b(this.mTbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void bI(View view) {
        if (bKS() != null) {
            bKS().a(view, this.adw);
        }
        if (this.adw != 0 && ((com.baidu.tieba.card.data.j) this.adw).aOi() != null && ((com.baidu.tieba.card.data.j) this.adw).aOi().aQS() != null) {
            m.Dn(((com.baidu.tieba.card.data.j) this.adw).dEA.getId());
            m.a(this.mTextTitle, ((com.baidu.tieba.card.data.j) this.adw).dEA.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(((com.baidu.tieba.card.data.j) this.adw).aOi().aQS());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.dIF.getPageActivity(), alaLiveInfoCoreData, "home_rec_play", "", false, "")));
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.fGo != null && this.gDH != null) {
            setTag(bdUniqueId);
            q(bdUniqueId);
            if (this.adC != null) {
                this.adC.setPageUniqueId(bdUniqueId);
            }
            this.gDH.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gDH);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aeX = str;
    }

    public void sn(int i) {
        if (this.fGo != null) {
            this.fGo.dWw = String.valueOf(i);
        }
    }

    public void gU(boolean z) {
        this.dXG = z;
    }
}
