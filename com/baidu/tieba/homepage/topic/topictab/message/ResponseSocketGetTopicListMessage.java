package com.baidu.tieba.homepage.topic.topictab.message;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.cn;
import com.baidu.tieba.ea8;
import com.baidu.tieba.ga8;
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
/* loaded from: classes6.dex */
public class ResponseSocketGetTopicListMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<cn> mTopicDataList;

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

    public List<cn> getTopicDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mTopicDataList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            NewTopicListResIdl newTopicListResIdl = (NewTopicListResIdl) new Wire(new Class[0]).parseFrom(bArr, NewTopicListResIdl.class);
            if (newTopicListResIdl == null) {
                return null;
            }
            setError(newTopicListResIdl.error.errorno.intValue());
            setErrorString(newTopicListResIdl.error.usermsg);
            if (getError() != 0) {
                return newTopicListResIdl;
            }
            DataRes dataRes = newTopicListResIdl.data;
            if (dataRes != null && !ListUtils.isEmpty(dataRes.topic_list)) {
                this.mTopicDataList = new ArrayList();
                int i2 = 1;
                for (NewTopicList newTopicList : newTopicListResIdl.data.topic_list) {
                    if (newTopicList != null && !StringUtils.isNull(newTopicList.topic_name) && !StringUtils.isNull(newTopicList.topic_desc)) {
                        ea8 ea8Var = new ea8();
                        ea8Var.R = i2;
                        ea8Var.H(newTopicList);
                        this.mTopicDataList.add(ea8Var);
                        this.mTopicDataList.add(new ga8());
                        i2++;
                    }
                }
                List<cn> list = this.mTopicDataList;
                ((ga8) ListUtils.getItem(list, list.size() - 1)).a = 0;
            }
            return newTopicListResIdl;
        }
        return invokeIL.objValue;
    }
}
