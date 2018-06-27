package com.baidu.tieba.easterEgg;

import android.app.Fragment;
/* loaded from: classes3.dex */
public class ActivityLifeCycleListener extends Fragment {
    @Override // android.app.Fragment
    public void onStop() {
        b.anp().anq();
        super.onStop();
    }
}
