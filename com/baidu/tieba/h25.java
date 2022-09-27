package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes4.dex */
public interface h25 {
    boolean a();

    int b();

    void c();

    Dialog d(int i, TbPageContext tbPageContext, am5 am5Var, boolean z);

    NavigationBarCoverTip e(Activity activity, ViewGroup viewGroup);

    void f(int i, TbPageContext tbPageContext, ViewGroup viewGroup, boolean z);

    int g();

    void h(boolean z, long j);

    void i(boolean z, int i, int i2);
}
