package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private List<EmotionImageData> eXH;
    private int ecl;
    private int eht;

    public int getPage() {
        return this.eht;
    }

    public void setPage(int i) {
        this.eht = i;
    }

    public int bfa() {
        return this.ecl;
    }

    public void setHasMore(int i) {
        this.ecl = i;
    }

    public List<EmotionImageData> bfb() {
        return this.eXH;
    }

    public void bJ(List<EmotionImageData> list) {
        this.eXH = list;
    }
}
