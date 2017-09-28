package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int bDd;
    private int bzQ;
    private List<EmotionImageData> cfa;

    public int getPage() {
        return this.bDd;
    }

    public void setPage(int i) {
        this.bDd = i;
    }

    public int adC() {
        return this.bzQ;
    }

    public void setHasMore(int i) {
        this.bzQ = i;
    }

    public List<EmotionImageData> adD() {
        return this.cfa;
    }

    public void ax(List<EmotionImageData> list) {
        this.cfa = list;
    }
}
