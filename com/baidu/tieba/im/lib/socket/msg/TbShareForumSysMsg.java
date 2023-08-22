package com.baidu.tieba.im.lib.socket.msg;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ShareForumMsgData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import protobuf.ForumInfo;
/* loaded from: classes6.dex */
public class TbShareForumSysMsg extends TbSysMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_TYPE = 7009;
    public static final String SHARE_FORUM_THUMBNAIL_TEXT;
    public static final long serialVersionUID = 665439903596865904L;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("forum_info")
    public ForumInfo forumInfo;
    public ShareForumMsgData shareForumMsgData;

    @Override // com.baidu.tieba.im.lib.socket.msg.TbSysMsg
    public boolean isConvertToNormalMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1097783252, "Lcom/baidu/tieba/im/lib/socket/msg/TbShareForumSysMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1097783252, "Lcom/baidu/tieba/im/lib/socket/msg/TbShareForumSysMsg;");
                return;
            }
        }
        SHARE_FORUM_THUMBNAIL_TEXT = TbadkApplication.getInst().getString(R.string.last_msg_forum_share);
    }

    public TbShareForumSysMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public ShareForumMsgData getForumInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.shareForumMsgData == null) {
                this.shareForumMsgData = ShareForumMsgData.ofImForumInfo(this.forumInfo);
            }
            return this.shareForumMsgData;
        }
        return (ShareForumMsgData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.lib.socket.msg.TbSysMsg, com.baidu.tieba.im.lib.socket.msg.TbBaseMsg
    @NonNull
    public CharSequence getThumbnailText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return SHARE_FORUM_THUMBNAIL_TEXT;
        }
        return (CharSequence) invokeV.objValue;
    }
}
