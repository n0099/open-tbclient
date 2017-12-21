package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class w extends e<x, y> {
    private final LinkedList<com.baidu.tbadk.j.f> cKd;
    private final LinkedList<RelativeLayout> cKe;

    public w(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.cKd = new LinkedList<>();
        this.cKe = new LinkedList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aj */
    public y onCreateViewHolder(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, (com.baidu.adp.lib.util.l.ae(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds90)));
        relativeLayout.setGravity(17);
        com.baidu.tbadk.j.f fVar = new com.baidu.tbadk.j.f(this.mContext, this.mContext.getResources().getDimensionPixelSize(d.e.ds140));
        fVar.Q(relativeLayout);
        this.cKd.add(fVar);
        this.cKe.add(relativeLayout);
        y yVar = new y(relativeLayout);
        yVar.cKg = fVar;
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.e, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, x xVar, y yVar) {
        if (yVar != null && yVar.cKg != null) {
            yVar.cKg.onChangeSkinType();
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.e
    public void release() {
        super.release();
        if (this.cKd.size() != 0 && this.cKe.size() == this.cKd.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.cKd.size()) {
                    break;
                }
                this.cKd.get(i2).P(this.cKe.get(i2));
                i = i2 + 1;
            }
        }
        this.cKd.clear();
        this.cKe.clear();
    }
}
