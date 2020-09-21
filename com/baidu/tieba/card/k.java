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
/* loaded from: classes20.dex */
public class k extends a<com.baidu.tieba.card.data.k> implements com.baidu.tieba.a.e {
    private CardUserInfoLayout afw;
    private String ahc;
    private View.OnClickListener ajn;
    private View.OnClickListener ewh;
    public boolean exp;
    public TbImageView feU;
    private TextView ffa;
    public LinearLayout fxB;
    public RelativeLayout gnk;
    private TBLottieAnimationView gnl;
    private TextView gnm;
    private LinearLayout gnn;
    private View gno;
    private FrameLayout hqm;
    private View.OnClickListener hqn;
    private CustomMessageListener hqo;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.exp = false;
        this.mLastScreenWidth = 0;
        this.hqn = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        };
        this.ajn = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.ceP() != null) {
                    k.this.ceP().a(view, k.this.afq);
                }
            }
        };
        this.ewh = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.ceP() != null) {
                    k.this.ceP().a(view, k.this.afq);
                }
            }
        };
        this.hqo = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.k.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && k.this.afq != 0 && ((com.baidu.tieba.card.data.k) k.this.afq).dXg != null && ((com.baidu.tieba.card.data.k) k.this.afq).dXg.getTid() != null && k.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(((com.baidu.tieba.card.data.k) k.this.afq).dXg.getTid())) {
                    m.a(k.this.mTextTitle, ((com.baidu.tieba.card.data.k) k.this.afq).dXg.getId(), R.color.cp_cont_d, R.color.cp_cont_d);
                }
            }
        };
        this.ehG = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init(getView());
    }

    private void init(View view) {
        this.hqm = (FrameLayout) view.findViewById(R.id.layout_root);
        this.mDivider = view.findViewById(R.id.divider_line);
        com.baidu.tbadk.a.b.a.d(this.mDivider, R.dimen.tbds20, R.dimen.tbds0);
        this.fxB = (LinearLayout) view.findViewById(R.id.content_layout);
        this.afw = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.afw.setPageContext(this.ehG);
        this.afw.setPageUniqueId(this.mBdUniqueId);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gnk = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.feU = (TbImageView) view.findViewById(R.id.image_video);
        this.feU.setDrawCorner(true);
        this.feU.setPlaceHolder(3);
        this.feU.setDefaultResource(0);
        this.feU.setDefaultErrorResource(0);
        this.feU.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        TbImageView tbImageView = this.feU;
        TbImageView tbImageView2 = this.feU;
        tbImageView.setConrers(15);
        this.feU.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.feU.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.feU.setBorderSurroundContent(true);
        this.feU.setDrawBorder(true);
        this.gnn = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
        this.gnl = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.gnl.loop(true);
        ap.a(this.gnl, R.raw.ala_live2);
        this.gnl.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                k.this.gnl.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                k.this.gnl.cancelAnimation();
            }
        });
        this.ffa = (TextView) view.findViewById(R.id.play_count);
        this.gnm = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.gno = view.findViewById(R.id.play_count_line);
        this.hon = (ForumEnterLayout) view.findViewById(R.id.card_forum_enter_button);
        this.gml = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_layout);
        this.hol = (ThreadCardBottomOpSegmentWeightLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.gml);
        b(this.hol);
        this.fxB.setOnClickListener(this);
        com.baidu.tbadk.a.b.a.h(view.findViewById(R.id.imageMask), R.color.transparent);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mDivider, R.color.cp_bg_line_b);
            g(tbPageContext, i);
            ap.setBackgroundResource(this.hqm, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.fxB, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.gnk, R.drawable.bg_ala_shape);
            int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
            ap.a(this.gnn, R.color.cp_other_d, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, 0.0f, 0.0f, dimens, dimens, 0.0f, 0.0f});
            ap.setBackgroundColor(this.gno, R.color.cp_cont_a);
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b);
            ap.setViewTextColor(this.ffa, R.color.cp_cont_a);
            ap.setViewTextColor(this.gnm, R.color.cp_cont_a);
            this.afw.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.feU.setPlaceHolder(3);
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
        this.afq = kVar;
        refreshView();
    }

    private void refreshView() {
        if (this.afq == 0 || ((com.baidu.tieba.card.data.k) this.afq).bcY() == null) {
            this.hqm.setVisibility(8);
            return;
        }
        this.hqm.setVisibility(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.ehG.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gnk.getLayoutParams();
            layoutParams.width = equipmentWidth - com.baidu.adp.lib.util.l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.gnk.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (((com.baidu.tieba.card.data.k) this.afq).bcY().bfS() != null && ((com.baidu.tieba.card.data.k) this.afq).bcY().bfS().isChushou) {
            this.gml.setShowFlag(10);
            this.gml.hideShareContainer();
        } else {
            this.gml.setShowFlag(11);
            this.gml.resetShareContainer();
        }
        this.afw.setVisibility(0);
        this.afw.setData(((com.baidu.tieba.card.data.k) this.afq).bcY());
        this.afw.setUserAfterClickListener(this.ajn);
        ((com.baidu.tieba.card.data.k) this.afq).bcY().bgw();
        this.mTextTitle.setText(new SpannableStringBuilder(((com.baidu.tieba.card.data.k) this.afq).bcY().bgi()));
        if (((com.baidu.tieba.card.data.k) this.afq).dXg.bfS().audience_count > 0) {
            this.gno.setVisibility(0);
            this.ffa.setVisibility(0);
            this.ffa.setText(String.format(this.ehG.getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(((com.baidu.tieba.card.data.k) this.afq).dXg.bfS().audience_count)));
        } else {
            this.gno.setVisibility(8);
            this.ffa.setVisibility(8);
        }
        this.gnm.setVisibility(8);
        if (((com.baidu.tieba.card.data.k) this.afq).dXg.bfS().openRecomReason == 1) {
            String str = ((com.baidu.tieba.card.data.k) this.afq).dXg.bfS().recomReason;
            if (!StringUtils.isNull(str)) {
                this.gnm.setVisibility(0);
                this.gnm.setText(str);
            } else {
                String bfN = ((com.baidu.tieba.card.data.k) this.afq).dXg.bfN();
                String bfO = ((com.baidu.tieba.card.data.k) this.afq).dXg.bfO();
                if (UtilHelper.isDecimal(bfN) && UtilHelper.isDecimal(bfO) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo drN = com.baidu.tieba.recapp.d.a.drI().drN();
                    String str2 = drN.latitude;
                    String str3 = drN.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && com.baidu.adp.lib.util.l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(bfN), Double.parseDouble(bfO)) <= 50.0d) {
                        this.gnm.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.gnm.setVisibility(0);
                    }
                }
            }
        }
        aO(this.hqm);
        onChangeSkinType(this.ehG, TbadkCoreApplication.getInst().getSkinType());
        if (m.Hx(((com.baidu.tieba.card.data.k) this.afq).dXg.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        bNe();
        this.gnl.playAnimation();
    }

    public void bNe() {
        if (com.baidu.tbadk.core.k.bcG().isShowImages() && this.afq != 0 && ((com.baidu.tieba.card.data.k) this.afq).bcY() != null && ((com.baidu.tieba.card.data.k) this.afq).bcY().bfS() != null) {
            this.feU.setPlaceHolder(3);
            this.feU.startLoad(((com.baidu.tieba.card.data.k) this.afq).bcY().bfS().cover, 10, false);
            this.gnk.setVisibility(0);
            return;
        }
        this.gnk.setVisibility(8);
    }

    public View ceS() {
        if (this.afw != null) {
            return this.afw.getAvatar();
        }
        return null;
    }

    public View ceT() {
        if (this.exp) {
            if (this.afw != null) {
                return this.afw.getUserName();
            }
            return null;
        }
        return this.mTextTitle;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fxB || view == this.gml.getCommentContainer() || view == this.hol.getCommentContainer()) {
            if (((com.baidu.tieba.card.data.k) this.afq).bcY().bfS() != null && ((com.baidu.tieba.card.data.k) this.afq).bcY().bfS().isChushou) {
                eq(((com.baidu.tieba.card.data.k) this.afq).bcY().bfS().thirdRoomId, ((com.baidu.tieba.card.data.k) this.afq).bcY().bfS().thirdLiveType);
            } else {
                cd(view);
            }
        }
    }

    private void eq(String str, String str2) {
        be.bkp().b(this.mTbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void cd(View view) {
        if (ceP() != null) {
            ceP().a(view, this.afq);
        }
        if (this.afq != 0 && ((com.baidu.tieba.card.data.k) this.afq).bcY() != null && ((com.baidu.tieba.card.data.k) this.afq).bcY().bfS() != null) {
            m.Hw(((com.baidu.tieba.card.data.k) this.afq).dXg.getId());
            m.a(this.mTextTitle, ((com.baidu.tieba.card.data.k) this.afq).dXg.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(((com.baidu.tieba.card.data.k) this.afq).bcY().bfS());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.ehG.getPageActivity(), alaLiveInfoCoreData, "home_rec_play", "", false, "")));
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gml != null && this.hqo != null) {
            setTag(bdUniqueId);
            q(bdUniqueId);
            if (this.afw != null) {
                this.afw.setPageUniqueId(bdUniqueId);
            }
            this.hqo.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hqo);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahc = str;
    }

    public void vT(int i) {
        if (this.gml != null) {
            this.gml.ewf = String.valueOf(i);
        }
    }

    public void ib(boolean z) {
        this.exp = z;
    }
}
