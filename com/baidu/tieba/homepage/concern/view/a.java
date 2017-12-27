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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.d;
import com.baidu.tieba.view.AlaPlayAnimationView;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<k> {
    public ImageView bYm;
    private String bbQ;
    private final View.OnClickListener bbR;
    private final View.OnClickListener bce;
    private HeadPendantClickableView cNO;
    private View cNQ;
    private View.OnClickListener cNS;
    private k cOH;
    private TextView cOL;
    private AlaPlayAnimationView cON;
    private String cct;
    public ThreadCommentAndPraiseInfoLayout ciE;
    private LinearLayout cjA;
    public ConcernThreadUserInfoLayout eaZ;
    private TbImageView eba;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cct = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.cNS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiY() != null) {
                    a.this.aiY().a(view, a.this.cOH);
                }
                a.this.ajz();
            }
        };
        this.bce = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiY() != null) {
                    a.this.aiY().a(view, a.this.cOH);
                }
            }
        };
        this.bbR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiY() != null) {
                    a.this.aiY().a(view, a.this.cOH);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.cNO = (HeadPendantClickableView) view.findViewById(d.g.card_concern_ala_live_thread_user_pendant_header);
        if (this.cNO.getHeadView() != null) {
            this.cNO.getHeadView().setIsRound(true);
            this.cNO.getHeadView().setDrawBorder(false);
            this.cNO.getHeadView().setDefaultResource(17170445);
            this.cNO.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cNO.getHeadView().setDefaultBgResource(d.C0108d.cp_bg_line_e);
            this.cNO.getHeadView().setRadius(l.s(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        this.cNO.DG();
        if (this.cNO.getPendantView() != null) {
            this.cNO.getPendantView().setIsRound(true);
            this.cNO.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_ala_live_thread_title);
        this.eba = (TbImageView) getView().findViewById(d.g.card_concern_ala_live_thread_live_image_view);
        this.eba.setDefaultErrorResource(0);
        this.eba.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.eba.setDrawerType(0);
        this.eba.setBorderSurroundContent(true);
        this.eba.setDrawBorder(true);
        this.cNQ = view.findViewById(d.g.divider_line);
        this.ciE = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_info_layout);
        this.eaZ = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_user_info_layout);
        if (this.ciE.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciE.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciE.setLayoutParams(layoutParams);
        }
        this.ciE.setOnClickListener(this.cNS);
        this.ciE.setReplyTimeVisible(false);
        this.ciE.setIsBarViewVisible(false);
        this.ciE.setShowPraiseNum(true);
        this.ciE.setNeedAddPraiseIcon(true);
        this.ciE.setNeedAddReplyIcon(true);
        this.ciE.setShareVisible(true);
        this.ciE.bbP = this.currentPageType;
        this.ciE.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aiY() != null) {
                    a.this.aiY().a(view2, a.this.cOH);
                }
            }
        });
        if (this.ciE.getCommentContainer() != null) {
            this.ciE.getCommentContainer().setOnClickListener(this.cNS);
        }
        this.cjA = (LinearLayout) view.findViewById(d.g.card_concern_ala_live_thread_content_layout);
        this.cOL = (TextView) getView().findViewById(d.g.play_count);
        this.bYm = (ImageView) view.findViewById(d.g.image_video_play);
        this.cON = (AlaPlayAnimationView) view.findViewById(d.g.ala_play);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            this.ciE.onChangeSkinType();
            this.eaZ.onChangeSkinType();
            aj.t(this.cNQ, d.C0108d.cp_bg_line_e);
            aj.r(this.cOL, d.C0108d.cp_cont_i);
            aj.c(this.bYm, d.f.btn_card_play_live_n);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_concern_ala_live_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(k kVar) {
        if (kVar == null || kVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.cOH = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cNS);
        }
        this.eaZ.setData(kVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tieba.card.k.jU(this.cOH.threadData.getId())) {
            com.baidu.tieba.card.k.a(this.mTitle, this.cOH.VW().getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
        }
        this.eaZ.setUserAfterClickListener(this.bce);
        this.ciE.setData(kVar.threadData);
        this.mStType = com.baidu.tieba.card.k.yN();
        this.bbQ = "feed#" + kVar.ajK();
        be VW = kVar.VW();
        if (this.eaZ.getHeaderImg() != null) {
            if (this.eaZ.getIsSimpleThread()) {
                this.eaZ.getHeaderImg().setVisibility(8);
                this.cNO.setVisibility(8);
            } else if (VW.yX() == null || VW.yX().getPendantData() == null || StringUtils.isNull(VW.yX().getPendantData().xu())) {
                this.cNO.setVisibility(8);
                this.eaZ.getHeaderImg().setVisibility(0);
                this.eaZ.getHeaderImg().setData(VW);
            } else {
                this.eaZ.getHeaderImg().setVisibility(4);
                this.cNO.setVisibility(0);
                this.cNO.setData(VW);
            }
        }
        com.baidu.tieba.card.k.a(VW, this.mTitle);
        this.eba.startLoad(VW.zq().cover, 10, false);
        this.cOL.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), am.I(this.cOH.threadData.zq().audience_count)));
        setPageUniqueId(getTag());
        this.cON.startPlayAnimation();
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.eaZ != null) {
            this.eaZ.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.eaZ != null) {
            return this.eaZ.bbZ;
        }
        return null;
    }

    public void ajz() {
        if (this.mPageContext != null && this.cOH != null && this.cOH.threadData != null && this.cOH.threadData.yX() != null && this.cOH.threadData.zq() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.cOH.threadData.yX().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cOH.threadData.zq());
            alaLiveInfoCoreData.userName = this.cOH.threadData.yX().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, this.cct, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
