package com.baidu.tieba.frs.entelechy.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.bi;
import com.baidu.tieba.frs.entelechy.view.bb;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class q extends aq<bi, bb> {
    private TbPageContext<?> GO;

    /* JADX INFO: Access modifiers changed from: protected */
    public q(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.GO = baseActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: G */
    public bb a(ViewGroup viewGroup) {
        return new bb(LayoutInflater.from(this.mContext).inflate(r.h.frs_read_progress_item, viewGroup, false), this.GO.getPageActivity());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.aq, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bi biVar, bb bbVar) {
        if (biVar != null && bbVar != null) {
            bbVar.a(biVar);
        }
        return view;
    }
}
