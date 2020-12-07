package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public abstract class b {
    protected boolean jcv;
    protected g jvd;
    protected a jve;
    protected boolean jvf;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes22.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cJN();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cJO();

    public b(g gVar, Intent intent) {
        this.jvf = true;
        this.jcv = false;
        this.jvd = gVar;
        this.mIntent = intent;
        e LF = d.cJT().LF(this.mIntent.getStringExtra("info_forum_name_text"));
        this.jvf = LF.cJV();
        this.jcv = LF.cJU();
        if (LF.cJW()) {
            ((RelativeLayout.LayoutParams) this.jvd.jvt.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.jve = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
