package com.baidu.tieba;

import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final /* synthetic */ class ay0 {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        int[] iArr = new int[AdDownloadStatus.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[AdDownloadStatus.NONE.ordinal()] = 1;
        $EnumSwitchMapping$0[AdDownloadStatus.DOWNLOADING.ordinal()] = 2;
    }
}
