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
    private TbPageContext<?> ako;
    private final View.OnClickListener anD;
    private String anm;
    private final View.OnClickListener ann;
    private HeadPendantClickableView bEC;
    private View bEG;
    private View.OnClickListener bEI;
    private k bFx;
    private String bdp;
    public ThreadCommentAndPraiseInfoLayout bjP;
    private LinearLayout bjT;
    public ConcernThreadUserInfoLayout cPo;
    private TbImageView cPp;
    private TextView cPq;
    private LinearLayout cPr;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bdp = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.bEI = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.VZ() != null) {
                    a.this.VZ().a(view, a.this.bFx);
                }
                a.this.Wu();
            }
        };
        this.anD = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.VZ() != null) {
                    a.this.VZ().a(view, a.this.bFx);
                }
            }
        };
        this.ann = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.VZ() != null) {
                    a.this.VZ().a(view, a.this.bFx);
                }
            }
        };
        View view = getView();
        this.ako = tbPageContext;
        this.bEC = (HeadPendantClickableView) view.findViewById(d.h.card_concern_ala_live_thread_user_pendant_header);
        if (this.bEC.getHeadView() != null) {
            this.bEC.getHeadView().setIsRound(true);
            this.bEC.getHeadView().setDrawBorder(false);
            this.bEC.getHeadView().setDefaultResource(17170445);
            this.bEC.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bEC.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bEC.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds60));
        }
        this.bEC.wt();
        if (this.bEC.getPendantView() != null) {
            this.bEC.getPendantView().setIsRound(true);
            this.bEC.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.h.card_concern_ala_live_thread_title);
        this.cPp = (TbImageView) getView().findViewById(d.h.card_concern_ala_live_thread_live_image_view);
        this.cPp.setDefaultErrorResource(0);
        this.cPp.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.cPp.setDrawerType(0);
        this.cPp.setBorderSurroundContent(true);
        this.cPp.setDrawBorder(true);
        this.cPq = (TextView) getView().findViewById(d.h.card_concern_ala_live_thread_live_tip_tv);
        this.cPr = (LinearLayout) getView().findViewById(d.h.card_concern_ala_live_thread_tip_layout);
        this.bEG = view.findViewById(d.h.divider_line);
        this.bjP = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_concern_ala_live_thread_info_layout);
        this.cPo = (ConcernThreadUserInfoLayout) view.findViewById(d.h.card_concern_ala_live_thread_user_info_layout);
        if (this.bjP.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bjP.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bjP.setLayoutParams(layoutParams);
        }
        this.bjP.setOnClickListener(this.bEI);
        this.bjP.setReplyTimeVisible(false);
        this.bjP.setIsBarViewVisible(false);
        this.bjP.setShowPraiseNum(true);
        this.bjP.setCommentNumEnable(false);
        this.bjP.setNeedAddPraiseIcon(true);
        this.bjP.setNeedAddReplyIcon(false);
        this.bjP.setLiveAudienceEnable(true);
        this.bjP.setLiveAudienceIcon(d.g.icon_home_card_live_n);
        this.bjP.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bjP.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.VZ() != null) {
                    a.this.VZ().a(view2, a.this.bFx);
                }
            }
        });
        this.bjT = (LinearLayout) view.findViewById(d.h.card_concern_ala_live_thread_content_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.addresslist_item_bg);
            this.bjP.onChangeSkinType();
            this.cPo.onChangeSkinType();
            ai.k(this.bEG, d.e.cp_bg_line_c);
            ai.i(this.cPq, d.e.cp_cont_i);
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
        this.bFx = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bEI);
        }
        this.cPo.a(kVar.threadData);
        d(this.ako, TbadkCoreApplication.getInst().getSkinType());
        if (m.iZ(this.bFx.threadData.getId())) {
            m.a(this.mTitle, this.bFx.MA().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        }
        this.cPo.setUserAfterClickListener(this.anD);
        this.bjP.a(kVar.threadData);
        this.mStType = m.rm();
        this.anm = "feed#" + kVar.WA();
        bl MA = kVar.MA();
        if (this.cPo.getHeaderImg() != null) {
            if (this.cPo.getIsSimpleThread()) {
                this.cPo.getHeaderImg().setVisibility(8);
                this.bEC.setVisibility(8);
            } else if (MA.getAuthor() == null || MA.getAuthor().getPendantData() == null || StringUtils.isNull(MA.getAuthor().getPendantData().pL())) {
                this.bEC.setVisibility(8);
                this.cPo.getHeaderImg().setVisibility(0);
                this.cPo.getHeaderImg().setData(MA);
            } else {
                this.cPo.getHeaderImg().setVisibility(4);
                this.bEC.setVisibility(0);
                this.bEC.setData(MA);
            }
        }
        m.a(MA, this.mTitle);
        this.cPq.setCompoundDrawablesWithIntrinsicBounds(d.g.icon_video_direct_seeding, 0, 0, 0);
        this.cPq.setText(this.mContext.getResources().getString(d.l.concern_live_tip));
        this.cPp.c(MA.rN().cover, 10, false);
        setPageUniqueId(getTag());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cPo != null) {
            this.cPo.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cPo != null) {
            return this.cPo.any;
        }
        return null;
    }

    public void Wu() {
        if (this.ako != null && this.bFx != null && this.bFx.threadData != null && this.bFx.threadData.getAuthor() != null && this.bFx.threadData.rN() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.bFx.threadData.getAuthor().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bFx.threadData.rN());
            alaLiveInfoCoreData.setUserName(this.bFx.threadData.getAuthor().getUserName());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.ako.getPageActivity(), alaLiveInfoCoreData, this.bdp, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
