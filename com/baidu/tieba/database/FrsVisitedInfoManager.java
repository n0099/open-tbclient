package com.baidu.tieba.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.iu6;
import com.baidu.tieba.ju6;
import com.baidu.tieba.ku6;
import com.baidu.tieba.kz0;
import com.baidu.tieba.lu6;
import com.baidu.tieba.qz0;
import com.baidu.tieba.sna;
import com.baidu.tieba.una;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\u000eJ\b\u0010\u0010\u001a\u00020\u000bH\u0002J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bJ,\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00140\u00130\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0016J\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/baidu/tieba/database/FrsVisitedInfoManager;", "", "()V", "accountChangedListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "dataSource", "Lcom/baidu/tieba/database/ExSql$IExDataSource;", "dbName", "", "getDataBaseName", "getLastVisitTimeByFid", "", "fid", WebChromeClient.KEY_ARG_CALLBACK, "Lkotlin/Function1;", "", "init", "recordForumCustomData", "selectFrsVisitedInfo", "", "Lcom/baidu/tieba/sqlite/entity/FrsVisitedInfo;", "topFids", "", "selectTopN", "", "n", "", "Companion", "frs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FrsVisitedInfoManager {
    public static /* synthetic */ Interceptable $ic;
    public static final a d;
    public static final Lazy<FrsVisitedInfoManager> e;
    public static final SimpleDateFormat f;
    public transient /* synthetic */ FieldHolder $fh;
    public ju6.a a;
    public String b;
    public final CustomMessageListener c;

    public /* synthetic */ FrsVisitedInfoManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final FrsVisitedInfoManager f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? d.a() : (FrsVisitedInfoManager) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

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

        public final FrsVisitedInfoManager a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return (FrsVisitedInfoManager) FrsVisitedInfoManager.e.getValue();
            }
            return (FrsVisitedInfoManager) invokeV.objValue;
        }

        public final SimpleDateFormat b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                return (SimpleDateFormat) invokeV.objValue;
            }
            return FrsVisitedInfoManager.f;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsVisitedInfoManager a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FrsVisitedInfoManager frsVisitedInfoManager) {
            super(2005016);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsVisitedInfoManager};
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
            this.a = frsVisitedInfoManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (responsedMessage.getCmd() == 2005016) {
                    this.a.h();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends BdAsyncTask<String, Integer, Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsVisitedInfoManager a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Function1<Long, Unit> c;

        public c(FrsVisitedInfoManager frsVisitedInfoManager, String str, Function1<? super Long, Unit> function1) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsVisitedInfoManager, str, function1};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsVisitedInfoManager;
            this.b = str;
            this.c = function1;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, MOVE_EXCEPTION] complete} */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Long doInBackground(String... params) {
            InterceptResult invokeL;
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, params)) == null) {
                Intrinsics.checkNotNullParameter(params, "params");
                ju6.a aVar = this.a.a;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataSource");
                    aVar = null;
                }
                Cursor g = aVar.g("SELECT latest_time \n                        FROM forum_visited_info \n                        WHERE fid = ?\n                        ORDER BY latest_time DESC \n                        LIMIT 1", this.b);
                try {
                    if (g.moveToFirst()) {
                        LongColumn c = ju6.a.c(0);
                        qz0.f(g, new LongColumn[]{c});
                        j = c.getValue();
                    } else {
                        j = -1;
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(g, null);
                    return Long.valueOf(j);
                } finally {
                }
            } else {
                return (Long) invokeL.objValue;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Long l) {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l) == null) {
                Function1<Long, Unit> function1 = this.c;
                if (l != null) {
                    j = l.longValue();
                } else {
                    j = -1;
                }
                function1.invoke(Long.valueOf(j));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends BdAsyncTask<String, Integer, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ FrsVisitedInfoManager b;

        public d(String str, FrsVisitedInfoManager frsVisitedInfoManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, frsVisitedInfoManager};
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
            this.b = frsVisitedInfoManager;
        }

        /* JADX DEBUG: Incorrect finally slice size: {[IGET, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, MOVE, IF] complete}, expected: {[IGET, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, MOVE, IF] complete} */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Finally extract failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Integer doInBackground(String... params) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, params)) == null) {
                Intrinsics.checkNotNullParameter(params, "params");
                String format = FrsVisitedInfoManager.d.b().format(new Date());
                sna snaVar = new sna();
                snaVar.f(format);
                snaVar.g(this.a);
                ju6.a aVar = this.b.a;
                ju6.a aVar2 = null;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataSource");
                    aVar = null;
                }
                aVar.beginTransaction();
                try {
                    kz0[] kz0VarArr = {una.f, una.g};
                    ju6.a aVar3 = this.b.a;
                    if (aVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dataSource");
                        aVar3 = null;
                    }
                    boolean b = aVar3.b(snaVar, (kz0[]) Arrays.copyOf(kz0VarArr, 2));
                    snaVar.h(System.currentTimeMillis());
                    if (b) {
                        snaVar.e(snaVar.c() + 1);
                        ju6.a aVar4 = this.b.a;
                        if (aVar4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("dataSource");
                            aVar4 = null;
                        }
                        aVar4.f(snaVar, (kz0[]) Arrays.copyOf(kz0VarArr, 2));
                    } else {
                        snaVar.e(1L);
                        ju6.a aVar5 = this.b.a;
                        if (aVar5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("dataSource");
                            aVar5 = null;
                        }
                        aVar5.c(snaVar);
                    }
                    ju6.a aVar6 = this.b.a;
                    if (aVar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dataSource");
                        aVar6 = null;
                    }
                    aVar6.setTransactionSuccessful();
                    ju6.a aVar7 = this.b.a;
                    if (aVar7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dataSource");
                    } else {
                        aVar2 = aVar7;
                    }
                    aVar2.endTransaction();
                    return 0;
                } catch (Throwable th) {
                    ju6.a aVar8 = this.b.a;
                    if (aVar8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dataSource");
                    } else {
                        aVar2 = aVar8;
                    }
                    aVar2.endTransaction();
                    throw th;
                }
            }
            return (Integer) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(386618437, "Lcom/baidu/tieba/database/FrsVisitedInfoManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(386618437, "Lcom/baidu/tieba/database/FrsVisitedInfoManager;");
                return;
            }
        }
        d = new a(null);
        e = LazyKt__LazyJVMKt.lazy(FrsVisitedInfoManager$Companion$instance$2.INSTANCE);
        f = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
    }

    public FrsVisitedInfoManager() {
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
        this.c = new b(this);
        h();
        MessageManager.getInstance().registerListener(this.c);
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (TextUtils.isEmpty(currentAccount)) {
                currentAccount = "visitor";
            }
            return "forum_custom_" + currentAccount + ".db";
        }
        return (String) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b = e();
            String str = this.b;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dbName");
                str = null;
            }
            SQLiteDatabase writableDatabase = new ku6(str).getWritableDatabase();
            writableDatabase.setLocale(Locale.US);
            this.a = new iu6(writableDatabase);
        }
    }

    public final void i(String fid) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fid) == null) {
            Intrinsics.checkNotNullParameter(fid, "fid");
            new d(fid, this).execute(new String[0]);
        }
    }

    public final Map<String, Map<String, sna>> j(List<String> topFids) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, topFids)) == null) {
            Intrinsics.checkNotNullParameter(topFids, "topFids");
            ju6.a aVar = this.a;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataSource");
                aVar = null;
            }
            return lu6.a(aVar, topFids);
        }
        return (Map) invokeL.objValue;
    }

    public final List<String> k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            ju6.a aVar = this.a;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataSource");
                aVar = null;
            }
            return lu6.b(aVar, i);
        }
        return (List) invokeI.objValue;
    }

    public final void g(String fid, Function1<? super Long, Unit> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fid, callback) == null) {
            Intrinsics.checkNotNullParameter(fid, "fid");
            Intrinsics.checkNotNullParameter(callback, "callback");
            c cVar = new c(this, fid, callback);
            cVar.setPriority(3);
            cVar.execute(fid);
        }
    }
}
