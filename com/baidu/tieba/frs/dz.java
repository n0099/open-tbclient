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
public class dz extends bm<ea, eb> {
    private final LinkedList<com.baidu.tbadk.f.f> beB;
    private final LinkedList<RelativeLayout> beC;

    /* JADX INFO: Access modifiers changed from: protected */
    public dz(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.beB = new LinkedList<>();
        this.beC = new LinkedList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public eb a(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds90)));
        relativeLayout.setGravity(17);
        com.baidu.tbadk.f.f fVar = new com.baidu.tbadk.f.f(this.mContext, this.mContext.getResources().getDimensionPixelSize(n.d.ds140));
        fVar.w(relativeLayout);
        this.beB.add(fVar);
        this.beC.add(relativeLayout);
        eb ebVar = new eb(relativeLayout);
        ebVar.beE = fVar;
        return ebVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bm, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ea eaVar, eb ebVar) {
        if (ebVar != null && ebVar.beE != null) {
            ebVar.beE.tH();
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.bm
    public void release() {
        super.release();
        if (this.beB.size() != 0 && this.beC.size() == this.beB.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.beB.size()) {
                    break;
                }
                this.beB.get(i2).v(this.beC.get(i2));
                i = i2 + 1;
            }
        }
        this.beB.clear();
        this.beC.clear();
    }
}
