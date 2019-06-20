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
    private CardUserInfoLayout Vn;
    private String Ws;
    private View.OnClickListener Xz;
    public View aMY;
    private View.OnClickListener bZu;
    public TbImageView cIp;
    private TextView cIv;
    public boolean cbI;
    public NewThreadCommentAndPraiseInfoLayout dBS;
    public ThreadSourceShareAndPraiseLayout dBT;
    private NEGFeedBackView dBq;
    public LinearLayout dCe;
    private com.baidu.tieba.card.data.j exb;
    public FrameLayout exc;
    public RelativeLayout exd;
    public TBLottieAnimationView exe;
    private View exf;
    private ThreadForumEnterButton exg;
    private CustomMessageListener exh;
    private TbPageContext<?> mContext;
    private int mLastScreenWidth;
    public TextView mTextTitle;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dBq = null;
        this.cbI = false;
        this.mLastScreenWidth = 0;
        this.Xz = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.aXr() != null) {
                    l.this.aXr().a(view, l.this.exb);
                }
            }
        };
        this.bZu = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.aXr() != null) {
                    l.this.aXr().a(view, l.this.exb);
                }
            }
        };
        this.exh = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.l.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && l.this.exb != null && l.this.exb.threadData != null && l.this.exb.threadData.getTid() != null && l.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(l.this.exb.threadData.getTid())) {
                    n.a(l.this.mTextTitle, l.this.exb.threadData.getId(), (int) R.color.cp_cont_d, (int) R.color.cp_cont_d);
                }
            }
        };
        this.mContext = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.exc = (FrameLayout) view.findViewById(R.id.layout_root);
        this.aMY = view.findViewById(R.id.divider_line);
        this.dCe = (LinearLayout) view.findViewById(R.id.content_layout);
        this.Vn = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.dBq = new NEGFeedBackView(this.mContext);
        this.dBq = new NEGFeedBackView(getTbPageContext());
        this.dBq.a(this.exc, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds115), 0, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds32), com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds3));
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.exd = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.cIp = (TbImageView) view.findViewById(R.id.image_video);
        this.cIp.setDrawCorner(true);
        this.cIp.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        this.cIp.setDefaultResource(0);
        this.cIp.setDefaultErrorResource(0);
        this.cIp.setRadius(com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds20));
        TbImageView tbImageView = this.cIp;
        TbImageView tbImageView2 = this.cIp;
        tbImageView.setConrers(15);
        this.cIp.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.cIp.setBorderColor(al.getColor(R.color.black_alpha8));
        this.cIp.setBorderSurroundContent(true);
        this.cIp.setDrawBorder(true);
        this.exe = (TBLottieAnimationView) view.findViewById(R.id.image_video_play);
        this.exe.y(true);
        al.a(this.exe, (int) R.raw.ala_play);
        this.exe.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.l.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                l.this.exe.bo();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                l.this.exe.cancelAnimation();
            }
        });
        this.exg = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
        this.dBS = (NewThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.dBS.setOnClickListener(this);
        this.dBS.setReplyTimeVisible(false);
        this.dBS.setShowPraiseNum(true);
        this.dBS.setNeedAddReplyIcon(true);
        this.dBS.setNeedAddPraiseIcon(true);
        if (this.dBS.getCommentContainer() != null) {
            this.dBS.getCommentContainer().setOnClickListener(this);
        }
        this.dBS.setShareVisible(true);
        this.dBS.setFrom(7);
        this.dBS.setShareReportFrom(3);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bEz = 7;
        dVar.bEE = 1;
        this.dBS.setAgreeStatisticData(dVar);
        this.dBT = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_ala_source_read_share_layout);
        this.dBT.cbx.setOnClickListener(this);
        this.dBT.setFrom(7);
        this.dBT.setShareReportFrom(3);
        if (this.dBT.cbx.getCommentContainer() != null) {
            this.dBT.cbx.getCommentContainer().setOnClickListener(this);
        }
        this.cIv = (TextView) view.findViewById(R.id.play_count);
        this.exf = view.findViewById(R.id.divider_below_reply_number_layout);
        this.dCe.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.exc, R.drawable.addresslist_item_bg);
            al.k(this.dCe, R.drawable.addresslist_item_bg);
            al.l(this.aMY, R.color.cp_bg_line_e);
            al.j(this.mTextTitle, R.color.cp_cont_b);
            al.j(this.cIv, R.color.cp_btn_a);
            al.a(this.exe, (int) R.raw.ala_play);
            al.k(this.exd, R.drawable.bg_ala_shape);
            this.Vn.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.dBS.onChangeSkinType();
            if (this.dBq != null) {
                this.dBq.onChangeSkinType();
            }
            this.exg.onChangeSkinType();
            this.dBT.onChangeSkinType();
            this.cIp.setDefaultBgResource(com.baidu.tbadk.util.e.get());
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
        this.exb = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.exb == null || this.exb.abv() == null) {
            this.exc.setVisibility(8);
            return;
        }
        this.exc.setVisibility(0);
        int af = com.baidu.adp.lib.util.l.af(this.mContext.getPageActivity());
        if (af != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.exd.getLayoutParams();
            layoutParams.width = af - com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.exd.setLayoutParams(layoutParams);
            this.mLastScreenWidth = af;
        }
        this.Vn.setData(this.exb.abv());
        this.Vn.setUserAfterClickListener(this.Xz);
        this.exb.abv().ael();
        this.mTextTitle.setText(new SpannableStringBuilder(this.exb.abv().aeb()));
        this.cIv.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), ap.aN(this.exb.threadData.adO().audience_count)));
        this.exg.w(this.exb.abv());
        if (this.cbI) {
            this.dBq.setVisibility(8);
        } else if (this.dBq != null && this.exb.abv() != null) {
            aj ajVar = new aj();
            ajVar.setTid(this.exb.abv().getTid());
            ajVar.setFid(this.exb.abv().getFid());
            ajVar.b(this.exb.bGL);
            this.dBq.setData(ajVar);
            this.dBq.setFirstRowSingleColumn(true);
        }
        nv(mh(1));
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.uS(this.exb.threadData.getId())) {
            al.f(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            al.f(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        aXu();
        this.exe.bo();
    }

    public void aXu() {
        if (com.baidu.tbadk.core.i.abb().abf() && this.exb != null && this.exb.abv() != null && this.exb.abv().adO() != null) {
            this.cIp.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.cIp.startLoad(this.exb.abv().adO().cover, 10, false);
            this.exd.setVisibility(0);
            return;
        }
        this.exd.setVisibility(8);
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.dBq != null) {
            this.dBq.setEventCallback(aVar);
        }
    }

    public View aXv() {
        if (this.Vn != null) {
            return this.Vn.getAvatar();
        }
        return null;
    }

    public View aXw() {
        if (this.Vn != null) {
            return this.Vn.getUserName();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dCe || view == this.dBS.getCommentContainer() || view == this.dBT.cbx.getCommentContainer()) {
            bD(view);
        }
    }

    private void bD(View view) {
        if (aXr() != null) {
            aXr().a(view, this.exb);
        }
        if (this.exb != null && this.exb.abv() != null && this.exb.abv().adO() != null) {
            n.uR(this.exb.threadData.getId());
            n.a(this.mTextTitle, this.exb.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.exb.abv().adO());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dBS != null && this.exh != null) {
            if (this.Vn != null) {
                this.Vn.setPageUniqueId(bdUniqueId);
            }
            this.exh.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.dBq != null) {
                this.dBq.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.exh);
        }
    }

    public void nv(int i) {
        if (this.exb != null && this.exb.threadData != null) {
            if (i == 1) {
                this.dBS.setVisibility(8);
                this.dBT.setData(this.exb.threadData);
                return;
            }
            this.dBT.setVisibility(8);
            if (this.dBS.setData(this.exb.threadData)) {
                this.exf.setVisibility(8);
            } else {
                this.exf.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Ws = str;
    }

    public int mh(int i) {
        return com.baidu.tieba.a.d.aBq().ag(this.Ws, i);
    }

    public void po(int i) {
        if (this.dBS != null) {
            this.dBS.caE = String.valueOf(i);
        }
    }

    public void dL(boolean z) {
        this.cbI = z;
    }
}
