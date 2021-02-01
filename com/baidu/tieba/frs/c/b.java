package com.baidu.tieba.frs.c;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public abstract class b {
    protected boolean jIA;
    protected g jIy;
    protected a jIz;
    protected boolean jpP;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes2.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cKl();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cKm();

    public b(g gVar, Intent intent) {
        this.jIA = true;
        this.jpP = false;
        this.jIy = gVar;
        this.mIntent = intent;
        e Lf = d.cKr().Lf(this.mIntent.getStringExtra("info_forum_name_text"));
        this.jIA = Lf.cKt();
        this.jpP = Lf.cKs();
        if (Lf.cKu()) {
            ((RelativeLayout.LayoutParams) this.jIy.jIO.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.jIz = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
