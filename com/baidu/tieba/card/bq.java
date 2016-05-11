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
public class bq extends com.baidu.tieba.card.a<com.baidu.tieba.card.a.n> {
    private TbPageContext<?> Do;
    private com.baidu.tieba.card.a.n aPR;
    private final String aQN;
    public a aQO;
    private CustomMessageListener aQc;
    private final View.OnClickListener adK;
    private final View.OnClickListener adn;
    private int mSkinType;

    public bq(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aQN = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
        this.mSkinType = 3;
        this.adK = new br(this);
        this.aQc = new bs(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.adn = new bt(this);
        this.Do = tbPageContext;
        this.aQO = new a();
        w(getView());
    }

    private void w(View view) {
        this.aQO.aQQ = view.findViewById(t.g.layout_root);
        this.aQO.aPI = view.findViewById(t.g.divider);
        this.aQO.aPC = (ClickableHeaderImageView) view.findViewById(t.g.image_user);
        this.aQO.aPC.setDefaultResource(17170445);
        this.aQO.aPC.setDefaultErrorResource(t.f.icon_default_avatar100);
        this.aQO.aPC.setDefaultBgResource(t.d.cp_bg_line_e);
        this.aQO.aPC.setRadius(com.baidu.adp.lib.util.k.c(this.Do.getPageActivity(), t.e.ds70));
        this.aQO.aPF = (UserIconLayout) view.findViewById(t.g.text_user_name);
        this.aQO.mTextTitle = (TextView) view.findViewById(t.g.text_title);
        this.aQO.aPD = (ThreadCommentAndPraiseInfoLayout) view.findViewById(t.g.text_bottom);
        this.aQO.aPE = (FrameLayout) view.findViewById(t.g.frame_video);
        this.aQO.aPJ = (TbImageView) view.findViewById(t.g.image_video);
        this.aQO.aPJ.setDefaultBgResource(t.f.pic_bg_video_frs);
        this.aQO.aPJ.setDefaultResource(0);
        this.aQO.aPJ.setDefaultErrorResource(0);
        this.aQO.aPK = (ImageView) view.findViewById(t.g.image_video_play);
        this.aQO.aQQ.setOnClickListener(this);
        this.aQO.aPE.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aQO.aQQ) {
            T(view);
        } else if (view == this.aQO.aPE) {
            U(view);
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        if (this.aQO != null && this.aQO.aPD != null) {
            this.aQO.aPD.setBarNameClickEnabled(z);
        }
    }

    private void T(View view) {
        if (JM() != null) {
            JM().a(view, this.aPR);
        }
        if (this.aPR != null && this.aPR.aRZ != null) {
            if (!JT()) {
                au.hb(this.aPR.aRZ.getId());
            }
            this.Do.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.Do.getPageActivity()).createFromThreadCfg(this.aPR.aRZ, this.aPR.aRZ.qP(), au.Kb(), 18003, true, false, false).addLocateParam(this.aPR.Ki())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean JT() {
        return this.aPR.aRY && !this.aPR.aSl;
    }

    private void U(View view) {
        if (this.aPR != null && this.aPR.aRZ != null && this.aPR.aRZ.ra() != null) {
            by<com.baidu.tieba.card.a.n> JM = JM();
            if (JM != null) {
                view.setTag(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                JM.a(view, this.aPR);
            }
            if (!com.baidu.adp.lib.util.i.fq()) {
                com.baidu.adp.lib.util.k.l(getContext(), getContext().getString(t.j.neterror));
            } else {
                XiaoyingUtil.startPlayXiaoyingVideo(this.Do.getPageActivity(), this.aPR.aRZ.ra().video_url, this.aPR.aRZ.ra().video_width.intValue(), this.aPR.aRZ.ra().video_height.intValue(), this.aPR.aRZ.ra().thumbnail_url);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int JN() {
        return t.h.card_home_page_video_thread;
    }

    public void a(com.baidu.tieba.card.a.n nVar) {
        this.aPR = nVar;
        JW();
    }

    private void JW() {
        if (this.aPR == null || this.aPR.aRZ == null || this.aPR.aRZ.getAuthor() == null) {
            this.aQO.aQQ.setVisibility(8);
            return;
        }
        this.aQO.aQQ.setVisibility(0);
        if (this.aPR.aRY) {
            this.aQO.aPC.setVisibility(8);
            this.aQO.aPF.setVisibility(8);
        } else {
            this.aQO.aPF.setVisibility(0);
            this.aQO.aPC.setVisibility(0);
            this.aQO.aPC.setData(this.aPR.aRZ);
            this.aQO.aPC.setAfterClickListener(this.adK);
        }
        this.aQO.aPF.setData(this.aPR.aRZ);
        this.aQO.aPF.setUserAfterClickListener(this.adK);
        this.aQO.mTextTitle.setText(this.aPR.aRZ.getTitle());
        this.aQO.aPD.setData(this.aPR.aRZ);
        this.aQO.aPD.setStType(au.Kb());
        this.aQO.aPD.setYuelaouLocate("feed#" + this.aPR.Kh());
        this.aQO.aPD.setForumAfterClickListener(this.adn);
        d(this.Do, TbadkCoreApplication.m11getInst().getSkinType());
        if (!JT()) {
            au.a(this.aQO.mTextTitle, this.aPR.aRZ.getId(), t.d.cp_cont_b, t.d.cp_cont_d);
        } else {
            com.baidu.tbadk.core.util.at.j((View) this.aQO.mTextTitle, t.d.cp_cont_b);
        }
        if (com.baidu.tbadk.core.l.ob().oh() && this.aPR.aRZ.ra() != null && !StringUtils.isNull(this.aPR.aRZ.ra().video_url)) {
            this.aQO.aPJ.c(this.aPR.aRZ.ra().thumbnail_url, 10, true);
            this.aQO.aPE.setVisibility(0);
        } else {
            this.aQO.aPE.setVisibility(8);
        }
        if (this.aPR.aSl) {
            setBarNameClickEnabled(true);
        } else {
            setBarNameClickEnabled(false);
        }
        this.aQO.aPE.setClickable(false);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.k(this.aQO.aQQ, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.l(this.aQO.aPI, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.j((View) this.aQO.mTextTitle, t.d.cp_cont_b);
            com.baidu.tbadk.core.util.at.c(this.aQO.aPK, t.f.btn_icon_play_video_n);
            this.aQO.aPF.sf();
            this.aQO.aPD.sf();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aQO != null && this.aQO.aPD != null && this.aQc != null) {
            this.aQO.aPD.h(bdUniqueId);
            this.aQc.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aQc);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public ClickableHeaderImageView aPC;
        public ThreadCommentAndPraiseInfoLayout aPD;
        public FrameLayout aPE;
        public UserIconLayout aPF;
        public View aPI;
        public TbImageView aPJ;
        public ImageView aPK;
        public View aQQ;
        public TextView mTextTitle;

        public a() {
        }
    }
}
