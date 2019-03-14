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
    private final View.OnClickListener ZG;
    private final View.OnClickListener bRz;
    private String bSJ;
    private TextView cAj;
    private TbImageView dcN;
    private LinearLayout dhL;
    private String dku;
    public ThreadCommentAndPraiseInfoLayout dqv;
    public ThreadSourceShareAndPraiseLayout drk;
    private LinearLayout drv;
    private j ehA;
    private TBLottieAnimationView ehD;
    private HeadPendantClickableView ehK;
    private View eio;
    private View.OnClickListener eis;
    public ConcernThreadUserInfoLayout fHh;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dku = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.eis = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aQh() != null) {
                    a.this.aQh().a(view, a.this.ehA);
                }
                a.this.aQC();
            }
        };
        this.ZG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aQh() != null) {
                    a.this.aQh().a(view, a.this.ehA);
                }
            }
        };
        this.bRz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aQh() != null) {
                    a.this.aQh().a(view, a.this.ehA);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.ehK = (HeadPendantClickableView) view.findViewById(d.g.card_concern_ala_live_thread_user_pendant_header);
        if (this.ehK.getHeadView() != null) {
            this.ehK.getHeadView().setIsRound(true);
            this.ehK.getHeadView().setDrawBorder(false);
            this.ehK.getHeadView().setDefaultResource(17170445);
            this.ehK.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.ehK.getHeadView().setDefaultBgResource(d.C0277d.cp_bg_line_e);
            this.ehK.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        this.ehK.setHasPendantStyle();
        if (this.ehK.getPendantView() != null) {
            this.ehK.getPendantView().setIsRound(true);
            this.ehK.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_ala_live_thread_title);
        this.dcN = (TbImageView) getView().findViewById(d.g.card_concern_ala_live_thread_live_image_view);
        this.dcN.setDefaultErrorResource(0);
        this.dcN.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.dcN.setDrawerType(0);
        this.dcN.setBorderSurroundContent(true);
        this.dcN.setDrawBorder(true);
        TbImageView tbImageView = this.dcN;
        TbImageView tbImageView2 = this.dcN;
        tbImageView.setConrers(15);
        this.dcN.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
        this.dcN.setBorderColor(al.getColor(d.C0277d.black_alpha8));
        this.dhL = (LinearLayout) getView().findViewById(d.g.challenge_root);
        this.eio = view.findViewById(d.g.divider_line);
        this.dqv = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_info_layout);
        this.fHh = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_user_info_layout);
        if (this.dqv.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqv.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dqv.setLayoutParams(layoutParams);
        }
        this.dqv.setOnClickListener(this.eis);
        this.dqv.setReplyTimeVisible(false);
        this.dqv.setIsBarViewVisible(false);
        this.dqv.setShowPraiseNum(true);
        this.dqv.setNeedAddPraiseIcon(true);
        this.dqv.setNeedAddReplyIcon(true);
        this.dqv.setShareVisible(true);
        this.dqv.bSH = this.currentPageType;
        this.dqv.setShareReportFrom(4);
        this.dqv.setFrom(9);
        this.dqv.setDisPraiseFrom(4);
        this.dqv.setForumAfterClickListener(this.bRz);
        if (this.dqv.getCommentContainer() != null) {
            this.dqv.getCommentContainer().setOnClickListener(this.eis);
        }
        this.drk = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_ala_source_read_share_layout);
        this.drk.bTz.setOnClickListener(this.eis);
        this.drk.setShareReportFrom(4);
        this.drk.setFrom(9);
        this.drk.bTz.bSH = this.currentPageType;
        this.drk.setForumAfterClickListener(this.bRz);
        if (this.drk.bTz.getCommentContainer() != null) {
            this.drk.bTz.getCommentContainer().setOnClickListener(this.eis);
        }
        this.drv = (LinearLayout) view.findViewById(d.g.card_concern_ala_live_thread_content_layout);
        this.cAj = (TextView) getView().findViewById(d.g.play_count);
        this.ehD = (TBLottieAnimationView) view.findViewById(d.g.image_video_play);
        this.ehD.G(true);
        al.a(this.ehD, d.i.ala_play);
        this.ehD.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                a.this.ehD.cu();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                a.this.ehD.cancelAnimation();
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.f.addresslist_item_bg);
            this.dqv.onChangeSkinType();
            this.fHh.onChangeSkinType();
            this.drk.onChangeSkinType();
            al.l(this.eio, d.C0277d.cp_bg_line_e);
            al.j(this.cAj, d.C0277d.cp_btn_a);
            al.a(this.ehD, d.i.ala_play);
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
        this.ehA = jVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eis);
        }
        this.fHh.setData(jVar.threadData);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.tB(this.ehA.threadData.getId())) {
            n.a(this.mTitle, this.ehA.WR().getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        }
        this.fHh.setUserAfterClickListener(this.ZG);
        this.bSJ = "feed#" + jVar.aQP();
        bg WR = jVar.WR();
        if (this.fHh.getHeaderImg() != null) {
            if (this.fHh.getIsSimpleThread()) {
                this.fHh.getHeaderImg().setVisibility(8);
                this.ehK.setVisibility(8);
            } else if (WR.YR() == null || WR.YR().getPendantData() == null || StringUtils.isNull(WR.YR().getPendantData().Xn())) {
                this.ehK.setVisibility(8);
                this.fHh.getHeaderImg().setVisibility(0);
                this.fHh.getHeaderImg().setData(WR);
            } else {
                this.fHh.getHeaderImg().setVisibility(4);
                this.ehK.setVisibility(0);
                this.ehK.setData(WR);
            }
        }
        n.a(WR, this.mTitle);
        this.dcN.startLoad(WR.Zk().cover, 10, false);
        this.cAj.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), ap.az(this.ehA.threadData.Zk().audience_count)));
        setPageUniqueId(getTag());
        this.ehD.cu();
        mF(lt(1));
        if (WR.Zk().mChallengeInfoData != null && WR.Zk().mChallengeInfoData.challenge_id > 0) {
            this.dhL.setVisibility(0);
        } else {
            this.dhL.setVisibility(8);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.fHh != null) {
            this.fHh.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.fHh != null) {
            return this.fHh.bTj;
        }
        return null;
    }

    public void aQC() {
        if (this.mPageContext != null && this.ehA != null && this.ehA.threadData != null && this.ehA.threadData.YR() != null && this.ehA.threadData.Zk() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.ehA.threadData.YR().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.ehA.threadData.Zk());
            alaLiveInfoCoreData.userName = this.ehA.threadData.YR().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, this.dku, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void mF(int i) {
        if (this.ehA != null && this.ehA.threadData != null) {
            this.mStType = n.YE();
            if (i == 1) {
                this.dqv.setVisibility(8);
                this.drk.setStType(this.mStType);
                this.drk.setData(this.ehA.threadData);
                this.fHh.dN(false);
                return;
            }
            this.dqv.setData(this.ehA.threadData);
            this.dqv.setStType(this.mStType);
            this.drk.setVisibility(8);
            this.fHh.dN(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YA = str;
    }

    public int lt(int i) {
        return com.baidu.tieba.a.d.awk().ak(this.YA, i);
    }
}
