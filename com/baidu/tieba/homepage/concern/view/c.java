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
    public FrameLayout bEJ;
    private TbImageView bEK;
    private ImageView bEL;
    private TbImageView.a bEN;
    private HeadPendantClickableView bGw;
    private ThreadGodReplyLayout bGx;
    private View bGy;
    private n bHE;
    private final View.OnClickListener bHQ;
    private final View.OnClickListener bHR;
    private TextView bHy;
    private View bhk;
    private RelativeLayout bkR;
    public ThreadCommentAndPraiseInfoLayout ble;
    public ConcernThreadUserInfoLayout cSG;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bEN = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && c.this.bEK != null) {
                    c.this.bEK.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bHQ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.Wx() != null) {
                    c.this.Wx().a(view, c.this.bHE);
                }
            }
        };
        this.bHR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.Wx() != null) {
                    c.this.Wx().a(view, c.this.bHE);
                }
            }
        };
        this.aoH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bHE != null && c.this.Wx() != null) {
                    c.this.Wx().a(view, c.this.bHE);
                }
            }
        };
        this.acr = tbPageContext;
        View view = getView();
        this.bkR = (RelativeLayout) view.findViewById(d.h.layout_root);
        this.bGw = (HeadPendantClickableView) this.bkR.findViewById(d.h.card_home_page_video_user_pendant_header);
        if (this.bGw.getHeadView() != null) {
            this.bGw.getHeadView().setIsRound(true);
            this.bGw.getHeadView().setDrawBorder(false);
            this.bGw.getHeadView().setDefaultResource(17170445);
            this.bGw.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bGw.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bGw.getHeadView().setRadius(k.g(this.acr.getPageActivity(), d.f.ds70));
        }
        if (this.bGw.getPendantView() != null) {
            this.bGw.getPendantView().setIsRound(true);
            this.bGw.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.cSG = (ConcernThreadUserInfoLayout) view.findViewById(d.h.card_concern_video_user_info_layout);
        this.ble = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        if (this.ble.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ble.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ble.setLayoutParams(layoutParams);
        }
        this.ble.setOnClickListener(this);
        this.ble.setReplyTimeVisible(false);
        this.ble.setShowPraiseNum(true);
        this.ble.setIsBarViewVisible(false);
        this.ble.setNeedAddPraiseIcon(true);
        this.ble.setNeedAddReplyIcon(true);
        this.ble.setReplyIcon(d.g.icon_home_card_comment_n);
        this.ble.setForumAfterClickListener(this.aoH);
        this.bGy = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bkR.setOnClickListener(this);
        this.bEJ = (FrameLayout) view.findViewById(d.h.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bEJ.getLayoutParams();
        layoutParams2.width = k.ag(this.acr.getPageActivity()) - k.g(this.acr.getPageActivity(), d.f.ds68);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bEJ.setLayoutParams(layoutParams2);
        this.bEK = (TbImageView) view.findViewById(d.h.image_video);
        this.bEK.setDefaultErrorResource(0);
        this.bEK.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bEK.setGifIconSupport(false);
        this.bEK.setEvent(this.bEN);
        this.bEL = (ImageView) view.findViewById(d.h.image_video_play);
        this.bHy = (TextView) view.findViewById(d.h.text_video_duration);
        this.bhk = view.findViewById(d.h.divider_line);
        this.bGx = (ThreadGodReplyLayout) view.findViewById(d.h.card_god_reply_layout);
        this.bGx.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.bkR, d.g.addresslist_item_bg);
            ai.c(this.bEL, d.g.home_ic_video);
            this.cSG.onChangeSkinType();
            this.ble.onChangeSkinType();
            ai.j(this.bhk, d.e.cp_bg_line_c);
            ai.i(this.bHy, d.e.cp_cont_i);
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
        this.bHE = nVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bkR || view == this.bGx) {
            W(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    private boolean WB() {
        return this.bHE.bKs && !this.bHE.bKG;
    }

    private void W(View view) {
        if (Wx() != null) {
            Wx().a(view, this.bHE);
        }
        if (this.bHE != null && this.bHE.bcN != null) {
            if (!WB()) {
                m.jh(this.bHE.bcN.getId());
                m.a(this.mTextTitle, this.bHE.bcN.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.acr.getPageActivity()).createFromThreadCfg(this.bHE.bcN, null, m.rx(), 18003, true, false, false).addLocateParam(this.bHE.WZ());
            addLocateParam.setVideo_source("concern_tab");
            addLocateParam.setForumId(String.valueOf(this.bHE.bcN.getFid()));
            addLocateParam.setForumName(this.bHE.bcN.rL());
            if (this.bHE.bKa == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bHE.bKa);
            }
            if (view == this.bGx) {
                addLocateParam.setJumpGodReply(true);
            }
            this.acr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void refreshView() {
        if (this.bHE == null || this.bHE.bcN == null || this.bHE.bcN.getAuthor() == null || this.bHE.bcN.rX() == null) {
            this.bkR.setVisibility(8);
            return;
        }
        this.bkR.setVisibility(0);
        WJ();
        if (!WB() && m.ji(this.bHE.bcN.getId())) {
            m.a(this.mTextTitle, this.bHE.bcN.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bGx.getGodReplyContent(), this.bHE.MF().getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bGx.getPraiseNum(), this.bHE.MF().getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.bHE.MF().so();
        this.mTextTitle.setText(this.bHE.MF().sg());
        this.cSG.a(this.bHE.MF());
        this.cSG.setUserAfterClickListener(this.bHQ);
        if (this.cSG.getHeaderImg() != null) {
            this.cSG.getHeaderImg().setAfterClickListener(this.bHR);
            if (this.cSG.getIsSimpleThread()) {
                this.cSG.getHeaderImg().setVisibility(8);
                this.bGw.setVisibility(8);
            } else if (this.bHE.MF() == null || this.bHE.MF().getAuthor() == null || this.bHE.MF().getAuthor().getPendantData() == null || StringUtils.isNull(this.bHE.MF().getAuthor().getPendantData().pW())) {
                this.bGw.setVisibility(8);
                this.cSG.getHeaderImg().setVisibility(0);
                this.cSG.getHeaderImg().setData(this.bHE.MF());
            } else {
                this.cSG.getHeaderImg().setVisibility(4);
                this.bGw.setVisibility(0);
                this.bGw.setData(this.bHE.MF());
            }
        }
        this.bHy.setText(al.cZ(this.bHE.bcN.rX().video_duration.intValue() * 1000));
        if (this.ble.a(this.bHE.bcN)) {
            this.bGy.setVisibility(8);
        } else {
            this.bGy.setVisibility(0);
        }
        this.bGx.setData(this.bHE.MF().sV());
        this.bGx.onChangeSkinType();
        if (this.bGx.getVisibility() == 0) {
            this.bGy.setVisibility(0);
        }
        d(this.acr, TbadkCoreApplication.getInst().getSkinType());
        if (m.ji(this.bHE.bcN.getId())) {
            ai.c(this.mTextTitle, d.e.cp_cont_d, 1);
        } else {
            ai.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
    }

    private void WJ() {
        if (this.bEK != null && this.bEJ != null) {
            if (h.oY().pe() && this.bHE != null && this.bHE.bcN != null && this.bHE.bcN.rX() != null) {
                this.bEK.setDefaultBgResource(d.g.pic_bg_video_frs);
                this.bEK.c(this.bHE.bcN.rX().thumbnail_url, 10, false);
                this.bEJ.setVisibility(0);
                return;
            }
            this.bEJ.setVisibility(8);
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
        if (this.bEK != null) {
            this.bEK.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cSG != null) {
            return this.cSG.getHeaderImg();
        }
        return null;
    }

    public View WA() {
        if (this.cSG != null) {
            return this.cSG.aoT;
        }
        return null;
    }
}
