package com.baidu.tieba.ala.alasquare.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.data.AlaSquareTabData;
import com.baidu.ala.data.AlaSquareTabInfo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class AlaLiveSquareGetTabResponse extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaSquareTabData mTabData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaLiveSquareGetTabResponse(int i2) {
        super(AlaCmdConfigHttp.CMD_ALA_LIVE_SQUARE_GET_TAB_INFO);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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
            AlaSquareTabData alaSquareTabData = new AlaSquareTabData();
            this.mTabData = alaSquareTabData;
            alaSquareTabData.hasSearch = optJSONObject.optInt("has_search");
            this.mTabData.showNum = optJSONObject.optInt("show_num");
            ArrayList arrayList = null;
            JSONArray optJSONArray = optJSONObject.optJSONArray("entry");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                ArrayList arrayList2 = new ArrayList(length);
                for (int i3 = 0; i3 < length; i3++) {
                    AlaSquareTabInfo alaSquareTabInfo = new AlaSquareTabInfo();
                    alaSquareTabInfo.parse(optJSONArray.optJSONObject(i3));
                    arrayList2.add(alaSquareTabInfo);
                }
                arrayList = arrayList2;
            }
            this.mTabData.tabInfoList = arrayList;
        }
    }

    public AlaSquareTabData getTabData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mTabData : (AlaSquareTabData) invokeV.objValue;
    }
}
