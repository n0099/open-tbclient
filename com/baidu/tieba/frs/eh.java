package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.BaseActivity;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class eh extends bw<com.baidu.tbadk.core.data.ax, a> {
    private View.OnClickListener aQs;
    private com.baidu.tbadk.core.data.ax aab;
    private BaseActivity<?> bek;
    private Set<String> blS;

    public eh(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId, boolean z) {
        super(baseActivity, bdUniqueId);
        this.aQs = new ei(this);
        this.bek = baseActivity;
        this.blS = new HashSet();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public a b(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.c.ar arVar = new com.baidu.tieba.frs.entelechy.c.ar(this.bek.getPageContext());
        arVar.j(this.bek.getUniqueId());
        arVar.setClickListener(this.aQs);
        return new a(arVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bw, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ax axVar, a aVar) {
        this.aab = axVar;
        com.baidu.tbadk.core.data.av qF = axVar.qF();
        if (qF != null) {
            String taskId = qF.getTaskId();
            String qE = qF.qE();
            if (StringUtils.isNull(qE)) {
                qE = qF.getTaskId();
            }
            if (this.bek instanceof fj) {
                fj fjVar = (fj) this.bek;
                if (this.blS.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", null, "VIEW_TRUE", fjVar.getForumId(), fjVar.getForumName(), qF.getThreadId(), null, "tieba.baidu.com/p/" + axVar.getTid(), qE);
                }
            }
        }
        aVar.blU.h(axVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.bw
    public void release() {
        super.release();
        this.blS.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends y.a {
        public com.baidu.tieba.frs.entelechy.c.ar blU;

        public a(com.baidu.tieba.frs.entelechy.c.ar arVar) {
            super(arVar.getView());
            this.blU = arVar;
        }
    }
}
