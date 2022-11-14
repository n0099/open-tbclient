package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.tieba.cj5;
import com.baidu.tieba.xg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.GetHistoryForum.DataReq;
import tbclient.GetHistoryForum.GetHistoryForumReqIdl;
/* loaded from: classes4.dex */
public class RecentlyVisitedForumRequestMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<VisitedForumData> mForumData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecentlyVisitedForumRequestMessage() {
        super(CmdConfigHttp.CMD_GET_HISTORY_FORUM, 309601);
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
            try {
                DataReq.Builder builder = new DataReq.Builder();
                JSONArray jSONArray = new JSONArray();
                if (this.mForumData != null) {
                    Iterator<VisitedForumData> it = this.mForumData.iterator();
                    while (it.hasNext()) {
                        VisitedForumData next = it.next();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("forum_id", xg.g(next.getForumId(), 0L));
                        jSONObject.put("visit_time", next.getVisitedTime());
                        jSONArray.put(jSONObject);
                    }
                }
                builder.history = jSONArray.toString();
                if (z || SocketAddCommonParamSwitch.getIsOn()) {
                    cj5.a(builder, true);
                }
                GetHistoryForumReqIdl.Builder builder2 = new GetHistoryForumReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeZ.objValue;
    }

    public LinkedList<VisitedForumData> getForumData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mForumData;
        }
        return (LinkedList) invokeV.objValue;
    }

    public void setForumData(LinkedList<VisitedForumData> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, linkedList) == null) {
            this.mForumData = linkedList;
        }
    }
}
