package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int cEW;
    private int cJW;
    private List<EmotionImageData> duy;

    public int getPage() {
        return this.cJW;
    }

    public void setPage(int i) {
        this.cJW = i;
    }

    public int axg() {
        return this.cEW;
    }

    public void setHasMore(int i) {
        this.cEW = i;
    }

    public List<EmotionImageData> axh() {
        return this.duy;
    }

    public void bq(List<EmotionImageData> list) {
        this.duy = list;
    }
}
