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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class bg extends com.baidu.tieba.card.a<com.baidu.tieba.card.data.n> {
    private TbPageContext<?> GM;
    private CustomMessageListener aZB;
    private com.baidu.tieba.card.data.n bag;
    public a bah;
    private View.OnClickListener bai;
    private View.OnClickListener baj;

    public bg(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bai = new bh(this);
        this.baj = new bi(this);
        this.aZB = new bj(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.GM = tbPageContext;
        R(getView());
        initUI();
    }

    private void R(View view) {
        this.bah = new a();
        this.bah.mRootView = view.findViewById(t.g.card_root_view);
        this.bah.bam = view.findViewById(t.g.top_line);
        this.bah.aZc = (ClickableHeaderImageView) view.findViewById(t.g.avatar);
        this.bah.aYe = (ViewStub) view.findViewById(t.g.viewstub_headimage_mask);
        this.bah.aZT = (UserIconLayout) view.findViewById(t.g.user_icon);
        this.bah.ban = (TextView) view.findViewById(t.g.thread_title);
        this.bah.bao = (TextView) view.findViewById(t.g.fans_num);
        this.bah.bap = (TbImageView) view.findViewById(t.g.thread_image);
        this.bah.baq = (ThreadCommentAndPraiseInfoLayout) view.findViewById(t.g.thread_more_info);
        this.bah.mRootView.setOnClickListener(this);
        this.bah.baq.setOnClickListener(this);
    }

    private void initUI() {
        this.bah.aZc.setRadius(com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds70));
        this.bah.aZc.setDefaultResource(17170445);
        this.bah.aZc.setDefaultErrorResource(t.f.icon_default_avatar100);
        this.bah.aZc.setDefaultBgResource(t.d.cp_bg_line_e);
        this.bah.baq.setShowPraiseNum(false);
        this.bah.bap.setDrawBorder(true);
        this.bah.bap.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return t.h.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.n nVar) {
        this.bag = nVar;
        Ny();
    }

    private void Ny() {
        if (this.bag == null || this.bag.bbC == null) {
            this.bah.mRootView.setVisibility(8);
            return;
        }
        UserTbVipInfoData rC = this.bag.Kw().rC();
        if (rC != null && rC.getvipV_url() != null && this.bah.aYe != null) {
            if (this.bah.aYf == null) {
                this.bah.aYe.inflate();
                this.bah.aYf = (TbImageView) getView().findViewById(t.g.user_head_mask);
            }
            this.bah.aYf.c(rC.getvipV_url(), 10, false);
            this.bah.aZc.setIsBigV(true);
        }
        this.bah.aZc.setData(this.bag.bbC);
        this.bah.aZc.setAfterClickListener(this.bai);
        this.bah.aZT.setData(this.bag.bbC);
        this.bah.aZT.setUserNameTextSizeRid(t.e.fontsize24);
        this.bah.aZT.setUserAfterClickListener(this.bai);
        Resources resources = this.GM.getResources();
        String string = resources.getString(t.j.recommend_live_title_prefix);
        new SpannableStringBuilder(String.valueOf(string) + this.bag.bbC.getTitle()).setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.av.getColor(t.d.cp_link_tip_a)), 0, string.length(), 17);
        this.bah.ban.setText(e(this.bag.bbC.getTitle()));
        String fansNickName = this.bag.bbC.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(t.j.fans_default_name);
        }
        this.bah.bao.setText(String.valueOf(fansNickName) + ": " + com.baidu.tbadk.core.util.ba.w(this.bag.bbC.getAuthor().getFansNum()));
        this.bah.baq.setData(this.bag.bbC);
        this.bah.baq.setForumAfterClickListener(this.baj);
        this.bah.baq.setStType(ap.ND());
        this.bah.baq.setYuelaouLocate("feed#" + this.bag.NJ());
        onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        if (com.baidu.tbadk.core.l.oG().oM() && this.bag.bbC.getPhotoLiveCover() != null && this.bag.bbC.getPhotoLiveCover().length() != 0) {
            this.bah.bap.setVisibility(0);
            this.bah.bap.c(this.bag.bbC.getPhotoLiveCover(), 10, false);
        } else {
            this.bah.bap.setVisibility(8);
        }
        com.baidu.tbadk.core.util.av.c(this.bah.bao, t.d.cp_cont_d, 1);
        if (ap.hH(this.bag.bbC.getId())) {
            com.baidu.tbadk.core.util.av.c(this.bah.ban, t.d.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.av.c(this.bah.ban, t.d.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bah.mRootView || view == this.bah.baq.getCommentNumView()) {
            if (getOnSubCardOnClickListenner() != null) {
                getOnSubCardOnClickListenner().a(this.bah.mRootView, this.bag);
            }
            NG();
        }
    }

    private void NG() {
        if (this.bag != null && this.bag.bbC != null) {
            ap.hG(this.bag.bbC.getId());
            if (!NH()) {
                UtilHelper.showToast(this.GM.getPageActivity(), t.j.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.GM.getPageActivity(), this.bag.bbC.getTid()).ci(this.bag.bbC.rQ()).cl(this.bag.NK()).cj(ap.ND()).oW()));
            hI(this.bag.bbC.getTid());
        }
    }

    public void hI(String str) {
        new Handler().postDelayed(new bk(this, str), 600L);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.j.a.a(tbPageContext, this.bah.mRootView);
            this.bah.aZT.ti();
            this.bah.baq.ti();
            com.baidu.tbadk.core.util.av.l(this.bah.bam, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.k(this.bah.mRootView, t.f.addresslist_item_bg);
            this.mSkinType = i;
        }
    }

    private boolean NH() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.aZB != null) {
            this.aZB.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aZB);
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.GM.getResources().getString(t.j.recommend_live_title_prefix);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.av.getColor(t.d.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.d dVar = new com.baidu.adp.widget.d(this.GM.getPageActivity(), com.baidu.tbadk.core.util.av.cN(t.f.pic_dot_title), 1);
        dVar.setOffset(3);
        spannableStringBuilder.setSpan(dVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    /* loaded from: classes.dex */
    public class a {
        public ViewStub aYe;
        public TbImageView aYf;
        public UserIconLayout aZT;
        public ClickableHeaderImageView aZc;
        public View bam;
        public TextView ban;
        public TextView bao;
        public TbImageView bap;
        public ThreadCommentAndPraiseInfoLayout baq;
        public View mRootView;

        public a() {
        }
    }
}
