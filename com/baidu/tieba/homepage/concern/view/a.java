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
    private String bdF;
    private final View.OnClickListener bdG;
    private final View.OnClickListener bdT;
    private View.OnClickListener cVA;
    private View cVy;
    private j cWd;
    private TextView cWh;
    private AlaPlayAnimationView cWj;
    public ImageView caA;
    private String cgZ;
    private HeadPendantClickableView cmL;
    public ThreadSourceShareAndPraiseLayout cmO;
    public ThreadCommentAndPraiseInfoLayout cma;
    private LinearLayout cna;
    public ConcernThreadUserInfoLayout egU;
    private TbImageView egV;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cgZ = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.cVA = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akP() != null) {
                    a.this.akP().a(view, a.this.cWd);
                }
                a.this.alq();
            }
        };
        this.bdT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akP() != null) {
                    a.this.akP().a(view, a.this.cWd);
                }
            }
        };
        this.bdG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akP() != null) {
                    a.this.akP().a(view, a.this.cWd);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.cmL = (HeadPendantClickableView) view.findViewById(d.g.card_concern_ala_live_thread_user_pendant_header);
        if (this.cmL.getHeadView() != null) {
            this.cmL.getHeadView().setIsRound(true);
            this.cmL.getHeadView().setDrawBorder(false);
            this.cmL.getHeadView().setDefaultResource(17170445);
            this.cmL.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmL.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.cmL.getHeadView().setRadius(l.t(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        this.cmL.DT();
        if (this.cmL.getPendantView() != null) {
            this.cmL.getPendantView().setIsRound(true);
            this.cmL.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_ala_live_thread_title);
        this.egV = (TbImageView) getView().findViewById(d.g.card_concern_ala_live_thread_live_image_view);
        this.egV.setDefaultErrorResource(0);
        this.egV.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.egV.setDrawerType(0);
        this.egV.setBorderSurroundContent(true);
        this.egV.setDrawBorder(true);
        this.cVy = view.findViewById(d.g.divider_line);
        this.cma = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_info_layout);
        this.egU = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_user_info_layout);
        if (this.cma.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cma.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cma.setLayoutParams(layoutParams);
        }
        this.cma.setOnClickListener(this.cVA);
        this.cma.setReplyTimeVisible(false);
        this.cma.setIsBarViewVisible(false);
        this.cma.setShowPraiseNum(true);
        this.cma.setNeedAddPraiseIcon(true);
        this.cma.setNeedAddReplyIcon(true);
        this.cma.setShareVisible(true);
        this.cma.aQv = this.currentPageType;
        this.cma.setShareReportFrom(4);
        this.cma.setFrom(9);
        this.cma.setForumAfterClickListener(this.bdG);
        if (this.cma.getCommentContainer() != null) {
            this.cma.getCommentContainer().setOnClickListener(this.cVA);
        }
        this.cmO = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_ala_source_read_share_layout);
        this.cmO.bep.setOnClickListener(this.cVA);
        this.cmO.setShareReportFrom(4);
        this.cmO.setFrom(9);
        this.cmO.bep.aQv = this.currentPageType;
        this.cmO.setForumAfterClickListener(this.bdG);
        if (this.cmO.bep.getCommentContainer() != null) {
            this.cmO.bep.getCommentContainer().setOnClickListener(this.cVA);
        }
        this.cna = (LinearLayout) view.findViewById(d.g.card_concern_ala_live_thread_content_layout);
        this.cWh = (TextView) getView().findViewById(d.g.play_count);
        this.caA = (ImageView) view.findViewById(d.g.image_video_play);
        this.cWj = (AlaPlayAnimationView) view.findViewById(d.g.ala_play);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            this.cma.onChangeSkinType();
            this.egU.onChangeSkinType();
            this.cmO.onChangeSkinType();
            aj.t(this.cVy, d.C0141d.cp_bg_line_e);
            aj.r(this.cWh, d.C0141d.cp_cont_i);
            aj.c(this.caA, d.f.btn_card_play_live_n);
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
        this.cWd = jVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVA);
        }
        this.egU.setData(jVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tieba.card.j.ks(this.cWd.threadData.getId())) {
            com.baidu.tieba.card.j.a(this.mTitle, this.cWd.WE().getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        }
        this.egU.setUserAfterClickListener(this.bdT);
        this.bdF = "feed#" + jVar.alB();
        bd WE = jVar.WE();
        if (this.egU.getHeaderImg() != null) {
            if (this.egU.getIsSimpleThread()) {
                this.egU.getHeaderImg().setVisibility(8);
                this.cmL.setVisibility(8);
            } else if (WE.zn() == null || WE.zn().getPendantData() == null || StringUtils.isNull(WE.zn().getPendantData().ya())) {
                this.cmL.setVisibility(8);
                this.egU.getHeaderImg().setVisibility(0);
                this.egU.getHeaderImg().setData(WE);
            } else {
                this.egU.getHeaderImg().setVisibility(4);
                this.cmL.setVisibility(0);
                this.cmL.setData(WE);
            }
        }
        com.baidu.tieba.card.j.a(WE, this.mTitle);
        this.egV.startLoad(WE.zG().cover, 10, false);
        this.cWh.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), am.J(this.cWd.threadData.zG().audience_count)));
        setPageUniqueId(getTag());
        this.cWj.startPlayAnimation();
        jX(WE.aQp);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.egU != null) {
            this.egU.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.egU != null) {
            return this.egU.bdO;
        }
        return null;
    }

    public void alq() {
        if (this.mPageContext != null && this.cWd != null && this.cWd.threadData != null && this.cWd.threadData.zn() != null && this.cWd.threadData.zG() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.cWd.threadData.zn().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cWd.threadData.zG());
            alaLiveInfoCoreData.userName = this.cWd.threadData.zn().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, this.cgZ, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void jX(int i) {
        if (this.cWd != null && this.cWd.threadData != null) {
            this.mStType = com.baidu.tieba.card.j.zd();
            if (i == 1) {
                this.cma.setVisibility(8);
                this.cmO.setStType(this.mStType);
                this.cmO.setData(this.cWd.threadData);
                this.egU.showForumNameView(false);
                return;
            }
            this.cma.setData(this.cWd.threadData);
            this.cma.setStType(this.mStType);
            this.cmO.setVisibility(8);
            this.egU.showForumNameView(true);
        }
    }
}
