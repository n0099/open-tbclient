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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class l extends a<com.baidu.tieba.card.data.j> implements com.baidu.tieba.a.e {
    private CardUserInfoLayout VH;
    private String WN;
    private View.OnClickListener XU;
    public View aNH;
    public TbImageView cJJ;
    private TextView cJP;
    private View.OnClickListener caw;
    public boolean ccL;
    private NEGFeedBackView dEM;
    public NewThreadCommentAndPraiseInfoLayout dFn;
    public ThreadSourceShareAndPraiseLayout dFo;
    public LinearLayout dFz;
    private com.baidu.tieba.card.data.j eCa;
    public FrameLayout eCb;
    public RelativeLayout eCc;
    public TBLottieAnimationView eCd;
    private View eCe;
    private ThreadForumEnterButton eCf;
    private CustomMessageListener eCg;
    private TbPageContext<?> mContext;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dEM = null;
        this.ccL = false;
        this.mLastScreenWidth = 0;
        this.XU = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.aZo() != null) {
                    l.this.aZo().a(view, l.this.eCa);
                }
            }
        };
        this.caw = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.aZo() != null) {
                    l.this.aZo().a(view, l.this.eCa);
                }
            }
        };
        this.eCg = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.l.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && l.this.eCa != null && l.this.eCa.threadData != null && l.this.eCa.threadData.getTid() != null && l.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(l.this.eCa.threadData.getTid())) {
                    n.a(l.this.mTextTitle, l.this.eCa.threadData.getId(), (int) R.color.cp_cont_d, (int) R.color.cp_cont_d);
                }
            }
        };
        this.mContext = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.eCb = (FrameLayout) view.findViewById(R.id.layout_root);
        this.aNH = view.findViewById(R.id.divider_line);
        this.dFz = (LinearLayout) view.findViewById(R.id.content_layout);
        this.VH = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.dEM = new NEGFeedBackView(this.mContext);
        this.dEM = new NEGFeedBackView(getTbPageContext());
        this.dEM.a(this.eCb, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds115), 0, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds32), com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds3));
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.eCc = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.cJJ = (TbImageView) view.findViewById(R.id.image_video);
        this.cJJ.setDrawCorner(true);
        this.cJJ.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
        this.cJJ.setDefaultResource(0);
        this.cJJ.setDefaultErrorResource(0);
        this.cJJ.setRadius(com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds20));
        TbImageView tbImageView = this.cJJ;
        TbImageView tbImageView2 = this.cJJ;
        tbImageView.setConrers(15);
        this.cJJ.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.cJJ.setBorderColor(am.getColor(R.color.black_alpha8));
        this.cJJ.setBorderSurroundContent(true);
        this.cJJ.setDrawBorder(true);
        this.eCd = (TBLottieAnimationView) view.findViewById(R.id.image_video_play);
        this.eCd.y(true);
        am.a(this.eCd, (int) R.raw.ala_play);
        this.eCd.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.l.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                l.this.eCd.br();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                l.this.eCd.cancelAnimation();
            }
        });
        this.eCf = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
        this.dFn = (NewThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.dFn.setOnClickListener(this);
        this.dFn.setReplyTimeVisible(false);
        this.dFn.setShowPraiseNum(true);
        this.dFn.setNeedAddReplyIcon(true);
        this.dFn.setNeedAddPraiseIcon(true);
        if (this.dFn.getCommentContainer() != null) {
            this.dFn.getCommentContainer().setOnClickListener(this);
        }
        this.dFn.setShareVisible(true);
        this.dFn.setFrom(7);
        this.dFn.setShareReportFrom(3);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bFz = 7;
        dVar.bFE = 1;
        this.dFn.setAgreeStatisticData(dVar);
        this.dFo = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_ala_source_read_share_layout);
        this.dFo.ccA.setOnClickListener(this);
        this.dFo.setFrom(7);
        this.dFo.setShareReportFrom(3);
        if (this.dFo.ccA.getCommentContainer() != null) {
            this.dFo.ccA.getCommentContainer().setOnClickListener(this);
        }
        this.cJP = (TextView) view.findViewById(R.id.play_count);
        this.eCe = view.findViewById(R.id.divider_below_reply_number_layout);
        this.dFz.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(this.eCb, R.drawable.addresslist_item_bg);
            am.k(this.dFz, R.drawable.addresslist_item_bg);
            am.l(this.aNH, R.color.cp_bg_line_e);
            am.j(this.mTextTitle, R.color.cp_cont_b);
            am.j(this.cJP, R.color.cp_btn_a);
            am.a(this.eCd, (int) R.raw.ala_play);
            am.k(this.eCc, R.drawable.bg_ala_shape);
            this.VH.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.dFn.onChangeSkinType();
            if (this.dEM != null) {
                this.dEM.onChangeSkinType();
            }
            this.eCf.onChangeSkinType();
            this.dFo.onChangeSkinType();
            this.cJJ.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
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
        this.eCa = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.eCa == null || this.eCa.acx() == null) {
            this.eCb.setVisibility(8);
            return;
        }
        this.eCb.setVisibility(0);
        int af = com.baidu.adp.lib.util.l.af(this.mContext.getPageActivity());
        if (af != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eCc.getLayoutParams();
            layoutParams.width = af - com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.eCc.setLayoutParams(layoutParams);
            this.mLastScreenWidth = af;
        }
        this.VH.setData(this.eCa.acx());
        this.VH.setUserAfterClickListener(this.XU);
        this.eCa.acx().afn();
        this.mTextTitle.setText(new SpannableStringBuilder(this.eCa.acx().afd()));
        this.cJP.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), aq.aO(this.eCa.threadData.aeQ().audience_count)));
        this.eCf.w(this.eCa.acx());
        if (this.ccL) {
            this.dEM.setVisibility(8);
        } else if (this.dEM != null && this.eCa.acx() != null) {
            aj ajVar = new aj();
            ajVar.setTid(this.eCa.acx().getTid());
            ajVar.setFid(this.eCa.acx().getFid());
            ajVar.b(this.eCa.bHL);
            this.dEM.setData(ajVar);
            this.dEM.setFirstRowSingleColumn(true);
        }
        nE(mo(1));
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.vx(this.eCa.threadData.getId())) {
            am.f(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.f(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        aZr();
        this.eCd.br();
    }

    public void aZr() {
        if (com.baidu.tbadk.core.i.aca().ace() && this.eCa != null && this.eCa.acx() != null && this.eCa.acx().aeQ() != null) {
            this.cJJ.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
            this.cJJ.startLoad(this.eCa.acx().aeQ().cover, 10, false);
            this.eCc.setVisibility(0);
            return;
        }
        this.eCc.setVisibility(8);
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.dEM != null) {
            this.dEM.setEventCallback(aVar);
        }
    }

    public View aZs() {
        if (this.VH != null) {
            return this.VH.getAvatar();
        }
        return null;
    }

    public View aZt() {
        if (this.VH != null) {
            return this.VH.getUserName();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dFz || view == this.dFn.getCommentContainer() || view == this.dFo.ccA.getCommentContainer()) {
            bF(view);
        }
    }

    private void bF(View view) {
        if (aZo() != null) {
            aZo().a(view, this.eCa);
        }
        if (this.eCa != null && this.eCa.acx() != null && this.eCa.acx().aeQ() != null) {
            n.vw(this.eCa.threadData.getId());
            n.a(this.mTextTitle, this.eCa.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.eCa.acx().aeQ());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dFn != null && this.eCg != null) {
            if (this.VH != null) {
                this.VH.setPageUniqueId(bdUniqueId);
            }
            this.eCg.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.dEM != null) {
                this.dEM.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.eCg);
        }
    }

    public void nE(int i) {
        if (this.eCa != null && this.eCa.threadData != null) {
            if (i == 1) {
                this.dFn.setVisibility(8);
                this.dFo.setData(this.eCa.threadData);
                return;
            }
            this.dFo.setVisibility(8);
            if (this.dFn.setData(this.eCa.threadData)) {
                this.eCe.setVisibility(8);
            } else {
                this.eCe.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.WN = str;
    }

    public int mo(int i) {
        return com.baidu.tieba.a.d.aCF().ag(this.WN, i);
    }

    public void pE(int i) {
        if (this.dFn != null) {
            this.dFn.cbG = String.valueOf(i);
        }
    }

    public void dP(boolean z) {
        this.ccL = z;
    }
}
