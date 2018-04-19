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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public abstract class d extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.concern.b.b> implements com.baidu.tieba.a.e {
    private final View.OnClickListener apj;
    protected bd bjU;
    private String bvX;
    public ThreadSourceShareAndPraiseLayout bwZ;
    public ThreadUserInfoLayout bwj;
    public ThreadCommentAndPraiseInfoLayout bwk;
    protected LinearLayout bxk;
    private com.baidu.tbadk.core.view.userLike.c coa;
    private TextView dBH;
    public ConcernUserLikeButton dBI;
    private View dBJ;
    public LinearLayout dBK;
    protected com.baidu.tieba.homepage.concern.b.b dBL;
    protected boolean dBM;
    private View.OnClickListener dBN;
    protected View.OnClickListener dBO;
    private final View.OnClickListener dBP;
    private View dua;
    protected TbPageContext<?> mPageContext;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void Y(bd bdVar);

    protected abstract void ac(View view2);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dBM = true;
        this.dBN = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (d.this.aeZ() != null) {
                    d.this.aeZ().a(view2, d.this.dBL);
                }
                if (d.this.dBL != null && !StringUtils.isNull(d.this.dBL.dBt.getName()) && !StringUtils.isNull(d.this.dBL.dBt.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(d.this.dBL.dBt.getUserId(), 0L), false, d.this.dBL.dBt.isGod())));
                }
            }
        };
        this.dBO = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (d.this.aeZ() != null) {
                    d.this.aeZ().a(view2, d.this.dBL);
                }
                d.this.afs();
            }
        };
        this.apj = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (d.this.aeZ() != null) {
                    d.this.aeZ().a(view2, d.this.dBL);
                }
            }
        };
        this.dBP = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2.getId() == d.g.thread_info_commont_container && d.this.bjU != null) {
                    o.kv(d.this.bjU.getId());
                    d.this.afe();
                }
            }
        };
        View view2 = getView();
        this.currentPageType = 1;
        this.mPageContext = tbPageContext;
        this.dBH = (TextView) view2.findViewById(d.g.card_recommend_god_reason);
        this.dBI = (ConcernUserLikeButton) view2.findViewById(d.g.card_recommend_god_user_like_btn);
        this.bwj = (ThreadUserInfoLayout) view2.findViewById(d.g.card_rec_god_user_info);
        this.coa = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dBI);
        this.bwj.setTShowVisible(false);
        this.bwj.getHeaderImg().setAfterClickListener(this.apj);
        this.dBI.setAfterOnClickListener(this.apj);
        this.dua = view2.findViewById(d.g.card_recommend_god_divide_line);
        this.dBJ = view2.findViewById(d.g.divider_line);
        this.dBK = (LinearLayout) view2.findViewById(d.g.card_recommend_god_content);
        this.dBK.setOnClickListener(this.dBN);
        this.mTitle = (TextView) view2.findViewById(d.g.card_recommend_god_therad_title);
        this.bwk = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(d.g.card_recommend_god_therad_info_layout);
        this.bwk.setOnClickListener(this.dBO);
        this.bwk.setReplyTimeVisible(false);
        this.bwk.setIsBarViewVisible(false);
        this.bwk.setShowPraiseNum(true);
        this.bwk.setNeedAddPraiseIcon(true);
        this.bwk.setNeedAddReplyIcon(true);
        this.bwk.setShareVisible(true);
        this.bwk.abV = this.currentPageType;
        this.bwk.setForumAfterClickListener(this.dBP);
        this.bwk.setShareReportFrom(4);
        this.bwk.setFrom(9);
        this.bwZ = (ThreadSourceShareAndPraiseLayout) view2.findViewById(d.g.card_concern_god_source_read_share_layout);
        this.bwZ.apG.setOnClickListener(this.dBO);
        this.bwZ.apG.abV = this.currentPageType;
        this.bwZ.apG.setForumAfterClickListener(this.dBP);
        this.bwZ.setShareReportFrom(4);
        this.bwZ.setFrom(9);
        this.bxk = (LinearLayout) view2.findViewById(d.g.card_recommend_god_therad_content_layout);
        ac(view2);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.coa.h(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.f.addresslist_item_bg);
            ak.h(this.dBH, d.C0126d.cp_cont_d);
            ak.j(this.dua, d.C0126d.cp_bg_line_e);
            ak.j(this.dBJ, d.C0126d.cp_bg_line_e);
            this.dBI.onChangeSkinType(i);
            this.bwk.onChangeSkinType();
            this.bwZ.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.dBt != null && !StringUtils.isNull(bVar.dBt.getName()) && !StringUtils.isNull(bVar.dBt.getUserId()) && !StringUtils.isNull(bVar.cQx.getTid())) {
            this.dBL = bVar;
            if (this.bwj != null) {
                this.bwj.setData(bVar.cQx);
                if (this.bwj.getHeaderImg() != null) {
                    this.bwj.getHeaderImg().setData(bVar.metaData);
                }
                this.bwj.onChangeSkinType();
            }
            this.coa.a(this.dBL.metaData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dBK.getLayoutParams();
            String axp = this.dBL.dBt.axp();
            if (StringUtils.isNull(axp)) {
                this.dBH.setVisibility(8);
            } else {
                this.dBH.setVisibility(0);
                this.dBH.setText(axp);
            }
            this.bjU = bVar.cQx;
            if (o.kw(this.bjU.getId())) {
                afe();
            }
            this.bwk.setData(this.bjU);
            o.b(this.bjU, this.mTitle);
            this.dBM = true;
            if ((StringUtils.isNull(this.bjU.getTitle()) && (this.bjU.rO() == null || this.bjU.rO().size() == 0)) || this.bjU.sf() == 1) {
                this.bjU.e(false, true);
                if (this.bjU.so() == null || StringUtils.isNull(this.bjU.so().toString())) {
                    this.dBM = false;
                }
            }
            Y(this.bjU);
            hb(gm(1));
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.dBI != null) {
            this.dBI.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afe() {
        o.a(this.mTitle, this.bjU.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afs() {
        if (this.dBL != null && this.bjU != null) {
            o.kv(this.bjU.getId());
            afe();
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.bjU.getId(), this.bjU.sg(), o.rG(), 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }

    public void hb(int i) {
        if (this.bjU != null) {
            if (i == 1) {
                this.bwk.setVisibility(8);
                this.bwZ.setData(this.bjU);
                this.bwj.showForumNameView(false);
                return;
            }
            this.bwk.setData(this.bjU);
            this.bwZ.setVisibility(8);
            this.bwj.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bvX = str;
    }

    public int gm(int i) {
        return com.baidu.tieba.a.d.MH().L(this.bvX, i);
    }
}
