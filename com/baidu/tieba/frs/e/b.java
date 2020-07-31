package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public abstract class b {
    protected boolean hOj;
    protected g ieb;
    protected a iec;
    protected boolean ied;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes16.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void chW();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void chX();

    public b(g gVar, Intent intent) {
        this.ied = true;
        this.hOj = false;
        this.ieb = gVar;
        this.mIntent = intent;
        e Gt = d.cic().Gt(this.mIntent.getStringExtra("info_forum_name_text"));
        this.ied = Gt.cie();
        this.hOj = Gt.cid();
        if (Gt.cif()) {
            ((RelativeLayout.LayoutParams) this.ieb.ier.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.iec = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
