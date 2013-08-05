package com.baidu.tieba.data;

import com.baidu.android.pushservice.PushConstants;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SendPKVoteData implements Serializable {
    private static final long serialVersionUID = 1;
    private long cTime;
    private Error error;
    private int errorCode;
    private String errorMsg;
    private int logId;
    private PKInfo pkInfo;
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

    public PKInfo getPkInfo() {
        return this.pkInfo;
    }

    public void setPkInfo(PKInfo pKInfo) {
        this.pkInfo = pKInfo;
    }

    public Error getError() {
        return this.error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
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

    public int getLogId() {
        return this.logId;
    }

    public void setLogId(int i) {
        this.logId = i;
    }

    public SendPKVoteData parserJson(String str) {
        try {
            return a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "parserJson", e.toString());
            return null;
        }
    }

    private SendPKVoteData a(JSONObject jSONObject) {
        try {
            SendPKVoteData sendPKVoteData = new SendPKVoteData();
            sendPKVoteData.setShareId(jSONObject.optString("share_id"));
            sendPKVoteData.setShareText(jSONObject.optString("share_text"));
            sendPKVoteData.setResultPic(jSONObject.optString("result_pic"));
            sendPKVoteData.setPkInfo(new PKInfo().parserJson(jSONObject.optJSONObject("pk_info")));
            sendPKVoteData.setError(new Error().a(jSONObject.optJSONObject("error")));
            sendPKVoteData.setErrorCode(jSONObject.optInt("error_code"));
            sendPKVoteData.setErrorMsg(jSONObject.optString(PushConstants.EXTRA_ERROR_CODE));
            sendPKVoteData.setTime(jSONObject.optLong("time"));
            sendPKVoteData.setcTime(jSONObject.optLong("ctime"));
            sendPKVoteData.setLogId(jSONObject.optInt("logid"));
            return sendPKVoteData;
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "parserJson", e.toString());
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class Error implements Serializable {
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
                com.baidu.tieba.util.aj.b(getClass().getName(), "parserJson", e.toString());
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    public class PKInfo implements Serializable {
        private String abstractS;
        private long endTime;
        private int pkId;
        private String pkUrl;
        private Player player1;
        private Player player2;
        private long remainTime;
        private long startTime;
        private int status;
        private String title;

        public PKInfo() {
        }

        public int getPkId() {
            return this.pkId;
        }

        public void setPkId(int i) {
            this.pkId = i;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getAbstractS() {
            return this.abstractS;
        }

        public void setAbstractS(String str) {
            this.abstractS = str;
        }

        public String getPkUrl() {
            return this.pkUrl;
        }

        public void setPkUrl(String str) {
            this.pkUrl = str;
        }

        public long getStartTime() {
            return this.startTime;
        }

        public void setStartTime(long j) {
            this.startTime = j;
        }

        public long getEndTime() {
            return this.endTime;
        }

        public void setEndTime(long j) {
            this.endTime = j;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int i) {
            this.status = i;
        }

        public long getRemainTime() {
            return this.remainTime;
        }

        public void setRemainTime(long j) {
            this.remainTime = j;
        }

        public Player getPlayer1() {
            return this.player1;
        }

        public void setPlayer1(Player player) {
            this.player1 = player;
        }

        public Player getPlayer2() {
            return this.player2;
        }

        public void setPlayer2(Player player) {
            this.player2 = player;
        }

        public PKInfo parserJson(JSONObject jSONObject) {
            try {
                PKInfo pKInfo = new PKInfo();
                pKInfo.setPkId(jSONObject.optInt("pk_id"));
                pKInfo.setTitle(jSONObject.optString("title"));
                pKInfo.setAbstractS(jSONObject.optString("abstract"));
                pKInfo.setPkUrl(jSONObject.optString("pk_url"));
                pKInfo.setStartTime(jSONObject.optLong("start_time"));
                pKInfo.setEndTime(jSONObject.optLong("end_time"));
                pKInfo.setStatus(jSONObject.optInt("status"));
                pKInfo.setRemainTime(jSONObject.optLong("remain_time"));
                pKInfo.setPlayer1(new Player().parserJson(jSONObject.optJSONObject("player1")));
                pKInfo.setPlayer2(new Player().parserJson(jSONObject.optJSONObject("player2")));
                return pKInfo;
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b(getClass().getName(), "parserJson", e.toString());
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    public class Player implements Serializable {
        private int playerId;
        private String playerName;
        private String smallHeadUrl;
        private int voteNumver;
        private int voteTimes;

        public Player() {
        }

        public int getPlayerId() {
            return this.playerId;
        }

        public void setPlayerId(int i) {
            this.playerId = i;
        }

        public String getPlayerName() {
            return this.playerName;
        }

        public void setPlayerName(String str) {
            this.playerName = str;
        }

        public String getSmallHeadUrl() {
            return this.smallHeadUrl;
        }

        public void setSmallHeadUrl(String str) {
            this.smallHeadUrl = str;
        }

        public int getVoteNumver() {
            return this.voteNumver;
        }

        public void setVoteNumver(int i) {
            this.voteNumver = i;
        }

        public int getVoteTimes() {
            return this.voteTimes;
        }

        public void setVoteTimes(int i) {
            this.voteTimes = i;
        }

        public Player parserJson(JSONObject jSONObject) {
            try {
                Player player = new Player();
                player.setPlayerId(jSONObject.optInt("player_id"));
                player.setPlayerName(jSONObject.optString("player_name"));
                player.setSmallHeadUrl(jSONObject.optString("small_head_url"));
                player.setVoteNumver(jSONObject.optInt("vote_number"));
                player.setVoteTimes(jSONObject.optInt("vote_times"));
                return player;
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b(getClass().getName(), "parserJson", e.toString());
                return null;
            }
        }
    }
}
