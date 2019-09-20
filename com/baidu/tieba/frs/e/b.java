package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public abstract class b {
    protected boolean fEk;
    protected g fSw;
    protected a fSx;
    protected boolean fSy;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes4.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bsM();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bsN();

    public b(g gVar, Intent intent) {
        this.fSy = true;
        this.fEk = false;
        this.fSw = gVar;
        this.mIntent = intent;
        e ye = d.bsS().ye(this.mIntent.getStringExtra("info_forum_name_text"));
        this.fSy = ye.bsU();
        this.fEk = ye.bsT();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fSw.fSM.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = this.fEk ? l.g(TbadkCoreApplication.getInst(), R.dimen.tbds152) : l.g(TbadkCoreApplication.getInst(), R.dimen.tbds121);
            this.fSw.fSM.setLayoutParams(layoutParams);
        }
        this.fSw.fSL.setVisibility(this.fSy ? 0 : 4);
        if (ye.bsV()) {
            this.fSw.fSL.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.fSw.fSM.getLayoutParams()).topMargin = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.fSx = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
