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
    private TbPageContext<?> abz;
    private final View.OnClickListener anr;
    private View aod;
    private HeadPendantClickableView bJv;
    private ThreadGodReplyLayout bJw;
    public FrameLayout bKB;
    private TextView bKE;
    private LinearLayout bKF;
    private n bKK;
    private TbImageView.a bKT;
    private final View.OnClickListener bKX;
    private final View.OnClickListener bKY;
    private TbImageView bKt;
    private ImageView bKu;
    private TextView bKv;
    private RelativeLayout bmW;
    public ThreadCommentAndPraiseInfoLayout bnj;
    public ConcernThreadUserInfoLayout cWD;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bKT = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && c.this.bKt != null) {
                    c.this.bKt.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bKX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.Xr() != null) {
                    c.this.Xr().a(view, c.this.bKK);
                }
            }
        };
        this.bKY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.Xr() != null) {
                    c.this.Xr().a(view, c.this.bKK);
                }
            }
        };
        this.anr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bKK != null && c.this.Xr() != null) {
                    c.this.Xr().a(view, c.this.bKK);
                }
            }
        };
        this.abz = tbPageContext;
        View view = getView();
        this.bmW = (RelativeLayout) view.findViewById(d.h.layout_root);
        this.bJv = (HeadPendantClickableView) this.bmW.findViewById(d.h.card_home_page_video_user_pendant_header);
        if (this.bJv.getHeadView() != null) {
            this.bJv.getHeadView().setIsRound(true);
            this.bJv.getHeadView().setDrawBorder(false);
            this.bJv.getHeadView().setDefaultResource(17170445);
            this.bJv.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bJv.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bJv.getHeadView().setRadius(l.f(this.abz.getPageActivity(), d.f.ds70));
        }
        if (this.bJv.getPendantView() != null) {
            this.bJv.getPendantView().setIsRound(true);
            this.bJv.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.cWD = (ConcernThreadUserInfoLayout) view.findViewById(d.h.card_concern_video_user_info_layout);
        this.bnj = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        if (this.bnj.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bnj.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bnj.setLayoutParams(layoutParams);
        }
        this.bnj.setOnClickListener(this);
        this.bnj.setReplyTimeVisible(false);
        this.bnj.setShowPraiseNum(true);
        this.bnj.setIsBarViewVisible(false);
        this.bnj.setNeedAddPraiseIcon(true);
        this.bnj.setNeedAddReplyIcon(true);
        this.bnj.setShareVisible(true);
        this.bnj.setShareReportFrom(4);
        this.bnj.setForumAfterClickListener(this.anr);
        this.bmW.setOnClickListener(this);
        this.bKB = (FrameLayout) view.findViewById(d.h.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bKB.getLayoutParams();
        layoutParams2.width = l.ad(this.abz.getPageActivity()) - l.f(this.abz.getPageActivity(), d.f.ds68);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bKB.setLayoutParams(layoutParams2);
        this.bKt = (TbImageView) view.findViewById(d.h.image_video);
        this.bKt.setDefaultErrorResource(0);
        this.bKt.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bKt.setGifIconSupport(false);
        this.bKt.setEvent(this.bKT);
        this.bKu = (ImageView) view.findViewById(d.h.image_video_play);
        this.bKE = (TextView) view.findViewById(d.h.text_video_duration);
        this.bKF = (LinearLayout) view.findViewById(d.h.duration_container);
        this.bKv = (TextView) view.findViewById(d.h.text_video_play_count);
        this.aod = view.findViewById(d.h.divider_line);
        this.bJw = (ThreadGodReplyLayout) view.findViewById(d.h.card_god_reply_layout);
        this.bJw.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bmW, d.g.addresslist_item_bg);
            aj.c(this.bKu, d.g.btn_icon_play_video_n);
            this.cWD.onChangeSkinType();
            this.bnj.onChangeSkinType();
            aj.j(this.aod, d.e.cp_bg_line_e);
            aj.i(this.bKE, d.e.cp_cont_i);
            aj.i(this.bKv, d.e.cp_cont_i);
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
        this.bKK = nVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bmW || view == this.bJw) {
            ad(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    private boolean Xv() {
        return this.bKK.bNG && !this.bKK.bNU;
    }

    private void ad(View view) {
        if (Xr() != null) {
            Xr().a(view, this.bKK);
        }
        if (this.bKK != null && this.bKK.bes != null) {
            if (!Xv()) {
                m.jm(this.bKK.bes.getId());
                m.a(this.mTextTitle, this.bKK.bes.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.abz.getPageActivity()).createFromThreadCfg(this.bKK.bes, null, m.rm(), 18003, true, false, false).addLocateParam(this.bKK.XV());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.bKK.bes.getFid()));
            addLocateParam.setForumName(this.bKK.bes.rA());
            if (this.bKK.bNn == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bKK.bNn);
            }
            if (view == this.bJw) {
                addLocateParam.setJumpGodReply(true);
            }
            this.abz.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void refreshView() {
        if (this.bKK == null || this.bKK.bes == null || this.bKK.bes.getAuthor() == null || this.bKK.bes.rM() == null) {
            this.bmW.setVisibility(8);
            return;
        }
        this.bmW.setVisibility(0);
        XE();
        if (!Xv() && m.jn(this.bKK.bes.getId())) {
            m.a(this.mTextTitle, this.bKK.bes.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bJw.getGodReplyContent(), this.bKK.Nj().getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.bKK.Nj().sd();
        this.mTextTitle.setText(this.bKK.Nj().rV());
        this.cWD.setData(this.bKK.Nj());
        this.cWD.setUserAfterClickListener(this.bKX);
        if (this.cWD.getHeaderImg() != null) {
            this.cWD.getHeaderImg().setAfterClickListener(this.bKY);
            if (this.cWD.getIsSimpleThread()) {
                this.cWD.getHeaderImg().setVisibility(8);
                this.bJv.setVisibility(8);
            } else if (this.bKK.Nj() == null || this.bKK.Nj().getAuthor() == null || this.bKK.Nj().getAuthor().getPendantData() == null || StringUtils.isNull(this.bKK.Nj().getAuthor().getPendantData().pS())) {
                this.bJv.setVisibility(8);
                this.cWD.getHeaderImg().setVisibility(0);
                this.cWD.getHeaderImg().setData(this.bKK.Nj());
            } else {
                this.cWD.getHeaderImg().setVisibility(4);
                this.bJv.setVisibility(0);
                this.bJv.setData(this.bKK.Nj());
            }
        }
        this.bKE.setText(am.cY(this.bKK.bes.rM().video_duration.intValue() * 1000));
        this.bKv.setText(String.format(this.abz.getResources().getString(d.l.play_count), am.z(this.bKK.bes.rM().play_count.intValue())));
        this.bnj.setData(this.bKK.bes);
        this.bJw.setData(this.bKK.Nj().sL());
        this.bJw.onChangeSkinType();
        d(this.abz, TbadkCoreApplication.getInst().getSkinType());
        if (m.jn(this.bKK.bes.getId())) {
            aj.c(this.mTextTitle, d.e.cp_cont_d, 1);
        } else {
            aj.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
    }

    private void XE() {
        if (this.bKt != null && this.bKB != null) {
            if (h.oT().oZ() && this.bKK != null && this.bKK.bes != null && this.bKK.bes.rM() != null) {
                this.bKt.setDefaultBgResource(d.g.pic_bg_video_frs);
                this.bKt.c(this.bKK.bes.rM().thumbnail_url, 10, false);
                this.bKB.setVisibility(0);
                return;
            }
            this.bKB.setVisibility(8);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cWD != null) {
            this.cWD.setPageUniqueId(bdUniqueId);
        }
        if (this.bKt != null) {
            this.bKt.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cWD != null) {
            return this.cWD.getHeaderImg();
        }
        return null;
    }

    public View Xu() {
        if (this.cWD != null) {
            return this.cWD.anF;
        }
        return null;
    }
}
