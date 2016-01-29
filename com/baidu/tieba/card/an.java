package com.baidu.tieba.card;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class an extends com.baidu.tieba.card.a<com.baidu.tieba.card.a.r> {
    private TbPageContext<?> Nw;
    private CustomMessageListener aQq;
    private com.baidu.tieba.card.a.r aQv;
    public a aQw;
    private View.OnClickListener aQx;
    private View.OnClickListener aQy;

    public an(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aQx = new ao(this);
        this.aQy = new ap(this);
        this.aQq = new aq(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.Nw = tbPageContext;
        w(getView());
        qD();
    }

    private void w(View view) {
        this.aQw = new a();
        this.aQw.mRootView = view.findViewById(t.g.card_root_view);
        this.aQw.aQA = view.findViewById(t.g.top_line);
        this.aQw.aQB = (ClickableHeaderImageView) view.findViewById(t.g.avatar);
        this.aQw.aQo = (UserIconLayout) view.findViewById(t.g.user_icon);
        this.aQw.aQC = (TextView) view.findViewById(t.g.thread_title);
        this.aQw.aQD = (TextView) view.findViewById(t.g.thread_content);
        this.aQw.aQE = (TbImageView) view.findViewById(t.g.thread_image);
        this.aQw.aQF = (ThreadCommentAndPraiseInfoLayout) view.findViewById(t.g.thread_more_info);
        this.aQw.mRootView.setOnClickListener(this);
    }

    private void qD() {
        this.aQw.aQB.setRadius(com.baidu.adp.lib.util.k.c(this.Nw.getPageActivity(), t.e.ds70));
        this.aQw.aQB.setDefaultResource(17170445);
        this.aQw.aQB.setDefaultBgResource(t.f.icon_default_avatar_round);
        this.aQw.aQF.setShowPraiseNum(false);
        this.aQw.aQE.setDrawBorder(true);
        this.aQw.aQE.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int JM() {
        return t.h.card_home_page_zhibo_item;
    }

    public void a(com.baidu.tieba.card.a.r rVar) {
        this.aQv = rVar;
        JZ();
    }

    private void JZ() {
        if (this.aQv == null || this.aQv.aSu == null) {
            this.aQw.mRootView.setVisibility(8);
            return;
        }
        this.aQw.aQB.setData(this.aQv.aSu);
        this.aQw.aQB.setAfterClickListener(this.aQx);
        this.aQw.aQo.setData(this.aQv.aSu);
        this.aQw.aQo.setUserAfterClickListener(this.aQx);
        this.aQw.aQC.setText(e(this.aQv.aSu.getTitle()));
        if (!StringUtils.isNull(this.aQv.aSu.tr())) {
            this.aQw.aQD.setVisibility(0);
            this.aQw.aQD.setText(this.aQv.aSu.tr());
        } else {
            this.aQw.aQD.setVisibility(8);
        }
        this.aQw.aQF.setData(this.aQv.aSu);
        this.aQw.aQF.setForumAfterClickListener(this.aQy);
        this.aQw.aQF.setStType(ae.JV());
        this.aQw.aQF.setYuelaouLocate("feed#" + this.aQv.Ke());
        d(this.Nw, TbadkCoreApplication.m411getInst().getSkinType());
        if (com.baidu.tbadk.core.l.rn().rt() && this.aQv.aSu.getPhotoLiveCover() != null && this.aQv.aSu.getPhotoLiveCover().length() != 0) {
            this.aQw.aQE.setVisibility(0);
            this.aQw.aQE.d(this.aQv.aSu.getPhotoLiveCover(), 10, false);
        } else {
            this.aQw.aQE.setVisibility(8);
        }
        if (ae.gP(this.aQv.aSu.getId())) {
            com.baidu.tbadk.core.util.ar.b(this.aQw.aQC, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ar.b(this.aQw.aQD, t.d.cp_cont_d, 1);
            return;
        }
        com.baidu.tbadk.core.util.ar.b(this.aQw.aQC, t.d.cp_cont_b, 1);
        com.baidu.tbadk.core.util.ar.b(this.aQw.aQD, t.d.cp_cont_j, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aQw.mRootView) {
            if (JL() != null) {
                JL().a(view, this.aQv);
            }
            Ka();
        }
    }

    private void Ka() {
        if (this.aQv != null && this.aQv.aSu != null) {
            ae.gO(this.aQv.aSu.getId());
            if (!Kb()) {
                UtilHelper.showToast(this.Nw.getPageActivity(), t.j.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.Nw.getPageActivity(), this.aQv.aSu.getTid()).cm(this.aQv.aSu.ty()).cp(this.aQv.Kf()).cn(ae.JV()).rC()));
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, this.aQw.mRootView);
            this.aQw.aQo.xk();
            this.aQw.aQF.uv();
            com.baidu.tbadk.core.util.ar.l(this.aQw.aQA, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.ar.k(this.aQw.mRootView, t.f.addresslist_item_bg);
            this.mSkinType = i;
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("  " + ((Object) charSequence));
        com.baidu.adp.widget.d dVar = new com.baidu.adp.widget.d(this.Nw.getPageActivity(), com.baidu.tbadk.core.util.ar.cO(t.f.icon_zhibo), 1);
        dVar.setOffset(3);
        spannableStringBuilder.setSpan(dVar, 0, 1, 33);
        return spannableStringBuilder;
    }

    private boolean Kb() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.aQq != null) {
            this.aQq.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aQq);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public View aQA;
        public ClickableHeaderImageView aQB;
        public TextView aQC;
        public TextView aQD;
        public TbImageView aQE;
        public ThreadCommentAndPraiseInfoLayout aQF;
        public UserIconLayout aQo;
        public View mRootView;

        public a() {
        }
    }
}
