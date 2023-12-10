package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.lib.socket.msg.data.BotsDTO;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hy8 implements bq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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

    public static aq8 c(Context context, RecyclerView recyclerView, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, context, recyclerView, i)) == null) {
            return new aq8(context, recyclerView, new fy8(), new gy8(), i, 1);
        }
        return (aq8) invokeLLI.objValue;
    }

    public static zp8 e(Context context, RecyclerView recyclerView, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, context, recyclerView, i)) == null) {
            return new zp8(context, recyclerView, new fy8(), new gy8(), i, 1);
        }
        return (zp8) invokeLLI.objValue;
    }

    @Override // com.baidu.tieba.bq8
    public aq8 b(Context context, RecyclerView recyclerView, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, recyclerView, i)) == null) {
            return c(context, recyclerView, i);
        }
        return (aq8) invokeLLI.objValue;
    }

    public static aq8 d(Context context, RecyclerView recyclerView, int i, @Nullable BotsDTO.BotListDTO.SkillDTO skillDTO, @Nullable BotsDTO.BotListDTO.UserDTO userDTO) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, recyclerView, Integer.valueOf(i), skillDTO, userDTO})) == null) {
            gy8 gy8Var = new gy8();
            gy8Var.e(skillDTO);
            gy8Var.f(userDTO);
            return new aq8(context, recyclerView, new fy8(), gy8Var, i, 2);
        }
        return (aq8) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.bq8
    public aq8 a(Context context, RecyclerView recyclerView, int i, @Nullable BotsDTO.BotListDTO.SkillDTO skillDTO, @Nullable BotsDTO.BotListDTO.UserDTO userDTO) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, recyclerView, Integer.valueOf(i), skillDTO, userDTO})) == null) {
            return d(context, recyclerView, i, skillDTO, userDTO);
        }
        return (aq8) invokeCommon.objValue;
    }
}
