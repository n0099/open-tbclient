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
    private final View.OnClickListener anz;
    private View aol;
    private HeadPendantClickableView bRc;
    private ThreadGodReplyLayout bRd;
    private TbImageView.a bSB;
    private final View.OnClickListener bSF;
    private final View.OnClickListener bSG;
    private TbImageView bSa;
    private ImageView bSb;
    private TextView bSc;
    public FrameLayout bSi;
    private TextView bSl;
    private LinearLayout bSm;
    private n bSr;
    public ThreadCommentAndPraiseInfoLayout boM;
    private RelativeLayout boz;
    public ConcernThreadUserInfoLayout dfa;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bSB = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && c.this.bSa != null) {
                    c.this.bSa.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bSF = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ZJ() != null) {
                    c.this.ZJ().a(view, c.this.bSr);
                }
            }
        };
        this.bSG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ZJ() != null) {
                    c.this.ZJ().a(view, c.this.bSr);
                }
            }
        };
        this.anz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bSr != null && c.this.ZJ() != null) {
                    c.this.ZJ().a(view, c.this.bSr);
                }
            }
        };
        this.abI = tbPageContext;
        View view = getView();
        this.boz = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.bRc = (HeadPendantClickableView) this.boz.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.bRc.getHeadView() != null) {
            this.bRc.getHeadView().setIsRound(true);
            this.bRc.getHeadView().setDrawBorder(false);
            this.bRc.getHeadView().setDefaultResource(17170445);
            this.bRc.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bRc.getHeadView().setDefaultBgResource(d.C0080d.cp_bg_line_e);
            this.bRc.getHeadView().setRadius(l.f(this.abI.getPageActivity(), d.e.ds70));
        }
        if (this.bRc.getPendantView() != null) {
            this.bRc.getPendantView().setIsRound(true);
            this.bRc.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.dfa = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_video_user_info_layout);
        this.boM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.boM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.boM.setLayoutParams(layoutParams);
        }
        this.boM.setOnClickListener(this);
        this.boM.setReplyTimeVisible(false);
        this.boM.setShowPraiseNum(true);
        this.boM.setIsBarViewVisible(false);
        this.boM.setNeedAddPraiseIcon(true);
        this.boM.setNeedAddReplyIcon(true);
        this.boM.setShareVisible(true);
        this.boM.setShareReportFrom(4);
        this.boM.setForumAfterClickListener(this.anz);
        this.boz.setOnClickListener(this);
        this.bSi = (FrameLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bSi.getLayoutParams();
        layoutParams2.width = l.ac(this.abI.getPageActivity()) - l.f(this.abI.getPageActivity(), d.e.ds68);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bSi.setLayoutParams(layoutParams2);
        this.bSa = (TbImageView) view.findViewById(d.g.image_video);
        this.bSa.setDefaultErrorResource(0);
        this.bSa.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.bSa.setGifIconSupport(false);
        this.bSa.setEvent(this.bSB);
        this.bSb = (ImageView) view.findViewById(d.g.image_video_play);
        this.bSl = (TextView) view.findViewById(d.g.text_video_duration);
        this.bSm = (LinearLayout) view.findViewById(d.g.duration_container);
        this.bSc = (TextView) view.findViewById(d.g.text_video_play_count);
        this.aol = view.findViewById(d.g.divider_line);
        this.bRd = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.bRd.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.boz, d.f.addresslist_item_bg);
            aj.c(this.bSb, d.f.btn_icon_play_video_n);
            this.dfa.onChangeSkinType();
            this.boM.onChangeSkinType();
            aj.j(this.aol, d.C0080d.cp_bg_line_e);
            aj.i(this.bSl, d.C0080d.cp_cont_i);
            aj.i(this.bSc, d.C0080d.cp_cont_i);
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
        this.bSr = nVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.boz || view == this.bRd) {
            ag(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    private boolean ZN() {
        return this.bSr.bVl && !this.bSr.bVz;
    }

    private void ag(View view) {
        if (ZJ() != null) {
            ZJ().a(view, this.bSr);
        }
        if (this.bSr != null && this.bSr.bff != null) {
            if (!ZN()) {
                m.jL(this.bSr.bff.getId());
                m.a(this.mTextTitle, this.bSr.bff.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.abI.getPageActivity()).createFromThreadCfg(this.bSr.bff, null, m.rj(), 18003, true, false, false).addLocateParam(this.bSr.aan());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.bSr.bff.getFid()));
            addLocateParam.setForumName(this.bSr.bff.rz());
            if (this.bSr.bUS == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bSr.bUS);
            }
            if (view == this.bRd) {
                addLocateParam.setJumpGodReply(true);
            }
            this.abI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void refreshView() {
        if (this.bSr == null || this.bSr.bff == null || this.bSr.bff.rt() == null || this.bSr.bff.rL() == null) {
            this.boz.setVisibility(8);
            return;
        }
        this.boz.setVisibility(0);
        ZW();
        if (!ZN() && m.jM(this.bSr.bff.getId())) {
            m.a(this.mTextTitle, this.bSr.bff.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
            m.a(this.bRd.getGodReplyContent(), this.bSr.NA().getId(), d.C0080d.cp_cont_f, d.C0080d.cp_cont_d);
        }
        this.bSr.NA().sc();
        this.mTextTitle.setText(this.bSr.NA().rU());
        this.dfa.setData(this.bSr.NA());
        this.dfa.setUserAfterClickListener(this.bSF);
        if (this.dfa.getHeaderImg() != null) {
            this.dfa.getHeaderImg().setAfterClickListener(this.bSG);
            if (this.dfa.getIsSimpleThread()) {
                this.dfa.getHeaderImg().setVisibility(8);
                this.bRc.setVisibility(8);
            } else if (this.bSr.NA() == null || this.bSr.NA().rt() == null || this.bSr.NA().rt().getPendantData() == null || StringUtils.isNull(this.bSr.NA().rt().getPendantData().pQ())) {
                this.bRc.setVisibility(8);
                this.dfa.getHeaderImg().setVisibility(0);
                this.dfa.getHeaderImg().setData(this.bSr.NA());
            } else {
                this.dfa.getHeaderImg().setVisibility(4);
                this.bRc.setVisibility(0);
                this.bRc.setData(this.bSr.NA());
            }
        }
        this.bSl.setText(am.cX(this.bSr.bff.rL().video_duration.intValue() * 1000));
        this.bSc.setText(String.format(this.abI.getResources().getString(d.j.play_count), am.A(this.bSr.bff.rL().play_count.intValue())));
        this.boM.setData(this.bSr.bff);
        this.bRd.setData(this.bSr.NA().sL());
        this.bRd.onChangeSkinType();
        d(this.abI, TbadkCoreApplication.getInst().getSkinType());
        if (m.jM(this.bSr.bff.getId())) {
            aj.c(this.mTextTitle, d.C0080d.cp_cont_d, 1);
        } else {
            aj.c(this.mTextTitle, d.C0080d.cp_cont_b, 1);
        }
    }

    private void ZW() {
        if (this.bSa != null && this.bSi != null) {
            if (h.oT().oZ() && this.bSr != null && this.bSr.bff != null && this.bSr.bff.rL() != null) {
                this.bSa.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.bSa.startLoad(this.bSr.bff.rL().thumbnail_url, 10, false);
                this.bSi.setVisibility(0);
                return;
            }
            this.bSi.setVisibility(8);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dfa != null) {
            this.dfa.setPageUniqueId(bdUniqueId);
        }
        if (this.bSa != null) {
            this.bSa.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dfa != null) {
            return this.dfa.getHeaderImg();
        }
        return null;
    }

    public View ZM() {
        if (this.dfa != null) {
            return this.dfa.anN;
        }
        return null;
    }
}
