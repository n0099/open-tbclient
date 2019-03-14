package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public abstract class b {
    protected boolean fgI;
    protected g fuo;
    protected a fup;
    protected boolean fuq;
    protected Intent mIntent;
    protected int mState = 0;

    /* loaded from: classes4.dex */
    public interface a {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bis();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bit();

    public b(g gVar, Intent intent) {
        this.fuq = true;
        this.fgI = false;
        this.fuo = gVar;
        this.mIntent = intent;
        e vJ = d.biy().vJ(this.mIntent.getStringExtra("info_forum_name_text"));
        this.fuq = vJ.biA();
        this.fgI = vJ.biz();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fuo.fuD.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = this.fgI ? l.h(TbadkCoreApplication.getInst(), d.e.tbds152) : l.h(TbadkCoreApplication.getInst(), d.e.tbds121);
            this.fuo.fuD.setLayoutParams(layoutParams);
        }
        this.fuo.fuC.setVisibility(this.fuq ? 0 : 4);
    }

    public void a(a aVar) {
        this.fup = aVar;
    }

    public int getState() {
        return this.mState;
    }
}
