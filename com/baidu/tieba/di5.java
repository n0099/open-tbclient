package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
/* loaded from: classes4.dex */
public interface di5 {
    BroadcastReceiver a(@NonNull Context context, @NonNull fi5 fi5Var);

    void b(@NonNull Context context, long j, long j2, int i, long j3, ei5 ei5Var);

    void c(@NonNull Context context, @NonNull BroadcastReceiver broadcastReceiver);

    void d(@NonNull Context context, @NonNull ChatMsg chatMsg, long j, @NonNull gi5 gi5Var);
}
