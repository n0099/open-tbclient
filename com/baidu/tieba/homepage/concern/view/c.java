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
import com.baidu.tieba.card.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.a<n> {
    private TbPageContext<?> acd;
    private final View.OnClickListener anO;
    private TbImageView bZX;
    private TextView bZY;
    private HeadPendantClickableView bZa;
    private ThreadGodReplyLayout bZb;
    private ImageView bkW;
    private View bqr;
    public ThreadCommentAndPraiseInfoLayout bvH;
    private RelativeLayout bvu;
    public FrameLayout cae;
    private TextView cag;
    private LinearLayout cah;
    private n cam;
    private TbImageView.a cav;
    private final View.OnClickListener cay;
    private final View.OnClickListener caz;
    public ConcernThreadUserInfoLayout dnH;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cav = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && c.this.bZX != null) {
                    c.this.bZX.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cay = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.abs() != null) {
                    c.this.abs().a(view, c.this.cam);
                }
            }
        };
        this.caz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.abs() != null) {
                    c.this.abs().a(view, c.this.cam);
                }
            }
        };
        this.anO = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cam != null && c.this.abs() != null) {
                    c.this.abs().a(view, c.this.cam);
                }
            }
        };
        this.acd = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.bvu = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.bZa = (HeadPendantClickableView) this.bvu.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.bZa.getHeadView() != null) {
            this.bZa.getHeadView().setIsRound(true);
            this.bZa.getHeadView().setDrawBorder(false);
            this.bZa.getHeadView().setDefaultResource(17170445);
            this.bZa.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bZa.getHeadView().setDefaultBgResource(d.C0082d.cp_bg_line_e);
            this.bZa.getHeadView().setRadius(l.f(this.acd.getPageActivity(), d.e.ds70));
        }
        if (this.bZa.getPendantView() != null) {
            this.bZa.getPendantView().setIsRound(true);
            this.bZa.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.dnH = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_video_user_info_layout);
        this.bvH = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.bvH.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvH.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bvH.setLayoutParams(layoutParams);
        }
        this.bvH.setOnClickListener(this);
        this.bvH.setReplyTimeVisible(false);
        this.bvH.setShowPraiseNum(true);
        this.bvH.setIsBarViewVisible(false);
        this.bvH.setNeedAddPraiseIcon(true);
        this.bvH.setNeedAddReplyIcon(true);
        this.bvH.setShareVisible(true);
        this.bvH.setShareReportFrom(4);
        this.bvH.setForumAfterClickListener(this.anO);
        this.bvH.anM = this.currentPageType;
        this.bvu.setOnClickListener(this);
        this.cae = (FrameLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cae.getLayoutParams();
        layoutParams2.width = l.ac(this.acd.getPageActivity()) - l.f(this.acd.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cae.setLayoutParams(layoutParams2);
        this.bZX = (TbImageView) view.findViewById(d.g.image_video);
        this.bZX.setDefaultErrorResource(0);
        this.bZX.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.bZX.setGifIconSupport(false);
        this.bZX.setEvent(this.cav);
        this.bkW = (ImageView) view.findViewById(d.g.image_video_play);
        this.cag = (TextView) view.findViewById(d.g.text_video_duration);
        this.cah = (LinearLayout) view.findViewById(d.g.duration_container);
        this.bZY = (TextView) view.findViewById(d.g.text_video_play_count);
        this.bqr = view.findViewById(d.g.divider_line);
        this.bZb = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.bZb.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bvu, d.f.addresslist_item_bg);
            aj.c(this.bkW, d.f.btn_icon_play_video_n);
            this.dnH.onChangeSkinType();
            this.bvH.onChangeSkinType();
            aj.j(this.bqr, d.C0082d.cp_bg_line_e);
            aj.i(this.cag, d.C0082d.cp_cont_i);
            aj.i(this.bZY, d.C0082d.cp_cont_i);
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
        this.cam = nVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bvu || view == this.bZb) {
            ah(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    private boolean abw() {
        return this.cam.cdF && !this.cam.cdT;
    }

    private void ah(View view) {
        if (abs() != null) {
            abs().a(view, this.cam);
        }
        if (this.cam != null && this.cam.bjD != null) {
            if (!abw()) {
                k.jQ(this.cam.bjD.getId());
                k.a(this.mTextTitle, this.cam.bjD.getId(), d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.acd.getPageActivity()).createFromThreadCfg(this.cam.bjD, null, k.rn(), 18003, true, false, false).addLocateParam(this.cam.abW());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.cam.bjD.getFid()));
            addLocateParam.setForumName(this.cam.bjD.rD());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.bZb) {
                addLocateParam.setJumpGodReply(true);
            }
            this.acd.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void refreshView() {
        if (this.cam == null || this.cam.bjD == null || this.cam.bjD.rx() == null || this.cam.bjD.rP() == null) {
            this.bvu.setVisibility(8);
            return;
        }
        this.bvu.setVisibility(0);
        abF();
        if (!abw() && k.jR(this.cam.bjD.getId())) {
            k.a(this.mTextTitle, this.cam.bjD.getId(), d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
            k.a(this.bZb.getGodReplyContent(), this.cam.Ox().getId(), d.C0082d.cp_cont_f, d.C0082d.cp_cont_d);
        }
        this.cam.Ox().sf();
        this.mTextTitle.setText(this.cam.Ox().rX());
        this.dnH.setData(this.cam.Ox());
        this.dnH.setUserAfterClickListener(this.cay);
        if (this.dnH.getHeaderImg() != null) {
            this.dnH.getHeaderImg().setAfterClickListener(this.caz);
            if (this.dnH.getIsSimpleThread()) {
                this.dnH.getHeaderImg().setVisibility(8);
                this.bZa.setVisibility(8);
            } else if (this.cam.Ox() == null || this.cam.Ox().rx() == null || this.cam.Ox().rx().getPendantData() == null || StringUtils.isNull(this.cam.Ox().rx().getPendantData().pT())) {
                this.bZa.setVisibility(8);
                this.dnH.getHeaderImg().setVisibility(0);
                this.dnH.getHeaderImg().setData(this.cam.Ox());
            } else {
                this.dnH.getHeaderImg().setVisibility(4);
                this.bZa.setVisibility(0);
                this.bZa.setData(this.cam.Ox());
            }
        }
        this.cag.setText(am.cY(this.cam.bjD.rP().video_duration.intValue() * 1000));
        this.bZY.setText(String.format(this.acd.getResources().getString(d.j.play_count), am.A(this.cam.bjD.rP().play_count.intValue())));
        this.bvH.setData(this.cam.bjD);
        this.bZb.setData(this.cam.Ox().sO());
        this.bZb.onChangeSkinType();
        d(this.acd, TbadkCoreApplication.getInst().getSkinType());
        if (k.jR(this.cam.bjD.getId())) {
            aj.c(this.mTextTitle, d.C0082d.cp_cont_d, 1);
        } else {
            aj.c(this.mTextTitle, d.C0082d.cp_cont_b, 1);
        }
    }

    private void abF() {
        if (this.bZX != null && this.cae != null) {
            if (h.pa().pg() && this.cam != null && this.cam.bjD != null && this.cam.bjD.rP() != null) {
                this.bZX.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.bZX.startLoad(this.cam.bjD.rP().thumbnail_url, 10, false);
                this.cae.setVisibility(0);
                return;
            }
            this.cae.setVisibility(8);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dnH != null) {
            this.dnH.setPageUniqueId(bdUniqueId);
        }
        if (this.bZX != null) {
            this.bZX.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dnH != null) {
            return this.dnH.getHeaderImg();
        }
        return null;
    }

    public View abv() {
        if (this.dnH != null) {
            return this.dnH.anX;
        }
        return null;
    }
}
