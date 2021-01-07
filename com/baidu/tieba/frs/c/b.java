package com.baidu.tieba.frs.c;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public abstract class b {
    protected g jHA;
    protected a jHB;
    protected boolean jHC;
    protected boolean joP;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes2.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cMQ();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cMR();

    public b(g gVar, Intent intent) {
        this.jHC = true;
        this.joP = false;
        this.jHA = gVar;
        this.mIntent = intent;
        e LE = d.cMW().LE(this.mIntent.getStringExtra("info_forum_name_text"));
        this.jHC = LE.cMY();
        this.joP = LE.cMX();
        if (LE.cMZ()) {
            ((RelativeLayout.LayoutParams) this.jHA.jHQ.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.jHB = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
