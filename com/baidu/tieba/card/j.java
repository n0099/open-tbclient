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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import tbclient.AppPosInfo;
/* loaded from: classes.dex */
public class j extends a<com.baidu.tieba.card.data.j> implements com.baidu.tieba.a.e {
    private CardUserInfoLayout agx;
    private String air;
    private View.OnClickListener akt;
    public TbImageView fRH;
    private TextView fRN;
    private View.OnClickListener fih;
    public boolean fjo;
    public LinearLayout gln;
    public RelativeLayout hjS;
    private TBLottieAnimationView hjT;
    private TextView hjU;
    private LinearLayout hjV;
    private View hjW;
    private FrameLayout iqM;
    private CustomMessageListener iqN;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.fjo = false;
        this.mLastScreenWidth = 0;
        this.akt = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.cqL() != null) {
                    j.this.cqL().a(view, j.this.agr);
                }
            }
        };
        this.fih = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.cqL() != null) {
                    j.this.cqL().a(view, j.this.agr);
                }
            }
        };
        this.iqN = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.j.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && j.this.agr != 0 && ((com.baidu.tieba.card.data.j) j.this.agr).eHK != null && ((com.baidu.tieba.card.data.j) j.this.agr).eHK.getTid() != null && j.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(((com.baidu.tieba.card.data.j) j.this.agr).eHK.getTid())) {
                    m.a(j.this.mTextTitle, ((com.baidu.tieba.card.data.j) j.this.agr).eHK.getId(), R.color.CAM_X0109, R.color.CAM_X0109);
                }
            }
        };
        this.eSJ = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init(getView());
    }

    private void init(View view) {
        this.iqM = (FrameLayout) view.findViewById(R.id.layout_root);
        this.gln = (LinearLayout) view.findViewById(R.id.content_layout);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gln.getLayoutParams();
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
        layoutParams.bottomMargin = 0;
        this.agx = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.agx.setPageContext(this.eSJ);
        this.agx.setPageUniqueId(this.mBdUniqueId);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.hjS = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.fRH = (TbImageView) view.findViewById(R.id.image_video);
        this.fRH.setDrawCorner(true);
        this.fRH.setPlaceHolder(3);
        this.fRH.setDefaultResource(0);
        this.fRH.setRadiusById(R.string.J_X05);
        TbImageView tbImageView = this.fRH;
        TbImageView tbImageView2 = this.fRH;
        tbImageView.setConrers(15);
        this.fRH.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fRH.setBorderColor(ao.getColor(R.color.CAM_X0401));
        this.fRH.setBorderSurroundContent(true);
        this.fRH.setDrawBorder(true);
        this.hjV = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
        this.hjT = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.hjT.loop(true);
        ao.a(this.hjT, R.raw.ala_live2);
        this.hjT.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.j.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                j.this.hjT.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                j.this.hjT.cancelAnimation();
            }
        });
        this.fRN = (TextView) view.findViewById(R.id.play_count);
        this.hjU = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.hjW = view.findViewById(R.id.play_count_line);
        this.ioN = (ForumEnterLayout) view.findViewById(R.id.card_forum_enter_button);
        this.hiT = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_layout);
        this.ioL = (ThreadCardBottomOpSegmentWeightLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.hiT);
        b(this.ioL);
        this.gln.setOnClickListener(this);
        com.baidu.tbadk.a.b.b.m(view.findViewById(R.id.imageMask), R.color.transparent);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            g(tbPageContext, i);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.gln).od(R.string.J_X06).aM(R.color.CAM_X0205, R.color.CAM_X0206);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.hjS).og(R.dimen.L_X01).of(R.color.CAM_X0401).od(R.string.J_X05).setBackGroundColor(R.color.CAM_X0611);
            int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31);
            ao.a(this.hjV, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, dimens, dimens, dimens, dimens, dimens, dimens});
            ao.setBackgroundColor(this.hjW, R.color.CAM_X0101);
            ao.setViewTextColor(this.mTextTitle, R.color.CAM_X0105);
            ao.setViewTextColor(this.fRN, R.color.CAM_X0101);
            ao.setViewTextColor(this.hjU, R.color.CAM_X0101);
            this.agx.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fRH.setPlaceHolder(3);
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
        this.agr = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.agr == 0 || ((com.baidu.tieba.card.data.j) this.agr).bkV() == null) {
            this.iqM.setVisibility(8);
            return;
        }
        this.iqM.setVisibility(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eSJ.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hjS.getLayoutParams();
            layoutParams.width = equipmentWidth - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.hjS.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        this.hiT.setShowFlag(11);
        this.hiT.resetShareContainer();
        this.agx.setVisibility(0);
        this.agx.setData(((com.baidu.tieba.card.data.j) this.agr).bkV());
        this.agx.setUserAfterClickListener(this.akt);
        if (((com.baidu.tieba.card.data.j) this.agr).bkV().bnQ() != null) {
            this.mTextTitle.setText(((com.baidu.tieba.card.data.j) this.agr).bkV().bnQ().friendRoomName);
        }
        if (((com.baidu.tieba.card.data.j) this.agr).eHK.bnQ().audience_count > 0) {
            this.hjW.setVisibility(0);
            this.fRN.setVisibility(0);
            this.fRN.setText(String.format(this.eSJ.getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(((com.baidu.tieba.card.data.j) this.agr).eHK.bnQ().audience_count)));
        } else {
            this.hjW.setVisibility(8);
            this.fRN.setVisibility(8);
        }
        this.hjU.setVisibility(8);
        if (((com.baidu.tieba.card.data.j) this.agr).eHK.bnQ().openRecomReason == 1) {
            String str = ((com.baidu.tieba.card.data.j) this.agr).eHK.bnQ().recomReason;
            if (!StringUtils.isNull(str)) {
                this.hjU.setVisibility(0);
                this.hjU.setText(str);
            } else {
                String latitude = ((com.baidu.tieba.card.data.j) this.agr).eHK.getLatitude();
                String bnM = ((com.baidu.tieba.card.data.j) this.agr).eHK.bnM();
                if (UtilHelper.isDecimal(latitude) && UtilHelper.isDecimal(bnM) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo dCb = com.baidu.tieba.recapp.c.a.dBW().dCb();
                    String str2 = dCb.latitude;
                    String str3 = dCb.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && com.baidu.adp.lib.util.l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(latitude), Double.parseDouble(bnM)) <= 50.0d) {
                        this.hjU.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.hjU.setVisibility(0);
                    }
                }
            }
        }
        ba(this.iqM);
        onChangeSkinType(this.eSJ, TbadkCoreApplication.getInst().getSkinType());
        if (m.Id(((com.baidu.tieba.card.data.j) this.agr).eHK.getId())) {
            ao.setViewTextColor(this.mTextTitle, R.color.CAM_X0109, 1);
        } else {
            ao.setViewTextColor(this.mTextTitle, R.color.CAM_X0105, 1);
        }
        bXU();
        this.hjT.playAnimation();
    }

    public void bXU() {
        if (com.baidu.tbadk.core.k.bkB().isShowImages() && this.agr != 0 && ((com.baidu.tieba.card.data.j) this.agr).bkV() != null && ((com.baidu.tieba.card.data.j) this.agr).bkV().bnQ() != null) {
            this.fRH.setPlaceHolder(3);
            this.fRH.startLoad(((com.baidu.tieba.card.data.j) this.agr).bkV().bnQ().cover, 10, false);
            this.hjS.setVisibility(0);
            return;
        }
        this.hjS.setVisibility(8);
    }

    public View cqO() {
        if (this.agx != null) {
            return this.agx.getAvatar();
        }
        return null;
    }

    public View cqP() {
        if (this.fjo) {
            if (this.agx != null) {
                return this.agx.getUserName();
            }
            return null;
        }
        return this.mTextTitle;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gln || view == this.hiT.getCommentContainer() || view == this.ioL.getCommentContainer()) {
            c(((com.baidu.tieba.card.data.j) this.agr).bkV().bnQ().live_id, ((com.baidu.tieba.card.data.j) this.agr).bkV().bnQ().roomId, this.fjo ? "home_concern_tab" : "home_rec_play");
            m.a(this.mTextTitle, ((com.baidu.tieba.card.data.j) this.agr).eHK.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            if (((com.baidu.tieba.card.data.j) this.agr).bkV() != null && ((com.baidu.tieba.card.data.j) this.agr).bkV().bnQ() != null) {
                aq aqVar = new aq("c14008");
                aqVar.an("obj_locate", this.fjo ? 2 : 1);
                aqVar.w("obj_param1", ((com.baidu.tieba.card.data.j) this.agr).bkV().bnQ().live_id);
                aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(aqVar);
            }
        }
    }

    private void c(long j, long j2, String str) {
        be.bsB().b(this.mTbPageContext, new String[]{"bdtiebalive://video/live?room_id=" + j2 + "&live_id=" + j + "&enterroom_type=1&from" + str});
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hiT != null && this.iqN != null) {
            setTag(bdUniqueId);
            q(bdUniqueId);
            if (this.agx != null) {
                this.agx.setPageUniqueId(bdUniqueId);
            }
            this.iqN.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iqN);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.air = str;
    }

    public void wQ(int i) {
        if (this.hiT != null) {
            this.hiT.fif = String.valueOf(i);
        }
    }

    public void jB(boolean z) {
        this.fjo = z;
    }
}
