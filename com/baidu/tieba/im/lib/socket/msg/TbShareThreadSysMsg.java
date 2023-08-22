package com.baidu.tieba.im.lib.socket.msg;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ShareThreadMsgData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import protobuf.ImShareThreadInfo;
/* loaded from: classes6.dex */
public class TbShareThreadSysMsg extends TbSysMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_TYPE = 7010;
    public static final long serialVersionUID = -5579407175119471201L;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("thread_info")
    public ImShareThreadInfo imShareThreadInfo;
    public ShareThreadMsgData shareThreadMsgData;
    public final String shareThreadThumbnailText;

    @Override // com.baidu.tieba.im.lib.socket.msg.TbSysMsg
    public boolean isConvertToNormalMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public TbShareThreadSysMsg() {
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
        this.shareThreadThumbnailText = TbadkApplication.getInst().getString(R.string.last_msg_thread_share);
    }

    public ShareThreadMsgData getShareThreadMsgData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.shareThreadMsgData == null) {
                this.shareThreadMsgData = ShareThreadMsgData.ofImShareThreadInfo(this.imShareThreadInfo);
            }
            return this.shareThreadMsgData;
        }
        return (ShareThreadMsgData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.lib.socket.msg.TbSysMsg, com.baidu.tieba.im.lib.socket.msg.TbBaseMsg
    @NonNull
    public CharSequence getThumbnailText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.shareThreadThumbnailText;
        }
        return (CharSequence) invokeV.objValue;
    }
}
