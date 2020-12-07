package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int gZF;
    private int hKX;
    private List<EmotionImageData> iFh;

    public int getPage() {
        return this.gZF;
    }

    public void setPage(int i) {
        this.gZF = i;
    }

    public int cxR() {
        return this.hKX;
    }

    public void setHasMore(int i) {
        this.hKX = i;
    }

    public List<EmotionImageData> cxS() {
        return this.iFh;
    }

    public void cT(List<EmotionImageData> list) {
        this.iFh = list;
    }
}
