package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public abstract class b {
    protected g hKN;
    protected a hKO;
    protected boolean hKP;
    protected boolean hvr;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes9.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cbe();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cbf();

    public b(g gVar, Intent intent) {
        this.hKP = true;
        this.hvr = false;
        this.hKN = gVar;
        this.mIntent = intent;
        e Fg = d.cbk().Fg(this.mIntent.getStringExtra("info_forum_name_text"));
        this.hKP = Fg.cbm();
        this.hvr = Fg.cbl();
        if (Fg.cbn()) {
            ((RelativeLayout.LayoutParams) this.hKN.hLd.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.hKO = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
