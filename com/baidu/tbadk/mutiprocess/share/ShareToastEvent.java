package com.baidu.tbadk.mutiprocess.share;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.mutiprocess.SerializableEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/tbadk/mutiprocess/share/ShareToastEvent;", "Lcom/baidu/tbadk/mutiprocess/SerializableEvent;", "toastStr", "", "toastIcon", "Lcom/baidu/tbadk/core/dialog/BdToast$ToastIcon;", "(Ljava/lang/String;Lcom/baidu/tbadk/core/dialog/BdToast$ToastIcon;)V", "getToastIcon", "()Lcom/baidu/tbadk/core/dialog/BdToast$ToastIcon;", "getToastStr", "()Ljava/lang/String;", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ShareToastEvent extends SerializableEvent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdToast.ToastIcon toastIcon;
    public final String toastStr;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShareToastEvent() {
        this(null, null, 3, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((String) objArr[0], (BdToast.ToastIcon) objArr[1], ((Integer) objArr[2]).intValue(), (DefaultConstructorMarker) objArr[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public ShareToastEvent(String toastStr, BdToast.ToastIcon toastIcon) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {toastStr, toastIcon};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(toastStr, "toastStr");
        this.toastStr = toastStr;
        this.toastIcon = toastIcon;
        setType(3);
    }

    public /* synthetic */ ShareToastEvent(String str, BdToast.ToastIcon toastIcon, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : toastIcon);
    }

    public final BdToast.ToastIcon getToastIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.toastIcon;
        }
        return (BdToast.ToastIcon) invokeV.objValue;
    }

    public final String getToastStr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.toastStr;
        }
        return (String) invokeV.objValue;
    }
}
