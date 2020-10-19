package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public abstract class b {
    protected g iOw;
    protected a iOx;
    protected boolean iOy;
    protected boolean iyx;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes22.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void czn();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void czo();

    public b(g gVar, Intent intent) {
        this.iOy = true;
        this.iyx = false;
        this.iOw = gVar;
        this.mIntent = intent;
        e Kh = d.czt().Kh(this.mIntent.getStringExtra("info_forum_name_text"));
        this.iOy = Kh.czv();
        this.iyx = Kh.czu();
        if (Kh.czw()) {
            ((RelativeLayout.LayoutParams) this.iOw.iOM.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.iOx = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
