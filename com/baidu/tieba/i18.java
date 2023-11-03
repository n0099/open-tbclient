package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.data.DialogStrategiesData;
import com.baidu.tieba.frs.FrsPrivateCommonDialogView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import tbclient.PrivateForumInfo;
/* loaded from: classes6.dex */
public class i18 implements w15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public i18() {
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

    /* JADX WARN: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c() {
        InterceptResult invokeV;
        PrivateForumPopInfoData privateForumPopInfoData;
        ForumData forumData;
        UserData userData;
        ny4 ny4Var;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            String str2 = null;
            if (currentActivity instanceof c25) {
                c25 c25Var = (c25) currentActivity;
                if (c25Var.j1() != null) {
                    b25 j1 = c25Var.j1();
                    forumData = j1.U0();
                    userData = j1.K1();
                    ny4Var = j1.g1();
                    privateForumPopInfoData = j1.j1();
                    kqa frsResponseData = TbSingleton.getInstance().getFrsResponseData();
                    FrsViewData frsViewData = new FrsViewData();
                    frsViewData.receiveData(frsResponseData);
                    if (forumData == null) {
                        forumData = frsViewData.getForum();
                    }
                    if (userData == null) {
                        userData = frsViewData.getUserData();
                    }
                    if (ny4Var == null) {
                        ny4Var = frsViewData.getPrivateForumTotalInfo();
                    }
                    if (privateForumPopInfoData == null) {
                        privateForumPopInfoData = frsViewData.getPrivateForumPopInfo();
                    }
                    if (forumData == null) {
                        str2 = forumData.getName();
                        str = forumData.getId();
                    } else {
                        str = null;
                    }
                    if (!StringUtils.isNull(str2) || StringUtils.isNull(str)) {
                        return false;
                    }
                    if ((ny4Var == null || ny4Var.a() == null || userData.getIs_manager() != 1) && privateForumPopInfoData == null) {
                        return false;
                    }
                    PrivateForumPopInfoData privateForumPopInfoData2 = new PrivateForumPopInfoData();
                    privateForumPopInfoData2.T(ny4Var.c());
                    PrivateForumInfo a = ny4Var.a();
                    if (a != null && a.private_forum_status.intValue() == 1 && (qd.isEmpty(privateForumPopInfoData2.R()) || privateForumPopInfoData2.Q() != JavaTypesHelper.toInt(str, 0))) {
                        privateForumPopInfoData2.W("create_success");
                        privateForumPopInfoData2.X(String.format(e18.a, str, str2));
                        privateForumPopInfoData2.V(JavaTypesHelper.toInt(str, -1));
                        privateForumPopInfoData2.setTitle(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f173f));
                        privateForumPopInfoData2.U(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1740));
                        z = FrsPrivateCommonDialogView.b(privateForumPopInfoData2, false);
                    } else if (privateForumPopInfoData2.Q() == JavaTypesHelper.toInt(str, 0)) {
                        z = FrsPrivateCommonDialogView.b(privateForumPopInfoData2, false);
                    } else {
                        z = false;
                    }
                    if (!z && privateForumPopInfoData != null && privateForumPopInfoData.Q() == JavaTypesHelper.toInt(str, 0)) {
                        return FrsPrivateCommonDialogView.b(privateForumPopInfoData, true);
                    }
                    return z;
                }
            }
            privateForumPopInfoData = null;
            forumData = null;
            userData = null;
            ny4Var = null;
            kqa frsResponseData2 = TbSingleton.getInstance().getFrsResponseData();
            FrsViewData frsViewData2 = new FrsViewData();
            frsViewData2.receiveData(frsResponseData2);
            if (forumData == null) {
            }
            if (userData == null) {
            }
            if (ny4Var == null) {
            }
            if (privateForumPopInfoData == null) {
            }
            if (forumData == null) {
            }
            if (!StringUtils.isNull(str2)) {
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.w15
    @NonNull
    public Map<String, Object> a(@NonNull DialogStrategiesData dialogStrategiesData, @NonNull Map<String, Object> map, @NonNull Map<String, Object> map2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, dialogStrategiesData, map, map2)) == null) {
            HashMap hashMap = new HashMap(map);
            hashMap.put("dialogName", "frsExam");
            hashMap.putAll(map);
            hashMap.putAll(map2);
            return hashMap;
        }
        return (Map) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.w15
    public boolean b(@NonNull Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            return c();
        }
        return invokeL.booleanValue;
    }
}
