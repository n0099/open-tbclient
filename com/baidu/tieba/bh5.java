package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes3.dex */
public interface bh5 extends gh5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("ImMessageCenter", "ChatBoxDialogService");

    void onChangeSkinType(int i);

    void onDestroy();

    void onPause();

    void onResume();
}
