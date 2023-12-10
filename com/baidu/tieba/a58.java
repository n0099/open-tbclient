package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.BdToastData;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.core.util.BdToastHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a58 extends m15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(a58 a58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                YunDialogManager.unMarkShowingDialogName("frsToast");
            }
        }
    }

    public a58() {
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

    @Override // com.baidu.tieba.m15
    public void a(@NonNull Context context, @NonNull a15 a15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, a15Var) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof i25) {
                i25 i25Var = (i25) currentActivity;
                if (i25Var.i1() != null) {
                    if (i25Var.i1().W() == null) {
                        YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "Frs Toast展示失败：当前Frs数据为空");
                        YunDialogManager.unMarkShowingDialogName("frsToast");
                        return;
                    }
                    String stringExtra = currentActivity.getIntent().getStringExtra(FrsActivityConfig.TOAST_DATA);
                    if (TextUtils.isEmpty(stringExtra)) {
                        YunDialogManager.unMarkShowingDialogName("frsToast");
                        return;
                    }
                    BdToastData bdToastData = new BdToastData();
                    try {
                        bdToastData.parserJson(new JSONObject(stringExtra));
                        BdToastHelper.toast(bdToastData);
                        currentActivity.getIntent().putExtra(FrsActivityConfig.TOAST_DATA, "");
                        SafeHandler.getInst().postDelayed(new a(this), 3000L);
                        return;
                    } catch (JSONException e) {
                        YunDialogManager.unMarkShowingDialogName("frsToast");
                        BdLog.e(e);
                        return;
                    }
                }
            }
            YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "Frs Toast展示失败：获取到的IForumDialogExtSupport为空");
            YunDialogManager.unMarkShowingDialogName("frsToast");
        }
    }
}
