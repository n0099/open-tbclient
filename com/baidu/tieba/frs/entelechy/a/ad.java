package com.baidu.tieba.frs.entelechy.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.bl;
import com.baidu.tieba.frs.entelechy.view.bc;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ad extends au<bl, bc> {
    private TbPageContext<?> GO;

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.GO = baseActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: y */
    public bc a(ViewGroup viewGroup) {
        return new bc(LayoutInflater.from(this.mContext).inflate(r.h.frs_read_progress_item, viewGroup, false), this.GO.getPageActivity());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.au, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bl blVar, bc bcVar) {
        if (blVar != null && bcVar != null) {
            bcVar.a(blVar);
        }
        return view;
    }
}
