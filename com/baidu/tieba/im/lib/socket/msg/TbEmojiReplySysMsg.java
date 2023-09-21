package com.baidu.tieba.im.lib.socket.msg;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.lib.socket.msg.data.EmojiData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/* loaded from: classes6.dex */
public class TbEmojiReplySysMsg extends TbSysMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_TYPE = 20000;
    public static final long serialVersionUID = -2928652517766829057L;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName(Constants.EXTRA_EMOJI_PACKAGE_ID)
    public final int emojiPackageId;
    @SerializedName("emoji_reaction_list")
    public final List<EmojiData> emojiSysDataList;
    @SerializedName("ori_emoji_replied_msg_id")
    public final long oriEmojiRepliedMsgId;
    @SerializedName("ori_emoji_replied_msg_key")
    public final String oriEmojiRepliedMsgKey;
    @SerializedName("msg_from_baidu_uk")
    public final String oriEmojiRepliedMsgSenderBdUk;
    @SerializedName("react_type")
    public final int reactType;

    @Override // com.baidu.tieba.im.lib.socket.msg.TbSysMsg
    public boolean isNoUISysMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public TbEmojiReplySysMsg(int i, @NonNull String str, long j, @NonNull String str2, int i2, @Nullable List<EmojiData> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, Long.valueOf(j), str2, Integer.valueOf(i2), list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setType(20000);
        this.reactType = i;
        this.oriEmojiRepliedMsgSenderBdUk = str;
        this.oriEmojiRepliedMsgId = j;
        this.oriEmojiRepliedMsgKey = str2;
        this.emojiPackageId = i2;
        this.emojiSysDataList = list;
    }

    public static TbEmojiReplySysMsg create(int i, @NonNull String str, long j, @NonNull String str2, int i2, @Nullable List<EmojiData> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), str, Long.valueOf(j), str2, Integer.valueOf(i2), list})) == null) {
            return new TbEmojiReplySysMsg(i, str, j, str2, i2, list);
        }
        return (TbEmojiReplySysMsg) invokeCommon.objValue;
    }

    @Nullable
    public List<EmojiData> getEmojiData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.emojiSysDataList;
        }
        return (List) invokeV.objValue;
    }

    public int getEmojiPackageId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.emojiPackageId;
        }
        return invokeV.intValue;
    }

    public long getOriEmojiRepliedMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.oriEmojiRepliedMsgId;
        }
        return invokeV.longValue;
    }

    @NonNull
    public String getOriEmojiRepliedMsgKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.oriEmojiRepliedMsgKey;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public String getOriEmojiRepliedMsgSenderBdUk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.oriEmojiRepliedMsgSenderBdUk;
        }
        return (String) invokeV.objValue;
    }

    public int getReactType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.reactType;
        }
        return invokeV.intValue;
    }
}
