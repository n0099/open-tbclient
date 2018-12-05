package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int cDk;
    private int cIk;
    private List<EmotionImageData> dra;

    public int getPage() {
        return this.cIk;
    }

    public void setPage(int i) {
        this.cIk = i;
    }

    public int avU() {
        return this.cDk;
    }

    public void setHasMore(int i) {
        this.cDk = i;
    }

    public List<EmotionImageData> avV() {
        return this.dra;
    }

    public void bo(List<EmotionImageData> list) {
        this.dra = list;
    }
}
