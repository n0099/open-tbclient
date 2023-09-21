package com.baidu.tieba.im.base.core.uilist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.base.core.repo.MsgProcessor;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.http.client.methods.HttpDelete;
/* loaded from: classes6.dex */
public class Action {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long a;
    @NonNull
    public final String b;
    @NonNull
    public final Op c;
    @Nullable
    public final a d;

    /* loaded from: classes6.dex */
    public interface a<Msg extends BaseItem<? extends TbBaseMsg>> {
        @WorkerThread
        void a(@NonNull Op op, @Nullable Msg msg, @NonNull MsgProcessor.d dVar);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class Op {
        public static final /* synthetic */ Op[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Op DELETE;
        public static final Op EXEC;
        public static final Op UPDATE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1815456390, "Lcom/baidu/tieba/im/base/core/uilist/Action$Op;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1815456390, "Lcom/baidu/tieba/im/base/core/uilist/Action$Op;");
                    return;
                }
            }
            DELETE = new Op(HttpDelete.METHOD_NAME, 0);
            UPDATE = new Op("UPDATE", 1);
            Op op = new Op("EXEC", 2);
            EXEC = op;
            $VALUES = new Op[]{DELETE, UPDATE, op};
        }

        public Op(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Op valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (Op) Enum.valueOf(Op.class, str);
            }
            return (Op) invokeL.objValue;
        }

        public static Op[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (Op[]) $VALUES.clone();
            }
            return (Op[]) invokeV.objValue;
        }
    }

    public Action(long j, @NonNull String str, @NonNull Op op, @Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), str, op, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = j;
        this.b = str;
        this.c = op;
        this.d = aVar;
    }

    @NonNull
    public static Action a(long j, @NonNull String str, @NonNull Op op, @Nullable a<? extends BaseItem<? extends TbBaseMsg>> aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j), str, op, aVar})) == null) {
            return new Action(j, str, op, aVar);
        }
        return (Action) invokeCommon.objValue;
    }

    public static void f(@Nullable a aVar, @NonNull Op op, @Nullable BaseItem<? extends TbBaseMsg> baseItem, @NonNull MsgProcessor.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65538, null, aVar, op, baseItem, dVar) == null) && aVar != null) {
            aVar.a(op, baseItem, dVar);
        }
    }

    @Nullable
    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return (a) invokeV.objValue;
    }

    @NonNull
    public Op c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (Op) invokeV.objValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return invokeV.longValue;
    }

    @NonNull
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }
}
