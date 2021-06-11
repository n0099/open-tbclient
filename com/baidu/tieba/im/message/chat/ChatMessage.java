package com.baidu.tieba.im.message.chat;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.MsgLocalData;
import d.a.c.c.e.c.a;
import d.a.c.e.m.b;
import d.a.c.k.e.n;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class ChatMessage extends TbSocketMessage implements a, n {
    public long bornTime;
    public transient MsgCacheData cacheData;
    public String content;
    public int customGroupType;
    public int followStatus;
    public GifInfo gifInfo;
    public String groupId;
    public boolean hasRead;
    public boolean hasRepeat;
    public int height;
    public int isFriend;
    public boolean isGifLoadSuccess;
    public boolean isUploading;
    public String link;
    public MsgLocalData localData;
    public long logTime;
    public boolean mIsPushForOperateAccount;
    public LinkedList<IconData> mTShowIconInfo;
    public long mToUserId;
    public long msgId;
    public int msgType;
    public Object objContent;
    public int progressValue;
    public int readCountPv;
    public long recordId;
    public long serviceId;
    public long sid;
    public String st_type;
    public String stat;
    public long statisticsServiceId;
    public long statisticsTaskId;
    public long taskId;
    public long time;
    public UserData toUserInfo;
    public long userId;
    public UserData userInfo;
    public int width;
    public static final BdUniqueId TYPE_MSG_LEFT = BdUniqueId.gen();
    public static final BdUniqueId TYPE_MSG_RIGHT = BdUniqueId.gen();
    public static final BdUniqueId TYPE_MSG_MID = BdUniqueId.gen();
    public static final BdUniqueId TYPE_MSG_TOPIC = BdUniqueId.gen();
    public static final BdUniqueId TYPE_MSG_GROUP_ACTIVITY = BdUniqueId.gen();
    public static final BdUniqueId TYPE_MSG_MULTI_PIC_TEXT = BdUniqueId.gen();
    public static final BdUniqueId TYPE_MSG_REPLY_CARD = BdUniqueId.gen();
    public static final BdUniqueId TYPE_MSG_PHOTOLIVE = BdUniqueId.gen();

    public ChatMessage(int i2) {
        super(i2);
        this.progressValue = 0;
        this.statisticsTaskId = -1L;
        this.statisticsServiceId = -1L;
        this.mIsPushForOperateAccount = false;
        this.isGifLoadSuccess = true;
        this.isUploading = false;
    }

    public long getBornTime() {
        return this.bornTime;
    }

    public MsgCacheData getCacheData() {
        return this.cacheData;
    }

    public String getContent() {
        return this.content;
    }

    public int getCustomGroupType() {
        return this.customGroupType;
    }

    public int getFollowStatus() {
        return this.followStatus;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GifInfo getGifInfo() {
        JSONObject jSONObject;
        JSONArray jSONArray;
        GifInfo gifInfo = this.gifInfo;
        if (gifInfo != null) {
            return gifInfo;
        }
        String str = this.content;
        try {
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException unused) {
                jSONObject = new JSONObject(str);
            }
        } catch (JSONException unused2) {
        }
        if (jSONArray.length() > 0) {
            jSONObject = jSONArray.getJSONObject(0);
            if (jSONObject == null) {
                String optString = jSONObject.optString("face_name");
                String optString2 = jSONObject.optString("url_s");
                String optString3 = jSONObject.optString("url_d");
                String optString4 = jSONObject.optString("pid");
                String optString5 = jSONObject.optString("packet_name");
                String optString6 = jSONObject.optString("icon");
                int optInt = jSONObject.optInt("size_width");
                int optInt2 = jSONObject.optInt("size_height");
                GifInfo gifInfo2 = new GifInfo();
                gifInfo2.mLoadFailed = false;
                gifInfo2.mSharpText = optString;
                gifInfo2.mStaticUrl = optString2;
                gifInfo2.mDynamicUrl = optString3;
                gifInfo2.mGid = optString4;
                gifInfo2.mGifWidth = optInt;
                gifInfo2.mGifHeight = optInt2;
                gifInfo2.mPackageName = optString5;
                gifInfo2.mIcon = optString6;
                this.gifInfo = gifInfo2;
                return gifInfo2;
            }
            return null;
        }
        jSONObject = null;
        if (jSONObject == null) {
        }
    }

    public String getGroupId() {
        return this.groupId;
    }

    public int getHeight() {
        return this.height;
    }

    public int getIsFriend() {
        return this.isFriend;
    }

    public boolean getIsUploading() {
        return this.isUploading;
    }

    public String getLink() {
        return this.link;
    }

    public MsgLocalData getLocalData() {
        return this.localData;
    }

    public long getLogTime() {
        return this.logTime;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public Object getObjContent() {
        return this.objContent;
    }

    public int getProgressValue() {
        return this.progressValue;
    }

    public int getReadCountPv() {
        return this.readCountPv;
    }

    public long getRecordId() {
        return this.recordId;
    }

    public long getServiceId() {
        return this.serviceId;
    }

    public long getSid() {
        return this.sid;
    }

    public String getSt_type() {
        return this.st_type;
    }

    public String getStat() {
        return this.stat;
    }

    public long getStatTaskId() {
        long j = this.statisticsTaskId;
        if (j != -1) {
            return j;
        }
        if (!TextUtils.isEmpty(this.content)) {
            try {
                JSONArray jSONArray = new JSONArray(this.content);
                if (jSONArray.length() > 0) {
                    this.statisticsTaskId = b.f(jSONArray.optJSONObject(0).optString("task_id"), 0L);
                }
            } catch (Exception unused) {
            }
        }
        if (this.statisticsTaskId <= 0) {
            long j2 = this.taskId;
            this.statisticsTaskId = j2 >= 0 ? j2 : 0L;
        }
        return this.statisticsTaskId;
    }

    public long getStatisticsServiceId() {
        long j = this.statisticsServiceId;
        if (j != -1) {
            return j;
        }
        if (!TextUtils.isEmpty(this.content)) {
            try {
                JSONArray jSONArray = new JSONArray(this.content);
                if (jSONArray.length() > 0) {
                    this.statisticsServiceId = b.f(jSONArray.optJSONObject(0).optString("service_id"), 0L);
                }
            } catch (Exception unused) {
            }
        }
        if (this.statisticsServiceId <= 0) {
            long j2 = this.serviceId;
            this.statisticsServiceId = j2 >= 0 ? j2 : 0L;
        }
        return this.statisticsServiceId;
    }

    public LinkedList<IconData> getTShowInfo() {
        return this.mTShowIconInfo;
    }

    public long getTaskId() {
        return this.taskId;
    }

    public long getTime() {
        return this.time;
    }

    public long getToUserId() {
        return this.mToUserId;
    }

    public UserData getToUserInfo() {
        return this.toUserInfo;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        int i2 = this.msgType;
        if (i2 == 11) {
            return TYPE_MSG_MID;
        }
        if (i2 == 12) {
            return TYPE_MSG_TOPIC;
        }
        if (i2 == 6) {
            return TYPE_MSG_GROUP_ACTIVITY;
        }
        if (i2 == 7) {
            return TYPE_MSG_MULTI_PIC_TEXT;
        }
        if (i2 == 23) {
            return TYPE_MSG_REPLY_CARD;
        }
        if (i2 == 25) {
            return TYPE_MSG_PHOTOLIVE;
        }
        if (getUserInfo() != null && getUserInfo().getUserId() != null) {
            if (getUserInfo().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                return TYPE_MSG_RIGHT;
            }
            return TYPE_MSG_LEFT;
        }
        return TYPE_MSG_LEFT;
    }

    public long getUserId() {
        return this.userId;
    }

    public UserData getUserInfo() {
        return this.userInfo;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isGifLoadSuccess() {
        return this.isGifLoadSuccess;
    }

    public boolean isHasRead() {
        return this.hasRead;
    }

    public boolean isPushForOperateAccount() {
        return this.mIsPushForOperateAccount;
    }

    @Override // d.a.c.c.e.c.a
    public boolean onFindMessage(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof ChatMessage)) {
            ChatMessage chatMessage = (ChatMessage) socketMessage;
            return chatMessage.getGroupId() != null && chatMessage.getRecordId() == this.recordId && chatMessage.getGroupId().equals(this.groupId) && chatMessage.getToUserId() == this.mToUserId;
        }
        return false;
    }

    public void setBornTime(long j) {
        this.bornTime = j;
    }

    public void setCacheData(MsgCacheData msgCacheData) {
        this.cacheData = msgCacheData;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCustomGroupType(int i2) {
        this.customGroupType = i2;
    }

    public void setFollowStatus(int i2) {
        this.followStatus = i2;
    }

    public void setGifLoadSuccess(boolean z) {
        this.isGifLoadSuccess = z;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setHasRead(boolean z) {
        this.hasRead = z;
    }

    public void setHeight(int i2) {
        this.height = i2;
    }

    public void setIsFriend(int i2) {
        this.isFriend = i2;
    }

    public void setIsPushForOperateAccount(boolean z) {
        this.mIsPushForOperateAccount = z;
    }

    public void setIsUploading(boolean z) {
        this.isUploading = z;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setLocalData(MsgLocalData msgLocalData) {
        this.localData = msgLocalData;
    }

    public void setLogTime(long j) {
        this.logTime = j;
    }

    public void setMsgId(long j) {
        this.msgId = j;
    }

    public void setMsgType(int i2) {
        this.msgType = i2;
    }

    public void setObjContent(Object obj) {
        this.objContent = obj;
    }

    public void setProgressValue(int i2) {
        this.progressValue = i2;
    }

    public void setReadCountPv(int i2) {
        this.readCountPv = i2;
    }

    public void setRecordId(long j) {
        this.recordId = j;
    }

    public void setServiceId(long j) {
        this.serviceId = j;
    }

    public void setSid(long j) {
        this.sid = j;
    }

    public void setSt_type(String str) {
        this.st_type = str;
    }

    public void setStat(String str) {
        this.stat = str;
    }

    public void setTShowInfo(LinkedList<IconData> linkedList) {
        this.mTShowIconInfo = linkedList;
    }

    public void setTaskId(long j) {
        this.taskId = j;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setToUserId(long j) {
        this.mToUserId = j;
    }

    public void setToUserInfo(UserData userData) {
        this.toUserInfo = userData;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setUserInfo(UserData userData) {
        this.userInfo = userData;
    }

    public void setWidth(int i2) {
        this.width = i2;
    }
}
