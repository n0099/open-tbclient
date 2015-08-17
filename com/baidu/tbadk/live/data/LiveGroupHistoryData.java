package com.baidu.tbadk.live.data;

import com.baidu.tbadk.core.data.LiveCardData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class LiveGroupHistoryData {
    private static final int TRUE = 1;
    private int hasMore;
    private List<History> historys = new ArrayList();
    private LiveCardData liveCardData;

    public LiveCardData getLiveCardData() {
        return this.liveCardData;
    }

    public void setLiveCardData(LiveCardData liveCardData) {
        this.liveCardData = liveCardData;
    }

    public List<History> getHistorys() {
        return this.historys;
    }

    public void setHistorys(List<History> list) {
        this.historys = list;
    }

    public int getHasMore() {
        return this.hasMore;
    }

    public void setHasMore(int i) {
        this.hasMore = i;
    }

    public boolean isHasMore() {
        return this.hasMore == 1;
    }

    /* loaded from: classes.dex */
    public static final class History {
        private long endTime;
        private int groupId;
        private int likers;
        private int listeners;
        private String playUrl;
        private long startTime;
        private long userId;

        public int getGroupId() {
            return this.groupId;
        }

        public void setGroupId(int i) {
            this.groupId = i;
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

        public long getUserId() {
            return this.userId;
        }

        public void setUserId(long j) {
            this.userId = j;
        }

        public int getListeners() {
            return this.listeners;
        }

        public void setListeners(int i) {
            this.listeners = i;
        }

        public int getLikers() {
            return this.likers;
        }

        public void setLikers(int i) {
            this.likers = i;
        }

        public String getPlayUrl() {
            return this.playUrl;
        }

        public void setPlayUrl(String str) {
            this.playUrl = str;
        }
    }
}
