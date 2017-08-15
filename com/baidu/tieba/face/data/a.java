package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int bwz;
    private int bzI;
    private List<EmotionImageData> cbw;

    public int getPage() {
        return this.bzI;
    }

    public void setPage(int i) {
        this.bzI = i;
    }

    public int acR() {
        return this.bwz;
    }

    public void setHasMore(int i) {
        this.bwz = i;
    }

    public List<EmotionImageData> acS() {
        return this.cbw;
    }

    public void aw(List<EmotionImageData> list) {
        this.cbw = list;
    }
}
