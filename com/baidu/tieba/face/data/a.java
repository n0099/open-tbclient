package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int bXj;
    private List<EmotionImageData> cKv;
    private int cbx;

    public int getPage() {
        return this.cbx;
    }

    public void setPage(int i) {
        this.cbx = i;
    }

    public int alz() {
        return this.bXj;
    }

    public void setHasMore(int i) {
        this.bXj = i;
    }

    public List<EmotionImageData> alA() {
        return this.cKv;
    }

    public void aR(List<EmotionImageData> list) {
        this.cKv = list;
    }
}
