package com.baidu.tieba.im.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class VoiceMsgData extends OrmObject implements Serializable {
    public static final long serialVersionUID = -129164961034822753L;
    public float during_time;
    public String voice_md5;
    public int type = 10;
    public int has_read = 0;

    public float getDuring_time() {
        return this.during_time;
    }

    public int getHas_read() {
        return this.has_read;
    }

    public int getType() {
        return this.type;
    }

    public String getVoice_md5() {
        return this.voice_md5;
    }

    public void setDuring_time(int i) {
        this.during_time = i;
    }

    public void setHas_read(int i) {
        this.has_read = i;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setVoice_md5(String str) {
        this.voice_md5 = str;
    }
}
