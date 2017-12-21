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
    private String anS;
    private final View.OnClickListener anT;
    private final View.OnClickListener aog;
    private HeadPendantClickableView bZi;
    private View bZl;
    private View.OnClickListener bZn;
    public ImageView blb;
    private String boY;
    public ThreadCommentAndPraiseInfoLayout bvM;
    private LinearLayout bvP;
    private k cac;
    private TextView cag;
    private AlaPlayAnimationView cai;
    public ConcernThreadUserInfoLayout doR;
    private TbImageView doS;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.boY = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.bZn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.abt() != null) {
                    a.this.abt().a(view, a.this.cac);
                }
                a.this.abT();
            }
        };
        this.aog = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.abt() != null) {
                    a.this.abt().a(view, a.this.cac);
                }
            }
        };
        this.anT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.abt() != null) {
                    a.this.abt().a(view, a.this.cac);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.bZi = (HeadPendantClickableView) view.findViewById(d.g.card_concern_ala_live_thread_user_pendant_header);
        if (this.bZi.getHeadView() != null) {
            this.bZi.getHeadView().setIsRound(true);
            this.bZi.getHeadView().setDrawBorder(false);
            this.bZi.getHeadView().setDefaultResource(17170445);
            this.bZi.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bZi.getHeadView().setDefaultBgResource(d.C0095d.cp_bg_line_e);
            this.bZi.getHeadView().setRadius(l.f(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        this.bZi.wi();
        if (this.bZi.getPendantView() != null) {
            this.bZi.getPendantView().setIsRound(true);
            this.bZi.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_ala_live_thread_title);
        this.doS = (TbImageView) getView().findViewById(d.g.card_concern_ala_live_thread_live_image_view);
        this.doS.setDefaultErrorResource(0);
        this.doS.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.doS.setDrawerType(0);
        this.doS.setBorderSurroundContent(true);
        this.doS.setDrawBorder(true);
        this.bZl = view.findViewById(d.g.divider_line);
        this.bvM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_info_layout);
        this.doR = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_user_info_layout);
        if (this.bvM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bvM.setLayoutParams(layoutParams);
        }
        this.bvM.setOnClickListener(this.bZn);
        this.bvM.setReplyTimeVisible(false);
        this.bvM.setIsBarViewVisible(false);
        this.bvM.setShowPraiseNum(true);
        this.bvM.setNeedAddPraiseIcon(true);
        this.bvM.setNeedAddReplyIcon(true);
        this.bvM.setShareVisible(true);
        this.bvM.anR = this.currentPageType;
        this.bvM.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.abt() != null) {
                    a.this.abt().a(view2, a.this.cac);
                }
            }
        });
        if (this.bvM.getCommentContainer() != null) {
            this.bvM.getCommentContainer().setOnClickListener(this.bZn);
        }
        this.bvP = (LinearLayout) view.findViewById(d.g.card_concern_ala_live_thread_content_layout);
        this.cag = (TextView) getView().findViewById(d.g.play_count);
        this.blb = (ImageView) view.findViewById(d.g.image_video_play);
        this.cai = (AlaPlayAnimationView) view.findViewById(d.g.ala_play);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            this.bvM.onChangeSkinType();
            this.doR.onChangeSkinType();
            aj.k(this.bZl, d.C0095d.cp_bg_line_e);
            aj.i(this.cag, d.C0095d.cp_cont_i);
            aj.c(this.blb, d.f.btn_card_play_live_n);
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
        this.cac = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bZn);
        }
        this.doR.setData(kVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tieba.card.k.jP(this.cac.threadData.getId())) {
            com.baidu.tieba.card.k.a(this.mTitle, this.cac.Ox().getId(), d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
        }
        this.doR.setUserAfterClickListener(this.aog);
        this.bvM.setData(kVar.threadData);
        this.mStType = com.baidu.tieba.card.k.rl();
        this.anS = "feed#" + kVar.ace();
        bd Ox = kVar.Ox();
        if (this.doR.getHeaderImg() != null) {
            if (this.doR.getIsSimpleThread()) {
                this.doR.getHeaderImg().setVisibility(8);
                this.bZi.setVisibility(8);
            } else if (Ox.rv() == null || Ox.rv().getPendantData() == null || StringUtils.isNull(Ox.rv().getPendantData().pR())) {
                this.bZi.setVisibility(8);
                this.doR.getHeaderImg().setVisibility(0);
                this.doR.getHeaderImg().setData(Ox);
            } else {
                this.doR.getHeaderImg().setVisibility(4);
                this.bZi.setVisibility(0);
                this.bZi.setData(Ox);
            }
        }
        com.baidu.tieba.card.k.a(Ox, this.mTitle);
        this.doS.startLoad(Ox.rO().cover, 10, false);
        this.cag.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), am.A(this.cac.threadData.rO().audience_count)));
        setPageUniqueId(getTag());
        this.cai.startPlayAnimation();
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.doR != null) {
            this.doR.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.doR != null) {
            return this.doR.aob;
        }
        return null;
    }

    public void abT() {
        if (this.mPageContext != null && this.cac != null && this.cac.threadData != null && this.cac.threadData.rv() != null && this.cac.threadData.rO() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.cac.threadData.rv().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cac.threadData.rO());
            alaLiveInfoCoreData.userName = this.cac.threadData.rv().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, this.boY, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
