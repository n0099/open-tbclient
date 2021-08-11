package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.HashMap;
import java.util.LinkedList;
import tbclient.Error;
import tbclient.GetHistoryForum.DataRes;
import tbclient.GetHistoryForum.GetHistoryForumResIdl;
import tbclient.HistoryForumInfo;
/* loaded from: classes7.dex */
public class RecentlyVisitedForumHttpResponseMessage extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<VisitedForumData> mForumData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecentlyVisitedForumHttpResponseMessage() {
        super(CmdConfigHttp.CMD_GET_HISTORY_FORUM);
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

    public LinkedList<VisitedForumData> getForumData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mForumData : (LinkedList) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetHistoryForumResIdl getHistoryForumResIdl;
        DataRes dataRes;
        Long l;
        String str;
        Integer num;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || (getHistoryForumResIdl = (GetHistoryForumResIdl) new Wire(new Class[0]).parseFrom(bArr, GetHistoryForumResIdl.class)) == null) {
            return;
        }
        Error error = getHistoryForumResIdl.error;
        if (error != null && (num = error.errorno) != null) {
            setError(num.intValue());
        }
        Error error2 = getHistoryForumResIdl.error;
        if (error2 != null && (str = error2.usermsg) != null && str.length() > 0) {
            setErrorString(getHistoryForumResIdl.error.usermsg);
        }
        if (getError() != 0 || (dataRes = getHistoryForumResIdl.data) == null || dataRes.history_forum == null) {
            return;
        }
        this.mForumData = new LinkedList<>();
        HashMap hashMap = new HashMap();
        if (!ListUtils.isEmpty(getHistoryForumResIdl.data.this_week_forums)) {
            for (HistoryForumInfo historyForumInfo : getHistoryForumResIdl.data.this_week_forums) {
                if (historyForumInfo != null && (l = historyForumInfo.forum_id) != null) {
                    hashMap.put(l, historyForumInfo);
                }
            }
        }
        for (HistoryForumInfo historyForumInfo2 : getHistoryForumResIdl.data.history_forum) {
            if (historyForumInfo2 != null && historyForumInfo2.forum_id != null) {
                VisitedForumData visitedForumData = new VisitedForumData();
                visitedForumData.I(historyForumInfo2);
                visitedForumData.J(hashMap.containsKey(historyForumInfo2.forum_id));
                this.mForumData.add(visitedForumData);
            }
        }
    }
}
