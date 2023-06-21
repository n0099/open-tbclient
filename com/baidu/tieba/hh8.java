package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextGenImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class hh8 extends mi8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean e;

    public hh8() {
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

    @Override // com.baidu.tieba.li8
    public boolean a(int i, boolean z, Object obj) {
        InterceptResult invokeCommon;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), obj})) == null) {
            li8 li8Var = this.c;
            if (li8Var != null) {
                z2 = li8Var.a(i, z, obj);
            } else {
                z2 = true;
            }
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                ki8 ki8Var = this.a.get(i2);
                if (ki8Var instanceof qh8) {
                    qh8 qh8Var = (qh8) ki8Var;
                    if (qh8Var.d() && i != i2) {
                        qh8Var.e(false);
                        i(i2);
                    } else {
                        if (i == i2) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        qh8Var.e(z3);
                    }
                }
            }
            return z2;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.tieba.mi8
    public List<ki8> j(List list) {
        InterceptResult invokeL;
        List<BotsDTO.BotListDTO.SkillDTO> list2;
        oh8 oh8Var;
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
                            oh8Var = new ph8(itemsDTO);
                        } else {
                            oh8 oh8Var2 = new oh8(itemsDTO);
                            int i2 = this.d;
                            if (i2 > -1) {
                                if (i != i2) {
                                    z = false;
                                }
                                oh8Var2.n(z);
                            }
                            oh8Var = oh8Var2;
                        }
                        arrayList.add(oh8Var);
                    } else if (obj instanceof BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO) {
                        qh8 qh8Var = new qh8((BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO) obj);
                        int i3 = this.d;
                        if (i3 > -1) {
                            if (i != i3) {
                                z = false;
                            }
                            qh8Var.e(z);
                        }
                        arrayList.add(qh8Var);
                    } else if (obj instanceof BaseMsg) {
                        TextGenImageMsg textGenImageMsg = (TextGenImageMsg) obj;
                        if (textGenImageMsg.getSubSkillConfig() != null && (list2 = textGenImageMsg.getSubSkillConfig().a) != null && !list2.isEmpty()) {
                            if (this.e) {
                                arrayList.add(new mh8());
                                this.e = false;
                            }
                            for (BotsDTO.BotListDTO.SkillDTO skillDTO : list2) {
                                nh8 nh8Var = new nh8(skillDTO);
                                nh8Var.e(textGenImageMsg);
                                arrayList.add(nh8Var);
                            }
                        }
                    } else if (obj instanceof AbilityItem) {
                        arrayList.add(new rh8((AbilityItem) obj));
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
