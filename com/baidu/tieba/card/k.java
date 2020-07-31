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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import tbclient.AppPosInfo;
/* loaded from: classes15.dex */
public class k extends a<com.baidu.tieba.card.data.j> implements com.baidu.tieba.a.e {
    private CardUserInfoLayout adW;
    private String afx;
    private View.OnClickListener ahD;
    public TbImageView eRr;
    private TextView eRx;
    private View.OnClickListener eke;
    public boolean elm;
    public RelativeLayout fYa;
    private TBLottieAnimationView fYb;
    private TextView fYc;
    private LinearLayout fYd;
    private View fYe;
    public LinearLayout fiQ;
    private FrameLayout gWm;
    private View.OnClickListener gWn;
    private CustomMessageListener gWo;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.elm = false;
        this.mLastScreenWidth = 0;
        this.gWn = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        };
        this.ahD = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.bRn() != null) {
                    k.this.bRn().a(view, k.this.adQ);
                }
            }
        };
        this.eke = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.bRn() != null) {
                    k.this.bRn().a(view, k.this.adQ);
                }
            }
        };
        this.gWo = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.k.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && k.this.adQ != 0 && ((com.baidu.tieba.card.data.j) k.this.adQ).dLK != null && ((com.baidu.tieba.card.data.j) k.this.adQ).dLK.getTid() != null && k.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(((com.baidu.tieba.card.data.j) k.this.adQ).dLK.getTid())) {
                    m.a(k.this.mTextTitle, ((com.baidu.tieba.card.data.j) k.this.adQ).dLK.getId(), R.color.cp_cont_d, R.color.cp_cont_d);
                }
            }
        };
        this.dVN = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init(getView());
    }

    private void init(View view) {
        this.gWm = (FrameLayout) view.findViewById(R.id.layout_root);
        this.mDivider = view.findViewById(R.id.divider_line);
        com.baidu.tbadk.a.b.a.e(this.mDivider, R.dimen.tbds20, R.dimen.tbds0);
        this.fiQ = (LinearLayout) view.findViewById(R.id.content_layout);
        this.adW = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.adW.setPageContext(this.dVN);
        this.adW.setPageUniqueId(this.mBdUniqueId);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fYa = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.eRr = (TbImageView) view.findViewById(R.id.image_video);
        this.eRr.setDrawCorner(true);
        this.eRr.setPlaceHolder(3);
        this.eRr.setDefaultResource(0);
        this.eRr.setDefaultErrorResource(0);
        this.eRr.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        TbImageView tbImageView = this.eRr;
        TbImageView tbImageView2 = this.eRr;
        tbImageView.setConrers(15);
        this.eRr.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eRr.setBorderColor(ao.getColor(R.color.cp_border_a));
        this.eRr.setBorderSurroundContent(true);
        this.eRr.setDrawBorder(true);
        this.fYd = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
        this.fYb = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.fYb.loop(true);
        ao.a(this.fYb, R.raw.ala_live2);
        this.fYb.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                k.this.fYb.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                k.this.fYb.cancelAnimation();
            }
        });
        this.eRx = (TextView) view.findViewById(R.id.play_count);
        this.fYc = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.fYe = view.findViewById(R.id.play_count_line);
        this.gUn = (ForumEnterLayout) view.findViewById(R.id.card_forum_enter_button);
        this.fXb = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_layout);
        this.gUl = (ThreadCardBottomOpSegmentWeightLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.fXb);
        b(this.gUl);
        this.fiQ.setOnClickListener(this);
        com.baidu.tbadk.a.b.a.h(view.findViewById(R.id.imageMask), R.color.transparent);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.mDivider, R.color.cp_bg_line_b);
            d(tbPageContext, i);
            ao.setBackgroundResource(this.gWm, R.drawable.addresslist_item_bg);
            ao.setBackgroundResource(this.fiQ, R.drawable.addresslist_item_bg);
            ao.setBackgroundResource(this.fYa, R.drawable.bg_ala_shape);
            int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
            ao.a(this.fYd, R.color.cp_other_d, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, 0.0f, 0.0f, dimens, dimens, 0.0f, 0.0f});
            ao.setBackgroundColor(this.fYe, R.color.cp_cont_a);
            ao.setViewTextColor(this.mTextTitle, R.color.cp_cont_b);
            ao.setViewTextColor(this.eRx, R.color.cp_cont_a);
            ao.setViewTextColor(this.fYc, R.color.cp_cont_a);
            this.adW.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.eRr.setPlaceHolder(3);
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
        this.adQ = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.adQ == 0 || ((com.baidu.tieba.card.data.j) this.adQ).aTN() == null) {
            this.gWm.setVisibility(8);
            return;
        }
        this.gWm.setVisibility(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.dVN.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fYa.getLayoutParams();
            layoutParams.width = equipmentWidth - com.baidu.adp.lib.util.l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.fYa.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (((com.baidu.tieba.card.data.j) this.adQ).aTN().aWF() != null && ((com.baidu.tieba.card.data.j) this.adQ).aTN().aWF().isChushou) {
            this.fXb.setShowFlag(10);
            this.fXb.hideShareContainer();
        } else {
            this.fXb.setShowFlag(11);
            this.fXb.resetShareContainer();
        }
        this.adW.setVisibility(0);
        this.adW.setData(((com.baidu.tieba.card.data.j) this.adQ).aTN());
        this.adW.setUserAfterClickListener(this.ahD);
        ((com.baidu.tieba.card.data.j) this.adQ).aTN().aXj();
        this.mTextTitle.setText(new SpannableStringBuilder(((com.baidu.tieba.card.data.j) this.adQ).aTN().aWV()));
        if (((com.baidu.tieba.card.data.j) this.adQ).dLK.aWF().audience_count > 0) {
            this.fYe.setVisibility(0);
            this.eRx.setVisibility(0);
            this.eRx.setText(String.format(this.dVN.getResources().getString(R.string.ala_audience_count_prefix), as.numFormatOverWan(((com.baidu.tieba.card.data.j) this.adQ).dLK.aWF().audience_count)));
        } else {
            this.fYe.setVisibility(8);
            this.eRx.setVisibility(8);
        }
        this.fYc.setVisibility(8);
        if (((com.baidu.tieba.card.data.j) this.adQ).dLK.aWF().openRecomReason == 1) {
            String str = ((com.baidu.tieba.card.data.j) this.adQ).dLK.aWF().recomReason;
            if (!StringUtils.isNull(str)) {
                this.fYc.setVisibility(0);
                this.fYc.setText(str);
            } else {
                String aWA = ((com.baidu.tieba.card.data.j) this.adQ).dLK.aWA();
                String aWB = ((com.baidu.tieba.card.data.j) this.adQ).dLK.aWB();
                if (UtilHelper.isDecimal(aWA) && UtilHelper.isDecimal(aWB) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo dcR = com.baidu.tieba.recapp.d.a.dcN().dcR();
                    String str2 = dcR.latitude;
                    String str3 = dcR.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && com.baidu.adp.lib.util.l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(aWA), Double.parseDouble(aWB)) <= 50.0d) {
                        this.fYc.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.fYc.setVisibility(0);
                    }
                }
            }
        }
        aO(this.gWm);
        onChangeSkinType(this.dVN, TbadkCoreApplication.getInst().getSkinType());
        if (m.EA(((com.baidu.tieba.card.data.j) this.adQ).dLK.getId())) {
            ao.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            ao.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        bCz();
        this.fYb.playAnimation();
    }

    public void bCz() {
        if (com.baidu.tbadk.core.k.aTv().isShowImages() && this.adQ != 0 && ((com.baidu.tieba.card.data.j) this.adQ).aTN() != null && ((com.baidu.tieba.card.data.j) this.adQ).aTN().aWF() != null) {
            this.eRr.setPlaceHolder(3);
            this.eRr.startLoad(((com.baidu.tieba.card.data.j) this.adQ).aTN().aWF().cover, 10, false);
            this.fYa.setVisibility(0);
            return;
        }
        this.fYa.setVisibility(8);
    }

    public View bRq() {
        if (this.adW != null) {
            return this.adW.getAvatar();
        }
        return null;
    }

    public View bRr() {
        if (this.elm) {
            if (this.adW != null) {
                return this.adW.getUserName();
            }
            return null;
        }
        return this.mTextTitle;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fiQ || view == this.fXb.getCommentContainer() || view == this.gUl.getCommentContainer()) {
            if (((com.baidu.tieba.card.data.j) this.adQ).aTN().aWF() != null && ((com.baidu.tieba.card.data.j) this.adQ).aTN().aWF().isChushou) {
                dU(((com.baidu.tieba.card.data.j) this.adQ).aTN().aWF().thirdRoomId, ((com.baidu.tieba.card.data.j) this.adQ).aTN().aWF().thirdLiveType);
            } else {
                bS(view);
            }
        }
    }

    private void dU(String str, String str2) {
        bd.baV().b(this.mTbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void bS(View view) {
        if (bRn() != null) {
            bRn().a(view, this.adQ);
        }
        if (this.adQ != 0 && ((com.baidu.tieba.card.data.j) this.adQ).aTN() != null && ((com.baidu.tieba.card.data.j) this.adQ).aTN().aWF() != null) {
            m.Ez(((com.baidu.tieba.card.data.j) this.adQ).dLK.getId());
            m.a(this.mTextTitle, ((com.baidu.tieba.card.data.j) this.adQ).dLK.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(((com.baidu.tieba.card.data.j) this.adQ).aTN().aWF());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.dVN.getPageActivity(), alaLiveInfoCoreData, "home_rec_play", "", false, "")));
        }
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.fXb != null && this.gWo != null) {
            setTag(bdUniqueId);
            r(bdUniqueId);
            if (this.adW != null) {
                this.adW.setPageUniqueId(bdUniqueId);
            }
            this.gWo.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gWo);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.afx = str;
    }

    public void tf(int i) {
        if (this.fXb != null) {
            this.fXb.ekc = String.valueOf(i);
        }
    }

    public void hH(boolean z) {
        this.elm = z;
    }
}
