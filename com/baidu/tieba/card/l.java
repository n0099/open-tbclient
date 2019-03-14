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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class l extends a<com.baidu.tieba.card.data.j> implements com.baidu.tieba.a.e {
    private CardUserInfoLayout Xw;
    private String YA;
    private View.OnClickListener ZG;
    public View aLb;
    private View.OnClickListener bRz;
    public TbImageView cAd;
    private TextView cAj;
    private NEGFeedBackView dqG;
    public NewThreadCommentAndPraiseInfoLayout drj;
    public ThreadSourceShareAndPraiseLayout drk;
    public LinearLayout drv;
    private com.baidu.tieba.card.data.j ehA;
    public FrameLayout ehB;
    public RelativeLayout ehC;
    public TBLottieAnimationView ehD;
    private View ehE;
    private ThreadForumEnterButton ehF;
    private CustomMessageListener ehG;
    private TbPageContext<?> mContext;
    public TextView mTextTitle;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dqG = null;
        this.ZG = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.aQh() != null) {
                    l.this.aQh().a(view, l.this.ehA);
                }
            }
        };
        this.bRz = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.aQh() != null) {
                    l.this.aQh().a(view, l.this.ehA);
                }
            }
        };
        this.ehG = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.l.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && l.this.ehA != null && l.this.ehA.threadData != null && l.this.ehA.threadData.getTid() != null && l.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(l.this.ehA.threadData.getTid())) {
                    n.a(l.this.mTextTitle, l.this.ehA.threadData.getId(), d.C0277d.cp_cont_d, d.C0277d.cp_cont_d);
                }
            }
        };
        this.mContext = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.ehB = (FrameLayout) view.findViewById(d.g.layout_root);
        this.aLb = view.findViewById(d.g.divider_line);
        this.drv = (LinearLayout) view.findViewById(d.g.content_layout);
        this.Xw = (CardUserInfoLayout) view.findViewById(d.g.card_home_page_ala_video_user_info_layout);
        this.dqG = new NEGFeedBackView(this.mContext);
        this.dqG = new NEGFeedBackView(getTbPageContext());
        this.dqG.a(this.ehB, com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds115), 0, com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds32), com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds3));
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.ehC = (RelativeLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ehC.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.tbds88);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.ehC.setLayoutParams(layoutParams);
        this.cAd = (TbImageView) view.findViewById(d.g.image_video);
        this.cAd.setDrawCorner(true);
        this.cAd.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        this.cAd.setDefaultResource(0);
        this.cAd.setDefaultErrorResource(0);
        this.cAd.setRadius(com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds20));
        TbImageView tbImageView = this.cAd;
        TbImageView tbImageView2 = this.cAd;
        tbImageView.setConrers(15);
        this.cAd.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
        this.cAd.setBorderColor(al.getColor(d.C0277d.black_alpha8));
        this.cAd.setBorderSurroundContent(true);
        this.cAd.setDrawBorder(true);
        this.ehD = (TBLottieAnimationView) view.findViewById(d.g.image_video_play);
        this.ehD.G(true);
        al.a(this.ehD, d.i.ala_play);
        this.ehD.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.l.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                l.this.ehD.cu();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                l.this.ehD.cancelAnimation();
            }
        });
        this.ehF = (ThreadForumEnterButton) view.findViewById(d.g.card_home_page_forum_enter_button);
        this.drj = (NewThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.drj.setOnClickListener(this);
        this.drj.setReplyTimeVisible(false);
        this.drj.setShowPraiseNum(true);
        this.drj.setNeedAddReplyIcon(true);
        this.drj.setNeedAddPraiseIcon(true);
        if (this.drj.getCommentContainer() != null) {
            this.drj.getCommentContainer().setOnClickListener(this);
        }
        this.drj.setShareVisible(true);
        this.drj.setFrom(7);
        this.drj.setShareReportFrom(3);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bxj = 7;
        dVar.bxo = 1;
        this.drj.setAgreeStatisticData(dVar);
        this.drk = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_ala_source_read_share_layout);
        this.drk.bTz.setOnClickListener(this);
        this.drk.setFrom(7);
        this.drk.setShareReportFrom(3);
        if (this.drk.bTz.getCommentContainer() != null) {
            this.drk.bTz.getCommentContainer().setOnClickListener(this);
        }
        this.cAj = (TextView) view.findViewById(d.g.play_count);
        this.ehE = view.findViewById(d.g.divider_below_reply_number_layout);
        this.drv.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.ehB, d.f.addresslist_item_bg);
            al.k(this.drv, d.f.addresslist_item_bg);
            al.l(this.aLb, d.C0277d.cp_bg_line_e);
            al.j(this.mTextTitle, d.C0277d.cp_cont_b);
            al.j(this.cAj, d.C0277d.cp_btn_a);
            al.a(this.ehD, d.i.ala_play);
            al.k(this.ehC, d.f.bg_ala_shape);
            this.Xw.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.drj.onChangeSkinType();
            if (this.dqG != null) {
                this.dqG.onChangeSkinType();
            }
            this.ehF.onChangeSkinType();
            this.drk.onChangeSkinType();
            this.cAd.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_ala_live_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.j jVar) {
        this.ehA = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.ehA == null || this.ehA.WR() == null) {
            this.ehB.setVisibility(8);
            return;
        }
        this.ehB.setVisibility(0);
        this.Xw.setData(this.ehA.WR());
        this.Xw.setUserAfterClickListener(this.ZG);
        this.ehA.WR().ZH();
        this.mTextTitle.setText(new SpannableStringBuilder(this.ehA.WR().Zx()));
        this.cAj.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), ap.az(this.ehA.threadData.Zk().audience_count)));
        this.ehF.w(this.ehA.WR());
        if (this.dqG != null && this.ehA.WR() != null) {
            aj ajVar = new aj();
            ajVar.setTid(this.ehA.WR().getTid());
            ajVar.setFid(this.ehA.WR().getFid());
            ajVar.b(this.ehA.bzu);
            this.dqG.setData(ajVar);
            this.dqG.setFirstRowSingleColumn(true);
        }
        mF(lt(1));
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.tB(this.ehA.threadData.getId())) {
            al.d(this.mTextTitle, d.C0277d.cp_cont_d, 1);
        } else {
            al.d(this.mTextTitle, d.C0277d.cp_cont_b, 1);
        }
        aQk();
        this.ehD.cu();
    }

    public void aQk() {
        if (com.baidu.tbadk.core.i.Wy().WC() && this.ehA != null && this.ehA.WR() != null && this.ehA.WR().Zk() != null) {
            this.cAd.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.cAd.startLoad(this.ehA.WR().Zk().cover, 10, false);
            this.ehC.setVisibility(0);
            return;
        }
        this.ehC.setVisibility(8);
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.dqG != null) {
            this.dqG.setEventCallback(aVar);
        }
    }

    public View aQl() {
        if (this.Xw != null) {
            return this.Xw.getAvatar();
        }
        return null;
    }

    public View aQm() {
        if (this.Xw != null) {
            return this.Xw.getUserName();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.drv || view == this.drj.getCommentContainer() || view == this.drk.bTz.getCommentContainer()) {
            bw(view);
        }
    }

    private void bw(View view) {
        if (aQh() != null) {
            aQh().a(view, this.ehA);
        }
        if (this.ehA != null && this.ehA.WR() != null && this.ehA.WR().Zk() != null) {
            n.tA(this.ehA.threadData.getId());
            n.a(this.mTextTitle, this.ehA.threadData.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.ehA.WR().Zk());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.drj != null && this.ehG != null) {
            if (this.Xw != null) {
                this.Xw.setPageUniqueId(bdUniqueId);
            }
            this.ehG.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.dqG != null) {
                this.dqG.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.ehG);
        }
    }

    public void mF(int i) {
        if (this.ehA != null && this.ehA.threadData != null) {
            if (i == 1) {
                this.drj.setVisibility(8);
                this.drk.setData(this.ehA.threadData);
                return;
            }
            this.drk.setVisibility(8);
            if (this.drj.setData(this.ehA.threadData)) {
                this.ehE.setVisibility(8);
            } else {
                this.ehE.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YA = str;
    }

    public int lt(int i) {
        return com.baidu.tieba.a.d.awk().ak(this.YA, i);
    }

    public void oo(int i) {
        if (this.drj != null) {
            this.drj.bSI = String.valueOf(i);
        }
    }
}
