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
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.card.a<com.baidu.tieba.card.data.m> {
    private final View.OnClickListener anJ;
    private String anq;
    private final View.OnClickListener anr;
    private CustomMessageListener bKy;
    private View.OnClickListener bKz;
    private com.baidu.tieba.card.data.m bLH;
    public a bLI;
    private View.OnClickListener bLJ;
    private View.OnClickListener bLK;
    private TbPageContext<?> mG;
    private String mStType;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bLJ = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.Xr() != null) {
                    p.this.Xr().a(view, p.this.bLH);
                }
            }
        };
        this.bLK = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.Xr() != null) {
                    p.this.Xr().a(view, p.this.bLH);
                }
            }
        };
        this.bKy = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.p.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && p.this.bLH != null && p.this.bLH.bes != null && p.this.bLH.bes.getTid() != null && p.this.bLI != null && p.this.bLI.bKl != null && ((String) customResponsedMessage.getData()).equals(p.this.bLH.bes.getTid())) {
                    m.a(p.this.bLI.bKl, p.this.bLH.bes.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                }
            }
        };
        this.anJ = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.Xr() != null) {
                    p.this.Xr().a(view, p.this.bLH);
                }
            }
        };
        this.anr = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.Xr() != null) {
                    p.this.Xr().a(view, p.this.bLH);
                }
            }
        };
        this.bKz = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.bLH != null && !StringUtils.isNull(p.this.bLH.bes.rA())) {
                    String rA = p.this.bLH.bes.rA();
                    if (StringUtils.isNull(p.this.mStType) || StringUtils.isNull(p.this.anq)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(p.this.mContext).createNormalCfg(rA, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(p.this.mContext).createCfgForpersonalized(rA, p.this.mStType, p.this.anq)));
                    }
                    if (p.this.anr != null) {
                        p.this.anr.onClick(view);
                    }
                }
            }
        };
        this.mG = tbPageContext;
        this.mStType = m.rm();
        X(getView());
        initUI();
    }

    private void X(View view) {
        this.bLI = new a();
        this.bLI.mRootView = view.findViewById(d.h.card_root_view);
        this.bLI.amH = (TextView) view.findViewById(d.h.thread_info_bar_name);
        this.bLI.bKl = (TextView) view.findViewById(d.h.thread_title);
        this.bLI.bLM = (TbImageView) view.findViewById(d.h.thread_image);
        this.bLI.bLN = (ThreadCommentAndPraiseInfoLayoutNew) view.findViewById(d.h.thread_more_info);
        this.bLI.bLO = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bLI.mRootView.setOnClickListener(this);
        this.bLI.amH.setOnClickListener(this.bKz);
        this.bLI.bLN.setOnClickListener(this);
        this.bLI.bKe = (CardGroupDividerView) view.findViewById(d.h.header_divider);
    }

    private void initUI() {
        this.bLI.bLM.setDrawBorder(true);
        this.bLI.bLM.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_zhibo_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.m mVar) {
        this.bLH = mVar;
        refreshView();
    }

    private void refreshView() {
        if (this.bLH == null || this.bLH.bes == null) {
            this.bLI.mRootView.setVisibility(8);
            return;
        }
        m.a(getContext(), this.bLH.bes, this.bLI.amH);
        String string = this.mG.getResources().getString(d.l.photo_live_tips);
        new SpannableStringBuilder(string + this.bLH.bes.getTitle()).setSpan(new ForegroundColorSpan(aj.getColor(d.e.cp_link_tip_a)), 0, string.length(), 17);
        this.bLI.bKl.setText(e(this.bLH.bes.getTitle()));
        this.anq = "feed#" + this.bLH.XU();
        this.bLI.bLN.setIsSimpleThread(false);
        this.bLI.bLN.setUserAfterClickListener(this.anJ);
        this.bLI.bLN.wK();
        if (this.bLI.bLN.setData(this.bLH.bes)) {
            this.bLI.bLO.setVisibility(8);
        } else {
            this.bLI.bLO.setVisibility(0);
        }
        if (this.bLI.bJx != null && this.bLH.Nj() != null) {
            al alVar = new al();
            alVar.cy(this.bLH.Nj().getTid());
            alVar.setFid(this.bLH.Nj().getFid());
            alVar.a(this.bLH.Xg);
            this.bLI.bJx.setData(alVar);
            this.bLI.bJx.setFirstRowSingleColumn(true);
        }
        d(this.mG, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.h.oT().oZ() && this.bLH.bes.getPhotoLiveCover() != null && this.bLH.bes.getPhotoLiveCover().length() != 0) {
            this.bLI.bLM.setVisibility(0);
            this.bLI.bLM.c(this.bLH.bes.getPhotoLiveCover(), 10, false);
        } else {
            this.bLI.bLM.setVisibility(8);
        }
        if (m.jo(this.bLH.bes.getId())) {
            aj.c(this.bLI.bKl, d.e.cp_cont_d, 1);
        } else {
            aj.c(this.bLI.bKl, d.e.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bLI.mRootView || view == this.bLI.bLN.getCommentNumView()) {
            if (Xr() != null) {
                Xr().a(this.bLI.mRootView, this.bLH);
            }
            XM();
        }
    }

    public void XL() {
        this.bLI.bJx = new com.baidu.tieba.NEGFeedBack.c(this.mG);
        this.bLI.bJx.Kr();
        this.bLI.bLN.addView(this.bLI.bJx);
        if (this.bLI.bLN.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLI.bLN.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bLI.bLN.setLayoutParams(layoutParams);
        }
    }

    private void XM() {
        if (this.bLH != null && this.bLH.bes != null) {
            m.jn(this.bLH.bes.getId());
            if (!XN()) {
                UtilHelper.showToast(this.mG.getPageActivity(), d.l.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.mG.getPageActivity(), this.bLH.bes.getTid()).cs(this.bLH.bes.rL()).cv(this.bLH.XV()).ct(m.rm()).pj()));
            jp(this.bLH.bes.getTid());
        }
    }

    public void jp(final String str) {
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
            com.baidu.tbadk.n.a.a(tbPageContext, this.bLI.mRootView);
            this.bLI.bLN.onChangeSkinType();
            aj.j(this.bLI.mRootView, d.g.addresslist_item_bg);
            this.mSkinType = i;
            if (this.bLI.bJx != null) {
                this.bLI.bJx.onChangeSkinType();
            }
            if (this.bLI.bKe != null) {
                this.bLI.bKe.onChangeSkinType();
            }
        }
    }

    private boolean XN() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.bKy != null) {
            setTag(bdUniqueId);
            if (this.bLI != null && this.bLI.bJx != null) {
                this.bLI.bJx.setUniqueId(bdUniqueId);
            }
            this.bKy.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bKy);
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.mG.getResources().getString(d.l.photo_live_tips);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.e.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(this.mG.getPageActivity(), aj.cR(d.g.pic_dot_title), 1);
        bVar.setOffset(3);
        spannableStringBuilder.setSpan(bVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public void a(c.a aVar) {
        if (this.bLI == null || this.bLI.bJx == null) {
            return;
        }
        this.bLI.bJx.setEventCallback(aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView amH;
        private com.baidu.tieba.NEGFeedBack.c bJx = null;
        public CardGroupDividerView bKe;
        public TextView bKl;
        public TbImageView bLM;
        public ThreadCommentAndPraiseInfoLayoutNew bLN;
        public View bLO;
        public View mRootView;

        public a() {
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bLI.bLN != null) {
            return this.bLI.bLN.anE;
        }
        return null;
    }

    public View XO() {
        return this.bLI.amH;
    }

    public View Xu() {
        if (this.bLI.bLN != null) {
            return this.bLI.bLN.anF;
        }
        return null;
    }
}
