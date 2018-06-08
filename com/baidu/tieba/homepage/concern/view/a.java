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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
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
    private String axf;
    private final View.OnClickListener axg;
    private final View.OnClickListener axr;
    private String bER;
    private HeadPendantClickableView bFP;
    private LinearLayout bFS;
    public ThreadSourceShareAndPraiseLayout bFT;
    public ThreadCommentAndPraiseInfoLayout bFe;
    private LinearLayout bGe;
    public ImageView bsT;
    private String bzz;
    private View cvN;
    private View.OnClickListener cvP;
    private j cxN;
    private TextView cxR;
    private AlaPlayAnimationView cxT;
    public ConcernThreadUserInfoLayout dNK;
    private TbImageView dNL;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bzz = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.cvP = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiI() != null) {
                    a.this.aiI().a(view, a.this.cxN);
                }
                a.this.aje();
            }
        };
        this.axr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiI() != null) {
                    a.this.aiI().a(view, a.this.cxN);
                }
            }
        };
        this.axg = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiI() != null) {
                    a.this.aiI().a(view, a.this.cxN);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.bFP = (HeadPendantClickableView) view.findViewById(d.g.card_concern_ala_live_thread_user_pendant_header);
        if (this.bFP.getHeadView() != null) {
            this.bFP.getHeadView().setIsRound(true);
            this.bFP.getHeadView().setDrawBorder(false);
            this.bFP.getHeadView().setDefaultResource(17170445);
            this.bFP.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bFP.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.bFP.getHeadView().setRadius(l.e(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        this.bFP.setHasPendantStyle();
        if (this.bFP.getPendantView() != null) {
            this.bFP.getPendantView().setIsRound(true);
            this.bFP.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_ala_live_thread_title);
        this.dNL = (TbImageView) getView().findViewById(d.g.card_concern_ala_live_thread_live_image_view);
        this.dNL.setDefaultErrorResource(0);
        this.dNL.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.dNL.setDrawerType(0);
        this.dNL.setBorderSurroundContent(true);
        this.dNL.setDrawBorder(true);
        this.bFS = (LinearLayout) getView().findViewById(d.g.challenge_root);
        this.cvN = view.findViewById(d.g.divider_line);
        this.bFe = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_info_layout);
        this.dNK = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_user_info_layout);
        if (this.bFe.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bFe.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bFe.setLayoutParams(layoutParams);
        }
        this.bFe.setOnClickListener(this.cvP);
        this.bFe.setReplyTimeVisible(false);
        this.bFe.setIsBarViewVisible(false);
        this.bFe.setShowPraiseNum(true);
        this.bFe.setNeedAddPraiseIcon(true);
        this.bFe.setNeedAddReplyIcon(true);
        this.bFe.setShareVisible(true);
        this.bFe.aka = this.currentPageType;
        this.bFe.setShareReportFrom(4);
        this.bFe.setFrom(9);
        this.bFe.setForumAfterClickListener(this.axg);
        if (this.bFe.getCommentContainer() != null) {
            this.bFe.getCommentContainer().setOnClickListener(this.cvP);
        }
        this.bFT = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_ala_source_read_share_layout);
        this.bFT.axN.setOnClickListener(this.cvP);
        this.bFT.setShareReportFrom(4);
        this.bFT.setFrom(9);
        this.bFT.axN.aka = this.currentPageType;
        this.bFT.setForumAfterClickListener(this.axg);
        if (this.bFT.axN.getCommentContainer() != null) {
            this.bFT.axN.getCommentContainer().setOnClickListener(this.cvP);
        }
        this.bGe = (LinearLayout) view.findViewById(d.g.card_concern_ala_live_thread_content_layout);
        this.cxR = (TextView) getView().findViewById(d.g.play_count);
        this.bsT = (ImageView) view.findViewById(d.g.image_video_play);
        this.cxT = (AlaPlayAnimationView) view.findViewById(d.g.ala_play);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), d.f.addresslist_item_bg);
            this.bFe.onChangeSkinType();
            this.dNK.onChangeSkinType();
            this.bFT.onChangeSkinType();
            al.j(this.cvN, d.C0141d.cp_bg_line_e);
            al.h(this.cxR, d.C0141d.cp_cont_i);
            al.c(this.bsT, d.f.btn_card_play_live_n);
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
        this.cxN = jVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cvP);
        }
        this.dNK.setData(jVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.lc(this.cxN.threadData.getId())) {
            o.a(this.mTitle, this.cxN.Sz().getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        }
        this.dNK.setUserAfterClickListener(this.axr);
        this.axf = "feed#" + jVar.ajp();
        bd Sz = jVar.Sz();
        if (this.dNK.getHeaderImg() != null) {
            if (this.dNK.getIsSimpleThread()) {
                this.dNK.getHeaderImg().setVisibility(8);
                this.bFP.setVisibility(8);
            } else if (Sz.vm() == null || Sz.vm().getPendantData() == null || StringUtils.isNull(Sz.vm().getPendantData().ub())) {
                this.bFP.setVisibility(8);
                this.dNK.getHeaderImg().setVisibility(0);
                this.dNK.getHeaderImg().setData(Sz);
            } else {
                this.dNK.getHeaderImg().setVisibility(4);
                this.bFP.setVisibility(0);
                this.bFP.setData(Sz);
            }
        }
        o.a(Sz, this.mTitle);
        this.dNL.startLoad(Sz.vE().cover, 10, false);
        this.cxR.setText(String.format(this.mContext.getResources().getString(d.k.ala_audience_count_prefix), ao.E(this.cxN.threadData.vE().audience_count)));
        setPageUniqueId(getTag());
        this.cxT.startPlayAnimation();
        hd(go(1));
        if (Sz.vE().mChallengeInfoData != null && Sz.vE().mChallengeInfoData.challenge_id > 0) {
            this.bFS.setVisibility(0);
        } else {
            this.bFS.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.dNK != null) {
            this.dNK.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dNK != null) {
            return this.dNK.axn;
        }
        return null;
    }

    public void aje() {
        if (this.mPageContext != null && this.cxN != null && this.cxN.threadData != null && this.cxN.threadData.vm() != null && this.cxN.threadData.vE() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.cxN.threadData.vm().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cxN.threadData.vE());
            alaLiveInfoCoreData.userName = this.cxN.threadData.vm().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, this.bzz, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void hd(int i) {
        if (this.cxN != null && this.cxN.threadData != null) {
            this.mStType = o.vb();
            if (i == 1) {
                this.bFe.setVisibility(8);
                this.bFT.setStType(this.mStType);
                this.bFT.setData(this.cxN.threadData);
                this.dNK.showForumNameView(false);
                return;
            }
            this.bFe.setData(this.cxN.threadData);
            this.bFe.setStType(this.mStType);
            this.bFT.setVisibility(8);
            this.dNK.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bER = str;
    }

    public int go(int i) {
        return com.baidu.tieba.a.d.Qe().L(this.bER, i);
    }
}
