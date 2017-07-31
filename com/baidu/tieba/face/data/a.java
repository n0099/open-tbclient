package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int bvQ;
    private int byZ;
    private List<EmotionImageData> caK;

    public int getPage() {
        return this.byZ;
    }

    public void setPage(int i) {
        this.byZ = i;
    }

    public int acw() {
        return this.bvQ;
    }

    public void setHasMore(int i) {
        this.bvQ = i;
    }

    public List<EmotionImageData> acx() {
        return this.caK;
    }

    public void aw(List<EmotionImageData> list) {
        this.caK = list;
    }
}
