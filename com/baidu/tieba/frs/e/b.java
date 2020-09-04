package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public abstract class b {
    protected boolean icw;
    protected g isn;
    protected a iso;
    protected boolean isp;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes16.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void csB();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void csC();

    public b(g gVar, Intent intent) {
        this.isp = true;
        this.icw = false;
        this.isn = gVar;
        this.mIntent = intent;
        e IW = d.csH().IW(this.mIntent.getStringExtra("info_forum_name_text"));
        this.isp = IW.csJ();
        this.icw = IW.csI();
        if (IW.csK()) {
            ((RelativeLayout.LayoutParams) this.isn.isD.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public void a(a aVar) {
        this.iso = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
