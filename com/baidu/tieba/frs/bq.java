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
public class bq extends at<br, bs> {
    private final LinkedList<com.baidu.tbadk.f.f> bIM;
    private final LinkedList<RelativeLayout> bIN;

    public bq(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bIM = new LinkedList<>();
        this.bIN = new LinkedList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public bs onCreateViewHolder(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, (com.baidu.adp.lib.util.k.J(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds90)));
        relativeLayout.setGravity(17);
        com.baidu.tbadk.f.f fVar = new com.baidu.tbadk.f.f(this.mContext, this.mContext.getResources().getDimensionPixelSize(r.f.ds140));
        fVar.L(relativeLayout);
        this.bIM.add(fVar);
        this.bIN.add(relativeLayout);
        bs bsVar = new bs(relativeLayout);
        bsVar.bIP = fVar;
        return bsVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.at, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, br brVar, bs bsVar) {
        if (bsVar != null && bsVar.bIP != null) {
            bsVar.bIP.tg();
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.at
    public void release() {
        super.release();
        if (this.bIM.size() != 0 && this.bIN.size() == this.bIM.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.bIM.size()) {
                    break;
                }
                this.bIM.get(i2).K(this.bIN.get(i2));
                i = i2 + 1;
            }
        }
        this.bIM.clear();
        this.bIN.clear();
    }
}
