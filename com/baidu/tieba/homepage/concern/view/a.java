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
    private String bdP;
    private final View.OnClickListener bdQ;
    private final View.OnClickListener bec;
    private View cVH;
    private View.OnClickListener cVJ;
    private j cWm;
    private TextView cWq;
    private AlaPlayAnimationView cWs;
    public ImageView caJ;
    private String chi;
    private HeadPendantClickableView cmU;
    public ThreadSourceShareAndPraiseLayout cmX;
    public ThreadCommentAndPraiseInfoLayout cmk;
    private LinearLayout cnj;
    public ConcernThreadUserInfoLayout egQ;
    private TbImageView egR;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.chi = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.cVJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akP() != null) {
                    a.this.akP().a(view, a.this.cWm);
                }
                a.this.alq();
            }
        };
        this.bec = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akP() != null) {
                    a.this.akP().a(view, a.this.cWm);
                }
            }
        };
        this.bdQ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akP() != null) {
                    a.this.akP().a(view, a.this.cWm);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.cmU = (HeadPendantClickableView) view.findViewById(d.g.card_concern_ala_live_thread_user_pendant_header);
        if (this.cmU.getHeadView() != null) {
            this.cmU.getHeadView().setIsRound(true);
            this.cmU.getHeadView().setDrawBorder(false);
            this.cmU.getHeadView().setDefaultResource(17170445);
            this.cmU.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmU.getHeadView().setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.cmU.getHeadView().setRadius(l.t(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        this.cmU.DT();
        if (this.cmU.getPendantView() != null) {
            this.cmU.getPendantView().setIsRound(true);
            this.cmU.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_ala_live_thread_title);
        this.egR = (TbImageView) getView().findViewById(d.g.card_concern_ala_live_thread_live_image_view);
        this.egR.setDefaultErrorResource(0);
        this.egR.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.egR.setDrawerType(0);
        this.egR.setBorderSurroundContent(true);
        this.egR.setDrawBorder(true);
        this.cVH = view.findViewById(d.g.divider_line);
        this.cmk = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_info_layout);
        this.egQ = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_user_info_layout);
        if (this.cmk.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmk.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cmk.setLayoutParams(layoutParams);
        }
        this.cmk.setOnClickListener(this.cVJ);
        this.cmk.setReplyTimeVisible(false);
        this.cmk.setIsBarViewVisible(false);
        this.cmk.setShowPraiseNum(true);
        this.cmk.setNeedAddPraiseIcon(true);
        this.cmk.setNeedAddReplyIcon(true);
        this.cmk.setShareVisible(true);
        this.cmk.aQE = this.currentPageType;
        this.cmk.setShareReportFrom(4);
        this.cmk.setFrom(9);
        this.cmk.setForumAfterClickListener(this.bdQ);
        if (this.cmk.getCommentContainer() != null) {
            this.cmk.getCommentContainer().setOnClickListener(this.cVJ);
        }
        this.cmX = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_ala_source_read_share_layout);
        this.cmX.bez.setOnClickListener(this.cVJ);
        this.cmX.setShareReportFrom(4);
        this.cmX.setFrom(9);
        this.cmX.bez.aQE = this.currentPageType;
        this.cmX.setForumAfterClickListener(this.bdQ);
        if (this.cmX.bez.getCommentContainer() != null) {
            this.cmX.bez.getCommentContainer().setOnClickListener(this.cVJ);
        }
        this.cnj = (LinearLayout) view.findViewById(d.g.card_concern_ala_live_thread_content_layout);
        this.cWq = (TextView) getView().findViewById(d.g.play_count);
        this.caJ = (ImageView) view.findViewById(d.g.image_video_play);
        this.cWs = (AlaPlayAnimationView) view.findViewById(d.g.ala_play);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            this.cmk.onChangeSkinType();
            this.egQ.onChangeSkinType();
            this.cmX.onChangeSkinType();
            aj.t(this.cVH, d.C0140d.cp_bg_line_e);
            aj.r(this.cWq, d.C0140d.cp_cont_i);
            aj.c(this.caJ, d.f.btn_card_play_live_n);
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
        this.cWm = jVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVJ);
        }
        this.egQ.setData(jVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tieba.card.j.ks(this.cWm.threadData.getId())) {
            com.baidu.tieba.card.j.a(this.mTitle, this.cWm.WE().getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
        }
        this.egQ.setUserAfterClickListener(this.bec);
        this.bdP = "feed#" + jVar.alB();
        bd WE = jVar.WE();
        if (this.egQ.getHeaderImg() != null) {
            if (this.egQ.getIsSimpleThread()) {
                this.egQ.getHeaderImg().setVisibility(8);
                this.cmU.setVisibility(8);
            } else if (WE.zn() == null || WE.zn().getPendantData() == null || StringUtils.isNull(WE.zn().getPendantData().ya())) {
                this.cmU.setVisibility(8);
                this.egQ.getHeaderImg().setVisibility(0);
                this.egQ.getHeaderImg().setData(WE);
            } else {
                this.egQ.getHeaderImg().setVisibility(4);
                this.cmU.setVisibility(0);
                this.cmU.setData(WE);
            }
        }
        com.baidu.tieba.card.j.a(WE, this.mTitle);
        this.egR.startLoad(WE.zG().cover, 10, false);
        this.cWq.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), am.J(this.cWm.threadData.zG().audience_count)));
        setPageUniqueId(getTag());
        this.cWs.startPlayAnimation();
        jX(WE.aQz);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.egQ != null) {
            this.egQ.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.egQ != null) {
            return this.egQ.bdX;
        }
        return null;
    }

    public void alq() {
        if (this.mPageContext != null && this.cWm != null && this.cWm.threadData != null && this.cWm.threadData.zn() != null && this.cWm.threadData.zG() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.cWm.threadData.zn().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cWm.threadData.zG());
            alaLiveInfoCoreData.userName = this.cWm.threadData.zn().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, this.chi, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void jX(int i) {
        if (this.cWm != null && this.cWm.threadData != null) {
            this.mStType = com.baidu.tieba.card.j.zd();
            if (i == 1) {
                this.cmk.setVisibility(8);
                this.cmX.setStType(this.mStType);
                this.cmX.setData(this.cWm.threadData);
                this.egQ.showForumNameView(false);
                return;
            }
            this.cmk.setData(this.cWm.threadData);
            this.cmk.setStType(this.mStType);
            this.cmX.setVisibility(8);
            this.egQ.showForumNameView(true);
        }
    }
}
