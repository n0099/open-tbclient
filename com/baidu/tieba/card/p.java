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
    private final View.OnClickListener anR;
    private String any;
    private final View.OnClickListener anz;
    private CustomMessageListener bSf;
    private View.OnClickListener bSg;
    private com.baidu.tieba.card.data.m bTm;
    public a bTn;
    private View.OnClickListener bTo;
    private View.OnClickListener bTp;
    private TbPageContext<?> mPageContext;
    private String mStType;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bTo = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.ZJ() != null) {
                    p.this.ZJ().a(view, p.this.bTm);
                }
            }
        };
        this.bTp = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.ZJ() != null) {
                    p.this.ZJ().a(view, p.this.bTm);
                }
            }
        };
        this.bSf = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.p.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && p.this.bTm != null && p.this.bTm.bff != null && p.this.bTm.bff.getTid() != null && p.this.bTn != null && p.this.bTn.bRS != null && ((String) customResponsedMessage.getData()).equals(p.this.bTm.bff.getTid())) {
                    m.a(p.this.bTn.bRS, p.this.bTm.bff.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
                }
            }
        };
        this.anR = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.ZJ() != null) {
                    p.this.ZJ().a(view, p.this.bTm);
                }
            }
        };
        this.anz = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.ZJ() != null) {
                    p.this.ZJ().a(view, p.this.bTm);
                }
            }
        };
        this.bSg = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.bTm != null && !StringUtils.isNull(p.this.bTm.bff.rz())) {
                    String rz = p.this.bTm.bff.rz();
                    if (StringUtils.isNull(p.this.mStType) || StringUtils.isNull(p.this.any)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(p.this.mContext).createNormalCfg(rz, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(p.this.mContext).createCfgForpersonalized(rz, p.this.mStType, p.this.any)));
                    }
                    if (p.this.anz != null) {
                        p.this.anz.onClick(view);
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
        this.bTn = new a();
        this.bTn.mRootView = view.findViewById(d.g.card_root_view);
        this.bTn.amP = (TextView) view.findViewById(d.g.thread_info_bar_name);
        this.bTn.bRS = (TextView) view.findViewById(d.g.thread_title);
        this.bTn.bTr = (TbImageView) view.findViewById(d.g.thread_image);
        this.bTn.bTs = (ThreadCommentAndPraiseInfoLayoutNew) view.findViewById(d.g.thread_more_info);
        this.bTn.bTt = view.findViewById(d.g.divider_below_reply_number_layout);
        this.bTn.mRootView.setOnClickListener(this);
        this.bTn.amP.setOnClickListener(this.bSg);
        this.bTn.bTs.setOnClickListener(this);
        this.bTn.bRL = (CardGroupDividerView) view.findViewById(d.g.header_divider);
    }

    private void initUI() {
        this.bTn.bTr.setDrawBorder(true);
        this.bTn.bTr.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_zhibo_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.m mVar) {
        this.bTm = mVar;
        refreshView();
    }

    private void refreshView() {
        if (this.bTm == null || this.bTm.bff == null) {
            this.bTn.mRootView.setVisibility(8);
            return;
        }
        m.a(getContext(), this.bTm.bff, this.bTn.amP);
        String string = this.mPageContext.getResources().getString(d.j.photo_live_tips);
        new SpannableStringBuilder(string + this.bTm.bff.getTitle()).setSpan(new ForegroundColorSpan(aj.getColor(d.C0080d.cp_link_tip_a)), 0, string.length(), 17);
        this.bTn.bRS.setText(e(this.bTm.bff.getTitle()));
        this.any = "feed#" + this.bTm.aam();
        this.bTn.bTs.setIsSimpleThread(false);
        this.bTn.bTs.setUserAfterClickListener(this.anR);
        this.bTn.bTs.wK();
        if (this.bTn.bTs.setData(this.bTm.bff)) {
            this.bTn.bTt.setVisibility(8);
        } else {
            this.bTn.bTt.setVisibility(0);
        }
        if (this.bTn.bRe != null && this.bTm.NA() != null) {
            al alVar = new al();
            alVar.cD(this.bTm.NA().getTid());
            alVar.setFid(this.bTm.NA().getFid());
            alVar.a(this.bTm.Xm);
            this.bTn.bRe.setData(alVar);
            this.bTn.bRe.setFirstRowSingleColumn(true);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.h.oT().oZ() && this.bTm.bff.getPhotoLiveCover() != null && this.bTm.bff.getPhotoLiveCover().length() != 0) {
            this.bTn.bTr.setVisibility(0);
            this.bTn.bTr.startLoad(this.bTm.bff.getPhotoLiveCover(), 10, false);
        } else {
            this.bTn.bTr.setVisibility(8);
        }
        if (m.jM(this.bTm.bff.getId())) {
            aj.c(this.bTn.bRS, d.C0080d.cp_cont_d, 1);
        } else {
            aj.c(this.bTn.bRS, d.C0080d.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bTn.mRootView || view == this.bTn.bTs.getCommentNumView()) {
            if (ZJ() != null) {
                ZJ().a(this.bTn.mRootView, this.bTm);
            }
            aae();
        }
    }

    public void aad() {
        this.bTn.bRe = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.bTn.bRe.KF();
        this.bTn.bTs.addView(this.bTn.bRe);
        if (this.bTn.bTs.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bTn.bTs.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bTn.bTs.setLayoutParams(layoutParams);
        }
    }

    private void aae() {
        if (this.bTm != null && this.bTm.bff != null) {
            m.jL(this.bTm.bff.getId());
            if (!aaf()) {
                UtilHelper.showToast(this.mPageContext.getPageActivity(), d.j.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.bTm.bff.getTid()).cx(this.bTm.bff.rK()).cA(this.bTm.aan()).cy(m.rj()).pi()));
            jN(this.bTm.bff.getTid());
        }
    }

    public void jN(final String str) {
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
            com.baidu.tbadk.o.a.a(tbPageContext, this.bTn.mRootView);
            this.bTn.bTs.onChangeSkinType();
            aj.j(this.bTn.mRootView, d.f.addresslist_item_bg);
            this.mSkinType = i;
            if (this.bTn.bRe != null) {
                this.bTn.bRe.onChangeSkinType();
            }
            if (this.bTn.bRL != null) {
                this.bTn.bRL.onChangeSkinType();
            }
        }
    }

    private boolean aaf() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.bSf != null) {
            setTag(bdUniqueId);
            if (this.bTn != null && this.bTn.bRe != null) {
                this.bTn.bRe.setUniqueId(bdUniqueId);
            }
            this.bSf.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bSf);
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.mPageContext.getResources().getString(d.j.photo_live_tips);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0080d.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(this.mPageContext.getPageActivity(), aj.cQ(d.f.pic_dot_title), 1);
        bVar.setOffset(3);
        spannableStringBuilder.setSpan(bVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public void a(c.a aVar) {
        if (this.bTn == null || this.bTn.bRe == null) {
            return;
        }
        this.bTn.bRe.setEventCallback(aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView amP;
        public CardGroupDividerView bRL;
        public TextView bRS;
        private com.baidu.tieba.NEGFeedBack.c bRe = null;
        public TbImageView bTr;
        public ThreadCommentAndPraiseInfoLayoutNew bTs;
        public View bTt;
        public View mRootView;

        public a() {
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bTn.bTs != null) {
            return this.bTn.bTs.anM;
        }
        return null;
    }

    public View aag() {
        return this.bTn.amP;
    }

    public View ZM() {
        if (this.bTn.bTs != null) {
            return this.bTn.bTs.anN;
        }
        return null;
    }
}
