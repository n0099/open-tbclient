package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public abstract class b {
    protected g gLP;
    protected a gLQ;
    protected boolean gLR;
    protected boolean gxc;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes9.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bKd();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bKe();

    public b(g gVar, Intent intent) {
        this.gLR = true;
        this.gxc = false;
        this.gLP = gVar;
        this.mIntent = intent;
        e BL = d.bKj().BL(this.mIntent.getStringExtra("info_forum_name_text"));
        this.gLR = BL.bKl();
        this.gxc = BL.bKk();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gLP.gMg.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = this.gxc ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds152) : l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds121);
            this.gLP.gMg.setLayoutParams(layoutParams);
        }
        this.gLP.gMf.setVisibility(this.gLR ? 0 : 4);
        if (BL.bKm()) {
            this.gLP.gMf.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.gLP.gMg.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.gLQ = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
