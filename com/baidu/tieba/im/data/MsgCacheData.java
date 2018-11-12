package com.baidu.tieba.im.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.widget.richText.TbRichText;
import java.io.Serializable;
/* loaded from: classes.dex */
public class MsgCacheData extends OrmObject implements Serializable {
    private static final long serialVersionUID = -100392737471140589L;
    private transient VoiceData.VoiceModel eGv;
    private transient TbRichText eGw;
    private int is_left;
    private int is_show_time;
    private long lastMsgTime;
    private int voice_status;

    public int getIs_left() {
        return this.is_left;
    }

    public VoiceData.VoiceModel getVoice_model() {
        return this.eGv;
    }

    public void setVoice_model(VoiceData.VoiceModel voiceModel) {
        this.eGv = voiceModel;
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

    public TbRichText getRich_content() {
        return this.eGw;
    }

    public void setRich_content(TbRichText tbRichText) {
        this.eGw = tbRichText;
    }

    public long getLastMsgTime() {
        return this.lastMsgTime;
    }

    public void setLastMsgTime(long j) {
        this.lastMsgTime = j;
    }
}
