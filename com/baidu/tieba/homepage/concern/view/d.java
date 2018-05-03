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
    private com.baidu.tbadk.core.view.userLike.c cnX;
    private TextView dBE;
    public ConcernUserLikeButton dBF;
    private View dBG;
    public LinearLayout dBH;
    protected com.baidu.tieba.homepage.concern.b.b dBI;
    protected boolean dBJ;
    private View.OnClickListener dBK;
    protected View.OnClickListener dBL;
    private final View.OnClickListener dBM;
    private View dtX;
    protected TbPageContext<?> mPageContext;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void Y(bd bdVar);

    protected abstract void ac(View view2);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dBJ = true;
        this.dBK = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (d.this.aeZ() != null) {
                    d.this.aeZ().a(view2, d.this.dBI);
                }
                if (d.this.dBI != null && !StringUtils.isNull(d.this.dBI.dBq.getName()) && !StringUtils.isNull(d.this.dBI.dBq.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(d.this.dBI.dBq.getUserId(), 0L), false, d.this.dBI.dBq.isGod())));
                }
            }
        };
        this.dBL = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (d.this.aeZ() != null) {
                    d.this.aeZ().a(view2, d.this.dBI);
                }
                d.this.afs();
            }
        };
        this.apj = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (d.this.aeZ() != null) {
                    d.this.aeZ().a(view2, d.this.dBI);
                }
            }
        };
        this.dBM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.4
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
        this.dBE = (TextView) view2.findViewById(d.g.card_recommend_god_reason);
        this.dBF = (ConcernUserLikeButton) view2.findViewById(d.g.card_recommend_god_user_like_btn);
        this.bwj = (ThreadUserInfoLayout) view2.findViewById(d.g.card_rec_god_user_info);
        this.cnX = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dBF);
        this.bwj.setTShowVisible(false);
        this.bwj.getHeaderImg().setAfterClickListener(this.apj);
        this.dBF.setAfterOnClickListener(this.apj);
        this.dtX = view2.findViewById(d.g.card_recommend_god_divide_line);
        this.dBG = view2.findViewById(d.g.divider_line);
        this.dBH = (LinearLayout) view2.findViewById(d.g.card_recommend_god_content);
        this.dBH.setOnClickListener(this.dBK);
        this.mTitle = (TextView) view2.findViewById(d.g.card_recommend_god_therad_title);
        this.bwk = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(d.g.card_recommend_god_therad_info_layout);
        this.bwk.setOnClickListener(this.dBL);
        this.bwk.setReplyTimeVisible(false);
        this.bwk.setIsBarViewVisible(false);
        this.bwk.setShowPraiseNum(true);
        this.bwk.setNeedAddPraiseIcon(true);
        this.bwk.setNeedAddReplyIcon(true);
        this.bwk.setShareVisible(true);
        this.bwk.abV = this.currentPageType;
        this.bwk.setForumAfterClickListener(this.dBM);
        this.bwk.setShareReportFrom(4);
        this.bwk.setFrom(9);
        this.bwZ = (ThreadSourceShareAndPraiseLayout) view2.findViewById(d.g.card_concern_god_source_read_share_layout);
        this.bwZ.apG.setOnClickListener(this.dBL);
        this.bwZ.apG.abV = this.currentPageType;
        this.bwZ.apG.setForumAfterClickListener(this.dBM);
        this.bwZ.setShareReportFrom(4);
        this.bwZ.setFrom(9);
        this.bxk = (LinearLayout) view2.findViewById(d.g.card_recommend_god_therad_content_layout);
        ac(view2);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.cnX.h(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.f.addresslist_item_bg);
            ak.h(this.dBE, d.C0126d.cp_cont_d);
            ak.j(this.dtX, d.C0126d.cp_bg_line_e);
            ak.j(this.dBG, d.C0126d.cp_bg_line_e);
            this.dBF.onChangeSkinType(i);
            this.bwk.onChangeSkinType();
            this.bwZ.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.dBq != null && !StringUtils.isNull(bVar.dBq.getName()) && !StringUtils.isNull(bVar.dBq.getUserId()) && !StringUtils.isNull(bVar.cQu.getTid())) {
            this.dBI = bVar;
            if (this.bwj != null) {
                this.bwj.setData(bVar.cQu);
                if (this.bwj.getHeaderImg() != null) {
                    this.bwj.getHeaderImg().setData(bVar.metaData);
                }
                this.bwj.onChangeSkinType();
            }
            this.cnX.a(this.dBI.metaData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dBH.getLayoutParams();
            String axp = this.dBI.dBq.axp();
            if (StringUtils.isNull(axp)) {
                this.dBE.setVisibility(8);
            } else {
                this.dBE.setVisibility(0);
                this.dBE.setText(axp);
            }
            this.bjU = bVar.cQu;
            if (o.kw(this.bjU.getId())) {
                afe();
            }
            this.bwk.setData(this.bjU);
            o.b(this.bjU, this.mTitle);
            this.dBJ = true;
            if ((StringUtils.isNull(this.bjU.getTitle()) && (this.bjU.rO() == null || this.bjU.rO().size() == 0)) || this.bjU.sf() == 1) {
                this.bjU.e(false, true);
                if (this.bjU.so() == null || StringUtils.isNull(this.bjU.so().toString())) {
                    this.dBJ = false;
                }
            }
            Y(this.bjU);
            hb(gm(1));
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.dBF != null) {
            this.dBF.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afe() {
        o.a(this.mTitle, this.bjU.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afs() {
        if (this.dBI != null && this.bjU != null) {
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
