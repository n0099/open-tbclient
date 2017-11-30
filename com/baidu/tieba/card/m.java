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
    private String anN;
    private final View.OnClickListener anO;
    private final View.OnClickListener aob;
    private com.baidu.tieba.card.data.m caS;
    public a caT;
    private View.OnClickListener caU;
    private View.OnClickListener caV;
    private CustomMessageListener cab;
    private View.OnClickListener cac;
    private TbPageContext<?> mPageContext;
    private String mStType;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.caU = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.abs() != null) {
                    m.this.abs().a(view, m.this.caS);
                }
            }
        };
        this.caV = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.abs() != null) {
                    m.this.abs().a(view, m.this.caS);
                }
            }
        };
        this.cab = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.m.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && m.this.caS != null && m.this.caS.bjD != null && m.this.caS.bjD.getTid() != null && m.this.caT != null && m.this.caT.bZQ != null && ((String) customResponsedMessage.getData()).equals(m.this.caS.bjD.getTid())) {
                    k.a(m.this.caT.bZQ, m.this.caS.bjD.getId(), d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
                }
            }
        };
        this.aob = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.abs() != null) {
                    m.this.abs().a(view, m.this.caS);
                }
            }
        };
        this.anO = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.abs() != null) {
                    m.this.abs().a(view, m.this.caS);
                }
            }
        };
        this.cac = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.caS != null && !StringUtils.isNull(m.this.caS.bjD.rD())) {
                    String rD = m.this.caS.bjD.rD();
                    if (StringUtils.isNull(m.this.mStType) || StringUtils.isNull(m.this.anN)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(m.this.mContext).createNormalCfg(rD, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(m.this.mContext).createCfgForpersonalized(rD, m.this.mStType, m.this.anN)));
                    }
                    if (m.this.anO != null) {
                        m.this.anO.onClick(view);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mStType = k.rn();
        aa(getView());
        initUI();
    }

    private void aa(View view) {
        this.caT = new a();
        this.caT.mRootView = view.findViewById(d.g.card_root_view);
        this.caT.anl = (TextView) view.findViewById(d.g.thread_info_bar_name);
        this.caT.bZQ = (TextView) view.findViewById(d.g.thread_title);
        this.caT.caY = (TbImageView) view.findViewById(d.g.thread_image);
        this.caT.caZ = (ThreadCommentAndPraiseInfoLayoutNew) view.findViewById(d.g.thread_more_info);
        this.caT.cba = view.findViewById(d.g.divider_below_reply_number_layout);
        this.caT.mRootView.setOnClickListener(this);
        this.caT.anl.setOnClickListener(this.cac);
        this.caT.caZ.setOnClickListener(this);
        this.caT.bZJ = (CardGroupDividerView) view.findViewById(d.g.header_divider);
    }

    private void initUI() {
        this.caT.caY.setDrawBorder(true);
        this.caT.caY.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_zhibo_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.m mVar) {
        this.caS = mVar;
        refreshView();
    }

    private void refreshView() {
        if (this.caS == null || this.caS.bjD == null) {
            this.caT.mRootView.setVisibility(8);
            return;
        }
        k.a(getContext(), this.caS.bjD, this.caT.anl);
        String string = this.mPageContext.getResources().getString(d.j.photo_live_tips);
        new SpannableStringBuilder(string + this.caS.bjD.getTitle()).setSpan(new ForegroundColorSpan(aj.getColor(d.C0082d.cp_link_tip_a)), 0, string.length(), 17);
        this.caT.bZQ.setText(e(this.caS.bjD.getTitle()));
        this.anN = "feed#" + this.caS.abV();
        this.caT.caZ.setIsSimpleThread(false);
        this.caT.caZ.setUserAfterClickListener(this.aob);
        this.caT.caZ.wL();
        if (this.caT.caZ.setData(this.caS.bjD)) {
            this.caT.cba.setVisibility(8);
        } else {
            this.caT.cba.setVisibility(0);
        }
        if (this.caT.bZc != null && this.caS.Ox() != null) {
            ah ahVar = new ah();
            ahVar.cD(this.caS.Ox().getTid());
            ahVar.setFid(this.caS.Ox().getFid());
            ahVar.a(this.caS.XE);
            this.caT.bZc.setData(ahVar);
            this.caT.bZc.setFirstRowSingleColumn(true);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.h.pa().pg() && this.caS.bjD.getPhotoLiveCover() != null && this.caS.bjD.getPhotoLiveCover().length() != 0) {
            this.caT.caY.setVisibility(0);
            this.caT.caY.startLoad(this.caS.bjD.getPhotoLiveCover(), 10, false);
        } else {
            this.caT.caY.setVisibility(8);
        }
        if (k.jR(this.caS.bjD.getId())) {
            aj.c(this.caT.bZQ, d.C0082d.cp_cont_d, 1);
        } else {
            aj.c(this.caT.bZQ, d.C0082d.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.caT.mRootView || view == this.caT.caZ.getCommentNumView()) {
            if (abs() != null) {
                abs().a(this.caT.mRootView, this.caS);
            }
            abM();
        }
    }

    public void abL() {
        this.caT.bZc = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.caT.bZc.Lc();
        this.caT.caZ.addView(this.caT.bZc);
        if (this.caT.caZ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caT.caZ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.caT.caZ.setLayoutParams(layoutParams);
        }
    }

    private void abM() {
        if (this.caS != null && this.caS.bjD != null) {
            k.jQ(this.caS.bjD.getId());
            if (!abN()) {
                UtilHelper.showToast(this.mPageContext.getPageActivity(), d.j.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.caS.bjD.getTid()).cx(this.caS.bjD.rO()).cA(this.caS.abW()).cy(k.rn()).pp()));
            jS(this.caS.bjD.getTid());
        }
    }

    public void jS(final String str) {
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
            com.baidu.tbadk.n.a.a(tbPageContext, this.caT.mRootView);
            this.caT.caZ.onChangeSkinType();
            aj.j(this.caT.mRootView, d.f.addresslist_item_bg);
            this.mSkinType = i;
            if (this.caT.bZc != null) {
                this.caT.bZc.onChangeSkinType();
            }
            if (this.caT.bZJ != null) {
                this.caT.bZJ.onChangeSkinType();
            }
        }
    }

    private boolean abN() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.cab != null) {
            setTag(bdUniqueId);
            if (this.caT != null && this.caT.bZc != null) {
                this.caT.bZc.setUniqueId(bdUniqueId);
            }
            this.cab.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cab);
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.mPageContext.getResources().getString(d.j.photo_live_tips);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0082d.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(this.mPageContext.getPageActivity(), aj.cR(d.f.pic_dot_title), 1);
        bVar.setOffset(3);
        spannableStringBuilder.setSpan(bVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public void a(c.a aVar) {
        if (this.caT == null || this.caT.bZc == null) {
            return;
        }
        this.caT.bZc.setEventCallback(aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView anl;
        public CardGroupDividerView bZJ;
        public TextView bZQ;
        private com.baidu.tieba.NEGFeedBack.c bZc = null;
        public TbImageView caY;
        public ThreadCommentAndPraiseInfoLayoutNew caZ;
        public View cba;
        public View mRootView;

        public a() {
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.caT.caZ != null) {
            return this.caT.caZ.anW;
        }
        return null;
    }

    public View abO() {
        return this.caT.anl;
    }

    public View abv() {
        if (this.caT.caZ != null) {
            return this.caT.caZ.anX;
        }
        return null;
    }
}
