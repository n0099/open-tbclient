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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class bp extends com.baidu.tieba.card.a<com.baidu.tieba.card.a.o> {
    private TbPageContext<?> Dp;
    private com.baidu.tieba.card.a.o aTn;
    private CustomMessageListener aTw;
    private final String aUj;
    public a aUk;
    private final View.OnClickListener adL;
    private final View.OnClickListener aei;
    private int mSkinType;

    public bp(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aUj = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
        this.mSkinType = 3;
        this.aei = new bq(this);
        this.aTw = new br(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.adL = new bs(this);
        this.Dp = tbPageContext;
        this.aUk = new a();
        Q(getView());
    }

    private void Q(View view) {
        this.aUk.aUm = view.findViewById(u.g.layout_root);
        this.aUk.aTe = view.findViewById(u.g.divider);
        this.aUk.aSY = (ClickableHeaderImageView) view.findViewById(u.g.image_user);
        this.aUk.aSY.setDefaultResource(17170445);
        this.aUk.aSY.setDefaultErrorResource(u.f.icon_default_avatar100);
        this.aUk.aSY.setDefaultBgResource(u.d.cp_bg_line_e);
        this.aUk.aSY.setRadius(com.baidu.adp.lib.util.k.c(this.Dp.getPageActivity(), u.e.ds70));
        this.aUk.aTb = (UserIconLayout) view.findViewById(u.g.text_user_name);
        this.aUk.mTextTitle = (TextView) view.findViewById(u.g.text_title);
        this.aUk.aSZ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(u.g.text_bottom);
        this.aUk.aTa = (FrameLayout) view.findViewById(u.g.frame_video);
        this.aUk.aTf = (TbImageView) view.findViewById(u.g.image_video);
        this.aUk.aTf.setDefaultBgResource(u.f.pic_bg_video_frs);
        this.aUk.aTf.setDefaultResource(0);
        this.aUk.aTf.setDefaultErrorResource(0);
        this.aUk.aTg = (ImageView) view.findViewById(u.g.image_video_play);
        this.aUk.aUm.setOnClickListener(this);
        this.aUk.aTa.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aUk.aUm) {
            U(view);
        } else if (view == this.aUk.aTa) {
            V(view);
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        if (this.aUk != null && this.aUk.aSZ != null) {
            this.aUk.aSZ.setBarNameClickEnabled(z);
        }
    }

    private void U(View view) {
        if (KO() != null) {
            KO().a(view, this.aTn);
        }
        if (this.aTn != null && this.aTn.aVc != null) {
            if (!KU()) {
                at.hb(this.aTn.aVc.getId());
            }
            this.Dp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.Dp.getPageActivity()).createFromThreadCfg(this.aTn.aVc, null, at.Lb(), 18003, true, false, false).addLocateParam(this.aTn.Li())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean KU() {
        return this.aTn.aVu && !this.aTn.aVG;
    }

    private void V(View view) {
        if (this.aTn != null && this.aTn.aVc != null && this.aTn.aVc.qW() != null) {
            bx<com.baidu.tieba.card.a.o> KO = KO();
            if (KO != null) {
                view.setTag(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                KO.a(view, this.aTn);
            }
            if (!com.baidu.adp.lib.util.i.fr()) {
                com.baidu.adp.lib.util.k.m(getContext(), getContext().getString(u.j.neterror));
            } else {
                XiaoyingUtil.startPlayXiaoyingVideo(this.Dp.getPageActivity(), this.aTn.aVc.qW().video_url, this.aTn.aVc.qW().video_width.intValue(), this.aTn.aVc.qW().video_height.intValue(), this.aTn.aVc.qW().thumbnail_url);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_home_page_video_thread;
    }

    public void a(com.baidu.tieba.card.a.o oVar) {
        this.aTn = oVar;
        KX();
    }

    private void KX() {
        if (this.aTn == null || this.aTn.aVc == null || this.aTn.aVc.getAuthor() == null) {
            this.aUk.aUm.setVisibility(8);
            return;
        }
        this.aUk.aUm.setVisibility(0);
        if (this.aTn.aVu) {
            this.aUk.aSY.setVisibility(8);
            this.aUk.aTb.setVisibility(8);
        } else {
            this.aUk.aTb.setVisibility(0);
            this.aUk.aSY.setVisibility(0);
            this.aUk.aSY.setData(this.aTn.aVc);
            this.aUk.aSY.setAfterClickListener(this.aei);
        }
        this.aUk.aTb.setData(this.aTn.aVc);
        this.aUk.aTb.setUserAfterClickListener(this.aei);
        this.aUk.mTextTitle.setText(this.aTn.aVc.getTitle());
        this.aUk.aSZ.setData(this.aTn.aVc);
        this.aUk.aSZ.setStType(at.Lb());
        this.aUk.aSZ.setYuelaouLocate("feed#" + this.aTn.Lh());
        this.aUk.aSZ.setForumAfterClickListener(this.adL);
        d(this.Dp, TbadkCoreApplication.m9getInst().getSkinType());
        if (!KU()) {
            at.a(this.aUk.mTextTitle, this.aTn.aVc.getId(), u.d.cp_cont_b, u.d.cp_cont_d);
        } else {
            com.baidu.tbadk.core.util.av.j((View) this.aUk.mTextTitle, u.d.cp_cont_b);
        }
        if (com.baidu.tbadk.core.l.nW().oc() && this.aTn.aVc.qW() != null && !StringUtils.isNull(this.aTn.aVc.qW().video_url)) {
            this.aUk.aTf.c(this.aTn.aVc.qW().thumbnail_url, 10, true);
            this.aUk.aTa.setVisibility(0);
        } else {
            this.aUk.aTa.setVisibility(8);
        }
        if (this.aTn.aVG) {
            setBarNameClickEnabled(true);
        } else {
            setBarNameClickEnabled(false);
        }
        this.aUk.aTa.setClickable(false);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(this.aUk.aUm, u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.l(this.aUk.aTe, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.j((View) this.aUk.mTextTitle, u.d.cp_cont_b);
            com.baidu.tbadk.core.util.av.c(this.aUk.aTg, u.f.btn_icon_play_video_n);
            this.aUk.aTb.se();
            this.aUk.aSZ.se();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aUk != null && this.aUk.aSZ != null && this.aTw != null) {
            this.aUk.aSZ.h(bdUniqueId);
            this.aTw.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aTw);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public ClickableHeaderImageView aSY;
        public ThreadCommentAndPraiseInfoLayout aSZ;
        public FrameLayout aTa;
        public UserIconLayout aTb;
        public View aTe;
        public TbImageView aTf;
        public ImageView aTg;
        public View aUm;
        public TextView mTextTitle;

        public a() {
        }
    }
}
