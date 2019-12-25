package com.baidu.tieba.homepage.gamevideo.c;

import com.baidu.fsg.face.base.b.c;
import com.baidu.tbadk.core.data.k;
import org.json.JSONObject;
import tbclient.RecomVertical.SubClassItem;
/* loaded from: classes6.dex */
public class a extends k {
    public int enable;
    public String sub_class_icon;
    public int sub_class_id;
    public String sub_class_name;

    @Override // com.baidu.tbadk.core.data.k
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.sub_class_id = jSONObject.optInt("sub_class_id");
            this.sub_class_name = jSONObject.optString("sub_class_name");
            this.sub_class_icon = jSONObject.optString("sub_class_icon");
            this.enable = jSONObject.optInt(c.l);
        }
    }

    public void a(SubClassItem subClassItem) {
        if (subClassItem != null) {
            this.sub_class_id = subClassItem.sub_class_id.intValue();
            this.sub_class_name = subClassItem.sub_class_name;
            this.sub_class_icon = subClassItem.sub_class_icon;
            this.enable = subClassItem.enable.intValue();
        }
    }
}
