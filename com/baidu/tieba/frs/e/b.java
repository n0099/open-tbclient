package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public abstract class b {
    protected boolean iKT;
    protected g jaS;
    protected a jaT;
    protected boolean jaU;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes22.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cCu();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cCv();

    public b(g gVar, Intent intent) {
        this.jaU = true;
        this.iKT = false;
        this.jaS = gVar;
        this.mIntent = intent;
        e KG = d.cCA().KG(this.mIntent.getStringExtra("info_forum_name_text"));
        this.jaU = KG.cCC();
        this.iKT = KG.cCB();
        if (KG.cCD()) {
            ((RelativeLayout.LayoutParams) this.jaS.jbi.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.jaT = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
