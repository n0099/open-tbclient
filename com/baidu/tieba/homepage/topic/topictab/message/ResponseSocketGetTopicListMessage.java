package com.baidu.tieba.homepage.topic.topictab.message;

import c.a.e.l.e.n;
import c.a.q0.f1.k.b.c.a;
import c.a.q0.f1.k.b.c.c;
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
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.NewTopicList.DataRes;
import tbclient.NewTopicList.NewTopicList;
import tbclient.NewTopicList.NewTopicListResIdl;
/* loaded from: classes7.dex */
public class ResponseSocketGetTopicListMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<n> mTopicDataList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseSocketGetTopicListMessage() {
        super(309628);
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

    public List<n> getTopicDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mTopicDataList : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        NewTopicListResIdl newTopicListResIdl;
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || (newTopicListResIdl = (NewTopicListResIdl) new Wire(new Class[0]).parseFrom(bArr, NewTopicListResIdl.class)) == null) {
            return;
        }
        setError(newTopicListResIdl.error.errorno.intValue());
        setErrorString(newTopicListResIdl.error.usermsg);
        if (getError() != 0 || (dataRes = newTopicListResIdl.data) == null || ListUtils.isEmpty(dataRes.topic_list)) {
            return;
        }
        this.mTopicDataList = new ArrayList();
        int i3 = 1;
        for (NewTopicList newTopicList : newTopicListResIdl.data.topic_list) {
            if (newTopicList != null && !StringUtils.isNull(newTopicList.topic_name) && !StringUtils.isNull(newTopicList.topic_desc)) {
                a aVar = new a();
                aVar.U = i3;
                aVar.Q(newTopicList);
                this.mTopicDataList.add(aVar);
                c cVar = new c();
                cVar.f18013e = R.dimen.tbds1;
                cVar.f18014f = R.color.CAM_X0203;
                this.mTopicDataList.add(cVar);
                i3++;
            }
        }
        List<n> list = this.mTopicDataList;
        ((c) ListUtils.getItem(list, list.size() - 1)).f18013e = 0;
    }
}
