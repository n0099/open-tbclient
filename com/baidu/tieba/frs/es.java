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
public class es extends bx<et, eu> {
    private final LinkedList<com.baidu.tbadk.f.f> bqI;
    private final LinkedList<RelativeLayout> bqJ;

    /* JADX INFO: Access modifiers changed from: protected */
    public es(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bqI = new LinkedList<>();
        this.bqJ = new LinkedList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: F */
    public eu b(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, (com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds90)));
        relativeLayout.setGravity(17);
        com.baidu.tbadk.f.f fVar = new com.baidu.tbadk.f.f(this.mContext, this.mContext.getResources().getDimensionPixelSize(t.e.ds140));
        fVar.L(relativeLayout);
        this.bqI.add(fVar);
        this.bqJ.add(relativeLayout);
        eu euVar = new eu(relativeLayout);
        euVar.bqL = fVar;
        return euVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bx, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, et etVar, eu euVar) {
        if (euVar != null && euVar.bqL != null) {
            euVar.bqL.uA();
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.bx
    public void release() {
        super.release();
        if (this.bqI.size() != 0 && this.bqJ.size() == this.bqI.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.bqI.size()) {
                    break;
                }
                this.bqI.get(i2).K(this.bqJ.get(i2));
                i = i2 + 1;
            }
        }
        this.bqI.clear();
        this.bqJ.clear();
    }
}
