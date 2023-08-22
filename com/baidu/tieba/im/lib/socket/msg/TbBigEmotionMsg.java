package com.baidu.tieba.im.lib.socket.msg;

import androidx.annotation.NonNull;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.spswitch.utils.EmotionUbcHelper;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.ag8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
/* loaded from: classes6.dex */
public class TbBigEmotionMsg extends TbBaseImageMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_TYPE = 4;
    public static final long serialVersionUID = 8778630731654009426L;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("emoticon_content")
    @ag8
    public EmotionContent emoticonContent;

    /* loaded from: classes6.dex */
    public static class EmotionContent extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -2675493860347749553L;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName(EmotionUbcHelper.MEME_ID)
        public String memeId;
        @SerializedName("meme_type")
        public String memeType;

        public EmotionContent() {
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
    }

    public TbBigEmotionMsg() {
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
        setType(4);
    }

    @Override // com.baidu.tieba.im.lib.socket.msg.TbBaseMsg
    @NonNull
    public CharSequence getThumbnailText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.imgThumbnailText;
        }
        return (CharSequence) invokeV.objValue;
    }

    @NonNull
    public static TbBigEmotionMsg create(@NonNull String str, @NonNull String str2, @NonNull Map<String, Object> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, map)) == null) {
            TbBigEmotionMsg tbBigEmotionMsg = new TbBigEmotionMsg();
            tbBigEmotionMsg.setThumbUrl(str);
            tbBigEmotionMsg.setThumbSize(str2);
            tbBigEmotionMsg.setBigSize(str2);
            tbBigEmotionMsg.emoticonContent = (EmotionContent) DataExt.toEntity(map, EmotionContent.class);
            return tbBigEmotionMsg;
        }
        return (TbBigEmotionMsg) invokeLLL.objValue;
    }
}
