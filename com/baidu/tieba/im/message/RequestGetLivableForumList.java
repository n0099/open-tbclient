package com.baidu.tieba.im.message;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import protobuf.GetLivableForumList.DataReq;
import protobuf.GetLivableForumList.GetLivableForumListReqIdl;
/* loaded from: classes5.dex */
public class RequestGetLivableForumList extends TbSocketMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int filterFlag;
    public int likeForumFlag;
    public int pageNo;
    public int pageSize;
    public long userId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestGetLivableForumList() {
        super(107129);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.userId = Long.valueOf(this.userId);
            if (this.likeForumFlag == 1) {
                builder.pageNo = Integer.valueOf(this.pageNo);
                builder.pageSize = Integer.valueOf(this.pageSize);
            }
            builder.likeForumFlag = Integer.valueOf(this.likeForumFlag);
            GetLivableForumListReqIdl.Builder builder2 = new GetLivableForumListReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeV.objValue;
    }

    public void setFilterFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.filterFlag = i2;
        }
    }

    public void setGetLikeForum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.likeForumFlag = i2;
        }
    }

    public void setPageNo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.pageNo = i2;
        }
    }

    public void setPageSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.pageSize = i2;
        }
    }

    public void setUserId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            this.userId = j2;
        }
    }
}
