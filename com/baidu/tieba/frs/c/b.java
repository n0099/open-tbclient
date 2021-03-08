package com.baidu.tieba.frs.c;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public abstract class b {
    protected g jKv;
    protected a jKw;
    protected boolean jKx;
    protected boolean jrM;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes2.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cKy();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cKz();

    public b(g gVar, Intent intent) {
        this.jKx = true;
        this.jrM = false;
        this.jKv = gVar;
        this.mIntent = intent;
        e Lp = d.cKE().Lp(this.mIntent.getStringExtra("info_forum_name_text"));
        this.jKx = Lp.cKG();
        this.jrM = Lp.cKF();
        if (Lp.cKH()) {
            ((RelativeLayout.LayoutParams) this.jKv.jKL.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.jKw = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
