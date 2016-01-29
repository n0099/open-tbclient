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
public class ek extends bv<el, em> {
    private final LinkedList<com.baidu.tbadk.f.f> blq;
    private final LinkedList<RelativeLayout> blr;

    /* JADX INFO: Access modifiers changed from: protected */
    public ek(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.blq = new LinkedList<>();
        this.blr = new LinkedList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: D */
    public em b(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds90)));
        relativeLayout.setGravity(17);
        com.baidu.tbadk.f.f fVar = new com.baidu.tbadk.f.f(this.mContext, this.mContext.getResources().getDimensionPixelSize(t.e.ds140));
        fVar.I(relativeLayout);
        this.blq.add(fVar);
        this.blr.add(relativeLayout);
        em emVar = new em(relativeLayout);
        emVar.blt = fVar;
        return emVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bv, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, el elVar, em emVar) {
        if (emVar != null && emVar.blt != null) {
            emVar.blt.uv();
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.bv
    public void release() {
        super.release();
        if (this.blq.size() != 0 && this.blr.size() == this.blq.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.blq.size()) {
                    break;
                }
                this.blq.get(i2).H(this.blr.get(i2));
                i = i2 + 1;
            }
        }
        this.blq.clear();
        this.blr.clear();
    }
}
