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
    private CardUserInfoLayout aho;
    private String aji;
    private View.OnClickListener alk;
    public TbImageView fWo;
    private TextView fWu;
    private View.OnClickListener fmS;
    public boolean fnX;
    public LinearLayout gpU;
    private TBLottieAnimationView hoA;
    private TextView hoB;
    private LinearLayout hoC;
    private View hoD;
    public RelativeLayout hoz;
    private FrameLayout ivt;
    private CustomMessageListener ivu;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.fnX = false;
        this.mLastScreenWidth = 0;
        this.alk = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.cuC() != null) {
                    j.this.cuC().a(view, j.this.ahi);
                }
            }
        };
        this.fmS = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.cuC() != null) {
                    j.this.cuC().a(view, j.this.ahi);
                }
            }
        };
        this.ivu = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.j.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && j.this.ahi != 0 && ((com.baidu.tieba.card.data.j) j.this.ahi).eMv != null && ((com.baidu.tieba.card.data.j) j.this.ahi).eMv.getTid() != null && j.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(((com.baidu.tieba.card.data.j) j.this.ahi).eMv.getTid())) {
                    m.a(j.this.mTextTitle, ((com.baidu.tieba.card.data.j) j.this.ahi).eMv.getId(), R.color.CAM_X0109, R.color.CAM_X0109);
                }
            }
        };
        this.eXu = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init(getView());
    }

    private void init(View view) {
        this.ivt = (FrameLayout) view.findViewById(R.id.layout_root);
        this.gpU = (LinearLayout) view.findViewById(R.id.content_layout);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gpU.getLayoutParams();
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
        layoutParams.bottomMargin = 0;
        this.aho = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.aho.setPageContext(this.eXu);
        this.aho.setPageUniqueId(this.mBdUniqueId);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.hoz = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.fWo = (TbImageView) view.findViewById(R.id.image_video);
        this.fWo.setDrawCorner(true);
        this.fWo.setPlaceHolder(3);
        this.fWo.setDefaultResource(0);
        this.fWo.setRadiusById(R.string.J_X05);
        TbImageView tbImageView = this.fWo;
        TbImageView tbImageView2 = this.fWo;
        tbImageView.setConrers(15);
        this.fWo.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fWo.setBorderColor(ao.getColor(R.color.CAM_X0401));
        this.fWo.setBorderSurroundContent(true);
        this.fWo.setDrawBorder(true);
        this.hoC = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
        this.hoA = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.hoA.loop(true);
        ao.a(this.hoA, R.raw.ala_live2);
        this.hoA.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.j.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                j.this.hoA.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                j.this.hoA.cancelAnimation();
            }
        });
        this.fWu = (TextView) view.findViewById(R.id.play_count);
        this.hoB = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.hoD = view.findViewById(R.id.play_count_line);
        this.itu = (ForumEnterLayout) view.findViewById(R.id.card_forum_enter_button);
        this.hnz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_layout);
        this.its = (ThreadCardBottomOpSegmentWeightLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.hnz);
        b(this.its);
        this.gpU.setOnClickListener(this);
        com.baidu.tbadk.a.b.b.m(view.findViewById(R.id.imageMask), R.color.transparent);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            g(tbPageContext, i);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.gpU).pK(R.string.J_X06).aM(R.color.CAM_X0205, R.color.CAM_X0206);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.hoz).pN(R.dimen.L_X01).pM(R.color.CAM_X0401).pK(R.string.J_X05).setBackGroundColor(R.color.CAM_X0611);
            int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31);
            ao.a(this.hoC, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, dimens, dimens, dimens, dimens, dimens, dimens});
            ao.setBackgroundColor(this.hoD, R.color.CAM_X0101);
            ao.setViewTextColor(this.mTextTitle, R.color.CAM_X0105);
            ao.setViewTextColor(this.fWu, R.color.CAM_X0101);
            ao.setViewTextColor(this.hoB, R.color.CAM_X0101);
            this.aho.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fWo.setPlaceHolder(3);
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
        this.ahi = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.ahi == 0 || ((com.baidu.tieba.card.data.j) this.ahi).boO() == null) {
            this.ivt.setVisibility(8);
            return;
        }
        this.ivt.setVisibility(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eXu.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hoz.getLayoutParams();
            layoutParams.width = equipmentWidth - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.hoz.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        this.hnz.setShowFlag(11);
        this.hnz.resetShareContainer();
        this.aho.setVisibility(0);
        this.aho.setData(((com.baidu.tieba.card.data.j) this.ahi).boO());
        this.aho.setUserAfterClickListener(this.alk);
        if (((com.baidu.tieba.card.data.j) this.ahi).boO().brJ() != null) {
            this.mTextTitle.setText(((com.baidu.tieba.card.data.j) this.ahi).boO().brJ().friendRoomName);
        }
        if (((com.baidu.tieba.card.data.j) this.ahi).eMv.brJ().audience_count > 0) {
            this.hoD.setVisibility(0);
            this.fWu.setVisibility(0);
            this.fWu.setText(String.format(this.eXu.getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(((com.baidu.tieba.card.data.j) this.ahi).eMv.brJ().audience_count)));
        } else {
            this.hoD.setVisibility(8);
            this.fWu.setVisibility(8);
        }
        this.hoB.setVisibility(8);
        if (((com.baidu.tieba.card.data.j) this.ahi).eMv.brJ().openRecomReason == 1) {
            String str = ((com.baidu.tieba.card.data.j) this.ahi).eMv.brJ().recomReason;
            if (!StringUtils.isNull(str)) {
                this.hoB.setVisibility(0);
                this.hoB.setText(str);
            } else {
                String latitude = ((com.baidu.tieba.card.data.j) this.ahi).eMv.getLatitude();
                String brF = ((com.baidu.tieba.card.data.j) this.ahi).eMv.brF();
                if (UtilHelper.isDecimal(latitude) && UtilHelper.isDecimal(brF) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo dFS = com.baidu.tieba.recapp.c.a.dFN().dFS();
                    String str2 = dFS.latitude;
                    String str3 = dFS.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && com.baidu.adp.lib.util.l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(latitude), Double.parseDouble(brF)) <= 50.0d) {
                        this.hoB.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.hoB.setVisibility(0);
                    }
                }
            }
        }
        ba(this.ivt);
        onChangeSkinType(this.eXu, TbadkCoreApplication.getInst().getSkinType());
        if (m.Jp(((com.baidu.tieba.card.data.j) this.ahi).eMv.getId())) {
            ao.setViewTextColor(this.mTextTitle, R.color.CAM_X0109, 1);
        } else {
            ao.setViewTextColor(this.mTextTitle, R.color.CAM_X0105, 1);
        }
        cbL();
        this.hoA.playAnimation();
    }

    public void cbL() {
        if (com.baidu.tbadk.core.k.bou().isShowImages() && this.ahi != 0 && ((com.baidu.tieba.card.data.j) this.ahi).boO() != null && ((com.baidu.tieba.card.data.j) this.ahi).boO().brJ() != null) {
            this.fWo.setPlaceHolder(3);
            this.fWo.startLoad(((com.baidu.tieba.card.data.j) this.ahi).boO().brJ().cover, 10, false);
            this.hoz.setVisibility(0);
            return;
        }
        this.hoz.setVisibility(8);
    }

    public View cuF() {
        if (this.aho != null) {
            return this.aho.getAvatar();
        }
        return null;
    }

    public View cuG() {
        if (this.fnX) {
            if (this.aho != null) {
                return this.aho.getUserName();
            }
            return null;
        }
        return this.mTextTitle;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gpU || view == this.hnz.getCommentContainer() || view == this.its.getCommentContainer()) {
            c(((com.baidu.tieba.card.data.j) this.ahi).boO().brJ().live_id, ((com.baidu.tieba.card.data.j) this.ahi).boO().brJ().roomId, this.fnX ? "home_concern_tab" : "home_rec_play");
            m.a(this.mTextTitle, ((com.baidu.tieba.card.data.j) this.ahi).eMv.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            if (((com.baidu.tieba.card.data.j) this.ahi).boO() != null && ((com.baidu.tieba.card.data.j) this.ahi).boO().brJ() != null) {
                aq aqVar = new aq("c14008");
                aqVar.an("obj_locate", this.fnX ? 2 : 1);
                aqVar.w("obj_param1", ((com.baidu.tieba.card.data.j) this.ahi).boO().brJ().live_id);
                aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(aqVar);
            }
        }
    }

    private void c(long j, long j2, String str) {
        be.bwu().b(this.mTbPageContext, new String[]{"bdtiebalive://video/live?room_id=" + j2 + "&live_id=" + j + "&enterroom_type=1&from" + str});
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hnz != null && this.ivu != null) {
            setTag(bdUniqueId);
            q(bdUniqueId);
            if (this.aho != null) {
                this.aho.setPageUniqueId(bdUniqueId);
            }
            this.ivu.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ivu);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aji = str;
    }

    public void yx(int i) {
        if (this.hnz != null) {
            this.hnz.fmQ = String.valueOf(i);
        }
    }

    public void jF(boolean z) {
        this.fnX = z;
    }
}
