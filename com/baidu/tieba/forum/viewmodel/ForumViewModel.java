package com.baidu.tieba.forum.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cj7;
import com.baidu.tieba.si7;
import com.baidu.tieba.ti7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u0010\u0010\tR\u0019\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\"\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/baidu/tieba/forum/viewmodel/ForumViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "firstPageData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/tieba/forum/data/ForumResponseData;", "getFirstPageData", "()Landroidx/lifecycle/MutableLiveData;", "setFirstPageData", "(Landroidx/lifecycle/MutableLiveData;)V", "forumLiveData", "Lcom/baidu/tieba/forum/data/ForumData;", "getForumLiveData", "setForumLiveData", "isInEditMode", "", "setInEditMode", "navSecondFloorEntranceRedDotVisibility", "getNavSecondFloorEntranceRedDotVisibility", "writeButtonData", "Lcom/baidu/tieba/forum/data/WriteButtonData;", "getWriteButtonData", "setWriteButtonData", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ForumViewModel extends ViewModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MutableLiveData<si7> a;
    public MutableLiveData<ti7> b;
    public MutableLiveData<cj7> c;
    public MutableLiveData<Boolean> d;
    public final MutableLiveData<Boolean> e;

    public ForumViewModel() {
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
        this.a = new MutableLiveData<>();
        this.b = new MutableLiveData<>();
        this.c = new MutableLiveData<>();
        this.d = new MutableLiveData<>(Boolean.FALSE);
        this.e = new MutableLiveData<>(null);
    }

    public final MutableLiveData<ti7> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<si7> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<Boolean> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<cj7> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<Boolean> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (MutableLiveData) invokeV.objValue;
    }
}
