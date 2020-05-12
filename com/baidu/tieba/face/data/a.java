package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int fXo;
    private int fqZ;
    private List<EmotionImageData> gKP;

    public int getPage() {
        return this.fqZ;
    }

    public void setPage(int i) {
        this.fqZ = i;
    }

    public int bKw() {
        return this.fXo;
    }

    public void setHasMore(int i) {
        this.fXo = i;
    }

    public List<EmotionImageData> bKx() {
        return this.gKP;
    }

    public void cc(List<EmotionImageData> list) {
        this.gKP = list;
    }
}
