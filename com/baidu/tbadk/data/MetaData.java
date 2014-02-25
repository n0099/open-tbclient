package com.baidu.tbadk.data;

import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.util.f;
import com.baidu.cloudsdk.social.core.SocialConstants;
import java.io.Serializable;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MetaData implements Serializable {
    private static final long serialVersionUID = -2658065756886586092L;
    private String userId = null;
    private int type = 0;
    private String userName = null;
    private String name_show = null;
    private String portrait = null;
    private String portraith = null;
    private LinkedList<IconData> mIconInfo = new LinkedList<>();
    private LinkedList<IconData> mTShowIconInfo = new LinkedList<>();

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserIdLong(long j) {
        this.userId = String.valueOf(j);
    }

    public long getUserIdLong() {
        return b.a(this.userId, 0L);
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

    public LinkedList<IconData> getTShowInfo() {
        return this.mTShowIconInfo;
    }

    public void setTShowInfo(LinkedList<IconData> linkedList) {
        this.mTShowIconInfo = linkedList;
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
                this.userName = jSONObject.optString(SocialConstants.PARAM_MEDIA_UNAME);
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
    }

    public String toString() {
        return "MetaData{id='" + this.userId + "', type=" + this.type + ", name='" + this.userName + "', name_show='" + this.name_show + "', portrait='" + this.portrait + "', portraith='" + this.portraith + "', mIconInfo=" + this.mIconInfo + ", mTShowIconInfo=" + this.mTShowIconInfo + '}';
    }
}
