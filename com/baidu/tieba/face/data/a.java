package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int egP;
    private int emf;
    private List<EmotionImageData> fdj;

    public int getPage() {
        return this.emf;
    }

    public void setPage(int i) {
        this.emf = i;
    }

    public int bhn() {
        return this.egP;
    }

    public void setHasMore(int i) {
        this.egP = i;
    }

    public List<EmotionImageData> bho() {
        return this.fdj;
    }

    public void bL(List<EmotionImageData> list) {
        this.fdj = list;
    }
}
