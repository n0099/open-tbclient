package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public interface ik0 {
    public static final ServiceReference a = new ServiceReference("nad.business", "rewardVideoLpTaskCenter");
    public static final ik0 b = new a();

    /* loaded from: classes6.dex */
    public interface b {
        void a(yj0 yj0Var);

        void onFail(Exception exc);
    }

    void a(@NonNull pm0 pm0Var, @NonNull in0 in0Var, @NonNull b bVar);

    /* loaded from: classes6.dex */
    public class a implements ik0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.ik0
        public void a(@NonNull pm0 pm0Var, @NonNull in0 in0Var, @NonNull b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, pm0Var, in0Var, bVar) == null) {
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
    }
}
