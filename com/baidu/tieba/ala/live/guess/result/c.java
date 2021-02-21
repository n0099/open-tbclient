package com.baidu.tieba.ala.live.guess.result;

import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    public static void nx(boolean z) {
        v(z, "rightgess_show");
    }

    public static void ny(boolean z) {
        v(z, "wrongguess_show");
    }

    public static void nz(boolean z) {
        v(z, "missguess_show");
    }

    public static void bXQ() {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "jointeam_clk");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_ACTIVITY_NAME, "gongyan_newyear");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubcStatisticItem.setContentExt("", UbcStatConstant.SubPage.GUESS_POPUP, jSONObject);
        UbcStatisticManager.getInstance().logEvent(ubcStatisticItem);
    }

    private static void v(boolean z, String str) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_ACTIVITY_NAME, "gongyan_newyear");
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, z ? "team" : "single");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubcStatisticItem.setContentExt("", UbcStatConstant.SubPage.GUESS_POPUP, jSONObject);
        UbcStatisticManager.getInstance().logEvent(ubcStatisticItem);
    }
}
