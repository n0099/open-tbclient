package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public abstract class b {
    protected boolean ijA;
    protected g izD;
    protected a izE;
    protected boolean izF;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes21.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cvQ();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cvR();

    public b(g gVar, Intent intent) {
        this.izF = true;
        this.ijA = false;
        this.izD = gVar;
        this.mIntent = intent;
        e Ju = d.cvW().Ju(this.mIntent.getStringExtra("info_forum_name_text"));
        this.izF = Ju.cvY();
        this.ijA = Ju.cvX();
        if (Ju.cvZ()) {
            ((RelativeLayout.LayoutParams) this.izD.izT.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.izE = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
