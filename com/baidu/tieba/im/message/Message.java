package com.baidu.tieba.im.message;

import com.baidu.tieba.im.b.l;
import java.io.Serializable;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class Message implements Serializable {
    private int cmd;

    public int getCmd() {
        return this.cmd;
    }

    public void setCmd(int i) {
        this.cmd = i;
    }

    public Map toMap() {
        try {
            return toDefaultMap();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map toDefaultMap() {
        return l.a().a(this);
    }

    public String toString() {
        Map map = toMap();
        return map == null ? getClass().getName() : getClass().getName() + "-->" + map.toString();
    }
}
