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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.card.j;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public abstract class d extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.concern.b.b> {
    private final View.OnClickListener bec;
    private com.baidu.tbadk.core.view.userLike.c cWj;
    protected bd cad;
    public ThreadSourceShareAndPraiseLayout cmX;
    public ThreadUserInfoLayout cmj;
    public ThreadCommentAndPraiseInfoLayout cmk;
    protected LinearLayout cnj;
    private View dZm;
    private TextView egX;
    public ConcernUserLikeButton egY;
    private View egZ;
    public LinearLayout eha;
    protected com.baidu.tieba.homepage.concern.b.b ehb;
    protected boolean ehc;
    private View.OnClickListener ehd;
    protected View.OnClickListener ehe;
    private final View.OnClickListener ehf;
    protected TbPageContext<?> mPageContext;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void X(bd bdVar);

    protected abstract void by(View view);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ehc = true;
        this.ehd = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.akP() != null) {
                    d.this.akP().a(view, d.this.ehb);
                }
                if (d.this.ehb != null && !StringUtils.isNull(d.this.ehb.egJ.getName()) && !StringUtils.isNull(d.this.ehb.egJ.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(d.this.ehb.egJ.getUserId(), 0L), false, d.this.ehb.egJ.isGod())));
                }
            }
        };
        this.ehe = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.akP() != null) {
                    d.this.akP().a(view, d.this.ehb);
                }
                d.this.alj();
            }
        };
        this.bec = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.akP() != null) {
                    d.this.akP().a(view, d.this.ehb);
                }
            }
        };
        this.ehf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.thread_info_commont_container && d.this.cad != null) {
                    j.kr(d.this.cad.getId());
                    d.this.akU();
                }
            }
        };
        View view = getView();
        this.currentPageType = 1;
        this.mPageContext = tbPageContext;
        this.egX = (TextView) view.findViewById(d.g.card_recommend_god_reason);
        this.egY = (ConcernUserLikeButton) view.findViewById(d.g.card_recommend_god_user_like_btn);
        this.cmj = (ThreadUserInfoLayout) view.findViewById(d.g.card_rec_god_user_info);
        this.cWj = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.egY);
        this.cmj.setTShowVisible(false);
        this.cmj.getHeaderImg().setAfterClickListener(this.bec);
        this.egY.setAfterOnClickListener(this.bec);
        this.dZm = view.findViewById(d.g.card_recommend_god_divide_line);
        this.egZ = view.findViewById(d.g.divider_line);
        this.eha = (LinearLayout) view.findViewById(d.g.card_recommend_god_content);
        this.eha.setOnClickListener(this.ehd);
        this.mTitle = (TextView) view.findViewById(d.g.card_recommend_god_therad_title);
        this.cmk = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_recommend_god_therad_info_layout);
        this.cmk.setOnClickListener(this.ehe);
        this.cmk.setReplyTimeVisible(false);
        this.cmk.setIsBarViewVisible(false);
        this.cmk.setShowPraiseNum(true);
        this.cmk.setNeedAddPraiseIcon(true);
        this.cmk.setNeedAddReplyIcon(true);
        this.cmk.setShareVisible(true);
        this.cmk.aQE = this.currentPageType;
        this.cmk.setForumAfterClickListener(this.ehf);
        this.cmk.setShareReportFrom(4);
        this.cmk.setFrom(9);
        this.cmX = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_god_source_read_share_layout);
        this.cmX.bez.setOnClickListener(this.ehe);
        this.cmX.bez.aQE = this.currentPageType;
        this.cmX.bez.setForumAfterClickListener(this.ehf);
        this.cmX.setShareReportFrom(4);
        this.cmX.setFrom(9);
        this.cnj = (LinearLayout) view.findViewById(d.g.card_recommend_god_therad_content_layout);
        by(view);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.cWj.h(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.r(this.egX, d.C0140d.cp_cont_d);
            aj.t(this.dZm, d.C0140d.cp_bg_line_e);
            aj.t(this.egZ, d.C0140d.cp_bg_line_e);
            this.egY.onChangeSkinType(i);
            this.cmk.onChangeSkinType();
            this.cmX.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.egJ != null && !StringUtils.isNull(bVar.egJ.getName()) && !StringUtils.isNull(bVar.egJ.getUserId()) && !StringUtils.isNull(bVar.dxT.getTid())) {
            this.ehb = bVar;
            if (this.cmj != null) {
                this.cmj.setData(bVar.dxT);
                if (this.cmj.getHeaderImg() != null) {
                    this.cmj.getHeaderImg().setData(bVar.metaData);
                }
                this.cmj.onChangeSkinType();
            }
            this.cWj.a(this.ehb.metaData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eha.getLayoutParams();
            String aCs = this.ehb.egJ.aCs();
            if (StringUtils.isNull(aCs)) {
                this.egX.setVisibility(8);
            } else {
                this.egX.setVisibility(0);
                this.egX.setText(aCs);
            }
            this.cad = bVar.dxT;
            if (j.ks(this.cad.getId())) {
                akU();
            }
            this.cmk.setData(this.cad);
            j.b(this.cad, this.mTitle);
            this.ehc = true;
            if ((StringUtils.isNull(this.cad.getTitle()) && (this.cad.zl() == null || this.cad.zl().size() == 0)) || this.cad.zD() == 1) {
                this.cad.h(false, true);
                if (this.cad.zN() == null || StringUtils.isNull(this.cad.zN().toString())) {
                    this.ehc = false;
                }
            }
            X(this.cad);
            jX(this.cad.aQz);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.egY != null) {
            this.egY.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akU() {
        j.a(this.mTitle, this.cad.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alj() {
        if (this.ehb != null && this.cad != null) {
            j.kr(this.cad.getId());
            akU();
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.cad.getId(), this.cad.zE(), j.zd(), 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void jX(int i) {
        if (this.cad != null) {
            if (i == 1) {
                this.cmk.setVisibility(8);
                this.cmX.setData(this.cad);
                this.cmj.showForumNameView(false);
                return;
            }
            this.cmk.setData(this.cad);
            this.cmX.setVisibility(8);
            this.cmj.showForumNameView(true);
        }
    }
}
