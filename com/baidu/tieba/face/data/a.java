package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int cEl;
    private int czs;
    private List<EmotionImageData> dky;

    public int getPage() {
        return this.cEl;
    }

    public void setPage(int i) {
        this.cEl = i;
    }

    public int auj() {
        return this.czs;
    }

    public void setHasMore(int i) {
        this.czs = i;
    }

    public List<EmotionImageData> auk() {
        return this.dky;
    }

    public void bm(List<EmotionImageData> list) {
        this.dky = list;
    }
}
