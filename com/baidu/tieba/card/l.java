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
    private CardUserInfoLayout VG;
    private String WM;
    private View.OnClickListener XU;
    public View aOf;
    public TbImageView cKG;
    private TextView cKM;
    private View.OnClickListener cbv;
    public boolean cdL;
    private NEGFeedBackView dGE;
    public NewThreadCommentAndPraiseInfoLayout dHf;
    public ThreadSourceShareAndPraiseLayout dHg;
    public LinearLayout dHr;
    private com.baidu.tieba.card.data.j eDQ;
    public FrameLayout eDR;
    public RelativeLayout eDS;
    public TBLottieAnimationView eDT;
    private View eDU;
    private ThreadForumEnterButton eDV;
    private CustomMessageListener eDW;
    private TbPageContext<?> mContext;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dGE = null;
        this.cdL = false;
        this.mLastScreenWidth = 0;
        this.XU = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.aZU() != null) {
                    l.this.aZU().a(view, l.this.eDQ);
                }
            }
        };
        this.cbv = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.aZU() != null) {
                    l.this.aZU().a(view, l.this.eDQ);
                }
            }
        };
        this.eDW = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.l.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && l.this.eDQ != null && l.this.eDQ.threadData != null && l.this.eDQ.threadData.getTid() != null && l.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(l.this.eDQ.threadData.getTid())) {
                    n.a(l.this.mTextTitle, l.this.eDQ.threadData.getId(), (int) R.color.cp_cont_d, (int) R.color.cp_cont_d);
                }
            }
        };
        this.mContext = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.eDR = (FrameLayout) view.findViewById(R.id.layout_root);
        this.aOf = view.findViewById(R.id.divider_line);
        this.dHr = (LinearLayout) view.findViewById(R.id.content_layout);
        this.VG = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.dGE = new NEGFeedBackView(this.mContext);
        this.dGE = new NEGFeedBackView(getTbPageContext());
        this.dGE.a(this.eDR, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds115), 0, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds32), com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds3));
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.eDS = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.cKG = (TbImageView) view.findViewById(R.id.image_video);
        this.cKG.setDrawCorner(true);
        this.cKG.setDefaultBgResource(com.baidu.tbadk.util.e.Qv());
        this.cKG.setDefaultResource(0);
        this.cKG.setDefaultErrorResource(0);
        this.cKG.setRadius(com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds20));
        TbImageView tbImageView = this.cKG;
        TbImageView tbImageView2 = this.cKG;
        tbImageView.setConrers(15);
        this.cKG.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.cKG.setBorderColor(am.getColor(R.color.black_alpha8));
        this.cKG.setBorderSurroundContent(true);
        this.cKG.setDrawBorder(true);
        this.eDT = (TBLottieAnimationView) view.findViewById(R.id.image_video_play);
        this.eDT.y(true);
        am.a(this.eDT, (int) R.raw.ala_play);
        this.eDT.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.l.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                l.this.eDT.br();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                l.this.eDT.cancelAnimation();
            }
        });
        this.eDV = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
        this.dHf = (NewThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.dHf.setOnClickListener(this);
        this.dHf.setReplyTimeVisible(false);
        this.dHf.setShowPraiseNum(true);
        this.dHf.setNeedAddReplyIcon(true);
        this.dHf.setNeedAddPraiseIcon(true);
        if (this.dHf.getCommentContainer() != null) {
            this.dHf.getCommentContainer().setOnClickListener(this);
        }
        this.dHf.setShareVisible(true);
        this.dHf.setFrom(7);
        this.dHf.setShareReportFrom(3);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bFY = 7;
        dVar.bGd = 1;
        this.dHf.setAgreeStatisticData(dVar);
        this.dHg = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_ala_source_read_share_layout);
        this.dHg.cdA.setOnClickListener(this);
        this.dHg.setFrom(7);
        this.dHg.setShareReportFrom(3);
        if (this.dHg.cdA.getCommentContainer() != null) {
            this.dHg.cdA.getCommentContainer().setOnClickListener(this);
        }
        this.cKM = (TextView) view.findViewById(R.id.play_count);
        this.eDU = view.findViewById(R.id.divider_below_reply_number_layout);
        this.dHr.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(this.eDR, R.drawable.addresslist_item_bg);
            am.k(this.dHr, R.drawable.addresslist_item_bg);
            am.l(this.aOf, R.color.cp_bg_line_c);
            am.j(this.mTextTitle, R.color.cp_cont_b);
            am.j(this.cKM, R.color.cp_cont_a);
            am.a(this.eDT, (int) R.raw.ala_play);
            am.k(this.eDS, R.drawable.bg_ala_shape);
            this.VG.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.dHf.onChangeSkinType();
            if (this.dGE != null) {
                this.dGE.onChangeSkinType();
            }
            this.eDV.onChangeSkinType();
            this.dHg.onChangeSkinType();
            this.cKG.setDefaultBgResource(com.baidu.tbadk.util.e.Qv());
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
        this.eDQ = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.eDQ == null || this.eDQ.acC() == null) {
            this.eDR.setVisibility(8);
            return;
        }
        this.eDR.setVisibility(0);
        int af = com.baidu.adp.lib.util.l.af(this.mContext.getPageActivity());
        if (af != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eDS.getLayoutParams();
            layoutParams.width = af - com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.eDS.setLayoutParams(layoutParams);
            this.mLastScreenWidth = af;
        }
        this.VG.setData(this.eDQ.acC());
        this.VG.setUserAfterClickListener(this.XU);
        this.eDQ.acC().afs();
        this.mTextTitle.setText(new SpannableStringBuilder(this.eDQ.acC().afi()));
        this.cKM.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), aq.aO(this.eDQ.threadData.aeV().audience_count)));
        this.eDV.y(this.eDQ.acC());
        if (this.cdL) {
            this.dGE.setVisibility(8);
        } else if (this.dGE != null && this.eDQ.acC() != null) {
            aj ajVar = new aj();
            ajVar.setTid(this.eDQ.acC().getTid());
            ajVar.setFid(this.eDQ.acC().getFid());
            ajVar.b(this.eDQ.bIk);
            this.dGE.setData(ajVar);
            this.dGE.setFirstRowSingleColumn(true);
        }
        nJ(mt(1));
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.vX(this.eDQ.threadData.getId())) {
            am.f(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.f(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        aZX();
        this.eDT.br();
    }

    public void aZX() {
        if (com.baidu.tbadk.core.i.ace().aci() && this.eDQ != null && this.eDQ.acC() != null && this.eDQ.acC().aeV() != null) {
            this.cKG.setDefaultBgResource(com.baidu.tbadk.util.e.Qv());
            this.cKG.startLoad(this.eDQ.acC().aeV().cover, 10, false);
            this.eDS.setVisibility(0);
            return;
        }
        this.eDS.setVisibility(8);
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.dGE != null) {
            this.dGE.setEventCallback(aVar);
        }
    }

    public View aZY() {
        if (this.VG != null) {
            return this.VG.getAvatar();
        }
        return null;
    }

    public View aZZ() {
        if (this.VG != null) {
            return this.VG.getUserName();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dHr || view == this.dHf.getCommentContainer() || view == this.dHg.cdA.getCommentContainer()) {
            bF(view);
        }
    }

    private void bF(View view) {
        if (aZU() != null) {
            aZU().a(view, this.eDQ);
        }
        if (this.eDQ != null && this.eDQ.acC() != null && this.eDQ.acC().aeV() != null) {
            n.vW(this.eDQ.threadData.getId());
            n.a(this.mTextTitle, this.eDQ.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.eDQ.acC().aeV());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dHf != null && this.eDW != null) {
            if (this.VG != null) {
                this.VG.setPageUniqueId(bdUniqueId);
            }
            this.eDW.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.dGE != null) {
                this.dGE.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.eDW);
        }
    }

    public void nJ(int i) {
        if (this.eDQ != null && this.eDQ.threadData != null) {
            if (i == 1) {
                this.dHf.setVisibility(8);
                this.dHg.setData(this.eDQ.threadData);
                return;
            }
            this.dHg.setVisibility(8);
            if (this.dHf.setData(this.eDQ.threadData)) {
                this.eDU.setVisibility(8);
            } else {
                this.eDU.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.WM = str;
    }

    public int mt(int i) {
        return com.baidu.tieba.a.d.aCV().ag(this.WM, i);
    }

    public void pJ(int i) {
        if (this.dHf != null) {
            this.dHf.ccH = String.valueOf(i);
        }
    }

    public void dP(boolean z) {
        this.cdL = z;
    }
}
