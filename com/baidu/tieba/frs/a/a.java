package com.baidu.tieba.frs.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.bw;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.aj;
/* loaded from: classes.dex */
public class a extends bw<aj, b> {
    private TbPageContext pageContext;

    public a(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.pageContext = baseActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: C */
    public b b(ViewGroup viewGroup) {
        return new b(this.pageContext, LayoutInflater.from(this.mContext).inflate(t.h.u9_info_layout, (ViewGroup) null, true));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bw, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, aj ajVar, b bVar) {
        super.a(i, view, viewGroup, (ViewGroup) ajVar, (aj) bVar);
        if (ajVar == null || bVar == null) {
            return null;
        }
        bVar.a(ajVar);
        bVar.onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
        return bVar.getView();
    }
}
