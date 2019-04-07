package com.baidu.tieba.homepage.concern.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.card.n;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.a<j> implements com.baidu.tieba.a.e {
    private String YA;
    private final View.OnClickListener ZH;
    private final View.OnClickListener bRB;
    private String bSL;
    private TextView cAl;
    private TbImageView dcR;
    private LinearLayout dhO;
    private String dkx;
    public ThreadCommentAndPraiseInfoLayout dqy;
    public ThreadSourceShareAndPraiseLayout drn;
    private LinearLayout dry;
    private j ehm;
    private TBLottieAnimationView ehp;
    private HeadPendantClickableView ehw;
    private View eia;
    private View.OnClickListener eie;
    public ConcernThreadUserInfoLayout fGV;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dkx = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.eie = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aQf() != null) {
                    a.this.aQf().a(view, a.this.ehm);
                }
                a.this.aQA();
            }
        };
        this.ZH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aQf() != null) {
                    a.this.aQf().a(view, a.this.ehm);
                }
            }
        };
        this.bRB = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aQf() != null) {
                    a.this.aQf().a(view, a.this.ehm);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.ehw = (HeadPendantClickableView) view.findViewById(d.g.card_concern_ala_live_thread_user_pendant_header);
        if (this.ehw.getHeadView() != null) {
            this.ehw.getHeadView().setIsRound(true);
            this.ehw.getHeadView().setDrawBorder(false);
            this.ehw.getHeadView().setDefaultResource(17170445);
            this.ehw.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.ehw.getHeadView().setDefaultBgResource(d.C0277d.cp_bg_line_e);
            this.ehw.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        this.ehw.setHasPendantStyle();
        if (this.ehw.getPendantView() != null) {
            this.ehw.getPendantView().setIsRound(true);
            this.ehw.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_ala_live_thread_title);
        this.dcR = (TbImageView) getView().findViewById(d.g.card_concern_ala_live_thread_live_image_view);
        this.dcR.setDefaultErrorResource(0);
        this.dcR.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.dcR.setDrawerType(0);
        this.dcR.setBorderSurroundContent(true);
        this.dcR.setDrawBorder(true);
        TbImageView tbImageView = this.dcR;
        TbImageView tbImageView2 = this.dcR;
        tbImageView.setConrers(15);
        this.dcR.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
        this.dcR.setBorderColor(al.getColor(d.C0277d.black_alpha8));
        this.dhO = (LinearLayout) getView().findViewById(d.g.challenge_root);
        this.eia = view.findViewById(d.g.divider_line);
        this.dqy = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_info_layout);
        this.fGV = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_user_info_layout);
        if (this.dqy.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqy.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dqy.setLayoutParams(layoutParams);
        }
        this.dqy.setOnClickListener(this.eie);
        this.dqy.setReplyTimeVisible(false);
        this.dqy.setIsBarViewVisible(false);
        this.dqy.setShowPraiseNum(true);
        this.dqy.setNeedAddPraiseIcon(true);
        this.dqy.setNeedAddReplyIcon(true);
        this.dqy.setShareVisible(true);
        this.dqy.bSJ = this.currentPageType;
        this.dqy.setShareReportFrom(4);
        this.dqy.setFrom(9);
        this.dqy.setDisPraiseFrom(4);
        this.dqy.setForumAfterClickListener(this.bRB);
        if (this.dqy.getCommentContainer() != null) {
            this.dqy.getCommentContainer().setOnClickListener(this.eie);
        }
        this.drn = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_ala_source_read_share_layout);
        this.drn.bTB.setOnClickListener(this.eie);
        this.drn.setShareReportFrom(4);
        this.drn.setFrom(9);
        this.drn.bTB.bSJ = this.currentPageType;
        this.drn.setForumAfterClickListener(this.bRB);
        if (this.drn.bTB.getCommentContainer() != null) {
            this.drn.bTB.getCommentContainer().setOnClickListener(this.eie);
        }
        this.dry = (LinearLayout) view.findViewById(d.g.card_concern_ala_live_thread_content_layout);
        this.cAl = (TextView) getView().findViewById(d.g.play_count);
        this.ehp = (TBLottieAnimationView) view.findViewById(d.g.image_video_play);
        this.ehp.G(true);
        al.a(this.ehp, d.i.ala_play);
        this.ehp.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                a.this.ehp.cu();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                a.this.ehp.cancelAnimation();
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.f.addresslist_item_bg);
            this.dqy.onChangeSkinType();
            this.fGV.onChangeSkinType();
            this.drn.onChangeSkinType();
            al.l(this.eia, d.C0277d.cp_bg_line_e);
            al.j(this.cAl, d.C0277d.cp_btn_a);
            al.a(this.ehp, d.i.ala_play);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_concern_ala_live_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(j jVar) {
        if (jVar == null || jVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ehm = jVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eie);
        }
        this.fGV.setData(jVar.threadData);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.tA(this.ehm.threadData.getId())) {
            n.a(this.mTitle, this.ehm.WO().getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        }
        this.fGV.setUserAfterClickListener(this.ZH);
        this.bSL = "feed#" + jVar.aQN();
        bg WO = jVar.WO();
        if (this.fGV.getHeaderImg() != null) {
            if (this.fGV.getIsSimpleThread()) {
                this.fGV.getHeaderImg().setVisibility(8);
                this.ehw.setVisibility(8);
            } else if (WO.YO() == null || WO.YO().getPendantData() == null || StringUtils.isNull(WO.YO().getPendantData().Xk())) {
                this.ehw.setVisibility(8);
                this.fGV.getHeaderImg().setVisibility(0);
                this.fGV.getHeaderImg().setData(WO);
            } else {
                this.fGV.getHeaderImg().setVisibility(4);
                this.ehw.setVisibility(0);
                this.ehw.setData(WO);
            }
        }
        n.a(WO, this.mTitle);
        this.dcR.startLoad(WO.Zh().cover, 10, false);
        this.cAl.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), ap.az(this.ehm.threadData.Zh().audience_count)));
        setPageUniqueId(getTag());
        this.ehp.cu();
        mE(ls(1));
        if (WO.Zh().mChallengeInfoData != null && WO.Zh().mChallengeInfoData.challenge_id > 0) {
            this.dhO.setVisibility(0);
        } else {
            this.dhO.setVisibility(8);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.fGV != null) {
            this.fGV.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.fGV != null) {
            return this.fGV.bTl;
        }
        return null;
    }

    public void aQA() {
        if (this.mPageContext != null && this.ehm != null && this.ehm.threadData != null && this.ehm.threadData.YO() != null && this.ehm.threadData.Zh() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.ehm.threadData.YO().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.ehm.threadData.Zh());
            alaLiveInfoCoreData.userName = this.ehm.threadData.YO().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, this.dkx, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void mE(int i) {
        if (this.ehm != null && this.ehm.threadData != null) {
            this.mStType = n.YB();
            if (i == 1) {
                this.dqy.setVisibility(8);
                this.drn.setStType(this.mStType);
                this.drn.setData(this.ehm.threadData);
                this.fGV.dN(false);
                return;
            }
            this.dqy.setData(this.ehm.threadData);
            this.dqy.setStType(this.mStType);
            this.drn.setVisibility(8);
            this.fGV.dN(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YA = str;
    }

    public int ls(int i) {
        return com.baidu.tieba.a.d.awh().ak(this.YA, i);
    }
}
