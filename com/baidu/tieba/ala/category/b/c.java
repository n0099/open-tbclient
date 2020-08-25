package com.baidu.tieba.ala.category.b;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c implements IAdapterData {
    public static final BdUniqueId fPq = BdUniqueId.gen();
    private String desc;
    private List<IAdapterData> fPr;
    private String icon;
    private String id;
    private String level;
    private String name;

    public void di(JSONObject jSONObject) {
        this.id = jSONObject.optString("id");
        this.name = jSONObject.optString("name");
        this.level = jSONObject.optString("level");
        this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        this.desc = jSONObject.optString("desc");
        JSONArray optJSONArray = jSONObject.optJSONArray("sub_list");
        if (optJSONArray != null) {
            this.fPr = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                c cVar = new c();
                cVar.di(optJSONObject);
                this.fPr.add(cVar);
            }
        }
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<IAdapterData> bHY() {
        return this.fPr;
    }

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return fPq;
    }
}
