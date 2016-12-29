package com.baidu.tieba.im.data;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.tbadk.core.data.VoiceData;
import java.io.Serializable;
/* loaded from: classes.dex */
public class MsgCacheData extends i implements Serializable {
    private static final long serialVersionUID = -100392737471140589L;
    private transient VoiceData.VoiceModel cKT;
    private transient com.baidu.tbadk.widget.richText.a cKU;
    private int is_left;
    private int is_show_time;
    private long lastMsgTime;
    private int voice_status;

    public int getIs_left() {
        return this.is_left;
    }

    public VoiceData.VoiceModel getVoice_model() {
        return this.cKT;
    }

    public void setVoice_model(VoiceData.VoiceModel voiceModel) {
        this.cKT = voiceModel;
    }

    public void setIs_left(int i) {
        this.is_left = i;
    }

    public int getVoice_status() {
        return this.voice_status;
    }

    public void setVoice_status(int i) {
        this.voice_status = i;
    }

    public int getIs_show_time() {
        return this.is_show_time;
    }

    public void setIs_show_time(int i) {
        this.is_show_time = i;
    }

    public com.baidu.tbadk.widget.richText.a getRich_content() {
        return this.cKU;
    }

    public void setRich_content(com.baidu.tbadk.widget.richText.a aVar) {
        this.cKU = aVar;
    }

    public long getLastMsgTime() {
        return this.lastMsgTime;
    }

    public void setLastMsgTime(long j) {
        this.lastMsgTime = j;
    }
}
