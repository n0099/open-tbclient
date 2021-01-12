package com.baidu.tieba.frs.c;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public abstract class b {
    protected g jCU;
    protected a jCV;
    protected boolean jCW;
    protected boolean jki;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes2.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cIY();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cIZ();

    public b(g gVar, Intent intent) {
        this.jCW = true;
        this.jki = false;
        this.jCU = gVar;
        this.mIntent = intent;
        e Ku = d.cJe().Ku(this.mIntent.getStringExtra("info_forum_name_text"));
        this.jCW = Ku.cJg();
        this.jki = Ku.cJf();
        if (Ku.cJh()) {
            ((RelativeLayout.LayoutParams) this.jCU.jDk.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.jCV = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
