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
    private String anS;
    private final View.OnClickListener anT;
    private final View.OnClickListener aog;
    private CustomMessageListener caj;
    private View.OnClickListener cak;
    private com.baidu.tieba.card.data.m cba;
    public a cbb;
    private View.OnClickListener cbc;
    private View.OnClickListener cbd;
    private TbPageContext<?> mPageContext;
    private String mStType;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cbc = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.abt() != null) {
                    m.this.abt().a(view, m.this.cba);
                }
            }
        };
        this.cbd = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.abt() != null) {
                    m.this.abt().a(view, m.this.cba);
                }
            }
        };
        this.caj = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.m.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && m.this.cba != null && m.this.cba.bjI != null && m.this.cba.bjI.getTid() != null && m.this.cbb != null && m.this.cbb.bZY != null && ((String) customResponsedMessage.getData()).equals(m.this.cba.bjI.getTid())) {
                    k.a(m.this.cbb.bZY, m.this.cba.bjI.getId(), d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
                }
            }
        };
        this.aog = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.abt() != null) {
                    m.this.abt().a(view, m.this.cba);
                }
            }
        };
        this.anT = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.abt() != null) {
                    m.this.abt().a(view, m.this.cba);
                }
            }
        };
        this.cak = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.cba != null && !StringUtils.isNull(m.this.cba.bjI.rB())) {
                    String rB = m.this.cba.bjI.rB();
                    if (StringUtils.isNull(m.this.mStType) || StringUtils.isNull(m.this.anS)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(m.this.mContext).createNormalCfg(rB, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(m.this.mContext).createCfgForpersonalized(rB, m.this.mStType, m.this.anS)));
                    }
                    if (m.this.anT != null) {
                        m.this.anT.onClick(view);
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
        this.cbb = new a();
        this.cbb.mRootView = view.findViewById(d.g.card_root_view);
        this.cbb.anl = (TextView) view.findViewById(d.g.thread_info_bar_name);
        this.cbb.bZY = (TextView) view.findViewById(d.g.thread_title);
        this.cbb.cbg = (TbImageView) view.findViewById(d.g.thread_image);
        this.cbb.cbh = (ThreadCommentAndPraiseInfoLayoutNew) view.findViewById(d.g.thread_more_info);
        this.cbb.cbi = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cbb.mRootView.setOnClickListener(this);
        this.cbb.anl.setOnClickListener(this.cak);
        this.cbb.cbh.setOnClickListener(this);
        this.cbb.bZR = (CardGroupDividerView) view.findViewById(d.g.header_divider);
    }

    private void initUI() {
        this.cbb.cbg.setDrawBorder(true);
        this.cbb.cbg.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_zhibo_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.m mVar) {
        this.cba = mVar;
        refreshView();
    }

    private void refreshView() {
        if (this.cba == null || this.cba.bjI == null) {
            this.cbb.mRootView.setVisibility(8);
            return;
        }
        k.a(getContext(), this.cba.bjI, this.cbb.anl);
        String string = this.mPageContext.getResources().getString(d.j.photo_live_tips);
        new SpannableStringBuilder(string + this.cba.bjI.getTitle()).setSpan(new ForegroundColorSpan(aj.getColor(d.C0095d.cp_link_tip_a)), 0, string.length(), 17);
        this.cbb.bZY.setText(e(this.cba.bjI.getTitle()));
        this.anS = "feed#" + this.cba.ace();
        this.cbb.cbh.setIsSimpleThread(false);
        this.cbb.cbh.setUserAfterClickListener(this.aog);
        this.cbb.cbh.wK();
        if (this.cbb.cbh.setData(this.cba.bjI)) {
            this.cbb.cbi.setVisibility(8);
        } else {
            this.cbb.cbi.setVisibility(0);
        }
        if (this.cbb.bZk != null && this.cba.Ox() != null) {
            ah ahVar = new ah();
            ahVar.cD(this.cba.Ox().getTid());
            ahVar.setFid(this.cba.Ox().getFid());
            ahVar.a(this.cba.XB);
            this.cbb.bZk.setData(ahVar);
            this.cbb.bZk.setFirstRowSingleColumn(true);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.h.oY().pe() && this.cba.bjI.getPhotoLiveCover() != null && this.cba.bjI.getPhotoLiveCover().length() != 0) {
            this.cbb.cbg.setVisibility(0);
            this.cbb.cbg.startLoad(this.cba.bjI.getPhotoLiveCover(), 10, false);
        } else {
            this.cbb.cbg.setVisibility(8);
        }
        if (k.jP(this.cba.bjI.getId())) {
            aj.c(this.cbb.bZY, d.C0095d.cp_cont_d, 1);
        } else {
            aj.c(this.cbb.bZY, d.C0095d.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cbb.mRootView || view == this.cbb.cbh.getCommentNumView()) {
            if (abt() != null) {
                abt().a(this.cbb.mRootView, this.cba);
            }
            abO();
        }
    }

    public void abN() {
        this.cbb.bZk = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.cbb.bZk.Lc();
        this.cbb.cbh.addView(this.cbb.bZk);
        if (this.cbb.cbh.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbb.cbh.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cbb.cbh.setLayoutParams(layoutParams);
        }
    }

    private void abO() {
        if (this.cba != null && this.cba.bjI != null) {
            k.jO(this.cba.bjI.getId());
            if (!abP()) {
                UtilHelper.showToast(this.mPageContext.getPageActivity(), d.j.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.cba.bjI.getTid()).cx(this.cba.bjI.rM()).cA(this.cba.acf()).cy(k.rl()).pn()));
            jQ(this.cba.bjI.getTid());
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
            com.baidu.tbadk.n.a.a(tbPageContext, this.cbb.mRootView);
            this.cbb.cbh.onChangeSkinType();
            aj.j(this.cbb.mRootView, d.f.addresslist_item_bg);
            this.mSkinType = i;
            if (this.cbb.bZk != null) {
                this.cbb.bZk.onChangeSkinType();
            }
            if (this.cbb.bZR != null) {
                this.cbb.bZR.onChangeSkinType();
            }
        }
    }

    private boolean abP() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.caj != null) {
            setTag(bdUniqueId);
            if (this.cbb != null && this.cbb.bZk != null) {
                this.cbb.bZk.setUniqueId(bdUniqueId);
            }
            this.caj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.caj);
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.mPageContext.getResources().getString(d.j.photo_live_tips);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0095d.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(this.mPageContext.getPageActivity(), aj.cR(d.f.pic_dot_title), 1);
        bVar.setOffset(3);
        spannableStringBuilder.setSpan(bVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public void a(c.a aVar) {
        if (this.cbb == null || this.cbb.bZk == null) {
            return;
        }
        this.cbb.bZk.setEventCallback(aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView anl;
        public CardGroupDividerView bZR;
        public TextView bZY;
        private com.baidu.tieba.NEGFeedBack.c bZk = null;
        public TbImageView cbg;
        public ThreadCommentAndPraiseInfoLayoutNew cbh;
        public View cbi;
        public View mRootView;

        public a() {
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cbb.cbh != null) {
            return this.cbb.cbh.aob;
        }
        return null;
    }

    public View abQ() {
        return this.cbb.anl;
    }

    public View abw() {
        if (this.cbb.cbh != null) {
            return this.cbb.cbh.aoc;
        }
        return null;
    }
}
