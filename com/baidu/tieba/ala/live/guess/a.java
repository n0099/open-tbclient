package com.baidu.tieba.ala.live.guess;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.d;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public void t(long j, int i) {
        d.BM().putLong("live_guess_last_question", j);
        d.BM().putInt("live_guess_last_answer", i);
    }

    public Long getId() {
        return Long.valueOf(d.BM().getLong("live_guess_last_question", -1L));
    }

    public int fn(long j) {
        return d.BM().getInt("live_guess_last_answer", -1);
    }

    public void bXB() {
        a(ar(UbcStatisticLiveKey.KEY_ID_1394, "display", "missguess_show"));
    }

    public void bXC() {
        a(ar(UbcStatisticLiveKey.KEY_ID_1394, "display", "wrongguess_show"));
    }

    public void bXD() {
        a(ar(UbcStatisticLiveKey.KEY_ID_1394, "display", "rightguess_show"));
    }

    public void bXE() {
        a(ar(UbcStatisticLiveKey.KEY_ID_1396, "click", "guessflw_clk"));
    }

    public void bXF() {
        a(ar(UbcStatisticLiveKey.KEY_ID_1394, "display", "guessflw_show"));
    }

    public void bXG() {
        a(ar(UbcStatisticLiveKey.KEY_ID_1396, "click", "getticket_clk"));
    }

    public void bXH() {
        a(ar(UbcStatisticLiveKey.KEY_ID_1394, "display", "ticketlack_show"));
    }

    public void bXI() {
        a(w(UbcStatisticLiveKey.KEY_ID_1395, "click", "guessing_succ", ""));
    }

    public void vU(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", i);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        a(ar(UbcStatisticLiveKey.KEY_ID_1396, "click", "guesschoice_clk").setContentExt(jSONObject));
    }

    public void bXJ() {
        a(ar(UbcStatisticLiveKey.KEY_ID_1394, "display", "guesspop_show"));
    }

    public UbcStatisticItem ar(String str, String str2, String str3) {
        return w(str, str2, str3, "popup");
    }

    private UbcStatisticItem w(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "live");
            if (str4 != null && !TextUtils.isEmpty(str4)) {
                jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, str4);
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        return new UbcStatisticItem(str, "liveroom", str2, str3).setContentExt(jSONObject);
    }

    private void a(UbcStatisticItem ubcStatisticItem) {
        UbcStatisticManager.getInstance().logEvent(ubcStatisticItem);
    }
}
