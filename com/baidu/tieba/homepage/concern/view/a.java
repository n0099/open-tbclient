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
    public ImageView bYB;
    private String bbY;
    private final View.OnClickListener bbZ;
    private final View.OnClickListener bcm;
    private View cSL;
    private View.OnClickListener cSO;
    private k cTD;
    private TextView cTH;
    private AlaPlayAnimationView cTJ;
    private String ccI;
    public ThreadCommentAndPraiseInfoLayout ciT;
    private HeadPendantClickableView cjC;
    private LinearLayout cjQ;
    public ConcernThreadUserInfoLayout ecE;
    private TbImageView ecF;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ccI = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.cSO = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akg() != null) {
                    a.this.akg().a(view, a.this.cTD);
                }
                a.this.akH();
            }
        };
        this.bcm = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akg() != null) {
                    a.this.akg().a(view, a.this.cTD);
                }
            }
        };
        this.bbZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akg() != null) {
                    a.this.akg().a(view, a.this.cTD);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.cjC = (HeadPendantClickableView) view.findViewById(d.g.card_concern_ala_live_thread_user_pendant_header);
        if (this.cjC.getHeadView() != null) {
            this.cjC.getHeadView().setIsRound(true);
            this.cjC.getHeadView().setDrawBorder(false);
            this.cjC.getHeadView().setDefaultResource(17170445);
            this.cjC.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cjC.getHeadView().setDefaultBgResource(d.C0108d.cp_bg_line_e);
            this.cjC.getHeadView().setRadius(l.s(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        this.cjC.Dz();
        if (this.cjC.getPendantView() != null) {
            this.cjC.getPendantView().setIsRound(true);
            this.cjC.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_ala_live_thread_title);
        this.ecF = (TbImageView) getView().findViewById(d.g.card_concern_ala_live_thread_live_image_view);
        this.ecF.setDefaultErrorResource(0);
        this.ecF.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.ecF.setDrawerType(0);
        this.ecF.setBorderSurroundContent(true);
        this.ecF.setDrawBorder(true);
        this.cSL = view.findViewById(d.g.divider_line);
        this.ciT = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_info_layout);
        this.ecE = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_user_info_layout);
        if (this.ciT.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciT.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciT.setLayoutParams(layoutParams);
        }
        this.ciT.setOnClickListener(this.cSO);
        this.ciT.setReplyTimeVisible(false);
        this.ciT.setIsBarViewVisible(false);
        this.ciT.setShowPraiseNum(true);
        this.ciT.setNeedAddPraiseIcon(true);
        this.ciT.setNeedAddReplyIcon(true);
        this.ciT.setShareVisible(true);
        this.ciT.bbX = this.currentPageType;
        this.ciT.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.akg() != null) {
                    a.this.akg().a(view2, a.this.cTD);
                }
            }
        });
        if (this.ciT.getCommentContainer() != null) {
            this.ciT.getCommentContainer().setOnClickListener(this.cSO);
        }
        this.cjQ = (LinearLayout) view.findViewById(d.g.card_concern_ala_live_thread_content_layout);
        this.cTH = (TextView) getView().findViewById(d.g.play_count);
        this.bYB = (ImageView) view.findViewById(d.g.image_video_play);
        this.cTJ = (AlaPlayAnimationView) view.findViewById(d.g.ala_play);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            this.ciT.onChangeSkinType();
            this.ecE.onChangeSkinType();
            aj.t(this.cSL, d.C0108d.cp_bg_line_e);
            aj.r(this.cTH, d.C0108d.cp_cont_i);
            aj.c(this.bYB, d.f.btn_card_play_live_n);
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
        this.cTD = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cSO);
        }
        this.ecE.setData(kVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tieba.card.k.kl(this.cTD.threadData.getId())) {
            com.baidu.tieba.card.k.a(this.mTitle, this.cTD.VM().getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
        }
        this.ecE.setUserAfterClickListener(this.bcm);
        this.ciT.setData(kVar.threadData);
        this.mStType = com.baidu.tieba.card.k.yJ();
        this.bbY = "feed#" + kVar.akS();
        bd VM = kVar.VM();
        if (this.ecE.getHeaderImg() != null) {
            if (this.ecE.getIsSimpleThread()) {
                this.ecE.getHeaderImg().setVisibility(8);
                this.cjC.setVisibility(8);
            } else if (VM.yT() == null || VM.yT().getPendantData() == null || StringUtils.isNull(VM.yT().getPendantData().xu())) {
                this.cjC.setVisibility(8);
                this.ecE.getHeaderImg().setVisibility(0);
                this.ecE.getHeaderImg().setData(VM);
            } else {
                this.ecE.getHeaderImg().setVisibility(4);
                this.cjC.setVisibility(0);
                this.cjC.setData(VM);
            }
        }
        com.baidu.tieba.card.k.a(VM, this.mTitle);
        this.ecF.startLoad(VM.zm().cover, 10, false);
        this.cTH.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), am.J(this.cTD.threadData.zm().audience_count)));
        setPageUniqueId(getTag());
        this.cTJ.startPlayAnimation();
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.ecE != null) {
            this.ecE.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.ecE != null) {
            return this.ecE.bch;
        }
        return null;
    }

    public void akH() {
        if (this.mPageContext != null && this.cTD != null && this.cTD.threadData != null && this.cTD.threadData.yT() != null && this.cTD.threadData.zm() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.cTD.threadData.yT().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cTD.threadData.zm());
            alaLiveInfoCoreData.userName = this.cTD.threadData.yT().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, this.ccI, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
