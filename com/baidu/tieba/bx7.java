package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class bx7 extends sx7 {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public BotsDTO.BotListDTO.SkillDTO.ItemsDTO b;
    public BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947660424, "Lcom/baidu/tieba/bx7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947660424, "Lcom/baidu/tieba/bx7;");
                return;
            }
        }
        d = BdUniqueId.gen().getId();
    }

    @Override // com.baidu.tieba.sx7
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return d;
        }
        return invokeV.intValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b.getName() + "：" + g();
        }
        return (String) invokeV.objValue;
    }

    public BotsDTO.BotListDTO.SkillDTO.ItemsDTO c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (BotsDTO.BotListDTO.SkillDTO.ItemsDTO) invokeV.objValue;
    }

    public List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO = this.b;
            if (itemsDTO != null) {
                return itemsDTO.getOpts();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c;
        }
        return (BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO) invokeV.objValue;
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO optsDTO = this.c;
            if (optsDTO != null) {
                return optsDTO.getName();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO = this.b;
            if (itemsDTO != null && itemsDTO.getOpts() != null && this.b.getOpts().size() > 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public bx7(BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {itemsDTO};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = itemsDTO;
        this.c = d();
    }

    public final BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.b.getOpts() != null && !this.b.getOpts().isEmpty()) {
                for (BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO optsDTO : this.b.getOpts()) {
                    if (optsDTO.getDefaultX() == 1) {
                        return optsDTO;
                    }
                }
                return this.b.getOpts().get(0);
            }
            return null;
        }
        return (BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO) invokeV.objValue;
    }

    public void j(BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO optsDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, optsDTO) == null) {
            this.c = optsDTO;
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.a = z;
        }
    }
}
