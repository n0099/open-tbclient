package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
/* loaded from: classes6.dex */
public interface gm8 {
    void a(@NonNull em8 em8Var);

    void d();

    void e(@NonNull BaseItem<? extends TbBaseMsg> baseItem, @NonNull ChatRoomDetail chatRoomDetail);

    void f(@NonNull ea8 ea8Var);

    void onDestroy();
}
