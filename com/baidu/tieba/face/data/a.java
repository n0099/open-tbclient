package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private List<EmotionImageData> cSH;
    private int cik;
    private int cmY;

    public int getPage() {
        return this.cmY;
    }

    public void setPage(int i) {
        this.cmY = i;
    }

    public int aoZ() {
        return this.cik;
    }

    public void setHasMore(int i) {
        this.cik = i;
    }

    public List<EmotionImageData> apa() {
        return this.cSH;
    }

    public void aY(List<EmotionImageData> list) {
        this.cSH = list;
    }
}
