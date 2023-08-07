package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
/* loaded from: classes5.dex */
public interface dn5 {
    BroadcastReceiver a(@NonNull Context context, @NonNull fn5 fn5Var);

    void b(@NonNull Context context, long j, long j2, int i, long j3, en5 en5Var);

    void c(@NonNull Context context, @NonNull BroadcastReceiver broadcastReceiver);

    void d(@NonNull Context context, @NonNull ChatMsg chatMsg, long j, @NonNull gn5 gn5Var);
}
