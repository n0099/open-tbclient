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
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<j> implements com.baidu.tieba.a.e {
    private String aAE;
    private final View.OnClickListener aBE;
    private final View.OnClickListener azz;
    private TbImageView bEE;
    private LinearLayout bEK;
    private String bHC;
    public ThreadCommentAndPraiseInfoLayout bND;
    private String bNq;
    private LinearLayout bOC;
    private HeadPendantClickableView bOo;
    public ThreadSourceShareAndPraiseLayout bOr;
    public ImageView bgo;
    private TextView bgv;
    private View cCj;
    private View.OnClickListener cCl;
    private j cEj;
    private AlaPlayAnimationView cEn;
    public ConcernThreadUserInfoLayout ebd;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bHC = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.cCl = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akm() != null) {
                    a.this.akm().a(view, a.this.cEj);
                }
                a.this.akJ();
            }
        };
        this.aBE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akm() != null) {
                    a.this.akm().a(view, a.this.cEj);
                }
            }
        };
        this.azz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akm() != null) {
                    a.this.akm().a(view, a.this.cEj);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.bOo = (HeadPendantClickableView) view.findViewById(e.g.card_concern_ala_live_thread_user_pendant_header);
        if (this.bOo.getHeadView() != null) {
            this.bOo.getHeadView().setIsRound(true);
            this.bOo.getHeadView().setDrawBorder(false);
            this.bOo.getHeadView().setDefaultResource(17170445);
            this.bOo.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bOo.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bOo.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), e.C0141e.ds60));
        }
        this.bOo.setHasPendantStyle();
        if (this.bOo.getPendantView() != null) {
            this.bOo.getPendantView().setIsRound(true);
            this.bOo.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(e.g.card_concern_ala_live_thread_title);
        this.bEE = (TbImageView) getView().findViewById(e.g.card_concern_ala_live_thread_live_image_view);
        this.bEE.setDefaultErrorResource(0);
        this.bEE.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bEE.setDrawerType(0);
        this.bEE.setBorderSurroundContent(true);
        this.bEE.setDrawBorder(true);
        this.bEK = (LinearLayout) getView().findViewById(e.g.challenge_root);
        this.cCj = view.findViewById(e.g.divider_line);
        this.bND = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_concern_ala_live_thread_info_layout);
        this.ebd = (ConcernThreadUserInfoLayout) view.findViewById(e.g.card_concern_ala_live_thread_user_info_layout);
        if (this.bND.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bND.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bND.setLayoutParams(layoutParams);
        }
        this.bND.setOnClickListener(this.cCl);
        this.bND.setReplyTimeVisible(false);
        this.bND.setIsBarViewVisible(false);
        this.bND.setShowPraiseNum(true);
        this.bND.setNeedAddPraiseIcon(true);
        this.bND.setNeedAddReplyIcon(true);
        this.bND.setShareVisible(true);
        this.bND.amD = this.currentPageType;
        this.bND.setShareReportFrom(4);
        this.bND.setFrom(9);
        this.bND.setDisPraiseFrom(4);
        this.bND.setForumAfterClickListener(this.azz);
        if (this.bND.getCommentContainer() != null) {
            this.bND.getCommentContainer().setOnClickListener(this.cCl);
        }
        this.bOr = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_concern_ala_source_read_share_layout);
        this.bOr.aBl.setOnClickListener(this.cCl);
        this.bOr.setShareReportFrom(4);
        this.bOr.setFrom(9);
        this.bOr.aBl.amD = this.currentPageType;
        this.bOr.setForumAfterClickListener(this.azz);
        if (this.bOr.aBl.getCommentContainer() != null) {
            this.bOr.aBl.getCommentContainer().setOnClickListener(this.cCl);
        }
        this.bOC = (LinearLayout) view.findViewById(e.g.card_concern_ala_live_thread_content_layout);
        this.bgv = (TextView) getView().findViewById(e.g.play_count);
        this.bgo = (ImageView) view.findViewById(e.g.image_video_play);
        this.cEn = (AlaPlayAnimationView) view.findViewById(e.g.ala_play);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            this.bND.onChangeSkinType();
            this.ebd.onChangeSkinType();
            this.bOr.onChangeSkinType();
            al.j(this.cCj, e.d.cp_bg_line_e);
            al.h(this.bgv, e.d.cp_cont_i);
            al.c(this.bgo, e.f.btn_card_play_live_n);
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
        this.cEj = jVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cCl);
        }
        this.ebd.setData(jVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.lB(this.cEj.threadData.getId())) {
            o.a(this.mTitle, this.cEj.UT().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
        this.ebd.setUserAfterClickListener(this.aBE);
        this.aAE = "feed#" + jVar.akW();
        bb UT = jVar.UT();
        if (this.ebd.getHeaderImg() != null) {
            if (this.ebd.getIsSimpleThread()) {
                this.ebd.getHeaderImg().setVisibility(8);
                this.bOo.setVisibility(8);
            } else if (UT.wm() == null || UT.wm().getPendantData() == null || StringUtils.isNull(UT.wm().getPendantData().uW())) {
                this.bOo.setVisibility(8);
                this.ebd.getHeaderImg().setVisibility(0);
                this.ebd.getHeaderImg().setData(UT);
            } else {
                this.ebd.getHeaderImg().setVisibility(4);
                this.bOo.setVisibility(0);
                this.bOo.setData(UT);
            }
        }
        o.a(UT, this.mTitle);
        this.bEE.startLoad(UT.wG().cover, 10, false);
        this.bgv.setText(String.format(this.mContext.getResources().getString(e.j.ala_audience_count_prefix), ao.L(this.cEj.threadData.wG().audience_count)));
        setPageUniqueId(getTag());
        this.cEn.startPlayAnimation();
        hM(gT(1));
        if (UT.wG().mChallengeInfoData != null && UT.wG().mChallengeInfoData.challenge_id > 0) {
            this.bEK.setVisibility(0);
        } else {
            this.bEK.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.ebd != null) {
            this.ebd.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.ebd != null) {
            return this.ebd.aBr;
        }
        return null;
    }

    public void akJ() {
        if (this.mPageContext != null && this.cEj != null && this.cEj.threadData != null && this.cEj.threadData.wm() != null && this.cEj.threadData.wG() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.cEj.threadData.wm().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cEj.threadData.wG());
            alaLiveInfoCoreData.userName = this.cEj.threadData.wm().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, this.bHC, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void hM(int i) {
        if (this.cEj != null && this.cEj.threadData != null) {
            this.mStType = o.wa();
            if (i == 1) {
                this.bND.setVisibility(8);
                this.bOr.setStType(this.mStType);
                this.bOr.setData(this.cEj.threadData);
                this.ebd.showForumNameView(false);
                return;
            }
            this.bND.setData(this.cEj.threadData);
            this.bND.setStType(this.mStType);
            this.bOr.setVisibility(8);
            this.ebd.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bNq = str;
    }

    public int gT(int i) {
        return com.baidu.tieba.a.d.SB().L(this.bNq, i);
    }
}
