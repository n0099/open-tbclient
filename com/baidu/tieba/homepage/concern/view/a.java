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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.card.o;
import com.baidu.tieba.f;
import com.baidu.tieba.view.AlaPlayAnimationView;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<j> implements com.baidu.tieba.a.e {
    private final View.OnClickListener axL;
    private String axv;
    private final View.OnClickListener axw;
    private String bBN;
    private String bHB;
    public ThreadCommentAndPraiseInfoLayout bHO;
    public ThreadSourceShareAndPraiseLayout bIC;
    private LinearLayout bIN;
    private HeadPendantClickableView bIz;
    public ImageView bcT;
    private TextView bcZ;
    private TbImageView byP;
    private LinearLayout byV;
    private View cwt;
    private View.OnClickListener cwv;
    private j cyt;
    private AlaPlayAnimationView cyx;
    public ConcernThreadUserInfoLayout dTK;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bBN = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.cwv = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiC() != null) {
                    a.this.aiC().a(view, a.this.cyt);
                }
                a.this.aiY();
            }
        };
        this.axL = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiC() != null) {
                    a.this.aiC().a(view, a.this.cyt);
                }
            }
        };
        this.axw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiC() != null) {
                    a.this.aiC().a(view, a.this.cyt);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.bIz = (HeadPendantClickableView) view.findViewById(f.g.card_concern_ala_live_thread_user_pendant_header);
        if (this.bIz.getHeadView() != null) {
            this.bIz.getHeadView().setIsRound(true);
            this.bIz.getHeadView().setDrawBorder(false);
            this.bIz.getHeadView().setDefaultResource(17170445);
            this.bIz.getHeadView().setDefaultErrorResource(f.C0146f.icon_default_avatar100);
            this.bIz.getHeadView().setDefaultBgResource(f.d.cp_bg_line_e);
            this.bIz.getHeadView().setRadius(l.f(this.mPageContext.getPageActivity(), f.e.ds60));
        }
        this.bIz.setHasPendantStyle();
        if (this.bIz.getPendantView() != null) {
            this.bIz.getPendantView().setIsRound(true);
            this.bIz.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(f.g.card_concern_ala_live_thread_title);
        this.byP = (TbImageView) getView().findViewById(f.g.card_concern_ala_live_thread_live_image_view);
        this.byP.setDefaultErrorResource(0);
        this.byP.setDefaultBgResource(f.C0146f.pic_bg_video_frs);
        this.byP.setDrawerType(0);
        this.byP.setBorderSurroundContent(true);
        this.byP.setDrawBorder(true);
        this.byV = (LinearLayout) getView().findViewById(f.g.challenge_root);
        this.cwt = view.findViewById(f.g.divider_line);
        this.bHO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(f.g.card_concern_ala_live_thread_info_layout);
        this.dTK = (ConcernThreadUserInfoLayout) view.findViewById(f.g.card_concern_ala_live_thread_user_info_layout);
        if (this.bHO.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHO.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bHO.setLayoutParams(layoutParams);
        }
        this.bHO.setOnClickListener(this.cwv);
        this.bHO.setReplyTimeVisible(false);
        this.bHO.setIsBarViewVisible(false);
        this.bHO.setShowPraiseNum(true);
        this.bHO.setNeedAddPraiseIcon(true);
        this.bHO.setNeedAddReplyIcon(true);
        this.bHO.setShareVisible(true);
        this.bHO.ajY = this.currentPageType;
        this.bHO.setShareReportFrom(4);
        this.bHO.setFrom(9);
        this.bHO.setForumAfterClickListener(this.axw);
        if (this.bHO.getCommentContainer() != null) {
            this.bHO.getCommentContainer().setOnClickListener(this.cwv);
        }
        this.bIC = (ThreadSourceShareAndPraiseLayout) view.findViewById(f.g.card_concern_ala_source_read_share_layout);
        this.bIC.ayo.setOnClickListener(this.cwv);
        this.bIC.setShareReportFrom(4);
        this.bIC.setFrom(9);
        this.bIC.ayo.ajY = this.currentPageType;
        this.bIC.setForumAfterClickListener(this.axw);
        if (this.bIC.ayo.getCommentContainer() != null) {
            this.bIC.ayo.getCommentContainer().setOnClickListener(this.cwv);
        }
        this.bIN = (LinearLayout) view.findViewById(f.g.card_concern_ala_live_thread_content_layout);
        this.bcZ = (TextView) getView().findViewById(f.g.play_count);
        this.bcT = (ImageView) view.findViewById(f.g.image_video_play);
        this.cyx = (AlaPlayAnimationView) view.findViewById(f.g.ala_play);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), f.C0146f.addresslist_item_bg);
            this.bHO.onChangeSkinType();
            this.dTK.onChangeSkinType();
            this.bIC.onChangeSkinType();
            am.j(this.cwt, f.d.cp_bg_line_e);
            am.h(this.bcZ, f.d.cp_cont_i);
            am.c(this.bcT, f.C0146f.btn_card_play_live_n);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_concern_ala_live_thread;
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
        this.cyt = jVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cwv);
        }
        this.dTK.setData(jVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.kZ(this.cyt.threadData.getId())) {
            o.a(this.mTitle, this.cyt.Tg().getId(), f.d.cp_cont_b, f.d.cp_cont_d);
        }
        this.dTK.setUserAfterClickListener(this.axL);
        this.axv = "feed#" + jVar.ajl();
        bb Tg = jVar.Tg();
        if (this.dTK.getHeaderImg() != null) {
            if (this.dTK.getIsSimpleThread()) {
                this.dTK.getHeaderImg().setVisibility(8);
                this.bIz.setVisibility(8);
            } else if (Tg.vj() == null || Tg.vj().getPendantData() == null || StringUtils.isNull(Tg.vj().getPendantData().tT())) {
                this.bIz.setVisibility(8);
                this.dTK.getHeaderImg().setVisibility(0);
                this.dTK.getHeaderImg().setData(Tg);
            } else {
                this.dTK.getHeaderImg().setVisibility(4);
                this.bIz.setVisibility(0);
                this.bIz.setData(Tg);
            }
        }
        o.a(Tg, this.mTitle);
        this.byP.startLoad(Tg.vC().cover, 10, false);
        this.bcZ.setText(String.format(this.mContext.getResources().getString(f.j.ala_audience_count_prefix), ap.H(this.cyt.threadData.vC().audience_count)));
        setPageUniqueId(getTag());
        this.cyx.startPlayAnimation();
        hm(gt(1));
        if (Tg.vC().mChallengeInfoData != null && Tg.vC().mChallengeInfoData.challenge_id > 0) {
            this.byV.setVisibility(0);
        } else {
            this.byV.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.dTK != null) {
            this.dTK.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dTK != null) {
            return this.dTK.axH;
        }
        return null;
    }

    public void aiY() {
        if (this.mPageContext != null && this.cyt != null && this.cyt.threadData != null && this.cyt.threadData.vj() != null && this.cyt.threadData.vC() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.cyt.threadData.vj().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cyt.threadData.vC());
            alaLiveInfoCoreData.userName = this.cyt.threadData.vj().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, this.bBN, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void hm(int i) {
        if (this.cyt != null && this.cyt.threadData != null) {
            this.mStType = o.uX();
            if (i == 1) {
                this.bHO.setVisibility(8);
                this.bIC.setStType(this.mStType);
                this.bIC.setData(this.cyt.threadData);
                this.dTK.showForumNameView(false);
                return;
            }
            this.bHO.setData(this.cyt.threadData);
            this.bHO.setStType(this.mStType);
            this.bIC.setVisibility(8);
            this.dTK.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bHB = str;
    }

    public int gt(int i) {
        return com.baidu.tieba.a.d.QN().G(this.bHB, i);
    }
}
