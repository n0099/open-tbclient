package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public abstract class b {
    protected boolean hOl;
    protected g ied;
    protected a iee;
    protected boolean ief;
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
        this.ief = true;
        this.hOl = false;
        this.ied = gVar;
        this.mIntent = intent;
        e Gt = d.cic().Gt(this.mIntent.getStringExtra("info_forum_name_text"));
        this.ief = Gt.cie();
        this.hOl = Gt.cid();
        if (Gt.cif()) {
            ((RelativeLayout.LayoutParams) this.ied.iet.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.iee = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
