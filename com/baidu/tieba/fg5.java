package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
/* loaded from: classes4.dex */
public interface fg5 {
    BroadcastReceiver a(@NonNull Context context, @NonNull hg5 hg5Var);

    void b(@NonNull Context context, long j, long j2, int i, long j3, gg5 gg5Var);

    void c(@NonNull Context context, @NonNull BroadcastReceiver broadcastReceiver);

    void d(@NonNull Context context, @NonNull ChatMsg chatMsg, long j, @NonNull ig5 ig5Var);
}
