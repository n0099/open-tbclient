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
    private final View.OnClickListener anJ;
    private String anq;
    private final View.OnClickListener anr;
    private View.OnClickListener bJA;
    private HeadPendantClickableView bJv;
    private View bJy;
    private k bKq;
    public ImageView bKu;
    private TextView bKv;
    private AlaPlayAnimationView bKx;
    private String bgj;
    public ThreadCommentAndPraiseInfoLayout bnj;
    private LinearLayout bnn;
    public ConcernThreadUserInfoLayout cWD;
    private TbImageView cWE;
    private TbPageContext<?> mG;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bgj = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.bJA = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.Xr() != null) {
                    a.this.Xr().a(view, a.this.bKq);
                }
                a.this.XP();
            }
        };
        this.anJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.Xr() != null) {
                    a.this.Xr().a(view, a.this.bKq);
                }
            }
        };
        this.anr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.Xr() != null) {
                    a.this.Xr().a(view, a.this.bKq);
                }
            }
        };
        View view = getView();
        this.mG = tbPageContext;
        this.bJv = (HeadPendantClickableView) view.findViewById(d.h.card_concern_ala_live_thread_user_pendant_header);
        if (this.bJv.getHeadView() != null) {
            this.bJv.getHeadView().setIsRound(true);
            this.bJv.getHeadView().setDrawBorder(false);
            this.bJv.getHeadView().setDefaultResource(17170445);
            this.bJv.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bJv.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bJv.getHeadView().setRadius(l.f(this.mG.getPageActivity(), d.f.ds60));
        }
        this.bJv.wg();
        if (this.bJv.getPendantView() != null) {
            this.bJv.getPendantView().setIsRound(true);
            this.bJv.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.h.card_concern_ala_live_thread_title);
        this.cWE = (TbImageView) getView().findViewById(d.h.card_concern_ala_live_thread_live_image_view);
        this.cWE.setDefaultErrorResource(0);
        this.cWE.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.cWE.setDrawerType(0);
        this.cWE.setBorderSurroundContent(true);
        this.cWE.setDrawBorder(true);
        this.bJy = view.findViewById(d.h.divider_line);
        this.bnj = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_concern_ala_live_thread_info_layout);
        this.cWD = (ConcernThreadUserInfoLayout) view.findViewById(d.h.card_concern_ala_live_thread_user_info_layout);
        if (this.bnj.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bnj.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bnj.setLayoutParams(layoutParams);
        }
        this.bnj.setOnClickListener(this.bJA);
        this.bnj.setReplyTimeVisible(false);
        this.bnj.setIsBarViewVisible(false);
        this.bnj.setShowPraiseNum(true);
        this.bnj.setCommentNumEnable(false);
        this.bnj.setNeedAddPraiseIcon(true);
        this.bnj.setNeedAddReplyIcon(false);
        this.bnj.setLiveAudienceEnable(false);
        this.bnj.setShareVisible(true);
        this.bnj.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.Xr() != null) {
                    a.this.Xr().a(view2, a.this.bKq);
                }
            }
        });
        this.bnn = (LinearLayout) view.findViewById(d.h.card_concern_ala_live_thread_content_layout);
        this.bKv = (TextView) getView().findViewById(d.h.play_count);
        this.bKu = (ImageView) view.findViewById(d.h.image_video_play);
        this.bKx = (AlaPlayAnimationView) view.findViewById(d.h.ala_play);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.addresslist_item_bg);
            this.bnj.onChangeSkinType();
            this.cWD.onChangeSkinType();
            aj.k(this.bJy, d.e.cp_bg_line_e);
            aj.i(this.bKv, d.e.cp_cont_i);
            aj.c(this.bKu, d.g.btn_icon_play_live_on_n);
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
        this.bKq = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bJA);
        }
        this.cWD.setData(kVar.threadData);
        d(this.mG, TbadkCoreApplication.getInst().getSkinType());
        if (m.jn(this.bKq.threadData.getId())) {
            m.a(this.mTitle, this.bKq.Nj().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        }
        this.cWD.setUserAfterClickListener(this.anJ);
        this.bnj.setData(kVar.threadData);
        this.mStType = m.rm();
        this.anq = "feed#" + kVar.XU();
        bh Nj = kVar.Nj();
        if (this.cWD.getHeaderImg() != null) {
            if (this.cWD.getIsSimpleThread()) {
                this.cWD.getHeaderImg().setVisibility(8);
                this.bJv.setVisibility(8);
            } else if (Nj.getAuthor() == null || Nj.getAuthor().getPendantData() == null || StringUtils.isNull(Nj.getAuthor().getPendantData().pS())) {
                this.bJv.setVisibility(8);
                this.cWD.getHeaderImg().setVisibility(0);
                this.cWD.getHeaderImg().setData(Nj);
            } else {
                this.cWD.getHeaderImg().setVisibility(4);
                this.bJv.setVisibility(0);
                this.bJv.setData(Nj);
            }
        }
        m.a(Nj, this.mTitle);
        this.cWE.c(Nj.rN().cover, 10, false);
        this.bKv.setText(String.format(this.mContext.getResources().getString(d.l.ala_audience_count_prefix), am.z(this.bKq.threadData.rN().audience_count)));
        setPageUniqueId(getTag());
        this.bKx.XT();
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cWD != null) {
            this.cWD.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cWD != null) {
            return this.cWD.anE;
        }
        return null;
    }

    public void XP() {
        if (this.mG != null && this.bKq != null && this.bKq.threadData != null && this.bKq.threadData.getAuthor() != null && this.bKq.threadData.rN() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.bKq.threadData.getAuthor().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bKq.threadData.rN());
            alaLiveInfoCoreData.setUserName(this.bKq.threadData.getAuthor().getUserName());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mG.getPageActivity(), alaLiveInfoCoreData, this.bgj, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
