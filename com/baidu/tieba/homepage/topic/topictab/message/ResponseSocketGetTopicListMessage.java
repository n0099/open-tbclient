package com.baidu.tieba.homepage.topic.topictab.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.q27;
import com.repackage.s27;
import com.repackage.uo;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.NewTopicList.DataRes;
import tbclient.NewTopicList.NewTopicList;
import tbclient.NewTopicList.NewTopicListResIdl;
/* loaded from: classes3.dex */
public class ResponseSocketGetTopicListMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<uo> mTopicDataList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseSocketGetTopicListMessage() {
        super(309628);
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

    public List<uo> getTopicDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mTopicDataList : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        NewTopicListResIdl newTopicListResIdl;
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || (newTopicListResIdl = (NewTopicListResIdl) new Wire(new Class[0]).parseFrom(bArr, NewTopicListResIdl.class)) == null) {
            return;
        }
        setError(newTopicListResIdl.error.errorno.intValue());
        setErrorString(newTopicListResIdl.error.usermsg);
        if (getError() != 0 || (dataRes = newTopicListResIdl.data) == null || ListUtils.isEmpty(dataRes.topic_list)) {
            return;
        }
        this.mTopicDataList = new ArrayList();
        int i2 = 1;
        for (NewTopicList newTopicList : newTopicListResIdl.data.topic_list) {
            if (newTopicList != null && !StringUtils.isNull(newTopicList.topic_name) && !StringUtils.isNull(newTopicList.topic_desc)) {
                q27 q27Var = new q27();
                q27Var.R = i2;
                q27Var.O(newTopicList);
                this.mTopicDataList.add(q27Var);
                s27 s27Var = new s27();
                s27Var.a = R.dimen.tbds1;
                s27Var.b = R.color.CAM_X0203;
                this.mTopicDataList.add(s27Var);
                i2++;
            }
        }
        List<uo> list = this.mTopicDataList;
        ((s27) ListUtils.getItem(list, list.size() - 1)).a = 0;
    }
}
