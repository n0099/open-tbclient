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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.d;
import com.baidu.tieba.view.AlaPlayAnimationView;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<j> {
    private String bdD;
    private final View.OnClickListener bdE;
    private final View.OnClickListener bdQ;
    private View cVv;
    private View.OnClickListener cVx;
    private j cWa;
    private TextView cWe;
    private AlaPlayAnimationView cWg;
    public ImageView cax;
    private String cgW;
    public ThreadCommentAndPraiseInfoLayout clX;
    private HeadPendantClickableView cmI;
    public ThreadSourceShareAndPraiseLayout cmL;
    private LinearLayout cmX;
    public ConcernThreadUserInfoLayout egE;
    private TbImageView egF;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cgW = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.cVx = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akO() != null) {
                    a.this.akO().a(view, a.this.cWa);
                }
                a.this.alp();
            }
        };
        this.bdQ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akO() != null) {
                    a.this.akO().a(view, a.this.cWa);
                }
            }
        };
        this.bdE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akO() != null) {
                    a.this.akO().a(view, a.this.cWa);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.cmI = (HeadPendantClickableView) view.findViewById(d.g.card_concern_ala_live_thread_user_pendant_header);
        if (this.cmI.getHeadView() != null) {
            this.cmI.getHeadView().setIsRound(true);
            this.cmI.getHeadView().setDrawBorder(false);
            this.cmI.getHeadView().setDefaultResource(17170445);
            this.cmI.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmI.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.cmI.getHeadView().setRadius(l.t(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        this.cmI.DS();
        if (this.cmI.getPendantView() != null) {
            this.cmI.getPendantView().setIsRound(true);
            this.cmI.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_ala_live_thread_title);
        this.egF = (TbImageView) getView().findViewById(d.g.card_concern_ala_live_thread_live_image_view);
        this.egF.setDefaultErrorResource(0);
        this.egF.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.egF.setDrawerType(0);
        this.egF.setBorderSurroundContent(true);
        this.egF.setDrawBorder(true);
        this.cVv = view.findViewById(d.g.divider_line);
        this.clX = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_info_layout);
        this.egE = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_user_info_layout);
        if (this.clX.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.clX.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.clX.setLayoutParams(layoutParams);
        }
        this.clX.setOnClickListener(this.cVx);
        this.clX.setReplyTimeVisible(false);
        this.clX.setIsBarViewVisible(false);
        this.clX.setShowPraiseNum(true);
        this.clX.setNeedAddPraiseIcon(true);
        this.clX.setNeedAddReplyIcon(true);
        this.clX.setShareVisible(true);
        this.clX.aQt = this.currentPageType;
        this.clX.setShareReportFrom(4);
        this.clX.setFrom(9);
        this.clX.setForumAfterClickListener(this.bdE);
        if (this.clX.getCommentContainer() != null) {
            this.clX.getCommentContainer().setOnClickListener(this.cVx);
        }
        this.cmL = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_ala_source_read_share_layout);
        this.cmL.bem.setOnClickListener(this.cVx);
        this.cmL.setShareReportFrom(4);
        this.cmL.setFrom(9);
        this.cmL.bem.aQt = this.currentPageType;
        this.cmL.setForumAfterClickListener(this.bdE);
        if (this.cmL.bem.getCommentContainer() != null) {
            this.cmL.bem.getCommentContainer().setOnClickListener(this.cVx);
        }
        this.cmX = (LinearLayout) view.findViewById(d.g.card_concern_ala_live_thread_content_layout);
        this.cWe = (TextView) getView().findViewById(d.g.play_count);
        this.cax = (ImageView) view.findViewById(d.g.image_video_play);
        this.cWg = (AlaPlayAnimationView) view.findViewById(d.g.ala_play);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            this.clX.onChangeSkinType();
            this.egE.onChangeSkinType();
            this.cmL.onChangeSkinType();
            aj.t(this.cVv, d.C0141d.cp_bg_line_e);
            aj.r(this.cWe, d.C0141d.cp_cont_i);
            aj.c(this.cax, d.f.btn_card_play_live_n);
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
        this.cWa = jVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVx);
        }
        this.egE.setData(jVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tieba.card.j.ks(this.cWa.threadData.getId())) {
            com.baidu.tieba.card.j.a(this.mTitle, this.cWa.WD().getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        }
        this.egE.setUserAfterClickListener(this.bdQ);
        this.bdD = "feed#" + jVar.alA();
        bd WD = jVar.WD();
        if (this.egE.getHeaderImg() != null) {
            if (this.egE.getIsSimpleThread()) {
                this.egE.getHeaderImg().setVisibility(8);
                this.cmI.setVisibility(8);
            } else if (WD.zn() == null || WD.zn().getPendantData() == null || StringUtils.isNull(WD.zn().getPendantData().ya())) {
                this.cmI.setVisibility(8);
                this.egE.getHeaderImg().setVisibility(0);
                this.egE.getHeaderImg().setData(WD);
            } else {
                this.egE.getHeaderImg().setVisibility(4);
                this.cmI.setVisibility(0);
                this.cmI.setData(WD);
            }
        }
        com.baidu.tieba.card.j.a(WD, this.mTitle);
        this.egF.startLoad(WD.zG().cover, 10, false);
        this.cWe.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), am.J(this.cWa.threadData.zG().audience_count)));
        setPageUniqueId(getTag());
        this.cWg.startPlayAnimation();
        jX(WD.aQo);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.egE != null) {
            this.egE.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.egE != null) {
            return this.egE.bdL;
        }
        return null;
    }

    public void alp() {
        if (this.mPageContext != null && this.cWa != null && this.cWa.threadData != null && this.cWa.threadData.zn() != null && this.cWa.threadData.zG() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.cWa.threadData.zn().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cWa.threadData.zG());
            alaLiveInfoCoreData.userName = this.cWa.threadData.zn().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, this.cgW, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void jX(int i) {
        if (this.cWa != null && this.cWa.threadData != null) {
            this.mStType = com.baidu.tieba.card.j.zd();
            if (i == 1) {
                this.clX.setVisibility(8);
                this.cmL.setStType(this.mStType);
                this.cmL.setData(this.cWa.threadData);
                this.egE.showForumNameView(false);
                return;
            }
            this.clX.setData(this.cWa.threadData);
            this.clX.setStType(this.mStType);
            this.cmL.setVisibility(8);
            this.egE.showForumNameView(true);
        }
    }
}
