package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int fFe;
    private List<EmotionImageData> gZM;
    private int gmt;

    public int getPage() {
        return this.fFe;
    }

    public void setPage(int i) {
        this.fFe = i;
    }

    public int bQT() {
        return this.gmt;
    }

    public void setHasMore(int i) {
        this.gmt = i;
    }

    public List<EmotionImageData> bQU() {
        return this.gZM;
    }

    public void bZ(List<EmotionImageData> list) {
        this.gZM = list;
    }
}
