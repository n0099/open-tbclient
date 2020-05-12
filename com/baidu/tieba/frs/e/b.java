package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public abstract class b {
    protected boolean hgs;
    protected g hvn;
    protected a hvo;
    protected boolean hvp;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes9.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bUA();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bUz();

    public b(g gVar, Intent intent) {
        this.hvp = true;
        this.hgs = false;
        this.hvn = gVar;
        this.mIntent = intent;
        e Dx = d.bUF().Dx(this.mIntent.getStringExtra("info_forum_name_text"));
        this.hvp = Dx.bUH();
        this.hgs = Dx.bUG();
        if (Dx.bUI()) {
            ((RelativeLayout.LayoutParams) this.hvn.hvD.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.hvo = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
