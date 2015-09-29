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
public class dj extends bn<dk, dl> {
    private final LinkedList<com.baidu.tbadk.e.f> aYi;
    private final LinkedList<RelativeLayout> aYj;

    /* JADX INFO: Access modifiers changed from: protected */
    public dj(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aYi = new LinkedList<>();
        this.aYj = new LinkedList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: q */
    public dl a(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds90)));
        relativeLayout.setGravity(17);
        com.baidu.tbadk.e.f fVar = new com.baidu.tbadk.e.f(this.mContext, this.mContext.getResources().getDimensionPixelSize(i.d.ds140));
        fVar.v(relativeLayout);
        this.aYi.add(fVar);
        this.aYj.add(relativeLayout);
        dl dlVar = new dl(relativeLayout);
        dlVar.aYl = fVar;
        return dlVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bn, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, dk dkVar, dl dlVar) {
        if (dlVar != null && dlVar.aYl != null) {
            dlVar.aYl.tc();
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.bn
    public void release() {
        super.release();
        if (this.aYi.size() != 0 && this.aYj.size() == this.aYi.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.aYi.size()) {
                    break;
                }
                this.aYi.get(i2).u(this.aYj.get(i2));
                i = i2 + 1;
            }
        }
        this.aYi.clear();
        this.aYj.clear();
    }
}
