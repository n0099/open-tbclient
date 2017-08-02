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
    private TbPageContext<?> ako;
    private final View.OnClickListener anD;
    private String anm;
    private final View.OnClickListener ann;
    private View.OnClickListener ant;
    private CustomMessageListener bFA;
    private com.baidu.tieba.card.data.m bGF;
    public a bGG;
    private View.OnClickListener bGH;
    private View.OnClickListener bGI;
    private String mStType;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bGH = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.VZ() != null) {
                    p.this.VZ().a(view, p.this.bGF);
                }
            }
        };
        this.bGI = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.VZ() != null) {
                    p.this.VZ().a(view, p.this.bGF);
                }
            }
        };
        this.bFA = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.p.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && p.this.bGF != null && p.this.bGF.bbB != null && p.this.bGF.bbB.getTid() != null && p.this.bGG != null && p.this.bGG.bEn != null && ((String) customResponsedMessage.getData()).equals(p.this.bGF.bbB.getTid())) {
                    m.a(p.this.bGG.bEn, p.this.bGF.bbB.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                }
            }
        };
        this.anD = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.VZ() != null) {
                    p.this.VZ().a(view, p.this.bGF);
                }
            }
        };
        this.ann = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.VZ() != null) {
                    p.this.VZ().a(view, p.this.bGF);
                }
            }
        };
        this.ant = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.bGF != null && !StringUtils.isNull(p.this.bGF.bbB.rA())) {
                    String rA = p.this.bGF.bbB.rA();
                    if (StringUtils.isNull(p.this.mStType) || StringUtils.isNull(p.this.anm)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(p.this.mContext).createNormalCfg(rA, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(p.this.mContext).createCfgForpersonalized(rA, p.this.mStType, p.this.anm)));
                    }
                    if (p.this.ann != null) {
                        p.this.ann.onClick(view);
                    }
                }
            }
        };
        this.ako = tbPageContext;
        this.mStType = m.rm();
        O(getView());
        initUI();
    }

    private void O(View view) {
        this.bGG = new a();
        this.bGG.mRootView = view.findViewById(d.h.card_root_view);
        this.bGG.amL = (TextView) view.findViewById(d.h.thread_info_bar_name);
        this.bGG.bEn = (TextView) view.findViewById(d.h.thread_title);
        this.bGG.bGL = (TbImageView) view.findViewById(d.h.thread_image);
        this.bGG.bGM = (ThreadCommentAndPraiseInfoLayoutNew) view.findViewById(d.h.thread_more_info);
        this.bGG.bGN = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bGG.mRootView.setOnClickListener(this);
        this.bGG.amL.setOnClickListener(this.ant);
        this.bGG.bGM.setOnClickListener(this);
        this.bGG.bFn = (CardGroupDividerView) view.findViewById(d.h.header_divider);
    }

    private void initUI() {
        this.bGG.bGL.setDrawBorder(true);
        this.bGG.bGL.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_zhibo_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.m mVar) {
        this.bGF = mVar;
        Ot();
    }

    private void Ot() {
        if (this.bGF == null || this.bGF.bbB == null) {
            this.bGG.mRootView.setVisibility(8);
            return;
        }
        m.a(getContext(), this.bGF.bbB, this.bGG.amL);
        String string = this.ako.getResources().getString(d.l.photo_live_tips);
        new SpannableStringBuilder(string + this.bGF.bbB.getTitle()).setSpan(new ForegroundColorSpan(ai.getColor(d.e.cp_link_tip_a)), 0, string.length(), 17);
        this.bGG.bEn.setText(e(this.bGF.bbB.getTitle()));
        this.anm = "feed#" + this.bGF.WA();
        this.bGG.bGM.setIsSimpleThread(false);
        this.bGG.bGM.setUserAfterClickListener(this.anD);
        this.bGG.bGM.xc();
        if (this.bGG.bGM.a(this.bGF.bbB)) {
            this.bGG.bGN.setVisibility(8);
        } else {
            this.bGG.bGN.setVisibility(0);
        }
        if (this.bGG.bEF != null && this.bGF.MA() != null) {
            an anVar = new an();
            anVar.cz(this.bGF.MA().getTid());
            anVar.setFid(this.bGF.MA().getFid());
            anVar.a(this.bGF.Wx);
            this.bGG.bEF.setData(anVar);
            this.bGG.bEF.setFirstRowSingleColumn(true);
        }
        d(this.ako, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.h.oN().oT() && this.bGF.bbB.getPhotoLiveCover() != null && this.bGF.bbB.getPhotoLiveCover().length() != 0) {
            this.bGG.bGL.setVisibility(0);
            this.bGG.bGL.c(this.bGF.bbB.getPhotoLiveCover(), 10, false);
        } else {
            this.bGG.bGL.setVisibility(8);
        }
        if (m.iZ(this.bGF.bbB.getId())) {
            ai.c(this.bGG.bEn, d.e.cp_cont_d, 1);
        } else {
            ai.c(this.bGG.bEn, d.e.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bGG.mRootView || view == this.bGG.bGM.getCommentNumView()) {
            if (VZ() != null) {
                VZ().a(this.bGG.mRootView, this.bGF);
            }
            Wr();
        }
    }

    public void Wq() {
        this.bGG.bEF = new com.baidu.tbadk.core.view.h(this.ako);
        this.bGG.bEF.wA();
        this.bGG.bGM.addView(this.bGG.bEF);
        if (this.bGG.bGM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bGG.bGM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bGG.bGM.setLayoutParams(layoutParams);
        }
    }

    private void Wr() {
        if (this.bGF != null && this.bGF.bbB != null) {
            m.iY(this.bGF.bbB.getId());
            if (!Ws()) {
                UtilHelper.showToast(this.ako.getPageActivity(), d.l.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.ako.getPageActivity(), this.bGF.bbB.getTid()).ct(this.bGF.bbB.rL()).cw(this.bGF.WB()).cu(m.rm()).pd()));
            ja(this.bGF.bbB.getTid());
        }
    }

    public void ja(final String str) {
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
            com.baidu.tbadk.o.a.a(tbPageContext, this.bGG.mRootView);
            this.bGG.bGM.onChangeSkinType();
            ai.j(this.bGG.mRootView, d.g.addresslist_item_bg);
            this.mSkinType = i;
            if (this.bGG.bEF != null) {
                this.bGG.bEF.onChangeSkinType();
            }
            if (this.bGG.bFn != null) {
                this.bGG.bFn.onChangeSkinType();
            }
        }
    }

    private boolean Ws() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bFA != null) {
            setTag(bdUniqueId);
            if (this.bGG != null && this.bGG.bEF != null) {
                this.bGG.bEF.setUniqueId(bdUniqueId);
            }
            this.bFA.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bFA);
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.ako.getResources().getString(d.l.photo_live_tips);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ai.getColor(d.e.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(this.ako.getPageActivity(), ai.cQ(d.g.pic_dot_title), 1);
        bVar.setOffset(3);
        spannableStringBuilder.setSpan(bVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public void a(h.a aVar) {
        if (this.bGG == null || this.bGG.bEF == null) {
            return;
        }
        this.bGG.bEF.setEventCallback(aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView amL;
        private com.baidu.tbadk.core.view.h bEF = null;
        public TextView bEn;
        public CardGroupDividerView bFn;
        public TbImageView bGL;
        public ThreadCommentAndPraiseInfoLayoutNew bGM;
        public View bGN;
        public View mRootView;

        public a() {
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bGG.bGM != null) {
            return this.bGG.bGM.any;
        }
        return null;
    }

    public View Wt() {
        return this.bGG.amL;
    }

    public View Wc() {
        if (this.bGG.bGM != null) {
            return this.bGG.bGM.anz;
        }
        return null;
    }
}
