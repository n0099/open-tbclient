package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private List<EmotionImageData> eXI;
    private int ecm;
    private int ehu;

    public int getPage() {
        return this.ehu;
    }

    public void setPage(int i) {
        this.ehu = i;
    }

    public int bfd() {
        return this.ecm;
    }

    public void setHasMore(int i) {
        this.ecm = i;
    }

    public List<EmotionImageData> bfe() {
        return this.eXI;
    }

    public void bJ(List<EmotionImageData> list) {
        this.eXI = list;
    }
}
