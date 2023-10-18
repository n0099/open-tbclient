package com.baidu.tieba;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import tbclient.Userlike.UserFollowLive;
/* loaded from: classes5.dex */
public class cn6 implements v47<Message> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public cn6() {
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
    @Override // com.baidu.tieba.v47
    /* renamed from: a */
    public h77<?> b(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
            if (!(message instanceof UserFollowLive)) {
                return null;
            }
            lw7 lw7Var = new lw7();
            lw7Var.d((UserFollowLive) message);
            fk6 fk6Var = new fk6(null, lw7Var.c(), ImageViewerConfig.FROM_CONCERN);
            f47 f47Var = new f47();
            f47Var.a = fk6Var;
            return new i77(new r07(f47Var), "ala_live_attention");
        }
        return (h77) invokeL.objValue;
    }
}
