package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public abstract class b {
    protected g hKa;
    protected a hKb;
    protected boolean hKc;
    protected boolean hvg;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes9.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void caW();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void caX();

    public b(g gVar, Intent intent) {
        this.hKc = true;
        this.hvg = false;
        this.hKa = gVar;
        this.mIntent = intent;
        e Fg = d.cbc().Fg(this.mIntent.getStringExtra("info_forum_name_text"));
        this.hKc = Fg.cbe();
        this.hvg = Fg.cbd();
        if (Fg.cbf()) {
            ((RelativeLayout.LayoutParams) this.hKa.hKq.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.hKb = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
