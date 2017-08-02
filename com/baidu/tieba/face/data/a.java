package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private List<EmotionImageData> bZE;
    private int buG;
    private int bxP;

    public int getPage() {
        return this.bxP;
    }

    public void setPage(int i) {
        this.bxP = i;
    }

    public int acr() {
        return this.buG;
    }

    public void setHasMore(int i) {
        this.buG = i;
    }

    public List<EmotionImageData> acs() {
        return this.bZE;
    }

    public void aw(List<EmotionImageData> list) {
        this.bZE = list;
    }
}
