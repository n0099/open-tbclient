package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public abstract class b {
    protected boolean gKA;
    protected g gKy;
    protected a gKz;
    protected boolean gwh;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes9.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bJP();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bJQ();

    public b(g gVar, Intent intent) {
        this.gKA = true;
        this.gwh = false;
        this.gKy = gVar;
        this.mIntent = intent;
        e BL = d.bJV().BL(this.mIntent.getStringExtra("info_forum_name_text"));
        this.gKA = BL.bJX();
        this.gwh = BL.bJW();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gKy.gKP.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = this.gwh ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds152) : l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds121);
            this.gKy.gKP.setLayoutParams(layoutParams);
        }
        this.gKy.gKO.setVisibility(this.gKA ? 0 : 4);
        if (BL.bJY()) {
            this.gKy.gKO.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.gKy.gKP.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.gKz = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
