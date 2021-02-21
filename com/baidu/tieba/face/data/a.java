package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int cdp;
    private int hXn;
    private List<EmotionImageData> iSJ;

    public int getPage() {
        return this.cdp;
    }

    public void setPage(int i) {
        this.cdp = i;
    }

    public int cym() {
        return this.hXn;
    }

    public void setHasMore(int i) {
        this.hXn = i;
    }

    public List<EmotionImageData> cyn() {
        return this.iSJ;
    }

    public void cV(List<EmotionImageData> list) {
        this.iSJ = list;
    }
}
