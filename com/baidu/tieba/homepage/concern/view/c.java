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
    private final View.OnClickListener aoc;
    public FrameLayout bIu;
    private TbImageView bIv;
    private ImageView bIw;
    private TbImageView.a bIy;
    private HeadPendantClickableView bKh;
    private ThreadGodReplyLayout bKi;
    private View bKj;
    private final View.OnClickListener bLB;
    private final View.OnClickListener bLC;
    private TextView bLj;
    private n bLp;
    private View bhm;
    private RelativeLayout bll;
    public ThreadCommentAndPraiseInfoLayout bly;
    public ConcernThreadUserInfoLayout cZZ;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bIy = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && c.this.bIv != null) {
                    c.this.bIv.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bLB = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.XL() != null) {
                    c.this.XL().a(view, c.this.bLp);
                }
            }
        };
        this.bLC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.XL() != null) {
                    c.this.XL().a(view, c.this.bLp);
                }
            }
        };
        this.aoc = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bLp != null && c.this.XL() != null) {
                    c.this.XL().a(view, c.this.bLp);
                }
            }
        };
        this.aby = tbPageContext;
        View view = getView();
        this.bll = (RelativeLayout) view.findViewById(d.h.layout_root);
        this.bKh = (HeadPendantClickableView) this.bll.findViewById(d.h.card_home_page_video_user_pendant_header);
        if (this.bKh.getHeadView() != null) {
            this.bKh.getHeadView().setIsRound(true);
            this.bKh.getHeadView().setDrawBorder(false);
            this.bKh.getHeadView().setDefaultResource(17170445);
            this.bKh.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bKh.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bKh.getHeadView().setRadius(k.f(this.aby.getPageActivity(), d.f.ds70));
        }
        if (this.bKh.getPendantView() != null) {
            this.bKh.getPendantView().setIsRound(true);
            this.bKh.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.cZZ = (ConcernThreadUserInfoLayout) view.findViewById(d.h.card_concern_video_user_info_layout);
        this.bly = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        if (this.bly.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bly.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bly.setLayoutParams(layoutParams);
        }
        this.bly.setOnClickListener(this);
        this.bly.setReplyTimeVisible(false);
        this.bly.setShowPraiseNum(true);
        this.bly.setIsBarViewVisible(false);
        this.bly.setNeedAddPraiseIcon(true);
        this.bly.setNeedAddReplyIcon(true);
        this.bly.setShareVisible(true);
        this.bly.setShareReportFrom(4);
        this.bly.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bly.setForumAfterClickListener(this.aoc);
        this.bKj = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bll.setOnClickListener(this);
        this.bIu = (FrameLayout) view.findViewById(d.h.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bIu.getLayoutParams();
        layoutParams2.width = k.ae(this.aby.getPageActivity()) - k.f(this.aby.getPageActivity(), d.f.ds68);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bIu.setLayoutParams(layoutParams2);
        this.bIv = (TbImageView) view.findViewById(d.h.image_video);
        this.bIv.setDefaultErrorResource(0);
        this.bIv.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bIv.setGifIconSupport(false);
        this.bIv.setEvent(this.bIy);
        this.bIw = (ImageView) view.findViewById(d.h.image_video_play);
        this.bLj = (TextView) view.findViewById(d.h.text_video_duration);
        this.bhm = view.findViewById(d.h.divider_line);
        this.bKi = (ThreadGodReplyLayout) view.findViewById(d.h.card_god_reply_layout);
        this.bKi.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bll, d.g.addresslist_item_bg);
            aj.c(this.bIw, d.g.home_ic_video);
            this.cZZ.onChangeSkinType();
            this.bly.onChangeSkinType();
            aj.j(this.bhm, d.e.cp_bg_line_c);
            aj.i(this.bLj, d.e.cp_cont_i);
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
        this.bLp = nVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bll || view == this.bKi) {
            ae(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    private boolean XP() {
        return this.bLp.bOb && !this.bLp.bOp;
    }

    private void ae(View view) {
        if (XL() != null) {
            XL().a(view, this.bLp);
        }
        if (this.bLp != null && this.bLp.bcG != null) {
            if (!XP()) {
                m.ju(this.bLp.bcG.getId());
                m.a(this.mTextTitle, this.bLp.bcG.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.aby.getPageActivity()).createFromThreadCfg(this.bLp.bcG, null, m.rs(), 18003, true, false, false).addLocateParam(this.bLp.Yn());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.bLp.bcG.getFid()));
            addLocateParam.setForumName(this.bLp.bcG.rG());
            if (this.bLp.bNJ == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bLp.bNJ);
            }
            if (view == this.bKi) {
                addLocateParam.setJumpGodReply(true);
            }
            this.aby.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void refreshView() {
        if (this.bLp == null || this.bLp.bcG == null || this.bLp.bcG.getAuthor() == null || this.bLp.bcG.rS() == null) {
            this.bll.setVisibility(8);
            return;
        }
        this.bll.setVisibility(0);
        XY();
        if (!XP() && m.jv(this.bLp.bcG.getId())) {
            m.a(this.mTextTitle, this.bLp.bcG.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bKi.getGodReplyContent(), this.bLp.MR().getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bKi.getPraiseNum(), this.bLp.MR().getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.bLp.MR().sj();
        this.mTextTitle.setText(this.bLp.MR().sb());
        this.cZZ.c(this.bLp.MR());
        this.cZZ.setUserAfterClickListener(this.bLB);
        if (this.cZZ.getHeaderImg() != null) {
            this.cZZ.getHeaderImg().setAfterClickListener(this.bLC);
            if (this.cZZ.getIsSimpleThread()) {
                this.cZZ.getHeaderImg().setVisibility(8);
                this.bKh.setVisibility(8);
            } else if (this.bLp.MR() == null || this.bLp.MR().getAuthor() == null || this.bLp.MR().getAuthor().getPendantData() == null || StringUtils.isNull(this.bLp.MR().getAuthor().getPendantData().pR())) {
                this.bKh.setVisibility(8);
                this.cZZ.getHeaderImg().setVisibility(0);
                this.cZZ.getHeaderImg().setData(this.bLp.MR());
            } else {
                this.cZZ.getHeaderImg().setVisibility(4);
                this.bKh.setVisibility(0);
                this.bKh.setData(this.bLp.MR());
            }
        }
        this.bLj.setText(am.da(this.bLp.bcG.rS().video_duration.intValue() * 1000));
        if (this.bly.c(this.bLp.bcG)) {
            this.bKj.setVisibility(8);
        } else {
            this.bKj.setVisibility(0);
        }
        this.bKi.setData(this.bLp.MR().sR());
        this.bKi.onChangeSkinType();
        if (this.bKi.getVisibility() == 0) {
            this.bKj.setVisibility(0);
        }
        d(this.aby, TbadkCoreApplication.getInst().getSkinType());
        if (m.jv(this.bLp.bcG.getId())) {
            aj.c(this.mTextTitle, d.e.cp_cont_d, 1);
        } else {
            aj.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
    }

    private void XY() {
        if (this.bIv != null && this.bIu != null) {
            if (h.oS().oY() && this.bLp != null && this.bLp.bcG != null && this.bLp.bcG.rS() != null) {
                this.bIv.setDefaultBgResource(d.g.pic_bg_video_frs);
                this.bIv.c(this.bLp.bcG.rS().thumbnail_url, 10, false);
                this.bIu.setVisibility(0);
                return;
            }
            this.bIu.setVisibility(8);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cZZ != null) {
            this.cZZ.setPageUniqueId(bdUniqueId);
        }
        if (this.bIv != null) {
            this.bIv.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cZZ != null) {
            return this.cZZ.getHeaderImg();
        }
        return null;
    }

    public View XO() {
        if (this.cZZ != null) {
            return this.cZZ.aoq;
        }
        return null;
    }
}
