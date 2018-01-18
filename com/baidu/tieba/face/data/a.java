package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int cDe;
    private int cHl;
    private List<EmotionImageData> doz;

    public int getPage() {
        return this.cHl;
    }

    public void setPage(int i) {
        this.cHl = i;
    }

    public int aqo() {
        return this.cDe;
    }

    public void setHasMore(int i) {
        this.cDe = i;
    }

    public List<EmotionImageData> aqp() {
        return this.doz;
    }

    public void aU(List<EmotionImageData> list) {
        this.doz = list;
    }
}
