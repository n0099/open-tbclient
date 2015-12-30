package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class dz extends bp<ea, eb> {
    private final LinkedList<com.baidu.tbadk.f.f> biv;
    private final LinkedList<RelativeLayout> biw;

    /* JADX INFO: Access modifiers changed from: protected */
    public dz(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.biv = new LinkedList<>();
        this.biw = new LinkedList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public eb a(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds90)));
        relativeLayout.setGravity(17);
        com.baidu.tbadk.f.f fVar = new com.baidu.tbadk.f.f(this.mContext, this.mContext.getResources().getDimensionPixelSize(n.e.ds140));
        fVar.v(relativeLayout);
        this.biv.add(fVar);
        this.biw.add(relativeLayout);
        eb ebVar = new eb(relativeLayout);
        ebVar.biy = fVar;
        return ebVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bp, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ea eaVar, eb ebVar) {
        if (ebVar != null && ebVar.biy != null) {
            ebVar.biy.tr();
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.bp
    public void release() {
        super.release();
        if (this.biv.size() != 0 && this.biw.size() == this.biv.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.biv.size()) {
                    break;
                }
                this.biv.get(i2).u(this.biw.get(i2));
                i = i2 + 1;
            }
        }
        this.biv.clear();
        this.biw.clear();
    }
}
