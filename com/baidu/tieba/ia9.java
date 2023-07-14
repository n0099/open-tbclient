package com.baidu.tieba;

import com.baidu.pyramid.annotation.Service;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
@Service
/* loaded from: classes6.dex */
public final class ia9 implements bg5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ia9() {
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

    @Override // com.baidu.tieba.bg5
    public uf5 a(String schema) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, schema)) == null) {
            Intrinsics.checkNotNullParameter(schema, "schema");
            try {
                if (StringsKt__StringsKt.contains$default((CharSequence) schema, (CharSequence) "tbtopicdetail", false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) schema, (CharSequence) "unidispatch/topicdetail", false, 2, (Object) null)) {
                    String c = my5.c(pz5.c(schema, "topic_id="), null);
                    uf5 uf5Var = new uf5();
                    uf5Var.c(c);
                    uf5Var.d(true);
                    return uf5Var;
                }
            } catch (Exception e) {
                if (!TbadkCoreApplication.getInst().isDebugMode()) {
                    e.printStackTrace();
                } else {
                    throw e;
                }
            }
            return new uf5();
        }
        return (uf5) invokeL.objValue;
    }
}
