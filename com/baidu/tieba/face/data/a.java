package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int cCU;
    private int cHb;
    private List<EmotionImageData> djY;

    public int getPage() {
        return this.cHb;
    }

    public void setPage(int i) {
        this.cHb = i;
    }

    public int apl() {
        return this.cCU;
    }

    public void setHasMore(int i) {
        this.cCU = i;
    }

    public List<EmotionImageData> apm() {
        return this.djY;
    }

    public void aW(List<EmotionImageData> list) {
        this.djY = list;
    }
}
