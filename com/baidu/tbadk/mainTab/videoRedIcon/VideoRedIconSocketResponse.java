package com.baidu.tbadk.mainTab.videoRedIcon;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.f45;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.VideoRedIcon.DataRes;
import tbclient.VideoRedIcon.RedIcon;
import tbclient.VideoRedIcon.VideoRedIconResIdl;
/* loaded from: classes3.dex */
public class VideoRedIconSocketResponse extends SocketResponsedMessage implements f45 {
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

    @Override // com.repackage.f45
    public List<RedIcon> getDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.redIcons : (List) invokeV.objValue;
    }

    @Override // com.repackage.f45
    public VideoRedIconResIdl getResData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mData : (VideoRedIconResIdl) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            VideoRedIconResIdl videoRedIconResIdl = (VideoRedIconResIdl) new Wire(new Class[0]).parseFrom(bArr, VideoRedIconResIdl.class);
            this.mData = videoRedIconResIdl;
            if (videoRedIconResIdl == null) {
                return;
            }
            setError(videoRedIconResIdl.error.errorno.intValue());
            setErrorString(videoRedIconResIdl.error.usermsg);
            if (getError() == 0 && (dataRes = videoRedIconResIdl.data) != null) {
                this.redIcons = dataRes.red_icon_list;
            }
        }
    }
}
