package com.baidu.tieba.ala.category.b;

import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d implements IAdapterData {
    public static final BdUniqueId fPw = BdUniqueId.gen();
    private boolean checked;
    private int fPx;
    private String member;
    private int score;

    public String bIa() {
        return this.member;
    }

    public int getScore() {
        return this.score;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void setChecked(boolean z) {
        this.checked = z;
    }

    public int bIb() {
        return this.fPx;
    }

    public void sV(int i) {
        this.fPx = i;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.member = jSONObject.optString("member");
            this.score = jSONObject.optInt(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE, 0);
            this.checked = jSONObject.optInt("checked", 0) == 1;
        }
    }

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return fPw;
    }
}
