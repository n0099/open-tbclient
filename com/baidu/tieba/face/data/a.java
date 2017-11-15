package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int bGf;
    private int bKo;
    private List<EmotionImageData> cmB;

    public int getPage() {
        return this.bKo;
    }

    public void setPage(int i) {
        this.bKo = i;
    }

    public int afT() {
        return this.bGf;
    }

    public void setHasMore(int i) {
        this.bGf = i;
    }

    public List<EmotionImageData> afU() {
        return this.cmB;
    }

    public void az(List<EmotionImageData> list) {
        this.cmB = list;
    }
}
