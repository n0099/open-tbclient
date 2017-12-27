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
import com.baidu.tbadk.core.data.ai;
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
    private String bbQ;
    private final View.OnClickListener bbR;
    private final View.OnClickListener bce;
    private CustomMessageListener cOO;
    private View.OnClickListener cOP;
    private com.baidu.tieba.card.data.m cPG;
    public a cPH;
    private View.OnClickListener cPI;
    private View.OnClickListener cPJ;
    private TbPageContext<?> mPageContext;
    private String mStType;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cPI = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.aiY() != null) {
                    m.this.aiY().a(view, m.this.cPG);
                }
            }
        };
        this.cPJ = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.aiY() != null) {
                    m.this.aiY().a(view, m.this.cPG);
                }
            }
        };
        this.cOO = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.m.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && m.this.cPG != null && m.this.cPG.bWT != null && m.this.cPG.bWT.getTid() != null && m.this.cPH != null && m.this.cPH.cOD != null && ((String) customResponsedMessage.getData()).equals(m.this.cPG.bWT.getTid())) {
                    k.a(m.this.cPH.cOD, m.this.cPG.bWT.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
                }
            }
        };
        this.bce = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.aiY() != null) {
                    m.this.aiY().a(view, m.this.cPG);
                }
            }
        };
        this.bbR = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.aiY() != null) {
                    m.this.aiY().a(view, m.this.cPG);
                }
            }
        };
        this.cOP = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.cPG != null && !StringUtils.isNull(m.this.cPG.bWT.zd())) {
                    String zd = m.this.cPG.bWT.zd();
                    if (StringUtils.isNull(m.this.mStType) || StringUtils.isNull(m.this.bbQ)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(m.this.mContext).createNormalCfg(zd, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(m.this.mContext).createCfgForpersonalized(zd, m.this.mStType, m.this.bbQ)));
                    }
                    if (m.this.bbR != null) {
                        m.this.bbR.onClick(view);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mStType = k.yN();
        bt(getView());
        initUI();
    }

    private void bt(View view) {
        this.cPH = new a();
        this.cPH.mRootView = view.findViewById(d.g.card_root_view);
        this.cPH.bbj = (TextView) view.findViewById(d.g.thread_info_bar_name);
        this.cPH.cOD = (TextView) view.findViewById(d.g.thread_title);
        this.cPH.cPM = (TbImageView) view.findViewById(d.g.thread_image);
        this.cPH.cPN = (ThreadCommentAndPraiseInfoLayoutNew) view.findViewById(d.g.thread_more_info);
        this.cPH.cPO = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cPH.mRootView.setOnClickListener(this);
        this.cPH.bbj.setOnClickListener(this.cOP);
        this.cPH.cPN.setOnClickListener(this);
        this.cPH.cOw = (CardGroupDividerView) view.findViewById(d.g.header_divider);
    }

    private void initUI() {
        this.cPH.cPM.setDrawBorder(true);
        this.cPH.cPM.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_zhibo_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.m mVar) {
        this.cPG = mVar;
        refreshView();
    }

    private void refreshView() {
        if (this.cPG == null || this.cPG.bWT == null) {
            this.cPH.mRootView.setVisibility(8);
            return;
        }
        k.a(getContext(), this.cPG.bWT, this.cPH.bbj);
        String string = this.mPageContext.getResources().getString(d.j.photo_live_tips);
        new SpannableStringBuilder(string + this.cPG.bWT.getTitle()).setSpan(new ForegroundColorSpan(aj.getColor(d.C0108d.cp_link_tip_a)), 0, string.length(), 17);
        this.cPH.cOD.setText(s(this.cPG.bWT.getTitle()));
        this.bbQ = "feed#" + this.cPG.ajK();
        this.cPH.cPN.setIsSimpleThread(false);
        this.cPH.cPN.setUserAfterClickListener(this.bce);
        this.cPH.cPN.Ei();
        if (this.cPH.cPN.setData(this.cPG.bWT)) {
            this.cPH.cPO.setVisibility(8);
        } else {
            this.cPH.cPO.setVisibility(0);
        }
        if (this.cPH.ciP != null && this.cPG.VW() != null) {
            ai aiVar = new ai();
            aiVar.cK(this.cPG.VW().getTid());
            aiVar.setFid(this.cPG.VW().getFid());
            aiVar.a(this.cPG.aLZ);
            this.cPH.ciP.setData(aiVar);
            this.cPH.ciP.setFirstRowSingleColumn(true);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.i.wB().wH() && this.cPG.bWT.getPhotoLiveCover() != null && this.cPG.bWT.getPhotoLiveCover().length() != 0) {
            this.cPH.cPM.setVisibility(0);
            this.cPH.cPM.startLoad(this.cPG.bWT.getPhotoLiveCover(), 10, false);
        } else {
            this.cPH.cPM.setVisibility(8);
        }
        if (k.jU(this.cPG.bWT.getId())) {
            aj.e(this.cPH.cOD, d.C0108d.cp_cont_d, 1);
        } else {
            aj.e(this.cPH.cOD, d.C0108d.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cPH.mRootView || view == this.cPH.cPN.getCommentNumView()) {
            if (aiY() != null) {
                aiY().a(this.cPH.mRootView, this.cPG);
            }
            aju();
        }
    }

    public void ajt() {
        this.cPH.ciP = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.cPH.ciP.SB();
        this.cPH.cPN.addView(this.cPH.ciP);
        if (this.cPH.cPN.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cPH.cPN.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cPH.cPN.setLayoutParams(layoutParams);
        }
    }

    private void aju() {
        if (this.cPG != null && this.cPG.bWT != null) {
            k.jT(this.cPG.bWT.getId());
            if (!ajv()) {
                UtilHelper.showToast(this.mPageContext.getPageActivity(), d.j.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.cPG.bWT.getTid()).cE(this.cPG.bWT.zo()).cH(this.cPG.ajL()).cF(k.yN()).wQ()));
            jV(this.cPG.bWT.getTid());
        }
    }

    public void jV(final String str) {
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
            com.baidu.tbadk.n.a.a(tbPageContext, this.cPH.mRootView);
            this.cPH.cPN.onChangeSkinType();
            aj.s(this.cPH.mRootView, d.f.addresslist_item_bg);
            this.mSkinType = i;
            if (this.cPH.ciP != null) {
                this.cPH.ciP.onChangeSkinType();
            }
            if (this.cPH.cOw != null) {
                this.cPH.cOw.onChangeSkinType();
            }
        }
    }

    private boolean ajv() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.cOO != null) {
            setTag(bdUniqueId);
            if (this.cPH != null && this.cPH.ciP != null) {
                this.cPH.ciP.setUniqueId(bdUniqueId);
            }
            this.cOO.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cOO);
        }
    }

    private SpannableStringBuilder s(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.mPageContext.getResources().getString(d.j.photo_live_tips);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0108d.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(this.mPageContext.getPageActivity(), aj.fQ(d.f.pic_dot_title), 1);
        bVar.setOffset(3);
        spannableStringBuilder.setSpan(bVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public void a(c.a aVar) {
        if (this.cPH == null || this.cPH.ciP == null) {
            return;
        }
        this.cPH.ciP.setEventCallback(aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView bbj;
        public TextView cOD;
        public CardGroupDividerView cOw;
        public TbImageView cPM;
        public ThreadCommentAndPraiseInfoLayoutNew cPN;
        public View cPO;
        private com.baidu.tieba.NEGFeedBack.c ciP = null;
        public View mRootView;

        public a() {
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cPH.cPN != null) {
            return this.cPH.cPN.bbZ;
        }
        return null;
    }

    public View ajw() {
        return this.cPH.bbj;
    }

    public View ajb() {
        if (this.cPH.cPN != null) {
            return this.cPH.cPN.bca;
        }
        return null;
    }
}
