package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
/* loaded from: classes5.dex */
public interface ed8 {
    void c(@NonNull cd8 cd8Var);

    void e(@NonNull BaseMsg baseMsg, @NonNull ChatRoomDetail chatRoomDetail);

    void i();

    void onDestroy();
}
