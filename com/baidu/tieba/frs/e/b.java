package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public abstract class b {
    protected g gKw;
    protected a gKx;
    protected boolean gKy;
    protected boolean gwf;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes9.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bJN();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bJO();

    public b(g gVar, Intent intent) {
        this.gKy = true;
        this.gwf = false;
        this.gKw = gVar;
        this.mIntent = intent;
        e BL = d.bJT().BL(this.mIntent.getStringExtra("info_forum_name_text"));
        this.gKy = BL.bJV();
        this.gwf = BL.bJU();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gKw.gKN.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = this.gwf ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds152) : l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds121);
            this.gKw.gKN.setLayoutParams(layoutParams);
        }
        this.gKw.gKM.setVisibility(this.gKy ? 0 : 4);
        if (BL.bJW()) {
            this.gKw.gKM.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.gKw.gKN.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.gKx = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
