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
    private final View.OnClickListener aIy;
    private String aJE;
    private final View.OnClickListener aKC;
    private TbImageView bRN;
    private LinearLayout bRT;
    private String bUJ;
    public ImageView boQ;
    private TextView boW;
    private View cVh;
    private View.OnClickListener cVj;
    private j cXg;
    private AlaPlayAnimationView cXk;
    public ThreadCommentAndPraiseInfoLayout caM;
    private String caz;
    private LinearLayout cbK;
    private HeadPendantClickableView cbw;
    public ThreadSourceShareAndPraiseLayout cbz;
    public ConcernThreadUserInfoLayout eud;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bUJ = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.cVj = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.apS() != null) {
                    a.this.apS().a(view, a.this.cXg);
                }
                a.this.aqp();
            }
        };
        this.aKC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.apS() != null) {
                    a.this.apS().a(view, a.this.cXg);
                }
            }
        };
        this.aIy = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.apS() != null) {
                    a.this.apS().a(view, a.this.cXg);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.cbw = (HeadPendantClickableView) view.findViewById(e.g.card_concern_ala_live_thread_user_pendant_header);
        if (this.cbw.getHeadView() != null) {
            this.cbw.getHeadView().setIsRound(true);
            this.cbw.getHeadView().setDrawBorder(false);
            this.cbw.getHeadView().setDefaultResource(17170445);
            this.cbw.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cbw.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cbw.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), e.C0210e.ds60));
        }
        this.cbw.setHasPendantStyle();
        if (this.cbw.getPendantView() != null) {
            this.cbw.getPendantView().setIsRound(true);
            this.cbw.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(e.g.card_concern_ala_live_thread_title);
        this.bRN = (TbImageView) getView().findViewById(e.g.card_concern_ala_live_thread_live_image_view);
        this.bRN.setDefaultErrorResource(0);
        this.bRN.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bRN.setDrawerType(0);
        this.bRN.setBorderSurroundContent(true);
        this.bRN.setDrawBorder(true);
        this.bRT = (LinearLayout) getView().findViewById(e.g.challenge_root);
        this.cVh = view.findViewById(e.g.divider_line);
        this.caM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_concern_ala_live_thread_info_layout);
        this.eud = (ConcernThreadUserInfoLayout) view.findViewById(e.g.card_concern_ala_live_thread_user_info_layout);
        if (this.caM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.caM.setLayoutParams(layoutParams);
        }
        this.caM.setOnClickListener(this.cVj);
        this.caM.setReplyTimeVisible(false);
        this.caM.setIsBarViewVisible(false);
        this.caM.setShowPraiseNum(true);
        this.caM.setNeedAddPraiseIcon(true);
        this.caM.setNeedAddReplyIcon(true);
        this.caM.setShareVisible(true);
        this.caM.avM = this.currentPageType;
        this.caM.setShareReportFrom(4);
        this.caM.setFrom(9);
        this.caM.setDisPraiseFrom(4);
        this.caM.setForumAfterClickListener(this.aIy);
        if (this.caM.getCommentContainer() != null) {
            this.caM.getCommentContainer().setOnClickListener(this.cVj);
        }
        this.cbz = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_concern_ala_source_read_share_layout);
        this.cbz.aKk.setOnClickListener(this.cVj);
        this.cbz.setShareReportFrom(4);
        this.cbz.setFrom(9);
        this.cbz.aKk.avM = this.currentPageType;
        this.cbz.setForumAfterClickListener(this.aIy);
        if (this.cbz.aKk.getCommentContainer() != null) {
            this.cbz.aKk.getCommentContainer().setOnClickListener(this.cVj);
        }
        this.cbK = (LinearLayout) view.findViewById(e.g.card_concern_ala_live_thread_content_layout);
        this.boW = (TextView) getView().findViewById(e.g.play_count);
        this.boQ = (ImageView) view.findViewById(e.g.image_video_play);
        this.cXk = (AlaPlayAnimationView) view.findViewById(e.g.ala_play);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            this.caM.onChangeSkinType();
            this.eud.onChangeSkinType();
            this.cbz.onChangeSkinType();
            al.j(this.cVh, e.d.cp_bg_line_e);
            al.h(this.boW, e.d.cp_cont_i);
            al.c(this.boQ, e.f.btn_card_play_live_n);
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
        this.cXg = jVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVj);
        }
        this.eud.setData(jVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.mH(this.cXg.threadData.getId())) {
            o.a(this.mTitle, this.cXg.ZT().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
        this.eud.setUserAfterClickListener(this.aKC);
        this.aJE = "feed#" + jVar.aqC();
        bb ZT = jVar.ZT();
        if (this.eud.getHeaderImg() != null) {
            if (this.eud.getIsSimpleThread()) {
                this.eud.getHeaderImg().setVisibility(8);
                this.cbw.setVisibility(8);
            } else if (ZT.zG() == null || ZT.zG().getPendantData() == null || StringUtils.isNull(ZT.zG().getPendantData().ys())) {
                this.cbw.setVisibility(8);
                this.eud.getHeaderImg().setVisibility(0);
                this.eud.getHeaderImg().setData(ZT);
            } else {
                this.eud.getHeaderImg().setVisibility(4);
                this.cbw.setVisibility(0);
                this.cbw.setData(ZT);
            }
        }
        o.a(ZT, this.mTitle);
        this.bRN.startLoad(ZT.Aa().cover, 10, false);
        this.boW.setText(String.format(this.mContext.getResources().getString(e.j.ala_audience_count_prefix), ao.X(this.cXg.threadData.Aa().audience_count)));
        setPageUniqueId(getTag());
        this.cXk.startPlayAnimation();
        iM(hD(1));
        if (ZT.Aa().mChallengeInfoData != null && ZT.Aa().mChallengeInfoData.challenge_id > 0) {
            this.bRT.setVisibility(0);
        } else {
            this.bRT.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.eud != null) {
            this.eud.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.eud != null) {
            return this.eud.aKp;
        }
        return null;
    }

    public void aqp() {
        if (this.mPageContext != null && this.cXg != null && this.cXg.threadData != null && this.cXg.threadData.zG() != null && this.cXg.threadData.Aa() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.cXg.threadData.zG().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cXg.threadData.Aa());
            alaLiveInfoCoreData.userName = this.cXg.threadData.zG().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, this.bUJ, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void iM(int i) {
        if (this.cXg != null && this.cXg.threadData != null) {
            this.mStType = o.zu();
            if (i == 1) {
                this.caM.setVisibility(8);
                this.cbz.setStType(this.mStType);
                this.cbz.setData(this.cXg.threadData);
                this.eud.showForumNameView(false);
                return;
            }
            this.caM.setData(this.cXg.threadData);
            this.caM.setStType(this.mStType);
            this.cbz.setVisibility(8);
            this.eud.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.caz = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.VO().N(this.caz, i);
    }
}
