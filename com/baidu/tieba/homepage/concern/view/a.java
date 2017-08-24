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
    private View bGA;
    private View.OnClickListener bGC;
    private HeadPendantClickableView bGw;
    private k bHr;
    private String beC;
    public ThreadCommentAndPraiseInfoLayout ble;
    private LinearLayout bli;
    public ConcernThreadUserInfoLayout cSG;
    private TbImageView cSH;
    private TextView cSI;
    private LinearLayout cSJ;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;
    private TbPageContext<?> oW;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.beC = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.bGC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.Wx() != null) {
                    a.this.Wx().a(view, a.this.bHr);
                }
                a.this.WS();
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.Wx() != null) {
                    a.this.Wx().a(view, a.this.bHr);
                }
            }
        };
        this.aoH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.Wx() != null) {
                    a.this.Wx().a(view, a.this.bHr);
                }
            }
        };
        View view = getView();
        this.oW = tbPageContext;
        this.bGw = (HeadPendantClickableView) view.findViewById(d.h.card_concern_ala_live_thread_user_pendant_header);
        if (this.bGw.getHeadView() != null) {
            this.bGw.getHeadView().setIsRound(true);
            this.bGw.getHeadView().setDrawBorder(false);
            this.bGw.getHeadView().setDefaultResource(17170445);
            this.bGw.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bGw.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bGw.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds60));
        }
        this.bGw.wE();
        if (this.bGw.getPendantView() != null) {
            this.bGw.getPendantView().setIsRound(true);
            this.bGw.getPendantView().setDrawBorder(false);
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
        this.bGA = view.findViewById(d.h.divider_line);
        this.ble = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_concern_ala_live_thread_info_layout);
        this.cSG = (ConcernThreadUserInfoLayout) view.findViewById(d.h.card_concern_ala_live_thread_user_info_layout);
        if (this.ble.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ble.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ble.setLayoutParams(layoutParams);
        }
        this.ble.setOnClickListener(this.bGC);
        this.ble.setReplyTimeVisible(false);
        this.ble.setIsBarViewVisible(false);
        this.ble.setShowPraiseNum(true);
        this.ble.setCommentNumEnable(false);
        this.ble.setNeedAddPraiseIcon(true);
        this.ble.setNeedAddReplyIcon(false);
        this.ble.setLiveAudienceEnable(true);
        this.ble.setLiveAudienceIcon(d.g.icon_home_card_live_n);
        this.ble.setReplyIcon(d.g.icon_home_card_comment_n);
        this.ble.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.Wx() != null) {
                    a.this.Wx().a(view2, a.this.bHr);
                }
            }
        });
        this.bli = (LinearLayout) view.findViewById(d.h.card_concern_ala_live_thread_content_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.addresslist_item_bg);
            this.ble.onChangeSkinType();
            this.cSG.onChangeSkinType();
            ai.k(this.bGA, d.e.cp_bg_line_c);
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
        this.bHr = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bGC);
        }
        this.cSG.a(kVar.threadData);
        d(this.oW, TbadkCoreApplication.getInst().getSkinType());
        if (m.ji(this.bHr.threadData.getId())) {
            m.a(this.mTitle, this.bHr.MF().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        }
        this.cSG.setUserAfterClickListener(this.aoX);
        this.ble.a(kVar.threadData);
        this.mStType = m.rx();
        this.aoG = "feed#" + kVar.WY();
        bl MF = kVar.MF();
        if (this.cSG.getHeaderImg() != null) {
            if (this.cSG.getIsSimpleThread()) {
                this.cSG.getHeaderImg().setVisibility(8);
                this.bGw.setVisibility(8);
            } else if (MF.getAuthor() == null || MF.getAuthor().getPendantData() == null || StringUtils.isNull(MF.getAuthor().getPendantData().pW())) {
                this.bGw.setVisibility(8);
                this.cSG.getHeaderImg().setVisibility(0);
                this.cSG.getHeaderImg().setData(MF);
            } else {
                this.cSG.getHeaderImg().setVisibility(4);
                this.bGw.setVisibility(0);
                this.bGw.setData(MF);
            }
        }
        m.a(MF, this.mTitle);
        this.cSI.setCompoundDrawablesWithIntrinsicBounds(d.g.icon_video_direct_seeding, 0, 0, 0);
        this.cSI.setText(this.mContext.getResources().getString(d.l.concern_live_tip));
        this.cSH.c(MF.rY().cover, 10, false);
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

    public void WS() {
        if (this.oW != null && this.bHr != null && this.bHr.threadData != null && this.bHr.threadData.getAuthor() != null && this.bHr.threadData.rY() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.bHr.threadData.getAuthor().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bHr.threadData.rY());
            alaLiveInfoCoreData.setUserName(this.bHr.threadData.getAuthor().getUserName());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.oW.getPageActivity(), alaLiveInfoCoreData, this.beC, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
