package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int gQL;
    private int hBL;
    private List<EmotionImageData> itB;

    public int getPage() {
        return this.gQL;
    }

    public void setPage(int i) {
        this.gQL = i;
    }

    public int ctZ() {
        return this.hBL;
    }

    public void setHasMore(int i) {
        this.hBL = i;
    }

    public List<EmotionImageData> cua() {
        return this.itB;
    }

    public void cP(List<EmotionImageData> list) {
        this.itB = list;
    }
}
