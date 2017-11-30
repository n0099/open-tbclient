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
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<k> {
    private String anN;
    private final View.OnClickListener anO;
    private final View.OnClickListener aob;
    private k bZU;
    private TextView bZY;
    private HeadPendantClickableView bZa;
    private View bZd;
    private View.OnClickListener bZf;
    public ImageView bkW;
    private String boT;
    public ThreadCommentAndPraiseInfoLayout bvH;
    private LinearLayout bvK;
    private AlaPlayAnimationView caa;
    public ConcernThreadUserInfoLayout dnH;
    private TbImageView dnI;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.boT = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.bZf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.abs() != null) {
                    a.this.abs().a(view, a.this.bZU);
                }
                a.this.abR();
            }
        };
        this.aob = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.abs() != null) {
                    a.this.abs().a(view, a.this.bZU);
                }
            }
        };
        this.anO = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.abs() != null) {
                    a.this.abs().a(view, a.this.bZU);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.bZa = (HeadPendantClickableView) view.findViewById(d.g.card_concern_ala_live_thread_user_pendant_header);
        if (this.bZa.getHeadView() != null) {
            this.bZa.getHeadView().setIsRound(true);
            this.bZa.getHeadView().setDrawBorder(false);
            this.bZa.getHeadView().setDefaultResource(17170445);
            this.bZa.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bZa.getHeadView().setDefaultBgResource(d.C0082d.cp_bg_line_e);
            this.bZa.getHeadView().setRadius(l.f(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        this.bZa.wk();
        if (this.bZa.getPendantView() != null) {
            this.bZa.getPendantView().setIsRound(true);
            this.bZa.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_ala_live_thread_title);
        this.dnI = (TbImageView) getView().findViewById(d.g.card_concern_ala_live_thread_live_image_view);
        this.dnI.setDefaultErrorResource(0);
        this.dnI.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.dnI.setDrawerType(0);
        this.dnI.setBorderSurroundContent(true);
        this.dnI.setDrawBorder(true);
        this.bZd = view.findViewById(d.g.divider_line);
        this.bvH = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_info_layout);
        this.dnH = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_user_info_layout);
        if (this.bvH.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvH.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bvH.setLayoutParams(layoutParams);
        }
        this.bvH.setOnClickListener(this.bZf);
        this.bvH.setReplyTimeVisible(false);
        this.bvH.setIsBarViewVisible(false);
        this.bvH.setShowPraiseNum(true);
        this.bvH.setNeedAddPraiseIcon(true);
        this.bvH.setNeedAddReplyIcon(true);
        this.bvH.setShareVisible(true);
        this.bvH.anM = this.currentPageType;
        this.bvH.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.abs() != null) {
                    a.this.abs().a(view2, a.this.bZU);
                }
            }
        });
        if (this.bvH.getCommentContainer() != null) {
            this.bvH.getCommentContainer().setOnClickListener(this.bZf);
        }
        this.bvK = (LinearLayout) view.findViewById(d.g.card_concern_ala_live_thread_content_layout);
        this.bZY = (TextView) getView().findViewById(d.g.play_count);
        this.bkW = (ImageView) view.findViewById(d.g.image_video_play);
        this.caa = (AlaPlayAnimationView) view.findViewById(d.g.ala_play);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            this.bvH.onChangeSkinType();
            this.dnH.onChangeSkinType();
            aj.k(this.bZd, d.C0082d.cp_bg_line_e);
            aj.i(this.bZY, d.C0082d.cp_cont_i);
            aj.c(this.bkW, d.f.btn_card_play_live_n);
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
        this.bZU = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bZf);
        }
        this.dnH.setData(kVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tieba.card.k.jR(this.bZU.threadData.getId())) {
            com.baidu.tieba.card.k.a(this.mTitle, this.bZU.Ox().getId(), d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
        }
        this.dnH.setUserAfterClickListener(this.aob);
        this.bvH.setData(kVar.threadData);
        this.mStType = com.baidu.tieba.card.k.rn();
        this.anN = "feed#" + kVar.abV();
        bd Ox = kVar.Ox();
        if (this.dnH.getHeaderImg() != null) {
            if (this.dnH.getIsSimpleThread()) {
                this.dnH.getHeaderImg().setVisibility(8);
                this.bZa.setVisibility(8);
            } else if (Ox.rx() == null || Ox.rx().getPendantData() == null || StringUtils.isNull(Ox.rx().getPendantData().pT())) {
                this.bZa.setVisibility(8);
                this.dnH.getHeaderImg().setVisibility(0);
                this.dnH.getHeaderImg().setData(Ox);
            } else {
                this.dnH.getHeaderImg().setVisibility(4);
                this.bZa.setVisibility(0);
                this.bZa.setData(Ox);
            }
        }
        com.baidu.tieba.card.k.a(Ox, this.mTitle);
        this.dnI.startLoad(Ox.rQ().cover, 10, false);
        this.bZY.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), am.A(this.bZU.threadData.rQ().audience_count)));
        setPageUniqueId(getTag());
        this.caa.startPlayAnimation();
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.dnH != null) {
            this.dnH.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dnH != null) {
            return this.dnH.anW;
        }
        return null;
    }

    public void abR() {
        if (this.mPageContext != null && this.bZU != null && this.bZU.threadData != null && this.bZU.threadData.rx() != null && this.bZU.threadData.rQ() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.bZU.threadData.rx().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bZU.threadData.rQ());
            alaLiveInfoCoreData.userName = this.bZU.threadData.rx().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, this.boT, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
