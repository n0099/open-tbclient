package com.baidu.tieba.card;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class by extends com.baidu.tieba.card.a<com.baidu.tieba.card.a.v> {
    private TbPageContext<?> MX;
    private com.baidu.tieba.card.a.v aTD;
    private CustomMessageListener aTI;
    private final String aUt;
    public a aUu;
    private final View.OnClickListener ahQ;
    private final View.OnClickListener ahw;
    private int mSkinType;

    public by(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aUt = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
        this.mSkinType = 3;
        this.ahQ = new bz(this);
        this.aTI = new ca(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.ahw = new cb(this);
        this.MX = tbPageContext;
        this.aUu = new a();
        w(getView());
    }

    private void w(View view) {
        this.aUu.aUw = view.findViewById(t.g.layout_root);
        this.aUu.aTu = view.findViewById(t.g.divider);
        this.aUu.aTo = (ClickableHeaderImageView) view.findViewById(t.g.image_user);
        this.aUu.aTo.setDefaultResource(17170445);
        this.aUu.aTo.setDefaultErrorResource(t.f.icon_default_avatar100);
        this.aUu.aTo.setDefaultBgResource(t.d.cp_bg_line_e);
        this.aUu.aTo.setRadius(com.baidu.adp.lib.util.k.c(this.MX.getPageActivity(), t.e.ds70));
        this.aUu.aTr = (UserIconLayout) view.findViewById(t.g.text_user_name);
        this.aUu.mTextTitle = (TextView) view.findViewById(t.g.text_title);
        this.aUu.aTp = (ThreadCommentAndPraiseInfoLayout) view.findViewById(t.g.text_bottom);
        this.aUu.aTq = (FrameLayout) view.findViewById(t.g.frame_video);
        this.aUu.aTv = (TbImageView) view.findViewById(t.g.image_video);
        this.aUu.aTv.setDefaultBgResource(t.f.pic_bg_video_frs);
        this.aUu.aTv.setDefaultResource(0);
        this.aUu.aTw = (ImageView) view.findViewById(t.g.image_video_play);
        this.aUu.aUw.setOnClickListener(this);
        this.aUu.aTq.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aUu.aUw) {
            R(view);
        } else if (view == this.aUu.aTq) {
            S(view);
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        if (this.aUu != null && this.aUu.aTp != null) {
            this.aUu.aTp.setBarNameClickEnabled(z);
        }
    }

    private void R(View view) {
        if (Ld() != null) {
            Ld().a(view, this.aTD);
        }
        if (this.aTD != null && this.aTD.aWf != null) {
            if (!Lm()) {
                bc.ha(this.aTD.aWf.getId());
            }
            this.MX.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.MX.getPageActivity()).createFromThreadCfg(this.aTD.aWf, this.aTD.aWf.tr(), bc.Ls(), 18003, true, false, false).addLocateParam(this.aTD.Lz())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Lm() {
        return this.aTD.aWe && !this.aTD.aWr;
    }

    private void S(View view) {
        if (this.aTD != null && this.aTD.aWf != null && this.aTD.aWf.tC() != null) {
            cj<com.baidu.tieba.card.a.v> Ld = Ld();
            if (Ld != null) {
                view.setTag(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                Ld.a(view, this.aTD);
            }
            if (!com.baidu.adp.lib.util.i.jf()) {
                com.baidu.adp.lib.util.k.l(getContext(), getContext().getString(t.j.neterror));
            } else {
                XiaoyingUtil.startPlayXiaoyingVideo(this.MX.getPageActivity(), this.aTD.aWf.tC().video_url, this.aTD.aWf.tC().video_width.intValue(), this.aTD.aWf.tC().video_height.intValue(), this.aTD.aWf.tC().thumbnail_url);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int Le() {
        return t.h.card_home_page_video_thread;
    }

    public void a(com.baidu.tieba.card.a.v vVar) {
        this.aTD = vVar;
        Lp();
    }

    private void Lp() {
        if (this.aTD == null || this.aTD.aWf == null || this.aTD.aWf.getAuthor() == null) {
            this.aUu.aUw.setVisibility(8);
            return;
        }
        this.aUu.aUw.setVisibility(0);
        if (this.aTD.aWe) {
            this.aUu.aTo.setVisibility(8);
            this.aUu.aTr.setVisibility(8);
        } else {
            this.aUu.aTr.setVisibility(0);
            this.aUu.aTo.setVisibility(0);
            this.aUu.aTo.setData(this.aTD.aWf);
            this.aUu.aTo.setAfterClickListener(this.ahQ);
        }
        this.aUu.aTr.setData(this.aTD.aWf);
        this.aUu.aTr.setUserAfterClickListener(this.ahQ);
        this.aUu.mTextTitle.setText(this.aTD.aWf.getTitle());
        this.aUu.aTp.setData(this.aTD.aWf);
        this.aUu.aTp.setStType(bc.Ls());
        this.aUu.aTp.setYuelaouLocate("feed#" + this.aTD.Ly());
        this.aUu.aTp.setForumAfterClickListener(this.ahw);
        d(this.MX, TbadkCoreApplication.m411getInst().getSkinType());
        if (!Lm()) {
            bc.a(this.aUu.mTextTitle, this.aTD.aWf.getId(), t.d.cp_cont_b, t.d.cp_cont_d);
        } else {
            com.baidu.tbadk.core.util.at.j((View) this.aUu.mTextTitle, t.d.cp_cont_b);
        }
        if (com.baidu.tbadk.core.l.qE().qK() && this.aTD.aWf.tC() != null && !StringUtils.isNull(this.aTD.aWf.tC().video_url)) {
            this.aUu.aTv.c(this.aTD.aWf.tC().thumbnail_url, 10, true);
            this.aUu.aTq.setVisibility(0);
        } else {
            this.aUu.aTq.setVisibility(8);
        }
        if (this.aTD.aWr) {
            setBarNameClickEnabled(true);
        } else {
            setBarNameClickEnabled(false);
        }
        this.aUu.aTq.setClickable(false);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.k(this.aUu.aUw, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.l(this.aUu.aTu, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.j((View) this.aUu.mTextTitle, t.d.cp_cont_b);
            com.baidu.tbadk.core.util.at.c(this.aUu.aTw, t.f.btn_icon_play_video_n);
            this.aUu.aTr.uA();
            this.aUu.aTp.uA();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aUu != null && this.aUu.aTp != null && this.aTI != null) {
            this.aUu.aTp.h(bdUniqueId);
            this.aTI.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aTI);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public ClickableHeaderImageView aTo;
        public ThreadCommentAndPraiseInfoLayout aTp;
        public FrameLayout aTq;
        public UserIconLayout aTr;
        public View aTu;
        public TbImageView aTv;
        public ImageView aTw;
        public View aUw;
        public TextView mTextTitle;

        public a() {
        }
    }
}
