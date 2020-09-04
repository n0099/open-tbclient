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
/* loaded from: classes15.dex */
public class k extends a<com.baidu.tieba.card.data.k> implements com.baidu.tieba.a.e {
    private CardUserInfoLayout afe;
    private String agJ;
    private View.OnClickListener aiT;
    private View.OnClickListener eud;
    public boolean evl;
    public TbImageView fcb;
    private TextView fch;
    public LinearLayout fuq;
    public RelativeLayout gkd;
    private TBLottieAnimationView gke;
    private TextView gkf;
    private LinearLayout gkg;
    private View gkh;
    private FrameLayout hjj;
    private View.OnClickListener hjk;
    private CustomMessageListener hjl;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.evl = false;
        this.mLastScreenWidth = 0;
        this.hjk = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        };
        this.aiT = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.cbA() != null) {
                    k.this.cbA().a(view, k.this.aeY);
                }
            }
        };
        this.eud = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.cbA() != null) {
                    k.this.cbA().a(view, k.this.aeY);
                }
            }
        };
        this.hjl = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.k.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && k.this.aeY != 0 && ((com.baidu.tieba.card.data.k) k.this.aeY).dUW != null && ((com.baidu.tieba.card.data.k) k.this.aeY).dUW.getTid() != null && k.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(((com.baidu.tieba.card.data.k) k.this.aeY).dUW.getTid())) {
                    m.a(k.this.mTextTitle, ((com.baidu.tieba.card.data.k) k.this.aeY).dUW.getId(), R.color.cp_cont_d, R.color.cp_cont_d);
                }
            }
        };
        this.efr = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init(getView());
    }

    private void init(View view) {
        this.hjj = (FrameLayout) view.findViewById(R.id.layout_root);
        this.mDivider = view.findViewById(R.id.divider_line);
        com.baidu.tbadk.a.b.a.d(this.mDivider, R.dimen.tbds20, R.dimen.tbds0);
        this.fuq = (LinearLayout) view.findViewById(R.id.content_layout);
        this.afe = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.afe.setPageContext(this.efr);
        this.afe.setPageUniqueId(this.mBdUniqueId);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gkd = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.fcb = (TbImageView) view.findViewById(R.id.image_video);
        this.fcb.setDrawCorner(true);
        this.fcb.setPlaceHolder(3);
        this.fcb.setDefaultResource(0);
        this.fcb.setDefaultErrorResource(0);
        this.fcb.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        TbImageView tbImageView = this.fcb;
        TbImageView tbImageView2 = this.fcb;
        tbImageView.setConrers(15);
        this.fcb.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fcb.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.fcb.setBorderSurroundContent(true);
        this.fcb.setDrawBorder(true);
        this.gkg = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
        this.gke = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.gke.loop(true);
        ap.a(this.gke, R.raw.ala_live2);
        this.gke.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                k.this.gke.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                k.this.gke.cancelAnimation();
            }
        });
        this.fch = (TextView) view.findViewById(R.id.play_count);
        this.gkf = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.gkh = view.findViewById(R.id.play_count_line);
        this.hhj = (ForumEnterLayout) view.findViewById(R.id.card_forum_enter_button);
        this.gje = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_layout);
        this.hhh = (ThreadCardBottomOpSegmentWeightLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.gje);
        b(this.hhh);
        this.fuq.setOnClickListener(this);
        com.baidu.tbadk.a.b.a.h(view.findViewById(R.id.imageMask), R.color.transparent);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mDivider, R.color.cp_bg_line_b);
            g(tbPageContext, i);
            ap.setBackgroundResource(this.hjj, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.fuq, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.gkd, R.drawable.bg_ala_shape);
            int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
            ap.a(this.gkg, R.color.cp_other_d, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, 0.0f, 0.0f, dimens, dimens, 0.0f, 0.0f});
            ap.setBackgroundColor(this.gkh, R.color.cp_cont_a);
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b);
            ap.setViewTextColor(this.fch, R.color.cp_cont_a);
            ap.setViewTextColor(this.gkf, R.color.cp_cont_a);
            this.afe.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fcb.setPlaceHolder(3);
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
        this.aeY = kVar;
        refreshView();
    }

    private void refreshView() {
        if (this.aeY == 0 || ((com.baidu.tieba.card.data.k) this.aeY).bce() == null) {
            this.hjj.setVisibility(8);
            return;
        }
        this.hjj.setVisibility(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.efr.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gkd.getLayoutParams();
            layoutParams.width = equipmentWidth - com.baidu.adp.lib.util.l.getDimens(this.efr.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.gkd.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (((com.baidu.tieba.card.data.k) this.aeY).bce().beY() != null && ((com.baidu.tieba.card.data.k) this.aeY).bce().beY().isChushou) {
            this.gje.setShowFlag(10);
            this.gje.hideShareContainer();
        } else {
            this.gje.setShowFlag(11);
            this.gje.resetShareContainer();
        }
        this.afe.setVisibility(0);
        this.afe.setData(((com.baidu.tieba.card.data.k) this.aeY).bce());
        this.afe.setUserAfterClickListener(this.aiT);
        ((com.baidu.tieba.card.data.k) this.aeY).bce().bfC();
        this.mTextTitle.setText(new SpannableStringBuilder(((com.baidu.tieba.card.data.k) this.aeY).bce().bfo()));
        if (((com.baidu.tieba.card.data.k) this.aeY).dUW.beY().audience_count > 0) {
            this.gkh.setVisibility(0);
            this.fch.setVisibility(0);
            this.fch.setText(String.format(this.efr.getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(((com.baidu.tieba.card.data.k) this.aeY).dUW.beY().audience_count)));
        } else {
            this.gkh.setVisibility(8);
            this.fch.setVisibility(8);
        }
        this.gkf.setVisibility(8);
        if (((com.baidu.tieba.card.data.k) this.aeY).dUW.beY().openRecomReason == 1) {
            String str = ((com.baidu.tieba.card.data.k) this.aeY).dUW.beY().recomReason;
            if (!StringUtils.isNull(str)) {
                this.gkf.setVisibility(0);
                this.gkf.setText(str);
            } else {
                String beT = ((com.baidu.tieba.card.data.k) this.aeY).dUW.beT();
                String beU = ((com.baidu.tieba.card.data.k) this.aeY).dUW.beU();
                if (UtilHelper.isDecimal(beT) && UtilHelper.isDecimal(beU) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo doe = com.baidu.tieba.recapp.d.a.dnZ().doe();
                    String str2 = doe.latitude;
                    String str3 = doe.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && com.baidu.adp.lib.util.l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(beT), Double.parseDouble(beU)) <= 50.0d) {
                        this.gkf.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.gkf.setVisibility(0);
                    }
                }
            }
        }
        aN(this.hjj);
        onChangeSkinType(this.efr, TbadkCoreApplication.getInst().getSkinType());
        if (m.Ha(((com.baidu.tieba.card.data.k) this.aeY).dUW.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        bLU();
        this.gke.playAnimation();
    }

    public void bLU() {
        if (com.baidu.tbadk.core.k.bbM().isShowImages() && this.aeY != 0 && ((com.baidu.tieba.card.data.k) this.aeY).bce() != null && ((com.baidu.tieba.card.data.k) this.aeY).bce().beY() != null) {
            this.fcb.setPlaceHolder(3);
            this.fcb.startLoad(((com.baidu.tieba.card.data.k) this.aeY).bce().beY().cover, 10, false);
            this.gkd.setVisibility(0);
            return;
        }
        this.gkd.setVisibility(8);
    }

    public View cbD() {
        if (this.afe != null) {
            return this.afe.getAvatar();
        }
        return null;
    }

    public View cbE() {
        if (this.evl) {
            if (this.afe != null) {
                return this.afe.getUserName();
            }
            return null;
        }
        return this.mTextTitle;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fuq || view == this.gje.getCommentContainer() || view == this.hhh.getCommentContainer()) {
            if (((com.baidu.tieba.card.data.k) this.aeY).bce().beY() != null && ((com.baidu.tieba.card.data.k) this.aeY).bce().beY().isChushou) {
                em(((com.baidu.tieba.card.data.k) this.aeY).bce().beY().thirdRoomId, ((com.baidu.tieba.card.data.k) this.aeY).bce().beY().thirdLiveType);
            } else {
                bU(view);
            }
        }
    }

    private void em(String str, String str2) {
        be.bju().b(this.mTbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void bU(View view) {
        if (cbA() != null) {
            cbA().a(view, this.aeY);
        }
        if (this.aeY != 0 && ((com.baidu.tieba.card.data.k) this.aeY).bce() != null && ((com.baidu.tieba.card.data.k) this.aeY).bce().beY() != null) {
            m.GZ(((com.baidu.tieba.card.data.k) this.aeY).dUW.getId());
            m.a(this.mTextTitle, ((com.baidu.tieba.card.data.k) this.aeY).dUW.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(((com.baidu.tieba.card.data.k) this.aeY).bce().beY());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.efr.getPageActivity(), alaLiveInfoCoreData, "home_rec_play", "", false, "")));
        }
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gje != null && this.hjl != null) {
            setTag(bdUniqueId);
            r(bdUniqueId);
            if (this.afe != null) {
                this.afe.setPageUniqueId(bdUniqueId);
            }
            this.hjl.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hjl);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.agJ = str;
    }

    public void vu(int i) {
        if (this.gje != null) {
            this.gje.eub = String.valueOf(i);
        }
    }

    public void ie(boolean z) {
        this.evl = z;
    }
}
