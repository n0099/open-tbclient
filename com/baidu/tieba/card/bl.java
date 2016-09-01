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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class bl extends com.baidu.tieba.card.a<com.baidu.tieba.card.data.o> {
    private TbPageContext<?> Gd;
    private CustomMessageListener aZB;
    private com.baidu.tieba.card.data.o aZr;
    private final View.OnClickListener ahR;
    private final View.OnClickListener ahu;
    private final String bas;
    public a bat;
    private int mSkinType;

    public bl(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bas = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
        this.mSkinType = 3;
        this.ahR = new bm(this);
        this.aZB = new bn(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.ahu = new bo(this);
        this.Gd = tbPageContext;
        this.bat = new a();
        R(getView());
    }

    private void R(View view) {
        this.bat.bav = view.findViewById(t.g.layout_root);
        this.bat.aZi = view.findViewById(t.g.divider);
        this.bat.aZc = (ClickableHeaderImageView) view.findViewById(t.g.image_user);
        this.bat.aYe = (ViewStub) view.findViewById(t.g.viewstub_headimage_mask);
        this.bat.aZc.setDefaultResource(17170445);
        this.bat.aZc.setDefaultErrorResource(t.f.icon_default_avatar100);
        this.bat.aZc.setDefaultBgResource(t.d.cp_bg_line_e);
        this.bat.aZc.setRadius(com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), t.e.ds70));
        this.bat.aZf = (UserIconLayout) view.findViewById(t.g.text_user_name);
        this.bat.mTextTitle = (TextView) view.findViewById(t.g.text_title);
        this.bat.aZd = (ThreadCommentAndPraiseInfoLayout) view.findViewById(t.g.text_bottom);
        this.bat.aZe = (FrameLayout) view.findViewById(t.g.frame_video);
        this.bat.aZj = (TbImageView) view.findViewById(t.g.image_video);
        this.bat.aZj.setDefaultBgResource(t.f.pic_bg_video_frs);
        this.bat.aZj.setDefaultResource(0);
        this.bat.aZj.setDefaultErrorResource(0);
        this.bat.aZk = (ImageView) view.findViewById(t.g.image_video_play);
        this.bat.bav.setOnClickListener(this);
        this.bat.aZe.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bat.bav) {
            T(view);
        } else if (view == this.bat.aZe) {
            U(view);
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        if (this.bat != null && this.bat.aZd != null) {
            this.bat.aZd.setBarNameClickEnabled(z);
        }
    }

    private void T(View view) {
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.aZr);
        }
        if (this.aZr != null && this.aZr.bbC != null) {
            if (!Nv()) {
                ap.hG(this.aZr.bbC.getId());
            }
            this.Gd.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.Gd.getPageActivity()).createFromThreadCfg(this.aZr.bbC, null, ap.ND(), 18003, true, false, false).addLocateParam(this.aZr.NK())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Nv() {
        return this.aZr.bbU && !this.aZr.bcg;
    }

    private void U(View view) {
        if (this.aZr != null && this.aZr.bbC != null && this.aZr.bbC.rR() != null) {
            cf<com.baidu.tieba.card.data.o> onSubCardOnClickListenner = getOnSubCardOnClickListenner();
            if (onSubCardOnClickListenner != null) {
                view.setTag(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                onSubCardOnClickListenner.a(view, this.aZr);
            }
            if (!com.baidu.adp.lib.util.i.gm()) {
                com.baidu.adp.lib.util.k.m(getContext(), getContext().getString(t.j.neterror));
            } else {
                XiaoyingUtil.startPlayXiaoyingVideo(this.Gd.getPageActivity(), this.aZr.bbC.rR().video_url, this.aZr.bbC.rR().video_width.intValue(), this.aZr.bbC.rR().video_height.intValue(), this.aZr.bbC.rR().thumbnail_url);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return t.h.card_home_page_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.o oVar) {
        this.aZr = oVar;
        Ny();
    }

    private void Ny() {
        if (this.aZr == null || this.aZr.bbC == null || this.aZr.bbC.getAuthor() == null) {
            this.bat.bav.setVisibility(8);
            return;
        }
        this.bat.bav.setVisibility(0);
        if (this.aZr.bbU) {
            this.bat.aZc.setVisibility(8);
            this.bat.aZf.setVisibility(8);
        } else {
            this.bat.aZf.setVisibility(0);
            this.bat.aZc.setVisibility(0);
            this.bat.aZc.setData(this.aZr.bbC);
            this.bat.aZc.setAfterClickListener(this.ahR);
            UserTbVipInfoData rC = this.aZr.Kw().rC();
            if (rC != null && rC.getvipV_url() != null && this.bat.aYe != null) {
                if (this.bat.aYf == null) {
                    this.bat.aYe.inflate();
                    this.bat.aYf = (TbImageView) getView().findViewById(t.g.user_head_mask);
                }
                this.bat.aYf.c(rC.getvipV_url(), 10, false);
                this.bat.aZc.setIsBigV(true);
            }
        }
        this.bat.aZf.setData(this.aZr.bbC);
        this.bat.aZf.setUserAfterClickListener(this.ahR);
        this.bat.mTextTitle.setText(this.aZr.bbC.getTitle());
        this.bat.aZd.setData(this.aZr.bbC);
        this.bat.aZd.setStType(ap.ND());
        this.bat.aZd.setYuelaouLocate("feed#" + this.aZr.NJ());
        this.bat.aZd.setForumAfterClickListener(this.ahu);
        onChangeSkinType(this.Gd, TbadkCoreApplication.m9getInst().getSkinType());
        if (!Nv()) {
            ap.a(this.bat.mTextTitle, this.aZr.bbC.getId(), t.d.cp_cont_b, t.d.cp_cont_d);
        } else {
            com.baidu.tbadk.core.util.av.j((View) this.bat.mTextTitle, t.d.cp_cont_b);
        }
        if (com.baidu.tbadk.core.l.oG().oM() && this.aZr.bbC.rR() != null && !StringUtils.isNull(this.aZr.bbC.rR().video_url)) {
            this.bat.aZj.c(this.aZr.bbC.rR().thumbnail_url, 10, true);
            this.bat.aZe.setVisibility(0);
        } else {
            this.bat.aZe.setVisibility(8);
        }
        if (this.aZr.bcg) {
            setBarNameClickEnabled(true);
        } else {
            setBarNameClickEnabled(false);
        }
        this.bat.aZe.setClickable(false);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(this.bat.bav, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.l(this.bat.aZi, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.j((View) this.bat.mTextTitle, t.d.cp_cont_b);
            com.baidu.tbadk.core.util.av.c(this.bat.aZk, t.f.btn_icon_play_video_n);
            this.bat.aZf.ti();
            this.bat.aZd.ti();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bat != null && this.bat.aZd != null && this.aZB != null) {
            this.bat.aZd.h(bdUniqueId);
            this.aZB.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aZB);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public ViewStub aYe;
        public TbImageView aYf;
        public ClickableHeaderImageView aZc;
        public ThreadCommentAndPraiseInfoLayout aZd;
        public FrameLayout aZe;
        public UserIconLayout aZf;
        public View aZi;
        public TbImageView aZj;
        public ImageView aZk;
        public View bav;
        public TextView mTextTitle;

        public a() {
        }
    }
}
