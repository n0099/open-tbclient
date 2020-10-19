package com.baidu.tieba.ala.live.guess;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.c;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.platform.comapi.map.MapController;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public void n(long j, int i) {
        c.AZ().putLong("live_guess_last_question", j);
        c.AZ().putInt("live_guess_last_answer", i);
    }

    public Long getId() {
        return Long.valueOf(c.AZ().getLong("live_guess_last_question", -1L));
    }

    public int el(long j) {
        return c.AZ().getInt("live_guess_last_answer", -1);
    }

    public void bPd() {
        a(ai(UbcStatisticLiveKey.KEY_ID_1394, "display", "missguess_show"));
    }

    public void bPe() {
        a(ai(UbcStatisticLiveKey.KEY_ID_1394, "display", "wrongguess_show"));
    }

    public void bPf() {
        a(ai(UbcStatisticLiveKey.KEY_ID_1394, "display", "rightguess_show"));
    }

    public void bPg() {
        a(ai(UbcStatisticLiveKey.KEY_ID_1396, "click", "guessflw_clk"));
    }

    public void bPh() {
        a(ai(UbcStatisticLiveKey.KEY_ID_1394, "display", "guessflw_show"));
    }

    public void bPi() {
        a(ai(UbcStatisticLiveKey.KEY_ID_1396, "click", "getticket_clk"));
    }

    public void bPj() {
        a(ai(UbcStatisticLiveKey.KEY_ID_1394, "display", "ticketlack_show"));
    }

    public void bPk() {
        a(v(UbcStatisticLiveKey.KEY_ID_1395, "click", "guessing_succ", ""));
    }

    public void um(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", i);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        a(ai(UbcStatisticLiveKey.KEY_ID_1396, "click", "guesschoice_clk").setContentExt(jSONObject));
    }

    public void bPl() {
        a(ai(UbcStatisticLiveKey.KEY_ID_1394, "display", "guesspop_show"));
    }

    public UbcStatisticItem ai(String str, String str2, String str3) {
        return v(str, str2, str3, MapController.POPUP_LAYER_TAG);
    }

    private UbcStatisticItem v(String str, String str2, String str3, String str4) {
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
