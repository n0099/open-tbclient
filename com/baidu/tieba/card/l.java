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
    private View.OnClickListener eQN;
    public boolean eRV;
    public LinearLayout fSf;
    public TbImageView fzG;
    private TextView fzM;
    public RelativeLayout gNr;
    private TBLottieAnimationView gNs;
    private TextView gNt;
    private LinearLayout gNu;
    private View gNv;
    private FrameLayout hRC;
    private CustomMessageListener hRD;
    private View.OnClickListener hRF;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.eRV = false;
        this.mLastScreenWidth = 0;
        this.hRF = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        };
        this.ajG = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.cls() != null) {
                    l.this.cls().a(view, l.this.afI);
                }
            }
        };
        this.eQN = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.cls() != null) {
                    l.this.cls().a(view, l.this.afI);
                }
            }
        };
        this.hRD = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.l.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && l.this.afI != 0 && ((com.baidu.tieba.card.data.k) l.this.afI).erH != null && ((com.baidu.tieba.card.data.k) l.this.afI).erH.getTid() != null && l.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(((com.baidu.tieba.card.data.k) l.this.afI).erH.getTid())) {
                    n.a(l.this.mTextTitle, ((com.baidu.tieba.card.data.k) l.this.afI).erH.getId(), R.color.cp_cont_d, R.color.cp_cont_d);
                }
            }
        };
        this.eCn = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init(getView());
    }

    private void init(View view) {
        this.hRC = (FrameLayout) view.findViewById(R.id.layout_root);
        this.mDivider = view.findViewById(R.id.divider_line);
        com.baidu.tbadk.a.b.a.d(this.mDivider, R.dimen.tbds20, R.dimen.tbds0);
        this.fSf = (LinearLayout) view.findViewById(R.id.content_layout);
        this.afO = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.afO.setPageContext(this.eCn);
        this.afO.setPageUniqueId(this.mBdUniqueId);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gNr = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.fzG = (TbImageView) view.findViewById(R.id.image_video);
        this.fzG.setDrawCorner(true);
        this.fzG.setPlaceHolder(3);
        this.fzG.setDefaultResource(0);
        this.fzG.setDefaultErrorResource(0);
        this.fzG.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
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
        this.gNs.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.l.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                l.this.gNs.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                l.this.gNs.cancelAnimation();
            }
        });
        this.fzM = (TextView) view.findViewById(R.id.play_count);
        this.gNt = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.gNv = view.findViewById(R.id.play_count_line);
        this.hPD = (ForumEnterLayout) view.findViewById(R.id.card_forum_enter_button);
        this.gMs = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_layout);
        this.hPB = (ThreadCardBottomOpSegmentWeightLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.gMs);
        b(this.hPB);
        this.fSf.setOnClickListener(this);
        com.baidu.tbadk.a.b.a.h(view.findViewById(R.id.imageMask), R.color.transparent);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mDivider, R.color.cp_bg_line_b);
            g(tbPageContext, i);
            ap.setBackgroundResource(this.hRC, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.fSf, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.gNr, R.drawable.bg_ala_shape);
            int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
            ap.a(this.gNu, R.color.cp_other_d, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, 0.0f, 0.0f, dimens, dimens, 0.0f, 0.0f});
            ap.setBackgroundColor(this.gNv, R.color.cp_cont_a);
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b);
            ap.setViewTextColor(this.fzM, R.color.cp_cont_a);
            ap.setViewTextColor(this.gNt, R.color.cp_cont_a);
            this.afO.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fzG.setPlaceHolder(3);
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
        if (this.afI == 0 || ((com.baidu.tieba.card.data.k) this.afI).bhz() == null) {
            this.hRC.setVisibility(8);
            return;
        }
        this.hRC.setVisibility(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eCn.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gNr.getLayoutParams();
            layoutParams.width = equipmentWidth - com.baidu.adp.lib.util.l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.gNr.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (((com.baidu.tieba.card.data.k) this.afI).bhz().bku() != null && ((com.baidu.tieba.card.data.k) this.afI).bhz().bku().isChushou) {
            this.gMs.setShowFlag(10);
            this.gMs.hideShareContainer();
        } else {
            this.gMs.setShowFlag(11);
            this.gMs.resetShareContainer();
        }
        this.afO.setVisibility(0);
        this.afO.setData(((com.baidu.tieba.card.data.k) this.afI).bhz());
        this.afO.setUserAfterClickListener(this.ajG);
        ((com.baidu.tieba.card.data.k) this.afI).bhz().bkY();
        this.mTextTitle.setText(new SpannableStringBuilder(((com.baidu.tieba.card.data.k) this.afI).bhz().bkK()));
        if (((com.baidu.tieba.card.data.k) this.afI).erH.bku().audience_count > 0) {
            this.gNv.setVisibility(0);
            this.fzM.setVisibility(0);
            this.fzM.setText(String.format(this.eCn.getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(((com.baidu.tieba.card.data.k) this.afI).erH.bku().audience_count)));
        } else {
            this.gNv.setVisibility(8);
            this.fzM.setVisibility(8);
        }
        this.gNt.setVisibility(8);
        if (((com.baidu.tieba.card.data.k) this.afI).erH.bku().openRecomReason == 1) {
            String str = ((com.baidu.tieba.card.data.k) this.afI).erH.bku().recomReason;
            if (!StringUtils.isNull(str)) {
                this.gNt.setVisibility(0);
                this.gNt.setText(str);
            } else {
                String bkp = ((com.baidu.tieba.card.data.k) this.afI).erH.bkp();
                String bkq = ((com.baidu.tieba.card.data.k) this.afI).erH.bkq();
                if (UtilHelper.isDecimal(bkp) && UtilHelper.isDecimal(bkq) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo dyF = com.baidu.tieba.recapp.d.a.dyA().dyF();
                    String str2 = dyF.latitude;
                    String str3 = dyF.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && com.baidu.adp.lib.util.l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(bkp), Double.parseDouble(bkq)) <= 50.0d) {
                        this.gNt.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.gNt.setVisibility(0);
                    }
                }
            }
        }
        aQ(this.hRC);
        onChangeSkinType(this.eCn, TbadkCoreApplication.getInst().getSkinType());
        if (n.IJ(((com.baidu.tieba.card.data.k) this.afI).erH.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        bTs();
        this.gNs.playAnimation();
    }

    public void bTs() {
        if (com.baidu.tbadk.core.k.bhh().isShowImages() && this.afI != 0 && ((com.baidu.tieba.card.data.k) this.afI).bhz() != null && ((com.baidu.tieba.card.data.k) this.afI).bhz().bku() != null) {
            this.fzG.setPlaceHolder(3);
            this.fzG.startLoad(((com.baidu.tieba.card.data.k) this.afI).bhz().bku().cover, 10, false);
            this.gNr.setVisibility(0);
            return;
        }
        this.gNr.setVisibility(8);
    }

    public View clv() {
        if (this.afO != null) {
            return this.afO.getAvatar();
        }
        return null;
    }

    public View clw() {
        if (this.eRV) {
            if (this.afO != null) {
                return this.afO.getUserName();
            }
            return null;
        }
        return this.mTextTitle;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fSf || view == this.gMs.getCommentContainer() || view == this.hPB.getCommentContainer()) {
            if (((com.baidu.tieba.card.data.k) this.afI).bhz().bku() != null && ((com.baidu.tieba.card.data.k) this.afI).bhz().bku().isChushou) {
                eC(((com.baidu.tieba.card.data.k) this.afI).bhz().bku().thirdRoomId, ((com.baidu.tieba.card.data.k) this.afI).bhz().bku().thirdLiveType);
            } else {
                cl(view);
            }
        }
    }

    private void eC(String str, String str2) {
        be.boR().b(this.mTbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void cl(View view) {
        if (cls() != null) {
            cls().a(view, this.afI);
        }
        if (this.afI != 0 && ((com.baidu.tieba.card.data.k) this.afI).bhz() != null && ((com.baidu.tieba.card.data.k) this.afI).bhz().bku() != null) {
            n.II(((com.baidu.tieba.card.data.k) this.afI).erH.getId());
            n.a(this.mTextTitle, ((com.baidu.tieba.card.data.k) this.afI).erH.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(((com.baidu.tieba.card.data.k) this.afI).bhz().bku());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.eCn.getPageActivity(), alaLiveInfoCoreData, "home_rec_play", "", false, "")));
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gMs != null && this.hRD != null) {
            setTag(bdUniqueId);
            q(bdUniqueId);
            if (this.afO != null) {
                this.afO.setPageUniqueId(bdUniqueId);
            }
            this.hRD.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hRD);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahu = str;
    }

    public void wS(int i) {
        if (this.gMs != null) {
            this.gMs.eQL = String.valueOf(i);
        }
    }

    public void iK(boolean z) {
        this.eRV = z;
    }
}
