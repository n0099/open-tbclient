package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int fQn;
    private int gzh;
    private List<EmotionImageData> hlY;

    public int getPage() {
        return this.fQn;
    }

    public void setPage(int i) {
        this.fQn = i;
    }

    public int bTP() {
        return this.gzh;
    }

    public void setHasMore(int i) {
        this.gzh = i;
    }

    public List<EmotionImageData> bTQ() {
        return this.hlY;
    }

    public void ci(List<EmotionImageData> list) {
        this.hlY = list;
    }
}
