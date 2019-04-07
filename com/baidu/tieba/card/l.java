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
    private View.OnClickListener ZH;
    public View aLe;
    private View.OnClickListener bRB;
    public TbImageView cAf;
    private TextView cAl;
    private NEGFeedBackView dqJ;
    public NewThreadCommentAndPraiseInfoLayout drm;
    public ThreadSourceShareAndPraiseLayout drn;
    public LinearLayout dry;
    private com.baidu.tieba.card.data.j ehm;
    public FrameLayout ehn;
    public RelativeLayout eho;
    public TBLottieAnimationView ehp;
    private View ehq;
    private ThreadForumEnterButton ehr;
    private CustomMessageListener ehs;
    private TbPageContext<?> mContext;
    public TextView mTextTitle;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dqJ = null;
        this.ZH = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.aQf() != null) {
                    l.this.aQf().a(view, l.this.ehm);
                }
            }
        };
        this.bRB = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.aQf() != null) {
                    l.this.aQf().a(view, l.this.ehm);
                }
            }
        };
        this.ehs = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.l.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && l.this.ehm != null && l.this.ehm.threadData != null && l.this.ehm.threadData.getTid() != null && l.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(l.this.ehm.threadData.getTid())) {
                    n.a(l.this.mTextTitle, l.this.ehm.threadData.getId(), d.C0277d.cp_cont_d, d.C0277d.cp_cont_d);
                }
            }
        };
        this.mContext = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.ehn = (FrameLayout) view.findViewById(d.g.layout_root);
        this.aLe = view.findViewById(d.g.divider_line);
        this.dry = (LinearLayout) view.findViewById(d.g.content_layout);
        this.Xw = (CardUserInfoLayout) view.findViewById(d.g.card_home_page_ala_video_user_info_layout);
        this.dqJ = new NEGFeedBackView(this.mContext);
        this.dqJ = new NEGFeedBackView(getTbPageContext());
        this.dqJ.a(this.ehn, com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds115), 0, com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds32), com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds3));
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.eho = (RelativeLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eho.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.tbds88);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.eho.setLayoutParams(layoutParams);
        this.cAf = (TbImageView) view.findViewById(d.g.image_video);
        this.cAf.setDrawCorner(true);
        this.cAf.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        this.cAf.setDefaultResource(0);
        this.cAf.setDefaultErrorResource(0);
        this.cAf.setRadius(com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds20));
        TbImageView tbImageView = this.cAf;
        TbImageView tbImageView2 = this.cAf;
        tbImageView.setConrers(15);
        this.cAf.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
        this.cAf.setBorderColor(al.getColor(d.C0277d.black_alpha8));
        this.cAf.setBorderSurroundContent(true);
        this.cAf.setDrawBorder(true);
        this.ehp = (TBLottieAnimationView) view.findViewById(d.g.image_video_play);
        this.ehp.G(true);
        al.a(this.ehp, d.i.ala_play);
        this.ehp.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.l.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                l.this.ehp.cu();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                l.this.ehp.cancelAnimation();
            }
        });
        this.ehr = (ThreadForumEnterButton) view.findViewById(d.g.card_home_page_forum_enter_button);
        this.drm = (NewThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.drm.setOnClickListener(this);
        this.drm.setReplyTimeVisible(false);
        this.drm.setShowPraiseNum(true);
        this.drm.setNeedAddReplyIcon(true);
        this.drm.setNeedAddPraiseIcon(true);
        if (this.drm.getCommentContainer() != null) {
            this.drm.getCommentContainer().setOnClickListener(this);
        }
        this.drm.setShareVisible(true);
        this.drm.setFrom(7);
        this.drm.setShareReportFrom(3);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bxm = 7;
        dVar.bxr = 1;
        this.drm.setAgreeStatisticData(dVar);
        this.drn = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_ala_source_read_share_layout);
        this.drn.bTB.setOnClickListener(this);
        this.drn.setFrom(7);
        this.drn.setShareReportFrom(3);
        if (this.drn.bTB.getCommentContainer() != null) {
            this.drn.bTB.getCommentContainer().setOnClickListener(this);
        }
        this.cAl = (TextView) view.findViewById(d.g.play_count);
        this.ehq = view.findViewById(d.g.divider_below_reply_number_layout);
        this.dry.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.ehn, d.f.addresslist_item_bg);
            al.k(this.dry, d.f.addresslist_item_bg);
            al.l(this.aLe, d.C0277d.cp_bg_line_e);
            al.j(this.mTextTitle, d.C0277d.cp_cont_b);
            al.j(this.cAl, d.C0277d.cp_btn_a);
            al.a(this.ehp, d.i.ala_play);
            al.k(this.eho, d.f.bg_ala_shape);
            this.Xw.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.drm.onChangeSkinType();
            if (this.dqJ != null) {
                this.dqJ.onChangeSkinType();
            }
            this.ehr.onChangeSkinType();
            this.drn.onChangeSkinType();
            this.cAf.setDefaultBgResource(com.baidu.tbadk.util.e.get());
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
        this.ehm = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.ehm == null || this.ehm.WO() == null) {
            this.ehn.setVisibility(8);
            return;
        }
        this.ehn.setVisibility(0);
        this.Xw.setData(this.ehm.WO());
        this.Xw.setUserAfterClickListener(this.ZH);
        this.ehm.WO().ZE();
        this.mTextTitle.setText(new SpannableStringBuilder(this.ehm.WO().Zu()));
        this.cAl.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), ap.az(this.ehm.threadData.Zh().audience_count)));
        this.ehr.w(this.ehm.WO());
        if (this.dqJ != null && this.ehm.WO() != null) {
            aj ajVar = new aj();
            ajVar.setTid(this.ehm.WO().getTid());
            ajVar.setFid(this.ehm.WO().getFid());
            ajVar.b(this.ehm.bzx);
            this.dqJ.setData(ajVar);
            this.dqJ.setFirstRowSingleColumn(true);
        }
        mE(ls(1));
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.tA(this.ehm.threadData.getId())) {
            al.d(this.mTextTitle, d.C0277d.cp_cont_d, 1);
        } else {
            al.d(this.mTextTitle, d.C0277d.cp_cont_b, 1);
        }
        aQi();
        this.ehp.cu();
    }

    public void aQi() {
        if (com.baidu.tbadk.core.i.Wv().Wz() && this.ehm != null && this.ehm.WO() != null && this.ehm.WO().Zh() != null) {
            this.cAf.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.cAf.startLoad(this.ehm.WO().Zh().cover, 10, false);
            this.eho.setVisibility(0);
            return;
        }
        this.eho.setVisibility(8);
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.dqJ != null) {
            this.dqJ.setEventCallback(aVar);
        }
    }

    public View aQj() {
        if (this.Xw != null) {
            return this.Xw.getAvatar();
        }
        return null;
    }

    public View aQk() {
        if (this.Xw != null) {
            return this.Xw.getUserName();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dry || view == this.drm.getCommentContainer() || view == this.drn.bTB.getCommentContainer()) {
            bw(view);
        }
    }

    private void bw(View view) {
        if (aQf() != null) {
            aQf().a(view, this.ehm);
        }
        if (this.ehm != null && this.ehm.WO() != null && this.ehm.WO().Zh() != null) {
            n.tz(this.ehm.threadData.getId());
            n.a(this.mTextTitle, this.ehm.threadData.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.ehm.WO().Zh());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.drm != null && this.ehs != null) {
            if (this.Xw != null) {
                this.Xw.setPageUniqueId(bdUniqueId);
            }
            this.ehs.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.dqJ != null) {
                this.dqJ.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.ehs);
        }
    }

    public void mE(int i) {
        if (this.ehm != null && this.ehm.threadData != null) {
            if (i == 1) {
                this.drm.setVisibility(8);
                this.drn.setData(this.ehm.threadData);
                return;
            }
            this.drn.setVisibility(8);
            if (this.drm.setData(this.ehm.threadData)) {
                this.ehq.setVisibility(8);
            } else {
                this.ehq.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YA = str;
    }

    public int ls(int i) {
        return com.baidu.tieba.a.d.awh().ak(this.YA, i);
    }

    public void ok(int i) {
        if (this.drm != null) {
            this.drm.bSK = String.valueOf(i);
        }
    }
}
