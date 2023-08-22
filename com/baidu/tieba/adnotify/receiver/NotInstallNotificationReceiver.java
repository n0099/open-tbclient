package com.baidu.tieba.adnotify.receiver;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.UsbAbTestConst;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.ql0;
import com.baidu.tieba.rm0;
import com.baidu.tieba.util.AdApkInstallHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.xiaomi.mipush.sdk.MiPushMessage;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0003J0\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH\u0002Jh\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0002J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0016¨\u0006\u001a"}, d2 = {"Lcom/baidu/tieba/adnotify/receiver/NotInstallNotificationReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "collapseStatusBar", "", "context", "Landroid/content/Context;", "installRemindNotificationClickStat", "source", "", TTDownloadField.TT_DOWNLOAD_URL, "", MiPushMessage.KEY_NOTIFY_TYPE, "apkName", "packageName", "judgeIsFromBusiness", "", "onNotificationClick", "path", "extraParams", "alaArea", "downloadId", "onReceive", "intent", "Landroid/content/Intent;", "Companion", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NotInstallNotificationReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a Companion;
    public static final String INTENT_PARAMS_KEY_APK_NAME = "key_apk_name";
    public static final String INTENT_PARAMS_KEY_DOWNLOAD_DATA_ID = "key_download_data_id";
    public static final String INTENT_PARAMS_KEY_DOWNLOAD_FILE_PATH = "key_download_path";
    public static final String INTENT_PARAMS_KEY_DOWNLOAD_URL = "key_download_url";
    public static final String INTENT_PARAMS_KEY_EXTRA_PARAM = "key_extra_param";
    public static final String INTENT_PARAMS_KEY_NOTIFICATION_ID = "key_notification_id";
    public static final String INTENT_PARAMS_KEY_NOTIFY_TYPE = "key_notify_type";
    public static final String INTENT_PARAMS_KEY_PACKAGE_NAME = "key_package_name";
    public static final String INTENT_PARAMS_KEY_SOURCE = "key_source";
    public static final String RECEIVER_ACTION_CLICK_BUTTON = "com.baidu.tieba.action.install.CLICK_BUTTON";
    public static final String RECEIVER_ACTION_CLICK_ITEM = "com.baidu.tieba.action.install.CLICK_ITEM";
    public static final String RECEIVER_ACTION_REMOVE_ITEM = "com.baidu.tieba.action.install.REMOVE_ITEM";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(194365006, "Lcom/baidu/tieba/adnotify/receiver/NotInstallNotificationReceiver;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(194365006, "Lcom/baidu/tieba/adnotify/receiver/NotInstallNotificationReceiver;");
                return;
            }
        }
        Companion = new a(null);
    }

    private final boolean judgeIsFromBusiness(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i)) == null) ? 5 == i : invokeI.booleanValue;
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

    public NotInstallNotificationReceiver() {
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

    @SuppressLint({"MissingPermission"})
    private final void collapseStatusBar(Context context) {
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
            try {
                Object systemService = context.getSystemService("statusbar");
                if (Build.VERSION.SDK_INT <= 16) {
                    method = systemService.getClass().getMethod("collapse", new Class[0]);
                } else {
                    method = systemService.getClass().getMethod("collapsePanels", new Class[0]);
                }
                Intrinsics.checkNotNullExpressionValue(method, "if (Build.VERSION.SDK_IN…psePanels\")\n            }");
                method.invoke(systemService, new Object[0]);
                context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private final void installRemindNotificationClickStat(int i, String str, String str2, String str3, String str4) {
        String str5;
        String str6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i), str, str2, str3, str4}) == null) {
            StatisticItem addParam = new StatisticItem(CommonStatisticKey.KEY_INSTALL_NOTIFICATION_REMIND_CLICK).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("obj_source", str3).addParam(TiebaStatic.Params.OBJ_URL, str).addParam("obj_name", str4);
            if (Intrinsics.areEqual("notify_type_unactivated", str2)) {
                str5 = "1";
            } else {
                str5 = "2";
            }
            StatisticItem addParam2 = addParam.addParam(TiebaStatic.Params.OBJ_PARAM2, str5);
            if (UbsABTestHelper.isAdNotInstallRemindA()) {
                str6 = UsbAbTestConst.KEY_AD_NOT_INSTALL_REMIND_A;
            } else {
                str6 = UsbAbTestConst.KEY_AD_NOT_INSTALL_REMIND_B;
            }
            TiebaStatic.log(addParam2.addParam(TiebaStatic.Params.OBJ_PARAM3, str6).addParam(TiebaStatic.Params.OBJ_PARAM4, i));
        }
    }

    private final void onNotificationClick(Context context, String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, String str8) {
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{context, str, str2, str3, str4, Integer.valueOf(i), str5, str6, str7, str8}) == null) {
            if (Intrinsics.areEqual("notify_type_uninstall", str3)) {
                AdApkInstallHelper.a.c(str2, new DownloadData(str6));
                str9 = ClogBuilder.LogType.DOWNLOAD_INSTALL.type;
            } else {
                rm0.h(str);
                str9 = ClogBuilder.LogType.OPEN_APP.type;
            }
            collapseStatusBar(context);
            if (str7 == null) {
                str10 = "";
            } else {
                str10 = str7;
            }
            if (str3 == null) {
                str11 = "";
            } else {
                str11 = str3;
            }
            if (str8 == null) {
                str12 = "";
            } else {
                str12 = str8;
            }
            if (str == null) {
                str13 = "";
            } else {
                str13 = str;
            }
            installRemindNotificationClickStat(i, str10, str11, str12, str13);
            if (judgeIsFromBusiness(i)) {
                ql0.f().h(str9, str5, str4, str3);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            String action = intent.getAction();
            if (TextUtils.isEmpty(action)) {
                return;
            }
            int intExtra = intent.getIntExtra("key_notification_id", -1);
            String stringExtra = intent.getStringExtra("key_package_name");
            String stringExtra2 = intent.getStringExtra("key_download_path");
            String stringExtra3 = intent.getStringExtra("key_notify_type");
            String stringExtra4 = intent.getStringExtra("key_extra_param");
            int intExtra2 = intent.getIntExtra("key_source", 0);
            String stringExtra5 = intent.getStringExtra(INTENT_PARAMS_KEY_DOWNLOAD_DATA_ID);
            String stringExtra6 = intent.getStringExtra(INTENT_PARAMS_KEY_DOWNLOAD_URL);
            String stringExtra7 = intent.getStringExtra(INTENT_PARAMS_KEY_APK_NAME);
            if (action != null) {
                int hashCode = action.hashCode();
                if (hashCode != -537987851) {
                    if (hashCode != -474095210) {
                        if (hashCode == -373665438 && action.equals(RECEIVER_ACTION_REMOVE_ITEM)) {
                            if (judgeIsFromBusiness(intExtra2)) {
                                ql0.f().h(ClogBuilder.LogType.FREE_CLICK.type, ClogBuilder.Area.AD_NOTIFICATION_REMOVE.type, stringExtra4, stringExtra3);
                            }
                        }
                    } else if (action.equals(RECEIVER_ACTION_CLICK_ITEM)) {
                        onNotificationClick(context, stringExtra, stringExtra2, stringExtra3, stringExtra4, intExtra2, ClogBuilder.Area.AD_NOTIFICATION_ITEM_CLICK.type, stringExtra5, stringExtra6, stringExtra7);
                    }
                } else if (action.equals(RECEIVER_ACTION_CLICK_BUTTON)) {
                    onNotificationClick(context, stringExtra, stringExtra2, stringExtra3, stringExtra4, intExtra2, ClogBuilder.Area.AD_NOTIFICATION_BTN_CLICK.type, stringExtra5, stringExtra6, stringExtra7);
                    if (intExtra != -1) {
                        ql0.f().a(intExtra);
                    }
                }
            }
        }
    }
}
