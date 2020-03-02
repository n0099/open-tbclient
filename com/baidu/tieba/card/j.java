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
    private TbPageContext<?> cVh;
    public TbImageView dLX;
    private TextView dMd;
    private View.OnClickListener dhJ;
    public boolean diU;
    public ThreadSourceShareAndPraiseLayout eNY;
    public ThreadCommentAndPraiseInfoLayout eNm;
    private NEGFeedBackView eNx;
    public LinearLayout egG;
    private com.baidu.tieba.card.data.j fJe;
    public FrameLayout fJf;
    public RelativeLayout fJg;
    private TBLottieAnimationView fJh;
    private View fJi;
    private ThreadForumEnterButton fJj;
    private View.OnClickListener fJk;
    private CustomMessageListener fJl;
    private BdUniqueId mBdUniqueId;
    public View mDivider;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.eNx = null;
        this.Mz = null;
        this.diU = false;
        this.mLastScreenWidth = 0;
        this.fJk = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        };
        this.Nw = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.buG() != null) {
                    j.this.buG().a(view, j.this.fJe);
                }
            }
        };
        this.dhJ = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.buG() != null) {
                    j.this.buG().a(view, j.this.fJe);
                }
            }
        };
        this.fJl = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.j.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && j.this.fJe != null && j.this.fJe.cRf != null && j.this.fJe.cRf.getTid() != null && j.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(j.this.fJe.cRf.getTid())) {
                    l.a(j.this.mTextTitle, j.this.fJe.cRf.getId(), (int) R.color.cp_cont_d, (int) R.color.cp_cont_d);
                }
            }
        };
        this.cVh = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init(getView());
    }

    private void init(View view) {
        this.fJf = (FrameLayout) view.findViewById(R.id.layout_root);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.egG = (LinearLayout) view.findViewById(R.id.content_layout);
        this.Kj = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.Kj.setPageContext(this.cVh);
        this.Kj.setPageUniqueId(this.mBdUniqueId);
        this.eNx = new NEGFeedBackView(getTbPageContext());
        this.eNx.a(this.fJf, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds124), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds15), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds20));
        buM();
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fJg = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.dLX = (TbImageView) view.findViewById(R.id.image_video);
        this.dLX.setDrawCorner(true);
        this.dLX.setPlaceHolder(3);
        this.dLX.setDefaultResource(0);
        this.dLX.setDefaultErrorResource(0);
        this.dLX.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        TbImageView tbImageView = this.dLX;
        TbImageView tbImageView2 = this.dLX;
        tbImageView.setConrers(15);
        this.dLX.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.dLX.setBorderColor(am.getColor(R.color.cp_border_a));
        this.dLX.setBorderSurroundContent(true);
        this.dLX.setDrawBorder(true);
        this.fJh = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.fJh.loop(true);
        am.a(this.fJh, R.raw.ala_live2);
        this.fJh.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.j.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                j.this.fJh.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                j.this.fJh.cancelAnimation();
            }
        });
        this.fJj = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
        this.eNm = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.eNm.setOnClickListener(this);
        this.eNm.setReplyTimeVisible(false);
        this.eNm.setShowPraiseNum(true);
        this.eNm.setNeedAddReplyIcon(true);
        this.eNm.setNeedAddPraiseIcon(true);
        if (this.eNm.getCommentContainer() != null) {
            this.eNm.getCommentContainer().setOnClickListener(this);
        }
        this.eNm.setShareVisible(true);
        this.eNm.setFrom(7);
        this.eNm.setShareReportFrom(3);
        this.eNm.hideDisagree();
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNB = 7;
        dVar.cNH = 1;
        this.eNm.setAgreeStatisticData(dVar);
        this.eNY = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_ala_source_read_share_layout);
        this.eNY.diH.setOnClickListener(this);
        this.eNY.setFrom(7);
        this.eNY.setShareReportFrom(3);
        if (this.eNY.diH.getCommentContainer() != null) {
            this.eNY.diH.getCommentContainer().setOnClickListener(this);
        }
        this.dMd = (TextView) view.findViewById(R.id.play_count);
        this.fJi = view.findViewById(R.id.divider_below_reply_number_layout);
        this.egG.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fJf, R.drawable.addresslist_item_bg);
            am.setBackgroundResource(this.egG, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.dMd, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.fJg, R.drawable.bg_ala_shape);
            this.Kj.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.eNm.onChangeSkinType();
            if (this.eNx != null) {
                this.eNx.onChangeSkinType();
            }
            this.Mz.onChangeSkinType();
            this.fJj.onChangeSkinType();
            this.eNY.onChangeSkinType();
            this.dLX.setPlaceHolder(3);
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
        this.fJe = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.fJe == null || this.fJe.aAg() == null) {
            this.fJf.setVisibility(8);
            return;
        }
        this.fJf.setVisibility(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.cVh.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fJg.getLayoutParams();
            layoutParams.width = equipmentWidth - com.baidu.adp.lib.util.l.getDimens(this.cVh.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.fJg.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (this.fJe.aAg().aCH() != null && this.fJe.aAg().aCH().isChushou) {
            this.eNm.setShowFlag(10);
            this.eNm.hideShareContainer();
        } else {
            this.eNm.setShowFlag(11);
            this.eNm.resetShareContainer();
        }
        this.Kj.setVisibility(0);
        this.Kj.setData(this.fJe.aAg());
        this.Kj.setUserAfterClickListener(this.Nw);
        this.fJe.aAg().aDj();
        this.mTextTitle.setText(new SpannableStringBuilder(this.fJe.aAg().aCV()));
        if (this.fJe.cRf.aCH().audience_count > 0) {
            this.dMd.setVisibility(0);
            this.dMd.setText(String.format(this.cVh.getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.fJe.cRf.aCH().audience_count)));
        } else {
            this.dMd.setVisibility(8);
        }
        if (this.diU) {
            this.fJj.q(this.fJe.aAg());
        }
        this.Mz.q(this.fJe.aAg());
        if (this.diU) {
            this.eNx.setVisibility(8);
            if (!au.u(this.fJe.aAg())) {
                this.Mz.setVisibility(0);
            } else {
                this.Mz.setVisibility(8);
            }
        } else {
            if (this.eNx != null && this.fJe.aAg() != null) {
                al alVar = new al();
                alVar.setTid(this.fJe.aAg().getTid());
                alVar.setFid(this.fJe.aAg().getFid());
                alVar.setFeedBackReasonMap(this.fJe.feedBackReasonMap);
                this.eNx.setData(alVar);
                this.eNx.setFirstRowSingleColumn(true);
            }
            this.Mz.setVisibility(8);
        }
        pB(oc(1));
        onChangeSkinType(this.cVh, TbadkCoreApplication.getInst().getSkinType());
        if (l.zT(this.fJe.cRf.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        buJ();
        this.fJh.playAnimation();
    }

    public void buJ() {
        if (com.baidu.tbadk.core.i.azO().isShowImages() && this.fJe != null && this.fJe.aAg() != null && this.fJe.aAg().aCH() != null) {
            this.dLX.setPlaceHolder(3);
            this.dLX.startLoad(this.fJe.aAg().aCH().cover, 10, false);
            this.fJg.setVisibility(0);
            return;
        }
        this.fJg.setVisibility(8);
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.eNx != null) {
            this.eNx.setEventCallback(aVar);
        }
    }

    public View buK() {
        if (this.Kj != null) {
            return this.Kj.getAvatar();
        }
        return null;
    }

    public View buL() {
        if (this.diU) {
            if (this.Kj != null) {
                return this.Kj.getUserName();
            }
            return null;
        }
        return this.mTextTitle;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.egG || view == this.eNm.getCommentContainer() || view == this.eNY.diH.getCommentContainer()) {
            if (this.fJe.aAg().aCH() != null && this.fJe.aAg().aCH().isChushou) {
                da(this.fJe.aAg().aCH().thirdRoomId, this.fJe.aAg().aCH().thirdLiveType);
            } else {
                bE(view);
            }
        }
    }

    private void da(String str, String str2) {
        ba.aGG().b(this.mTbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void bE(View view) {
        if (buG() != null) {
            buG().a(view, this.fJe);
        }
        if (this.fJe != null && this.fJe.aAg() != null && this.fJe.aAg().aCH() != null) {
            l.zS(this.fJe.cRf.getId());
            l.a(this.mTextTitle, this.fJe.cRf.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.fJe.aAg().aCH());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.cVh.getPageActivity(), alaLiveInfoCoreData, "home_rec_play", "", false, "")));
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.eNm != null && this.fJl != null) {
            if (this.Kj != null) {
                this.Kj.setPageUniqueId(bdUniqueId);
            }
            this.fJl.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.eNx != null) {
                this.eNx.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.fJl);
        }
    }

    public void pB(int i) {
        if (this.fJe != null && this.fJe.cRf != null) {
            if (i == 1) {
                this.eNm.setVisibility(8);
                this.eNY.setData(this.fJe.cRf);
                return;
            }
            this.eNY.setVisibility(8);
            if (this.eNm.setData(this.fJe.cRf)) {
                this.fJi.setVisibility(8);
            } else {
                this.fJi.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oc(int i) {
        return com.baidu.tieba.a.d.aXF().ai(this.LC, i);
    }

    public void rp(int i) {
        if (this.eNm != null) {
            this.eNm.dhH = String.valueOf(i);
        }
    }

    public void fE(boolean z) {
        this.diU = z;
    }

    private void buM() {
        this.Mz = new UnfollowedDecorView(this.cVh.getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds124);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds20);
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds15);
        layoutParams.gravity = 85;
        this.fJf.addView(this.Mz, layoutParams);
    }
}
