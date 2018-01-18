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
    private String bbQ;
    private final View.OnClickListener bbR;
    private final View.OnClickListener bce;
    private CustomMessageListener cTp;
    private View.OnClickListener cTq;
    private com.baidu.tieba.card.data.m cUi;
    public a cUj;
    private View.OnClickListener cUk;
    private View.OnClickListener cUl;
    private TbPageContext<?> mPageContext;
    private String mStType;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cUk = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.akb() != null) {
                    m.this.akb().a(view, m.this.cUi);
                }
            }
        };
        this.cUl = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.akb() != null) {
                    m.this.akb().a(view, m.this.cUi);
                }
            }
        };
        this.cTp = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.m.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && m.this.cUi != null && m.this.cUi.bXa != null && m.this.cUi.bXa.getTid() != null && m.this.cUj != null && m.this.cUj.cTe != null && ((String) customResponsedMessage.getData()).equals(m.this.cUi.bXa.getTid())) {
                    k.a(m.this.cUj.cTe, m.this.cUi.bXa.getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
                }
            }
        };
        this.bce = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.akb() != null) {
                    m.this.akb().a(view, m.this.cUi);
                }
            }
        };
        this.bbR = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.akb() != null) {
                    m.this.akb().a(view, m.this.cUi);
                }
            }
        };
        this.cTq = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.cUi != null && !StringUtils.isNull(m.this.cUi.bXa.yY())) {
                    String yY = m.this.cUi.bXa.yY();
                    if (StringUtils.isNull(m.this.mStType) || StringUtils.isNull(m.this.bbQ)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(m.this.mContext).createNormalCfg(yY, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(m.this.mContext).createCfgForpersonalized(yY, m.this.mStType, m.this.bbQ)));
                    }
                    if (m.this.bbR != null) {
                        m.this.bbR.onClick(view);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mStType = k.yI();
        bv(getView());
        initUI();
    }

    private void bv(View view) {
        this.cUj = new a();
        this.cUj.mRootView = view.findViewById(d.g.card_root_view);
        this.cUj.bbj = (TextView) view.findViewById(d.g.thread_info_bar_name);
        this.cUj.cTe = (TextView) view.findViewById(d.g.thread_title);
        this.cUj.cUo = (TbImageView) view.findViewById(d.g.thread_image);
        this.cUj.cUp = (ThreadCommentAndPraiseInfoLayoutNew) view.findViewById(d.g.thread_more_info);
        this.cUj.cUq = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cUj.mRootView.setOnClickListener(this);
        this.cUj.bbj.setOnClickListener(this.cTq);
        this.cUj.cUp.setOnClickListener(this);
        this.cUj.cSX = (CardGroupDividerView) view.findViewById(d.g.header_divider);
    }

    private void initUI() {
        this.cUj.cUo.setDrawBorder(true);
        this.cUj.cUo.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_zhibo_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.m mVar) {
        this.cUi = mVar;
        refreshView();
    }

    private void refreshView() {
        if (this.cUi == null || this.cUi.bXa == null) {
            this.cUj.mRootView.setVisibility(8);
            return;
        }
        k.a(getContext(), this.cUi.bXa, this.cUj.bbj);
        String string = this.mPageContext.getResources().getString(d.j.photo_live_tips);
        new SpannableStringBuilder(string + this.cUi.bXa.getTitle()).setSpan(new ForegroundColorSpan(aj.getColor(d.C0107d.cp_link_tip_a)), 0, string.length(), 17);
        this.cUj.cTe.setText(s(this.cUi.bXa.getTitle()));
        this.bbQ = "feed#" + this.cUi.akN();
        this.cUj.cUp.setIsSimpleThread(false);
        this.cUj.cUp.setUserAfterClickListener(this.bce);
        this.cUj.cUp.DZ();
        if (this.cUj.cUp.setData(this.cUi.bXa)) {
            this.cUj.cUq.setVisibility(8);
        } else {
            this.cUj.cUq.setVisibility(0);
        }
        if (this.cUj.ciW != null && this.cUi.VK() != null) {
            ah ahVar = new ah();
            ahVar.cK(this.cUi.VK().getTid());
            ahVar.setFid(this.cUi.VK().getFid());
            ahVar.a(this.cUi.aLV);
            this.cUj.ciW.setData(ahVar);
            this.cUj.ciW.setFirstRowSingleColumn(true);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.i.wA().wG() && this.cUi.bXa.getPhotoLiveCover() != null && this.cUi.bXa.getPhotoLiveCover().length() != 0) {
            this.cUj.cUo.setVisibility(0);
            this.cUj.cUo.startLoad(this.cUi.bXa.getPhotoLiveCover(), 10, false);
        } else {
            this.cUj.cUo.setVisibility(8);
        }
        if (k.kd(this.cUi.bXa.getId())) {
            aj.e(this.cUj.cTe, d.C0107d.cp_cont_d, 1);
        } else {
            aj.e(this.cUj.cTe, d.C0107d.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cUj.mRootView || view == this.cUj.cUp.getCommentNumView()) {
            if (akb() != null) {
                akb().a(this.cUj.mRootView, this.cUi);
            }
            akx();
        }
    }

    public void akw() {
        this.cUj.ciW = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.cUj.ciW.Sp();
        this.cUj.cUp.addView(this.cUj.ciW);
        if (this.cUj.cUp.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cUj.cUp.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cUj.cUp.setLayoutParams(layoutParams);
        }
    }

    private void akx() {
        if (this.cUi != null && this.cUi.bXa != null) {
            k.kc(this.cUi.bXa.getId());
            if (!aky()) {
                UtilHelper.showToast(this.mPageContext.getPageActivity(), d.j.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.cUi.bXa.getTid()).cE(this.cUi.bXa.zj()).cH(this.cUi.akO()).cF(k.yI()).wP()));
            ke(this.cUi.bXa.getTid());
        }
    }

    public void ke(final String str) {
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
            com.baidu.tbadk.n.a.a(tbPageContext, this.cUj.mRootView);
            this.cUj.cUp.onChangeSkinType();
            aj.s(this.cUj.mRootView, d.f.addresslist_item_bg);
            this.mSkinType = i;
            if (this.cUj.ciW != null) {
                this.cUj.ciW.onChangeSkinType();
            }
            if (this.cUj.cSX != null) {
                this.cUj.cSX.onChangeSkinType();
            }
        }
    }

    private boolean aky() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.cTp != null) {
            setTag(bdUniqueId);
            if (this.cUj != null && this.cUj.ciW != null) {
                this.cUj.ciW.setUniqueId(bdUniqueId);
            }
            this.cTp.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cTp);
        }
    }

    private SpannableStringBuilder s(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.mPageContext.getResources().getString(d.j.photo_live_tips);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0107d.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(this.mPageContext.getPageActivity(), aj.fO(d.f.pic_dot_title), 1);
        bVar.setOffset(3);
        spannableStringBuilder.setSpan(bVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public void a(c.a aVar) {
        if (this.cUj == null || this.cUj.ciW == null) {
            return;
        }
        this.cUj.ciW.setEventCallback(aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView bbj;
        public CardGroupDividerView cSX;
        public TextView cTe;
        public TbImageView cUo;
        public ThreadCommentAndPraiseInfoLayoutNew cUp;
        public View cUq;
        private com.baidu.tieba.NEGFeedBack.c ciW = null;
        public View mRootView;

        public a() {
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cUj.cUp != null) {
            return this.cUj.cUp.bbZ;
        }
        return null;
    }

    public View akz() {
        return this.cUj.bbj;
    }

    public View ake() {
        if (this.cUj.cUp != null) {
            return this.cUj.cUp.bca;
        }
        return null;
    }
}
