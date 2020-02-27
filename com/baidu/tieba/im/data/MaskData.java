package com.baidu.tieba.im.data;

import java.io.Serializable;
/* loaded from: classes13.dex */
public class MaskData implements Serializable {
    private static final int FALSE = 0;
    private static final long serialVersionUID = -7490208614712442860L;
    private int isMask;
    private String list;

    public int getIsMask() {
        return this.isMask;
    }

    public void setIsMask(int i) {
        this.isMask = i;
    }

    public String getList() {
        return this.list;
    }

    public void setList(String str) {
        this.list = str;
    }

    public boolean isMask() {
        return this.isMask != 0;
    }
}
