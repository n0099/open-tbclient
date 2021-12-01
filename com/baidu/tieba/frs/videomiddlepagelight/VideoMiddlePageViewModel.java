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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u000e\u00105\u001a\u0002062\u0006\u00107\u001a\u00020*J\u0014\u00105\u001a\u0002062\f\u00107\u001a\b\u0012\u0004\u0012\u00020*08J\u0006\u00109\u001a\u000206J\u0006\u0010:\u001a\u000206J\u0006\u0010;\u001a\u000206J\u000e\u0010<\u001a\u0002062\u0006\u0010=\u001a\u00020\u000bJ\u0006\u0010>\u001a\u000206R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\tR\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\tR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\tR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R$\u0010%\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013R\u001d\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0\u0006¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\tR(\u0010-\u001a\u0004\u0018\u00010,2\b\u0010\r\u001a\u0004\u0018\u00010,@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00102\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0011\"\u0004\b4\u0010\u0013¨\u0006@"}, d2 = {"Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;", "Landroidx/lifecycle/ViewModel;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "(Lcom/baidu/tbadk/TbPageContext;)V", "configuration", "Landroidx/lifecycle/MutableLiveData;", "Landroid/content/res/Configuration;", "getConfiguration", "()Landroidx/lifecycle/MutableLiveData;", "curPlayingVideoPos", "", "getCurPlayingVideoPos", "value", "", "from", "getFrom", "()Ljava/lang/String;", "setFrom", "(Ljava/lang/String;)V", "fromTid", "getFromTid", "setFromTid", "hasMore", "", "getHasMore", "isLoading", "loadErrorMsg", "getLoadErrorMsg", "model", "Lcom/baidu/tieba/frs/videomiddlepage/VideoMiddleModel;", "getModel", "()Lcom/baidu/tieba/frs/videomiddlepage/VideoMiddleModel;", "model$delegate", "Lkotlin/Lazy;", "getPageContext", "()Lcom/baidu/tbadk/TbPageContext;", "stType", "getStType", "setStType", "videoDataList", "", "Lcom/baidu/tieba/card/data/BaseCardInfo;", "getVideoDataList", "Lcom/baidu/tieba/play/monitor/VideoSerializeVideoThreadInfo;", "videoThreadInfo", "getVideoThreadInfo", "()Lcom/baidu/tieba/play/monitor/VideoSerializeVideoThreadInfo;", "setVideoThreadInfo", "(Lcom/baidu/tieba/play/monitor/VideoSerializeVideoThreadInfo;)V", "yuelaouLocate", "getYuelaouLocate", "setYuelaouLocate", "addData", "", "data", "", "loadData", "playLastVideo", "playNextVideo", "playVideoAtPosition", "position", "resumePlayVideo", "Companion", "frsExtra_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes10.dex */
public final class VideoMiddlePageViewModel extends ViewModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a Companion;
    public static final int LOAD_MORE_LEFT_VIDEO_COUNTS = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public final MutableLiveData<List<BaseCardInfo>> f44754b;

    /* renamed from: c  reason: collision with root package name */
    public final MutableLiveData<Boolean> f44755c;

    /* renamed from: d  reason: collision with root package name */
    public final MutableLiveData<Boolean> f44756d;

    /* renamed from: e  reason: collision with root package name */
    public final MutableLiveData<String> f44757e;

    /* renamed from: f  reason: collision with root package name */
    public final MutableLiveData<Integer> f44758f;

    /* renamed from: g  reason: collision with root package name */
    public final MutableLiveData<Configuration> f44759g;

    /* renamed from: h  reason: collision with root package name */
    public final Lazy f44760h;

    /* renamed from: i  reason: collision with root package name */
    public String f44761i;

    /* renamed from: j  reason: collision with root package name */
    public String f44762j;

    /* renamed from: k  reason: collision with root package name */
    public String f44763k;
    public VideoSerializeVideoThreadInfo l;
    public String m;

    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-516975788, "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-516975788, "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;");
                return;
            }
        }
        Companion = new a(null);
    }

    public VideoMiddlePageViewModel(TbPageContext<?> pageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        this.a = pageContext;
        this.f44754b = new MutableLiveData<>();
        this.f44755c = new MutableLiveData<>();
        this.f44756d = new MutableLiveData<>();
        this.f44757e = new MutableLiveData<>();
        this.f44758f = new MutableLiveData<>();
        this.f44759g = new MutableLiveData<>();
        this.f44760h = LazyKt__LazyJVMKt.lazy(new VideoMiddlePageViewModel$model$2(this));
        this.f44761i = "";
        this.f44762j = "";
        this.f44763k = "";
        this.m = "";
        this.f44755c.setValue(Boolean.FALSE);
        this.f44756d.setValue(Boolean.FALSE);
        this.f44754b.setValue(new ArrayList());
        this.f44758f.setValue(0);
    }

    public final void addData(BaseCardInfo data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            List<BaseCardInfo> value = this.f44754b.getValue();
            if (value != null) {
                value.add(data);
            }
            MutableLiveData<List<BaseCardInfo>> mutableLiveData = this.f44754b;
            mutableLiveData.setValue(mutableLiveData.getValue());
        }
    }

    public final MutableLiveData<Configuration> getConfiguration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f44759g : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<Integer> getCurPlayingVideoPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f44758f : (MutableLiveData) invokeV.objValue;
    }

    public final String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    public final String getFromTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f44761i : (String) invokeV.objValue;
    }

    public final MutableLiveData<Boolean> getHasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f44756d : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<String> getLoadErrorMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f44757e : (MutableLiveData) invokeV.objValue;
    }

    public final VideoMiddleModel getModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (VideoMiddleModel) this.f44760h.getValue() : (VideoMiddleModel) invokeV.objValue;
    }

    public final TbPageContext<?> getPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a : (TbPageContext) invokeV.objValue;
    }

    public final String getStType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f44763k : (String) invokeV.objValue;
    }

    public final MutableLiveData<List<BaseCardInfo>> getVideoDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f44754b : (MutableLiveData) invokeV.objValue;
    }

    public final VideoSerializeVideoThreadInfo getVideoThreadInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.l : (VideoSerializeVideoThreadInfo) invokeV.objValue;
    }

    public final String getYuelaouLocate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f44762j : (String) invokeV.objValue;
    }

    public final MutableLiveData<Boolean> isLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f44755c : (MutableLiveData) invokeV.objValue;
    }

    public final void loadData() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && Intrinsics.areEqual(this.f44755c.getValue(), Boolean.FALSE)) {
            this.f44755c.setValue(Boolean.TRUE);
            getModel().setFrom(this.m);
            getModel().loadData();
        }
    }

    public final void playLastVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            List<BaseCardInfo> value = this.f44754b.getValue();
            Integer valueOf = value == null ? null : Integer.valueOf(value.size());
            Integer value2 = this.f44758f.getValue();
            if (valueOf == null || valueOf.intValue() <= 0 || value2 == null || value2.intValue() <= 0) {
                return;
            }
            MutableLiveData<Integer> mutableLiveData = this.f44758f;
            Integer value3 = mutableLiveData.getValue();
            mutableLiveData.setValue(value3 != null ? Integer.valueOf(value3.intValue() - 1) : null);
        }
    }

    public final void playNextVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            List<BaseCardInfo> value = this.f44754b.getValue();
            Integer valueOf = value == null ? null : Integer.valueOf(value.size());
            Integer value2 = this.f44758f.getValue();
            if (valueOf == null || valueOf.intValue() <= 0 || value2 == null || value2.intValue() >= valueOf.intValue() - 1) {
                return;
            }
            MutableLiveData<Integer> mutableLiveData = this.f44758f;
            Integer value3 = mutableLiveData.getValue();
            mutableLiveData.setValue(value3 != null ? Integer.valueOf(value3.intValue() + 1) : null);
            if ((valueOf.intValue() - 1) - value2.intValue() <= 3) {
                loadData();
            }
        }
    }

    public final void playVideoAtPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            List<BaseCardInfo> value = this.f44754b.getValue();
            Integer valueOf = value == null ? null : Integer.valueOf(value.size());
            Integer value2 = this.f44758f.getValue();
            if (valueOf == null || valueOf.intValue() <= 0 || i2 >= valueOf.intValue()) {
                return;
            }
            this.f44758f.setValue(Integer.valueOf(i2));
            if (value2 == null || (valueOf.intValue() - 1) - value2.intValue() > 3) {
                return;
            }
            loadData();
        }
    }

    public final void resumePlayVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            Integer value = this.f44758f.getValue();
            if (value == null) {
                value = 0;
            }
            playVideoAtPosition(value.intValue());
        }
    }

    public final void setFrom(String value) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, value) == null) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.m = value;
            getModel().setFrom(value);
        }
    }

    public final void setFromTid(String value) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, value) == null) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.f44761i = value;
            getModel().B(value);
        }
    }

    public final void setStType(String value) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, value) == null) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.f44763k = value;
            getModel().D(value);
        }
    }

    public final void setVideoThreadInfo(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, videoSerializeVideoThreadInfo) == null) {
            this.l = videoSerializeVideoThreadInfo;
            getModel().E(videoSerializeVideoThreadInfo);
        }
    }

    public final void setYuelaouLocate(String value) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, value) == null) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.f44762j = value;
            getModel().C(value);
        }
    }

    public final void addData(List<? extends BaseCardInfo> data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            List<BaseCardInfo> value = this.f44754b.getValue();
            if (value != null) {
                value.addAll(data);
            }
            MutableLiveData<List<BaseCardInfo>> mutableLiveData = this.f44754b;
            mutableLiveData.setValue(mutableLiveData.getValue());
        }
    }
}
