package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int bwA;
    private int bzJ;
    private List<EmotionImageData> cbx;

    public int getPage() {
        return this.bzJ;
    }

    public void setPage(int i) {
        this.bzJ = i;
    }

    public int acN() {
        return this.bwA;
    }

    public void setHasMore(int i) {
        this.bwA = i;
    }

    public List<EmotionImageData> acO() {
        return this.cbx;
    }

    public void aw(List<EmotionImageData> list) {
        this.cbx = list;
    }
}
