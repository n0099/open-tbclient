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
    private String aob;
    private final View.OnClickListener aoc;
    private final View.OnClickListener aou;
    private CustomMessageListener bLe;
    private View.OnClickListener bLf;
    private com.baidu.tieba.card.data.m bMk;
    public a bMl;
    private View.OnClickListener bMm;
    private View.OnClickListener bMn;
    private TbPageContext<?> mF;
    private String mStType;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bMm = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.XL() != null) {
                    p.this.XL().a(view, p.this.bMk);
                }
            }
        };
        this.bMn = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.XL() != null) {
                    p.this.XL().a(view, p.this.bMk);
                }
            }
        };
        this.bLe = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.p.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && p.this.bMk != null && p.this.bMk.bcG != null && p.this.bMk.bcG.getTid() != null && p.this.bMl != null && p.this.bMl.bJS != null && ((String) customResponsedMessage.getData()).equals(p.this.bMk.bcG.getTid())) {
                    m.a(p.this.bMl.bJS, p.this.bMk.bcG.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                }
            }
        };
        this.aou = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.XL() != null) {
                    p.this.XL().a(view, p.this.bMk);
                }
            }
        };
        this.aoc = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.XL() != null) {
                    p.this.XL().a(view, p.this.bMk);
                }
            }
        };
        this.bLf = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.bMk != null && !StringUtils.isNull(p.this.bMk.bcG.rG())) {
                    String rG = p.this.bMk.bcG.rG();
                    if (StringUtils.isNull(p.this.mStType) || StringUtils.isNull(p.this.aob)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(p.this.mContext).createNormalCfg(rG, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(p.this.mContext).createCfgForpersonalized(rG, p.this.mStType, p.this.aob)));
                    }
                    if (p.this.aoc != null) {
                        p.this.aoc.onClick(view);
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
        this.bMl = new a();
        this.bMl.mRootView = view.findViewById(d.h.card_root_view);
        this.bMl.anx = (TextView) view.findViewById(d.h.thread_info_bar_name);
        this.bMl.bJS = (TextView) view.findViewById(d.h.thread_title);
        this.bMl.bMp = (TbImageView) view.findViewById(d.h.thread_image);
        this.bMl.bMq = (ThreadCommentAndPraiseInfoLayoutNew) view.findViewById(d.h.thread_more_info);
        this.bMl.bMr = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bMl.mRootView.setOnClickListener(this);
        this.bMl.anx.setOnClickListener(this.bLf);
        this.bMl.bMq.setOnClickListener(this);
        this.bMl.bKR = (CardGroupDividerView) view.findViewById(d.h.header_divider);
    }

    private void initUI() {
        this.bMl.bMp.setDrawBorder(true);
        this.bMl.bMp.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_zhibo_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.m mVar) {
        this.bMk = mVar;
        refreshView();
    }

    private void refreshView() {
        if (this.bMk == null || this.bMk.bcG == null) {
            this.bMl.mRootView.setVisibility(8);
            return;
        }
        m.a(getContext(), this.bMk.bcG, this.bMl.anx);
        String string = this.mF.getResources().getString(d.l.photo_live_tips);
        new SpannableStringBuilder(string + this.bMk.bcG.getTitle()).setSpan(new ForegroundColorSpan(aj.getColor(d.e.cp_link_tip_a)), 0, string.length(), 17);
        this.bMl.bJS.setText(e(this.bMk.bcG.getTitle()));
        this.aob = "feed#" + this.bMk.Ym();
        this.bMl.bMq.setIsSimpleThread(false);
        this.bMl.bMq.setUserAfterClickListener(this.aou);
        this.bMl.bMq.xm();
        if (this.bMl.bMq.c(this.bMk.bcG)) {
            this.bMl.bMr.setVisibility(8);
        } else {
            this.bMl.bMr.setVisibility(0);
        }
        if (this.bMl.bKk != null && this.bMk.MR() != null) {
            an anVar = new an();
            anVar.cy(this.bMk.MR().getTid());
            anVar.setFid(this.bMk.MR().getFid());
            anVar.a(this.bMk.Xf);
            this.bMl.bKk.setData(anVar);
            this.bMl.bKk.setFirstRowSingleColumn(true);
        }
        d(this.mF, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.h.oS().oY() && this.bMk.bcG.getPhotoLiveCover() != null && this.bMk.bcG.getPhotoLiveCover().length() != 0) {
            this.bMl.bMp.setVisibility(0);
            this.bMl.bMp.c(this.bMk.bcG.getPhotoLiveCover(), 10, false);
        } else {
            this.bMl.bMp.setVisibility(8);
        }
        if (m.jv(this.bMk.bcG.getId())) {
            aj.c(this.bMl.bJS, d.e.cp_cont_d, 1);
        } else {
            aj.c(this.bMl.bJS, d.e.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bMl.mRootView || view == this.bMl.bMq.getCommentNumView()) {
            if (XL() != null) {
                XL().a(this.bMl.mRootView, this.bMk);
            }
            Ye();
        }
    }

    public void Yd() {
        this.bMl.bKk = new com.baidu.tbadk.core.view.h(this.mF);
        this.bMl.bKk.wI();
        this.bMl.bMq.addView(this.bMl.bKk);
        if (this.bMl.bMq.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bMl.bMq.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bMl.bMq.setLayoutParams(layoutParams);
        }
    }

    private void Ye() {
        if (this.bMk != null && this.bMk.bcG != null) {
            m.ju(this.bMk.bcG.getId());
            if (!Yf()) {
                UtilHelper.showToast(this.mF.getPageActivity(), d.l.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.mF.getPageActivity(), this.bMk.bcG.getTid()).cs(this.bMk.bcG.rR()).cv(this.bMk.Yn()).ct(m.rs()).pi()));
            jw(this.bMk.bcG.getTid());
        }
    }

    public void jw(final String str) {
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
            com.baidu.tbadk.o.a.a(tbPageContext, this.bMl.mRootView);
            this.bMl.bMq.onChangeSkinType();
            aj.j(this.bMl.mRootView, d.g.addresslist_item_bg);
            this.mSkinType = i;
            if (this.bMl.bKk != null) {
                this.bMl.bKk.onChangeSkinType();
            }
            if (this.bMl.bKR != null) {
                this.bMl.bKR.onChangeSkinType();
            }
        }
    }

    private boolean Yf() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bLe != null) {
            setTag(bdUniqueId);
            if (this.bMl != null && this.bMl.bKk != null) {
                this.bMl.bKk.setUniqueId(bdUniqueId);
            }
            this.bLe.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bLe);
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
        if (this.bMl == null || this.bMl.bKk == null) {
            return;
        }
        this.bMl.bKk.setEventCallback(aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView anx;
        public TextView bJS;
        public CardGroupDividerView bKR;
        private com.baidu.tbadk.core.view.h bKk = null;
        public TbImageView bMp;
        public ThreadCommentAndPraiseInfoLayoutNew bMq;
        public View bMr;
        public View mRootView;

        public a() {
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bMl.bMq != null) {
            return this.bMl.bMq.aop;
        }
        return null;
    }

    public View Yg() {
        return this.bMl.anx;
    }

    public View XO() {
        if (this.bMl.bMq != null) {
            return this.bMl.bMq.aoq;
        }
        return null;
    }
}
