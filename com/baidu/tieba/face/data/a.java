package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int fVG;
    private int gEI;
    private List<EmotionImageData> hrK;

    public int getPage() {
        return this.fVG;
    }

    public void setPage(int i) {
        this.fVG = i;
    }

    public int bXj() {
        return this.gEI;
    }

    public void setHasMore(int i) {
        this.gEI = i;
    }

    public List<EmotionImageData> bXk() {
        return this.hrK;
    }

    public void cn(List<EmotionImageData> list) {
        this.hrK = list;
    }
}
