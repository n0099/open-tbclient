package com.baidu.tbadk.trackConfig;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.m0.r.d0.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TrackConfigResponseMessage extends JsonHttpResponsedMessage {
    public boolean isOpenTrack;

    public TrackConfigResponseMessage(int i2) {
        super(i2);
        this.isOpenTrack = false;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        if (jSONObject == null || !isSuccess()) {
            return;
        }
        try {
            int i3 = jSONObject.getInt("is_open_track");
            boolean z = true;
            if (i3 != 1) {
                z = false;
            }
            this.isOpenTrack = z;
            b.j().t("key_is_open_track", this.isOpenTrack);
            TbSingleton.getInstance().setIsOpenTrack(this.isOpenTrack);
        } catch (JSONException e2) {
            BdLog.e("open track parese exception " + e2.toString());
        }
    }

    public boolean getData() {
        return this.isOpenTrack;
    }
}
