package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int cEV;
    private int cJV;
    private List<EmotionImageData> dux;

    public int getPage() {
        return this.cJV;
    }

    public void setPage(int i) {
        this.cJV = i;
    }

    public int axg() {
        return this.cEV;
    }

    public void setHasMore(int i) {
        this.cEV = i;
    }

    public List<EmotionImageData> axh() {
        return this.dux;
    }

    public void bq(List<EmotionImageData> list) {
        this.dux = list;
    }
}
