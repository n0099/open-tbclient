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
    private final View.OnClickListener aIx;
    private String aJC;
    private final View.OnClickListener aKA;
    private TbImageView bRK;
    private LinearLayout bRQ;
    private String bUG;
    public ImageView boN;
    private TextView boT;
    private View cSr;
    private View.OnClickListener cSt;
    private j cUq;
    private AlaPlayAnimationView cUu;
    public ThreadCommentAndPraiseInfoLayout caJ;
    private String caw;
    private LinearLayout cbH;
    private HeadPendantClickableView cbt;
    public ThreadSourceShareAndPraiseLayout cbw;
    public ConcernThreadUserInfoLayout erl;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bUG = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.cSt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.apc() != null) {
                    a.this.apc().a(view, a.this.cUq);
                }
                a.this.apA();
            }
        };
        this.aKA = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.apc() != null) {
                    a.this.apc().a(view, a.this.cUq);
                }
            }
        };
        this.aIx = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.apc() != null) {
                    a.this.apc().a(view, a.this.cUq);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.cbt = (HeadPendantClickableView) view.findViewById(e.g.card_concern_ala_live_thread_user_pendant_header);
        if (this.cbt.getHeadView() != null) {
            this.cbt.getHeadView().setIsRound(true);
            this.cbt.getHeadView().setDrawBorder(false);
            this.cbt.getHeadView().setDefaultResource(17170445);
            this.cbt.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cbt.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cbt.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), e.C0210e.ds60));
        }
        this.cbt.setHasPendantStyle();
        if (this.cbt.getPendantView() != null) {
            this.cbt.getPendantView().setIsRound(true);
            this.cbt.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(e.g.card_concern_ala_live_thread_title);
        this.bRK = (TbImageView) getView().findViewById(e.g.card_concern_ala_live_thread_live_image_view);
        this.bRK.setDefaultErrorResource(0);
        this.bRK.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bRK.setDrawerType(0);
        this.bRK.setBorderSurroundContent(true);
        this.bRK.setDrawBorder(true);
        this.bRQ = (LinearLayout) getView().findViewById(e.g.challenge_root);
        this.cSr = view.findViewById(e.g.divider_line);
        this.caJ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_concern_ala_live_thread_info_layout);
        this.erl = (ConcernThreadUserInfoLayout) view.findViewById(e.g.card_concern_ala_live_thread_user_info_layout);
        if (this.caJ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caJ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.caJ.setLayoutParams(layoutParams);
        }
        this.caJ.setOnClickListener(this.cSt);
        this.caJ.setReplyTimeVisible(false);
        this.caJ.setIsBarViewVisible(false);
        this.caJ.setShowPraiseNum(true);
        this.caJ.setNeedAddPraiseIcon(true);
        this.caJ.setNeedAddReplyIcon(true);
        this.caJ.setShareVisible(true);
        this.caJ.avL = this.currentPageType;
        this.caJ.setShareReportFrom(4);
        this.caJ.setFrom(9);
        this.caJ.setDisPraiseFrom(4);
        this.caJ.setForumAfterClickListener(this.aIx);
        if (this.caJ.getCommentContainer() != null) {
            this.caJ.getCommentContainer().setOnClickListener(this.cSt);
        }
        this.cbw = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_concern_ala_source_read_share_layout);
        this.cbw.aKi.setOnClickListener(this.cSt);
        this.cbw.setShareReportFrom(4);
        this.cbw.setFrom(9);
        this.cbw.aKi.avL = this.currentPageType;
        this.cbw.setForumAfterClickListener(this.aIx);
        if (this.cbw.aKi.getCommentContainer() != null) {
            this.cbw.aKi.getCommentContainer().setOnClickListener(this.cSt);
        }
        this.cbH = (LinearLayout) view.findViewById(e.g.card_concern_ala_live_thread_content_layout);
        this.boT = (TextView) getView().findViewById(e.g.play_count);
        this.boN = (ImageView) view.findViewById(e.g.image_video_play);
        this.cUu = (AlaPlayAnimationView) view.findViewById(e.g.ala_play);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            this.caJ.onChangeSkinType();
            this.erl.onChangeSkinType();
            this.cbw.onChangeSkinType();
            al.j(this.cSr, e.d.cp_bg_line_e);
            al.h(this.boT, e.d.cp_cont_i);
            al.c(this.boN, e.f.btn_card_play_live_n);
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
        this.cUq = jVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cSt);
        }
        this.erl.setData(jVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.mE(this.cUq.threadData.getId())) {
            o.a(this.mTitle, this.cUq.ZR().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
        this.erl.setUserAfterClickListener(this.aKA);
        this.aJC = "feed#" + jVar.apN();
        bb ZR = jVar.ZR();
        if (this.erl.getHeaderImg() != null) {
            if (this.erl.getIsSimpleThread()) {
                this.erl.getHeaderImg().setVisibility(8);
                this.cbt.setVisibility(8);
            } else if (ZR.zG() == null || ZR.zG().getPendantData() == null || StringUtils.isNull(ZR.zG().getPendantData().ys())) {
                this.cbt.setVisibility(8);
                this.erl.getHeaderImg().setVisibility(0);
                this.erl.getHeaderImg().setData(ZR);
            } else {
                this.erl.getHeaderImg().setVisibility(4);
                this.cbt.setVisibility(0);
                this.cbt.setData(ZR);
            }
        }
        o.a(ZR, this.mTitle);
        this.bRK.startLoad(ZR.Aa().cover, 10, false);
        this.boT.setText(String.format(this.mContext.getResources().getString(e.j.ala_audience_count_prefix), ao.W(this.cUq.threadData.Aa().audience_count)));
        setPageUniqueId(getTag());
        this.cUu.startPlayAnimation();
        iL(hC(1));
        if (ZR.Aa().mChallengeInfoData != null && ZR.Aa().mChallengeInfoData.challenge_id > 0) {
            this.bRQ.setVisibility(0);
        } else {
            this.bRQ.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.erl != null) {
            this.erl.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.erl != null) {
            return this.erl.aKn;
        }
        return null;
    }

    public void apA() {
        if (this.mPageContext != null && this.cUq != null && this.cUq.threadData != null && this.cUq.threadData.zG() != null && this.cUq.threadData.Aa() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.cUq.threadData.zG().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cUq.threadData.Aa());
            alaLiveInfoCoreData.userName = this.cUq.threadData.zG().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, this.bUG, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void iL(int i) {
        if (this.cUq != null && this.cUq.threadData != null) {
            this.mStType = o.zu();
            if (i == 1) {
                this.caJ.setVisibility(8);
                this.cbw.setStType(this.mStType);
                this.cbw.setData(this.cUq.threadData);
                this.erl.showForumNameView(false);
                return;
            }
            this.caJ.setData(this.cUq.threadData);
            this.caJ.setStType(this.mStType);
            this.cbw.setVisibility(8);
            this.erl.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.caw = str;
    }

    public int hC(int i) {
        return com.baidu.tieba.a.d.VM().M(this.caw, i);
    }
}
