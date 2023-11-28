package com.baidu.tieba;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.tracker.ext.FragmentExtKt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* loaded from: classes5.dex */
public final class bp5 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public static final HashMap<BdUniqueId, String> b;
    public static final HashMap<BdUniqueId, Pair<String, String>[]> c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: com.baidu.tieba.bp5$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0249a implements zo5 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m4b a;

            public C0249a(m4b m4bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {m4bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = m4bVar;
            }

            @Override // com.baidu.tieba.zo5
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    m4b m4bVar = this.a;
                    if (m4bVar instanceof Fragment) {
                        FragmentExtKt.b((Fragment) m4bVar, new Pair[0]);
                    } else if (m4bVar instanceof FragmentActivity) {
                        l4b.b((FragmentActivity) m4bVar);
                    }
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.i("PageLoadEvent", "start: " + this.a.getClass());
                }
            }

            @Override // com.baidu.tieba.zo5
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    m4b m4bVar = this.a;
                    if (m4bVar instanceof Fragment) {
                        FragmentExtKt.c((Fragment) m4bVar, new Pair[0]);
                    } else if (m4bVar instanceof FragmentActivity) {
                        l4b.c((FragmentActivity) m4bVar, new Pair[0]);
                    }
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.i("PageLoadEvent", "finish: " + this.a.getClass());
                }
            }

            @Override // com.baidu.tieba.zo5
            public void c(Pair<String, String>... info) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, info) == null) {
                    Intrinsics.checkNotNullParameter(info, "info");
                    m4b m4bVar = this.a;
                    if (m4bVar instanceof Fragment) {
                        FragmentExtKt.a((Fragment) m4bVar, (Pair[]) Arrays.copyOf(info, info.length));
                    } else if (m4bVar instanceof FragmentActivity) {
                        l4b.a((FragmentActivity) m4bVar, (Pair[]) Arrays.copyOf(info, info.length));
                    }
                    StringBuilder sb = new StringBuilder();
                    for (Pair<String, String> pair : info) {
                        sb.append(pair);
                    }
                    DefaultLog.getInstance().i("PageLoadEvent", "error: " + this.a.getClass() + " info: " + ((Object) sb));
                }
            }
        }

        /* loaded from: classes5.dex */
        public static final class b extends ar6<ap5> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BdUniqueId b;
            public final /* synthetic */ zo5 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(BdUniqueId bdUniqueId, zo5 zo5Var, Class<ap5> cls) {
                super(cls);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bdUniqueId, zo5Var, cls};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((Class) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bdUniqueId;
                this.c = zo5Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ar6
            public void onEvent(ap5 event) {
                String str;
                String str2;
                String str3;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
                    Intrinsics.checkNotNullParameter(event, "event");
                    if (!Intrinsics.areEqual(event.a(), this.b)) {
                        return;
                    }
                    String c = event.c();
                    int hashCode = c.hashCode();
                    if (hashCode != 3540994) {
                        if (hashCode != 96784904) {
                            if (hashCode == 109757538 && c.equals("start") && (str3 = bp5.a.c().get(this.b)) != null) {
                                int hashCode2 = str3.hashCode();
                                if (hashCode2 != 3237136) {
                                    if (hashCode2 != 3540994) {
                                        if (hashCode2 == 96784904 && str3.equals("error")) {
                                            this.c.a();
                                            Pair<String, String>[] pairArr = bp5.a.b().get(this.b);
                                            if (pairArr != null) {
                                                this.c.c((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
                                            }
                                            bp5.a.c().remove(this.b);
                                            bp5.a.b().remove(this.b);
                                        }
                                    } else if (str3.equals("stop")) {
                                        this.c.a();
                                        this.c.b();
                                        bp5.a.c().remove(this.b);
                                        bp5.a.b().remove(this.b);
                                    }
                                } else if (str3.equals("init")) {
                                    this.c.a();
                                    bp5.a.c().put(this.b, "start");
                                }
                            }
                        } else if (c.equals("error") && (str2 = bp5.a.c().get(this.b)) != null) {
                            int hashCode3 = str2.hashCode();
                            if (hashCode3 != 3237136) {
                                if (hashCode3 == 109757538 && str2.equals("start")) {
                                    zo5 zo5Var = this.c;
                                    Pair<String, String>[] b = event.b();
                                    zo5Var.c((Pair[]) Arrays.copyOf(b, b.length));
                                    bp5.a.c().remove(this.b);
                                    bp5.a.b().remove(this.b);
                                }
                            } else if (str2.equals("init")) {
                                bp5.a.c().put(this.b, "error");
                                bp5.a.b().put(this.b, event.b());
                            }
                        }
                    } else if (c.equals("stop") && (str = bp5.a.c().get(this.b)) != null) {
                        int hashCode4 = str.hashCode();
                        if (hashCode4 != 3237136) {
                            if (hashCode4 == 109757538 && str.equals("start")) {
                                this.c.b();
                                bp5.a.c().remove(this.b);
                                bp5.a.b().remove(this.b);
                            }
                        } else if (str.equals("init")) {
                            bp5.a.c().put(this.b, "stop");
                        }
                    }
                }
            }
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

        public final HashMap<BdUniqueId, Pair<String, String>[]> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                return (HashMap) invokeV.objValue;
            }
            return bp5.c;
        }

        public final HashMap<BdUniqueId, String> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) != null) {
                return (HashMap) invokeV.objValue;
            }
            return bp5.b;
        }

        public final void a(BdUniqueId bdUniqueId, Pair<String, String>... info) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, bdUniqueId, info) == null) {
                Intrinsics.checkNotNullParameter(info, "info");
                xq6.b().c(new ap5(bdUniqueId, "error", (Pair[]) Arrays.copyOf(info, info.length)));
            }
        }

        public final void e(BdUniqueId uniqueId, m4b traceable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, uniqueId, traceable) == null) {
                Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
                Intrinsics.checkNotNullParameter(traceable, "traceable");
                c().put(uniqueId, "init");
                f(uniqueId, d(traceable));
            }
        }

        public final void f(BdUniqueId bdUniqueId, zo5 zo5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, bdUniqueId, zo5Var) == null) {
                xq6.b().b(new wq6(bdUniqueId, Reflection.getOrCreateKotlinClass(ap5.class)), new b(bdUniqueId, zo5Var, ap5.class));
            }
        }

        public final zo5 d(m4b m4bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, m4bVar)) == null) {
                return new C0249a(m4bVar);
            }
            return (zo5) invokeL.objValue;
        }

        public final void g(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
                xq6.b().c(new ap5(bdUniqueId, "start"));
            }
        }

        public final void h(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
                xq6.b().c(new ap5(bdUniqueId, "stop"));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947652674, "Lcom/baidu/tieba/bp5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947652674, "Lcom/baidu/tieba/bp5;");
                return;
            }
        }
        a = new a(null);
        b = new HashMap<>();
        c = new HashMap<>();
    }
}
