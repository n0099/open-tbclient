package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int ceQ;
    private int hYW;
    private List<EmotionImageData> iUs;

    public int getPage() {
        return this.ceQ;
    }

    public void setPage(int i) {
        this.ceQ = i;
    }

    public int cys() {
        return this.hYW;
    }

    public void setHasMore(int i) {
        this.hYW = i;
    }

    public List<EmotionImageData> cyt() {
        return this.iUs;
    }

    public void cV(List<EmotionImageData> list) {
        this.iUs = list;
    }
}
