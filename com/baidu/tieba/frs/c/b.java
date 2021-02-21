package com.baidu.tieba.frs.c;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public abstract class b {
    protected g jIM;
    protected a jIN;
    protected boolean jIO;
    protected boolean jqd;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes2.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cKs();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cKt();

    public b(g gVar, Intent intent) {
        this.jIO = true;
        this.jqd = false;
        this.jIM = gVar;
        this.mIntent = intent;
        e Lg = d.cKy().Lg(this.mIntent.getStringExtra("info_forum_name_text"));
        this.jIO = Lg.cKA();
        this.jqd = Lg.cKz();
        if (Lg.cKB()) {
            ((RelativeLayout.LayoutParams) this.jIM.jJc.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.jIN = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
