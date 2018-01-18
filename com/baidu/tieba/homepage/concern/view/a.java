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
    public ImageView bYt;
    private String bbQ;
    private final View.OnClickListener bbR;
    private final View.OnClickListener bce;
    private View cSq;
    private View.OnClickListener cSt;
    private k cTi;
    private TextView cTm;
    private AlaPlayAnimationView cTo;
    private String ccA;
    public ThreadCommentAndPraiseInfoLayout ciL;
    private LinearLayout cjI;
    private HeadPendantClickableView cju;
    public ConcernThreadUserInfoLayout ecj;
    private TbImageView eck;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ccA = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.cSt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akb() != null) {
                    a.this.akb().a(view, a.this.cTi);
                }
                a.this.akC();
            }
        };
        this.bce = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akb() != null) {
                    a.this.akb().a(view, a.this.cTi);
                }
            }
        };
        this.bbR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akb() != null) {
                    a.this.akb().a(view, a.this.cTi);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.cju = (HeadPendantClickableView) view.findViewById(d.g.card_concern_ala_live_thread_user_pendant_header);
        if (this.cju.getHeadView() != null) {
            this.cju.getHeadView().setIsRound(true);
            this.cju.getHeadView().setDrawBorder(false);
            this.cju.getHeadView().setDefaultResource(17170445);
            this.cju.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cju.getHeadView().setDefaultBgResource(d.C0107d.cp_bg_line_e);
            this.cju.getHeadView().setRadius(l.s(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        this.cju.Dx();
        if (this.cju.getPendantView() != null) {
            this.cju.getPendantView().setIsRound(true);
            this.cju.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_ala_live_thread_title);
        this.eck = (TbImageView) getView().findViewById(d.g.card_concern_ala_live_thread_live_image_view);
        this.eck.setDefaultErrorResource(0);
        this.eck.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.eck.setDrawerType(0);
        this.eck.setBorderSurroundContent(true);
        this.eck.setDrawBorder(true);
        this.cSq = view.findViewById(d.g.divider_line);
        this.ciL = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_info_layout);
        this.ecj = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_user_info_layout);
        if (this.ciL.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciL.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciL.setLayoutParams(layoutParams);
        }
        this.ciL.setOnClickListener(this.cSt);
        this.ciL.setReplyTimeVisible(false);
        this.ciL.setIsBarViewVisible(false);
        this.ciL.setShowPraiseNum(true);
        this.ciL.setNeedAddPraiseIcon(true);
        this.ciL.setNeedAddReplyIcon(true);
        this.ciL.setShareVisible(true);
        this.ciL.bbP = this.currentPageType;
        this.ciL.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.akb() != null) {
                    a.this.akb().a(view2, a.this.cTi);
                }
            }
        });
        if (this.ciL.getCommentContainer() != null) {
            this.ciL.getCommentContainer().setOnClickListener(this.cSt);
        }
        this.cjI = (LinearLayout) view.findViewById(d.g.card_concern_ala_live_thread_content_layout);
        this.cTm = (TextView) getView().findViewById(d.g.play_count);
        this.bYt = (ImageView) view.findViewById(d.g.image_video_play);
        this.cTo = (AlaPlayAnimationView) view.findViewById(d.g.ala_play);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            this.ciL.onChangeSkinType();
            this.ecj.onChangeSkinType();
            aj.t(this.cSq, d.C0107d.cp_bg_line_e);
            aj.r(this.cTm, d.C0107d.cp_cont_i);
            aj.c(this.bYt, d.f.btn_card_play_live_n);
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
        this.cTi = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cSt);
        }
        this.ecj.setData(kVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tieba.card.k.kd(this.cTi.threadData.getId())) {
            com.baidu.tieba.card.k.a(this.mTitle, this.cTi.VK().getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
        }
        this.ecj.setUserAfterClickListener(this.bce);
        this.ciL.setData(kVar.threadData);
        this.mStType = com.baidu.tieba.card.k.yI();
        this.bbQ = "feed#" + kVar.akN();
        bd VK = kVar.VK();
        if (this.ecj.getHeaderImg() != null) {
            if (this.ecj.getIsSimpleThread()) {
                this.ecj.getHeaderImg().setVisibility(8);
                this.cju.setVisibility(8);
            } else if (VK.yS() == null || VK.yS().getPendantData() == null || StringUtils.isNull(VK.yS().getPendantData().xt())) {
                this.cju.setVisibility(8);
                this.ecj.getHeaderImg().setVisibility(0);
                this.ecj.getHeaderImg().setData(VK);
            } else {
                this.ecj.getHeaderImg().setVisibility(4);
                this.cju.setVisibility(0);
                this.cju.setData(VK);
            }
        }
        com.baidu.tieba.card.k.a(VK, this.mTitle);
        this.eck.startLoad(VK.zl().cover, 10, false);
        this.cTm.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), am.J(this.cTi.threadData.zl().audience_count)));
        setPageUniqueId(getTag());
        this.cTo.startPlayAnimation();
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.ecj != null) {
            this.ecj.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.ecj != null) {
            return this.ecj.bbZ;
        }
        return null;
    }

    public void akC() {
        if (this.mPageContext != null && this.cTi != null && this.cTi.threadData != null && this.cTi.threadData.yS() != null && this.cTi.threadData.zl() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.cTi.threadData.yS().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cTi.threadData.zl());
            alaLiveInfoCoreData.userName = this.cTi.threadData.yS().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, this.ccA, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
