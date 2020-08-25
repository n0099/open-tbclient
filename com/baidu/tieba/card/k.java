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
    private CardUserInfoLayout afc;
    private String agH;
    private View.OnClickListener aiR;
    private View.OnClickListener etZ;
    public boolean evh;
    public TbImageView fbX;
    private TextView fcd;
    public LinearLayout fum;
    public RelativeLayout gjZ;
    private TBLottieAnimationView gka;
    private TextView gkb;
    private LinearLayout gkc;
    private View gkd;
    private FrameLayout hjf;
    private View.OnClickListener hjg;
    private CustomMessageListener hjh;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.evh = false;
        this.mLastScreenWidth = 0;
        this.hjg = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        };
        this.aiR = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.cbz() != null) {
                    k.this.cbz().a(view, k.this.aeW);
                }
            }
        };
        this.etZ = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.cbz() != null) {
                    k.this.cbz().a(view, k.this.aeW);
                }
            }
        };
        this.hjh = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.k.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && k.this.aeW != 0 && ((com.baidu.tieba.card.data.k) k.this.aeW).dUS != null && ((com.baidu.tieba.card.data.k) k.this.aeW).dUS.getTid() != null && k.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(((com.baidu.tieba.card.data.k) k.this.aeW).dUS.getTid())) {
                    m.a(k.this.mTextTitle, ((com.baidu.tieba.card.data.k) k.this.aeW).dUS.getId(), R.color.cp_cont_d, R.color.cp_cont_d);
                }
            }
        };
        this.efn = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init(getView());
    }

    private void init(View view) {
        this.hjf = (FrameLayout) view.findViewById(R.id.layout_root);
        this.mDivider = view.findViewById(R.id.divider_line);
        com.baidu.tbadk.a.b.a.d(this.mDivider, R.dimen.tbds20, R.dimen.tbds0);
        this.fum = (LinearLayout) view.findViewById(R.id.content_layout);
        this.afc = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.afc.setPageContext(this.efn);
        this.afc.setPageUniqueId(this.mBdUniqueId);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gjZ = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.fbX = (TbImageView) view.findViewById(R.id.image_video);
        this.fbX.setDrawCorner(true);
        this.fbX.setPlaceHolder(3);
        this.fbX.setDefaultResource(0);
        this.fbX.setDefaultErrorResource(0);
        this.fbX.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        TbImageView tbImageView = this.fbX;
        TbImageView tbImageView2 = this.fbX;
        tbImageView.setConrers(15);
        this.fbX.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fbX.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.fbX.setBorderSurroundContent(true);
        this.fbX.setDrawBorder(true);
        this.gkc = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
        this.gka = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.gka.loop(true);
        ap.a(this.gka, R.raw.ala_live2);
        this.gka.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                k.this.gka.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                k.this.gka.cancelAnimation();
            }
        });
        this.fcd = (TextView) view.findViewById(R.id.play_count);
        this.gkb = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.gkd = view.findViewById(R.id.play_count_line);
        this.hhf = (ForumEnterLayout) view.findViewById(R.id.card_forum_enter_button);
        this.gja = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_layout);
        this.hhd = (ThreadCardBottomOpSegmentWeightLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.gja);
        b(this.hhd);
        this.fum.setOnClickListener(this);
        com.baidu.tbadk.a.b.a.h(view.findViewById(R.id.imageMask), R.color.transparent);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mDivider, R.color.cp_bg_line_b);
            g(tbPageContext, i);
            ap.setBackgroundResource(this.hjf, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.fum, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.gjZ, R.drawable.bg_ala_shape);
            int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
            ap.a(this.gkc, R.color.cp_other_d, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, 0.0f, 0.0f, dimens, dimens, 0.0f, 0.0f});
            ap.setBackgroundColor(this.gkd, R.color.cp_cont_a);
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b);
            ap.setViewTextColor(this.fcd, R.color.cp_cont_a);
            ap.setViewTextColor(this.gkb, R.color.cp_cont_a);
            this.afc.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fbX.setPlaceHolder(3);
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
        this.aeW = kVar;
        refreshView();
    }

    private void refreshView() {
        if (this.aeW == 0 || ((com.baidu.tieba.card.data.k) this.aeW).bce() == null) {
            this.hjf.setVisibility(8);
            return;
        }
        this.hjf.setVisibility(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.efn.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gjZ.getLayoutParams();
            layoutParams.width = equipmentWidth - com.baidu.adp.lib.util.l.getDimens(this.efn.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.gjZ.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (((com.baidu.tieba.card.data.k) this.aeW).bce().beY() != null && ((com.baidu.tieba.card.data.k) this.aeW).bce().beY().isChushou) {
            this.gja.setShowFlag(10);
            this.gja.hideShareContainer();
        } else {
            this.gja.setShowFlag(11);
            this.gja.resetShareContainer();
        }
        this.afc.setVisibility(0);
        this.afc.setData(((com.baidu.tieba.card.data.k) this.aeW).bce());
        this.afc.setUserAfterClickListener(this.aiR);
        ((com.baidu.tieba.card.data.k) this.aeW).bce().bfC();
        this.mTextTitle.setText(new SpannableStringBuilder(((com.baidu.tieba.card.data.k) this.aeW).bce().bfo()));
        if (((com.baidu.tieba.card.data.k) this.aeW).dUS.beY().audience_count > 0) {
            this.gkd.setVisibility(0);
            this.fcd.setVisibility(0);
            this.fcd.setText(String.format(this.efn.getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(((com.baidu.tieba.card.data.k) this.aeW).dUS.beY().audience_count)));
        } else {
            this.gkd.setVisibility(8);
            this.fcd.setVisibility(8);
        }
        this.gkb.setVisibility(8);
        if (((com.baidu.tieba.card.data.k) this.aeW).dUS.beY().openRecomReason == 1) {
            String str = ((com.baidu.tieba.card.data.k) this.aeW).dUS.beY().recomReason;
            if (!StringUtils.isNull(str)) {
                this.gkb.setVisibility(0);
                this.gkb.setText(str);
            } else {
                String beT = ((com.baidu.tieba.card.data.k) this.aeW).dUS.beT();
                String beU = ((com.baidu.tieba.card.data.k) this.aeW).dUS.beU();
                if (UtilHelper.isDecimal(beT) && UtilHelper.isDecimal(beU) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo dob = com.baidu.tieba.recapp.d.a.dnW().dob();
                    String str2 = dob.latitude;
                    String str3 = dob.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && com.baidu.adp.lib.util.l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(beT), Double.parseDouble(beU)) <= 50.0d) {
                        this.gkb.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.gkb.setVisibility(0);
                    }
                }
            }
        }
        aN(this.hjf);
        onChangeSkinType(this.efn, TbadkCoreApplication.getInst().getSkinType());
        if (m.GZ(((com.baidu.tieba.card.data.k) this.aeW).dUS.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        bLT();
        this.gka.playAnimation();
    }

    public void bLT() {
        if (com.baidu.tbadk.core.k.bbM().isShowImages() && this.aeW != 0 && ((com.baidu.tieba.card.data.k) this.aeW).bce() != null && ((com.baidu.tieba.card.data.k) this.aeW).bce().beY() != null) {
            this.fbX.setPlaceHolder(3);
            this.fbX.startLoad(((com.baidu.tieba.card.data.k) this.aeW).bce().beY().cover, 10, false);
            this.gjZ.setVisibility(0);
            return;
        }
        this.gjZ.setVisibility(8);
    }

    public View cbC() {
        if (this.afc != null) {
            return this.afc.getAvatar();
        }
        return null;
    }

    public View cbD() {
        if (this.evh) {
            if (this.afc != null) {
                return this.afc.getUserName();
            }
            return null;
        }
        return this.mTextTitle;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fum || view == this.gja.getCommentContainer() || view == this.hhd.getCommentContainer()) {
            if (((com.baidu.tieba.card.data.k) this.aeW).bce().beY() != null && ((com.baidu.tieba.card.data.k) this.aeW).bce().beY().isChushou) {
                el(((com.baidu.tieba.card.data.k) this.aeW).bce().beY().thirdRoomId, ((com.baidu.tieba.card.data.k) this.aeW).bce().beY().thirdLiveType);
            } else {
                bU(view);
            }
        }
    }

    private void el(String str, String str2) {
        be.bju().b(this.mTbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void bU(View view) {
        if (cbz() != null) {
            cbz().a(view, this.aeW);
        }
        if (this.aeW != 0 && ((com.baidu.tieba.card.data.k) this.aeW).bce() != null && ((com.baidu.tieba.card.data.k) this.aeW).bce().beY() != null) {
            m.GY(((com.baidu.tieba.card.data.k) this.aeW).dUS.getId());
            m.a(this.mTextTitle, ((com.baidu.tieba.card.data.k) this.aeW).dUS.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(((com.baidu.tieba.card.data.k) this.aeW).bce().beY());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.efn.getPageActivity(), alaLiveInfoCoreData, "home_rec_play", "", false, "")));
        }
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gja != null && this.hjh != null) {
            setTag(bdUniqueId);
            r(bdUniqueId);
            if (this.afc != null) {
                this.afc.setPageUniqueId(bdUniqueId);
            }
            this.hjh.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hjh);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.agH = str;
    }

    public void vu(int i) {
        if (this.gja != null) {
            this.gja.etX = String.valueOf(i);
        }
    }

    public void id(boolean z) {
        this.evh = z;
    }
}
