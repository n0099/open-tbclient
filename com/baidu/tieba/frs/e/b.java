package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public abstract class b {
    protected g fKT;
    protected a fKU;
    protected boolean fKV;
    protected boolean fwN;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes4.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bpL();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bpM();

    public b(g gVar, Intent intent) {
        this.fKV = true;
        this.fwN = false;
        this.fKT = gVar;
        this.mIntent = intent;
        e wZ = d.bpR().wZ(this.mIntent.getStringExtra("info_forum_name_text"));
        this.fKV = wZ.bpT();
        this.fwN = wZ.bpS();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fKT.fLj.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = this.fwN ? l.g(TbadkCoreApplication.getInst(), R.dimen.tbds152) : l.g(TbadkCoreApplication.getInst(), R.dimen.tbds121);
            this.fKT.fLj.setLayoutParams(layoutParams);
        }
        this.fKT.fLi.setVisibility(this.fKV ? 0 : 4);
        if (wZ.bpU()) {
            this.fKT.fLi.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.fKT.fLj.getLayoutParams()).topMargin = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.fKU = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
