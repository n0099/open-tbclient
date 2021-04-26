package com.baidu.tieba.im.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.widget.richText.TbRichText;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class MsgCacheData extends OrmObject implements Serializable {
    public static final long serialVersionUID = -100392737471140589L;
    public int is_left;
    public int is_show_time;
    public long lastMsgTime;
    public transient TbRichText rich_content;
    public transient VoiceData$VoiceModel voice_model;
    public int voice_status;

    public int getIs_left() {
        return this.is_left;
    }

    public int getIs_show_time() {
        return this.is_show_time;
    }

    public long getLastMsgTime() {
        return this.lastMsgTime;
    }

    public TbRichText getRich_content() {
        return this.rich_content;
    }

    public VoiceData$VoiceModel getVoice_model() {
        return this.voice_model;
    }

    public int getVoice_status() {
        return this.voice_status;
    }

    public void setIs_left(int i2) {
        this.is_left = i2;
    }

    public void setIs_show_time(int i2) {
        this.is_show_time = i2;
    }

    public void setLastMsgTime(long j) {
        this.lastMsgTime = j;
    }

    public void setRich_content(TbRichText tbRichText) {
        this.rich_content = tbRichText;
    }

    public void setVoice_model(VoiceData$VoiceModel voiceData$VoiceModel) {
        this.voice_model = voiceData$VoiceModel;
    }

    public void setVoice_status(int i2) {
        this.voice_status = i2;
    }
}
