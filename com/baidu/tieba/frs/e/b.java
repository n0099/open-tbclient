package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public abstract class b {
    protected boolean fgu;
    protected g fua;
    protected a fub;
    protected boolean fuc;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes4.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void biq();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bir();

    public b(g gVar, Intent intent) {
        this.fuc = true;
        this.fgu = false;
        this.fua = gVar;
        this.mIntent = intent;
        e vI = d.biw().vI(this.mIntent.getStringExtra("info_forum_name_text"));
        this.fuc = vI.biy();
        this.fgu = vI.bix();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fua.fup.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = this.fgu ? l.h(TbadkCoreApplication.getInst(), d.e.tbds152) : l.h(TbadkCoreApplication.getInst(), d.e.tbds121);
            this.fua.fup.setLayoutParams(layoutParams);
        }
        this.fua.fuo.setVisibility(this.fuc ? 0 : 4);
    }

    public void a(a aVar) {
        this.fub = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
