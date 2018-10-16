package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int cDd;
    private int cyj;
    private List<EmotionImageData> djt;

    public int getPage() {
        return this.cDd;
    }

    public void setPage(int i) {
        this.cDd = i;
    }

    public int auK() {
        return this.cyj;
    }

    public void setHasMore(int i) {
        this.cyj = i;
    }

    public List<EmotionImageData> auL() {
        return this.djt;
    }

    public void bo(List<EmotionImageData> list) {
        this.djt = list;
    }
}
