package com.baidu.tieba.data;

import com.baidu.android.pushservice.PushConstants;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SendAloneVoteData implements Serializable {
    private static final long serialVersionUID = 1;
    private long cTime;
    private Error error;
    private String errorCode;
    private String errorMsg;
    private int logId;
    private String resultPic;
    private String shareId;
    private String shareText;
    private long time;

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public long getcTime() {
        return this.cTime;
    }

    public void setcTime(long j) {
        this.cTime = j;
    }

    public long getLogId() {
        return this.logId;
    }

    public void setLogId(int i) {
        this.logId = i;
    }

    public Error getError() {
        return this.error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public String getShareId() {
        return this.shareId;
    }

    public void setShareId(String str) {
        this.shareId = str;
    }

    public String getShareText() {
        return this.shareText;
    }

    public void setShareText(String str) {
        this.shareText = str;
    }

    public String getResultPic() {
        return this.resultPic;
    }

    public void setResultPic(String str) {
        this.resultPic = str;
    }

    public SendAloneVoteData parserJson(String str) {
        try {
            return a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "parserJson", e.toString());
            return null;
        }
    }

    private SendAloneVoteData a(JSONObject jSONObject) {
        try {
            SendAloneVoteData sendAloneVoteData = new SendAloneVoteData();
            sendAloneVoteData.setError(new Error().a(jSONObject.optJSONObject("error")));
            sendAloneVoteData.setShareId(jSONObject.optString("share_id"));
            sendAloneVoteData.setShareText(jSONObject.optString("share_text"));
            sendAloneVoteData.setResultPic(jSONObject.optString("result_pic"));
            sendAloneVoteData.setErrorCode(jSONObject.optString("error_code"));
            sendAloneVoteData.setErrorMsg(jSONObject.optString(PushConstants.EXTRA_ERROR_CODE));
            sendAloneVoteData.setTime(jSONObject.optLong("time"));
            sendAloneVoteData.setcTime(jSONObject.optLong("ctime"));
            sendAloneVoteData.setLogId(jSONObject.optInt("logid"));
            return sendAloneVoteData;
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "parserJson", e.toString());
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class Error implements Serializable {
        private static final long serialVersionUID = 1;
        private String errorId;
        private String errroMsg;
        private String userMsg;

        public Error() {
        }

        public String getErrorId() {
            return this.errorId;
        }

        public void setErrorId(String str) {
            this.errorId = str;
        }

        public String getErrroMsg() {
            return this.errroMsg;
        }

        public void setErrroMsg(String str) {
            this.errroMsg = str;
        }

        public String getUserMsg() {
            return this.userMsg;
        }

        public void setUserMsg(String str) {
            this.userMsg = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Error a(JSONObject jSONObject) {
            try {
                Error error = new Error();
                error.setErrorId(jSONObject.optString("errno"));
                error.setErrroMsg(jSONObject.optString("errmsg"));
                error.setUserMsg(jSONObject.optString("usermsg"));
                return error;
            } catch (Exception e) {
                com.baidu.tieba.util.aq.b(getClass().getName(), "parserJson", e.toString());
                return null;
            }
        }
    }
}
