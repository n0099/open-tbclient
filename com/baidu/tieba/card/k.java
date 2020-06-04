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
    public TbImageView eBm;
    private TextView eBs;
    public LinearLayout eTM;
    private TextView fHA;
    private LinearLayout fHB;
    private View fHC;
    public RelativeLayout fHy;
    private TBLottieAnimationView fHz;
    private FrameLayout gDQ;
    private View.OnClickListener gDR;
    private CustomMessageListener gDS;
    public View mDivider;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.dXG = false;
        this.mLastScreenWidth = 0;
        this.gDR = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        };
        this.agI = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.bKU() != null) {
                    k.this.bKU().a(view, k.this.adw);
                }
            }
        };
        this.dWy = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.bKU() != null) {
                    k.this.bKU().a(view, k.this.adw);
                }
            }
        };
        this.gDS = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.k.5
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
        this.gDQ = (FrameLayout) view.findViewById(R.id.layout_root);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.eTM = (LinearLayout) view.findViewById(R.id.content_layout);
        this.adC = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.adC.setPageContext(this.dIF);
        this.adC.setPageUniqueId(this.mBdUniqueId);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fHy = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.eBm = (TbImageView) view.findViewById(R.id.image_video);
        this.eBm.setDrawCorner(true);
        this.eBm.setPlaceHolder(3);
        this.eBm.setDefaultResource(0);
        this.eBm.setDefaultErrorResource(0);
        this.eBm.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        TbImageView tbImageView = this.eBm;
        TbImageView tbImageView2 = this.eBm;
        tbImageView.setConrers(15);
        this.eBm.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eBm.setBorderColor(am.getColor(R.color.cp_border_a));
        this.eBm.setBorderSurroundContent(true);
        this.eBm.setDrawBorder(true);
        this.fHB = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
        this.fHz = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.fHz.loop(true);
        am.a(this.fHz, (int) R.raw.ala_live2);
        this.fHz.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                k.this.fHz.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                k.this.fHz.cancelAnimation();
            }
        });
        this.eBs = (TextView) view.findViewById(R.id.play_count);
        this.fHA = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.fHC = view.findViewById(R.id.play_count_line);
        this.gBR = (ForumEnterLayout) view.findViewById(R.id.card_forum_enter_button);
        this.fGz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_layout);
        this.gBP = (ThreadCardBottomOpSegmentWeightLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.fGz);
        b(this.gBP);
        this.eTM.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            d(tbPageContext, i);
            am.setBackgroundResource(this.gDQ, R.drawable.addresslist_item_bg);
            am.setBackgroundResource(this.eTM, R.drawable.addresslist_item_bg);
            am.setBackgroundResource(this.fHy, R.drawable.bg_ala_shape);
            int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
            am.a(this.fHB, (int) R.color.cp_other_d, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, 0.0f, 0.0f, dimens, dimens, 0.0f, 0.0f});
            am.setBackgroundColor(this.fHC, R.color.cp_cont_a);
            am.setBackgroundResource(this.mDivider, R.color.cp_bg_line_b);
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eBs, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.fHA, (int) R.color.cp_cont_a);
            this.adC.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.eBm.setPlaceHolder(3);
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
            this.gDQ.setVisibility(8);
            return;
        }
        this.gDQ.setVisibility(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.dIF.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fHy.getLayoutParams();
            layoutParams.width = equipmentWidth - com.baidu.adp.lib.util.l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.fHy.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (((com.baidu.tieba.card.data.j) this.adw).aOi().aQS() != null && ((com.baidu.tieba.card.data.j) this.adw).aOi().aQS().isChushou) {
            this.fGz.setShowFlag(10);
            this.fGz.hideShareContainer();
        } else {
            this.fGz.setShowFlag(11);
            this.fGz.resetShareContainer();
        }
        this.adC.setVisibility(0);
        this.adC.setData(((com.baidu.tieba.card.data.j) this.adw).aOi());
        this.adC.setUserAfterClickListener(this.agI);
        ((com.baidu.tieba.card.data.j) this.adw).aOi().aRw();
        this.mTextTitle.setText(new SpannableStringBuilder(((com.baidu.tieba.card.data.j) this.adw).aOi().aRi()));
        if (((com.baidu.tieba.card.data.j) this.adw).dEA.aQS().audience_count > 0) {
            this.fHC.setVisibility(0);
            this.eBs.setVisibility(0);
            this.eBs.setText(String.format(this.dIF.getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(((com.baidu.tieba.card.data.j) this.adw).dEA.aQS().audience_count)));
        } else {
            this.fHC.setVisibility(8);
            this.eBs.setVisibility(8);
        }
        this.fHA.setVisibility(8);
        if (((com.baidu.tieba.card.data.j) this.adw).dEA.aQS().openRecomReason == 1) {
            String str = ((com.baidu.tieba.card.data.j) this.adw).dEA.aQS().recomReason;
            if (!StringUtils.isNull(str)) {
                this.fHA.setVisibility(0);
                this.fHA.setText(str);
            } else {
                String aQN = ((com.baidu.tieba.card.data.j) this.adw).dEA.aQN();
                String aQO = ((com.baidu.tieba.card.data.j) this.adw).dEA.aQO();
                if (UtilHelper.isDecimal(aQN) && UtilHelper.isDecimal(aQO) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo cVt = com.baidu.tieba.recapp.d.a.cVp().cVt();
                    String str2 = cVt.latitude;
                    String str3 = cVt.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && com.baidu.adp.lib.util.l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(aQN), Double.parseDouble(aQO)) <= 50.0d) {
                        this.fHA.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.fHA.setVisibility(0);
                    }
                }
            }
        }
        aJ(this.gDQ);
        onChangeSkinType(this.dIF, TbadkCoreApplication.getInst().getSkinType());
        if (m.Do(((com.baidu.tieba.card.data.j) this.adw).dEA.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        bwp();
        this.fHz.playAnimation();
    }

    public void bwp() {
        if (com.baidu.tbadk.core.k.aNQ().isShowImages() && this.adw != 0 && ((com.baidu.tieba.card.data.j) this.adw).aOi() != null && ((com.baidu.tieba.card.data.j) this.adw).aOi().aQS() != null) {
            this.eBm.setPlaceHolder(3);
            this.eBm.startLoad(((com.baidu.tieba.card.data.j) this.adw).aOi().aQS().cover, 10, false);
            this.fHy.setVisibility(0);
            return;
        }
        this.fHy.setVisibility(8);
    }

    public View bKX() {
        if (this.adC != null) {
            return this.adC.getAvatar();
        }
        return null;
    }

    public View bKY() {
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
        if (view == this.eTM || view == this.fGz.getCommentContainer() || view == this.gBP.getCommentContainer()) {
            if (((com.baidu.tieba.card.data.j) this.adw).aOi().aQS() != null && ((com.baidu.tieba.card.data.j) this.adw).aOi().aQS().isChushou) {
                dN(((com.baidu.tieba.card.data.j) this.adw).aOi().aQS().thirdRoomId, ((com.baidu.tieba.card.data.j) this.adw).aOi().aQS().thirdLiveType);
            } else {
                bI(view);
            }
        }
    }

    private void dN(String str, String str2) {
        ba.aVa().b(this.mTbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void bI(View view) {
        if (bKU() != null) {
            bKU().a(view, this.adw);
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
        if (bdUniqueId != null && this.fGz != null && this.gDS != null) {
            setTag(bdUniqueId);
            q(bdUniqueId);
            if (this.adC != null) {
                this.adC.setPageUniqueId(bdUniqueId);
            }
            this.gDS.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gDS);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aeX = str;
    }

    public void sp(int i) {
        if (this.fGz != null) {
            this.fGz.dWw = String.valueOf(i);
        }
    }

    public void gU(boolean z) {
        this.dXG = z;
    }
}
