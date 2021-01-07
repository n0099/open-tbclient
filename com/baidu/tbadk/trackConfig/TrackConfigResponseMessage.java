package com.baidu.tbadk.trackConfig;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TrackConfigResponseMessage extends JsonHttpResponsedMessage {
    private boolean isOpenTrack;

    public TrackConfigResponseMessage(int i) {
        super(i);
        this.isOpenTrack = false;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && isSuccess()) {
            try {
                this.isOpenTrack = jSONObject.getInt("is_open_track") == 1;
                b.bvr().putBoolean("key_is_open_track", this.isOpenTrack);
                TbSingleton.getInstance().setIsOpenTrack(this.isOpenTrack);
            } catch (JSONException e) {
                BdLog.e("open track parese exception " + e.toString());
            }
        }
    }

    public boolean getData() {
        return this.isOpenTrack;
    }
}
