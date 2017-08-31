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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.card.a<com.baidu.tieba.card.data.m> {
    private String aod;
    private final View.OnClickListener aoe;
    private final View.OnClickListener aow;
    private CustomMessageListener bKn;
    private View.OnClickListener bKo;
    private com.baidu.tieba.card.data.m bLt;
    public a bLu;
    private View.OnClickListener bLv;
    private View.OnClickListener bLw;
    private TbPageContext<?> mF;
    private String mStType;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bLv = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.XA() != null) {
                    p.this.XA().a(view, p.this.bLt);
                }
            }
        };
        this.bLw = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.XA() != null) {
                    p.this.XA().a(view, p.this.bLt);
                }
            }
        };
        this.bKn = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.p.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && p.this.bLt != null && p.this.bLt.bcJ != null && p.this.bLt.bcJ.getTid() != null && p.this.bLu != null && p.this.bLu.bJb != null && ((String) customResponsedMessage.getData()).equals(p.this.bLt.bcJ.getTid())) {
                    m.a(p.this.bLu.bJb, p.this.bLt.bcJ.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                }
            }
        };
        this.aow = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.XA() != null) {
                    p.this.XA().a(view, p.this.bLt);
                }
            }
        };
        this.aoe = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.XA() != null) {
                    p.this.XA().a(view, p.this.bLt);
                }
            }
        };
        this.bKo = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.bLt != null && !StringUtils.isNull(p.this.bLt.bcJ.rG())) {
                    String rG = p.this.bLt.bcJ.rG();
                    if (StringUtils.isNull(p.this.mStType) || StringUtils.isNull(p.this.aod)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(p.this.mContext).createNormalCfg(rG, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(p.this.mContext).createCfgForpersonalized(rG, p.this.mStType, p.this.aod)));
                    }
                    if (p.this.aoe != null) {
                        p.this.aoe.onClick(view);
                    }
                }
            }
        };
        this.mF = tbPageContext;
        this.mStType = m.rs();
        X(getView());
        initUI();
    }

    private void X(View view) {
        this.bLu = new a();
        this.bLu.mRootView = view.findViewById(d.h.card_root_view);
        this.bLu.anz = (TextView) view.findViewById(d.h.thread_info_bar_name);
        this.bLu.bJb = (TextView) view.findViewById(d.h.thread_title);
        this.bLu.bLy = (TbImageView) view.findViewById(d.h.thread_image);
        this.bLu.bLz = (ThreadCommentAndPraiseInfoLayoutNew) view.findViewById(d.h.thread_more_info);
        this.bLu.bLA = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bLu.mRootView.setOnClickListener(this);
        this.bLu.anz.setOnClickListener(this.bKo);
        this.bLu.bLz.setOnClickListener(this);
        this.bLu.bKa = (CardGroupDividerView) view.findViewById(d.h.header_divider);
    }

    private void initUI() {
        this.bLu.bLy.setDrawBorder(true);
        this.bLu.bLy.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_zhibo_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.m mVar) {
        this.bLt = mVar;
        refreshView();
    }

    private void refreshView() {
        if (this.bLt == null || this.bLt.bcJ == null) {
            this.bLu.mRootView.setVisibility(8);
            return;
        }
        m.a(getContext(), this.bLt.bcJ, this.bLu.anz);
        String string = this.mF.getResources().getString(d.l.photo_live_tips);
        new SpannableStringBuilder(string + this.bLt.bcJ.getTitle()).setSpan(new ForegroundColorSpan(aj.getColor(d.e.cp_link_tip_a)), 0, string.length(), 17);
        this.bLu.bJb.setText(e(this.bLt.bcJ.getTitle()));
        this.aod = "feed#" + this.bLt.Yb();
        this.bLu.bLz.setIsSimpleThread(false);
        this.bLu.bLz.setUserAfterClickListener(this.aow);
        this.bLu.bLz.xm();
        if (this.bLu.bLz.c(this.bLt.bcJ)) {
            this.bLu.bLA.setVisibility(8);
        } else {
            this.bLu.bLA.setVisibility(0);
        }
        if (this.bLu.bJt != null && this.bLt.MR() != null) {
            an anVar = new an();
            anVar.cy(this.bLt.MR().getTid());
            anVar.setFid(this.bLt.MR().getFid());
            anVar.a(this.bLt.Xf);
            this.bLu.bJt.setData(anVar);
            this.bLu.bJt.setFirstRowSingleColumn(true);
        }
        d(this.mF, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.h.oS().oY() && this.bLt.bcJ.getPhotoLiveCover() != null && this.bLt.bcJ.getPhotoLiveCover().length() != 0) {
            this.bLu.bLy.setVisibility(0);
            this.bLu.bLy.c(this.bLt.bcJ.getPhotoLiveCover(), 10, false);
        } else {
            this.bLu.bLy.setVisibility(8);
        }
        if (m.jt(this.bLt.bcJ.getId())) {
            aj.c(this.bLu.bJb, d.e.cp_cont_d, 1);
        } else {
            aj.c(this.bLu.bJb, d.e.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bLu.mRootView || view == this.bLu.bLz.getCommentNumView()) {
            if (XA() != null) {
                XA().a(this.bLu.mRootView, this.bLt);
            }
            XT();
        }
    }

    public void XS() {
        this.bLu.bJt = new com.baidu.tbadk.core.view.h(this.mF);
        this.bLu.bJt.wI();
        this.bLu.bLz.addView(this.bLu.bJt);
        if (this.bLu.bLz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLu.bLz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bLu.bLz.setLayoutParams(layoutParams);
        }
    }

    private void XT() {
        if (this.bLt != null && this.bLt.bcJ != null) {
            m.js(this.bLt.bcJ.getId());
            if (!XU()) {
                UtilHelper.showToast(this.mF.getPageActivity(), d.l.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.mF.getPageActivity(), this.bLt.bcJ.getTid()).cs(this.bLt.bcJ.rR()).cv(this.bLt.Yc()).ct(m.rs()).pi()));
            ju(this.bLt.bcJ.getTid());
        }
    }

    public void ju(final String str) {
        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.card.p.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, str));
            }
        }, 600L);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.o.a.a(tbPageContext, this.bLu.mRootView);
            this.bLu.bLz.onChangeSkinType();
            aj.j(this.bLu.mRootView, d.g.addresslist_item_bg);
            this.mSkinType = i;
            if (this.bLu.bJt != null) {
                this.bLu.bJt.onChangeSkinType();
            }
            if (this.bLu.bKa != null) {
                this.bLu.bKa.onChangeSkinType();
            }
        }
    }

    private boolean XU() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bKn != null) {
            setTag(bdUniqueId);
            if (this.bLu != null && this.bLu.bJt != null) {
                this.bLu.bJt.setUniqueId(bdUniqueId);
            }
            this.bKn.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bKn);
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.mF.getResources().getString(d.l.photo_live_tips);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.e.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(this.mF.getPageActivity(), aj.cT(d.g.pic_dot_title), 1);
        bVar.setOffset(3);
        spannableStringBuilder.setSpan(bVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public void a(h.a aVar) {
        if (this.bLu == null || this.bLu.bJt == null) {
            return;
        }
        this.bLu.bJt.setEventCallback(aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView anz;
        public TextView bJb;
        private com.baidu.tbadk.core.view.h bJt = null;
        public CardGroupDividerView bKa;
        public View bLA;
        public TbImageView bLy;
        public ThreadCommentAndPraiseInfoLayoutNew bLz;
        public View mRootView;

        public a() {
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bLu.bLz != null) {
            return this.bLu.bLz.aor;
        }
        return null;
    }

    public View XV() {
        return this.bLu.anz;
    }

    public View XD() {
        if (this.bLu.bLz != null) {
            return this.bLu.bLz.aos;
        }
        return null;
    }
}
