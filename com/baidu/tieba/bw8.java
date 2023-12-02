package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.im.lib.socket.msg.data.BotsDTO;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class bw8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull Map<String, Object> map, @NonNull BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO) {
        BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO.Ext ext;
        List<AtSelectData> atUserInfos;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, map, itemsDTO) == null) {
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
}
