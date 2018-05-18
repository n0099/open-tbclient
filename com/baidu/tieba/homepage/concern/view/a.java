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
    public ImageView bkP;
    private String bru;
    private String bwO;
    private HeadPendantClickableView bxM;
    private LinearLayout bxP;
    public ThreadSourceShareAndPraiseLayout bxQ;
    public ThreadCommentAndPraiseInfoLayout bxb;
    private LinearLayout byb;
    private View cni;
    private View.OnClickListener cnk;
    private j cpj;
    private TextView cpn;
    private AlaPlayAnimationView cpp;
    public ConcernThreadUserInfoLayout dCE;
    private TbImageView dCF;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bru = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.cnk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aeZ() != null) {
                    a.this.aeZ().a(view2, a.this.cpj);
                }
                a.this.afv();
            }
        };
        this.apj = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aeZ() != null) {
                    a.this.aeZ().a(view2, a.this.cpj);
                }
            }
        };
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aeZ() != null) {
                    a.this.aeZ().a(view2, a.this.cpj);
                }
            }
        };
        View view2 = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.bxM = (HeadPendantClickableView) view2.findViewById(d.g.card_concern_ala_live_thread_user_pendant_header);
        if (this.bxM.getHeadView() != null) {
            this.bxM.getHeadView().setIsRound(true);
            this.bxM.getHeadView().setDrawBorder(false);
            this.bxM.getHeadView().setDefaultResource(17170445);
            this.bxM.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bxM.getHeadView().setDefaultBgResource(d.C0126d.cp_bg_line_e);
            this.bxM.getHeadView().setRadius(l.e(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        this.bxM.setHasPendantStyle();
        if (this.bxM.getPendantView() != null) {
            this.bxM.getPendantView().setIsRound(true);
            this.bxM.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view2.findViewById(d.g.card_concern_ala_live_thread_title);
        this.dCF = (TbImageView) getView().findViewById(d.g.card_concern_ala_live_thread_live_image_view);
        this.dCF.setDefaultErrorResource(0);
        this.dCF.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.dCF.setDrawerType(0);
        this.dCF.setBorderSurroundContent(true);
        this.dCF.setDrawBorder(true);
        this.bxP = (LinearLayout) getView().findViewById(d.g.challenge_root);
        this.cni = view2.findViewById(d.g.divider_line);
        this.bxb = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(d.g.card_concern_ala_live_thread_info_layout);
        this.dCE = (ConcernThreadUserInfoLayout) view2.findViewById(d.g.card_concern_ala_live_thread_user_info_layout);
        if (this.bxb.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bxb.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bxb.setLayoutParams(layoutParams);
        }
        this.bxb.setOnClickListener(this.cnk);
        this.bxb.setReplyTimeVisible(false);
        this.bxb.setIsBarViewVisible(false);
        this.bxb.setShowPraiseNum(true);
        this.bxb.setNeedAddPraiseIcon(true);
        this.bxb.setNeedAddReplyIcon(true);
        this.bxb.setShareVisible(true);
        this.bxb.abW = this.currentPageType;
        this.bxb.setShareReportFrom(4);
        this.bxb.setFrom(9);
        this.bxb.setForumAfterClickListener(this.aoY);
        if (this.bxb.getCommentContainer() != null) {
            this.bxb.getCommentContainer().setOnClickListener(this.cnk);
        }
        this.bxQ = (ThreadSourceShareAndPraiseLayout) view2.findViewById(d.g.card_concern_ala_source_read_share_layout);
        this.bxQ.apG.setOnClickListener(this.cnk);
        this.bxQ.setShareReportFrom(4);
        this.bxQ.setFrom(9);
        this.bxQ.apG.abW = this.currentPageType;
        this.bxQ.setForumAfterClickListener(this.aoY);
        if (this.bxQ.apG.getCommentContainer() != null) {
            this.bxQ.apG.getCommentContainer().setOnClickListener(this.cnk);
        }
        this.byb = (LinearLayout) view2.findViewById(d.g.card_concern_ala_live_thread_content_layout);
        this.cpn = (TextView) getView().findViewById(d.g.play_count);
        this.bkP = (ImageView) view2.findViewById(d.g.image_video_play);
        this.cpp = (AlaPlayAnimationView) view2.findViewById(d.g.ala_play);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.f.addresslist_item_bg);
            this.bxb.onChangeSkinType();
            this.dCE.onChangeSkinType();
            this.bxQ.onChangeSkinType();
            ak.j(this.cni, d.C0126d.cp_bg_line_e);
            ak.h(this.cpn, d.C0126d.cp_cont_i);
            ak.c(this.bkP, d.f.btn_card_play_live_n);
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
        this.cpj = jVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cnk);
        }
        this.dCE.setData(jVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.kz(this.cpj.threadData.getId())) {
            o.a(this.mTitle, this.cpj.Pb().getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
        }
        this.dCE.setUserAfterClickListener(this.apj);
        this.aoX = "feed#" + jVar.afI();
        bd Pb = jVar.Pb();
        if (this.dCE.getHeaderImg() != null) {
            if (this.dCE.getIsSimpleThread()) {
                this.dCE.getHeaderImg().setVisibility(8);
                this.bxM.setVisibility(8);
            } else if (Pb.rP() == null || Pb.rP().getPendantData() == null || StringUtils.isNull(Pb.rP().getPendantData().qF())) {
                this.bxM.setVisibility(8);
                this.dCE.getHeaderImg().setVisibility(0);
                this.dCE.getHeaderImg().setData(Pb);
            } else {
                this.dCE.getHeaderImg().setVisibility(4);
                this.bxM.setVisibility(0);
                this.bxM.setData(Pb);
            }
        }
        o.a(Pb, this.mTitle);
        this.dCF.startLoad(Pb.sh().cover, 10, false);
        this.cpn.setText(String.format(this.mContext.getResources().getString(d.k.ala_audience_count_prefix), an.B(this.cpj.threadData.sh().audience_count)));
        setPageUniqueId(getTag());
        this.cpp.startPlayAnimation();
        hc(gn(1));
        if (Pb.sh().mChallengeInfoData != null && Pb.sh().mChallengeInfoData.challenge_id > 0) {
            this.bxP.setVisibility(0);
        } else {
            this.bxP.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.dCE != null) {
            this.dCE.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dCE != null) {
            return this.dCE.apf;
        }
        return null;
    }

    public void afv() {
        if (this.mPageContext != null && this.cpj != null && this.cpj.threadData != null && this.cpj.threadData.rP() != null && this.cpj.threadData.sh() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.cpj.threadData.rP().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cpj.threadData.sh());
            alaLiveInfoCoreData.userName = this.cpj.threadData.rP().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, this.bru, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }

    public void hc(int i) {
        if (this.cpj != null && this.cpj.threadData != null) {
            this.mStType = o.rF();
            if (i == 1) {
                this.bxb.setVisibility(8);
                this.bxQ.setStType(this.mStType);
                this.bxQ.setData(this.cpj.threadData);
                this.dCE.showForumNameView(false);
                return;
            }
            this.bxb.setData(this.cpj.threadData);
            this.bxb.setStType(this.mStType);
            this.bxQ.setVisibility(8);
            this.dCE.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bwO = str;
    }

    public int gn(int i) {
        return com.baidu.tieba.a.d.MF().L(this.bwO, i);
    }
}
