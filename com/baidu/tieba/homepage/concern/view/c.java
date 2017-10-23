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
    private TbPageContext<?> abm;
    private View anR;
    private final View.OnClickListener anf;
    private HeadPendantClickableView bJj;
    private ThreadGodReplyLayout bJk;
    private TbImageView.a bKH;
    private final View.OnClickListener bKL;
    private final View.OnClickListener bKM;
    private TbImageView bKh;
    private ImageView bKi;
    private TextView bKj;
    public FrameLayout bKp;
    private TextView bKs;
    private LinearLayout bKt;
    private n bKy;
    private RelativeLayout bmI;
    public ThreadCommentAndPraiseInfoLayout bmV;
    public ConcernThreadUserInfoLayout cWr;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bKH = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && c.this.bKh != null) {
                    c.this.bKh.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bKL = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.Xn() != null) {
                    c.this.Xn().a(view, c.this.bKy);
                }
            }
        };
        this.bKM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.Xn() != null) {
                    c.this.Xn().a(view, c.this.bKy);
                }
            }
        };
        this.anf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bKy != null && c.this.Xn() != null) {
                    c.this.Xn().a(view, c.this.bKy);
                }
            }
        };
        this.abm = tbPageContext;
        View view = getView();
        this.bmI = (RelativeLayout) view.findViewById(d.h.layout_root);
        this.bJj = (HeadPendantClickableView) this.bmI.findViewById(d.h.card_home_page_video_user_pendant_header);
        if (this.bJj.getHeadView() != null) {
            this.bJj.getHeadView().setIsRound(true);
            this.bJj.getHeadView().setDrawBorder(false);
            this.bJj.getHeadView().setDefaultResource(17170445);
            this.bJj.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bJj.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bJj.getHeadView().setRadius(l.f(this.abm.getPageActivity(), d.f.ds70));
        }
        if (this.bJj.getPendantView() != null) {
            this.bJj.getPendantView().setIsRound(true);
            this.bJj.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.cWr = (ConcernThreadUserInfoLayout) view.findViewById(d.h.card_concern_video_user_info_layout);
        this.bmV = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        if (this.bmV.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bmV.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bmV.setLayoutParams(layoutParams);
        }
        this.bmV.setOnClickListener(this);
        this.bmV.setReplyTimeVisible(false);
        this.bmV.setShowPraiseNum(true);
        this.bmV.setIsBarViewVisible(false);
        this.bmV.setNeedAddPraiseIcon(true);
        this.bmV.setNeedAddReplyIcon(true);
        this.bmV.setShareVisible(true);
        this.bmV.setShareReportFrom(4);
        this.bmV.setForumAfterClickListener(this.anf);
        this.bmI.setOnClickListener(this);
        this.bKp = (FrameLayout) view.findViewById(d.h.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bKp.getLayoutParams();
        layoutParams2.width = l.ad(this.abm.getPageActivity()) - l.f(this.abm.getPageActivity(), d.f.ds68);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bKp.setLayoutParams(layoutParams2);
        this.bKh = (TbImageView) view.findViewById(d.h.image_video);
        this.bKh.setDefaultErrorResource(0);
        this.bKh.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bKh.setGifIconSupport(false);
        this.bKh.setEvent(this.bKH);
        this.bKi = (ImageView) view.findViewById(d.h.image_video_play);
        this.bKs = (TextView) view.findViewById(d.h.text_video_duration);
        this.bKt = (LinearLayout) view.findViewById(d.h.duration_container);
        this.bKj = (TextView) view.findViewById(d.h.text_video_play_count);
        this.anR = view.findViewById(d.h.divider_line);
        this.bJk = (ThreadGodReplyLayout) view.findViewById(d.h.card_god_reply_layout);
        this.bJk.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bmI, d.g.addresslist_item_bg);
            aj.c(this.bKi, d.g.btn_icon_play_video_n);
            this.cWr.onChangeSkinType();
            this.bmV.onChangeSkinType();
            aj.j(this.anR, d.e.cp_bg_line_e);
            aj.i(this.bKs, d.e.cp_cont_i);
            aj.i(this.bKj, d.e.cp_cont_i);
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
        if (view == this.bmI || view == this.bJk) {
            ad(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    private boolean Xr() {
        return this.bKy.bNu && !this.bKy.bNI;
    }

    private void ad(View view) {
        if (Xn() != null) {
            Xn().a(view, this.bKy);
        }
        if (this.bKy != null && this.bKy.bee != null) {
            if (!Xr()) {
                m.jl(this.bKy.bee.getId());
                m.a(this.mTextTitle, this.bKy.bee.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.abm.getPageActivity()).createFromThreadCfg(this.bKy.bee, null, m.rf(), 18003, true, false, false).addLocateParam(this.bKy.XR());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.bKy.bee.getFid()));
            addLocateParam.setForumName(this.bKy.bee.rt());
            if (this.bKy.bNb == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bKy.bNb);
            }
            if (view == this.bJk) {
                addLocateParam.setJumpGodReply(true);
            }
            this.abm.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void refreshView() {
        if (this.bKy == null || this.bKy.bee == null || this.bKy.bee.getAuthor() == null || this.bKy.bee.rF() == null) {
            this.bmI.setVisibility(8);
            return;
        }
        this.bmI.setVisibility(0);
        XA();
        if (!Xr() && m.jm(this.bKy.bee.getId())) {
            m.a(this.mTextTitle, this.bKy.bee.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bJk.getGodReplyContent(), this.bKy.Nd().getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.bKy.Nd().rW();
        this.mTextTitle.setText(this.bKy.Nd().rO());
        this.cWr.setData(this.bKy.Nd());
        this.cWr.setUserAfterClickListener(this.bKL);
        if (this.cWr.getHeaderImg() != null) {
            this.cWr.getHeaderImg().setAfterClickListener(this.bKM);
            if (this.cWr.getIsSimpleThread()) {
                this.cWr.getHeaderImg().setVisibility(8);
                this.bJj.setVisibility(8);
            } else if (this.bKy.Nd() == null || this.bKy.Nd().getAuthor() == null || this.bKy.Nd().getAuthor().getPendantData() == null || StringUtils.isNull(this.bKy.Nd().getAuthor().getPendantData().pL())) {
                this.bJj.setVisibility(8);
                this.cWr.getHeaderImg().setVisibility(0);
                this.cWr.getHeaderImg().setData(this.bKy.Nd());
            } else {
                this.cWr.getHeaderImg().setVisibility(4);
                this.bJj.setVisibility(0);
                this.bJj.setData(this.bKy.Nd());
            }
        }
        this.bKs.setText(am.cX(this.bKy.bee.rF().video_duration.intValue() * 1000));
        this.bKj.setText(String.format(this.abm.getResources().getString(d.l.play_count), am.A(this.bKy.bee.rF().play_count.intValue())));
        this.bmV.setData(this.bKy.bee);
        this.bJk.setData(this.bKy.Nd().sE());
        this.bJk.onChangeSkinType();
        d(this.abm, TbadkCoreApplication.getInst().getSkinType());
        if (m.jm(this.bKy.bee.getId())) {
            aj.c(this.mTextTitle, d.e.cp_cont_d, 1);
        } else {
            aj.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
    }

    private void XA() {
        if (this.bKh != null && this.bKp != null) {
            if (h.oM().oS() && this.bKy != null && this.bKy.bee != null && this.bKy.bee.rF() != null) {
                this.bKh.setDefaultBgResource(d.g.pic_bg_video_frs);
                this.bKh.c(this.bKy.bee.rF().thumbnail_url, 10, false);
                this.bKp.setVisibility(0);
                return;
            }
            this.bKp.setVisibility(8);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cWr != null) {
            this.cWr.setPageUniqueId(bdUniqueId);
        }
        if (this.bKh != null) {
            this.bKh.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cWr != null) {
            return this.cWr.getHeaderImg();
        }
        return null;
    }

    public View Xq() {
        if (this.cWr != null) {
            return this.cWr.ant;
        }
        return null;
    }
}
