package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int gUU;
    private int gkS;
    private List<EmotionImageData> hMh;

    public int getPage() {
        return this.gkS;
    }

    public void setPage(int i) {
        this.gkS = i;
    }

    public int ckT() {
        return this.gUU;
    }

    public void setHasMore(int i) {
        this.gUU = i;
    }

    public List<EmotionImageData> ckU() {
        return this.hMh;
    }

    public void cv(List<EmotionImageData> list) {
        this.hMh = list;
    }
}
