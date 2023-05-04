package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public interface f88 {
    void b(@NonNull String str, @NonNull String str2, @NonNull Map<String, Object> map);

    void e(@NonNull String str, int i);

    void g(@NonNull String str, @Nullable Object obj, @Nullable c68 c68Var, @Nullable List<AtSelectData> list, @Nullable Map<String, Integer> map, int i);

    void i(@NonNull String str, int i);

    void l(@NonNull String str, @NonNull String str2);

    void m(@NonNull AbilityItem abilityItem);
}
