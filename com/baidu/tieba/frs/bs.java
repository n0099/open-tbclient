package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.f.f;
import com.baidu.tieba.r;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class bs extends au<bt, bu> {
    private final LinkedList<f> bBs;
    private final LinkedList<RelativeLayout> bBt;

    public bs(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bBs = new LinkedList<>();
        this.bBt = new LinkedList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: s */
    public bu a(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, (com.baidu.adp.lib.util.k.J(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds90)));
        relativeLayout.setGravity(17);
        f fVar = new f(this.mContext, this.mContext.getResources().getDimensionPixelSize(r.e.ds140));
        fVar.N(relativeLayout);
        this.bBs.add(fVar);
        this.bBt.add(relativeLayout);
        bu buVar = new bu(relativeLayout);
        buVar.bBv = fVar;
        return buVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.au, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bt btVar, bu buVar) {
        if (buVar != null && buVar.bBv != null) {
            buVar.bBv.tm();
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.au
    public void release() {
        super.release();
        if (this.bBs.size() != 0 && this.bBt.size() == this.bBs.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.bBs.size()) {
                    break;
                }
                this.bBs.get(i2).M(this.bBt.get(i2));
                i = i2 + 1;
            }
        }
        this.bBs.clear();
        this.bBt.clear();
    }
}
