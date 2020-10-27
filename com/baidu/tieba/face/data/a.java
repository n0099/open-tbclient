package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int gKZ;
    private int hvO;
    private List<EmotionImageData> inE;

    public int getPage() {
        return this.gKZ;
    }

    public void setPage(int i) {
        this.gKZ = i;
    }

    public int cry() {
        return this.hvO;
    }

    public void setHasMore(int i) {
        this.hvO = i;
    }

    public List<EmotionImageData> crz() {
        return this.inE;
    }

    public void cH(List<EmotionImageData> list) {
        this.inE = list;
    }
}
