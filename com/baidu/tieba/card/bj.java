package com.baidu.tieba.card;

import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
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
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew;
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class bj extends com.baidu.tieba.card.a<com.baidu.tieba.card.data.m> {
    private TbPageContext<?> ajh;
    private String alN;
    private final View.OnClickListener alO;
    private View.OnClickListener alR;
    private final View.OnClickListener ama;
    private CustomMessageListener bAA;
    private com.baidu.tieba.card.data.m bBF;
    public a bBG;
    private View.OnClickListener bBH;
    private View.OnClickListener bBI;
    private String mStType;

    public bj(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bBH = new bk(this);
        this.bBI = new bl(this);
        this.bAA = new bm(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.ama = new bn(this);
        this.alO = new bo(this);
        this.alR = new bp(this);
        this.ajh = tbPageContext;
        this.mStType = at.rl();
        N(getView());
        initUI();
    }

    private void N(View view) {
        this.bBG = new a();
        this.bBG.mRootView = view.findViewById(w.h.card_root_view);
        this.bBG.alt = (TextView) view.findViewById(w.h.thread_info_bar_name);
        this.bBG.bzn = (TextView) view.findViewById(w.h.thread_title);
        this.bBG.bBL = (TbImageView) view.findViewById(w.h.thread_image);
        this.bBG.bBM = (ThreadCommentAndPraiseInfoLayoutNew) view.findViewById(w.h.thread_more_info);
        this.bBG.bBN = view.findViewById(w.h.divider_below_reply_number_layout);
        this.bBG.mRootView.setOnClickListener(this);
        this.bBG.alt.setOnClickListener(this.alR);
        this.bBG.bBM.setOnClickListener(this);
        this.bBG.bAn = (CardGroupDividerView) view.findViewById(w.h.header_divider);
    }

    private void initUI() {
        this.bBG.bBL.setDrawBorder(true);
        this.bBG.bBL.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_zhibo_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.m mVar) {
        this.bBF = mVar;
        MU();
    }

    private void MU() {
        if (this.bBF == null || this.bBF.aYA == null) {
            this.bBG.mRootView.setVisibility(8);
            return;
        }
        at.a(getContext(), this.bBF.aYA, this.bBG.alt);
        String string = this.ajh.getResources().getString(w.l.photo_live_tips);
        new SpannableStringBuilder(String.valueOf(string) + this.bBF.aYA.getTitle()).setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_a)), 0, string.length(), 17);
        this.bBG.bzn.setText(e(this.bBF.aYA.getTitle()));
        this.alN = "feed#" + this.bBF.UB();
        this.bBG.bBM.setIsSimpleThread(false);
        this.bBG.bBM.setUserAfterClickListener(this.ama);
        this.bBG.bBM.wz();
        if (this.bBG.bBM.a(this.bBF.aYA)) {
            this.bBG.bBN.setVisibility(8);
        } else {
            this.bBG.bBN.setVisibility(0);
        }
        if (this.bBG.bzF != null && this.bBF.LH() != null) {
            com.baidu.tbadk.core.data.an anVar = new com.baidu.tbadk.core.data.an();
            anVar.co(this.bBF.LH().getTid());
            anVar.setFid(this.bBF.LH().getFid());
            anVar.a(this.bBF.Wh);
            this.bBG.bzF.setData(anVar);
        }
        d(this.ajh, TbadkCoreApplication.m9getInst().getSkinType());
        if (com.baidu.tbadk.core.r.oN().oT() && this.bBF.aYA.getPhotoLiveCover() != null && this.bBF.aYA.getPhotoLiveCover().length() != 0) {
            this.bBG.bBL.setVisibility(0);
            this.bBG.bBL.c(this.bBF.aYA.getPhotoLiveCover(), 10, false);
        } else {
            this.bBG.bBL.setVisibility(8);
        }
        if (at.ic(this.bBF.aYA.getId())) {
            com.baidu.tbadk.core.util.aq.c(this.bBG.bzn, w.e.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.aq.c(this.bBG.bzn, w.e.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bBG.mRootView || view == this.bBG.bBM.getCommentNumView()) {
            if (Ud() != null) {
                Ud().a(this.bBG.mRootView, this.bBF);
            }
            Ut();
        }
    }

    public void Us() {
        this.bBG.bzF = new com.baidu.tbadk.core.view.o(this.ajh);
        this.bBG.bzF.wa();
        this.bBG.bBM.addView(this.bBG.bzF);
        if (this.bBG.bBM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bBG.bBM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bBG.bBM.setLayoutParams(layoutParams);
        }
    }

    private void Ut() {
        if (this.bBF != null && this.bBF.aYA != null) {
            at.ib(this.bBF.aYA.getId());
            if (!Uu()) {
                UtilHelper.showToast(this.ajh.getPageActivity(), w.l.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.ajh.getPageActivity(), this.bBF.aYA.getTid()).ci(this.bBF.aYA.rK()).cl(this.bBF.UC()).cj(at.rl()).pd()));
            id(this.bBF.aYA.getTid());
        }
    }

    public void id(String str) {
        new Handler().postDelayed(new bq(this, str), 600L);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.m.a.a(tbPageContext, this.bBG.mRootView);
            this.bBG.bBM.onChangeSkinType();
            com.baidu.tbadk.core.util.aq.j(this.bBG.mRootView, w.g.addresslist_item_bg);
            this.mSkinType = i;
            if (this.bBG.bzF != null) {
                this.bBG.bzF.onChangeSkinType();
            }
            if (this.bBG.bAn != null) {
                this.bBG.bAn.onChangeSkinType();
            }
        }
    }

    private boolean Uu() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bAA != null) {
            setTag(bdUniqueId);
            if (this.bBG != null && this.bBG.bzF != null) {
                this.bBG.bzF.setUniqueId(bdUniqueId);
            }
            this.bAA.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bAA);
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.ajh.getResources().getString(w.l.photo_live_tips);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.d dVar = new com.baidu.adp.widget.d(this.ajh.getPageActivity(), com.baidu.tbadk.core.util.aq.cM(w.g.pic_dot_title), 1);
        dVar.setOffset(3);
        spannableStringBuilder.setSpan(dVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public void a(o.a aVar) {
        if (this.bBG == null || this.bBG.bzF == null) {
            return;
        }
        this.bBG.bzF.setEventCallback(aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView alt;
        public CardGroupDividerView bAn;
        public TbImageView bBL;
        public ThreadCommentAndPraiseInfoLayoutNew bBM;
        public View bBN;
        private com.baidu.tbadk.core.view.o bzF = null;
        public TextView bzn;
        public View mRootView;

        public a() {
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bBG.bBM != null) {
            return this.bBG.bBM.alV;
        }
        return null;
    }

    public View Uv() {
        return this.bBG.alt;
    }

    public View Ug() {
        if (this.bBG.bBM != null) {
            return this.bBG.bBM.alW;
        }
        return null;
    }
}
