package com.baidu.tieba;

import android.content.Context;
import android.location.Address;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.s0.s.q.z1;
import c.a.t0.t3.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.message.SignMessage;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tieba.signall.SignAllForumActivity;
import com.baidu.tieba.signall.SignAllForumAdvertActivity;
import com.baidu.tieba.supplementSign.SupplementSignActivity;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class SignStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes12.dex */
    public static class a implements CustomMessageTask.CustomRunnable<ForumData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<ForumData> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                SignData signData = null;
                if (customMessage != null && customMessage.getData() != null) {
                    ForumData data = customMessage.getData();
                    String name = data.getName();
                    String id = data.getId();
                    if (name != null && name.length() > 0 && id != null && id.length() > 0) {
                        Context context = TbadkCoreApplication.getInst().getContext();
                        TiebaStatic.eventStat(context, "sign_start_time", System.currentTimeMillis() + "");
                        Context context2 = TbadkCoreApplication.getInst().getContext();
                        TiebaStatic.eventStat(context2, "sign_do_time", System.currentTimeMillis() + "");
                        SignMessage signMessage = new SignMessage();
                        try {
                            Context context3 = TbadkCoreApplication.getInst().getContext();
                            TiebaStatic.eventStat(context3, "sign_do_time", System.currentTimeMillis() + "");
                            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.SIGN_ADDRESS);
                            netWork.addPostData(TiebaStatic.Params.H5_FORUM_NAME, name);
                            netWork.addPostData("fid", id);
                            if (!TextUtils.isEmpty(data.getFromPage())) {
                                netWork.addPostData("sign_from", data.getFromPage());
                            }
                            if (!TextUtils.isEmpty(TbSingleton.getInstance().getActivityId())) {
                                netWork.addPostData("activity_id", TbSingleton.getInstance().getActivityId());
                            }
                            if (!TextUtils.isEmpty(TbSingleton.getInstance().getSampleId())) {
                                netWork.addPostData(TiebaStatic.Params.SAMPLE_ID, TbSingleton.getInstance().getSampleId());
                            }
                            SignStatic.a(netWork);
                            netWork.getNetContext().getRequest().mIsNeedTbs = true;
                            netWork.setNeedSig(true);
                            String postNetData = netWork.postNetData();
                            if (netWork.isNetSuccess()) {
                                if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                                    signData = new SignData();
                                    signData.parserJson(postNetData);
                                    signData.forumId = id;
                                    signData.forumName = name;
                                } else if (!m.isEmpty(postNetData)) {
                                    JSONObject jSONObject = new JSONObject(postNetData);
                                    signMessage.parserJson(netWork, jSONObject);
                                    if (AntiHelper.l(netWork.getServerErrorCode()) || "199901".equals(jSONObject.optString("error_code"))) {
                                        signData = new SignData();
                                        signData.parserJson(postNetData);
                                        signData.is_signed = 1;
                                        signData.count_sign_num = 1;
                                        signData.sign_bonus_point = 0;
                                        signData.forumId = id;
                                        signData.forumName = name;
                                    }
                                } else {
                                    signMessage.parserJson(netWork, null);
                                }
                                signMessage.signData = signData;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                        TbSingleton.getInstance().setActivityId("");
                        return signMessage;
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class b implements CustomMessageTask.CustomRunnable<c.a.t0.t3.h.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<c.a.t0.t3.h.c> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && (customMessage.getData() instanceof z1)) {
                    new e().f((z1) customMessage.getData());
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class c implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr != null && strArr.length != 0) {
                    String str = strArr[0];
                    if (!StringUtils.isNull(str) && str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_ONE_KEY_SIGN)) {
                        SignAllForumActivityConfig signAllForumActivityConfig = new SignAllForumActivityConfig(tbPageContext.getPageActivity());
                        if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                            tbPageContext.sendMessage(new CustomMessage(2002001, signAllForumActivityConfig));
                            return 0;
                        } else if (tbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                            tbPageContext.sendMessage(new CustomMessage(2002001, signAllForumActivityConfig));
                            return 0;
                        }
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1745083294, "Lcom/baidu/tieba/SignStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1745083294, "Lcom/baidu/tieba/SignStatic;");
                return;
            }
        }
        TbadkCoreApplication.getInst().RegisterIntent(SupplementSignActivityConfig.class, SupplementSignActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(SignAllForumActivityConfig.class, SignAllForumActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(SignAllForumAdvertActivityConfig.class, SignAllForumAdvertActivity.class);
        b();
        d();
        c();
    }

    public SignStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a(NetWork netWork) {
        Address j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, netWork) == null) {
            String locationLng = TbadkCoreApplication.getInst().getLocationLng();
            String locationLat = TbadkCoreApplication.getInst().getLocationLat();
            if ((TextUtils.isEmpty(locationLat) || TextUtils.isEmpty(locationLng)) && (j2 = c.a.d.f.i.a.n().j(false)) != null) {
                locationLng = String.valueOf(j2.getLongitude());
                locationLat = String.valueOf(j2.getLatitude());
            }
            if (TextUtils.isEmpty(locationLat) || TextUtils.isEmpty(locationLng)) {
                return;
            }
            netWork.addPostData("location", locationLng + "," + locationLat);
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            UrlManager.getInstance().addListener(new c());
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921663, new b());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001425, new a());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }
}
