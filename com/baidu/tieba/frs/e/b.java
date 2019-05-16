package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public abstract class b {
    protected g fKQ;
    protected a fKR;
    protected boolean fKS;
    protected boolean fwM;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes4.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bpG();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bpH();

    public b(g gVar, Intent intent) {
        this.fKS = true;
        this.fwM = false;
        this.fKQ = gVar;
        this.mIntent = intent;
        e wX = d.bpM().wX(this.mIntent.getStringExtra("info_forum_name_text"));
        this.fKS = wX.bpO();
        this.fwM = wX.bpN();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fKQ.fLg.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = this.fwM ? l.g(TbadkCoreApplication.getInst(), R.dimen.tbds152) : l.g(TbadkCoreApplication.getInst(), R.dimen.tbds121);
            this.fKQ.fLg.setLayoutParams(layoutParams);
        }
        this.fKQ.fLf.setVisibility(this.fKS ? 0 : 4);
        if (wX.bpP()) {
            this.fKQ.fLf.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.fKQ.fLg.getLayoutParams()).topMargin = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.fKR = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
