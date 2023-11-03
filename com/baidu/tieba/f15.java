package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public abstract class f15 extends g15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public TBAlertBuilder b;

    public abstract void b(TBAlertBuilder tBAlertBuilder);

    public abstract void d();

    public abstract void e();

    public f15() {
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

    public final Activity c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (Activity) invokeV.objValue;
    }

    public static final void f(f15 this$0, DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, dialogInterface) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.d();
        }
    }

    @Override // com.baidu.tieba.g15
    public void a(Context context, u05 data) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, data) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            if (!(context instanceof Activity)) {
                activity = TbadkApplication.getInst().getCurrentActivity();
            } else {
                activity = (Activity) context;
            }
            this.a = activity;
            if (activity == null) {
                d();
                TbLog yunDialogLog = YunDialogLog.getInstance();
                yunDialogLog.i(YunDialogManager.LOG_KEY, "云弹窗 " + data.a("yun_dialogName") + " 展示失败：当前 activity 为空");
                return;
            }
            Intrinsics.checkNotNull(activity);
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(activity);
            this.b = tBAlertBuilder;
            if (tBAlertBuilder != null) {
                tBAlertBuilder.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.y05
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                            f15.f(f15.this, dialogInterface);
                        }
                    }
                });
                b(tBAlertBuilder);
                e();
            }
        }
    }
}
