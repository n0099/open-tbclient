package com.baidu.tieba.card;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.card.view.ForumEnterLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import tbclient.AppPosInfo;
/* loaded from: classes20.dex */
public class k extends a<com.baidu.tieba.card.data.j> implements com.baidu.tieba.a.e {
    private CardUserInfoLayout afT;
    private String ahw;
    private View.OnClickListener ajJ;
    private View.OnClickListener eVM;
    public boolean eWR;
    public TbImageView fEY;
    private TextView fFe;
    public LinearLayout fXC;
    private LinearLayout gTA;
    private View gTB;
    public RelativeLayout gTx;
    private TBLottieAnimationView gTy;
    private TextView gTz;
    private FrameLayout hXZ;
    private CustomMessageListener hYa;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.eWR = false;
        this.mLastScreenWidth = 0;
        this.ajJ = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.cnv() != null) {
                    k.this.cnv().a(view, k.this.afN);
                }
            }
        };
        this.eVM = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.cnv() != null) {
                    k.this.cnv().a(view, k.this.afN);
                }
            }
        };
        this.hYa = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.k.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && k.this.afN != 0 && ((com.baidu.tieba.card.data.j) k.this.afN).evQ != null && ((com.baidu.tieba.card.data.j) k.this.afN).evQ.getTid() != null && k.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(((com.baidu.tieba.card.data.j) k.this.afN).evQ.getTid())) {
                    n.a(k.this.mTextTitle, ((com.baidu.tieba.card.data.j) k.this.afN).evQ.getId(), R.color.CAM_X0109, R.color.CAM_X0109);
                }
            }
        };
        this.eGu = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init(getView());
    }

    private void init(View view) {
        this.hXZ = (FrameLayout) view.findViewById(R.id.layout_root);
        this.fXC = (LinearLayout) view.findViewById(R.id.content_layout);
        ot(com.baidu.tbadk.a.d.bhw());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fXC.getLayoutParams();
        if (com.baidu.tbadk.a.d.bhw()) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        } else {
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
            layoutParams.bottomMargin = 0;
        }
        this.afT = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.afT.setPageContext(this.eGu);
        this.afT.setPageUniqueId(this.mBdUniqueId);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gTx = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.fEY = (TbImageView) view.findViewById(R.id.image_video);
        this.fEY.setDrawCorner(true);
        this.fEY.setPlaceHolder(3);
        this.fEY.setDefaultResource(0);
        this.fEY.setDefaultErrorResource(0);
        this.fEY.setRadiusById(R.string.J_X05);
        TbImageView tbImageView = this.fEY;
        TbImageView tbImageView2 = this.fEY;
        tbImageView.setConrers(15);
        this.fEY.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fEY.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.fEY.setBorderSurroundContent(true);
        this.fEY.setDrawBorder(true);
        this.gTA = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
        this.gTy = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.gTy.loop(true);
        ap.a(this.gTy, R.raw.ala_live2);
        this.gTy.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                k.this.gTy.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                k.this.gTy.cancelAnimation();
            }
        });
        this.fFe = (TextView) view.findViewById(R.id.play_count);
        this.gTz = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.gTB = view.findViewById(R.id.play_count_line);
        this.hWa = (ForumEnterLayout) view.findViewById(R.id.card_forum_enter_button);
        this.gSy = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_layout);
        this.hVY = (ThreadCardBottomOpSegmentWeightLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.gSy);
        b(this.hVY);
        this.fXC.setOnClickListener(this);
        com.baidu.tbadk.a.b.a.j(view.findViewById(R.id.imageMask), R.color.transparent);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            g(tbPageContext, i);
            com.baidu.tbadk.core.elementsMaven.c.bj(this.fXC).pb(R.string.J_X06).aN(R.color.CAM_X0205, R.color.CAM_X0206);
            com.baidu.tbadk.core.elementsMaven.c.bj(this.gTx).pd(R.dimen.L_X01).pc(R.color.CAM_X0401).pb(R.string.J_X05).setBackGroundColor(R.color.CAM_X0611);
            int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31);
            ap.a(this.gTA, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, dimens, dimens, dimens, dimens, dimens, dimens});
            ap.setBackgroundColor(this.gTB, R.color.CAM_X0101);
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0105);
            ap.setViewTextColor(this.fFe, R.color.CAM_X0101);
            ap.setViewTextColor(this.gTz, R.color.CAM_X0101);
            this.afT.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fEY.setPlaceHolder(3);
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
        this.afN = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.afN == 0 || ((com.baidu.tieba.card.data.j) this.afN).bjd() == null) {
            this.hXZ.setVisibility(8);
            return;
        }
        this.hXZ.setVisibility(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eGu.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gTx.getLayoutParams();
            layoutParams.width = equipmentWidth - (com.baidu.tbadk.a.d.bhw() ? UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2 : (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.gTx.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        this.gSy.setShowFlag(11);
        this.gSy.resetShareContainer();
        this.afT.setVisibility(0);
        this.afT.setData(((com.baidu.tieba.card.data.j) this.afN).bjd());
        this.afT.setUserAfterClickListener(this.ajJ);
        if (((com.baidu.tieba.card.data.j) this.afN).bjd().blW() != null) {
            this.mTextTitle.setText(((com.baidu.tieba.card.data.j) this.afN).bjd().blW().friendRoomName);
        }
        if (((com.baidu.tieba.card.data.j) this.afN).evQ.blW().audience_count > 0) {
            this.gTB.setVisibility(0);
            this.fFe.setVisibility(0);
            this.fFe.setText(String.format(this.eGu.getResources().getString(R.string.ala_audience_count_prefix), au.numFormatOverWan(((com.baidu.tieba.card.data.j) this.afN).evQ.blW().audience_count)));
        } else {
            this.gTB.setVisibility(8);
            this.fFe.setVisibility(8);
        }
        this.gTz.setVisibility(8);
        if (((com.baidu.tieba.card.data.j) this.afN).evQ.blW().openRecomReason == 1) {
            String str = ((com.baidu.tieba.card.data.j) this.afN).evQ.blW().recomReason;
            if (!StringUtils.isNull(str)) {
                this.gTz.setVisibility(0);
                this.gTz.setText(str);
            } else {
                String blR = ((com.baidu.tieba.card.data.j) this.afN).evQ.blR();
                String blS = ((com.baidu.tieba.card.data.j) this.afN).evQ.blS();
                if (UtilHelper.isDecimal(blR) && UtilHelper.isDecimal(blS) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo dAL = com.baidu.tieba.recapp.d.a.dAG().dAL();
                    String str2 = dAL.latitude;
                    String str3 = dAL.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && com.baidu.adp.lib.util.l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(blR), Double.parseDouble(blS)) <= 50.0d) {
                        this.gTz.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.gTz.setVisibility(0);
                    }
                }
            }
        }
        aO(this.hXZ);
        onChangeSkinType(this.eGu, TbadkCoreApplication.getInst().getSkinType());
        if (n.IB(((com.baidu.tieba.card.data.j) this.afN).evQ.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0109, 1);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0105, 1);
        }
        bVt();
        this.gTy.playAnimation();
    }

    public void bVt() {
        if (com.baidu.tbadk.core.k.biL().isShowImages() && this.afN != 0 && ((com.baidu.tieba.card.data.j) this.afN).bjd() != null && ((com.baidu.tieba.card.data.j) this.afN).bjd().blW() != null) {
            this.fEY.setPlaceHolder(3);
            this.fEY.startLoad(((com.baidu.tieba.card.data.j) this.afN).bjd().blW().cover, 10, false);
            this.gTx.setVisibility(0);
            return;
        }
        this.gTx.setVisibility(8);
    }

    public View cny() {
        if (this.afT != null) {
            return this.afT.getAvatar();
        }
        return null;
    }

    public View cnz() {
        if (this.eWR) {
            if (this.afT != null) {
                return this.afT.getUserName();
            }
            return null;
        }
        return this.mTextTitle;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fXC || view == this.gSy.getCommentContainer() || view == this.hVY.getCommentContainer()) {
            y(((com.baidu.tieba.card.data.j) this.afN).bjd().blW().live_id, ((com.baidu.tieba.card.data.j) this.afN).bjd().blW().roomId);
            n.a(this.mTextTitle, ((com.baidu.tieba.card.data.j) this.afN).evQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            if (((com.baidu.tieba.card.data.j) this.afN).bjd() != null && ((com.baidu.tieba.card.data.j) this.afN).bjd().blW() != null) {
                ar arVar = new ar("c14008");
                arVar.ak("obj_locate", this.eWR ? 2 : 1);
                arVar.w("obj_param1", ((com.baidu.tieba.card.data.j) this.afN).bjd().blW().live_id);
                arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(arVar);
            }
        }
    }

    private void y(long j, long j2) {
        bf.bqF().b(this.mTbPageContext, new String[]{"bdtiebalive://video/live?room_id=" + j2 + "&live_id=" + j + "&enterroom_type=1"});
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gSy != null && this.hYa != null) {
            setTag(bdUniqueId);
            q(bdUniqueId);
            if (this.afT != null) {
                this.afT.setPageUniqueId(bdUniqueId);
            }
            this.hYa.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hYa);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahw = str;
    }

    public void xD(int i) {
        if (this.gSy != null) {
            this.gSy.eVK = String.valueOf(i);
        }
    }

    public void iU(boolean z) {
        this.eWR = z;
    }

    private void ot(boolean z) {
        if (z && this.fXC != null) {
            this.fXC.setPadding(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007), this.fXC.getPaddingTop(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007), this.fXC.getPaddingBottom());
        }
    }
}
