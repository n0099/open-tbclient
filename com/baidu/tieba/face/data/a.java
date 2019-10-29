package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int dRY;
    private int evJ;
    private List<EmotionImageData> fhG;

    public int getPage() {
        return this.dRY;
    }

    public void setPage(int i) {
        this.dRY = i;
    }

    public int bfQ() {
        return this.evJ;
    }

    public void setHasMore(int i) {
        this.evJ = i;
    }

    public List<EmotionImageData> bfR() {
        return this.fhG;
    }

    public void bY(List<EmotionImageData> list) {
        this.fhG = list;
    }
}
