package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class d extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.concern.b.b> {
    private TextView anF;
    private final View.OnClickListener anJ;
    private TextView aoc;
    private com.baidu.tbadk.core.view.userLike.c bKb;
    protected bh bit;
    public ThreadCommentAndPraiseInfoLayout bnj;
    protected LinearLayout bnn;
    public ClickableHeaderImageView cKB;
    private View cUW;
    private TextView cWJ;
    public ConcernUserLikeButton cWK;
    private View cWL;
    public LinearLayout cWM;
    protected com.baidu.tieba.homepage.concern.b.b cWN;
    protected boolean cWO;
    private View.OnClickListener cWP;
    protected View.OnClickListener cWQ;
    protected TbPageContext<?> mG;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void Q(bh bhVar);

    protected abstract void aa(View view);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cWO = false;
        this.cWP = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.Xr() != null) {
                    d.this.Xr().a(view, d.this.cWN);
                }
                if (d.this.cWN != null && !StringUtils.isNull(d.this.cWN.cWv.getName()) && !StringUtils.isNull(d.this.cWN.cWv.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(d.this.mG.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(d.this.cWN.cWv.getUserId(), 0L), false, d.this.cWN.cWv.isGod())));
                }
            }
        };
        this.cWQ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.Xr() != null) {
                    d.this.Xr().a(view, d.this.cWN);
                }
                d.this.XJ();
            }
        };
        this.anJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.Xr() != null) {
                    d.this.Xr().a(view, d.this.cWN);
                }
            }
        };
        View view = getView();
        this.mG = tbPageContext;
        this.cWJ = (TextView) view.findViewById(d.h.card_recommend_god_reason);
        this.cKB = (ClickableHeaderImageView) view.findViewById(d.h.card_recommend_god_header_view);
        this.cKB.setAfterClickListener(this.anJ);
        this.anF = (TextView) view.findViewById(d.h.card_recommend_god_name);
        this.aoc = (TextView) view.findViewById(d.h.card_recommend_god_rec_intro);
        this.cWK = (ConcernUserLikeButton) view.findViewById(d.h.card_recommend_god_user_like_btn);
        this.bKb = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.cWK);
        this.cWK.setAfterOnClickListener(this.anJ);
        this.cWL = view.findViewById(d.h.card_recommend_god_divide_line);
        this.cUW = view.findViewById(d.h.divider_line);
        this.cWM = (LinearLayout) view.findViewById(d.h.card_recommend_god_content);
        this.cWM.setOnClickListener(this.cWP);
        this.mTitle = (TextView) view.findViewById(d.h.card_recommend_god_therad_title);
        this.bnj = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_recommend_god_therad_info_layout);
        if (this.bnj.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bnj.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bnj.setLayoutParams(layoutParams);
        }
        this.bnj.setOnClickListener(this.cWQ);
        this.bnj.setReplyTimeVisible(false);
        this.bnj.setIsBarViewVisible(false);
        this.bnj.setShowPraiseNum(true);
        this.bnj.setNeedAddPraiseIcon(true);
        this.bnj.setNeedAddReplyIcon(true);
        this.bnj.setShareVisible(true);
        this.bnn = (LinearLayout) view.findViewById(d.h.card_recommend_god_therad_content_layout);
        aa(view);
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.bKb.h(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.addresslist_item_bg);
            aj.i(this.anF, d.e.cp_cont_h);
            aj.i(this.aoc, d.e.cp_cont_d);
            aj.i(this.cWJ, d.e.cp_cont_j);
            aj.k(this.cWL, d.e.cp_bg_line_e);
            aj.k(this.cUW, d.e.cp_bg_line_e);
            this.cWK.onChangeSkinType(i);
            this.bnj.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.cWv != null && !StringUtils.isNull(bVar.cWv.getName()) && !StringUtils.isNull(bVar.cWv.getUserId()) && !StringUtils.isNull(bVar.bfa.getTid())) {
            this.cWN = bVar;
            this.cKB.setData(this.cWN.metaData);
            this.cKB.setIsRound(true);
            this.anF.setText(this.cWN.cWv.getName());
            this.aoc.setText(this.cWN.cWv.getIntro());
            this.bKb.a(this.cWN.metaData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cWM.getLayoutParams();
            String apb = this.cWN.cWv.apb();
            if (StringUtils.isNull(apb)) {
                this.cWJ.setVisibility(8);
                layoutParams.topMargin = 0;
                this.cWM.setLayoutParams(layoutParams);
            } else {
                this.cWJ.setVisibility(0);
                layoutParams.topMargin = getContext().getResources().getDimensionPixelOffset(d.f.ds28);
                this.cWM.setLayoutParams(layoutParams);
                this.cWJ.setText(apb);
            }
            this.bit = bVar.bfa;
            if (m.jo(this.bit.getId())) {
                Xw();
            }
            this.bnj.setData(this.bit);
            m.b(this.bit, this.mTitle);
            if ((StringUtils.isNull(this.bit.getTitle()) && (this.bit.rt() == null || this.bit.rt().size() == 0)) || this.bit.rK() == 1) {
                this.bit.e(false, true);
                if (this.bit.rV() == null || StringUtils.isNull(this.bit.rV().toString())) {
                    this.cWO = false;
                }
            }
            Q(this.bit);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cKB != null) {
            this.cKB.setTag(bdUniqueId);
        }
        if (this.cWK != null) {
            this.cWK.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Xw() {
        m.a(this.mTitle, this.bit.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void XJ() {
        if (this.cWN != null && this.bit != null) {
            m.jn(this.bit.getId());
            Xw();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mG.getPageActivity()).createCfgForPersonCenter(this.bit.getId(), this.bit.rL(), m.rm(), 18005)));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
