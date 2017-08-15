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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<k> {
    private String aoG;
    private final View.OnClickListener aoH;
    private final View.OnClickListener aoX;
    private View.OnClickListener bGB;
    private HeadPendantClickableView bGv;
    private View bGz;
    private k bHq;
    private String beB;
    public ThreadCommentAndPraiseInfoLayout bld;
    private LinearLayout blh;
    public ConcernThreadUserInfoLayout cSG;
    private TbImageView cSH;
    private TextView cSI;
    private LinearLayout cSJ;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;
    private TbPageContext<?> oV;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.beB = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.bGB = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.WA() != null) {
                    a.this.WA().a(view, a.this.bHq);
                }
                a.this.WV();
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.WA() != null) {
                    a.this.WA().a(view, a.this.bHq);
                }
            }
        };
        this.aoH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.WA() != null) {
                    a.this.WA().a(view, a.this.bHq);
                }
            }
        };
        View view = getView();
        this.oV = tbPageContext;
        this.bGv = (HeadPendantClickableView) view.findViewById(d.h.card_concern_ala_live_thread_user_pendant_header);
        if (this.bGv.getHeadView() != null) {
            this.bGv.getHeadView().setIsRound(true);
            this.bGv.getHeadView().setDrawBorder(false);
            this.bGv.getHeadView().setDefaultResource(17170445);
            this.bGv.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bGv.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bGv.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds60));
        }
        this.bGv.wD();
        if (this.bGv.getPendantView() != null) {
            this.bGv.getPendantView().setIsRound(true);
            this.bGv.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.h.card_concern_ala_live_thread_title);
        this.cSH = (TbImageView) getView().findViewById(d.h.card_concern_ala_live_thread_live_image_view);
        this.cSH.setDefaultErrorResource(0);
        this.cSH.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.cSH.setDrawerType(0);
        this.cSH.setBorderSurroundContent(true);
        this.cSH.setDrawBorder(true);
        this.cSI = (TextView) getView().findViewById(d.h.card_concern_ala_live_thread_live_tip_tv);
        this.cSJ = (LinearLayout) getView().findViewById(d.h.card_concern_ala_live_thread_tip_layout);
        this.bGz = view.findViewById(d.h.divider_line);
        this.bld = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_concern_ala_live_thread_info_layout);
        this.cSG = (ConcernThreadUserInfoLayout) view.findViewById(d.h.card_concern_ala_live_thread_user_info_layout);
        if (this.bld.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bld.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bld.setLayoutParams(layoutParams);
        }
        this.bld.setOnClickListener(this.bGB);
        this.bld.setReplyTimeVisible(false);
        this.bld.setIsBarViewVisible(false);
        this.bld.setShowPraiseNum(true);
        this.bld.setCommentNumEnable(false);
        this.bld.setNeedAddPraiseIcon(true);
        this.bld.setNeedAddReplyIcon(false);
        this.bld.setLiveAudienceEnable(true);
        this.bld.setLiveAudienceIcon(d.g.icon_home_card_live_n);
        this.bld.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bld.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.WA() != null) {
                    a.this.WA().a(view2, a.this.bHq);
                }
            }
        });
        this.blh = (LinearLayout) view.findViewById(d.h.card_concern_ala_live_thread_content_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.addresslist_item_bg);
            this.bld.onChangeSkinType();
            this.cSG.onChangeSkinType();
            ai.k(this.bGz, d.e.cp_bg_line_c);
            ai.i(this.cSI, d.e.cp_cont_i);
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
        this.bHq = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bGB);
        }
        this.cSG.a(kVar.threadData);
        d(this.oV, TbadkCoreApplication.getInst().getSkinType());
        if (m.jf(this.bHq.threadData.getId())) {
            m.a(this.mTitle, this.bHq.MF().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        }
        this.cSG.setUserAfterClickListener(this.aoX);
        this.bld.a(kVar.threadData);
        this.mStType = m.rw();
        this.aoG = "feed#" + kVar.Xb();
        bl MF = kVar.MF();
        if (this.cSG.getHeaderImg() != null) {
            if (this.cSG.getIsSimpleThread()) {
                this.cSG.getHeaderImg().setVisibility(8);
                this.bGv.setVisibility(8);
            } else if (MF.getAuthor() == null || MF.getAuthor().getPendantData() == null || StringUtils.isNull(MF.getAuthor().getPendantData().pV())) {
                this.bGv.setVisibility(8);
                this.cSG.getHeaderImg().setVisibility(0);
                this.cSG.getHeaderImg().setData(MF);
            } else {
                this.cSG.getHeaderImg().setVisibility(4);
                this.bGv.setVisibility(0);
                this.bGv.setData(MF);
            }
        }
        m.a(MF, this.mTitle);
        this.cSI.setCompoundDrawablesWithIntrinsicBounds(d.g.icon_video_direct_seeding, 0, 0, 0);
        this.cSI.setText(this.mContext.getResources().getString(d.l.concern_live_tip));
        this.cSH.c(MF.rX().cover, 10, false);
        setPageUniqueId(getTag());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cSG != null) {
            this.cSG.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cSG != null) {
            return this.cSG.aoS;
        }
        return null;
    }

    public void WV() {
        if (this.oV != null && this.bHq != null && this.bHq.threadData != null && this.bHq.threadData.getAuthor() != null && this.bHq.threadData.rX() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.bHq.threadData.getAuthor().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bHq.threadData.rX());
            alaLiveInfoCoreData.setUserName(this.bHq.threadData.getAuthor().getUserName());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.oV.getPageActivity(), alaLiveInfoCoreData, this.beB, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
