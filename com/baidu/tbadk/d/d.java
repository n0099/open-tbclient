package com.baidu.tbadk.d;

import android.view.View;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class d extends b {
    private View.OnClickListener OS;
    private IntentConfig ase;
    private IntentConfig asf;

    @Override // com.baidu.tbadk.d.b
    public void h(View.OnClickListener onClickListener) {
        this.OS = onClickListener;
    }

    public void a(IntentConfig intentConfig) {
        this.ase = intentConfig;
    }

    public void b(IntentConfig intentConfig) {
        this.asf = intentConfig;
    }

    public IntentConfig bf(boolean z) {
        return z ? this.ase : this.asf;
    }
}
