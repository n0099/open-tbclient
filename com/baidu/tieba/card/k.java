package com.baidu.tieba.card;

import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import tbclient.AppPosInfo;
/* loaded from: classes.dex */
public class k extends a<com.baidu.tieba.card.data.j> implements com.baidu.tieba.a.e {
    private static final int alG = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds2);
    private CardUserInfoLayout ahH;
    private String ajx;
    private View.OnClickListener alB;
    private TextView fVC;
    public TbImageView fVw;
    private View.OnClickListener flY;
    public boolean fnf;
    public LinearLayout gpQ;
    public RelativeLayout hqd;
    private TBLottieAnimationView hqe;
    private TextView hqf;
    private LinearLayout hqg;
    private View hqh;
    private LinearLayout hqj;
    private TextView hqk;
    private ImageView hql;
    private FrameLayout iyn;
    private CustomMessageListener iyo;
    private View.OnClickListener iyq;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.fnf = false;
        this.mLastScreenWidth = 0;
        this.iyq = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        };
        this.alB = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.csi() != null) {
                    k.this.csi().a(view, k.this.ahB);
                }
            }
        };
        this.flY = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.csi() != null) {
                    k.this.csi().a(view, k.this.ahB);
                }
            }
        };
        this.iyo = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.k.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && k.this.ahB != 0 && ((com.baidu.tieba.card.data.j) k.this.ahB).eLr != null && ((com.baidu.tieba.card.data.j) k.this.ahB).eLr.getTid() != null && k.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(((com.baidu.tieba.card.data.j) k.this.ahB).eLr.getTid())) {
                    m.a(k.this.mTextTitle, ((com.baidu.tieba.card.data.j) k.this.ahB).eLr.getId(), R.color.CAM_X0109, R.color.CAM_X0109);
                }
            }
        };
        this.eWx = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init(getView());
    }

    private void init(View view) {
        this.iyn = (FrameLayout) view.findViewById(R.id.layout_root);
        this.gpQ = (LinearLayout) view.findViewById(R.id.content_layout);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gpQ.getLayoutParams();
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
        layoutParams.bottomMargin = 0;
        this.ahH = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.ahH.setPageContext(this.eWx);
        this.ahH.setPageUniqueId(this.mBdUniqueId);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.hqd = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.fVw = (TbImageView) view.findViewById(R.id.image_video);
        this.fVw.setDrawCorner(true);
        this.fVw.setPlaceHolder(3);
        this.fVw.setDefaultResource(0);
        this.fVw.setRadiusById(R.string.J_X05);
        TbImageView tbImageView = this.fVw;
        TbImageView tbImageView2 = this.fVw;
        tbImageView.setConrers(15);
        this.fVw.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fVw.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.fVw.setBorderSurroundContent(true);
        this.fVw.setDrawBorder(true);
        this.hqg = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
        this.hqe = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.hqe.loop(true);
        ap.a(this.hqe, R.raw.ala_live2);
        this.hqe.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                k.this.hqe.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                k.this.hqe.cancelAnimation();
            }
        });
        this.fVC = (TextView) view.findViewById(R.id.play_count);
        this.hqf = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.hqh = view.findViewById(R.id.play_count_line);
        this.iwo = (ForumEnterLayout) view.findViewById(R.id.card_forum_enter_button);
        this.hpe = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_layout);
        this.iwm = (ThreadCardBottomOpSegmentWeightLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.hpe);
        b(this.iwm);
        this.gpQ.setOnClickListener(this);
        this.hqj = (LinearLayout) view.findViewById(R.id.forum_friends_now_looking);
        this.hqk = (TextView) view.findViewById(R.id.tv_forum_friends_now_looking);
        this.hql = (ImageView) view.findViewById(R.id.image_forum_friends_now_looking);
        this.hqj.setOnClickListener(this);
        com.baidu.tbadk.a.b.b.m(view.findViewById(R.id.imageMask), R.color.transparent);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            g(tbPageContext, i);
            com.baidu.tbadk.core.elementsMaven.c.br(this.gpQ).oh(R.string.J_X06).aJ(R.color.CAM_X0205, R.color.CAM_X0206);
            com.baidu.tbadk.core.elementsMaven.c.br(this.hqd).ol(R.dimen.L_X01).ok(R.color.CAM_X0401).oh(R.string.J_X05).setBackGroundColor(R.color.CAM_X0611);
            int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31);
            ap.a(this.hqg, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, dimens, dimens, dimens, dimens, dimens, dimens});
            ap.setBackgroundColor(this.hqh, R.color.CAM_X0101);
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0105);
            ap.setViewTextColor(this.fVC, R.color.CAM_X0101);
            ap.setViewTextColor(this.hqf, R.color.CAM_X0101);
            com.baidu.tbadk.core.util.f.a.bty().oP(0).oY(1).aj(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31)).oV(R.color.CAM_X0304).oX(alG).bv(this.hqj);
            ap.setViewTextColor(this.hqk, R.color.CAM_X0304);
            WebPManager.a(this.hql, R.drawable.icon_ala_watching, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.ahH.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fVw.setPlaceHolder(3);
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
        this.ahB = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.ahB == 0 || ((com.baidu.tieba.card.data.j) this.ahB).blp() == null) {
            this.iyn.setVisibility(8);
            return;
        }
        this.iyn.setVisibility(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eWx.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hqd.getLayoutParams();
            layoutParams.width = equipmentWidth - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.hqd.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (((com.baidu.tieba.card.data.j) this.ahB).blp().bol() != null && ((com.baidu.tieba.card.data.j) this.ahB).blp().bol().isChushou) {
            this.hpe.setShowFlag(10);
            this.hpe.hideShareContainer();
        } else {
            this.hpe.setShowFlag(11);
            this.hpe.resetShareContainer();
        }
        this.ahH.setVisibility(0);
        this.ahH.setData(((com.baidu.tieba.card.data.j) this.ahB).blp());
        this.ahH.setUserAfterClickListener(this.alB);
        ((com.baidu.tieba.card.data.j) this.ahB).blp().boR();
        this.mTextTitle.setText(new SpannableStringBuilder(((com.baidu.tieba.card.data.j) this.ahB).blp().boB()));
        if (((com.baidu.tieba.card.data.j) this.ahB).eLr.bol().audience_count > 0) {
            this.hqh.setVisibility(0);
            this.fVC.setVisibility(0);
            this.fVC.setText(String.format(this.eWx.getResources().getString(R.string.ala_audience_count_prefix), au.numFormatOverWan(((com.baidu.tieba.card.data.j) this.ahB).eLr.bol().audience_count)));
        } else {
            this.hqh.setVisibility(8);
            this.fVC.setVisibility(8);
        }
        this.hqf.setVisibility(8);
        if (((com.baidu.tieba.card.data.j) this.ahB).eLr.bol().openRecomReason == 1) {
            String str = ((com.baidu.tieba.card.data.j) this.ahB).eLr.bol().recomReason;
            if (!StringUtils.isNull(str)) {
                this.hqf.setVisibility(0);
                this.hqf.setText(str);
            } else {
                String latitude = ((com.baidu.tieba.card.data.j) this.ahB).eLr.getLatitude();
                String boh = ((com.baidu.tieba.card.data.j) this.ahB).eLr.boh();
                if (UtilHelper.isDecimal(latitude) && UtilHelper.isDecimal(boh) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo dEz = com.baidu.tieba.recapp.c.a.dEu().dEz();
                    String str2 = dEz.latitude;
                    String str3 = dEz.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && com.baidu.adp.lib.util.l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(latitude), Double.parseDouble(boh)) <= 50.0d) {
                        this.hqf.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.hqf.setVisibility(0);
                    }
                }
            }
        }
        if (((com.baidu.tieba.card.data.j) this.ahB).eLr.bol() != null && !StringUtils.isNull(((com.baidu.tieba.card.data.j) this.ahB).eLr.bol().forumUserLiveMsg)) {
            this.hqj.setVisibility(0);
            this.hqk.setText(au.cutChineseAndEnglishWithSuffix(((com.baidu.tieba.card.data.j) this.ahB).eLr.bol().forumUserLiveMsg, 10, StringHelper.STRING_MORE) + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_forum_live_suffix));
        } else {
            this.hqj.setVisibility(8);
        }
        ba(this.iyn);
        onChangeSkinType(this.eWx, TbadkCoreApplication.getInst().getSkinType());
        if (m.IX(((com.baidu.tieba.card.data.j) this.ahB).eLr.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0109, 1);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0105, 1);
        }
        bZf();
        this.hqe.playAnimation();
    }

    public void bZf() {
        if (com.baidu.tbadk.core.k.bkV().isShowImages() && this.ahB != 0 && ((com.baidu.tieba.card.data.j) this.ahB).blp() != null && ((com.baidu.tieba.card.data.j) this.ahB).blp().bol() != null) {
            this.fVw.setPlaceHolder(3);
            this.fVw.startLoad(((com.baidu.tieba.card.data.j) this.ahB).blp().bol().cover, 10, false);
            this.hqd.setVisibility(0);
            return;
        }
        this.hqd.setVisibility(8);
    }

    public View csl() {
        if (this.ahH != null) {
            return this.ahH.getAvatar();
        }
        return null;
    }

    public View csm() {
        if (this.fnf) {
            if (this.ahH != null) {
                return this.ahH.getUserName();
            }
            return null;
        }
        return this.mTextTitle;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gpQ || view == this.hpe.getCommentContainer() || view == this.iwm.getCommentContainer() || view == this.hqj) {
            if (((com.baidu.tieba.card.data.j) this.ahB).blp().bol() != null && ((com.baidu.tieba.card.data.j) this.ahB).blp().bol().isChushou) {
                eI(((com.baidu.tieba.card.data.j) this.ahB).blp().bol().thirdRoomId, ((com.baidu.tieba.card.data.j) this.ahB).blp().bol().thirdLiveType);
            } else {
                cJ(view);
            }
        }
    }

    private void eI(String str, String str2) {
        bf.bsY().b(this.mTbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void cJ(View view) {
        if (csi() != null) {
            csi().a(view, this.ahB);
        }
        if (this.ahB != 0 && ((com.baidu.tieba.card.data.j) this.ahB).blp() != null && ((com.baidu.tieba.card.data.j) this.ahB).blp().bol() != null) {
            m.IW(((com.baidu.tieba.card.data.j) this.ahB).eLr.getId());
            m.a(this.mTextTitle, ((com.baidu.tieba.card.data.j) this.ahB).eLr.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(((com.baidu.tieba.card.data.j) this.ahB).blp().bol());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.eWx.getPageActivity(), alaLiveInfoCoreData, "home_rec_play", "", false, "")));
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hpe != null && this.iyo != null) {
            setTag(bdUniqueId);
            q(bdUniqueId);
            if (this.ahH != null) {
                this.ahH.setPageUniqueId(bdUniqueId);
            }
            this.iyo.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iyo);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ajx = str;
    }

    public void xb(int i) {
        if (this.hpe != null) {
            this.hpe.flW = String.valueOf(i);
        }
    }

    public void jD(boolean z) {
        this.fnf = z;
    }
}
