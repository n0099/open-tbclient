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
    private TextView anN;
    private final View.OnClickListener anR;
    private TextView aok;
    private com.baidu.tbadk.core.view.userLike.c bRI;
    protected bh biZ;
    public ThreadCommentAndPraiseInfoLayout boM;
    protected LinearLayout boQ;
    public ClickableHeaderImageView cTU;
    private TextView dfg;
    public ConcernUserLikeButton dfh;
    private View dfi;
    private View dfj;
    public LinearLayout dfk;
    protected com.baidu.tieba.homepage.concern.b.b dfl;
    protected boolean dfm;
    private View.OnClickListener dfn;
    protected View.OnClickListener dfo;
    protected TbPageContext<?> mPageContext;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void S(bh bhVar);

    protected abstract void ad(View view);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dfm = true;
        this.dfn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.ZJ() != null) {
                    d.this.ZJ().a(view, d.this.dfl);
                }
                if (d.this.dfl != null && !StringUtils.isNull(d.this.dfl.deT.getName()) && !StringUtils.isNull(d.this.dfl.deT.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(d.this.dfl.deT.getUserId(), 0L), false, d.this.dfl.deT.isGod())));
                }
            }
        };
        this.dfo = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.ZJ() != null) {
                    d.this.ZJ().a(view, d.this.dfl);
                }
                d.this.aab();
            }
        };
        this.anR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.ZJ() != null) {
                    d.this.ZJ().a(view, d.this.dfl);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.dfg = (TextView) view.findViewById(d.g.card_recommend_god_reason);
        this.cTU = (ClickableHeaderImageView) view.findViewById(d.g.card_recommend_god_header_view);
        this.cTU.setAfterClickListener(this.anR);
        this.anN = (TextView) view.findViewById(d.g.card_recommend_god_name);
        this.aok = (TextView) view.findViewById(d.g.card_recommend_god_rec_intro);
        this.dfh = (ConcernUserLikeButton) view.findViewById(d.g.card_recommend_god_user_like_btn);
        this.bRI = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dfh);
        this.dfh.setAfterOnClickListener(this.anR);
        this.dfi = view.findViewById(d.g.card_recommend_god_divide_line);
        this.dfj = view.findViewById(d.g.divider_line);
        this.dfk = (LinearLayout) view.findViewById(d.g.card_recommend_god_content);
        this.dfk.setOnClickListener(this.dfn);
        this.mTitle = (TextView) view.findViewById(d.g.card_recommend_god_therad_title);
        this.boM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_recommend_god_therad_info_layout);
        if (this.boM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.boM.setLayoutParams(layoutParams);
        }
        this.boM.setOnClickListener(this.dfo);
        this.boM.setReplyTimeVisible(false);
        this.boM.setIsBarViewVisible(false);
        this.boM.setShowPraiseNum(true);
        this.boM.setNeedAddPraiseIcon(true);
        this.boM.setNeedAddReplyIcon(true);
        this.boM.setShareVisible(true);
        this.boQ = (LinearLayout) view.findViewById(d.g.card_recommend_god_therad_content_layout);
        ad(view);
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.bRI.h(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            aj.i(this.anN, d.C0080d.cp_cont_h);
            aj.i(this.aok, d.C0080d.cp_cont_d);
            aj.i(this.dfg, d.C0080d.cp_cont_j);
            aj.k(this.dfi, d.C0080d.cp_bg_line_e);
            aj.k(this.dfj, d.C0080d.cp_bg_line_e);
            this.dfh.onChangeSkinType(i);
            this.boM.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.deT != null && !StringUtils.isNull(bVar.deT.getName()) && !StringUtils.isNull(bVar.deT.getUserId()) && !StringUtils.isNull(bVar.bfM.getTid())) {
            this.dfl = bVar;
            this.cTU.setData(this.dfl.metaData);
            this.cTU.setIsRound(true);
            this.anN.setText(this.dfl.deT.getName());
            this.aok.setText(this.dfl.deT.getIntro());
            this.bRI.a(this.dfl.metaData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dfk.getLayoutParams();
            String arL = this.dfl.deT.arL();
            if (StringUtils.isNull(arL)) {
                this.dfg.setVisibility(8);
                layoutParams.topMargin = 0;
                this.dfk.setLayoutParams(layoutParams);
            } else {
                this.dfg.setVisibility(0);
                layoutParams.topMargin = getContext().getResources().getDimensionPixelOffset(d.e.ds28);
                this.dfk.setLayoutParams(layoutParams);
                this.dfg.setText(arL);
            }
            this.biZ = bVar.bfM;
            if (m.jM(this.biZ.getId())) {
                ZO();
            }
            this.boM.setData(this.biZ);
            m.b(this.biZ, this.mTitle);
            this.dfm = true;
            if ((StringUtils.isNull(this.biZ.getTitle()) && (this.biZ.rr() == null || this.biZ.rr().size() == 0)) || this.biZ.rJ() == 1) {
                this.biZ.e(false, true);
                if (this.biZ.rU() == null || StringUtils.isNull(this.biZ.rU().toString())) {
                    this.dfm = false;
                }
            }
            S(this.biZ);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cTU != null) {
            this.cTU.setTag(bdUniqueId);
        }
        if (this.dfh != null) {
            this.dfh.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ZO() {
        m.a(this.mTitle, this.biZ.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aab() {
        if (this.dfl != null && this.biZ != null) {
            m.jL(this.biZ.getId());
            ZO();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.biZ.getId(), this.biZ.rK(), m.rj(), 18005)));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
