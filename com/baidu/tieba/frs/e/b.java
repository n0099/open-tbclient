package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public abstract class b {
    protected boolean icq;
    protected g ish;
    protected a isi;
    protected boolean isj;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes16.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void csA();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void csB();

    public b(g gVar, Intent intent) {
        this.isj = true;
        this.icq = false;
        this.ish = gVar;
        this.mIntent = intent;
        e IV = d.csG().IV(this.mIntent.getStringExtra("info_forum_name_text"));
        this.isj = IV.csI();
        this.icq = IV.csH();
        if (IV.csJ()) {
            ((RelativeLayout.LayoutParams) this.ish.isx.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.isi = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
