package com.baidu.tieba;

import android.support.v4.app.Fragment;
/* loaded from: classes.dex */
public abstract class BaseFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private int f838a = -1;

    @Override // android.support.v4.app.Fragment
    public void n() {
        super.n();
        if (this.f838a != TiebaApplication.g().an()) {
            this.f838a = TiebaApplication.g().an();
            a(this.f838a);
        }
    }

    public void a(int i) {
    }
}
