package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Environment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.UsbAbTestConst;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.flow.data.ApkDownloadInfoData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.util.AdApkInstallHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Service
/* loaded from: classes6.dex */
public final class h76 implements ph5 {
    public static /* synthetic */ Interceptable $ic;
    public static final b a;
    public static final List<ApkDownloadInfoData> b;
    public static long c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public static int b;
        public static int c;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-792376379, "Lcom/baidu/tieba/h76$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-792376379, "Lcom/baidu/tieba/h76$a;");
                    return;
                }
            }
            a = new a();
        }

        public a() {
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

        public final int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b;
            }
            return invokeV.intValue;
        }

        public final int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return c;
            }
            return invokeV.intValue;
        }

        public final void c(ClogBuilder.LogType logType, ClogBuilder.Area area, hl0 bean) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, logType, area, bean) == null) {
                Intrinsics.checkNotNullParameter(logType, "logType");
                Intrinsics.checkNotNullParameter(area, "area");
                Intrinsics.checkNotNullParameter(bean, "bean");
                ClogBuilder clogBuilder = new ClogBuilder();
                clogBuilder.u(ClogBuilder.Page.POPUP);
                clogBuilder.y(logType);
                clogBuilder.i(area);
                if (!TextUtils.isEmpty(bean.p.a)) {
                    clogBuilder.p(bean.p.a);
                }
                clogBuilder.k(String.valueOf(b));
                clogBuilder.l(String.valueOf(c));
                if (TextUtils.equals(bean.q.o, "reminded_type_uninstall")) {
                    str = "1";
                } else {
                    str = "2";
                }
                clogBuilder.m(str);
                t31.e(clogBuilder);
            }
        }

        public final void d(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                b = i;
            }
        }

        public final void e(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                c = i;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public b() {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947776674, "Lcom/baidu/tieba/h76;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947776674, "Lcom/baidu/tieba/h76;");
                return;
            }
        }
        a = new b(null);
        b = new ArrayList();
    }

    public h76() {
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

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c = System.currentTimeMillis();
            SharedPrefHelper.getInstance().putLong("key_last_not_install_dialog_show_time", c);
        }
    }

    public static final void f(h76 this$0, ApkDownloadInfoData apkDownloadInfoData, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, this$0, apkDownloadInfoData, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.i();
            gl0.b().d(false);
            if (apkDownloadInfoData.isFromBusiness()) {
                a aVar = a.a;
                ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
                ClogBuilder.Area area = ClogBuilder.Area.DIALOG_POSITIVE;
                hl0 adDownloadBean = apkDownloadInfoData.getAdDownloadBean();
                Intrinsics.checkNotNullExpressionValue(adDownloadBean, "data.adDownloadBean");
                aVar.c(logType, area, adDownloadBean);
            }
            if (TextUtils.equals(apkDownloadInfoData.getBackAlertRemindType(), "reminded_type_un_open")) {
                rm0.h(apkDownloadInfoData.getApkPackageName());
            } else {
                AdApkInstallHelper.a.c(apkDownloadInfoData.getApkFile().getAbsolutePath(), null);
            }
            this$0.d(apkDownloadInfoData);
        }
    }

    public static final void g(h76 this$0, vh5 processCallBack, ApkDownloadInfoData apkDownloadInfoData, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, this$0, processCallBack, apkDownloadInfoData, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(processCallBack, "$processCallBack");
            this$0.i();
            gl0.b().d(false);
            processCallBack.a();
            if (apkDownloadInfoData.isFromBusiness()) {
                a aVar = a.a;
                ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
                ClogBuilder.Area area = ClogBuilder.Area.DIALOG_NEGATIVE;
                hl0 adDownloadBean = apkDownloadInfoData.getAdDownloadBean();
                Intrinsics.checkNotNullExpressionValue(adDownloadBean, "data.adDownloadBean");
                aVar.c(logType, area, adDownloadBean);
            }
        }
    }

    public static final boolean h(h76 this$0, ApkDownloadInfoData apkDownloadInfoData, Activity activity, vh5 processCallBack, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{this$0, apkDownloadInfoData, activity, processCallBack, dialogInterface, Integer.valueOf(i), keyEvent})) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(activity, "$activity");
            Intrinsics.checkNotNullParameter(processCallBack, "$processCallBack");
            a aVar = a.a;
            aVar.d(aVar.a() + 1);
            this$0.i();
            if (apkDownloadInfoData.isFromBusiness()) {
                a aVar2 = a.a;
                ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
                ClogBuilder.Area area = ClogBuilder.Area.DIALOG_KEYBACK;
                hl0 adDownloadBean = apkDownloadInfoData.getAdDownloadBean();
                Intrinsics.checkNotNullExpressionValue(adDownloadBean, "data.adDownloadBean");
                aVar2.c(logType, area, adDownloadBean);
            }
            if (gl0.b().a(activity)) {
                gl0.b().e(activity, System.currentTimeMillis());
                processCallBack.a();
            } else {
                processCallBack.b();
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.tieba.ph5
    public void a(final Activity activity, final vh5 processCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, processCallBack) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(processCallBack, "processCallBack");
            a aVar = a.a;
            aVar.d(aVar.a() + 1);
            c = SharedPrefHelper.getInstance().getLong("key_last_not_install_dialog_show_time", 0L);
            if (System.currentTimeMillis() - c < 600000) {
                processCallBack.a();
                return;
            }
            final ApkDownloadInfoData c2 = c();
            if (c2 == null) {
                processCallBack.a();
                return;
            }
            c76 c76Var = new c76(activity);
            c76Var.b(false);
            c76Var.c(false);
            c76Var.d(c2);
            c76Var.i(new View.OnClickListener() { // from class: com.baidu.tieba.f76
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        h76.f(h76.this, c2, view2);
                    }
                }
            });
            c76Var.e(new View.OnClickListener() { // from class: com.baidu.tieba.g76
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        h76.g(h76.this, processCallBack, c2, view2);
                    }
                }
            });
            c76Var.g(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.e76
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    InterceptResult invokeLIL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) ? h76.h(h76.this, c2, activity, processCallBack, dialogInterface, i, keyEvent) : invokeLIL.booleanValue;
                }
            });
            c76Var.k();
            e(c2);
            a aVar2 = a.a;
            aVar2.e(aVar2.b() + 1);
            gl0.b().d(true);
            if (c2.isFromBusiness() && c2.getAdDownloadBean() != null) {
                a aVar3 = a.a;
                ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_SHOW;
                ClogBuilder.Area area = ClogBuilder.Area.DIALOG;
                hl0 adDownloadBean = c2.getAdDownloadBean();
                Intrinsics.checkNotNullExpressionValue(adDownloadBean, "data.adDownloadBean");
                aVar3.c(logType, area, adDownloadBean);
            }
        }
    }

    @Override // com.baidu.tieba.ph5
    public void b(ApkDownloadInfoData data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (data.getApkFile() != null && data.getApkFile().exists() && !TextUtils.isEmpty(data.getApkName())) {
                b.add(data);
            }
        }
    }

    public final ApkDownloadInfoData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ApkDownloadInfoData apkDownloadInfoData = null;
            if (d31.g(b)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            d31.m(b);
            Iterator<ApkDownloadInfoData> it = b.iterator();
            ApkDownloadInfoData apkDownloadInfoData2 = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ApkDownloadInfoData next = it.next();
                if (next != null) {
                    String apkPackageName = next.getApkPackageName();
                    boolean c2 = rm0.c(apkPackageName);
                    boolean exists = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + apkPackageName).exists();
                    if (c2) {
                        if (exists) {
                            arrayList.add(next);
                        } else {
                            arrayList.add(next);
                            next.setBackAlertRemindType("reminded_type_un_open");
                            apkDownloadInfoData = next;
                            break;
                        }
                    } else if (rm0.g(next.getApkFile()) && apkDownloadInfoData2 == null) {
                        next.setBackAlertRemindType("reminded_type_uninstall");
                        arrayList.add(next);
                        apkDownloadInfoData2 = next;
                    }
                }
            }
            b.removeAll(arrayList);
            if (apkDownloadInfoData != null) {
                return apkDownloadInfoData;
            }
            return apkDownloadInfoData2;
        }
        return (ApkDownloadInfoData) invokeV.objValue;
    }

    public final void d(ApkDownloadInfoData apkDownloadInfoData) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, apkDownloadInfoData) == null) {
            StatisticItem addParam = new StatisticItem(CommonStatisticKey.KEY_INSTALL_EXIT_DIALOG_REMIND_CLICK).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("obj_source", apkDownloadInfoData.getApkName()).addParam(TiebaStatic.Params.OBJ_URL, apkDownloadInfoData.getDownloadUrl()).addParam("obj_name", apkDownloadInfoData.getApkPackageName());
            if (TextUtils.equals(apkDownloadInfoData.getBackAlertRemindType(), "reminded_type_uninstall")) {
                str = "2";
            } else {
                str = "1";
            }
            StatisticItem addParam2 = addParam.addParam(TiebaStatic.Params.OBJ_PARAM2, str);
            if (UbsABTestHelper.isAdNotInstallRemindA()) {
                str2 = UsbAbTestConst.KEY_AD_NOT_INSTALL_REMIND_A;
            } else {
                str2 = UsbAbTestConst.KEY_AD_NOT_INSTALL_REMIND_B;
            }
            TiebaStatic.log(addParam2.addParam(TiebaStatic.Params.OBJ_PARAM3, str2).addParam(TiebaStatic.Params.OBJ_PARAM4, apkDownloadInfoData.getItemSource()));
        }
    }

    public final void e(ApkDownloadInfoData apkDownloadInfoData) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, apkDownloadInfoData) == null) {
            StatisticItem addParam = new StatisticItem(CommonStatisticKey.KEY_INSTALL_EXIT_DIALOG_REMIND_SHOW).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("obj_source", apkDownloadInfoData.getApkName()).addParam(TiebaStatic.Params.OBJ_URL, apkDownloadInfoData.getDownloadUrl()).addParam("obj_name", apkDownloadInfoData.getApkPackageName());
            if (TextUtils.equals(apkDownloadInfoData.getBackAlertRemindType(), "reminded_type_uninstall")) {
                str = "2";
            } else {
                str = "1";
            }
            StatisticItem addParam2 = addParam.addParam(TiebaStatic.Params.OBJ_PARAM2, str);
            if (UbsABTestHelper.isAdNotInstallRemindA()) {
                str2 = UsbAbTestConst.KEY_AD_NOT_INSTALL_REMIND_A;
            } else {
                str2 = UsbAbTestConst.KEY_AD_NOT_INSTALL_REMIND_B;
            }
            TiebaStatic.log(addParam2.addParam(TiebaStatic.Params.OBJ_PARAM3, str2).addParam(TiebaStatic.Params.OBJ_PARAM4, apkDownloadInfoData.getItemSource()));
        }
    }
}
