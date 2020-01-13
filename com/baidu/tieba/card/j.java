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
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class j extends a<com.baidu.tieba.card.data.j> implements com.baidu.tieba.a.e {
    private CardUserInfoLayout JN;
    private String Lg;
    private View.OnClickListener MX;
    private UnfollowedDecorView Mb;
    private TbPageContext<?> cRe;
    public TbImageView dHR;
    private TextView dHX;
    private View.OnClickListener ddE;
    public boolean deN;
    private NEGFeedBackView eJD;
    public ThreadCommentAndPraiseInfoLayout eJr;
    public ThreadSourceShareAndPraiseLayout eKe;
    public LinearLayout ecC;
    private com.baidu.tieba.card.data.j fGF;
    public FrameLayout fGG;
    public RelativeLayout fGH;
    private TBLottieAnimationView fGI;
    private View fGJ;
    private ThreadForumEnterButton fGK;
    private View.OnClickListener fGL;
    private CustomMessageListener fGM;
    private BdUniqueId mBdUniqueId;
    public View mDivider;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.eJD = null;
        this.Mb = null;
        this.deN = false;
        this.mLastScreenWidth = 0;
        this.fGL = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        };
        this.MX = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.bta() != null) {
                    j.this.bta().a(view, j.this.fGF);
                }
            }
        };
        this.ddE = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.bta() != null) {
                    j.this.bta().a(view, j.this.fGF);
                }
            }
        };
        this.fGM = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.j.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && j.this.fGF != null && j.this.fGF.cNb != null && j.this.fGF.cNb.getTid() != null && j.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(j.this.fGF.cNb.getTid())) {
                    l.a(j.this.mTextTitle, j.this.fGF.cNb.getId(), (int) R.color.cp_cont_d, (int) R.color.cp_cont_d);
                }
            }
        };
        this.cRe = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init(getView());
    }

    private void init(View view) {
        this.fGG = (FrameLayout) view.findViewById(R.id.layout_root);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.ecC = (LinearLayout) view.findViewById(R.id.content_layout);
        this.JN = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.eJD = new NEGFeedBackView(this.cRe);
        this.eJD = new NEGFeedBackView(getTbPageContext());
        this.eJD.a(this.fGG, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds124), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds15), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds20));
        btg();
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fGH = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.dHR = (TbImageView) view.findViewById(R.id.image_video);
        this.dHR.setDrawCorner(true);
        this.dHR.setPlaceHolder(3);
        this.dHR.setDefaultResource(0);
        this.dHR.setDefaultErrorResource(0);
        this.dHR.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        TbImageView tbImageView = this.dHR;
        TbImageView tbImageView2 = this.dHR;
        tbImageView.setConrers(15);
        this.dHR.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.dHR.setBorderColor(am.getColor(R.color.cp_border_a));
        this.dHR.setBorderSurroundContent(true);
        this.dHR.setDrawBorder(true);
        this.fGI = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.fGI.loop(true);
        am.a(this.fGI, R.raw.ala_live2);
        this.fGI.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.j.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                j.this.fGI.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                j.this.fGI.cancelAnimation();
            }
        });
        this.fGK = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
        this.eJr = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.eJr.setOnClickListener(this);
        this.eJr.setReplyTimeVisible(false);
        this.eJr.setShowPraiseNum(true);
        this.eJr.setNeedAddReplyIcon(true);
        this.eJr.setNeedAddPraiseIcon(true);
        if (this.eJr.getCommentContainer() != null) {
            this.eJr.getCommentContainer().setOnClickListener(this);
        }
        this.eJr.setShareVisible(true);
        this.eJr.setFrom(7);
        this.eJr.setShareReportFrom(3);
        this.eJr.hideDisagree();
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cJx = 7;
        dVar.cJD = 1;
        this.eJr.setAgreeStatisticData(dVar);
        this.eKe = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_ala_source_read_share_layout);
        this.eKe.deA.setOnClickListener(this);
        this.eKe.setFrom(7);
        this.eKe.setShareReportFrom(3);
        if (this.eKe.deA.getCommentContainer() != null) {
            this.eKe.deA.getCommentContainer().setOnClickListener(this);
        }
        this.dHX = (TextView) view.findViewById(R.id.play_count);
        this.fGJ = view.findViewById(R.id.divider_below_reply_number_layout);
        this.ecC.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fGG, R.drawable.addresslist_item_bg);
            am.setBackgroundResource(this.ecC, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.dHX, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.fGH, R.drawable.bg_ala_shape);
            this.JN.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.eJr.onChangeSkinType();
            if (this.eJD != null) {
                this.eJD.onChangeSkinType();
            }
            this.Mb.onChangeSkinType();
            this.fGK.onChangeSkinType();
            this.eKe.onChangeSkinType();
            this.dHR.setPlaceHolder(3);
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
        this.fGF = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.fGF == null || this.fGF.axQ() == null) {
            this.fGG.setVisibility(8);
            return;
        }
        this.fGG.setVisibility(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.cRe.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fGH.getLayoutParams();
            layoutParams.width = equipmentWidth - com.baidu.adp.lib.util.l.getDimens(this.cRe.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.fGH.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        this.JN.setVisibility(0);
        this.JN.setData(this.fGF.axQ());
        this.JN.setUserAfterClickListener(this.MX);
        this.fGF.axQ().aAT();
        this.mTextTitle.setText(new SpannableStringBuilder(this.fGF.axQ().aAE()));
        this.dHX.setText(String.format(this.cRe.getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.fGF.cNb.aAq().audience_count)));
        if (this.deN) {
            this.fGK.q(this.fGF.axQ());
        }
        this.Mb.q(this.fGF.axQ());
        if (this.deN) {
            this.eJD.setVisibility(8);
            if (!au.u(this.fGF.axQ())) {
                this.Mb.setVisibility(0);
            } else {
                this.Mb.setVisibility(8);
            }
        } else {
            if (this.eJD != null && this.fGF.axQ() != null) {
                al alVar = new al();
                alVar.setTid(this.fGF.axQ().getTid());
                alVar.setFid(this.fGF.axQ().getFid());
                alVar.setFeedBackReasonMap(this.fGF.feedBackReasonMap);
                this.eJD.setData(alVar);
                this.eJD.setFirstRowSingleColumn(true);
            }
            this.Mb.setVisibility(8);
        }
        pq(nL(1));
        onChangeSkinType(this.cRe, TbadkCoreApplication.getInst().getSkinType());
        if (l.zD(this.fGF.cNb.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        btd();
        this.fGI.playAnimation();
    }

    public void btd() {
        if (com.baidu.tbadk.core.i.axy().isShowImages() && this.fGF != null && this.fGF.axQ() != null && this.fGF.axQ().aAq() != null) {
            this.dHR.setPlaceHolder(3);
            this.dHR.startLoad(this.fGF.axQ().aAq().cover, 10, false);
            this.fGH.setVisibility(0);
            return;
        }
        this.fGH.setVisibility(8);
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.eJD != null) {
            this.eJD.setEventCallback(aVar);
        }
    }

    public View bte() {
        if (this.JN != null) {
            return this.JN.getAvatar();
        }
        return null;
    }

    public View btf() {
        if (this.deN) {
            if (this.JN != null) {
                return this.JN.getUserName();
            }
            return null;
        }
        return this.mTextTitle;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ecC || view == this.eJr.getCommentContainer() || view == this.eKe.deA.getCommentContainer()) {
            bE(view);
        }
    }

    private void bE(View view) {
        if (bta() != null) {
            bta().a(view, this.fGF);
        }
        if (this.fGF != null && this.fGF.axQ() != null && this.fGF.axQ().aAq() != null) {
            l.zC(this.fGF.cNb.getId());
            l.a(this.mTextTitle, this.fGF.cNb.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.fGF.axQ().aAq());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.cRe.getPageActivity(), alaLiveInfoCoreData, "home_rec_play", "", false, "")));
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.eJr != null && this.fGM != null) {
            if (this.JN != null) {
                this.JN.setPageUniqueId(bdUniqueId);
            }
            this.fGM.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.eJD != null) {
                this.eJD.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.fGM);
        }
    }

    public void pq(int i) {
        if (this.fGF != null && this.fGF.cNb != null) {
            if (i == 1) {
                this.eJr.setVisibility(8);
                this.eKe.setData(this.fGF.cNb);
                return;
            }
            this.eKe.setVisibility(8);
            if (this.eJr.setData(this.fGF.cNb)) {
                this.fGJ.setVisibility(8);
            } else {
                this.fGJ.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Lg = str;
    }

    public int nL(int i) {
        return com.baidu.tieba.a.d.aVo().ak(this.Lg, i);
    }

    public void ri(int i) {
        if (this.eJr != null) {
            this.eJr.ddC = String.valueOf(i);
        }
    }

    public void fx(boolean z) {
        this.deN = z;
    }

    private void btg() {
        this.Mb = new UnfollowedDecorView(this.cRe.getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds124);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds20);
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds15);
        layoutParams.gravity = 85;
        this.fGG.addView(this.Mb, layoutParams);
    }
}
