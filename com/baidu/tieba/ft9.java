package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LcUpdateDialogActivityConfig;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.switchs.LooperBlockSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ft9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ClientUpdateInfo clientUpdateInfo, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, clientUpdateInfo, str) == null) && clientUpdateInfo != null && !TextUtils.isEmpty(str)) {
            if (!LooperBlockSwitch.getIsOn()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), clientUpdateInfo, str)));
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("is_force_update", clientUpdateInfo.mIsForceUpdate);
                jSONObject.put("status", clientUpdateInfo.mStatus);
                jSONObject.put("reverson", clientUpdateInfo.mReverson);
                jSONObject.put("content_url", clientUpdateInfo.mContentUrl);
                jSONObject.put("apk_md5_rsa", str);
            } catch (Exception e) {
                BdLog.e(e);
            }
            a15.o(TbadkCoreApplication.getInst().getApp(), "lcUpdateDialog", jSONObject);
        }
    }

    public static void b(x95 x95Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, x95Var) != null) || x95Var == null) {
            return;
        }
        VersionData u = x95Var.u();
        TbadkCoreApplication.getInst().setVersionData(u);
        TbadkCoreApplication.getInst().refreshNewVersion(true);
        if (u.forceUpdate()) {
            if (x95Var.k() != null && TbadkCoreApplication.getInst().getResumeNum() > 0 && !LooperBlockSwitch.getIsOn()) {
                TbSingleton.getInstance();
                TbSingleton.setExceptInsertAdDiaShow(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), u, x95Var.j())));
                return;
            }
            return;
        }
        Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
        Long valueOf2 = Long.valueOf(new Date().getTime());
        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && u.getStrategy() == 0 && x95Var.k() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
            TbSingleton.getInstance().setSyncModel(x95Var);
            if (TbSingleton.getInstance().hasPerformedFirstLoginTest() && !LooperBlockSwitch.getIsOn()) {
                TbSingleton.getInstance();
                TbSingleton.setExceptInsertAdDiaShow(true);
                ky5.d();
            }
            TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
        }
    }

    public static void c(VersionData versionData, ClientUpdateInfo clientUpdateInfo, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{versionData, clientUpdateInfo, str, Boolean.valueOf(z)}) != null) || versionData == null) {
            return;
        }
        TbadkCoreApplication.getInst().setVersionData(versionData);
        TbadkCoreApplication.getInst().refreshNewVersion(true);
        if (TbadkCoreApplication.getInst().getResumeNum() > 0) {
            if (versionData.forceUpdate()) {
                a(clientUpdateInfo, str);
            } else if ((Long.valueOf(new Date().getTime()).longValue() - Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime()).longValue() > 86400000 || z) && versionData.getStrategy() == 0) {
                a(clientUpdateInfo, str);
            }
        }
    }
}
