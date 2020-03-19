package com.baidu.tieba.card;

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
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.card.view.UnfollowedDecorView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class j extends a<com.baidu.tieba.card.data.j> implements com.baidu.tieba.a.e {
    private CardUserInfoLayout Kj;
    private String LC;
    private UnfollowedDecorView MA;
    private View.OnClickListener Nx;
    private TbPageContext<?> cVv;
    public TbImageView dMA;
    private TextView dMG;
    private View.OnClickListener dik;
    public boolean dju;
    public ThreadCommentAndPraiseInfoLayout eNX;
    public ThreadSourceShareAndPraiseLayout eOJ;
    private NEGFeedBackView eOi;
    public LinearLayout ehj;
    private com.baidu.tieba.card.data.j fJZ;
    public FrameLayout fKa;
    public RelativeLayout fKb;
    private TBLottieAnimationView fKc;
    private View fKd;
    private ThreadForumEnterButton fKe;
    private View.OnClickListener fKf;
    private CustomMessageListener fKg;
    private BdUniqueId mBdUniqueId;
    public View mDivider;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.eOi = null;
        this.MA = null;
        this.dju = false;
        this.mLastScreenWidth = 0;
        this.fKf = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        };
        this.Nx = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.buM() != null) {
                    j.this.buM().a(view, j.this.fJZ);
                }
            }
        };
        this.dik = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.buM() != null) {
                    j.this.buM().a(view, j.this.fJZ);
                }
            }
        };
        this.fKg = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.j.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && j.this.fJZ != null && j.this.fJZ.cRt != null && j.this.fJZ.cRt.getTid() != null && j.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(j.this.fJZ.cRt.getTid())) {
                    l.a(j.this.mTextTitle, j.this.fJZ.cRt.getId(), (int) R.color.cp_cont_d, (int) R.color.cp_cont_d);
                }
            }
        };
        this.cVv = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init(getView());
    }

    private void init(View view) {
        this.fKa = (FrameLayout) view.findViewById(R.id.layout_root);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.ehj = (LinearLayout) view.findViewById(R.id.content_layout);
        this.Kj = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.Kj.setPageContext(this.cVv);
        this.Kj.setPageUniqueId(this.mBdUniqueId);
        this.eOi = new NEGFeedBackView(getTbPageContext());
        this.eOi.a(this.fKa, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds124), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds15), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds20));
        buS();
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fKb = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.dMA = (TbImageView) view.findViewById(R.id.image_video);
        this.dMA.setDrawCorner(true);
        this.dMA.setPlaceHolder(3);
        this.dMA.setDefaultResource(0);
        this.dMA.setDefaultErrorResource(0);
        this.dMA.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        TbImageView tbImageView = this.dMA;
        TbImageView tbImageView2 = this.dMA;
        tbImageView.setConrers(15);
        this.dMA.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.dMA.setBorderColor(am.getColor(R.color.cp_border_a));
        this.dMA.setBorderSurroundContent(true);
        this.dMA.setDrawBorder(true);
        this.fKc = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.fKc.loop(true);
        am.a(this.fKc, R.raw.ala_live2);
        this.fKc.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.j.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                j.this.fKc.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                j.this.fKc.cancelAnimation();
            }
        });
        this.fKe = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
        this.eNX = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.eNX.setOnClickListener(this);
        this.eNX.setReplyTimeVisible(false);
        this.eNX.setShowPraiseNum(true);
        this.eNX.setNeedAddReplyIcon(true);
        this.eNX.setNeedAddPraiseIcon(true);
        if (this.eNX.getCommentContainer() != null) {
            this.eNX.getCommentContainer().setOnClickListener(this);
        }
        this.eNX.setShareVisible(true);
        this.eNX.setFrom(7);
        this.eNX.setShareReportFrom(3);
        this.eNX.hideDisagree();
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNP = 7;
        dVar.cNV = 1;
        this.eNX.setAgreeStatisticData(dVar);
        this.eOJ = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_ala_source_read_share_layout);
        this.eOJ.djh.setOnClickListener(this);
        this.eOJ.setFrom(7);
        this.eOJ.setShareReportFrom(3);
        if (this.eOJ.djh.getCommentContainer() != null) {
            this.eOJ.djh.getCommentContainer().setOnClickListener(this);
        }
        this.dMG = (TextView) view.findViewById(R.id.play_count);
        this.fKd = view.findViewById(R.id.divider_below_reply_number_layout);
        this.ehj.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fKa, R.drawable.addresslist_item_bg);
            am.setBackgroundResource(this.ehj, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.dMG, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.fKb, R.drawable.bg_ala_shape);
            this.Kj.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.eNX.onChangeSkinType();
            if (this.eOi != null) {
                this.eOi.onChangeSkinType();
            }
            this.MA.onChangeSkinType();
            this.fKe.onChangeSkinType();
            this.eOJ.onChangeSkinType();
            this.dMA.setPlaceHolder(3);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_ala_live_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.j jVar) {
        this.fJZ = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.fJZ == null || this.fJZ.aAj() == null) {
            this.fKa.setVisibility(8);
            return;
        }
        this.fKa.setVisibility(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.cVv.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fKb.getLayoutParams();
            layoutParams.width = equipmentWidth - com.baidu.adp.lib.util.l.getDimens(this.cVv.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.fKb.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (this.fJZ.aAj().aCK() != null && this.fJZ.aAj().aCK().isChushou) {
            this.eNX.setShowFlag(10);
            this.eNX.hideShareContainer();
        } else {
            this.eNX.setShowFlag(11);
            this.eNX.resetShareContainer();
        }
        this.Kj.setVisibility(0);
        this.Kj.setData(this.fJZ.aAj());
        this.Kj.setUserAfterClickListener(this.Nx);
        this.fJZ.aAj().aDm();
        this.mTextTitle.setText(new SpannableStringBuilder(this.fJZ.aAj().aCY()));
        if (this.fJZ.cRt.aCK().audience_count > 0) {
            this.dMG.setVisibility(0);
            this.dMG.setText(String.format(this.cVv.getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.fJZ.cRt.aCK().audience_count)));
        } else {
            this.dMG.setVisibility(8);
        }
        if (this.dju) {
            this.fKe.q(this.fJZ.aAj());
        }
        this.MA.q(this.fJZ.aAj());
        if (this.dju) {
            this.eOi.setVisibility(8);
            if (!au.u(this.fJZ.aAj())) {
                this.MA.setVisibility(0);
            } else {
                this.MA.setVisibility(8);
            }
        } else {
            if (this.eOi != null && this.fJZ.aAj() != null) {
                al alVar = new al();
                alVar.setTid(this.fJZ.aAj().getTid());
                alVar.setFid(this.fJZ.aAj().getFid());
                alVar.setFeedBackReasonMap(this.fJZ.feedBackReasonMap);
                this.eOi.setData(alVar);
                this.eOi.setFirstRowSingleColumn(true);
            }
            this.MA.setVisibility(8);
        }
        pD(oe(1));
        onChangeSkinType(this.cVv, TbadkCoreApplication.getInst().getSkinType());
        if (l.zW(this.fJZ.cRt.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        buP();
        this.fKc.playAnimation();
    }

    public void buP() {
        if (com.baidu.tbadk.core.i.azR().isShowImages() && this.fJZ != null && this.fJZ.aAj() != null && this.fJZ.aAj().aCK() != null) {
            this.dMA.setPlaceHolder(3);
            this.dMA.startLoad(this.fJZ.aAj().aCK().cover, 10, false);
            this.fKb.setVisibility(0);
            return;
        }
        this.fKb.setVisibility(8);
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.eOi != null) {
            this.eOi.setEventCallback(aVar);
        }
    }

    public View buQ() {
        if (this.Kj != null) {
            return this.Kj.getAvatar();
        }
        return null;
    }

    public View buR() {
        if (this.dju) {
            if (this.Kj != null) {
                return this.Kj.getUserName();
            }
            return null;
        }
        return this.mTextTitle;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ehj || view == this.eNX.getCommentContainer() || view == this.eOJ.djh.getCommentContainer()) {
            if (this.fJZ.aAj().aCK() != null && this.fJZ.aAj().aCK().isChushou) {
                cZ(this.fJZ.aAj().aCK().thirdRoomId, this.fJZ.aAj().aCK().thirdLiveType);
            } else {
                bE(view);
            }
        }
    }

    private void cZ(String str, String str2) {
        ba.aGK().b(this.mTbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void bE(View view) {
        if (buM() != null) {
            buM().a(view, this.fJZ);
        }
        if (this.fJZ != null && this.fJZ.aAj() != null && this.fJZ.aAj().aCK() != null) {
            l.zV(this.fJZ.cRt.getId());
            l.a(this.mTextTitle, this.fJZ.cRt.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.fJZ.aAj().aCK());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.cVv.getPageActivity(), alaLiveInfoCoreData, "home_rec_play", "", false, "")));
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.eNX != null && this.fKg != null) {
            if (this.Kj != null) {
                this.Kj.setPageUniqueId(bdUniqueId);
            }
            this.fKg.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.eOi != null) {
                this.eOi.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.fKg);
        }
    }

    public void pD(int i) {
        if (this.fJZ != null && this.fJZ.cRt != null) {
            if (i == 1) {
                this.eNX.setVisibility(8);
                this.eOJ.setData(this.fJZ.cRt);
                return;
            }
            this.eOJ.setVisibility(8);
            if (this.eNX.setData(this.fJZ.cRt)) {
                this.fKd.setVisibility(8);
            } else {
                this.fKd.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oe(int i) {
        return com.baidu.tieba.a.d.aXK().ai(this.LC, i);
    }

    public void rr(int i) {
        if (this.eNX != null) {
            this.eNX.dii = String.valueOf(i);
        }
    }

    public void fF(boolean z) {
        this.dju = z;
    }

    private void buS() {
        this.MA = new UnfollowedDecorView(this.cVv.getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds124);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds20);
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds15);
        layoutParams.gravity = 85;
        this.fKa.addView(this.MA, layoutParams);
    }
}
