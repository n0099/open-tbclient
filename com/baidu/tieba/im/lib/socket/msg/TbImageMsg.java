package com.baidu.tieba.im.lib.socket.msg;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class TbImageMsg extends TbBaseImageMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_TYPE = 2;
    public static final long serialVersionUID = 2444733934102528879L;
    public transient /* synthetic */ FieldHolder $fh;

    public TbImageMsg() {
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
        setType(2);
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
    public static TbImageMsg create(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            TbImageMsg tbImageMsg = new TbImageMsg();
            tbImageMsg.setThumbUrl(str);
            tbImageMsg.setThumbSize(str2);
            tbImageMsg.setBigSize(str2);
            return tbImageMsg;
        }
        return (TbImageMsg) invokeLL.objValue;
    }
}
