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
    private TbPageContext<?> ajP;
    private String amE;
    private final View.OnClickListener amF;
    private View.OnClickListener amJ;
    private final View.OnClickListener amS;
    private CustomMessageListener bBt;
    private View.OnClickListener bCA;
    private View.OnClickListener bCB;
    private com.baidu.tieba.card.data.m bCy;
    public a bCz;
    private String mStType;

    public bj(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bCA = new bk(this);
        this.bCB = new bl(this);
        this.bBt = new bm(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.amS = new bn(this);
        this.amF = new bo(this);
        this.amJ = new bp(this);
        this.ajP = tbPageContext;
        this.mStType = at.ri();
        O(getView());
        initUI();
    }

    private void O(View view) {
        this.bCz = new a();
        this.bCz.mRootView = view.findViewById(w.h.card_root_view);
        this.bCz.amh = (TextView) view.findViewById(w.h.thread_info_bar_name);
        this.bCz.bAg = (TextView) view.findViewById(w.h.thread_title);
        this.bCz.bCE = (TbImageView) view.findViewById(w.h.thread_image);
        this.bCz.bCF = (ThreadCommentAndPraiseInfoLayoutNew) view.findViewById(w.h.thread_more_info);
        this.bCz.bCG = view.findViewById(w.h.divider_below_reply_number_layout);
        this.bCz.mRootView.setOnClickListener(this);
        this.bCz.amh.setOnClickListener(this.amJ);
        this.bCz.bCF.setOnClickListener(this);
        this.bCz.bBg = (CardGroupDividerView) view.findViewById(w.h.header_divider);
    }

    private void initUI() {
        this.bCz.bCE.setDrawBorder(true);
        this.bCz.bCE.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_zhibo_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.m mVar) {
        this.bCy = mVar;
        Oh();
    }

    private void Oh() {
        if (this.bCy == null || this.bCy.bai == null) {
            this.bCz.mRootView.setVisibility(8);
            return;
        }
        at.a(getContext(), this.bCy.bai, this.bCz.amh);
        String string = this.ajP.getResources().getString(w.l.photo_live_tips);
        new SpannableStringBuilder(String.valueOf(string) + this.bCy.bai.getTitle()).setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.as.getColor(w.e.cp_link_tip_a)), 0, string.length(), 17);
        this.bCz.bAg.setText(e(this.bCy.bai.getTitle()));
        this.amE = "feed#" + this.bCy.VS();
        this.bCz.bCF.setIsSimpleThread(false);
        this.bCz.bCF.setUserAfterClickListener(this.amS);
        this.bCz.bCF.wR();
        if (this.bCz.bCF.a(this.bCy.bai)) {
            this.bCz.bCG.setVisibility(8);
        } else {
            this.bCz.bCG.setVisibility(0);
        }
        if (this.bCz.bAy != null && this.bCy.Mv() != null) {
            com.baidu.tbadk.core.data.ao aoVar = new com.baidu.tbadk.core.data.ao();
            aoVar.cu(this.bCy.Mv().getTid());
            aoVar.setFid(this.bCy.Mv().getFid());
            aoVar.a(this.bCy.Wh);
            this.bCz.bAy.setData(aoVar);
        }
        d(this.ajP, TbadkCoreApplication.m9getInst().getSkinType());
        if (com.baidu.tbadk.core.r.oK().oQ() && this.bCy.bai.getPhotoLiveCover() != null && this.bCy.bai.getPhotoLiveCover().length() != 0) {
            this.bCz.bCE.setVisibility(0);
            this.bCz.bCE.c(this.bCy.bai.getPhotoLiveCover(), 10, false);
        } else {
            this.bCz.bCE.setVisibility(8);
        }
        if (at.iJ(this.bCy.bai.getId())) {
            com.baidu.tbadk.core.util.as.c(this.bCz.bAg, w.e.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.as.c(this.bCz.bAg, w.e.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bCz.mRootView || view == this.bCz.bCF.getCommentNumView()) {
            if (Vs() != null) {
                Vs().a(this.bCz.mRootView, this.bCy);
            }
            VK();
        }
    }

    public void VJ() {
        this.bCz.bAy = new com.baidu.tbadk.core.view.o(this.ajP);
        this.bCz.bAy.wr();
        this.bCz.bCF.addView(this.bCz.bAy);
        if (this.bCz.bCF.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bCz.bCF.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bCz.bCF.setLayoutParams(layoutParams);
        }
    }

    private void VK() {
        if (this.bCy != null && this.bCy.bai != null) {
            at.iI(this.bCy.bai.getId());
            if (!VL()) {
                UtilHelper.showToast(this.ajP.getPageActivity(), w.l.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.ajP.getPageActivity(), this.bCy.bai.getTid()).co(this.bCy.bai.rH()).cr(this.bCy.VT()).cp(at.ri()).pa()));
            iK(this.bCy.bai.getTid());
        }
    }

    public void iK(String str) {
        new Handler().postDelayed(new bq(this, str), 600L);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.m.a.a(tbPageContext, this.bCz.mRootView);
            this.bCz.bCF.onChangeSkinType();
            com.baidu.tbadk.core.util.as.j(this.bCz.mRootView, w.g.addresslist_item_bg);
            this.mSkinType = i;
            if (this.bCz.bAy != null) {
                this.bCz.bAy.onChangeSkinType();
            }
            if (this.bCz.bBg != null) {
                this.bCz.bBg.onChangeSkinType();
            }
        }
    }

    private boolean VL() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bBt != null) {
            setTag(bdUniqueId);
            if (this.bCz != null && this.bCz.bAy != null) {
                this.bCz.bAy.setUniqueId(bdUniqueId);
            }
            this.bBt.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bBt);
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.ajP.getResources().getString(w.l.photo_live_tips);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.as.getColor(w.e.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.d dVar = new com.baidu.adp.widget.d(this.ajP.getPageActivity(), com.baidu.tbadk.core.util.as.cO(w.g.pic_dot_title), 1);
        dVar.setOffset(3);
        spannableStringBuilder.setSpan(dVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public void a(o.a aVar) {
        if (this.bCz == null || this.bCz.bAy == null) {
            return;
        }
        this.bCz.bAy.setEventCallback(aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView amh;
        public TextView bAg;
        private com.baidu.tbadk.core.view.o bAy = null;
        public CardGroupDividerView bBg;
        public TbImageView bCE;
        public ThreadCommentAndPraiseInfoLayoutNew bCF;
        public View bCG;
        public View mRootView;

        public a() {
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bCz.bCF != null) {
            return this.bCz.bCF.amN;
        }
        return null;
    }

    public View VM() {
        return this.bCz.amh;
    }

    public View Vv() {
        if (this.bCz.bCF != null) {
            return this.bCz.bCF.amO;
        }
        return null;
    }
}
