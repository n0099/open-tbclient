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
    private final View.OnClickListener aJa;
    private String aKg;
    private final View.OnClickListener aLe;
    private LinearLayout bSE;
    private TbImageView bSy;
    private String bVu;
    public ImageView bpE;
    private TextView bpK;
    private View cVS;
    private View.OnClickListener cVU;
    private j cXR;
    private AlaPlayAnimationView cXV;
    private String cbk;
    public ThreadCommentAndPraiseInfoLayout cbx;
    private HeadPendantClickableView cch;
    public ThreadSourceShareAndPraiseLayout cck;
    private LinearLayout ccw;
    public ConcernThreadUserInfoLayout euJ;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bVu = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.cVU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aqp() != null) {
                    a.this.aqp().a(view, a.this.cXR);
                }
                a.this.aqM();
            }
        };
        this.aLe = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aqp() != null) {
                    a.this.aqp().a(view, a.this.cXR);
                }
            }
        };
        this.aJa = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aqp() != null) {
                    a.this.aqp().a(view, a.this.cXR);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.cch = (HeadPendantClickableView) view.findViewById(e.g.card_concern_ala_live_thread_user_pendant_header);
        if (this.cch.getHeadView() != null) {
            this.cch.getHeadView().setIsRound(true);
            this.cch.getHeadView().setDrawBorder(false);
            this.cch.getHeadView().setDefaultResource(17170445);
            this.cch.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cch.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cch.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), e.C0210e.ds60));
        }
        this.cch.setHasPendantStyle();
        if (this.cch.getPendantView() != null) {
            this.cch.getPendantView().setIsRound(true);
            this.cch.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(e.g.card_concern_ala_live_thread_title);
        this.bSy = (TbImageView) getView().findViewById(e.g.card_concern_ala_live_thread_live_image_view);
        this.bSy.setDefaultErrorResource(0);
        this.bSy.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bSy.setDrawerType(0);
        this.bSy.setBorderSurroundContent(true);
        this.bSy.setDrawBorder(true);
        this.bSE = (LinearLayout) getView().findViewById(e.g.challenge_root);
        this.cVS = view.findViewById(e.g.divider_line);
        this.cbx = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_concern_ala_live_thread_info_layout);
        this.euJ = (ConcernThreadUserInfoLayout) view.findViewById(e.g.card_concern_ala_live_thread_user_info_layout);
        if (this.cbx.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbx.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cbx.setLayoutParams(layoutParams);
        }
        this.cbx.setOnClickListener(this.cVU);
        this.cbx.setReplyTimeVisible(false);
        this.cbx.setIsBarViewVisible(false);
        this.cbx.setShowPraiseNum(true);
        this.cbx.setNeedAddPraiseIcon(true);
        this.cbx.setNeedAddReplyIcon(true);
        this.cbx.setShareVisible(true);
        this.cbx.awo = this.currentPageType;
        this.cbx.setShareReportFrom(4);
        this.cbx.setFrom(9);
        this.cbx.setDisPraiseFrom(4);
        this.cbx.setForumAfterClickListener(this.aJa);
        if (this.cbx.getCommentContainer() != null) {
            this.cbx.getCommentContainer().setOnClickListener(this.cVU);
        }
        this.cck = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_concern_ala_source_read_share_layout);
        this.cck.aKM.setOnClickListener(this.cVU);
        this.cck.setShareReportFrom(4);
        this.cck.setFrom(9);
        this.cck.aKM.awo = this.currentPageType;
        this.cck.setForumAfterClickListener(this.aJa);
        if (this.cck.aKM.getCommentContainer() != null) {
            this.cck.aKM.getCommentContainer().setOnClickListener(this.cVU);
        }
        this.ccw = (LinearLayout) view.findViewById(e.g.card_concern_ala_live_thread_content_layout);
        this.bpK = (TextView) getView().findViewById(e.g.play_count);
        this.bpE = (ImageView) view.findViewById(e.g.image_video_play);
        this.cXV = (AlaPlayAnimationView) view.findViewById(e.g.ala_play);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            this.cbx.onChangeSkinType();
            this.euJ.onChangeSkinType();
            this.cck.onChangeSkinType();
            al.j(this.cVS, e.d.cp_bg_line_e);
            al.h(this.bpK, e.d.cp_cont_i);
            al.c(this.bpE, e.f.btn_card_play_live_n);
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
        this.cXR = jVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVU);
        }
        this.euJ.setData(jVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.mX(this.cXR.threadData.getId())) {
            o.a(this.mTitle, this.cXR.aaq().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
        this.euJ.setUserAfterClickListener(this.aLe);
        this.aKg = "feed#" + jVar.aqZ();
        bb aaq = jVar.aaq();
        if (this.euJ.getHeaderImg() != null) {
            if (this.euJ.getIsSimpleThread()) {
                this.euJ.getHeaderImg().setVisibility(8);
                this.cch.setVisibility(8);
            } else if (aaq.zT() == null || aaq.zT().getPendantData() == null || StringUtils.isNull(aaq.zT().getPendantData().yF())) {
                this.cch.setVisibility(8);
                this.euJ.getHeaderImg().setVisibility(0);
                this.euJ.getHeaderImg().setData(aaq);
            } else {
                this.euJ.getHeaderImg().setVisibility(4);
                this.cch.setVisibility(0);
                this.cch.setData(aaq);
            }
        }
        o.a(aaq, this.mTitle);
        this.bSy.startLoad(aaq.An().cover, 10, false);
        this.bpK.setText(String.format(this.mContext.getResources().getString(e.j.ala_audience_count_prefix), ao.X(this.cXR.threadData.An().audience_count)));
        setPageUniqueId(getTag());
        this.cXV.startPlayAnimation();
        iM(hD(1));
        if (aaq.An().mChallengeInfoData != null && aaq.An().mChallengeInfoData.challenge_id > 0) {
            this.bSE.setVisibility(0);
        } else {
            this.bSE.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.euJ != null) {
            this.euJ.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.euJ != null) {
            return this.euJ.aKR;
        }
        return null;
    }

    public void aqM() {
        if (this.mPageContext != null && this.cXR != null && this.cXR.threadData != null && this.cXR.threadData.zT() != null && this.cXR.threadData.An() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.cXR.threadData.zT().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cXR.threadData.An());
            alaLiveInfoCoreData.userName = this.cXR.threadData.zT().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, this.bVu, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void iM(int i) {
        if (this.cXR != null && this.cXR.threadData != null) {
            this.mStType = o.zH();
            if (i == 1) {
                this.cbx.setVisibility(8);
                this.cck.setStType(this.mStType);
                this.cck.setData(this.cXR.threadData);
                this.euJ.showForumNameView(false);
                return;
            }
            this.cbx.setData(this.cXR.threadData);
            this.cbx.setStType(this.mStType);
            this.cck.setVisibility(8);
            this.euJ.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.cbk = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.Wk().N(this.cbk, i);
    }
}
