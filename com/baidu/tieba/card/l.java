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
    private String bdF;
    private final View.OnClickListener bdG;
    private final View.OnClickListener bdT;
    private CustomMessageListener cWk;
    private View.OnClickListener cWl;
    private com.baidu.tieba.card.data.l cXd;
    public a cXe;
    private View.OnClickListener cXf;
    private View.OnClickListener cXg;
    private TbPageContext<?> mPageContext;
    private String mStType;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cXf = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.akP() != null) {
                    l.this.akP().a(view, l.this.cXd);
                }
            }
        };
        this.cXg = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.akP() != null) {
                    l.this.akP().a(view, l.this.cXd);
                }
            }
        };
        this.cWk = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.l.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && l.this.cXd != null && l.this.cXd.bZi != null && l.this.cXd.bZi.getTid() != null && l.this.cXe != null && l.this.cXe.cXj != null && ((String) customResponsedMessage.getData()).equals(l.this.cXd.bZi.getTid())) {
                    j.a(l.this.cXe.cXj, l.this.cXd.bZi.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
                }
            }
        };
        this.bdT = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.akP() != null) {
                    l.this.akP().a(view, l.this.cXd);
                }
            }
        };
        this.bdG = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.akP() != null) {
                    l.this.akP().a(view, l.this.cXd);
                }
            }
        };
        this.cWl = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.cXd != null && !StringUtils.isNull(l.this.cXd.bZi.zt())) {
                    String zt = l.this.cXd.bZi.zt();
                    if (StringUtils.isNull(l.this.mStType) || StringUtils.isNull(l.this.bdF)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(l.this.mContext).createNormalCfg(zt, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(l.this.mContext).createCfgForpersonalized(zt, l.this.mStType, l.this.bdF)));
                    }
                    if (l.this.bdG != null) {
                        l.this.bdG.onClick(view);
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
        this.cXe = new a();
        this.cXe.mRootView = view.findViewById(d.g.card_root_view);
        this.cXe.bcZ = (TextView) view.findViewById(d.g.thread_info_bar_name);
        this.cXe.cXj = (TextView) view.findViewById(d.g.thread_title);
        this.cXe.cXk = (TbImageView) view.findViewById(d.g.thread_image);
        this.cXe.cXl = (ThreadCommentAndPraiseInfoLayoutNew) view.findViewById(d.g.thread_more_info);
        this.cXe.cXm = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cXe.mRootView.setOnClickListener(this);
        this.cXe.bcZ.setOnClickListener(this.cWl);
        this.cXe.cXl.setOnClickListener(this);
        this.cXe.cXn = (CardGroupDividerView) view.findViewById(d.g.header_divider);
    }

    private void initUI() {
        this.cXe.cXk.setDrawBorder(true);
        this.cXe.cXk.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_zhibo_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.cXd = lVar;
        refreshView();
    }

    private void refreshView() {
        if (this.cXd == null || this.cXd.bZi == null) {
            this.cXe.mRootView.setVisibility(8);
            return;
        }
        j.a(getContext(), this.cXd.bZi, this.cXe.bcZ);
        String string = this.mPageContext.getResources().getString(d.j.photo_live_tips);
        new SpannableStringBuilder(string + this.cXd.bZi.getTitle()).setSpan(new ForegroundColorSpan(aj.getColor(d.C0141d.cp_link_tip_a)), 0, string.length(), 17);
        this.cXe.cXj.setText(s(this.cXd.bZi.getTitle()));
        this.bdF = "feed#" + this.cXd.alB();
        this.cXe.cXl.setIsSimpleThread(false);
        this.cXe.cXl.setUserAfterClickListener(this.bdT);
        this.cXe.cXl.Ew();
        if (this.cXe.cXl.setData(this.cXd.bZi)) {
            this.cXe.cXm.setVisibility(8);
        } else {
            this.cXe.cXm.setVisibility(0);
        }
        if (this.cXe.cmm != null && this.cXd.WE() != null) {
            ah ahVar = new ah();
            ahVar.cV(this.cXd.WE().getTid());
            ahVar.setFid(this.cXd.WE().getFid());
            ahVar.a(this.cXd.aNh);
            this.cXe.cmm.setData(ahVar);
            this.cXe.cmm.setFirstRowSingleColumn(true);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.i.xo().xu() && this.cXd.bZi.getPhotoLiveCover() != null && this.cXd.bZi.getPhotoLiveCover().length() != 0) {
            this.cXe.cXk.setVisibility(0);
            this.cXe.cXk.startLoad(this.cXd.bZi.getPhotoLiveCover(), 10, false);
        } else {
            this.cXe.cXk.setVisibility(8);
        }
        if (j.ks(this.cXd.bZi.getId())) {
            aj.e(this.cXe.cXj, d.C0141d.cp_cont_d, 1);
        } else {
            aj.e(this.cXe.cXj, d.C0141d.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cXe.mRootView || view == this.cXe.cXl.getCommentNumView()) {
            if (akP() != null) {
                akP().a(this.cXe.mRootView, this.cXd);
            }
            all();
        }
    }

    public void alk() {
        this.cXe.cmm = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.cXe.cmm.SY();
        this.cXe.cXl.addView(this.cXe.cmm);
        if (this.cXe.cXl.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cXe.cXl.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cXe.cXl.setLayoutParams(layoutParams);
        }
    }

    private void all() {
        if (this.cXd != null && this.cXd.bZi != null) {
            j.kr(this.cXd.bZi.getId());
            if (!alm()) {
                UtilHelper.showToast(this.mPageContext.getPageActivity(), d.j.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.cXd.bZi.getTid()).cP(this.cXd.bZi.zE()).cS(this.cXd.alC()).cQ(j.zd()).xD()));
            kt(this.cXd.bZi.getTid());
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
            com.baidu.tbadk.n.a.a(tbPageContext, this.cXe.mRootView);
            this.cXe.cXl.onChangeSkinType();
            aj.s(this.cXe.mRootView, d.f.addresslist_item_bg);
            this.mSkinType = i;
            if (this.cXe.cmm != null) {
                this.cXe.cmm.onChangeSkinType();
            }
            if (this.cXe.cXn != null) {
                this.cXe.cXn.onChangeSkinType();
            }
        }
    }

    private boolean alm() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.cWk != null) {
            setTag(bdUniqueId);
            if (this.cXe != null && this.cXe.cmm != null) {
                this.cXe.cmm.setUniqueId(bdUniqueId);
            }
            this.cWk.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cWk);
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
        if (this.cXe == null || this.cXe.cmm == null) {
            return;
        }
        this.cXe.cmm.setEventCallback(aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView bcZ;
        public TextView cXj;
        public TbImageView cXk;
        public ThreadCommentAndPraiseInfoLayoutNew cXl;
        public View cXm;
        public CardGroupDividerView cXn;
        private com.baidu.tieba.NEGFeedBack.c cmm = null;
        public View mRootView;

        public a() {
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cXe.cXl != null) {
            return this.cXe.cXl.bdO;
        }
        return null;
    }

    public View aln() {
        return this.cXe.bcZ;
    }

    public View akS() {
        if (this.cXe.cXl != null) {
            return this.cXe.cXl.bdP;
        }
        return null;
    }
}
