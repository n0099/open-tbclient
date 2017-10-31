package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.a<n> {
    private TbPageContext<?> abI;
    private final View.OnClickListener anA;
    private View aom;
    private HeadPendantClickableView bQP;
    private ThreadGodReplyLayout bQQ;
    private TbImageView bRN;
    private ImageView bRO;
    private TextView bRP;
    public FrameLayout bRV;
    private TextView bRY;
    private LinearLayout bRZ;
    private n bSe;
    private TbImageView.a bSo;
    private final View.OnClickListener bSs;
    private final View.OnClickListener bSt;
    public ThreadCommentAndPraiseInfoLayout boD;
    private RelativeLayout boq;
    public ConcernThreadUserInfoLayout deG;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bSo = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && c.this.bRN != null) {
                    c.this.bRN.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bSs = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.Zx() != null) {
                    c.this.Zx().a(view, c.this.bSe);
                }
            }
        };
        this.bSt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.Zx() != null) {
                    c.this.Zx().a(view, c.this.bSe);
                }
            }
        };
        this.anA = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bSe != null && c.this.Zx() != null) {
                    c.this.Zx().a(view, c.this.bSe);
                }
            }
        };
        this.abI = tbPageContext;
        View view = getView();
        this.boq = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.bQP = (HeadPendantClickableView) this.boq.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.bQP.getHeadView() != null) {
            this.bQP.getHeadView().setIsRound(true);
            this.bQP.getHeadView().setDrawBorder(false);
            this.bQP.getHeadView().setDefaultResource(17170445);
            this.bQP.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bQP.getHeadView().setDefaultBgResource(d.C0080d.cp_bg_line_e);
            this.bQP.getHeadView().setRadius(l.f(this.abI.getPageActivity(), d.e.ds70));
        }
        if (this.bQP.getPendantView() != null) {
            this.bQP.getPendantView().setIsRound(true);
            this.bQP.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.deG = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_video_user_info_layout);
        this.boD = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.boD.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boD.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.boD.setLayoutParams(layoutParams);
        }
        this.boD.setOnClickListener(this);
        this.boD.setReplyTimeVisible(false);
        this.boD.setShowPraiseNum(true);
        this.boD.setIsBarViewVisible(false);
        this.boD.setNeedAddPraiseIcon(true);
        this.boD.setNeedAddReplyIcon(true);
        this.boD.setShareVisible(true);
        this.boD.setShareReportFrom(4);
        this.boD.setForumAfterClickListener(this.anA);
        this.boq.setOnClickListener(this);
        this.bRV = (FrameLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bRV.getLayoutParams();
        layoutParams2.width = l.ac(this.abI.getPageActivity()) - l.f(this.abI.getPageActivity(), d.e.ds68);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bRV.setLayoutParams(layoutParams2);
        this.bRN = (TbImageView) view.findViewById(d.g.image_video);
        this.bRN.setDefaultErrorResource(0);
        this.bRN.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.bRN.setGifIconSupport(false);
        this.bRN.setEvent(this.bSo);
        this.bRO = (ImageView) view.findViewById(d.g.image_video_play);
        this.bRY = (TextView) view.findViewById(d.g.text_video_duration);
        this.bRZ = (LinearLayout) view.findViewById(d.g.duration_container);
        this.bRP = (TextView) view.findViewById(d.g.text_video_play_count);
        this.aom = view.findViewById(d.g.divider_line);
        this.bQQ = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.bQQ.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.boq, d.f.addresslist_item_bg);
            aj.c(this.bRO, d.f.btn_icon_play_video_n);
            this.deG.onChangeSkinType();
            this.boD.onChangeSkinType();
            aj.j(this.aom, d.C0080d.cp_bg_line_e);
            aj.i(this.bRY, d.C0080d.cp_cont_i);
            aj.i(this.bRP, d.C0080d.cp_cont_i);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(n nVar) {
        this.bSe = nVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.boq || view == this.bQQ) {
            ag(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    private boolean ZB() {
        return this.bSe.bUY && !this.bSe.bVm;
    }

    private void ag(View view) {
        if (Zx() != null) {
            Zx().a(view, this.bSe);
        }
        if (this.bSe != null && this.bSe.beV != null) {
            if (!ZB()) {
                m.jK(this.bSe.beV.getId());
                m.a(this.mTextTitle, this.bSe.beV.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.abI.getPageActivity()).createFromThreadCfg(this.bSe.beV, null, m.rj(), 18003, true, false, false).addLocateParam(this.bSe.aab());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.bSe.beV.getFid()));
            addLocateParam.setForumName(this.bSe.beV.rz());
            if (this.bSe.bUF == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bSe.bUF);
            }
            if (view == this.bQQ) {
                addLocateParam.setJumpGodReply(true);
            }
            this.abI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void refreshView() {
        if (this.bSe == null || this.bSe.beV == null || this.bSe.beV.rt() == null || this.bSe.beV.rL() == null) {
            this.boq.setVisibility(8);
            return;
        }
        this.boq.setVisibility(0);
        ZK();
        if (!ZB() && m.jL(this.bSe.beV.getId())) {
            m.a(this.mTextTitle, this.bSe.beV.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
            m.a(this.bQQ.getGodReplyContent(), this.bSe.Np().getId(), d.C0080d.cp_cont_f, d.C0080d.cp_cont_d);
        }
        this.bSe.Np().sc();
        this.mTextTitle.setText(this.bSe.Np().rU());
        this.deG.setData(this.bSe.Np());
        this.deG.setUserAfterClickListener(this.bSs);
        if (this.deG.getHeaderImg() != null) {
            this.deG.getHeaderImg().setAfterClickListener(this.bSt);
            if (this.deG.getIsSimpleThread()) {
                this.deG.getHeaderImg().setVisibility(8);
                this.bQP.setVisibility(8);
            } else if (this.bSe.Np() == null || this.bSe.Np().rt() == null || this.bSe.Np().rt().getPendantData() == null || StringUtils.isNull(this.bSe.Np().rt().getPendantData().pQ())) {
                this.bQP.setVisibility(8);
                this.deG.getHeaderImg().setVisibility(0);
                this.deG.getHeaderImg().setData(this.bSe.Np());
            } else {
                this.deG.getHeaderImg().setVisibility(4);
                this.bQP.setVisibility(0);
                this.bQP.setData(this.bSe.Np());
            }
        }
        this.bRY.setText(am.cY(this.bSe.beV.rL().video_duration.intValue() * 1000));
        this.bRP.setText(String.format(this.abI.getResources().getString(d.j.play_count), am.A(this.bSe.beV.rL().play_count.intValue())));
        this.boD.setData(this.bSe.beV);
        this.bQQ.setData(this.bSe.Np().sL());
        this.bQQ.onChangeSkinType();
        d(this.abI, TbadkCoreApplication.getInst().getSkinType());
        if (m.jL(this.bSe.beV.getId())) {
            aj.c(this.mTextTitle, d.C0080d.cp_cont_d, 1);
        } else {
            aj.c(this.mTextTitle, d.C0080d.cp_cont_b, 1);
        }
    }

    private void ZK() {
        if (this.bRN != null && this.bRV != null) {
            if (h.oT().oZ() && this.bSe != null && this.bSe.beV != null && this.bSe.beV.rL() != null) {
                this.bRN.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.bRN.startLoad(this.bSe.beV.rL().thumbnail_url, 10, false);
                this.bRV.setVisibility(0);
                return;
            }
            this.bRV.setVisibility(8);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.deG != null) {
            this.deG.setPageUniqueId(bdUniqueId);
        }
        if (this.bRN != null) {
            this.bRN.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.deG != null) {
            return this.deG.getHeaderImg();
        }
        return null;
    }

    public View ZA() {
        if (this.deG != null) {
            return this.deG.anO;
        }
        return null;
    }
}
