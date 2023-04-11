package com.baidu.tieba;

import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.data.ChatRoomEntranceData;
/* loaded from: classes4.dex */
public interface hi5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("ImMessageCenter", "ChatFloatEntranceService");

    /* loaded from: classes4.dex */
    public interface a {
    }

    /* loaded from: classes4.dex */
    public interface b {
        void C(ChatRoomEntranceData chatRoomEntranceData);

        void P0();

        void R0(MotionEvent motionEvent);

        void U0();

        void c();

        Fragment d();

        void destroy();

        int getState();

        boolean m0();

        void m1(boolean z);

        void p1();

        boolean s1(String str);

        void z1(long j, String str, boolean z, boolean z2);
    }

    void a(@Nullable a aVar);

    @NonNull
    b b(String str, ki5 ki5Var);

    void onChangeSkinType(int i);
}
