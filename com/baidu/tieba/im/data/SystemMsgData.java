package com.baidu.tieba.im.data;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SystemMsgData implements Serializable {
    private static final long serialVersionUID = -4218611013851599074L;
    private String content;
    private boolean isSelf;

    public boolean getIsSelf() {
        return this.isSelf;
    }

    public void setIsSelf(boolean z) {
        this.isSelf = z;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }
}
