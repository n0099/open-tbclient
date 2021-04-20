package com.baidu.tieba.flutter.plugin.tiebaUtility;

import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class TiebaUtilityMessageAuto {

    /* loaded from: classes4.dex */
    public interface HostUtilityMessage {
        void clearNewMessage(MessageStringParam messageStringParam);

        void delAllMsgInForumUser(MessageStringParam messageStringParam);

        void getIsOfficalForumLetterReminderOpen(MessageStringParam messageStringParam, Result<MessageBoolResult> result);

        void readNewMessage(Result<NewMessage> result);

        void readVipCenterNewMessage(Result<MessageBoolResult> result);

        void resetFansNumCount();

        void setOfficalForumLetterReminderOpen(SetForumBroadcastParam setForumBroadcastParam);
    }

    /* loaded from: classes4.dex */
    public static class MessageBoolResult {
        public Boolean result;

        public static MessageBoolResult fromMap(HashMap hashMap) {
            MessageBoolResult messageBoolResult = new MessageBoolResult();
            messageBoolResult.result = (Boolean) hashMap.get("result");
            return messageBoolResult;
        }

        public Boolean getResult() {
            return this.result;
        }

        public void setResult(Boolean bool) {
            this.result = bool;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("result", this.result);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public static class MessageStringParam {
        public String result;

        public static MessageStringParam fromMap(HashMap hashMap) {
            MessageStringParam messageStringParam = new MessageStringParam();
            messageStringParam.result = (String) hashMap.get("result");
            return messageStringParam;
        }

        public String getResult() {
            return this.result;
        }

        public void setResult(String str) {
            this.result = str;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("result", this.result);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public static class NewMessage {
        public HashMap result;

        public static NewMessage fromMap(HashMap hashMap) {
            NewMessage newMessage = new NewMessage();
            newMessage.result = (HashMap) hashMap.get("result");
            return newMessage;
        }

        public HashMap getResult() {
            return this.result;
        }

        public void setResult(HashMap hashMap) {
            this.result = hashMap;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("result", this.result);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public interface Result<T> {
        void success(T t);
    }

    /* loaded from: classes4.dex */
    public static class SetForumBroadcastParam {
        public String forumId;
        public Boolean open;

        public static SetForumBroadcastParam fromMap(HashMap hashMap) {
            SetForumBroadcastParam setForumBroadcastParam = new SetForumBroadcastParam();
            setForumBroadcastParam.forumId = (String) hashMap.get(TbTitleActivityConfig.FORUM_ID);
            setForumBroadcastParam.open = (Boolean) hashMap.get("open");
            return setForumBroadcastParam;
        }

        public String getForumId() {
            return this.forumId;
        }

        public Boolean getOpen() {
            return this.open;
        }

        public void setForumId(String str) {
            this.forumId = str;
        }

        public void setOpen(Boolean bool) {
            this.open = bool;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put(TbTitleActivityConfig.FORUM_ID, this.forumId);
            hashMap.put("open", this.open);
            return hashMap;
        }
    }

    public static HashMap wrapError(Exception exc) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", exc.toString());
        hashMap.put("code", exc.getClass().getSimpleName());
        hashMap.put("details", null);
        return hashMap;
    }
}
