package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.immessagecenter.chatgroup.data.AtInfo;
import com.baidu.tieba.immessagecenter.chatgroup.data.AtInfoMsg;
import com.baidu.tieba.immessagecenter.chatgroup.data.ReplyEmojiMsgInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class h09 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ChatRoomDetail a;

    public h09() {
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

    public final Map<String, AtInfoMsg> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            ChatRoomDetail chatRoomDetail = this.a;
            if (chatRoomDetail != null) {
                Intrinsics.checkNotNull(chatRoomDetail);
                if (chatRoomDetail.getAtInfo() != null) {
                    ChatRoomDetail chatRoomDetail2 = this.a;
                    Intrinsics.checkNotNull(chatRoomDetail2);
                    AtInfo atInfo = chatRoomDetail2.getAtInfo();
                    Intrinsics.checkNotNull(atInfo);
                    if (atInfo.getCountAll() > 0) {
                        ChatRoomDetail chatRoomDetail3 = this.a;
                        Intrinsics.checkNotNull(chatRoomDetail3);
                        AtInfo atInfo2 = chatRoomDetail3.getAtInfo();
                        Intrinsics.checkNotNull(atInfo2);
                        List<AtInfoMsg> allMsgList = atInfo2.getAllMsgList();
                        List<AtInfoMsg> singleMsgList = atInfo2.getSingleMsgList();
                        if (!ListUtils.isEmpty(allMsgList) && ListUtils.isEmpty(singleMsgList)) {
                            String string = UtilHelper.getString(R.string.obfuscated_res_0x7f0f0409);
                            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.chat_at_all)");
                            Intrinsics.checkNotNull(allMsgList);
                            AtInfoMsg atInfoMsg = allMsgList.get(0);
                            Intrinsics.checkNotNullExpressionValue(atInfoMsg, "atAllMsgList!![0]");
                            hashMap.put(string, atInfoMsg);
                        } else if (ListUtils.isEmpty(allMsgList) && !ListUtils.isEmpty(singleMsgList)) {
                            String string2 = UtilHelper.getString(R.string.obfuscated_res_0x7f0f040a);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.chat_at_me)");
                            Intrinsics.checkNotNull(singleMsgList);
                            AtInfoMsg atInfoMsg2 = singleMsgList.get(0);
                            Intrinsics.checkNotNullExpressionValue(atInfoMsg2, "atSingleMsgList!![0]");
                            hashMap.put(string2, atInfoMsg2);
                        } else if (!ListUtils.isEmpty(allMsgList) && !ListUtils.isEmpty(singleMsgList)) {
                            Intrinsics.checkNotNull(singleMsgList);
                            AtInfoMsg atSingle = singleMsgList.get(0);
                            Intrinsics.checkNotNull(allMsgList);
                            AtInfoMsg atAll = allMsgList.get(0);
                            if (atSingle.getMsgId() > atAll.getMsgId()) {
                                String string3 = UtilHelper.getString(R.string.obfuscated_res_0x7f0f0409);
                                Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.chat_at_all)");
                                Intrinsics.checkNotNullExpressionValue(atAll, "atAll");
                                hashMap.put(string3, atAll);
                            } else {
                                String string4 = UtilHelper.getString(R.string.obfuscated_res_0x7f0f040a);
                                Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.chat_at_me)");
                                Intrinsics.checkNotNullExpressionValue(atSingle, "atSingle");
                                hashMap.put(string4, atSingle);
                            }
                        }
                    }
                }
                ChatRoomDetail chatRoomDetail4 = this.a;
                Intrinsics.checkNotNull(chatRoomDetail4);
                if (chatRoomDetail4.getReplyEmojiMsgInfo() != null) {
                    ChatRoomDetail chatRoomDetail5 = this.a;
                    Intrinsics.checkNotNull(chatRoomDetail5);
                    ReplyEmojiMsgInfo replyEmojiMsgInfo = chatRoomDetail5.getReplyEmojiMsgInfo();
                    Intrinsics.checkNotNull(replyEmojiMsgInfo);
                    if (replyEmojiMsgInfo.getCount() > 0) {
                        ChatRoomDetail chatRoomDetail6 = this.a;
                        Intrinsics.checkNotNull(chatRoomDetail6);
                        ReplyEmojiMsgInfo replyEmojiMsgInfo2 = chatRoomDetail6.getReplyEmojiMsgInfo();
                        Intrinsics.checkNotNull(replyEmojiMsgInfo2);
                        List<AtInfoMsg> msgList = replyEmojiMsgInfo2.getMsgList();
                        if (!ListUtils.isEmpty(msgList)) {
                            String string5 = UtilHelper.getString(R.string.obfuscated_res_0x7f0f0412);
                            Intrinsics.checkNotNullExpressionValue(string5, "getString(R.string.chat_emoji_reply)");
                            hashMap.put(string5, msgList.get(0));
                        }
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ChatRoomDetail chatRoomDetail = this.a;
            boolean z = false;
            if (chatRoomDetail != null) {
                Intrinsics.checkNotNull(chatRoomDetail);
                if (chatRoomDetail.getAtInfo() != null) {
                    ChatRoomDetail chatRoomDetail2 = this.a;
                    Intrinsics.checkNotNull(chatRoomDetail2);
                    AtInfo atInfo = chatRoomDetail2.getAtInfo();
                    Intrinsics.checkNotNull(atInfo);
                    if (atInfo.getCountAll() > 0) {
                        z = true;
                    }
                }
                if (!z) {
                    ChatRoomDetail chatRoomDetail3 = this.a;
                    Intrinsics.checkNotNull(chatRoomDetail3);
                    if (chatRoomDetail3.getReplyEmojiMsgInfo() != null) {
                        ChatRoomDetail chatRoomDetail4 = this.a;
                        Intrinsics.checkNotNull(chatRoomDetail4);
                        ReplyEmojiMsgInfo replyEmojiMsgInfo = chatRoomDetail4.getReplyEmojiMsgInfo();
                        Intrinsics.checkNotNull(replyEmojiMsgInfo);
                        if (replyEmojiMsgInfo.getCount() > 0) {
                            return true;
                        }
                    }
                }
                return z;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void c(ChatRoomDetail chatRoomDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatRoomDetail) == null) {
            this.a = chatRoomDetail;
        }
    }
}
