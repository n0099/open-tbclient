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
    private UnfollowedDecorView Mz;
    private View.OnClickListener Nw;
    private TbPageContext<?> cVg;
    public TbImageView dLW;
    private TextView dMc;
    private View.OnClickListener dhI;
    public boolean diT;
    public ThreadSourceShareAndPraiseLayout eNX;
    public ThreadCommentAndPraiseInfoLayout eNl;
    private NEGFeedBackView eNw;
    public LinearLayout egF;
    private com.baidu.tieba.card.data.j fJc;
    public FrameLayout fJd;
    public RelativeLayout fJe;
    private TBLottieAnimationView fJf;
    private View fJg;
    private ThreadForumEnterButton fJh;
    private View.OnClickListener fJi;
    private CustomMessageListener fJj;
    private BdUniqueId mBdUniqueId;
    public View mDivider;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.eNw = null;
        this.Mz = null;
        this.diT = false;
        this.mLastScreenWidth = 0;
        this.fJi = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        };
        this.Nw = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.buE() != null) {
                    j.this.buE().a(view, j.this.fJc);
                }
            }
        };
        this.dhI = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.buE() != null) {
                    j.this.buE().a(view, j.this.fJc);
                }
            }
        };
        this.fJj = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.j.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && j.this.fJc != null && j.this.fJc.cRe != null && j.this.fJc.cRe.getTid() != null && j.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(j.this.fJc.cRe.getTid())) {
                    l.a(j.this.mTextTitle, j.this.fJc.cRe.getId(), (int) R.color.cp_cont_d, (int) R.color.cp_cont_d);
                }
            }
        };
        this.cVg = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init(getView());
    }

    private void init(View view) {
        this.fJd = (FrameLayout) view.findViewById(R.id.layout_root);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.egF = (LinearLayout) view.findViewById(R.id.content_layout);
        this.Kj = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.Kj.setPageContext(this.cVg);
        this.Kj.setPageUniqueId(this.mBdUniqueId);
        this.eNw = new NEGFeedBackView(getTbPageContext());
        this.eNw.a(this.fJd, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds124), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds15), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds20));
        buK();
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fJe = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.dLW = (TbImageView) view.findViewById(R.id.image_video);
        this.dLW.setDrawCorner(true);
        this.dLW.setPlaceHolder(3);
        this.dLW.setDefaultResource(0);
        this.dLW.setDefaultErrorResource(0);
        this.dLW.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        TbImageView tbImageView = this.dLW;
        TbImageView tbImageView2 = this.dLW;
        tbImageView.setConrers(15);
        this.dLW.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.dLW.setBorderColor(am.getColor(R.color.cp_border_a));
        this.dLW.setBorderSurroundContent(true);
        this.dLW.setDrawBorder(true);
        this.fJf = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.fJf.loop(true);
        am.a(this.fJf, R.raw.ala_live2);
        this.fJf.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.j.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                j.this.fJf.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                j.this.fJf.cancelAnimation();
            }
        });
        this.fJh = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
        this.eNl = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.eNl.setOnClickListener(this);
        this.eNl.setReplyTimeVisible(false);
        this.eNl.setShowPraiseNum(true);
        this.eNl.setNeedAddReplyIcon(true);
        this.eNl.setNeedAddPraiseIcon(true);
        if (this.eNl.getCommentContainer() != null) {
            this.eNl.getCommentContainer().setOnClickListener(this);
        }
        this.eNl.setShareVisible(true);
        this.eNl.setFrom(7);
        this.eNl.setShareReportFrom(3);
        this.eNl.hideDisagree();
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNA = 7;
        dVar.cNG = 1;
        this.eNl.setAgreeStatisticData(dVar);
        this.eNX = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_ala_source_read_share_layout);
        this.eNX.diG.setOnClickListener(this);
        this.eNX.setFrom(7);
        this.eNX.setShareReportFrom(3);
        if (this.eNX.diG.getCommentContainer() != null) {
            this.eNX.diG.getCommentContainer().setOnClickListener(this);
        }
        this.dMc = (TextView) view.findViewById(R.id.play_count);
        this.fJg = view.findViewById(R.id.divider_below_reply_number_layout);
        this.egF.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fJd, R.drawable.addresslist_item_bg);
            am.setBackgroundResource(this.egF, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.dMc, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.fJe, R.drawable.bg_ala_shape);
            this.Kj.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.eNl.onChangeSkinType();
            if (this.eNw != null) {
                this.eNw.onChangeSkinType();
            }
            this.Mz.onChangeSkinType();
            this.fJh.onChangeSkinType();
            this.eNX.onChangeSkinType();
            this.dLW.setPlaceHolder(3);
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
        this.fJc = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.fJc == null || this.fJc.aAe() == null) {
            this.fJd.setVisibility(8);
            return;
        }
        this.fJd.setVisibility(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.cVg.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fJe.getLayoutParams();
            layoutParams.width = equipmentWidth - com.baidu.adp.lib.util.l.getDimens(this.cVg.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.fJe.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (this.fJc.aAe().aCF() != null && this.fJc.aAe().aCF().isChushou) {
            this.eNl.setShowFlag(10);
            this.eNl.hideShareContainer();
        } else {
            this.eNl.setShowFlag(11);
            this.eNl.resetShareContainer();
        }
        this.Kj.setVisibility(0);
        this.Kj.setData(this.fJc.aAe());
        this.Kj.setUserAfterClickListener(this.Nw);
        this.fJc.aAe().aDh();
        this.mTextTitle.setText(new SpannableStringBuilder(this.fJc.aAe().aCT()));
        if (this.fJc.cRe.aCF().audience_count > 0) {
            this.dMc.setVisibility(0);
            this.dMc.setText(String.format(this.cVg.getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.fJc.cRe.aCF().audience_count)));
        } else {
            this.dMc.setVisibility(8);
        }
        if (this.diT) {
            this.fJh.q(this.fJc.aAe());
        }
        this.Mz.q(this.fJc.aAe());
        if (this.diT) {
            this.eNw.setVisibility(8);
            if (!au.u(this.fJc.aAe())) {
                this.Mz.setVisibility(0);
            } else {
                this.Mz.setVisibility(8);
            }
        } else {
            if (this.eNw != null && this.fJc.aAe() != null) {
                al alVar = new al();
                alVar.setTid(this.fJc.aAe().getTid());
                alVar.setFid(this.fJc.aAe().getFid());
                alVar.setFeedBackReasonMap(this.fJc.feedBackReasonMap);
                this.eNw.setData(alVar);
                this.eNw.setFirstRowSingleColumn(true);
            }
            this.Mz.setVisibility(8);
        }
        pB(oc(1));
        onChangeSkinType(this.cVg, TbadkCoreApplication.getInst().getSkinType());
        if (l.zT(this.fJc.cRe.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        buH();
        this.fJf.playAnimation();
    }

    public void buH() {
        if (com.baidu.tbadk.core.i.azM().isShowImages() && this.fJc != null && this.fJc.aAe() != null && this.fJc.aAe().aCF() != null) {
            this.dLW.setPlaceHolder(3);
            this.dLW.startLoad(this.fJc.aAe().aCF().cover, 10, false);
            this.fJe.setVisibility(0);
            return;
        }
        this.fJe.setVisibility(8);
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.eNw != null) {
            this.eNw.setEventCallback(aVar);
        }
    }

    public View buI() {
        if (this.Kj != null) {
            return this.Kj.getAvatar();
        }
        return null;
    }

    public View buJ() {
        if (this.diT) {
            if (this.Kj != null) {
                return this.Kj.getUserName();
            }
            return null;
        }
        return this.mTextTitle;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.egF || view == this.eNl.getCommentContainer() || view == this.eNX.diG.getCommentContainer()) {
            if (this.fJc.aAe().aCF() != null && this.fJc.aAe().aCF().isChushou) {
                da(this.fJc.aAe().aCF().thirdRoomId, this.fJc.aAe().aCF().thirdLiveType);
            } else {
                bE(view);
            }
        }
    }

    private void da(String str, String str2) {
        ba.aGE().b(this.mTbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void bE(View view) {
        if (buE() != null) {
            buE().a(view, this.fJc);
        }
        if (this.fJc != null && this.fJc.aAe() != null && this.fJc.aAe().aCF() != null) {
            l.zS(this.fJc.cRe.getId());
            l.a(this.mTextTitle, this.fJc.cRe.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.fJc.aAe().aCF());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.cVg.getPageActivity(), alaLiveInfoCoreData, "home_rec_play", "", false, "")));
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.eNl != null && this.fJj != null) {
            if (this.Kj != null) {
                this.Kj.setPageUniqueId(bdUniqueId);
            }
            this.fJj.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.eNw != null) {
                this.eNw.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.fJj);
        }
    }

    public void pB(int i) {
        if (this.fJc != null && this.fJc.cRe != null) {
            if (i == 1) {
                this.eNl.setVisibility(8);
                this.eNX.setData(this.fJc.cRe);
                return;
            }
            this.eNX.setVisibility(8);
            if (this.eNl.setData(this.fJc.cRe)) {
                this.fJg.setVisibility(8);
            } else {
                this.fJg.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oc(int i) {
        return com.baidu.tieba.a.d.aXD().ai(this.LC, i);
    }

    public void rp(int i) {
        if (this.eNl != null) {
            this.eNl.dhG = String.valueOf(i);
        }
    }

    public void fE(boolean z) {
        this.diT = z;
    }

    private void buK() {
        this.Mz = new UnfollowedDecorView(this.cVg.getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds124);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds20);
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds15);
        layoutParams.gravity = 85;
        this.fJd.addView(this.Mz, layoutParams);
    }
}
