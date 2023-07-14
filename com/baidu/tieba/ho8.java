package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.data.EmojiData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ho8 extends np8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.mp8
    public boolean a(int i, boolean z, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), obj})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public ho8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.np8
    @NonNull
    public List<lp8> j(@NonNull List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list.size() > 0) {
                Object obj = list.get(0);
                if (obj instanceof BaseMsg) {
                    BaseMsg baseMsg = (BaseMsg) obj;
                    List<EmojiData> emojiList = baseMsg.getCommonMsgField().getEmojiList();
                    if (emojiList != null && emojiList.size() > 0) {
                        for (EmojiData emojiData : emojiList) {
                            if (emojiData.isAdd().booleanValue()) {
                                arrayList.add(new lo8(baseMsg, emojiData));
                            } else {
                                arrayList.add(new mo8(baseMsg, emojiData));
                            }
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
