package com.baidu.tieba.homepage.topic.topictab.message;

import androidx.annotation.Nullable;
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
import com.repackage.on;
import com.repackage.p37;
import com.repackage.r37;
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
    public List<on> mTopicDataList;

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

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            NewTopicListResIdl newTopicListResIdl = (NewTopicListResIdl) new Wire(new Class[0]).parseFrom(bArr, NewTopicListResIdl.class);
            if (newTopicListResIdl == null) {
                return null;
            }
            setError(newTopicListResIdl.error.errorno.intValue());
            setErrorString(newTopicListResIdl.error.usermsg);
            if (getError() == 0 && (dataRes = newTopicListResIdl.data) != null && !ListUtils.isEmpty(dataRes.topic_list)) {
                this.mTopicDataList = new ArrayList();
                int i2 = 1;
                for (NewTopicList newTopicList : newTopicListResIdl.data.topic_list) {
                    if (newTopicList != null && !StringUtils.isNull(newTopicList.topic_name) && !StringUtils.isNull(newTopicList.topic_desc)) {
                        p37 p37Var = new p37();
                        p37Var.R = i2;
                        p37Var.O(newTopicList);
                        this.mTopicDataList.add(p37Var);
                        r37 r37Var = new r37();
                        r37Var.a = R.dimen.tbds1;
                        r37Var.b = R.color.CAM_X0203;
                        this.mTopicDataList.add(r37Var);
                        i2++;
                    }
                }
                List<on> list = this.mTopicDataList;
                ((r37) ListUtils.getItem(list, list.size() - 1)).a = 0;
            }
            return newTopicListResIdl;
        }
        return invokeIL.objValue;
    }

    public List<on> getTopicDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mTopicDataList : (List) invokeV.objValue;
    }
}
