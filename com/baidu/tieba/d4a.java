package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.pb.mixplayer.TbMixPlayerView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes5.dex */
public final class d4a {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public static long b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947655960, "Lcom/baidu/tieba/d4a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947655960, "Lcom/baidu/tieba/d4a;");
                return;
            }
        }
        a = new a(null);
    }

    @JvmStatic
    public static final AlaInfoData c(vv9 vv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, vv9Var)) == null) ? a.b(vv9Var) : (AlaInfoData) invokeL.objValue;
    }

    @JvmStatic
    public static final void d(j1a j1aVar, vv9 vv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, j1aVar, vv9Var) == null) {
            a.e(j1aVar, vv9Var);
        }
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: com.baidu.tieba.d4a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0262a implements TbMixPlayerView.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ vv9 a;

            public C0262a(vv9 vv9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {vv9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = vv9Var;
            }

            @Override // com.baidu.tieba.pb.mixplayer.TbMixPlayerView.a
            public void onClick() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    nua.u("c15499", this.a.R(), d4a.a.b(this.a), 0L);
                }
            }
        }

        /* loaded from: classes5.dex */
        public static final class b implements TbMixPlayerView.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ vv9 a;

            public b(vv9 vv9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {vv9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = vv9Var;
            }

            @Override // com.baidu.tieba.pb.mixplayer.TbMixPlayerView.b
            public void onError() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = d4a.a;
                    d4a.b = 0L;
                }
            }

            @Override // com.baidu.tieba.pb.mixplayer.TbMixPlayerView.b
            public void onPause() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    d4a.a.d(this.a);
                }
            }

            @Override // com.baidu.tieba.pb.mixplayer.TbMixPlayerView.b
            public void onRelease() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    a aVar = d4a.a;
                    d4a.b = 0L;
                }
            }

            @Override // com.baidu.tieba.pb.mixplayer.TbMixPlayerView.b
            public void onStart() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                    a aVar = d4a.a;
                    d4a.b = System.currentTimeMillis();
                }
            }

            @Override // com.baidu.tieba.pb.mixplayer.TbMixPlayerView.b
            public void onStop() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                    d4a.a.d(this.a);
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

        @JvmStatic
        public final void e(j1a j1aVar, vv9 pbData) {
            TbMixPlayerView b1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, j1aVar, pbData) == null) {
                Intrinsics.checkNotNullParameter(pbData, "pbData");
                if (j1aVar != null && (b1 = j1aVar.b1()) != null) {
                    b1.setOnClickCallback(new C0262a(pbData));
                    b1.setPlayerStatusCallBack(new b(pbData));
                }
            }
        }

        @JvmStatic
        public final AlaInfoData b(vv9 vv9Var) {
            InterceptResult invokeL;
            ThreadData R;
            HashMap<String, MetaData> userMap;
            MetaData metaData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vv9Var)) == null) {
                if (vv9Var != null && (R = vv9Var.R()) != null && (userMap = R.getUserMap()) != null && (metaData = userMap.get(c(vv9Var))) != null) {
                    return metaData.getAlaInfo();
                }
                return null;
            }
            return (AlaInfoData) invokeL.objValue;
        }

        public final void d(vv9 vv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vv9Var) == null) {
                long currentTimeMillis = System.currentTimeMillis() - d4a.b;
                if (d4a.b > 0 && currentTimeMillis > 0) {
                    nua.u("c15500", vv9Var.R(), b(vv9Var), Long.valueOf(currentTimeMillis));
                }
                d4a.b = 0L;
            }
        }

        public final String c(vv9 vv9Var) {
            InterceptResult invokeL;
            String str;
            String str2;
            nwa l;
            ArrayList<nwa> I;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vv9Var)) == null) {
                String str3 = "";
                boolean z2 = false;
                if (vv9Var == null || (I = vv9Var.I()) == null) {
                    str = "";
                } else {
                    Iterator<nwa> it = I.iterator();
                    str = "";
                    while (it.hasNext()) {
                        nwa next = it.next();
                        if (next != null && next.L() == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            str = next.v();
                            Intrinsics.checkNotNullExpressionValue(str, "data.authorId");
                        }
                    }
                }
                if ((str == null || StringsKt__StringsJVMKt.isBlank(str)) ? true : true) {
                    if (vv9Var != null && (l = vv9Var.l()) != null) {
                        str2 = l.v();
                    } else {
                        str2 = null;
                    }
                    if (str2 != null) {
                        str3 = str2;
                    }
                    return str3;
                }
                return str;
            }
            return (String) invokeL.objValue;
        }
    }
}
