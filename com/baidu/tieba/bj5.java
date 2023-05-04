package com.baidu.tieba;

import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.data.ChatRoomEntranceData;
/* loaded from: classes3.dex */
public interface bj5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("ImMessageCenter", "ChatFloatEntranceService");

    /* loaded from: classes3.dex */
    public interface a {
    }

    /* loaded from: classes3.dex */
    public interface b {
        void A1(long j, String str, boolean z, boolean z2);

        void F(ChatRoomEntranceData chatRoomEntranceData);

        void Q0();

        void S0(MotionEvent motionEvent);

        boolean V0();

        void d();

        void destroy();

        Fragment e();

        int getState();

        boolean n0();

        void n1(boolean z);

        void q1();

        boolean t1(String str);
    }

    void a(@Nullable a aVar);

    @NonNull
    b b(String str, ej5 ej5Var);

    void onChangeSkinType(int i);
}
