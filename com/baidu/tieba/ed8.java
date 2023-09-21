package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public interface ed8 {
    void b(@NonNull String str, @NonNull String str2, @NonNull Map<String, Object> map);

    void c(@NonNull String str, int i);

    void k(@NonNull String str, int i);

    void l(@NonNull String str, @NonNull String str2);

    void n(@NonNull String str, @Nullable Object obj, @Nullable od8 od8Var, @Nullable List<AtSelectData> list, @Nullable Map<String, Integer> map, int i);

    void p(@NonNull AbilityItem abilityItem);
}
