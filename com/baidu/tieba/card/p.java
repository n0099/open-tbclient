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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.card.a<com.baidu.tieba.card.data.m> {
    private String aoG;
    private final View.OnClickListener aoH;
    private View.OnClickListener aoN;
    private final View.OnClickListener aoX;
    private CustomMessageListener bHu;
    public a bIA;
    private View.OnClickListener bIB;
    private View.OnClickListener bIC;
    private com.baidu.tieba.card.data.m bIz;
    private String mStType;
    private TbPageContext<?> oW;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bIB = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.Wx() != null) {
                    p.this.Wx().a(view, p.this.bIz);
                }
            }
        };
        this.bIC = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.Wx() != null) {
                    p.this.Wx().a(view, p.this.bIz);
                }
            }
        };
        this.bHu = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.p.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && p.this.bIz != null && p.this.bIz.bcN != null && p.this.bIz.bcN.getTid() != null && p.this.bIA != null && p.this.bIA.bGh != null && ((String) customResponsedMessage.getData()).equals(p.this.bIz.bcN.getTid())) {
                    m.a(p.this.bIA.bGh, p.this.bIz.bcN.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                }
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.Wx() != null) {
                    p.this.Wx().a(view, p.this.bIz);
                }
            }
        };
        this.aoH = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.Wx() != null) {
                    p.this.Wx().a(view, p.this.bIz);
                }
            }
        };
        this.aoN = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.bIz != null && !StringUtils.isNull(p.this.bIz.bcN.rL())) {
                    String rL = p.this.bIz.bcN.rL();
                    if (StringUtils.isNull(p.this.mStType) || StringUtils.isNull(p.this.aoG)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(p.this.mContext).createNormalCfg(rL, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(p.this.mContext).createCfgForpersonalized(rL, p.this.mStType, p.this.aoG)));
                    }
                    if (p.this.aoH != null) {
                        p.this.aoH.onClick(view);
                    }
                }
            }
        };
        this.oW = tbPageContext;
        this.mStType = m.rx();
        P(getView());
        initUI();
    }

    private void P(View view) {
        this.bIA = new a();
        this.bIA.mRootView = view.findViewById(d.h.card_root_view);
        this.bIA.aof = (TextView) view.findViewById(d.h.thread_info_bar_name);
        this.bIA.bGh = (TextView) view.findViewById(d.h.thread_title);
        this.bIA.bIF = (TbImageView) view.findViewById(d.h.thread_image);
        this.bIA.bIG = (ThreadCommentAndPraiseInfoLayoutNew) view.findViewById(d.h.thread_more_info);
        this.bIA.bIH = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bIA.mRootView.setOnClickListener(this);
        this.bIA.aof.setOnClickListener(this.aoN);
        this.bIA.bIG.setOnClickListener(this);
        this.bIA.bHh = (CardGroupDividerView) view.findViewById(d.h.header_divider);
    }

    private void initUI() {
        this.bIA.bIF.setDrawBorder(true);
        this.bIA.bIF.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_zhibo_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.m mVar) {
        this.bIz = mVar;
        refreshView();
    }

    private void refreshView() {
        if (this.bIz == null || this.bIz.bcN == null) {
            this.bIA.mRootView.setVisibility(8);
            return;
        }
        m.a(getContext(), this.bIz.bcN, this.bIA.aof);
        String string = this.oW.getResources().getString(d.l.photo_live_tips);
        new SpannableStringBuilder(string + this.bIz.bcN.getTitle()).setSpan(new ForegroundColorSpan(ai.getColor(d.e.cp_link_tip_a)), 0, string.length(), 17);
        this.bIA.bGh.setText(e(this.bIz.bcN.getTitle()));
        this.aoG = "feed#" + this.bIz.WY();
        this.bIA.bIG.setIsSimpleThread(false);
        this.bIA.bIG.setUserAfterClickListener(this.aoX);
        this.bIA.bIG.xk();
        if (this.bIA.bIG.a(this.bIz.bcN)) {
            this.bIA.bIH.setVisibility(8);
        } else {
            this.bIA.bIH.setVisibility(0);
        }
        if (this.bIA.bGz != null && this.bIz.MF() != null) {
            an anVar = new an();
            anVar.cI(this.bIz.MF().getTid());
            anVar.setFid(this.bIz.MF().getFid());
            anVar.a(this.bIz.XW);
            this.bIA.bGz.setData(anVar);
            this.bIA.bGz.setFirstRowSingleColumn(true);
        }
        d(this.oW, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.h.oY().pe() && this.bIz.bcN.getPhotoLiveCover() != null && this.bIz.bcN.getPhotoLiveCover().length() != 0) {
            this.bIA.bIF.setVisibility(0);
            this.bIA.bIF.c(this.bIz.bcN.getPhotoLiveCover(), 10, false);
        } else {
            this.bIA.bIF.setVisibility(8);
        }
        if (m.ji(this.bIz.bcN.getId())) {
            ai.c(this.bIA.bGh, d.e.cp_cont_d, 1);
        } else {
            ai.c(this.bIA.bGh, d.e.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bIA.mRootView || view == this.bIA.bIG.getCommentNumView()) {
            if (Wx() != null) {
                Wx().a(this.bIA.mRootView, this.bIz);
            }
            WP();
        }
    }

    public void WO() {
        this.bIA.bGz = new com.baidu.tbadk.core.view.h(this.oW);
        this.bIA.bGz.wL();
        this.bIA.bIG.addView(this.bIA.bGz);
        if (this.bIA.bIG.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bIA.bIG.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bIA.bIG.setLayoutParams(layoutParams);
        }
    }

    private void WP() {
        if (this.bIz != null && this.bIz.bcN != null) {
            m.jh(this.bIz.bcN.getId());
            if (!WQ()) {
                UtilHelper.showToast(this.oW.getPageActivity(), d.l.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.oW.getPageActivity(), this.bIz.bcN.getTid()).cC(this.bIz.bcN.rW()).cF(this.bIz.WZ()).cD(m.rx()).po()));
            jj(this.bIz.bcN.getTid());
        }
    }

    public void jj(final String str) {
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
            com.baidu.tbadk.o.a.a(tbPageContext, this.bIA.mRootView);
            this.bIA.bIG.onChangeSkinType();
            ai.j(this.bIA.mRootView, d.g.addresslist_item_bg);
            this.mSkinType = i;
            if (this.bIA.bGz != null) {
                this.bIA.bGz.onChangeSkinType();
            }
            if (this.bIA.bHh != null) {
                this.bIA.bHh.onChangeSkinType();
            }
        }
    }

    private boolean WQ() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bHu != null) {
            setTag(bdUniqueId);
            if (this.bIA != null && this.bIA.bGz != null) {
                this.bIA.bGz.setUniqueId(bdUniqueId);
            }
            this.bHu.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bHu);
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.oW.getResources().getString(d.l.photo_live_tips);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ai.getColor(d.e.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(this.oW.getPageActivity(), ai.cS(d.g.pic_dot_title), 1);
        bVar.setOffset(3);
        spannableStringBuilder.setSpan(bVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public void a(h.a aVar) {
        if (this.bIA == null || this.bIA.bGz == null) {
            return;
        }
        this.bIA.bGz.setEventCallback(aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView aof;
        public TextView bGh;
        private com.baidu.tbadk.core.view.h bGz = null;
        public CardGroupDividerView bHh;
        public TbImageView bIF;
        public ThreadCommentAndPraiseInfoLayoutNew bIG;
        public View bIH;
        public View mRootView;

        public a() {
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bIA.bIG != null) {
            return this.bIA.bIG.aoS;
        }
        return null;
    }

    public View WR() {
        return this.bIA.aof;
    }

    public View WA() {
        if (this.bIA.bIG != null) {
            return this.bIA.bIG.aoT;
        }
        return null;
    }
}
