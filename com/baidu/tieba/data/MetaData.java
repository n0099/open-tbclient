package com.baidu.tieba.data;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.util.bg;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.io.Serializable;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MetaData implements com.baidu.tieba.util.an, Serializable {
    private static final long serialVersionUID = -2969858506144441193L;
    private String id = null;
    private int type = 0;
    private String name = null;
    private String name_show = null;
    private String portrait = null;
    LinkedList<aa> mIconInfo = new LinkedList<>();

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

    public LinkedList<aa> getIconInfo() {
        return this.mIconInfo;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            bg.b("MetaData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.id = jSONObject.optString(LocaleUtil.INDONESIAN);
                this.type = jSONObject.optInt("type", 0);
                this.name = jSONObject.optString(SocialConstants.PARAM_MEDIA_UNAME);
                if (this.name != null && this.name.length() <= 0) {
                    this.name = null;
                }
                this.name_show = jSONObject.optString("name_show");
                this.portrait = jSONObject.optString("portrait");
                JSONArray optJSONArray = jSONObject.optJSONArray("iconinfo");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        aa aaVar = new aa();
                        aaVar.a(optJSONArray.getJSONObject(i));
                        this.mIconInfo.add(aaVar);
                    }
                }
            } catch (Exception e) {
                bg.b("MetaData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public void logPrint() {
        bg.d("MetaData", "logPrint", "id = " + this.id);
        bg.d("MetaData", "logPrint", "type = " + String.valueOf(this.type));
        bg.d("MetaData", "logPrint", "name = " + this.name);
        bg.d("MetaData", "logPrint", "name_show = " + this.name_show);
        bg.d("MetaData", "logPrint", "portrait = " + this.portrait);
    }

    @Override // com.baidu.tieba.util.an
    public LinkedList<String> getImageUrl() {
        LinkedList<aa> iconInfo = getIconInfo();
        if (iconInfo == null) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iconInfo.size()) {
                return linkedList;
            }
            linkedList.add(iconInfo.get(i2).a());
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.util.an
    public LinkedList<String> getPhotoUrl() {
        return null;
    }

    @Override // com.baidu.tieba.util.an
    public LinkedList<String> getForumPhotoUrl() {
        return null;
    }
}
