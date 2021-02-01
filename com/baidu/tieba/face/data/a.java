package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int cdp;
    private int hWZ;
    private List<EmotionImageData> iSv;

    public int getPage() {
        return this.cdp;
    }

    public void setPage(int i) {
        this.cdp = i;
    }

    public int cyf() {
        return this.hWZ;
    }

    public void setHasMore(int i) {
        this.hWZ = i;
    }

    public List<EmotionImageData> cyg() {
        return this.iSv;
    }

    public void cV(List<EmotionImageData> list) {
        this.iSv = list;
    }
}
