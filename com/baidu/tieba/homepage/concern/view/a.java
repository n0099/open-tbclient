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
    private final View.OnClickListener axO;
    private String axy;
    private final View.OnClickListener axz;
    private String bBL;
    private String bHB;
    public ThreadCommentAndPraiseInfoLayout bHO;
    public ThreadSourceShareAndPraiseLayout bIC;
    private LinearLayout bIN;
    private HeadPendantClickableView bIz;
    public ImageView bcT;
    private TextView bcZ;
    private TbImageView byN;
    private LinearLayout byT;
    private View cww;
    private View.OnClickListener cwy;
    private AlaPlayAnimationView cyA;
    private j cyw;
    public ConcernThreadUserInfoLayout dTP;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bBL = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.cwy = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiz() != null) {
                    a.this.aiz().a(view, a.this.cyw);
                }
                a.this.aiV();
            }
        };
        this.axO = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiz() != null) {
                    a.this.aiz().a(view, a.this.cyw);
                }
            }
        };
        this.axz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiz() != null) {
                    a.this.aiz().a(view, a.this.cyw);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.bIz = (HeadPendantClickableView) view.findViewById(d.g.card_concern_ala_live_thread_user_pendant_header);
        if (this.bIz.getHeadView() != null) {
            this.bIz.getHeadView().setIsRound(true);
            this.bIz.getHeadView().setDrawBorder(false);
            this.bIz.getHeadView().setDefaultResource(17170445);
            this.bIz.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bIz.getHeadView().setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.bIz.getHeadView().setRadius(l.f(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        this.bIz.setHasPendantStyle();
        if (this.bIz.getPendantView() != null) {
            this.bIz.getPendantView().setIsRound(true);
            this.bIz.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_ala_live_thread_title);
        this.byN = (TbImageView) getView().findViewById(d.g.card_concern_ala_live_thread_live_image_view);
        this.byN.setDefaultErrorResource(0);
        this.byN.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.byN.setDrawerType(0);
        this.byN.setBorderSurroundContent(true);
        this.byN.setDrawBorder(true);
        this.byT = (LinearLayout) getView().findViewById(d.g.challenge_root);
        this.cww = view.findViewById(d.g.divider_line);
        this.bHO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_info_layout);
        this.dTP = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_user_info_layout);
        if (this.bHO.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHO.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bHO.setLayoutParams(layoutParams);
        }
        this.bHO.setOnClickListener(this.cwy);
        this.bHO.setReplyTimeVisible(false);
        this.bHO.setIsBarViewVisible(false);
        this.bHO.setShowPraiseNum(true);
        this.bHO.setNeedAddPraiseIcon(true);
        this.bHO.setNeedAddReplyIcon(true);
        this.bHO.setShareVisible(true);
        this.bHO.ajY = this.currentPageType;
        this.bHO.setShareReportFrom(4);
        this.bHO.setFrom(9);
        this.bHO.setForumAfterClickListener(this.axz);
        if (this.bHO.getCommentContainer() != null) {
            this.bHO.getCommentContainer().setOnClickListener(this.cwy);
        }
        this.bIC = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_ala_source_read_share_layout);
        this.bIC.ayr.setOnClickListener(this.cwy);
        this.bIC.setShareReportFrom(4);
        this.bIC.setFrom(9);
        this.bIC.ayr.ajY = this.currentPageType;
        this.bIC.setForumAfterClickListener(this.axz);
        if (this.bIC.ayr.getCommentContainer() != null) {
            this.bIC.ayr.getCommentContainer().setOnClickListener(this.cwy);
        }
        this.bIN = (LinearLayout) view.findViewById(d.g.card_concern_ala_live_thread_content_layout);
        this.bcZ = (TextView) getView().findViewById(d.g.play_count);
        this.bcT = (ImageView) view.findViewById(d.g.image_video_play);
        this.cyA = (AlaPlayAnimationView) view.findViewById(d.g.ala_play);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), d.f.addresslist_item_bg);
            this.bHO.onChangeSkinType();
            this.dTP.onChangeSkinType();
            this.bIC.onChangeSkinType();
            am.j(this.cww, d.C0140d.cp_bg_line_e);
            am.h(this.bcZ, d.C0140d.cp_cont_i);
            am.c(this.bcT, d.f.btn_card_play_live_n);
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
        this.cyw = jVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cwy);
        }
        this.dTP.setData(jVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.kX(this.cyw.threadData.getId())) {
            o.a(this.mTitle, this.cyw.Td().getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
        }
        this.dTP.setUserAfterClickListener(this.axO);
        this.axy = "feed#" + jVar.aji();
        bb Td = jVar.Td();
        if (this.dTP.getHeaderImg() != null) {
            if (this.dTP.getIsSimpleThread()) {
                this.dTP.getHeaderImg().setVisibility(8);
                this.bIz.setVisibility(8);
            } else if (Td.vk() == null || Td.vk().getPendantData() == null || StringUtils.isNull(Td.vk().getPendantData().tU())) {
                this.bIz.setVisibility(8);
                this.dTP.getHeaderImg().setVisibility(0);
                this.dTP.getHeaderImg().setData(Td);
            } else {
                this.dTP.getHeaderImg().setVisibility(4);
                this.bIz.setVisibility(0);
                this.bIz.setData(Td);
            }
        }
        o.a(Td, this.mTitle);
        this.byN.startLoad(Td.vD().cover, 10, false);
        this.bcZ.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), ap.H(this.cyw.threadData.vD().audience_count)));
        setPageUniqueId(getTag());
        this.cyA.startPlayAnimation();
        hn(gu(1));
        if (Td.vD().mChallengeInfoData != null && Td.vD().mChallengeInfoData.challenge_id > 0) {
            this.byT.setVisibility(0);
        } else {
            this.byT.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.dTP != null) {
            this.dTP.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dTP != null) {
            return this.dTP.axK;
        }
        return null;
    }

    public void aiV() {
        if (this.mPageContext != null && this.cyw != null && this.cyw.threadData != null && this.cyw.threadData.vk() != null && this.cyw.threadData.vD() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.cyw.threadData.vk().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cyw.threadData.vD());
            alaLiveInfoCoreData.userName = this.cyw.threadData.vk().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, this.bBL, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void hn(int i) {
        if (this.cyw != null && this.cyw.threadData != null) {
            this.mStType = o.uY();
            if (i == 1) {
                this.bHO.setVisibility(8);
                this.bIC.setStType(this.mStType);
                this.bIC.setData(this.cyw.threadData);
                this.dTP.showForumNameView(false);
                return;
            }
            this.bHO.setData(this.cyw.threadData);
            this.bHO.setStType(this.mStType);
            this.bIC.setVisibility(8);
            this.dTP.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bHB = str;
    }

    public int gu(int i) {
        return com.baidu.tieba.a.d.QI().G(this.bHB, i);
    }
}
