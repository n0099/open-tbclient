package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int bXW;
    private List<EmotionImageData> cLz;
    private int ccq;

    public int getPage() {
        return this.ccq;
    }

    public void setPage(int i) {
        this.ccq = i;
    }

    public int alz() {
        return this.bXW;
    }

    public void setHasMore(int i) {
        this.bXW = i;
    }

    public List<EmotionImageData> alA() {
        return this.cLz;
    }

    public void aU(List<EmotionImageData> list) {
        this.cLz = list;
    }
}
