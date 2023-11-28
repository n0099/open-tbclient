package com.baidu.tieba;

import android.content.Intent;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.data.ChatRoomEntranceData;
/* loaded from: classes5.dex */
public interface am5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("ImMessageCenter", "ChatFloatEntranceService");

    /* loaded from: classes5.dex */
    public interface a {
    }

    /* loaded from: classes5.dex */
    public interface b {
        void B2(long j, String str, boolean z, boolean z2);

        void E1();

        void G1(MotionEvent motionEvent);

        boolean M1();

        void a0(ChatRoomEntranceData chatRoomEntranceData);

        void destroy();

        int getState();

        void h2(boolean z);

        void j();

        void l1(boolean z);

        Fragment n();

        void n2();

        void onActivityResult(int i, int i2, Intent intent);

        boolean p0();

        boolean r();

        boolean r2(String str);
    }

    void a(@Nullable a aVar);

    @NonNull
    b b(String str, dm5 dm5Var);

    void onChangeSkinType(int i);
}
