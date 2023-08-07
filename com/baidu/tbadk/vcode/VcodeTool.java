package com.baidu.tbadk.vcode;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.jd5;
import com.baidu.tieba.oda;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class VcodeTool {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PAGE_TYPE_DRAG = "5";
    public static final String PAGE_TYPE_ROTATE = "6";
    public static final String PAGE_TYPE_SUDOKU = "4";
    @Nullable
    public static AntiData cachedAntiData;
    @Nullable
    public static PostWriteCallBackData cachedCallbackData;
    @Nullable
    public static jd5 cachedVcodeInfoData;
    @Nullable
    public static WriteData cachedWriteData;
    public transient /* synthetic */ FieldHolder $fh;

    public VcodeTool() {
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

    public static String getJsCallback(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            int indexOf = str.indexOf("(");
            int indexOf2 = str.indexOf(SmallTailInfo.EMOTION_SUFFIX);
            if (indexOf == -1 || indexOf2 == -1 || (i = indexOf + 1) >= indexOf2) {
                return null;
            }
            return str.substring(i, indexOf2);
        }
        return (String) invokeL.objValue;
    }

    public static boolean needVcode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            if (!str.equals("4") && !str.equals("5") && !str.equals("6")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean tryProcessActivityResultOnWriteScene(int i, int i2, @Nullable Intent intent) {
        InterceptResult invokeIIL;
        boolean z;
        PostWriteCallBackData postWriteCallBackData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65539, null, i, i2, intent)) == null) {
            if (i != 12006) {
                return false;
            }
            if (i2 == -1 && intent != null) {
                z = true;
            } else {
                z = false;
            }
            if (cachedCallbackData != null && cachedVcodeInfoData != null && cachedWriteData != null && cachedAntiData != null && z) {
                try {
                    postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                } catch (Exception e) {
                    BdLog.e(e);
                    postWriteCallBackData = null;
                }
                if (postWriteCallBackData == null) {
                    return false;
                }
                oda.k().j(true, postWriteCallBackData, cachedVcodeInfoData, cachedWriteData, cachedAntiData);
            } else {
                oda.k().j(false, cachedCallbackData, null, cachedWriteData, cachedAntiData);
            }
            cachedCallbackData = null;
            cachedVcodeInfoData = null;
            cachedWriteData = null;
            cachedAntiData = null;
            return true;
        }
        return invokeIIL.booleanValue;
    }

    public static boolean tryShowOnWriteScene(@Nullable PostWriteCallBackData postWriteCallBackData, @Nullable jd5 jd5Var, @Nullable WriteData writeData, @Nullable AntiData antiData) {
        InterceptResult invokeLLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, postWriteCallBackData, jd5Var, writeData, antiData)) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null && writeData != null && jd5Var != null && !TextUtils.isEmpty(jd5Var.c())) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                cachedCallbackData = postWriteCallBackData;
                cachedVcodeInfoData = jd5Var;
                cachedWriteData = writeData;
                cachedAntiData = antiData;
                writeData.setVcodeMD5(jd5Var.b());
                writeData.setVcodeUrl(jd5Var.c());
                writeData.setVcodeExtra(jd5Var.a());
                if (needVcode(jd5Var.d())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(currentActivity, 12006, writeData, false, jd5Var.d())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(currentActivity, writeData, 12006)));
                }
            }
            return z;
        }
        return invokeLLLL.booleanValue;
    }
}
