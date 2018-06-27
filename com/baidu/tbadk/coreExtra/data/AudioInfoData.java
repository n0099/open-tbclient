package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AudioInfoData extends com.baidu.tbadk.core.data.i implements Serializable {
    private static final long serialVersionUID = -3295150133270063363L;
    private int errorCode;
    private String errorMsg;
    private String errorUserMsg;
    private String voiceId;

    @Override // com.baidu.tbadk.core.data.i
    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.i
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("error");
                if (optJSONObject != null) {
                    this.errorCode = optJSONObject.optInt("errno", -1);
                    this.errorMsg = optJSONObject.optString("errmsg", null);
                    this.errorUserMsg = optJSONObject.optString("usermsg", null);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("info");
                if (optJSONObject2 != null) {
                    this.voiceId = optJSONObject2.optString("voice_md5", null);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String getVoiceId() {
        return this.voiceId;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getErrorUserMsg() {
        return this.errorUserMsg;
    }
}
