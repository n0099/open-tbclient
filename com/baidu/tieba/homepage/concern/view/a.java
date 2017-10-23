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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
import com.baidu.tieba.view.AlaPlayAnimationView;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<k> {
    private String ane;
    private final View.OnClickListener anf;
    private final View.OnClickListener anx;
    private HeadPendantClickableView bJj;
    private View bJm;
    private View.OnClickListener bJo;
    private k bKe;
    public ImageView bKi;
    private TextView bKj;
    private AlaPlayAnimationView bKl;
    private String bfV;
    public ThreadCommentAndPraiseInfoLayout bmV;
    private LinearLayout bmZ;
    public ConcernThreadUserInfoLayout cWr;
    private TbImageView cWs;
    private TbPageContext<?> mH;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bfV = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.bJo = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.Xn() != null) {
                    a.this.Xn().a(view, a.this.bKe);
                }
                a.this.XL();
            }
        };
        this.anx = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.Xn() != null) {
                    a.this.Xn().a(view, a.this.bKe);
                }
            }
        };
        this.anf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.Xn() != null) {
                    a.this.Xn().a(view, a.this.bKe);
                }
            }
        };
        View view = getView();
        this.mH = tbPageContext;
        this.bJj = (HeadPendantClickableView) view.findViewById(d.h.card_concern_ala_live_thread_user_pendant_header);
        if (this.bJj.getHeadView() != null) {
            this.bJj.getHeadView().setIsRound(true);
            this.bJj.getHeadView().setDrawBorder(false);
            this.bJj.getHeadView().setDefaultResource(17170445);
            this.bJj.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bJj.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bJj.getHeadView().setRadius(l.f(this.mH.getPageActivity(), d.f.ds60));
        }
        this.bJj.vZ();
        if (this.bJj.getPendantView() != null) {
            this.bJj.getPendantView().setIsRound(true);
            this.bJj.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.h.card_concern_ala_live_thread_title);
        this.cWs = (TbImageView) getView().findViewById(d.h.card_concern_ala_live_thread_live_image_view);
        this.cWs.setDefaultErrorResource(0);
        this.cWs.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.cWs.setDrawerType(0);
        this.cWs.setBorderSurroundContent(true);
        this.cWs.setDrawBorder(true);
        this.bJm = view.findViewById(d.h.divider_line);
        this.bmV = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_concern_ala_live_thread_info_layout);
        this.cWr = (ConcernThreadUserInfoLayout) view.findViewById(d.h.card_concern_ala_live_thread_user_info_layout);
        if (this.bmV.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bmV.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bmV.setLayoutParams(layoutParams);
        }
        this.bmV.setOnClickListener(this.bJo);
        this.bmV.setReplyTimeVisible(false);
        this.bmV.setIsBarViewVisible(false);
        this.bmV.setShowPraiseNum(true);
        this.bmV.setCommentNumEnable(false);
        this.bmV.setNeedAddPraiseIcon(true);
        this.bmV.setNeedAddReplyIcon(false);
        this.bmV.setLiveAudienceEnable(false);
        this.bmV.setShareVisible(true);
        this.bmV.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.Xn() != null) {
                    a.this.Xn().a(view2, a.this.bKe);
                }
            }
        });
        this.bmZ = (LinearLayout) view.findViewById(d.h.card_concern_ala_live_thread_content_layout);
        this.bKj = (TextView) getView().findViewById(d.h.play_count);
        this.bKi = (ImageView) view.findViewById(d.h.image_video_play);
        this.bKl = (AlaPlayAnimationView) view.findViewById(d.h.ala_play);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.addresslist_item_bg);
            this.bmV.onChangeSkinType();
            this.cWr.onChangeSkinType();
            aj.k(this.bJm, d.e.cp_bg_line_e);
            aj.i(this.bKj, d.e.cp_cont_i);
            aj.c(this.bKi, d.g.btn_icon_play_live_on_n);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_concern_ala_live_thread;
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
        this.bKe = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bJo);
        }
        this.cWr.setData(kVar.threadData);
        d(this.mH, TbadkCoreApplication.getInst().getSkinType());
        if (m.jm(this.bKe.threadData.getId())) {
            m.a(this.mTitle, this.bKe.Nd().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        }
        this.cWr.setUserAfterClickListener(this.anx);
        this.bmV.setData(kVar.threadData);
        this.mStType = m.rf();
        this.ane = "feed#" + kVar.XQ();
        bh Nd = kVar.Nd();
        if (this.cWr.getHeaderImg() != null) {
            if (this.cWr.getIsSimpleThread()) {
                this.cWr.getHeaderImg().setVisibility(8);
                this.bJj.setVisibility(8);
            } else if (Nd.getAuthor() == null || Nd.getAuthor().getPendantData() == null || StringUtils.isNull(Nd.getAuthor().getPendantData().pL())) {
                this.bJj.setVisibility(8);
                this.cWr.getHeaderImg().setVisibility(0);
                this.cWr.getHeaderImg().setData(Nd);
            } else {
                this.cWr.getHeaderImg().setVisibility(4);
                this.bJj.setVisibility(0);
                this.bJj.setData(Nd);
            }
        }
        m.a(Nd, this.mTitle);
        this.cWs.c(Nd.rG().cover, 10, false);
        this.bKj.setText(String.format(this.mContext.getResources().getString(d.l.ala_audience_count_prefix), am.A(this.bKe.threadData.rG().audience_count)));
        setPageUniqueId(getTag());
        this.bKl.XP();
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cWr != null) {
            this.cWr.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cWr != null) {
            return this.cWr.ans;
        }
        return null;
    }

    public void XL() {
        if (this.mH != null && this.bKe != null && this.bKe.threadData != null && this.bKe.threadData.getAuthor() != null && this.bKe.threadData.rG() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.bKe.threadData.getAuthor().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bKe.threadData.rG());
            alaLiveInfoCoreData.setUserName(this.bKe.threadData.getAuthor().getUserName());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mH.getPageActivity(), alaLiveInfoCoreData, this.bfV, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
