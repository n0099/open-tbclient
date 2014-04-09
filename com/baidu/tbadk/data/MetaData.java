package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.f;
import java.io.Serializable;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MetaData implements Serializable {
    private static final long serialVersionUID = -2658065756886586092L;
    private int is_like = 0;
    private String userId = null;
    private int type = 0;
    private int level_id = 0;
    private String userName = null;
    private String name_show = null;
    private String portrait = null;
    private String portraith = null;
    private LinkedList<IconData> mIconInfo = new LinkedList<>();
    private LinkedList<IconData> mTShowIconInfo = new LinkedList<>();
    private int is_bawu = 0;
    private String bawu_type = null;

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserIdLong(long j) {
        this.userId = String.valueOf(j);
    }

    public int getIsLike() {
        return this.is_like;
    }

    public void setIsLike(int i) {
        this.is_like = i;
    }

    public long getUserIdLong() {
        return com.baidu.adp.lib.f.b.a(this.userId, 0L);
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setName_show(String str) {
        this.name_show = str;
    }

    public String getName_show() {
        return this.name_show;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void setPortraitH(String str) {
        this.portraith = str;
    }

    public String getPortraitH() {
        return this.portraith;
    }

    public LinkedList<IconData> getIconInfo() {
        return this.mIconInfo;
    }

    public void setIconInfo(LinkedList<IconData> linkedList) {
        this.mIconInfo = linkedList;
    }

    public LinkedList<IconData> getTShowInfo() {
        return this.mTShowIconInfo;
    }

    public void setTShowInfo(LinkedList<IconData> linkedList) {
        this.mTShowIconInfo = linkedList;
    }

    public int getLevel_id() {
        return this.level_id;
    }

    public void setLevel_id(int i) {
        this.level_id = i;
    }

    public int getIs_bawu() {
        return this.is_bawu;
    }

    public void setIsBawu(int i) {
        this.is_bawu = i;
    }

    public String getBawu_type() {
        return this.bawu_type;
    }

    public void setBawuType(String str) {
        this.bawu_type = str;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            f.b("MetaData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.userId = jSONObject.optString("id");
                this.type = jSONObject.optInt("type", 0);
                this.userName = jSONObject.optString("name");
                this.level_id = jSONObject.optInt("level_id", 0);
                this.is_like = jSONObject.optInt("is_like", 0);
                this.is_bawu = jSONObject.optInt("is_bawu", 0);
                this.bawu_type = jSONObject.optString("bawu_type");
                if (this.userName != null && this.userName.length() <= 0) {
                    this.userName = null;
                }
                this.name_show = jSONObject.optString("name_show");
                this.portrait = jSONObject.optString("portrait");
                this.portraith = jSONObject.optString("portraith");
                JSONArray optJSONArray = jSONObject.optJSONArray("iconinfo");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("tshow_icon");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        IconData iconData = new IconData();
                        iconData.parserJson(optJSONArray.getJSONObject(i));
                        this.mIconInfo.add(iconData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        IconData iconData2 = new IconData();
                        iconData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.mTShowIconInfo.add(iconData2);
                    }
                }
            } catch (Exception e) {
                f.b("MetaData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public void logPrint() {
        f.d("MetaData", "logPrint", "id = " + this.userId);
        f.d("MetaData", "logPrint", "type = " + String.valueOf(this.type));
        f.d("MetaData", "logPrint", "name = " + this.userName);
        f.d("MetaData", "logPrint", "name_show = " + this.name_show);
        f.d("MetaData", "logPrint", "portrait = " + this.portrait);
        f.d("MetaData", "logPrint", "portraith = " + this.portraith);
        f.d("MetaData", "logPrint", "level_id = " + String.valueOf(this.level_id));
    }

    public String toString() {
        return "MetaData{id='" + this.userId + "', type=" + this.type + ", name='" + this.userName + "', level_id=" + this.level_id + ", is_like=" + this.is_like + ", bawu_type=" + this.bawu_type + ", is_bawu=" + this.is_bawu + ", name_show='" + this.name_show + "', portrait='" + this.portrait + "', portraith='" + this.portraith + "', mIconInfo=" + this.mIconInfo + ", mTShowIconInfo=" + this.mTShowIconInfo + '}';
    }
}
