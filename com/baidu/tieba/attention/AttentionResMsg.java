package com.baidu.tieba.attention;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.data.j;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.frs.FrsTabItemData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class AttentionResMsg extends JsonHttpResponsedMessage {
    private boolean mHasMore;
    private List<j> mSelectForumDataList;

    public AttentionResMsg(int i) {
        super(CmdConfigHttp.CMD_SELECT_FORUM_ATTENTION);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("forum_list")) != null) {
            this.mSelectForumDataList = new ArrayList();
            parseForum(optJSONObject.optJSONArray("gconforum"));
            parseForum(optJSONObject.optJSONArray("non-gconforum"));
            this.mHasMore = jSONObject.optInt("has_more") == 1;
        }
    }

    private void parseForum(JSONArray jSONArray) {
        JSONObject optJSONObject;
        if (jSONArray != null && jSONArray.length() != 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject2 = jSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    j jVar = new j();
                    jVar.forumId = optJSONObject2.optString("id");
                    jVar.aVj = optJSONObject2.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
                    jVar.forumName = optJSONObject2.optString("name");
                    jVar.level = optJSONObject2.optInt("level_id");
                    jVar.fAg = optJSONObject2.optInt("this_week_post") == 1;
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("block_pop_info");
                    if (optJSONObject3 != null) {
                        jVar.fAh = optJSONObject3.optInt("can_post") == 1;
                        jVar.fAi = optJSONObject3.optString("block_info");
                    }
                    JSONArray optJSONArray = optJSONObject2.optJSONArray("tab_info");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        jVar.tabInfoList = new ArrayList();
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
                                builder.is_default = Integer.valueOf(optJSONObject4.optInt("is_default"));
                                jVar.tabInfoList.add(new FrsTabItemData(builder.build(true)));
                            }
                        }
                    }
                    jVar.isForumBusinessAccount = optJSONObject2.optInt("is_forum_business_account") == 1;
                    if (optJSONObject2.optInt("has_postpre") == 1 && (optJSONObject = optJSONObject2.optJSONObject("post_prefix")) != null) {
                        jVar.fAj = new PostPrefixData();
                        jVar.fAj.parserJson(optJSONObject);
                    }
                    this.mSelectForumDataList.add(jVar);
                }
            }
        }
    }

    public List<j> getSelectForumDataList() {
        return this.mSelectForumDataList;
    }

    public boolean getHasMore() {
        return this.mHasMore;
    }
}
