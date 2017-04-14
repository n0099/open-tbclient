package com.baidu.tieba.card;

import android.content.res.Resources;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
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
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class bk extends com.baidu.tieba.card.a<com.baidu.tieba.card.data.o> {
    private TbPageContext<?> ajT;
    private CustomMessageListener bsD;
    private com.baidu.tieba.card.data.o btB;
    public a btC;
    private View.OnClickListener btD;
    private View.OnClickListener btE;

    public bk(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.btD = new bl(this);
        this.btE = new bm(this);
        this.bsD = new bn(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.ajT = tbPageContext;
        P(getView());
        initUI();
    }

    private void P(View view) {
        this.btC = new a();
        this.btC.mRootView = view.findViewById(w.h.card_root_view);
        this.btC.btH = view.findViewById(w.h.top_line);
        this.btC.baZ = (ClickableHeaderImageView) view.findViewById(w.h.avatar);
        this.btC.bba = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.btC.bto = (UserIconLayout) view.findViewById(w.h.user_icon);
        this.btC.aRU = (TextView) view.findViewById(w.h.thread_title);
        this.btC.btI = (TextView) view.findViewById(w.h.fans_num);
        this.btC.btJ = (TbImageView) view.findViewById(w.h.thread_image);
        this.btC.btK = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.thread_more_info);
        this.btC.btL = view.findViewById(w.h.divider_below_reply_number_layout);
        this.btC.mRootView.setOnClickListener(this);
        this.btC.btK.setOnClickListener(this);
        this.btC.bsk = (CardGroupDividerView) view.findViewById(w.h.header_divider);
    }

    private void initUI() {
        this.btC.baZ.setRadius(com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds70));
        this.btC.baZ.setDefaultResource(17170445);
        this.btC.baZ.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.btC.baZ.setDefaultBgResource(w.e.cp_bg_line_e);
        this.btC.btK.setShowPraiseNum(false);
        this.btC.btJ.setDrawBorder(true);
        this.btC.btJ.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.o oVar) {
        this.btB = oVar;
        Nq();
    }

    private void Nq() {
        if (this.btB == null || this.btB.bbo == null) {
            this.btC.mRootView.setVisibility(8);
            return;
        }
        UserTbVipInfoData sp = this.btB.Kn().sp();
        if (sp != null && sp.getvipV_url() != null && this.btC.bba != null) {
            if (this.btC.bbb == null) {
                this.btC.bba.inflate();
                this.btC.bbb = (TbImageView) getView().findViewById(w.h.user_head_mask);
            }
            this.btC.bbb.c(sp.getvipV_url(), 10, false);
            this.btC.baZ.setIsBigV(true);
        }
        this.btC.baZ.setData(this.btB.bbo);
        this.btC.baZ.setAfterClickListener(this.btD);
        this.btC.bto.setData(this.btB.bbo);
        this.btC.bto.setUserNameTextSizeRid(w.f.fontsize24);
        this.btC.bto.setUserAfterClickListener(this.btD);
        Resources resources = this.ajT.getResources();
        String string = resources.getString(w.l.photo_live_tips);
        new SpannableStringBuilder(String.valueOf(string) + this.btB.bbo.getTitle()).setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_a)), 0, string.length(), 17);
        this.btC.aRU.setText(e(this.btB.bbo.getTitle()));
        String fansNickName = this.btB.bbo.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(w.l.fans_default_name);
        }
        this.btC.btI.setText(String.valueOf(fansNickName) + ": " + com.baidu.tbadk.core.util.au.t(this.btB.bbo.getAuthor().getFansNum()));
        if (this.btC.btK.a(this.btB.bbo)) {
            this.btC.btL.setVisibility(8);
        } else {
            this.btC.btL.setVisibility(0);
        }
        this.btC.btK.setForumAfterClickListener(this.btE);
        this.btC.btK.setStType(at.sf());
        this.btC.btK.setYuelaouLocate("feed#" + this.btB.SV());
        if (this.btC.bsC != null && this.btB.Kn() != null) {
            com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
            alVar.cp(this.btB.Kn().getTid());
            alVar.setFid(this.btB.Kn().getFid());
            alVar.a(this.btB.WT);
            this.btC.bsC.setData(alVar);
        }
        onChangeSkinType(this.ajT, TbadkCoreApplication.m9getInst().getSkinType());
        if (com.baidu.tbadk.core.q.po().pu() && this.btB.bbo.getPhotoLiveCover() != null && this.btB.bbo.getPhotoLiveCover().length() != 0) {
            this.btC.btJ.setVisibility(0);
            this.btC.btJ.c(this.btB.bbo.getPhotoLiveCover(), 10, false);
        } else {
            this.btC.btJ.setVisibility(8);
        }
        com.baidu.tbadk.core.util.aq.c(this.btC.btI, w.e.cp_cont_d, 1);
        if (at.hZ(this.btB.bbo.getId())) {
            com.baidu.tbadk.core.util.aq.c(this.btC.aRU, w.e.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.aq.c(this.btC.aRU, w.e.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.btC.mRootView || view == this.btC.btK.getCommentNumView()) {
            if (getOnSubCardOnClickListenner() != null) {
                getOnSubCardOnClickListenner().a(this.btC.mRootView, this.btB);
            }
            SR();
        }
    }

    public void SQ() {
        this.btC.bsC = new com.baidu.tbadk.core.view.o(this.ajT);
        this.btC.bsC.wQ();
        this.btC.btK.addView(this.btC.bsC);
        if (this.btC.btK.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.btC.btK.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.btC.btK.setLayoutParams(layoutParams);
        }
    }

    private void SR() {
        if (this.btB != null && this.btB.bbo != null) {
            at.hY(this.btB.bbo.getId());
            if (!SS()) {
                UtilHelper.showToast(this.ajT.getPageActivity(), w.l.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.ajT.getPageActivity(), this.btB.bbo.getTid()).ci(this.btB.bbo.sE()).cl(this.btB.SW()).cj(at.sf()).pE()));
            ia(this.btB.bbo.getTid());
        }
    }

    public void ia(String str) {
        new Handler().postDelayed(new bo(this, str), 600L);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.m.a.a(tbPageContext, this.btC.mRootView);
            this.btC.bto.onChangeSkinType();
            this.btC.btK.onChangeSkinType();
            com.baidu.tbadk.core.util.aq.k(this.btC.btH, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.j(this.btC.mRootView, w.g.addresslist_item_bg);
            this.mSkinType = i;
            if (this.btC.bsC != null) {
                this.btC.bsC.onChangeSkinType();
            }
            if (this.btC.bsk != null) {
                this.btC.bsk.onChangeSkinType();
            }
        }
    }

    private boolean SS() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bsD != null) {
            this.bsD.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bsD);
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.ajT.getResources().getString(w.l.photo_live_tips);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.d dVar = new com.baidu.adp.widget.d(this.ajT.getPageActivity(), com.baidu.tbadk.core.util.aq.cO(w.g.pic_dot_title), 1);
        dVar.setOffset(3);
        spannableStringBuilder.setSpan(dVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public void a(o.a aVar) {
        if (this.btC == null || this.btC.bsC == null) {
            return;
        }
        this.btC.bsC.setEventCallback(aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView aRU;
        public ClickableHeaderImageView baZ;
        public ViewStub bba;
        public TbImageView bbb;
        private com.baidu.tbadk.core.view.o bsC = null;
        public CardGroupDividerView bsk;
        public View btH;
        public TextView btI;
        public TbImageView btJ;
        public ThreadCommentAndPraiseInfoLayout btK;
        public View btL;
        public UserIconLayout bto;
        public View mRootView;

        public a() {
        }
    }
}
