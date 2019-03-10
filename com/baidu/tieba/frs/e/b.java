package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public abstract class b {
    protected boolean fgJ;
    protected g fup;
    protected a fuq;
    protected boolean fur;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes4.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bit();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void biu();

    public b(g gVar, Intent intent) {
        this.fur = true;
        this.fgJ = false;
        this.fup = gVar;
        this.mIntent = intent;
        e vL = d.biz().vL(this.mIntent.getStringExtra("info_forum_name_text"));
        this.fur = vL.biB();
        this.fgJ = vL.biA();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fup.fuE.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = this.fgJ ? l.h(TbadkCoreApplication.getInst(), d.e.tbds152) : l.h(TbadkCoreApplication.getInst(), d.e.tbds121);
            this.fup.fuE.setLayoutParams(layoutParams);
        }
        this.fup.fuD.setVisibility(this.fur ? 0 : 4);
    }

    public void a(a aVar) {
        this.fuq = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
