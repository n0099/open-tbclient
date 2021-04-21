package com.baidu.tieba.attention;

import com.baidu.pass.ecommerce.bean.AddressField;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.frs.FrsTabItemData;
import d.b.i0.t.j;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class AttentionResMsg extends JsonHttpResponsedMessage {
    public boolean mHasMore;
    public List<j> mSelectForumDataList;

    public AttentionResMsg(int i) {
        super(CmdConfigHttp.CMD_SELECT_FORUM_ATTENTION);
    }

    private void parseForum(JSONArray jSONArray) {
        JSONObject optJSONObject;
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject2 = jSONArray.optJSONObject(i);
            if (optJSONObject2 != null) {
                j jVar = new j();
                jVar.f52225a = optJSONObject2.optString("id");
                jVar.f52226b = optJSONObject2.optString("avatar");
                jVar.f52227c = optJSONObject2.optString("name");
                jVar.f52228d = optJSONObject2.optInt("level_id");
                jVar.f52229e = optJSONObject2.optInt("this_week_post") == 1;
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("block_pop_info");
                if (optJSONObject3 != null) {
                    jVar.f52230f = optJSONObject3.optInt("can_post") == 1;
                    jVar.f52231g = optJSONObject3.optString("block_info");
                }
                JSONArray optJSONArray = optJSONObject2.optJSONArray("tab_info");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    jVar.f52232h = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject4 = optJSONArray.optJSONObject(i2);
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
                            jVar.f52232h.add(new FrsTabItemData(builder.build(true)));
                        }
                    }
                }
                jVar.j = optJSONObject2.optInt("is_forum_business_account") == 1;
                if (optJSONObject2.optInt("has_postpre") == 1 && (optJSONObject = optJSONObject2.optJSONObject("post_prefix")) != null) {
                    PostPrefixData postPrefixData = new PostPrefixData();
                    jVar.i = postPrefixData;
                    postPrefixData.parserJson(optJSONObject);
                }
                this.mSelectForumDataList.add(jVar);
            }
        }
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("forum_list")) == null) {
            return;
        }
        this.mSelectForumDataList = new ArrayList();
        parseForum(optJSONObject.optJSONArray("gconforum"));
        parseForum(optJSONObject.optJSONArray("non-gconforum"));
        this.mHasMore = jSONObject.optInt("has_more") == 1;
    }

    public boolean getHasMore() {
        return this.mHasMore;
    }

    public List<j> getSelectForumDataList() {
        return this.mSelectForumDataList;
    }
}
