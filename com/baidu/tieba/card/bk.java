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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class bk extends com.baidu.tieba.card.a<com.baidu.tieba.card.a.n> {
    private TbPageContext<?> EA;
    private com.baidu.tieba.card.a.n aUV;
    public a aUW;
    private View.OnClickListener aUX;
    private View.OnClickListener aUY;
    private CustomMessageListener aUs;

    public bk(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aUX = new bl(this);
        this.aUY = new bm(this);
        this.aUs = new bn(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.EA = tbPageContext;
        Q(getView());
        initUI();
    }

    private void Q(View view) {
        this.aUW = new a();
        this.aUW.mRootView = view.findViewById(u.g.card_root_view);
        this.aUW.aVa = view.findViewById(u.g.top_line);
        this.aUW.aTU = (ClickableHeaderImageView) view.findViewById(u.g.avatar);
        this.aUW.aSW = (ViewStub) view.findViewById(u.g.viewstub_headimage_mask);
        this.aUW.aUI = (UserIconLayout) view.findViewById(u.g.user_icon);
        this.aUW.aVb = (TextView) view.findViewById(u.g.thread_title);
        this.aUW.aVc = (TextView) view.findViewById(u.g.fans_num);
        this.aUW.aVd = (TbImageView) view.findViewById(u.g.thread_image);
        this.aUW.aVe = (ThreadCommentAndPraiseInfoLayout) view.findViewById(u.g.thread_more_info);
        this.aUW.mRootView.setOnClickListener(this);
        this.aUW.aVe.setOnClickListener(this);
    }

    private void initUI() {
        this.aUW.aTU.setRadius(com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds70));
        this.aUW.aTU.setDefaultResource(17170445);
        this.aUW.aTU.setDefaultErrorResource(u.f.icon_default_avatar100);
        this.aUW.aTU.setDefaultBgResource(u.d.cp_bg_line_e);
        this.aUW.aVe.setShowPraiseNum(false);
        this.aUW.aVd.setDrawBorder(true);
        this.aUW.aVd.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_home_page_zhibo_item;
    }

    public void a(com.baidu.tieba.card.a.n nVar) {
        this.aUV = nVar;
        KW();
    }

    private void KW() {
        if (this.aUV == null || this.aUV.aWa == null) {
            this.aUW.mRootView.setVisibility(8);
            return;
        }
        UserTbVipInfoData qx = this.aUV.Iw().qx();
        if (qx != null && qx.getvipV_url() != null && this.aUW.aSW != null) {
            if (this.aUW.aSX == null) {
                this.aUW.aSW.inflate();
                this.aUW.aSX = (TbImageView) getView().findViewById(u.g.user_head_mask);
            }
            this.aUW.aSX.c(qx.getvipV_url(), 10, false);
            this.aUW.aTU.setIsBigV(true);
        }
        this.aUW.aTU.setData(this.aUV.aWa);
        this.aUW.aTU.setAfterClickListener(this.aUX);
        this.aUW.aUI.setData(this.aUV.aWa);
        this.aUW.aUI.setUserNameTextSizeRid(u.e.fontsize24);
        this.aUW.aUI.setUserAfterClickListener(this.aUX);
        Resources resources = this.EA.getResources();
        String string = resources.getString(u.j.recommend_live_title_prefix);
        new SpannableStringBuilder(String.valueOf(string) + this.aUV.aWa.getTitle()).setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.av.getColor(u.d.cp_link_tip_a)), 0, string.length(), 17);
        this.aUW.aVb.setText(e(this.aUV.aWa.getTitle()));
        String fansNickName = this.aUV.aWa.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(u.j.fans_default_name);
        }
        this.aUW.aVc.setText(String.valueOf(fansNickName) + ": " + com.baidu.tbadk.core.util.ba.w(this.aUV.aWa.getAuthor().getFansNum()));
        this.aUW.aVe.setData(this.aUV.aWa);
        this.aUW.aVe.setForumAfterClickListener(this.aUY);
        this.aUW.aVe.setStType(at.La());
        this.aUW.aVe.setYuelaouLocate("feed#" + this.aUV.Lg());
        d(this.EA, TbadkCoreApplication.m10getInst().getSkinType());
        if (com.baidu.tbadk.core.l.nL().nR() && this.aUV.aWa.getPhotoLiveCover() != null && this.aUV.aWa.getPhotoLiveCover().length() != 0) {
            this.aUW.aVd.setVisibility(0);
            this.aUW.aVd.c(this.aUV.aWa.getPhotoLiveCover(), 10, false);
        } else {
            this.aUW.aVd.setVisibility(8);
        }
        com.baidu.tbadk.core.util.av.c(this.aUW.aVc, u.d.cp_cont_d, 1);
        if (at.hc(this.aUV.aWa.getId())) {
            com.baidu.tbadk.core.util.av.c(this.aUW.aVb, u.d.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.av.c(this.aUW.aVb, u.d.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aUW.mRootView || view == this.aUW.aVe.getCommentNumView()) {
            if (KN() != null) {
                KN().a(this.aUW.mRootView, this.aUV);
            }
            Ld();
        }
    }

    private void Ld() {
        if (this.aUV != null && this.aUV.aWa != null) {
            at.hb(this.aUV.aWa.getId());
            if (!Le()) {
                UtilHelper.showToast(this.EA.getPageActivity(), u.j.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.EA.getPageActivity(), this.aUV.aWa.getTid()).ch(this.aUV.aWa.qL()).ck(this.aUV.Lh()).ci(at.La()).oa()));
            hd(this.aUV.aWa.getTid());
        }
    }

    public void hd(String str) {
        new Handler().postDelayed(new bo(this, str), 600L);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.j.a.a(tbPageContext, this.aUW.mRootView);
            this.aUW.aUI.sd();
            this.aUW.aVe.sd();
            com.baidu.tbadk.core.util.av.l(this.aUW.aVa, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.k(this.aUW.mRootView, u.f.addresslist_item_bg);
            this.mSkinType = i;
        }
    }

    private boolean Le() {
        return TbadkCoreApplication.m10getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.aUs != null) {
            this.aUs.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aUs);
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.EA.getResources().getString(u.j.recommend_live_title_prefix);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.av.getColor(u.d.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.d dVar = new com.baidu.adp.widget.d(this.EA.getPageActivity(), com.baidu.tbadk.core.util.av.cA(u.f.pic_dot_title), 1);
        dVar.setOffset(3);
        spannableStringBuilder.setSpan(dVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    /* loaded from: classes.dex */
    public class a {
        public ViewStub aSW;
        public TbImageView aSX;
        public ClickableHeaderImageView aTU;
        public UserIconLayout aUI;
        public View aVa;
        public TextView aVb;
        public TextView aVc;
        public TbImageView aVd;
        public ThreadCommentAndPraiseInfoLayout aVe;
        public View mRootView;

        public a() {
        }
    }
}
