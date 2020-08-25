package com.baidu.tieba.ala.liveroom.data;

import com.baidu.live.data.AlaLivePerfBaseData;
/* loaded from: classes7.dex */
public class AlaLivePlayerPerfData extends AlaLivePerfBaseData {
    public static final int WATCH_STYLE_NORMAL = 1;
    public static final int WATCH_STYLE_PAGE_CHANGE = 3;
    public static final int WATCH_STYLE_SWITCH_STREAM = 4;
    public static final int WATCH_STYLE_USER_NAME = 2;
    public int bufferType;
    public int bufferingCount;
    public int delay;
    public int delayMax;
    public long enterLiveStamp;
    public long enterTime;
    public int errCode;
    public int firstFrameTime;
    public boolean isSuccess;
    public int linkCount;
    public long linkTime;
    public long linkTimeStamp;
    public String networkType;
    public String nodeIP;
    public long playSpeedCount;
    public int sourcePlatform;
    public long startTimeStamp;
    public int totalBufferingDuration;
    public long totalTime;
    public long watchTime;
    public int watchStyle = 1;
    private int delayCount = 0;

    public void addFrameDelay(int i, int i2) {
        this.sourcePlatform = i2;
        this.delayMax = this.delayMax > i ? this.delayMax : i;
        this.delay = ((this.delay * this.delayCount) + i) / (this.delayCount + 1);
        this.delayCount++;
    }

    public void addBufferingDuration(int i) {
        this.bufferingCount++;
        this.totalBufferingDuration += i;
    }

    @Override // com.baidu.live.data.AlaLivePerfBaseData
    public void reset() {
        super.reset();
        this.startTimeStamp = 0L;
        this.enterLiveStamp = 0L;
        this.linkTimeStamp = 0L;
        this.totalTime = 0L;
        this.enterTime = 0L;
        this.watchTime = 0L;
        this.linkTime = 0L;
        this.linkCount = 0;
        this.isSuccess = true;
        this.errCode = 0;
        this.firstFrameTime = 0;
        this.watchStyle = 0;
        this.delay = 0;
        this.delayMax = 0;
        this.sourcePlatform = 0;
        this.nodeIP = "";
        this.networkType = "";
        this.bufferType = 0;
        this.bufferingCount = 0;
        this.totalBufferingDuration = 0;
        this.playSpeedCount = 0L;
        this.delayCount = 0;
    }
}
