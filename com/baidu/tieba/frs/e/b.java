package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public abstract class b {
    protected boolean fBJ;
    protected g fPR;
    protected a fPS;
    protected boolean fPT;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes4.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void brM();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void brN();

    public b(g gVar, Intent intent) {
        this.fPT = true;
        this.fBJ = false;
        this.fPR = gVar;
        this.mIntent = intent;
        e xE = d.brS().xE(this.mIntent.getStringExtra("info_forum_name_text"));
        this.fPT = xE.brU();
        this.fBJ = xE.brT();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fPR.fQh.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = this.fBJ ? l.g(TbadkCoreApplication.getInst(), R.dimen.tbds152) : l.g(TbadkCoreApplication.getInst(), R.dimen.tbds121);
            this.fPR.fQh.setLayoutParams(layoutParams);
        }
        this.fPR.fQg.setVisibility(this.fPT ? 0 : 4);
        if (xE.brV()) {
            this.fPR.fQg.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.fPR.fQh.getLayoutParams()).topMargin = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.fPS = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
