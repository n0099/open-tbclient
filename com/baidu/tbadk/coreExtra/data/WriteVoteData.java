package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class WriteVoteData extends OrmObject implements Serializable {
    public static final String VOTE_CONTENT_PREFIX_FORMAT = "#(poll,%s)";
    public int expire_type;
    public int is_multi;
    public String title = "";
    public List<WriteVoteItemData> options = new ArrayList();

    public int getExpire_type() {
        return this.expire_type;
    }

    public int getIs_multi() {
        return this.is_multi;
    }

    public List<WriteVoteItemData> getOptions() {
        return this.options;
    }

    public String getTitle() {
        return this.title;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.title = jSONObject.optString("title");
        this.expire_type = jSONObject.optInt("expire_type");
        this.is_multi = jSONObject.optInt("is_multi");
        JSONArray optJSONArray = jSONObject.optJSONArray("options");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                WriteVoteItemData writeVoteItemData = new WriteVoteItemData();
                try {
                    writeVoteItemData.parseJson(optJSONArray.getJSONObject(i));
                    this.options.add(writeVoteItemData);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void setExpire_type(int i) {
        this.expire_type = i;
    }

    public void setIs_multi(int i) {
        this.is_multi = i;
    }

    public void setOptions(List<WriteVoteItemData> list) {
        this.options = list;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public JSONObject toJsonObject() {
        return OrmObject.jsonWithObject(this);
    }

    public String toJsonString() {
        return OrmObject.jsonStrWithObject(this);
    }
}
