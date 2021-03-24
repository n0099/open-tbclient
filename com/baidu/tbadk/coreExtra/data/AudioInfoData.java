package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import d.b.h0.r.q.o;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AudioInfoData extends o implements Serializable {
    public static final long serialVersionUID = -3295150133270063363L;
    public int errorCode;
    public String errorMsg;
    public String errorUserMsg;
    public String voiceId;

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getErrorUserMsg() {
        return this.errorUserMsg;
    }

    public String getVoiceId() {
        return this.voiceId;
    }

    @Override // d.b.h0.r.q.o
    public void parserJson(String str) {
        if (str == null) {
            return;
        }
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    @Override // d.b.h0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("error");
            if (optJSONObject != null) {
                this.errorCode = optJSONObject.optInt("errno", -1);
                this.errorMsg = optJSONObject.optString("errmsg", null);
                this.errorUserMsg = optJSONObject.optString(VideoFinishResult.KEY_ERROR_USER_MSG, null);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("info");
            if (optJSONObject2 != null) {
                this.voiceId = optJSONObject2.optString("voice_md5", null);
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
