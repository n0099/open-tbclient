package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.timepicker.pickerview.listener.OnTimeSelectListener;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes5.dex */
public interface fa5 {
    boolean a();

    int b();

    void c();

    Dialog d(int i, TbPageContext tbPageContext, OnTimeSelectListener onTimeSelectListener, boolean z);

    NavigationBarCoverTip e(Activity activity, ViewGroup viewGroup);

    void f(int i, TbPageContext tbPageContext, ViewGroup viewGroup, boolean z);

    int g();

    void h(boolean z, long j);

    void i(boolean z, int i, int i2);
}
