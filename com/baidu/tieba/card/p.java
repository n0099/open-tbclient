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
    private final View.OnClickListener anA;
    private final View.OnClickListener anS;
    private String anz;
    private CustomMessageListener bRS;
    private View.OnClickListener bRT;
    private com.baidu.tieba.card.data.m bSZ;
    public a bTa;
    private View.OnClickListener bTb;
    private View.OnClickListener bTc;
    private TbPageContext<?> mPageContext;
    private String mStType;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bTb = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.Zx() != null) {
                    p.this.Zx().a(view, p.this.bSZ);
                }
            }
        };
        this.bTc = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.Zx() != null) {
                    p.this.Zx().a(view, p.this.bSZ);
                }
            }
        };
        this.bRS = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.p.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && p.this.bSZ != null && p.this.bSZ.beV != null && p.this.bSZ.beV.getTid() != null && p.this.bTa != null && p.this.bTa.bRF != null && ((String) customResponsedMessage.getData()).equals(p.this.bSZ.beV.getTid())) {
                    m.a(p.this.bTa.bRF, p.this.bSZ.beV.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
                }
            }
        };
        this.anS = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.Zx() != null) {
                    p.this.Zx().a(view, p.this.bSZ);
                }
            }
        };
        this.anA = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.Zx() != null) {
                    p.this.Zx().a(view, p.this.bSZ);
                }
            }
        };
        this.bRT = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.bSZ != null && !StringUtils.isNull(p.this.bSZ.beV.rz())) {
                    String rz = p.this.bSZ.beV.rz();
                    if (StringUtils.isNull(p.this.mStType) || StringUtils.isNull(p.this.anz)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(p.this.mContext).createNormalCfg(rz, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(p.this.mContext).createCfgForpersonalized(rz, p.this.mStType, p.this.anz)));
                    }
                    if (p.this.anA != null) {
                        p.this.anA.onClick(view);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mStType = m.rj();
        Z(getView());
        initUI();
    }

    private void Z(View view) {
        this.bTa = new a();
        this.bTa.mRootView = view.findViewById(d.g.card_root_view);
        this.bTa.amQ = (TextView) view.findViewById(d.g.thread_info_bar_name);
        this.bTa.bRF = (TextView) view.findViewById(d.g.thread_title);
        this.bTa.bTe = (TbImageView) view.findViewById(d.g.thread_image);
        this.bTa.bTf = (ThreadCommentAndPraiseInfoLayoutNew) view.findViewById(d.g.thread_more_info);
        this.bTa.bTg = view.findViewById(d.g.divider_below_reply_number_layout);
        this.bTa.mRootView.setOnClickListener(this);
        this.bTa.amQ.setOnClickListener(this.bRT);
        this.bTa.bTf.setOnClickListener(this);
        this.bTa.bRy = (CardGroupDividerView) view.findViewById(d.g.header_divider);
    }

    private void initUI() {
        this.bTa.bTe.setDrawBorder(true);
        this.bTa.bTe.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_zhibo_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.m mVar) {
        this.bSZ = mVar;
        refreshView();
    }

    private void refreshView() {
        if (this.bSZ == null || this.bSZ.beV == null) {
            this.bTa.mRootView.setVisibility(8);
            return;
        }
        m.a(getContext(), this.bSZ.beV, this.bTa.amQ);
        String string = this.mPageContext.getResources().getString(d.j.photo_live_tips);
        new SpannableStringBuilder(string + this.bSZ.beV.getTitle()).setSpan(new ForegroundColorSpan(aj.getColor(d.C0080d.cp_link_tip_a)), 0, string.length(), 17);
        this.bTa.bRF.setText(e(this.bSZ.beV.getTitle()));
        this.anz = "feed#" + this.bSZ.aaa();
        this.bTa.bTf.setIsSimpleThread(false);
        this.bTa.bTf.setUserAfterClickListener(this.anS);
        this.bTa.bTf.wK();
        if (this.bTa.bTf.setData(this.bSZ.beV)) {
            this.bTa.bTg.setVisibility(8);
        } else {
            this.bTa.bTg.setVisibility(0);
        }
        if (this.bTa.bQR != null && this.bSZ.Np() != null) {
            al alVar = new al();
            alVar.cD(this.bSZ.Np().getTid());
            alVar.setFid(this.bSZ.Np().getFid());
            alVar.a(this.bSZ.Xm);
            this.bTa.bQR.setData(alVar);
            this.bTa.bQR.setFirstRowSingleColumn(true);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.h.oT().oZ() && this.bSZ.beV.getPhotoLiveCover() != null && this.bSZ.beV.getPhotoLiveCover().length() != 0) {
            this.bTa.bTe.setVisibility(0);
            this.bTa.bTe.startLoad(this.bSZ.beV.getPhotoLiveCover(), 10, false);
        } else {
            this.bTa.bTe.setVisibility(8);
        }
        if (m.jL(this.bSZ.beV.getId())) {
            aj.c(this.bTa.bRF, d.C0080d.cp_cont_d, 1);
        } else {
            aj.c(this.bTa.bRF, d.C0080d.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bTa.mRootView || view == this.bTa.bTf.getCommentNumView()) {
            if (Zx() != null) {
                Zx().a(this.bTa.mRootView, this.bSZ);
            }
            ZS();
        }
    }

    public void ZR() {
        this.bTa.bQR = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.bTa.bQR.Ku();
        this.bTa.bTf.addView(this.bTa.bQR);
        if (this.bTa.bTf.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bTa.bTf.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bTa.bTf.setLayoutParams(layoutParams);
        }
    }

    private void ZS() {
        if (this.bSZ != null && this.bSZ.beV != null) {
            m.jK(this.bSZ.beV.getId());
            if (!ZT()) {
                UtilHelper.showToast(this.mPageContext.getPageActivity(), d.j.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.bSZ.beV.getTid()).cx(this.bSZ.beV.rK()).cA(this.bSZ.aab()).cy(m.rj()).pi()));
            jM(this.bSZ.beV.getTid());
        }
    }

    public void jM(final String str) {
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
            com.baidu.tbadk.o.a.a(tbPageContext, this.bTa.mRootView);
            this.bTa.bTf.onChangeSkinType();
            aj.j(this.bTa.mRootView, d.f.addresslist_item_bg);
            this.mSkinType = i;
            if (this.bTa.bQR != null) {
                this.bTa.bQR.onChangeSkinType();
            }
            if (this.bTa.bRy != null) {
                this.bTa.bRy.onChangeSkinType();
            }
        }
    }

    private boolean ZT() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.bRS != null) {
            setTag(bdUniqueId);
            if (this.bTa != null && this.bTa.bQR != null) {
                this.bTa.bQR.setUniqueId(bdUniqueId);
            }
            this.bRS.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bRS);
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.mPageContext.getResources().getString(d.j.photo_live_tips);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0080d.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(this.mPageContext.getPageActivity(), aj.cR(d.f.pic_dot_title), 1);
        bVar.setOffset(3);
        spannableStringBuilder.setSpan(bVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public void a(c.a aVar) {
        if (this.bTa == null || this.bTa.bQR == null) {
            return;
        }
        this.bTa.bQR.setEventCallback(aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView amQ;
        private com.baidu.tieba.NEGFeedBack.c bQR = null;
        public TextView bRF;
        public CardGroupDividerView bRy;
        public TbImageView bTe;
        public ThreadCommentAndPraiseInfoLayoutNew bTf;
        public View bTg;
        public View mRootView;

        public a() {
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bTa.bTf != null) {
            return this.bTa.bTf.anN;
        }
        return null;
    }

    public View ZU() {
        return this.bTa.amQ;
    }

    public View ZA() {
        if (this.bTa.bTf != null) {
            return this.bTa.bTf.anO;
        }
        return null;
    }
}
