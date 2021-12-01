package com.baidu.tieba.external.filter;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.data.QmFilterItem;
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
/* loaded from: classes10.dex */
public class ResponseGetQmFiltersMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<QmFilterItem> mQmFilterItems;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseGetQmFiltersMessage() {
        super(CmdConfigHttp.CMD_GET_QM_FILTERS);
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

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) {
            super.decodeLogicInBackGround(i2, jSONObject);
            if (getError() != 0 || jSONObject == null || (optJSONArray = jSONObject.optJSONArray("filter_list")) == null || optJSONArray.length() <= 0) {
                return;
            }
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                QmFilterItem qmFilterItem = new QmFilterItem();
                qmFilterItem.parseJson(optJSONArray.getJSONObject(i3));
                if (this.mQmFilterItems == null) {
                    this.mQmFilterItems = new ArrayList();
                }
                this.mQmFilterItems.add(qmFilterItem);
            }
        }
    }

    public List<QmFilterItem> getFilterItems() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mQmFilterItems : (List) invokeV.objValue;
    }
}
