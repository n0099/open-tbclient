package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int dRM;
    private int dWU;
    private List<EmotionImageData> eHy;

    public int getPage() {
        return this.dWU;
    }

    public void setPage(int i) {
        this.dWU = i;
    }

    public int aXG() {
        return this.dRM;
    }

    public void setHasMore(int i) {
        this.dRM = i;
    }

    public List<EmotionImageData> aXH() {
        return this.eHy;
    }

    public void bB(List<EmotionImageData> list) {
        this.eHy = list;
    }
}
