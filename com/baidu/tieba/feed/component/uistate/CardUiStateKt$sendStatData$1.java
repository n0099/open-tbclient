package com.baidu.tieba.feed.component.uistate;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.util.LocalFilesFilterKt;
import com.baidu.tieba.c67;
import com.baidu.tieba.n87;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public /* synthetic */ class CardUiStateKt$sendStatData$1 extends FunctionReferenceImpl implements Function1<c67, Unit> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardUiStateKt$sendStatData$1(Object obj) {
        super(1, obj, n87.a.class, LocalFilesFilterKt.FILTER_NAME_LOG, "log(Lcom/baidu/tieba/feed/data/StatData;)V", 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), objArr2[1], (Class) objArr2[2], (String) objArr2[3], (String) objArr2[4], ((Integer) objArr2[5]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(c67 c67Var) {
        invoke2(c67Var);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(c67 c67Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c67Var) == null) {
            ((n87.a) this.receiver).a(c67Var);
        }
    }
}
