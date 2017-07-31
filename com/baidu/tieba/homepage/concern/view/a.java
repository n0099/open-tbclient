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
    private TbPageContext<?> alI;
    private String aoF;
    private final View.OnClickListener aoG;
    private final View.OnClickListener aoW;
    private HeadPendantClickableView bFM;
    private View bFQ;
    private View.OnClickListener bFS;
    private k bGH;
    private String beA;
    public ThreadCommentAndPraiseInfoLayout bkZ;
    private LinearLayout bld;
    public ConcernThreadUserInfoLayout cQH;
    private TbImageView cQI;
    private TextView cQJ;
    private LinearLayout cQK;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.beA = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.bFS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.We() != null) {
                    a.this.We().a(view, a.this.bGH);
                }
                a.this.Wz();
            }
        };
        this.aoW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.We() != null) {
                    a.this.We().a(view, a.this.bGH);
                }
            }
        };
        this.aoG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.We() != null) {
                    a.this.We().a(view, a.this.bGH);
                }
            }
        };
        View view = getView();
        this.alI = tbPageContext;
        this.bFM = (HeadPendantClickableView) view.findViewById(d.h.card_concern_ala_live_thread_user_pendant_header);
        if (this.bFM.getHeadView() != null) {
            this.bFM.getHeadView().setIsRound(true);
            this.bFM.getHeadView().setDrawBorder(false);
            this.bFM.getHeadView().setDefaultResource(17170445);
            this.bFM.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bFM.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bFM.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds60));
        }
        this.bFM.wD();
        if (this.bFM.getPendantView() != null) {
            this.bFM.getPendantView().setIsRound(true);
            this.bFM.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.h.card_concern_ala_live_thread_title);
        this.cQI = (TbImageView) getView().findViewById(d.h.card_concern_ala_live_thread_live_image_view);
        this.cQI.setDefaultErrorResource(0);
        this.cQI.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.cQI.setDrawerType(0);
        this.cQI.setBorderSurroundContent(true);
        this.cQI.setDrawBorder(true);
        this.cQJ = (TextView) getView().findViewById(d.h.card_concern_ala_live_thread_live_tip_tv);
        this.cQK = (LinearLayout) getView().findViewById(d.h.card_concern_ala_live_thread_tip_layout);
        this.bFQ = view.findViewById(d.h.divider_line);
        this.bkZ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_concern_ala_live_thread_info_layout);
        this.cQH = (ConcernThreadUserInfoLayout) view.findViewById(d.h.card_concern_ala_live_thread_user_info_layout);
        if (this.bkZ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bkZ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bkZ.setLayoutParams(layoutParams);
        }
        this.bkZ.setOnClickListener(this.bFS);
        this.bkZ.setReplyTimeVisible(false);
        this.bkZ.setIsBarViewVisible(false);
        this.bkZ.setShowPraiseNum(true);
        this.bkZ.setCommentNumEnable(false);
        this.bkZ.setNeedAddPraiseIcon(true);
        this.bkZ.setNeedAddReplyIcon(false);
        this.bkZ.setLiveAudienceEnable(true);
        this.bkZ.setLiveAudienceIcon(d.g.icon_home_card_live_n);
        this.bkZ.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bkZ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.We() != null) {
                    a.this.We().a(view2, a.this.bGH);
                }
            }
        });
        this.bld = (LinearLayout) view.findViewById(d.h.card_concern_ala_live_thread_content_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.addresslist_item_bg);
            this.bkZ.onChangeSkinType();
            this.cQH.onChangeSkinType();
            ai.k(this.bFQ, d.e.cp_bg_line_c);
            ai.i(this.cQJ, d.e.cp_cont_i);
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
        this.bGH = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bFS);
        }
        this.cQH.a(kVar.threadData);
        d(this.alI, TbadkCoreApplication.getInst().getSkinType());
        if (m.je(this.bGH.threadData.getId())) {
            m.a(this.mTitle, this.bGH.MF().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        }
        this.cQH.setUserAfterClickListener(this.aoW);
        this.bkZ.a(kVar.threadData);
        this.mStType = m.rw();
        this.aoF = "feed#" + kVar.WF();
        bl MF = kVar.MF();
        if (this.cQH.getHeaderImg() != null) {
            if (this.cQH.getIsSimpleThread()) {
                this.cQH.getHeaderImg().setVisibility(8);
                this.bFM.setVisibility(8);
            } else if (MF.getAuthor() == null || MF.getAuthor().getPendantData() == null || StringUtils.isNull(MF.getAuthor().getPendantData().pV())) {
                this.bFM.setVisibility(8);
                this.cQH.getHeaderImg().setVisibility(0);
                this.cQH.getHeaderImg().setData(MF);
            } else {
                this.cQH.getHeaderImg().setVisibility(4);
                this.bFM.setVisibility(0);
                this.bFM.setData(MF);
            }
        }
        m.a(MF, this.mTitle);
        this.cQJ.setCompoundDrawablesWithIntrinsicBounds(d.g.icon_video_direct_seeding, 0, 0, 0);
        this.cQJ.setText(this.mContext.getResources().getString(d.l.concern_live_tip));
        this.cQI.c(MF.rX().cover, 10, false);
        setPageUniqueId(getTag());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cQH != null) {
            this.cQH.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cQH != null) {
            return this.cQH.aoR;
        }
        return null;
    }

    public void Wz() {
        if (this.alI != null && this.bGH != null && this.bGH.threadData != null && this.bGH.threadData.getAuthor() != null && this.bGH.threadData.rX() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.bGH.threadData.getAuthor().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bGH.threadData.rX());
            alaLiveInfoCoreData.setUserName(this.bGH.threadData.getAuthor().getUserName());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.alI.getPageActivity(), alaLiveInfoCoreData, this.beA, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
