package com.baidu.tieba.ala.live.personcenter.admin.b;

import android.text.TextUtils;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.IAdapterData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements IAdapterData {
    public static final BdUniqueId fPb = BdUniqueId.gen();
    private String fDX;
    private String portrait;
    private int sex;
    private String userId;
    private String userName;

    public void cV(JSONObject jSONObject) {
        this.userId = jSONObject.optString("user_id");
        this.userName = jSONObject.optString("user_name");
        if (!jSONObject.isNull("user_nickname")) {
            this.fDX = jSONObject.optString("user_nickname");
        }
        this.portrait = jSONObject.optString("bd_portrait");
        if (StringUtils.isNull(this.portrait)) {
            this.portrait = jSONObject.optString("portrait");
        }
        this.sex = jSONObject.optInt("sex");
    }

    public String getUserId() {
        return this.userId;
    }

    public String bdc() {
        return !TextUtils.isEmpty(this.fDX) ? this.fDX : this.userName;
    }

    public String getPortrait() {
        return this.portrait;
    }

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return fPb;
    }
}
