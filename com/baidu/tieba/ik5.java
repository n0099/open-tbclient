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
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.switchs.FunnySpriteSwitch;
import com.baidu.tieba.log.TbLog;
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
/* loaded from: classes6.dex */
public final class ik5 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947856406, "Lcom/baidu/tieba/ik5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947856406, "Lcom/baidu/tieba/ik5;");
        }
    }

    @JvmOverloads
    public static final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? g(false, 1, null) : invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
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
                String postNetData = netWork.postNetData();
                if (postNetData == null) {
                    postNetData = "";
                }
                ik5.h(postNetData);
                return Boolean.valueOf((netWork.getNetContext().getResponse().isRequestSuccess() && StringUtils.isNotNull(postNetData)) ? false : false);
            }
            return (Boolean) invokeL.objValue;
        }
    }

    public static final fr6 a(String resPath, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{resPath, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            Intrinsics.checkNotNullParameter(resPath, "resPath");
            fr6 fr6Var = new fr6();
            fr6Var.e(resPath);
            fr6Var.d(z);
            fr6Var.f(i);
            return fr6Var;
        }
        return (fr6) invokeCommon.objValue;
    }

    public static final String c(String spriteTalk, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65539, null, spriteTalk, i, str)) == null) {
            Intrinsics.checkNotNullParameter(spriteTalk, "spriteTalk");
            return "tiebaapp://router/portal?params={\"page\":\"im/funnySprite\",\"pageParams\":{\"spriteType\": \"" + i + "\",spriteTalk: \"" + spriteTalk + "\",forumId: \"" + str + "\"}}";
        }
        return (String) invokeLIL.objValue;
    }

    public static final String b(String spriteTalk, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, spriteTalk, i)) == null) {
            Intrinsics.checkNotNullParameter(spriteTalk, "spriteTalk");
            return c(spriteTalk, i, "");
        }
        return (String) invokeLI.objValue;
    }

    public static final void k(String content, String mMsgKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, content, mMsgKey) == null) {
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(mMsgKey, "mMsgKey");
            if (StringUtils.isNull(content)) {
                return;
            }
            new a(mMsgKey).execute(content);
        }
    }

    public static final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return a;
        }
        return (String) invokeV.objValue;
    }

    @JvmOverloads
    public static final boolean f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65542, null, z)) == null) {
            Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
            if (currentActivity == null || currentActivity.isFinishing()) {
                return false;
            }
            if (currentActivity instanceof k0b) {
                return a2b.j.a().i();
            }
            if ((!z && !FunnySpriteSwitch.Companion.isOn()) || !FunnySpriteResDownloadUtil.k().invoke().booleanValue()) {
                return false;
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public static final void h(String result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, result) == null) {
            Intrinsics.checkNotNullParameter(result, "result");
            try {
                a = new JSONObject(result).optJSONObject("data").optString("msg_key");
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("sendSpriteMsg", "发送接口success：" + a + WebvttCueParser.CHAR_SPACE + result);
            } catch (Exception e) {
                DefaultLog.getInstance().e("sendSpriteMsg", "发送接口数据解析失败");
                BdLog.e(e.getMessage());
            }
        }
    }

    public static final void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, null, i) == null) {
            if (i != 2 && 2 == a2b.j.a().c().a().c && 1 == a2b.j.a().c().b().c && 6 == a2b.j.a().c().c().c) {
                DefaultLog.getInstance().i("SpriteTip", "requestSpriteTip：直播tab不请求轻互动");
            } else {
                l(i);
            }
        }
    }

    public static final void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65548, null, i) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_REQUEST_SPRITE_LOOP);
            httpMessage.addParam("scene", i);
            httpMessage.addParam("sprite_uk", SharedPrefHelper.getInstance().getString("key_funny_sprite_uk", ""));
            httpMessage.addParam("version", SharedPrefHelper.getInstance().getString("key_sprite_speech_version", ""));
            httpMessage.addParam("is_sprite_new_user", SharedPrefHelper.getInstance().getInt("key_sprite_is_new_user", 0));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static /* synthetic */ boolean g(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return f(z);
    }

    public static final void j(String content) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, content) == null) {
            Intrinsics.checkNotNullParameter(content, "content");
            k(content, "");
        }
    }

    public static final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.i("SpriteTip", "tryRequestFirstTip isShowSpriteDialog:" + TbSingleton.getInstance().isShowSpriteDialog);
            if (!TbSingleton.getInstance().isShowSpriteDialog) {
                return false;
            }
            i(3);
            TbSingleton.getInstance().isShowSpriteDialog = false;
            return true;
        }
        return invokeV.booleanValue;
    }
}
