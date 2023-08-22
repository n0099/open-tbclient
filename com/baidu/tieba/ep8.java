package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.immessagecenter.chatgroup.data.RecentlyBotSkillInfoDto;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.adapter.RobotItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.adapter.RobotSkillItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.adapter.RobotSkillRecentlyItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ep8 implements vk8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    @NonNull
    public TbPageContext e;
    public dp8 f;
    public long g;
    public long h;
    public ArrayList<RobotItem> i;
    public List<tk8> j;
    public xk8 k;

    @Override // com.baidu.tieba.vk8
    public void detach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.tieba.vk8
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public ep8(@NonNull TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.i = new ArrayList<>();
        this.j = new ArrayList();
        this.e = tbPageContext;
    }

    public void a(List<tk8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, list) == null) && !ListUtils.isEmpty(list) && this.k != null) {
            this.j.clear();
            this.j.addAll(list);
            this.k.f(0, d());
        }
    }

    @Override // com.baidu.tieba.vk8
    public void c(@NonNull xk8 xk8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xk8Var) == null) {
            this.k = xk8Var;
        }
    }

    @Nullable
    public tk8 k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            if (!ListUtils.isEmpty(this.j) && i >= 0 && i < this.j.size()) {
                return this.j.get(i);
            }
            return null;
        }
        return (tk8) invokeI.objValue;
    }

    public void u(dp8 dp8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, dp8Var) == null) {
            this.f = dp8Var;
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i = this.b + 1;
            this.b = i;
            return i;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.vk8
    @NonNull
    public List<tk8> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.j;
        }
        return (List) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i = this.c + 1;
            this.c = i;
            return i;
        }
        return invokeV.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i = this.d + 1;
            this.d = i;
            return i;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.vk8
    public int getItemsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.j.size();
        }
        return invokeV.intValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.a = 0;
            this.i.clear();
        }
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return BdUtilHelper.dip2px(this.e.getPageActivity(), 42.0f);
        }
        return invokeV.intValue;
    }

    @NonNull
    public ArrayList<RobotItem> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.i;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public void t() {
        xk8 xk8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (xk8Var = this.k) != null) {
            xk8Var.a(0, d().size());
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (this.b != 0) {
                this.a += BdUtilHelper.dip2px(this.e.getPageActivity(), 42.0f) * this.b;
            }
            if (this.c != 0) {
                this.a += BdUtilHelper.dip2px(this.e.getPageActivity(), 35.0f) * this.c;
            }
            if (this.d != 0 && !z) {
                int dip2px = this.a + (BdUtilHelper.dip2px(this.e.getPageActivity(), 55.0f) * this.d);
                this.a = dip2px;
                this.a = dip2px + BdUtilHelper.dip2px(this.e.getPageActivity(), 42.0f);
            }
            if (!z) {
                this.a += BdUtilHelper.dip2px(this.e.getPageActivity(), 52.0f);
            }
            this.a += BdUtilHelper.dip2px(this.e.getPageActivity(), 18.0f);
        }
    }

    public void p(List<Object> list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048593, this, list, z) == null) && !ListUtils.isEmpty(list) && this.k != null) {
            i();
            List<tk8> r = r(list);
            if (ListUtils.isEmpty(r)) {
                return;
            }
            h(z);
            this.j.clear();
            this.j.addAll(r);
            this.k.f(0, d());
        }
    }

    public void q(List<Object> list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048594, this, list, z) == null) && !ListUtils.isEmpty(list) && this.k != null) {
            i();
            List<tk8> r = r(list);
            if (ListUtils.isEmpty(r)) {
                return;
            }
            h(z);
            this.j.clear();
            this.j.addAll(r);
            this.k.b(0, d());
        }
    }

    @Nullable
    public final List<tk8> r(@Nullable List<?> list) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (obj instanceof BotsDTO.BotListDTO) {
                    BotsDTO.BotListDTO botListDTO = (BotsDTO.BotListDTO) obj;
                    if (botListDTO.getUser() != null) {
                        String nameShow = botListDTO.getUser().getNameShow();
                        String portrait = botListDTO.getUser().getPortrait();
                        String uk = botListDTO.getUser().getUk();
                        List<tk8> s = s(botListDTO.getSkill(), botListDTO.getUser().getUk());
                        if (!TextUtils.isEmpty(nameShow) && !TextUtils.isEmpty(portrait) && !TextUtils.isEmpty(uk) && !ListUtils.isEmpty(s)) {
                            b();
                            TbPageContext tbPageContext = this.e;
                            dp8 dp8Var = this.f;
                            if (l() == 1 && (this.b != 1 || o() == 0)) {
                                z = false;
                            } else {
                                z = true;
                            }
                            RobotItem robotItem = new RobotItem(s, portrait, nameShow, uk, tbPageContext, dp8Var, z);
                            arrayList.add(robotItem);
                            this.i.add(robotItem);
                        }
                    }
                } else if (obj instanceof RecentlyBotSkillInfoDto) {
                    RecentlyBotSkillInfoDto recentlyBotSkillInfoDto = (RecentlyBotSkillInfoDto) obj;
                    RobotSkillRecentlyItem robotSkillRecentlyItem = new RobotSkillRecentlyItem(recentlyBotSkillInfoDto.getSkillName(), recentlyBotSkillInfoDto.getDesc(), recentlyBotSkillInfoDto.getBotName(), recentlyBotSkillInfoDto.getAvatar(), recentlyBotSkillInfoDto.getBotUk(), recentlyBotSkillInfoDto.getSkillId(), recentlyBotSkillInfoDto.getFuncType());
                    robotSkillRecentlyItem.setRoomDetailInfo(this.g, this.h);
                    arrayList.add(robotSkillRecentlyItem);
                    g();
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Nullable
    public final List<tk8> s(@Nullable List<?> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, list, str)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (obj instanceof BotsDTO.BotListDTO.SkillDTO) {
                    BotsDTO.BotListDTO.SkillDTO skillDTO = (BotsDTO.BotListDTO.SkillDTO) obj;
                    String name = skillDTO.getName();
                    String desc = skillDTO.getDesc();
                    int type = skillDTO.getType();
                    boolean isShow = skillDTO.isShow();
                    AbilityItem abilityItem = skillDTO.getAbilityItem();
                    boolean isFuncJump = skillDTO.isFuncJump();
                    if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(desc) && !TextUtils.isEmpty(str) && isShow) {
                        f();
                        arrayList.add(new RobotSkillItem(name, desc, type, str, abilityItem, isFuncJump));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public void v(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.g = j;
            this.h = j2;
        }
    }
}
