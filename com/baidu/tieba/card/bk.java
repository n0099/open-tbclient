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
    private TbPageContext<?> ajF;
    private CustomMessageListener bsL;
    private com.baidu.tieba.card.data.o btJ;
    public a btK;
    private View.OnClickListener btL;
    private View.OnClickListener btM;

    public bk(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.btL = new bl(this);
        this.btM = new bm(this);
        this.bsL = new bn(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.ajF = tbPageContext;
        P(getView());
        initUI();
    }

    private void P(View view) {
        this.btK = new a();
        this.btK.mRootView = view.findViewById(w.h.card_root_view);
        this.btK.btP = view.findViewById(w.h.top_line);
        this.btK.bbg = (ClickableHeaderImageView) view.findViewById(w.h.avatar);
        this.btK.bbh = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.btK.btw = (UserIconLayout) view.findViewById(w.h.user_icon);
        this.btK.aRE = (TextView) view.findViewById(w.h.thread_title);
        this.btK.btQ = (TextView) view.findViewById(w.h.fans_num);
        this.btK.btR = (TbImageView) view.findViewById(w.h.thread_image);
        this.btK.btS = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.thread_more_info);
        this.btK.btT = view.findViewById(w.h.divider_below_reply_number_layout);
        this.btK.mRootView.setOnClickListener(this);
        this.btK.btS.setOnClickListener(this);
        this.btK.bss = (CardGroupDividerView) view.findViewById(w.h.header_divider);
    }

    private void initUI() {
        this.btK.bbg.setRadius(com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds70));
        this.btK.bbg.setDefaultResource(17170445);
        this.btK.bbg.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.btK.bbg.setDefaultBgResource(w.e.cp_bg_line_e);
        this.btK.btS.setShowPraiseNum(false);
        this.btK.btR.setDrawBorder(true);
        this.btK.btR.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.o oVar) {
        this.btJ = oVar;
        MR();
    }

    private void MR() {
        if (this.btJ == null || this.btJ.bbv == null) {
            this.btK.mRootView.setVisibility(8);
            return;
        }
        UserTbVipInfoData rR = this.btJ.JN().rR();
        if (rR != null && rR.getvipV_url() != null && this.btK.bbh != null) {
            if (this.btK.bbi == null) {
                this.btK.bbh.inflate();
                this.btK.bbi = (TbImageView) getView().findViewById(w.h.user_head_mask);
            }
            this.btK.bbi.c(rR.getvipV_url(), 10, false);
            this.btK.bbg.setIsBigV(true);
        }
        this.btK.bbg.setData(this.btJ.bbv);
        this.btK.bbg.setAfterClickListener(this.btL);
        this.btK.btw.setData(this.btJ.bbv);
        this.btK.btw.setUserNameTextSizeRid(w.f.fontsize24);
        this.btK.btw.setUserAfterClickListener(this.btL);
        Resources resources = this.ajF.getResources();
        String string = resources.getString(w.l.recommend_live_title_prefix);
        new SpannableStringBuilder(String.valueOf(string) + this.btJ.bbv.getTitle()).setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_a)), 0, string.length(), 17);
        this.btK.aRE.setText(e(this.btJ.bbv.getTitle()));
        String fansNickName = this.btJ.bbv.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(w.l.fans_default_name);
        }
        this.btK.btQ.setText(String.valueOf(fansNickName) + ": " + com.baidu.tbadk.core.util.au.t(this.btJ.bbv.getAuthor().getFansNum()));
        if (this.btK.btS.a(this.btJ.bbv)) {
            this.btK.btT.setVisibility(8);
        } else {
            this.btK.btT.setVisibility(0);
        }
        this.btK.btS.setForumAfterClickListener(this.btM);
        this.btK.btS.setStType(at.rH());
        this.btK.btS.setYuelaouLocate("feed#" + this.btJ.Sx());
        if (this.btK.bsK != null && this.btJ.JN() != null) {
            com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
            amVar.ci(this.btJ.JN().getTid());
            amVar.setFid(this.btJ.JN().getFid());
            amVar.a(this.btJ.WE);
            this.btK.bsK.setData(amVar);
        }
        onChangeSkinType(this.ajF, TbadkCoreApplication.m9getInst().getSkinType());
        if (com.baidu.tbadk.core.l.oQ().oW() && this.btJ.bbv.getPhotoLiveCover() != null && this.btJ.bbv.getPhotoLiveCover().length() != 0) {
            this.btK.btR.setVisibility(0);
            this.btK.btR.c(this.btJ.bbv.getPhotoLiveCover(), 10, false);
        } else {
            this.btK.btR.setVisibility(8);
        }
        com.baidu.tbadk.core.util.aq.c(this.btK.btQ, w.e.cp_cont_d, 1);
        if (at.hV(this.btJ.bbv.getId())) {
            com.baidu.tbadk.core.util.aq.c(this.btK.aRE, w.e.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.aq.c(this.btK.aRE, w.e.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.btK.mRootView || view == this.btK.btS.getCommentNumView()) {
            if (getOnSubCardOnClickListenner() != null) {
                getOnSubCardOnClickListenner().a(this.btK.mRootView, this.btJ);
            }
            St();
        }
    }

    public void Ss() {
        this.btK.bsK = new com.baidu.tbadk.core.view.o(this.ajF);
        this.btK.bsK.wu();
        this.btK.btS.addView(this.btK.bsK);
        if (this.btK.btS.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.btK.btS.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.btK.btS.setLayoutParams(layoutParams);
        }
    }

    private void St() {
        if (this.btJ != null && this.btJ.bbv != null) {
            at.hU(this.btJ.bbv.getId());
            if (!Su()) {
                UtilHelper.showToast(this.ajF.getPageActivity(), w.l.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.ajF.getPageActivity(), this.btJ.bbv.getTid()).cb(this.btJ.bbv.sg()).ce(this.btJ.Sy()).cc(at.rH()).pg()));
            hW(this.btJ.bbv.getTid());
        }
    }

    public void hW(String str) {
        new Handler().postDelayed(new bo(this, str), 600L);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, this.btK.mRootView);
            this.btK.btw.tD();
            this.btK.btS.tD();
            com.baidu.tbadk.core.util.aq.k(this.btK.btP, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.j(this.btK.mRootView, w.g.addresslist_item_bg);
            this.mSkinType = i;
            if (this.btK.bsK != null) {
                this.btK.bsK.tD();
            }
            if (this.btK.bss != null) {
                this.btK.bss.tD();
            }
        }
    }

    private boolean Su() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bsL != null) {
            this.bsL.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bsL);
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.ajF.getResources().getString(w.l.recommend_live_title_prefix);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.d dVar = new com.baidu.adp.widget.d(this.ajF.getPageActivity(), com.baidu.tbadk.core.util.aq.cL(w.g.pic_dot_title), 1);
        dVar.setOffset(3);
        spannableStringBuilder.setSpan(dVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public void a(o.a aVar) {
        if (this.btK == null || this.btK.bsK == null) {
            return;
        }
        this.btK.bsK.setEventCallback(aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView aRE;
        public ClickableHeaderImageView bbg;
        public ViewStub bbh;
        public TbImageView bbi;
        private com.baidu.tbadk.core.view.o bsK = null;
        public CardGroupDividerView bss;
        public View btP;
        public TextView btQ;
        public TbImageView btR;
        public ThreadCommentAndPraiseInfoLayout btS;
        public View btT;
        public UserIconLayout btw;
        public View mRootView;

        public a() {
        }
    }
}
