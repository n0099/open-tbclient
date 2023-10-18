package com.baidu.tieba.frs;

import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class FrsTabInfoData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isForumBusinessAccount;
    public int selectedTabId;
    public List<FrsTabItemData> tabList;

    public FrsTabInfoData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void parseJson(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            this.selectedTabId = jSONObject.optInt(MessageCenterActivityConfig.SELECTED_TAB_ID);
            this.isForumBusinessAccount = jSONObject.optBoolean("is_forum_business_account");
            JSONArray optJSONArray = jSONObject.optJSONArray("tab_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    FrsTabItemData frsTabItemData = new FrsTabItemData();
                    try {
                        frsTabItemData.parseJson(optJSONArray.getJSONObject(i));
                        this.tabList.add(frsTabItemData);
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                }
            }
        }
    }

    public JSONObject toJsonObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(MessageCenterActivityConfig.SELECTED_TAB_ID, this.selectedTabId);
                jSONObject.put("is_forum_business_account", this.isForumBusinessAccount);
                JSONArray jSONArray = new JSONArray();
                for (FrsTabItemData frsTabItemData : this.tabList) {
                    jSONArray.put(frsTabItemData.toJsonObject());
                }
                jSONObject.put("tab_list", jSONArray);
            } catch (JSONException e) {
                BdLog.e(e);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
