package com.baidu.tieba;

import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
/* loaded from: classes5.dex */
public interface ao5 {
    void a(long j, List<? extends ChatMsg> list, Function1<? super List<? extends ChatMsg>, Unit> function1);

    void onDestroy();
}
