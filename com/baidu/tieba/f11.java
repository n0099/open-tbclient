package com.baidu.tieba;

import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final /* synthetic */ class f11 {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        int[] iArr = new int[PlayerStatus.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[PlayerStatus.PREPARED.ordinal()] = 1;
        $EnumSwitchMapping$0[PlayerStatus.COMPLETE.ordinal()] = 2;
    }
}
