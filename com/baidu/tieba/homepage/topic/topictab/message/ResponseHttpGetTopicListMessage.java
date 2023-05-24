package com.baidu.tieba.homepage.topic.topictab.message;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.my7;
import com.baidu.tieba.oy7;
import com.baidu.tieba.rn;
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
/* loaded from: classes5.dex */
public class ResponseHttpGetTopicListMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<rn> mTopicDataList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseHttpGetTopicListMessage() {
        super(CmdConfigHttp.CMD_TOPIC_LIST);
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

    public List<rn> getTopicDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mTopicDataList;
        }
        return (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        NewTopicListResIdl newTopicListResIdl;
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) != null) || (newTopicListResIdl = (NewTopicListResIdl) new Wire(new Class[0]).parseFrom(bArr, NewTopicListResIdl.class)) == null) {
            return;
        }
        setError(newTopicListResIdl.error.errorno.intValue());
        setErrorString(newTopicListResIdl.error.usermsg);
        if (getError() == 0 && (dataRes = newTopicListResIdl.data) != null && !ListUtils.isEmpty(dataRes.topic_list)) {
            this.mTopicDataList = new ArrayList();
            int i2 = 1;
            for (NewTopicList newTopicList : newTopicListResIdl.data.topic_list) {
                if (newTopicList != null && !StringUtils.isNull(newTopicList.topic_name) && !StringUtils.isNull(newTopicList.topic_desc)) {
                    my7 my7Var = new my7();
                    my7Var.R = i2;
                    my7Var.K(newTopicList);
                    this.mTopicDataList.add(my7Var);
                    oy7 oy7Var = new oy7();
                    oy7Var.a = R.dimen.tbds1;
                    oy7Var.b = R.color.CAM_X0203;
                    this.mTopicDataList.add(oy7Var);
                    i2++;
                }
            }
            List<rn> list = this.mTopicDataList;
            ((oy7) ListUtils.getItem(list, list.size() - 1)).a = 0;
        }
    }
}
