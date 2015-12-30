package com.baidu.tbadk.d;

import android.view.View;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class d extends b {
    private IntentConfig arl;
    private IntentConfig arm;
    private View.OnClickListener mClickListener;

    @Override // com.baidu.tbadk.d.b
    public void d(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void a(IntentConfig intentConfig) {
        this.arl = intentConfig;
    }

    public void b(IntentConfig intentConfig) {
        this.arm = intentConfig;
    }

    public IntentConfig bd(boolean z) {
        return z ? this.arl : this.arm;
    }
}
