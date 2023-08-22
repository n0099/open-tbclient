package com.baidu.tieba.im.lib.socket.msg;

import android.text.SpannableStringBuilder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ag8;
import com.baidu.tieba.bg8;
import com.baidu.tieba.cw5;
import com.baidu.tieba.im.lib.socket.msg.data.BotsDTO;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
/* loaded from: classes6.dex */
public class TbSingleTextImageMsg extends TbBaseImageMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_TYPE = 102;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    @cw5(serialize = false)
    public CharSequence cacheText;
    @Nullable
    public BotsDTO.BotListDTO.SkillDTO.ItemsDTO fileItem;
    @Nullable
    @SerializedName("robot_params")
    @ag8
    public Map<String, Object> robotParams;
    @bg8
    public String text;
    @cw5(serialize = false)
    public SpannableStringBuilder thumbnailText;

    public TbSingleTextImageMsg() {
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
        setType(102);
    }

    @Nullable
    public CharSequence getCacheText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.cacheText;
        }
        return (CharSequence) invokeV.objValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String str = this.text;
            if (str != null) {
                this.text = str.replaceAll("\r", "\n");
            }
            return this.text;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.lib.socket.msg.TbBaseMsg
    @NonNull
    public CharSequence getThumbnailText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.thumbnailText = TbTextMsg.processThumbnailText(this.thumbnailText, this.text);
            if (!StringUtils.isNull(this.thumbUrl)) {
                this.thumbnailText.append((CharSequence) this.imgThumbnailText);
            }
            return this.thumbnailText;
        }
        return (CharSequence) invokeV.objValue;
    }

    @NonNull
    public static TbSingleTextImageMsg create(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, str3)) == null) {
            TbSingleTextImageMsg tbSingleTextImageMsg = new TbSingleTextImageMsg();
            tbSingleTextImageMsg.text = str;
            tbSingleTextImageMsg.setThumbUrl(str2);
            tbSingleTextImageMsg.setThumbSize(str3);
            tbSingleTextImageMsg.setBigSize(str3);
            return tbSingleTextImageMsg;
        }
        return (TbSingleTextImageMsg) invokeLLL.objValue;
    }

    public void setCacheText(@Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, charSequence) == null) {
            this.cacheText = charSequence;
        }
    }

    public void setFileItem(@Nullable BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, itemsDTO) == null) {
            this.fileItem = itemsDTO;
        }
    }

    public void setRobotParams(@Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, map) == null) {
            this.robotParams = map;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.text = str;
        }
    }
}
