package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public abstract class b {
    protected g gKK;
    protected a gKL;
    protected boolean gKM;
    protected boolean gwt;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes9.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bJQ();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bJR();

    public b(g gVar, Intent intent) {
        this.gKM = true;
        this.gwt = false;
        this.gKK = gVar;
        this.mIntent = intent;
        e BM = d.bJW().BM(this.mIntent.getStringExtra("info_forum_name_text"));
        this.gKM = BM.bJY();
        this.gwt = BM.bJX();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gKK.gLb.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = this.gwt ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds152) : l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds121);
            this.gKK.gLb.setLayoutParams(layoutParams);
        }
        this.gKK.gLa.setVisibility(this.gKM ? 0 : 4);
        if (BM.bJZ()) {
            this.gKK.gLa.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.gKK.gLb.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.gKL = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
