package com.baidu.tieba.data;

import com.baidu.cloudsdk.social.core.SocialConstants;
import java.io.Serializable;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MetaData extends com.baidu.tieba.util.as implements Serializable {
    private static final long serialVersionUID = -2969858506144441193L;
    private String id = null;
    private int type = 0;
    private String name = null;
    private String name_show = null;
    private String portrait = null;
    private String portraith = null;
    private LinkedList<IconData> mIconInfo = new LinkedList<>();
    private LinkedList<IconData> mTShowIconInfo = new LinkedList<>();

    public void setId(String str) {
        this.id = str;
    }

    public String getId() {
        return this.id;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
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
            com.baidu.adp.lib.g.e.b("MetaData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.id = jSONObject.optString("id");
                this.type = jSONObject.optInt("type", 0);
                this.name = jSONObject.optString(SocialConstants.PARAM_MEDIA_UNAME);
                if (this.name != null && this.name.length() <= 0) {
                    this.name = null;
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
                com.baidu.adp.lib.g.e.b("MetaData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public void logPrint() {
        com.baidu.adp.lib.g.e.d("MetaData", "logPrint", "id = " + this.id);
        com.baidu.adp.lib.g.e.d("MetaData", "logPrint", "type = " + String.valueOf(this.type));
        com.baidu.adp.lib.g.e.d("MetaData", "logPrint", "name = " + this.name);
        com.baidu.adp.lib.g.e.d("MetaData", "logPrint", "name_show = " + this.name_show);
        com.baidu.adp.lib.g.e.d("MetaData", "logPrint", "portrait = " + this.portrait);
        com.baidu.adp.lib.g.e.d("MetaData", "logPrint", "portraith = " + this.portraith);
    }

    @Override // com.baidu.tieba.util.as, com.baidu.tieba.util.au
    public LinkedList<String> getImageUrl() {
        LinkedList<IconData> iconInfo = getIconInfo();
        LinkedList<IconData> tShowInfo = getTShowInfo();
        if (iconInfo == null || tShowInfo == null) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < iconInfo.size(); i++) {
            linkedList.add(iconInfo.get(i).getIcon());
        }
        for (int i2 = 0; i2 < iconInfo.size(); i2++) {
            linkedList.add(tShowInfo.get(i2).getIcon());
        }
        return linkedList;
    }

    public String toString() {
        return "MetaData{id='" + this.id + "', type=" + this.type + ", name='" + this.name + "', name_show='" + this.name_show + "', portrait='" + this.portrait + "', portraith='" + this.portraith + "', mIconInfo=" + this.mIconInfo + ", mTShowIconInfo=" + this.mTShowIconInfo + '}';
    }
}
