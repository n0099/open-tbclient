package com.baidu.tieba.card;

import android.text.SpannableString;
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
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.card.view.UnfollowedDecorView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
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
/* loaded from: classes5.dex */
public class j extends a<com.baidu.tieba.card.data.j> implements com.baidu.tieba.a.e {
    private CardUserInfoLayout JH;
    private UnfollowedDecorView LW;
    private String La;
    private View.OnClickListener MT;
    private TbPageContext<?> cQU;
    public TbImageView dHI;
    private TextView dHO;
    private View.OnClickListener ddt;
    public boolean deB;
    public ThreadSourceShareAndPraiseLayout eIU;
    public ThreadCommentAndPraiseInfoLayout eIh;
    private NEGFeedBackView eIt;
    public LinearLayout ect;
    private ThreadForumEnterButton fDA;
    private View.OnClickListener fDB;
    private CustomMessageListener fDC;
    private com.baidu.tieba.card.data.j fDu;
    public FrameLayout fDv;
    private CardForumHeadLayout fDw;
    public RelativeLayout fDx;
    public TBLottieAnimationView fDy;
    private View fDz;
    public View mDivider;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eIt = null;
        this.LW = null;
        this.deB = false;
        this.mLastScreenWidth = 0;
        this.fDB = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        };
        this.MT = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.brY() != null) {
                    j.this.brY().a(view, j.this.fDu);
                }
            }
        };
        this.ddt = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.brY() != null) {
                    j.this.brY().a(view, j.this.fDu);
                }
            }
        };
        this.fDC = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.j.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && j.this.fDu != null && j.this.fDu.cMR != null && j.this.fDu.cMR.getTid() != null && j.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(j.this.fDu.cMR.getTid())) {
                    l.a(j.this.mTextTitle, j.this.fDu.cMR.getId(), (int) R.color.cp_cont_d, (int) R.color.cp_cont_d);
                }
            }
        };
        this.cQU = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.fDv = (FrameLayout) view.findViewById(R.id.layout_root);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.ect = (LinearLayout) view.findViewById(R.id.content_layout);
        this.JH = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.fDw = (CardForumHeadLayout) view.findViewById(R.id.card_home_page_ala_forum_head_layout);
        this.eIt = new NEGFeedBackView(this.cQU);
        this.eIt = new NEGFeedBackView(getTbPageContext());
        this.eIt.a(this.fDv, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds124), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds15), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds20));
        bse();
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fDx = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.dHI = (TbImageView) view.findViewById(R.id.image_video);
        this.dHI.setDrawCorner(true);
        this.dHI.setPlaceHolder(3);
        this.dHI.setDefaultResource(0);
        this.dHI.setDefaultErrorResource(0);
        this.dHI.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        TbImageView tbImageView = this.dHI;
        TbImageView tbImageView2 = this.dHI;
        tbImageView.setConrers(15);
        this.dHI.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.dHI.setBorderColor(am.getColor(R.color.cp_border_a));
        this.dHI.setBorderSurroundContent(true);
        this.dHI.setDrawBorder(true);
        this.fDy = (TBLottieAnimationView) view.findViewById(R.id.image_video_play);
        this.fDy.loop(true);
        am.a(this.fDy, R.raw.ala_play);
        this.fDy.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.j.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                j.this.fDy.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                j.this.fDy.cancelAnimation();
            }
        });
        this.fDA = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
        this.eIh = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.eIh.setOnClickListener(this);
        this.eIh.setReplyTimeVisible(false);
        this.eIh.setShowPraiseNum(true);
        this.eIh.setNeedAddReplyIcon(true);
        this.eIh.setNeedAddPraiseIcon(true);
        if (this.eIh.getCommentContainer() != null) {
            this.eIh.getCommentContainer().setOnClickListener(this);
        }
        this.eIh.setShareVisible(true);
        this.eIh.setFrom(7);
        this.eIh.setShareReportFrom(3);
        this.eIh.hideDisagree();
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cJm = 7;
        dVar.cJs = 1;
        this.eIh.setAgreeStatisticData(dVar);
        this.eIU = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_ala_source_read_share_layout);
        this.eIU.dep.setOnClickListener(this);
        this.eIU.setFrom(7);
        this.eIU.setShareReportFrom(3);
        if (this.eIU.dep.getCommentContainer() != null) {
            this.eIU.dep.getCommentContainer().setOnClickListener(this);
        }
        this.dHO = (TextView) view.findViewById(R.id.play_count);
        this.fDz = view.findViewById(R.id.divider_below_reply_number_layout);
        this.ect.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fDv, R.drawable.addresslist_item_bg);
            am.setBackgroundResource(this.ect, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.dHO, (int) R.color.cp_cont_a);
            am.a(this.fDy, R.raw.ala_play);
            am.setBackgroundResource(this.fDx, R.drawable.bg_ala_shape);
            this.JH.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fDw.onChangeSkinType();
            this.eIh.onChangeSkinType();
            if (this.eIt != null) {
                this.eIt.onChangeSkinType();
            }
            this.LW.onChangeSkinType();
            this.fDA.onChangeSkinType();
            this.eIU.onChangeSkinType();
            this.dHI.setPlaceHolder(3);
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
        this.fDu = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.fDu == null || this.fDu.axx() == null) {
            this.fDv.setVisibility(8);
            return;
        }
        this.fDv.setVisibility(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.cQU.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fDx.getLayoutParams();
            layoutParams.width = equipmentWidth - com.baidu.adp.lib.util.l.getDimens(this.cQU.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.fDx.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (!this.deB) {
            this.fDw.setVisibility(0);
            this.fDw.setData(this.fDu.axx());
            this.fDw.setAfterClickListener(this.ddt);
        } else {
            this.JH.setVisibility(0);
            this.JH.setData(this.fDu.axx());
            this.JH.setUserAfterClickListener(this.MT);
        }
        this.fDu.axx().aAA();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.fDu.axx().aAl());
        if (!this.deB) {
            String format = String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), this.fDu.axx().azE().getName_show());
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(new com.baidu.tbadk.widget.richText.f(16, this.fDu.axx().azE().getUserId()) { // from class: com.baidu.tieba.card.j.3
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(view.getContext(), getLink(), null)));
                    j.this.MT.onClick(view);
                }
            }, 0, format.length() - 1, 33);
            spannableStringBuilder.insert(0, (CharSequence) spannableString);
            this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.h(spannableStringBuilder));
        }
        this.mTextTitle.setText(spannableStringBuilder);
        this.dHO.setText(String.format(this.cQU.getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.fDu.cMR.azX().audience_count)));
        if (this.deB) {
            this.fDA.q(this.fDu.axx());
        }
        this.LW.q(this.fDu.axx());
        if (this.deB) {
            this.eIt.setVisibility(8);
            if (!au.u(this.fDu.axx())) {
                this.LW.setVisibility(0);
            } else {
                this.LW.setVisibility(8);
            }
        } else {
            if (this.eIt != null && this.fDu.axx() != null) {
                al alVar = new al();
                alVar.setTid(this.fDu.axx().getTid());
                alVar.setFid(this.fDu.axx().getFid());
                alVar.setFeedBackReasonMap(this.fDu.feedBackReasonMap);
                this.eIt.setData(alVar);
                this.eIt.setFirstRowSingleColumn(true);
            }
            this.LW.setVisibility(8);
        }
        pp(nL(1));
        onChangeSkinType(this.cQU, TbadkCoreApplication.getInst().getSkinType());
        if (l.zt(this.fDu.cMR.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        bsb();
        this.fDy.playAnimation();
    }

    public void bsb() {
        if (com.baidu.tbadk.core.i.axf().isShowImages() && this.fDu != null && this.fDu.axx() != null && this.fDu.axx().azX() != null) {
            this.dHI.setPlaceHolder(3);
            this.dHI.startLoad(this.fDu.axx().azX().cover, 10, false);
            this.fDx.setVisibility(0);
            return;
        }
        this.fDx.setVisibility(8);
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.eIt != null) {
            this.eIt.setEventCallback(aVar);
        }
    }

    public View bsc() {
        if (this.JH != null) {
            return this.JH.getAvatar();
        }
        return null;
    }

    public View bsd() {
        if (this.deB) {
            if (this.JH != null) {
                return this.JH.getUserName();
            }
            return null;
        }
        return this.mTextTitle;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ect || view == this.eIh.getCommentContainer() || view == this.eIU.dep.getCommentContainer()) {
            bz(view);
        }
    }

    private void bz(View view) {
        if (brY() != null) {
            brY().a(view, this.fDu);
        }
        if (this.fDu != null && this.fDu.axx() != null && this.fDu.axx().azX() != null) {
            l.zs(this.fDu.cMR.getId());
            l.a(this.mTextTitle, this.fDu.cMR.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.fDu.axx().azX());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.cQU.getPageActivity(), alaLiveInfoCoreData, "home_rec_play", "", false, "")));
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.eIh != null && this.fDC != null) {
            if (this.JH != null) {
                this.JH.setPageUniqueId(bdUniqueId);
            }
            this.fDC.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.eIt != null) {
                this.eIt.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.fDC);
        }
    }

    public void pp(int i) {
        if (this.fDu != null && this.fDu.cMR != null) {
            if (i == 1) {
                this.eIh.setVisibility(8);
                this.eIU.setData(this.fDu.cMR);
                return;
            }
            this.eIU.setVisibility(8);
            if (this.eIh.setData(this.fDu.cMR)) {
                this.fDz.setVisibility(8);
            } else {
                this.fDz.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.La = str;
    }

    public int nL(int i) {
        return com.baidu.tieba.a.d.aUV().aj(this.La, i);
    }

    public void rd(int i) {
        if (this.eIh != null) {
            this.eIh.ddr = String.valueOf(i);
        }
    }

    public void fs(boolean z) {
        this.deB = z;
    }

    private void bse() {
        this.LW = new UnfollowedDecorView(this.cQU.getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds124);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds20);
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds15);
        layoutParams.gravity = 85;
        this.fDv.addView(this.LW, layoutParams);
    }
}
