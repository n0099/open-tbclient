package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public abstract class b {
    protected boolean hIj;
    protected g hXZ;
    protected a hYa;
    protected boolean hYb;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes9.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cex();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cey();

    public b(g gVar, Intent intent) {
        this.hYb = true;
        this.hIj = false;
        this.hXZ = gVar;
        this.mIntent = intent;
        e FH = d.ceD().FH(this.mIntent.getStringExtra("info_forum_name_text"));
        this.hYb = FH.ceF();
        this.hIj = FH.ceE();
        if (FH.ceG()) {
            ((RelativeLayout.LayoutParams) this.hXZ.hYp.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.hYa = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
