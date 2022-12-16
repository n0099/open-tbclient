package com.baidu.tieba.im.forum.broadcast.data;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.tieba.wj5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.CommonReq;
import tbclient.GetForumBroadcastList.DataReq;
import tbclient.GetForumBroadcastList.GetForumBroadcastListReqIdl;
/* loaded from: classes4.dex */
public class BroadcastMajorHistoryRequestMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOAD_RN = 15;
    public static final int LOAD_TYPE_LOADMORE = 2;
    public static final int LOAD_TYPE_REFRESH = 1;
    public static final int QUERY_TYPE_BCASTID = 2;
    public static final int QUERY_TYPE_FORUMID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Long> bcastIds;

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f1079common;
    public long forumId;
    public long lastId;
    public int needCount;
    public int queryType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BroadcastMajorHistoryRequestMessage() {
        super(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY, 309669);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.f1212common = this.f1079common;
            builder.query_type = Integer.valueOf(this.queryType);
            builder.forum_id = Long.valueOf(this.forumId);
            builder.need_cnt = Integer.valueOf(this.needCount);
            builder.staff_id = 1;
            builder.bcast_ids = this.bcastIds;
            builder.staff_id64 = Long.valueOf(this.lastId);
            if (z || SocketAddCommonParamSwitch.getIsOn()) {
                wj5.a(builder, true);
            }
            GetForumBroadcastListReqIdl.Builder builder2 = new GetForumBroadcastListReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public void setCommon(CommonReq commonReq) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, commonReq) == null) {
            this.f1079common = commonReq;
        }
    }
}
