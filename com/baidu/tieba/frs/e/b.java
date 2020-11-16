package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public abstract class b {
    protected boolean iRD;
    protected g jhA;
    protected a jhB;
    protected boolean jhC;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes21.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cEA();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cEB();

    public b(g gVar, Intent intent) {
        this.jhC = true;
        this.iRD = false;
        this.jhA = gVar;
        this.mIntent = intent;
        e Ky = d.cEG().Ky(this.mIntent.getStringExtra("info_forum_name_text"));
        this.jhC = Ky.cEI();
        this.iRD = Ky.cEH();
        if (Ky.cEJ()) {
            ((RelativeLayout.LayoutParams) this.jhA.jhQ.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.jhB = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
