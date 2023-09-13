package com.baidu.tieba.ala.frsgamelive.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.cn;
import com.baidu.tieba.we6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class AlaGameFrsLiveThreadsRespMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasMore;
    public int liveCount;
    public List<cn> liveList;
    public List<cn> recommandList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaGameFrsLiveThreadsRespMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_LIVE_FRS_GAME);
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
        this.liveList = new ArrayList();
        this.recommandList = new ArrayList();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("page");
            if (optJSONObject != null) {
                boolean z = true;
                if (optJSONObject.optInt("has_more") != 1) {
                    z = false;
                }
                this.hasMore = z;
            } else {
                this.hasMore = false;
            }
            this.liveCount = jSONObject.optInt("ala_live_count");
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                    if (optJSONObject2 != null) {
                        we6 we6Var = new we6();
                        ThreadData threadData = new ThreadData();
                        threadData.parserJson(optJSONObject2);
                        we6Var.a = threadData;
                        this.liveList.add(we6Var);
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("alt_list");
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                for (int i3 = 0; i3 < length2; i3++) {
                    JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i3);
                    if (optJSONObject3 != null) {
                        we6 we6Var2 = new we6();
                        ThreadData threadData2 = new ThreadData();
                        threadData2.parserJson(optJSONObject3);
                        we6Var2.a = threadData2;
                        this.recommandList.add(we6Var2);
                    }
                }
            }
        }
    }

    public int getLiveCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.liveCount;
        }
        return invokeV.intValue;
    }

    public List<cn> getLiveList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.liveList;
        }
        return (List) invokeV.objValue;
    }

    public List<cn> getRecommandList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.recommandList;
        }
        return (List) invokeV.objValue;
    }

    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.hasMore;
        }
        return invokeV.booleanValue;
    }
}
