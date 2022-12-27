package com.baidu.tieba;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Nullable;
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
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class dl5 {
    public static /* synthetic */ Interceptable $ic;
    @Nullable
    public static PostWriteCallBackData a;
    @Nullable
    public static d35 b;
    @Nullable
    public static WriteData c;
    @Nullable
    public static AntiData d;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
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

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
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

    public static boolean c(int i, int i2, @Nullable Intent intent) {
        InterceptResult invokeIIL;
        boolean z;
        PostWriteCallBackData postWriteCallBackData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65538, null, i, i2, intent)) == null) {
            if (i != 12006) {
                return false;
            }
            if (i2 == -1 && intent != null) {
                z = true;
            } else {
                z = false;
            }
            if (a != null && b != null && c != null && d != null && z) {
                try {
                    postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                } catch (Exception e) {
                    BdLog.e(e);
                    postWriteCallBackData = null;
                }
                if (postWriteCallBackData == null) {
                    return false;
                }
                hu8.k().h(true, postWriteCallBackData, b, c, d);
            } else {
                hu8.k().h(false, a, null, c, d);
            }
            a = null;
            b = null;
            c = null;
            d = null;
            return true;
        }
        return invokeIIL.booleanValue;
    }

    public static boolean d(@Nullable PostWriteCallBackData postWriteCallBackData, @Nullable d35 d35Var, @Nullable WriteData writeData, @Nullable AntiData antiData) {
        InterceptResult invokeLLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, postWriteCallBackData, d35Var, writeData, antiData)) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null && writeData != null && d35Var != null && !TextUtils.isEmpty(d35Var.c())) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                a = postWriteCallBackData;
                b = d35Var;
                c = writeData;
                d = antiData;
                writeData.setVcodeMD5(d35Var.b());
                writeData.setVcodeUrl(d35Var.c());
                writeData.setVcodeExtra(d35Var.a());
                if (b(d35Var.d())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(currentActivity, 12006, writeData, false, d35Var.d())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(currentActivity, writeData, 12006)));
                }
            }
            return z;
        }
        return invokeLLLL.booleanValue;
    }
}
