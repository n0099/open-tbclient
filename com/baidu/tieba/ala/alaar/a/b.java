package com.baidu.tieba.ala.alaar.a;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.d;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b {
    private static b gsV = new b();
    public static boolean gsY = false;
    private JSONObject gsW;
    private int gsX = 3;

    public static b bPJ() {
        return gsV;
    }

    public void init() {
        loadData();
    }

    public void bPK() {
        HttpMessage httpMessage = new HttpMessage(1021204);
        httpMessage.setTag(null);
        httpMessage.addParam("classification_id", bPM());
        httpMessage.addParam(HttpConstants.HTTP_HARDWARE, Build.HARDWARE);
        httpMessage.addParam("live_model", Build.MODEL);
        httpMessage.addParam("manufacture", Build.MANUFACTURER);
        httpMessage.addParam("quality_sign", bPL());
        httpMessage.addParam("submodule", "live");
        httpMessage.addParam(HttpConstants.HTTP_BOARD, Build.BOARD);
        httpMessage.addParam("arsdk_version", String.valueOf(com.baidu.minivideo.arface.a.getVersion()));
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private String bPL() {
        String str = null;
        if (!isEmpty()) {
            str = this.gsW.optString("quality_sign");
        }
        if (TextUtils.isEmpty(str)) {
            return DefaultSharedPrefsWrapper.SP_FILE_DEFAULT;
        }
        return str;
    }

    private String bPM() {
        String str = null;
        if (!isEmpty()) {
            str = this.gsW.optString("classification_id");
        }
        if (TextUtils.isEmpty(str)) {
            return DefaultSharedPrefsWrapper.SP_FILE_DEFAULT;
        }
        return str;
    }

    public JSONObject bPN() {
        if (isEmpty()) {
            return null;
        }
        return this.gsW.optJSONObject("classification");
    }

    public JSONObject bPO() {
        if (isEmpty()) {
            return null;
        }
        return this.gsW.optJSONObject("quality");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x0104 -> B:69:0x00cf). Please submit an issue!!! */
    public JSONObject dF(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return this.gsW;
        }
        if (this.gsW == null) {
            if (jSONObject.has("quality") && com.baidu.live.ar.b.w(jSONObject.optJSONObject("quality")) == null) {
                return null;
            }
            return jSONObject;
        }
        String optString = this.gsW.optString("classification_id");
        JSONObject optJSONObject = this.gsW.optJSONObject("classification");
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
        String optString3 = this.gsW.optString("quality_sign");
        JSONObject optJSONObject3 = this.gsW.optJSONObject("quality");
        String jSONObject5 = optJSONObject3 != null ? optJSONObject3.toString() : null;
        if (jSONObject.has("quality_sign")) {
            String optString4 = jSONObject.optString("quality_sign");
            JSONObject optJSONObject4 = jSONObject.optJSONObject("quality");
            String jSONObject6 = optJSONObject4 != null ? optJSONObject4.toString() : null;
            try {
                com.baidu.live.ar.b w = com.baidu.live.ar.b.w(optJSONObject4);
                if (optString4 != null && !optString4.equals(optString3) && jSONObject6 != null && !jSONObject6.equals(jSONObject5) && w != null) {
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

    public void f(JSONObject jSONObject, boolean z) {
        if (jSONObject != null && jSONObject.length() != 0) {
            if (z) {
                dG(jSONObject);
            }
            this.gsW = jSONObject;
            com.baidu.minivideo.arface.b.setGradingConfig(bPN());
            com.baidu.minivideo.arface.b.av(bPO());
        }
    }

    private void dG(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            String jSONObject2 = jSONObject.toString();
            d.xc().putString("ar_grading_quality_config", jSONObject2);
            if (com.baidu.live.ar.b.c(this.gsW, jSONObject)) {
                d.xc().putBoolean("ar_grading_quality_config_need_update", true);
                if (isDebug()) {
                    Log.d("GradingQualityConfig", "saveCache: need update quality value ");
                }
            }
            if (isDebug()) {
                Log.d("GradingQualityConfig", "saveCache: " + jSONObject2);
            }
        }
    }

    private void bPP() {
        String string = d.xc().getString("ar_grading_quality_config", "");
        if (isDebug()) {
            Log.d("GradingQualityConfig", "readCache: " + string);
        }
        if (!TextUtils.isEmpty(string)) {
            try {
                f(new JSONObject(string), false);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    protected void loadData() {
        bPP();
        bPK();
    }

    public boolean isEmpty() {
        return this.gsW == null || this.gsW.length() == 0;
    }

    public static boolean isDebug() {
        return com.baidu.minivideo.arface.b.isDebug();
    }
}
