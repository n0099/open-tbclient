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
    private String ane;
    private final View.OnClickListener anf;
    private final View.OnClickListener anx;
    private CustomMessageListener bKm;
    private View.OnClickListener bKn;
    private com.baidu.tieba.card.data.m bLv;
    public a bLw;
    private View.OnClickListener bLx;
    private View.OnClickListener bLy;
    private TbPageContext<?> mH;
    private String mStType;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bLx = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.Xn() != null) {
                    p.this.Xn().a(view, p.this.bLv);
                }
            }
        };
        this.bLy = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.Xn() != null) {
                    p.this.Xn().a(view, p.this.bLv);
                }
            }
        };
        this.bKm = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.p.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && p.this.bLv != null && p.this.bLv.bee != null && p.this.bLv.bee.getTid() != null && p.this.bLw != null && p.this.bLw.bJZ != null && ((String) customResponsedMessage.getData()).equals(p.this.bLv.bee.getTid())) {
                    m.a(p.this.bLw.bJZ, p.this.bLv.bee.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                }
            }
        };
        this.anx = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.Xn() != null) {
                    p.this.Xn().a(view, p.this.bLv);
                }
            }
        };
        this.anf = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.Xn() != null) {
                    p.this.Xn().a(view, p.this.bLv);
                }
            }
        };
        this.bKn = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.bLv != null && !StringUtils.isNull(p.this.bLv.bee.rt())) {
                    String rt = p.this.bLv.bee.rt();
                    if (StringUtils.isNull(p.this.mStType) || StringUtils.isNull(p.this.ane)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(p.this.mContext).createNormalCfg(rt, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(p.this.mContext).createCfgForpersonalized(rt, p.this.mStType, p.this.ane)));
                    }
                    if (p.this.anf != null) {
                        p.this.anf.onClick(view);
                    }
                }
            }
        };
        this.mH = tbPageContext;
        this.mStType = m.rf();
        X(getView());
        initUI();
    }

    private void X(View view) {
        this.bLw = new a();
        this.bLw.mRootView = view.findViewById(d.h.card_root_view);
        this.bLw.amv = (TextView) view.findViewById(d.h.thread_info_bar_name);
        this.bLw.bJZ = (TextView) view.findViewById(d.h.thread_title);
        this.bLw.bLA = (TbImageView) view.findViewById(d.h.thread_image);
        this.bLw.bLB = (ThreadCommentAndPraiseInfoLayoutNew) view.findViewById(d.h.thread_more_info);
        this.bLw.bLC = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bLw.mRootView.setOnClickListener(this);
        this.bLw.amv.setOnClickListener(this.bKn);
        this.bLw.bLB.setOnClickListener(this);
        this.bLw.bJS = (CardGroupDividerView) view.findViewById(d.h.header_divider);
    }

    private void initUI() {
        this.bLw.bLA.setDrawBorder(true);
        this.bLw.bLA.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_zhibo_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.m mVar) {
        this.bLv = mVar;
        refreshView();
    }

    private void refreshView() {
        if (this.bLv == null || this.bLv.bee == null) {
            this.bLw.mRootView.setVisibility(8);
            return;
        }
        m.a(getContext(), this.bLv.bee, this.bLw.amv);
        String string = this.mH.getResources().getString(d.l.photo_live_tips);
        new SpannableStringBuilder(string + this.bLv.bee.getTitle()).setSpan(new ForegroundColorSpan(aj.getColor(d.e.cp_link_tip_a)), 0, string.length(), 17);
        this.bLw.bJZ.setText(e(this.bLv.bee.getTitle()));
        this.ane = "feed#" + this.bLv.XQ();
        this.bLw.bLB.setIsSimpleThread(false);
        this.bLw.bLB.setUserAfterClickListener(this.anx);
        this.bLw.bLB.wD();
        if (this.bLw.bLB.setData(this.bLv.bee)) {
            this.bLw.bLC.setVisibility(8);
        } else {
            this.bLw.bLC.setVisibility(0);
        }
        if (this.bLw.bJl != null && this.bLv.Nd() != null) {
            al alVar = new al();
            alVar.cx(this.bLv.Nd().getTid());
            alVar.setFid(this.bLv.Nd().getFid());
            alVar.a(this.bLv.WU);
            this.bLw.bJl.setData(alVar);
            this.bLw.bJl.setFirstRowSingleColumn(true);
        }
        d(this.mH, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.h.oM().oS() && this.bLv.bee.getPhotoLiveCover() != null && this.bLv.bee.getPhotoLiveCover().length() != 0) {
            this.bLw.bLA.setVisibility(0);
            this.bLw.bLA.c(this.bLv.bee.getPhotoLiveCover(), 10, false);
        } else {
            this.bLw.bLA.setVisibility(8);
        }
        if (m.jm(this.bLv.bee.getId())) {
            aj.c(this.bLw.bJZ, d.e.cp_cont_d, 1);
        } else {
            aj.c(this.bLw.bJZ, d.e.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bLw.mRootView || view == this.bLw.bLB.getCommentNumView()) {
            if (Xn() != null) {
                Xn().a(this.bLw.mRootView, this.bLv);
            }
            XI();
        }
    }

    public void XH() {
        this.bLw.bJl = new com.baidu.tieba.NEGFeedBack.c(this.mH);
        this.bLw.bJl.Kl();
        this.bLw.bLB.addView(this.bLw.bJl);
        if (this.bLw.bLB.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLw.bLB.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bLw.bLB.setLayoutParams(layoutParams);
        }
    }

    private void XI() {
        if (this.bLv != null && this.bLv.bee != null) {
            m.jl(this.bLv.bee.getId());
            if (!XJ()) {
                UtilHelper.showToast(this.mH.getPageActivity(), d.l.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.mH.getPageActivity(), this.bLv.bee.getTid()).cr(this.bLv.bee.rE()).cu(this.bLv.XR()).cs(m.rf()).pc()));
            jn(this.bLv.bee.getTid());
        }
    }

    public void jn(final String str) {
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
            com.baidu.tbadk.n.a.a(tbPageContext, this.bLw.mRootView);
            this.bLw.bLB.onChangeSkinType();
            aj.j(this.bLw.mRootView, d.g.addresslist_item_bg);
            this.mSkinType = i;
            if (this.bLw.bJl != null) {
                this.bLw.bJl.onChangeSkinType();
            }
            if (this.bLw.bJS != null) {
                this.bLw.bJS.onChangeSkinType();
            }
        }
    }

    private boolean XJ() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.bKm != null) {
            setTag(bdUniqueId);
            if (this.bLw != null && this.bLw.bJl != null) {
                this.bLw.bJl.setUniqueId(bdUniqueId);
            }
            this.bKm.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bKm);
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.mH.getResources().getString(d.l.photo_live_tips);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.e.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(this.mH.getPageActivity(), aj.cQ(d.g.pic_dot_title), 1);
        bVar.setOffset(3);
        spannableStringBuilder.setSpan(bVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public void a(c.a aVar) {
        if (this.bLw == null || this.bLw.bJl == null) {
            return;
        }
        this.bLw.bJl.setEventCallback(aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView amv;
        public CardGroupDividerView bJS;
        public TextView bJZ;
        private com.baidu.tieba.NEGFeedBack.c bJl = null;
        public TbImageView bLA;
        public ThreadCommentAndPraiseInfoLayoutNew bLB;
        public View bLC;
        public View mRootView;

        public a() {
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bLw.bLB != null) {
            return this.bLw.bLB.ans;
        }
        return null;
    }

    public View XK() {
        return this.bLw.amv;
    }

    public View Xq() {
        if (this.bLw.bLB != null) {
            return this.bLw.bLB.ant;
        }
        return null;
    }
}
