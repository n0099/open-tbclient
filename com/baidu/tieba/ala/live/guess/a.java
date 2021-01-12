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
/* loaded from: classes10.dex */
public class a {
    public void v(long j, int i) {
        d.xf().putLong("live_guess_last_question", j);
        d.xf().putInt("live_guess_last_answer", i);
    }

    public Long getId() {
        return Long.valueOf(d.xf().getLong("live_guess_last_question", -1L));
    }

    public int fn(long j) {
        return d.xf().getInt("live_guess_last_answer", -1);
    }

    public void bWq() {
        a(at(UbcStatisticLiveKey.KEY_ID_1394, "display", "missguess_show"));
    }

    public void bWr() {
        a(at(UbcStatisticLiveKey.KEY_ID_1394, "display", "wrongguess_show"));
    }

    public void bWs() {
        a(at(UbcStatisticLiveKey.KEY_ID_1394, "display", "rightguess_show"));
    }

    public void bWt() {
        a(at(UbcStatisticLiveKey.KEY_ID_1396, "click", "guessflw_clk"));
    }

    public void bWu() {
        a(at(UbcStatisticLiveKey.KEY_ID_1394, "display", "guessflw_show"));
    }

    public void bWv() {
        a(at(UbcStatisticLiveKey.KEY_ID_1396, "click", "getticket_clk"));
    }

    public void bWw() {
        a(at(UbcStatisticLiveKey.KEY_ID_1394, "display", "ticketlack_show"));
    }

    public void bWx() {
        a(v(UbcStatisticLiveKey.KEY_ID_1395, "click", "guessing_succ", ""));
    }

    public void uz(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", i);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        a(at(UbcStatisticLiveKey.KEY_ID_1396, "click", "guesschoice_clk").setContentExt(jSONObject));
    }

    public void bWy() {
        a(at(UbcStatisticLiveKey.KEY_ID_1394, "display", "guesspop_show"));
    }

    public UbcStatisticItem at(String str, String str2, String str3) {
        return v(str, str2, str3, UbcStatConstant.SubPage.POPUP);
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
