package com.baidu.tieba.im.message.chat;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.client.socket.a;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.widget.ListView.i;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.MsgLocalData;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class ChatMessage extends TbSocketMessage implements a, i {
    private long bornTime;
    private transient MsgCacheData cacheData;
    private String content;
    private int customGroupType;
    private int followStatus;
    private GifInfo gifInfo;
    private String groupId;
    private boolean hasRead;
    public boolean hasRepeat;
    private int height;
    private int isFriend;
    private boolean isGifLoadSuccess;
    private boolean isUploading;
    private String link;
    private MsgLocalData localData;
    private long logTime;
    private boolean mIsPushForOperateAccount;
    private LinkedList<IconData> mTShowIconInfo;
    private long mToUserId;
    private long msgId;
    private int msgType;
    private Object objContent;
    private int progressValue;
    private long recordId;
    private long sid;
    private String st_type;
    private String stat;
    private long statisticsTaskId;
    private long taskId;
    private long time;
    private UserData toUserInfo;
    private long userId;
    private UserData userInfo;
    private int width;
    public static final BdUniqueId TYPE_MSG_LEFT = BdUniqueId.gen();
    public static final BdUniqueId TYPE_MSG_RIGHT = BdUniqueId.gen();
    public static final BdUniqueId TYPE_MSG_MID = BdUniqueId.gen();
    public static final BdUniqueId TYPE_MSG_TOPIC = BdUniqueId.gen();
    public static final BdUniqueId TYPE_MSG_GROUP_ACTIVITY = BdUniqueId.gen();
    public static final BdUniqueId TYPE_MSG_MULTI_PIC_TEXT = BdUniqueId.gen();
    public static final BdUniqueId TYPE_MSG_REPLY_CARD = BdUniqueId.gen();
    public static final BdUniqueId TYPE_MSG_PHOTOLIVE = BdUniqueId.gen();
    public static final BdUniqueId TYPE_MSG_TEXT_OFFICAL_NOTIFICATION = BdUniqueId.gen();

    public ChatMessage(int i) {
        super(i);
        this.progressValue = 0;
        this.statisticsTaskId = -1L;
        this.mIsPushForOperateAccount = false;
        this.isGifLoadSuccess = true;
        this.isUploading = false;
    }

    public boolean isPushForOperateAccount() {
        return this.mIsPushForOperateAccount;
    }

    public void setIsPushForOperateAccount(boolean z) {
        this.mIsPushForOperateAccount = z;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public long getBornTime() {
        return this.bornTime;
    }

    public void setBornTime(long j) {
        this.bornTime = j;
    }

    public long getToUserId() {
        return this.mToUserId;
    }

    public void setToUserId(long j) {
        this.mToUserId = j;
    }

    public GifInfo getGifInfo() {
        JSONObject jSONObject;
        if (this.gifInfo != null) {
            return this.gifInfo;
        }
        String str = this.content;
        try {
            JSONArray jSONArray = new JSONArray(str);
            jSONObject = jSONArray.length() > 0 ? jSONArray.getJSONObject(0) : null;
        } catch (JSONException e) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e2) {
                jSONObject = null;
            }
        }
        if (jSONObject != null) {
            String optString = jSONObject.optString("face_name");
            String optString2 = jSONObject.optString("url_s");
            String optString3 = jSONObject.optString("url_d");
            String optString4 = jSONObject.optString(Info.kBaiduPIDKey);
            String optString5 = jSONObject.optString("packet_name");
            String optString6 = jSONObject.optString("icon");
            int optInt = jSONObject.optInt("size_width");
            int optInt2 = jSONObject.optInt("size_height");
            GifInfo gifInfo = new GifInfo();
            gifInfo.mLoadFailed = false;
            gifInfo.mSharpText = optString;
            gifInfo.mStaticUrl = optString2;
            gifInfo.mDynamicUrl = optString3;
            gifInfo.mGid = optString4;
            gifInfo.mGifWidth = optInt;
            gifInfo.mGifHeight = optInt2;
            gifInfo.mPackageName = optString5;
            gifInfo.mIcon = optString6;
            this.gifInfo = gifInfo;
            return gifInfo;
        }
        return null;
    }

    public String getSt_type() {
        return this.st_type;
    }

    public void setSt_type(String str) {
        this.st_type = str;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public String getStat() {
        return this.stat;
    }

    public void setStat(String str) {
        this.stat = str;
    }

    public long getTaskId() {
        return this.taskId;
    }

    public void setTaskId(long j) {
        this.taskId = j;
    }

    public void setTShowInfo(LinkedList<IconData> linkedList) {
        this.mTShowIconInfo = linkedList;
    }

    public LinkedList<IconData> getTShowInfo() {
        return this.mTShowIconInfo;
    }

    public boolean getIsUploading() {
        return this.isUploading;
    }

    public void setIsUploading(boolean z) {
        this.isUploading = z;
    }

    public int getProgressValue() {
        return this.progressValue;
    }

    public void setProgressValue(int i) {
        this.progressValue = i;
    }

    public Object getObjContent() {
        return this.objContent;
    }

    public void setObjContent(Object obj) {
        this.objContent = obj;
    }

    public UserData getUserInfo() {
        return this.userInfo;
    }

    public void setUserInfo(UserData userData) {
        this.userInfo = userData;
    }

    public UserData getToUserInfo() {
        return this.toUserInfo;
    }

    public void setToUserInfo(UserData userData) {
        this.toUserInfo = userData;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public void setMsgType(int i) {
        this.msgType = i;
    }

    public long getRecordId() {
        return this.recordId;
    }

    public void setRecordId(long j) {
        this.recordId = j;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public void setMsgId(long j) {
        this.msgId = j;
    }

    public long getSid() {
        return this.sid;
    }

    public void setSid(long j) {
        this.sid = j;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public MsgLocalData getLocalData() {
        return this.localData;
    }

    public void setLocalData(MsgLocalData msgLocalData) {
        this.localData = msgLocalData;
    }

    public MsgCacheData getCacheData() {
        return this.cacheData;
    }

    public void setCacheData(MsgCacheData msgCacheData) {
        this.cacheData = msgCacheData;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public boolean isGifLoadSuccess() {
        return this.isGifLoadSuccess;
    }

    public void setGifLoadSuccess(boolean z) {
        this.isGifLoadSuccess = z;
    }

    public long getLogTime() {
        return this.logTime;
    }

    public void setLogTime(long j) {
        this.logTime = j;
    }

    public int getIsFriend() {
        return this.isFriend;
    }

    public void setIsFriend(int i) {
        this.isFriend = i;
    }

    public void setFollowStatus(int i) {
        this.followStatus = i;
    }

    public int getFollowStatus() {
        return this.followStatus;
    }

    public int getCustomGroupType() {
        return this.customGroupType;
    }

    public void setCustomGroupType(int i) {
        this.customGroupType = i;
    }

    public boolean isHasRead() {
        return this.hasRead;
    }

    public void setHasRead(boolean z) {
        this.hasRead = z;
    }

    @Override // com.baidu.adp.framework.client.socket.a
    public boolean onFindMessage(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof ChatMessage)) {
            ChatMessage chatMessage = (ChatMessage) socketMessage;
            return chatMessage.getGroupId() != null && chatMessage.getRecordId() == this.recordId && chatMessage.getGroupId().equals(this.groupId) && chatMessage.getToUserId() == this.mToUserId;
        }
        return false;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (com.baidu.tbadk.coreExtra.messageCenter.a.GI().Hh() != null && com.baidu.tbadk.coreExtra.messageCenter.a.GI().Hh().contains(String.valueOf(this.userId)) && this.msgType == 1) {
            return TYPE_MSG_TEXT_OFFICAL_NOTIFICATION;
        }
        if (this.msgType == 11) {
            return TYPE_MSG_MID;
        }
        if (this.msgType == 12) {
            return TYPE_MSG_TOPIC;
        }
        if (this.msgType == 6) {
            return TYPE_MSG_GROUP_ACTIVITY;
        }
        if (this.msgType == 7) {
            return TYPE_MSG_MULTI_PIC_TEXT;
        }
        if (this.msgType == 23) {
            return TYPE_MSG_REPLY_CARD;
        }
        if (this.msgType == 25) {
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

    public long getStatTaskId() {
        if (this.statisticsTaskId != -1) {
            return this.statisticsTaskId;
        }
        if (!TextUtils.isEmpty(this.content)) {
            try {
                JSONArray jSONArray = new JSONArray(this.content);
                if (jSONArray.length() > 0) {
                    this.statisticsTaskId = b.c(jSONArray.optJSONObject(0).optString("task_id"), 0L);
                }
            } catch (Exception e) {
            }
        }
        if (this.statisticsTaskId <= 0) {
            this.statisticsTaskId = this.taskId >= 0 ? this.taskId : 0L;
        }
        return this.statisticsTaskId;
    }
}
