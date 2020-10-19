package com.baidu.tieba.ala.alaar.a;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class b {
    private static b fNk = new b();
    public static boolean fNn = false;
    private JSONObject fNl;
    private int fNm = 3;

    public static b bIo() {
        return fNk;
    }

    public void init() {
        loadData();
    }

    public void bIp() {
        HttpMessage httpMessage = new HttpMessage(1021204);
        httpMessage.setTag(null);
        httpMessage.addParam("classification_id", bIr());
        httpMessage.addParam(HttpConstants.HTTP_HARDWARE, Build.HARDWARE);
        httpMessage.addParam("live_model", Build.MODEL);
        httpMessage.addParam("manufacture", Build.MANUFACTURER);
        httpMessage.addParam("quality_sign", bIq());
        httpMessage.addParam("submodule", "live");
        httpMessage.addParam(HttpConstants.HTTP_BOARD, Build.BOARD);
        httpMessage.addParam("arsdk_version", String.valueOf(com.baidu.minivideo.arface.a.getVersion()));
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private String bIq() {
        String str = null;
        if (!isEmpty()) {
            str = this.fNl.optString("quality_sign");
        }
        if (TextUtils.isEmpty(str)) {
            return "default";
        }
        return str;
    }

    private String bIr() {
        String str = null;
        if (!isEmpty()) {
            str = this.fNl.optString("classification_id");
        }
        if (TextUtils.isEmpty(str)) {
            return "default";
        }
        return str;
    }

    public JSONObject bIs() {
        if (isEmpty()) {
            return null;
        }
        return this.fNl.optJSONObject("classification");
    }

    public JSONObject bIt() {
        if (isEmpty()) {
            return null;
        }
        return this.fNl.optJSONObject("quality");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x0104 -> B:69:0x00cf). Please submit an issue!!! */
    public JSONObject dq(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return this.fNl;
        }
        if (this.fNl == null) {
            if (jSONObject.has("quality") && com.baidu.live.ar.b.t(jSONObject.optJSONObject("quality")) == null) {
                return null;
            }
            return jSONObject;
        }
        String optString = this.fNl.optString("classification_id");
        JSONObject optJSONObject = this.fNl.optJSONObject("classification");
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
        String optString3 = this.fNl.optString("quality_sign");
        JSONObject optJSONObject3 = this.fNl.optJSONObject("quality");
        String jSONObject5 = optJSONObject3 != null ? optJSONObject3.toString() : null;
        if (jSONObject.has("quality_sign")) {
            String optString4 = jSONObject.optString("quality_sign");
            JSONObject optJSONObject4 = jSONObject.optJSONObject("quality");
            String jSONObject6 = optJSONObject4 != null ? optJSONObject4.toString() : null;
            try {
                com.baidu.live.ar.b t = com.baidu.live.ar.b.t(optJSONObject4);
                if (optString4 != null && !optString4.equals(optString3) && jSONObject6 != null && !jSONObject6.equals(jSONObject5) && t != null) {
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
                dr(jSONObject);
            }
            this.fNl = jSONObject;
            com.baidu.minivideo.arface.b.setGradingConfig(bIs());
            com.baidu.minivideo.arface.b.ag(bIt());
        }
    }

    private void dr(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            String jSONObject2 = jSONObject.toString();
            c.AZ().putString("ar_grading_quality_config", jSONObject2);
            if (com.baidu.live.ar.b.d(this.fNl, jSONObject)) {
                c.AZ().putBoolean("ar_grading_quality_config_need_update", true);
                if (isDebug()) {
                    Log.d("GradingQualityConfig", "saveCache: need update quality value ");
                }
            }
            if (isDebug()) {
                Log.d("GradingQualityConfig", "saveCache: " + jSONObject2);
            }
        }
    }

    private void bIu() {
        String string = c.AZ().getString("ar_grading_quality_config", "");
        if (isDebug()) {
            Log.d("GradingQualityConfig", "readCache: " + string);
        }
        if (!TextUtils.isEmpty(string)) {
            try {
                d(new JSONObject(string), false);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    protected void loadData() {
        bIu();
        bIp();
    }

    public boolean isEmpty() {
        return this.fNl == null || this.fNl.length() == 0;
    }

    private static final boolean isDebug() {
        return com.baidu.minivideo.arface.b.isDebug();
    }
}
