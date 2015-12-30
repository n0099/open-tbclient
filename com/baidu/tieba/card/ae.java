package com.baidu.tieba.card;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ae extends com.baidu.tieba.card.a<com.baidu.tieba.card.a.o> {
    private com.baidu.tieba.card.a.o aOw;
    private a aOx;
    private View.OnClickListener aOy;
    private View.OnClickListener aOz;
    private TbPageContext<?> mPageContext;

    public ae(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aOy = new af(this);
        this.aOz = new ag(this);
        this.mPageContext = tbPageContext;
        j(getView());
        initUI();
    }

    private void j(View view) {
        this.aOx = new a(this, null);
        this.aOx.mRootView = view.findViewById(n.g.card_root_view);
        this.aOx.aOB = view.findViewById(n.g.top_line);
        this.aOx.aOC = (ClickableHeaderImageView) view.findViewById(n.g.avatar);
        this.aOx.aOm = (UserIconLayout) view.findViewById(n.g.user_icon);
        this.aOx.aOD = (TextView) view.findViewById(n.g.thread_title);
        this.aOx.aOE = (TextView) view.findViewById(n.g.thread_content);
        this.aOx.aOF = (TbImageView) view.findViewById(n.g.thread_image);
        this.aOx.aOG = (ThreadCommentAndPraiseInfoLayout) view.findViewById(n.g.thread_more_info);
        this.aOx.mRootView.setOnClickListener(this);
    }

    private void initUI() {
        this.aOx.aOC.setRadius(com.baidu.adp.lib.util.k.d(this.mPageContext.getPageActivity(), n.e.ds70));
        this.aOx.aOC.setDefaultResource(17170445);
        this.aOx.aOC.setDefaultBgResource(n.f.icon_default_avatar_round);
        this.aOx.aOG.setShowPraiseNum(false);
        this.aOx.aOF.setDrawBorder(true);
        this.aOx.aOF.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int Ig() {
        return n.h.card_home_page_zhibo_item;
    }

    public void a(com.baidu.tieba.card.a.o oVar) {
        this.aOw = oVar;
        if (this.aOw != null) {
            am.Iq().a(this.aOw.II());
        }
        refreshView();
    }

    private void refreshView() {
        if (this.aOw == null || this.aOw.aQp == null) {
            this.aOx.mRootView.setVisibility(8);
            return;
        }
        this.aOx.aOC.setData(this.aOw.aQp);
        this.aOx.aOC.setAfterClickListener(this.aOy);
        this.aOx.aOm.setData(this.aOw.aQp);
        this.aOx.aOm.setUserAfterClickListener(this.aOy);
        this.aOx.aOD.setText(e(this.aOw.aQp.getTitle()));
        this.aOx.aOE.setText(this.aOw.aQp.sy());
        this.aOx.aOG.setData(this.aOw.aQp);
        this.aOx.aOG.setForumAfterClickListener(this.aOz);
        this.aOx.aOG.setStType(x.In());
        this.aOx.aOG.setYuelaouLocate("feed#" + this.aOw.Is());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.m411getInst().getSkinType());
        if (!com.baidu.tbadk.core.m.qQ().qW() || this.aOw.aQp.getPhotoLiveCover() == null || this.aOw.aQp.getPhotoLiveCover().length() == 0) {
            this.aOx.aOF.setVisibility(8);
        } else {
            this.aOx.aOF.setVisibility(0);
            this.aOx.aOF.d(this.aOw.aQp.getPhotoLiveCover(), 10, false);
        }
        if (x.gI(this.aOw.aQp.getId())) {
            as.b(this.aOx.aOD, n.d.cp_cont_d, 1);
            as.b(this.aOx.aOE, n.d.cp_cont_d, 1);
            return;
        }
        as.b(this.aOx.aOD, n.d.cp_cont_b, 1);
        as.b(this.aOx.aOE, n.d.cp_cont_j, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aOx.mRootView) {
            Io();
        }
    }

    private void Io() {
        if (this.aOw != null && this.aOw.aQp != null) {
            x.gH(this.aOw.aQp.getId());
            TiebaStatic.log(this.aOw.IH());
            if (!Ip()) {
                UtilHelper.showToast(this.mPageContext.getPageActivity(), n.j.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.aOw.aQp.getTid()).cn(this.aOw.aQp.sD()).cq(this.aOw.It()).co(x.In()).rf()));
            refreshView();
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType == i) {
            return;
        }
        com.baidu.tbadk.i.a.a(tbPageContext, this.aOx.mRootView);
        this.aOx.aOm.vW();
        this.aOx.aOG.tr();
        as.j(this.aOx.aOB, n.d.cp_bg_line_c);
        as.i(this.aOx.mRootView, n.f.addresslist_item_bg);
        this.mSkinType = i;
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("  " + ((Object) charSequence));
        com.baidu.adp.widget.d dVar = new com.baidu.adp.widget.d(this.mPageContext.getPageActivity(), as.cx(n.f.icon_zhibo), 1);
        dVar.setOffset(3);
        spannableStringBuilder.setSpan(dVar, 0, 1, 33);
        return spannableStringBuilder;
    }

    private boolean Ip() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private View aOB;
        private ClickableHeaderImageView aOC;
        private TextView aOD;
        private TextView aOE;
        private TbImageView aOF;
        private ThreadCommentAndPraiseInfoLayout aOG;
        private UserIconLayout aOm;
        private View mRootView;

        private a() {
        }

        /* synthetic */ a(ae aeVar, a aVar) {
            this();
        }
    }
}
