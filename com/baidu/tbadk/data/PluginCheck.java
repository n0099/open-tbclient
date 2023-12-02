package com.baidu.tbadk.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.invoke.IInvokeCallback;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.qf;
import com.baidu.tieba.za5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000fH\u0007J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/baidu/tbadk/data/PluginCheck;", "", "()V", "CONFIG_KEY", "", "FLAG_FLUTTER", "FLAG_SDK_CODE", "KEY_SP_CACHE", "RET_LESS_THAN_MIN_VERSION", "", "TOAST_TEXT", "TOAST_TEXT_LOADING", "conf", "Lcom/baidu/tbadk/data/PluginCheck$Conf;", "isSyncParsed", "", "canPass", "pckName", "invokeCallback", "Lcom/baidu/nps/main/invoke/IInvokeCallback;", "tag", "isAfterDownload", "isLessThanMinVersion", "Conf", "Parser", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PluginCheck {
    public static /* synthetic */ Interceptable $ic;
    public static final PluginCheck a;
    public static Conf b;
    public static boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003J\t\u0010\u0019\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/baidu/tbadk/data/PluginCheck$Conf;", "Ljava/io/Serializable;", "hostVersion", "", "walletMinVersion", "flutterMinVersion", "sdkCodeMinVersion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFlutterMinVersion", "()Ljava/lang/String;", "getHostVersion", "getSdkCodeMinVersion", "getWalletMinVersion", "component1", "component2", "component3", "component4", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", "getMinVersion", "", "pckName", "hashCode", "toString", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Conf implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("flutter_min_version")
        public final String flutterMinVersion;
        @SerializedName("host_version")
        public final String hostVersion;
        @SerializedName("sdkcode_min_version")
        public final String sdkCodeMinVersion;
        @SerializedName("wallet_min_version")
        public final String walletMinVersion;

        public static /* synthetic */ Conf copy$default(Conf conf, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = conf.hostVersion;
            }
            if ((i & 2) != 0) {
                str2 = conf.walletMinVersion;
            }
            if ((i & 4) != 0) {
                str3 = conf.flutterMinVersion;
            }
            if ((i & 8) != 0) {
                str4 = conf.sdkCodeMinVersion;
            }
            return conf.copy(str, str2, str3, str4);
        }

        public final String component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.hostVersion : (String) invokeV.objValue;
        }

        public final String component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.walletMinVersion : (String) invokeV.objValue;
        }

        public final String component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.flutterMinVersion : (String) invokeV.objValue;
        }

        public final String component4() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.sdkCodeMinVersion : (String) invokeV.objValue;
        }

        public final Conf copy(String hostVersion, String walletMinVersion, String flutterMinVersion, String sdkCodeMinVersion) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, hostVersion, walletMinVersion, flutterMinVersion, sdkCodeMinVersion)) == null) {
                Intrinsics.checkNotNullParameter(hostVersion, "hostVersion");
                Intrinsics.checkNotNullParameter(walletMinVersion, "walletMinVersion");
                Intrinsics.checkNotNullParameter(flutterMinVersion, "flutterMinVersion");
                Intrinsics.checkNotNullParameter(sdkCodeMinVersion, "sdkCodeMinVersion");
                return new Conf(hostVersion, walletMinVersion, flutterMinVersion, sdkCodeMinVersion);
            }
            return (Conf) invokeLLLL.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Conf) {
                    Conf conf = (Conf) obj;
                    return Intrinsics.areEqual(this.hostVersion, conf.hostVersion) && Intrinsics.areEqual(this.walletMinVersion, conf.walletMinVersion) && Intrinsics.areEqual(this.flutterMinVersion, conf.flutterMinVersion) && Intrinsics.areEqual(this.sdkCodeMinVersion, conf.sdkCodeMinVersion);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? (((((this.hostVersion.hashCode() * 31) + this.walletMinVersion.hashCode()) * 31) + this.flutterMinVersion.hashCode()) * 31) + this.sdkCodeMinVersion.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return "Conf(hostVersion=" + this.hostVersion + ", walletMinVersion=" + this.walletMinVersion + ", flutterMinVersion=" + this.flutterMinVersion + ", sdkCodeMinVersion=" + this.sdkCodeMinVersion + ')';
            }
            return (String) invokeV.objValue;
        }

        public Conf(String hostVersion, String walletMinVersion, String flutterMinVersion, String sdkCodeMinVersion) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hostVersion, walletMinVersion, flutterMinVersion, sdkCodeMinVersion};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(hostVersion, "hostVersion");
            Intrinsics.checkNotNullParameter(walletMinVersion, "walletMinVersion");
            Intrinsics.checkNotNullParameter(flutterMinVersion, "flutterMinVersion");
            Intrinsics.checkNotNullParameter(sdkCodeMinVersion, "sdkCodeMinVersion");
            this.hostVersion = hostVersion;
            this.walletMinVersion = walletMinVersion;
            this.flutterMinVersion = flutterMinVersion;
            this.sdkCodeMinVersion = sdkCodeMinVersion;
        }

        public final String getFlutterMinVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.flutterMinVersion;
            }
            return (String) invokeV.objValue;
        }

        public final String getHostVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.hostVersion;
            }
            return (String) invokeV.objValue;
        }

        public final String getSdkCodeMinVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.sdkCodeMinVersion;
            }
            return (String) invokeV.objValue;
        }

        public final String getWalletMinVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.walletMinVersion;
            }
            return (String) invokeV.objValue;
        }

        public final int getMinVersion(String pckName) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pckName)) == null) {
                Intrinsics.checkNotNullParameter(pckName, "pckName");
                if (StringsKt__StringsKt.contains$default((CharSequence) pckName, (CharSequence) "flutter", false, 2, (Object) null)) {
                    str = this.flutterMinVersion;
                } else if (StringsKt__StringsKt.contains$default((CharSequence) pckName, (CharSequence) "sdkcode", false, 2, (Object) null)) {
                    str = this.sdkCodeMinVersion;
                } else {
                    str = this.walletMinVersion;
                }
                Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
                if (intOrNull == null) {
                    return 0;
                }
                return intOrNull.intValue();
            }
            return invokeL.intValue;
        }
    }

    @Singleton
    @Service
    /* loaded from: classes5.dex */
    public static final class a implements za5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // com.baidu.tieba.za5
        public void parseJson(JSONObject json) {
            String version;
            boolean z;
            Object obj;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, json) == null) {
                Intrinsics.checkNotNullParameter(json, "json");
                try {
                    version = TbConfig.getVersion();
                } catch (Exception e) {
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.e("NpsPlugin", "插件配置数据解析失败" + e.getMessage());
                }
                if (version == null) {
                    return;
                }
                String arrayJson = json.optString("nps_plugins_config");
                Intrinsics.checkNotNullExpressionValue(arrayJson, "arrayJson");
                if (arrayJson.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    PluginCheck pluginCheck = PluginCheck.a;
                    PluginCheck.c = true;
                    return;
                }
                PluginCheck pluginCheck2 = PluginCheck.a;
                Iterator it = DataExt.toEntityList(arrayJson, Conf.class).iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.areEqual(version, ((Conf) obj).getHostVersion())) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                Conf conf = (Conf) obj;
                SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                if (conf == null || (str = DataExt.toJson(conf)) == null) {
                    str = StringUtil.NULL_STRING;
                }
                sharedPrefHelper.putString("key_nps_plugins_config", str);
                PluginCheck.b = (Conf) obj;
                PluginCheck pluginCheck3 = PluginCheck.a;
                PluginCheck.c = true;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1384386168, "Lcom/baidu/tbadk/data/PluginCheck;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1384386168, "Lcom/baidu/tbadk/data/PluginCheck;");
                return;
            }
        }
        a = new PluginCheck();
        Conf conf = null;
        String string = SharedPrefHelper.getInstance().getString("key_nps_plugins_config", null);
        if (string != null) {
            conf = (Conf) DataExt.toEntity(string, Conf.class);
        }
        b = conf;
    }

    public PluginCheck() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (b == null) {
                return false;
            }
            int bundleVersion = NPSPackageManager.getInstance().getBundleVersion(str);
            Conf conf = b;
            Intrinsics.checkNotNull(conf);
            if (bundleVersion >= conf.getMinVersion(str)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @JvmStatic
    public static final boolean c(String pckName, IInvokeCallback iInvokeCallback, String tag, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{pckName, iInvokeCallback, tag, Boolean.valueOf(z)})) == null) {
            Intrinsics.checkNotNullParameter(pckName, "pckName");
            Intrinsics.checkNotNullParameter(tag, "tag");
            if (b == null && !c) {
                TbLog a2 = qf.a.a();
                a2.i(tag, "isDownload:" + z + "，sync配置还未解析完，阻止加载");
                if (iInvokeCallback != null) {
                    iInvokeCallback.onResult(-1400, "插件加载中...", null);
                }
                return false;
            } else if (a.d(pckName)) {
                TbLog a3 = qf.a.a();
                a3.i(tag, "isDownload:" + z + "，命中兜底策略，阻止加载");
                if (iInvokeCallback != null) {
                    iInvokeCallback.onResult(-1400, "插件修复中...", null);
                }
                return false;
            } else {
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }
}
