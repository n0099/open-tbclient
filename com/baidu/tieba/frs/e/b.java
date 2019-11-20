package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public abstract class b {
    protected boolean fCK;
    protected g fQY;
    protected a fQZ;
    protected boolean fRa;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes4.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bpO();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bpP();

    public b(g gVar, Intent intent) {
        this.fRa = true;
        this.fCK = false;
        this.fQY = gVar;
        this.mIntent = intent;
        e ww = d.bpU().ww(this.mIntent.getStringExtra("info_forum_name_text"));
        this.fRa = ww.bpW();
        this.fCK = ww.bpV();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fQY.fRo.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = this.fCK ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds152) : l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds121);
            this.fQY.fRo.setLayoutParams(layoutParams);
        }
        this.fQY.fRn.setVisibility(this.fRa ? 0 : 4);
        if (ww.bpX()) {
            this.fQY.fRn.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.fQY.fRo.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.fQZ = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
