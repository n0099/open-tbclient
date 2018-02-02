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
    private String bbY;
    private final View.OnClickListener bbZ;
    private final View.OnClickListener bcm;
    private CustomMessageListener cTK;
    private View.OnClickListener cTL;
    private com.baidu.tieba.card.data.m cUD;
    public a cUE;
    private View.OnClickListener cUF;
    private View.OnClickListener cUG;
    private TbPageContext<?> mPageContext;
    private String mStType;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cUF = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.akg() != null) {
                    m.this.akg().a(view, m.this.cUD);
                }
            }
        };
        this.cUG = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.akg() != null) {
                    m.this.akg().a(view, m.this.cUD);
                }
            }
        };
        this.cTK = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.m.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && m.this.cUD != null && m.this.cUD.bXi != null && m.this.cUD.bXi.getTid() != null && m.this.cUE != null && m.this.cUE.cTz != null && ((String) customResponsedMessage.getData()).equals(m.this.cUD.bXi.getTid())) {
                    k.a(m.this.cUE.cTz, m.this.cUD.bXi.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
                }
            }
        };
        this.bcm = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.akg() != null) {
                    m.this.akg().a(view, m.this.cUD);
                }
            }
        };
        this.bbZ = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.akg() != null) {
                    m.this.akg().a(view, m.this.cUD);
                }
            }
        };
        this.cTL = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.cUD != null && !StringUtils.isNull(m.this.cUD.bXi.yZ())) {
                    String yZ = m.this.cUD.bXi.yZ();
                    if (StringUtils.isNull(m.this.mStType) || StringUtils.isNull(m.this.bbY)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(m.this.mContext).createNormalCfg(yZ, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(m.this.mContext).createCfgForpersonalized(yZ, m.this.mStType, m.this.bbY)));
                    }
                    if (m.this.bbZ != null) {
                        m.this.bbZ.onClick(view);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mStType = k.yJ();
        bv(getView());
        initUI();
    }

    private void bv(View view) {
        this.cUE = new a();
        this.cUE.mRootView = view.findViewById(d.g.card_root_view);
        this.cUE.bbr = (TextView) view.findViewById(d.g.thread_info_bar_name);
        this.cUE.cTz = (TextView) view.findViewById(d.g.thread_title);
        this.cUE.cUJ = (TbImageView) view.findViewById(d.g.thread_image);
        this.cUE.cUK = (ThreadCommentAndPraiseInfoLayoutNew) view.findViewById(d.g.thread_more_info);
        this.cUE.cUL = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cUE.mRootView.setOnClickListener(this);
        this.cUE.bbr.setOnClickListener(this.cTL);
        this.cUE.cUK.setOnClickListener(this);
        this.cUE.cTs = (CardGroupDividerView) view.findViewById(d.g.header_divider);
    }

    private void initUI() {
        this.cUE.cUJ.setDrawBorder(true);
        this.cUE.cUJ.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_zhibo_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.m mVar) {
        this.cUD = mVar;
        refreshView();
    }

    private void refreshView() {
        if (this.cUD == null || this.cUD.bXi == null) {
            this.cUE.mRootView.setVisibility(8);
            return;
        }
        k.a(getContext(), this.cUD.bXi, this.cUE.bbr);
        String string = this.mPageContext.getResources().getString(d.j.photo_live_tips);
        new SpannableStringBuilder(string + this.cUD.bXi.getTitle()).setSpan(new ForegroundColorSpan(aj.getColor(d.C0108d.cp_link_tip_a)), 0, string.length(), 17);
        this.cUE.cTz.setText(s(this.cUD.bXi.getTitle()));
        this.bbY = "feed#" + this.cUD.akS();
        this.cUE.cUK.setIsSimpleThread(false);
        this.cUE.cUK.setUserAfterClickListener(this.bcm);
        this.cUE.cUK.Eb();
        if (this.cUE.cUK.setData(this.cUD.bXi)) {
            this.cUE.cUL.setVisibility(8);
        } else {
            this.cUE.cUL.setVisibility(0);
        }
        if (this.cUE.cje != null && this.cUD.VM() != null) {
            ah ahVar = new ah();
            ahVar.cK(this.cUD.VM().getTid());
            ahVar.setFid(this.cUD.VM().getFid());
            ahVar.a(this.cUD.aLY);
            this.cUE.cje.setData(ahVar);
            this.cUE.cje.setFirstRowSingleColumn(true);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.i.wB().wH() && this.cUD.bXi.getPhotoLiveCover() != null && this.cUD.bXi.getPhotoLiveCover().length() != 0) {
            this.cUE.cUJ.setVisibility(0);
            this.cUE.cUJ.startLoad(this.cUD.bXi.getPhotoLiveCover(), 10, false);
        } else {
            this.cUE.cUJ.setVisibility(8);
        }
        if (k.kl(this.cUD.bXi.getId())) {
            aj.e(this.cUE.cTz, d.C0108d.cp_cont_d, 1);
        } else {
            aj.e(this.cUE.cTz, d.C0108d.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cUE.mRootView || view == this.cUE.cUK.getCommentNumView()) {
            if (akg() != null) {
                akg().a(this.cUE.mRootView, this.cUD);
            }
            akC();
        }
    }

    public void akB() {
        this.cUE.cje = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.cUE.cje.Sr();
        this.cUE.cUK.addView(this.cUE.cje);
        if (this.cUE.cUK.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cUE.cUK.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cUE.cUK.setLayoutParams(layoutParams);
        }
    }

    private void akC() {
        if (this.cUD != null && this.cUD.bXi != null) {
            k.kk(this.cUD.bXi.getId());
            if (!akD()) {
                UtilHelper.showToast(this.mPageContext.getPageActivity(), d.j.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.cUD.bXi.getTid()).cE(this.cUD.bXi.zk()).cH(this.cUD.akT()).cF(k.yJ()).wQ()));
            km(this.cUD.bXi.getTid());
        }
    }

    public void km(final String str) {
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
            com.baidu.tbadk.n.a.a(tbPageContext, this.cUE.mRootView);
            this.cUE.cUK.onChangeSkinType();
            aj.s(this.cUE.mRootView, d.f.addresslist_item_bg);
            this.mSkinType = i;
            if (this.cUE.cje != null) {
                this.cUE.cje.onChangeSkinType();
            }
            if (this.cUE.cTs != null) {
                this.cUE.cTs.onChangeSkinType();
            }
        }
    }

    private boolean akD() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.cTK != null) {
            setTag(bdUniqueId);
            if (this.cUE != null && this.cUE.cje != null) {
                this.cUE.cje.setUniqueId(bdUniqueId);
            }
            this.cTK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cTK);
        }
    }

    private SpannableStringBuilder s(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.mPageContext.getResources().getString(d.j.photo_live_tips);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0108d.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(this.mPageContext.getPageActivity(), aj.fO(d.f.pic_dot_title), 1);
        bVar.setOffset(3);
        spannableStringBuilder.setSpan(bVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public void a(c.a aVar) {
        if (this.cUE == null || this.cUE.cje == null) {
            return;
        }
        this.cUE.cje.setEventCallback(aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView bbr;
        public CardGroupDividerView cTs;
        public TextView cTz;
        public TbImageView cUJ;
        public ThreadCommentAndPraiseInfoLayoutNew cUK;
        public View cUL;
        private com.baidu.tieba.NEGFeedBack.c cje = null;
        public View mRootView;

        public a() {
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cUE.cUK != null) {
            return this.cUE.cUK.bch;
        }
        return null;
    }

    public View akE() {
        return this.cUE.bbr;
    }

    public View akj() {
        if (this.cUE.cUK != null) {
            return this.cUE.cUK.bci;
        }
        return null;
    }
}
