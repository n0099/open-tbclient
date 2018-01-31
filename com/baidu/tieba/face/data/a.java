package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int cDr;
    private int cHy;
    private List<EmotionImageData> doU;

    public int getPage() {
        return this.cHy;
    }

    public void setPage(int i) {
        this.cHy = i;
    }

    public int aqt() {
        return this.cDr;
    }

    public void setHasMore(int i) {
        this.cDr = i;
    }

    public List<EmotionImageData> aqu() {
        return this.doU;
    }

    public void aU(List<EmotionImageData> list) {
        this.doU = list;
    }
}
