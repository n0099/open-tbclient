package com.baidu.tieba.ala.frsgamelive.message;

import b.a.q0.s.q.d2;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class AlaFrsStoryLiveGatherRespMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasMore;
    public int liveCount;
    public List<d2> liveList;
    public List<d2> recommandList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaFrsStoryLiveGatherRespMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_FRS_STORY_LIVE_GATHER);
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
        this.liveList = new ArrayList();
        this.recommandList = new ArrayList();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) {
            super.decodeLogicInBackGround(i2, jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("page");
            if (optJSONObject != null) {
                this.hasMore = optJSONObject.optInt("has_more") == 1;
            } else {
                this.hasMore = false;
            }
            this.liveCount = jSONObject.optInt("ala_live_count");
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                    if (optJSONObject2 != null) {
                        d2 d2Var = new d2();
                        d2Var.X2(optJSONObject2);
                        this.liveList.add(d2Var);
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("alt_list");
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                for (int i4 = 0; i4 < length2; i4++) {
                    JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i4);
                    if (optJSONObject3 != null) {
                        d2 d2Var2 = new d2();
                        d2Var2.X2(optJSONObject3);
                        this.recommandList.add(d2Var2);
                    }
                }
            }
        }
    }

    public int getLiveCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.liveCount : invokeV.intValue;
    }

    public List<d2> getLiveList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.liveList : (List) invokeV.objValue;
    }

    public List<d2> getRecommandList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.recommandList : (List) invokeV.objValue;
    }

    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.hasMore : invokeV.booleanValue;
    }
}
