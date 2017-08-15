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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
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
    private TbPageContext<?> acr;
    private final View.OnClickListener aoH;
    public FrameLayout bEI;
    private TbImageView bEJ;
    private ImageView bEK;
    private TbImageView.a bEM;
    private HeadPendantClickableView bGv;
    private ThreadGodReplyLayout bGw;
    private View bGx;
    private n bHD;
    private final View.OnClickListener bHP;
    private final View.OnClickListener bHQ;
    private TextView bHx;
    private View bhj;
    private RelativeLayout bkQ;
    public ThreadCommentAndPraiseInfoLayout bld;
    public ConcernThreadUserInfoLayout cSG;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bEM = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && c.this.bEJ != null) {
                    c.this.bEJ.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bHP = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.WA() != null) {
                    c.this.WA().a(view, c.this.bHD);
                }
            }
        };
        this.bHQ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.WA() != null) {
                    c.this.WA().a(view, c.this.bHD);
                }
            }
        };
        this.aoH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bHD != null && c.this.WA() != null) {
                    c.this.WA().a(view, c.this.bHD);
                }
            }
        };
        this.acr = tbPageContext;
        View view = getView();
        this.bkQ = (RelativeLayout) view.findViewById(d.h.layout_root);
        this.bGv = (HeadPendantClickableView) this.bkQ.findViewById(d.h.card_home_page_video_user_pendant_header);
        if (this.bGv.getHeadView() != null) {
            this.bGv.getHeadView().setIsRound(true);
            this.bGv.getHeadView().setDrawBorder(false);
            this.bGv.getHeadView().setDefaultResource(17170445);
            this.bGv.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bGv.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bGv.getHeadView().setRadius(k.g(this.acr.getPageActivity(), d.f.ds70));
        }
        if (this.bGv.getPendantView() != null) {
            this.bGv.getPendantView().setIsRound(true);
            this.bGv.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.cSG = (ConcernThreadUserInfoLayout) view.findViewById(d.h.card_concern_video_user_info_layout);
        this.bld = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        if (this.bld.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bld.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bld.setLayoutParams(layoutParams);
        }
        this.bld.setOnClickListener(this);
        this.bld.setReplyTimeVisible(false);
        this.bld.setShowPraiseNum(true);
        this.bld.setIsBarViewVisible(false);
        this.bld.setNeedAddPraiseIcon(true);
        this.bld.setNeedAddReplyIcon(true);
        this.bld.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bld.setForumAfterClickListener(this.aoH);
        this.bGx = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bkQ.setOnClickListener(this);
        this.bEI = (FrameLayout) view.findViewById(d.h.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bEI.getLayoutParams();
        layoutParams2.width = k.ag(this.acr.getPageActivity()) - k.g(this.acr.getPageActivity(), d.f.ds68);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bEI.setLayoutParams(layoutParams2);
        this.bEJ = (TbImageView) view.findViewById(d.h.image_video);
        this.bEJ.setDefaultErrorResource(0);
        this.bEJ.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bEJ.setGifIconSupport(false);
        this.bEJ.setEvent(this.bEM);
        this.bEK = (ImageView) view.findViewById(d.h.image_video_play);
        this.bHx = (TextView) view.findViewById(d.h.text_video_duration);
        this.bhj = view.findViewById(d.h.divider_line);
        this.bGw = (ThreadGodReplyLayout) view.findViewById(d.h.card_god_reply_layout);
        this.bGw.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.bkQ, d.g.addresslist_item_bg);
            ai.c(this.bEK, d.g.home_ic_video);
            this.cSG.onChangeSkinType();
            this.bld.onChangeSkinType();
            ai.j(this.bhj, d.e.cp_bg_line_c);
            ai.i(this.bHx, d.e.cp_cont_i);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(n nVar) {
        this.bHD = nVar;
        Oy();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bkQ || view == this.bGw) {
            X(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    private boolean WE() {
        return this.bHD.bKr && !this.bHD.bKF;
    }

    private void X(View view) {
        if (WA() != null) {
            WA().a(view, this.bHD);
        }
        if (this.bHD != null && this.bHD.bcM != null) {
            if (!WE()) {
                m.je(this.bHD.bcM.getId());
                m.a(this.mTextTitle, this.bHD.bcM.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.acr.getPageActivity()).createFromThreadCfg(this.bHD.bcM, null, m.rw(), 18003, true, false, false).addLocateParam(this.bHD.Xc());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.bHD.bcM.getFid()));
            addLocateParam.setForumName(this.bHD.bcM.rK());
            if (this.bHD.bJZ == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bHD.bJZ);
            }
            if (view == this.bGw) {
                addLocateParam.setJumpGodReply(true);
            }
            this.acr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void Oy() {
        if (this.bHD == null || this.bHD.bcM == null || this.bHD.bcM.getAuthor() == null || this.bHD.bcM.rW() == null) {
            this.bkQ.setVisibility(8);
            return;
        }
        this.bkQ.setVisibility(0);
        WM();
        if (!WE() && m.jf(this.bHD.bcM.getId())) {
            m.a(this.mTextTitle, this.bHD.bcM.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bGw.getGodReplyContent(), this.bHD.MF().getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bGw.getPraiseNum(), this.bHD.MF().getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.bHD.MF().sn();
        this.mTextTitle.setText(this.bHD.MF().sf());
        this.cSG.a(this.bHD.MF());
        this.cSG.setUserAfterClickListener(this.bHP);
        if (this.cSG.getHeaderImg() != null) {
            this.cSG.getHeaderImg().setAfterClickListener(this.bHQ);
            if (this.cSG.getIsSimpleThread()) {
                this.cSG.getHeaderImg().setVisibility(8);
                this.bGv.setVisibility(8);
            } else if (this.bHD.MF() == null || this.bHD.MF().getAuthor() == null || this.bHD.MF().getAuthor().getPendantData() == null || StringUtils.isNull(this.bHD.MF().getAuthor().getPendantData().pV())) {
                this.bGv.setVisibility(8);
                this.cSG.getHeaderImg().setVisibility(0);
                this.cSG.getHeaderImg().setData(this.bHD.MF());
            } else {
                this.cSG.getHeaderImg().setVisibility(4);
                this.bGv.setVisibility(0);
                this.bGv.setData(this.bHD.MF());
            }
        }
        this.bHx.setText(al.cZ(this.bHD.bcM.rW().video_duration.intValue() * 1000));
        if (this.bld.a(this.bHD.bcM)) {
            this.bGx.setVisibility(8);
        } else {
            this.bGx.setVisibility(0);
        }
        this.bGw.setData(this.bHD.MF().sU());
        this.bGw.onChangeSkinType();
        if (this.bGw.getVisibility() == 0) {
            this.bGx.setVisibility(0);
        }
        d(this.acr, TbadkCoreApplication.getInst().getSkinType());
        if (m.jf(this.bHD.bcM.getId())) {
            ai.c(this.mTextTitle, d.e.cp_cont_d, 1);
        } else {
            ai.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
    }

    private void WM() {
        if (this.bEJ != null && this.bEI != null) {
            if (h.oX().pd() && this.bHD != null && this.bHD.bcM != null && this.bHD.bcM.rW() != null) {
                this.bEJ.setDefaultBgResource(d.g.pic_bg_video_frs);
                this.bEJ.c(this.bHD.bcM.rW().thumbnail_url, 10, false);
                this.bEI.setVisibility(0);
                return;
            }
            this.bEI.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cSG != null) {
            this.cSG.setPageUniqueId(bdUniqueId);
        }
        if (this.bEJ != null) {
            this.bEJ.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cSG != null) {
            return this.cSG.getHeaderImg();
        }
        return null;
    }

    public View WD() {
        if (this.cSG != null) {
            return this.cSG.aoT;
        }
        return null;
    }
}
