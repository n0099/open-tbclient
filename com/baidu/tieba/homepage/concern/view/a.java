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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
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
    private String aoX;
    private final View.OnClickListener aoY;
    private final View.OnClickListener apj;
    public ImageView bkA;
    private String brf;
    private String bvX;
    private HeadPendantClickableView bwV;
    private LinearLayout bwY;
    public ThreadSourceShareAndPraiseLayout bwZ;
    public ThreadCommentAndPraiseInfoLayout bwk;
    private LinearLayout bxk;
    private View cmb;
    private View.OnClickListener cme;
    private j cod;
    private TextView coh;
    private AlaPlayAnimationView coj;
    public ConcernThreadUserInfoLayout dBA;
    private TbImageView dBB;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.brf = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.cme = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aeZ() != null) {
                    a.this.aeZ().a(view2, a.this.cod);
                }
                a.this.afv();
            }
        };
        this.apj = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aeZ() != null) {
                    a.this.aeZ().a(view2, a.this.cod);
                }
            }
        };
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aeZ() != null) {
                    a.this.aeZ().a(view2, a.this.cod);
                }
            }
        };
        View view2 = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.bwV = (HeadPendantClickableView) view2.findViewById(d.g.card_concern_ala_live_thread_user_pendant_header);
        if (this.bwV.getHeadView() != null) {
            this.bwV.getHeadView().setIsRound(true);
            this.bwV.getHeadView().setDrawBorder(false);
            this.bwV.getHeadView().setDefaultResource(17170445);
            this.bwV.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bwV.getHeadView().setDefaultBgResource(d.C0126d.cp_bg_line_e);
            this.bwV.getHeadView().setRadius(l.e(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        this.bwV.setHasPendantStyle();
        if (this.bwV.getPendantView() != null) {
            this.bwV.getPendantView().setIsRound(true);
            this.bwV.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view2.findViewById(d.g.card_concern_ala_live_thread_title);
        this.dBB = (TbImageView) getView().findViewById(d.g.card_concern_ala_live_thread_live_image_view);
        this.dBB.setDefaultErrorResource(0);
        this.dBB.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.dBB.setDrawerType(0);
        this.dBB.setBorderSurroundContent(true);
        this.dBB.setDrawBorder(true);
        this.bwY = (LinearLayout) getView().findViewById(d.g.challenge_root);
        this.cmb = view2.findViewById(d.g.divider_line);
        this.bwk = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(d.g.card_concern_ala_live_thread_info_layout);
        this.dBA = (ConcernThreadUserInfoLayout) view2.findViewById(d.g.card_concern_ala_live_thread_user_info_layout);
        if (this.bwk.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bwk.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bwk.setLayoutParams(layoutParams);
        }
        this.bwk.setOnClickListener(this.cme);
        this.bwk.setReplyTimeVisible(false);
        this.bwk.setIsBarViewVisible(false);
        this.bwk.setShowPraiseNum(true);
        this.bwk.setNeedAddPraiseIcon(true);
        this.bwk.setNeedAddReplyIcon(true);
        this.bwk.setShareVisible(true);
        this.bwk.abV = this.currentPageType;
        this.bwk.setShareReportFrom(4);
        this.bwk.setFrom(9);
        this.bwk.setForumAfterClickListener(this.aoY);
        if (this.bwk.getCommentContainer() != null) {
            this.bwk.getCommentContainer().setOnClickListener(this.cme);
        }
        this.bwZ = (ThreadSourceShareAndPraiseLayout) view2.findViewById(d.g.card_concern_ala_source_read_share_layout);
        this.bwZ.apG.setOnClickListener(this.cme);
        this.bwZ.setShareReportFrom(4);
        this.bwZ.setFrom(9);
        this.bwZ.apG.abV = this.currentPageType;
        this.bwZ.setForumAfterClickListener(this.aoY);
        if (this.bwZ.apG.getCommentContainer() != null) {
            this.bwZ.apG.getCommentContainer().setOnClickListener(this.cme);
        }
        this.bxk = (LinearLayout) view2.findViewById(d.g.card_concern_ala_live_thread_content_layout);
        this.coh = (TextView) getView().findViewById(d.g.play_count);
        this.bkA = (ImageView) view2.findViewById(d.g.image_video_play);
        this.coj = (AlaPlayAnimationView) view2.findViewById(d.g.ala_play);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.f.addresslist_item_bg);
            this.bwk.onChangeSkinType();
            this.dBA.onChangeSkinType();
            this.bwZ.onChangeSkinType();
            ak.j(this.cmb, d.C0126d.cp_bg_line_e);
            ak.h(this.coh, d.C0126d.cp_cont_i);
            ak.c(this.bkA, d.f.btn_card_play_live_n);
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
        this.cod = jVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cme);
        }
        this.dBA.setData(jVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.kw(this.cod.threadData.getId())) {
            o.a(this.mTitle, this.cod.Pe().getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
        }
        this.dBA.setUserAfterClickListener(this.apj);
        this.aoX = "feed#" + jVar.afI();
        bd Pe = jVar.Pe();
        if (this.dBA.getHeaderImg() != null) {
            if (this.dBA.getIsSimpleThread()) {
                this.dBA.getHeaderImg().setVisibility(8);
                this.bwV.setVisibility(8);
            } else if (Pe.rQ() == null || Pe.rQ().getPendantData() == null || StringUtils.isNull(Pe.rQ().getPendantData().qG())) {
                this.bwV.setVisibility(8);
                this.dBA.getHeaderImg().setVisibility(0);
                this.dBA.getHeaderImg().setData(Pe);
            } else {
                this.dBA.getHeaderImg().setVisibility(4);
                this.bwV.setVisibility(0);
                this.bwV.setData(Pe);
            }
        }
        o.a(Pe, this.mTitle);
        this.dBB.startLoad(Pe.si().cover, 10, false);
        this.coh.setText(String.format(this.mContext.getResources().getString(d.k.ala_audience_count_prefix), an.B(this.cod.threadData.si().audience_count)));
        setPageUniqueId(getTag());
        this.coj.startPlayAnimation();
        hc(gn(1));
        if (Pe.si().mChallengeInfoData != null && Pe.si().mChallengeInfoData.challenge_id > 0) {
            this.bwY.setVisibility(0);
        } else {
            this.bwY.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.dBA != null) {
            this.dBA.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dBA != null) {
            return this.dBA.apf;
        }
        return null;
    }

    public void afv() {
        if (this.mPageContext != null && this.cod != null && this.cod.threadData != null && this.cod.threadData.rQ() != null && this.cod.threadData.si() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.cod.threadData.rQ().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cod.threadData.si());
            alaLiveInfoCoreData.userName = this.cod.threadData.rQ().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, this.brf, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }

    public void hc(int i) {
        if (this.cod != null && this.cod.threadData != null) {
            this.mStType = o.rG();
            if (i == 1) {
                this.bwk.setVisibility(8);
                this.bwZ.setStType(this.mStType);
                this.bwZ.setData(this.cod.threadData);
                this.dBA.showForumNameView(false);
                return;
            }
            this.bwk.setData(this.cod.threadData);
            this.bwk.setStType(this.mStType);
            this.bwZ.setVisibility(8);
            this.dBA.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bvX = str;
    }

    public int gn(int i) {
        return com.baidu.tieba.a.d.MH().L(this.bvX, i);
    }
}
