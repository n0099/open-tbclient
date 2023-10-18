package com.baidu.tbadk.coreExtra.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.util.DataExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/tbadk/coreExtra/model/ResponseToastLogic;", "", "()V", "exchangeToastString", "", "scene", "json", "Conf", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ResponseToastLogic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-830041508, "Lcom/baidu/tbadk/coreExtra/model/ResponseToastLogic;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-830041508, "Lcom/baidu/tbadk/coreExtra/model/ResponseToastLogic;");
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÂ\u0003J'\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0005J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/baidu/tbadk/coreExtra/model/ResponseToastLogic$Conf;", "Ljava/io/Serializable;", "show", "", "title", "", "freq", "(ILjava/lang/String;I)V", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", "getTitleByScene", "scene", "hashCode", "shouldShow", "toString", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Conf implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final a Companion;
        public static final String DEFAULT_BRAND = "DEFAULT";
        public static final Map<String, String> DEFAULT_TITLE_MAP;
        public static final String KEY_SP_TIMESTAMP = "_key_sp_timestamp";
        public static final String SCENE_ATTENTION_PB = "AttentionAsyncTask-pb";
        public static final String SCENE_MARK = "MarkAsyncTask";
        public transient /* synthetic */ FieldHolder $fh;
        public final int freq;
        public final int show;
        public final String title;

        private final int component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this.show : invokeV.intValue;
        }

        private final int component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? this.freq : invokeV.intValue;
        }

        public static /* synthetic */ Conf copy$default(Conf conf, int i, String str, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = conf.show;
            }
            if ((i3 & 2) != 0) {
                str = conf.title;
            }
            if ((i3 & 4) != 0) {
                i2 = conf.freq;
            }
            return conf.copy(i, str, i2);
        }

        public final String component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.title : (String) invokeV.objValue;
        }

        public final Conf copy(int i, String title, int i2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), title, Integer.valueOf(i2)})) == null) {
                Intrinsics.checkNotNullParameter(title, "title");
                return new Conf(i, title, i2);
            }
            return (Conf) invokeCommon.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Conf) {
                    Conf conf = (Conf) obj;
                    return this.show == conf.show && Intrinsics.areEqual(this.title, conf.title) && this.freq == conf.freq;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (((this.show * 31) + this.title.hashCode()) * 31) + this.freq : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return "Conf(show=" + this.show + ", title=" + this.title + ", freq=" + this.freq + ')';
            }
            return (String) invokeV.objValue;
        }

        /* loaded from: classes5.dex */
        public static final class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-228108718, "Lcom/baidu/tbadk/coreExtra/model/ResponseToastLogic$Conf;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-228108718, "Lcom/baidu/tbadk/coreExtra/model/ResponseToastLogic$Conf;");
                    return;
                }
            }
            Companion = new a(null);
            DEFAULT_TITLE_MAP = MapsKt__MapsKt.mapOf(TuplesKt.to(SCENE_MARK, "收藏成功"), TuplesKt.to(SCENE_ATTENTION_PB, "关注成功\n并接受TA的精选内容"));
        }

        public Conf(int i, String title, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), title, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(title, "title");
            this.show = i;
            this.title = title;
            this.freq = i2;
        }

        public /* synthetic */ Conf(int i, String str, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, (i3 & 4) != 0 ? -1 : i2);
        }

        public final String getTitle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.title;
            }
            return (String) invokeV.objValue;
        }

        public final String getTitleByScene(String scene) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, scene)) == null) {
                Intrinsics.checkNotNullParameter(scene, "scene");
                if (this.title.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return this.title;
                }
                String str = DEFAULT_TITLE_MAP.get(scene);
                if (str == null) {
                    return "";
                }
                return str;
            }
            return (String) invokeL.objValue;
        }

        public final boolean shouldShow(String scene) {
            InterceptResult invokeL;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, scene)) == null) {
                Intrinsics.checkNotNullParameter(scene, "scene");
                if (this.show != 1 || (i = this.freq) == 0) {
                    return false;
                }
                if (i == -1) {
                    return true;
                }
                SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount(scene + KEY_SP_TIMESTAMP);
                long currentTimeMillis = System.currentTimeMillis();
                long j = sharedPrefHelper.getLong(sharedPrefKeyWithAccount, 0L);
                if (j > 0 && TimeHelper.getDayDifference(currentTimeMillis, j) < this.freq) {
                    return false;
                }
                sharedPrefHelper.putLong(sharedPrefKeyWithAccount, currentTimeMillis);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    @JvmStatic
    public static final String a(String scene, String json) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, scene, json)) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(json, "json");
            Map<String, Object> mapSafe = DataExt.toMapSafe(json);
            String deviceBrand = DeviceInfoUtil.getDeviceBrand();
            Intrinsics.checkNotNullExpressionValue(deviceBrand, "getDeviceBrand()");
            String upperCase = deviceBrand.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            if (!mapSafe.containsKey(upperCase)) {
                upperCase = "DEFAULT";
            }
            Object obj = mapSafe.get(upperCase);
            if (obj == null) {
                return null;
            }
            Conf conf = (Conf) DataExt.toEntity(DataExt.toJson(obj), Conf.class);
            if (!conf.shouldShow(scene)) {
                return null;
            }
            return conf.getTitleByScene(scene);
        }
        return (String) invokeLL.objValue;
    }
}
