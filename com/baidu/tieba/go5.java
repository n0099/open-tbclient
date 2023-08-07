package com.baidu.tieba;

import android.content.Intent;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.data.ChatRoomEntranceData;
/* loaded from: classes6.dex */
public interface go5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("ImMessageCenter", "ChatFloatEntranceService");

    /* loaded from: classes6.dex */
    public interface a {
    }

    /* loaded from: classes6.dex */
    public interface b {
        void D1(long j, String str, boolean z, boolean z2);

        void H(ChatRoomEntranceData chatRoomEntranceData);

        void H0(boolean z);

        void T0();

        boolean U();

        void V0(MotionEvent motionEvent);

        boolean Z0();

        void destroy();

        void g();

        int getState();

        Fragment i();

        void onActivityResult(int i, int i2, Intent intent);

        boolean q0();

        void q1(boolean z);

        void t1();

        boolean w1(String str);
    }

    void a(@Nullable a aVar);

    @NonNull
    b b(String str, jo5 jo5Var);

    void onChangeSkinType(int i);
}
