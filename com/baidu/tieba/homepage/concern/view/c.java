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
    private TbPageContext<?> aaS;
    private final View.OnClickListener ann;
    public FrameLayout bCP;
    private TbImageView bCQ;
    private ImageView bCR;
    private TbImageView.a bCT;
    private HeadPendantClickableView bEC;
    private ThreadGodReplyLayout bED;
    private View bEE;
    private TextView bFE;
    private n bFK;
    private final View.OnClickListener bFW;
    private final View.OnClickListener bFX;
    private View bfY;
    private RelativeLayout bjC;
    public ThreadCommentAndPraiseInfoLayout bjP;
    public ConcernThreadUserInfoLayout cPo;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bCT = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && c.this.bCQ != null) {
                    c.this.bCQ.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bFW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.VZ() != null) {
                    c.this.VZ().a(view, c.this.bFK);
                }
            }
        };
        this.bFX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.VZ() != null) {
                    c.this.VZ().a(view, c.this.bFK);
                }
            }
        };
        this.ann = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bFK != null && c.this.VZ() != null) {
                    c.this.VZ().a(view, c.this.bFK);
                }
            }
        };
        this.aaS = tbPageContext;
        View view = getView();
        this.bjC = (RelativeLayout) view.findViewById(d.h.layout_root);
        this.bEC = (HeadPendantClickableView) this.bjC.findViewById(d.h.card_home_page_video_user_pendant_header);
        if (this.bEC.getHeadView() != null) {
            this.bEC.getHeadView().setIsRound(true);
            this.bEC.getHeadView().setDrawBorder(false);
            this.bEC.getHeadView().setDefaultResource(17170445);
            this.bEC.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bEC.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bEC.getHeadView().setRadius(k.g(this.aaS.getPageActivity(), d.f.ds70));
        }
        if (this.bEC.getPendantView() != null) {
            this.bEC.getPendantView().setIsRound(true);
            this.bEC.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.cPo = (ConcernThreadUserInfoLayout) view.findViewById(d.h.card_concern_video_user_info_layout);
        this.bjP = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        if (this.bjP.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bjP.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bjP.setLayoutParams(layoutParams);
        }
        this.bjP.setOnClickListener(this);
        this.bjP.setReplyTimeVisible(false);
        this.bjP.setShowPraiseNum(true);
        this.bjP.setIsBarViewVisible(false);
        this.bjP.setNeedAddPraiseIcon(true);
        this.bjP.setNeedAddReplyIcon(true);
        this.bjP.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bjP.setForumAfterClickListener(this.ann);
        this.bEE = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bjC.setOnClickListener(this);
        this.bCP = (FrameLayout) view.findViewById(d.h.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bCP.getLayoutParams();
        layoutParams2.width = k.af(this.aaS.getPageActivity()) - k.g(this.aaS.getPageActivity(), d.f.ds68);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bCP.setLayoutParams(layoutParams2);
        this.bCQ = (TbImageView) view.findViewById(d.h.image_video);
        this.bCQ.setDefaultErrorResource(0);
        this.bCQ.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bCQ.setGifIconSupport(false);
        this.bCQ.setEvent(this.bCT);
        this.bCR = (ImageView) view.findViewById(d.h.image_video_play);
        this.bFE = (TextView) view.findViewById(d.h.text_video_duration);
        this.bfY = view.findViewById(d.h.divider_line);
        this.bED = (ThreadGodReplyLayout) view.findViewById(d.h.card_god_reply_layout);
        this.bED.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.bjC, d.g.addresslist_item_bg);
            ai.c(this.bCR, d.g.home_ic_video);
            this.cPo.onChangeSkinType();
            this.bjP.onChangeSkinType();
            ai.j(this.bfY, d.e.cp_bg_line_c);
            ai.i(this.bFE, d.e.cp_cont_i);
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
        this.bFK = nVar;
        Ot();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bjC || view == this.bED) {
            X(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    private boolean Wd() {
        return this.bFK.bIy && !this.bFK.bIM;
    }

    private void X(View view) {
        if (VZ() != null) {
            VZ().a(view, this.bFK);
        }
        if (this.bFK != null && this.bFK.bbB != null) {
            if (!Wd()) {
                m.iY(this.bFK.bbB.getId());
                m.a(this.mTextTitle, this.bFK.bbB.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.aaS.getPageActivity()).createFromThreadCfg(this.bFK.bbB, null, m.rm(), 18003, true, false, false).addLocateParam(this.bFK.WB());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.bFK.bbB.getFid()));
            addLocateParam.setForumName(this.bFK.bbB.rA());
            if (this.bFK.bIg == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bFK.bIg);
            }
            if (view == this.bED) {
                addLocateParam.setJumpGodReply(true);
            }
            this.aaS.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void Ot() {
        if (this.bFK == null || this.bFK.bbB == null || this.bFK.bbB.getAuthor() == null || this.bFK.bbB.rM() == null) {
            this.bjC.setVisibility(8);
            return;
        }
        this.bjC.setVisibility(0);
        Wl();
        if (!Wd() && m.iZ(this.bFK.bbB.getId())) {
            m.a(this.mTextTitle, this.bFK.bbB.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bED.getGodReplyContent(), this.bFK.MA().getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bED.getPraiseNum(), this.bFK.MA().getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.bFK.MA().sd();
        this.mTextTitle.setText(this.bFK.MA().rV());
        this.cPo.a(this.bFK.MA());
        this.cPo.setUserAfterClickListener(this.bFW);
        if (this.cPo.getHeaderImg() != null) {
            this.cPo.getHeaderImg().setAfterClickListener(this.bFX);
            if (this.cPo.getIsSimpleThread()) {
                this.cPo.getHeaderImg().setVisibility(8);
                this.bEC.setVisibility(8);
            } else if (this.bFK.MA() == null || this.bFK.MA().getAuthor() == null || this.bFK.MA().getAuthor().getPendantData() == null || StringUtils.isNull(this.bFK.MA().getAuthor().getPendantData().pL())) {
                this.bEC.setVisibility(8);
                this.cPo.getHeaderImg().setVisibility(0);
                this.cPo.getHeaderImg().setData(this.bFK.MA());
            } else {
                this.cPo.getHeaderImg().setVisibility(4);
                this.bEC.setVisibility(0);
                this.bEC.setData(this.bFK.MA());
            }
        }
        this.bFE.setText(al.cX(this.bFK.bbB.rM().video_duration.intValue() * 1000));
        if (this.bjP.a(this.bFK.bbB)) {
            this.bEE.setVisibility(8);
        } else {
            this.bEE.setVisibility(0);
        }
        this.bED.setData(this.bFK.MA().sK());
        this.bED.onChangeSkinType();
        if (this.bED.getVisibility() == 0) {
            this.bEE.setVisibility(0);
        }
        d(this.aaS, TbadkCoreApplication.getInst().getSkinType());
        if (m.iZ(this.bFK.bbB.getId())) {
            ai.c(this.mTextTitle, d.e.cp_cont_d, 1);
        } else {
            ai.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
    }

    private void Wl() {
        if (this.bCQ != null && this.bCP != null) {
            if (h.oN().oT() && this.bFK != null && this.bFK.bbB != null && this.bFK.bbB.rM() != null) {
                this.bCQ.setDefaultBgResource(d.g.pic_bg_video_frs);
                this.bCQ.c(this.bFK.bbB.rM().thumbnail_url, 10, false);
                this.bCP.setVisibility(0);
                return;
            }
            this.bCP.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cPo != null) {
            this.cPo.setPageUniqueId(bdUniqueId);
        }
        if (this.bCQ != null) {
            this.bCQ.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cPo != null) {
            return this.cPo.getHeaderImg();
        }
        return null;
    }

    public View Wc() {
        if (this.cPo != null) {
            return this.cPo.anz;
        }
        return null;
    }
}
