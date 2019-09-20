package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int eiz;
    private int enR;
    private List<EmotionImageData> feW;

    public int getPage() {
        return this.enR;
    }

    public void setPage(int i) {
        this.enR = i;
    }

    public int bhY() {
        return this.eiz;
    }

    public void setHasMore(int i) {
        this.eiz = i;
    }

    public List<EmotionImageData> bhZ() {
        return this.feW;
    }

    public void bL(List<EmotionImageData> list) {
        this.feW = list;
    }
}
