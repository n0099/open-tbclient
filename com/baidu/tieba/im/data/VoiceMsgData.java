package com.baidu.tieba.im.data;

import com.baidu.adp.lib.a.b.a.a.i;
import java.io.Serializable;
/* loaded from: classes.dex */
public class VoiceMsgData extends i implements Serializable {
    private static final long serialVersionUID = -129164961034822753L;
    private float during_time;
    private String voice_md5;
    private int type = 10;
    private int has_read = 0;

    public int getHas_read() {
        return this.has_read;
    }

    public void setHas_read(int i) {
        this.has_read = i;
    }

    public String getVoice_md5() {
        return this.voice_md5;
    }

    public void setVoice_md5(String str) {
        this.voice_md5 = str;
    }

    public float getDuring_time() {
        return this.during_time;
    }

    public void setDuring_time(int i) {
        this.during_time = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
