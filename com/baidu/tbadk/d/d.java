package com.baidu.tbadk.d;

import android.view.View;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class d extends b {
    private IntentConfig apJ;
    private IntentConfig apK;
    private View.OnClickListener mClickListener;

    @Override // com.baidu.tbadk.d.b
    public void d(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void a(IntentConfig intentConfig) {
        this.apJ = intentConfig;
    }

    public void b(IntentConfig intentConfig) {
        this.apK = intentConfig;
    }

    public IntentConfig be(boolean z) {
        return z ? this.apJ : this.apK;
    }
}
