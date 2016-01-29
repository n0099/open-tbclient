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
public class ar extends com.baidu.tieba.card.a<com.baidu.tieba.card.a.s> {
    private TbPageContext<?> MR;
    private final String aQG;
    public a aQH;
    private com.baidu.tieba.card.a.s aQI;
    private CustomMessageListener aQq;
    private final View.OnClickListener ahL;
    private final View.OnClickListener ahr;
    private int mSkinType;

    public ar(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aQG = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
        this.mSkinType = 3;
        this.ahL = new as(this);
        this.aQq = new at(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.ahr = new au(this);
        this.MR = tbPageContext;
        this.aQH = new a();
        w(getView());
    }

    private void w(View view) {
        this.aQH.aQK = view.findViewById(t.g.layout_root);
        this.aQH.aQL = view.findViewById(t.g.divider);
        this.aQH.aQB = (ClickableHeaderImageView) view.findViewById(t.g.image_user);
        this.aQH.aQB.setDefaultResource(17170445);
        this.aQH.aQB.setDefaultBgResource(t.f.icon_default_avatar_round);
        this.aQH.aQB.setRadius(com.baidu.adp.lib.util.k.c(this.MR.getPageActivity(), t.e.ds70));
        this.aQH.aQQ = (UserIconLayout) view.findViewById(t.g.text_user_name);
        this.aQH.mTextTitle = (TextView) view.findViewById(t.g.text_title);
        this.aQH.aQP = (ThreadCommentAndPraiseInfoLayout) view.findViewById(t.g.text_bottom);
        this.aQH.aQM = (FrameLayout) view.findViewById(t.g.frame_video);
        this.aQH.aQN = (TbImageView) view.findViewById(t.g.image_video);
        this.aQH.aQN.setDefaultBgResource(t.f.pic_bg_video_frs);
        this.aQH.aQN.setDefaultResource(0);
        this.aQH.aQO = (ImageView) view.findViewById(t.g.image_video_play);
        this.aQH.aQK.setOnClickListener(this);
        this.aQH.aQM.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aQH.aQK) {
            N(view);
        } else if (view == this.aQH.aQM) {
            O(view);
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        if (this.aQH != null && this.aQH.aQP != null) {
            this.aQH.aQP.setBarNameClickEnabled(z);
        }
    }

    private void N(View view) {
        if (JL() != null) {
            JL().a(view, this.aQI);
        }
        if (this.aQI != null && this.aQI.aSu != null) {
            if (!JY()) {
                ae.gO(this.aQI.aSu.getId());
            }
            this.MR.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.MR.getPageActivity()).createFromThreadCfg(this.aQI.aSu, this.aQI.aSu.tn(), ae.JV(), 18003, true, false, false).addLocateParam(this.aQI.Kf())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean JY() {
        return this.aQI.aSt && !this.aQI.aSF;
    }

    private void O(View view) {
        if (this.aQI != null && this.aQI.aSu != null && this.aQI.aSu.tz() != null) {
            bb<com.baidu.tieba.card.a.s> JL = JL();
            if (JL != null) {
                view.setTag(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                JL.a(view, this.aQI);
            }
            if (!com.baidu.adp.lib.util.i.iZ()) {
                com.baidu.adp.lib.util.k.u(getContext(), getContext().getString(t.j.neterror));
            } else {
                XiaoyingUtil.startPlayXiaoyingVideo(this.MR.getPageActivity(), this.aQI.aSu.tz().video_url, this.aQI.aSu.tz().video_width.intValue(), this.aQI.aSu.tz().video_height.intValue(), this.aQI.aSu.tz().thumbnail_url);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int JM() {
        return t.h.card_home_page_video_thread;
    }

    public void a(com.baidu.tieba.card.a.s sVar) {
        this.aQI = sVar;
        JZ();
    }

    private void JZ() {
        if (this.aQI == null || this.aQI.aSu == null || this.aQI.aSu.getAuthor() == null) {
            this.aQH.aQK.setVisibility(8);
            return;
        }
        this.aQH.aQK.setVisibility(0);
        if (this.aQI.aSt) {
            this.aQH.aQB.setVisibility(8);
            this.aQH.aQQ.setVisibility(8);
        } else {
            this.aQH.aQQ.setVisibility(0);
            this.aQH.aQB.setVisibility(0);
            this.aQH.aQB.setData(this.aQI.aSu);
            this.aQH.aQB.setAfterClickListener(this.ahL);
        }
        this.aQH.aQQ.setData(this.aQI.aSu);
        this.aQH.aQQ.setUserAfterClickListener(this.ahL);
        this.aQH.mTextTitle.setText(this.aQI.aSu.getTitle());
        this.aQH.aQP.setData(this.aQI.aSu);
        this.aQH.aQP.setStType(ae.JV());
        this.aQH.aQP.setYuelaouLocate("feed#" + this.aQI.Ke());
        this.aQH.aQP.setForumAfterClickListener(this.ahr);
        d(this.MR, TbadkCoreApplication.m411getInst().getSkinType());
        if (!JY()) {
            ae.a(this.aQH.mTextTitle, this.aQI.aSu.getId(), t.d.cp_cont_b, t.d.cp_cont_d);
        } else {
            com.baidu.tbadk.core.util.ar.j((View) this.aQH.mTextTitle, t.d.cp_cont_b);
        }
        if (com.baidu.tbadk.core.l.rn().rt() && this.aQI.aSu.tz() != null && !StringUtils.isNull(this.aQI.aSu.tz().video_url)) {
            this.aQH.aQN.d(this.aQI.aSu.tz().thumbnail_url, 10, true);
            this.aQH.aQM.setVisibility(0);
        } else {
            this.aQH.aQM.setVisibility(8);
        }
        if (this.aQI.aSF) {
            setBarNameClickEnabled(true);
        } else {
            setBarNameClickEnabled(false);
        }
        this.aQH.aQM.setClickable(false);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ar.k(this.aQH.aQK, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.ar.l(this.aQH.aQL, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.ar.j((View) this.aQH.mTextTitle, t.d.cp_cont_b);
            com.baidu.tbadk.core.util.ar.c(this.aQH.aQO, t.f.btn_icon_play_video_n);
            this.aQH.aQQ.xk();
            this.aQH.aQP.uv();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aQH != null && this.aQH.aQP != null && this.aQq != null) {
            this.aQH.aQP.h(bdUniqueId);
            this.aQq.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aQq);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public ClickableHeaderImageView aQB;
        public View aQK;
        public View aQL;
        public FrameLayout aQM;
        public TbImageView aQN;
        public ImageView aQO;
        public ThreadCommentAndPraiseInfoLayout aQP;
        public UserIconLayout aQQ;
        public TextView mTextTitle;

        public a() {
        }
    }
}
