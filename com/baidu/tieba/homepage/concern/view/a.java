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
    private String aob;
    private final View.OnClickListener aoc;
    private final View.OnClickListener aou;
    private HeadPendantClickableView bKh;
    private View bKl;
    private View.OnClickListener bKn;
    private k bLb;
    private String bew;
    private LinearLayout blC;
    public ThreadCommentAndPraiseInfoLayout bly;
    public ConcernThreadUserInfoLayout cZZ;
    private TbImageView daa;
    private TextView dab;
    private LinearLayout dac;
    private TbPageContext<?> mF;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bew = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.bKn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.XL() != null) {
                    a.this.XL().a(view, a.this.bLb);
                }
                a.this.Yh();
            }
        };
        this.aou = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.XL() != null) {
                    a.this.XL().a(view, a.this.bLb);
                }
            }
        };
        this.aoc = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.XL() != null) {
                    a.this.XL().a(view, a.this.bLb);
                }
            }
        };
        View view = getView();
        this.mF = tbPageContext;
        this.bKh = (HeadPendantClickableView) view.findViewById(d.h.card_concern_ala_live_thread_user_pendant_header);
        if (this.bKh.getHeadView() != null) {
            this.bKh.getHeadView().setIsRound(true);
            this.bKh.getHeadView().setDrawBorder(false);
            this.bKh.getHeadView().setDefaultResource(17170445);
            this.bKh.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bKh.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bKh.getHeadView().setRadius(com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds60));
        }
        this.bKh.wB();
        if (this.bKh.getPendantView() != null) {
            this.bKh.getPendantView().setIsRound(true);
            this.bKh.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.h.card_concern_ala_live_thread_title);
        this.daa = (TbImageView) getView().findViewById(d.h.card_concern_ala_live_thread_live_image_view);
        this.daa.setDefaultErrorResource(0);
        this.daa.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.daa.setDrawerType(0);
        this.daa.setBorderSurroundContent(true);
        this.daa.setDrawBorder(true);
        this.dab = (TextView) getView().findViewById(d.h.card_concern_ala_live_thread_live_tip_tv);
        this.dac = (LinearLayout) getView().findViewById(d.h.card_concern_ala_live_thread_tip_layout);
        this.bKl = view.findViewById(d.h.divider_line);
        this.bly = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_concern_ala_live_thread_info_layout);
        this.cZZ = (ConcernThreadUserInfoLayout) view.findViewById(d.h.card_concern_ala_live_thread_user_info_layout);
        if (this.bly.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bly.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bly.setLayoutParams(layoutParams);
        }
        this.bly.setOnClickListener(this.bKn);
        this.bly.setReplyTimeVisible(false);
        this.bly.setIsBarViewVisible(false);
        this.bly.setShowPraiseNum(true);
        this.bly.setCommentNumEnable(false);
        this.bly.setNeedAddPraiseIcon(true);
        this.bly.setNeedAddReplyIcon(false);
        this.bly.setLiveAudienceEnable(true);
        this.bly.setLiveAudienceIcon(d.g.icon_home_card_live_n);
        this.bly.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bly.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.XL() != null) {
                    a.this.XL().a(view2, a.this.bLb);
                }
            }
        });
        this.blC = (LinearLayout) view.findViewById(d.h.card_concern_ala_live_thread_content_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.addresslist_item_bg);
            this.bly.onChangeSkinType();
            this.cZZ.onChangeSkinType();
            aj.k(this.bKl, d.e.cp_bg_line_c);
            aj.i(this.dab, d.e.cp_cont_i);
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
        this.bLb = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bKn);
        }
        this.cZZ.c(kVar.threadData);
        d(this.mF, TbadkCoreApplication.getInst().getSkinType());
        if (m.jv(this.bLb.threadData.getId())) {
            m.a(this.mTitle, this.bLb.MR().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        }
        this.cZZ.setUserAfterClickListener(this.aou);
        this.bly.c(kVar.threadData);
        this.mStType = m.rs();
        this.aob = "feed#" + kVar.Ym();
        bj MR = kVar.MR();
        if (this.cZZ.getHeaderImg() != null) {
            if (this.cZZ.getIsSimpleThread()) {
                this.cZZ.getHeaderImg().setVisibility(8);
                this.bKh.setVisibility(8);
            } else if (MR.getAuthor() == null || MR.getAuthor().getPendantData() == null || StringUtils.isNull(MR.getAuthor().getPendantData().pR())) {
                this.bKh.setVisibility(8);
                this.cZZ.getHeaderImg().setVisibility(0);
                this.cZZ.getHeaderImg().setData(MR);
            } else {
                this.cZZ.getHeaderImg().setVisibility(4);
                this.bKh.setVisibility(0);
                this.bKh.setData(MR);
            }
        }
        m.a(MR, this.mTitle);
        this.dab.setCompoundDrawablesWithIntrinsicBounds(d.g.icon_video_direct_seeding, 0, 0, 0);
        this.dab.setText(this.mContext.getResources().getString(d.l.live_in));
        this.daa.c(MR.rT().cover, 10, false);
        setPageUniqueId(getTag());
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cZZ != null) {
            this.cZZ.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cZZ != null) {
            return this.cZZ.aop;
        }
        return null;
    }

    public void Yh() {
        if (this.mF != null && this.bLb != null && this.bLb.threadData != null && this.bLb.threadData.getAuthor() != null && this.bLb.threadData.rT() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.bLb.threadData.getAuthor().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bLb.threadData.rT());
            alaLiveInfoCoreData.setUserName(this.bLb.threadData.getAuthor().getUserName());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mF.getPageActivity(), alaLiveInfoCoreData, this.bew, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
