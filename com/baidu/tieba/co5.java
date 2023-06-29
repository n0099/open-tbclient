package com.baidu.tieba;

import androidx.annotation.WorkerThread;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
/* loaded from: classes5.dex */
public interface co5 {
    @WorkerThread
    void a(long j, int i, String str, IChatRoomEnterListener.ChatRoomInfo chatRoomInfo);
}
