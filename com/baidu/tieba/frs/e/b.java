package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public abstract class b {
    protected g gIx;
    protected a gIy;
    protected boolean gIz;
    protected boolean gue;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes7.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bIl();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bIm();

    public b(g gVar, Intent intent) {
        this.gIz = true;
        this.gue = false;
        this.gIx = gVar;
        this.mIntent = intent;
        e Bv = d.bIr().Bv(this.mIntent.getStringExtra("info_forum_name_text"));
        this.gIz = Bv.bIt();
        this.gue = Bv.bIs();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gIx.gIO.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = this.gue ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds152) : l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds121);
            this.gIx.gIO.setLayoutParams(layoutParams);
        }
        this.gIx.gIN.setVisibility(this.gIz ? 0 : 4);
        if (Bv.bIu()) {
            this.gIx.gIN.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.gIx.gIO.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.gIy = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
