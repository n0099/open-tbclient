package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int cEk;
    private int cJk;
    private List<EmotionImageData> dtO;

    public int getPage() {
        return this.cJk;
    }

    public void setPage(int i) {
        this.cJk = i;
    }

    public int awJ() {
        return this.cEk;
    }

    public void setHasMore(int i) {
        this.cEk = i;
    }

    public List<EmotionImageData> awK() {
        return this.dtO;
    }

    public void bp(List<EmotionImageData> list) {
        this.dtO = list;
    }
}
