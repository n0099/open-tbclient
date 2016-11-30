package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class bt extends aq<bu, bv> {
    private final LinkedList<com.baidu.tbadk.f.f> bVk;
    private final LinkedList<RelativeLayout> bVl;

    public bt(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bVk = new LinkedList<>();
        this.bVl = new LinkedList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public bv a(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds90)));
        relativeLayout.setGravity(17);
        com.baidu.tbadk.f.f fVar = new com.baidu.tbadk.f.f(this.mContext, this.mContext.getResources().getDimensionPixelSize(r.e.ds140));
        fVar.N(relativeLayout);
        this.bVk.add(fVar);
        this.bVl.add(relativeLayout);
        bv bvVar = new bv(relativeLayout);
        bvVar.bVn = fVar;
        return bvVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.aq, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bu buVar, bv bvVar) {
        if (bvVar != null && bvVar.bVn != null) {
            bvVar.bVn.tB();
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.aq
    public void release() {
        super.release();
        if (this.bVk.size() != 0 && this.bVl.size() == this.bVk.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.bVk.size()) {
                    break;
                }
                this.bVk.get(i2).M(this.bVl.get(i2));
                i = i2 + 1;
            }
        }
        this.bVk.clear();
        this.bVl.clear();
    }
}
