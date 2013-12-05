package com.baidu.tieba.im.data;

import com.baidu.tieba.voice.VoiceManager;
import java.io.Serializable;
/* loaded from: classes.dex */
public class MsgCacheData implements Serializable {
    private static final long serialVersionUID = -100392737471140589L;

    /* renamed from: a  reason: collision with root package name */
    private transient VoiceManager.VoiceModel f1645a;
    private transient com.baidu.tbadk.widget.richText.a b;
    private int is_left;
    private int is_show_time;
    private int voice_status;

    public int getIs_left() {
        return this.is_left;
    }

    public VoiceManager.VoiceModel getVoice_model() {
        return this.f1645a;
    }

    public void setVoice_model(VoiceManager.VoiceModel voiceModel) {
        this.f1645a = voiceModel;
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
        return this.b;
    }

    public void setRich_content(com.baidu.tbadk.widget.richText.a aVar) {
        this.b = aVar;
    }
}
