package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.constants.PlayerStatus;
/* loaded from: classes3.dex */
public interface cx0 {
    void a(@NonNull bw0 bw0Var);

    void d(@NonNull bw0 bw0Var);

    int getExpectOrder();

    @Nullable
    int[] getSubscribeEvent();

    int getType();

    void h(PlayerStatus playerStatus, PlayerStatus playerStatus2);

    void j(@NonNull bw0 bw0Var);

    void k(@NonNull bw0 bw0Var);

    void n(@NonNull bw0 bw0Var);

    void q(@NonNull bw0 bw0Var);
}
