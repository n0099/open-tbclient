package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.by8;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class hy8 implements cg1<by8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class a implements by8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public jy8 b;

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

        @Override // com.baidu.tieba.by8
        public void onDestroy() {
            jy8 jy8Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (jy8Var = this.b) != null) {
                jy8Var.p();
            }
        }

        @Override // com.baidu.tieba.by8
        public void a(qk5 callback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, callback) == null) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                jy8 jy8Var = this.b;
                if (jy8Var != null) {
                    jy8Var.s(callback);
                }
            }
        }

        @Override // com.baidu.tieba.by8
        public void d(by8.a callback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, callback) == null) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                jy8 jy8Var = this.b;
                if (jy8Var != null) {
                    jy8Var.z(callback);
                }
            }
        }

        @Override // com.baidu.tieba.by8
        public void b(Context context, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i) == null) {
                Intrinsics.checkNotNullParameter(context, "context");
                this.b = new jy8(context, i);
            }
        }

        @Override // com.baidu.tieba.by8
        public void c(long j, List<ChatRoomInfo> roomInfoList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j, roomInfoList) == null) {
                Intrinsics.checkNotNullParameter(roomInfoList, "roomInfoList");
                jy8 jy8Var = this.b;
                if (jy8Var != null) {
                    jy8Var.A(j);
                }
                jy8 jy8Var2 = this.b;
                if (jy8Var2 != null) {
                    jy8Var2.o(roomInfoList);
                }
            }
        }
    }

    public hy8() {
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
    @Override // com.baidu.tieba.cg1
    /* renamed from: a */
    public by8 getService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a();
        }
        return (by8) invokeV.objValue;
    }
}
