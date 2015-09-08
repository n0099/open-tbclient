package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class cu extends bd<cv, cw> {
    private final LinkedList<com.baidu.tbadk.e.f> aYG;
    private final LinkedList<RelativeLayout> aYH;

    /* JADX INFO: Access modifiers changed from: protected */
    public cu(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aYG = new LinkedList<>();
        this.aYH = new LinkedList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: o */
    public cw a(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds90)));
        relativeLayout.setGravity(17);
        com.baidu.tbadk.e.f fVar = new com.baidu.tbadk.e.f(this.mContext, this.mContext.getResources().getDimensionPixelSize(i.d.ds140));
        fVar.v(relativeLayout);
        this.aYG.add(fVar);
        this.aYH.add(relativeLayout);
        cw cwVar = new cw(relativeLayout);
        cwVar.aYJ = fVar;
        return cwVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bd, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, cv cvVar, cw cwVar) {
        if (cwVar != null && cwVar.aYJ != null) {
            cwVar.aYJ.tf();
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.bd
    public void release() {
        super.release();
        if (this.aYG.size() != 0 && this.aYH.size() == this.aYG.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.aYG.size()) {
                    break;
                }
                this.aYG.get(i2).u(this.aYH.get(i2));
                i = i2 + 1;
            }
        }
        this.aYG.clear();
        this.aYH.clear();
    }
}
