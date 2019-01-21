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
    private final View.OnClickListener aJb;
    private String aKh;
    private final View.OnClickListener aLf;
    private LinearLayout bSF;
    private TbImageView bSz;
    private String bVv;
    public ImageView bpF;
    private TextView bpL;
    private View cVT;
    private View.OnClickListener cVV;
    private j cXS;
    private AlaPlayAnimationView cXW;
    private String cbl;
    public ThreadCommentAndPraiseInfoLayout cby;
    private HeadPendantClickableView cci;
    public ThreadSourceShareAndPraiseLayout ccl;
    private LinearLayout ccx;
    public ConcernThreadUserInfoLayout euK;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bVv = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.cVV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aqp() != null) {
                    a.this.aqp().a(view, a.this.cXS);
                }
                a.this.aqM();
            }
        };
        this.aLf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aqp() != null) {
                    a.this.aqp().a(view, a.this.cXS);
                }
            }
        };
        this.aJb = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aqp() != null) {
                    a.this.aqp().a(view, a.this.cXS);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.cci = (HeadPendantClickableView) view.findViewById(e.g.card_concern_ala_live_thread_user_pendant_header);
        if (this.cci.getHeadView() != null) {
            this.cci.getHeadView().setIsRound(true);
            this.cci.getHeadView().setDrawBorder(false);
            this.cci.getHeadView().setDefaultResource(17170445);
            this.cci.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cci.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cci.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), e.C0210e.ds60));
        }
        this.cci.setHasPendantStyle();
        if (this.cci.getPendantView() != null) {
            this.cci.getPendantView().setIsRound(true);
            this.cci.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(e.g.card_concern_ala_live_thread_title);
        this.bSz = (TbImageView) getView().findViewById(e.g.card_concern_ala_live_thread_live_image_view);
        this.bSz.setDefaultErrorResource(0);
        this.bSz.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bSz.setDrawerType(0);
        this.bSz.setBorderSurroundContent(true);
        this.bSz.setDrawBorder(true);
        this.bSF = (LinearLayout) getView().findViewById(e.g.challenge_root);
        this.cVT = view.findViewById(e.g.divider_line);
        this.cby = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_concern_ala_live_thread_info_layout);
        this.euK = (ConcernThreadUserInfoLayout) view.findViewById(e.g.card_concern_ala_live_thread_user_info_layout);
        if (this.cby.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cby.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cby.setLayoutParams(layoutParams);
        }
        this.cby.setOnClickListener(this.cVV);
        this.cby.setReplyTimeVisible(false);
        this.cby.setIsBarViewVisible(false);
        this.cby.setShowPraiseNum(true);
        this.cby.setNeedAddPraiseIcon(true);
        this.cby.setNeedAddReplyIcon(true);
        this.cby.setShareVisible(true);
        this.cby.awp = this.currentPageType;
        this.cby.setShareReportFrom(4);
        this.cby.setFrom(9);
        this.cby.setDisPraiseFrom(4);
        this.cby.setForumAfterClickListener(this.aJb);
        if (this.cby.getCommentContainer() != null) {
            this.cby.getCommentContainer().setOnClickListener(this.cVV);
        }
        this.ccl = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_concern_ala_source_read_share_layout);
        this.ccl.aKN.setOnClickListener(this.cVV);
        this.ccl.setShareReportFrom(4);
        this.ccl.setFrom(9);
        this.ccl.aKN.awp = this.currentPageType;
        this.ccl.setForumAfterClickListener(this.aJb);
        if (this.ccl.aKN.getCommentContainer() != null) {
            this.ccl.aKN.getCommentContainer().setOnClickListener(this.cVV);
        }
        this.ccx = (LinearLayout) view.findViewById(e.g.card_concern_ala_live_thread_content_layout);
        this.bpL = (TextView) getView().findViewById(e.g.play_count);
        this.bpF = (ImageView) view.findViewById(e.g.image_video_play);
        this.cXW = (AlaPlayAnimationView) view.findViewById(e.g.ala_play);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            this.cby.onChangeSkinType();
            this.euK.onChangeSkinType();
            this.ccl.onChangeSkinType();
            al.j(this.cVT, e.d.cp_bg_line_e);
            al.h(this.bpL, e.d.cp_cont_i);
            al.c(this.bpF, e.f.btn_card_play_live_n);
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
        this.cXS = jVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVV);
        }
        this.euK.setData(jVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.mX(this.cXS.threadData.getId())) {
            o.a(this.mTitle, this.cXS.aaq().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
        this.euK.setUserAfterClickListener(this.aLf);
        this.aKh = "feed#" + jVar.aqZ();
        bb aaq = jVar.aaq();
        if (this.euK.getHeaderImg() != null) {
            if (this.euK.getIsSimpleThread()) {
                this.euK.getHeaderImg().setVisibility(8);
                this.cci.setVisibility(8);
            } else if (aaq.zT() == null || aaq.zT().getPendantData() == null || StringUtils.isNull(aaq.zT().getPendantData().yF())) {
                this.cci.setVisibility(8);
                this.euK.getHeaderImg().setVisibility(0);
                this.euK.getHeaderImg().setData(aaq);
            } else {
                this.euK.getHeaderImg().setVisibility(4);
                this.cci.setVisibility(0);
                this.cci.setData(aaq);
            }
        }
        o.a(aaq, this.mTitle);
        this.bSz.startLoad(aaq.An().cover, 10, false);
        this.bpL.setText(String.format(this.mContext.getResources().getString(e.j.ala_audience_count_prefix), ao.X(this.cXS.threadData.An().audience_count)));
        setPageUniqueId(getTag());
        this.cXW.startPlayAnimation();
        iM(hD(1));
        if (aaq.An().mChallengeInfoData != null && aaq.An().mChallengeInfoData.challenge_id > 0) {
            this.bSF.setVisibility(0);
        } else {
            this.bSF.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.euK != null) {
            this.euK.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.euK != null) {
            return this.euK.aKS;
        }
        return null;
    }

    public void aqM() {
        if (this.mPageContext != null && this.cXS != null && this.cXS.threadData != null && this.cXS.threadData.zT() != null && this.cXS.threadData.An() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.cXS.threadData.zT().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cXS.threadData.An());
            alaLiveInfoCoreData.userName = this.cXS.threadData.zT().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, this.bVv, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void iM(int i) {
        if (this.cXS != null && this.cXS.threadData != null) {
            this.mStType = o.zH();
            if (i == 1) {
                this.cby.setVisibility(8);
                this.ccl.setStType(this.mStType);
                this.ccl.setData(this.cXS.threadData);
                this.euK.showForumNameView(false);
                return;
            }
            this.cby.setData(this.cXS.threadData);
            this.cby.setStType(this.mStType);
            this.ccl.setVisibility(8);
            this.euK.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.cbl = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.Wk().N(this.cbl, i);
    }
}
