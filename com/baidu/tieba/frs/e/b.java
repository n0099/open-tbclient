package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public abstract class b {
    protected boolean fDB;
    protected g fRP;
    protected a fRQ;
    protected boolean fRR;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes4.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bpQ();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bpR();

    public b(g gVar, Intent intent) {
        this.fRR = true;
        this.fDB = false;
        this.fRP = gVar;
        this.mIntent = intent;
        e ww = d.bpW().ww(this.mIntent.getStringExtra("info_forum_name_text"));
        this.fRR = ww.bpY();
        this.fDB = ww.bpX();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fRP.fSf.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = this.fDB ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds152) : l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds121);
            this.fRP.fSf.setLayoutParams(layoutParams);
        }
        this.fRP.fSe.setVisibility(this.fRR ? 0 : 4);
        if (ww.bpZ()) {
            this.fRP.fSe.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.fRP.fSf.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.fRQ = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
