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
/* loaded from: classes21.dex */
public class k extends a<com.baidu.tieba.card.data.j> implements com.baidu.tieba.a.e {
    private CardUserInfoLayout agP;
    private String aiw;
    private View.OnClickListener akI;
    public TbImageView fMK;
    private TextView fMQ;
    private View.OnClickListener fdj;
    public boolean feo;
    public LinearLayout gfP;
    public RelativeLayout hcM;
    private TBLottieAnimationView hcN;
    private TextView hcO;
    private LinearLayout hcP;
    private View hcQ;
    private FrameLayout iiY;
    private CustomMessageListener iiZ;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.feo = false;
        this.mLastScreenWidth = 0;
        this.akI = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.crJ() != null) {
                    k.this.crJ().a(view, k.this.agJ);
                }
            }
        };
        this.fdj = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.crJ() != null) {
                    k.this.crJ().a(view, k.this.agJ);
                }
            }
        };
        this.iiZ = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.k.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && k.this.agJ != 0 && ((com.baidu.tieba.card.data.j) k.this.agJ).eCR != null && ((com.baidu.tieba.card.data.j) k.this.agJ).eCR.getTid() != null && k.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(((com.baidu.tieba.card.data.j) k.this.agJ).eCR.getTid())) {
                    n.a(k.this.mTextTitle, ((com.baidu.tieba.card.data.j) k.this.agJ).eCR.getId(), R.color.CAM_X0109, R.color.CAM_X0109);
                }
            }
        };
        this.eNx = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init(getView());
    }

    private void init(View view) {
        this.iiY = (FrameLayout) view.findViewById(R.id.layout_root);
        this.gfP = (LinearLayout) view.findViewById(R.id.content_layout);
        oP(com.baidu.tbadk.a.d.bkA());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gfP.getLayoutParams();
        if (com.baidu.tbadk.a.d.bkA()) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        } else {
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
            layoutParams.bottomMargin = 0;
        }
        this.agP = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.agP.setPageContext(this.eNx);
        this.agP.setPageUniqueId(this.mBdUniqueId);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.hcM = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.fMK = (TbImageView) view.findViewById(R.id.image_video);
        this.fMK.setDrawCorner(true);
        this.fMK.setPlaceHolder(3);
        this.fMK.setDefaultResource(0);
        this.fMK.setDefaultErrorResource(0);
        this.fMK.setRadiusById(R.string.J_X05);
        TbImageView tbImageView = this.fMK;
        TbImageView tbImageView2 = this.fMK;
        tbImageView.setConrers(15);
        this.fMK.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fMK.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.fMK.setBorderSurroundContent(true);
        this.fMK.setDrawBorder(true);
        this.hcP = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
        this.hcN = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.hcN.loop(true);
        ap.a(this.hcN, R.raw.ala_live2);
        this.hcN.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                k.this.hcN.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                k.this.hcN.cancelAnimation();
            }
        });
        this.fMQ = (TextView) view.findViewById(R.id.play_count);
        this.hcO = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.hcQ = view.findViewById(R.id.play_count_line);
        this.igZ = (ForumEnterLayout) view.findViewById(R.id.card_forum_enter_button);
        this.hbN = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_layout);
        this.igX = (ThreadCardBottomOpSegmentWeightLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.hbN);
        b(this.igX);
        this.gfP.setOnClickListener(this);
        com.baidu.tbadk.a.b.a.j(view.findViewById(R.id.imageMask), R.color.transparent);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            g(tbPageContext, i);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.gfP).pA(R.string.J_X06).aP(R.color.CAM_X0205, R.color.CAM_X0206);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.hcM).pD(R.dimen.L_X01).pC(R.color.CAM_X0401).pA(R.string.J_X05).setBackGroundColor(R.color.CAM_X0611);
            int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31);
            ap.a(this.hcP, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, dimens, dimens, dimens, dimens, dimens, dimens});
            ap.setBackgroundColor(this.hcQ, R.color.CAM_X0101);
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0105);
            ap.setViewTextColor(this.fMQ, R.color.CAM_X0101);
            ap.setViewTextColor(this.hcO, R.color.CAM_X0101);
            this.agP.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fMK.setPlaceHolder(3);
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
        this.agJ = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.agJ == 0 || ((com.baidu.tieba.card.data.j) this.agJ).bmn() == null) {
            this.iiY.setVisibility(8);
            return;
        }
        this.iiY.setVisibility(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eNx.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hcM.getLayoutParams();
            layoutParams.width = equipmentWidth - (com.baidu.tbadk.a.d.bkA() ? UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2 : (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.hcM.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        this.hbN.setShowFlag(11);
        this.hbN.resetShareContainer();
        this.agP.setVisibility(0);
        this.agP.setData(((com.baidu.tieba.card.data.j) this.agJ).bmn());
        this.agP.setUserAfterClickListener(this.akI);
        if (((com.baidu.tieba.card.data.j) this.agJ).bmn().bpj() != null) {
            this.mTextTitle.setText(((com.baidu.tieba.card.data.j) this.agJ).bmn().bpj().friendRoomName);
        }
        if (((com.baidu.tieba.card.data.j) this.agJ).eCR.bpj().audience_count > 0) {
            this.hcQ.setVisibility(0);
            this.fMQ.setVisibility(0);
            this.fMQ.setText(String.format(this.eNx.getResources().getString(R.string.ala_audience_count_prefix), au.numFormatOverWan(((com.baidu.tieba.card.data.j) this.agJ).eCR.bpj().audience_count)));
        } else {
            this.hcQ.setVisibility(8);
            this.fMQ.setVisibility(8);
        }
        this.hcO.setVisibility(8);
        if (((com.baidu.tieba.card.data.j) this.agJ).eCR.bpj().openRecomReason == 1) {
            String str = ((com.baidu.tieba.card.data.j) this.agJ).eCR.bpj().recomReason;
            if (!StringUtils.isNull(str)) {
                this.hcO.setVisibility(0);
                this.hcO.setText(str);
            } else {
                String bpe = ((com.baidu.tieba.card.data.j) this.agJ).eCR.bpe();
                String bpf = ((com.baidu.tieba.card.data.j) this.agJ).eCR.bpf();
                if (UtilHelper.isDecimal(bpe) && UtilHelper.isDecimal(bpf) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo dGd = com.baidu.tieba.recapp.d.a.dFY().dGd();
                    String str2 = dGd.latitude;
                    String str3 = dGd.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && com.baidu.adp.lib.util.l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(bpe), Double.parseDouble(bpf)) <= 50.0d) {
                        this.hcO.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.hcO.setVisibility(0);
                    }
                }
            }
        }
        aO(this.iiY);
        onChangeSkinType(this.eNx, TbadkCoreApplication.getInst().getSkinType());
        if (n.Jr(((com.baidu.tieba.card.data.j) this.agJ).eCR.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0109, 1);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0105, 1);
        }
        bZe();
        this.hcN.playAnimation();
    }

    public void bZe() {
        if (com.baidu.tbadk.core.k.blV().isShowImages() && this.agJ != 0 && ((com.baidu.tieba.card.data.j) this.agJ).bmn() != null && ((com.baidu.tieba.card.data.j) this.agJ).bmn().bpj() != null) {
            this.fMK.setPlaceHolder(3);
            this.fMK.startLoad(((com.baidu.tieba.card.data.j) this.agJ).bmn().bpj().cover, 10, false);
            this.hcM.setVisibility(0);
            return;
        }
        this.hcM.setVisibility(8);
    }

    public View crM() {
        if (this.agP != null) {
            return this.agP.getAvatar();
        }
        return null;
    }

    public View crN() {
        if (this.feo) {
            if (this.agP != null) {
                return this.agP.getUserName();
            }
            return null;
        }
        return this.mTextTitle;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gfP || view == this.hbN.getCommentContainer() || view == this.igX.getCommentContainer()) {
            c(((com.baidu.tieba.card.data.j) this.agJ).bmn().bpj().live_id, ((com.baidu.tieba.card.data.j) this.agJ).bmn().bpj().roomId, this.feo ? "home_concern_tab" : "home_rec_play");
            n.a(this.mTextTitle, ((com.baidu.tieba.card.data.j) this.agJ).eCR.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            if (((com.baidu.tieba.card.data.j) this.agJ).bmn() != null && ((com.baidu.tieba.card.data.j) this.agJ).bmn().bpj() != null) {
                ar arVar = new ar("c14008");
                arVar.al("obj_locate", this.feo ? 2 : 1);
                arVar.w("obj_param1", ((com.baidu.tieba.card.data.j) this.agJ).bmn().bpj().live_id);
                arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(arVar);
            }
        }
    }

    private void c(long j, long j2, String str) {
        bf.bua().b(this.mTbPageContext, new String[]{"bdtiebalive://video/live?room_id=" + j2 + "&live_id=" + j + "&enterroom_type=1&from" + str});
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hbN != null && this.iiZ != null) {
            setTag(bdUniqueId);
            q(bdUniqueId);
            if (this.agP != null) {
                this.agP.setPageUniqueId(bdUniqueId);
            }
            this.iiZ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iiZ);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aiw = str;
    }

    public void yj(int i) {
        if (this.hbN != null) {
            this.hbN.fdh = String.valueOf(i);
        }
    }

    public void jj(boolean z) {
        this.feo = z;
    }

    private void oP(boolean z) {
        if (z && this.gfP != null) {
            this.gfP.setPadding(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007), this.gfP.getPaddingTop(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007), this.gfP.getPaddingBottom());
        }
    }
}
