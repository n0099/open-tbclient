package com.baidu.tieba.frs.entelechy.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.bl;
import com.baidu.tieba.frs.entelechy.view.bb;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ad extends av<bl, bb> {
    private TbPageContext<?> ajU;

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.ajU = baseActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: C */
    public bb onCreateViewHolder(ViewGroup viewGroup) {
        return new bb(LayoutInflater.from(this.mContext).inflate(w.j.frs_read_progress_item, viewGroup, false), this.ajU.getPageActivity());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bl blVar, bb bbVar) {
        if (blVar != null && bbVar != null) {
            bbVar.a(blVar);
        }
        return view;
    }
}
