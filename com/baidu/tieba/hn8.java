package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.immessagecenter.chatgroup.floatentrance.ChatFloatEntranceFragment;
import com.baidu.tieba.qp5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hn8 implements cl1<qp5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements qp5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public ChatFloatEntranceFragment b;

        @Override // com.baidu.tieba.qp5
        public void a(@Nullable qp5.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            }
        }

        public a(hn8 hn8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hn8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.qp5
        public void onChangeSkinType(int i) {
            ChatFloatEntranceFragment chatFloatEntranceFragment;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (chatFloatEntranceFragment = this.b) != null) {
                chatFloatEntranceFragment.onChangeSkinType(i);
            }
        }

        @Override // com.baidu.tieba.qp5
        @NonNull
        public qp5.b b(String str, tp5 tp5Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, tp5Var)) == null) {
                if (this.b == null) {
                    this.b = new ChatFloatEntranceFragment(str, tp5Var);
                }
                return this.b;
            }
            return (qp5.b) invokeLL.objValue;
        }
    }

    public hn8() {
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
    @Override // com.baidu.tieba.cl1
    /* renamed from: a */
    public qp5 getService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (qp5) invokeV.objValue;
    }
}
