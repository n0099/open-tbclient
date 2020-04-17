package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public abstract class b {
    protected boolean hgm;
    protected g hvh;
    protected a hvi;
    protected boolean hvj;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes9.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bUA();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bUB();

    public b(g gVar, Intent intent) {
        this.hvj = true;
        this.hgm = false;
        this.hvh = gVar;
        this.mIntent = intent;
        e Du = d.bUG().Du(this.mIntent.getStringExtra("info_forum_name_text"));
        this.hvj = Du.bUI();
        this.hgm = Du.bUH();
        if (Du.bUJ()) {
            ((RelativeLayout.LayoutParams) this.hvh.hvx.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.hvi = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
