package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class bq extends at<br, bs> {
    private final LinkedList<com.baidu.tbadk.f.f> bPV;
    private final LinkedList<RelativeLayout> bPW;

    public bq(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bPV = new LinkedList<>();
        this.bPW = new LinkedList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public bs onCreateViewHolder(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, (com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds90)));
        relativeLayout.setGravity(17);
        com.baidu.tbadk.f.f fVar = new com.baidu.tbadk.f.f(this.mContext, this.mContext.getResources().getDimensionPixelSize(w.f.ds140));
        fVar.J(relativeLayout);
        this.bPV.add(fVar);
        this.bPW.add(relativeLayout);
        bs bsVar = new bs(relativeLayout);
        bsVar.bPY = fVar;
        return bsVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.at, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, br brVar, bs bsVar) {
        if (bsVar != null && bsVar.bPY != null) {
            bsVar.bPY.tD();
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.at
    public void release() {
        super.release();
        if (this.bPV.size() != 0 && this.bPW.size() == this.bPV.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.bPV.size()) {
                    break;
                }
                this.bPV.get(i2).I(this.bPW.get(i2));
                i = i2 + 1;
            }
        }
        this.bPV.clear();
        this.bPW.clear();
    }
}
