package com.baidu.tieba.flutter.plugin.tiebaShare;

import androidx.transition.Transition;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class TiebaShareAuto {

    /* loaded from: classes4.dex */
    public static class GameDetailsParam {
        public String content;
        public String iconUrl;
        public String itemId;
        public String itemName;
        public String url;

        public static GameDetailsParam fromMap(HashMap hashMap) {
            GameDetailsParam gameDetailsParam = new GameDetailsParam();
            gameDetailsParam.url = (String) hashMap.get("url");
            gameDetailsParam.itemId = (String) hashMap.get(Transition.MATCH_ITEM_ID_STR);
            gameDetailsParam.itemName = (String) hashMap.get("itemName");
            gameDetailsParam.content = (String) hashMap.get("content");
            gameDetailsParam.iconUrl = (String) hashMap.get("iconUrl");
            return gameDetailsParam;
        }

        public String getContent() {
            return this.content;
        }

        public String getIconUrl() {
            return this.iconUrl;
        }

        public String getItemId() {
            return this.itemId;
        }

        public String getItemName() {
            return this.itemName;
        }

        public String getUrl() {
            return this.url;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setIconUrl(String str) {
            this.iconUrl = str;
        }

        public void setItemId(String str) {
            this.itemId = str;
        }

        public void setItemName(String str) {
            this.itemName = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("url", this.url);
            hashMap.put(Transition.MATCH_ITEM_ID_STR, this.itemId);
            hashMap.put("itemName", this.itemName);
            hashMap.put("content", this.content);
            hashMap.put("iconUrl", this.iconUrl);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public interface HostTiebaShare {
        void shareGameItemDetails(GameDetailsParam gameDetailsParam);

        void shareThread(ShareThreadParam shareThreadParam);
    }

    /* loaded from: classes4.dex */
    public static class ShareThreadParam {
        public HashMap threadInfo;

        public static ShareThreadParam fromMap(HashMap hashMap) {
            ShareThreadParam shareThreadParam = new ShareThreadParam();
            shareThreadParam.threadInfo = (HashMap) hashMap.get("threadInfo");
            return shareThreadParam;
        }

        public HashMap getThreadInfo() {
            return this.threadInfo;
        }

        public void setThreadInfo(HashMap hashMap) {
            this.threadInfo = hashMap;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("threadInfo", this.threadInfo);
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
