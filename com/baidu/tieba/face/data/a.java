package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int fET;
    private List<EmotionImageData> gZB;
    private int gmi;

    public int getPage() {
        return this.fET;
    }

    public void setPage(int i) {
        this.fET = i;
    }

    public int bQR() {
        return this.gmi;
    }

    public void setHasMore(int i) {
        this.gmi = i;
    }

    public List<EmotionImageData> bQS() {
        return this.gZB;
    }

    public void bZ(List<EmotionImageData> list) {
        this.gZB = list;
    }
}
