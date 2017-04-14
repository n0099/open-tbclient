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
public class bs extends av<bt, bu> {
    private final LinkedList<com.baidu.tbadk.i.f> bPK;
    private final LinkedList<RelativeLayout> bPL;

    public bs(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bPK = new LinkedList<>();
        this.bPL = new LinkedList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public bu onCreateViewHolder(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, (com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds90)));
        relativeLayout.setGravity(17);
        com.baidu.tbadk.i.f fVar = new com.baidu.tbadk.i.f(this.mContext, this.mContext.getResources().getDimensionPixelSize(w.f.ds140));
        fVar.J(relativeLayout);
        this.bPK.add(fVar);
        this.bPL.add(relativeLayout);
        bu buVar = new bu(relativeLayout);
        buVar.bPN = fVar;
        return buVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bt btVar, bu buVar) {
        if (buVar != null && buVar.bPN != null) {
            buVar.bPN.onChangeSkinType();
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.av
    public void release() {
        super.release();
        if (this.bPK.size() != 0 && this.bPL.size() == this.bPK.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.bPK.size()) {
                    break;
                }
                this.bPK.get(i2).I(this.bPL.get(i2));
                i = i2 + 1;
            }
        }
        this.bPK.clear();
        this.bPL.clear();
    }
}
