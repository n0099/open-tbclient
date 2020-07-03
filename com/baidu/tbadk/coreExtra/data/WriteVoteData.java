package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class WriteVoteData extends OrmObject implements Serializable {
    public static final String VOTE_CONTENT_PREFIX_FORMAT = "#(poll,%s)";
    private int expireType;
    private int isMulti;
    private String title = "";
    private List<WriteVoteItemData> options = new ArrayList();

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.title = jSONObject.optString("title");
            this.expireType = jSONObject.optInt("expire_type");
            this.isMulti = jSONObject.optInt("is_multi");
            JSONArray optJSONArray = jSONObject.optJSONArray("options");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    WriteVoteItemData writeVoteItemData = new WriteVoteItemData();
                    try {
                        writeVoteItemData.parseJson(optJSONArray.getJSONObject(i));
                        this.options.add(writeVoteItemData);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public String toJsonString() {
        String jsonStrWithObject = OrmObject.jsonStrWithObject(this);
        if (jsonStrWithObject != null) {
            return jsonStrWithObject.replace("\"expireType\":", "\"expire_type\":").replace("\"isMulti\":", "\"is_multi\":");
        }
        return jsonStrWithObject;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int getExpireType() {
        return this.expireType;
    }

    public void setExpireType(int i) {
        this.expireType = i;
    }

    public int getIsMulti() {
        return this.isMulti;
    }

    public void setIsMulti(int i) {
        this.isMulti = i;
    }

    public List<WriteVoteItemData> getOptions() {
        return this.options;
    }

    public void setOptions(List<WriteVoteItemData> list) {
        this.options = list;
    }
}
