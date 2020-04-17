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
    private CardUserInfoLayout adh;
    private String aey;
    private UnfollowedDecorView afp;
    private View.OnClickListener agi;
    private View.OnClickListener dIf;
    public boolean dJn;
    private TbPageContext<?> duG;
    public LinearLayout eGZ;
    public TbImageView emr;
    private TextView emx;
    private NEGFeedBackView fsC;
    public ThreadCommentAndPraiseInfoLayout fsr;
    public ThreadSourceShareAndPraiseLayout ftd;
    private com.baidu.tieba.card.data.j goF;
    public FrameLayout goG;
    public RelativeLayout goH;
    private TBLottieAnimationView goI;
    private View goJ;
    private ThreadForumEnterButton goK;
    private View.OnClickListener goL;
    private CustomMessageListener goM;
    private BdUniqueId mBdUniqueId;
    public View mDivider;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.fsC = null;
        this.afp = null;
        this.dJn = false;
        this.mLastScreenWidth = 0;
        this.goL = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        };
        this.agi = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.bEy() != null) {
                    j.this.bEy().a(view, j.this.goF);
                }
            }
        };
        this.dIf = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.bEy() != null) {
                    j.this.bEy().a(view, j.this.goF);
                }
            }
        };
        this.goM = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.j.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && j.this.goF != null && j.this.goF.dqA != null && j.this.goF.dqA.getTid() != null && j.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(j.this.goF.dqA.getTid())) {
                    l.a(j.this.mTextTitle, j.this.goF.dqA.getId(), (int) R.color.cp_cont_d, (int) R.color.cp_cont_d);
                }
            }
        };
        this.duG = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init(getView());
    }

    private void init(View view) {
        this.goG = (FrameLayout) view.findViewById(R.id.layout_root);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.eGZ = (LinearLayout) view.findViewById(R.id.content_layout);
        this.adh = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.adh.setPageContext(this.duG);
        this.adh.setPageUniqueId(this.mBdUniqueId);
        this.fsC = new NEGFeedBackView(getTbPageContext());
        this.fsC.a(this.goG, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds124), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds15), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds20));
        bEE();
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.goH = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.emr = (TbImageView) view.findViewById(R.id.image_video);
        this.emr.setDrawCorner(true);
        this.emr.setPlaceHolder(3);
        this.emr.setDefaultResource(0);
        this.emr.setDefaultErrorResource(0);
        this.emr.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        TbImageView tbImageView = this.emr;
        TbImageView tbImageView2 = this.emr;
        tbImageView.setConrers(15);
        this.emr.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.emr.setBorderColor(am.getColor(R.color.cp_border_a));
        this.emr.setBorderSurroundContent(true);
        this.emr.setDrawBorder(true);
        this.goI = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.goI.loop(true);
        am.a(this.goI, R.raw.ala_live2);
        this.goI.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.j.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                j.this.goI.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                j.this.goI.cancelAnimation();
            }
        });
        this.goK = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
        this.fsr = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.fsr.setOnClickListener(this);
        this.fsr.setReplyTimeVisible(false);
        this.fsr.setShowPraiseNum(true);
        this.fsr.setNeedAddReplyIcon(true);
        this.fsr.setNeedAddPraiseIcon(true);
        if (this.fsr.getCommentContainer() != null) {
            this.fsr.getCommentContainer().setOnClickListener(this);
        }
        this.fsr.setShareVisible(true);
        this.fsr.setFrom(7);
        this.fsr.setShareReportFrom(3);
        this.fsr.hideDisagree();
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.dmT = 7;
        dVar.dmZ = 1;
        this.fsr.setAgreeStatisticData(dVar);
        this.ftd = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_ala_source_read_share_layout);
        this.ftd.dJa.setOnClickListener(this);
        this.ftd.setFrom(7);
        this.ftd.setShareReportFrom(3);
        if (this.ftd.dJa.getCommentContainer() != null) {
            this.ftd.dJa.getCommentContainer().setOnClickListener(this);
        }
        this.emx = (TextView) view.findViewById(R.id.play_count);
        this.goJ = view.findViewById(R.id.divider_below_reply_number_layout);
        this.eGZ.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.goG, R.drawable.addresslist_item_bg);
            am.setBackgroundResource(this.eGZ, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.emx, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.goH, R.drawable.bg_ala_shape);
            this.adh.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fsr.onChangeSkinType();
            if (this.fsC != null) {
                this.fsC.onChangeSkinType();
            }
            this.afp.onChangeSkinType();
            this.goK.onChangeSkinType();
            this.ftd.onChangeSkinType();
            this.emr.setPlaceHolder(3);
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
        this.goF = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.goF == null || this.goF.aIw() == null) {
            this.goG.setVisibility(8);
            return;
        }
        this.goG.setVisibility(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.duG.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.goH.getLayoutParams();
            layoutParams.width = equipmentWidth - com.baidu.adp.lib.util.l.getDimens(this.duG.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.goH.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (this.goF.aIw().aKX() != null && this.goF.aIw().aKX().isChushou) {
            this.fsr.setShowFlag(10);
            this.fsr.hideShareContainer();
        } else {
            this.fsr.setShowFlag(11);
            this.fsr.resetShareContainer();
        }
        this.adh.setVisibility(0);
        this.adh.setData(this.goF.aIw());
        this.adh.setUserAfterClickListener(this.agi);
        this.goF.aIw().aLz();
        this.mTextTitle.setText(new SpannableStringBuilder(this.goF.aIw().aLl()));
        if (this.goF.dqA.aKX().audience_count > 0) {
            this.emx.setVisibility(0);
            this.emx.setText(String.format(this.duG.getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.goF.dqA.aKX().audience_count)));
        } else {
            this.emx.setVisibility(8);
        }
        if (this.dJn) {
            this.goK.q(this.goF.aIw());
        }
        this.afp.q(this.goF.aIw());
        if (this.dJn) {
            this.fsC.setVisibility(8);
            if (!au.u(this.goF.aIw())) {
                this.afp.setVisibility(0);
            } else {
                this.afp.setVisibility(8);
            }
        } else {
            if (this.fsC != null && this.goF.aIw() != null) {
                al alVar = new al();
                alVar.setTid(this.goF.aIw().getTid());
                alVar.setFid(this.goF.aIw().getFid());
                alVar.setFeedBackReasonMap(this.goF.feedBackReasonMap);
                this.fsC.setData(alVar);
                this.fsC.setFirstRowSingleColumn(true);
            }
            this.afp.setVisibility(8);
        }
        pX(or(1));
        onChangeSkinType(this.duG, TbadkCoreApplication.getInst().getSkinType());
        if (l.BC(this.goF.dqA.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        bEB();
        this.goI.playAnimation();
    }

    public void bEB() {
        if (com.baidu.tbadk.core.i.aIe().isShowImages() && this.goF != null && this.goF.aIw() != null && this.goF.aIw().aKX() != null) {
            this.emr.setPlaceHolder(3);
            this.emr.startLoad(this.goF.aIw().aKX().cover, 10, false);
            this.goH.setVisibility(0);
            return;
        }
        this.goH.setVisibility(8);
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.fsC != null) {
            this.fsC.setEventCallback(aVar);
        }
    }

    public View bEC() {
        if (this.adh != null) {
            return this.adh.getAvatar();
        }
        return null;
    }

    public View bED() {
        if (this.dJn) {
            if (this.adh != null) {
                return this.adh.getUserName();
            }
            return null;
        }
        return this.mTextTitle;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eGZ || view == this.fsr.getCommentContainer() || view == this.ftd.dJa.getCommentContainer()) {
            if (this.goF.aIw().aKX() != null && this.goF.aIw().aKX().isChushou) {
                dn(this.goF.aIw().aKX().thirdRoomId, this.goF.aIw().aKX().thirdLiveType);
            } else {
                bJ(view);
            }
        }
    }

    private void dn(String str, String str2) {
        ba.aOY().b(this.mTbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void bJ(View view) {
        if (bEy() != null) {
            bEy().a(view, this.goF);
        }
        if (this.goF != null && this.goF.aIw() != null && this.goF.aIw().aKX() != null) {
            l.BB(this.goF.dqA.getId());
            l.a(this.mTextTitle, this.goF.dqA.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.goF.aIw().aKX());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.duG.getPageActivity(), alaLiveInfoCoreData, "home_rec_play", "", false, "")));
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.fsr != null && this.goM != null) {
            if (this.adh != null) {
                this.adh.setPageUniqueId(bdUniqueId);
            }
            this.goM.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.fsC != null) {
                this.fsC.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.goM);
        }
    }

    public void pX(int i) {
        if (this.goF != null && this.goF.dqA != null) {
            if (i == 1) {
                this.fsr.setVisibility(8);
                this.ftd.setData(this.goF.dqA);
                return;
            }
            this.ftd.setVisibility(8);
            if (this.fsr.setData(this.goF.dqA)) {
                this.goJ.setVisibility(8);
            } else {
                this.goJ.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aey = str;
    }

    public int or(int i) {
        return com.baidu.tieba.a.d.bfP().ar(this.aey, i);
    }

    public void rJ(int i) {
        if (this.fsr != null) {
            this.fsr.dId = String.valueOf(i);
        }
    }

    public void gC(boolean z) {
        this.dJn = z;
    }

    private void bEE() {
        this.afp = new UnfollowedDecorView(this.duG.getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds124);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds20);
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds15);
        layoutParams.gravity = 85;
        this.goG.addView(this.afp, layoutParams);
    }
}
