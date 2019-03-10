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
    private String Yz;
    private final View.OnClickListener ZF;
    private final View.OnClickListener bRy;
    private String bSI;
    private TextView cAm;
    private TbImageView dcR;
    private LinearLayout dhP;
    private String dky;
    public ThreadCommentAndPraiseInfoLayout dqz;
    public ThreadSourceShareAndPraiseLayout dro;
    private LinearLayout drz;
    private j ehE;
    private TBLottieAnimationView ehH;
    private HeadPendantClickableView ehO;
    private View eis;
    private View.OnClickListener eiw;
    public ConcernThreadUserInfoLayout fHi;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dky = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.eiw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aQi() != null) {
                    a.this.aQi().a(view, a.this.ehE);
                }
                a.this.aQD();
            }
        };
        this.ZF = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aQi() != null) {
                    a.this.aQi().a(view, a.this.ehE);
                }
            }
        };
        this.bRy = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aQi() != null) {
                    a.this.aQi().a(view, a.this.ehE);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.ehO = (HeadPendantClickableView) view.findViewById(d.g.card_concern_ala_live_thread_user_pendant_header);
        if (this.ehO.getHeadView() != null) {
            this.ehO.getHeadView().setIsRound(true);
            this.ehO.getHeadView().setDrawBorder(false);
            this.ehO.getHeadView().setDefaultResource(17170445);
            this.ehO.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.ehO.getHeadView().setDefaultBgResource(d.C0236d.cp_bg_line_e);
            this.ehO.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        this.ehO.setHasPendantStyle();
        if (this.ehO.getPendantView() != null) {
            this.ehO.getPendantView().setIsRound(true);
            this.ehO.getPendantView().setDrawBorder(false);
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
        this.dcR.setBorderColor(al.getColor(d.C0236d.black_alpha8));
        this.dhP = (LinearLayout) getView().findViewById(d.g.challenge_root);
        this.eis = view.findViewById(d.g.divider_line);
        this.dqz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_info_layout);
        this.fHi = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_user_info_layout);
        if (this.dqz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dqz.setLayoutParams(layoutParams);
        }
        this.dqz.setOnClickListener(this.eiw);
        this.dqz.setReplyTimeVisible(false);
        this.dqz.setIsBarViewVisible(false);
        this.dqz.setShowPraiseNum(true);
        this.dqz.setNeedAddPraiseIcon(true);
        this.dqz.setNeedAddReplyIcon(true);
        this.dqz.setShareVisible(true);
        this.dqz.bSG = this.currentPageType;
        this.dqz.setShareReportFrom(4);
        this.dqz.setFrom(9);
        this.dqz.setDisPraiseFrom(4);
        this.dqz.setForumAfterClickListener(this.bRy);
        if (this.dqz.getCommentContainer() != null) {
            this.dqz.getCommentContainer().setOnClickListener(this.eiw);
        }
        this.dro = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_ala_source_read_share_layout);
        this.dro.bTy.setOnClickListener(this.eiw);
        this.dro.setShareReportFrom(4);
        this.dro.setFrom(9);
        this.dro.bTy.bSG = this.currentPageType;
        this.dro.setForumAfterClickListener(this.bRy);
        if (this.dro.bTy.getCommentContainer() != null) {
            this.dro.bTy.getCommentContainer().setOnClickListener(this.eiw);
        }
        this.drz = (LinearLayout) view.findViewById(d.g.card_concern_ala_live_thread_content_layout);
        this.cAm = (TextView) getView().findViewById(d.g.play_count);
        this.ehH = (TBLottieAnimationView) view.findViewById(d.g.image_video_play);
        this.ehH.G(true);
        al.a(this.ehH, d.i.ala_play);
        this.ehH.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                a.this.ehH.cu();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                a.this.ehH.cancelAnimation();
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.f.addresslist_item_bg);
            this.dqz.onChangeSkinType();
            this.fHi.onChangeSkinType();
            this.dro.onChangeSkinType();
            al.l(this.eis, d.C0236d.cp_bg_line_e);
            al.j(this.cAm, d.C0236d.cp_btn_a);
            al.a(this.ehH, d.i.ala_play);
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
        this.ehE = jVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eiw);
        }
        this.fHi.setData(jVar.threadData);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.tD(this.ehE.threadData.getId())) {
            n.a(this.mTitle, this.ehE.WR().getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
        }
        this.fHi.setUserAfterClickListener(this.ZF);
        this.bSI = "feed#" + jVar.aQQ();
        bg WR = jVar.WR();
        if (this.fHi.getHeaderImg() != null) {
            if (this.fHi.getIsSimpleThread()) {
                this.fHi.getHeaderImg().setVisibility(8);
                this.ehO.setVisibility(8);
            } else if (WR.YR() == null || WR.YR().getPendantData() == null || StringUtils.isNull(WR.YR().getPendantData().Xn())) {
                this.ehO.setVisibility(8);
                this.fHi.getHeaderImg().setVisibility(0);
                this.fHi.getHeaderImg().setData(WR);
            } else {
                this.fHi.getHeaderImg().setVisibility(4);
                this.ehO.setVisibility(0);
                this.ehO.setData(WR);
            }
        }
        n.a(WR, this.mTitle);
        this.dcR.startLoad(WR.Zk().cover, 10, false);
        this.cAm.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), ap.az(this.ehE.threadData.Zk().audience_count)));
        setPageUniqueId(getTag());
        this.ehH.cu();
        mF(lt(1));
        if (WR.Zk().mChallengeInfoData != null && WR.Zk().mChallengeInfoData.challenge_id > 0) {
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
        if (this.fHi != null) {
            this.fHi.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.fHi != null) {
            return this.fHi.bTi;
        }
        return null;
    }

    public void aQD() {
        if (this.mPageContext != null && this.ehE != null && this.ehE.threadData != null && this.ehE.threadData.YR() != null && this.ehE.threadData.Zk() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.ehE.threadData.YR().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.ehE.threadData.Zk());
            alaLiveInfoCoreData.userName = this.ehE.threadData.YR().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, this.dky, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void mF(int i) {
        if (this.ehE != null && this.ehE.threadData != null) {
            this.mStType = n.YE();
            if (i == 1) {
                this.dqz.setVisibility(8);
                this.dro.setStType(this.mStType);
                this.dro.setData(this.ehE.threadData);
                this.fHi.dN(false);
                return;
            }
            this.dqz.setData(this.ehE.threadData);
            this.dqz.setStType(this.mStType);
            this.dro.setVisibility(8);
            this.fHi.dN(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Yz = str;
    }

    public int lt(int i) {
        return com.baidu.tieba.a.d.awl().ak(this.Yz, i);
    }
}
