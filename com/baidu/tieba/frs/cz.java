package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class cz extends bj<da, db> {
    private final LinkedList<com.baidu.tbadk.g.f> bGJ;
    private final LinkedList<RelativeLayout> bGK;

    public cz(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bGJ = new LinkedList<>();
        this.bGK = new LinkedList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: v */
    public db a(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, (com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds90)));
        relativeLayout.setGravity(17);
        com.baidu.tbadk.g.f fVar = new com.baidu.tbadk.g.f(this.mContext, this.mContext.getResources().getDimensionPixelSize(u.e.ds140));
        fVar.L(relativeLayout);
        this.bGJ.add(fVar);
        this.bGK.add(relativeLayout);
        db dbVar = new db(relativeLayout);
        dbVar.bGM = fVar;
        return dbVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bj, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, da daVar, db dbVar) {
        if (dbVar != null && dbVar.bGM != null) {
            dbVar.bGM.se();
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.bj
    public void release() {
        super.release();
        if (this.bGJ.size() != 0 && this.bGK.size() == this.bGJ.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.bGJ.size()) {
                    break;
                }
                this.bGJ.get(i2).K(this.bGK.get(i2));
                i = i2 + 1;
            }
        }
        this.bGJ.clear();
        this.bGK.clear();
    }
}
