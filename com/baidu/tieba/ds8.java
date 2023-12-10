package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.biz.aibot.recentbot.AibotHistoryDataManager;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.SizedSyncTreeSet;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class ds8 {
    public static /* synthetic */ Interceptable $ic;
    public static final b d;
    public static final ds8 e;
    public transient /* synthetic */ FieldHolder $fh;
    public AibotHistoryDataManager a;
    public boolean b;
    public final Comparator<AibotHistoryDataManager.BotChatData> c;

    public /* synthetic */ ds8(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* loaded from: classes5.dex */
    public static final class a implements Comparator<AibotHistoryDataManager.BotChatData> {
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
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(AibotHistoryDataManager.BotChatData botChatData, AibotHistoryDataManager.BotChatData botChatData2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, botChatData, botChatData2)) == null) {
                if (botChatData == null || botChatData2 == null) {
                    return 0;
                }
                if (botChatData.getTimestamp() < botChatData2.getTimestamp()) {
                    return 1;
                }
                if (botChatData.getTimestamp() > botChatData2.getTimestamp()) {
                    return -1;
                }
                int i = (botChatData.getTimestamp() > botChatData2.getTimestamp() ? 1 : (botChatData.getTimestamp() == botChatData2.getTimestamp() ? 0 : -1));
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public b() {
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

        public final ds8 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return ds8.e;
            }
            return (ds8) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;
        public static final ds8 b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-851422079, "Lcom/baidu/tieba/ds8$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-851422079, "Lcom/baidu/tieba/ds8$c;");
                    return;
                }
            }
            a = new c();
            b = new ds8(null);
        }

        public c() {
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

        public final ds8 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b;
            }
            return (ds8) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends nu5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public d(String str) {
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

        @Override // com.baidu.tieba.nu5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                da<String> n = e05.n("tb.im_ai_bot_chat_history", TbadkCoreApplication.getCurrentAccount());
                if (n == null) {
                    return null;
                }
                n.g("key_chat_ai_bot_list", this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class e extends nu5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ds8 a;

        public e(ds8 ds8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ds8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ds8Var;
        }

        @Override // com.baidu.tieba.nu5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                da<String> n = e05.n("tb.im_ai_bot_chat_history", TbadkCoreApplication.getCurrentAccount());
                if (n == null) {
                    return null;
                }
                this.a.d().i(n.get("key_chat_ai_bot_list"));
                return null;
            }
            return invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947715232, "Lcom/baidu/tieba/ds8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947715232, "Lcom/baidu/tieba/ds8;");
                return;
            }
        }
        d = new b(null);
        e = c.a.a();
    }

    public ds8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new AibotHistoryDataManager();
        this.c = new a();
    }

    public final Comparator<AibotHistoryDataManager.BotChatData> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (Comparator) invokeV.objValue;
    }

    public final AibotHistoryDataManager d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (AibotHistoryDataManager) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && !this.b) {
            ru5.b(new e(this), null);
            this.b = true;
        }
    }

    public final boolean b(String fid, String uk) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fid, uk)) == null) {
            Intrinsics.checkNotNullParameter(fid, "fid");
            Intrinsics.checkNotNullParameter(uk, "uk");
            SizedSyncTreeSet<AibotHistoryDataManager.BotChatData> d2 = this.a.d(fid);
            if (d2 != null) {
                return this.a.a(uk, d2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final String e(String fid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fid)) == null) {
            Intrinsics.checkNotNullParameter(fid, "fid");
            if (this.a.d(fid) != null) {
                return this.a.g(fid);
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public final void f(String fid, String uk, String paid, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, fid, uk, paid, str) == null) {
            Intrinsics.checkNotNullParameter(fid, "fid");
            Intrinsics.checkNotNullParameter(uk, "uk");
            Intrinsics.checkNotNullParameter(paid, "paid");
            this.a.h(fid, uk, paid, str);
            ru5.b(new d(this.a.c()), null);
        }
    }
}
