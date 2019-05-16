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
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class l extends a<com.baidu.tieba.card.data.j> implements com.baidu.tieba.a.e {
    private CardUserInfoLayout Vo;
    private String Wt;
    private View.OnClickListener XA;
    public View aMY;
    private View.OnClickListener bZt;
    public TbImageView cIo;
    private TextView cIu;
    public boolean cbH;
    public NewThreadCommentAndPraiseInfoLayout dBR;
    public ThreadSourceShareAndPraiseLayout dBS;
    private NEGFeedBackView dBp;
    public LinearLayout dCd;
    private com.baidu.tieba.card.data.j exa;
    public FrameLayout exb;
    public RelativeLayout exc;
    public TBLottieAnimationView exd;
    private View exe;
    private ThreadForumEnterButton exf;
    private CustomMessageListener exg;
    private TbPageContext<?> mContext;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dBp = null;
        this.cbH = false;
        this.mLastScreenWidth = 0;
        this.XA = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.aXo() != null) {
                    l.this.aXo().a(view, l.this.exa);
                }
            }
        };
        this.bZt = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.aXo() != null) {
                    l.this.aXo().a(view, l.this.exa);
                }
            }
        };
        this.exg = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.l.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && l.this.exa != null && l.this.exa.threadData != null && l.this.exa.threadData.getTid() != null && l.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(l.this.exa.threadData.getTid())) {
                    n.a(l.this.mTextTitle, l.this.exa.threadData.getId(), (int) R.color.cp_cont_d, (int) R.color.cp_cont_d);
                }
            }
        };
        this.mContext = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.exb = (FrameLayout) view.findViewById(R.id.layout_root);
        this.aMY = view.findViewById(R.id.divider_line);
        this.dCd = (LinearLayout) view.findViewById(R.id.content_layout);
        this.Vo = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.dBp = new NEGFeedBackView(this.mContext);
        this.dBp = new NEGFeedBackView(getTbPageContext());
        this.dBp.a(this.exb, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds115), 0, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds32), com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds3));
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.exc = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.cIo = (TbImageView) view.findViewById(R.id.image_video);
        this.cIo.setDrawCorner(true);
        this.cIo.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        this.cIo.setDefaultResource(0);
        this.cIo.setDefaultErrorResource(0);
        this.cIo.setRadius(com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds20));
        TbImageView tbImageView = this.cIo;
        TbImageView tbImageView2 = this.cIo;
        tbImageView.setConrers(15);
        this.cIo.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.cIo.setBorderColor(al.getColor(R.color.black_alpha8));
        this.cIo.setBorderSurroundContent(true);
        this.cIo.setDrawBorder(true);
        this.exd = (TBLottieAnimationView) view.findViewById(R.id.image_video_play);
        this.exd.y(true);
        al.a(this.exd, (int) R.raw.ala_play);
        this.exd.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.l.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                l.this.exd.bo();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                l.this.exd.cancelAnimation();
            }
        });
        this.exf = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
        this.dBR = (NewThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.dBR.setOnClickListener(this);
        this.dBR.setReplyTimeVisible(false);
        this.dBR.setShowPraiseNum(true);
        this.dBR.setNeedAddReplyIcon(true);
        this.dBR.setNeedAddPraiseIcon(true);
        if (this.dBR.getCommentContainer() != null) {
            this.dBR.getCommentContainer().setOnClickListener(this);
        }
        this.dBR.setShareVisible(true);
        this.dBR.setFrom(7);
        this.dBR.setShareReportFrom(3);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bEy = 7;
        dVar.bED = 1;
        this.dBR.setAgreeStatisticData(dVar);
        this.dBS = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_ala_source_read_share_layout);
        this.dBS.cbw.setOnClickListener(this);
        this.dBS.setFrom(7);
        this.dBS.setShareReportFrom(3);
        if (this.dBS.cbw.getCommentContainer() != null) {
            this.dBS.cbw.getCommentContainer().setOnClickListener(this);
        }
        this.cIu = (TextView) view.findViewById(R.id.play_count);
        this.exe = view.findViewById(R.id.divider_below_reply_number_layout);
        this.dCd.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.exb, R.drawable.addresslist_item_bg);
            al.k(this.dCd, R.drawable.addresslist_item_bg);
            al.l(this.aMY, R.color.cp_bg_line_e);
            al.j(this.mTextTitle, R.color.cp_cont_b);
            al.j(this.cIu, R.color.cp_btn_a);
            al.a(this.exd, (int) R.raw.ala_play);
            al.k(this.exc, R.drawable.bg_ala_shape);
            this.Vo.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.dBR.onChangeSkinType();
            if (this.dBp != null) {
                this.dBp.onChangeSkinType();
            }
            this.exf.onChangeSkinType();
            this.dBS.onChangeSkinType();
            this.cIo.setDefaultBgResource(com.baidu.tbadk.util.e.get());
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
        this.exa = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.exa == null || this.exa.abv() == null) {
            this.exb.setVisibility(8);
            return;
        }
        this.exb.setVisibility(0);
        int af = com.baidu.adp.lib.util.l.af(this.mContext.getPageActivity());
        if (af != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.exc.getLayoutParams();
            layoutParams.width = af - com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.exc.setLayoutParams(layoutParams);
            this.mLastScreenWidth = af;
        }
        this.Vo.setData(this.exa.abv());
        this.Vo.setUserAfterClickListener(this.XA);
        this.exa.abv().ael();
        this.mTextTitle.setText(new SpannableStringBuilder(this.exa.abv().aeb()));
        this.cIu.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), ap.aN(this.exa.threadData.adO().audience_count)));
        this.exf.w(this.exa.abv());
        if (this.cbH) {
            this.dBp.setVisibility(8);
        } else if (this.dBp != null && this.exa.abv() != null) {
            aj ajVar = new aj();
            ajVar.setTid(this.exa.abv().getTid());
            ajVar.setFid(this.exa.abv().getFid());
            ajVar.b(this.exa.bGK);
            this.dBp.setData(ajVar);
            this.dBp.setFirstRowSingleColumn(true);
        }
        nv(mh(1));
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.uT(this.exa.threadData.getId())) {
            al.f(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            al.f(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        aXr();
        this.exd.bo();
    }

    public void aXr() {
        if (com.baidu.tbadk.core.i.abb().abf() && this.exa != null && this.exa.abv() != null && this.exa.abv().adO() != null) {
            this.cIo.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.cIo.startLoad(this.exa.abv().adO().cover, 10, false);
            this.exc.setVisibility(0);
            return;
        }
        this.exc.setVisibility(8);
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.dBp != null) {
            this.dBp.setEventCallback(aVar);
        }
    }

    public View aXs() {
        if (this.Vo != null) {
            return this.Vo.getAvatar();
        }
        return null;
    }

    public View aXt() {
        if (this.Vo != null) {
            return this.Vo.getUserName();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dCd || view == this.dBR.getCommentContainer() || view == this.dBS.cbw.getCommentContainer()) {
            bD(view);
        }
    }

    private void bD(View view) {
        if (aXo() != null) {
            aXo().a(view, this.exa);
        }
        if (this.exa != null && this.exa.abv() != null && this.exa.abv().adO() != null) {
            n.uS(this.exa.threadData.getId());
            n.a(this.mTextTitle, this.exa.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.exa.abv().adO());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dBR != null && this.exg != null) {
            if (this.Vo != null) {
                this.Vo.setPageUniqueId(bdUniqueId);
            }
            this.exg.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.dBp != null) {
                this.dBp.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.exg);
        }
    }

    public void nv(int i) {
        if (this.exa != null && this.exa.threadData != null) {
            if (i == 1) {
                this.dBR.setVisibility(8);
                this.dBS.setData(this.exa.threadData);
                return;
            }
            this.dBS.setVisibility(8);
            if (this.dBR.setData(this.exa.threadData)) {
                this.exe.setVisibility(8);
            } else {
                this.exe.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Wt = str;
    }

    public int mh(int i) {
        return com.baidu.tieba.a.d.aBn().ag(this.Wt, i);
    }

    public void po(int i) {
        if (this.dBR != null) {
            this.dBR.caD = String.valueOf(i);
        }
    }

    public void dL(boolean z) {
        this.cbH = z;
    }
}
