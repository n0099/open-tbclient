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
    private TextView anO;
    private final View.OnClickListener anS;
    private TextView aol;
    private com.baidu.tbadk.core.view.userLike.c bRv;
    protected bh biQ;
    public ThreadCommentAndPraiseInfoLayout boD;
    protected LinearLayout boH;
    public ClickableHeaderImageView cTA;
    private TextView deM;
    public ConcernUserLikeButton deN;
    private View deO;
    private View deP;
    public LinearLayout deQ;
    protected com.baidu.tieba.homepage.concern.b.b deR;
    protected boolean deS;
    private View.OnClickListener deT;
    protected View.OnClickListener deU;
    protected TbPageContext<?> mPageContext;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void S(bh bhVar);

    protected abstract void ad(View view);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.deS = true;
        this.deT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.Zx() != null) {
                    d.this.Zx().a(view, d.this.deR);
                }
                if (d.this.deR != null && !StringUtils.isNull(d.this.deR.dez.getName()) && !StringUtils.isNull(d.this.deR.dez.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(d.this.deR.dez.getUserId(), 0L), false, d.this.deR.dez.isGod())));
                }
            }
        };
        this.deU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.Zx() != null) {
                    d.this.Zx().a(view, d.this.deR);
                }
                d.this.ZP();
            }
        };
        this.anS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.Zx() != null) {
                    d.this.Zx().a(view, d.this.deR);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.deM = (TextView) view.findViewById(d.g.card_recommend_god_reason);
        this.cTA = (ClickableHeaderImageView) view.findViewById(d.g.card_recommend_god_header_view);
        this.cTA.setAfterClickListener(this.anS);
        this.anO = (TextView) view.findViewById(d.g.card_recommend_god_name);
        this.aol = (TextView) view.findViewById(d.g.card_recommend_god_rec_intro);
        this.deN = (ConcernUserLikeButton) view.findViewById(d.g.card_recommend_god_user_like_btn);
        this.bRv = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.deN);
        this.deN.setAfterOnClickListener(this.anS);
        this.deO = view.findViewById(d.g.card_recommend_god_divide_line);
        this.deP = view.findViewById(d.g.divider_line);
        this.deQ = (LinearLayout) view.findViewById(d.g.card_recommend_god_content);
        this.deQ.setOnClickListener(this.deT);
        this.mTitle = (TextView) view.findViewById(d.g.card_recommend_god_therad_title);
        this.boD = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_recommend_god_therad_info_layout);
        if (this.boD.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boD.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.boD.setLayoutParams(layoutParams);
        }
        this.boD.setOnClickListener(this.deU);
        this.boD.setReplyTimeVisible(false);
        this.boD.setIsBarViewVisible(false);
        this.boD.setShowPraiseNum(true);
        this.boD.setNeedAddPraiseIcon(true);
        this.boD.setNeedAddReplyIcon(true);
        this.boD.setShareVisible(true);
        this.boH = (LinearLayout) view.findViewById(d.g.card_recommend_god_therad_content_layout);
        ad(view);
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.bRv.h(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            aj.i(this.anO, d.C0080d.cp_cont_h);
            aj.i(this.aol, d.C0080d.cp_cont_d);
            aj.i(this.deM, d.C0080d.cp_cont_j);
            aj.k(this.deO, d.C0080d.cp_bg_line_e);
            aj.k(this.deP, d.C0080d.cp_bg_line_e);
            this.deN.onChangeSkinType(i);
            this.boD.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.dez != null && !StringUtils.isNull(bVar.dez.getName()) && !StringUtils.isNull(bVar.dez.getUserId()) && !StringUtils.isNull(bVar.bfD.getTid())) {
            this.deR = bVar;
            this.cTA.setData(this.deR.metaData);
            this.cTA.setIsRound(true);
            this.anO.setText(this.deR.dez.getName());
            this.aol.setText(this.deR.dez.getIntro());
            this.bRv.a(this.deR.metaData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.deQ.getLayoutParams();
            String arv = this.deR.dez.arv();
            if (StringUtils.isNull(arv)) {
                this.deM.setVisibility(8);
                layoutParams.topMargin = 0;
                this.deQ.setLayoutParams(layoutParams);
            } else {
                this.deM.setVisibility(0);
                layoutParams.topMargin = getContext().getResources().getDimensionPixelOffset(d.e.ds28);
                this.deQ.setLayoutParams(layoutParams);
                this.deM.setText(arv);
            }
            this.biQ = bVar.bfD;
            if (m.jL(this.biQ.getId())) {
                ZC();
            }
            this.boD.setData(this.biQ);
            m.b(this.biQ, this.mTitle);
            this.deS = true;
            if ((StringUtils.isNull(this.biQ.getTitle()) && (this.biQ.rr() == null || this.biQ.rr().size() == 0)) || this.biQ.rJ() == 1) {
                this.biQ.e(false, true);
                if (this.biQ.rU() == null || StringUtils.isNull(this.biQ.rU().toString())) {
                    this.deS = false;
                }
            }
            S(this.biQ);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cTA != null) {
            this.cTA.setTag(bdUniqueId);
        }
        if (this.deN != null) {
            this.deN.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ZC() {
        m.a(this.mTitle, this.biQ.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ZP() {
        if (this.deR != null && this.biQ != null) {
            m.jK(this.biQ.getId());
            ZC();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.biQ.getId(), this.biQ.rK(), m.rj(), 18005)));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
