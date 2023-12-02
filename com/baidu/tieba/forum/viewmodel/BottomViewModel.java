package com.baidu.tieba.forum.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.oi7;
import com.baidu.tieba.wi7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/baidu/tieba/forum/viewmodel/BottomViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "bottomLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/tieba/forum/data/BottomData;", "bubbleData", "Lcom/baidu/tieba/forum/data/GuideBubbleData;", "getBubbleData", "()Landroidx/lifecycle/MutableLiveData;", "bubbleData$delegate", "Lkotlin/Lazy;", "getBottomData", "setBottomData", "", "bottomData", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BottomViewModel extends ViewModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;
    public MutableLiveData<oi7> b;

    public BottomViewModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = LazyKt__LazyJVMKt.lazy(BottomViewModel$bubbleData$2.INSTANCE);
        this.b = new MutableLiveData<>();
    }

    public final MutableLiveData<oi7> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<wi7> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (MutableLiveData) this.a.getValue();
        }
        return (MutableLiveData) invokeV.objValue;
    }

    public final void e(oi7 bottomData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bottomData) == null) {
            Intrinsics.checkNotNullParameter(bottomData, "bottomData");
            this.b.setValue(bottomData);
        }
    }
}
