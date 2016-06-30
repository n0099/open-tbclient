package com.baidu.tieba.card;

import android.content.res.Resources;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class bk extends com.baidu.tieba.card.a<com.baidu.tieba.card.a.n> {
    private TbPageContext<?> Ea;
    private com.baidu.tieba.card.a.n aTZ;
    private CustomMessageListener aTw;
    public a aUa;
    private View.OnClickListener aUb;
    private View.OnClickListener aUc;

    public bk(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aUb = new bl(this);
        this.aUc = new bm(this);
        this.aTw = new bn(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.Ea = tbPageContext;
        Q(getView());
        nl();
    }

    private void Q(View view) {
        this.aUa = new a();
        this.aUa.mRootView = view.findViewById(u.g.card_root_view);
        this.aUa.aUe = view.findViewById(u.g.top_line);
        this.aUa.aSY = (ClickableHeaderImageView) view.findViewById(u.g.avatar);
        this.aUa.aTM = (UserIconLayout) view.findViewById(u.g.user_icon);
        this.aUa.aUf = (TextView) view.findViewById(u.g.thread_title);
        this.aUa.aUg = (TextView) view.findViewById(u.g.fans_num);
        this.aUa.aUh = (TbImageView) view.findViewById(u.g.thread_image);
        this.aUa.aUi = (ThreadCommentAndPraiseInfoLayout) view.findViewById(u.g.thread_more_info);
        this.aUa.mRootView.setOnClickListener(this);
        this.aUa.aUi.setOnClickListener(this);
    }

    private void nl() {
        this.aUa.aSY.setRadius(com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds70));
        this.aUa.aSY.setDefaultResource(17170445);
        this.aUa.aSY.setDefaultErrorResource(u.f.icon_default_avatar100);
        this.aUa.aSY.setDefaultBgResource(u.d.cp_bg_line_e);
        this.aUa.aUi.setShowPraiseNum(false);
        this.aUa.aUh.setDrawBorder(true);
        this.aUa.aUh.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_home_page_zhibo_item;
    }

    public void a(com.baidu.tieba.card.a.n nVar) {
        this.aTZ = nVar;
        KX();
    }

    private void KX() {
        if (this.aTZ == null || this.aTZ.aVc == null) {
            this.aUa.mRootView.setVisibility(8);
            return;
        }
        this.aUa.aSY.setData(this.aTZ.aVc);
        this.aUa.aSY.setAfterClickListener(this.aUb);
        this.aUa.aTM.setData(this.aTZ.aVc);
        this.aUa.aTM.setUserNameTextSizeRid(u.e.fontsize24);
        this.aUa.aTM.setUserAfterClickListener(this.aUb);
        Resources resources = this.Ea.getResources();
        String string = resources.getString(u.j.recommend_live_title_prefix);
        new SpannableStringBuilder(String.valueOf(string) + this.aTZ.aVc.getTitle()).setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.av.getColor(u.d.cp_link_tip_a)), 0, string.length(), 17);
        this.aUa.aUf.setText(e(this.aTZ.aVc.getTitle()));
        String fansNickName = this.aTZ.aVc.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(u.j.fans_default_name);
        }
        this.aUa.aUg.setText(String.valueOf(fansNickName) + ": " + com.baidu.tbadk.core.util.ba.B(this.aTZ.aVc.getAuthor().getFansNum()));
        this.aUa.aUi.setData(this.aTZ.aVc);
        this.aUa.aUi.setForumAfterClickListener(this.aUc);
        this.aUa.aUi.setStType(at.Lb());
        this.aUa.aUi.setYuelaouLocate("feed#" + this.aTZ.Lh());
        d(this.Ea, TbadkCoreApplication.m9getInst().getSkinType());
        if (com.baidu.tbadk.core.l.nW().oc() && this.aTZ.aVc.getPhotoLiveCover() != null && this.aTZ.aVc.getPhotoLiveCover().length() != 0) {
            this.aUa.aUh.setVisibility(0);
            this.aUa.aUh.c(this.aTZ.aVc.getPhotoLiveCover(), 10, false);
        } else {
            this.aUa.aUh.setVisibility(8);
        }
        com.baidu.tbadk.core.util.av.c(this.aUa.aUg, u.d.cp_cont_d, 1);
        if (at.hc(this.aTZ.aVc.getId())) {
            com.baidu.tbadk.core.util.av.c(this.aUa.aUf, u.d.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.av.c(this.aUa.aUf, u.d.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aUa.mRootView || view == this.aUa.aUi.getCommentNumView()) {
            if (KO() != null) {
                KO().a(this.aUa.mRootView, this.aTZ);
            }
            Le();
        }
    }

    private void Le() {
        if (this.aTZ != null && this.aTZ.aVc != null) {
            at.hb(this.aTZ.aVc.getId());
            if (!Lf()) {
                UtilHelper.showToast(this.Ea.getPageActivity(), u.j.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.Ea.getPageActivity(), this.aTZ.aVc.getTid()).cg(this.aTZ.aVc.qV()).cj(this.aTZ.Li()).ch(at.Lb()).ol()));
            hd(this.aTZ.aVc.getTid());
        }
    }

    public void hd(String str) {
        new Handler().postDelayed(new bo(this, str), 600L);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.j.a.a(tbPageContext, this.aUa.mRootView);
            this.aUa.aTM.se();
            this.aUa.aUi.se();
            com.baidu.tbadk.core.util.av.l(this.aUa.aUe, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.k(this.aUa.mRootView, u.f.addresslist_item_bg);
            this.mSkinType = i;
        }
    }

    private boolean Lf() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.aTw != null) {
            this.aTw.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aTw);
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.Ea.getResources().getString(u.j.recommend_live_title_prefix);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.av.getColor(u.d.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.d dVar = new com.baidu.adp.widget.d(this.Ea.getPageActivity(), com.baidu.tbadk.core.util.av.cA(u.f.pic_dot_title), 1);
        dVar.setOffset(3);
        spannableStringBuilder.setSpan(dVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    /* loaded from: classes.dex */
    public class a {
        public ClickableHeaderImageView aSY;
        public UserIconLayout aTM;
        public View aUe;
        public TextView aUf;
        public TextView aUg;
        public TbImageView aUh;
        public ThreadCommentAndPraiseInfoLayout aUi;
        public View mRootView;

        public a() {
        }
    }
}
