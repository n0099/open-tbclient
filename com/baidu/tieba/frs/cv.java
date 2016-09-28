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
public class cv extends bf<cw, cx> {
    private final LinkedList<com.baidu.tbadk.f.f> bTe;
    private final LinkedList<RelativeLayout> bTf;

    public cv(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bTe = new LinkedList<>();
        this.bTf = new LinkedList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: u */
    public cx a(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds90)));
        relativeLayout.setGravity(17);
        com.baidu.tbadk.f.f fVar = new com.baidu.tbadk.f.f(this.mContext, this.mContext.getResources().getDimensionPixelSize(r.e.ds140));
        fVar.M(relativeLayout);
        this.bTe.add(fVar);
        this.bTf.add(relativeLayout);
        cx cxVar = new cx(relativeLayout);
        cxVar.bTh = fVar;
        return cxVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bf, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, cw cwVar, cx cxVar) {
        if (cxVar != null && cxVar.bTh != null) {
            cxVar.bTh.tx();
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.bf
    public void release() {
        super.release();
        if (this.bTe.size() != 0 && this.bTf.size() == this.bTe.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.bTe.size()) {
                    break;
                }
                this.bTe.get(i2).L(this.bTf.get(i2));
                i = i2 + 1;
            }
        }
        this.bTe.clear();
        this.bTf.clear();
    }
}
