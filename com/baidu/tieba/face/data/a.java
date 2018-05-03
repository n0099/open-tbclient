package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int bXg;
    private List<EmotionImageData> cKs;
    private int cbu;

    public int getPage() {
        return this.cbu;
    }

    public void setPage(int i) {
        this.cbu = i;
    }

    public int alz() {
        return this.bXg;
    }

    public void setHasMore(int i) {
        this.bXg = i;
    }

    public List<EmotionImageData> alA() {
        return this.cKs;
    }

    public void aR(List<EmotionImageData> list) {
        this.cKs = list;
    }
}
