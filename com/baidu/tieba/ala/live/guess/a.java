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
/* loaded from: classes11.dex */
public class a {
    public void b(long j, int i, boolean z) {
        d.xc().putLong("live_guess_last_question", j);
        d.xc().putInt("live_guess_last_answer", i);
        d.xc().putBoolean("live_guess_last_use_double_tickct", z);
    }

    public Long getId() {
        return Long.valueOf(d.xc().getLong("live_guess_last_question", -1L));
    }

    public void bWU() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_ACTIVITY_NAME, "gongyan_newyear");
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "follow_clk").setContentExt(null, UbcStatConstant.SubPage.GUESS_POPUP, jSONObject));
    }

    public void Ha(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_ACTIVITY_NAME, "gongyan_newyear");
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", str, "guessentry_show").setContentExt(null, UbcStatConstant.SubPage.GUESS_POPUP, jSONObject));
    }

    public void Hb(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_ACTIVITY_NAME, "gongyan_newyear");
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "display", str, "guessentry_clk").setContentExt(null, UbcStatConstant.SubPage.GUESS_POPUP, jSONObject));
    }

    public void bWV() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_ACTIVITY_NAME, "gongyan_newyear");
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "followguide_show").setContentExt(null, UbcStatConstant.SubPage.GUESS_POPUP, jSONObject));
    }

    public void bWW() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_ACTIVITY_NAME, "gongyan_newyear");
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "guesslack_clk").setContentExt(null, UbcStatConstant.SubPage.GUESS_POPUP, jSONObject));
    }

    public void bWX() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_ACTIVITY_NAME, "gongyan_newyear");
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "guesslack_show").setContentExt(null, UbcStatConstant.SubPage.GUESS_POPUP, jSONObject));
    }

    public void bWY() {
        a(v(UbcStatisticLiveKey.KEY_ID_1395, "click", "guessing_succ", ""));
    }

    public void k(int i, int i2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        String str = "guessyes_clk";
        if (i == 0) {
            str = "guessno_clk";
        }
        try {
            if (z) {
                jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, "single");
            } else {
                jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, "team");
            }
            jSONObject.put("is_double", i2);
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_ACTIVITY_NAME, "gongyan_newyear");
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", str).setContentExt(null, UbcStatConstant.SubPage.GUESS_POPUP, jSONObject));
        } catch (JSONException e) {
            BdLog.e(e);
        }
    }

    public void nu(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (z) {
                jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, "single");
            } else {
                jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, "team");
            }
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_ACTIVITY_NAME, "gongyan_newyear");
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "guesspop_show").setContentExt(null, UbcStatConstant.SubPage.GUESS_POPUP, jSONObject));
        } catch (JSONException e) {
            BdLog.e(e);
        }
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
        return new UbcStatisticItem(str, str2, "liveroom", str3).setContentExt(jSONObject);
    }

    private void a(UbcStatisticItem ubcStatisticItem) {
        UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
    }
}
