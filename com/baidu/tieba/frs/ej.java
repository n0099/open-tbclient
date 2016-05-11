package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ej extends bw<ek, el> {
    private final LinkedList<com.baidu.tbadk.f.f> blV;
    private final LinkedList<RelativeLayout> blW;

    public ej(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.blV = new LinkedList<>();
        this.blW = new LinkedList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: y */
    public el b(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, (com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m11getInst()) - TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds100)) - TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds90)));
        relativeLayout.setGravity(17);
        com.baidu.tbadk.f.f fVar = new com.baidu.tbadk.f.f(this.mContext, this.mContext.getResources().getDimensionPixelSize(t.e.ds140));
        fVar.M(relativeLayout);
        this.blV.add(fVar);
        this.blW.add(relativeLayout);
        el elVar = new el(relativeLayout);
        elVar.blY = fVar;
        return elVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bw, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ek ekVar, el elVar) {
        if (elVar != null && elVar.blY != null) {
            elVar.blY.sf();
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.bw
    public void release() {
        super.release();
        if (this.blV.size() != 0 && this.blW.size() == this.blV.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.blV.size()) {
                    break;
                }
                this.blV.get(i2).L(this.blW.get(i2));
                i = i2 + 1;
            }
        }
        this.blV.clear();
        this.blW.clear();
    }
}
