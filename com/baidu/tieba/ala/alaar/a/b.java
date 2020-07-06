package com.baidu.tieba.ala.alaar.a;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class b {
    private static b fhh = new b();
    public static boolean fhk = false;
    private JSONObject fhi;
    private int fhj = 3;

    public static b bsh() {
        return fhh;
    }

    public void init() {
        loadData();
    }

    public void bsi() {
        HttpMessage httpMessage = new HttpMessage(1021204);
        httpMessage.setTag(null);
        httpMessage.addParam("classification_id", bsk());
        httpMessage.addParam(HttpConstants.HTTP_HARDWARE, Build.HARDWARE);
        httpMessage.addParam("live_model", Build.MODEL);
        httpMessage.addParam("manufacture", Build.MANUFACTURER);
        httpMessage.addParam("quality_sign", bsj());
        httpMessage.addParam("submodule", "live");
        httpMessage.addParam(HttpConstants.HTTP_BOARD, Build.BOARD);
        httpMessage.addParam("arsdk_version", String.valueOf(com.baidu.minivideo.arface.a.getVersion()));
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private String bsj() {
        String str = null;
        if (!isEmpty()) {
            str = this.fhi.optString("quality_sign");
        }
        if (TextUtils.isEmpty(str)) {
            return "default";
        }
        return str;
    }

    private String bsk() {
        String str = null;
        if (!isEmpty()) {
            str = this.fhi.optString("classification_id");
        }
        if (TextUtils.isEmpty(str)) {
            return "default";
        }
        return str;
    }

    public JSONObject bsl() {
        if (isEmpty()) {
            return null;
        }
        return this.fhi.optJSONObject("classification");
    }

    public JSONObject bsm() {
        if (isEmpty()) {
            return null;
        }
        return this.fhi.optJSONObject("quality");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x0104 -> B:69:0x00cf). Please submit an issue!!! */
    public JSONObject cT(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return this.fhi;
        }
        if (this.fhi == null) {
            if (jSONObject.has("quality") && com.baidu.live.ar.b.s(jSONObject.optJSONObject("quality")) == null) {
                return null;
            }
            return jSONObject;
        }
        String optString = this.fhi.optString("classification_id");
        JSONObject optJSONObject = this.fhi.optJSONObject("classification");
        String jSONObject3 = optJSONObject != null ? optJSONObject.toString() : null;
        if (jSONObject.has("classification_id")) {
            String optString2 = jSONObject.optString("classification_id");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("classification");
            String jSONObject4 = optJSONObject2 != null ? optJSONObject2.toString() : null;
            if (optString2 != null) {
                try {
                    if (!optString2.equals(optString) && jSONObject4 != null && !jSONObject4.equals(jSONObject3)) {
                        jSONObject2.put("classification_id", optString2);
                        jSONObject2.put("classification", optJSONObject2);
                    }
                } catch (JSONException e) {
                }
            }
            jSONObject2.put("classification_id", optString);
            jSONObject2.put("classification", optJSONObject);
        } else {
            try {
                jSONObject2.put("classification_id", optString);
                jSONObject2.put("classification", optJSONObject);
            } catch (JSONException e2) {
            }
        }
        String optString3 = this.fhi.optString("quality_sign");
        JSONObject optJSONObject3 = this.fhi.optJSONObject("quality");
        String jSONObject5 = optJSONObject3 != null ? optJSONObject3.toString() : null;
        if (jSONObject.has("quality_sign")) {
            String optString4 = jSONObject.optString("quality_sign");
            JSONObject optJSONObject4 = jSONObject.optJSONObject("quality");
            String jSONObject6 = optJSONObject4 != null ? optJSONObject4.toString() : null;
            try {
                com.baidu.live.ar.b s = com.baidu.live.ar.b.s(optJSONObject4);
                if (optString4 != null && !optString4.equals(optString3) && jSONObject6 != null && !jSONObject6.equals(jSONObject5) && s != null) {
                    jSONObject2.put("quality_sign", optString4);
                    jSONObject2.put("quality", optJSONObject4);
                } else {
                    jSONObject2.put("quality_sign", optString3);
                    jSONObject2.put("quality", optJSONObject3);
                }
            } catch (JSONException e3) {
            }
        } else {
            try {
                jSONObject2.put("quality_sign", optString3);
                jSONObject2.put("quality", optJSONObject3);
            } catch (JSONException e4) {
            }
        }
        return jSONObject2;
    }

    public void d(JSONObject jSONObject, boolean z) {
        if (jSONObject != null && jSONObject.length() != 0) {
            if (z) {
                cU(jSONObject);
            }
            this.fhi = jSONObject;
            com.baidu.minivideo.arface.b.setGradingConfig(bsl());
            com.baidu.minivideo.arface.b.Y(bsm());
        }
    }

    private void cU(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            c.vf().putString("ar_grading_quality_config", jSONObject.toString());
            if (com.baidu.live.ar.b.d(this.fhi, jSONObject)) {
                c.vf().putBoolean("ar_grading_quality_config_need_update", true);
            }
        }
    }

    private void bsn() {
        String string = c.vf().getString("ar_grading_quality_config", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                d(new JSONObject(string), false);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    protected void loadData() {
        bsn();
        bsi();
    }

    public boolean isEmpty() {
        return this.fhi == null || this.fhi.length() == 0;
    }
}
