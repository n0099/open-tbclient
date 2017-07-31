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
    private TbPageContext<?> alI;
    private String aoF;
    private final View.OnClickListener aoG;
    private View.OnClickListener aoM;
    private final View.OnClickListener aoW;
    private CustomMessageListener bGK;
    private com.baidu.tieba.card.data.m bHP;
    public a bHQ;
    private View.OnClickListener bHR;
    private View.OnClickListener bHS;
    private String mStType;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bHR = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.We() != null) {
                    p.this.We().a(view, p.this.bHP);
                }
            }
        };
        this.bHS = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.We() != null) {
                    p.this.We().a(view, p.this.bHP);
                }
            }
        };
        this.bGK = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.p.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && p.this.bHP != null && p.this.bHP.bcL != null && p.this.bHP.bcL.getTid() != null && p.this.bHQ != null && p.this.bHQ.bFx != null && ((String) customResponsedMessage.getData()).equals(p.this.bHP.bcL.getTid())) {
                    m.a(p.this.bHQ.bFx, p.this.bHP.bcL.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                }
            }
        };
        this.aoW = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.We() != null) {
                    p.this.We().a(view, p.this.bHP);
                }
            }
        };
        this.aoG = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.We() != null) {
                    p.this.We().a(view, p.this.bHP);
                }
            }
        };
        this.aoM = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.bHP != null && !StringUtils.isNull(p.this.bHP.bcL.rK())) {
                    String rK = p.this.bHP.bcL.rK();
                    if (StringUtils.isNull(p.this.mStType) || StringUtils.isNull(p.this.aoF)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(p.this.mContext).createNormalCfg(rK, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(p.this.mContext).createCfgForpersonalized(rK, p.this.mStType, p.this.aoF)));
                    }
                    if (p.this.aoG != null) {
                        p.this.aoG.onClick(view);
                    }
                }
            }
        };
        this.alI = tbPageContext;
        this.mStType = m.rw();
        O(getView());
        initUI();
    }

    private void O(View view) {
        this.bHQ = new a();
        this.bHQ.mRootView = view.findViewById(d.h.card_root_view);
        this.bHQ.aoe = (TextView) view.findViewById(d.h.thread_info_bar_name);
        this.bHQ.bFx = (TextView) view.findViewById(d.h.thread_title);
        this.bHQ.bHV = (TbImageView) view.findViewById(d.h.thread_image);
        this.bHQ.bHW = (ThreadCommentAndPraiseInfoLayoutNew) view.findViewById(d.h.thread_more_info);
        this.bHQ.bHX = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bHQ.mRootView.setOnClickListener(this);
        this.bHQ.aoe.setOnClickListener(this.aoM);
        this.bHQ.bHW.setOnClickListener(this);
        this.bHQ.bGx = (CardGroupDividerView) view.findViewById(d.h.header_divider);
    }

    private void initUI() {
        this.bHQ.bHV.setDrawBorder(true);
        this.bHQ.bHV.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_zhibo_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.m mVar) {
        this.bHP = mVar;
        Oy();
    }

    private void Oy() {
        if (this.bHP == null || this.bHP.bcL == null) {
            this.bHQ.mRootView.setVisibility(8);
            return;
        }
        m.a(getContext(), this.bHP.bcL, this.bHQ.aoe);
        String string = this.alI.getResources().getString(d.l.photo_live_tips);
        new SpannableStringBuilder(string + this.bHP.bcL.getTitle()).setSpan(new ForegroundColorSpan(ai.getColor(d.e.cp_link_tip_a)), 0, string.length(), 17);
        this.bHQ.bFx.setText(e(this.bHP.bcL.getTitle()));
        this.aoF = "feed#" + this.bHP.WF();
        this.bHQ.bHW.setIsSimpleThread(false);
        this.bHQ.bHW.setUserAfterClickListener(this.aoW);
        this.bHQ.bHW.xk();
        if (this.bHQ.bHW.a(this.bHP.bcL)) {
            this.bHQ.bHX.setVisibility(8);
        } else {
            this.bHQ.bHX.setVisibility(0);
        }
        if (this.bHQ.bFP != null && this.bHP.MF() != null) {
            an anVar = new an();
            anVar.cF(this.bHP.MF().getTid());
            anVar.setFid(this.bHP.MF().getFid());
            anVar.a(this.bHP.XT);
            this.bHQ.bFP.setData(anVar);
            this.bHQ.bFP.setFirstRowSingleColumn(true);
        }
        d(this.alI, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.h.oX().pd() && this.bHP.bcL.getPhotoLiveCover() != null && this.bHP.bcL.getPhotoLiveCover().length() != 0) {
            this.bHQ.bHV.setVisibility(0);
            this.bHQ.bHV.c(this.bHP.bcL.getPhotoLiveCover(), 10, false);
        } else {
            this.bHQ.bHV.setVisibility(8);
        }
        if (m.je(this.bHP.bcL.getId())) {
            ai.c(this.bHQ.bFx, d.e.cp_cont_d, 1);
        } else {
            ai.c(this.bHQ.bFx, d.e.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bHQ.mRootView || view == this.bHQ.bHW.getCommentNumView()) {
            if (We() != null) {
                We().a(this.bHQ.mRootView, this.bHP);
            }
            Ww();
        }
    }

    public void Wv() {
        this.bHQ.bFP = new com.baidu.tbadk.core.view.h(this.alI);
        this.bHQ.bFP.wK();
        this.bHQ.bHW.addView(this.bHQ.bFP);
        if (this.bHQ.bHW.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHQ.bHW.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bHQ.bHW.setLayoutParams(layoutParams);
        }
    }

    private void Ww() {
        if (this.bHP != null && this.bHP.bcL != null) {
            m.jd(this.bHP.bcL.getId());
            if (!Wx()) {
                UtilHelper.showToast(this.alI.getPageActivity(), d.l.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.alI.getPageActivity(), this.bHP.bcL.getTid()).cz(this.bHP.bcL.rV()).cC(this.bHP.WG()).cA(m.rw()).pn()));
            jf(this.bHP.bcL.getTid());
        }
    }

    public void jf(final String str) {
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
            com.baidu.tbadk.o.a.a(tbPageContext, this.bHQ.mRootView);
            this.bHQ.bHW.onChangeSkinType();
            ai.j(this.bHQ.mRootView, d.g.addresslist_item_bg);
            this.mSkinType = i;
            if (this.bHQ.bFP != null) {
                this.bHQ.bFP.onChangeSkinType();
            }
            if (this.bHQ.bGx != null) {
                this.bHQ.bGx.onChangeSkinType();
            }
        }
    }

    private boolean Wx() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bGK != null) {
            setTag(bdUniqueId);
            if (this.bHQ != null && this.bHQ.bFP != null) {
                this.bHQ.bFP.setUniqueId(bdUniqueId);
            }
            this.bGK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bGK);
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.alI.getResources().getString(d.l.photo_live_tips);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ai.getColor(d.e.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(this.alI.getPageActivity(), ai.cS(d.g.pic_dot_title), 1);
        bVar.setOffset(3);
        spannableStringBuilder.setSpan(bVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public void a(h.a aVar) {
        if (this.bHQ == null || this.bHQ.bFP == null) {
            return;
        }
        this.bHQ.bFP.setEventCallback(aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView aoe;
        private com.baidu.tbadk.core.view.h bFP = null;
        public TextView bFx;
        public CardGroupDividerView bGx;
        public TbImageView bHV;
        public ThreadCommentAndPraiseInfoLayoutNew bHW;
        public View bHX;
        public View mRootView;

        public a() {
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bHQ.bHW != null) {
            return this.bHQ.bHW.aoR;
        }
        return null;
    }

    public View Wy() {
        return this.bHQ.aoe;
    }

    public View Wh() {
        if (this.bHQ.bHW != null) {
            return this.bHQ.bHW.aoS;
        }
        return null;
    }
}
