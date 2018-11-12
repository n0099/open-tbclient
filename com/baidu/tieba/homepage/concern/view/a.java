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
    private final View.OnClickListener aEX;
    private String aGc;
    private final View.OnClickListener aHa;
    private TbImageView bNT;
    private LinearLayout bNZ;
    private String bQP;
    private String bWE;
    public ThreadCommentAndPraiseInfoLayout bWR;
    private HeadPendantClickableView bXB;
    public ThreadSourceShareAndPraiseLayout bXE;
    private LinearLayout bXP;
    public ImageView blp;
    private TextView blv;
    private View cLK;
    private View.OnClickListener cLM;
    private j cNJ;
    private AlaPlayAnimationView cNN;
    public ConcernThreadUserInfoLayout ekr;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bQP = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.cLM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.anq() != null) {
                    a.this.anq().a(view, a.this.cNJ);
                }
                a.this.anN();
            }
        };
        this.aHa = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.anq() != null) {
                    a.this.anq().a(view, a.this.cNJ);
                }
            }
        };
        this.aEX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.anq() != null) {
                    a.this.anq().a(view, a.this.cNJ);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.bXB = (HeadPendantClickableView) view.findViewById(e.g.card_concern_ala_live_thread_user_pendant_header);
        if (this.bXB.getHeadView() != null) {
            this.bXB.getHeadView().setIsRound(true);
            this.bXB.getHeadView().setDrawBorder(false);
            this.bXB.getHeadView().setDefaultResource(17170445);
            this.bXB.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bXB.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bXB.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), e.C0200e.ds60));
        }
        this.bXB.setHasPendantStyle();
        if (this.bXB.getPendantView() != null) {
            this.bXB.getPendantView().setIsRound(true);
            this.bXB.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(e.g.card_concern_ala_live_thread_title);
        this.bNT = (TbImageView) getView().findViewById(e.g.card_concern_ala_live_thread_live_image_view);
        this.bNT.setDefaultErrorResource(0);
        this.bNT.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bNT.setDrawerType(0);
        this.bNT.setBorderSurroundContent(true);
        this.bNT.setDrawBorder(true);
        this.bNZ = (LinearLayout) getView().findViewById(e.g.challenge_root);
        this.cLK = view.findViewById(e.g.divider_line);
        this.bWR = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_concern_ala_live_thread_info_layout);
        this.ekr = (ConcernThreadUserInfoLayout) view.findViewById(e.g.card_concern_ala_live_thread_user_info_layout);
        if (this.bWR.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWR.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bWR.setLayoutParams(layoutParams);
        }
        this.bWR.setOnClickListener(this.cLM);
        this.bWR.setReplyTimeVisible(false);
        this.bWR.setIsBarViewVisible(false);
        this.bWR.setShowPraiseNum(true);
        this.bWR.setNeedAddPraiseIcon(true);
        this.bWR.setNeedAddReplyIcon(true);
        this.bWR.setShareVisible(true);
        this.bWR.asl = this.currentPageType;
        this.bWR.setShareReportFrom(4);
        this.bWR.setFrom(9);
        this.bWR.setDisPraiseFrom(4);
        this.bWR.setForumAfterClickListener(this.aEX);
        if (this.bWR.getCommentContainer() != null) {
            this.bWR.getCommentContainer().setOnClickListener(this.cLM);
        }
        this.bXE = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_concern_ala_source_read_share_layout);
        this.bXE.aGI.setOnClickListener(this.cLM);
        this.bXE.setShareReportFrom(4);
        this.bXE.setFrom(9);
        this.bXE.aGI.asl = this.currentPageType;
        this.bXE.setForumAfterClickListener(this.aEX);
        if (this.bXE.aGI.getCommentContainer() != null) {
            this.bXE.aGI.getCommentContainer().setOnClickListener(this.cLM);
        }
        this.bXP = (LinearLayout) view.findViewById(e.g.card_concern_ala_live_thread_content_layout);
        this.blv = (TextView) getView().findViewById(e.g.play_count);
        this.blp = (ImageView) view.findViewById(e.g.image_video_play);
        this.cNN = (AlaPlayAnimationView) view.findViewById(e.g.ala_play);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            this.bWR.onChangeSkinType();
            this.ekr.onChangeSkinType();
            this.bXE.onChangeSkinType();
            al.j(this.cLK, e.d.cp_bg_line_e);
            al.h(this.blv, e.d.cp_cont_i);
            al.c(this.blp, e.f.btn_card_play_live_n);
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
        this.cNJ = jVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cLM);
        }
        this.ekr.setData(jVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.mf(this.cNJ.threadData.getId())) {
            o.a(this.mTitle, this.cNJ.YL().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
        this.ekr.setUserAfterClickListener(this.aHa);
        this.aGc = "feed#" + jVar.aoa();
        bb YL = jVar.YL();
        if (this.ekr.getHeaderImg() != null) {
            if (this.ekr.getIsSimpleThread()) {
                this.ekr.getHeaderImg().setVisibility(8);
                this.bXB.setVisibility(8);
            } else if (YL.yC() == null || YL.yC().getPendantData() == null || StringUtils.isNull(YL.yC().getPendantData().xn())) {
                this.bXB.setVisibility(8);
                this.ekr.getHeaderImg().setVisibility(0);
                this.ekr.getHeaderImg().setData(YL);
            } else {
                this.ekr.getHeaderImg().setVisibility(4);
                this.bXB.setVisibility(0);
                this.bXB.setData(YL);
            }
        }
        o.a(YL, this.mTitle);
        this.bNT.startLoad(YL.yW().cover, 10, false);
        this.blv.setText(String.format(this.mContext.getResources().getString(e.j.ala_audience_count_prefix), ao.P(this.cNJ.threadData.yW().audience_count)));
        setPageUniqueId(getTag());
        this.cNN.startPlayAnimation();
        ix(ho(1));
        if (YL.yW().mChallengeInfoData != null && YL.yW().mChallengeInfoData.challenge_id > 0) {
            this.bNZ.setVisibility(0);
        } else {
            this.bNZ.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.ekr != null) {
            this.ekr.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.ekr != null) {
            return this.ekr.aGN;
        }
        return null;
    }

    public void anN() {
        if (this.mPageContext != null && this.cNJ != null && this.cNJ.threadData != null && this.cNJ.threadData.yC() != null && this.cNJ.threadData.yW() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.cNJ.threadData.yC().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cNJ.threadData.yW());
            alaLiveInfoCoreData.userName = this.cNJ.threadData.yC().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, this.bQP, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void ix(int i) {
        if (this.cNJ != null && this.cNJ.threadData != null) {
            this.mStType = o.yq();
            if (i == 1) {
                this.bWR.setVisibility(8);
                this.bXE.setStType(this.mStType);
                this.bXE.setData(this.cNJ.threadData);
                this.ekr.showForumNameView(false);
                return;
            }
            this.bWR.setData(this.cNJ.threadData);
            this.bWR.setStType(this.mStType);
            this.bXE.setVisibility(8);
            this.ekr.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bWE = str;
    }

    public int ho(int i) {
        return com.baidu.tieba.a.d.UG().M(this.bWE, i);
    }
}
