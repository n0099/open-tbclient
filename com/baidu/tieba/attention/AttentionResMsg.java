package com.baidu.tieba.attention;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.bean.AddressField;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.t.j;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsTabInfo;
/* loaded from: classes5.dex */
public class AttentionResMsg extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mHasMore;
    public List<j> mSelectForumDataList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AttentionResMsg(int i2) {
        super(CmdConfigHttp.CMD_SELECT_FORUM_ATTENTION);
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

    private void parseForum(JSONArray jSONArray) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, jSONArray) == null) || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject2 = jSONArray.optJSONObject(i2);
            if (optJSONObject2 != null) {
                j jVar = new j();
                jVar.f56710a = optJSONObject2.optString("id");
                jVar.f56711b = optJSONObject2.optString("avatar");
                jVar.f56712c = optJSONObject2.optString("name");
                jVar.f56713d = optJSONObject2.optInt("level_id");
                jVar.f56714e = optJSONObject2.optInt("this_week_post") == 1;
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("block_pop_info");
                if (optJSONObject3 != null) {
                    jVar.f56715f = optJSONObject3.optInt("can_post") == 1;
                    jVar.f56716g = optJSONObject3.optString("block_info");
                }
                JSONArray optJSONArray = optJSONObject2.optJSONArray("tab_info");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    jVar.f56717h = new ArrayList();
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONObject optJSONObject4 = optJSONArray.optJSONObject(i3);
                        if (optJSONObject4 != null) {
                            FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
                            builder.tab_id = Integer.valueOf(optJSONObject4.optInt("tab_id"));
                            builder.tab_type = Integer.valueOf(optJSONObject4.optInt("tab_type"));
                            builder.tab_name = optJSONObject4.optString("tab_name");
                            builder.tab_url = optJSONObject4.optString("tab_url");
                            builder.tab_gid = optJSONObject4.optString("tab_gid");
                            builder.tab_title = optJSONObject4.optString("tab_title");
                            builder.is_general_tab = Integer.valueOf(optJSONObject4.optInt("is_general_tab"));
                            builder.tab_code = optJSONObject4.optString(LowFlowsActivityConfig.TAB_CODE);
                            builder.tab_version = Integer.valueOf(optJSONObject4.optInt("tab_version"));
                            builder.is_default = Integer.valueOf(optJSONObject4.optInt(AddressField.KEY_IS_DEFAULT));
                            jVar.f56717h.add(new FrsTabItemData(builder.build(true)));
                        }
                    }
                }
                jVar.j = optJSONObject2.optInt("is_forum_business_account") == 1;
                if (optJSONObject2.optInt("has_postpre") == 1 && (optJSONObject = optJSONObject2.optJSONObject("post_prefix")) != null) {
                    PostPrefixData postPrefixData = new PostPrefixData();
                    jVar.f56718i = postPrefixData;
                    postPrefixData.parserJson(optJSONObject);
                }
                this.mSelectForumDataList.add(jVar);
            }
        }
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("forum_list")) == null) {
            return;
        }
        this.mSelectForumDataList = new ArrayList();
        parseForum(optJSONObject.optJSONArray("gconforum"));
        parseForum(optJSONObject.optJSONArray("non-gconforum"));
        this.mHasMore = jSONObject.optInt("has_more") == 1;
    }

    public boolean getHasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mHasMore : invokeV.booleanValue;
    }

    public List<j> getSelectForumDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mSelectForumDataList : (List) invokeV.objValue;
    }
}
