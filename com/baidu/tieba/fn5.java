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
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class fn5 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947769916, "Lcom/baidu/tieba/fn5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947769916, "Lcom/baidu/tieba/fn5;");
        }
    }

    @JvmOverloads
    public static final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f(false, 1, null) : invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public static final class a extends BdAsyncTask<String, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(String... params) {
            InterceptResult invokeL;
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, params)) == null) {
                Intrinsics.checkNotNullParameter(params, "params");
                boolean z3 = true;
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
                String str2 = this.a;
                if (str2 != null && str2.length() != 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    netWork.addPostData("msg_key", this.a);
                }
                String result = netWork.postNetData();
                Intrinsics.checkNotNullExpressionValue(result, "result");
                fn5.g(result);
                return Boolean.valueOf((netWork.getNetContext().getResponse().isRequestSuccess() && StringUtils.isNotNull(result)) ? false : false);
            }
            return (Boolean) invokeL.objValue;
        }
    }

    public static final es6 a(String resPath, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{resPath, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            Intrinsics.checkNotNullParameter(resPath, "resPath");
            es6 es6Var = new es6();
            es6Var.d(resPath);
            es6Var.c(z);
            es6Var.e(i);
            return es6Var;
        }
        return (es6) invokeCommon.objValue;
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

    @JvmOverloads
    public static final boolean e(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65541, null, z)) == null) {
            Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
            if (currentActivity == null || currentActivity.isFinishing()) {
                return false;
            }
            if (currentActivity instanceof z1a) {
                return w3a.g.a().g();
            }
            if ((!z && !FunnySpriteSwitch.Companion.isOn()) || !FunnySpriteResDownloadUtil.k().invoke().booleanValue() || !new cr8("key_sprite_dialog_disappear").f()) {
                return false;
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public static final void g(String result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, result) == null) {
            Intrinsics.checkNotNullParameter(result, "result");
            try {
                a = new JSONObject(result).optJSONObject("data").optString("msg_key");
                zq8 defaultLog = DefaultLog.getInstance();
                defaultLog.c("sendSpriteMsg", "发送接口success：" + a + WebvttCueParser.CHAR_SPACE + result);
            } catch (Exception e) {
                DefaultLog.getInstance().b("sendSpriteMsg", "发送接口数据解析失败");
                BdLog.e(e.getMessage());
            }
        }
    }

    public static final void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, null, i) == null) {
            if (i != 2 && 2 == w3a.g.a().b().a().c && 1 == w3a.g.a().b().b().c && 6 == w3a.g.a().b().c().c) {
                DefaultLog.getInstance().c("SpriteTip", "requestSpriteTip：直播tab不请求轻互动");
            } else {
                k(i);
            }
        }
    }

    public static final void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65547, null, i) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_REQUEST_SPRITE_LOOP);
            httpMessage.addParam("scene", i);
            httpMessage.addParam("sprite_uk", n95.m().s("key_funny_sprite_uk", ""));
            httpMessage.addParam("version", n95.m().s("key_sprite_speech_version", ""));
            httpMessage.addParam("is_sprite_new_user", n95.m().n("key_sprite_is_new_user", 0));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static /* synthetic */ boolean f(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return e(z);
    }

    public static final void i(String content) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, content) == null) {
            Intrinsics.checkNotNullParameter(content, "content");
            j(content, "");
        }
    }

    public static final void j(String content, String mMsgKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, content, mMsgKey) == null) {
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(mMsgKey, "mMsgKey");
            if (StringUtils.isNull(content)) {
                return;
            }
            new a(mMsgKey).execute(content);
        }
    }

    public static final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            zq8 defaultLog = DefaultLog.getInstance();
            defaultLog.c("SpriteTip", "tryRequestFirstTip isShowSpriteDialog:" + TbSingleton.getInstance().isShowSpriteDialog);
            if (!TbSingleton.getInstance().isShowSpriteDialog) {
                return false;
            }
            h(3);
            TbSingleton.getInstance().isShowSpriteDialog = false;
            return true;
        }
        return invokeV.booleanValue;
    }
}
