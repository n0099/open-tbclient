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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.card.a<com.baidu.tieba.card.data.l> {
    private String bdD;
    private final View.OnClickListener bdE;
    private final View.OnClickListener bdQ;
    private CustomMessageListener cWh;
    private View.OnClickListener cWi;
    private com.baidu.tieba.card.data.l cXa;
    public a cXb;
    private View.OnClickListener cXc;
    private View.OnClickListener cXd;
    private TbPageContext<?> mPageContext;
    private String mStType;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cXc = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.akO() != null) {
                    l.this.akO().a(view, l.this.cXa);
                }
            }
        };
        this.cXd = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.akO() != null) {
                    l.this.akO().a(view, l.this.cXa);
                }
            }
        };
        this.cWh = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.l.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && l.this.cXa != null && l.this.cXa.bZf != null && l.this.cXa.bZf.getTid() != null && l.this.cXb != null && l.this.cXb.cXg != null && ((String) customResponsedMessage.getData()).equals(l.this.cXa.bZf.getTid())) {
                    j.a(l.this.cXb.cXg, l.this.cXa.bZf.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
                }
            }
        };
        this.bdQ = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.akO() != null) {
                    l.this.akO().a(view, l.this.cXa);
                }
            }
        };
        this.bdE = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.akO() != null) {
                    l.this.akO().a(view, l.this.cXa);
                }
            }
        };
        this.cWi = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.cXa != null && !StringUtils.isNull(l.this.cXa.bZf.zt())) {
                    String zt = l.this.cXa.bZf.zt();
                    if (StringUtils.isNull(l.this.mStType) || StringUtils.isNull(l.this.bdD)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(l.this.mContext).createNormalCfg(zt, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(l.this.mContext).createCfgForpersonalized(zt, l.this.mStType, l.this.bdD)));
                    }
                    if (l.this.bdE != null) {
                        l.this.bdE.onClick(view);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mStType = j.zd();
        bu(getView());
        initUI();
    }

    private void bu(View view) {
        this.cXb = new a();
        this.cXb.mRootView = view.findViewById(d.g.card_root_view);
        this.cXb.bcX = (TextView) view.findViewById(d.g.thread_info_bar_name);
        this.cXb.cXg = (TextView) view.findViewById(d.g.thread_title);
        this.cXb.cXh = (TbImageView) view.findViewById(d.g.thread_image);
        this.cXb.cXi = (ThreadCommentAndPraiseInfoLayoutNew) view.findViewById(d.g.thread_more_info);
        this.cXb.cXj = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cXb.mRootView.setOnClickListener(this);
        this.cXb.bcX.setOnClickListener(this.cWi);
        this.cXb.cXi.setOnClickListener(this);
        this.cXb.cXk = (CardGroupDividerView) view.findViewById(d.g.header_divider);
    }

    private void initUI() {
        this.cXb.cXh.setDrawBorder(true);
        this.cXb.cXh.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_zhibo_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.cXa = lVar;
        refreshView();
    }

    private void refreshView() {
        if (this.cXa == null || this.cXa.bZf == null) {
            this.cXb.mRootView.setVisibility(8);
            return;
        }
        j.a(getContext(), this.cXa.bZf, this.cXb.bcX);
        String string = this.mPageContext.getResources().getString(d.j.photo_live_tips);
        new SpannableStringBuilder(string + this.cXa.bZf.getTitle()).setSpan(new ForegroundColorSpan(aj.getColor(d.C0141d.cp_link_tip_a)), 0, string.length(), 17);
        this.cXb.cXg.setText(s(this.cXa.bZf.getTitle()));
        this.bdD = "feed#" + this.cXa.alA();
        this.cXb.cXi.setIsSimpleThread(false);
        this.cXb.cXi.setUserAfterClickListener(this.bdQ);
        this.cXb.cXi.Ev();
        if (this.cXb.cXi.setData(this.cXa.bZf)) {
            this.cXb.cXj.setVisibility(8);
        } else {
            this.cXb.cXj.setVisibility(0);
        }
        if (this.cXb.cmj != null && this.cXa.WD() != null) {
            ah ahVar = new ah();
            ahVar.cV(this.cXa.WD().getTid());
            ahVar.setFid(this.cXa.WD().getFid());
            ahVar.a(this.cXa.aNg);
            this.cXb.cmj.setData(ahVar);
            this.cXb.cmj.setFirstRowSingleColumn(true);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.i.xo().xu() && this.cXa.bZf.getPhotoLiveCover() != null && this.cXa.bZf.getPhotoLiveCover().length() != 0) {
            this.cXb.cXh.setVisibility(0);
            this.cXb.cXh.startLoad(this.cXa.bZf.getPhotoLiveCover(), 10, false);
        } else {
            this.cXb.cXh.setVisibility(8);
        }
        if (j.ks(this.cXa.bZf.getId())) {
            aj.e(this.cXb.cXg, d.C0141d.cp_cont_d, 1);
        } else {
            aj.e(this.cXb.cXg, d.C0141d.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cXb.mRootView || view == this.cXb.cXi.getCommentNumView()) {
            if (akO() != null) {
                akO().a(this.cXb.mRootView, this.cXa);
            }
            alk();
        }
    }

    public void alj() {
        this.cXb.cmj = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.cXb.cmj.SX();
        this.cXb.cXi.addView(this.cXb.cmj);
        if (this.cXb.cXi.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cXb.cXi.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cXb.cXi.setLayoutParams(layoutParams);
        }
    }

    private void alk() {
        if (this.cXa != null && this.cXa.bZf != null) {
            j.kr(this.cXa.bZf.getId());
            if (!all()) {
                UtilHelper.showToast(this.mPageContext.getPageActivity(), d.j.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.cXa.bZf.getTid()).cP(this.cXa.bZf.zE()).cS(this.cXa.alB()).cQ(j.zd()).xD()));
            kt(this.cXa.bZf.getTid());
        }
    }

    public void kt(final String str) {
        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.card.l.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001390, str));
            }
        }, 600L);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.n.a.a(tbPageContext, this.cXb.mRootView);
            this.cXb.cXi.onChangeSkinType();
            aj.s(this.cXb.mRootView, d.f.addresslist_item_bg);
            this.mSkinType = i;
            if (this.cXb.cmj != null) {
                this.cXb.cmj.onChangeSkinType();
            }
            if (this.cXb.cXk != null) {
                this.cXb.cXk.onChangeSkinType();
            }
        }
    }

    private boolean all() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.cWh != null) {
            setTag(bdUniqueId);
            if (this.cXb != null && this.cXb.cmj != null) {
                this.cXb.cmj.setUniqueId(bdUniqueId);
            }
            this.cWh.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cWh);
        }
    }

    private SpannableStringBuilder s(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.mPageContext.getResources().getString(d.j.photo_live_tips);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0141d.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(this.mPageContext.getPageActivity(), aj.fO(d.f.pic_dot_title), 1);
        bVar.setOffset(3);
        spannableStringBuilder.setSpan(bVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public void a(c.a aVar) {
        if (this.cXb == null || this.cXb.cmj == null) {
            return;
        }
        this.cXb.cmj.setEventCallback(aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView bcX;
        public TextView cXg;
        public TbImageView cXh;
        public ThreadCommentAndPraiseInfoLayoutNew cXi;
        public View cXj;
        public CardGroupDividerView cXk;
        private com.baidu.tieba.NEGFeedBack.c cmj = null;
        public View mRootView;

        public a() {
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cXb.cXi != null) {
            return this.cXb.cXi.bdL;
        }
        return null;
    }

    public View alm() {
        return this.cXb.bcX;
    }

    public View akR() {
        if (this.cXb.cXi != null) {
            return this.cXb.cXi.bdM;
        }
        return null;
    }
}
