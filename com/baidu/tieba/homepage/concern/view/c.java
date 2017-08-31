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
    private TbPageContext<?> aby;
    private final View.OnClickListener aoe;
    public FrameLayout bHD;
    private TbImageView bHE;
    private ImageView bHF;
    private TbImageView.a bHH;
    private HeadPendantClickableView bJq;
    private ThreadGodReplyLayout bJr;
    private View bJs;
    private final View.OnClickListener bKK;
    private final View.OnClickListener bKL;
    private TextView bKs;
    private n bKy;
    private View bhp;
    private RelativeLayout blm;
    public ThreadCommentAndPraiseInfoLayout blz;
    public ConcernThreadUserInfoLayout cZf;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bHH = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && c.this.bHE != null) {
                    c.this.bHE.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bKK = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.XA() != null) {
                    c.this.XA().a(view, c.this.bKy);
                }
            }
        };
        this.bKL = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.XA() != null) {
                    c.this.XA().a(view, c.this.bKy);
                }
            }
        };
        this.aoe = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bKy != null && c.this.XA() != null) {
                    c.this.XA().a(view, c.this.bKy);
                }
            }
        };
        this.aby = tbPageContext;
        View view = getView();
        this.blm = (RelativeLayout) view.findViewById(d.h.layout_root);
        this.bJq = (HeadPendantClickableView) this.blm.findViewById(d.h.card_home_page_video_user_pendant_header);
        if (this.bJq.getHeadView() != null) {
            this.bJq.getHeadView().setIsRound(true);
            this.bJq.getHeadView().setDrawBorder(false);
            this.bJq.getHeadView().setDefaultResource(17170445);
            this.bJq.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bJq.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bJq.getHeadView().setRadius(k.g(this.aby.getPageActivity(), d.f.ds70));
        }
        if (this.bJq.getPendantView() != null) {
            this.bJq.getPendantView().setIsRound(true);
            this.bJq.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.cZf = (ConcernThreadUserInfoLayout) view.findViewById(d.h.card_concern_video_user_info_layout);
        this.blz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        if (this.blz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.blz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.blz.setLayoutParams(layoutParams);
        }
        this.blz.setOnClickListener(this);
        this.blz.setReplyTimeVisible(false);
        this.blz.setShowPraiseNum(true);
        this.blz.setIsBarViewVisible(false);
        this.blz.setNeedAddPraiseIcon(true);
        this.blz.setNeedAddReplyIcon(true);
        this.blz.setShareVisible(true);
        this.blz.setShareReportFrom(4);
        this.blz.setReplyIcon(d.g.icon_home_card_comment_n);
        this.blz.setForumAfterClickListener(this.aoe);
        this.bJs = view.findViewById(d.h.divider_below_reply_number_layout);
        this.blm.setOnClickListener(this);
        this.bHD = (FrameLayout) view.findViewById(d.h.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bHD.getLayoutParams();
        layoutParams2.width = k.ad(this.aby.getPageActivity()) - k.g(this.aby.getPageActivity(), d.f.ds68);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bHD.setLayoutParams(layoutParams2);
        this.bHE = (TbImageView) view.findViewById(d.h.image_video);
        this.bHE.setDefaultErrorResource(0);
        this.bHE.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bHE.setGifIconSupport(false);
        this.bHE.setEvent(this.bHH);
        this.bHF = (ImageView) view.findViewById(d.h.image_video_play);
        this.bKs = (TextView) view.findViewById(d.h.text_video_duration);
        this.bhp = view.findViewById(d.h.divider_line);
        this.bJr = (ThreadGodReplyLayout) view.findViewById(d.h.card_god_reply_layout);
        this.bJr.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.blm, d.g.addresslist_item_bg);
            aj.c(this.bHF, d.g.home_ic_video);
            this.cZf.onChangeSkinType();
            this.blz.onChangeSkinType();
            aj.j(this.bhp, d.e.cp_bg_line_c);
            aj.i(this.bKs, d.e.cp_cont_i);
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
        this.bKy = nVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.blm || view == this.bJr) {
            ae(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    private boolean XE() {
        return this.bKy.bNk && !this.bKy.bNy;
    }

    private void ae(View view) {
        if (XA() != null) {
            XA().a(view, this.bKy);
        }
        if (this.bKy != null && this.bKy.bcJ != null) {
            if (!XE()) {
                m.js(this.bKy.bcJ.getId());
                m.a(this.mTextTitle, this.bKy.bcJ.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.aby.getPageActivity()).createFromThreadCfg(this.bKy.bcJ, null, m.rs(), 18003, true, false, false).addLocateParam(this.bKy.Yc());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.bKy.bcJ.getFid()));
            addLocateParam.setForumName(this.bKy.bcJ.rG());
            if (this.bKy.bMS == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bKy.bMS);
            }
            if (view == this.bJr) {
                addLocateParam.setJumpGodReply(true);
            }
            this.aby.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void refreshView() {
        if (this.bKy == null || this.bKy.bcJ == null || this.bKy.bcJ.getAuthor() == null || this.bKy.bcJ.rS() == null) {
            this.blm.setVisibility(8);
            return;
        }
        this.blm.setVisibility(0);
        XN();
        if (!XE() && m.jt(this.bKy.bcJ.getId())) {
            m.a(this.mTextTitle, this.bKy.bcJ.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bJr.getGodReplyContent(), this.bKy.MR().getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bJr.getPraiseNum(), this.bKy.MR().getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.bKy.MR().sj();
        this.mTextTitle.setText(this.bKy.MR().sb());
        this.cZf.c(this.bKy.MR());
        this.cZf.setUserAfterClickListener(this.bKK);
        if (this.cZf.getHeaderImg() != null) {
            this.cZf.getHeaderImg().setAfterClickListener(this.bKL);
            if (this.cZf.getIsSimpleThread()) {
                this.cZf.getHeaderImg().setVisibility(8);
                this.bJq.setVisibility(8);
            } else if (this.bKy.MR() == null || this.bKy.MR().getAuthor() == null || this.bKy.MR().getAuthor().getPendantData() == null || StringUtils.isNull(this.bKy.MR().getAuthor().getPendantData().pR())) {
                this.bJq.setVisibility(8);
                this.cZf.getHeaderImg().setVisibility(0);
                this.cZf.getHeaderImg().setData(this.bKy.MR());
            } else {
                this.cZf.getHeaderImg().setVisibility(4);
                this.bJq.setVisibility(0);
                this.bJq.setData(this.bKy.MR());
            }
        }
        this.bKs.setText(am.da(this.bKy.bcJ.rS().video_duration.intValue() * 1000));
        if (this.blz.c(this.bKy.bcJ)) {
            this.bJs.setVisibility(8);
        } else {
            this.bJs.setVisibility(0);
        }
        this.bJr.setData(this.bKy.MR().sR());
        this.bJr.onChangeSkinType();
        if (this.bJr.getVisibility() == 0) {
            this.bJs.setVisibility(0);
        }
        d(this.aby, TbadkCoreApplication.getInst().getSkinType());
        if (m.jt(this.bKy.bcJ.getId())) {
            aj.c(this.mTextTitle, d.e.cp_cont_d, 1);
        } else {
            aj.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
    }

    private void XN() {
        if (this.bHE != null && this.bHD != null) {
            if (h.oS().oY() && this.bKy != null && this.bKy.bcJ != null && this.bKy.bcJ.rS() != null) {
                this.bHE.setDefaultBgResource(d.g.pic_bg_video_frs);
                this.bHE.c(this.bKy.bcJ.rS().thumbnail_url, 10, false);
                this.bHD.setVisibility(0);
                return;
            }
            this.bHD.setVisibility(8);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cZf != null) {
            this.cZf.setPageUniqueId(bdUniqueId);
        }
        if (this.bHE != null) {
            this.bHE.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cZf != null) {
            return this.cZf.getHeaderImg();
        }
        return null;
    }

    public View XD() {
        if (this.cZf != null) {
            return this.cZf.aos;
        }
        return null;
    }
}
