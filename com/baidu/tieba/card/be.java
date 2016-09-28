package com.baidu.tieba.card;

import android.content.res.Resources;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewStub;
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
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class be extends com.baidu.tieba.card.a<com.baidu.tieba.card.data.n> {
    private TbPageContext<?> GM;
    private CustomMessageListener aZT;
    private View.OnClickListener baA;
    private View.OnClickListener baB;
    private com.baidu.tieba.card.data.n bay;
    public a baz;

    public be(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.baA = new bf(this);
        this.baB = new bg(this);
        this.aZT = new bh(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.GM = tbPageContext;
        R(getView());
        initUI();
    }

    private void R(View view) {
        this.baz = new a();
        this.baz.mRootView = view.findViewById(r.g.card_root_view);
        this.baz.baE = view.findViewById(r.g.top_line);
        this.baz.aZw = (ClickableHeaderImageView) view.findViewById(r.g.avatar);
        this.baz.aYH = (ViewStub) view.findViewById(r.g.viewstub_headimage_mask);
        this.baz.bak = (UserIconLayout) view.findViewById(r.g.user_icon);
        this.baz.baF = (TextView) view.findViewById(r.g.thread_title);
        this.baz.baG = (TextView) view.findViewById(r.g.fans_num);
        this.baz.baH = (TbImageView) view.findViewById(r.g.thread_image);
        this.baz.baI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.g.thread_more_info);
        this.baz.mRootView.setOnClickListener(this);
        this.baz.baI.setOnClickListener(this);
    }

    private void initUI() {
        this.baz.aZw.setRadius(com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds70));
        this.baz.aZw.setDefaultResource(17170445);
        this.baz.aZw.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.baz.aZw.setDefaultBgResource(r.d.cp_bg_line_e);
        this.baz.baI.setShowPraiseNum(false);
        this.baz.baH.setDrawBorder(true);
        this.baz.baH.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.n nVar) {
        this.bay = nVar;
        NZ();
    }

    private void NZ() {
        if (this.bay == null || this.bay.bbU == null) {
            this.baz.mRootView.setVisibility(8);
            return;
        }
        UserTbVipInfoData rO = this.bay.Jv().rO();
        if (rO != null && rO.getvipV_url() != null && this.baz.aYH != null) {
            if (this.baz.aYI == null) {
                this.baz.aYH.inflate();
                this.baz.aYI = (TbImageView) getView().findViewById(r.g.user_head_mask);
            }
            this.baz.aYI.c(rO.getvipV_url(), 10, false);
            this.baz.aZw.setIsBigV(true);
        }
        this.baz.aZw.setData(this.bay.bbU);
        this.baz.aZw.setAfterClickListener(this.baA);
        this.baz.bak.setData(this.bay.bbU);
        this.baz.bak.setUserNameTextSizeRid(r.e.fontsize24);
        this.baz.bak.setUserAfterClickListener(this.baA);
        Resources resources = this.GM.getResources();
        String string = resources.getString(r.j.recommend_live_title_prefix);
        new SpannableStringBuilder(String.valueOf(string) + this.bay.bbU.getTitle()).setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.av.getColor(r.d.cp_link_tip_a)), 0, string.length(), 17);
        this.baz.baF.setText(e(this.bay.bbU.getTitle()));
        String fansNickName = this.bay.bbU.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(r.j.fans_default_name);
        }
        this.baz.baG.setText(String.valueOf(fansNickName) + ": " + com.baidu.tbadk.core.util.az.w(this.bay.bbU.getAuthor().getFansNum()));
        this.baz.baI.setData(this.bay.bbU);
        this.baz.baI.setForumAfterClickListener(this.baB);
        this.baz.baI.setStType(an.Od());
        this.baz.baI.setYuelaouLocate("feed#" + this.bay.Ok());
        if (this.baz.aZB != null) {
            this.baz.aZB.setData(this.bay);
        }
        onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        if (com.baidu.tbadk.core.l.oH().oN() && this.bay.bbU.getPhotoLiveCover() != null && this.bay.bbU.getPhotoLiveCover().length() != 0) {
            this.baz.baH.setVisibility(0);
            this.baz.baH.c(this.bay.bbU.getPhotoLiveCover(), 10, false);
        } else {
            this.baz.baH.setVisibility(8);
        }
        com.baidu.tbadk.core.util.av.c(this.baz.baG, r.d.cp_cont_d, 1);
        if (an.hO(this.bay.bbU.getId())) {
            com.baidu.tbadk.core.util.av.c(this.baz.baF, r.d.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.av.c(this.baz.baF, r.d.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.baz.mRootView || view == this.baz.baI.getCommentNumView()) {
            if (getOnSubCardOnClickListenner() != null) {
                getOnSubCardOnClickListenner().a(this.baz.mRootView, this.bay);
            }
            Oh();
        }
    }

    public void Og() {
        this.baz.aZB = new com.baidu.tbadk.core.view.o(this.GM.getPageActivity());
        this.baz.aZB.wp();
        this.baz.baI.addView(this.baz.aZB);
    }

    private void Oh() {
        if (this.bay != null && this.bay.bbU != null) {
            an.hN(this.bay.bbU.getId());
            if (!Oi()) {
                UtilHelper.showToast(this.GM.getPageActivity(), r.j.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.GM.getPageActivity(), this.bay.bbU.getTid()).ci(this.bay.bbU.sc()).cl(this.bay.Ol()).cj(an.Od()).oX()));
            hP(this.bay.bbU.getTid());
        }
    }

    public void hP(String str) {
        new Handler().postDelayed(new bi(this, str), 600L);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, this.baz.mRootView);
            this.baz.bak.tx();
            this.baz.baI.tx();
            com.baidu.tbadk.core.util.av.l(this.baz.baE, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.k(this.baz.mRootView, r.f.addresslist_item_bg);
            this.mSkinType = i;
            if (this.baz.aZB == null) {
                return;
            }
            this.baz.aZB.tx();
        }
    }

    private boolean Oi() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.aZT != null) {
            this.aZT.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aZT);
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.GM.getResources().getString(r.j.recommend_live_title_prefix);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.av.getColor(r.d.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.d dVar = new com.baidu.adp.widget.d(this.GM.getPageActivity(), com.baidu.tbadk.core.util.av.cN(r.f.pic_dot_title), 1);
        dVar.setOffset(3);
        spannableStringBuilder.setSpan(dVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    /* loaded from: classes.dex */
    public class a {
        public ViewStub aYH;
        public TbImageView aYI;
        private com.baidu.tbadk.core.view.o aZB = null;
        public ClickableHeaderImageView aZw;
        public View baE;
        public TextView baF;
        public TextView baG;
        public TbImageView baH;
        public ThreadCommentAndPraiseInfoLayout baI;
        public UserIconLayout bak;
        public View mRootView;

        public a() {
        }
    }
}
