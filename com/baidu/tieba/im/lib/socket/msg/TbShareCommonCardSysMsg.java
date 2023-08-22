package com.baidu.tieba.im.lib.socket.msg;

import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.data.ImShareCardCommonData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
/* loaded from: classes6.dex */
public class TbShareCommonCardSysMsg extends TbSysMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_TYPE = 7021;
    public static final long serialVersionUID = 6912363044199189133L;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("share_info")
    public ImShareCardCommonData shareCommon;

    @Override // com.baidu.tieba.im.lib.socket.msg.TbSysMsg
    public boolean isConvertToNormalMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public TbShareCommonCardSysMsg() {
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

    @Override // com.baidu.tieba.im.lib.socket.msg.TbSysMsg, com.baidu.tieba.im.lib.socket.msg.TbBaseMsg
    @NonNull
    public CharSequence getThumbnailText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (StringUtils.isNull(this.shareCommon.getThumbText())) {
                int type = this.shareCommon.getType();
                if (type != 1) {
                    if (type != 2) {
                        return TbadkApplication.getInst().getString(R.string.last_msg_nonsupport_share);
                    }
                    return TbadkApplication.getInst().getString(R.string.last_msg_compilation_share);
                }
                return TbadkApplication.getInst().getString(R.string.last_msg_topic_share);
            }
            return this.shareCommon.getThumbText();
        }
        return (CharSequence) invokeV.objValue;
    }
}
