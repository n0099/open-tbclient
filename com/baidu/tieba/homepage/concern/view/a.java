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
    private String YB;
    private final View.OnClickListener ZI;
    private final View.OnClickListener bRC;
    private String bSM;
    private TextView cAm;
    private TbImageView dcS;
    private LinearLayout dhP;
    private String dky;
    public ThreadCommentAndPraiseInfoLayout dqz;
    public ThreadSourceShareAndPraiseLayout dro;
    private LinearLayout drz;
    private j ehn;
    private TBLottieAnimationView ehq;
    private HeadPendantClickableView ehx;
    private View eib;
    private View.OnClickListener eif;
    public ConcernThreadUserInfoLayout fGV;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dky = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.eif = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aQf() != null) {
                    a.this.aQf().a(view, a.this.ehn);
                }
                a.this.aQA();
            }
        };
        this.ZI = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aQf() != null) {
                    a.this.aQf().a(view, a.this.ehn);
                }
            }
        };
        this.bRC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aQf() != null) {
                    a.this.aQf().a(view, a.this.ehn);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.ehx = (HeadPendantClickableView) view.findViewById(d.g.card_concern_ala_live_thread_user_pendant_header);
        if (this.ehx.getHeadView() != null) {
            this.ehx.getHeadView().setIsRound(true);
            this.ehx.getHeadView().setDrawBorder(false);
            this.ehx.getHeadView().setDefaultResource(17170445);
            this.ehx.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.ehx.getHeadView().setDefaultBgResource(d.C0277d.cp_bg_line_e);
            this.ehx.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        this.ehx.setHasPendantStyle();
        if (this.ehx.getPendantView() != null) {
            this.ehx.getPendantView().setIsRound(true);
            this.ehx.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_ala_live_thread_title);
        this.dcS = (TbImageView) getView().findViewById(d.g.card_concern_ala_live_thread_live_image_view);
        this.dcS.setDefaultErrorResource(0);
        this.dcS.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.dcS.setDrawerType(0);
        this.dcS.setBorderSurroundContent(true);
        this.dcS.setDrawBorder(true);
        TbImageView tbImageView = this.dcS;
        TbImageView tbImageView2 = this.dcS;
        tbImageView.setConrers(15);
        this.dcS.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
        this.dcS.setBorderColor(al.getColor(d.C0277d.black_alpha8));
        this.dhP = (LinearLayout) getView().findViewById(d.g.challenge_root);
        this.eib = view.findViewById(d.g.divider_line);
        this.dqz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_info_layout);
        this.fGV = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_user_info_layout);
        if (this.dqz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dqz.setLayoutParams(layoutParams);
        }
        this.dqz.setOnClickListener(this.eif);
        this.dqz.setReplyTimeVisible(false);
        this.dqz.setIsBarViewVisible(false);
        this.dqz.setShowPraiseNum(true);
        this.dqz.setNeedAddPraiseIcon(true);
        this.dqz.setNeedAddReplyIcon(true);
        this.dqz.setShareVisible(true);
        this.dqz.bSK = this.currentPageType;
        this.dqz.setShareReportFrom(4);
        this.dqz.setFrom(9);
        this.dqz.setDisPraiseFrom(4);
        this.dqz.setForumAfterClickListener(this.bRC);
        if (this.dqz.getCommentContainer() != null) {
            this.dqz.getCommentContainer().setOnClickListener(this.eif);
        }
        this.dro = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_ala_source_read_share_layout);
        this.dro.bTC.setOnClickListener(this.eif);
        this.dro.setShareReportFrom(4);
        this.dro.setFrom(9);
        this.dro.bTC.bSK = this.currentPageType;
        this.dro.setForumAfterClickListener(this.bRC);
        if (this.dro.bTC.getCommentContainer() != null) {
            this.dro.bTC.getCommentContainer().setOnClickListener(this.eif);
        }
        this.drz = (LinearLayout) view.findViewById(d.g.card_concern_ala_live_thread_content_layout);
        this.cAm = (TextView) getView().findViewById(d.g.play_count);
        this.ehq = (TBLottieAnimationView) view.findViewById(d.g.image_video_play);
        this.ehq.G(true);
        al.a(this.ehq, d.i.ala_play);
        this.ehq.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                a.this.ehq.cu();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                a.this.ehq.cancelAnimation();
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.f.addresslist_item_bg);
            this.dqz.onChangeSkinType();
            this.fGV.onChangeSkinType();
            this.dro.onChangeSkinType();
            al.l(this.eib, d.C0277d.cp_bg_line_e);
            al.j(this.cAm, d.C0277d.cp_btn_a);
            al.a(this.ehq, d.i.ala_play);
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
        this.ehn = jVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eif);
        }
        this.fGV.setData(jVar.threadData);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.tA(this.ehn.threadData.getId())) {
            n.a(this.mTitle, this.ehn.WO().getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        }
        this.fGV.setUserAfterClickListener(this.ZI);
        this.bSM = "feed#" + jVar.aQN();
        bg WO = jVar.WO();
        if (this.fGV.getHeaderImg() != null) {
            if (this.fGV.getIsSimpleThread()) {
                this.fGV.getHeaderImg().setVisibility(8);
                this.ehx.setVisibility(8);
            } else if (WO.YO() == null || WO.YO().getPendantData() == null || StringUtils.isNull(WO.YO().getPendantData().Xk())) {
                this.ehx.setVisibility(8);
                this.fGV.getHeaderImg().setVisibility(0);
                this.fGV.getHeaderImg().setData(WO);
            } else {
                this.fGV.getHeaderImg().setVisibility(4);
                this.ehx.setVisibility(0);
                this.ehx.setData(WO);
            }
        }
        n.a(WO, this.mTitle);
        this.dcS.startLoad(WO.Zh().cover, 10, false);
        this.cAm.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), ap.az(this.ehn.threadData.Zh().audience_count)));
        setPageUniqueId(getTag());
        this.ehq.cu();
        mE(ls(1));
        if (WO.Zh().mChallengeInfoData != null && WO.Zh().mChallengeInfoData.challenge_id > 0) {
            this.dhP.setVisibility(0);
        } else {
            this.dhP.setVisibility(8);
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
            return this.fGV.bTm;
        }
        return null;
    }

    public void aQA() {
        if (this.mPageContext != null && this.ehn != null && this.ehn.threadData != null && this.ehn.threadData.YO() != null && this.ehn.threadData.Zh() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.ehn.threadData.YO().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.ehn.threadData.Zh());
            alaLiveInfoCoreData.userName = this.ehn.threadData.YO().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, this.dky, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void mE(int i) {
        if (this.ehn != null && this.ehn.threadData != null) {
            this.mStType = n.YB();
            if (i == 1) {
                this.dqz.setVisibility(8);
                this.dro.setStType(this.mStType);
                this.dro.setData(this.ehn.threadData);
                this.fGV.dN(false);
                return;
            }
            this.dqz.setData(this.ehn.threadData);
            this.dqz.setStType(this.mStType);
            this.dro.setVisibility(8);
            this.fGV.dN(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YB = str;
    }

    public int ls(int i) {
        return com.baidu.tieba.a.d.awh().ak(this.YB, i);
    }
}
