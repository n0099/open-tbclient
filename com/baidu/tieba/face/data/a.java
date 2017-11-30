package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int bOf;
    private int bSm;
    private List<EmotionImageData> cvp;

    public int getPage() {
        return this.bSm;
    }

    public void setPage(int i) {
        this.bSm = i;
    }

    public int ahE() {
        return this.bOf;
    }

    public void setHasMore(int i) {
        this.bOf = i;
    }

    public List<EmotionImageData> ahF() {
        return this.cvp;
    }

    public void aL(List<EmotionImageData> list) {
        this.cvp = list;
    }
}
