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
    private final View.OnClickListener anA;
    private final View.OnClickListener anS;
    private String anz;
    private HeadPendantClickableView bQP;
    private View bQS;
    private View.OnClickListener bQU;
    private k bRK;
    public ImageView bRO;
    private TextView bRP;
    private AlaPlayAnimationView bRR;
    private String bgM;
    public ThreadCommentAndPraiseInfoLayout boD;
    private LinearLayout boH;
    public ConcernThreadUserInfoLayout deG;
    private TbImageView deH;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bgM = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB;
        this.bQU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.Zx() != null) {
                    a.this.Zx().a(view, a.this.bRK);
                }
                a.this.ZV();
            }
        };
        this.anS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.Zx() != null) {
                    a.this.Zx().a(view, a.this.bRK);
                }
            }
        };
        this.anA = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.Zx() != null) {
                    a.this.Zx().a(view, a.this.bRK);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.bQP = (HeadPendantClickableView) view.findViewById(d.g.card_concern_ala_live_thread_user_pendant_header);
        if (this.bQP.getHeadView() != null) {
            this.bQP.getHeadView().setIsRound(true);
            this.bQP.getHeadView().setDrawBorder(false);
            this.bQP.getHeadView().setDefaultResource(17170445);
            this.bQP.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bQP.getHeadView().setDefaultBgResource(d.C0080d.cp_bg_line_e);
            this.bQP.getHeadView().setRadius(l.f(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        this.bQP.wg();
        if (this.bQP.getPendantView() != null) {
            this.bQP.getPendantView().setIsRound(true);
            this.bQP.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_ala_live_thread_title);
        this.deH = (TbImageView) getView().findViewById(d.g.card_concern_ala_live_thread_live_image_view);
        this.deH.setDefaultErrorResource(0);
        this.deH.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.deH.setDrawerType(0);
        this.deH.setBorderSurroundContent(true);
        this.deH.setDrawBorder(true);
        this.bQS = view.findViewById(d.g.divider_line);
        this.boD = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_info_layout);
        this.deG = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_ala_live_thread_user_info_layout);
        if (this.boD.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boD.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.boD.setLayoutParams(layoutParams);
        }
        this.boD.setOnClickListener(this.bQU);
        this.boD.setReplyTimeVisible(false);
        this.boD.setIsBarViewVisible(false);
        this.boD.setShowPraiseNum(true);
        this.boD.setCommentNumEnable(false);
        this.boD.setNeedAddPraiseIcon(true);
        this.boD.setNeedAddReplyIcon(false);
        this.boD.setLiveAudienceEnable(false);
        this.boD.setShareVisible(true);
        this.boD.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.Zx() != null) {
                    a.this.Zx().a(view2, a.this.bRK);
                }
            }
        });
        this.boH = (LinearLayout) view.findViewById(d.g.card_concern_ala_live_thread_content_layout);
        this.bRP = (TextView) getView().findViewById(d.g.play_count);
        this.bRO = (ImageView) view.findViewById(d.g.image_video_play);
        this.bRR = (AlaPlayAnimationView) view.findViewById(d.g.ala_play);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            this.boD.onChangeSkinType();
            this.deG.onChangeSkinType();
            aj.k(this.bQS, d.C0080d.cp_bg_line_e);
            aj.i(this.bRP, d.C0080d.cp_cont_i);
            aj.c(this.bRO, d.f.btn_icon_play_live_on_n);
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
        if (kVar == null || kVar.blk == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bRK = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bQU);
        }
        this.deG.setData(kVar.blk);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (m.jL(this.bRK.blk.getId())) {
            m.a(this.mTitle, this.bRK.Np().getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
        }
        this.deG.setUserAfterClickListener(this.anS);
        this.boD.setData(kVar.blk);
        this.mStType = m.rj();
        this.anz = "feed#" + kVar.aaa();
        bh Np = kVar.Np();
        if (this.deG.getHeaderImg() != null) {
            if (this.deG.getIsSimpleThread()) {
                this.deG.getHeaderImg().setVisibility(8);
                this.bQP.setVisibility(8);
            } else if (Np.rt() == null || Np.rt().getPendantData() == null || StringUtils.isNull(Np.rt().getPendantData().pQ())) {
                this.bQP.setVisibility(8);
                this.deG.getHeaderImg().setVisibility(0);
                this.deG.getHeaderImg().setData(Np);
            } else {
                this.deG.getHeaderImg().setVisibility(4);
                this.bQP.setVisibility(0);
                this.bQP.setData(Np);
            }
        }
        m.a(Np, this.mTitle);
        this.deH.startLoad(Np.rM().cover, 10, false);
        this.bRP.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), am.A(this.bRK.blk.rM().audience_count)));
        setPageUniqueId(getTag());
        this.bRR.ZZ();
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.deG != null) {
            this.deG.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.deG != null) {
            return this.deG.anN;
        }
        return null;
    }

    public void ZV() {
        if (this.mPageContext != null && this.bRK != null && this.bRK.blk != null && this.bRK.blk.rt() != null && this.bRK.blk.rM() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = this.bRK.blk.rt().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bRK.blk.rM());
            alaLiveInfoCoreData.userName = this.bRK.blk.rt().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, this.bgM, str, z, "")));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
