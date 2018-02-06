package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int cHk;
    private int cLw;
    private List<EmotionImageData> drN;

    public int getPage() {
        return this.cLw;
    }

    public void setPage(int i) {
        this.cLw = i;
    }

    public int arj() {
        return this.cHk;
    }

    public void setHasMore(int i) {
        this.cHk = i;
    }

    public List<EmotionImageData> ark() {
        return this.drN;
    }

    public void aW(List<EmotionImageData> list) {
        this.drN = list;
    }
}
