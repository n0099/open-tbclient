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
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 H2\u00020\u0001:\u0001HB\u0013\u0012\n\u00102\u001a\u0006\u0012\u0002\b\u000301¢\u0006\u0004\bF\u0010GJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b\u0005\u0010\bJ\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\nJ\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\nJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\nR\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R*\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R*\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u00128\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010\u0017R\u001f\u0010(\u001a\b\u0012\u0004\u0012\u00020%0\u00128\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0015\u001a\u0004\b(\u0010\u0017R\u001f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00128\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u0015\u001a\u0004\b*\u0010\u0017R\u001d\u00100\u001a\u00020+8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001d\u00102\u001a\u0006\u0012\u0002\b\u0003018\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R*\u00106\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010\u001d\u001a\u0004\b7\u0010\u001f\"\u0004\b8\u0010!R%\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0002090\u00128\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010\u0015\u001a\u0004\b;\u0010\u0017R.\u0010=\u001a\u0004\u0018\u00010<2\b\u0010\u001b\u001a\u0004\u0018\u00010<8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR*\u0010C\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010\u001d\u001a\u0004\bD\u0010\u001f\"\u0004\bE\u0010!¨\u0006I"}, d2 = {"Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/baidu/tieba/card/data/BaseCardInfo;", "data", "", "addData", "(Lcom/baidu/tieba/card/data/BaseCardInfo;)V", "", "(Ljava/util/List;)V", "loadData", "()V", "playLastVideo", "playNextVideo", "", "position", "playVideoAtPosition", "(I)V", "resumePlayVideo", "Landroidx/lifecycle/MutableLiveData;", "Landroid/content/res/Configuration;", "configuration", "Landroidx/lifecycle/MutableLiveData;", "getConfiguration", "()Landroidx/lifecycle/MutableLiveData;", "curPlayingVideoPos", "getCurPlayingVideoPos", "", "value", "from", "Ljava/lang/String;", "getFrom", "()Ljava/lang/String;", "setFrom", "(Ljava/lang/String;)V", "fromTid", "getFromTid", "setFromTid", "", "hasMore", "getHasMore", "isLoading", "loadErrorMsg", "getLoadErrorMsg", "Lcom/baidu/tieba/frs/videomiddlepage/VideoMiddleModel;", "model$delegate", "Lkotlin/Lazy;", "getModel", "()Lcom/baidu/tieba/frs/videomiddlepage/VideoMiddleModel;", "model", "Lcom/baidu/tbadk/TbPageContext;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "getPageContext", "()Lcom/baidu/tbadk/TbPageContext;", "stType", "getStType", "setStType", "", "videoDataList", "getVideoDataList", "Lcom/baidu/tieba/play/monitor/VideoSerializeVideoThreadInfo;", "videoThreadInfo", "Lcom/baidu/tieba/play/monitor/VideoSerializeVideoThreadInfo;", "getVideoThreadInfo", "()Lcom/baidu/tieba/play/monitor/VideoSerializeVideoThreadInfo;", "setVideoThreadInfo", "(Lcom/baidu/tieba/play/monitor/VideoSerializeVideoThreadInfo;)V", "yuelaouLocate", "getYuelaouLocate", "setYuelaouLocate", "<init>", "(Lcom/baidu/tbadk/TbPageContext;)V", "Companion", "frsExtra_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class VideoMiddlePageViewModel extends ViewModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a Companion;
    public static final int LOAD_MORE_LEFT_VIDEO_COUNTS = 3;
    public static final /* synthetic */ KProperty[] n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final MutableLiveData<List<BaseCardInfo>> f51744a;

    /* renamed from: b  reason: collision with root package name */
    public final MutableLiveData<Boolean> f51745b;

    /* renamed from: c  reason: collision with root package name */
    public final MutableLiveData<Boolean> f51746c;

    /* renamed from: d  reason: collision with root package name */
    public final MutableLiveData<String> f51747d;

    /* renamed from: e  reason: collision with root package name */
    public final MutableLiveData<Integer> f51748e;

    /* renamed from: f  reason: collision with root package name */
    public final MutableLiveData<Configuration> f51749f;

    /* renamed from: g  reason: collision with root package name */
    public final Lazy f51750g;

    /* renamed from: h  reason: collision with root package name */
    public String f51751h;

    /* renamed from: i  reason: collision with root package name */
    public String f51752i;

    /* renamed from: j  reason: collision with root package name */
    public String f51753j;
    public VideoSerializeVideoThreadInfo k;
    public String l;
    public final TbPageContext<?> m;

    /* loaded from: classes7.dex */
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
        n = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(VideoMiddlePageViewModel.class), "model", "getModel()Lcom/baidu/tieba/frs/videomiddlepage/VideoMiddleModel;"))};
        Companion = new a(null);
    }

    public VideoMiddlePageViewModel(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = tbPageContext;
        this.f51744a = new MutableLiveData<>();
        this.f51745b = new MutableLiveData<>();
        this.f51746c = new MutableLiveData<>();
        this.f51747d = new MutableLiveData<>();
        this.f51748e = new MutableLiveData<>();
        this.f51749f = new MutableLiveData<>();
        this.f51750g = LazyKt__LazyJVMKt.lazy(new VideoMiddlePageViewModel$model$2(this));
        this.f51751h = "";
        this.f51752i = "";
        this.f51753j = "";
        this.l = "";
        this.f51745b.setValue(Boolean.FALSE);
        this.f51746c.setValue(Boolean.FALSE);
        this.f51744a.setValue(new ArrayList());
        this.f51748e.setValue(0);
    }

    public final void addData(BaseCardInfo baseCardInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, baseCardInfo) == null) {
            List<BaseCardInfo> value = this.f51744a.getValue();
            if (value != null) {
                value.add(baseCardInfo);
            }
            MutableLiveData<List<BaseCardInfo>> mutableLiveData = this.f51744a;
            mutableLiveData.setValue(mutableLiveData.getValue());
        }
    }

    public final MutableLiveData<Configuration> getConfiguration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f51749f : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<Integer> getCurPlayingVideoPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f51748e : (MutableLiveData) invokeV.objValue;
    }

    public final String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public final String getFromTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f51751h : (String) invokeV.objValue;
    }

    public final MutableLiveData<Boolean> getHasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f51746c : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<String> getLoadErrorMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f51747d : (MutableLiveData) invokeV.objValue;
    }

    public final VideoMiddleModel getModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Lazy lazy = this.f51750g;
            KProperty kProperty = n[0];
            return (VideoMiddleModel) lazy.getValue();
        }
        return (VideoMiddleModel) invokeV.objValue;
    }

    public final TbPageContext<?> getPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.m : (TbPageContext) invokeV.objValue;
    }

    public final String getStType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f51753j : (String) invokeV.objValue;
    }

    public final MutableLiveData<List<BaseCardInfo>> getVideoDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f51744a : (MutableLiveData) invokeV.objValue;
    }

    public final VideoSerializeVideoThreadInfo getVideoThreadInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.k : (VideoSerializeVideoThreadInfo) invokeV.objValue;
    }

    public final String getYuelaouLocate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f51752i : (String) invokeV.objValue;
    }

    public final MutableLiveData<Boolean> isLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f51745b : (MutableLiveData) invokeV.objValue;
    }

    public final void loadData() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && Intrinsics.areEqual(this.f51745b.getValue(), Boolean.FALSE)) {
            this.f51745b.setValue(Boolean.TRUE);
            getModel().setFrom(this.l);
            getModel().loadData();
        }
    }

    public final void playLastVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            List<BaseCardInfo> value = this.f51744a.getValue();
            Integer valueOf = value != null ? Integer.valueOf(value.size()) : null;
            Integer value2 = this.f51748e.getValue();
            if (valueOf == null || valueOf.intValue() <= 0 || value2 == null || value2.intValue() <= 0) {
                return;
            }
            MutableLiveData<Integer> mutableLiveData = this.f51748e;
            Integer value3 = mutableLiveData.getValue();
            mutableLiveData.setValue(value3 != null ? Integer.valueOf(value3.intValue() - 1) : null);
        }
    }

    public final void playNextVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            List<BaseCardInfo> value = this.f51744a.getValue();
            Integer valueOf = value != null ? Integer.valueOf(value.size()) : null;
            Integer value2 = this.f51748e.getValue();
            if (valueOf == null || valueOf.intValue() <= 0 || value2 == null || value2.intValue() >= valueOf.intValue() - 1) {
                return;
            }
            MutableLiveData<Integer> mutableLiveData = this.f51748e;
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
            List<BaseCardInfo> value = this.f51744a.getValue();
            Integer valueOf = value != null ? Integer.valueOf(value.size()) : null;
            Integer value2 = this.f51748e.getValue();
            if (valueOf == null || valueOf.intValue() <= 0 || Intrinsics.compare(i2, valueOf.intValue()) >= 0) {
                return;
            }
            this.f51748e.setValue(Integer.valueOf(i2));
            if (value2 == null || (valueOf.intValue() - 1) - value2.intValue() > 3) {
                return;
            }
            loadData();
        }
    }

    public final void resumePlayVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            Integer value = this.f51748e.getValue();
            if (value == null) {
                value = 0;
            }
            playVideoAtPosition(value.intValue());
        }
    }

    public final void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.l = str;
            getModel().setFrom(str);
        }
    }

    public final void setFromTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.f51751h = str;
            getModel().B(str);
        }
    }

    public final void setStType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.f51753j = str;
            getModel().D(str);
        }
    }

    public final void setVideoThreadInfo(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, videoSerializeVideoThreadInfo) == null) {
            this.k = videoSerializeVideoThreadInfo;
            getModel().E(videoSerializeVideoThreadInfo);
        }
    }

    public final void setYuelaouLocate(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.f51752i = str;
            getModel().C(str);
        }
    }

    public final void addData(List<? extends BaseCardInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            List<BaseCardInfo> value = this.f51744a.getValue();
            if (value != null) {
                value.addAll(list);
            }
            MutableLiveData<List<BaseCardInfo>> mutableLiveData = this.f51744a;
            mutableLiveData.setValue(mutableLiveData.getValue());
        }
    }
}
