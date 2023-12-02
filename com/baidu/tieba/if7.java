package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.forum.bubble.BubbleFrequencyData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class if7 {
    public static /* synthetic */ Interceptable $ic;
    public static final if7 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947851663, "Lcom/baidu/tieba/if7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947851663, "Lcom/baidu/tieba/if7;");
                return;
            }
        }
        a = new if7();
    }

    /* loaded from: classes6.dex */
    public static final class a extends nu5<BubbleFrequencyData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;

        public a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nu5
        /* renamed from: a */
        public BubbleFrequencyData doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return BubbleFrequencyData.c.a(e05.l("tb.forum_bubble_guide_cache").get(jf7.a(this.a, this.b)));
            }
            return (BubbleFrequencyData) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends nu5<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public b(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = i2;
            this.c = str;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String date = rd.getDateStringDay(new Date());
                Intrinsics.checkNotNullExpressionValue(date, "date");
                e05.l("tb.forum_bubble_guide_cache").g(jf7.a(this.b, this.c), new BubbleFrequencyData(date, this.a).c());
            }
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.nu5
        public /* bridge */ /* synthetic */ Unit doInBackground() {
            a();
            return Unit.INSTANCE;
        }
    }

    public if7() {
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

    public static final void b(Function1 callback, BubbleFrequencyData bubbleFrequencyData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, callback, bubbleFrequencyData) == null) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            if (bubbleFrequencyData == null) {
                callback.invoke(0);
                return;
            }
            if (Intrinsics.areEqual(bubbleFrequencyData.b(), rd.getDateStringDay(new Date()))) {
                callback.invoke(Integer.valueOf(bubbleFrequencyData.a()));
            } else {
                callback.invoke(0);
            }
        }
    }

    public final void a(String fid, int i, final Function1<? super Integer, Unit> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, fid, i, callback) == null) {
            Intrinsics.checkNotNullParameter(fid, "fid");
            Intrinsics.checkNotNullParameter(callback, "callback");
            ru5.b(new a(i, fid), new st5() { // from class: com.baidu.tieba.df7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.st5
                public final void onReturnDataInUI(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        if7.b(Function1.this, (BubbleFrequencyData) obj);
                    }
                }
            });
        }
    }

    public final void c(String fid, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fid, i, i2) == null) {
            Intrinsics.checkNotNullParameter(fid, "fid");
            ru5.b(new b(i2, i, fid), null);
        }
    }
}
