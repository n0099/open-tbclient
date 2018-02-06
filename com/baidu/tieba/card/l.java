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
    private String bdP;
    private final View.OnClickListener bdQ;
    private final View.OnClickListener bec;
    private CustomMessageListener cWt;
    private View.OnClickListener cWu;
    private com.baidu.tieba.card.data.l cXm;
    public a cXn;
    private View.OnClickListener cXo;
    private View.OnClickListener cXp;
    private TbPageContext<?> mPageContext;
    private String mStType;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cXo = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.akP() != null) {
                    l.this.akP().a(view, l.this.cXm);
                }
            }
        };
        this.cXp = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.akP() != null) {
                    l.this.akP().a(view, l.this.cXm);
                }
            }
        };
        this.cWt = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.l.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && l.this.cXm != null && l.this.cXm.bZr != null && l.this.cXm.bZr.getTid() != null && l.this.cXn != null && l.this.cXn.cXs != null && ((String) customResponsedMessage.getData()).equals(l.this.cXm.bZr.getTid())) {
                    j.a(l.this.cXn.cXs, l.this.cXm.bZr.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
                }
            }
        };
        this.bec = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.akP() != null) {
                    l.this.akP().a(view, l.this.cXm);
                }
            }
        };
        this.bdQ = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.akP() != null) {
                    l.this.akP().a(view, l.this.cXm);
                }
            }
        };
        this.cWu = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.cXm != null && !StringUtils.isNull(l.this.cXm.bZr.zt())) {
                    String zt = l.this.cXm.bZr.zt();
                    if (StringUtils.isNull(l.this.mStType) || StringUtils.isNull(l.this.bdP)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(l.this.mContext).createNormalCfg(zt, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(l.this.mContext).createCfgForpersonalized(zt, l.this.mStType, l.this.bdP)));
                    }
                    if (l.this.bdQ != null) {
                        l.this.bdQ.onClick(view);
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
        this.cXn = new a();
        this.cXn.mRootView = view.findViewById(d.g.card_root_view);
        this.cXn.bdj = (TextView) view.findViewById(d.g.thread_info_bar_name);
        this.cXn.cXs = (TextView) view.findViewById(d.g.thread_title);
        this.cXn.cXt = (TbImageView) view.findViewById(d.g.thread_image);
        this.cXn.cXu = (ThreadCommentAndPraiseInfoLayoutNew) view.findViewById(d.g.thread_more_info);
        this.cXn.cXv = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cXn.mRootView.setOnClickListener(this);
        this.cXn.bdj.setOnClickListener(this.cWu);
        this.cXn.cXu.setOnClickListener(this);
        this.cXn.cXw = (CardGroupDividerView) view.findViewById(d.g.header_divider);
    }

    private void initUI() {
        this.cXn.cXt.setDrawBorder(true);
        this.cXn.cXt.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_zhibo_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.cXm = lVar;
        refreshView();
    }

    private void refreshView() {
        if (this.cXm == null || this.cXm.bZr == null) {
            this.cXn.mRootView.setVisibility(8);
            return;
        }
        j.a(getContext(), this.cXm.bZr, this.cXn.bdj);
        String string = this.mPageContext.getResources().getString(d.j.photo_live_tips);
        new SpannableStringBuilder(string + this.cXm.bZr.getTitle()).setSpan(new ForegroundColorSpan(aj.getColor(d.C0140d.cp_link_tip_a)), 0, string.length(), 17);
        this.cXn.cXs.setText(s(this.cXm.bZr.getTitle()));
        this.bdP = "feed#" + this.cXm.alB();
        this.cXn.cXu.setIsSimpleThread(false);
        this.cXn.cXu.setUserAfterClickListener(this.bec);
        this.cXn.cXu.Ew();
        if (this.cXn.cXu.setData(this.cXm.bZr)) {
            this.cXn.cXv.setVisibility(8);
        } else {
            this.cXn.cXv.setVisibility(0);
        }
        if (this.cXn.cmv != null && this.cXm.WE() != null) {
            ah ahVar = new ah();
            ahVar.cV(this.cXm.WE().getTid());
            ahVar.setFid(this.cXm.WE().getFid());
            ahVar.a(this.cXm.aNr);
            this.cXn.cmv.setData(ahVar);
            this.cXn.cmv.setFirstRowSingleColumn(true);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.i.xo().xu() && this.cXm.bZr.getPhotoLiveCover() != null && this.cXm.bZr.getPhotoLiveCover().length() != 0) {
            this.cXn.cXt.setVisibility(0);
            this.cXn.cXt.startLoad(this.cXm.bZr.getPhotoLiveCover(), 10, false);
        } else {
            this.cXn.cXt.setVisibility(8);
        }
        if (j.ks(this.cXm.bZr.getId())) {
            aj.e(this.cXn.cXs, d.C0140d.cp_cont_d, 1);
        } else {
            aj.e(this.cXn.cXs, d.C0140d.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cXn.mRootView || view == this.cXn.cXu.getCommentNumView()) {
            if (akP() != null) {
                akP().a(this.cXn.mRootView, this.cXm);
            }
            all();
        }
    }

    public void alk() {
        this.cXn.cmv = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.cXn.cmv.SY();
        this.cXn.cXu.addView(this.cXn.cmv);
        if (this.cXn.cXu.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cXn.cXu.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cXn.cXu.setLayoutParams(layoutParams);
        }
    }

    private void all() {
        if (this.cXm != null && this.cXm.bZr != null) {
            j.kr(this.cXm.bZr.getId());
            if (!alm()) {
                UtilHelper.showToast(this.mPageContext.getPageActivity(), d.j.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.cXm.bZr.getTid()).cP(this.cXm.bZr.zE()).cS(this.cXm.alC()).cQ(j.zd()).xD()));
            kt(this.cXm.bZr.getTid());
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
            com.baidu.tbadk.n.a.a(tbPageContext, this.cXn.mRootView);
            this.cXn.cXu.onChangeSkinType();
            aj.s(this.cXn.mRootView, d.f.addresslist_item_bg);
            this.mSkinType = i;
            if (this.cXn.cmv != null) {
                this.cXn.cmv.onChangeSkinType();
            }
            if (this.cXn.cXw != null) {
                this.cXn.cXw.onChangeSkinType();
            }
        }
    }

    private boolean alm() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.cWt != null) {
            setTag(bdUniqueId);
            if (this.cXn != null && this.cXn.cmv != null) {
                this.cXn.cmv.setUniqueId(bdUniqueId);
            }
            this.cWt.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cWt);
        }
    }

    private SpannableStringBuilder s(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.mPageContext.getResources().getString(d.j.photo_live_tips);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0140d.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(this.mPageContext.getPageActivity(), aj.fO(d.f.pic_dot_title), 1);
        bVar.setOffset(3);
        spannableStringBuilder.setSpan(bVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public void a(c.a aVar) {
        if (this.cXn == null || this.cXn.cmv == null) {
            return;
        }
        this.cXn.cmv.setEventCallback(aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView bdj;
        public TextView cXs;
        public TbImageView cXt;
        public ThreadCommentAndPraiseInfoLayoutNew cXu;
        public View cXv;
        public CardGroupDividerView cXw;
        private com.baidu.tieba.NEGFeedBack.c cmv = null;
        public View mRootView;

        public a() {
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cXn.cXu != null) {
            return this.cXn.cXu.bdX;
        }
        return null;
    }

    public View aln() {
        return this.cXn.bdj;
    }

    public View akS() {
        if (this.cXn.cXu != null) {
            return this.cXn.cXu.bdY;
        }
        return null;
    }
}
