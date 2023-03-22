package com.baidu.tieba;

import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.data.ChatRoomEntranceData;
/* loaded from: classes4.dex */
public interface dh5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("ImMessageCenter", "ChatFloatEntranceService");

    /* loaded from: classes4.dex */
    public interface a {
    }

    /* loaded from: classes4.dex */
    public interface b {
        void N0();

        void O0(MotionEvent motionEvent);

        void S0();

        void c();

        Fragment d();

        void destroy();

        int getState();

        boolean j0();

        void l1(boolean z);

        void o1();

        boolean r1(String str);

        void u(ChatRoomEntranceData chatRoomEntranceData);

        void z1(long j, String str, boolean z, boolean z2);
    }

    void a(@Nullable a aVar);

    @NonNull
    b b(String str, gh5 gh5Var);

    void onChangeSkinType(int i);
}
