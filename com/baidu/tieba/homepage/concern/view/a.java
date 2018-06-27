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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import com.baidu.tieba.view.AlaPlayAnimationView;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<j> implements com.baidu.tieba.a.e {
    private String axS;
    private final View.OnClickListener axT;
    private final View.OnClickListener ayi;
    private String bBe;
    private String bGM;
    public ThreadCommentAndPraiseInfoLayout bGZ;
    private HeadPendantClickableView bHK;
    public ThreadSourceShareAndPraiseLayout bHN;
    private LinearLayout bHY;
    public ImageView bcK;
    private TextView bcQ;
    private TbImageView byi;
    private LinearLayout byo;
    private View ctT;
    private View.OnClickListener ctV;
    private j cvU;
    private AlaPlayAnimationView cvY;
    public ConcernThreadUserInfoLayout dRc;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bBe = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.ctV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aia() != null) {
                    a.this.aia().a(view, a.this.cvU);
                }
                a.this.aiw();
            }
        };
        this.ayi = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aia() != null) {
                    a.this.aia().a(view, a.this.cvU);
                }
            }
        };
        this.axT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aia() != null) {
                    a.this.aia().a(view, a.this.cvU);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.bHK = (HeadPendantClickableView) view.findViewById(d.g.card_concern_ala_live_thread_user_pendant_header);
        if (this.bHK.getHeadView() != null) {
            this.bHK.getHeadView().setIsRound(true);
            this.bHK.getHeadView().setDrawBorder(false);
            this.bHK.getHeadView().setDefaultResource(17170445);
            this.bHK.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bHK.getHeadView().setDefaultBgResource(d.C0142d.cp_bg_line_e);
            this.bHK.getHeadView().setRadius(l.e(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        this.bHK.setHasPendantStyle();
        if (this.bHK.getPendantView() != null) {
            this.bHK.getPendantView().setIsRound(true);
            this.bHK.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_ala_live_thread_title);
        this.byi = (TbImageView) getView().findViewById(d.g.card_concern_ala_live_thread_live_image_view);
        this.byi.setDefaultErrorResource(0);
        this.byi.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.byi.setDrawerType(0);
        this.byi.setBorderSurroundContent(true);
        this.byi.setDrawBorder(true);
        this.byo = (LinearLayout) getView().findViewById(d.g.challenge_root);
        this.ctT = view.findViewById(d.g.divider_line);
        this.bGZ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_info_layout);
        this.dRc = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_user_info_layout);
        if (this.bGZ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bGZ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bGZ.setLayoutParams(layoutParams);
        }
        this.bGZ.setOnClickListener(this.ctV);
        this.bGZ.setReplyTimeVisible(false);
        this.bGZ.setIsBarViewVisible(false);
        this.bGZ.setShowPraiseNum(true);
        this.bGZ.setNeedAddPraiseIcon(true);
        this.bGZ.setNeedAddReplyIcon(true);
        this.bGZ.setShareVisible(true);
        this.bGZ.akz = this.currentPageType;
        this.bGZ.setShareReportFrom(4);
        this.bGZ.setFrom(9);
        this.bGZ.setForumAfterClickListener(this.axT);
        if (this.bGZ.getCommentContainer() != null) {
            this.bGZ.getCommentContainer().setOnClickListener(this.ctV);
        }
        this.bHN = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_ala_source_read_share_layout);
        this.bHN.ayE.setOnClickListener(this.ctV);
        this.bHN.setShareReportFrom(4);
        this.bHN.setFrom(9);
        this.bHN.ayE.akz = this.currentPageType;
        this.bHN.setForumAfterClickListener(this.axT);
        if (this.bHN.ayE.getCommentContainer() != null) {
            this.bHN.ayE.getCommentContainer().setOnClickListener(this.ctV);
        }
        this.bHY = (LinearLayout) view.findViewById(d.g.card_concern_ala_live_thread_content_layout);
        this.bcQ = (TextView) getView().findViewById(d.g.play_count);
        this.bcK = (ImageView) view.findViewById(d.g.image_video_play);
        this.cvY = (AlaPlayAnimationView) view.findViewById(d.g.ala_play);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), d.f.addresslist_item_bg);
            this.bGZ.onChangeSkinType();
            this.dRc.onChangeSkinType();
            this.bHN.onChangeSkinType();
            am.j(this.ctT, d.C0142d.cp_bg_line_e);
            am.h(this.bcQ, d.C0142d.cp_cont_i);
            am.c(this.bcK, d.f.btn_card_play_live_n);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_concern_ala_live_thread;
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
        this.cvU = jVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.ctV);
        }
        this.dRc.setData(jVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.kZ(this.cvU.threadData.getId())) {
            o.a(this.mTitle, this.cvU.SV().getId(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
        }
        this.dRc.setUserAfterClickListener(this.ayi);
        this.axS = "feed#" + jVar.aiJ();
        bc SV = jVar.SV();
        if (this.dRc.getHeaderImg() != null) {
            if (this.dRc.getIsSimpleThread()) {
                this.dRc.getHeaderImg().setVisibility(8);
                this.bHK.setVisibility(8);
            } else if (SV.vw() == null || SV.vw().getPendantData() == null || StringUtils.isNull(SV.vw().getPendantData().uh())) {
                this.bHK.setVisibility(8);
                this.dRc.getHeaderImg().setVisibility(0);
                this.dRc.getHeaderImg().setData(SV);
            } else {
                this.dRc.getHeaderImg().setVisibility(4);
                this.bHK.setVisibility(0);
                this.bHK.setData(SV);
            }
        }
        o.a(SV, this.mTitle);
        this.byi.startLoad(SV.vO().cover, 10, false);
        this.bcQ.setText(String.format(this.mContext.getResources().getString(d.k.ala_audience_count_prefix), ap.F(this.cvU.threadData.vO().audience_count)));
        setPageUniqueId(getTag());
        this.cvY.startPlayAnimation();
        hh(gp(1));
        if (SV.vO().mChallengeInfoData != null && SV.vO().mChallengeInfoData.challenge_id > 0) {
            this.byo.setVisibility(0);
        } else {
            this.byo.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.dRc != null) {
            this.dRc.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dRc != null) {
            return this.dRc.aye;
        }
        return null;
    }

    public void aiw() {
        if (this.mPageContext != null && this.cvU != null && this.cvU.threadData != null && this.cvU.threadData.vw() != null && this.cvU.threadData.vO() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.cvU.threadData.vw().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cvU.threadData.vO());
            alaLiveInfoCoreData.userName = this.cvU.threadData.vw().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, this.bBe, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void hh(int i) {
        if (this.cvU != null && this.cvU.threadData != null) {
            this.mStType = o.vk();
            if (i == 1) {
                this.bGZ.setVisibility(8);
                this.bHN.setStType(this.mStType);
                this.bHN.setData(this.cvU.threadData);
                this.dRc.showForumNameView(false);
                return;
            }
            this.bGZ.setData(this.cvU.threadData);
            this.bGZ.setStType(this.mStType);
            this.bHN.setVisibility(8);
            this.dRc.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bGM = str;
    }

    public int gp(int i) {
        return com.baidu.tieba.a.d.QB().L(this.bGM, i);
    }
}
