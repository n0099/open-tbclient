package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public abstract class b {
    protected g fKR;
    protected a fKS;
    protected boolean fKT;
    protected boolean fwN;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes4.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bpJ();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bpK();

    public b(g gVar, Intent intent) {
        this.fKT = true;
        this.fwN = false;
        this.fKR = gVar;
        this.mIntent = intent;
        e wX = d.bpP().wX(this.mIntent.getStringExtra("info_forum_name_text"));
        this.fKT = wX.bpR();
        this.fwN = wX.bpQ();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fKR.fLh.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = this.fwN ? l.g(TbadkCoreApplication.getInst(), R.dimen.tbds152) : l.g(TbadkCoreApplication.getInst(), R.dimen.tbds121);
            this.fKR.fLh.setLayoutParams(layoutParams);
        }
        this.fKR.fLg.setVisibility(this.fKT ? 0 : 4);
        if (wX.bpS()) {
            this.fKR.fLg.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.fKR.fLh.getLayoutParams()).topMargin = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.fKS = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
