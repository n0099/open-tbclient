package com.baidu.tieba.frs.videomiddlepagelight;

import android.content.res.Configuration;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u000e\u00105\u001a\u0002062\u0006\u00107\u001a\u00020*J\u0014\u00105\u001a\u0002062\f\u00107\u001a\b\u0012\u0004\u0012\u00020*08J\u0006\u00109\u001a\u000206J\u0006\u0010:\u001a\u000206J\u0006\u0010;\u001a\u000206J\u000e\u0010<\u001a\u0002062\u0006\u0010=\u001a\u00020\u000bJ\u0006\u0010>\u001a\u000206R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\tR\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\tR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\tR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R$\u0010%\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013R\u001d\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0\u0006¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\tR(\u0010-\u001a\u0004\u0018\u00010,2\b\u0010\r\u001a\u0004\u0018\u00010,@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00102\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0011\"\u0004\b4\u0010\u0013¨\u0006@"}, d2 = {"Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;", "Landroidx/lifecycle/ViewModel;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "(Lcom/baidu/tbadk/TbPageContext;)V", "configuration", "Landroidx/lifecycle/MutableLiveData;", "Landroid/content/res/Configuration;", "getConfiguration", "()Landroidx/lifecycle/MutableLiveData;", "curPlayingVideoPos", "", "getCurPlayingVideoPos", "value", "", "from", "getFrom", "()Ljava/lang/String;", "setFrom", "(Ljava/lang/String;)V", "fromTid", "getFromTid", "setFromTid", "hasMore", "", "getHasMore", "isLoading", "loadErrorMsg", "getLoadErrorMsg", "model", "Lcom/baidu/tieba/frs/videomiddlepage/VideoMiddleModel;", "getModel", "()Lcom/baidu/tieba/frs/videomiddlepage/VideoMiddleModel;", "model$delegate", "Lkotlin/Lazy;", "getPageContext", "()Lcom/baidu/tbadk/TbPageContext;", "stType", "getStType", "setStType", "videoDataList", "", "Lcom/baidu/tieba/card/data/BaseCardInfo;", "getVideoDataList", "Lcom/baidu/tieba/play/monitor/VideoSerializeVideoThreadInfo;", "videoThreadInfo", "getVideoThreadInfo", "()Lcom/baidu/tieba/play/monitor/VideoSerializeVideoThreadInfo;", "setVideoThreadInfo", "(Lcom/baidu/tieba/play/monitor/VideoSerializeVideoThreadInfo;)V", "yuelaouLocate", "getYuelaouLocate", "setYuelaouLocate", "addData", "", "data", "", "loadData", "playLastVideo", "playNextVideo", "playVideoAtPosition", "position", "resumePlayVideo", "Companion", "frsExtra_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class VideoMiddlePageViewModel extends ViewModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public final MutableLiveData<List<BaseCardInfo>> f32915b;

    /* renamed from: c  reason: collision with root package name */
    public final MutableLiveData<Boolean> f32916c;

    /* renamed from: d  reason: collision with root package name */
    public final MutableLiveData<Boolean> f32917d;

    /* renamed from: e  reason: collision with root package name */
    public final MutableLiveData<String> f32918e;

    /* renamed from: f  reason: collision with root package name */
    public final MutableLiveData<Integer> f32919f;

    /* renamed from: g  reason: collision with root package name */
    public final MutableLiveData<Configuration> f32920g;

    /* renamed from: h  reason: collision with root package name */
    public final Lazy f32921h;
    public String i;
    public String j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-516975788, "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-516975788, "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;");
        }
    }

    public VideoMiddlePageViewModel(TbPageContext<?> pageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        this.a = pageContext;
        this.f32915b = new MutableLiveData<>();
        this.f32916c = new MutableLiveData<>();
        this.f32917d = new MutableLiveData<>();
        this.f32918e = new MutableLiveData<>();
        this.f32919f = new MutableLiveData<>();
        this.f32920g = new MutableLiveData<>();
        this.f32921h = LazyKt__LazyJVMKt.lazy(new VideoMiddlePageViewModel$model$2(this));
        this.i = "";
        this.j = "";
        this.f32916c.setValue(Boolean.FALSE);
        this.f32917d.setValue(Boolean.FALSE);
        this.f32915b.setValue(new ArrayList());
        this.f32919f.setValue(0);
    }

    public final void a(List<? extends BaseCardInfo> data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            List<BaseCardInfo> value = this.f32915b.getValue();
            if (value != null) {
                value.addAll(data);
            }
            MutableLiveData<List<BaseCardInfo>> mutableLiveData = this.f32915b;
            mutableLiveData.setValue(mutableLiveData.getValue());
        }
    }

    public final MutableLiveData<Configuration> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32920g : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<Integer> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32919f : (MutableLiveData) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.i : (String) invokeV.objValue;
    }

    public final MutableLiveData<Boolean> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f32917d : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<String> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f32918e : (MutableLiveData) invokeV.objValue;
    }

    public final VideoMiddleModel h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (VideoMiddleModel) this.f32921h.getValue() : (VideoMiddleModel) invokeV.objValue;
    }

    public final TbPageContext<?> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a : (TbPageContext) invokeV.objValue;
    }

    public final MutableLiveData<List<BaseCardInfo>> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f32915b : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<Boolean> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f32916c : (MutableLiveData) invokeV.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && Intrinsics.areEqual(this.f32916c.getValue(), Boolean.FALSE)) {
            this.f32916c.setValue(Boolean.TRUE);
            h().setFrom(this.j);
            h().loadData();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            List<BaseCardInfo> value = this.f32915b.getValue();
            Integer valueOf = value == null ? null : Integer.valueOf(value.size());
            Integer value2 = this.f32919f.getValue();
            if (valueOf == null || valueOf.intValue() <= 0 || value2 == null || value2.intValue() <= 0) {
                return;
            }
            MutableLiveData<Integer> mutableLiveData = this.f32919f;
            Integer value3 = mutableLiveData.getValue();
            mutableLiveData.setValue(value3 != null ? Integer.valueOf(value3.intValue() - 1) : null);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<BaseCardInfo> value = this.f32915b.getValue();
            Integer valueOf = value == null ? null : Integer.valueOf(value.size());
            Integer value2 = this.f32919f.getValue();
            if (valueOf == null || valueOf.intValue() <= 0 || value2 == null || value2.intValue() >= valueOf.intValue() - 1) {
                return;
            }
            MutableLiveData<Integer> mutableLiveData = this.f32919f;
            Integer value3 = mutableLiveData.getValue();
            mutableLiveData.setValue(value3 != null ? Integer.valueOf(value3.intValue() + 1) : null);
            if ((valueOf.intValue() - 1) - value2.intValue() <= 3) {
                l();
            }
        }
    }

    public final void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            List<BaseCardInfo> value = this.f32915b.getValue();
            Integer valueOf = value == null ? null : Integer.valueOf(value.size());
            Integer value2 = this.f32919f.getValue();
            if (valueOf == null || valueOf.intValue() <= 0 || i >= valueOf.intValue()) {
                return;
            }
            this.f32919f.setValue(Integer.valueOf(i));
            if (value2 == null || (valueOf.intValue() - 1) - value2.intValue() > 3) {
                return;
            }
            l();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            Integer value = this.f32919f.getValue();
            if (value == null) {
                value = 0;
            }
            o(value.intValue());
        }
    }

    public final void q(String value) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, value) == null) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.j = value;
            h().setFrom(value);
        }
    }

    public final void r(String value) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, value) == null) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.i = value;
            h().D(value);
        }
    }

    public final void s(String value) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, value) == null) {
            Intrinsics.checkNotNullParameter(value, "value");
            h().F(value);
        }
    }

    public final void t(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, videoSerializeVideoThreadInfo) == null) {
            h().G(videoSerializeVideoThreadInfo);
        }
    }

    public final void u(String value) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, value) == null) {
            Intrinsics.checkNotNullParameter(value, "value");
            h().E(value);
        }
    }
}
