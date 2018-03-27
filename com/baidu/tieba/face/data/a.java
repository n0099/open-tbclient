package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int cHb;
    private int cLn;
    private List<EmotionImageData> drE;

    public int getPage() {
        return this.cLn;
    }

    public void setPage(int i) {
        this.cLn = i;
    }

    public int arj() {
        return this.cHb;
    }

    public void setHasMore(int i) {
        this.cHb = i;
    }

    public List<EmotionImageData> ark() {
        return this.drE;
    }

    public void aW(List<EmotionImageData> list) {
        this.drE = list;
    }
}
