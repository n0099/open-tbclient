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
import com.baidu.tieba.a.e;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class l extends a<com.baidu.tieba.card.data.j> implements e {
    private CardUserInfoLayout Xv;
    private String Yz;
    private View.OnClickListener ZF;
    public View aLa;
    private View.OnClickListener bRy;
    public TbImageView cAg;
    private TextView cAm;
    private NEGFeedBackView dqK;
    public NewThreadCommentAndPraiseInfoLayout drn;
    public ThreadSourceShareAndPraiseLayout dro;
    public LinearLayout drz;
    private com.baidu.tieba.card.data.j ehE;
    public FrameLayout ehF;
    public RelativeLayout ehG;
    public TBLottieAnimationView ehH;
    private View ehI;
    private ThreadForumEnterButton ehJ;
    private CustomMessageListener ehK;
    private TbPageContext<?> mContext;
    public TextView mTextTitle;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dqK = null;
        this.ZF = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.aQh() != null) {
                    l.this.aQh().a(view, l.this.ehE);
                }
            }
        };
        this.bRy = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.aQh() != null) {
                    l.this.aQh().a(view, l.this.ehE);
                }
            }
        };
        this.ehK = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.l.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && l.this.ehE != null && l.this.ehE.threadData != null && l.this.ehE.threadData.getTid() != null && l.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(l.this.ehE.threadData.getTid())) {
                    n.a(l.this.mTextTitle, l.this.ehE.threadData.getId(), d.C0236d.cp_cont_d, d.C0236d.cp_cont_d);
                }
            }
        };
        this.mContext = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.ehF = (FrameLayout) view.findViewById(d.g.layout_root);
        this.aLa = view.findViewById(d.g.divider_line);
        this.drz = (LinearLayout) view.findViewById(d.g.content_layout);
        this.Xv = (CardUserInfoLayout) view.findViewById(d.g.card_home_page_ala_video_user_info_layout);
        this.dqK = new NEGFeedBackView(this.mContext);
        this.dqK = new NEGFeedBackView(getTbPageContext());
        this.dqK.a(this.ehF, com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds115), 0, com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds32), com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds3));
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.ehG = (RelativeLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ehG.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.tbds88);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.ehG.setLayoutParams(layoutParams);
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
        this.cAg.setBorderColor(al.getColor(d.C0236d.black_alpha8));
        this.cAg.setBorderSurroundContent(true);
        this.cAg.setDrawBorder(true);
        this.ehH = (TBLottieAnimationView) view.findViewById(d.g.image_video_play);
        this.ehH.G(true);
        al.a(this.ehH, d.i.ala_play);
        this.ehH.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.card.l.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                l.this.ehH.cu();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                l.this.ehH.cancelAnimation();
            }
        });
        this.ehJ = (ThreadForumEnterButton) view.findViewById(d.g.card_home_page_forum_enter_button);
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
        dVar.bxh = 7;
        dVar.bxm = 1;
        this.drn.setAgreeStatisticData(dVar);
        this.dro = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_ala_source_read_share_layout);
        this.dro.bTy.setOnClickListener(this);
        this.dro.setFrom(7);
        this.dro.setShareReportFrom(3);
        if (this.dro.bTy.getCommentContainer() != null) {
            this.dro.bTy.getCommentContainer().setOnClickListener(this);
        }
        this.cAm = (TextView) view.findViewById(d.g.play_count);
        this.ehI = view.findViewById(d.g.divider_below_reply_number_layout);
        this.drz.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.ehF, d.f.addresslist_item_bg);
            al.k(this.drz, d.f.addresslist_item_bg);
            al.l(this.aLa, d.C0236d.cp_bg_line_e);
            al.j(this.mTextTitle, d.C0236d.cp_cont_b);
            al.j(this.cAm, d.C0236d.cp_btn_a);
            al.a(this.ehH, d.i.ala_play);
            al.k(this.ehG, d.f.bg_ala_shape);
            this.Xv.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.drn.onChangeSkinType();
            if (this.dqK != null) {
                this.dqK.onChangeSkinType();
            }
            this.ehJ.onChangeSkinType();
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
        this.ehE = jVar;
        refreshView();
    }

    private void refreshView() {
        if (this.ehE == null || this.ehE.WR() == null) {
            this.ehF.setVisibility(8);
            return;
        }
        this.ehF.setVisibility(0);
        this.Xv.setData(this.ehE.WR());
        this.Xv.setUserAfterClickListener(this.ZF);
        this.ehE.WR().ZH();
        this.mTextTitle.setText(new SpannableStringBuilder(this.ehE.WR().Zx()));
        this.cAm.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), ap.az(this.ehE.threadData.Zk().audience_count)));
        this.ehJ.w(this.ehE.WR());
        if (this.dqK != null && this.ehE.WR() != null) {
            aj ajVar = new aj();
            ajVar.setTid(this.ehE.WR().getTid());
            ajVar.setFid(this.ehE.WR().getFid());
            ajVar.b(this.ehE.bzs);
            this.dqK.setData(ajVar);
            this.dqK.setFirstRowSingleColumn(true);
        }
        mF(lt(1));
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.tC(this.ehE.threadData.getId())) {
            al.d(this.mTextTitle, d.C0236d.cp_cont_d, 1);
        } else {
            al.d(this.mTextTitle, d.C0236d.cp_cont_b, 1);
        }
        aQk();
        this.ehH.cu();
    }

    public void aQk() {
        if (com.baidu.tbadk.core.i.Wy().WC() && this.ehE != null && this.ehE.WR() != null && this.ehE.WR().Zk() != null) {
            this.cAg.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.cAg.startLoad(this.ehE.WR().Zk().cover, 10, false);
            this.ehG.setVisibility(0);
            return;
        }
        this.ehG.setVisibility(8);
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.dqK != null) {
            this.dqK.setEventCallback(aVar);
        }
    }

    public View aQl() {
        if (this.Xv != null) {
            return this.Xv.getAvatar();
        }
        return null;
    }

    public View aQm() {
        if (this.Xv != null) {
            return this.Xv.getUserName();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.drz || view == this.drn.getCommentContainer() || view == this.dro.bTy.getCommentContainer()) {
            bw(view);
        }
    }

    private void bw(View view) {
        if (aQh() != null) {
            aQh().a(view, this.ehE);
        }
        if (this.ehE != null && this.ehE.WR() != null && this.ehE.WR().Zk() != null) {
            n.tB(this.ehE.threadData.getId());
            n.a(this.mTextTitle, this.ehE.threadData.getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.ehE.WR().Zk());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.drn != null && this.ehK != null) {
            if (this.Xv != null) {
                this.Xv.setPageUniqueId(bdUniqueId);
            }
            this.ehK.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.dqK != null) {
                this.dqK.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.ehK);
        }
    }

    public void mF(int i) {
        if (this.ehE != null && this.ehE.threadData != null) {
            if (i == 1) {
                this.drn.setVisibility(8);
                this.dro.setData(this.ehE.threadData);
                return;
            }
            this.dro.setVisibility(8);
            if (this.drn.setData(this.ehE.threadData)) {
                this.ehI.setVisibility(8);
            } else {
                this.ehI.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Yz = str;
    }

    public int lt(int i) {
        return com.baidu.tieba.a.d.awk().ak(this.Yz, i);
    }

    public void oo(int i) {
        if (this.drn != null) {
            this.drn.bSH = String.valueOf(i);
        }
    }
}
