package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import java.util.Map;
/* loaded from: classes5.dex */
public interface fm8 extends cm8 {
    void a(@NonNull String str);

    void h();

    void i(boolean z, int i, int i2, @Nullable Map<String, Object> map, boolean z2, int i3, long j, long j2);

    void j(@NonNull String str);

    void k(@NonNull String str, @NonNull CharSequence charSequence);

    void m(@NonNull dm8 dm8Var);

    void n(Object obj);

    void o();

    void onChangeSkinType();

    void onDestroy();

    void p(@NonNull String str, @Nullable String str2);

    void q(int i, int i2, @Nullable String str);

    void r(@Nullable BaseItem baseItem, @Nullable ChatRoomDetail chatRoomDetail);
}
