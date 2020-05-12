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
    private CardUserInfoLayout adk;
    private String aeB;
    private UnfollowedDecorView afs;
    private View.OnClickListener agl;
    private View.OnClickListener dIj;
    public boolean dJr;
    private TbPageContext<?> duK;
    public LinearLayout eHe;
    private TextView emC;
    public TbImageView emw;
    private NEGFeedBackView fsH;
    public ThreadCommentAndPraiseInfoLayout fsw;
    public ThreadSourceShareAndPraiseLayout fti;
    private com.baidu.tieba.card.data.j goL;
    public FrameLayout goM;
    public RelativeLayout goN;
    private TBLottieAnimationView goO;
    private View goP;
    private ThreadForumEnterButton goQ;
    private View.OnClickListener goR;
    private CustomMessageListener goS;
    private BdUniqueId mBdUniqueId;
    public View mDivider;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.fsH = null;
        this.afs = null;
        this.dJr = false;
        this.mLastScreenWidth = 0;
        this.goR = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        };
        this.agl = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.bEx() != null) {
                    j.this.bEx().a(view, j.this.goL);
                }
            }
        };
        this.dIj = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.bEx() != null) {
                    j.this.bEx().a(view, j.this.goL);
                }
            }
        };
        this.goS = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.j.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && j.this.goL != null && j.this.goL.dqE != null && j.this.goL.dqE.getTid() != null && j.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(j.this.goL.dqE.getTid())) {
                    l.a(j.this.mTextTitle, j.this.goL.dqE.getId(), (int) R.color.cp_cont_d, (int) R.color.cp_cont_d);
                }
            }
        };
        this.duK = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init(getView());
    }

    private void init(View view) {
        this.goM = (FrameLayout) view.findViewById(R.id.layout_root);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.eHe = (LinearLayout) view.findViewById(R.id.content_layout);
        this.adk = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.adk.setPageContext(this.duK);
        this.adk.setPageUniqueId(this.mBdUniqueId);
        this.fsH = new NEGFeedBackView(getTbPageContext());
        this.fsH.a(this.goM, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds124), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds15), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds20));
        bED();
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.goN = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.emw = (TbImageView) view.findViewById(R.id.image_video);
        this.emw.setDrawCorner(true);
        this.emw.setPlaceHolder(3);
        this.emw.setDefaultResource(0);
        this.emw.setDefaultErrorResource(0);
        this.emw.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        TbImageView tbImageView = this.emw;
        TbImageView tbImageView2 = this.emw;
        tbImageView.setConrers(15);
        this.emw.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.emw.setBorderColor(am.getColor(R.color.cp_border_a));
        this.emw.setBorderSurroundContent(true);
        this.emw.setDrawBorder(true);
        this.goO = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.goO.loop(true);
        am.a(this.goO, R.raw.ala_live2);
        this.goO.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.j.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                j.this.goO.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                j.this.goO.cancelAnimation();
            }
        });
        this.goQ = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
        this.fsw = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.fsw.setOnClickListener(this);
        this.fsw.setReplyTimeVisible(false);
        this.fsw.setShowPraiseNum(true);
        this.fsw.setNeedAddReplyIcon(true);
        this.fsw.setNeedAddPraiseIcon(true);
        if (this.fsw.getCommentContainer() != null) {
            this.fsw.getCommentContainer().setOnClickListener(this);
        }
        this.fsw.setShareVisible(true);
        this.fsw.setFrom(7);
        this.fsw.setShareReportFrom(3);
        this.fsw.hideDisagree();
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.dmX = 7;
        dVar.dnd = 1;
        this.fsw.setAgreeStatisticData(dVar);
        this.fti = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_ala_source_read_share_layout);
        this.fti.dJe.setOnClickListener(this);
        this.fti.setFrom(7);
        this.fti.setShareReportFrom(3);
        if (this.fti.dJe.getCommentContainer() != null) {
            this.fti.dJe.getCommentContainer().setOnClickListener(this);
        }
        this.emC = (TextView) view.findViewById(R.id.play_count);
        this.goP = view.findViewById(R.id.divider_below_reply_number_layout);
        this.eHe.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.goM, R.drawable.addresslist_item_bg);
            am.setBackgroundResource(this.eHe, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.emC, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.goN, R.drawable.bg_ala_shape);
            this.adk.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fsw.onChangeSkinType();
            if (this.fsH != null) {
                this.fsH.onChangeSkinType();
            }
            this.afs.onChangeSkinType();
            this.goQ.onChangeSkinType();
            this.fti.onChangeSkinType();
            this.emw.setPlaceHolder(3);
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
        this.goL = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.goL == null || this.goL.aIu() == null) {
            this.goM.setVisibility(8);
            return;
        }
        this.goM.setVisibility(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.duK.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.goN.getLayoutParams();
            layoutParams.width = equipmentWidth - com.baidu.adp.lib.util.l.getDimens(this.duK.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.goN.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (this.goL.aIu().aKV() != null && this.goL.aIu().aKV().isChushou) {
            this.fsw.setShowFlag(10);
            this.fsw.hideShareContainer();
        } else {
            this.fsw.setShowFlag(11);
            this.fsw.resetShareContainer();
        }
        this.adk.setVisibility(0);
        this.adk.setData(this.goL.aIu());
        this.adk.setUserAfterClickListener(this.agl);
        this.goL.aIu().aLx();
        this.mTextTitle.setText(new SpannableStringBuilder(this.goL.aIu().aLj()));
        if (this.goL.dqE.aKV().audience_count > 0) {
            this.emC.setVisibility(0);
            this.emC.setText(String.format(this.duK.getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.goL.dqE.aKV().audience_count)));
        } else {
            this.emC.setVisibility(8);
        }
        if (this.dJr) {
            this.goQ.q(this.goL.aIu());
        }
        this.afs.q(this.goL.aIu());
        if (this.dJr) {
            this.fsH.setVisibility(8);
            if (!au.u(this.goL.aIu())) {
                this.afs.setVisibility(0);
            } else {
                this.afs.setVisibility(8);
            }
        } else {
            if (this.fsH != null && this.goL.aIu() != null) {
                al alVar = new al();
                alVar.setTid(this.goL.aIu().getTid());
                alVar.setFid(this.goL.aIu().getFid());
                alVar.setFeedBackReasonMap(this.goL.feedBackReasonMap);
                this.fsH.setData(alVar);
                this.fsH.setFirstRowSingleColumn(true);
            }
            this.afs.setVisibility(8);
        }
        pX(or(1));
        onChangeSkinType(this.duK, TbadkCoreApplication.getInst().getSkinType());
        if (l.BF(this.goL.dqE.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        bEA();
        this.goO.playAnimation();
    }

    public void bEA() {
        if (com.baidu.tbadk.core.i.aIc().isShowImages() && this.goL != null && this.goL.aIu() != null && this.goL.aIu().aKV() != null) {
            this.emw.setPlaceHolder(3);
            this.emw.startLoad(this.goL.aIu().aKV().cover, 10, false);
            this.goN.setVisibility(0);
            return;
        }
        this.goN.setVisibility(8);
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.fsH != null) {
            this.fsH.setEventCallback(aVar);
        }
    }

    public View bEB() {
        if (this.adk != null) {
            return this.adk.getAvatar();
        }
        return null;
    }

    public View bEC() {
        if (this.dJr) {
            if (this.adk != null) {
                return this.adk.getUserName();
            }
            return null;
        }
        return this.mTextTitle;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eHe || view == this.fsw.getCommentContainer() || view == this.fti.dJe.getCommentContainer()) {
            if (this.goL.aIu().aKV() != null && this.goL.aIu().aKV().isChushou) {
                dn(this.goL.aIu().aKV().thirdRoomId, this.goL.aIu().aKV().thirdLiveType);
            } else {
                bJ(view);
            }
        }
    }

    private void dn(String str, String str2) {
        ba.aOV().b(this.mTbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void bJ(View view) {
        if (bEx() != null) {
            bEx().a(view, this.goL);
        }
        if (this.goL != null && this.goL.aIu() != null && this.goL.aIu().aKV() != null) {
            l.BE(this.goL.dqE.getId());
            l.a(this.mTextTitle, this.goL.dqE.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.goL.aIu().aKV());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.duK.getPageActivity(), alaLiveInfoCoreData, "home_rec_play", "", false, "")));
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.fsw != null && this.goS != null) {
            if (this.adk != null) {
                this.adk.setPageUniqueId(bdUniqueId);
            }
            this.goS.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.fsH != null) {
                this.fsH.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.goS);
        }
    }

    public void pX(int i) {
        if (this.goL != null && this.goL.dqE != null) {
            if (i == 1) {
                this.fsw.setVisibility(8);
                this.fti.setData(this.goL.dqE);
                return;
            }
            this.fti.setVisibility(8);
            if (this.fsw.setData(this.goL.dqE)) {
                this.goP.setVisibility(8);
            } else {
                this.goP.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aeB = str;
    }

    public int or(int i) {
        return com.baidu.tieba.a.d.bfN().ar(this.aeB, i);
    }

    public void rJ(int i) {
        if (this.fsw != null) {
            this.fsw.dIh = String.valueOf(i);
        }
    }

    public void gC(boolean z) {
        this.dJr = z;
    }

    private void bED() {
        this.afs = new UnfollowedDecorView(this.duK.getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds124);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds20);
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds15);
        layoutParams.gravity = 85;
        this.goM.addView(this.afs, layoutParams);
    }
}
