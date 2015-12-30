package com.baidu.tieba.card;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ah extends com.baidu.tieba.card.a<com.baidu.tieba.card.a.p> {
    private final String aOH;
    private a aOI;
    private com.baidu.tieba.card.a.p aOJ;
    private final View.OnClickListener agD;
    private final View.OnClickListener agW;
    private TbPageContext<?> mContext;
    private int mSkinType;

    public ah(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aOH = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
        this.mSkinType = 3;
        this.agW = new ai(this);
        this.agD = new aj(this);
        this.mContext = tbPageContext;
        this.aOI = new a(this, null);
        j(getView());
    }

    private void j(View view) {
        this.aOI.aOL = (RelativeLayout) view.findViewById(n.g.layout_root);
        this.aOI.aOM = view.findViewById(n.g.divider);
        this.aOI.aOC = (ClickableHeaderImageView) view.findViewById(n.g.image_user);
        this.aOI.aOC.setDefaultResource(17170445);
        this.aOI.aOC.setDefaultBgResource(n.f.icon_default_avatar_round);
        this.aOI.aOC.setRadius(com.baidu.adp.lib.util.k.d(this.mContext.getPageActivity(), n.e.ds70));
        this.aOI.aOR = (UserIconLayout) view.findViewById(n.g.text_user_name);
        this.aOI.mTextTitle = (TextView) view.findViewById(n.g.text_title);
        this.aOI.aOQ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(n.g.text_bottom);
        this.aOI.aON = (FrameLayout) view.findViewById(n.g.frame_video);
        this.aOI.aOO = (TbImageView) view.findViewById(n.g.image_video);
        this.aOI.aOO.setDefaultBgResource(n.f.pic_bg_video_frs);
        this.aOI.aOO.setDefaultResource(0);
        this.aOI.aOP = (ImageView) view.findViewById(n.g.image_video_play);
        this.aOI.aOL.setOnClickListener(this);
        this.aOI.aON.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aOI.aOL) {
            Io();
        } else if (view == this.aOI.aON) {
            A(view);
        }
    }

    private void Io() {
        if (this.aOJ != null && this.aOJ.aQp != null) {
            TiebaStatic.log(this.aOJ.IB());
            x.gH(this.aOJ.aQp.getId());
            this.mContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.aOJ.aQp, this.aOJ.aQp.sv(), x.In(), 18003, true, false, false).addLocateParam(this.aOJ.It())));
            refreshView();
        }
    }

    private void A(View view) {
        if (this.aOJ != null && this.aOJ.aQp != null && this.aOJ.aQp.sE() != null) {
            TiebaStatic.log(this.aOJ.IL());
            aq<com.baidu.tieba.card.a.p> If = If();
            if (If != null) {
                view.setTag(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                If.a(view, this.aOJ);
            }
            if (!com.baidu.adp.lib.util.i.iQ()) {
                com.baidu.adp.lib.util.k.u(getContext(), getContext().getString(n.j.neterror));
            } else {
                XiaoyingUtil.startPlayXiaoyingVideo(this.mContext.getPageActivity(), this.aOJ.aQp.sE().video_url, this.aOJ.aQp.sE().video_width.intValue(), this.aOJ.aQp.sE().video_height.intValue(), this.aOJ.aQp.sE().thumbnail_url);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int Ig() {
        return n.h.card_home_page_video_thread;
    }

    public void a(com.baidu.tieba.card.a.p pVar) {
        this.aOJ = pVar;
        if (this.aOJ != null) {
            am.Iq().a(this.aOJ.IA());
        }
        refreshView();
    }

    private void refreshView() {
        if (this.aOJ == null || this.aOJ.aQp == null || this.aOJ.aQp.getAuthor() == null) {
            this.aOI.aOL.setVisibility(8);
            return;
        }
        this.aOI.aOL.setVisibility(0);
        this.aOI.aOC.setData(this.aOJ.aQp);
        this.aOI.aOC.setAfterClickListener(this.agW);
        this.aOI.aOR.setData(this.aOJ.aQp);
        this.aOI.aOR.setUserAfterClickListener(this.agW);
        this.aOI.mTextTitle.setText(this.aOJ.aQp.getTitle());
        this.aOI.aOQ.setData(this.aOJ.aQp);
        this.aOI.aOQ.setStType(x.In());
        this.aOI.aOQ.setYuelaouLocate("feed#" + this.aOJ.Is());
        this.aOI.aOQ.setForumAfterClickListener(this.agD);
        onChangeSkinType(this.mContext, TbadkCoreApplication.m411getInst().getSkinType());
        if (x.gI(this.aOJ.aQp.getId())) {
            as.b(this.aOI.mTextTitle, n.d.cp_cont_d, 1);
        } else {
            as.b(this.aOI.mTextTitle, n.d.cp_cont_b, 1);
        }
        if (!com.baidu.tbadk.core.m.qQ().qW() || this.aOJ.aQp.sE() == null || StringUtils.isNull(this.aOJ.aQp.sE().video_url)) {
            this.aOI.aON.setVisibility(8);
            return;
        }
        this.aOI.aOO.d(this.aOJ.aQp.sE().thumbnail_url, 10, true);
        this.aOI.aON.setVisibility(0);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType == i) {
            return;
        }
        as.i(this.aOI.aOL, n.f.addresslist_item_bg);
        as.j(this.aOI.aOM, n.d.cp_bg_line_c);
        as.h((View) this.aOI.mTextTitle, n.d.cp_cont_b);
        as.c(this.aOI.aOP, n.f.icon_play_video);
        this.aOI.aOR.vW();
        this.aOI.aOQ.tr();
        this.mSkinType = i;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.aOI == null || this.aOI.aOQ == null) {
            return;
        }
        this.aOI.aOQ.h(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private ClickableHeaderImageView aOC;
        private RelativeLayout aOL;
        private View aOM;
        private FrameLayout aON;
        private TbImageView aOO;
        private ImageView aOP;
        private ThreadCommentAndPraiseInfoLayout aOQ;
        private UserIconLayout aOR;
        private TextView mTextTitle;

        private a() {
        }

        /* synthetic */ a(ah ahVar, a aVar) {
            this();
        }
    }
}
