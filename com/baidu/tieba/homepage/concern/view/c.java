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
    private TbPageContext<?> acp;
    private final View.OnClickListener aoG;
    public FrameLayout bDZ;
    private TbImageView bEa;
    private ImageView bEb;
    private TbImageView.a bEd;
    private HeadPendantClickableView bFM;
    private ThreadGodReplyLayout bFN;
    private View bFO;
    private TextView bGO;
    private n bGU;
    private final View.OnClickListener bHg;
    private final View.OnClickListener bHh;
    private View bhj;
    private RelativeLayout bkM;
    public ThreadCommentAndPraiseInfoLayout bkZ;
    public ConcernThreadUserInfoLayout cQH;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bEd = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && c.this.bEa != null) {
                    c.this.bEa.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bHg = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.We() != null) {
                    c.this.We().a(view, c.this.bGU);
                }
            }
        };
        this.bHh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.We() != null) {
                    c.this.We().a(view, c.this.bGU);
                }
            }
        };
        this.aoG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bGU != null && c.this.We() != null) {
                    c.this.We().a(view, c.this.bGU);
                }
            }
        };
        this.acp = tbPageContext;
        View view = getView();
        this.bkM = (RelativeLayout) view.findViewById(d.h.layout_root);
        this.bFM = (HeadPendantClickableView) this.bkM.findViewById(d.h.card_home_page_video_user_pendant_header);
        if (this.bFM.getHeadView() != null) {
            this.bFM.getHeadView().setIsRound(true);
            this.bFM.getHeadView().setDrawBorder(false);
            this.bFM.getHeadView().setDefaultResource(17170445);
            this.bFM.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bFM.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bFM.getHeadView().setRadius(k.g(this.acp.getPageActivity(), d.f.ds70));
        }
        if (this.bFM.getPendantView() != null) {
            this.bFM.getPendantView().setIsRound(true);
            this.bFM.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.cQH = (ConcernThreadUserInfoLayout) view.findViewById(d.h.card_concern_video_user_info_layout);
        this.bkZ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        if (this.bkZ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bkZ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bkZ.setLayoutParams(layoutParams);
        }
        this.bkZ.setOnClickListener(this);
        this.bkZ.setReplyTimeVisible(false);
        this.bkZ.setShowPraiseNum(true);
        this.bkZ.setIsBarViewVisible(false);
        this.bkZ.setNeedAddPraiseIcon(true);
        this.bkZ.setNeedAddReplyIcon(true);
        this.bkZ.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bkZ.setForumAfterClickListener(this.aoG);
        this.bFO = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bkM.setOnClickListener(this);
        this.bDZ = (FrameLayout) view.findViewById(d.h.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bDZ.getLayoutParams();
        layoutParams2.width = k.ag(this.acp.getPageActivity()) - k.g(this.acp.getPageActivity(), d.f.ds68);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bDZ.setLayoutParams(layoutParams2);
        this.bEa = (TbImageView) view.findViewById(d.h.image_video);
        this.bEa.setDefaultErrorResource(0);
        this.bEa.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bEa.setGifIconSupport(false);
        this.bEa.setEvent(this.bEd);
        this.bEb = (ImageView) view.findViewById(d.h.image_video_play);
        this.bGO = (TextView) view.findViewById(d.h.text_video_duration);
        this.bhj = view.findViewById(d.h.divider_line);
        this.bFN = (ThreadGodReplyLayout) view.findViewById(d.h.card_god_reply_layout);
        this.bFN.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.bkM, d.g.addresslist_item_bg);
            ai.c(this.bEb, d.g.home_ic_video);
            this.cQH.onChangeSkinType();
            this.bkZ.onChangeSkinType();
            ai.j(this.bhj, d.e.cp_bg_line_c);
            ai.i(this.bGO, d.e.cp_cont_i);
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
        this.bGU = nVar;
        Oy();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bkM || view == this.bFN) {
            X(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    private boolean Wi() {
        return this.bGU.bJI && !this.bGU.bJW;
    }

    private void X(View view) {
        if (We() != null) {
            We().a(view, this.bGU);
        }
        if (this.bGU != null && this.bGU.bcL != null) {
            if (!Wi()) {
                m.jd(this.bGU.bcL.getId());
                m.a(this.mTextTitle, this.bGU.bcL.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.acp.getPageActivity()).createFromThreadCfg(this.bGU.bcL, null, m.rw(), 18003, true, false, false).addLocateParam(this.bGU.WG());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.bGU.bcL.getFid()));
            addLocateParam.setForumName(this.bGU.bcL.rK());
            if (this.bGU.bJq == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bGU.bJq);
            }
            if (view == this.bFN) {
                addLocateParam.setJumpGodReply(true);
            }
            this.acp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void Oy() {
        if (this.bGU == null || this.bGU.bcL == null || this.bGU.bcL.getAuthor() == null || this.bGU.bcL.rW() == null) {
            this.bkM.setVisibility(8);
            return;
        }
        this.bkM.setVisibility(0);
        Wq();
        if (!Wi() && m.je(this.bGU.bcL.getId())) {
            m.a(this.mTextTitle, this.bGU.bcL.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bFN.getGodReplyContent(), this.bGU.MF().getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bFN.getPraiseNum(), this.bGU.MF().getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.bGU.MF().sn();
        this.mTextTitle.setText(this.bGU.MF().sf());
        this.cQH.a(this.bGU.MF());
        this.cQH.setUserAfterClickListener(this.bHg);
        if (this.cQH.getHeaderImg() != null) {
            this.cQH.getHeaderImg().setAfterClickListener(this.bHh);
            if (this.cQH.getIsSimpleThread()) {
                this.cQH.getHeaderImg().setVisibility(8);
                this.bFM.setVisibility(8);
            } else if (this.bGU.MF() == null || this.bGU.MF().getAuthor() == null || this.bGU.MF().getAuthor().getPendantData() == null || StringUtils.isNull(this.bGU.MF().getAuthor().getPendantData().pV())) {
                this.bFM.setVisibility(8);
                this.cQH.getHeaderImg().setVisibility(0);
                this.cQH.getHeaderImg().setData(this.bGU.MF());
            } else {
                this.cQH.getHeaderImg().setVisibility(4);
                this.bFM.setVisibility(0);
                this.bFM.setData(this.bGU.MF());
            }
        }
        this.bGO.setText(al.cZ(this.bGU.bcL.rW().video_duration.intValue() * 1000));
        if (this.bkZ.a(this.bGU.bcL)) {
            this.bFO.setVisibility(8);
        } else {
            this.bFO.setVisibility(0);
        }
        this.bFN.setData(this.bGU.MF().sU());
        this.bFN.onChangeSkinType();
        if (this.bFN.getVisibility() == 0) {
            this.bFO.setVisibility(0);
        }
        d(this.acp, TbadkCoreApplication.getInst().getSkinType());
        if (m.je(this.bGU.bcL.getId())) {
            ai.c(this.mTextTitle, d.e.cp_cont_d, 1);
        } else {
            ai.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
    }

    private void Wq() {
        if (this.bEa != null && this.bDZ != null) {
            if (h.oX().pd() && this.bGU != null && this.bGU.bcL != null && this.bGU.bcL.rW() != null) {
                this.bEa.setDefaultBgResource(d.g.pic_bg_video_frs);
                this.bEa.c(this.bGU.bcL.rW().thumbnail_url, 10, false);
                this.bDZ.setVisibility(0);
                return;
            }
            this.bDZ.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cQH != null) {
            this.cQH.setPageUniqueId(bdUniqueId);
        }
        if (this.bEa != null) {
            this.bEa.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cQH != null) {
            return this.cQH.getHeaderImg();
        }
        return null;
    }

    public View Wh() {
        if (this.cQH != null) {
            return this.cQH.aoS;
        }
        return null;
    }
}
