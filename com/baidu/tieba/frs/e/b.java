package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public abstract class b {
    protected boolean jcx;
    protected g jvf;
    protected a jvg;
    protected boolean jvh;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes22.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cJO();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cJP();

    public b(g gVar, Intent intent) {
        this.jvh = true;
        this.jcx = false;
        this.jvf = gVar;
        this.mIntent = intent;
        e LF = d.cJU().LF(this.mIntent.getStringExtra("info_forum_name_text"));
        this.jvh = LF.cJW();
        this.jcx = LF.cJV();
        if (LF.cJX()) {
            ((RelativeLayout.LayoutParams) this.jvf.jvv.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.jvg = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
