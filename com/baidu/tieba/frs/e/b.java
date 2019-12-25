package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public abstract class b {
    protected g gFi;
    protected a gFj;
    protected boolean gFk;
    protected boolean gqV;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes6.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bHj();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bHk();

    public b(g gVar, Intent intent) {
        this.gFk = true;
        this.gqV = false;
        this.gFi = gVar;
        this.mIntent = intent;
        e Bl = d.bHp().Bl(this.mIntent.getStringExtra("info_forum_name_text"));
        this.gFk = Bl.bHr();
        this.gqV = Bl.bHq();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gFi.gFz.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = this.gqV ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds152) : l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds121);
            this.gFi.gFz.setLayoutParams(layoutParams);
        }
        this.gFi.gFy.setVisibility(this.gFk ? 0 : 4);
        if (Bl.bHs()) {
            this.gFi.gFy.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.gFi.gFz.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.gFj = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
