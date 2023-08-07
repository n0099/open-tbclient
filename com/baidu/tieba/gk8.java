package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.data.EmojiData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.data.Reaction;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class gk8 {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;
    public static final int b;
    public static final int c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947796917, "Lcom/baidu/tieba/gk8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947796917, "Lcom/baidu/tieba/gk8;");
                return;
            }
        }
        a = UtilHelper.getDimenPixelSize(R.dimen.tbds28_5);
        b = UtilHelper.getDimenPixelSize(R.dimen.tbds31);
        c = UtilHelper.getDimenPixelSize(R.dimen.tbds83);
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return (BdUtilHelper.getEquipmentWidth(TbadkApplication.getInst()) - (a * 2)) / ((b * 2) + c);
        }
        return invokeV.intValue;
    }

    @Nullable
    public static EmojiData b(@NonNull String str, @NonNull List<EmojiData> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, list)) == null) {
            try {
                URL url = new URL(str);
                for (EmojiData emojiData : list) {
                    URL url2 = new URL(emojiData.getContent());
                    if (url.getHost().equals(url2.getHost()) && url.getPath().equals(url2.getPath())) {
                        return emojiData;
                    }
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (EmojiData) invokeLL.objValue;
    }

    public static boolean c(@NonNull GroupInputViewController groupInputViewController) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, groupInputViewController)) == null) {
            return !groupInputViewController.k1(Arrays.asList(Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_MUZZLE_ALL), Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_FROZEN), Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_MUZZLE)));
        }
        return invokeL.booleanValue;
    }

    public static boolean d(@NonNull Reaction reaction, @NonNull List<EmojiData> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, reaction, list)) == null) {
            EmojiData b2 = b(reaction.getContent(), list);
            if (b2 != null) {
                return b2.hasReplied();
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void e(@NonNull fj8 fj8Var, int i, @NonNull BaseMsg baseMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65541, null, fj8Var, i, baseMsg) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("scene", Integer.valueOf(i));
            fj8Var.d(new AbilityItem("open_emoji_panel", hashMap, null), baseMsg, null);
        }
    }

    public static void f(@NonNull fj8 fj8Var, @NonNull EmojiData emojiData, @NonNull BaseMsg baseMsg, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65542, null, fj8Var, emojiData, baseMsg, i) == null) {
            g(fj8Var, new Reaction("", emojiData.getContent()), baseMsg, i);
        }
    }

    public static void g(@NonNull fj8 fj8Var, @NonNull Reaction reaction, @NonNull BaseMsg baseMsg, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65543, null, fj8Var, reaction, baseMsg, i) == null) {
            List<EmojiData> emojiList = baseMsg.getCommonMsgField().getEmojiList();
            boolean z = true;
            if (emojiList != null) {
                boolean d = d(reaction, emojiList);
                if (i != 1) {
                    int i2 = 2;
                    if (i == 2) {
                        z = true ^ d;
                        if (!z) {
                            i2 = 3;
                        }
                        ym8.h(i2);
                    }
                } else if (d) {
                    return;
                } else {
                    ym8.h(1);
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("content", reaction.getContent());
            hashMap.put(SpeedStatsUtils.UBC_KEY_OPTION, Boolean.valueOf(z));
            fj8Var.d(new AbilityItem("send_emoji_msg", hashMap, null), baseMsg, null);
        }
    }
}
