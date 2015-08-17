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
public class co extends bc<cp, cq> {
    private final LinkedList<com.baidu.tbadk.c.f> aYp;
    private final LinkedList<RelativeLayout> aYq;

    /* JADX INFO: Access modifiers changed from: protected */
    public co(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aYp = new LinkedList<>();
        this.aYq = new LinkedList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public cq a(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds90)));
        relativeLayout.setGravity(17);
        com.baidu.tbadk.c.f fVar = new com.baidu.tbadk.c.f(this.mContext, this.mContext.getResources().getDimensionPixelSize(i.d.ds140));
        fVar.v(relativeLayout);
        this.aYp.add(fVar);
        this.aYq.add(relativeLayout);
        cq cqVar = new cq(relativeLayout);
        cqVar.aYs = fVar;
        return cqVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bc, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, cp cpVar, cq cqVar) {
        if (cqVar != null && cqVar.aYs != null) {
            cqVar.aYs.ta();
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.bc
    public void release() {
        super.release();
        if (this.aYp.size() != 0 && this.aYq.size() == this.aYp.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.aYp.size()) {
                    break;
                }
                this.aYp.get(i2).u(this.aYq.get(i2));
                i = i2 + 1;
            }
        }
        this.aYp.clear();
        this.aYq.clear();
    }
}
