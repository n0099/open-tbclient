package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int cGY;
    private int cLk;
    private List<EmotionImageData> drB;

    public int getPage() {
        return this.cLk;
    }

    public void setPage(int i) {
        this.cLk = i;
    }

    public int ari() {
        return this.cGY;
    }

    public void setHasMore(int i) {
        this.cGY = i;
    }

    public List<EmotionImageData> arj() {
        return this.drB;
    }

    public void aW(List<EmotionImageData> list) {
        this.drB = list;
    }
}
