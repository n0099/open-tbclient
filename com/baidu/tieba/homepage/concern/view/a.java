package com.baidu.tieba.homepage.concern.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<k> {
    private String aod;
    private final View.OnClickListener aoe;
    private final View.OnClickListener aow;
    private HeadPendantClickableView bJq;
    private View bJu;
    private View.OnClickListener bJw;
    private k bKk;
    private String bez;
    private LinearLayout blD;
    public ThreadCommentAndPraiseInfoLayout blz;
    public ConcernThreadUserInfoLayout cZf;
    private TbImageView cZg;
    private TextView cZh;
    private LinearLayout cZi;
    private TbPageContext<?> mF;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bez = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.bJw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.XA() != null) {
                    a.this.XA().a(view, a.this.bKk);
                }
                a.this.XW();
            }
        };
        this.aow = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.XA() != null) {
                    a.this.XA().a(view, a.this.bKk);
                }
            }
        };
        this.aoe = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.XA() != null) {
                    a.this.XA().a(view, a.this.bKk);
                }
            }
        };
        View view = getView();
        this.mF = tbPageContext;
        this.bJq = (HeadPendantClickableView) view.findViewById(d.h.card_concern_ala_live_thread_user_pendant_header);
        if (this.bJq.getHeadView() != null) {
            this.bJq.getHeadView().setIsRound(true);
            this.bJq.getHeadView().setDrawBorder(false);
            this.bJq.getHeadView().setDefaultResource(17170445);
            this.bJq.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bJq.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bJq.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds60));
        }
        this.bJq.wB();
        if (this.bJq.getPendantView() != null) {
            this.bJq.getPendantView().setIsRound(true);
            this.bJq.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.h.card_concern_ala_live_thread_title);
        this.cZg = (TbImageView) getView().findViewById(d.h.card_concern_ala_live_thread_live_image_view);
        this.cZg.setDefaultErrorResource(0);
        this.cZg.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.cZg.setDrawerType(0);
        this.cZg.setBorderSurroundContent(true);
        this.cZg.setDrawBorder(true);
        this.cZh = (TextView) getView().findViewById(d.h.card_concern_ala_live_thread_live_tip_tv);
        this.cZi = (LinearLayout) getView().findViewById(d.h.card_concern_ala_live_thread_tip_layout);
        this.bJu = view.findViewById(d.h.divider_line);
        this.blz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_concern_ala_live_thread_info_layout);
        this.cZf = (ConcernThreadUserInfoLayout) view.findViewById(d.h.card_concern_ala_live_thread_user_info_layout);
        if (this.blz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.blz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.blz.setLayoutParams(layoutParams);
        }
        this.blz.setOnClickListener(this.bJw);
        this.blz.setReplyTimeVisible(false);
        this.blz.setIsBarViewVisible(false);
        this.blz.setShowPraiseNum(true);
        this.blz.setCommentNumEnable(false);
        this.blz.setNeedAddPraiseIcon(true);
        this.blz.setNeedAddReplyIcon(false);
        this.blz.setLiveAudienceEnable(true);
        this.blz.setLiveAudienceIcon(d.g.icon_home_card_live_n);
        this.blz.setReplyIcon(d.g.icon_home_card_comment_n);
        this.blz.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.XA() != null) {
                    a.this.XA().a(view2, a.this.bKk);
                }
            }
        });
        this.blD = (LinearLayout) view.findViewById(d.h.card_concern_ala_live_thread_content_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.addresslist_item_bg);
            this.blz.onChangeSkinType();
            this.cZf.onChangeSkinType();
            aj.k(this.bJu, d.e.cp_bg_line_c);
            aj.i(this.cZh, d.e.cp_cont_i);
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
        this.bKk = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bJw);
        }
        this.cZf.c(kVar.threadData);
        d(this.mF, TbadkCoreApplication.getInst().getSkinType());
        if (m.jt(this.bKk.threadData.getId())) {
            m.a(this.mTitle, this.bKk.MR().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        }
        this.cZf.setUserAfterClickListener(this.aow);
        this.blz.c(kVar.threadData);
        this.mStType = m.rs();
        this.aod = "feed#" + kVar.Yb();
        bj MR = kVar.MR();
        if (this.cZf.getHeaderImg() != null) {
            if (this.cZf.getIsSimpleThread()) {
                this.cZf.getHeaderImg().setVisibility(8);
                this.bJq.setVisibility(8);
            } else if (MR.getAuthor() == null || MR.getAuthor().getPendantData() == null || StringUtils.isNull(MR.getAuthor().getPendantData().pR())) {
                this.bJq.setVisibility(8);
                this.cZf.getHeaderImg().setVisibility(0);
                this.cZf.getHeaderImg().setData(MR);
            } else {
                this.cZf.getHeaderImg().setVisibility(4);
                this.bJq.setVisibility(0);
                this.bJq.setData(MR);
            }
        }
        m.a(MR, this.mTitle);
        this.cZh.setCompoundDrawablesWithIntrinsicBounds(d.g.icon_video_direct_seeding, 0, 0, 0);
        this.cZh.setText(this.mContext.getResources().getString(d.l.live_in));
        this.cZg.c(MR.rT().cover, 10, false);
        setPageUniqueId(getTag());
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cZf != null) {
            this.cZf.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cZf != null) {
            return this.cZf.aor;
        }
        return null;
    }

    public void XW() {
        if (this.mF != null && this.bKk != null && this.bKk.threadData != null && this.bKk.threadData.getAuthor() != null && this.bKk.threadData.rT() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.bKk.threadData.getAuthor().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bKk.threadData.rT());
            alaLiveInfoCoreData.setUserName(this.bKk.threadData.getAuthor().getUserName());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mF.getPageActivity(), alaLiveInfoCoreData, this.bez, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
