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
    private String anP;
    private final View.OnClickListener anQ;
    private final View.OnClickListener aod;
    private k bZY;
    private HeadPendantClickableView bZe;
    private View bZh;
    private View.OnClickListener bZj;
    public ImageView bkX;
    private String boU;
    public ThreadCommentAndPraiseInfoLayout bvI;
    private LinearLayout bvL;
    private TextView cac;
    private AlaPlayAnimationView cae;
    public ConcernThreadUserInfoLayout doN;
    private TbImageView doO;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.boU = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.bZj = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.abt() != null) {
                    a.this.abt().a(view, a.this.bZY);
                }
                a.this.abU();
            }
        };
        this.aod = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.abt() != null) {
                    a.this.abt().a(view, a.this.bZY);
                }
            }
        };
        this.anQ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.abt() != null) {
                    a.this.abt().a(view, a.this.bZY);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.bZe = (HeadPendantClickableView) view.findViewById(d.g.card_concern_ala_live_thread_user_pendant_header);
        if (this.bZe.getHeadView() != null) {
            this.bZe.getHeadView().setIsRound(true);
            this.bZe.getHeadView().setDrawBorder(false);
            this.bZe.getHeadView().setDefaultResource(17170445);
            this.bZe.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bZe.getHeadView().setDefaultBgResource(d.C0096d.cp_bg_line_e);
            this.bZe.getHeadView().setRadius(l.f(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        this.bZe.wi();
        if (this.bZe.getPendantView() != null) {
            this.bZe.getPendantView().setIsRound(true);
            this.bZe.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_ala_live_thread_title);
        this.doO = (TbImageView) getView().findViewById(d.g.card_concern_ala_live_thread_live_image_view);
        this.doO.setDefaultErrorResource(0);
        this.doO.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.doO.setDrawerType(0);
        this.doO.setBorderSurroundContent(true);
        this.doO.setDrawBorder(true);
        this.bZh = view.findViewById(d.g.divider_line);
        this.bvI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_info_layout);
        this.doN = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_user_info_layout);
        if (this.bvI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvI.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bvI.setLayoutParams(layoutParams);
        }
        this.bvI.setOnClickListener(this.bZj);
        this.bvI.setReplyTimeVisible(false);
        this.bvI.setIsBarViewVisible(false);
        this.bvI.setShowPraiseNum(true);
        this.bvI.setNeedAddPraiseIcon(true);
        this.bvI.setNeedAddReplyIcon(true);
        this.bvI.setShareVisible(true);
        this.bvI.anO = this.currentPageType;
        this.bvI.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.abt() != null) {
                    a.this.abt().a(view2, a.this.bZY);
                }
            }
        });
        if (this.bvI.getCommentContainer() != null) {
            this.bvI.getCommentContainer().setOnClickListener(this.bZj);
        }
        this.bvL = (LinearLayout) view.findViewById(d.g.card_concern_ala_live_thread_content_layout);
        this.cac = (TextView) getView().findViewById(d.g.play_count);
        this.bkX = (ImageView) view.findViewById(d.g.image_video_play);
        this.cae = (AlaPlayAnimationView) view.findViewById(d.g.ala_play);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            this.bvI.onChangeSkinType();
            this.doN.onChangeSkinType();
            aj.k(this.bZh, d.C0096d.cp_bg_line_e);
            aj.i(this.cac, d.C0096d.cp_cont_i);
            aj.c(this.bkX, d.f.btn_card_play_live_n);
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
        this.bZY = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bZj);
        }
        this.doN.setData(kVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tieba.card.k.jP(this.bZY.threadData.getId())) {
            com.baidu.tieba.card.k.a(this.mTitle, this.bZY.Ox().getId(), d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
        }
        this.doN.setUserAfterClickListener(this.aod);
        this.bvI.setData(kVar.threadData);
        this.mStType = com.baidu.tieba.card.k.rl();
        this.anP = "feed#" + kVar.acf();
        bd Ox = kVar.Ox();
        if (this.doN.getHeaderImg() != null) {
            if (this.doN.getIsSimpleThread()) {
                this.doN.getHeaderImg().setVisibility(8);
                this.bZe.setVisibility(8);
            } else if (Ox.rv() == null || Ox.rv().getPendantData() == null || StringUtils.isNull(Ox.rv().getPendantData().pR())) {
                this.bZe.setVisibility(8);
                this.doN.getHeaderImg().setVisibility(0);
                this.doN.getHeaderImg().setData(Ox);
            } else {
                this.doN.getHeaderImg().setVisibility(4);
                this.bZe.setVisibility(0);
                this.bZe.setData(Ox);
            }
        }
        com.baidu.tieba.card.k.a(Ox, this.mTitle);
        this.doO.startLoad(Ox.rO().cover, 10, false);
        this.cac.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), am.A(this.bZY.threadData.rO().audience_count)));
        setPageUniqueId(getTag());
        this.cae.startPlayAnimation();
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.doN != null) {
            this.doN.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.doN != null) {
            return this.doN.anY;
        }
        return null;
    }

    public void abU() {
        if (this.mPageContext != null && this.bZY != null && this.bZY.threadData != null && this.bZY.threadData.rv() != null && this.bZY.threadData.rO() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.bZY.threadData.rv().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bZY.threadData.rO());
            alaLiveInfoCoreData.userName = this.bZY.threadData.rv().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, this.boU, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
