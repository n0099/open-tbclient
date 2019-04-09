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
    private CardUserInfoLayout Xx;
    private String YB;
    private View.OnClickListener ZI;
    public View aLf;
    private View.OnClickListener bRC;
    public TbImageView cAg;
    private TextView cAm;
    private NEGFeedBackView dqK;
    public NewThreadCommentAndPraiseInfoLayout drn;
    public ThreadSourceShareAndPraiseLayout dro;
    public LinearLayout drz;
    private com.baidu.tieba.card.data.j ehn;
    public FrameLayout eho;
    public RelativeLayout ehp;
    public TBLottieAnimationView ehq;
    private View ehr;
    private ThreadForumEnterButton ehs;
    private CustomMessageListener eht;
    private TbPageContext<?> mContext;
    public TextView mTextTitle;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dqK = null;
        this.ZI = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.aQf() != null) {
                    l.this.aQf().a(view, l.this.ehn);
                }
            }
        };
        this.bRC = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.aQf() != null) {
                    l.this.aQf().a(view, l.this.ehn);
                }
            }
        };
        this.eht = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.l.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && l.this.ehn != null && l.this.ehn.threadData != null && l.this.ehn.threadData.getTid() != null && l.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(l.this.ehn.threadData.getTid())) {
                    n.a(l.this.mTextTitle, l.this.ehn.threadData.getId(), d.C0277d.cp_cont_d, d.C0277d.cp_cont_d);
                }
            }
        };
        this.mContext = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.eho = (FrameLayout) view.findViewById(d.g.layout_root);
        this.aLf = view.findViewById(d.g.divider_line);
        this.drz = (LinearLayout) view.findViewById(d.g.content_layout);
        this.Xx = (CardUserInfoLayout) view.findViewById(d.g.card_home_page_ala_video_user_info_layout);
        this.dqK = new NEGFeedBackView(this.mContext);
        this.dqK = new NEGFeedBackView(getTbPageContext());
        this.dqK.a(this.eho, com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds115), 0, com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds32), com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds3));
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.ehp = (RelativeLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ehp.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.tbds88);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.ehp.setLayoutParams(layoutParams);
        this.cAg = (TbImageView) view.findViewById(d.g.image_video);
        this.cAg.setDrawCorner(true);
        this.cAg.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        this.cAg.setDefaultResource(0);
        this.cAg.setDefaultErrorResource(0);
        this.cAg.setRadius(com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds20));
        TbImageView tbImageView = this.cAg;
        TbImageView tbImageView2 = this.cAg;
        tbImageView.setConrers(15);
        this.cAg.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
        this.cAg.setBorderColor(al.getColor(d.C0277d.black_alpha8));
        this.cAg.setBorderSurroundContent(true);
        this.cAg.setDrawBorder(true);
        this.ehq = (TBLottieAnimationView) view.findViewById(d.g.image_video_play);
        this.ehq.G(true);
        al.a(this.ehq, d.i.ala_play);
        this.ehq.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.l.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                l.this.ehq.cu();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                l.this.ehq.cancelAnimation();
            }
        });
        this.ehs = (ThreadForumEnterButton) view.findViewById(d.g.card_home_page_forum_enter_button);
        this.drn = (NewThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.drn.setOnClickListener(this);
        this.drn.setReplyTimeVisible(false);
        this.drn.setShowPraiseNum(true);
        this.drn.setNeedAddReplyIcon(true);
        this.drn.setNeedAddPraiseIcon(true);
        if (this.drn.getCommentContainer() != null) {
            this.drn.getCommentContainer().setOnClickListener(this);
        }
        this.drn.setShareVisible(true);
        this.drn.setFrom(7);
        this.drn.setShareReportFrom(3);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bxn = 7;
        dVar.bxs = 1;
        this.drn.setAgreeStatisticData(dVar);
        this.dro = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_ala_source_read_share_layout);
        this.dro.bTC.setOnClickListener(this);
        this.dro.setFrom(7);
        this.dro.setShareReportFrom(3);
        if (this.dro.bTC.getCommentContainer() != null) {
            this.dro.bTC.getCommentContainer().setOnClickListener(this);
        }
        this.cAm = (TextView) view.findViewById(d.g.play_count);
        this.ehr = view.findViewById(d.g.divider_below_reply_number_layout);
        this.drz.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.eho, d.f.addresslist_item_bg);
            al.k(this.drz, d.f.addresslist_item_bg);
            al.l(this.aLf, d.C0277d.cp_bg_line_e);
            al.j(this.mTextTitle, d.C0277d.cp_cont_b);
            al.j(this.cAm, d.C0277d.cp_btn_a);
            al.a(this.ehq, d.i.ala_play);
            al.k(this.ehp, d.f.bg_ala_shape);
            this.Xx.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.drn.onChangeSkinType();
            if (this.dqK != null) {
                this.dqK.onChangeSkinType();
            }
            this.ehs.onChangeSkinType();
            this.dro.onChangeSkinType();
            this.cAg.setDefaultBgResource(com.baidu.tbadk.util.e.get());
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
        this.ehn = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.ehn == null || this.ehn.WO() == null) {
            this.eho.setVisibility(8);
            return;
        }
        this.eho.setVisibility(0);
        this.Xx.setData(this.ehn.WO());
        this.Xx.setUserAfterClickListener(this.ZI);
        this.ehn.WO().ZE();
        this.mTextTitle.setText(new SpannableStringBuilder(this.ehn.WO().Zu()));
        this.cAm.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), ap.az(this.ehn.threadData.Zh().audience_count)));
        this.ehs.w(this.ehn.WO());
        if (this.dqK != null && this.ehn.WO() != null) {
            aj ajVar = new aj();
            ajVar.setTid(this.ehn.WO().getTid());
            ajVar.setFid(this.ehn.WO().getFid());
            ajVar.b(this.ehn.bzy);
            this.dqK.setData(ajVar);
            this.dqK.setFirstRowSingleColumn(true);
        }
        mE(ls(1));
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.tA(this.ehn.threadData.getId())) {
            al.d(this.mTextTitle, d.C0277d.cp_cont_d, 1);
        } else {
            al.d(this.mTextTitle, d.C0277d.cp_cont_b, 1);
        }
        aQi();
        this.ehq.cu();
    }

    public void aQi() {
        if (com.baidu.tbadk.core.i.Wv().Wz() && this.ehn != null && this.ehn.WO() != null && this.ehn.WO().Zh() != null) {
            this.cAg.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.cAg.startLoad(this.ehn.WO().Zh().cover, 10, false);
            this.ehp.setVisibility(0);
            return;
        }
        this.ehp.setVisibility(8);
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.dqK != null) {
            this.dqK.setEventCallback(aVar);
        }
    }

    public View aQj() {
        if (this.Xx != null) {
            return this.Xx.getAvatar();
        }
        return null;
    }

    public View aQk() {
        if (this.Xx != null) {
            return this.Xx.getUserName();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.drz || view == this.drn.getCommentContainer() || view == this.dro.bTC.getCommentContainer()) {
            bw(view);
        }
    }

    private void bw(View view) {
        if (aQf() != null) {
            aQf().a(view, this.ehn);
        }
        if (this.ehn != null && this.ehn.WO() != null && this.ehn.WO().Zh() != null) {
            n.tz(this.ehn.threadData.getId());
            n.a(this.mTextTitle, this.ehn.threadData.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.ehn.WO().Zh());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.drn != null && this.eht != null) {
            if (this.Xx != null) {
                this.Xx.setPageUniqueId(bdUniqueId);
            }
            this.eht.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.dqK != null) {
                this.dqK.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.eht);
        }
    }

    public void mE(int i) {
        if (this.ehn != null && this.ehn.threadData != null) {
            if (i == 1) {
                this.drn.setVisibility(8);
                this.dro.setData(this.ehn.threadData);
                return;
            }
            this.dro.setVisibility(8);
            if (this.drn.setData(this.ehn.threadData)) {
                this.ehr.setVisibility(8);
            } else {
                this.ehr.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YB = str;
    }

    public int ls(int i) {
        return com.baidu.tieba.a.d.awh().ak(this.YB, i);
    }

    public void ok(int i) {
        if (this.drn != null) {
            this.drn.bSL = String.valueOf(i);
        }
    }
}
