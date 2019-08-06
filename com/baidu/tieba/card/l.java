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
    public TbImageView cJQ;
    private TextView cJW;
    private View.OnClickListener caC;
    public boolean ccS;
    private NEGFeedBackView dET;
    public LinearLayout dFG;
    public NewThreadCommentAndPraiseInfoLayout dFu;
    public ThreadSourceShareAndPraiseLayout dFv;
    private com.baidu.tieba.card.data.j eCh;
    public FrameLayout eCi;
    public RelativeLayout eCj;
    public TBLottieAnimationView eCk;
    private View eCl;
    private ThreadForumEnterButton eCm;
    private CustomMessageListener eCn;
    private TbPageContext<?> mContext;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dET = null;
        this.ccS = false;
        this.mLastScreenWidth = 0;
        this.XU = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.aZq() != null) {
                    l.this.aZq().a(view, l.this.eCh);
                }
            }
        };
        this.caC = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.aZq() != null) {
                    l.this.aZq().a(view, l.this.eCh);
                }
            }
        };
        this.eCn = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.l.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && l.this.eCh != null && l.this.eCh.threadData != null && l.this.eCh.threadData.getTid() != null && l.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(l.this.eCh.threadData.getTid())) {
                    n.a(l.this.mTextTitle, l.this.eCh.threadData.getId(), (int) R.color.cp_cont_d, (int) R.color.cp_cont_d);
                }
            }
        };
        this.mContext = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.eCi = (FrameLayout) view.findViewById(R.id.layout_root);
        this.aNH = view.findViewById(R.id.divider_line);
        this.dFG = (LinearLayout) view.findViewById(R.id.content_layout);
        this.VH = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.dET = new NEGFeedBackView(this.mContext);
        this.dET = new NEGFeedBackView(getTbPageContext());
        this.dET.a(this.eCi, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds115), 0, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds32), com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds3));
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.eCj = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.cJQ = (TbImageView) view.findViewById(R.id.image_video);
        this.cJQ.setDrawCorner(true);
        this.cJQ.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
        this.cJQ.setDefaultResource(0);
        this.cJQ.setDefaultErrorResource(0);
        this.cJQ.setRadius(com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds20));
        TbImageView tbImageView = this.cJQ;
        TbImageView tbImageView2 = this.cJQ;
        tbImageView.setConrers(15);
        this.cJQ.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.cJQ.setBorderColor(am.getColor(R.color.black_alpha8));
        this.cJQ.setBorderSurroundContent(true);
        this.cJQ.setDrawBorder(true);
        this.eCk = (TBLottieAnimationView) view.findViewById(R.id.image_video_play);
        this.eCk.y(true);
        am.a(this.eCk, (int) R.raw.ala_play);
        this.eCk.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.l.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                l.this.eCk.br();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                l.this.eCk.cancelAnimation();
            }
        });
        this.eCm = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
        this.dFu = (NewThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.dFu.setOnClickListener(this);
        this.dFu.setReplyTimeVisible(false);
        this.dFu.setShowPraiseNum(true);
        this.dFu.setNeedAddReplyIcon(true);
        this.dFu.setNeedAddPraiseIcon(true);
        if (this.dFu.getCommentContainer() != null) {
            this.dFu.getCommentContainer().setOnClickListener(this);
        }
        this.dFu.setShareVisible(true);
        this.dFu.setFrom(7);
        this.dFu.setShareReportFrom(3);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bFA = 7;
        dVar.bFF = 1;
        this.dFu.setAgreeStatisticData(dVar);
        this.dFv = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_ala_source_read_share_layout);
        this.dFv.ccH.setOnClickListener(this);
        this.dFv.setFrom(7);
        this.dFv.setShareReportFrom(3);
        if (this.dFv.ccH.getCommentContainer() != null) {
            this.dFv.ccH.getCommentContainer().setOnClickListener(this);
        }
        this.cJW = (TextView) view.findViewById(R.id.play_count);
        this.eCl = view.findViewById(R.id.divider_below_reply_number_layout);
        this.dFG.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(this.eCi, R.drawable.addresslist_item_bg);
            am.k(this.dFG, R.drawable.addresslist_item_bg);
            am.l(this.aNH, R.color.cp_bg_line_e);
            am.j(this.mTextTitle, R.color.cp_cont_b);
            am.j(this.cJW, R.color.cp_btn_a);
            am.a(this.eCk, (int) R.raw.ala_play);
            am.k(this.eCj, R.drawable.bg_ala_shape);
            this.VH.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.dFu.onChangeSkinType();
            if (this.dET != null) {
                this.dET.onChangeSkinType();
            }
            this.eCm.onChangeSkinType();
            this.dFv.onChangeSkinType();
            this.cJQ.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
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
        this.eCh = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.eCh == null || this.eCh.acy() == null) {
            this.eCi.setVisibility(8);
            return;
        }
        this.eCi.setVisibility(0);
        int af = com.baidu.adp.lib.util.l.af(this.mContext.getPageActivity());
        if (af != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eCj.getLayoutParams();
            layoutParams.width = af - com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.eCj.setLayoutParams(layoutParams);
            this.mLastScreenWidth = af;
        }
        this.VH.setData(this.eCh.acy());
        this.VH.setUserAfterClickListener(this.XU);
        this.eCh.acy().afo();
        this.mTextTitle.setText(new SpannableStringBuilder(this.eCh.acy().afe()));
        this.cJW.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), aq.aO(this.eCh.threadData.aeR().audience_count)));
        this.eCm.x(this.eCh.acy());
        if (this.ccS) {
            this.dET.setVisibility(8);
        } else if (this.dET != null && this.eCh.acy() != null) {
            aj ajVar = new aj();
            ajVar.setTid(this.eCh.acy().getTid());
            ajVar.setFid(this.eCh.acy().getFid());
            ajVar.b(this.eCh.bHM);
            this.dET.setData(ajVar);
            this.dET.setFirstRowSingleColumn(true);
        }
        nF(mp(1));
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.vy(this.eCh.threadData.getId())) {
            am.f(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.f(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        aZt();
        this.eCk.br();
    }

    public void aZt() {
        if (com.baidu.tbadk.core.i.aca().ace() && this.eCh != null && this.eCh.acy() != null && this.eCh.acy().aeR() != null) {
            this.cJQ.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
            this.cJQ.startLoad(this.eCh.acy().aeR().cover, 10, false);
            this.eCj.setVisibility(0);
            return;
        }
        this.eCj.setVisibility(8);
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.dET != null) {
            this.dET.setEventCallback(aVar);
        }
    }

    public View aZu() {
        if (this.VH != null) {
            return this.VH.getAvatar();
        }
        return null;
    }

    public View aZv() {
        if (this.VH != null) {
            return this.VH.getUserName();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dFG || view == this.dFu.getCommentContainer() || view == this.dFv.ccH.getCommentContainer()) {
            bF(view);
        }
    }

    private void bF(View view) {
        if (aZq() != null) {
            aZq().a(view, this.eCh);
        }
        if (this.eCh != null && this.eCh.acy() != null && this.eCh.acy().aeR() != null) {
            n.vx(this.eCh.threadData.getId());
            n.a(this.mTextTitle, this.eCh.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.eCh.acy().aeR());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dFu != null && this.eCn != null) {
            if (this.VH != null) {
                this.VH.setPageUniqueId(bdUniqueId);
            }
            this.eCn.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.dET != null) {
                this.dET.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.eCn);
        }
    }

    public void nF(int i) {
        if (this.eCh != null && this.eCh.threadData != null) {
            if (i == 1) {
                this.dFu.setVisibility(8);
                this.dFv.setData(this.eCh.threadData);
                return;
            }
            this.dFv.setVisibility(8);
            if (this.dFu.setData(this.eCh.threadData)) {
                this.eCl.setVisibility(8);
            } else {
                this.eCl.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.WN = str;
    }

    public int mp(int i) {
        return com.baidu.tieba.a.d.aCH().ag(this.WN, i);
    }

    public void pF(int i) {
        if (this.dFu != null) {
            this.dFu.cbN = String.valueOf(i);
        }
    }

    public void dP(boolean z) {
        this.ccS = z;
    }
}
