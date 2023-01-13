package com.baidu.tbadk.mainTab.videoRedIcon;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.VideoRedIcon.DataRes;
import tbclient.VideoRedIcon.RedIcon;
import tbclient.VideoRedIcon.VideoRedIconResIdl;
/* loaded from: classes3.dex */
public class VideoRedIconSocketResponse extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoRedIconResIdl mData;
    public List<RedIcon> redIcons;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoRedIconSocketResponse() {
        super(309708);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public List<RedIcon> getDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.redIcons;
        }
        return (List) invokeV.objValue;
    }

    public VideoRedIconResIdl getResData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mData;
        }
        return (VideoRedIconResIdl) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            VideoRedIconResIdl videoRedIconResIdl = (VideoRedIconResIdl) new Wire(new Class[0]).parseFrom(bArr, VideoRedIconResIdl.class);
            this.mData = videoRedIconResIdl;
            if (videoRedIconResIdl == null) {
                return null;
            }
            setError(videoRedIconResIdl.error.errorno.intValue());
            setErrorString(videoRedIconResIdl.error.usermsg);
            if (getError() != 0) {
                return videoRedIconResIdl;
            }
            DataRes dataRes = videoRedIconResIdl.data;
            if (dataRes == null) {
                return videoRedIconResIdl;
            }
            this.redIcons = dataRes.red_icon_list;
            return videoRedIconResIdl;
        }
        return invokeIL.objValue;
    }
}
