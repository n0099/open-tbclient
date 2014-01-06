package com.baidu.tieba.data.chat;

import android.content.Context;
import android.text.ClipboardManager;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bo;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ChatMessageData implements Serializable {
    public static final int STATUS_RECEIVED = 1;
    public static final int STATUS_SENDING = 99;
    public static final int STATUS_SENT = 0;
    public static final int TYPE_MSG = 0;
    public static final int TYPE_NEW_CHAT_FLAG = 99;
    private static final long serialVersionUID = -3482133650101812568L;
    protected String friendId;
    protected long localTime;
    private com.baidu.tbadk.widget.richText.a mRichText = null;
    protected String msgContent;
    protected long msgId;
    protected int msgType;
    protected String ownerId;
    protected long serverTime;
    protected int status;

    public static ChatMessageData newChatFlag() {
        ChatMessageData chatMessageData = new ChatMessageData();
        chatMessageData.msgType = 99;
        return chatMessageData;
    }

    public static ChatMessageData newMessage() {
        ChatMessageData chatMessageData = new ChatMessageData();
        chatMessageData.msgType = 0;
        chatMessageData.setOwnerId(TiebaApplication.A());
        return chatMessageData;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public void setMsgId(long j) {
        this.msgId = j;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public void setOwnerId(String str) {
        this.ownerId = str;
    }

    public String getFriendId() {
        return this.friendId;
    }

    public void setFriendId(String str) {
        this.friendId = str;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public void setMsgType(int i) {
        this.msgType = i;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public long getLocalTime() {
        return this.localTime;
    }

    public void setLocalTime(long j) {
        this.localTime = j;
    }

    public long getServerTime() {
        return this.serverTime;
    }

    public void setServerTime(long j) {
        this.serverTime = j;
    }

    public String getMsgContent() {
        return this.msgContent;
    }

    public void setMsgContent(String str) {
        this.msgContent = str;
    }

    public com.baidu.tbadk.widget.richText.a getRichText(Context context) {
        if (this.mRichText == null) {
            this.mRichText = TbRichTextView.a(context, this.msgContent);
        }
        return this.mRichText;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            bo.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            if (jSONObject.optInt("from") == 1) {
                this.status = 0;
            } else {
                this.status = 1;
            }
            this.msgContent = jSONObject.optJSONArray(PushConstants.EXTRA_CONTENT).toString();
            this.serverTime = jSONObject.getLong("time");
            try {
                this.msgId = jSONObject.optLong("msg_id");
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            bo.b(getClass().getName(), "parserJson", e2.toString());
        }
    }

    public void setClipString(Context context) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        ArrayList<com.baidu.tbadk.widget.richText.c> a = this.mRichText.a();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= a.size()) {
                break;
            }
            if (a.get(i2).a() == 1) {
                sb.append((CharSequence) a.get(i2).d());
            }
            i = i2 + 1;
        }
        clipboardManager.setText(sb);
        if (clipboardManager.getText() != null) {
            bo.e("ChatMessageActivity", "clip_text", clipboardManager.getText().toString());
        }
    }
}
