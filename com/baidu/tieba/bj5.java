package com.baidu.tieba;

import android.app.Activity;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.switchs.FunnySpriteSwitch;
import com.baidu.tieba.sprite.FunnySpriteResDownloadUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class bj5 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947646908, "Lcom/baidu/tieba/bj5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947646908, "Lcom/baidu/tieba/bj5;");
        }
    }

    /* loaded from: classes5.dex */
    public static final class a extends BdAsyncTask<String, Integer, Boolean> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(String... params) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, params)) == null) {
                Intrinsics.checkNotNullParameter(params, "params");
                boolean z2 = true;
                if (params.length == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return Boolean.FALSE;
                }
                String str = params[0];
                if (StringUtils.isNull(str)) {
                    return Boolean.FALSE;
                }
                NetWork netWork = new NetWork();
                netWork.setUrl(TbConfig.SERVER_ADDRESS + "c/f/sprite/sendSpriteMsg");
                netWork.addPostData("content", str);
                String result = netWork.postNetData();
                Intrinsics.checkNotNullExpressionValue(result, "result");
                bj5.e(result);
                return Boolean.valueOf((netWork.getNetContext().getResponse().isRequestSuccess() && StringUtils.isNotNull(result)) ? false : false);
            }
            return (Boolean) invokeL.objValue;
        }

        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                super.onPostExecute(Boolean.valueOf(z));
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* bridge */ /* synthetic */ void onPostExecute(Boolean bool) {
            c(bool.booleanValue());
        }
    }

    public static final rn6 a(String resPath, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{resPath, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            Intrinsics.checkNotNullParameter(resPath, "resPath");
            rn6 rn6Var = new rn6();
            rn6Var.d(resPath);
            rn6Var.c(z);
            rn6Var.e(i);
            return rn6Var;
        }
        return (rn6) invokeCommon.objValue;
    }

    public static final String b(String spriteTalk, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, spriteTalk, i)) == null) {
            Intrinsics.checkNotNullParameter(spriteTalk, "spriteTalk");
            return "tiebaapp://router/portal?params={\"page\":\"im/funnySprite\",\"pageParams\":{\"spriteType\": \"" + i + "\",spriteTalk: \"" + spriteTalk + "\"}}";
        }
        return (String) invokeLI.objValue;
    }

    public static final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a;
        }
        return (String) invokeV.objValue;
    }

    public static final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
            if (currentActivity == null || currentActivity.isFinishing()) {
                return false;
            }
            if (currentActivity instanceof iv9) {
                return fx9.d.a().d();
            }
            if (!FunnySpriteSwitch.Companion.isOn() || !FunnySpriteResDownloadUtil.k().invoke().booleanValue() || !new cl8("key_sprite_dialog_disappear").f()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            zk8 defaultLog = DefaultLog.getInstance();
            defaultLog.c("SpriteTip", "tryRequestFirstTip isShowSpriteDialog:" + TbSingleton.getInstance().isShowSpriteDialog);
            if (!TbSingleton.getInstance().isShowSpriteDialog) {
                return false;
            }
            f(3);
            TbSingleton.getInstance().isShowSpriteDialog = false;
            return true;
        }
        return invokeV.booleanValue;
    }

    public static final void e(String result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, result) == null) {
            Intrinsics.checkNotNullParameter(result, "result");
            try {
                a = new JSONObject(result).optJSONObject("data").optString("msg_key");
                zk8 defaultLog = DefaultLog.getInstance();
                defaultLog.c("sendSpriteMsg", "发送接口success：" + a + WebvttCueParser.CHAR_SPACE + result);
            } catch (Exception e) {
                DefaultLog.getInstance().b("sendSpriteMsg", "发送接口数据解析失败");
                BdLog.e(e.getMessage());
            }
        }
    }

    public static final void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, null, i) == null) {
            if (i != 2 && 2 == fx9.d.a().b().a().c && 1 == fx9.d.a().b().b().c && 6 == fx9.d.a().b().c().c) {
                DefaultLog.getInstance().c("SpriteTip", "requestSpriteTip：直播tab不请求轻互动");
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_REQUEST_SPRITE_LOOP);
            httpMessage.addParam("scene", i);
            httpMessage.addParam("sprite_uk", o65.m().s("key_funny_sprite_uk", ""));
            httpMessage.addParam("version", o65.m().s("key_sprite_speech_version", ""));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static final void g(String content) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, content) == null) {
            Intrinsics.checkNotNullParameter(content, "content");
            if (StringUtils.isNull(content)) {
                return;
            }
            new a().execute(content);
        }
    }
}
