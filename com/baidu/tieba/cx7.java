package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class cx7 extends sx7 {
    public static /* synthetic */ Interceptable $ic;
    public static final int c;
    public transient /* synthetic */ FieldHolder $fh;
    public BotsDTO.BotListDTO.SkillDTO.ItemsDTO a;
    public BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947690215, "Lcom/baidu/tieba/cx7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947690215, "Lcom/baidu/tieba/cx7;");
                return;
            }
        }
        c = BdUniqueId.gen().getId();
    }

    @Override // com.baidu.tieba.sx7
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return c;
        }
        return invokeV.intValue;
    }

    @NonNull
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a.getName() + "：" + e();
        }
        return (String) invokeV.objValue;
    }

    public BotsDTO.BotListDTO.SkillDTO.ItemsDTO c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (BotsDTO.BotListDTO.SkillDTO.ItemsDTO) invokeV.objValue;
    }

    public BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO) invokeV.objValue;
    }

    @NonNull
    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO optsDTO = this.b;
            if (optsDTO != null) {
                return optsDTO.getName();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }
}
