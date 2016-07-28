package com.baidu.tieba.card;

import android.view.View;
import android.view.ViewStub;
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
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class bp extends com.baidu.tieba.card.a<com.baidu.tieba.card.a.o> {
    private TbPageContext<?> DQ;
    private com.baidu.tieba.card.a.o aUj;
    private CustomMessageListener aUs;
    private final String aVf;
    public a aVg;
    private final View.OnClickListener aeW;
    private final View.OnClickListener aez;
    private int mSkinType;

    public bp(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aVf = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
        this.mSkinType = 3;
        this.aeW = new bq(this);
        this.aUs = new br(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.aez = new bs(this);
        this.DQ = tbPageContext;
        this.aVg = new a();
        Q(getView());
    }

    private void Q(View view) {
        this.aVg.aVi = view.findViewById(u.g.layout_root);
        this.aVg.aUa = view.findViewById(u.g.divider);
        this.aVg.aTU = (ClickableHeaderImageView) view.findViewById(u.g.image_user);
        this.aVg.aSW = (ViewStub) view.findViewById(u.g.viewstub_headimage_mask);
        this.aVg.aTU.setDefaultResource(17170445);
        this.aVg.aTU.setDefaultErrorResource(u.f.icon_default_avatar100);
        this.aVg.aTU.setDefaultBgResource(u.d.cp_bg_line_e);
        this.aVg.aTU.setRadius(com.baidu.adp.lib.util.k.c(this.DQ.getPageActivity(), u.e.ds70));
        this.aVg.aTX = (UserIconLayout) view.findViewById(u.g.text_user_name);
        this.aVg.mTextTitle = (TextView) view.findViewById(u.g.text_title);
        this.aVg.aTV = (ThreadCommentAndPraiseInfoLayout) view.findViewById(u.g.text_bottom);
        this.aVg.aTW = (FrameLayout) view.findViewById(u.g.frame_video);
        this.aVg.aUb = (TbImageView) view.findViewById(u.g.image_video);
        this.aVg.aUb.setDefaultBgResource(u.f.pic_bg_video_frs);
        this.aVg.aUb.setDefaultResource(0);
        this.aVg.aUb.setDefaultErrorResource(0);
        this.aVg.aUc = (ImageView) view.findViewById(u.g.image_video_play);
        this.aVg.aVi.setOnClickListener(this);
        this.aVg.aTW.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aVg.aVi) {
            U(view);
        } else if (view == this.aVg.aTW) {
            V(view);
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        if (this.aVg != null && this.aVg.aTV != null) {
            this.aVg.aTV.setBarNameClickEnabled(z);
        }
    }

    private void U(View view) {
        if (KN() != null) {
            KN().a(view, this.aUj);
        }
        if (this.aUj != null && this.aUj.aWa != null) {
            if (!KT()) {
                at.hb(this.aUj.aWa.getId());
            }
            this.DQ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.DQ.getPageActivity()).createFromThreadCfg(this.aUj.aWa, null, at.La(), 18003, true, false, false).addLocateParam(this.aUj.Lh())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean KT() {
        return this.aUj.aWs && !this.aUj.aWE;
    }

    private void V(View view) {
        if (this.aUj != null && this.aUj.aWa != null && this.aUj.aWa.qM() != null) {
            bx<com.baidu.tieba.card.a.o> KN = KN();
            if (KN != null) {
                view.setTag(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                KN.a(view, this.aUj);
            }
            if (!com.baidu.adp.lib.util.i.fq()) {
                com.baidu.adp.lib.util.k.m(getContext(), getContext().getString(u.j.neterror));
            } else {
                XiaoyingUtil.startPlayXiaoyingVideo(this.DQ.getPageActivity(), this.aUj.aWa.qM().video_url, this.aUj.aWa.qM().video_width.intValue(), this.aUj.aWa.qM().video_height.intValue(), this.aUj.aWa.qM().thumbnail_url);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_home_page_video_thread;
    }

    public void a(com.baidu.tieba.card.a.o oVar) {
        this.aUj = oVar;
        KW();
    }

    private void KW() {
        if (this.aUj == null || this.aUj.aWa == null || this.aUj.aWa.getAuthor() == null) {
            this.aVg.aVi.setVisibility(8);
            return;
        }
        this.aVg.aVi.setVisibility(0);
        if (this.aUj.aWs) {
            this.aVg.aTU.setVisibility(8);
            this.aVg.aTX.setVisibility(8);
        } else {
            this.aVg.aTX.setVisibility(0);
            this.aVg.aTU.setVisibility(0);
            this.aVg.aTU.setData(this.aUj.aWa);
            this.aVg.aTU.setAfterClickListener(this.aeW);
            UserTbVipInfoData qx = this.aUj.Iw().qx();
            if (qx != null && qx.getvipV_url() != null && this.aVg.aSW != null) {
                if (this.aVg.aSX == null) {
                    this.aVg.aSW.inflate();
                    this.aVg.aSX = (TbImageView) getView().findViewById(u.g.user_head_mask);
                }
                this.aVg.aSX.c(qx.getvipV_url(), 10, false);
                this.aVg.aTU.setIsBigV(true);
            }
        }
        this.aVg.aTX.setData(this.aUj.aWa);
        this.aVg.aTX.setUserAfterClickListener(this.aeW);
        this.aVg.mTextTitle.setText(this.aUj.aWa.getTitle());
        this.aVg.aTV.setData(this.aUj.aWa);
        this.aVg.aTV.setStType(at.La());
        this.aVg.aTV.setYuelaouLocate("feed#" + this.aUj.Lg());
        this.aVg.aTV.setForumAfterClickListener(this.aez);
        d(this.DQ, TbadkCoreApplication.m10getInst().getSkinType());
        if (!KT()) {
            at.a(this.aVg.mTextTitle, this.aUj.aWa.getId(), u.d.cp_cont_b, u.d.cp_cont_d);
        } else {
            com.baidu.tbadk.core.util.av.j((View) this.aVg.mTextTitle, u.d.cp_cont_b);
        }
        if (com.baidu.tbadk.core.l.nL().nR() && this.aUj.aWa.qM() != null && !StringUtils.isNull(this.aUj.aWa.qM().video_url)) {
            this.aVg.aUb.c(this.aUj.aWa.qM().thumbnail_url, 10, true);
            this.aVg.aTW.setVisibility(0);
        } else {
            this.aVg.aTW.setVisibility(8);
        }
        if (this.aUj.aWE) {
            setBarNameClickEnabled(true);
        } else {
            setBarNameClickEnabled(false);
        }
        this.aVg.aTW.setClickable(false);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(this.aVg.aVi, u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.l(this.aVg.aUa, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.j((View) this.aVg.mTextTitle, u.d.cp_cont_b);
            com.baidu.tbadk.core.util.av.c(this.aVg.aUc, u.f.btn_icon_play_video_n);
            this.aVg.aTX.sd();
            this.aVg.aTV.sd();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aVg != null && this.aVg.aTV != null && this.aUs != null) {
            this.aVg.aTV.h(bdUniqueId);
            this.aUs.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aUs);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public ViewStub aSW;
        public TbImageView aSX;
        public ClickableHeaderImageView aTU;
        public ThreadCommentAndPraiseInfoLayout aTV;
        public FrameLayout aTW;
        public UserIconLayout aTX;
        public View aUa;
        public TbImageView aUb;
        public ImageView aUc;
        public View aVi;
        public TextView mTextTitle;

        public a() {
        }
    }
}
