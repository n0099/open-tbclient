package com.baidu.tieba.ala.personcenter.privilege.achievementmark.message;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.data.AlaUserInfoData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.unified.SourceConstant;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.fi6;
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
public class AlaAchievementMarkResponsedMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<fi6> list;
    public AlaUserInfoData user_info;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaAchievementMarkResponsedMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GET_PRIVILEGE_MARK_LIST);
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
        this.list = new ArrayList();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                return;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(SourceConstant.SOURCE_USER_INFO);
            if (optJSONObject2 != null) {
                this.user_info = (AlaUserInfoData) OrmObject.objectWithJson(optJSONObject2, AlaUserInfoData.class);
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("mark_info");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i2);
                    if (optJSONObject3 != null) {
                        fi6 fi6Var = new fi6();
                        fi6Var.c(optJSONObject3);
                        this.list.add(fi6Var);
                    }
                }
            }
        }
    }

    public AlaUserInfoData getAlaUserInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.user_info;
        }
        return (AlaUserInfoData) invokeV.objValue;
    }

    public List<fi6> getList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.list == null) {
                this.list = new ArrayList();
            }
            return this.list;
        }
        return (List) invokeV.objValue;
    }
}
