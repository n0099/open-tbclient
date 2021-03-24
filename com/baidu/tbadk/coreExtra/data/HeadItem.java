package com.baidu.tbadk.coreExtra.data;

import java.io.Serializable;
/* loaded from: classes3.dex */
public class HeadItem implements Serializable {
    public String content;
    public String name;
    public int type;

    public HeadItem(String str, String str2, int i) {
        this.name = str;
        this.content = str2;
        this.type = i;
    }

    public String getContent() {
        return this.content;
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setType(int i) {
        this.type = i;
    }
}
