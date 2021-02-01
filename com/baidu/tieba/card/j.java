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
/* loaded from: classes.dex */
public class j extends a<com.baidu.tieba.card.data.j> implements com.baidu.tieba.a.e {
    private CardUserInfoLayout agp;
    private String aif;
    private View.OnClickListener aki;
    public TbImageView fTW;
    private TextView fUc;
    private View.OnClickListener fkz;
    public boolean flF;
    public LinearLayout gnT;
    public RelativeLayout hof;
    private TBLottieAnimationView hog;
    private TextView hoh;
    private LinearLayout hoi;
    private View hoj;
    private FrameLayout iwq;
    private CustomMessageListener iwr;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.flF = false;
        this.mLastScreenWidth = 0;
        this.aki = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.crV() != null) {
                    j.this.crV().a(view, j.this.agj);
                }
            }
        };
        this.fkz = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.crV() != null) {
                    j.this.crV().a(view, j.this.agj);
                }
            }
        };
        this.iwr = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.j.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && j.this.agj != 0 && ((com.baidu.tieba.card.data.j) j.this.agj).eJQ != null && ((com.baidu.tieba.card.data.j) j.this.agj).eJQ.getTid() != null && j.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(((com.baidu.tieba.card.data.j) j.this.agj).eJQ.getTid())) {
                    m.a(j.this.mTextTitle, ((com.baidu.tieba.card.data.j) j.this.agj).eJQ.getId(), R.color.CAM_X0109, R.color.CAM_X0109);
                }
            }
        };
        this.eUY = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init(getView());
    }

    private void init(View view) {
        this.iwq = (FrameLayout) view.findViewById(R.id.layout_root);
        this.gnT = (LinearLayout) view.findViewById(R.id.content_layout);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gnT.getLayoutParams();
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
        layoutParams.bottomMargin = 0;
        this.agp = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.agp.setPageContext(this.eUY);
        this.agp.setPageUniqueId(this.mBdUniqueId);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.hof = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.fTW = (TbImageView) view.findViewById(R.id.image_video);
        this.fTW.setDrawCorner(true);
        this.fTW.setPlaceHolder(3);
        this.fTW.setDefaultResource(0);
        this.fTW.setRadiusById(R.string.J_X05);
        TbImageView tbImageView = this.fTW;
        TbImageView tbImageView2 = this.fTW;
        tbImageView.setConrers(15);
        this.fTW.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fTW.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.fTW.setBorderSurroundContent(true);
        this.fTW.setDrawBorder(true);
        this.hoi = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
        this.hog = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.hog.loop(true);
        ap.a(this.hog, R.raw.ala_live2);
        this.hog.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.j.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                j.this.hog.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                j.this.hog.cancelAnimation();
            }
        });
        this.fUc = (TextView) view.findViewById(R.id.play_count);
        this.hoh = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.hoj = view.findViewById(R.id.play_count_line);
        this.iur = (ForumEnterLayout) view.findViewById(R.id.card_forum_enter_button);
        this.hng = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_layout);
        this.iup = (ThreadCardBottomOpSegmentWeightLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.hng);
        b(this.iup);
        this.gnT.setOnClickListener(this);
        com.baidu.tbadk.a.b.b.m(view.findViewById(R.id.imageMask), R.color.transparent);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            g(tbPageContext, i);
            com.baidu.tbadk.core.elementsMaven.c.br(this.gnT).og(R.string.J_X06).aJ(R.color.CAM_X0205, R.color.CAM_X0206);
            com.baidu.tbadk.core.elementsMaven.c.br(this.hof).ok(R.dimen.L_X01).oj(R.color.CAM_X0401).og(R.string.J_X05).setBackGroundColor(R.color.CAM_X0611);
            int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31);
            ap.a(this.hoi, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, dimens, dimens, dimens, dimens, dimens, dimens});
            ap.setBackgroundColor(this.hoj, R.color.CAM_X0101);
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0105);
            ap.setViewTextColor(this.fUc, R.color.CAM_X0101);
            ap.setViewTextColor(this.hoh, R.color.CAM_X0101);
            this.agp.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fTW.setPlaceHolder(3);
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
        this.agj = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.agj == 0 || ((com.baidu.tieba.card.data.j) this.agj).bln() == null) {
            this.iwq.setVisibility(8);
            return;
        }
        this.iwq.setVisibility(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eUY.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hof.getLayoutParams();
            layoutParams.width = equipmentWidth - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.hof.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        this.hng.setShowFlag(11);
        this.hng.resetShareContainer();
        this.agp.setVisibility(0);
        this.agp.setData(((com.baidu.tieba.card.data.j) this.agj).bln());
        this.agp.setUserAfterClickListener(this.aki);
        if (((com.baidu.tieba.card.data.j) this.agj).bln().boj() != null) {
            this.mTextTitle.setText(((com.baidu.tieba.card.data.j) this.agj).bln().boj().friendRoomName);
        }
        if (((com.baidu.tieba.card.data.j) this.agj).eJQ.boj().audience_count > 0) {
            this.hoj.setVisibility(0);
            this.fUc.setVisibility(0);
            this.fUc.setText(String.format(this.eUY.getResources().getString(R.string.ala_audience_count_prefix), au.numFormatOverWan(((com.baidu.tieba.card.data.j) this.agj).eJQ.boj().audience_count)));
        } else {
            this.hoj.setVisibility(8);
            this.fUc.setVisibility(8);
        }
        this.hoh.setVisibility(8);
        if (((com.baidu.tieba.card.data.j) this.agj).eJQ.boj().openRecomReason == 1) {
            String str = ((com.baidu.tieba.card.data.j) this.agj).eJQ.boj().recomReason;
            if (!StringUtils.isNull(str)) {
                this.hoh.setVisibility(0);
                this.hoh.setText(str);
            } else {
                String latitude = ((com.baidu.tieba.card.data.j) this.agj).eJQ.getLatitude();
                String bof = ((com.baidu.tieba.card.data.j) this.agj).eJQ.bof();
                if (UtilHelper.isDecimal(latitude) && UtilHelper.isDecimal(bof) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo dEj = com.baidu.tieba.recapp.c.a.dEe().dEj();
                    String str2 = dEj.latitude;
                    String str3 = dEj.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && com.baidu.adp.lib.util.l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(latitude), Double.parseDouble(bof)) <= 50.0d) {
                        this.hoh.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.hoh.setVisibility(0);
                    }
                }
            }
        }
        ba(this.iwq);
        onChangeSkinType(this.eUY, TbadkCoreApplication.getInst().getSkinType());
        if (m.IN(((com.baidu.tieba.card.data.j) this.agj).eJQ.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0109, 1);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0105, 1);
        }
        bYS();
        this.hog.playAnimation();
    }

    public void bYS() {
        if (com.baidu.tbadk.core.k.bkT().isShowImages() && this.agj != 0 && ((com.baidu.tieba.card.data.j) this.agj).bln() != null && ((com.baidu.tieba.card.data.j) this.agj).bln().boj() != null) {
            this.fTW.setPlaceHolder(3);
            this.fTW.startLoad(((com.baidu.tieba.card.data.j) this.agj).bln().boj().cover, 10, false);
            this.hof.setVisibility(0);
            return;
        }
        this.hof.setVisibility(8);
    }

    public View crY() {
        if (this.agp != null) {
            return this.agp.getAvatar();
        }
        return null;
    }

    public View crZ() {
        if (this.flF) {
            if (this.agp != null) {
                return this.agp.getUserName();
            }
            return null;
        }
        return this.mTextTitle;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gnT || view == this.hng.getCommentContainer() || view == this.iup.getCommentContainer()) {
            d(((com.baidu.tieba.card.data.j) this.agj).bln().boj().live_id, ((com.baidu.tieba.card.data.j) this.agj).bln().boj().roomId, this.flF ? "home_concern_tab" : "home_rec_play");
            m.a(this.mTextTitle, ((com.baidu.tieba.card.data.j) this.agj).eJQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            if (((com.baidu.tieba.card.data.j) this.agj).bln() != null && ((com.baidu.tieba.card.data.j) this.agj).bln().boj() != null) {
                ar arVar = new ar("c14008");
                arVar.ap("obj_locate", this.flF ? 2 : 1);
                arVar.v("obj_param1", ((com.baidu.tieba.card.data.j) this.agj).bln().boj().live_id);
                arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(arVar);
            }
        }
    }

    private void d(long j, long j2, String str) {
        bf.bsV().b(this.mTbPageContext, new String[]{"bdtiebalive://video/live?room_id=" + j2 + "&live_id=" + j + "&enterroom_type=1&from" + str});
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hng != null && this.iwr != null) {
            setTag(bdUniqueId);
            q(bdUniqueId);
            if (this.agp != null) {
                this.agp.setPageUniqueId(bdUniqueId);
            }
            this.iwr.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iwr);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aif = str;
    }

    public void xa(int i) {
        if (this.hng != null) {
            this.hng.fkx = String.valueOf(i);
        }
    }

    public void jD(boolean z) {
        this.flF = z;
    }
}
