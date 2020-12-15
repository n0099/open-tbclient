package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int gZH;
    private int hKZ;
    private List<EmotionImageData> iFj;

    public int getPage() {
        return this.gZH;
    }

    public void setPage(int i) {
        this.gZH = i;
    }

    public int cxS() {
        return this.hKZ;
    }

    public void setHasMore(int i) {
        this.hKZ = i;
    }

    public List<EmotionImageData> cxT() {
        return this.iFj;
    }

    public void cT(List<EmotionImageData> list) {
        this.iFj = list;
    }
}
