package com.baidu.tieba.ala.live.personcenter.admin.b;

import android.text.TextUtils;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.IAdapterData;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements IAdapterData {
    public static final BdUniqueId ggt = BdUniqueId.gen();
    private String fUJ;
    private String portrait;
    private int sex;
    private String userId;
    private String userName;

    public void di(JSONObject jSONObject) {
        this.userId = jSONObject.optString("user_id");
        this.userName = jSONObject.optString("user_name");
        if (!jSONObject.isNull("user_nickname")) {
            this.fUJ = jSONObject.optString("user_nickname");
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

    public String bpu() {
        return !TextUtils.isEmpty(this.fUJ) ? this.fUJ : this.userName;
    }

    public String getPortrait() {
        return this.portrait;
    }

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return ggt;
    }
}
