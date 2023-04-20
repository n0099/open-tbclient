package com.baidu.tieba;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class f78 extends y78 {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public BotsDTO.BotListDTO.SkillDTO.ItemsDTO b;
    public BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947717154, "Lcom/baidu/tieba/f78;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947717154, "Lcom/baidu/tieba/f78;");
                return;
            }
        }
        d = BdUniqueId.gen().getId();
    }

    @Override // com.baidu.tieba.y78
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
            return this.b.getName() + "：" + h();
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public List<AtSelectData> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO optsDTO = this.c;
            if (optsDTO != null && optsDTO.getExt() != null) {
                return this.c.getExt().getAtUserInfos();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public BotsDTO.BotListDTO.SkillDTO.ItemsDTO d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (BotsDTO.BotListDTO.SkillDTO.ItemsDTO) invokeV.objValue;
    }

    public List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO = this.b;
            if (itemsDTO != null) {
                return itemsDTO.getOpts();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c;
        }
        return (BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b.getItemType();
        }
        return invokeV.intValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO = this.b;
            if (itemsDTO != null && itemsDTO.getOpts() != null && this.b.getOpts().size() > 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public f78(BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO) {
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
        this.c = e();
    }

    public final BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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

    public String h() {
        InterceptResult invokeV;
        BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO optsDTO;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String str = "";
            if (this.b.getItemType() == 2 && (optsDTO = this.c) != null && optsDTO.getExt() != null) {
                List<AtSelectData> atUserInfos = this.c.getExt().getAtUserInfos();
                if (!ListUtils.isEmpty(atUserInfos)) {
                    int size = atUserInfos.size();
                    AtSelectData atSelectData = atUserInfos.get(0);
                    if (atSelectData != null) {
                        str = atSelectData.getNameShow();
                    }
                    if (StringHelper.getChineseAndEnglishLength(str) > 8) {
                        str = StringHelper.subString(str, 8) + StringHelper.STRING_MORE;
                    }
                    if (size == 1) {
                        return str;
                    }
                    return str + "等" + size + "人";
                }
            }
            BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO optsDTO2 = this.c;
            if (optsDTO2 == null) {
                return "";
            }
            return optsDTO2.getName();
        }
        return (String) invokeV.objValue;
    }

    public void l(BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO optsDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, optsDTO) == null) {
            this.c = optsDTO;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.a = z;
        }
    }

    public void n(List<AtSelectData> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, list) == null) && this.c != null) {
            BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO.Ext ext = new BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO.Ext();
            ext.setAtUserInfos(list);
            this.c.setExt(ext);
        }
    }
}
