package com.baidu.tieba;

import android.support.v4.app.Fragment;
/* loaded from: classes.dex */
public abstract class BaseFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private int f851a = -1;

    @Override // android.support.v4.app.Fragment
    public void o() {
        super.o();
        this.f851a = TiebaApplication.g().ap();
        b(this.f851a);
    }

    public void b(int i) {
    }
}
