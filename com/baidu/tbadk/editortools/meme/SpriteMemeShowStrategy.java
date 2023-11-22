package com.baidu.tbadk.editortools.meme;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.meme.muti.MutiSpriteMemeEvent;
import com.baidu.tbadk.mutiprocess.MutiProcessManager;
import com.baidu.tieba.bu5;
import com.baidu.tieba.ca;
import com.baidu.tieba.fu5;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.pf5;
import com.baidu.tieba.yz4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n*\u0001\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u0012J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\b\u0010\u0019\u001a\u00020\rH\u0002J\u0006\u0010\u001a\u001a\u00020\rJ\b\u0010\u001b\u001a\u00020\rH\u0002J\u000e\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u001d\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J\b\u0010\u001f\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006 "}, d2 = {"Lcom/baidu/tbadk/editortools/meme/SpriteMemeShowStrategy;", "", "()V", "CACHE_KEY", "", "config", "Lcom/baidu/tbadk/editortools/meme/SpriteMemeShowConfigData;", "getConfig", "()Lcom/baidu/tbadk/editortools/meme/SpriteMemeShowConfigData;", "config$delegate", "Lkotlin/Lazy;", "currentAccount", "isReadingCache", "", "mAccountChangeListener", "com/baidu/tbadk/editortools/meme/SpriteMemeShowStrategy$mAccountChangeListener$1", "Lcom/baidu/tbadk/editortools/meme/SpriteMemeShowStrategy$mAccountChangeListener$1;", "clickSpriteMeme", "", "getShowConfigGap", "", "getShowConfigTimes", "", "init", "initConfigWithCache", "isLogin", "isNeedShowMemes", "isSameCycle", "mutiSyncConfig", "mutiSyncLoginState", "account", "updateCache", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SpriteMemeShowStrategy {
    public static /* synthetic */ Interceptable $ic;
    public static final SpriteMemeShowStrategy a;
    public static String b;
    public static boolean c;
    public static final Lazy d;
    public static final b e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class a extends BdAsyncTask<Void, Void, SpriteMemeShowConfigData> {
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
        public SpriteMemeShowConfigData doInBackground(Void... params) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, params)) == null) {
                Intrinsics.checkNotNullParameter(params, "params");
                SpriteMemeShowConfigData spriteMemeShowConfigData = new SpriteMemeShowConfigData();
                ca<String> n = yz4.n("tb.sprite_meme_config", SpriteMemeShowStrategy.b);
                if (n != null && !StringUtils.isNull(n.get("sprite_meme_config_cache"))) {
                    try {
                        String str = n.get("sprite_meme_config_cache");
                        TbLog defaultLog = DefaultLog.getInstance();
                        defaultLog.e("sprite_meme_log", "初始化 SpriteMeme 缓存配置: " + str);
                        OrmObject objectWithJsonStr = OrmObject.objectWithJsonStr(str, SpriteMemeShowConfigData.class);
                        if (objectWithJsonStr != null) {
                            return (SpriteMemeShowConfigData) objectWithJsonStr;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.editortools.meme.SpriteMemeShowConfigData");
                    } catch (Exception e) {
                        TbLog defaultLog2 = DefaultLog.getInstance();
                        e.printStackTrace();
                        defaultLog2.e("sprite_meme_log", Unit.INSTANCE.toString());
                        e.printStackTrace();
                        return spriteMemeShowConfigData;
                    }
                }
                return spriteMemeShowConfigData;
            }
            return (SpriteMemeShowConfigData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(SpriteMemeShowConfigData spriteMemeShowConfigData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, spriteMemeShowConfigData) == null) {
                super.onPostExecute(spriteMemeShowConfigData);
                SpriteMemeShowStrategy spriteMemeShowStrategy = SpriteMemeShowStrategy.a;
                SpriteMemeShowStrategy.c = false;
                if (spriteMemeShowConfigData != null) {
                    SpriteMemeShowStrategy.a.f().update(spriteMemeShowConfigData);
                }
                MutiProcessManager.publishEvent(new MutiSpriteMemeEvent(SpriteMemeShowStrategy.b, SpriteMemeShowStrategy.a.f()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b() {
            super(2005016);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            SpriteMemeShowStrategy.a.j();
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends bu5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        @Override // com.baidu.tieba.bu5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ca<String> n = yz4.n("tb.sprite_meme_config", SpriteMemeShowStrategy.b);
                if (n == null) {
                    return null;
                }
                String jsonStrWithObject = OrmObject.jsonStrWithObject(SpriteMemeShowStrategy.a.f());
                n.g("sprite_meme_config_cache", jsonStrWithObject);
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.e("sprite_meme_log", "SpriteMeme 缓存配置：" + jsonStrWithObject);
                return null;
            }
            return invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1425482875, "Lcom/baidu/tbadk/editortools/meme/SpriteMemeShowStrategy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1425482875, "Lcom/baidu/tbadk/editortools/meme/SpriteMemeShowStrategy;");
                return;
            }
        }
        a = new SpriteMemeShowStrategy();
        d = LazyKt__LazyJVMKt.lazy(SpriteMemeShowStrategy$config$2.INSTANCE);
        e = new b();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && k() && f().getShowTimes() < h() && !f().isClickMeme()) {
            f().setClickMeme(true);
            p();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && k() && !c) {
            MutiProcessManager.publishEvent(new MutiSpriteMemeEvent(b, f()));
            DefaultLog.getInstance().e("sprite_meme_log", "开始更新 SpriteMeme 本地缓存配置");
            fu5.b(new c(), null);
        }
    }

    public SpriteMemeShowStrategy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final SpriteMemeShowConfigData f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (SpriteMemeShowConfigData) d.getValue();
        }
        return (SpriteMemeShowConfigData) invokeV.objValue;
    }

    public final long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return pf5.a.a().a();
        }
        return invokeV.longValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return pf5.a.a().b();
        }
        return invokeV.intValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().registerListener(e);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c = true;
            b = TbadkCoreApplication.getCurrentAccount();
            a aVar = new a();
            aVar.setPriority(3);
            aVar.execute(new Void[0]);
        }
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return !StringUtils.isNull(b);
        }
        return invokeV.booleanValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if ((System.currentTimeMillis() / 1000) - f().getFirstShowTime() < g()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void n(SpriteMemeShowConfigData config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, config) == null) {
            Intrinsics.checkNotNullParameter(config, "config");
            f().update(config);
        }
    }

    public final void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            b = str;
        }
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!k()) {
                DefaultLog.getInstance().e("sprite_meme_log", "当前用户未登陆");
                return false;
            } else if (!m()) {
                f().reset();
                p();
                return true;
            } else if (f().getShowTimes() >= h()) {
                return f().isClickMeme();
            } else {
                SpriteMemeShowConfigData f = f();
                f.setShowTimes(f.getShowTimes() + 1);
                p();
                return true;
            }
        }
        return invokeV.booleanValue;
    }
}
