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
public class bf extends com.baidu.tieba.card.a<com.baidu.tieba.card.data.m> {
    private TbPageContext<?> ajr;
    private String alX;
    private final View.OnClickListener alY;
    private View.OnClickListener amb;
    private final View.OnClickListener amk;
    private CustomMessageListener buT;
    private com.baidu.tieba.card.data.m bvV;
    public a bvW;
    private View.OnClickListener bvX;
    private View.OnClickListener bvY;
    private String mStType;

    public bf(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bvX = new bg(this);
        this.bvY = new bh(this);
        this.buT = new bi(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.amk = new bj(this);
        this.alY = new bk(this);
        this.amb = new bl(this);
        this.ajr = tbPageContext;
        this.mStType = ap.rp();
        O(getView());
        initUI();
    }

    private void O(View view) {
        this.bvW = new a();
        this.bvW.mRootView = view.findViewById(w.h.card_root_view);
        this.bvW.alD = (TextView) view.findViewById(w.h.thread_info_bar_name);
        this.bvW.aSr = (TextView) view.findViewById(w.h.thread_title);
        this.bvW.bwb = (TbImageView) view.findViewById(w.h.thread_image);
        this.bvW.bwc = (ThreadCommentAndPraiseInfoLayoutNew) view.findViewById(w.h.thread_more_info);
        this.bvW.bwd = view.findViewById(w.h.divider_below_reply_number_layout);
        this.bvW.mRootView.setOnClickListener(this);
        this.bvW.alD.setOnClickListener(this.amb);
        this.bvW.bwc.setOnClickListener(this);
        this.bvW.buA = (CardGroupDividerView) view.findViewById(w.h.header_divider);
    }

    private void initUI() {
        this.bvW.bwb.setDrawBorder(true);
        this.bvW.bwb.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_zhibo_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.m mVar) {
        this.bvV = mVar;
        MM();
    }

    private void MM() {
        if (this.bvV == null || this.bvV.bcB == null) {
            this.bvW.mRootView.setVisibility(8);
            return;
        }
        ap.a(getContext(), this.bvV.bcB, this.bvW.alD);
        String string = this.ajr.getResources().getString(w.l.photo_live_tips);
        new SpannableStringBuilder(String.valueOf(string) + this.bvV.bcB.getTitle()).setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_a)), 0, string.length(), 17);
        this.bvW.aSr.setText(e(this.bvV.bcB.getTitle()));
        this.alX = "feed#" + this.bvV.Tq();
        this.bvW.bwc.setIsSimpleThread(false);
        this.bvW.bwc.setUserAfterClickListener(this.amk);
        this.bvW.bwc.wD();
        if (this.bvW.bwc.a(this.bvV.bcB)) {
            this.bvW.bwd.setVisibility(8);
        } else {
            this.bvW.bwd.setVisibility(0);
        }
        if (this.bvW.buS != null && this.bvV.JB() != null) {
            com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
            amVar.cp(this.bvV.JB().getTid());
            amVar.setFid(this.bvV.JB().getFid());
            amVar.a(this.bvV.Wm);
            this.bvW.buS.setData(amVar);
        }
        onChangeSkinType(this.ajr, TbadkCoreApplication.m9getInst().getSkinType());
        if (com.baidu.tbadk.core.r.oV().pb() && this.bvV.bcB.getPhotoLiveCover() != null && this.bvV.bcB.getPhotoLiveCover().length() != 0) {
            this.bvW.bwb.setVisibility(0);
            this.bvW.bwb.c(this.bvV.bcB.getPhotoLiveCover(), 10, false);
        } else {
            this.bvW.bwb.setVisibility(8);
        }
        if (ap.hZ(this.bvV.bcB.getId())) {
            com.baidu.tbadk.core.util.aq.c(this.bvW.aSr, w.e.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.aq.c(this.bvW.aSr, w.e.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bvW.mRootView || view == this.bvW.bwc.getCommentNumView()) {
            if (getOnSubCardOnClickListenner() != null) {
                getOnSubCardOnClickListenner().a(this.bvW.mRootView, this.bvV);
            }
            Tl();
        }
    }

    public void Tk() {
        this.bvW.buS = new com.baidu.tbadk.core.view.o(this.ajr);
        this.bvW.buS.wd();
        this.bvW.bwc.addView(this.bvW.buS);
        if (this.bvW.bwc.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvW.bwc.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bvW.bwc.setLayoutParams(layoutParams);
        }
    }

    private void Tl() {
        if (this.bvV != null && this.bvV.bcB != null) {
            ap.hY(this.bvV.bcB.getId());
            if (!Tm()) {
                UtilHelper.showToast(this.ajr.getPageActivity(), w.l.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.ajr.getPageActivity(), this.bvV.bcB.getTid()).ci(this.bvV.bcB.rO()).cl(this.bvV.Tr()).cj(ap.rp()).pl()));
            ia(this.bvV.bcB.getTid());
        }
    }

    public void ia(String str) {
        new Handler().postDelayed(new bm(this, str), 600L);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.m.a.a(tbPageContext, this.bvW.mRootView);
            this.bvW.bwc.onChangeSkinType();
            com.baidu.tbadk.core.util.aq.j(this.bvW.mRootView, w.g.addresslist_item_bg);
            this.mSkinType = i;
            if (this.bvW.buS != null) {
                this.bvW.buS.onChangeSkinType();
            }
            if (this.bvW.buA != null) {
                this.bvW.buA.onChangeSkinType();
            }
        }
    }

    private boolean Tm() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.buT != null) {
            setTag(bdUniqueId);
            if (this.bvW != null && this.bvW.buS != null) {
                this.bvW.buS.setUniqueId(bdUniqueId);
            }
            this.buT.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.buT);
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.ajr.getResources().getString(w.l.photo_live_tips);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.d dVar = new com.baidu.adp.widget.d(this.ajr.getPageActivity(), com.baidu.tbadk.core.util.aq.cL(w.g.pic_dot_title), 1);
        dVar.setOffset(3);
        spannableStringBuilder.setSpan(dVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public void a(o.a aVar) {
        if (this.bvW == null || this.bvW.buS == null) {
            return;
        }
        this.bvW.buS.setEventCallback(aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView aSr;
        public TextView alD;
        public CardGroupDividerView buA;
        private com.baidu.tbadk.core.view.o buS = null;
        public TbImageView bwb;
        public ThreadCommentAndPraiseInfoLayoutNew bwc;
        public View bwd;
        public View mRootView;

        public a() {
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bvW.bwc != null) {
            return this.bvW.bwc.amf;
        }
        return null;
    }

    public View Tn() {
        return this.bvW.alD;
    }

    public View Tg() {
        if (this.bvW.bwc != null) {
            return this.bvW.bwc.amg;
        }
        return null;
    }
}
