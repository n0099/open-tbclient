package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.TbTextGenImageMsg;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.im.lib.socket.msg.data.BotsDTO;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class fy8 extends gq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean e;

    public fy8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = true;
    }

    @Override // com.baidu.tieba.dq8
    public boolean a(int i, boolean z, Object obj) {
        InterceptResult invokeCommon;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), obj})) == null) {
            dq8 dq8Var = this.c;
            if (dq8Var != null) {
                z2 = dq8Var.a(i, z, obj);
            } else {
                z2 = true;
            }
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                cq8 cq8Var = this.a.get(i2);
                if (cq8Var instanceof vy8) {
                    vy8 vy8Var = (vy8) cq8Var;
                    if (vy8Var.d() && i != i2) {
                        vy8Var.e(false);
                        i(i2);
                    } else {
                        if (i == i2) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        vy8Var.e(z3);
                    }
                }
            }
            return z2;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.tieba.gq8
    public List<cq8> j(List list) {
        InterceptResult invokeL;
        List<BotsDTO.BotListDTO.SkillDTO> list2;
        hq8 hq8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                boolean z = true;
                if (i < list.size()) {
                    Object obj = list.get(i);
                    if (obj instanceof BotsDTO.BotListDTO.SkillDTO.ItemsDTO) {
                        BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO = (BotsDTO.BotListDTO.SkillDTO.ItemsDTO) obj;
                        if (itemsDTO.getItemType() == 1) {
                            hq8Var = new iq8(itemsDTO);
                        } else {
                            hq8 hq8Var2 = new hq8(itemsDTO);
                            int i2 = this.d;
                            if (i2 > -1) {
                                if (i != i2) {
                                    z = false;
                                }
                                hq8Var2.n(z);
                            }
                            hq8Var = hq8Var2;
                        }
                        arrayList.add(hq8Var);
                    } else if (obj instanceof BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO) {
                        vy8 vy8Var = new vy8((BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO) obj);
                        int i3 = this.d;
                        if (i3 > -1) {
                            if (i != i3) {
                                z = false;
                            }
                            vy8Var.e(z);
                        }
                        arrayList.add(vy8Var);
                    } else if (obj instanceof TbBaseMsg) {
                        TbTextGenImageMsg tbTextGenImageMsg = (TbTextGenImageMsg) obj;
                        if (tbTextGenImageMsg.getSubSkillConfig() != null && (list2 = tbTextGenImageMsg.getSubSkillConfig().a) != null && !list2.isEmpty()) {
                            if (this.e) {
                                arrayList.add(new ty8());
                                this.e = false;
                            }
                            for (BotsDTO.BotListDTO.SkillDTO skillDTO : list2) {
                                uy8 uy8Var = new uy8(skillDTO);
                                uy8Var.e(tbTextGenImageMsg);
                                arrayList.add(uy8Var);
                            }
                        }
                    } else if (obj instanceof AbilityItem) {
                        arrayList.add(new wy8((AbilityItem) obj));
                    }
                    i++;
                } else {
                    this.e = true;
                    return arrayList;
                }
            }
        } else {
            return (List) invokeL.objValue;
        }
    }
}
