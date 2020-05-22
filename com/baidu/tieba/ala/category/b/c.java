package com.baidu.tieba.ala.category.b;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements IAdapterData {
    public static final BdUniqueId fnt = BdUniqueId.gen();
    private String desc;
    private String fnu;
    private List<IAdapterData> fnv;
    private String icon;
    private String id;
    private String name;

    public void cM(JSONObject jSONObject) {
        this.id = jSONObject.optString("id");
        this.name = jSONObject.optString("name");
        this.fnu = jSONObject.optString(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL);
        this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        this.desc = jSONObject.optString("desc");
        JSONArray optJSONArray = jSONObject.optJSONArray("sub_list");
        if (optJSONArray != null) {
            this.fnv = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                c cVar = new c();
                cVar.cM(optJSONObject);
                this.fnv.add(cVar);
            }
        }
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<IAdapterData> bsO() {
        return this.fnv;
    }

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return fnt;
    }
}
