package com.baidu.tieba.im.data;

import java.io.Serializable;
/* loaded from: classes4.dex */
public class SystemMsgData implements Serializable {
    public static final long serialVersionUID = -4218611013851599074L;
    public String content;
    public boolean isSelf;

    public String getContent() {
        return this.content;
    }

    public boolean getIsSelf() {
        return this.isSelf;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setIsSelf(boolean z) {
        this.isSelf = z;
    }
}
