package com.baidu.tieba.im.data;

import java.io.Serializable;
/* loaded from: classes3.dex */
public class MaskData implements Serializable {
    public static final int FALSE = 0;
    public static final long serialVersionUID = -7490208614712442860L;
    public int isMask;
    public String list;

    public int getIsMask() {
        return this.isMask;
    }

    public String getList() {
        return this.list;
    }

    public boolean isMask() {
        return this.isMask != 0;
    }

    public void setIsMask(int i) {
        this.isMask = i;
    }

    public void setList(String str) {
        this.list = str;
    }
}
