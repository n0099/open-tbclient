package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public abstract class b {
    protected boolean iQQ;
    protected g jgP;
    protected a jgQ;
    protected boolean jgR;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes22.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cEV();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cEW();

    public b(g gVar, Intent intent) {
        this.jgR = true;
        this.iQQ = false;
        this.jgP = gVar;
        this.mIntent = intent;
        e KX = d.cFb().KX(this.mIntent.getStringExtra("info_forum_name_text"));
        this.jgR = KX.cFd();
        this.iQQ = KX.cFc();
        if (KX.cFe()) {
            ((RelativeLayout.LayoutParams) this.jgP.jhf.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.jgQ = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
