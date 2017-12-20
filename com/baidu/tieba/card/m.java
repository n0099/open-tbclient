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
import com.baidu.tbadk.core.data.ah;
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
public class m extends com.baidu.tieba.card.a<com.baidu.tieba.card.data.m> {
    private String anP;
    private final View.OnClickListener anQ;
    private final View.OnClickListener aod;
    private com.baidu.tieba.card.data.m caW;
    public a caX;
    private View.OnClickListener caY;
    private View.OnClickListener caZ;
    private CustomMessageListener caf;
    private View.OnClickListener cag;
    private TbPageContext<?> mPageContext;
    private String mStType;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.caY = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.abt() != null) {
                    m.this.abt().a(view, m.this.caW);
                }
            }
        };
        this.caZ = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.abt() != null) {
                    m.this.abt().a(view, m.this.caW);
                }
            }
        };
        this.caf = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.m.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && m.this.caW != null && m.this.caW.bjE != null && m.this.caW.bjE.getTid() != null && m.this.caX != null && m.this.caX.bZU != null && ((String) customResponsedMessage.getData()).equals(m.this.caW.bjE.getTid())) {
                    k.a(m.this.caX.bZU, m.this.caW.bjE.getId(), d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
                }
            }
        };
        this.aod = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.abt() != null) {
                    m.this.abt().a(view, m.this.caW);
                }
            }
        };
        this.anQ = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.abt() != null) {
                    m.this.abt().a(view, m.this.caW);
                }
            }
        };
        this.cag = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.caW != null && !StringUtils.isNull(m.this.caW.bjE.rB())) {
                    String rB = m.this.caW.bjE.rB();
                    if (StringUtils.isNull(m.this.mStType) || StringUtils.isNull(m.this.anP)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(m.this.mContext).createNormalCfg(rB, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(m.this.mContext).createCfgForpersonalized(rB, m.this.mStType, m.this.anP)));
                    }
                    if (m.this.anQ != null) {
                        m.this.anQ.onClick(view);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mStType = k.rl();
        ab(getView());
        initUI();
    }

    private void ab(View view) {
        this.caX = new a();
        this.caX.mRootView = view.findViewById(d.g.card_root_view);
        this.caX.ani = (TextView) view.findViewById(d.g.thread_info_bar_name);
        this.caX.bZU = (TextView) view.findViewById(d.g.thread_title);
        this.caX.cbc = (TbImageView) view.findViewById(d.g.thread_image);
        this.caX.cbd = (ThreadCommentAndPraiseInfoLayoutNew) view.findViewById(d.g.thread_more_info);
        this.caX.cbe = view.findViewById(d.g.divider_below_reply_number_layout);
        this.caX.mRootView.setOnClickListener(this);
        this.caX.ani.setOnClickListener(this.cag);
        this.caX.cbd.setOnClickListener(this);
        this.caX.bZN = (CardGroupDividerView) view.findViewById(d.g.header_divider);
    }

    private void initUI() {
        this.caX.cbc.setDrawBorder(true);
        this.caX.cbc.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_zhibo_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.m mVar) {
        this.caW = mVar;
        refreshView();
    }

    private void refreshView() {
        if (this.caW == null || this.caW.bjE == null) {
            this.caX.mRootView.setVisibility(8);
            return;
        }
        k.a(getContext(), this.caW.bjE, this.caX.ani);
        String string = this.mPageContext.getResources().getString(d.j.photo_live_tips);
        new SpannableStringBuilder(string + this.caW.bjE.getTitle()).setSpan(new ForegroundColorSpan(aj.getColor(d.C0096d.cp_link_tip_a)), 0, string.length(), 17);
        this.caX.bZU.setText(e(this.caW.bjE.getTitle()));
        this.anP = "feed#" + this.caW.ace();
        this.caX.cbd.setIsSimpleThread(false);
        this.caX.cbd.setUserAfterClickListener(this.aod);
        this.caX.cbd.wK();
        if (this.caX.cbd.setData(this.caW.bjE)) {
            this.caX.cbe.setVisibility(8);
        } else {
            this.caX.cbe.setVisibility(0);
        }
        if (this.caX.bZg != null && this.caW.Ox() != null) {
            ah ahVar = new ah();
            ahVar.cD(this.caW.Ox().getTid());
            ahVar.setFid(this.caW.Ox().getFid());
            ahVar.a(this.caW.Xy);
            this.caX.bZg.setData(ahVar);
            this.caX.bZg.setFirstRowSingleColumn(true);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.h.oY().pe() && this.caW.bjE.getPhotoLiveCover() != null && this.caW.bjE.getPhotoLiveCover().length() != 0) {
            this.caX.cbc.setVisibility(0);
            this.caX.cbc.startLoad(this.caW.bjE.getPhotoLiveCover(), 10, false);
        } else {
            this.caX.cbc.setVisibility(8);
        }
        if (k.jP(this.caW.bjE.getId())) {
            aj.c(this.caX.bZU, d.C0096d.cp_cont_d, 1);
        } else {
            aj.c(this.caX.bZU, d.C0096d.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.caX.mRootView || view == this.caX.cbd.getCommentNumView()) {
            if (abt() != null) {
                abt().a(this.caX.mRootView, this.caW);
            }
            abO();
        }
    }

    public void abN() {
        this.caX.bZg = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.caX.bZg.Lc();
        this.caX.cbd.addView(this.caX.bZg);
        if (this.caX.cbd.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caX.cbd.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.caX.cbd.setLayoutParams(layoutParams);
        }
    }

    private void abO() {
        if (this.caW != null && this.caW.bjE != null) {
            k.jO(this.caW.bjE.getId());
            if (!abP()) {
                UtilHelper.showToast(this.mPageContext.getPageActivity(), d.j.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.caW.bjE.getTid()).cx(this.caW.bjE.rM()).cA(this.caW.acf()).cy(k.rl()).pn()));
            jQ(this.caW.bjE.getTid());
        }
    }

    public void jQ(final String str) {
        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.card.m.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, str));
            }
        }, 600L);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.n.a.a(tbPageContext, this.caX.mRootView);
            this.caX.cbd.onChangeSkinType();
            aj.j(this.caX.mRootView, d.f.addresslist_item_bg);
            this.mSkinType = i;
            if (this.caX.bZg != null) {
                this.caX.bZg.onChangeSkinType();
            }
            if (this.caX.bZN != null) {
                this.caX.bZN.onChangeSkinType();
            }
        }
    }

    private boolean abP() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.caf != null) {
            setTag(bdUniqueId);
            if (this.caX != null && this.caX.bZg != null) {
                this.caX.bZg.setUniqueId(bdUniqueId);
            }
            this.caf.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.caf);
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.mPageContext.getResources().getString(d.j.photo_live_tips);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0096d.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(this.mPageContext.getPageActivity(), aj.cR(d.f.pic_dot_title), 1);
        bVar.setOffset(3);
        spannableStringBuilder.setSpan(bVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public void a(c.a aVar) {
        if (this.caX == null || this.caX.bZg == null) {
            return;
        }
        this.caX.bZg.setEventCallback(aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView ani;
        public CardGroupDividerView bZN;
        public TextView bZU;
        private com.baidu.tieba.NEGFeedBack.c bZg = null;
        public TbImageView cbc;
        public ThreadCommentAndPraiseInfoLayoutNew cbd;
        public View cbe;
        public View mRootView;

        public a() {
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.caX.cbd != null) {
            return this.caX.cbd.anY;
        }
        return null;
    }

    public View abQ() {
        return this.caX.ani;
    }

    public View abw() {
        if (this.caX.cbd != null) {
            return this.caX.cbd.anZ;
        }
        return null;
    }
}
