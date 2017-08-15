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
    private CustomMessageListener bHt;
    private View.OnClickListener bIA;
    private View.OnClickListener bIB;
    private com.baidu.tieba.card.data.m bIy;
    public a bIz;
    private String mStType;
    private TbPageContext<?> oV;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bIA = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.WA() != null) {
                    p.this.WA().a(view, p.this.bIy);
                }
            }
        };
        this.bIB = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.WA() != null) {
                    p.this.WA().a(view, p.this.bIy);
                }
            }
        };
        this.bHt = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.p.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && p.this.bIy != null && p.this.bIy.bcM != null && p.this.bIy.bcM.getTid() != null && p.this.bIz != null && p.this.bIz.bGg != null && ((String) customResponsedMessage.getData()).equals(p.this.bIy.bcM.getTid())) {
                    m.a(p.this.bIz.bGg, p.this.bIy.bcM.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                }
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.WA() != null) {
                    p.this.WA().a(view, p.this.bIy);
                }
            }
        };
        this.aoH = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.WA() != null) {
                    p.this.WA().a(view, p.this.bIy);
                }
            }
        };
        this.aoN = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.bIy != null && !StringUtils.isNull(p.this.bIy.bcM.rK())) {
                    String rK = p.this.bIy.bcM.rK();
                    if (StringUtils.isNull(p.this.mStType) || StringUtils.isNull(p.this.aoG)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(p.this.mContext).createNormalCfg(rK, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(p.this.mContext).createCfgForpersonalized(rK, p.this.mStType, p.this.aoG)));
                    }
                    if (p.this.aoH != null) {
                        p.this.aoH.onClick(view);
                    }
                }
            }
        };
        this.oV = tbPageContext;
        this.mStType = m.rw();
        P(getView());
        initUI();
    }

    private void P(View view) {
        this.bIz = new a();
        this.bIz.mRootView = view.findViewById(d.h.card_root_view);
        this.bIz.aof = (TextView) view.findViewById(d.h.thread_info_bar_name);
        this.bIz.bGg = (TextView) view.findViewById(d.h.thread_title);
        this.bIz.bIE = (TbImageView) view.findViewById(d.h.thread_image);
        this.bIz.bIF = (ThreadCommentAndPraiseInfoLayoutNew) view.findViewById(d.h.thread_more_info);
        this.bIz.bIG = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bIz.mRootView.setOnClickListener(this);
        this.bIz.aof.setOnClickListener(this.aoN);
        this.bIz.bIF.setOnClickListener(this);
        this.bIz.bHg = (CardGroupDividerView) view.findViewById(d.h.header_divider);
    }

    private void initUI() {
        this.bIz.bIE.setDrawBorder(true);
        this.bIz.bIE.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_zhibo_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.m mVar) {
        this.bIy = mVar;
        Oy();
    }

    private void Oy() {
        if (this.bIy == null || this.bIy.bcM == null) {
            this.bIz.mRootView.setVisibility(8);
            return;
        }
        m.a(getContext(), this.bIy.bcM, this.bIz.aof);
        String string = this.oV.getResources().getString(d.l.photo_live_tips);
        new SpannableStringBuilder(string + this.bIy.bcM.getTitle()).setSpan(new ForegroundColorSpan(ai.getColor(d.e.cp_link_tip_a)), 0, string.length(), 17);
        this.bIz.bGg.setText(e(this.bIy.bcM.getTitle()));
        this.aoG = "feed#" + this.bIy.Xb();
        this.bIz.bIF.setIsSimpleThread(false);
        this.bIz.bIF.setUserAfterClickListener(this.aoX);
        this.bIz.bIF.xk();
        if (this.bIz.bIF.a(this.bIy.bcM)) {
            this.bIz.bIG.setVisibility(8);
        } else {
            this.bIz.bIG.setVisibility(0);
        }
        if (this.bIz.bGy != null && this.bIy.MF() != null) {
            an anVar = new an();
            anVar.cF(this.bIy.MF().getTid());
            anVar.setFid(this.bIy.MF().getFid());
            anVar.a(this.bIy.XV);
            this.bIz.bGy.setData(anVar);
            this.bIz.bGy.setFirstRowSingleColumn(true);
        }
        d(this.oV, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.h.oX().pd() && this.bIy.bcM.getPhotoLiveCover() != null && this.bIy.bcM.getPhotoLiveCover().length() != 0) {
            this.bIz.bIE.setVisibility(0);
            this.bIz.bIE.c(this.bIy.bcM.getPhotoLiveCover(), 10, false);
        } else {
            this.bIz.bIE.setVisibility(8);
        }
        if (m.jf(this.bIy.bcM.getId())) {
            ai.c(this.bIz.bGg, d.e.cp_cont_d, 1);
        } else {
            ai.c(this.bIz.bGg, d.e.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bIz.mRootView || view == this.bIz.bIF.getCommentNumView()) {
            if (WA() != null) {
                WA().a(this.bIz.mRootView, this.bIy);
            }
            WS();
        }
    }

    public void WR() {
        this.bIz.bGy = new com.baidu.tbadk.core.view.h(this.oV);
        this.bIz.bGy.wK();
        this.bIz.bIF.addView(this.bIz.bGy);
        if (this.bIz.bIF.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bIz.bIF.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bIz.bIF.setLayoutParams(layoutParams);
        }
    }

    private void WS() {
        if (this.bIy != null && this.bIy.bcM != null) {
            m.je(this.bIy.bcM.getId());
            if (!WT()) {
                UtilHelper.showToast(this.oV.getPageActivity(), d.l.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.oV.getPageActivity(), this.bIy.bcM.getTid()).cz(this.bIy.bcM.rV()).cC(this.bIy.Xc()).cA(m.rw()).pn()));
            jg(this.bIy.bcM.getTid());
        }
    }

    public void jg(final String str) {
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
            com.baidu.tbadk.o.a.a(tbPageContext, this.bIz.mRootView);
            this.bIz.bIF.onChangeSkinType();
            ai.j(this.bIz.mRootView, d.g.addresslist_item_bg);
            this.mSkinType = i;
            if (this.bIz.bGy != null) {
                this.bIz.bGy.onChangeSkinType();
            }
            if (this.bIz.bHg != null) {
                this.bIz.bHg.onChangeSkinType();
            }
        }
    }

    private boolean WT() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bHt != null) {
            setTag(bdUniqueId);
            if (this.bIz != null && this.bIz.bGy != null) {
                this.bIz.bGy.setUniqueId(bdUniqueId);
            }
            this.bHt.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bHt);
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.oV.getResources().getString(d.l.photo_live_tips);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ai.getColor(d.e.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(this.oV.getPageActivity(), ai.cS(d.g.pic_dot_title), 1);
        bVar.setOffset(3);
        spannableStringBuilder.setSpan(bVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public void a(h.a aVar) {
        if (this.bIz == null || this.bIz.bGy == null) {
            return;
        }
        this.bIz.bGy.setEventCallback(aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView aof;
        public TextView bGg;
        private com.baidu.tbadk.core.view.h bGy = null;
        public CardGroupDividerView bHg;
        public TbImageView bIE;
        public ThreadCommentAndPraiseInfoLayoutNew bIF;
        public View bIG;
        public View mRootView;

        public a() {
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bIz.bIF != null) {
            return this.bIz.bIF.aoS;
        }
        return null;
    }

    public View WU() {
        return this.bIz.aof;
    }

    public View WD() {
        if (this.bIz.bIF != null) {
            return this.bIz.bIF.aoT;
        }
        return null;
    }
}
