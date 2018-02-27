package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.card.t;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ao;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class m extends com.baidu.tieba.frs.g<bd, a> implements t, com.baidu.tieba.frs.e.c {
    private v<bd> clL;
    private Set<String> dKP;
    private boolean dKQ;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dKQ = false;
        this.clL = new v<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    if (view.getId() == d.g.card_home_page_normal_thread_user_header || view.getId() == d.g.card_home_page_normal_thread_user_pendant_header) {
                        com.baidu.tieba.frs.e.b.azQ().a(com.baidu.tieba.frs.e.c.dUe, bdVar, 2);
                    } else if (view.getId() == d.g.card_home_page_normal_thread_root) {
                        if (bdVar.zP() == 2 && bdVar.yV() != null) {
                            String xP = bdVar.yV().xP();
                            if (StringUtils.isNull(xP)) {
                                xP = bdVar.yV().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", String.valueOf(bdVar.getFid()), bdVar.zt(), bdVar.yV().getThreadId(), "tieba.baidu.com/p/" + bdVar.yV().getThreadId(), xP);
                        }
                        com.baidu.tieba.frs.e.b.azQ().a(com.baidu.tieba.frs.e.c.dUe, bdVar, 1);
                    }
                }
            }
        };
        this.dKP = new HashSet();
        this.dKQ = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: az */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.m mVar = new com.baidu.tieba.frs.entelechy.view.m(this.mPageContext, this.mPageId);
        mVar.j(this.mPageId);
        mVar.b(this.clL);
        return new a(mVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, a aVar) {
        com.baidu.tieba.frs.e.b.azQ().a(dUe, bdVar);
        bb yV = bdVar.yV();
        if (yV != null) {
            String taskId = yV.getTaskId();
            String xP = yV.xP();
            if (StringUtils.isNull(xP)) {
                xP = yV.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof ao) {
                ao aoVar = (ao) this.mPageContext.getOrignalPage();
                if (this.dKP.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", "VIEW_TRUE", aoVar.getForumId(), aoVar.getForumName(), yV.getThreadId(), "tieba.baidu.com/p/" + bdVar.getTid(), xP);
                }
            }
        }
        if (bdVar != null) {
            bdVar.Ai();
        }
        aVar.dKS.setFromCDN(this.mIsFromCDN);
        aVar.dKS.a(bdVar);
        aVar.dKS.gf(this.dKQ);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.g
    public void release() {
        super.release();
        this.dKP.clear();
    }

    @Override // com.baidu.tieba.card.t
    public void setForumName(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a extends r.a {
        public com.baidu.tieba.frs.entelechy.view.m dKS;

        public a(com.baidu.tieba.frs.entelechy.view.m mVar) {
            super(mVar.getView());
            this.dKS = mVar;
        }
    }
}
