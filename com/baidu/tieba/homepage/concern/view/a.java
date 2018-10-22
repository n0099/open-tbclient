package com.baidu.tieba.homepage.concern.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.card.o;
import com.baidu.tieba.e;
import com.baidu.tieba.view.AlaPlayAnimationView;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.a<j> implements com.baidu.tieba.a.e {
    private final View.OnClickListener aEh;
    private String aFm;
    private final View.OnClickListener aGk;
    private TbImageView bNi;
    private LinearLayout bNo;
    private String bQf;
    private String bVS;
    private HeadPendantClickableView bWP;
    public ThreadSourceShareAndPraiseLayout bWS;
    public ThreadCommentAndPraiseInfoLayout bWf;
    private LinearLayout bXd;
    public ImageView bkE;
    private TextView bkK;
    private View cKE;
    private View.OnClickListener cKG;
    private j cMD;
    private AlaPlayAnimationView cMH;
    public ConcernThreadUserInfoLayout eiX;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bQf = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.cKG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.anP() != null) {
                    a.this.anP().a(view, a.this.cMD);
                }
                a.this.aom();
            }
        };
        this.aGk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.anP() != null) {
                    a.this.anP().a(view, a.this.cMD);
                }
            }
        };
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.anP() != null) {
                    a.this.anP().a(view, a.this.cMD);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.bWP = (HeadPendantClickableView) view.findViewById(e.g.card_concern_ala_live_thread_user_pendant_header);
        if (this.bWP.getHeadView() != null) {
            this.bWP.getHeadView().setIsRound(true);
            this.bWP.getHeadView().setDrawBorder(false);
            this.bWP.getHeadView().setDefaultResource(17170445);
            this.bWP.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bWP.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bWP.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), e.C0175e.ds60));
        }
        this.bWP.setHasPendantStyle();
        if (this.bWP.getPendantView() != null) {
            this.bWP.getPendantView().setIsRound(true);
            this.bWP.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(e.g.card_concern_ala_live_thread_title);
        this.bNi = (TbImageView) getView().findViewById(e.g.card_concern_ala_live_thread_live_image_view);
        this.bNi.setDefaultErrorResource(0);
        this.bNi.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bNi.setDrawerType(0);
        this.bNi.setBorderSurroundContent(true);
        this.bNi.setDrawBorder(true);
        this.bNo = (LinearLayout) getView().findViewById(e.g.challenge_root);
        this.cKE = view.findViewById(e.g.divider_line);
        this.bWf = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_concern_ala_live_thread_info_layout);
        this.eiX = (ConcernThreadUserInfoLayout) view.findViewById(e.g.card_concern_ala_live_thread_user_info_layout);
        if (this.bWf.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWf.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bWf.setLayoutParams(layoutParams);
        }
        this.bWf.setOnClickListener(this.cKG);
        this.bWf.setReplyTimeVisible(false);
        this.bWf.setIsBarViewVisible(false);
        this.bWf.setShowPraiseNum(true);
        this.bWf.setNeedAddPraiseIcon(true);
        this.bWf.setNeedAddReplyIcon(true);
        this.bWf.setShareVisible(true);
        this.bWf.ary = this.currentPageType;
        this.bWf.setShareReportFrom(4);
        this.bWf.setFrom(9);
        this.bWf.setDisPraiseFrom(4);
        this.bWf.setForumAfterClickListener(this.aEh);
        if (this.bWf.getCommentContainer() != null) {
            this.bWf.getCommentContainer().setOnClickListener(this.cKG);
        }
        this.bWS = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_concern_ala_source_read_share_layout);
        this.bWS.aFS.setOnClickListener(this.cKG);
        this.bWS.setShareReportFrom(4);
        this.bWS.setFrom(9);
        this.bWS.aFS.ary = this.currentPageType;
        this.bWS.setForumAfterClickListener(this.aEh);
        if (this.bWS.aFS.getCommentContainer() != null) {
            this.bWS.aFS.getCommentContainer().setOnClickListener(this.cKG);
        }
        this.bXd = (LinearLayout) view.findViewById(e.g.card_concern_ala_live_thread_content_layout);
        this.bkK = (TextView) getView().findViewById(e.g.play_count);
        this.bkE = (ImageView) view.findViewById(e.g.image_video_play);
        this.cMH = (AlaPlayAnimationView) view.findViewById(e.g.ala_play);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            this.bWf.onChangeSkinType();
            this.eiX.onChangeSkinType();
            this.bWS.onChangeSkinType();
            al.j(this.cKE, e.d.cp_bg_line_e);
            al.h(this.bkK, e.d.cp_cont_i);
            al.c(this.bkE, e.f.btn_card_play_live_n);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_concern_ala_live_thread;
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
        this.cMD = jVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cKG);
        }
        this.eiX.setData(jVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.me(this.cMD.threadData.getId())) {
            o.a(this.mTitle, this.cMD.YB().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
        this.eiX.setUserAfterClickListener(this.aGk);
        this.aFm = "feed#" + jVar.aoz();
        bb YB = jVar.YB();
        if (this.eiX.getHeaderImg() != null) {
            if (this.eiX.getIsSimpleThread()) {
                this.eiX.getHeaderImg().setVisibility(8);
                this.bWP.setVisibility(8);
            } else if (YB.yv() == null || YB.yv().getPendantData() == null || StringUtils.isNull(YB.yv().getPendantData().xf())) {
                this.bWP.setVisibility(8);
                this.eiX.getHeaderImg().setVisibility(0);
                this.eiX.getHeaderImg().setData(YB);
            } else {
                this.eiX.getHeaderImg().setVisibility(4);
                this.bWP.setVisibility(0);
                this.bWP.setData(YB);
            }
        }
        o.a(YB, this.mTitle);
        this.bNi.startLoad(YB.yP().cover, 10, false);
        this.bkK.setText(String.format(this.mContext.getResources().getString(e.j.ala_audience_count_prefix), ao.N(this.cMD.threadData.yP().audience_count)));
        setPageUniqueId(getTag());
        this.cMH.startPlayAnimation();
        ik(hb(1));
        if (YB.yP().mChallengeInfoData != null && YB.yP().mChallengeInfoData.challenge_id > 0) {
            this.bNo.setVisibility(0);
        } else {
            this.bNo.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.eiX != null) {
            this.eiX.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.eiX != null) {
            return this.eiX.aFX;
        }
        return null;
    }

    public void aom() {
        if (this.mPageContext != null && this.cMD != null && this.cMD.threadData != null && this.cMD.threadData.yv() != null && this.cMD.threadData.yP() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.cMD.threadData.yv().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cMD.threadData.yP());
            alaLiveInfoCoreData.userName = this.cMD.threadData.yv().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, this.bQf, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void ik(int i) {
        if (this.cMD != null && this.cMD.threadData != null) {
            this.mStType = o.yj();
            if (i == 1) {
                this.bWf.setVisibility(8);
                this.bWS.setStType(this.mStType);
                this.bWS.setData(this.cMD.threadData);
                this.eiX.showForumNameView(false);
                return;
            }
            this.bWf.setData(this.cMD.threadData);
            this.bWf.setStType(this.mStType);
            this.bWS.setVisibility(8);
            this.eiX.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bVS = str;
    }

    public int hb(int i) {
        return com.baidu.tieba.a.d.Ux().M(this.bVS, i);
    }
}
