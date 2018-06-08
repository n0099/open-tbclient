package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private List<EmotionImageData> cUF;
    private int cfZ;
    private int cku;

    public int getPage() {
        return this.cku;
    }

    public void setPage(int i) {
        this.cku = i;
    }

    public int apF() {
        return this.cfZ;
    }

    public void setHasMore(int i) {
        this.cfZ = i;
    }

    public List<EmotionImageData> apG() {
        return this.cUF;
    }

    public void aX(List<EmotionImageData> list) {
        this.cUF = list;
    }
}
