package com.baidu.tieba.im.live;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class PlayProgressChangedMessage extends CustomResponsedMessage<Object> {
    private int currentPosition;
    private int duration;
    private String url;

    public PlayProgressChangedMessage(String str) {
        super(MessageTypes.CMD_PLAY_PROGRESS_CHANGED);
        this.url = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    public void setCurrentPosition(int i) {
        this.currentPosition = i;
    }
}
