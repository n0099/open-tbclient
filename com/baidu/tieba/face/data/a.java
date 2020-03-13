package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int eMg;
    private int fsp;
    private List<EmotionImageData> gaS;

    public int getPage() {
        return this.eMg;
    }

    public void setPage(int i) {
        this.eMg = i;
    }

    public int bzQ() {
        return this.fsp;
    }

    public void setHasMore(int i) {
        this.fsp = i;
    }

    public List<EmotionImageData> bzR() {
        return this.gaS;
    }

    public void bQ(List<EmotionImageData> list) {
        this.gaS = list;
    }
}
