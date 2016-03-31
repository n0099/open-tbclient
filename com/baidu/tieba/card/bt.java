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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class bt extends com.baidu.tieba.card.a<com.baidu.tieba.card.a.u> {
    private TbPageContext<?> ND;
    private CustomMessageListener aTI;
    private com.baidu.tieba.card.a.u aUi;
    public a aUj;
    private View.OnClickListener aUk;
    private View.OnClickListener aUl;

    public bt(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aUk = new bu(this);
        this.aUl = new bv(this);
        this.aTI = new bw(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.ND = tbPageContext;
        w(getView());
        pU();
    }

    private void w(View view) {
        this.aUj = new a();
        this.aUj.mRootView = view.findViewById(t.g.card_root_view);
        this.aUj.aUo = view.findViewById(t.g.top_line);
        this.aUj.aTo = (ClickableHeaderImageView) view.findViewById(t.g.avatar);
        this.aUj.aTV = (UserIconLayout) view.findViewById(t.g.user_icon);
        this.aUj.aUp = (TextView) view.findViewById(t.g.thread_title);
        this.aUj.aUq = (TextView) view.findViewById(t.g.fans_num);
        this.aUj.aUr = (TbImageView) view.findViewById(t.g.thread_image);
        this.aUj.aUs = (ThreadCommentAndPraiseInfoLayout) view.findViewById(t.g.thread_more_info);
        this.aUj.mRootView.setOnClickListener(this);
    }

    private void pU() {
        this.aUj.aTo.setRadius(com.baidu.adp.lib.util.k.c(this.ND.getPageActivity(), t.e.ds70));
        this.aUj.aTo.setDefaultResource(17170445);
        this.aUj.aTo.setDefaultErrorResource(t.f.icon_default_avatar100);
        this.aUj.aTo.setDefaultBgResource(t.d.cp_bg_line_e);
        this.aUj.aUs.setShowPraiseNum(false);
        this.aUj.aUr.setDrawBorder(true);
        this.aUj.aUr.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int Le() {
        return t.h.card_home_page_zhibo_item;
    }

    public void a(com.baidu.tieba.card.a.u uVar) {
        this.aUi = uVar;
        Lp();
    }

    private void Lp() {
        if (this.aUi == null || this.aUi.aWf == null) {
            this.aUj.mRootView.setVisibility(8);
            return;
        }
        this.aUj.aTo.setData(this.aUi.aWf);
        this.aUj.aTo.setAfterClickListener(this.aUk);
        this.aUj.aTV.setData(this.aUi.aWf);
        this.aUj.aTV.setUserNameTextSizeRid(t.e.fontsize24);
        this.aUj.aTV.setUserAfterClickListener(this.aUk);
        Resources resources = this.ND.getResources();
        String string = resources.getString(t.j.recommend_live_title_prefix);
        new SpannableStringBuilder(String.valueOf(string) + this.aUi.aWf.getTitle()).setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.at.getColor(t.d.cp_link_tip_a)), 0, string.length(), 17);
        this.aUj.aUp.setText(e(this.aUi.aWf.getTitle()));
        String fansNickName = this.aUi.aWf.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(t.j.fans_default_name);
        }
        this.aUj.aUq.setText(String.valueOf(fansNickName) + ": " + com.baidu.tbadk.core.util.ay.z(this.aUi.aWf.getAuthor().getFansNum()));
        this.aUj.aUs.setData(this.aUi.aWf);
        this.aUj.aUs.setForumAfterClickListener(this.aUl);
        this.aUj.aUs.setStType(bc.Ls());
        this.aUj.aUs.setYuelaouLocate("feed#" + this.aUi.Ly());
        d(this.ND, TbadkCoreApplication.m411getInst().getSkinType());
        if (com.baidu.tbadk.core.l.qE().qK() && this.aUi.aWf.getPhotoLiveCover() != null && this.aUi.aWf.getPhotoLiveCover().length() != 0) {
            this.aUj.aUr.setVisibility(0);
            this.aUj.aUr.c(this.aUi.aWf.getPhotoLiveCover(), 10, false);
        } else {
            this.aUj.aUr.setVisibility(8);
        }
        com.baidu.tbadk.core.util.at.b(this.aUj.aUq, t.d.cp_cont_d, 1);
        if (bc.hb(this.aUi.aWf.getId())) {
            com.baidu.tbadk.core.util.at.b(this.aUj.aUp, t.d.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.at.b(this.aUj.aUp, t.d.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aUj.mRootView) {
            if (Ld() != null) {
                Ld().a(view, this.aUi);
            }
            Lv();
        }
    }

    private void Lv() {
        if (this.aUi != null && this.aUi.aWf != null) {
            bc.ha(this.aUi.aWf.getId());
            if (!Lw()) {
                UtilHelper.showToast(this.ND.getPageActivity(), t.j.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.ND.getPageActivity(), this.aUi.aWf.getTid()).cj(this.aUi.aWf.tB()).cm(this.aUi.Lz()).ck(bc.Ls()).qT()));
            hc(this.aUi.aWf.getTid());
        }
    }

    public void hc(String str) {
        new Handler().postDelayed(new bx(this, str), 600L);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, this.aUj.mRootView);
            this.aUj.aTV.uA();
            this.aUj.aUs.uA();
            com.baidu.tbadk.core.util.at.l(this.aUj.aUo, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.k(this.aUj.mRootView, t.f.addresslist_item_bg);
            this.mSkinType = i;
        }
    }

    private boolean Lw() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.aTI != null) {
            this.aTI.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aTI);
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.ND.getResources().getString(t.j.recommend_live_title_prefix);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.at.getColor(t.d.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.d dVar = new com.baidu.adp.widget.d(this.ND.getPageActivity(), com.baidu.tbadk.core.util.at.cR(t.f.pic_dot_title), 1);
        dVar.setOffset(3);
        spannableStringBuilder.setSpan(dVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    /* loaded from: classes.dex */
    public class a {
        public UserIconLayout aTV;
        public ClickableHeaderImageView aTo;
        public View aUo;
        public TextView aUp;
        public TextView aUq;
        public TbImageView aUr;
        public ThreadCommentAndPraiseInfoLayout aUs;
        public View mRootView;

        public a() {
        }
    }
}
