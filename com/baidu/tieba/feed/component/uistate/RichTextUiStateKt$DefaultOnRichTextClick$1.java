package com.baidu.tieba.feed.component.uistate;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.c87;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public /* synthetic */ class RichTextUiStateKt$DefaultOnRichTextClick$1 extends FunctionReferenceImpl implements Function2<Context, String, Unit> {
    public static /* synthetic */ Interceptable $ic;
    public static final RichTextUiStateKt$DefaultOnRichTextClick$1 INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1048131457, "Lcom/baidu/tieba/feed/component/uistate/RichTextUiStateKt$DefaultOnRichTextClick$1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1048131457, "Lcom/baidu/tieba/feed/component/uistate/RichTextUiStateKt$DefaultOnRichTextClick$1;");
                return;
            }
        }
        INSTANCE = new RichTextUiStateKt$DefaultOnRichTextClick$1();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RichTextUiStateKt$DefaultOnRichTextClick$1() {
        super(2, c87.class, "deal", "deal(Landroid/content/Context;Ljava/lang/String;)V", 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), (Class) objArr[1], (String) objArr[2], (String) objArr[3], ((Integer) objArr[4]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Context context, String str) {
        invoke2(context, str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str) == null) {
            c87.c(context, str);
        }
    }
}
