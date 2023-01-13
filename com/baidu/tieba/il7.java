package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.AtUserInfo;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.ReMsgInfo;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.TextGenImageMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.TextMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class il7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(@Nullable String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str2;
            }
            return TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0839, new Object[]{str, str2});
        }
        return (String) invokeLL.objValue;
    }

    @Nullable
    public static AtUserInfo b(@NonNull BotsDTO.BotListDTO.UserDTO userDTO, @NonNull BotsDTO.BotListDTO.SkillDTO skillDTO) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, userDTO, skillDTO)) == null) {
            String bdUidFromBdUK = BIMManager.getBdUidFromBdUK(userDTO.getUk());
            if (TextUtils.isEmpty(bdUidFromBdUK)) {
                return null;
            }
            try {
                return AtUserInfo.create(AtUserInfo.AtType.USER, Long.parseLong(bdUidFromBdUK), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f083b, new Object[]{userDTO.getNameShow(), skillDTO.getName()}), userDTO.getPortrait(), 0);
            } catch (Exception e) {
                if (!TbadkCoreApplication.getInst().isDebugMode()) {
                    e.printStackTrace();
                    return null;
                }
                throw e;
            }
        }
        return (AtUserInfo) invokeLL.objValue;
    }

    public static TextMsg c(@NonNull String str, @NonNull xk7 xk7Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, xk7Var)) == null) {
            BotsDTO.BotListDTO.UserDTO userDTO = xk7Var.a;
            BotsDTO.BotListDTO.SkillDTO skillDTO = xk7Var.b;
            List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list = xk7Var.c;
            if (userDTO != null && skillDTO != null) {
                TextMsg create = TextMsg.create(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f083a, new Object[]{userDTO.getNameShow(), skillDTO.getName(), a(skillDTO.getAlias(), str)}));
                AtUserInfo b = b(userDTO, skillDTO);
                if (b == null) {
                    return TextMsg.create(str);
                }
                create.addAtUserInfo(b);
                HashMap hashMap = new HashMap();
                hashMap.put("type", Integer.valueOf(skillDTO.getType()));
                hashMap.put("promot", str);
                hashMap.put("scene", "tieba_group_chat");
                HashMap hashMap2 = new HashMap();
                if (!ListUtils.isEmpty(list)) {
                    for (BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO : list) {
                        if (itemsDTO != null && !ListUtils.isEmpty(itemsDTO.getOpts())) {
                            hashMap2.put(itemsDTO.getValue(), itemsDTO.getOpts().get(0).getName());
                        }
                    }
                }
                hashMap.put("opts", hashMap2);
                create.setRobotParams(hashMap);
                return create;
            }
            return TextMsg.create(str);
        }
        return (TextMsg) invokeLL.objValue;
    }

    public static TextMsg d(@NonNull String str, @NonNull BaseMsg baseMsg, @NonNull xk7 xk7Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, baseMsg, xk7Var)) == null) {
            BotsDTO.BotListDTO.UserDTO userDTO = xk7Var.a;
            BotsDTO.BotListDTO.SkillDTO skillDTO = xk7Var.b;
            List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list = xk7Var.c;
            if (userDTO != null && skillDTO != null) {
                StringBuilder sb = new StringBuilder();
                if (!ListUtils.isEmpty(list)) {
                    for (BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO : list) {
                        if (itemsDTO != null && !ListUtils.isEmpty(itemsDTO.getOpts())) {
                            sb.append(a(itemsDTO.getName(), itemsDTO.getOpts().get(0).getName()));
                            sb.append("\n");
                        }
                    }
                }
                if (!TextUtils.isEmpty(skillDTO.getAlias()) && !TextUtils.isEmpty(str)) {
                    sb.append(a(skillDTO.getAlias(), str));
                }
                String sb2 = sb.toString();
                if (sb2.endsWith("\n")) {
                    sb2 = sb2.substring(0, sb2.length() - 1);
                }
                TextMsg create = TextMsg.create(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f083a, new Object[]{userDTO.getNameShow(), skillDTO.getName(), sb2}));
                AtUserInfo b = b(userDTO, skillDTO);
                if (b == null) {
                    return TextMsg.create(str);
                }
                create.addAtUserInfo(b);
                create.setReMsgInfo(ReMsgInfo.create(baseMsg.getMsgType(), baseMsg.getSdkMsg().getMsgType(), baseMsg.getCommonMsgField().getUserId(), baseMsg.getCommonMsgField().getUserName(), baseMsg.getCommonMsgField().getMsgId(), baseMsg.getCommonMsgField().getMsgKey(), baseMsg.getThumbnailText().toString()));
                HashMap hashMap = new HashMap();
                hashMap.put("type", Integer.valueOf(skillDTO.getType()));
                hashMap.put("promot", str);
                hashMap.put("scene", "tieba_group_chat");
                if (baseMsg.getReMsgInfo() != null) {
                    if (baseMsg instanceof TextGenImageMsg) {
                        hashMap.put("last_promot", ((TextGenImageMsg) baseMsg).getLastPrompt());
                    }
                    hashMap.put("user_msg_id", Long.valueOf(baseMsg.getReMsgInfo().getMsgId()));
                    hashMap.put("user_msg_key", baseMsg.getReMsgInfo().getMsgKey());
                }
                if (baseMsg.getTaskInfo() != null) {
                    hashMap.put("robot_msg_id", Long.valueOf(baseMsg.getTaskInfo().getOriginMsgId()));
                    hashMap.put("robot_msg_key", baseMsg.getTaskInfo().getOriginMsgKey());
                }
                HashMap hashMap2 = new HashMap();
                if (!ListUtils.isEmpty(list)) {
                    for (BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO2 : list) {
                        if (itemsDTO2 != null && !ListUtils.isEmpty(itemsDTO2.getOpts())) {
                            hashMap2.put(itemsDTO2.getValue(), itemsDTO2.getOpts().get(0).getName());
                        }
                    }
                }
                hashMap.put("opts", hashMap2);
                create.setRobotParams(hashMap);
                return create;
            }
            return TextMsg.create(str);
        }
        return (TextMsg) invokeLLL.objValue;
    }

    public static TextMsg e(@NonNull String str, @Nullable BaseMsg baseMsg, @Nullable xk7 xk7Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, baseMsg, xk7Var)) == null) {
            if (xk7Var == null) {
                return TextMsg.create(str);
            }
            if (baseMsg == null) {
                return c(str, xk7Var);
            }
            return d(str, baseMsg, xk7Var);
        }
        return (TextMsg) invokeLLL.objValue;
    }
}
