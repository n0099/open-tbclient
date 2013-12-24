package com.baidu.tieba.data.chat;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.util.be;
import java.io.Serializable;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ChatData implements Serializable {
    private static final long serialVersionUID = 2998520534610453157L;
    private LinkedList<ChatMessageData> mMessage;
    private String friendId = null;
    private String friendName = null;
    private String userId = null;
    private String friendPortrait = null;
    private String userPortrait = null;
    private boolean hasMore = false;

    public ChatData() {
        this.mMessage = null;
        this.mMessage = new LinkedList<>();
    }

    public void setFriendId(String str) {
        this.friendId = str;
    }

    public String getFriendId() {
        return this.friendId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setFriendPortrait(String str) {
        this.friendPortrait = str;
    }

    public void setUserPortrait(String str) {
        this.userPortrait = str;
    }

    public String getFriendPortrait() {
        return this.friendPortrait;
    }

    public String getUserPortrait() {
        return this.userPortrait;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public LinkedList<ChatMessageData> getChatList() {
        return this.mMessage;
    }

    public void clearData() {
        this.mMessage.clear();
    }

    public void setChatList(LinkedList<ChatMessageData> linkedList) {
        this.mMessage = linkedList;
    }

    public void addChatData(ChatMessageData chatMessageData) {
        this.mMessage.add(chatMessageData);
        while (this.mMessage.size() > 1000) {
            this.mMessage.remove(0);
        }
    }

    public void mergeData(ChatData chatData) {
        long serverTime;
        long serverTime2;
        long serverTime3;
        long serverTime4;
        long j;
        LinkedList<ChatMessageData> chatList = chatData.getChatList();
        LinkedList<ChatMessageData> linkedList = new LinkedList<>();
        if (chatList != null && chatList.size() != 0 && chatList.get(0).getMsgId() != 0) {
            long j2 = 0;
            while (this.mMessage.size() > 0 && chatList.size() > 0) {
                ChatMessageData chatMessageData = chatList.get(0);
                ChatMessageData chatMessageData2 = this.mMessage.get(0);
                try {
                    serverTime3 = Long.valueOf(chatMessageData.getMsgId()).longValue();
                    serverTime4 = Long.valueOf(chatMessageData2.getMsgId()).longValue();
                } catch (Exception e) {
                    serverTime3 = chatMessageData.getServerTime();
                    serverTime4 = chatMessageData2.getServerTime();
                }
                if (serverTime3 > serverTime4) {
                    long max = Math.max(j2, serverTime4);
                    linkedList.add(chatMessageData2);
                    this.mMessage.remove(0);
                    j = max;
                } else if (serverTime3 < serverTime4) {
                    long max2 = Math.max(j2, serverTime3);
                    linkedList.add(chatMessageData);
                    chatList.remove(0);
                    j = max2;
                } else {
                    long max3 = Math.max(j2, serverTime3);
                    linkedList.add(chatMessageData);
                    chatList.remove(0);
                    this.mMessage.remove(0);
                    j = max3;
                }
                j2 = j;
            }
            while (this.mMessage.size() > 0) {
                ChatMessageData remove = this.mMessage.remove(0);
                try {
                    serverTime2 = Long.valueOf(remove.getMsgId()).longValue();
                } catch (Exception e2) {
                    serverTime2 = remove.getServerTime();
                }
                if (serverTime2 > j2) {
                    linkedList.add(remove);
                    j2 = serverTime2;
                }
            }
            while (chatList.size() > 0) {
                ChatMessageData remove2 = chatList.remove(0);
                try {
                    serverTime = Long.valueOf(remove2.getMsgId()).longValue();
                } catch (Exception e3) {
                    serverTime = remove2.getServerTime();
                }
                if (serverTime > j2) {
                    linkedList.add(remove2);
                    j2 = serverTime;
                }
            }
            this.mMessage = linkedList;
            while (this.mMessage.size() > 1000) {
                this.mMessage.remove(0);
            }
        }
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            be.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            if (jSONObject.optInt("has_more") == 0) {
                this.hasMore = false;
            } else {
                this.hasMore = true;
            }
            this.friendPortrait = jSONObject.optString("com_portrait");
            this.userPortrait = jSONObject.optString("user_portrait");
            JSONArray optJSONArray = jSONObject.optJSONArray(PushConstants.EXTRA_PUSH_MESSAGE);
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    ChatMessageData chatMessageData = new ChatMessageData();
                    chatMessageData.parserJson(optJSONArray.getJSONObject(i));
                    chatMessageData.setFriendId(this.friendId);
                    chatMessageData.setOwnerId(this.userId);
                    this.mMessage.add(chatMessageData);
                }
            }
        } catch (Exception e) {
            be.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public ChatMessageData getLastMsg() {
        if (this.mMessage.size() < 1) {
            return null;
        }
        return this.mMessage.get(this.mMessage.size() - 1);
    }

    public ChatMessageData getMsg(int i) {
        if (this.mMessage != null && i < this.mMessage.size() && i >= 0) {
            return this.mMessage.get(i);
        }
        return null;
    }

    public String getFriendName() {
        return this.friendName;
    }

    public void setFriendName(String str) {
        this.friendName = str;
    }
}
