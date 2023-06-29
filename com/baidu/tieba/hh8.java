package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AtUserInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.ReMsgInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.SingleTextImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextGenImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class hh8 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public static final String b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947823825, "Lcom/baidu/tieba/hh8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947823825, "Lcom/baidu/tieba/hh8;");
                return;
            }
        }
        a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0921);
        b = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0922);
    }

    public static String a(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str2;
            }
            if (TextUtils.isEmpty(str2)) {
                return String.format(b, str);
            }
            return String.format(a, str, str2);
        }
        return (String) invokeLL.objValue;
    }

    @NonNull
    public static AtUserInfo j(@NonNull BotsDTO.BotListDTO.UserDTO userDTO, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, userDTO, str)) == null) {
            lx5.d(i(userDTO));
            return AtUserInfo.create(AtUserInfo.AtType.USER, Long.parseLong(BIMManager.getBdUidFromBdUK(userDTO.getUk())), str, userDTO.getPortrait(), 0);
        }
        return (AtUserInfo) invokeLL.objValue;
    }

    public static String b(@NonNull List<AtSelectData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            StringBuilder sb = new StringBuilder();
            for (AtSelectData atSelectData : list) {
                sb.append("@");
                sb.append(atSelectData.getNameShow());
                sb.append(" ");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String c(@NonNull String str, @NonNull BotsDTO.BotListDTO.SkillDTO skillDTO, @Nullable List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list, @NonNull List<AtSelectData> list2) {
        InterceptResult invokeLLLL;
        List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO> opts;
        BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO.Ext ext;
        List<AtSelectData> atUserInfos;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, str, skillDTO, list, list2)) == null) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            if (list != null && !list.isEmpty()) {
                for (BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO : list) {
                    if (itemsDTO != null && (opts = itemsDTO.getOpts()) != null && !opts.isEmpty()) {
                        if (itemsDTO.isNormalType()) {
                            sb.append(a(itemsDTO.getName(), opts.get(0).getName()));
                            sb.append("\n");
                        } else if (itemsDTO.isFileType()) {
                            sb2.append(a(itemsDTO.getName(), null));
                            sb2.append("\n");
                        } else if (itemsDTO.isAtType() && (ext = opts.get(0).getExt()) != null && (atUserInfos = ext.getAtUserInfos()) != null && !atUserInfos.isEmpty()) {
                            list2.addAll(atUserInfos);
                            sb.append(a(itemsDTO.getName(), b(atUserInfos)));
                            sb.append("\n");
                        }
                    }
                }
            }
            if (!TextUtils.isEmpty(skillDTO.getAlias()) && !TextUtils.isEmpty(str)) {
                sb.append(a(skillDTO.getAlias(), str));
                sb.append("\n");
            }
            sb.append((CharSequence) sb2);
            return sb.toString();
        }
        return (String) invokeLLLL.objValue;
    }

    public static String d(@NonNull String str, @NonNull String str2, boolean z) {
        InterceptResult invokeLLZ;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, z)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("@");
            sb.append(str);
            if (z) {
                str3 = " ";
            } else {
                str3 = "\n";
            }
            sb.append(str3);
            sb.append(str2);
            return sb.toString();
        }
        return (String) invokeLLZ.objValue;
    }

    @NonNull
    public static String f(@NonNull BotsDTO.BotListDTO.UserDTO userDTO, @NonNull BotsDTO.BotListDTO.SkillDTO skillDTO, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65542, null, userDTO, skillDTO, z)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(userDTO.getNameShow());
            if (!z) {
                sb.append("/");
                sb.append(skillDTO.getName());
            }
            return sb.toString();
        }
        return (String) invokeLLZ.objValue;
    }

    public static HashMap<String, Object> g(@NonNull BotsDTO.BotListDTO.SkillDTO skillDTO, @Nullable List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list, @Nullable String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, skillDTO, list, str)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("type", Integer.valueOf(skillDTO.getType()));
            if (str == null) {
                str = "";
            }
            hashMap.put("promot", str);
            hashMap.put("scene", "tieba_group_chat");
            e(hashMap, list);
            return hashMap;
        }
        return (HashMap) invokeLLL.objValue;
    }

    public static void e(@NonNull Map<String, Object> map, @Nullable List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, null, map, list) == null) && list != null && list.size() > 0) {
            for (BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO : list) {
                if (itemsDTO != null) {
                    o(map, itemsDTO);
                }
            }
        }
    }

    @NonNull
    public static String h(@NonNull String str, @NonNull String str2, @NonNull BotsDTO.BotListDTO.SkillDTO skillDTO, @Nullable List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list, @NonNull List<AtSelectData> list2) {
        InterceptResult invokeLLLLL;
        String str3;
        List<AtSelectData> atUserInfos;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65544, null, str, str2, skillDTO, list, list2)) == null) {
            lx5.b(str);
            String replaceAll = str.replaceAll(skillDTO.getAliasHolder(), skillDTO.getAlias()).replaceAll(skillDTO.getKeyboardHolder(), str2);
            if (list != null && !list.isEmpty()) {
                for (BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO : list) {
                    if (itemsDTO != null) {
                        String value = itemsDTO.getValue();
                        replaceAll = replaceAll.replaceAll(itemsDTO.getNameHolder(), itemsDTO.getName()).replaceAll(itemsDTO.getAliasHolder(), itemsDTO.getAlias());
                        List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO> opts = itemsDTO.getOpts();
                        if (opts != null && !opts.isEmpty() && !TextUtils.isEmpty(value)) {
                            BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO optsDTO = opts.get(0);
                            if (itemsDTO.isNormalType()) {
                                replaceAll = replaceAll.replaceAll(optsDTO.getNameHolder(value), optsDTO.getName()).replaceAll(optsDTO.getAliasHolder(value), optsDTO.getAlias());
                            } else if (itemsDTO.isAtType()) {
                                BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO.Ext ext = optsDTO.getExt();
                                if (ext != null && (atUserInfos = ext.getAtUserInfos()) != null && !atUserInfos.isEmpty()) {
                                    list2.addAll(atUserInfos);
                                    str3 = b(atUserInfos);
                                } else {
                                    str3 = "";
                                }
                                replaceAll = replaceAll.replaceAll(optsDTO.getNameHolder(value), str3).replaceAll(optsDTO.getAliasHolder(value), str3);
                            }
                        }
                    }
                }
            }
            return replaceAll;
        }
        return (String) invokeLLLLL.objValue;
    }

    public static TextMsg l(@NonNull String str, @Nullable BaseMsg baseMsg, @NonNull nf8 nf8Var, @Nullable List<AtSelectData> list, @Nullable Map<String, Integer> map) {
        InterceptResult invokeLLLLL;
        boolean z;
        String c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65548, null, str, baseMsg, nf8Var, list, map)) == null) {
            BotsDTO.BotListDTO.UserDTO userDTO = nf8Var.a;
            BotsDTO.BotListDTO.SkillDTO skillDTO = nf8Var.b;
            List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list2 = nf8Var.c;
            if (userDTO != null && skillDTO != null && i(userDTO)) {
                ArrayList arrayList = new ArrayList();
                if (list != null) {
                    arrayList.addAll(list);
                }
                String showTemplate = skillDTO.getShowTemplate(list2);
                if (showTemplate != null && !TextUtils.isEmpty(showTemplate)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    c = h(showTemplate, str, skillDTO, list2, arrayList);
                } else {
                    c = c(str, skillDTO, list2, arrayList);
                }
                String f = f(userDTO, skillDTO, z);
                String q = q(d(f, c, z));
                TextMsg create = TextMsg.create(q);
                create.addAtUserInfo(j(userDTO, f));
                create.addAtUserInfo(n(q, arrayList));
                HashMap<String, Object> g = g(skillDTO, list2, str);
                if (baseMsg == null) {
                    create.setRobotParams(g);
                    return create;
                }
                if (nf8Var.c()) {
                    create.setReMsgInfo(ReMsgInfo.create(baseMsg, baseMsg.getThumbnailText().toString()));
                }
                if (baseMsg.getReMsgInfo() != null) {
                    if (baseMsg instanceof TextGenImageMsg) {
                        g.put("last_promot", ((TextGenImageMsg) baseMsg).getLastPrompt());
                    }
                    g.put("user_msg_id", Long.valueOf(baseMsg.getReMsgInfo().getMsgId()));
                    g.put("user_msg_key", baseMsg.getReMsgInfo().getMsgKey());
                }
                if (baseMsg.getTaskInfo() != null) {
                    g.put("robot_msg_id", Long.valueOf(baseMsg.getTaskInfo().getOriginMsgId()));
                    g.put("robot_msg_key", baseMsg.getTaskInfo().getOriginMsgKey());
                }
                create.setRobotParams(g);
                return create;
            }
            return k(str, list, map);
        }
        return (TextMsg) invokeLLLLL.objValue;
    }

    public static boolean i(@NonNull BotsDTO.BotListDTO.UserDTO userDTO) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, userDTO)) == null) {
            try {
                String bdUidFromBdUK = BIMManager.getBdUidFromBdUK(userDTO.getUk());
                if (TextUtils.isEmpty(bdUidFromBdUK)) {
                    return false;
                }
                Long.parseLong(bdUidFromBdUK);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String q(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            if (str.endsWith("\n")) {
                return str.substring(0, str.length() - 1);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public static TextMsg k(@NonNull String str, @Nullable List<AtSelectData> list, @Nullable Map<String, Integer> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, str, list, map)) == null) {
            TextMsg create = TextMsg.create(str);
            create.addAtUserInfo(p(list, map));
            return create;
        }
        return (TextMsg) invokeLLL.objValue;
    }

    public static TextMsg m(@NonNull String str, @Nullable BaseMsg baseMsg, @Nullable nf8 nf8Var, @Nullable List<AtSelectData> list, @Nullable Map<String, Integer> map) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65549, null, str, baseMsg, nf8Var, list, map)) == null) {
            if (nf8Var == null) {
                return k(str, list, map);
            }
            return l(str, baseMsg, nf8Var, list, map);
        }
        return (TextMsg) invokeLLLLL.objValue;
    }

    @NonNull
    public static List<AtUserInfo> n(@NonNull String str, @NonNull List<AtSelectData> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, list)) == null) {
            HashMap hashMap = new HashMap();
            for (AtSelectData atSelectData : list) {
                int i = 0;
                String str2 = "@" + atSelectData.getNameShow();
                while (true) {
                    int indexOf = str.indexOf(str2, i);
                    if (indexOf == -1) {
                        break;
                    }
                    i = indexOf + 1;
                    if (hashMap.get(Integer.valueOf(indexOf)) == null) {
                        AtUserInfo.AtType atType = AtUserInfo.AtType.USER;
                        if (AtSelectData.AT_ALL_FAKE_UID.equals(atSelectData.getUid())) {
                            atType = AtUserInfo.AtType.ALL;
                        }
                        hashMap.put(Integer.valueOf(indexOf), AtUserInfo.create(atType, vg.g(atSelectData.getUid(), 0L), atSelectData.getNameShow(), atSelectData.getPortrait(), indexOf));
                    }
                }
            }
            return new ArrayList(hashMap.values());
        }
        return (List) invokeLL.objValue;
    }

    @NonNull
    public static List<AtUserInfo> p(@Nullable List<AtSelectData> list, @Nullable Map<String, Integer> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, list, map)) == null) {
            if (list != null && !list.isEmpty() && map != null && !map.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (AtSelectData atSelectData : list) {
                    AtUserInfo.AtType atType = AtUserInfo.AtType.USER;
                    if (AtSelectData.AT_ALL_FAKE_UID.equals(atSelectData.getUid())) {
                        atType = AtUserInfo.AtType.ALL;
                    }
                    arrayList.add(AtUserInfo.create(atType, vg.g(atSelectData.getUid(), 0L), atSelectData.getNameShow(), atSelectData.getPortrait(), map.get(atSelectData.getUid()).intValue()));
                }
                return arrayList;
            }
            return Collections.emptyList();
        }
        return (List) invokeLL.objValue;
    }

    public static void o(@NonNull Map<String, Object> map, @NonNull BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO) {
        BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO.Ext ext;
        List<AtSelectData> atUserInfos;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, map, itemsDTO) == null) {
            Map map2 = (Map) map.get("opts");
            if (map2 == null) {
                map2 = new HashMap();
                map.put("opts", map2);
            }
            List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO> opts = itemsDTO.getOpts();
            if (opts != null && !opts.isEmpty()) {
                String str = null;
                if (itemsDTO.isNormalType()) {
                    str = opts.get(0).getName();
                } else if (itemsDTO.isFileType()) {
                    BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO.Ext ext2 = opts.get(0).getExt();
                    if (ext2 != null) {
                        str = ext2.getPicPath();
                    }
                } else if (itemsDTO.isAtType() && (ext = opts.get(0).getExt()) != null && (atUserInfos = ext.getAtUserInfos()) != null && !atUserInfos.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < atUserInfos.size(); i++) {
                        sb.append(BIMManager.getBdUKFromBdUid(atUserInfos.get(i).getUid()));
                        if (i < atUserInfos.size() - 1) {
                            sb.append(",");
                        }
                    }
                    str = sb.toString();
                }
                if (str != null && !str.isEmpty()) {
                    map2.put(itemsDTO.getValue(), str);
                }
            }
        }
    }

    @NonNull
    public static BaseChatMsg<?> r(@NonNull TextMsg textMsg, @Nullable nf8 nf8Var) {
        InterceptResult invokeLL;
        BotsDTO.BotListDTO.SkillDTO.ItemsDTO b2;
        List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO> opts;
        BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO.Ext ext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, textMsg, nf8Var)) == null) {
            if (nf8Var != null && (b2 = nf8Var.b()) != null && (opts = b2.getOpts()) != null && !opts.isEmpty() && (ext = opts.get(0).getExt()) != null) {
                SingleTextImageMsg create = SingleTextImageMsg.create(textMsg.getText(), ext.getPicPath(), ext.getPicSize());
                create.fillSdkMsg4Base(textMsg);
                create.setRobotParams(textMsg.getRobotParams());
                create.setFileItem(b2);
                return create;
            }
            return textMsg;
        }
        return (BaseChatMsg) invokeLL.objValue;
    }
}
