package com.baidu.tieba.easterEgg;

import android.app.Fragment;
import d.a.j0.g0.a;
/* loaded from: classes4.dex */
public class ActivityLifeCycleListener extends Fragment {
    @Override // android.app.Fragment
    public void onStop() {
        a.f().e();
        super.onStop();
    }
}
