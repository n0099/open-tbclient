package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.data.ChatRoomEntranceData;
/* loaded from: classes4.dex */
public interface gi5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("ImMessageCenter", "ChatFloatEntranceService");

    /* loaded from: classes4.dex */
    public interface a {
    }

    /* loaded from: classes4.dex */
    public interface b {
        void N0();

        void R0();

        void c();

        Fragment d();

        void destroy();

        int getState();

        boolean j0();

        void k1(boolean z);

        void n1();

        boolean q1(String str);

        void x1(long j, String str, boolean z, boolean z2);

        void z(ChatRoomEntranceData chatRoomEntranceData);
    }

    void a(@Nullable a aVar);

    @NonNull
    b b(String str, ji5 ji5Var);

    void onChangeSkinType(int i);
}
