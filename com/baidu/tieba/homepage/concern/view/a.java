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
    private final View.OnClickListener anR;
    private String any;
    private final View.OnClickListener anz;
    private k bRX;
    private HeadPendantClickableView bRc;
    private View bRf;
    private View.OnClickListener bRh;
    public ImageView bSb;
    private TextView bSc;
    private AlaPlayAnimationView bSe;
    private String bgV;
    public ThreadCommentAndPraiseInfoLayout boM;
    private LinearLayout boQ;
    public ConcernThreadUserInfoLayout dfa;
    private TbImageView dfb;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bgV = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.bRh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ZJ() != null) {
                    a.this.ZJ().a(view, a.this.bRX);
                }
                a.this.aah();
            }
        };
        this.anR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ZJ() != null) {
                    a.this.ZJ().a(view, a.this.bRX);
                }
            }
        };
        this.anz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ZJ() != null) {
                    a.this.ZJ().a(view, a.this.bRX);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.bRc = (HeadPendantClickableView) view.findViewById(d.g.card_concern_ala_live_thread_user_pendant_header);
        if (this.bRc.getHeadView() != null) {
            this.bRc.getHeadView().setIsRound(true);
            this.bRc.getHeadView().setDrawBorder(false);
            this.bRc.getHeadView().setDefaultResource(17170445);
            this.bRc.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bRc.getHeadView().setDefaultBgResource(d.C0080d.cp_bg_line_e);
            this.bRc.getHeadView().setRadius(l.f(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        this.bRc.wg();
        if (this.bRc.getPendantView() != null) {
            this.bRc.getPendantView().setIsRound(true);
            this.bRc.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_ala_live_thread_title);
        this.dfb = (TbImageView) getView().findViewById(d.g.card_concern_ala_live_thread_live_image_view);
        this.dfb.setDefaultErrorResource(0);
        this.dfb.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.dfb.setDrawerType(0);
        this.dfb.setBorderSurroundContent(true);
        this.dfb.setDrawBorder(true);
        this.bRf = view.findViewById(d.g.divider_line);
        this.boM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_info_layout);
        this.dfa = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_user_info_layout);
        if (this.boM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.boM.setLayoutParams(layoutParams);
        }
        this.boM.setOnClickListener(this.bRh);
        this.boM.setReplyTimeVisible(false);
        this.boM.setIsBarViewVisible(false);
        this.boM.setShowPraiseNum(true);
        this.boM.setCommentNumEnable(false);
        this.boM.setNeedAddPraiseIcon(true);
        this.boM.setNeedAddReplyIcon(false);
        this.boM.setLiveAudienceEnable(false);
        this.boM.setShareVisible(true);
        this.boM.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.ZJ() != null) {
                    a.this.ZJ().a(view2, a.this.bRX);
                }
            }
        });
        this.boQ = (LinearLayout) view.findViewById(d.g.card_concern_ala_live_thread_content_layout);
        this.bSc = (TextView) getView().findViewById(d.g.play_count);
        this.bSb = (ImageView) view.findViewById(d.g.image_video_play);
        this.bSe = (AlaPlayAnimationView) view.findViewById(d.g.ala_play);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            this.boM.onChangeSkinType();
            this.dfa.onChangeSkinType();
            aj.k(this.bRf, d.C0080d.cp_bg_line_e);
            aj.i(this.bSc, d.C0080d.cp_cont_i);
            aj.c(this.bSb, d.f.btn_icon_play_live_on_n);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_concern_ala_live_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(k kVar) {
        if (kVar == null || kVar.blt == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bRX = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bRh);
        }
        this.dfa.setData(kVar.blt);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (m.jM(this.bRX.blt.getId())) {
            m.a(this.mTitle, this.bRX.NA().getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
        }
        this.dfa.setUserAfterClickListener(this.anR);
        this.boM.setData(kVar.blt);
        this.mStType = m.rj();
        this.any = "feed#" + kVar.aam();
        bh NA = kVar.NA();
        if (this.dfa.getHeaderImg() != null) {
            if (this.dfa.getIsSimpleThread()) {
                this.dfa.getHeaderImg().setVisibility(8);
                this.bRc.setVisibility(8);
            } else if (NA.rt() == null || NA.rt().getPendantData() == null || StringUtils.isNull(NA.rt().getPendantData().pQ())) {
                this.bRc.setVisibility(8);
                this.dfa.getHeaderImg().setVisibility(0);
                this.dfa.getHeaderImg().setData(NA);
            } else {
                this.dfa.getHeaderImg().setVisibility(4);
                this.bRc.setVisibility(0);
                this.bRc.setData(NA);
            }
        }
        m.a(NA, this.mTitle);
        this.dfb.startLoad(NA.rM().cover, 10, false);
        this.bSc.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), am.A(this.bRX.blt.rM().audience_count)));
        setPageUniqueId(getTag());
        this.bSe.aal();
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.dfa != null) {
            this.dfa.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dfa != null) {
            return this.dfa.anM;
        }
        return null;
    }

    public void aah() {
        if (this.mPageContext != null && this.bRX != null && this.bRX.blt != null && this.bRX.blt.rt() != null && this.bRX.blt.rM() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.bRX.blt.rt().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bRX.blt.rM());
            alaLiveInfoCoreData.userName = this.bRX.blt.rt().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, this.bgV, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
