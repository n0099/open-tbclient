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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import tbclient.AppPosInfo;
/* loaded from: classes8.dex */
public class k extends a<com.baidu.tieba.card.data.j> implements com.baidu.tieba.a.e {
    private CardUserInfoLayout aeg;
    private String afG;
    private View.OnClickListener ahM;
    public TbImageView eKV;
    private TextView eLb;
    private View.OnClickListener edU;
    public boolean efc;
    public RelativeLayout fSH;
    private TBLottieAnimationView fSI;
    private TextView fSJ;
    private LinearLayout fSK;
    private View fSL;
    public LinearLayout fdX;
    private FrameLayout gQG;
    private View.OnClickListener gQH;
    private CustomMessageListener gQI;
    public View mDivider;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.efc = false;
        this.mLastScreenWidth = 0;
        this.gQH = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        };
        this.ahM = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.bOc() != null) {
                    k.this.bOc().a(view, k.this.aea);
                }
            }
        };
        this.edU = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.bOc() != null) {
                    k.this.bOc().a(view, k.this.aea);
                }
            }
        };
        this.gQI = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.k.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && k.this.aea != 0 && ((com.baidu.tieba.card.data.j) k.this.aea).dLi != null && ((com.baidu.tieba.card.data.j) k.this.aea).dLi.getTid() != null && k.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(((com.baidu.tieba.card.data.j) k.this.aea).dLi.getTid())) {
                    m.a(k.this.mTextTitle, ((com.baidu.tieba.card.data.j) k.this.aea).dLi.getId(), (int) R.color.cp_cont_d, (int) R.color.cp_cont_d);
                }
            }
        };
        this.dPv = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init(getView());
    }

    private void init(View view) {
        this.gQG = (FrameLayout) view.findViewById(R.id.layout_root);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.fdX = (LinearLayout) view.findViewById(R.id.content_layout);
        this.aeg = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.aeg.setPageContext(this.dPv);
        this.aeg.setPageUniqueId(this.mBdUniqueId);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fSH = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.eKV = (TbImageView) view.findViewById(R.id.image_video);
        this.eKV.setDrawCorner(true);
        this.eKV.setPlaceHolder(3);
        this.eKV.setDefaultResource(0);
        this.eKV.setDefaultErrorResource(0);
        this.eKV.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        TbImageView tbImageView = this.eKV;
        TbImageView tbImageView2 = this.eKV;
        tbImageView.setConrers(15);
        this.eKV.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eKV.setBorderColor(an.getColor(R.color.cp_border_a));
        this.eKV.setBorderSurroundContent(true);
        this.eKV.setDrawBorder(true);
        this.fSK = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
        this.fSI = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.fSI.loop(true);
        an.a(this.fSI, (int) R.raw.ala_live2);
        this.fSI.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                k.this.fSI.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                k.this.fSI.cancelAnimation();
            }
        });
        this.eLb = (TextView) view.findViewById(R.id.play_count);
        this.fSJ = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.fSL = view.findViewById(R.id.play_count_line);
        this.gOH = (ForumEnterLayout) view.findViewById(R.id.card_forum_enter_button);
        this.fRI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_layout);
        this.gOF = (ThreadCardBottomOpSegmentWeightLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.fRI);
        b(this.gOF);
        this.fdX.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            d(tbPageContext, i);
            an.setBackgroundResource(this.gQG, R.drawable.addresslist_item_bg);
            an.setBackgroundResource(this.fdX, R.drawable.addresslist_item_bg);
            an.setBackgroundResource(this.fSH, R.drawable.bg_ala_shape);
            int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
            an.a(this.fSK, (int) R.color.cp_other_d, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, 0.0f, 0.0f, dimens, dimens, 0.0f, 0.0f});
            an.setBackgroundColor(this.fSL, R.color.cp_cont_a);
            an.setBackgroundResource(this.mDivider, R.color.cp_bg_line_b);
            an.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.eLb, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.fSJ, (int) R.color.cp_cont_a);
            this.aeg.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.eKV.setPlaceHolder(3);
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
        this.aea = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.aea == 0 || ((com.baidu.tieba.card.data.j) this.aea).aPS() == null) {
            this.gQG.setVisibility(8);
            return;
        }
        this.gQG.setVisibility(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.dPv.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fSH.getLayoutParams();
            layoutParams.width = equipmentWidth - com.baidu.adp.lib.util.l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.fSH.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (((com.baidu.tieba.card.data.j) this.aea).aPS().aSJ() != null && ((com.baidu.tieba.card.data.j) this.aea).aPS().aSJ().isChushou) {
            this.fRI.setShowFlag(10);
            this.fRI.hideShareContainer();
        } else {
            this.fRI.setShowFlag(11);
            this.fRI.resetShareContainer();
        }
        this.aeg.setVisibility(0);
        this.aeg.setData(((com.baidu.tieba.card.data.j) this.aea).aPS());
        this.aeg.setUserAfterClickListener(this.ahM);
        ((com.baidu.tieba.card.data.j) this.aea).aPS().aTn();
        this.mTextTitle.setText(new SpannableStringBuilder(((com.baidu.tieba.card.data.j) this.aea).aPS().aSZ()));
        if (((com.baidu.tieba.card.data.j) this.aea).dLi.aSJ().audience_count > 0) {
            this.fSL.setVisibility(0);
            this.eLb.setVisibility(0);
            this.eLb.setText(String.format(this.dPv.getResources().getString(R.string.ala_audience_count_prefix), ar.numFormatOverWan(((com.baidu.tieba.card.data.j) this.aea).dLi.aSJ().audience_count)));
        } else {
            this.fSL.setVisibility(8);
            this.eLb.setVisibility(8);
        }
        this.fSJ.setVisibility(8);
        if (((com.baidu.tieba.card.data.j) this.aea).dLi.aSJ().openRecomReason == 1) {
            String str = ((com.baidu.tieba.card.data.j) this.aea).dLi.aSJ().recomReason;
            if (!StringUtils.isNull(str)) {
                this.fSJ.setVisibility(0);
                this.fSJ.setText(str);
            } else {
                String aSE = ((com.baidu.tieba.card.data.j) this.aea).dLi.aSE();
                String aSF = ((com.baidu.tieba.card.data.j) this.aea).dLi.aSF();
                if (UtilHelper.isDecimal(aSE) && UtilHelper.isDecimal(aSF) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo cZJ = com.baidu.tieba.recapp.d.a.cZF().cZJ();
                    String str2 = cZJ.latitude;
                    String str3 = cZJ.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && com.baidu.adp.lib.util.l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(aSE), Double.parseDouble(aSF)) <= 50.0d) {
                        this.fSJ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.fSJ.setVisibility(0);
                    }
                }
            }
        }
        aN(this.gQG);
        onChangeSkinType(this.dPv, TbadkCoreApplication.getInst().getSkinType());
        if (m.DP(((com.baidu.tieba.card.data.j) this.aea).dLi.getId())) {
            an.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            an.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        bzk();
        this.fSI.playAnimation();
    }

    public void bzk() {
        if (com.baidu.tbadk.core.k.aPA().isShowImages() && this.aea != 0 && ((com.baidu.tieba.card.data.j) this.aea).aPS() != null && ((com.baidu.tieba.card.data.j) this.aea).aPS().aSJ() != null) {
            this.eKV.setPlaceHolder(3);
            this.eKV.startLoad(((com.baidu.tieba.card.data.j) this.aea).aPS().aSJ().cover, 10, false);
            this.fSH.setVisibility(0);
            return;
        }
        this.fSH.setVisibility(8);
    }

    public View bOf() {
        if (this.aeg != null) {
            return this.aeg.getAvatar();
        }
        return null;
    }

    public View bOg() {
        if (this.efc) {
            if (this.aeg != null) {
                return this.aeg.getUserName();
            }
            return null;
        }
        return this.mTextTitle;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fdX || view == this.fRI.getCommentContainer() || view == this.gOF.getCommentContainer()) {
            if (((com.baidu.tieba.card.data.j) this.aea).aPS().aSJ() != null && ((com.baidu.tieba.card.data.j) this.aea).aPS().aSJ().isChushou) {
                dS(((com.baidu.tieba.card.data.j) this.aea).aPS().aSJ().thirdRoomId, ((com.baidu.tieba.card.data.j) this.aea).aPS().aSJ().thirdLiveType);
            } else {
                bM(view);
            }
        }
    }

    private void dS(String str, String str2) {
        bc.aWU().b(this.mTbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void bM(View view) {
        if (bOc() != null) {
            bOc().a(view, this.aea);
        }
        if (this.aea != 0 && ((com.baidu.tieba.card.data.j) this.aea).aPS() != null && ((com.baidu.tieba.card.data.j) this.aea).aPS().aSJ() != null) {
            m.DO(((com.baidu.tieba.card.data.j) this.aea).dLi.getId());
            m.a(this.mTextTitle, ((com.baidu.tieba.card.data.j) this.aea).dLi.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(((com.baidu.tieba.card.data.j) this.aea).aPS().aSJ());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.dPv.getPageActivity(), alaLiveInfoCoreData, "home_rec_play", "", false, "")));
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.fRI != null && this.gQI != null) {
            setTag(bdUniqueId);
            q(bdUniqueId);
            if (this.aeg != null) {
                this.aeg.setPageUniqueId(bdUniqueId);
            }
            this.gQI.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gQI);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.afG = str;
    }

    public void sN(int i) {
        if (this.fRI != null) {
            this.fRI.edS = String.valueOf(i);
        }
    }

    public void hd(boolean z) {
        this.efc = z;
    }
}
