package com.baidu.tieba.ala.personcenter.privilege.entereffect;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.s0.v.j.g.d.d.a;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class AlaGetEnterEffectResponsedMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<n> mEffectList;
    public int mEnterEffectCount;
    public String mNickName;
    public String mPortrait;
    public String mUserName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaGetEnterEffectResponsedMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT);
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
        this.mEffectList = new LinkedList();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) {
            super.decodeLogicInBackGround(i2, jSONObject);
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                return;
            }
            this.mEnterEffectCount = optJSONObject.optInt("own_count");
            String optString = optJSONObject.optString("portrait");
            this.mPortrait = optString;
            if (StringUtils.isNull(optString)) {
                this.mPortrait = TbadkCoreApplication.getCurrentPortrait();
            }
            String optString2 = optJSONObject.optString("user_name");
            this.mUserName = optString2;
            if (StringUtils.isNull(optString2)) {
                this.mUserName = TbadkCoreApplication.getCurrentAccountNameShow();
            }
            String optString3 = optJSONObject.optString("user_nickname");
            this.mNickName = optString3;
            if (StringUtils.isNull(optString3)) {
                this.mNickName = this.mUserName;
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("effect_info");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            this.mEffectList.clear();
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                if (optJSONObject2 != null) {
                    a aVar = new a();
                    aVar.b(optJSONObject2);
                    this.mEffectList.add(aVar);
                    JSONArray optJSONArray2 = optJSONObject2.optJSONArray("effect_list");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                            JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i4);
                            if (optJSONObject3 != null) {
                                AlaEnterEffectData alaEnterEffectData = new AlaEnterEffectData();
                                alaEnterEffectData.parserJson(optJSONObject3);
                                this.mEffectList.add(alaEnterEffectData);
                            }
                        }
                    }
                }
            }
        }
    }

    public List<n> getEffectList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mEffectList : (List) invokeV.objValue;
    }

    public int getEnterEffectCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mEnterEffectCount : invokeV.intValue;
    }

    public String getPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mPortrait : (String) invokeV.objValue;
    }

    public String getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!StringUtils.isNull(this.mNickName)) {
                return this.mNickName;
            }
            return this.mUserName;
        }
        return (String) invokeV.objValue;
    }
}
