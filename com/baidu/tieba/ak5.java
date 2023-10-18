package com.baidu.tieba;

import android.content.Intent;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.data.ChatRoomEntranceData;
/* loaded from: classes5.dex */
public interface ak5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("ImMessageCenter", "ChatFloatEntranceService");

    /* loaded from: classes5.dex */
    public interface a {
    }

    /* loaded from: classes5.dex */
    public interface b {
        boolean E0();

        void G1(boolean z);

        void K1();

        boolean O1(String str);

        void T(ChatRoomEntranceData chatRoomEntranceData);

        void V0(boolean z);

        void X1(long j, String str, boolean z, boolean z2);

        void destroy();

        void g();

        int getState();

        boolean h0();

        void i1();

        Fragment j();

        void k1(MotionEvent motionEvent);

        boolean o1();

        void onActivityResult(int i, int i2, Intent intent);
    }

    void a(@Nullable a aVar);

    @NonNull
    b b(String str, dk5 dk5Var);

    void onChangeSkinType(int i);
}
