package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public abstract class b {
    protected boolean fCx;
    protected g fQF;
    protected a fQG;
    protected boolean fQH;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes4.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void brZ();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bsa();

    public b(g gVar, Intent intent) {
        this.fQH = true;
        this.fCx = false;
        this.fQF = gVar;
        this.mIntent = intent;
        e xF = d.bsf().xF(this.mIntent.getStringExtra("info_forum_name_text"));
        this.fQH = xF.bsh();
        this.fCx = xF.bsg();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fQF.fQV.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = this.fCx ? l.g(TbadkCoreApplication.getInst(), R.dimen.tbds152) : l.g(TbadkCoreApplication.getInst(), R.dimen.tbds121);
            this.fQF.fQV.setLayoutParams(layoutParams);
        }
        this.fQF.fQU.setVisibility(this.fQH ? 0 : 4);
        if (xF.bsi()) {
            this.fQF.fQU.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.fQF.fQV.getLayoutParams()).topMargin = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.fQG = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
